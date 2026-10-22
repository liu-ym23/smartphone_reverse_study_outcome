package com.bytedance.android.livesdkapi.depend.model.live;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/StrategyInitConfig;", "", "()V", "enableInitOpt", "", "getEnableInitOpt", "()Z", "setEnableInitOpt", "(Z)V", "enableStrategyInitCache", "getEnableStrategyInitCache", "setEnableStrategyInitCache", "enableUseSliceStrategy", "getEnableUseSliceStrategy", "setEnableUseSliceStrategy", "featureUpdateInterval", "", "getFeatureUpdateInterval", "()J", "setFeatureUpdateInterval", "(J)V", "strategyInitFactors", "", "", "getStrategyInitFactors", "()Ljava/util/List;", "setStrategyInitFactors", "(Ljava/util/List;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class StrategyInitConfig {

    @SerializedName("enable_init_opt")
    private boolean enableInitOpt;

    @SerializedName("enable_strategy_init_cache")
    private boolean enableStrategyInitCache;

    @SerializedName("enable_use_slice_strategy")
    private boolean enableUseSliceStrategy;

    @SerializedName("feature_update_interval")
    private long featureUpdateInterval;

    @SerializedName("strategy_init_factors")
    private List<String> strategyInitFactors;

    public StrategyInitConfig() {
        this.strategyInitFactors = new ArrayList();
        this.enableStrategyInitCache = true;
        this.featureUpdateInterval = 15;
    }

    public final boolean getEnableInitOpt() {
        return this.enableInitOpt;
    }

    public final boolean getEnableStrategyInitCache() {
        return this.enableStrategyInitCache;
    }

    public final boolean getEnableUseSliceStrategy() {
        return this.enableUseSliceStrategy;
    }

    public final long getFeatureUpdateInterval() {
        return this.featureUpdateInterval;
    }

    public final List<String> getStrategyInitFactors() {
        return this.strategyInitFactors;
    }

    public final void setEnableInitOpt(boolean r100) {
        this.enableInitOpt = r100;
    }

    public final void setEnableStrategyInitCache(boolean r100) {
        this.enableStrategyInitCache = r100;
    }

    public final void setEnableUseSliceStrategy(boolean r100) {
        this.enableUseSliceStrategy = r100;
    }

    public final void setFeatureUpdateInterval(long r100) {
        this.featureUpdateInterval = r100;
    }

    public final void setStrategyInitFactors(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.strategyInitFactors = r100;
    }
}
