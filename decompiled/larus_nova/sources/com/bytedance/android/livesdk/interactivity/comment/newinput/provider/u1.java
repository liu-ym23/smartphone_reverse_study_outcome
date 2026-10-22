package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class u1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t1.c f135995a;

    public u1(t1.c r100) {
        this.f135995a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f135995a.h();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
