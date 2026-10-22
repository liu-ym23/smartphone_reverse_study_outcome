package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public final class ThreadFactoryBuilder {
    private ThreadFactory backingThreadFactory;
    private Boolean daemon;
    private String nameFormat;
    private Integer priority;
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler;

    public ThreadFactoryBuilder() {
        this.nameFormat = null;
        this.daemon = null;
        this.priority = null;
        this.uncaughtExceptionHandler = null;
        this.backingThreadFactory = null;
    }

    public ThreadFactoryBuilder setNameFormat(String r4) {
        String.format(r4, new Object[]{0});
        this.nameFormat = r4;
        return this;
    }

    public ThreadFactoryBuilder setDaemon(boolean r1) {
        this.daemon = Boolean.valueOf(r1);
        return this;
    }

    public ThreadFactoryBuilder setPriority(int r7) {
        if (r7 < 1) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkArgument(r2, "Thread priority (%s) must be >= %s", new Object[]{Integer.valueOf(r7), 1});
        if (r7 > 10) goto L9;
        boolean r4 = true;
    L10:
        Preconditions.checkArgument(r4, "Thread priority (%s) must be <= %s", new Object[]{Integer.valueOf(r7), 10});
        this.priority = Integer.valueOf(r7);
        return this;
    L9:
        r4 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    public ThreadFactoryBuilder setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler r1) {
        this.uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler) Preconditions.checkNotNull(r1);
        return this;
    }

    public ThreadFactoryBuilder setThreadFactory(ThreadFactory r1) {
        this.backingThreadFactory = (ThreadFactory) Preconditions.checkNotNull(r1);
        return this;
    }

    public ThreadFactory build() {
        return build(this);
    }

    private static ThreadFactory build(ThreadFactoryBuilder r9) {
        final String r2 = r9.nameFormat;
        final Boolean r4 = r9.daemon;
        final Integer r5 = r9.priority;
        final Thread.UncaughtExceptionHandler r6 = r9.uncaughtExceptionHandler;
        ThreadFactory r10 = r9.backingThreadFactory;
        if (r10 != null) goto L6;
        r10 = Executors.defaultThreadFactory();
    L6:
        final ThreadFactory r1 = r10;
        if (r2 == null) goto L9;
        AtomicLong r11 = new AtomicLong(0);
    L10:
        final AtomicLong r3 = r11;
        return new AnonymousClass1(r1, r2, r3, r4, r5, r6);
    L9:
        r11 = null;
        goto L10
    }
}
