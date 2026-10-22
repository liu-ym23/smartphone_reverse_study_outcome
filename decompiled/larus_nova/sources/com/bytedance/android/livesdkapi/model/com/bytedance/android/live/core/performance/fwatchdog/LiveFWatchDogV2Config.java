package com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.performance.fwatchdog;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001e\u0010!\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\u001e\u0010$\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001dR\u001e\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\b¨\u0006*"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/live/core/performance/fwatchdog/LiveFWatchDogV2Config;", "", "()V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "enableFallback", "getEnableFallback", "setEnableFallback", "enableLog", "getEnableLog", "setEnableLog", "enableRetryReflect", "getEnableRetryReflect", "setEnableRetryReflect", "enterStartDelay", "", "getEnterStartDelay", "()J", "setEnterStartDelay", "(J)V", "logLevel", "", "getLogLevel", "()I", "setLogLevel", "(I)V", "maxSdkApi", "getMaxSdkApi", "setMaxSdkApi", "minSdkApi", "getMinSdkApi", "setMinSdkApi", "onVsyncActionStrategy", "getOnVsyncActionStrategy", "setOnVsyncActionStrategy", "stopWhenContainerStop", "getStopWhenContainerStop", "setStopWhenContainerStop", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFWatchDogV2Config {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_fallback")
    private boolean enableFallback;

    @SerializedName("enable_log")
    private boolean enableLog;

    @SerializedName("enable_reflect_retry")
    private boolean enableRetryReflect;

    @SerializedName("enter_start_delay")
    private long enterStartDelay;

    @SerializedName("log_level")
    private int logLevel;

    @SerializedName("max_sdk_api")
    private int maxSdkApi;

    @SerializedName("min_sdk_api")
    private int minSdkApi;

    @SerializedName("on_vsync_action_strategy")
    private int onVsyncActionStrategy;

    @SerializedName("stop_when_container_stop")
    private boolean stopWhenContainerStop;

    public LiveFWatchDogV2Config() {
        this.logLevel = 2;
        this.minSdkApi = 28;
        this.maxSdkApi = 35;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getEnableFallback() {
        return this.enableFallback;
    }

    public final boolean getEnableLog() {
        return this.enableLog;
    }

    public final boolean getEnableRetryReflect() {
        return this.enableRetryReflect;
    }

    public final long getEnterStartDelay() {
        return this.enterStartDelay;
    }

    public final int getLogLevel() {
        return this.logLevel;
    }

    public final int getMaxSdkApi() {
        return this.maxSdkApi;
    }

    public final int getMinSdkApi() {
        return this.minSdkApi;
    }

    public final int getOnVsyncActionStrategy() {
        return this.onVsyncActionStrategy;
    }

    public final boolean getStopWhenContainerStop() {
        return this.stopWhenContainerStop;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setEnableFallback(boolean r100) {
        this.enableFallback = r100;
    }

    public final void setEnableLog(boolean r100) {
        this.enableLog = r100;
    }

    public final void setEnableRetryReflect(boolean r100) {
        this.enableRetryReflect = r100;
    }

    public final void setEnterStartDelay(long r100) {
        this.enterStartDelay = r100;
    }

    public final void setLogLevel(int r100) {
        this.logLevel = r100;
    }

    public final void setMaxSdkApi(int r100) {
        this.maxSdkApi = r100;
    }

    public final void setMinSdkApi(int r100) {
        this.minSdkApi = r100;
    }

    public final void setOnVsyncActionStrategy(int r100) {
        this.onVsyncActionStrategy = r100;
    }

    public final void setStopWhenContainerStop(boolean r100) {
        this.stopWhenContainerStop = r100;
    }
}
