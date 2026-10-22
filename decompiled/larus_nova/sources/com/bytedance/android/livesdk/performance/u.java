package com.bytedance.android.livesdk.performance;

import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes11.dex */
public class u {

    @SerializedName("anchor_degrade_setting")
    public a anchorDegradeSetting;

    @SerializedName("batteryLevel")
    public int batteryLevel;

    @SerializedName("degrade_lev1")
    public b degradeLevel1;

    @SerializedName("degrade_lev2")
    public b degradeLevel2;

    @SerializedName("enable")
    public boolean enable;

    @SerializedName("enableAnchor")
    public boolean enableAnchor;

    @SerializedName("enableLowPower")
    public boolean enableLowPower;

    @SerializedName("enablePerformance")
    public boolean enablePerformance;

    @SerializedName("enable_ui_rate")
    public boolean enableUiRate;

    @SerializedName("enableUnitm")
    public boolean enableUnitm;

    @SerializedName("lintEnable")
    public boolean lintEnable;

    @SerializedName("recover_duration")
    public long recoverDuration;

    public static class a {

        @SerializedName("anchorRecoverDuration")
        public long anchorRecoverDuration;

        @SerializedName("previewFpsDeviation")
        public float previewFpsDeviation;

        @SerializedName("previewFpsDuration")
        public long previewFpsDuration;

        @SerializedName("temperatureAnchor")
        public float temperatureAnchor;

        @SerializedName("temperatureDuration")
        public long temperatureDuration;

        @SerializedName("uiStallSeriousCount")
        public int uiStallSeriousCount;

        public a() {
        }
    }

    public static class b {

        @SerializedName("duration")
        public long duration;

        @SerializedName("fps")
        public float fps;

        @SerializedName(OnekeyLoginConstants.CU_KEY_OPERATOR)
        public int operator;

        @SerializedName("tempreture_android")
        public float temperature;

        @SerializedName(IPerformanceStrategyManager.KEY_DOUBLE_UI_STALL_RATE)
        public float uiStallRate;

        public b() {
        }
    }

    public u() {
    }
}
