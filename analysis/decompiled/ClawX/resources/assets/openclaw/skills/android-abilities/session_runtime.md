# session_runtime — 会话与运行时

> ⚠️ 全部工具为云侧工具（OpenClaw）

---

## 云侧工具参考

```
ability.call method="sessions_list" params='{}'
```

列出所有会话。

```
ability.call method="sessions_history" params='{"session_id":"<会话ID>"}'
```

获取指定会话的历史记录。

```
ability.call method="sessions_send" params='{"session_id":"<会话ID>","message":"<消息内容>"}'
```

向指定会话发送消息。

```
ability.call method="sessions_spawn" params='{}'
```

创建新会话。可选参数：`prompt`（初始提示词）。

```
ability.call method="session_status" params='{"session_id":"<会话ID>"}'
```

获取会话状态。

```
ability.call method="exec" params='{"command":"<要执行的命令>"}'
```

执行命令。

```
ability.call method="bash" params='{"command":"<Bash命令>"}'
```

执行 Bash Shell 命令。

```
ability.call method="process" params='{"action":"<操作类型，支持list/kill等>"}'
```

进程管理。可选参数：`pid`（进程ID）。

---

## 端侧工具

> 来源 App：`com.stepos.ailauncher`

```
ability.call method="assistant_get_voice_list" params='{}'
```

读取当前TTS引擎支持的音色列表，查询当前说话支持哪些声音音色。优先调用该原子能力。

```
ability.call method="assistant_change_voice_id" params='{"voice_id":"<音色ID，必须是mcp tool[assistant_get_voice_id]返回的音色之一>"}'
```

切换说话声音，切换回复的声音音色，换个TTS合成使用的音色，让TTS引擎使用指定音色朗读，不需要用户手动切换。优先调用该原子能力。

---

## 云侧工具扩展

```
ability.call method="get_user_profile" params='{"accountId":"<账号ID>"}'
```

获取用户记忆偏好。

```
ability.call method="flow_workflow_call" params='{"workflow_id":"<工作流ID>","data":"<发送数据JSON对象>"}'
```

调用flow workflow。可选参数：`version`（版本号，不填默认用最新版本）。
