package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\r\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PreConnectConfig;", "", "()V", "delayedTime", "", "getDelayedTime", "()J", "enabled", "", "getEnabled", "()Z", "optimizeV2", "getOptimizeV2", "resolutionEnabled", "getResolutionEnabled", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PreConnectConfig {

    @SerializedName("delayed_time")
    private final long delayedTime;

    @SerializedName("enabled")
    private final boolean enabled;

    @SerializedName("optimize_v2")
    private final boolean optimizeV2;

    @SerializedName("resolution_enabled")
    private final boolean resolutionEnabled;

    public PreConnectConfig() {
        this.delayedTime = -1;
    }

    public final long getDelayedTime() {
        return this.delayedTime;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final boolean getOptimizeV2() {
        return this.optimizeV2;
    }

    public final boolean getResolutionEnabled() {
        return this.resolutionEnabled;
    }
}
