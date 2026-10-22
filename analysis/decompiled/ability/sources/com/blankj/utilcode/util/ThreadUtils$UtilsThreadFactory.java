package com.blankj.utilcode.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
final class ThreadUtils$UtilsThreadFactory extends AtomicLong implements ThreadFactory {
    public static final AtomicInteger c = new AtomicInteger(1);

    /* renamed from: a, reason: collision with root package name */
    public final String f2199a;
    public final int b;

    public ThreadUtils$UtilsThreadFactory(String str) {
        StringBuilder sbX = androidx.appfunctions.metadata.a.x(str, "-pool-");
        sbX.append(c.getAndIncrement());
        sbX.append("-thread-");
        this.f2199a = sbX.toString();
        this.b = 5;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        E2.b bVar = new E2.b(runnable, this.f2199a + getAndIncrement());
        bVar.setDaemon(false);
        bVar.setUncaughtExceptionHandler(new h());
        bVar.setPriority(this.b);
        return bVar;
    }
}
