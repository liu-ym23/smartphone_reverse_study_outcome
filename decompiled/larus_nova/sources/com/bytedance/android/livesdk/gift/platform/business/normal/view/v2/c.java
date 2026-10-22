package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2;

import android.animation.Animator;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GamePlatformGiftCombView f129968a;

    public c(GamePlatformGiftCombView r100) {
        this.f129968a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        GamePlatformGiftCombView r100 = this.f129968a;     // Catch: Throwable -> L9
        r100.f129804c = r100.f129812k.c(r100, r100.f129817p);     // Catch: Throwable -> L9
        Animator r101 = this.f129968a.f129804c;     // Catch: Throwable -> L9
        if (r101 == null) goto L5;
        r101.start();     // Catch: Throwable -> L9
    L5:
        s02.a r102 = this.f129968a.f129813l;     // Catch: Throwable -> L9
        if (r102 == null) goto L12;
        r102.a();     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
