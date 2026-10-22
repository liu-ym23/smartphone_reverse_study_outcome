package com.bytedance.android.latch.internal.perf;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LatchPerfMetricCollector f58373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LatchPerfMetricCollector.PerfPoints f58374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f58375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f58376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f58377e;

    public f(LatchPerfMetricCollector r100, LatchPerfMetricCollector.PerfPoints r101, long r102, String r103, String r104) {
        this.f58373a = r100;
        this.f58374b = r101;
        this.f58375c = r102;
        this.f58376d = r103;
        this.f58377e = r104;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LatchPerfMetricCollector.a(this.f58373a, this.f58374b, this.f58375c, this.f58376d, this.f58377e);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
