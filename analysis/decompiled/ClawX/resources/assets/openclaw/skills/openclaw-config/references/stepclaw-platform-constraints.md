# StepClaw Android 平台约束

OpenClaw Gateway 运行在 StepClaw Android 设备的 chroot 环境中，有以下特有约束。

## 端口分配

chroot 与 Android 宿主共享网络命名空间。三个端口被固定分配，不可修改：

| 端口 | 用途 | 进程 | 说明 |
|------|------|------|------|
| 18789 | Gateway (Node.js) | `openclaw_env`（chroot 内） | OpenClaw 主进程 |
| 18790 | InterceptHttpServer (webhook) | `com.stepos.stepclaw`（Android App） | 宿主 webhook 拦截 |
| 18791 | StepOSProxyServer (LLM 代理) | `com.stepos.stepclaw`（Android App） | LLM 请求代理 |

修改 Gateway 端口到 18790 或 18791 会直接与 Android 侧服务冲突，导致 crash loop。

## 认证约束

- `gateway.auth.mode` 必须为 `"token"`
- `gateway.auth.token` 必须等于仓库统一占位值 `stepclaw-dev-placeholder-v1`
- 原因：StepClaw 当前依赖 shared-secret token 握手，才能让 backend agent 在 loopback 下保留 `operator.write` scope；App 和 SDK 侧也都内置了同一个占位 token 回落
- 改为 `"none"`` 或把 token 改成其它值后果：backend agent shared-auth bypass 失效，`ability.call` / Gateway 握手会报 `missing scope: operator.write`、`401 unauthorized` 或 `gateway closed (1008)`

## chroot 环境限制

- `lsof` 不可用——不要依赖它做端口占用诊断
- `chmod` 在某些目录下返回 ENOSYS
- `dpkg` 目录可能只读——安装 pip 用 `curl get-pip.py` 而非 `apt-get install python3-pip`

## 配置文件路径

- 不要硬编码路径假设，用 `openclaw config get` 获取当前配置
- 主配置文件的实际路径取决于 `OPENCLAW_CONFIG_PATH` 环境变量

## 历史事故

以下 postmortem 记录了因修改平台约束字段导致的 P0/P1 事故：

| 日期 | 事故 | 文档 |
|------|------|------|
| 2026-04-01 | Agent 改 gateway.bind 导致飞书彻底断连 | `doc/postmortem/2026-04-01-agent-edit-gateway-bind-regression.md` |
| 2026-04-07 | Agent 改 gateway.auth.mode 导致 SDK 401 | `doc/postmortem/2026-04-07-agent-edit-gateway-auth-regression.md` |
| 2026-04-16 | Agent 通过 exec 改 auth.mode 导致 SDK 401 | `doc/postmortem/2026-04-16-agent-exec-gateway-auth-mutation.md` |
| 2026-04-17 | Agent 改 gateway.port 导致端口冲突 crash loop | `doc/postmortem/2026-04-17-gateway-crash-loop-port-conflict.md` |
