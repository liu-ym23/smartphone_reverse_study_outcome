package com.bytedance.android.latch.internal.perf;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LatchPerfMetricCollector f58381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f58382b;

    public h(LatchPerfMetricCollector r100) {
        this.f58381a = r100;
        this.f58382b = "native";
    }

    @Override // java.lang.Runnable
    public final void run() {
        LatchPerfMetricCollector r100 = this.f58381a;     // Catch: Throwable -> L4
        r100.f58334r = this.f58382b;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
