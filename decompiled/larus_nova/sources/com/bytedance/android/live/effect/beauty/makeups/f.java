package com.bytedance.android.live.effect.beauty.makeups;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.c f67352a;

    public f(a.c r100) {
        this.f67352a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.c r100 = this.f67352a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.onError();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
