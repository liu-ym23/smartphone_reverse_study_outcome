package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.animation.AnimatorSet;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnimatorSet f127950a;

    public l(AnimatorSet r100) {
        this.f127950a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f127950a.start();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
