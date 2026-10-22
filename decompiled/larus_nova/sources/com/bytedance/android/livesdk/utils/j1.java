package com.bytedance.android.livesdk.utils;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class j1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k1 f158990a;

    public j1(k1 r100) {
        this.f158990a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f158990a.f159005a = true;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
