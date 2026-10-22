package io.reactivex.internal.util;

import io.reactivex.internal.schedulers.NonBlockingThread;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {
    public static void a() {
        if (qf.a.c() == true) goto L5;
        return;
    L5:
        if ((Thread.currentThread() instanceof NonBlockingThread) == true) goto L10;
        if (qf.a.d() == true) goto L10;
        return;
    L10:
        throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
    }
}
