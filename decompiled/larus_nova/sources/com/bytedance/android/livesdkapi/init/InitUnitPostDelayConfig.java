package com.bytedance.android.livesdkapi.init;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/init/InitUnitPostDelayConfig;", "", "()V", "commonDelayTime", "", "getCommonDelayTime", "()J", "setCommonDelayTime", "(J)V", "ensureLazyTime", "getEnsureLazyTime", "setEnsureLazyTime", "revenueDelayTime", "getRevenueDelayTime", "setRevenueDelayTime", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InitUnitPostDelayConfig {

    @SerializedName("common_delay_time")
    private long commonDelayTime;

    @SerializedName("ensure_lazy_time")
    private long ensureLazyTime;

    @SerializedName("revenue_delay_time")
    private long revenueDelayTime;

    public InitUnitPostDelayConfig() {
    }

    public final long getCommonDelayTime() {
        return this.commonDelayTime;
    }

    public final long getEnsureLazyTime() {
        return this.ensureLazyTime;
    }

    public final long getRevenueDelayTime() {
        return this.revenueDelayTime;
    }

    public final void setCommonDelayTime(long r100) {
        this.commonDelayTime = r100;
    }

    public final void setEnsureLazyTime(long r100) {
        this.ensureLazyTime = r100;
    }

    public final void setRevenueDelayTime(long r100) {
        this.revenueDelayTime = r100;
    }
}
