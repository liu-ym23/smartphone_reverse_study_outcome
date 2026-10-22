package com.bytedance.android.livesdk.interactivity.like.view;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DiggTabCountView f137955a;

    public s(DiggTabCountView r100) {
        this.f137955a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f137955a.f137859j.c();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
