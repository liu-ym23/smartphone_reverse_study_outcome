package com.bytedance.android.ec.window.base.common.bubble;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f49146a;

    public s(r r100) {
        this.f49146a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r r100 = this.f49146a;     // Catch: Throwable -> L9
        if (r100.f49136g <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L12;
        r100.a(false);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L5:
        r101 = false;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
