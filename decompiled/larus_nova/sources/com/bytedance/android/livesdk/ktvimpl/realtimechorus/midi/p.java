package com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RealTimeChorusMidiWidget f146831a;

    public p(RealTimeChorusMidiWidget r100) {
        this.f146831a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b r100 = this.f146831a.f146780n;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.c();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
