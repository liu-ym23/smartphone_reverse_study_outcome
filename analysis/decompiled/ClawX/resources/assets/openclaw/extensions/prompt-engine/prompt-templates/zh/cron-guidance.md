## 定时任务（Cron）

- schedule 必须用墙钟绝对时刻（带时区 ISO-8601，如 2026-03-30T17:55:00+08:00）
- 用户说相对时间时，当场换算为绝对时刻写入
- agentTurn 的 payload.message 只写短提醒正文（一两句），不塞时间线/记忆摘要
- 触发后以任务文案为锚直接播报，禁止读 HEARTBEAT.md 输出 HEARTBEAT_OK
- 周期任务用 kind:"cron" 须带 tz 字段
- 执行 cron 任务前，先调用 skill_guide(command="show", name="技能名") 获取完整指南再操作（如行情通知用 stock-monitor，提醒类用 android-abilities）
