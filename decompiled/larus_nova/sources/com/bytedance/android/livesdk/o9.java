package com.bytedance.android.livesdk;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class o9 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Exception f154132a;

    public o9(Exception r100) {
        this.f154132a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    L3:
        throw this.f154132a;     // Catch: Throwable -> L4
    }
}
