---
name: openclaw-config
description: |
  安全编辑和校验 OpenClaw Gateway 配置（openclaw.json / JSON5）。
  触发场景：添加/修改/删除配置项（gateway.*、channels.*、models.*、agents.*、tools.*、skills.*、plugins.*）、
  排查 Gateway 启动失败或 openclaw doctor 报告的 schema 错误、配置新的 channel 或 provider。
  核心原则：先读后写、增量修改、验证闭环；理解为什么 CLI/RPC 比直接文件操作更安全。
metadata:
  openclaw:
    emoji: "⚙️"
---

# OpenClaw 配置管理

安全编辑 `openclaw.json` 的 schema-first 工作流。修改配置前阅读本文档，
避免 schema 不匹配导致 Gateway 无法启动或安全策略被意外改变。

## ⛔ READONLY 字段 — 修改会被系统回滚（不要尝试）

以下字段受 StepClaw 应用层锁定保护，**config.patch / config.set 对这些字段的写入会被静默回滚**。
即使命令返回成功，Gateway 重启后应用层会从 hardcoded 值覆盖回来，导致用户以为改好了但实际没生效。
**不要浪费时间尝试修改这些字段，直接告诉用户不可改。**

被锁定的字段：`gateway.bind` · `gateway.port` · `gateway.mode` · `gateway.auth.*` · `gateway.tls.*` · `gateway.experimental` · `server.apiKey` · `server.apiUrl`

当用户要求修改上述字段时，**直接回复不可修改，不要调用任何 config 写入命令**：

> ⚠️ `gateway.bind` 是平台锁定字段，StepClaw 应用层会在每次 Gateway 启动时将其强制覆盖为 `"loopback"`。
> 即使现在修改成功，重启后也会被回滚。这个字段无法通过配置修改来更改。
> 如果你需要从局域网访问 Gateway，可以使用 `adb forward tcp:18789 tcp:18789` 端口转发。

## 三步闭环工作流

所有配置修改都遵循 READ → PATCH → VERIFY 三步：

### 1. READ — 读取当前配置

先理解现有配置结构，不要盲写。

- Gateway 在线：`openclaw gateway call config.get --params '{}'`
- Gateway 离线：`openclaw config get`

### 2. PATCH — 最小化增量修改

用增量方式修改，不要全量替换。

- Gateway 在线（推荐）：`openclaw gateway call config.patch --params '{ "channels": { "feishu": { "enabled": true } } }'`
  - 热更新，即时生效，不需要重启
- Gateway 离线：`openclaw config set <dot.path> <value> [--json]`
  - 值为字符串时注意内层双引号：`openclaw config set 'channels.feishu.accounts.default.appId' '"app_xxx"' --json`

**不要使用 `config.apply`**（全量替换），除非明确需要重置整个配置且已获得用户确认。

### 3. VERIFY — 验证修改结果

修改后必须验证：

```bash
openclaw doctor                        # schema 校验 + 健康检查
openclaw gateway call config.get --params '{}'  # 确认改动生效（Gateway 在线时）
```

如果 `openclaw doctor` 报错，根据 `path` + `message` 定位问题并修复。
不要运行 `openclaw doctor --fix` 或 `--yes`，除非用户明确同意（它会写入配置/状态文件）。

## 字段访问控制

配置字段按安全等级分三层。详见 `references/field-access-control.md`。

### READONLY — 平台锁定字段（修改会被系统回滚，不要尝试）

⛔ **以下字段受应用层锁定保护。config.patch/config.set 写入会被静默回滚，不要调用写入命令。**

| 字段 | 固定值 | 修改后果 |
|------|--------|----------|
| `gateway.bind` | `"loopback"` | 暴露端口到外部网络，Gateway 崩溃或安全漏洞 |
| `gateway.port` | `18789` | 与 18790/18791 冲突，crash loop |
| `gateway.mode` | `"local"` | 非 local 模式不适用 Android |
| `gateway.auth.*` | `auth.mode="token"` + `token="stepclaw-dev-placeholder-v1"` | 改成 `none` 或改坏 token 会破坏 shared-auth 握手，backend agent / SDK / App 连接失败 |
| `gateway.tls.*` | 未启用 | 启用 TLS 阻断 localhost 连接 |
| `gateway.experimental` | `"snapshot"` | ConfigGuard 回滚依赖此模式 |
| `server.apiKey` | 应用层注入 | 覆盖后 API 鉴权失败 |
| `server.apiUrl` | 应用层注入 | 覆盖后 API 路由错误 |

**对这些字段调用 config.patch / config.set 没有实际效果，Gateway 重启后会被应用层覆盖回来。**
如果排查问题时发现这些字段值异常，说明问题根因在别处——参见「channel 问题排查」。
告诉用户该字段无法修改，并给出替代方案（如端口转发）。

### WRITABLE — 常规业务配置

`channels.*`、`models.providers.*`、`agents.defaults.*`、`tools.*`、`skills.*`、`plugins.*`

正常走三步闭环即可。

### DANGEROUS — 需用户确认

- `models.providers.*.apiKey`：API key 应优先写入 `auth-profiles.json` 而非 openclaw.json
- `agents.defaults.model`：切换默认模型影响所有对话
- `config.apply`（全量替换）：会丢失未包含的配置

这些操作在执行前向用户确认意图和影响。

## 为什么优先使用 CLI/RPC 而非直接编辑文件

不是"不能"直接编辑，而是理解为什么 CLI/RPC 路径更安全：

1. **Schema 校验**：CLI 和 RPC 路径经过 Zod schema 验证，未知字段或类型错误会被拦截
2. **审计记录**：CLI/RPC 路径有配置审计日志
3. **原子性**：`config.patch` 是原子操作；手工编辑 JSON 在写入过程中可能产生语法错误
4. **热更新**：Gateway 在线时 RPC 即时生效，不需要重启
5. **严格模式**：多数配置对象使用 `.strict()` 验证，未知字段会导致 Gateway 启动失败

## Channel 配置指导

预装 channel（飞书、微信、企业微信）的配置模板和常见错误见 `references/channel-recipes.md`。

**关键认知：Channel 问题 ≠ Gateway 配置问题。** 飞书/微信/企业微信等使用 WebSocket 或 HTTP 长连接与各自平台通信，与 `gateway.bind`/`gateway.port`/`gateway.auth` 无关。排查 channel 连接问题时，检查 channel 自身配置和平台侧设置，不要碰 gateway 配置。

### 非预装 Channel

用户可以自行安装第三方 channel 插件。配置这些 channel 时：

1. 确认插件已安装：`openclaw extensions list`
2. 获取 schema：`openclaw gateway call config.schema --params '{}'`
3. 按 schema 写入配置，不要猜测字段名
4. 三步闭环：READ → PATCH → VERIFY

## StepClaw Android 平台约束

详见 `references/stepclaw-platform-constraints.md`。

摘要：
- 端口 18789/18790/18791 三进程共享网络命名空间，不可修改
- `gateway.auth.mode` 必须为 `"token"`，且 `gateway.auth.token` 必须保持仓库约定占位值
- chroot 环境下部分命令不可用（如 `lsof`），不要依赖它们做端口诊断
- 配置文件路径：以 `openclaw config get` 输出为准，不要硬编码假设路径

## 参考资源

需要更多细节时按需 `read`：

- `references/field-access-control.md` — 字段完整分层表
- `references/channel-recipes.md` — 预装 channel 配置模板
- `references/stepclaw-platform-constraints.md` — Android 平台约束
- `scripts/config-check.sh` — 验证脚本
