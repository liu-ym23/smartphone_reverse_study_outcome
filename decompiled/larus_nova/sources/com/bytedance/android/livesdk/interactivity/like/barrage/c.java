package com.bytedance.android.livesdk.interactivity.like.barrage;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ugc.live.barrage.barrage.AbsBarrage;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DiggController f137593a;

    public c(DiggController r100) {
        this.f137593a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AbsBarrage r100 = this.f137593a.g();     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        DiggController r101 = this.f137593a;     // Catch: Throwable -> L6
        int r102 = r101.f137578p.nextInt(r101.f137577o.size());     // Catch: Throwable -> L6
        ((d) ListProtector.get(this.f137593a.f137577o, r102)).a(r100, false);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
