package com.bytedance.android.gamecp.common.monitor_v1;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f56589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f56590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f56591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f56592d;

    public c(String r100, boolean r101, String r102, String r103) {
        this.f56589a = r100;
        this.f56590b = r101;
        this.f56591c = r102;
        this.f56592d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.gamecp.base.cache.c<String, FMPMonitorTracker.b> r100 = FMPMonitorTracker.f56549a;     // Catch: Throwable -> L10
        FMPMonitorTracker.b r101 = FMPMonitorTracker.g(this.f56589a);     // Catch: Throwable -> L10
        if (r101 != null) goto L6;
    L15:
        return;
    L6:
        if (this.f56590b == false) goto L8;
        r101.f56568i.put(this.f56592d, this.f56591c);     // Catch: Throwable -> L10
        goto L15
    L8:
        r101.f56567h.put(this.f56592d, this.f56591c);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L18;
        throw th;
    }
}
