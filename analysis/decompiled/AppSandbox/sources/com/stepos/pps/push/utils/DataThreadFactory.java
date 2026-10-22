package com.stepos.pps.push.utils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class DataThreadFactory implements ThreadFactory {
    private final String mNamePrefix;
    private final AtomicInteger mNextId = new AtomicInteger(1);

    public DataThreadFactory(String str) {
        this.mNamePrefix = "From DataThreadFactory's" + str + "-Worker-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.mNamePrefix + this.mNextId.getAndIncrement());
    }
}
