package org.apache.http.impl.bootstrap;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
class ThreadFactoryImpl implements ThreadFactory {
    private final AtomicLong count;
    private final ThreadGroup group;
    private final String namePrefix;

    public ThreadFactoryImpl(String r10, ThreadGroup r11) {
        this.namePrefix = r10;
        this.group = r11;
        this.count = new AtomicLong();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r10) {
        return new Thread(this.group, r10, this.namePrefix + "-" + this.count.incrementAndGet());
    }

    public ThreadFactoryImpl(String r10) {
        this(r10, null);
    }
}
