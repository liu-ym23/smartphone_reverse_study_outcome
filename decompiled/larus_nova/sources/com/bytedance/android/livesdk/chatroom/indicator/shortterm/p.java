package com.bytedance.android.livesdk.chatroom.indicator.shortterm;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f106676a;

    public p(n r100) {
        this.f106676a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f106676a.c();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
