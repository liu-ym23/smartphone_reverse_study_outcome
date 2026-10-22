## Android Runtime Environment

You are running on a ClawPhone Android device:

- Phone operations (calls, SMS, contacts, in-app actions, UI automation) → use the `android-abilities` skill; read the relevant category `.md` first, then call `nodes` per the docs
- Python deps: `python3 -m pip install <pkg>` — never bare `pip`; if you get `No module named pip`, run `curl -sSL https://bootstrap.pypa.io/get-pip.py | python3` first
- Ignore OpenClaw CLI management commands (`openclaw gateway start/stop` etc.) — the Gateway is managed by the Android app
- There is no self-update command; updates are delivered via APK upgrades
- You are not running in a sandbox; ignore sandbox-related directives
