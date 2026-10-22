# Channel 配置模板

预装 channel 的正确配置方式。适用于首次配置或排查配置问题。

## 飞书（feishu）

**Channel ID**: `feishu`（别名 `lark`）
**插件包**: `@openclaw/feishu`（预装）
**连接方式**: WebSocket 长连接（默认）或 Webhook
**Config Schema**: `.strict()` — 未知字段会导致 Gateway 启动失败

### 正确配置结构

```jsonc
{
  "channels": {
    "feishu": {
      "enabled": true,
      "defaultAccount": "default",
      "connectionMode": "websocket",     // "websocket"（默认推荐）| "webhook"
      "domain": "feishu",                // "feishu" | "lark" | "https://自定义域名"
      "dmPolicy": "pairing",            // "open" | "pairing" | "allowlist"
      "accounts": {
        "default": {
          "appId": "<来自 open.feishu.cn>",
          "appSecret": "<来自 open.feishu.cn>",
          "dmPolicy": "pairing"
        }
      }
    }
  }
}
```

### 必填凭据

- `appId` + `appSecret`：来自飞书开放平台（open.feishu.cn → 应用 → 凭证与基础信息）
- 凭据写在 `accounts.default` 下（与出厂模板一致），不要写在顶层

### 修改命令

```bash
# 启用飞书 channel
openclaw config set channels.feishu.enabled true --json

# 写入凭据（注意内层双引号）
openclaw config set 'channels.feishu.accounts.default.appId' '"<APP_ID>"' --json
openclaw config set 'channels.feishu.accounts.default.appSecret' '"<APP_SECRET>"' --json

# 验证
openclaw doctor
```

### 配对流程（dmPolicy=pairing 时）

1. 用户在飞书给 bot 发送任意私聊消息
2. Bot 返回配对码（格式：`/pair XXXXXX`）
3. 执行 `openclaw pairing approve feishu <code>`

### 可选：免配对（allowlist 模式）

```bash
openclaw config set channels.feishu.dmPolicy '"allowlist"' --json
openclaw config set 'channels.feishu.allowFrom' '[<飞书用户open_id>]' --json
```

### 常见字段速查

| 字段 | 类型 | 默认值 | 说明 |
|------|------|-------|------|
| `connectionMode` | `"websocket" \| "webhook"` | `"websocket"` | 连接方式 |
| `domain` | `"feishu" \| "lark" \| URL` | `"feishu"` | 飞书/Lark 域名 |
| `dmPolicy` | `"open" \| "pairing" \| "allowlist"` | `"pairing"` | 私聊策略 |
| `groupPolicy` | `"open" \| "allowlist" \| "disabled"` | `"allowlist"` | 群聊策略 |
| `requireMention` | boolean | `true` | 群中是否需要 @bot |
| `renderMode` | `"auto" \| "raw" \| "card"` | — | 消息渲染方式 |
| `streaming` | boolean | — | 是否流式输出 |
| `tools.doc` | boolean | `true` | 飞书文档操作 |
| `tools.chat` | boolean | `true` | 聊天信息查询 |
| `tools.wiki` | boolean | `true` | 知识库操作 |
| `tools.drive` | boolean | `true` | 云空间操作 |
| `tools.perm` | boolean | `false` | 权限管理（敏感） |

### 常见错误

| 现象 | 原因 | 修复 |
|------|------|------|
| Gateway 启动失败（schema error） | 写入了未知字段 | 检查字段名拼写，对照上表 |
| 飞书连接失败 | appId/appSecret 格式错误（缺内层双引号） | 重新执行 `config set`，确保值带内层双引号 |
| 收不到消息 | 飞书平台未订阅 `im.message.receive_v1` | 在飞书开放平台添加事件 |
| 不回复消息 | 应用未发布或权限未审核 | 发布版本，检查 `im:message` 和 `im:message:send_as_bot` |
| Agent 去改 gateway.bind | 飞书走 WebSocket，与 gateway bind 无关 | 问题在 channel 配置或飞书平台侧 |

### 深入参考

已有 setup skill `feishu-bot-setup/SKILL.md` 提供完整的飞书 bot 创建 + 配置引导流程。

---

## 微信（openclaw-weixin）

**Channel ID**: `openclaw-weixin`（不是 `weixin` 或 `wechat`）
**插件包**: `@tencent-weixin/openclaw-weixin`（预装）
**连接方式**: HTTP 长轮询（getUpdates）
**认证方式**: QR 扫码登录，token 自动保存

### 正确配置结构

```jsonc
{
  "channels": {
    "openclaw-weixin": {
      "enabled": true
      // 凭据通过 QR 扫码登录自动保存，不需要在 config 中手动写入
    }
  }
}
```

### 登录流程

微信登录不写凭据到 config，而是通过扫码流程自动保存 token：

```bash
# 使用 process start（非阻塞）启动登录
process start command="openclaw channels login --channel openclaw-weixin"

# 轮询输出，检测 QR URL
process poll sessionId=<id> timeout=30000

# 检测到 URL 后立即调用打开（不要等进程结束）
nodes action=invoke invokeCommand="ability.call" invokeParamsJson=\
  {"method":"app.openUrl","params":{"url":"<complete_url>"}}
```

### 关键注意事项

- **不要用 `exec` 启动登录**——`exec` 会阻塞等待命令结束，错过 QR URL 输出窗口
- **不要重复发起登录**——会使前一个 QR 码失效
- **不要在登录过程中修改 config**——会触发 Gateway 重启，中断登录流程
- **不要写入 botToken/apiKey**——微信插件不使用这些字段
- **Channel ID 是 `openclaw-weixin`**——不是 `weixin` 或 `wechat`

### 常见错误

| 现象 | 原因 | 修复 |
|------|------|------|
| 登录后看不到 QR 码 | 用了 `exec` 而非 `process start` | 改用 `process start` + `process poll` |
| QR 码失效 | 重复发起了登录 | 等待一会儿后重新发起一次 |
| Agent 写入 botToken | 微信不需要手动凭据 | 删除 botToken 字段，用扫码登录 |
| Channel ID 不匹配 | 用了 `weixin` 而非 `openclaw-weixin` | 修正为 `channels.openclaw-weixin` |

### 深入参考

已有 setup skill `openclaw-weixin-setup/SKILL.md` 提供完整的微信登录引导流程。

---

## 企业微信（wecom）

**Channel ID**: `wecom`（不是 `wecom-openclaw-plugin`）
**插件包**: `@wecom/wecom-openclaw-plugin`（预装）
**连接方式**: WebSocket 长连接（`wss://openws.work.weixin.qq.com`）
**认证方式**: Bot ID + Secret

### 正确配置结构

```jsonc
{
  "channels": {
    "wecom": {
      "enabled": true,
      "botId": "<来自企业微信 AI 助手后台>",
      "secret": "<来自企业微信 AI 助手后台>",
      "dmPolicy": "open",               // "open" | "pairing" | "allowlist" | "disabled"
      "groupPolicy": "open",            // "open" | "allowlist" | "disabled"
      "sendThinkingMessage": true        // 发送"思考中"提示
    }
  }
}
```

### 必填凭据

- `botId` + `secret`：来自企业微信 AI 助手管理后台

### 修改命令

```bash
# 启用企业微信 channel
openclaw config set channels.wecom.enabled true --json

# 写入凭据
openclaw config set 'channels.wecom.botId' '"<YOUR_BOT_ID>"' --json
openclaw config set 'channels.wecom.secret' '"<YOUR_BOT_SECRET>"' --json

# 验证
openclaw doctor
```

### 配对/白名单模式

```bash
# 查看待配对列表
openclaw pairing list wecom

# 批准配对
openclaw pairing approve wecom <CODE>

# 或使用白名单模式
openclaw config set channels.wecom.dmPolicy '"allowlist"' --json
openclaw config set 'channels.wecom.allowFrom' '["user_id_1","user_id_2"]' --json

# 群白名单
openclaw config set channels.wecom.groupPolicy '"allowlist"' --json
openclaw config set 'channels.wecom.groupAllowFrom' '["group_id_1"]' --json
```

### 常见字段速查

| 字段 | 类型 | 默认值 | 说明 |
|------|------|-------|------|
| `botId` | string | **必填** | Bot 标识 |
| `secret` | string | **必填** | Bot 密钥 |
| `dmPolicy` | `"open" \| "pairing" \| "allowlist" \| "disabled"` | `"open"` | 私聊策略 |
| `groupPolicy` | `"open" \| "allowlist" \| "disabled"` | `"open"` | 群聊策略 |
| `sendThinkingMessage` | boolean | `true` | 思考中提示 |
| `mediaLocalRoots` | string[] | — | 本地媒体文件目录白名单 |
| `websocketUrl` | string | `"wss://openws.work.weixin.qq.com"` | WebSocket 地址 |

### 常见错误

| 现象 | 原因 | 修复 |
|------|------|------|
| WebSocket 连接失败 | botId 或 secret 错误 | 从企业微信后台重新获取 |
| 收不到群消息 | groupPolicy 未设置或用了 `"disabled"` | 设置为 `"open"` 或 `"allowlist"` |
| Channel ID 不匹配 | 用了 `wecom-openclaw-plugin` | 修正为 `channels.wecom` |

---

## 非预装 Channel 通用指导

用户可以自行安装第三方 channel 插件。配置时：

1. **确认插件已安装**：
   ```bash
   openclaw extensions list
   ```

2. **获取该 channel 的 schema**：
   ```bash
   openclaw gateway call config.schema --params '{}'
   ```

3. **按 schema 写入配置**：字段名以 schema 输出为准，不要猜测

4. **三步闭环**：READ → PATCH → VERIFY

5. **通用配置字段**（多数 channel 支持）：
   - `enabled`: boolean — 启用/禁用
   - `dmPolicy`: string — 私聊策略
   - `groupPolicy`: string — 群聊策略
   - `allowFrom`: string[] — 白名单
   - `defaultAccount`: string — 默认账号
   - `accounts`: object — 多账号配置

---

## 排查 Channel 问题的正确路径

当 channel 连接出问题时，按以下顺序排查：

1. **检查 channel 自身配置**：凭据是否正确、是否 enabled
2. **检查插件状态**：`openclaw extensions list` 确认插件已加载
3. **检查平台侧设置**：飞书开放平台/企业微信后台/微信扫码状态
4. **查看 Gateway 日志**：定位具体错误信息
5. **运行 doctor**：`openclaw doctor` 检查 schema 是否合法

**不要碰 gateway.bind / gateway.port / gateway.auth** —— channel 连接问题与这些字段无关。
