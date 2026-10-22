package com.bytedance.android.live.componentsmarket.impl.components.title;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TitleTetris f64679a;

    public g(TitleTetris r100) {
        this.f64679a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TitleTetris r100 = this.f64679a;     // Catch: Throwable -> L6
        com.bytedance.android.livesdk.common.j r101 = r100.A;     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        r101.setTextWithFadingMode(r100.j0());     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
