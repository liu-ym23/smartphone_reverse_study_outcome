package com.obric.aiagent.product.platform.api.memory;

/* JADX INFO: compiled from: ObricMemoryConstants.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObricMemoryConstants {
    public static final int EVENT_GESTURE_BACK = 0;
    public static final int EVENT_STATE_DEFAULT = 0;
    public static final int FROM_ACTION_MODE = 1;
    public static final int FROM_GESTURE = 3;
    public static final int FROM_KEY = 4;
    public static final int FROM_SCREENSHOT = 0;
    public static final ObricMemoryConstants INSTANCE = null;
    public static final int IN_APP_ACTION_L1_EVENT = 6;
    public static final int IN_APP_ACTION_REGISTER = 1;
    public static final int IN_APP_ACTION_RULE_COMMAND = 5;
    public static final int IN_APP_ACTION_RULE_REQUEST = 3;
    public static final int IN_APP_ACTION_RULE_RESPONSE = 4;
    public static final int IN_APP_ACTION_TOAST_SHOWN = 7;
    public static final int IN_APP_ACTION_UNREGISTER = 2;
    public static final int IN_APP_ENGINE_VERSION = 1;
    public static final String IN_APP_KEY_ACTION = "inAppAction";
    public static final String IN_APP_KEY_ACTIVITY_INDEX = "inAppActivityIndex";
    public static final String IN_APP_KEY_ACTIVITY_NAME = "inAppActivityName";
    public static final String IN_APP_KEY_ACTIVITY_RULE_JSON = "inAppL1RulesJson";
    public static final String IN_APP_KEY_ACTIVITY_RULE_VERSION = "inAppActivityRuleVersion";
    public static final String IN_APP_KEY_ACTIVITY_TOKEN = "inAppActivityToken";
    public static final String IN_APP_KEY_APP_VERSION_CODE = "inAppAppVersionCode";
    public static final String IN_APP_KEY_ENGINE_VERSION = "inAppEngineVersion";
    public static final String IN_APP_KEY_GLOBAL_VERSION = "inAppGlobalVersion";
    public static final String IN_APP_KEY_L1_EVENT_JSON = "inAppL1EventJson";
    public static final String IN_APP_KEY_OPERATION = "inAppOperation";
    public static final String IN_APP_KEY_PACKAGE_NAME = "inAppPackageName";
    public static final String IN_APP_KEY_PROTOCOL_VERSION = "inAppProtocolVersion";
    public static final String IN_APP_KEY_REQUEST_ID = "inAppRequestId";
    public static final String IN_APP_KEY_RESULT_CODE = "inAppResultCode";
    public static final String IN_APP_KEY_RULE_BUNDLE = "inAppRuleBundle";
    public static final String IN_APP_KEY_RULE_TOKEN = "inAppRuleToken";
    public static final String IN_APP_KEY_TOAST_DURATION = "inAppToastDuration";
    public static final String IN_APP_KEY_TOAST_TEXT = "inAppToastText";
    public static final int IN_APP_MAX_PAYLOAD_BYTES = 262144;
    public static final int IN_APP_OPERATION_REMOVE = 2;
    public static final int IN_APP_OPERATION_SET = 1;
    public static final int IN_APP_PROTOCOL_VERSION = 1;
    public static final int IN_APP_RULE_RESULT_CONTENT = 1;
    public static final int IN_APP_RULE_RESULT_REJECTED = 2;
    public static final String KEY_IMAGE_URI = "com.obric.memorydata.EXTRA_IMAGE_URI";
    public static final String KEY_IN_APP_SIGNALS_BYTES = "inAppSignalsBytes";
    public static final String KEY_IN_APP_SIGNALS_ENCODING = "inAppSignalsEncoding";
    public static final String KEY_IN_APP_SIGNALS_JSON = "inAppSignalsJson";
    public static final String KEY_IN_APP_SIGNALS_NEWEST_SIGNAL_UPTIME_MS = "inAppSignalsNewestSignalUptimeMs";
    public static final String KEY_IN_APP_SIGNALS_ORIGINAL_BYTES = "inAppSignalsOriginalBytes";
    public static final String KEY_IN_APP_SIGNAL_ACTION = "inAppSignalAction";
    public static final String KEY_IN_APP_SIGNAL_ENABLED = "inAppSignalEnabled";
    public static final String KEY_IN_APP_SIGNAL_FLUSH_COMPLETE = "inAppSignalFlushComplete";
    public static final String KEY_IN_APP_SIGNAL_FLUSH_RESULT = "inAppSignalFlushResult";
    public static final String KEY_IN_APP_SIGNAL_PACKAGE_ALLOWLIST = "inAppSignalPackageAllowlist";
    public static final String KEY_IN_APP_SIGNAL_REQUEST_ID = "inAppSignalRequestId";
    public static final String KEY_IN_APP_SIGNAL_WATERMARK_EVENT_TIME_MS = "inAppSignalWatermarkEventTimeMs";
    public static final String KEY_PACKAGE = "com.obric.memorydata.EXTRA_PACKAGE";
    public static final String KEY_PACKAGE_NAME = "packageName";
    public static final String KEY_SESSION_ID = "sessionId";
    public static final String KEY_SESSION_STATE = "state";
    public static final String KEY_TEXT = "com.obric.memorydata.EXTRA_TEXT";
    public static final String KEY_TIMESTAMP = "com.obric.memorydata.EXTRA_TIMESTAMP";
    public static final String MEMORY_SERVICE = "memorydata";
    public static final String PROP_IN_APP_SIGNAL_GENERATION = "persist.sys.obric.in_app_signal_generation";
    public static final String SETTINGS_KEY_SHORTCUT_GESTURE_ENABLED = "memorydata_memory_shortcut_gesture_enabled";
    public static final String SETTINGS_KEY_SHORTCUT_KEY_ENABLED = "memorydata_memory_shortcut_key_enabled";
    public static final int SETTINGS_VALUE_DISABLED = 0;
    public static final int SETTINGS_VALUE_ENABLED = 1;
    public static final int TYPE_EXECUTE_SCENE_PERCEPTION = 1;
    public static final int TYPE_IN_APP_RULE = 3;
    public static final int TYPE_IN_APP_SIGNALS = 2;
    public static final String VALUE_IN_APP_SIGNALS_ENCODING_GZIP_JSON = "gzip+json";
    public static final String VALUE_IN_APP_SIGNAL_ACTION_FLUSH = "flush";
    public static final String VALUE_IN_APP_SIGNAL_ACTION_UPDATE_POLICY = "updatePolicy";
    public static final int VALUE_SESSION_STATE_DEFAULT = 0;
    public static final int VALUE_SESSION_STATE_FAILURE = 2;
    public static final int VALUE_SESSION_STATE_SECURE = 4;
    public static final int VALUE_SESSION_STATE_SUCCESS = 1;
    public static final int VALUE_SESSION_STATE_TIMEOUT = 3;

    static {
        INSTANCE = new ObricMemoryConstants();
    }

    private ObricMemoryConstants() {
    }
}
