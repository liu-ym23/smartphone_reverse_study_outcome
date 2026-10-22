package com.bytedance.android.livesdk.gift.vs.tray.view;

import android.animation.Animator;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VSGiftTrayAnimationView.d f132571a;

    public c(VSGiftTrayAnimationView.d r100) {
        this.f132571a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VSGiftTrayAnimationView.d r100 = this.f132571a;     // Catch: Throwable -> L9
        VSGiftTrayAnimationView r101 = r100.f132552a;     // Catch: Throwable -> L9
        r101.f132526b = r101.f132532h.c(r101, r100);     // Catch: Throwable -> L9
        Animator r102 = this.f132571a.f132552a.f132526b;     // Catch: Throwable -> L9
        if (r102 == null) goto L5;
        r102.start();     // Catch: Throwable -> L9
    L5:
        s02.a r103 = this.f132571a.f132552a.f132533i;     // Catch: Throwable -> L9
        if (r103 == null) goto L12;
        r103.a();     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
