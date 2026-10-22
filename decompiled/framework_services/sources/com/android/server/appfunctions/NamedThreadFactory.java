package com.android.server.appfunctions;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class NamedThreadFactory implements ThreadFactory {
    private final String mBaseName;
    private final AtomicInteger mCount;
    private final ThreadFactory mDefaultThreadFactory;

    public NamedThreadFactory(String baseName) {
        this.mCount = new AtomicInteger(0);
        this.mDefaultThreadFactory = Executors.defaultThreadFactory();
        this.mBaseName = baseName;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = this.mDefaultThreadFactory.newThread(runnable);
        thread.setName(this.mBaseName + "-" + this.mCount.getAndIncrement());
        return thread;
    }
}
