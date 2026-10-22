"use strict";
/**
 * StepClaw Prompt Engine Plugin
 *
 * 通过 before_prompt_build Hook（方案 A：独立共存），完全替换 OpenClaw 默认
 * buildAgentSystemPrompt() 产物，改为 StepClaw 面向 Android AIOS 场景优化的中文提示词。
 *
 * 架构：
 *   - priority=100（高优先级），先于 stepclaw-intercept（默认 priority）执行
 *   - 返回 { systemPrompt, prependContext? }，systemPrompt 整段替换默认 prompt，
 *     prependContext 携带动态段（时间/Runtime/Bootstrap/memory-recall 等）拼入 user 前缀
 *   - stepclaw-intercept 仍可通过 appendSystemContext 追加记忆召回内容
 *   - fail-open：任何异常时返回 undefined，回退到 OpenClaw 默认 prompt
 *
 * Hook 事件说明：
 *   before_prompt_build 的 event.prompt 是用户输入的消息文本（不是 system prompt），
 *   ctx.workspaceDir 是当前 workspace 路径。插件从文件系统自行加载所有构建数据。
 */

const fs = require("fs");
const path = require("path");

const { loadTemplates } = require("./lib/template-loader");
const { loadBootstrapFiles } = require("./lib/bootstrap-loader");
const { loadSkillsSummary, getAllSkillEntries } = require("./lib/skills-loader");
const {
  assembleSystemPrompt,
  assemblePrependContext,
  buildRuntimeLine,
  formatCurrentTime,
  resolvePromptMode,
} = require("./lib/prompt-assembler");
const { classifyTask } = require("./lib/task-classifier");
const { resolveLlmOverrides } = require("./lib/llm-override-resolver");

// 进程级缓存（避免每次 Hook 调用都重新扫描 skills）
let _skillsCacheDir = null;
let _skillsCacheResult = null;
let _skillsCacheTs = 0;
const SKILLS_CACHE_TTL_MS = 60_000; // 60 秒内复用


module.exports = {
  id: "prompt-engine",
  name: "StepClaw Prompt Engine",

  register(api) {
    const pluginCfg = api.pluginConfig || {};
    const enabled = pluginCfg.enabled !== false;
    // 与 openclaw.plugin.json 中 debug 的 default: true 一致（loader 不会注入 schema default）
    const debug = pluginCfg.debug === true;

    if (!enabled) {
      api.logger.info("[prompt-engine] disabled by config, skipping hook registration");
      return;
    }

    // 从 api.config 读取 Bootstrap / Skills 配置参数
    const bootstrapMaxChars =
      api.config?.agents?.defaults?.bootstrapMaxChars || 20000;
    const bootstrapTotalMaxChars =
      api.config?.agents?.defaults?.bootstrapTotalMaxChars || 150000;
    const maxSkillsPromptChars =
      api.config?.skills?.limits?.maxSkillsPromptChars || 30000;
    const configTimezone =
      api.config?.agents?.defaults?.userTimezone || "Asia/Shanghai";

    // Skills 混合加载配置（从 pluginConfig 或 api.config 读取）
    const skillsSummaryFormat = pluginCfg.skillsSummaryFormat || "hybrid";
    const skillsMaxDescriptionLength = pluginCfg.skillsMaxDescriptionLength || 10000;
    const skillsAlwaysInclude = pluginCfg.skillsAlwaysInclude || undefined;

    api.logger.info(
      `[prompt-engine] registered (bootstrapMax=${bootstrapMaxChars}, ` +
      `bootstrapTotal=${bootstrapTotalMaxChars}, skillsMax=${maxSkillsPromptChars}, ` +
      `skillsFormat=${skillsSummaryFormat})`
    );

    // 注册 skill_guide 工具（list/show/find），供模型按需查询技能
    // 无条件注册，即使不是 hybrid 模式也可用。
    // getWorkspaceDir：hook 触发后优先用已知的 _skillsCacheDir，
    // 首次对话前降级到 process.cwd()（proot 下 cwd === workspace root）。
    registerSkillTool(api, () => _skillsCacheDir || process.cwd());

    // priority=100 确保先于 stepclaw-intercept 执行
    api.on(
      "before_prompt_build",
      async (event, ctx) => {
        try {
          return await buildPrompt({
            event,
            ctx,
            api,
            bootstrapMaxChars,
            bootstrapTotalMaxChars,
            maxSkillsPromptChars,
            configTimezone,
            skillsSummaryFormat,
            skillsMaxDescriptionLength,
            skillsAlwaysInclude,
            debug,
            logger: api.logger,
          });
        } catch (err) {
          api.logger.error(
            `[prompt-engine] build failed, falling back to default: ${err?.message || err}`
          );
          return undefined; // fail-open
        }
      },
      { priority: 100 }
    );
  },
};

// ─────────────────────────────────────────────────────────────────────────────

/**
 * 构建完整 system prompt 并返回 Hook 结果。
 */
async function buildPrompt({
  event,
  ctx,
  api,
  bootstrapMaxChars,
  bootstrapTotalMaxChars,
  maxSkillsPromptChars,
  configTimezone,
  skillsSummaryFormat,
  skillsMaxDescriptionLength,
  skillsAlwaysInclude,
  debug,
  logger,
}) {
  const workspaceDir = ctx.workspaceDir;
  if (!workspaceDir) {
    logger.warn("[prompt-engine] ctx.workspaceDir is empty, skipping");
    return undefined;
  }

  const promptMode = resolvePromptMode(ctx.sessionKey);

  // none 模式（当前 OpenClaw 不通过 Hook 传递，保留逻辑备用）
  if (promptMode === "none") {
    return {
      systemPrompt: "你是运行在 ClawPhone Android 设备上的个人智能助手。",
    };
  }

  // ── 任务分类 ──────────────────────────────────────────────────────────────
  const userMessage = typeof event?.prompt === "string" ? event.prompt : "";
  const taskClassConfig = api.pluginConfig?.taskClassification ?? {};
  const tierOverrides = api.pluginConfig?.tierOverrides;
  let classifyResult = null;
  try {
    classifyResult = await classifyTask(
      userMessage, api, taskClassConfig, promptMode, ctx.sessionKey
    );
  } catch (err) {
    logger.warn(`[prompt-engine] classify error, falling back to FULL: ${err?.message || err}`);
  }
  const promptTier = classifyResult?.tier;

  if (classifyResult) {
    logger.info(
      `[prompt-engine] classify: ${classifyResult.tier} via ${classifyResult.source} ${classifyResult.latencyMs}ms`
    );
  }

  // 1. 并行加载：模板 + Skills + Bootstrap
  const [templates, skillsSummary, bootstrapFiles] = await Promise.all([
    loadTemplates(workspaceDir),
    getCachedSkillsSummary(workspaceDir, {
      maxChars: maxSkillsPromptChars,
      summaryFormat: skillsSummaryFormat,
      maxDescriptionLength: skillsMaxDescriptionLength,
      alwaysIncludeSkills: skillsAlwaysInclude,
      logger,
    }),
    loadBootstrapFiles(workspaceDir, {
      maxChars: bootstrapMaxChars,
      totalMaxChars: bootstrapTotalMaxChars,
      minimal: promptMode === "minimal",
      promptTier,
      tierOverrides,
    }),
  ]);

  // 2. 构建变量上下文
  const userTimezone = configTimezone;
  const variables = {
    workspaceDir,
    userTimezone,
    currentTime: formatCurrentTime(userTimezone),
    skillsSummary,
    runtimeLine: buildRuntimeLine({ trigger: ctx.trigger || "user" }),
    sessionType: resolveSessionType(ctx.sessionKey),
  };

  // 3. 组装 system prompt（仅稳定段）
  const assembleParams = { templates, variables, bootstrapFiles, promptMode, promptTier, tierOverrides };
  const systemPrompt = assembleSystemPrompt(assembleParams);

  // 4. 组装 prependContext（动态段：时间 / Runtime / Bootstrap / memory-recall 等）
  const prependContext = assemblePrependContext(assembleParams);

  logger.info(
    `[prompt-engine] assembled system=${systemPrompt.length} prepend=${prependContext?.length || 0} chars ` +
    `(mode=${promptMode}, tier=${promptTier ?? "none"}, bootstrap=${bootstrapFiles.length} files, ` +
    `skills=${skillsSummary.length} chars, session=${ctx.sessionKey || "?"})`
  );

  // 5. 调试：异步写入快照，不阻塞 Hook 返回
  if (debug) {
    const snapPath = path.join(workspaceDir, ".prompt-debug-latest.md");
    const { resolveTierConfig, getTierSectionMode } = require("./lib/tier-section-matrix");
    const tierConfig = promptTier ? resolveTierConfig(promptTier, tierOverrides) : null;

    // 分类段落
    let classifyBlock = "";
    if (classifyResult) {
      const msgPreview = userMessage.slice(0, 50) + (userMessage.length > 50 ? "..." : "");
      classifyBlock =
        `\n## Task Classification\n` +
        `- tier: ${classifyResult.tier}\n` +
        `- source: ${classifyResult.source}\n` +
        `- latencyMs: ${classifyResult.latencyMs}\n` +
        `- userMessage (first 50 chars): "${msgPreview}"\n`;
    }

    // 段落包含状态
    let sectionBlock = "";
    if (tierConfig) {
      const SECTION_IDS = [
        "identity", "tooling", "tool-call-style", "safety", "skills-header",
        "memory-recall", "android-context", "cron-guidance", "workspace-info",
        "silent-replies", "heartbeat", "messaging",
      ];
      const lines = SECTION_IDS.map((id) => {
        const mode = getTierSectionMode(tierConfig, id);
        const icon = mode === "on" ? "✅" : mode === "lite" ? "📝 lite" : "❌";
        return `- ${id.padEnd(18)} ${icon}`;
      });
      sectionBlock = `\n## Section Inclusion (tier=${promptTier})\n${lines.join("\n")}\n`;
    }

    // 组装统计
    const sysLen = systemPrompt.length;
    const preLen = prependContext?.length || 0;
    const statsBlock =
      `\n## Assembly Stats\n` +
      `- systemPrompt: ${sysLen} chars\n` +
      `- prependContext: ${preLen} chars\n` +
      `- estimatedTokens: ~${Math.round((sysLen + preLen) / 1.5)}\n` +
      `- bootstrapFiles: ${bootstrapFiles.length}\n`;

    // LLM Overrides
    const llmOvr = promptTier ? resolveLlmOverrides(promptTier, tierOverrides) : {};
    const llmBlock = Object.keys(llmOvr).length > 0
      ? `\n## LLM Overrides\n` + Object.entries(llmOvr).map(([k, v]) => `- ${k}: ${v}`).join("\n") + "\n"
      : "";

    const header = `# Prompt Debug Snapshot\n生成时间: ${new Date().toISOString()}\n` +
      `模式: ${promptMode} | Tier: ${promptTier ?? "none"} | 会话: ${ctx.sessionKey || "?"}\n` +
      `Bootstrap 文件: ${bootstrapFiles.map((f) => f.name).join(", ") || "无"}\n` +
      `---\n` +
      classifyBlock + sectionBlock + statsBlock + llmBlock +
      `\n---\n\n`;
    const prependSection = prependContext
      ? `\n\n---\n# PrependContext (user 前缀)\n\n${prependContext}`
      : "";
    fs.promises
      .writeFile(snapPath, header + systemPrompt + prependSection, "utf-8")
      .then(() =>
        logger.info(`[prompt-engine] debug snapshot written (${snapPath})`)
      )
      .catch((e) => logger.warn(`[prompt-engine] debug snapshot write failed: ${e?.message}`));
  }

  // 6. LLM 路由参数
  const llmOverrides = promptTier ? resolveLlmOverrides(promptTier, tierOverrides) : {};

  const result = { systemPrompt };
  if (prependContext) result.prependContext = prependContext;
  if (promptTier && Object.keys(llmOverrides).length > 0) result.llmOverrides = llmOverrides;
  return result;
}

/**
 * 带 TTL 缓存的 Skills 摘要加载（skills 目录变化频率低）。
 * @param {string} workspaceDir
 * @param {object} opts  透传给 loadSkillsSummary
 */
async function getCachedSkillsSummary(workspaceDir, opts) {
  const now = Date.now();
  if (
    _skillsCacheDir === workspaceDir &&
    _skillsCacheResult !== null &&
    now - _skillsCacheTs < SKILLS_CACHE_TTL_MS
  ) {
    return _skillsCacheResult;
  }

  const logger = opts.logger;
  try {
    const summary = await loadSkillsSummary(workspaceDir, opts);
    _skillsCacheDir = workspaceDir;
    _skillsCacheResult = summary;
    _skillsCacheTs = now;
    logger?.info?.(`[prompt-engine] skills summary refreshed (${summary.length} chars)`);
    return summary;
  } catch (err) {
    logger?.warn?.(`[prompt-engine] skills load failed: ${err?.message}`);
    return _skillsCacheResult || "";
  }
}

// ─────────────────────────────────────────────────────────────────────────────

const SKILL_LIST_PAGE_SIZE = 15;

/**
 * 注册 skill_guide 工具（list / show / find）。
 * CLI 子命令风格，确定性接口，无需猜关键词。
 *
 * @param {object} api  插件 API
 * @param {() => string} getWorkspaceDir  返回当前 workspace 路径的 getter（可在注册后动态更新）
 */
function registerSkillTool(api, getWorkspaceDir) {
  api.registerTool(
    {
      name: "skill_guide",
      label: "skill_guide",
      description:
        "获取技能指南。参数：\n" +
        "  command=\"list\" [category] [page]  列出可用技能\n" +
        "  command=\"show\" name=\"技能名\"      返回技能完整指南\n" +
        "  command=\"find\" keyword=\"关键词\"  搜索技能",
      parameters: {
        type: "object",
        properties: {
          command: {
            type: "string",
            enum: ["list", "show", "find"],
            description: "子命令: list=列出, show=显示详情, find=搜索",
          },
          name: {
            type: "string",
            description: "show 命令的技能名称",
          },
          keyword: {
            type: "string",
            description: "find 命令的搜索关键词",
          },
          category: {
            type: "string",
            description: "list 命令的过滤类别（来自 SKILL.md frontmatter 的 category 字段）",
          },
          page: {
            type: "integer",
            description: "list 命令的页码（默认 1）",
          },
        },
        required: ["command"],
      },
      async execute(_callId, params) {
        const { command, name: skillName, keyword, category, page = 1 } = params || {};
        const allSkills = await getAllSkillEntries(getWorkspaceDir());

        switch (command) {
          case "list": {
            let filtered = allSkills;
            if (category) {
              const cat = category.toLowerCase();
              filtered = filtered.filter(
                (s) => s.category && s.category.toLowerCase() === cat
              );
            }
            const start = (page - 1) * SKILL_LIST_PAGE_SIZE;
            const paged = filtered.slice(start, start + SKILL_LIST_PAGE_SIZE);
            const totalPages = Math.ceil(filtered.length / SKILL_LIST_PAGE_SIZE);

            if (paged.length === 0) {
              return {
                content: [{ type: "text", text: category
                  ? `类别 "${category}" 下没有技能。用 skill_guide(command="list") 查看全部。`
                  : "当前没有可用技能。" }],
              };
            }

            const header = `技能列表 (${filtered.length} 个${category ? `, 类别: ${category}` : ""}, 第 ${page}/${totalPages} 页):\n`;
            const lines = paged.map(
              (s) => `  ${s.name}  # ${s.description.slice(0, 50)}`
            );
            const text = header + lines.join("\n");
            return { content: [{ type: "text", text }] };
          }

          case "show": {
            if (!skillName) {
              return {
                content: [{ type: "text", text: "错误: 请指定技能名称。用法: skill_guide(command=\"show\", name=\"技能名\")" }],
              };
            }
            const skill = allSkills.find((s) => s.name === skillName);
            if (!skill) {
              return {
                content: [{ type: "text", text: `技能 "${skillName}" 不存在。用 skill_guide(command="list") 查看全部。` }],
              };
            }
            try {
              const skillDir = path.dirname(skill.skillMdPath);
              const dirEntries = await fs.promises.readdir(skillDir, { withFileTypes: true });
              const files = dirEntries
                .filter((e) => !e.name.startsWith("."))
                .map((e) => e.isDirectory() ? `${e.name}/` : e.name);
              const text =
                `技能 "${skillName}" 目录: ${skillDir}\n` +
                `描述: ${skill.description}\n\n` +
                `文件列表:\n${files.map((f) => `  ${f}`).join("\n")}\n\n` +
                `请用 read 工具读取所需文件（如 ${skillDir}/SKILL.md）获取完整指南。`;
              return {
                content: [{ type: "text", text }],
              };
            } catch (err) {
              return {
                content: [{ type: "text", text: `读取失败 (${skill.skillMdPath}): ${err?.message || err}` }],
              };
            }
          }

          case "find": {
            if (!keyword) {
              return {
                content: [{ type: "text", text: "错误: 请指定搜索关键词。用法: skill_guide(command=\"find\", keyword=\"关键词\")" }],
              };
            }
            const kw = keyword.toLowerCase();
            const matched = allSkills.filter(
              (s) =>
                s.name.toLowerCase().includes(kw) ||
                s.description.toLowerCase().includes(kw)
            );
            if (matched.length === 0) {
              return {
                content: [{ type: "text", text: `未找到包含 "${keyword}" 的技能。用 skill_guide(command="list") 查看全部。` }],
              };
            }
            const lines = matched.map(
              (s) => `  ${s.name}  # ${s.description.slice(0, 60)}`
            );
            return { content: [{ type: "text", text: lines.join("\n") }] };
          }

          default:
            return {
              content: [{ type: "text", text: "未知命令。支持: list, show, find" }],
            };
        }
      },
    },
  );

  api.logger.info("[prompt-engine] skill_guide tool registered");
}

/**
 * 从 sessionKey 推断会话类型标签（仅用于日志和变量插值）。
 */
function resolveSessionType(sessionKey) {
  if (!sessionKey) return "main";
  if (sessionKey.includes(":cron:")) return "cron";
  if (sessionKey.includes(":sub:") || sessionKey.startsWith("subagent:")) return "subagent";
  return "main";
}
