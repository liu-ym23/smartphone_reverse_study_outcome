# 字段访问控制表

本文档列出 `openclaw.json` 中所有顶层配置域的访问控制等级。

## ⛔ READONLY — 平台锁定字段（修改会被系统回滚，不要尝试）

以下字段受 StepClaw 应用层锁定保护。**config.patch / config.set 对这些字段的写入会被静默回滚**——
即使命令返回成功，Gateway 重启后应用层会从 hardcoded 值覆盖回来。
**不要浪费时间尝试修改，直接告诉用户不可改。**

| 字段路径 | 当前固定值 | 修改后果 |
|---------|-----------|---------|
| `gateway.bind` | `"loopback"` | 改为 `"0.0.0.0"` 等会暴露端口到外部网络，或与宿主进程冲突 |
| `gateway.port` | `18789` | 18790 被 InterceptHttpServer 占用，18791 被 StepOSProxyServer 占用，改到任一都导致 crash loop |
| `gateway.mode` | `"local"` | 非 local 模式不适用于 Android 单机部署 |
| `gateway.auth.mode` | `"token"` | 改为 `"none"` 或其它模式会破坏 StepClaw 当前 shared-secret 握手，backend agent 丢失 `operator.write`，SDK / App 连接可能返回 `401 unauthorized` 或 `gateway closed (1008)` |
| `gateway.auth.token` | `"stepclaw-dev-placeholder-v1"` | 改动后会与 App / SDK 内置占位 token 漂移，导致握手失败 |
| `gateway.auth.*`（其他子字段） | — | `gateway.auth` 整体受平台约束，不要自行扩展或替换 |
| `gateway.tls.*` | — | Android localhost 不需要 TLS，启用会阻断连接 |
| `gateway.experimental` | `"snapshot"` | 快照模式是 ConfigGuard 回滚所依赖的前提，禁止修改 |
| `server.apiKey` | — | 由应用层注入 |
| `server.apiUrl` | — | 由应用层注入 |

### 收到修改请求时的标准回复

> ⚠️ `<字段名>` 是平台管控的 READONLY 字段，我无法修改它。
> 修改会导致 <具体后果>。
> 如果你需要 <用户的真实意图>，可以 <替代方案>。

### 遇到这些字段值异常怎么办？

如果排查过程中发现 READONLY 字段的值异常（例如 `auth.mode` 不是 `"token"`，或 token 不是占位值）：
1. **绝对不要**手动修改——交给 StepClaw App 层恢复
2. 可以用 `openclaw config get gateway` 读取当前值做诊断
3. 报告给用户，建议重启 StepClaw App

## WRITABLE — 常规业务配置

| 配置域 | 说明 | 常见操作 |
|-------|------|---------|
| `channels.*` | Channel 配置（飞书、微信、企业微信等） | 启用/禁用 channel、填写凭据、配置 DM/群组策略 |
| `models.providers.*` | LLM Provider 配置 | 添加/修改 provider、调整 model 参数 |
| `agents.defaults.*` | Agent 默认配置 | 修改默认模型、时区、memory 参数 |
| `tools.*` | 工具配置 | 启用/禁用工具、配置工具参数 |
| `skills.*` | Skill 配置 | 启用/禁用 skill、设置 skill 环境变量 |
| `plugins.*` | 插件配置 | 启用/禁用插件、配置插件参数 |

操作方式：三步闭环（READ → PATCH → VERIFY）。

## DANGEROUS — 需用户确认后执行

| 操作 | 风险 | 确认要点 |
|------|------|---------|
| 写入 `models.providers.*.apiKey` | API key 应优先存入 `auth-profiles.json` | 确认用户了解 key 会明文保存在 openclaw.json |
| 修改 `agents.defaults.model` | 影响所有后续对话的默认模型 | 确认用户意图切换模型 |
| 使用 `config.apply`（全量替换） | 未包含的配置项会被删除 | 确认用户理解全量替换的影响，优先推荐 `config.patch` |
| 删除整个 `channels.<id>` 配置块 | 该 channel 会停止工作 | 确认用户只是想禁用（用 `enabled: false`）还是完全移除 |
