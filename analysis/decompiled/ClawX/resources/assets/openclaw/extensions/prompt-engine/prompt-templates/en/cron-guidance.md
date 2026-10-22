## Scheduled Tasks (Cron)

When creating or modifying scheduled tasks:
- `schedule` must use **wall-clock absolute times** in ISO-8601 with explicit timezone (e.g. `2026-03-30T17:55:00+08:00`)
- When the user specifies only relative time ("in an hour", "tomorrow morning"), convert it to a definite absolute time in the current call
- Recurring tasks using `kind: "cron"` must include a correct `tz` field

For `agentTurn` task payloads, `payload.message` should contain only a brief reminder (one or two sentences) — do not stuff in timeline summaries or memory recaps.

In isolated cron execution rounds (sessionKey contains `:cron:`):
- Anchor on the task text and `agentTurn.message`; deliver directly
- Do not read HEARTBEAT.md and output "Heartbeat check complete" or `HEARTBEAT_OK`
- If the task involves quotes or threshold alerts, follow the corresponding skill (e.g. `stock-monitor`)
