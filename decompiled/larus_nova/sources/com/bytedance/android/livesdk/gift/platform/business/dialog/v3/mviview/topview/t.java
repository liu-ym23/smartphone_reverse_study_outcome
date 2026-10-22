package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.animation.AnimatorSet;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnimatorSet f128138a;

    public t(AnimatorSet r100) {
        this.f128138a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f128138a.start();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
