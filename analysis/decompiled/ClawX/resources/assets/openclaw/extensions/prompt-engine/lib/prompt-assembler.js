"use strict";
/**
 * prompt-assembler.js
 *
 * 将模板段落、Bootstrap 文件、Skills 摘要和运行时变量组装为两条通道：
 *
 *   assembleSystemPrompt   → 仅包含字节级稳定的段落（写入 system message，可被 prompt cache）
 *   assemblePrependContext  → 包含每轮/常变的动态段落（写入 prependContext → user 前缀）
 *
 * 路由依据：config.json 中的 injectCurrentTime / injectProjectContext / injectRuntimeLine（三态
 * "system" | "user" | "off"；兼容旧布尔 true→system, false→off）以及 sections.*.channel
 * （"system" | "user" | "off"；兼容 enabled: true→system, enabled: false→off）。
 *
 * 段落顺序（与 OpenClaw buildAgentSystemPrompt 对齐，去除 Android 无用项）：
 *   1. 身份声明 (identity)
 *   2. ## Tooling + 工具摘要列表
 *   3. ## 工具调用风格 (tool-call-style)
 *   4. ## 安全准则 (safety)
 *   5. ## 技能 (skills-header + skillsSummary)
 *   6. ## 记忆回忆 (memory-recall)          [minimal 模式跳过]
 *   7. ## Android 运行环境 (android-context)
 *   8. ## 定时任务指导 (cron-guidance)
 *   9. ## 工作区 (workspace-info)
 *  10. ## 当前时间                          [injectCurrentTime]
 *  11. # Project Context — Bootstrap 文件    [injectProjectContext]
 *  12. ## 静默回复 (silent-replies)          [minimal 模式跳过]
 *  13. ## 心跳 (heartbeat)                   [minimal 模式跳过]
 *  14. ## Runtime 行                       [injectRuntimeLine]
 */

const os = require("os");
const { BUILT_IN_DEFAULTS } = require("./template-loader");
const { resolveTierConfig, getTierSectionMode } = require("./tier-section-matrix");

// StepClaw 环境下的固定工具摘要（对应 OpenClaw coreToolSummaries）
const TOOL_SUMMARIES = {
  read:          "读取文件内容",
  write:         "创建或覆盖文件",
  edit:          "精确编辑文件（局部修改）",
  apply_patch:   "应用多文件 patch",
  grep:          "按正则搜索文件内容",
  find:          "按 glob 查找文件",
  ls:            "列出目录内容",
  exec:          "执行 shell 命令",
  process:       "管理后台执行会话",
  web_search:    "联网搜索（走配置的搜索提供方）",
  web_fetch:     "抓取 URL 的可读正文",
  nodes:         "调用手机能力：action=invoke, invokeCommand=\"ability.call\", invokeParamsJson JSON {\"method\":\"…\",\"params\":{…}}。method 必须与 android-abilities 类目文档中的字符串完全一致，不得自行拼接。",
  cron:          "定时任务和唤醒事件。创建提醒时用墙钟绝对时刻（带时区的 ISO-8601），不要用相对时间。",
  message:       "发送消息和频道操作",
  gateway:       "管理 OpenClaw 进程（重启/配置）",
  session_status:"显示会话状态（用量/时间/模型）",
  memory_search: "语义搜索记忆内容",
  image:         "用图像模型分析图片",
  skill_guide:   "获取技能指南。command=\"show\" + name=\"技能名\" 返回完整 SKILL.md；command=\"list\" 列出所有技能；command=\"find\" + keyword 搜索。",
};

// ─── Channel 路由 ────────────────────────────────────────────────────────────

/**
 * 解析 sections.* 某段的目标通道，兼容旧布尔格式。
 * @returns {"system" | "user" | "off"}
 */
function resolveChannel(config, sectionId) {
  const sec = config.sections?.[sectionId];
  if (!sec) return "off";
  if (sec.channel === "user") return "user";
  if (sec.channel === "system") return "system";
  if (sec.channel === "off") return "off";
  if (sec.enabled === false) return "off";
  return "system";
}

/**
 * 解析顶层 inject* 字段（injectCurrentTime / injectProjectContext / injectRuntimeLine），
 * 兼容旧布尔 true/false。
 * @returns {"system" | "user" | "off"}
 */
function resolveInjectChannel(value) {
  if (value === "user") return "user";
  if (value === true || value === "system") return "system";
  if (value === false || value === "off") return "off";
  // undefined / null → 默认 "system"（与旧版 `!== false` 语义一致）
  return "system";
}

// ─── System Prompt 组装（仅稳定段） ──────────────────────────────────────────

/**
 * 组装 system prompt（仅 channel=system 的段落）。
 *
 * @param {object} params
 * @param {object} params.templates      loadTemplates() 的返回值 { config, texts }
 * @param {object} params.variables      模板变量
 * @param {Array}  params.bootstrapFiles loadBootstrapFiles() 的返回值
 * @param {string} params.promptMode     "full" | "minimal"
 * @returns {string}
 */
function assembleSystemPrompt({ templates, variables, bootstrapFiles, promptMode, promptTier, tierOverrides }) {
  const isMinimal = promptMode === "minimal";
  const { config, texts } = templates;
  const sections = [];
  const tierConfig = promptTier ? resolveTierConfig(promptTier, tierOverrides) : null;
  const tierMode = (id) => tierConfig ? getTierSectionMode(tierConfig, id) : "on";
  const injectAllowed = (field) => !tierConfig?.inject || tierConfig.inject[field] !== false;

  // 1. 身份声明
  if (tierMode("identity") !== "off" && resolveChannel(config, "identity") === "system") {
    if (tierMode("identity") === "lite") {
      const lite = getSection(texts, "identity-lite", BUILT_IN_DEFAULTS["identity-lite"]);
      sections.push(lite || getSection(texts, "identity", BUILT_IN_DEFAULTS.identity));
    } else {
      const identity = getSection(texts, "identity", BUILT_IN_DEFAULTS.identity);
      if (identity) sections.push(identity);
    }
  }

  // 2. Tooling
  if (tierMode("tooling") !== "off" && resolveChannel(config, "tooling") === "system") {
    const toolingHeader = getSection(texts, "tooling", null);
    sections.push(toolingHeader || "## 工具");
    if (!(tierConfig && Array.isArray(tierConfig.toolSummaries) && tierConfig.toolSummaries.length === 0)) {
      sections.push(buildToolList());
    }
  }

  // 3. 工具调用风格
  if (tierMode("tool-call-style") !== "off" && resolveChannel(config, "tool-call-style") === "system") {
    if (tierMode("tool-call-style") === "lite") {
      const lite = getSection(texts, "tool-call-style-lite", BUILT_IN_DEFAULTS["tool-call-style-lite"]);
      sections.push(lite || getSection(texts, "tool-call-style", BUILT_IN_DEFAULTS["tool-call-style"]));
    } else {
      sections.push(getSection(texts, "tool-call-style", BUILT_IN_DEFAULTS["tool-call-style"]));
    }
  }

  // 4. 安全准则
  if (tierMode("safety") !== "off" && resolveChannel(config, "safety") === "system") {
    sections.push(getSection(texts, "safety", BUILT_IN_DEFAULTS.safety));
  }

  // 5. 技能
  if (tierMode("skills-header") !== "off" && resolveChannel(config, "skills-header") === "system" && variables.skillsSummary) {
    if (tierMode("skills-header") === "lite") {
      const lite = getSection(texts, "skills-header-lite", BUILT_IN_DEFAULTS["skills-header-lite"]);
      sections.push(lite || getSection(texts, "skills-header", BUILT_IN_DEFAULTS["skills-header"]));
    } else {
      sections.push(getSection(texts, "skills-header", BUILT_IN_DEFAULTS["skills-header"]));
    }
    sections.push(variables.skillsSummary);
  }

  // 6. 记忆回忆（minimal 跳过）
  if (!isMinimal && tierMode("memory-recall") !== "off" && resolveChannel(config, "memory-recall") === "system") {
    sections.push(getSection(texts, "memory-recall", BUILT_IN_DEFAULTS["memory-recall"]));
  }

  // 7. Android 运行环境
  if (tierMode("android-context") !== "off" && resolveChannel(config, "android-context") === "system") {
    if (tierMode("android-context") === "lite") {
      const lite = getSection(texts, "android-context-lite", BUILT_IN_DEFAULTS["android-context-lite"]);
      sections.push(lite || getSection(texts, "android-context", BUILT_IN_DEFAULTS["android-context"]));
    } else {
      sections.push(getSection(texts, "android-context", BUILT_IN_DEFAULTS["android-context"]));
    }
  }

  // 8. 定时任务指导（minimal 跳过）
  if (!isMinimal && tierMode("cron-guidance") !== "off" && resolveChannel(config, "cron-guidance") === "system") {
    const cron = getSection(texts, "cron-guidance", null);
    if (cron) sections.push(cron);
  }

  // 9. 工作区信息
  if (tierMode("workspace-info") !== "off" && resolveChannel(config, "workspace-info") === "system") {
    if (tierMode("workspace-info") === "lite") {
      const lite = getSection(texts, "workspace-info-lite", BUILT_IN_DEFAULTS["workspace-info-lite"]);
      if (lite) {
        sections.push(interpolate(lite, variables));
      } else {
        const wsInfo = getSection(texts, "workspace-info", null);
        if (wsInfo) {
          sections.push(interpolate(wsInfo, variables));
        } else if (variables.workspaceDir) {
          sections.push(`## 工作区\n路径：${variables.workspaceDir}`);
        }
      }
    } else {
      const wsInfo = getSection(texts, "workspace-info", null);
      if (wsInfo) {
        sections.push(interpolate(wsInfo, variables));
      } else if (variables.workspaceDir) {
        sections.push(`## 工作区\n路径：${variables.workspaceDir}`);
      }
    }
  }

  // 10. 当前时间
  if (injectAllowed("currentTime") && resolveInjectChannel(config.injectCurrentTime) === "system" && variables.userTimezone && variables.currentTime) {
    sections.push(`## 当前时间\n时区：${variables.userTimezone}\n时间：${variables.currentTime}`);
  }

  // 11. Bootstrap 文件
  if (injectAllowed("projectContext") && resolveInjectChannel(config.injectProjectContext) === "system" && bootstrapFiles && bootstrapFiles.length > 0) {
    const fileBlocks = bootstrapFiles.map((f) => `## ${f.name}\n${f.content}`).join("\n\n");
    sections.push(`# Project Context\n以下文件来自工作区，定义了项目上下文和人设：\n\n${fileBlocks}`);
  }

  // 12. 静默回复（minimal 跳过）
  if (!isMinimal && tierMode("silent-replies") !== "off" && resolveChannel(config, "silent-replies") === "system") {
    sections.push(getSection(texts, "silent-replies", BUILT_IN_DEFAULTS["silent-replies"]));
  }

  // 13. 心跳（minimal 跳过）
  if (!isMinimal && tierMode("heartbeat") !== "off" && resolveChannel(config, "heartbeat") === "system") {
    sections.push(getSection(texts, "heartbeat", BUILT_IN_DEFAULTS.heartbeat));
  }

  // 14. Runtime 行
  if (injectAllowed("runtimeLine") && resolveInjectChannel(config.injectRuntimeLine) === "system" && variables.runtimeLine) {
    sections.push(`## Runtime\n${variables.runtimeLine}`);
  }

  return sections.filter(Boolean).join("\n\n");
}

// ─── PrependContext 组装（动态段） ────────────────────────────────────────────

/**
 * 组装 prependContext（仅 channel=user 的段落）。
 * 结构与 assembleSystemPrompt 对称，便于维护。
 *
 * @param {object} params  同 assembleSystemPrompt
 * @returns {string|undefined}  有内容时返回字符串，否则 undefined
 */
function assemblePrependContext({ templates, variables, bootstrapFiles, promptMode, promptTier, tierOverrides }) {
  const isMinimal = promptMode === "minimal";
  const { config, texts } = templates;
  const sections = [];
  const tierConfig = promptTier ? resolveTierConfig(promptTier, tierOverrides) : null;
  const tierMode = (id) => tierConfig ? getTierSectionMode(tierConfig, id) : "on";
  const injectAllowed = (field) => !tierConfig?.inject || tierConfig.inject[field] !== false;

  // sections 里 channel=user 的块，按原段落顺序收集

  // 1-5：identity / tooling / tool-call-style / safety / skills-header
  // 这些通常不会设为 user，但架构上保持对称支持
  if (tierMode("identity") !== "off" && resolveChannel(config, "identity") === "user") {
    if (tierMode("identity") === "lite") {
      const lite = getSection(texts, "identity-lite", BUILT_IN_DEFAULTS["identity-lite"]);
      sections.push(lite || getSection(texts, "identity", BUILT_IN_DEFAULTS.identity));
    } else {
      const identity = getSection(texts, "identity", BUILT_IN_DEFAULTS.identity);
      if (identity) sections.push(identity);
    }
  }
  if (tierMode("tooling") !== "off" && resolveChannel(config, "tooling") === "user") {
    const toolingHeader = getSection(texts, "tooling", null);
    sections.push(toolingHeader || "## 工具");
    if (!(tierConfig && Array.isArray(tierConfig.toolSummaries) && tierConfig.toolSummaries.length === 0)) {
      sections.push(buildToolList());
    }
  }
  if (tierMode("tool-call-style") !== "off" && resolveChannel(config, "tool-call-style") === "user") {
    if (tierMode("tool-call-style") === "lite") {
      const lite = getSection(texts, "tool-call-style-lite", BUILT_IN_DEFAULTS["tool-call-style-lite"]);
      sections.push(lite || getSection(texts, "tool-call-style", BUILT_IN_DEFAULTS["tool-call-style"]));
    } else {
      sections.push(getSection(texts, "tool-call-style", BUILT_IN_DEFAULTS["tool-call-style"]));
    }
  }
  if (tierMode("safety") !== "off" && resolveChannel(config, "safety") === "user") {
    sections.push(getSection(texts, "safety", BUILT_IN_DEFAULTS.safety));
  }
  if (tierMode("skills-header") !== "off" && resolveChannel(config, "skills-header") === "user" && variables.skillsSummary) {
    if (tierMode("skills-header") === "lite") {
      const lite = getSection(texts, "skills-header-lite", BUILT_IN_DEFAULTS["skills-header-lite"]);
      sections.push(lite || getSection(texts, "skills-header", BUILT_IN_DEFAULTS["skills-header"]));
    } else {
      sections.push(getSection(texts, "skills-header", BUILT_IN_DEFAULTS["skills-header"]));
    }
    sections.push(variables.skillsSummary);
  }

  // 6. 记忆回忆（minimal 跳过）
  if (!isMinimal && tierMode("memory-recall") !== "off" && resolveChannel(config, "memory-recall") === "user") {
    sections.push(getSection(texts, "memory-recall", BUILT_IN_DEFAULTS["memory-recall"]));
  }

  // 7. Android 运行环境
  if (tierMode("android-context") !== "off" && resolveChannel(config, "android-context") === "user") {
    if (tierMode("android-context") === "lite") {
      const lite = getSection(texts, "android-context-lite", BUILT_IN_DEFAULTS["android-context-lite"]);
      sections.push(lite || getSection(texts, "android-context", BUILT_IN_DEFAULTS["android-context"]));
    } else {
      sections.push(getSection(texts, "android-context", BUILT_IN_DEFAULTS["android-context"]));
    }
  }

  // 8. 定时任务指导（minimal 跳过）
  if (!isMinimal && tierMode("cron-guidance") !== "off" && resolveChannel(config, "cron-guidance") === "user") {
    const cron = getSection(texts, "cron-guidance", null);
    if (cron) sections.push(cron);
  }

  // 9. 工作区信息
  if (tierMode("workspace-info") !== "off" && resolveChannel(config, "workspace-info") === "user") {
    if (tierMode("workspace-info") === "lite") {
      const lite = getSection(texts, "workspace-info-lite", BUILT_IN_DEFAULTS["workspace-info-lite"]);
      if (lite) {
        sections.push(interpolate(lite, variables));
      } else {
        const wsInfo = getSection(texts, "workspace-info", null);
        if (wsInfo) {
          sections.push(interpolate(wsInfo, variables));
        } else if (variables.workspaceDir) {
          sections.push(`## 工作区\n路径：${variables.workspaceDir}`);
        }
      }
    } else {
      const wsInfo = getSection(texts, "workspace-info", null);
      if (wsInfo) {
        sections.push(interpolate(wsInfo, variables));
      } else if (variables.workspaceDir) {
        sections.push(`## 工作区\n路径：${variables.workspaceDir}`);
      }
    }
  }

  // 10. 当前时间
  if (injectAllowed("currentTime") && resolveInjectChannel(config.injectCurrentTime) === "user" && variables.userTimezone && variables.currentTime) {
    sections.push(`## 当前时间\n时区：${variables.userTimezone}\n时间：${variables.currentTime}`);
  }

  // 11. Bootstrap 文件
  if (injectAllowed("projectContext") && resolveInjectChannel(config.injectProjectContext) === "user" && bootstrapFiles && bootstrapFiles.length > 0) {
    const fileBlocks = bootstrapFiles.map((f) => `## ${f.name}\n${f.content}`).join("\n\n");
    sections.push(`# Project Context\n以下文件来自工作区，定义了项目上下文和人设：\n\n${fileBlocks}`);
  }

  // 12. 静默回复（minimal 跳过）
  if (!isMinimal && tierMode("silent-replies") !== "off" && resolveChannel(config, "silent-replies") === "user") {
    sections.push(getSection(texts, "silent-replies", BUILT_IN_DEFAULTS["silent-replies"]));
  }

  // 13. 心跳（minimal 跳过）
  if (!isMinimal && tierMode("heartbeat") !== "off" && resolveChannel(config, "heartbeat") === "user") {
    sections.push(getSection(texts, "heartbeat", BUILT_IN_DEFAULTS.heartbeat));
  }

  // 14. Runtime 行
  if (injectAllowed("runtimeLine") && resolveInjectChannel(config.injectRuntimeLine) === "user" && variables.runtimeLine) {
    sections.push(`## Runtime\n${variables.runtimeLine}`);
  }

  const result = sections.filter(Boolean).join("\n\n");
  return result || undefined;
}

// ─── 工具函数 ────────────────────────────────────────────────────────────────

/**
 * 生成工具摘要列表文本。
 */
function buildToolList() {
  return Object.entries(TOOL_SUMMARIES)
    .map(([name, desc]) => `- **${name}**: ${desc}`)
    .join("\n");
}

/**
 * 生成 Runtime 信息行。
 */
function buildRuntimeLine(extras) {
  const parts = [
    `os=${os.type()} ${os.release()}`,
    `arch=${os.arch()}`,
    `node=${process.version}`,
  ];
  if (extras) {
    for (const [k, v] of Object.entries(extras)) {
      if (v) parts.push(`${k}=${v}`);
    }
  }
  return parts.join(" | ");
}

/**
 * 格式化当前时间。
 */
function formatCurrentTime(timezone) {
  try {
    return new Date().toLocaleString("zh-CN", {
      timeZone: timezone || "Asia/Shanghai",
      year: "numeric", month: "2-digit", day: "2-digit",
      hour: "2-digit", minute: "2-digit",
      hour12: false,
    });
  } catch {
    return new Date().toISOString();
  }
}

/**
 * 从 texts 获取段落内容，不存在时用 fallback。
 */
function getSection(texts, sectionId, fallback) {
  return texts[sectionId] || fallback || null;
}

/**
 * 简单变量插值：替换 {{varName}} 占位符。
 */
function interpolate(template, variables) {
  return template.replace(/\{\{(\w+)\}\}/g, (_, key) => {
    return variables[key] !== undefined ? String(variables[key]) : `{{${key}}}`;
  });
}

/**
 * 从 sessionKey 推断 promptMode。
 * 与 OpenClaw resolvePromptModeForSession 逻辑对齐。
 */
function resolvePromptMode(sessionKey) {
  if (!sessionKey) return "full";
  if (sessionKey.includes(":sub:") || sessionKey.startsWith("subagent:")) return "minimal";
  if (sessionKey.includes(":cron:")) return "minimal";
  return "full";
}

module.exports = {
  assembleSystemPrompt,
  assemblePrependContext,
  buildToolList,
  buildRuntimeLine,
  formatCurrentTime,
  resolvePromptMode,
  resolveChannel,
  resolveInjectChannel,
  interpolate,
  TOOL_SUMMARIES,
};
