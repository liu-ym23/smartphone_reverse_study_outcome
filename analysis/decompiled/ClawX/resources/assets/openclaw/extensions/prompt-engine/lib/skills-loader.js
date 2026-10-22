"use strict";
/**
 * skills-loader.js
 *
 * 扫描 workspace 中的 Skills 目录，提取每个 skill 的 name + description，
 * 生成供 system prompt 使用的摘要列表。
 *
 * 支持四种 summaryFormat（通过 config.json 的 skillsSummaryFormat 配置）：
 *   - "full"       每条完整描述（默认，向后兼容）
 *   - "compact"    每条最多 maxDescriptionLength 字符
 *   - "names-only" 仅列出技能名称
 *   - "hybrid"     高频技能内嵌 compact 摘要，低频技能通过 skill 工具按需查询
 *
 * 搜索目录优先级（低→高，后者覆盖同名 skill）：
 *   1. bundled — /usr/local/lib/node_modules/openclaw/skills（或 OPENCLAW_BUNDLED_SKILLS_DIR）
 *   2. managed — ~/.openclaw/skills/（用户安装的 skill，或 OPENCLAW_STATE_DIR/skills）
 *   3. personal agents — ~/.agents/skills/
 *   4. project agents — <workspace>/.agents/skills/
 *   5. workspace — <workspace>/skills/
 *
 * 解析逻辑：读取 SKILL.md 的 YAML frontmatter（--- ... --- 块），
 * 提取 name / description 字段；若无 frontmatter，则用目录名作为 name，
 * 取文件第一段非空文本（最多 200 字符）作为 description。
 */

const fs = require("fs");
const path = require("path");
const os = require("os");

/**
 * 解析 OpenClaw 配置根目录（与 openclaw/src/utils.ts:resolveConfigDir 对齐）。
 * 优先级：OPENCLAW_STATE_DIR > OPENCLAW_CONFIG_PATH > ~/.openclaw
 */
function resolveConfigDir() {
  const stateDir = (process.env.OPENCLAW_STATE_DIR || "").trim();
  if (stateDir) return stateDir;
  const configPath = (process.env.OPENCLAW_CONFIG_PATH || "").trim();
  if (configPath) return path.dirname(configPath);
  return path.join(os.homedir(), ".openclaw");
}

const DEFAULT_ALWAYS_INCLUDE = [
  "android-abilities",
  "android-filesystem",
];

/**
 * 加载 Skills 摘要文本（格式化为 bullet list）。
 *
 * @param {string} workspaceDir  workspace 根目录
 * @param {object} opts
 * @param {number}   [opts.maxChars=30000]  摘要总字符上限
 * @param {string}   [opts.summaryFormat="full"]  "full" | "compact" | "names-only" | "hybrid"
 * @param {number}   [opts.maxDescriptionLength=60]  compact/hybrid 模式单条描述最大字符
 * @param {string[]} [opts.alwaysIncludeSkills]  hybrid 模式高频技能白名单
 * @param {{ info?: Function, warn?: Function, debug?: Function }} [opts.logger]
 * @returns {Promise<string>}  格式化后的摘要字符串，可直接嵌入 system prompt
 */
async function loadSkillsSummary(workspaceDir, opts = {}) {
  const maxChars = opts.maxChars || 30000;
  const format = opts.summaryFormat || "full";
  const entries = await scanSkillEntries(workspaceDir, opts.logger);

  if (entries.length === 0) {
    opts.logger?.info?.("[prompt-engine/skills] no skill entries after scan; skillsSummary empty");
    return "";
  }

  const nameList = entries.map((e) => e.name);
  const namePreview =
    nameList.length > 40
      ? `${nameList.slice(0, 40).join(", ")} …(+${nameList.length - 40} more)`
      : nameList.join(", ");
  opts.logger?.info?.(
    `[prompt-engine/skills] ${entries.length} unique skill(s), format=${format}: ${namePreview}`
  );

  // ── hybrid 模式：高频内嵌 + 低频缓存 ──
  if (format === "hybrid") {
    return buildHybridSummary(entries, opts);
  }

  // ── names-only 模式 ──
  if (format === "names-only") {
    const names = entries.map((e) => e.name).join(", ");
    return names.length > maxChars ? names.slice(0, maxChars - 3) + "…" : names;
  }

  // ── compact 模式 ──
  if (format === "compact") {
    return buildCompactSummary(entries, opts);
  }

  // ── full 模式（默认，向后兼容）──
  return buildFullSummary(entries, maxChars, opts.logger);
}

/**
 * hybrid 模式：高频技能 compact 内嵌，其余通过 skill 工具按需查询。
 */
function buildHybridSummary(entries, opts) {
  const alwaysInclude = new Set(
    opts.alwaysIncludeSkills || DEFAULT_ALWAYS_INCLUDE
  );
  const maxDescLen = opts.maxDescriptionLength || 60;

  const inlineSkills = [];
  let onDemandCount = 0;

  for (const entry of entries) {
    if (alwaysInclude.has(entry.name)) {
      inlineSkills.push(entry);
    } else {
      onDemandCount++;
    }
  }

  opts.logger?.info?.(
    `[prompt-engine/skills] hybrid: ${inlineSkills.length} inline, ` +
    `${onDemandCount} on-demand (skill tool)`
  );

  const lines = inlineSkills.map((e) => {
    const desc =
      e.description.length > maxDescLen
        ? e.description.slice(0, maxDescLen) + "…"
        : e.description;
    return `- **${e.name}**: ${desc}`;
  });

  lines.push(
    `\n使用技能前先调用 **skill_guide** 工具（command="show", name="技能名"）获取完整指南。` +
    (onDemandCount > 0
      ? `还有 ${onDemandCount} 个技能可通过 skill_guide(command="list") 查看或 skill_guide(command="find", keyword="关键词") 搜索。`
      : "")
  );

  return lines.join("\n");
}

/**
 * compact 模式：所有技能用截断描述列出。
 */
function buildCompactSummary(entries, opts) {
  const maxDescLen = opts.maxDescriptionLength || 60;
  const maxChars = opts.maxChars || 30000;

  const lines = [];
  let totalLen = 0;

  for (const entry of entries) {
    const desc =
      entry.description.length > maxDescLen
        ? entry.description.slice(0, maxDescLen) + "…"
        : entry.description;
    const line = `- **${entry.name}**: ${desc}`;
    if (totalLen + line.length + 1 > maxChars) break;
    lines.push(line);
    totalLen += line.length + 1;
  }

  return lines.join("\n");
}

/**
 * full 模式：原始完整描述（向后兼容）。
 */
function buildFullSummary(entries, maxChars, logger) {
  const lines = [];
  let totalLen = 0;

  for (const entry of entries) {
    const line = `- **${entry.name}**: ${entry.description}`;
    if (totalLen + line.length + 1 > maxChars) break;
    lines.push(line);
    totalLen += line.length + 1;
  }

  if (lines.length < entries.length) {
    logger?.info?.(
      `[prompt-engine/skills] maxChars=${maxChars} truncated summary: ` +
      `${lines.length}/${entries.length} bullet(s) kept`
    );
  }

  return lines.join("\n");
}

/**
 * 扫描 skills 目录，返回去重后的 SkillEntry 列表。
 *
 * @param {string} workspaceDir
 * @param {{ info?: Function, warn?: Function, debug?: Function }} [logger]
 */
async function scanSkillEntries(workspaceDir, logger) {
  const map = new Map(); // name → entry（后来的覆盖先来的）

  // 按原生优先级从低到高排列（last-write-wins）
  const bundledDir =
    (process.env.OPENCLAW_BUNDLED_SKILLS_DIR || "").trim() ||
    "/usr/local/lib/node_modules/openclaw/skills";
  const managedDir = path.join(resolveConfigDir(), "skills");
  const personalAgentsDir = path.join(os.homedir(), ".agents", "skills");
  const projectAgentsDir = path.join(workspaceDir, ".agents", "skills");
  const workspaceSkillsDir = path.join(workspaceDir, "skills");

  const dirsToScan = [
    bundledDir,
    managedDir,
    personalAgentsDir,
    projectAgentsDir,
    workspaceSkillsDir,
  ];

  logger?.info?.(
    `[prompt-engine/skills] scan workspaceDir=${workspaceDir} (${dirsToScan.length} roots)`
  );

  for (const dir of dirsToScan) {
    let subdirs;
    try {
      const entries = await fs.promises.readdir(dir, { withFileTypes: true });
      subdirs = entries.filter((e) => e.isDirectory()).map((e) => e.name);
    } catch (err) {
      logger?.warn?.(
        `[prompt-engine/skills] skip unreadable/missing dir: ${dir} ` +
        `(${err?.code || "ERR"}: ${err?.message || err})`
      );
      continue;
    }

    const visible = subdirs.filter((n) => !n.startsWith("."));
    let accepted = 0;
    for (const skillDirName of subdirs) {
      if (skillDirName.startsWith(".")) continue;
      const skillPath = path.join(dir, skillDirName);
      const entry = await parseSkillEntry(skillPath, skillDirName, logger);
      if (entry) {
        const prev = map.get(entry.name);
        map.set(entry.name, entry);
        accepted++;
        if (prev) {
          logger?.debug?.(
            `[prompt-engine/skills]   override name="${entry.name}" ` +
            `(dir=${skillDirName} wins over earlier source)`
          );
        } else {
          logger?.debug?.(
            `[prompt-engine/skills]   + ${entry.name} (folder=${skillDirName})`
          );
        }
      }
    }

    if (logger) {
      const line =
        `[prompt-engine/skills] dir=${dir} candidates=${visible.length} accepted=${accepted}`;
      if (accepted === 0 && visible.length > 0) {
        logger.info(
          `${line} (all rejected: missing SKILL.md, empty description, or body excerpt; ` +
          "enable debug logs for per-folder detail)"
        );
      } else {
        logger.info(line);
      }
    }
  }

  const merged = Array.from(map.values());
  logger?.info?.(
    `[prompt-engine/skills] merge done: ${merged.length} unique name(s)`
  );
  return merged;
}

/**
 * 解析单个 skill 目录，返回 SkillEntry 或 null。
 *
 * @param {string} skillPath
 * @param {string} dirName
 * @param {{ debug?: Function }} [logger]
 * @returns {Promise<{name: string, description: string, skillMdPath: string, category?: string}|null>}
 */
async function parseSkillEntry(skillPath, dirName, logger) {
  const skillMdPath = path.join(skillPath, "SKILL.md");
  let content;
  try {
    content = await fs.promises.readFile(skillMdPath, "utf-8");
  } catch (err) {
    logger?.debug?.(
      `[prompt-engine/skills]     parse ${dirName}: no SKILL.md (${err?.code || ""} ${err?.message || err})`
    );
    return null;
  }

  const fm = parseFrontmatter(content);
  if (fm) {
    const name = (fm.name || dirName).trim();
    const description = (fm.description || "").trim();
    if (description) {
      return { name, description, skillMdPath, category: fm.category || undefined };
    }
    logger?.debug?.(
      `[prompt-engine/skills]     parse ${dirName}: frontmatter present but description empty; trying body excerpt`
    );
  }

  const description = extractFirstParagraph(content, 200);
  if (!description) {
    logger?.debug?.(
      `[prompt-engine/skills]     parse ${dirName}: no description from frontmatter or body excerpt`
    );
    return null;
  }

  return { name: dirName, description, skillMdPath, category: fm?.category || undefined };
}

/**
 * 解析 YAML frontmatter（--- ... --- 块）。
 * 只做简单的 key: value 解析，不依赖 yaml 库。
 */
function parseFrontmatter(content) {
  const lines = content.split("\n");
  if (lines[0].trim() !== "---") return null;

  const result = {};
  let i = 1;
  while (i < lines.length && lines[i].trim() !== "---") {
    const line = lines[i];
    const colonIdx = line.indexOf(":");
    if (colonIdx > 0) {
      const key = line.slice(0, colonIdx).trim();
      let value = line.slice(colonIdx + 1).trim();
      // 去除引号
      if ((value.startsWith('"') && value.endsWith('"')) ||
          (value.startsWith("'") && value.endsWith("'"))) {
        value = value.slice(1, -1);
      }
      // 多行值（以 | 或 > 开头）：只取第一行
      if (value === "|" || value === ">") {
        i++;
        value = (lines[i] || "").trim();
      }
      result[key] = value;
    }
    i++;
  }

  return Object.keys(result).length > 0 ? result : null;
}

/**
 * 提取 Markdown 正文的第一段有意义文本（跳过标题行和空行）。
 */
function extractFirstParagraph(content, maxLen) {
  // 跳过 frontmatter
  let body = content;
  if (content.trimStart().startsWith("---")) {
    const end = content.indexOf("\n---", 3);
    if (end > 0) body = content.slice(end + 4);
  }

  const lines = body.split("\n");
  const textLines = [];

  for (const line of lines) {
    const trimmed = line.trim();
    if (!trimmed) {
      if (textLines.length > 0) break; // 空行结束段落
      continue;
    }
    if (trimmed.startsWith("#")) continue; // 跳过标题
    textLines.push(trimmed);
    if (textLines.join(" ").length >= maxLen) break;
  }

  const text = textLines.join(" ").slice(0, maxLen);
  return text || null;
}

// 进程级 entries 缓存（供 skill_guide Tool 的 execute 使用）
let _entriesCacheDir = null;
let _entriesCacheResult = null;
let _entriesCacheTs = 0;
const ENTRIES_CACHE_TTL_MS = 60_000;

/**
 * 返回完整的技能条目数组（SkillEntry[]），带 TTL 缓存。
 * skill_guide Tool 的 execute 函数通过此接口获取实时技能列表，
 * 无需重新扫描（与 loadSkillsSummary 共享同一目录，但独立维护条目级缓存）。
 *
 * @param {string} workspaceDir
 * @param {{ info?: Function, warn?: Function, debug?: Function }} [logger]
 * @returns {Promise<Array<{name: string, description: string, skillMdPath: string, category?: string}>>}
 */
async function getAllSkillEntries(workspaceDir, logger) {
  const now = Date.now();
  if (
    _entriesCacheDir === workspaceDir &&
    _entriesCacheResult !== null &&
    now - _entriesCacheTs < ENTRIES_CACHE_TTL_MS
  ) {
    return _entriesCacheResult;
  }
  const entries = await scanSkillEntries(workspaceDir, logger);
  _entriesCacheDir = workspaceDir;
  _entriesCacheResult = entries;
  _entriesCacheTs = now;
  return entries;
}

module.exports = { loadSkillsSummary, scanSkillEntries, getAllSkillEntries };
