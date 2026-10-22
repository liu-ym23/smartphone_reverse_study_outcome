package com.bytedance.android.livesdk.gift.platform.business.dialog.v2;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f126626a;

    public b(a r100) {
        this.f126626a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f126626a.f126624a = null;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
