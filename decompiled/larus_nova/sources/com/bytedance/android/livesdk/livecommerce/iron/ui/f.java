package com.bytedance.android.livesdk.livecommerce.iron.ui;

import com.bytedance.android.ec.model.live.t;
import com.larus.apm.impl.protector.RunnableProtector;
import sg2.v;

/* JADX INFO: loaded from: classes10.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ xi2.j f148998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ gi2.a f148999b;

    public f(xi2.j r100, gi2.a r101) {
        this.f148998a = r100;
        this.f148999b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t r100 = this.f148998a.i();     // Catch: Throwable -> L16
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.b() == null) goto L23;
        String r101 = r100.b();     // Catch: Throwable -> L16
        if (r101 != null) goto L10;
        r101 = "";
    L10:
        com.bytedance.android.ec.common.api.jump.model.a r102 = this.f148999b;     // Catch: Throwable -> L16
        if (r102 != null) goto L14;
        r102 = com.bytedance.android.ec.common.api.jump.model.b.f42853a;     // Catch: Throwable -> L16
    L14:
        v r103 = new v(r101, r102);     // Catch: Throwable -> L16
        r103.d(r100.c());     // Catch: Throwable -> L16
        r103.i("a1.b0715.c9204.d242353");     // Catch: Throwable -> L16
        return;
    L23:
        return;
    L16:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L24;
        throw th;
    }
}
