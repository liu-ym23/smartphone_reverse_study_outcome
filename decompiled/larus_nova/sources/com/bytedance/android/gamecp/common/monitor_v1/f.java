package com.bytedance.android.gamecp.common.monitor_v1;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f56599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f56600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f56601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f56602d;

    public f(String r100, String r101, String r102, long r103) {
        this.f56599a = r100;
        this.f56600b = r101;
        this.f56601c = r102;
        this.f56602d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.gamecp.base.cache.c<String, FMPMonitorTracker.b> r100 = FMPMonitorTracker.f56549a;     // Catch: Throwable -> L10
        FMPMonitorTracker.b r101 = FMPMonitorTracker.f(this.f56599a, this.f56600b);     // Catch: Throwable -> L10
        if (r101 == null) goto L13;
        FMPMonitorTracker.a r102 = r101.f56566g.get(this.f56601c);     // Catch: Throwable -> L10
        if (r102 == null) goto L17;
        r102.f56558c = (this.f56602d - r101.f56563d) - r102.f56556a;     // Catch: Throwable -> L10
        return;
    L17:
        return;
    L13:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L18;
        throw th;
    }
}
