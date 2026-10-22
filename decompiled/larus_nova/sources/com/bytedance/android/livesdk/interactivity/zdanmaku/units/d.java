package com.bytedance.android.livesdk.interactivity.zdanmaku.units;

import com.airbnb.lottie.LottieDrawable;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f141813a;

    public d(f r100) {
        this.f141813a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f141813a.f141822n.d();     // Catch: Throwable -> L7
        LottieDrawable r100 = this.f141813a.f141822n;     // Catch: Throwable -> L7
        u0.c r101 = r100.f24726c;     // Catch: Throwable -> L7
        if (r101.f548108k == false) goto L5;
        r101.cancel();     // Catch: Throwable -> L7
    L5:
        r100.f24725b = null;     // Catch: Throwable -> L7
        r100.f24738o = null;     // Catch: Throwable -> L7
        r100.f24732i = null;     // Catch: Throwable -> L7
        u0.c r102 = r100.f24726c;     // Catch: Throwable -> L7
        r102.f548107j = null;     // Catch: Throwable -> L7
        r102.f548105h = -2.1474836E9f;     // Catch: Throwable -> L7
        r102.f548106i = 2.1474836E9f;     // Catch: Throwable -> L7
        r100.invalidateSelf();     // Catch: Throwable -> L7
        this.f141813a.f141822n.setCallback(null);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
