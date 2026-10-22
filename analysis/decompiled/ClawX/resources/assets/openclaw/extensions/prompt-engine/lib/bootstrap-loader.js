"use strict";
/**
 * bootstrap-loader.js
 *
 * 加载 workspace 中的 Bootstrap 文件（SOUL.md、AGENTS.md 等）。
 * 复用 OpenClaw 的截断策略：head 70% + tail 20%，超出预算截断末尾文件。
 */

const fs = require("fs");
const path = require("path");
const { resolveTierConfig } = require("./tier-section-matrix");

// 标准 Bootstrap 文件名，按加载顺序排列（与 OpenClaw workspace.ts 一致）
const BOOTSTRAP_FILENAMES = [
  "AGENTS.md",
  "SOUL.md",
  "TOOLS.md",
  "IDENTITY.md",
  "USER.md",
  "HEARTBEAT.md",
  "BOOTSTRAP.md",
  "MEMORY.md",
];

// subagent/cron 会话只加载白名单文件（与 OpenClaw filterBootstrapFilesForSession 一致）
const MINIMAL_ALLOWLIST = new Set(["SOUL.md", "IDENTITY.md", "AGENTS.md"]);

const HEAD_RATIO = 0.7;
const TAIL_RATIO = 0.2;
const MIN_FILE_BUDGET = 64;

// 实质内容少于此字符数的文件视为"空文件"，不注入 prompt
const MIN_EFFECTIVE_CHARS = 50;

/**
 * 判断文件是否实质上为空（只含标题、注释、空行、占位符、模板提示）。
 * 去掉这些后剩余内容 < MIN_EFFECTIVE_CHARS 则视为空。
 */
function isEffectivelyEmpty(content) {
  const lines = content.split(/\r?\n/);
  let effectiveChars = 0;

  for (const line of lines) {
    const trimmed = line.trim();
    // 跳过空行
    if (!trimmed) continue;
    // 跳过 Markdown 标题行（# ## ### 等，后接空格）
    if (/^#{1,6}\s/.test(trimmed)) continue;
    // 跳过注释行（# 后直接接内容，常见于 HEARTBEAT.md 等）
    if (/^#\s*[^#]/.test(trimmed) && trimmed.length < 80) continue;
    // 跳过 HTML 注释
    if (trimmed.startsWith("<!--") && trimmed.endsWith("-->")) continue;
    // 跳过占位符行（被下划线包裹的斜体提示）
    if (/^_.*_$/.test(trimmed)) continue;
    // 跳过只含分隔线的行
    if (/^[-=]{3,}$/.test(trimmed)) continue;
    // 跳过空的列表项（只有 key 没有 value，如 "- **称呼：**"）
    if (/^[-*]\s*\*\*[^*]+：\*\*\s*$/.test(trimmed)) continue;
    // 跳过模板提示性列表项
    if (/^[-*]\s*(记什么|在需要时|随着交流|保持此文件|设备型号|常用 App|用户偏好|家庭|其他环境)/.test(trimmed)) continue;
    // 跳过模板说明性句子
    if (/^(技能定义了|在需要时随手补充)/.test(trimmed)) continue;

    effectiveChars += trimmed.length;
    if (effectiveChars >= MIN_EFFECTIVE_CHARS) return false;
  }

  return true;
}

/**
 * 加载 Bootstrap 文件。
 *
 * @param {string} workspaceDir  workspace 根目录
 * @param {object} opts
 * @param {number} [opts.maxChars=20000]       单文件最大字符
 * @param {number} [opts.totalMaxChars=150000]  所有文件总字符上限
 * @param {boolean} [opts.minimal=false]        是否 minimal 模式（subagent/cron）
 * @param {string}  [opts.promptTier]           Prompt Tier（LITE/STANDARD/FULL），用于白名单过滤
 * @returns {Promise<Array<{name: string, content: string}>>}
 */
async function loadBootstrapFiles(workspaceDir, opts = {}) {
  const maxChars = opts.maxChars || 20000;
  const totalMaxChars = opts.totalMaxChars || 150000;
  const minimal = opts.minimal || false;
  const promptTier = opts.promptTier;
  const tierOverrides = opts.tierOverrides;

  let filenames;
  if (minimal) {
    // minimal 模式优先级高于 promptTier（会话级控制优先于任务级控制）
    filenames = BOOTSTRAP_FILENAMES.filter((n) => MINIMAL_ALLOWLIST.has(n));
  } else if (promptTier) {
    const tierConfig = resolveTierConfig(promptTier, tierOverrides);
    if (tierConfig.bootstrapWhitelist) {
      const whitelist = new Set(tierConfig.bootstrapWhitelist);
      filenames = BOOTSTRAP_FILENAMES.filter((n) => whitelist.has(n));
    } else {
      filenames = BOOTSTRAP_FILENAMES;
    }
  } else {
    filenames = BOOTSTRAP_FILENAMES;
  }

  const result = [];
  let remainingTotal = totalMaxChars;

  for (const name of filenames) {
    if (remainingTotal <= 0) break;

    const filePath = path.join(workspaceDir, name);
    let rawContent;
    try {
      rawContent = await fs.promises.readFile(filePath, "utf-8");
    } catch {
      continue;
    }

    // 跳过完全空或实质上空的文件
    if (!rawContent.trim() || isEffectivelyEmpty(rawContent)) continue;

    const fileMax = Math.min(maxChars, remainingTotal);
    const trimmed = trimContent(rawContent, name, fileMax);

    const content = trimmed.length > remainingTotal
      ? trimmed.slice(0, remainingTotal - 3) + "..."
      : trimmed;

    if (content.trim()) {
      result.push({ name, content });
      remainingTotal -= content.length;
    }
  }

  return result;
}

/**
 * 按 head/tail 策略截断单个文件内容。
 * head 保留前 70%，tail 保留后 20%，中间用省略提示替代。
 */
function trimContent(content, filename, maxChars) {
  if (content.length <= maxChars) return content;

  const headChars = Math.floor(maxChars * HEAD_RATIO);
  const tailChars = Math.floor(maxChars * TAIL_RATIO);
  const omitNote = `\n\n[... ${filename} 中间部分已省略 ...]\n\n`;

  const head = content.slice(0, headChars);
  const tail = content.slice(content.length - tailChars);
  return head + omitNote + tail;
}

module.exports = { loadBootstrapFiles, BOOTSTRAP_FILENAMES, MINIMAL_ALLOWLIST };
