package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerPerformanceConfig;", "", "()V", "enableCostTracer", "", "getEnableCostTracer", "()Z", "sampleValue", "", "getSampleValue", "()I", "seiCostTracer", "getSeiCostTracer", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerPerformanceConfig {

    @SerializedName("enable_cost_tracer")
    private final boolean enableCostTracer;

    @SerializedName("sample_value")
    private final int sampleValue;

    @SerializedName("sei_cost_trace")
    private final boolean seiCostTracer;

    public PlayerPerformanceConfig() {
        this.sampleValue = 5;
    }

    public final boolean getEnableCostTracer() {
        return this.enableCostTracer;
    }

    public final int getSampleValue() {
        return this.sampleValue;
    }

    public final boolean getSeiCostTracer() {
        return this.seiCostTracer;
    }
}
