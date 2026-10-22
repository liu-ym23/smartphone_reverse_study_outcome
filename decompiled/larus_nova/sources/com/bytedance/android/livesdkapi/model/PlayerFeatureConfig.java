package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001f\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0016\u0010\u0011\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0016\u0010\u0013\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0016\u0010\u0015\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0016\u0010\u0017\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0016\u0010\u0019\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0016\u0010\u001b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0016\u0010\u001d\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0016\u0010\u001f\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0016\u0010!\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006R\u0016\u0010#\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0006R\u0016\u0010%\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0006¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerFeatureConfig;", "", "()V", "enableABRControl", "", "getEnableABRControl", "()Z", "enableAudioWatermark", "", "getEnableAudioWatermark", "()I", "enableFeatureManager", "getEnableFeatureManager", "setEnableFeatureManager", "(Z)V", "enableGlobalControl", "getEnableGlobalControl", "enableInnerTimer", "getEnableInnerTimer", "enableNewEventNotify", "getEnableNewEventNotify", "enablePlayerBasenew", "getEnablePlayerBasenew", "enablePlayerPerformanceData", "getEnablePlayerPerformanceData", "enablePlayerUsedMetrics", "getEnablePlayerUsedMetrics", "enablePreConnect", "getEnablePreConnect", "enableWtnRtcPlayer", "getEnableWtnRtcPlayer", "getMetricsFromVqos", "getGetMetricsFromVqos", "innerSetting", "getInnerSetting", "listenTTVideoEnginePlayer", "getListenTTVideoEnginePlayer", "lynxNewApi", "getLynxNewApi", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerFeatureConfig {

    @SerializedName("enable_abr_control")
    private final boolean enableABRControl;

    @SerializedName("enable_audio_watermark")
    private final int enableAudioWatermark;

    @SerializedName("enable_feature_manager")
    private boolean enableFeatureManager;

    @SerializedName("enable_global_control")
    private final boolean enableGlobalControl;

    @SerializedName("enable_inner_timer")
    private final boolean enableInnerTimer;

    @SerializedName("enable_new_event_notify")
    private final boolean enableNewEventNotify;

    @SerializedName("enable_player_base_new")
    private final boolean enablePlayerBasenew;

    @SerializedName("enable_player_performance_data")
    private final boolean enablePlayerPerformanceData;

    @SerializedName("enable_player_used_metrics")
    private final boolean enablePlayerUsedMetrics;

    @SerializedName("enable_pre_connect")
    private final boolean enablePreConnect;

    @SerializedName("enable_wtn_rtc_player")
    private final boolean enableWtnRtcPlayer;

    @SerializedName("get_metrics_from_vqos")
    private final boolean getMetricsFromVqos;

    @SerializedName("inner_setting")
    private final boolean innerSetting;

    @SerializedName("listen_ttvideoengine_player")
    private final boolean listenTTVideoEnginePlayer;

    @SerializedName("lynx_new_api")
    private final boolean lynxNewApi;

    public PlayerFeatureConfig() {
        this.enableFeatureManager = true;
        this.enableInnerTimer = true;
        this.enableNewEventNotify = true;
        this.enableGlobalControl = true;
        this.enableABRControl = true;
        this.enableWtnRtcPlayer = true;
    }

    public final boolean getEnableABRControl() {
        return this.enableABRControl;
    }

    public final int getEnableAudioWatermark() {
        return this.enableAudioWatermark;
    }

    public final boolean getEnableFeatureManager() {
        return this.enableFeatureManager;
    }

    public final boolean getEnableGlobalControl() {
        return this.enableGlobalControl;
    }

    public final boolean getEnableInnerTimer() {
        return this.enableInnerTimer;
    }

    public final boolean getEnableNewEventNotify() {
        return this.enableNewEventNotify;
    }

    public final boolean getEnablePlayerBasenew() {
        return this.enablePlayerBasenew;
    }

    public final boolean getEnablePlayerPerformanceData() {
        return this.enablePlayerPerformanceData;
    }

    public final boolean getEnablePlayerUsedMetrics() {
        return this.enablePlayerUsedMetrics;
    }

    public final boolean getEnablePreConnect() {
        return this.enablePreConnect;
    }

    public final boolean getEnableWtnRtcPlayer() {
        return this.enableWtnRtcPlayer;
    }

    public final boolean getGetMetricsFromVqos() {
        return this.getMetricsFromVqos;
    }

    public final boolean getInnerSetting() {
        return this.innerSetting;
    }

    public final boolean getListenTTVideoEnginePlayer() {
        return this.listenTTVideoEnginePlayer;
    }

    public final boolean getLynxNewApi() {
        return this.lynxNewApi;
    }

    public final void setEnableFeatureManager(boolean r100) {
        this.enableFeatureManager = r100;
    }
}
