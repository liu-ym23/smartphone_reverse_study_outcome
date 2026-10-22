package com.bytedance.android.shopping.store.slicecard.viewmanager;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f186427a;

    public j(i r100) {
        this.f186427a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        gk3.a r100 = this.f186427a.o1();     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.d(this.f186427a.k1());     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
