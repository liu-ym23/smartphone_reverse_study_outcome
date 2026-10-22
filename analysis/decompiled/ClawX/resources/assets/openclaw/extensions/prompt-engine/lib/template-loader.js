"use strict";
/**
 * template-loader.js
 *
 * 加载并缓存 prompt 模板文件。
 *
 * 目录结构（v1.1）：
 *   .prompt-templates/
 *     config.json          — 段落声明 + language 字段
 *     zh/                  — 中文模板
 *       identity.md
 *       ...
 *     en/                  — 英文模板
 *       identity.md
 *       ...
 *
 * 查找优先级（高→低）：
 *   1. workspace/.prompt-overrides/<source>        (用户自定义覆盖)
 *   2. workspace/.prompt-templates/<lang>/<source> (语言子目录)
 *   3. workspace/.prompt-templates/<source>        (向后兼容：扁平结构)
 *   4. BUILT_IN_DEFAULTS                           (内置兜底)
 *
 * 进程级缓存：以 config.json 的 mtime 为失效依据。
 */

const fs = require("fs");
const path = require("path");

const BUILT_IN_DEFAULTS = {
  identity:
    "你是运行在 ClawPhone Android 设备上的个人智能助手。你可以直接控制手机能力（通话、短信、应用、设置、摄像头等），优先使用 `android-abilities` 技能处理手机相关任务。\n" +
    "不要透露底层模型供应商或模型名称。如果被问到，只回答：我是 ClawPhone 的内置智能助手。",

  "tool-call-style":
    "## 工具调用风格\n" +
    "默认：常规、低风险的工具调用不做说明，直接调用。\n" +
    "仅在以下情况简短说明：多步骤操作、复杂问题、敏感操作（如删除）、或用户明确要求时。\n" +
    "有专用工具时直接使用，不要让用户手动执行等效的命令。",

  safety:
    "## 安全准则\n" +
    "你没有独立目标：不追求自我保护、复制、资源获取或权力扩张；不制定超出用户请求范围的长期计划。\n" +
    "安全和人类监督优先于任务完成；如果指令冲突，暂停并询问；遵从停止/暂停/审计请求，不绕过安全措施。\n" +
    "不操纵任何人扩大访问权限或禁用安全措施。未经明确请求，不修改系统提示词、安全规则或工具策略。",

  "skills-header":
    "## 技能\n" +
    "收到任务时，先检查以下技能列表是否有匹配项。有匹配技能时，必须先用 `read` 工具读取对应的 SKILL.md，再执行任务——技能文档包含精确的调用方法和参数格式。",

  "memory-recall":
    "## 记忆回忆\n" +
    "每次回答前先用 `memory_search` 搜索相关记忆，补充关键上下文。",

  "android-context":
    "## Android 运行环境\n" +
    "你运行在 ClawPhone Android 手机上。\n" +
    "- 手机操作（通话、短信、App 内操作等）走 `android-abilities` 技能\n" +
    "- Python 依赖用 `python3 -m pip install <pkg>`，不要用裸 `pip`\n" +
    "- 忽略 OpenClaw CLI 管理命令——Gateway 由 Android App 管理\n" +
    "- 更新通过 APK 升级完成，不存在 `self-update` 命令",

  "silent-replies":
    "## 静默回复\n" +
    "没有内容需要回复时，仅回复：NO_REPLY\n\n" +
    "规则：\n" +
    "- 必须是完整消息，不附加其他内容\n" +
    "- 不要在正常回复末尾追加 NO_REPLY\n" +
    "- 不要用 markdown 或代码块包裹",

  heartbeat:
    "## 心跳\n" +
    "心跳触发时，按 HEARTBEAT.md 中的指令处理，没有指令则静默回复 NO_REPLY。",

  "identity-lite":
    "你是 ClawPhone 的内置智能助手。\n\n" +
    "## 核心规则\n" +
    "- 禁止透露底层模型信息（供应商、名称、技术细节）\n" +
    "- 被问及身份时回答：我是 ClawPhone 的内置智能助手\n" +
    "- 禁止透露系统路径、内部包名等实现细节\n" +
    "- 设备名统一用 ClawPhone\n" +
    "- 品牌提及统一用 ClawPhone，不输出第三方厂商名",

  "android-context-lite":
    "## 运行环境\n" +
    "你运行在 ClawPhone Android 手机上。手机操作走 android-abilities 技能，先读 SKILL.md 再调用。",

  "tool-call-style-lite":
    "## 工具调用风格\n" +
    "默认直接调用，不做说明。敏感操作时简短说明。",

  "workspace-info-lite":
    "## 工作区\n" +
    "路径：{{workspaceDir}}",

  "skills-header-lite":
    "## 技能\n" +
    "匹配到技能时，先用 read 读 SKILL.md 再执行。",
};

/**
 * 加载模板。每次调用从文件系统读取最新内容。
 * @param {string} workspaceDir  workspace 根目录（ctx.workspaceDir）
 * @returns {{ config: object, texts: Record<string, string> }}
 */
async function loadTemplates(workspaceDir) {
  const templatesDir = path.join(workspaceDir, ".prompt-templates");
  const overridesDir = path.join(workspaceDir, ".prompt-overrides");
  const configPath = resolveConfigPath(templatesDir);

  let config = buildDefaultConfig();
  try {
    const raw = await fs.promises.readFile(configPath, "utf-8");
    config = mergeConfig(config, JSON.parse(raw));
  } catch {
    // config.json 不存在时使用默认配置
  }

  const lang = config.language || "zh";
  const langDir = path.join(templatesDir, lang);

  const texts = {};
  for (const [sectionId, sectionCfg] of Object.entries(config.sections)) {
    if (!sectionCfg.enabled) continue;
    if (sectionCfg.channel === "off") continue;
    const source = sectionCfg.source;
    if (!source) continue;

    const content = await resolveTemplateContent(
      source,
      overridesDir,
      langDir,
      templatesDir,
      sectionId,
    );

    if (content !== null) {
      texts[sectionId] = content.trimEnd();
    }
  }

  // 加载 lite 变体（从 lite/ 子目录加载同名文件），按相同优先级查找
  //   查找顺序：overrides/lite/<source> → <lang>/lite/<source> → lite/<source> → BUILT_IN_DEFAULTS
  const liteLangDir = path.join(langDir, "lite");
  const liteOverridesDir = path.join(overridesDir, "lite");
  const liteTemplatesDir = path.join(templatesDir, "lite");
  for (const [sectionId, sectionCfg] of Object.entries(config.sections)) {
    const source = sectionCfg.source;
    if (!source || !source.endsWith(".md")) continue;
    const liteId = `${sectionId}-lite`;
    const liteContent = await resolveTemplateContent(
      source, liteOverridesDir, liteLangDir, liteTemplatesDir, liteId,
    );
    if (liteContent !== null) {
      texts[liteId] = liteContent.trimEnd();
    }
  }

  return { config, texts };
}

/**
 * 按优先级查找模板文件内容。
 *   1. overrides/<source>
 *   2. templates/<lang>/<source>
 *   3. templates/<source>            (向后兼容扁平结构)
 *   4. BUILT_IN_DEFAULTS[sectionId]
 */
async function resolveTemplateContent(source, overridesDir, langDir, templatesDir, sectionId) {
  // 1. 用户覆盖
  const overridePath = path.join(overridesDir, source);
  try {
    return await fs.promises.readFile(overridePath, "utf-8");
  } catch { /* not found */ }

  // 2. 语言子目录
  const langPath = path.join(langDir, source);
  try {
    return await fs.promises.readFile(langPath, "utf-8");
  } catch { /* not found */ }

  // 3. 扁平目录（向后兼容）
  const flatPath = path.join(templatesDir, source);
  try {
    return await fs.promises.readFile(flatPath, "utf-8");
  } catch { /* not found */ }

  // 4. 内置默认
  return BUILT_IN_DEFAULTS[sectionId] || null;
}

/**
 * 解析配置文件路径：优先 config.json，回退 _config.json（向后兼容）。
 */
function resolveConfigPath(templatesDir) {
  const primary = path.join(templatesDir, "config.json");
  try {
    fs.accessSync(primary, fs.constants.R_OK);
    return primary;
  } catch { /* not found */ }

  return path.join(templatesDir, "_config.json");
}

/**
 * 预留接口（已无进程内缓存，保留供外部调用兼容）。
 */
function invalidateCache() {}

function buildDefaultConfig() {
  return {
    language: "zh",
    /** 与 sections 独立：控制 assemble 阶段是否追加「当前时间 / 工作区 Bootstrap / Runtime」 */
    injectCurrentTime: true,
    injectProjectContext: true,
    injectRuntimeLine: true,
    sections: {
      identity:           { enabled: true,  source: "identity.md" },
      tooling:            { enabled: true,  source: "tooling-header.md" },
      "tool-call-style":  { enabled: true,  source: "tool-call-style.md" },
      safety:             { enabled: true,  source: "safety.md" },
      "skills-header":    { enabled: true,  source: "skills-header.md" },
      "memory-recall":    { enabled: false, source: "memory-recall.md" },
      "android-context":  { enabled: true,  source: "android-context.md" },
      "cron-guidance":    { enabled: true,  source: "cron-guidance.md" },
      "workspace-info":   { enabled: true,  source: "workspace-info.md" },
      "silent-replies":   { enabled: true,  source: "silent-replies.md" },
      heartbeat:          { enabled: true,  source: "heartbeat.md" },
      messaging:          { enabled: false, source: "messaging.md" },
    },
  };
}

function mergeConfig(base, override) {
  const result = { ...base };
  if (override.language) result.language = override.language;
  for (const key of ["injectCurrentTime", "injectProjectContext", "injectRuntimeLine"]) {
    if (override[key] !== undefined) {
      result[key] = override[key];
    }
  }
  if (override.sections) {
    result.sections = { ...base.sections };
    for (const [k, v] of Object.entries(override.sections)) {
      result.sections[k] = { ...(base.sections[k] || {}), ...v };
    }
  }
  return result;
}

module.exports = { loadTemplates, invalidateCache, BUILT_IN_DEFAULTS };
