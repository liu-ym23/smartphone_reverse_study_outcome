package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
@CanIgnoreReturnValue
@GwtIncompatible
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

    public static /* synthetic */ String access$000(String r10, Object[] r11) {
        return format(r10, r11);
    }

    private static ThreadFactory doBuild(ThreadFactoryBuilder r10) {
        final String r11 = r10.nameFormat;
        final Boolean r12 = r10.daemon;
        final Integer r13 = r10.priority;
        final Thread.UncaughtExceptionHandler r14 = r10.uncaughtExceptionHandler;
        ThreadFactory r15 = r10.backingThreadFactory;
        if (r15 == null) goto L5;
    L4:
        final ThreadFactory r16 = r15;
        if (r11 == null) goto L9;
        AtomicLong r17 = new AtomicLong(0);
    L8:
        final AtomicLong r18 = r17;
        return new AnonymousClass1(r16, r11, r18, r12, r13, r14);
    L9:
        r17 = null;
        goto L8
    L5:
        r15 = Executors.defaultThreadFactory();
        goto L4
    }

    private static String format(String r10, Object... r11) {
        return String.format(Locale.ROOT, r10, r11);
    }

    @CheckReturnValue
    public ThreadFactory build() {
        return doBuild(this);
    }

    public ThreadFactoryBuilder setDaemon(boolean r10) {
        this.daemon = Boolean.valueOf(r10);
        return this;
    }

    public ThreadFactoryBuilder setNameFormat(String r10) {
        format(r10, new Object[]{0});
        this.nameFormat = r10;
        return this;
    }

    public ThreadFactoryBuilder setPriority(int r10) {
        boolean r11 = false;
        if (r10 < 1) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12, "Thread priority (%s) must be >= %s", r10, 1);
        if (r10 > 10) goto L9;
        r11 = true;
    L9:
        Preconditions.checkArgument(r11, "Thread priority (%s) must be <= %s", r10, 10);
        this.priority = Integer.valueOf(r10);
        return this;
    L5:
        r12 = false;
        goto L6
    }

    public ThreadFactoryBuilder setThreadFactory(ThreadFactory r10) {
        this.backingThreadFactory = (ThreadFactory) Preconditions.checkNotNull(r10);
        return this;
    }

    public ThreadFactoryBuilder setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler r10) {
        this.uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler) Preconditions.checkNotNull(r10);
        return this;
    }
}
