package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerResolutionOptimizeConfig;", "", "()V", "enableCostOptimize", "", "getEnableCostOptimize", "()Z", "setEnableCostOptimize", "(Z)V", "enableResolutionFallbackOptimize", "getEnableResolutionFallbackOptimize", "setEnableResolutionFallbackOptimize", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerResolutionOptimizeConfig {

    @SerializedName("enable_cost_optimize")
    private boolean enableCostOptimize;

    @SerializedName("enable_resolution_fallback_optimize")
    private boolean enableResolutionFallbackOptimize;

    public PlayerResolutionOptimizeConfig() {
        this.enableResolutionFallbackOptimize = true;
    }

    public final boolean getEnableCostOptimize() {
        return this.enableCostOptimize;
    }

    public final boolean getEnableResolutionFallbackOptimize() {
        return this.enableResolutionFallbackOptimize;
    }

    public final void setEnableCostOptimize(boolean r100) {
        this.enableCostOptimize = r100;
    }

    public final void setEnableResolutionFallbackOptimize(boolean r100) {
        this.enableResolutionFallbackOptimize = r100;
    }
}
