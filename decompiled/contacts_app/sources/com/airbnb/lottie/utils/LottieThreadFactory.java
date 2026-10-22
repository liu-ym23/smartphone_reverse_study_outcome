package com.airbnb.lottie.utils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class LottieThreadFactory implements ThreadFactory {
    private static final AtomicInteger poolNumber = null;
    private final ThreadGroup group;
    private final String namePrefix;
    private final AtomicInteger threadNumber;

    static {
        poolNumber = new AtomicInteger(1);
    }

    public LottieThreadFactory() {
        this.threadNumber = new AtomicInteger(1);
        SecurityManager r0 = System.getSecurityManager();
        if (r0 != null) goto L5;
        ThreadGroup r1 = Thread.currentThread().getThreadGroup();
    L6:
        this.group = r1;
        this.namePrefix = "lottie-" + poolNumber.getAndIncrement() + "-thread-";
        return;
    L5:
        r1 = r0.getThreadGroup();
        goto L6
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r8) {
        Thread r6 = new Thread(this.group, r8, this.namePrefix + this.threadNumber.getAndIncrement(), 0);
        r6.setDaemon(false);
        r6.setPriority(10);
        return r6;
    }
}
