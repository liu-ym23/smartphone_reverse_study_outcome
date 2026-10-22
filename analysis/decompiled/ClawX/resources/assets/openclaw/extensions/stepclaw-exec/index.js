/**
 * stepclaw-exec: In-Gateway shell exec + 端侧文件系统工具集
 *
 * 工具参数与《端侧文件系统操作工具集》文档一致，经 stepclaw.exec / POST /plugins/stepclaw-exec/run
 * 传入 JSON：{ "tool": "<name>", ... } 或使用 bash 风格 system.run（argv）。
 *
 * Exposed surfaces:
 *   WebSocket RPC: stepclaw.system.run | stepclaw.system.which | stepclaw.system.<tool>
 *   HTTP (auth=gateway):
 *     POST /plugins/stepclaw-exec/run   body: tool 分发 或 { command: string[] } 走 system.run
 *     POST /plugins/stepclaw-exec/which { command }
 *
 * pull / push（文档语义）:
 *   pull: src[]=设备路径, dst= workspace:... URI → 复制到 Gateway 工作区 /root/.openclaw/workspace
 *   push: src[]= workspace:... , dst=设备路径 → 从工作区复制到设备
 * workspace URI 规则见同目录 TOOL-SPEC.md
 *
 * Security model (MVP):
 *   - argv must be a non-empty string[] (no shell-string injection vector).
 *   - argv[0] basename must match allowedCommands whitelist (config-driven).
 *   - argv.join(' ') checked against denyPatterns (config) + hard-coded baseline
 *     (rm -rf, mkfs, dd if=, curl|sh, wget|sh, sudo, eval $(, bash -i >&, etc.).
 *   - cwd is restricted to a small safe set (/, /tmp, /root, /root/.openclaw).
 *   - env keys must not override sensitive vars (LD_PRELOAD, PATH, HOME, USER).
 *   - timeoutMs is clamped to [100, maxTimeoutMs].
 *
 * Not handled here (out of scope; rely on layers above/below):
 *   - exec-approvals UX (this is a programmatic RPC, not chat-driven).
 *   - SELinux containment (Gateway runs as `system` user with project-wide policy).
 */

const path = require("path");
const fs = require("fs");
const { execSync } = require("child_process");
const crypto = require("crypto");

// ---- Defaults ---------------------------------------------------------------

/** argv[0] basename whitelist. Tightened to scripting languages + a few diag tools. */
const DEFAULT_ALLOWED_COMMANDS = Object.freeze([
  "python", "python3", "node",
  "sh", "bash",
  "echo", "cat", "ls", "pwd", "whoami", "uname",
  "env", "which", "head", "tail", "wc",
]);

/** Hard-coded deny substring patterns; always enforced regardless of config. */
const HARDCODED_DENY_PATTERNS = Object.freeze([
  "rm -rf",
  "mkfs",
  "dd if=",
  "dd of=",
  "curl|sh", "curl | sh", "curl|bash", "curl | bash",
  "wget|sh", "wget | sh", "wget|bash", "wget | bash",
  "sudo ",
  "eval $(",
  "eval \"$(",
  "bash -i >& /dev/tcp/",
  "sh -i >& /dev/tcp/",
  "chmod 777 ",
  "/etc/shadow",
  "/proc/self/mem",
]);

/** Allowed cwd values (resolved real paths). Use empty string == use Gateway cwd. */
const ALLOWED_CWDS = Object.freeze(new Set([
  "",
  "/",
  "/tmp",
  "/root",
  "/root/.openclaw",
  "/var/log/openclaw",
]));

/** Env keys forbidden in the per-call env overlay. Keep the shell's identity. */
const FORBIDDEN_ENV_KEYS = Object.freeze(new Set([
  "LD_PRELOAD", "LD_LIBRARY_PATH",
  "PATH", "HOME", "USER", "LOGNAME", "SHELL",
  "NODE_OPTIONS", "PYTHONSTARTUP",
]));

const DEFAULT_TIMEOUT_MS = 10_000;
const MAX_TIMEOUT_MS = 60_000;
const MIN_TIMEOUT_MS = 100;

// ---- Validators -------------------------------------------------------------

/** @returns {string|null} reason if rejected, null if ok */
function validateArgv(argv) {
  if (!Array.isArray(argv) || argv.length === 0) {
    return "command must be non-empty array";
  }
  for (const part of argv) {
    if (typeof part !== "string") return "command parts must all be strings";
    if (part.length === 0) return "command parts must be non-empty";
    if (part.includes("\0")) return "command parts must not contain NUL";
  }
  return null;
}

function validateCommandHead(argv, allowedCommands) {
  const head = path.basename(String(argv[0] || ""));
  if (!head) return "command head missing";
  // Reject absolute path heads to disable arbitrary binary lookup
  if (String(argv[0]).startsWith("/")) {
    if (!String(argv[0]).startsWith("/usr/")
      && !String(argv[0]).startsWith("/bin/")
      && !String(argv[0]).startsWith("/sbin/")) {
      return "absolute command path must live under /usr, /bin, or /sbin";
    }
  }
  const allow = allowedCommands && allowedCommands.length ? allowedCommands : DEFAULT_ALLOWED_COMMANDS;
  if (!allow.includes(head)) {
    return `command '${head}' not in allowedCommands (${allow.join(", ")})`;
  }
  return null;
}

function validateDenyPatterns(argv, denyPatterns) {
  const joined = argv.join(" ");
  const baseline = HARDCODED_DENY_PATTERNS;
  for (const pat of baseline) {
    if (joined.includes(pat)) return `command matches hard-coded deny pattern: ${pat}`;
  }
  if (Array.isArray(denyPatterns)) {
    for (const pat of denyPatterns) {
      if (typeof pat === "string" && pat.length && joined.includes(pat)) {
        return `command matches deny pattern: ${pat}`;
      }
    }
  }
  return null;
}

function validateCwd(cwd) {
  if (cwd === undefined || cwd === null || cwd === "") return null;
  if (typeof cwd !== "string") return "cwd must be a string";
  if (cwd.includes("..")) return "cwd must not contain '..'";
  if (!ALLOWED_CWDS.has(cwd)) {
    return `cwd '${cwd}' not in allowlist (${[...ALLOWED_CWDS].filter(Boolean).join(", ")})`;
  }
  return null;
}

function validateEnv(env) {
  if (env === undefined || env === null) return null;
  if (typeof env !== "object" || Array.isArray(env)) return "env must be an object";
  for (const key of Object.keys(env)) {
    if (FORBIDDEN_ENV_KEYS.has(key)) return `env key '${key}' is forbidden`;
    if (!/^[A-Za-z_][A-Za-z0-9_]*$/.test(key)) return `env key '${key}' is malformed`;
    const v = env[key];
    if (typeof v !== "string") return `env value for '${key}' must be a string`;
    if (v.includes("\0")) return `env value for '${key}' must not contain NUL`;
  }
  return null;
}

function clampTimeout(requested, maxMs) {
  const max = Number.isFinite(maxMs) ? maxMs : MAX_TIMEOUT_MS;
  if (!Number.isFinite(requested)) return DEFAULT_TIMEOUT_MS;
  return Math.max(MIN_TIMEOUT_MS, Math.min(max, requested));
}

// ---- Plugin -----------------------------------------------------------------

module.exports = {
  id: "stepclaw-exec",
  name: "StepClaw Exec",
  description: "In-Gateway shell exec (replaces external node-host daemon)",

  configSchema: {
    type: "object",
    additionalProperties: false,
    properties: {
      allowedCommands: { type: "array", items: { type: "string" } },
      denyPatterns: { type: "array", items: { type: "string" } },
      defaultTimeoutMs: { type: "integer", minimum: 100, maximum: 600000 },
      maxTimeoutMs: { type: "integer", minimum: 100, maximum: 600000 },
    },
  },

  register: function (api) {
    const log = api.logger || {
      info: (m) => console.log(m),
      warn: (m) => console.warn(m),
      error: (m) => console.error(m),
      debug: (m) => console.log(m),
    };

    const cfg = (api.pluginConfig && typeof api.pluginConfig === "object") ? api.pluginConfig : {};
    const allowedCommands = Array.isArray(cfg.allowedCommands) && cfg.allowedCommands.length
      ? cfg.allowedCommands
      : DEFAULT_ALLOWED_COMMANDS;
    const denyPatterns = Array.isArray(cfg.denyPatterns) ? cfg.denyPatterns : [];
    const defaultTimeoutMs = Number.isFinite(cfg.defaultTimeoutMs) ? cfg.defaultTimeoutMs : DEFAULT_TIMEOUT_MS;
    const maxTimeoutMs = Number.isFinite(cfg.maxTimeoutMs) ? cfg.maxTimeoutMs : MAX_TIMEOUT_MS;

    log.info("[stepclaw-exec] registering");

    const runCommandWithTimeout = api.runtime &&
      api.runtime.system &&
      api.runtime.system.runCommandWithTimeout;
    if (typeof runCommandWithTimeout !== "function") {
      log.error("[stepclaw-exec] api.runtime.system.runCommandWithTimeout unavailable; methods will return error");
    }

    // Shared system.run implementation (used by both WS RPC and HTTP route).
    async function doSystemRun(params) {
      const startedAt = Date.now();
      const argv = params && params.command;
      let err = validateArgv(argv);
      if (err) return { ok: false, error: err };
      err = validateCommandHead(argv, allowedCommands);
      if (err) return { ok: false, error: err };
      err = validateDenyPatterns(argv, denyPatterns);
      if (err) return { ok: false, error: err };
      err = validateCwd(params.cwd);
      if (err) return { ok: false, error: err };
      err = validateEnv(params.env);
      if (err) return { ok: false, error: err };

      const timeoutMs = clampTimeout(
        Number.isFinite(params.timeoutMs) ? params.timeoutMs : defaultTimeoutMs,
        maxTimeoutMs,
      );
      const execOpts = { timeoutMs: timeoutMs };
      if (params.cwd) execOpts.cwd = params.cwd;
      if (params.env) execOpts.env = Object.assign({}, process.env, params.env);
      if (typeof params.stdin === "string") execOpts.input = params.stdin;

      log.debug(
        "[stepclaw-exec] system.run argv=" + JSON.stringify(argv) +
        " timeoutMs=" + timeoutMs +
        (params.cwd ? " cwd=" + params.cwd : ""),
      );

      const result = await runCommandWithTimeout(argv, execOpts);
      return {
        ok: true,
        result: {
          stdout: result.stdout,
          stderr: result.stderr,
          exitCode: result.code,
          signal: result.signal || null,
          termination: result.termination,
          timedOut: result.termination === "timeout" || !!result.noOutputTimedOut,
          elapsedMs: Date.now() - startedAt,
          pid: result.pid || null,
        },
      };
    }

    async function doSystemWhich(params) {
      const cmd = String((params && params.command) || "").trim();
      if (!cmd) return { ok: false, error: "command (string) required" };
      if (cmd.includes("/") || cmd.includes(" ") || cmd.length > 64) {
        return { ok: false, error: "command must be a short basename without '/' or space" };
      }
      const result = await runCommandWithTimeout(
        ["/usr/bin/which", cmd],
        { timeoutMs: 3000 },
      );
      if (result.code !== 0) return { ok: true, result: { found: false, path: null } };
      return { ok: true, result: { found: true, path: result.stdout.trim() } };
    }

    // -----------------------------------------------------------------------
    // WS RPC: stepclaw.system.run
    // -----------------------------------------------------------------------
    api.registerGatewayMethod("stepclaw.system.run", async function (opts) {
      const respond = opts.respond;
      const params = (opts && opts.params) || opts || {};
      try {
        if (typeof runCommandWithTimeout !== "function") {
          return respond(false, { error: "runtime.system.runCommandWithTimeout unavailable" });
        }
        const r = await doSystemRun(params);
        if (!r.ok) return respond(false, { error: r.error });
        respond(true, r.result);
      } catch (e) {
        log.warn("[stepclaw-exec] system.run error: " + (e && e.message ? e.message : String(e)));
        respond(false, { error: e && e.message ? e.message : String(e) });
      }
    });

    // -----------------------------------------------------------------------
    // WS RPC: stepclaw.system.which
    // -----------------------------------------------------------------------
    api.registerGatewayMethod("stepclaw.system.which", async function (opts) {
      const respond = opts.respond;
      const params = (opts && opts.params) || opts || {};
      try {
        if (typeof runCommandWithTimeout !== "function") {
          return respond(false, { error: "runtime.system.runCommandWithTimeout unavailable" });
        }
        const r = await doSystemWhich(params);
        if (!r.ok) return respond(false, { error: r.error });
        respond(true, r.result);
      } catch (e) {
        respond(false, { error: e && e.message ? e.message : String(e) });
      }
    });

    // -----------------------------------------------------------------------
    // HTTP routes (auth=gateway). Bearer-token via Authorization header.
    // Useful for end-to-end smoke tests without the WS connect-challenge dance.
    // -----------------------------------------------------------------------
    async function readJsonBody(req) {
      return await new Promise(function (resolve, reject) {
        const chunks = [];
        req.on("data", function (c) { chunks.push(c); });
        req.on("end", function () {
          const raw = Buffer.concat(chunks).toString("utf8");
          if (!raw) return resolve(null);
          try { resolve(JSON.parse(raw)); } catch (e) { reject(e); }
        });
        req.on("error", reject);
      });
    }
    function writeJson(res, status, body) {
      res.statusCode = status;
      res.setHeader("content-type", "application/json; charset=utf-8");
      res.end(JSON.stringify(body));
    }

    /**
     * 归一化 POST /run 体：合并嵌套 params（与文档 JSON 字段对齐）。
     */
    function normalizePluginRunBody(b) {
      if (!b || typeof b !== "object") return b;
      const o = Object.assign({}, b);
      if (b.params && typeof b.params === "object") Object.assign(o, b.params);
      return o;
    }

    api.registerHttpRoute({
      path: "/plugins/stepclaw-exec/run",
      auth: "gateway",
      match: "exact",
      handler: async function (req, res) {
        if (req.method !== "POST") return writeJson(res, 405, { error: "method not allowed" });
        let body;
        try { body = await readJsonBody(req); } catch (_) { return writeJson(res, 400, { error: "invalid JSON body" }); }
        if (!body || typeof body !== "object") return writeJson(res, 400, { error: "body required" });
        body = normalizePluginRunBody(body);

        // stepclaw tool dispatch: body.tool = "ls" | "stat" | ... routes to tool handler
        if (body.tool && typeof body.tool === "string" && STEPCLAW_TOOLS[body.tool]) {
          const r = STEPCLAW_TOOLS[body.tool](body);
          writeJson(res, r.ok ? 200 : 400, r);
          return true;
        }

        try {
          const r = await doSystemRun(body);
          if (!r.ok) return writeJson(res, 400, { error: r.error });
          writeJson(res, 200, r.result);
        } catch (e) {
          writeJson(res, 500, { error: e && e.message ? e.message : String(e) });
        }
        return true;
      },
    });

    api.registerHttpRoute({
      path: "/plugins/stepclaw-exec/which",
      auth: "gateway",
      match: "exact",
      handler: async function (req, res) {
        if (req.method !== "POST") return writeJson(res, 405, { error: "method not allowed" });
        let body;
        try { body = await readJsonBody(req); } catch (_) { return writeJson(res, 400, { error: "invalid JSON body" }); }
        try {
          const r = await doSystemWhich(body || {});
          if (!r.ok) return writeJson(res, 400, { error: r.error });
          writeJson(res, 200, r.result);
        } catch (e) {
          writeJson(res, 500, { error: e && e.message ? e.message : String(e) });
        }
        return true;
      },
    });

    // =================================================================
    //  Filesystem tools (端侧文件系统操作工具集)
    //  ls / stat / find / mkdir / rm / mv / cp / read / write / edit / pull / push
    // =================================================================

    const WORKSPACE_ROOT = "/root/.openclaw/workspace";
    const MAX_READ_BYTES = 2 * 1024 * 1024;
    const MAX_READ_LINES = 2000;
    const MAX_WRITE_BYTES = 8 * 1024 * 1024;
    const FIND_MAX_RESULTS = 1000;

    const FS_ERROR_MAP = {
      ENOENT: "E_NOT_FOUND", EEXIST: "E_EXISTS", EACCES: "E_PERMISSION",
      EPERM: "E_PERMISSION", EISDIR: "E_IS_A_DIR", ENOTDIR: "E_NOT_A_DIR",
      ENOTEMPTY: "E_NOT_EMPTY",
    };
    function fsErr(e) { return FS_ERROR_MAP[e.code] || "E_INTERNAL"; }
    function toolOk(tool, result) { return { ok: true, tool, result }; }
    function toolFail(tool, code, message, extra) {
      const err = Object.assign({ code, message, exitCode: 1, stderr: message || "" }, extra || {});
      return { ok: false, tool, error: err };
    }
    function reqStr(p, k) {
      const v = p[k]; if (typeof v === "string" && v.length) return v;
      throw { _c: "E_INVALID_PARAM", _m: `'${k}' required (string)` };
    }
    function reqArr(p, k) {
      const v = p[k]; if (Array.isArray(v) && v.length && v.every(s => typeof s === "string")) return v;
      throw { _c: "E_INVALID_PARAM", _m: `'${k}' required (string[])` };
    }
    function optB(p, k, d) { const v = p[k]; return typeof v === "boolean" ? v : d; }
    function optI(p, k, d) { const v = p[k]; return typeof v === "number" && Number.isInteger(v) ? v : d; }
    function optS(p, k, d) { const v = p[k]; return typeof v === "string" && v.length ? v : d; }
    function vPath(p) {
      if (!p || typeof p !== "string") throw { _c: "E_INVALID_PATH", _m: "empty path" };
      const r = path.resolve(p); if (r.includes("\0")) throw { _c: "E_INVALID_PATH", _m: "null in path" };
      return r;
    }
    function fType(s) { return s.isFile() ? "file" : s.isDirectory() ? "dir" : s.isSymbolicLink() ? "symlink" : "other"; }
    function fMode(m) { return "0" + (m & 0o7777).toString(8); }
    function wsPath(u) {
      if (u.startsWith("workspace:/")) return path.join(WORKSPACE_ROOT, u.slice(11));
      if (u.startsWith("workspace:")) return path.join(WORKSPACE_ROOT, u.slice(10));
      return u;
    }
    function esc(s) { return "'" + s.replace(/'/g, "'\\''") + "'"; }

    /** 文档 human_readable (-h) */
    function humanSize(bytes) {
      const u = ["B", "K", "M", "G", "T"];
      let n = Number(bytes), i = 0;
      while (n >= 1024 && i < u.length - 1) { n /= 1024; i++; }
      return (i === 0 ? String(Math.round(n)) : n.toFixed(1)) + u[i];
    }

    function runTool(tool, fn) {
      return function (params) {
        try { return fn(params); } catch (e) {
          if (e._c) return toolFail(tool, e._c, e._m);
          return toolFail(tool, fsErr(e), e.message);
        }
      };
    }

    // ---- ls（参数与文档一致：all / almost_all / long / human_readable / recursive / sort）----
    const doLs = runTool("ls", function (p) {
      const paths = reqArr(p, "paths");
      const showAll = optB(p, "all", false);
      const almostAll = optB(p, "almost_all", false);
      const longFmt = optB(p, "long", true);
      const humanReadable = optB(p, "human_readable", false);
      const recursive = optB(p, "recursive", false);
      const sortBy = optS(p, "sort", "name");
      const entries = [];
      for (const pp of paths) lsCollect(vPath(pp), entries, showAll, almostAll, recursive);
      if (sortBy === "name") entries.sort((a, b) => a.name.localeCompare(b.name));
      else if (sortBy === "mtime") entries.sort((a, b) => b.mtime - a.mtime);
      else if (sortBy === "size") entries.sort((a, b) => b.size - a.size);
      else if (sortBy === "none") { /* keep discovery order */ }
      if (longFmt) {
        for (const e of entries) {
          if (!humanReadable) continue;
          e.size_human = humanSize(e.size);
        }
      } else {
        for (const e of entries) {
          delete e.mode;
          delete e.size;
          delete e.mtime;
          delete e.target;
        }
      }
      return toolOk("ls", { entries });
    });
    function lsCollect(dir, out, all, almostAll, rec) {
      let st; try { st = fs.statSync(dir); } catch (e) { throw e; }
      if (!st.isDirectory()) { out.push(lsEntry(dir, fs.lstatSync(dir))); return; }
      for (const n of fs.readdirSync(dir)) {
        if (!all && !almostAll && n.startsWith(".")) continue;
        const f = path.join(dir, n);
        try { const s = fs.lstatSync(f); out.push(lsEntry(f, s));
          if (rec && s.isDirectory()) lsCollect(f, out, all, almostAll, rec);
        } catch (_) {}
      }
    }
    function lsEntry(f, s) {
      const e = { path: f, name: path.basename(f), type: fType(s), size: s.size,
        mode: fMode(s.mode), mtime: Math.floor(s.mtimeMs / 1000), target: null };
      if (s.isSymbolicLink()) try { e.target = fs.readlinkSync(f); } catch (_) {}
      return e;
    }

    // ---- stat（file + dereference；file_system → 文件系统信息）----
    const doStatFs = runTool("stat", function (p) {
      const file = reqStr(p, "file");
      const deref = optB(p, "dereference", true);
      const fileSystem = optB(p, "file_system", false);
      const r = vPath(file);
      if (fileSystem) {
        let sfs;
        try {
          sfs = typeof fs.statfsSync === "function" ? fs.statfsSync(r) : null;
        } catch (e) { throw e; }
        if (!sfs) return toolFail("stat", "E_INTERNAL", "fs.statfsSync unavailable in this Node runtime");
        return toolOk("stat", {
          path: r,
          file_system: {
            type: sfs.type,
            bsize: sfs.bsize,
            blocks: sfs.blocks,
            bfree: sfs.bfree,
            bavail: sfs.bavail,
            files: sfs.files,
            ffree: sfs.ffree,
          },
        });
      }
      const st = deref ? fs.statSync(r) : fs.lstatSync(r);
      return toolOk("stat", { path: r, type: fType(st), size: st.size, mode: fMode(st.mode),
        uid: st.uid, gid: st.gid, mtime: Math.floor(st.mtimeMs / 1000),
        ctime: Math.floor(st.ctimeMs / 1000), atime: Math.floor(st.atimeMs / 1000) });
    });

    // ---- find ----
    const doFindFs = runTool("find", function (p) {
      const paths = reqArr(p, "paths"), nameP = optS(p, "name", null),
        inameP = optS(p, "iname", null), pathP = optS(p, "path", null),
        typeF = optS(p, "type", null), maxD = optI(p, "maxdepth", Infinity),
        minD = optI(p, "mindepth", 0), sizeE = optS(p, "size", null),
        mtimeD = optI(p, "mtime", null), mminM = optI(p, "mmin", null),
        newerF = optS(p, "newer", null);
      let newerMs = null;
      if (newerF) newerMs = fs.statSync(vPath(newerF)).mtimeMs;
      const matches = []; let truncated = false;
      const filters = { nameP, inameP, pathP, typeF, maxD, minD, sizeE, mtimeD, mminM, newerMs };
      for (const pp of paths) {
        walkFind(vPath(pp), 0, filters, matches, () => { if (matches.length >= FIND_MAX_RESULTS) { truncated = true; return true; } return false; });
        if (truncated) break;
      }
      return toolOk("find", { matches, truncated });
    });
    function walkFind(dir, depth, f, out, stop) {
      if (stop() || depth > f.maxD) return;
      let ents; try { ents = fs.readdirSync(dir, { withFileTypes: true }); } catch (_) { return; }
      for (const e of ents) {
        if (stop()) return;
        const full = path.join(dir, e.name);
        let st; try { st = fs.lstatSync(full); } catch (_) { continue; }
        if (depth + 1 >= f.minD && findMatch(full, e, st, f))
          out.push({ path: full, type: fType(st), size: st.size, mtime: Math.floor(st.mtimeMs / 1000) });
        if (e.isDirectory()) walkFind(full, depth + 1, f, out, stop);
      }
    }
    function findMatch(fp, e, st, f) {
      if (f.typeF) { if (f.typeF === "f" && !st.isFile()) return false; if (f.typeF === "d" && !st.isDirectory()) return false; if (f.typeF === "l" && !st.isSymbolicLink()) return false; }
      if (f.nameP && !globM(e.name, f.nameP, false)) return false;
      if (f.inameP && !globM(e.name, f.inameP, true)) return false;
      if (f.pathP && !globM(fp, f.pathP, false)) return false;
      if (f.sizeE && !matchSz(st.size, f.sizeE)) return false;
      if (f.mtimeD !== null) { const d = (Date.now() - st.mtimeMs) / 86400000; if (f.mtimeD >= 0 ? d < f.mtimeD : d > -f.mtimeD) return false; }
      if (f.mminM !== null) { const m = (Date.now() - st.mtimeMs) / 60000; if (f.mminM >= 0 ? m < f.mminM : m > -f.mminM) return false; }
      if (f.newerMs !== null && st.mtimeMs <= f.newerMs) return false;
      return true;
    }
    function globM(s, pat, ci) {
      let re = pat.replace(/[.+^${}()|[\]\\]/g, "\\$&").replace(/\*/g, ".*").replace(/\?/g, ".");
      return new RegExp("^" + re + "$", ci ? "i" : "").test(s);
    }
    function matchSz(sz, expr) {
      const m = expr.match(/^([+-]?)(\d+)([cwbkMG]?)$/); if (!m) return true;
      const mul = { c: 1, w: 2, b: 512, k: 1024, M: 1048576, G: 1073741824 };
      let val = parseInt(m[2], 10) * (mul[m[3]] || 512);
      if (m[1] === "+") return sz > val; if (m[1] === "-") return sz < val;
      return sz >= val - (mul[m[3]] || 512) && sz < val + (mul[m[3]] || 512);
    }

    // ---- mkdir ----
    const doMkdirFs = runTool("mkdir", function (p) {
      const paths = reqArr(p, "paths"), parents = optB(p, "parents", true),
        mode = optS(p, "mode", null);
      const created = [];
      for (const pp of paths) { const r = vPath(pp); const o = { recursive: parents }; if (mode) o.mode = parseInt(mode, 8); fs.mkdirSync(r, o); created.push(r); }
      return toolOk("mkdir", { created });
    });

    // ---- rm ----
    const doRmFs = runTool("rm", function (p) {
      const paths = reqArr(p, "paths"), recursive = optB(p, "recursive", false),
        force = optB(p, "force", false), dirOpt = optB(p, "dir", false);
      const removed = [], skipped = [];
      for (const pp of paths) {
        const r = vPath(pp);
        try {
          const st = fs.lstatSync(r);
          if (st.isDirectory() && !recursive && !dirOpt)
            throw Object.assign(new Error(r + " is a directory"), { code: "EISDIR" });
          if (st.isDirectory() && dirOpt && !recursive) fs.rmdirSync(r);
          else fs.rmSync(r, { recursive, force });
          removed.push(r);
        } catch (e) { if (e.code === "ENOENT" && force) { skipped.push(r); continue; } throw e; }
      }
      return toolOk("rm", { removed, skipped });
    });

    // ---- mv ----
    const doMvFs = runTool("mv", function (p) {
      const srcList = reqArr(p, "src"), dst = reqStr(p, "dst"),
        force = optB(p, "force", false), noClobber = optB(p, "no_clobber", false);
      const rDst = vPath(dst), moved = [];
      for (const s of srcList) {
        const rSrc = vPath(s);
        let target = rDst;
        try { if (fs.statSync(rDst).isDirectory()) target = path.join(rDst, path.basename(rSrc)); } catch (_) {}
        if (noClobber && fs.existsSync(target)) throw { _c: "E_EXISTS", _m: target + " exists (no_clobber)" };
        if (!force && !noClobber && fs.existsSync(target)) throw { _c: "E_EXISTS", _m: target + " exists" };
        try { fs.renameSync(rSrc, target); } catch (e) {
          if (e.code === "EXDEV") { execSync("cp -a " + esc(rSrc) + " " + esc(target)); fs.rmSync(rSrc, { recursive: true, force: true }); } else throw e;
        }
        moved.push({ from: rSrc, to: target });
      }
      return toolOk("mv", { moved });
    });

    // ---- cp ----
    const doCpFs = runTool("cp", function (p) {
      const srcList = reqArr(p, "src"), dst = reqStr(p, "dst"),
        recursive = optB(p, "recursive", false), force = optB(p, "force", false),
        noClobber = optB(p, "no_clobber", false), preserve = optB(p, "preserve", false),
        deref = optB(p, "dereference", true), archive = optB(p, "archive", false);
      const rDst = vPath(dst), copied = [];
      for (const s of srcList) {
        const rSrc = vPath(s);
        const st = fs.lstatSync(rSrc);
        if (st.isDirectory() && !recursive && !archive)
          throw Object.assign(new Error(rSrc + " is a directory"), { code: "EISDIR" });
        let target = rDst;
        try { if (fs.statSync(rDst).isDirectory()) target = path.join(rDst, path.basename(rSrc)); } catch (_) {}
        if (noClobber && fs.existsSync(target)) throw { _c: "E_EXISTS", _m: target + " exists (no_clobber)" };
        const fl = []; if (archive) fl.push("-a"); else { if (recursive) fl.push("-r"); if (preserve) fl.push("-p"); if (deref) fl.push("-L"); }
        if (force) fl.push("-f"); if (noClobber) fl.push("-n");
        execSync("cp " + fl.join(" ") + " " + esc(rSrc) + " " + esc(target));
        let sz = 0; try { sz = fs.statSync(target).size; } catch (_) {}
        copied.push({ from: rSrc, to: target, size: sz });
      }
      return toolOk("cp", { copied });
    });

    // ---- read ----
    const doReadFs = runTool("read", function (p) {
      const fp = vPath(reqStr(p, "file_path")), enc = optS(p, "encoding", "utf-8");
      const st = fs.statSync(fp);
      if (st.isDirectory()) throw Object.assign(new Error("is a directory"), { code: "EISDIR" });
      if (enc === "base64") {
        const off = optI(p, "offset", 0), lim = optI(p, "limit", MAX_READ_BYTES);
        if (st.size > MAX_READ_BYTES && lim >= MAX_READ_BYTES)
          return toolFail("read", "E_TOO_LARGE", "file " + st.size + " bytes; use offset/limit");
        const fd = fs.openSync(fp, "r"), buf = Buffer.alloc(Math.min(lim, st.size - off));
        const n = fs.readSync(fd, buf, 0, buf.length, off); fs.closeSync(fd);
        return toolOk("read", { file_path: fp, encoding: "base64", size: st.size,
          content: buf.slice(0, n).toString("base64"), offset: off, returned: n, eof: off + n >= st.size });
      }
      const raw = fs.readFileSync(fp, "utf-8"), lines = raw.split("\n");
      const off = optI(p, "offset", 0), lim = optI(p, "limit", MAX_READ_LINES);
      if (st.size > MAX_READ_BYTES && lines.length > MAX_READ_LINES)
        return toolFail("read", "E_TOO_LARGE", "file " + st.size + " bytes / " + lines.length + " lines; use offset/limit");
      const slice = lines.slice(off, off + lim);
      return toolOk("read", { file_path: fp, encoding: "utf-8", size: st.size,
        content: slice.join("\n"), offset: off, returned: slice.length, eof: off + slice.length >= lines.length });
    });

    // ---- write ----
    const doWriteFs = runTool("write", function (p) {
      const fp = vPath(reqStr(p, "file_path")), content = reqStr(p, "content"),
        enc = optS(p, "encoding", "utf-8");
      const dir = path.dirname(fp);
      if (!fs.existsSync(dir)) return toolFail("write", "E_NOT_FOUND", "parent dir " + dir + " missing");
      try { const s = fs.statSync(fp); if (s.isDirectory()) throw Object.assign(new Error("is a dir"), { code: "EISDIR" }); } catch (e) { if (e.code !== "ENOENT") throw e; }
      const buf = enc === "base64" ? Buffer.from(content, "base64") : Buffer.from(content, "utf-8");
      if (buf.length > MAX_WRITE_BYTES) return toolFail("write", "E_TOO_LARGE", buf.length + " bytes > " + MAX_WRITE_BYTES + "; use push");
      const created = !fs.existsSync(fp);
      fs.writeFileSync(fp, buf);
      return toolOk("write", { file_path: fp, size: buf.length, created });
    });

    // ---- edit ----
    const doEditFs = runTool("edit", function (p) {
      const fp = vPath(reqStr(p, "file_path")), oldStr = reqStr(p, "old_string");
      const newStr = p.new_string; if (typeof newStr !== "string") throw { _c: "E_INVALID_PARAM", _m: "'new_string' required" };
      const replaceAll = optB(p, "replace_all", false);
      let content = fs.readFileSync(fp, "utf-8");
      const count = content.split(oldStr).length - 1;
      if (count === 0) return toolFail("edit", "E_INVALID_PARAM", "old_string not found");
      if (!replaceAll && count > 1) return toolFail("edit", "E_INVALID_PARAM", "old_string found " + count + " times; use replace_all=true");
      if (replaceAll) { content = content.split(oldStr).join(newStr); } else { content = content.replace(oldStr, newStr); }
      fs.writeFileSync(fp, content, "utf-8");
      return toolOk("edit", { file_path: fp, replacements: replaceAll ? count : 1 });
    });

    /** 文档：Pull 设备路径 → workspace URI；Push workspace URI → 设备路径 */
    function toWorkspaceDisplayPath(absResolvedPath) {
      const norm = path.resolve(absResolvedPath);
      const root = path.resolve(WORKSPACE_ROOT);
      if (norm === root || norm.startsWith(root + path.sep)) {
        const rel = norm === root ? "" : norm.slice(root.length + 1);
        return "workspace:/" + rel.replace(/\\/g, "/");
      }
      return norm;
    }

    /** 极简通配：仅 basename 含 * ? [...] 时在父目录匹配（与文档「支持通配符」对齐） */
    function expandGlobPatterns(p) {
      if (!p || typeof p !== "string") return [];
      if (!/[*\?\[]/.test(path.basename(p))) return [vPath(p)];
      const dir = path.dirname(p);
      const pat = path.basename(p);
      let names;
      try {
        if (!fs.statSync(dir).isDirectory()) return [];
        names = fs.readdirSync(dir);
      } catch (e) { throw e; }
      const out = [];
      for (const n of names) {
        if (globM(n, pat, false)) out.push(vPath(path.join(dir, n)));
      }
      return out;
    }

    // ---- pull：设备端 src → 服务端工作区 dst（workspace:...）----
    const doPullFs = runTool("pull", function (p) {
      const srcList = reqArr(p, "src");
      const dstUri = reqStr(p, "dst");
      const recursive = optB(p, "recursive", false);
      const preserve = optB(p, "preserve", false);
      const noClobber = optB(p, "no_clobber", false);
      const sha = optS(p, "expected_sha256", null);
      const rDstBase = wsPath(dstUri);
      fs.mkdirSync(path.dirname(rDstBase), { recursive: true });
      const transferred = [];
      const collectSrc = [];
      for (const s of srcList) collectSrc.push(...expandGlobPatterns(s));
      if (!collectSrc.length) return toolFail("pull", "E_NOT_FOUND", "no paths matched src / glob");
      for (const rSrc of collectSrc) {
        const st = fs.lstatSync(rSrc);
        if (st.isDirectory() && !recursive)
          return toolFail("pull", "E_IS_A_DIR", rSrc + "; set recursive=true");
        let target = rDstBase;
        try {
          if (fs.statSync(rDstBase).isDirectory()) target = path.join(rDstBase, path.basename(rSrc));
        } catch (_) {}
        if (noClobber && fs.existsSync(target)) return toolFail("pull", "E_EXISTS", target + " exists (no_clobber)");
        const t0 = Date.now();
        const fl = [];
        if (preserve) fl.push("-a"); else if (recursive) fl.push("-r");
        execSync("cp " + fl.filter(Boolean).join(" ") + " " + esc(rSrc) + " " + esc(target));
        let sz = 0;
        let h = null;
        try {
          const ts = fs.statSync(target);
          sz = ts.size;
          if (ts.isFile()) h = crypto.createHash("sha256").update(fs.readFileSync(target)).digest("hex");
        } catch (_) {}
        if (sha && h && h !== sha) return toolFail("pull", "E_TRANSFER", "sha256 mismatch");
        transferred.push({
          src: rSrc,
          dst: toWorkspaceDisplayPath(target),
          size: sz,
          sha256: h,
          duration_ms: Date.now() - t0,
        });
      }
      return toolOk("pull", { transferred });
    });

    // ---- push：服务端工作区 src → 设备端 dst ----
    const doPushFs = runTool("push", function (p) {
      const srcList = reqArr(p, "src");
      const dst = reqStr(p, "dst");
      const recursive = optB(p, "recursive", false);
      const preserve = optB(p, "preserve", false);
      const noClobber = optB(p, "no_clobber", false);
      const makeParents = optB(p, "make_parents", true);
      const sha = optS(p, "expected_sha256", null);
      const rDst = vPath(dst);
      if (makeParents) fs.mkdirSync(path.dirname(rDst), { recursive: true });
      const transferred = [];
      for (const s of srcList) {
        const rSrc = vPath(wsPath(s));
        const st = fs.lstatSync(rSrc);
        if (st.isDirectory() && !recursive)
          return toolFail("push", "E_IS_A_DIR", rSrc + "; set recursive=true");
        let target = rDst;
        try {
          if (fs.statSync(rDst).isDirectory()) target = path.join(rDst, path.basename(rSrc));
        } catch (_) {}
        if (noClobber && fs.existsSync(target)) return toolFail("push", "E_EXISTS", target + " exists (no_clobber)");
        if (makeParents) fs.mkdirSync(path.dirname(target), { recursive: true });
        const t0 = Date.now();
        const fl = [];
        if (preserve) fl.push("-a"); else if (recursive) fl.push("-r");
        execSync("cp " + fl.filter(Boolean).join(" ") + " " + esc(rSrc) + " " + esc(target));
        let sz = 0;
        let h = null;
        try {
          const ts = fs.statSync(target);
          sz = ts.size;
          if (ts.isFile()) h = crypto.createHash("sha256").update(fs.readFileSync(target)).digest("hex");
        } catch (_) {}
        if (sha && h && h !== sha) return toolFail("push", "E_TRANSFER", "sha256 mismatch");
        transferred.push({
          src: s.startsWith("workspace") ? s : toWorkspaceDisplayPath(rSrc),
          dst: target,
          size: sz,
          sha256: h,
          duration_ms: Date.now() - t0,
        });
      }
      return toolOk("push", { transferred });
    });

    // ---- Register all tools ----
    const STEPCLAW_TOOLS = {
      ls: doLs, stat: doStatFs, find: doFindFs, mkdir: doMkdirFs,
      rm: doRmFs, mv: doMvFs, cp: doCpFs,
      read: doReadFs, write: doWriteFs, edit: doEditFs,
      pull: doPullFs, push: doPushFs,
    };

    for (const [name, handler] of Object.entries(STEPCLAW_TOOLS)) {
      api.registerGatewayMethod("stepclaw.system." + name, async function (opts) {
        const respond = opts.respond;
        const params = (opts && opts.params) || opts || {};
        try { const r = handler(params); respond(r.ok, r.ok ? r : r); }
        catch (e) { respond(false, { ok: false, tool: name, error: { code: "E_INTERNAL", message: e.message } }); }
      });
    }

    log.info("[stepclaw-exec] registered: system.run, system.which, " + Object.keys(STEPCLAW_TOOLS).map(function(n){return "system."+n}).join(", "));
  },
};
