package com.bytedance.android.livesdk.interactivity.zdanmaku.units;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f141814a;

    public e(f r100) {
        this.f141814a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f141814a.f141822n.k();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
