package com.bytedance.android.livesdkapi.init;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\u001a\u0010\u000e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdkapi/init/LiveInitConfigInner;", "", "()V", "isLiveInitArcOpt", "", "()Z", "setLiveInitArcOpt", "(Z)V", "lazyInitTopService", "getLazyInitTopService", "setLazyInitTopService", "revenueInitPre", "getRevenueInitPre", "setRevenueInitPre", "ttlivecontextInit", "getTtlivecontextInit", "setTtlivecontextInit", "unitPostDelayConfig", "Lcom/bytedance/android/livesdkapi/init/InitUnitPostDelayConfig;", "getUnitPostDelayConfig", "()Lcom/bytedance/android/livesdkapi/init/InitUnitPostDelayConfig;", "setUnitPostDelayConfig", "(Lcom/bytedance/android/livesdkapi/init/InitUnitPostDelayConfig;)V", "unitThreadConfig", "Lcom/bytedance/android/livesdkapi/init/InitUnitThreadConfig;", "getUnitThreadConfig", "()Lcom/bytedance/android/livesdkapi/init/InitUnitThreadConfig;", "setUnitThreadConfig", "(Lcom/bytedance/android/livesdkapi/init/InitUnitThreadConfig;)V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveInitConfigInner {
    private boolean isLiveInitArcOpt;
    private boolean lazyInitTopService;
    private boolean revenueInitPre;
    private boolean ttlivecontextInit;
    private InitUnitPostDelayConfig unitPostDelayConfig;
    private InitUnitThreadConfig unitThreadConfig;

    public LiveInitConfigInner() {
        this.unitThreadConfig = new InitUnitThreadConfig();
        this.unitPostDelayConfig = new InitUnitPostDelayConfig();
    }

    public final boolean getLazyInitTopService() {
        return this.lazyInitTopService;
    }

    public final boolean getRevenueInitPre() {
        return this.revenueInitPre;
    }

    public final boolean getTtlivecontextInit() {
        return this.ttlivecontextInit;
    }

    public final InitUnitPostDelayConfig getUnitPostDelayConfig() {
        return this.unitPostDelayConfig;
    }

    public final InitUnitThreadConfig getUnitThreadConfig() {
        return this.unitThreadConfig;
    }

    public final boolean isLiveInitArcOpt() {
        return this.isLiveInitArcOpt;
    }

    public final void setLazyInitTopService(boolean r100) {
        this.lazyInitTopService = r100;
    }

    public final void setLiveInitArcOpt(boolean r100) {
        this.isLiveInitArcOpt = r100;
    }

    public final void setRevenueInitPre(boolean r100) {
        this.revenueInitPre = r100;
    }

    public final void setTtlivecontextInit(boolean r100) {
        this.ttlivecontextInit = r100;
    }

    public final void setUnitPostDelayConfig(InitUnitPostDelayConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.unitPostDelayConfig = r100;
    }

    public final void setUnitThreadConfig(InitUnitThreadConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.unitThreadConfig = r100;
    }
}
