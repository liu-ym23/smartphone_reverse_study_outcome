package obric.api;

/* JADX INFO: loaded from: classes5.dex */
public class IntentSmt {
    public static final String ACTION_BYTEDANCE_GAMEAPPTYPE_UPDATED = "android.intent.action_GAMEAPPTYPE_UPDATED";
    public static final String ACTION_COPY_HISTORY_CHANGE = "android.intent.action.CopyHistoryChange";
    public static final String ACTION_FOORESULT_DISMISS = "bytedanceos.intent.action.FOORESULT_DISMISS";
    public static final String ACTION_INSTALL_SHORTCUT = "bytedanceos.intent.action.INSTALL_SHORTCUT";
    public static final String ACTION_LAUNCH_VOICE_COMMAND = "bytedanceos.intent.action.ACTION_LAUNCH_VOICE_COMMAND";
    public static final String ACTION_PHONE_MODE_CHANGED = "bytedanceos.intent.action.ACTION_PHONE_MODE_CHANGED";
    public static final String ACTION_SM_SQUEEZE_SHORTCUTS = "com.bytedanceos.action.SM_SQUEEZE_SHORTCUT";
    public static final String ACTION_STATUS_BAR_CLICKED = "android.intent.action.STATUS_BAR_CLICKED";
    public static final String EXTRA_BYTEDANCE_ANIM_RESOURCE_ID = "bytedanceos.intent.extra.ANIM_RESOURCE_ID";
    public static final String EXTRA_BYTEDANCE_KEYGUARD_LAUNCH_CAMERA = "bytedanceos.intent.extra.KEYGUARD_LAUNCH_CAMERA";
    public static final String EXTRA_BYTEDANCE_WINDOW_OPTION = "bytedanceos.intent.extra.SHOW_WINDOW_WITH_OPTIONS";
    public static final String EXTRA_PHONE_MODE = "phone_mode";
    public static final String EXTRA_REVONE_SMT_LAUNCH_TYPE = "rev_launch_type";
    public static final String EXTRA_REVONE_SMT_POPACTIVITY_PRE_TASKID = "smt_pop_pre_taskid";
    public static final String EXTRA_REVONE_SMT_WINDOW_ARROW_DIRECT = "smt_window_arrow_direct";
    public static final String EXTRA_REVONE_SMT_WINDOW_ARROW_XOFFSET = "smt_window_arrow_xoffset";
    public static final String EXTRA_REVONE_SMT_WINDOW_ARROW_YOFFSET = "smt_window_arrow_yoffset";
    public static final String EXTRA_REVONE_SMT_WINDOW_FLOATING = "smt_window_floating";
    public static final String EXTRA_REVONE_SMT_WINDOW_TYPE = "window-type";
    public static final String EXTRA_REVONE_SMT_WINDOW_USE_LAST_LOCATION = "smt_window_use_last_location";
    public static final String EXTRA_REVONE_SMT_WINDOW_VIEW_HEIGHT = "smt_window_view_height";
    public static final String EXTRA_REVONE_SMT_WINDOW_VIEW_WIDTH = "smt_window_view_width";
    public static final String EXTRA_SM_SQUEEZE_SHORTCUTS = "com.bytedanceos.action.SM_SQUEEZE_SHORTCUT";
    public static final int FLAG_ACTIVITY_SECURITY_MODE = 512;
    public static final int FLAG_NEW_TASK_FOR_ACTIVITY_RESULT = 1024;
    public static final int FLAG_RECEIVER_SM_USER_AWARE = 128;
    public static final int FLAG_SHOW_BYTEDANCE_TRANSITION = 256;
    public static final int FLAG_SM_FORCE_REOPEN_WHEN_RESUMED = 8;
    public static final int FLAG_SM_IN_CALL_SCREEN = 2;
    public static final int FLAG_SM_NO_AMPLIFICATION = 1;
    public static final int FLAG_SM_REMOVE_ACTIVE_NETWORKINFO_CACHE = 32;
    public static final int FLAG_SM_REMOVE_CONTAINER_IMMEDIATE = 4;
    public static final int FLAG_SM_TASK_NOT_TRIMMABLE = 16;

    public static final String get_ACTION_BATTERY_LEVEL_CHANGED() {
        return "android.bluetooth.headset.profile.action.BATTERY_LEVEL_CHANGED";
    }

    public static final String get_ACTION_BYTEDANCE_GAMEAPPTYPE_UPDATED() {
        return ACTION_BYTEDANCE_GAMEAPPTYPE_UPDATED;
    }

    public static final String get_ACTION_SM_SQUEEZE_SHORTCUTS() {
        return "com.bytedanceos.action.SM_SQUEEZE_SHORTCUT";
    }

    public static final String get_ACTION_STATUS_BAR_CLICKED() {
        return ACTION_STATUS_BAR_CLICKED;
    }

    public static final String get_EXTRA_BYTEDANCE_ANIM_RESOURCE_ID() {
        return EXTRA_BYTEDANCE_ANIM_RESOURCE_ID;
    }

    public static final String get_EXTRA_BYTEDANCE_KEYGUARD_LAUNCH_CAMERA() {
        return EXTRA_BYTEDANCE_KEYGUARD_LAUNCH_CAMERA;
    }

    public static final String get_EXTRA_HEADSET_BATTERY_LEVEL() {
        return "android.bluetooth.headset.extra.EXTRA_HEADSET_BATTERY_LEVEL";
    }

    public static final String get_EXTRA_SM_SQUEEZE_SHORTCUTS() {
        return "com.bytedanceos.action.SM_SQUEEZE_SHORTCUT";
    }

    public static final int get_FLAG_RECEIVER_SM_USER_AWARE() {
        return 128;
    }

    public IntentSmt() {
    }
}
