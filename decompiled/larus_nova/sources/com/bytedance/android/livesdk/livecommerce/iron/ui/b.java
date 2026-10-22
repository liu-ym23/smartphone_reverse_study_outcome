package com.bytedance.android.livesdk.livecommerce.iron.ui;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECCustomizedElementView.c.a f148988a;

    public b(ECCustomizedElementView.c.a r100) {
        this.f148988a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f148988a.f148882a.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).start();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
