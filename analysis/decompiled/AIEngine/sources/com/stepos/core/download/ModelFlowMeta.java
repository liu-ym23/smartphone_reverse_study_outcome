package com.stepos.core.download;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelFlowMeta {
    public static final int ENV_ERROR_NO_NETWORK = 5001;
    public static final int GATE_ERROR_INSUFFICIENT_SPACE = 5021;
    public static final int GATE_ERROR_LOW_BATTERY = 5020;
    public static final int GATE_ERROR_NONE = 0;
    public static final int GATE_ERROR_SERVICE_DISABLED = 5022;
    public static final ModelFlowMeta INSTANCE = new ModelFlowMeta();
    public static final String KEY_ACTIVE = "active";
    public static final String KEY_CAN_UPDATE = "canUpdate";
    public static final String KEY_CELLULAR_ALLOWED = "cellularAllowed";
    public static final String KEY_CTA_BLOCKED = "ctaBlocked";
    public static final String KEY_ENV_ERROR = "envError";
    public static final String KEY_ENV_OK = "envOk";
    public static final String KEY_FETCH_OK = "fetchOk";
    public static final String KEY_GATE_ERROR = "gateError";
    public static final String KEY_GATE_OK = "gateOk";
    public static final String KEY_HAS_NETWORK = "hasNetwork";
    public static final String KEY_HAS_UPDATE = "hasUpdate";
    public static final String KEY_INSTALLED = "installed";
    public static final String KEY_IS_WIFI = "isWifi";
    public static final String KEY_MODEL_LABEL = "modelLabel";
    public static final String KEY_PLAN = "plan";
    public static final String KEY_REMOTE_AVAILABLE = "remoteAvailable";
    public static final String KEY_SERVER_REACHED = "serverReached";
    public static final String KEY_SERVICE_ENABLED = "serviceEnabled";
    public static final String KEY_SIZE_BYTES = "sizeBytes";
    public static final String KEY_UPDATE_INFO = "updateInfo";
    public static final int NONET_STATE_DECLINED = 1;
    public static final int NONET_STATE_PROMPT = 0;
    public static final int NONET_STATE_SCHEDULED = 2;
    public static final int NONET_STATE_SUPPRESSED = 3;
    public static final String PLAN_DL_CELLULAR_REMINDER = "DL_CELLULAR_REMINDER";
    public static final String PLAN_DL_CONFIRM_ONLY = "DL_CONFIRM_ONLY";
    public static final String PLAN_DL_CONFIRM_THEN_CELLULAR = "DL_CONFIRM_THEN_CELLULAR";
    public static final String PLAN_DL_NO_NETWORK_GUIDE = "DL_NO_NETWORK_GUIDE";
    public static final String PLAN_DL_RESUME_CELLULAR = "DL_RESUME_CELLULAR";
    public static final String PLAN_DL_RESUME_CONFIRM = "DL_RESUME_CONFIRM";
    public static final String PLAN_DL_WIFI_TO_CELLULAR = "DL_WIFI_TO_CELLULAR";
    public static final String PLAN_GATE_INSUFFICIENT_SPACE = "GATE_INSUFFICIENT_SPACE";
    public static final String PLAN_GATE_LOW_BATTERY = "GATE_LOW_BATTERY";
    public static final String PLAN_GATE_SERVICE_DISABLED = "GATE_SERVICE_DISABLED";
    public static final String PLAN_NONE = "NONE";
    public static final String PLAN_NO_NETWORK = "NO_NETWORK";
    public static final String PLAN_UNAVAILABLE = "UNAVAILABLE";
    public static final String PLAN_UPD_CELLULAR_AUTO_OFF = "UPD_CELLULAR_AUTO_OFF";
    public static final String PLAN_UPD_CELLULAR_AUTO_ON = "UPD_CELLULAR_AUTO_ON";
    public static final String PLAN_UPD_CELLULAR_REMINDER = "UPD_CELLULAR_REMINDER";
    public static final String PLAN_UPD_WIFI_AUTO_OFF = "UPD_WIFI_AUTO_OFF";
    public static final String PLAN_UPD_WIFI_AUTO_ON = "UPD_WIFI_AUTO_ON";
    public static final String PLAN_UPD_WIFI_TO_CELLULAR = "UPD_WIFI_TO_CELLULAR";

    private ModelFlowMeta() {
    }
}
