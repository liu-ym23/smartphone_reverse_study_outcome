package obric.api;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SettingsSmtBase {
    static final String TAG = "SettingsSmtEx";

    public static abstract class ACL_MODE_BASE {
        public static final int ACL_MODE_DEFAULT = 1;
        public static final int ACL_MODE_OFF = 0;
        public static final int ACL_MODE_ON = 1;

        public ACL_MODE_BASE() {
        }
    }

    public static abstract class GlobalBase {
        public static final String GLOBAL_PC_MODE_SETTINGS = "global_pc_mode_settings";
        public static final String POWER_ACL_MODE_ENABLE = "acl_mode_enable";
        public static final String POWER_SLEEP_MODE_ENABLE = "sleep_mode_enable";
        public static final String SLEEP_MODE_LAST_MOBILE_STATE = "sleep_mode_last_mobile_state";
        public static final String SLEEP_MODE_LAST_WIFI_STATE = "sleep_mode_last_wifi_state";

        public GlobalBase() {
        }
    }

    public static abstract class SLEEP_MODE_BASE {
        public static final int SLEEP_MODE_LAST_OFF_STATE = 0;
        public static final int SLEEP_MODE_LAST_ON_STATE = 1;
        public static final int SLEEP_MODE_OFF = 0;
        public static final int SLEEP_MODE_ON = 1;

        public SLEEP_MODE_BASE() {
        }
    }

    public static abstract class SecureBase {
        public SecureBase() {
        }
    }

    public static abstract class SystemBase {
        public static final String HERO_FORBID_APPSTART_AUTHORITY = "forbidapp.start.authority";
        public static final String HERO_FORBID_APPSTART_ENABLED = "forbidapp.start";
        public static final String REALTIME_SCREEN_BRIGHTNESS = "realtime_screen_brightness";
        public static final String SCREEN_BRIGHTNESS_TEMP = "screen_brightness_temp";
        public static final String SUNSHINE_SCREEN = "sunshine_screen";

        public SystemBase() {
        }
    }

    public SettingsSmtBase() {
    }
}
