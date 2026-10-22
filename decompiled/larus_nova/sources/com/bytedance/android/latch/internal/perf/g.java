package com.bytedance.android.latch.internal.perf;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LatchPerfMetricCollector f58378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ hx.a f58379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.latch.a.d f58380c;

    public g(LatchPerfMetricCollector r100, hx.a r101, com.bytedance.android.latch.a.d r102) {
        this.f58378a = r100;
        this.f58379b = r101;
        this.f58380c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LatchPerfMetricCollector.b(this.f58378a, this.f58379b, this.f58380c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
