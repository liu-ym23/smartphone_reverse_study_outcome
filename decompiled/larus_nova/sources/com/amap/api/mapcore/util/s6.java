package com.amap.api.mapcore.util;

import android.os.Looper;

/* JADX INFO: loaded from: classes28.dex */
final class s6 extends a9 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ w5 f27956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f27957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ t6 f27958d;

    @Override // com.amap.api.mapcore.util.a9
    public final void runTask() {
        Looper r100 = Looper.getMainLooper();     // Catch: Throwable -> L13
        monitor-enter(r100);     // Catch: Throwable -> L13
        q6.a(this.f27956b);     // Catch: Throwable -> L10
        monitor-exit(r100);     // Catch: Throwable -> L10
    L7:
        if (this.f27957c == false) goto L19;
        u6.a(t6.a(this.f27958d));     // Catch: Throwable -> L13
        return;
    L19:
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.printStackTrace();
    }

    public s6(t6 r100, w5 r101, boolean r102) {
        this.f27958d = r100;
        this.f27956b = r101;
        this.f27957c = r102;
    }
}
