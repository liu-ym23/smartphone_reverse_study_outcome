package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
@CanIgnoreReturnValue
@GwtIncompatible
abstract class WrappingScheduledExecutorService extends WrappingExecutorService implements ScheduledExecutorService {
    final ScheduledExecutorService delegate;

    public WrappingScheduledExecutorService(ScheduledExecutorService r10) {
        super(r10);
        this.delegate = r10;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture<?> schedule(Runnable r10, long r11, TimeUnit r12) {
        return this.delegate.schedule(wrapTask(r10), r11, r12);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture<?> scheduleAtFixedRate(Runnable r10, long r11, long r12, TimeUnit r13) {
        return this.delegate.scheduleAtFixedRate(wrapTask(r10), r11, r12, r13);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture<?> scheduleWithFixedDelay(Runnable r10, long r11, long r12, TimeUnit r13) {
        return this.delegate.scheduleWithFixedDelay(wrapTask(r10), r11, r12, r13);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final <V> ScheduledFuture<V> schedule(Callable<V> r10, long r11, TimeUnit r12) {
        return this.delegate.schedule(wrapTask(r10), r11, r12);
    }
}
