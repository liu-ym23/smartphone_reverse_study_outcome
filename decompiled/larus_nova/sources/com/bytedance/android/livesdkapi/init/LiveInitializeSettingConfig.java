package com.bytedance.android.livesdkapi.init;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0018\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001e\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001e\u0010$\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdkapi/init/LiveInitializeSettingConfig;", "", "()V", "aiInitOpt", "", "getAiInitOpt", "()Z", "setAiInitOpt", "(Z)V", "featureInitOpt", "getFeatureInitOpt", "setFeatureInitOpt", "handleSchemaOpt", "getHandleSchemaOpt", "setHandleSchemaOpt", "ioThreadPoolSize", "", "getIoThreadPoolSize", "()I", "setIoThreadPoolSize", "(I)V", "liveRegisterServiceOpt", "getLiveRegisterServiceOpt", "setLiveRegisterServiceOpt", "preInitLiveOptV2", "getPreInitLiveOptV2", "setPreInitLiveOptV2", "resUtilGetOpt", "getResUtilGetOpt", "setResUtilGetOpt", "sdkLaunchTaskOpt", "getSdkLaunchTaskOpt", "setSdkLaunchTaskOpt", "strategyOptimizerOpt", "getStrategyOptimizerOpt", "setStrategyOptimizerOpt", "threadPoolSize", "getThreadPoolSize", "setThreadPoolSize", "Companion", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveInitializeSettingConfig {
    public static final Companion Companion = null;
    private static final String combindKey = null;
    private static final String combindVal = null;

    @SerializedName("ai_init_opt")
    private boolean aiInitOpt;

    @SerializedName("feature_init_opt")
    private boolean featureInitOpt;

    @SerializedName("handle_schema_opt")
    private boolean handleSchemaOpt;

    @SerializedName("schedule_io_thread_pool_size")
    private int ioThreadPoolSize;

    @SerializedName("live_register_service_opt")
    private boolean liveRegisterServiceOpt;

    @SerializedName("pre_init_live_opt_v2")
    private boolean preInitLiveOptV2;

    @SerializedName("res_util_get_opt")
    private boolean resUtilGetOpt;

    @SerializedName("sdk_launch_task_opt")
    private boolean sdkLaunchTaskOpt;

    @SerializedName("strategy_optimizer_opt")
    private boolean strategyOptimizerOpt;

    @SerializedName("schedule_thread_pool_size")
    private int threadPoolSize;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/init/LiveInitializeSettingConfig$Companion;", "", "()V", "combindKey", "", "getCombindKey", "()Ljava/lang/String;", "combindVal", "getCombindVal", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public final String getCombindKey() {
            return LiveInitializeSettingConfig.access$getCombindKey$cp();
        }

        public final String getCombindVal() {
            return LiveInitializeSettingConfig.access$getCombindVal$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        combindKey = "is_from_combine_";
        combindVal = "true";
    }

    public LiveInitializeSettingConfig() {
        this.threadPoolSize = 1;
        this.ioThreadPoolSize = 5;
    }

    public static final /* synthetic */ String access$getCombindKey$cp() {
        return combindKey;
    }

    public static final /* synthetic */ String access$getCombindVal$cp() {
        return combindVal;
    }

    public final boolean getAiInitOpt() {
        return this.aiInitOpt;
    }

    public final boolean getFeatureInitOpt() {
        return this.featureInitOpt;
    }

    public final boolean getHandleSchemaOpt() {
        return this.handleSchemaOpt;
    }

    public final int getIoThreadPoolSize() {
        return this.ioThreadPoolSize;
    }

    public final boolean getLiveRegisterServiceOpt() {
        return this.liveRegisterServiceOpt;
    }

    public final boolean getPreInitLiveOptV2() {
        return this.preInitLiveOptV2;
    }

    public final boolean getResUtilGetOpt() {
        return this.resUtilGetOpt;
    }

    public final boolean getSdkLaunchTaskOpt() {
        return this.sdkLaunchTaskOpt;
    }

    public final boolean getStrategyOptimizerOpt() {
        return this.strategyOptimizerOpt;
    }

    public final int getThreadPoolSize() {
        return this.threadPoolSize;
    }

    public final void setAiInitOpt(boolean r100) {
        this.aiInitOpt = r100;
    }

    public final void setFeatureInitOpt(boolean r100) {
        this.featureInitOpt = r100;
    }

    public final void setHandleSchemaOpt(boolean r100) {
        this.handleSchemaOpt = r100;
    }

    public final void setIoThreadPoolSize(int r100) {
        this.ioThreadPoolSize = r100;
    }

    public final void setLiveRegisterServiceOpt(boolean r100) {
        this.liveRegisterServiceOpt = r100;
    }

    public final void setPreInitLiveOptV2(boolean r100) {
        this.preInitLiveOptV2 = r100;
    }

    public final void setResUtilGetOpt(boolean r100) {
        this.resUtilGetOpt = r100;
    }

    public final void setSdkLaunchTaskOpt(boolean r100) {
        this.sdkLaunchTaskOpt = r100;
    }

    public final void setStrategyOptimizerOpt(boolean r100) {
        this.strategyOptimizerOpt = r100;
    }

    public final void setThreadPoolSize(int r100) {
        this.threadPoolSize = r100;
    }
}
