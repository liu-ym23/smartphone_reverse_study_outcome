package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
@CanIgnoreReturnValue
@Beta
@GwtIncompatible
public final class FakeTimeLimiter implements TimeLimiter {
    public FakeTimeLimiter() {
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T callUninterruptiblyWithTimeout(Callable<T> r10, long r11, TimeUnit r12) throws ExecutionException {
        return (T) callWithTimeout(r10, r11, r12);
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T callWithTimeout(Callable<T> r10, long r11, TimeUnit r12) throws ExecutionException {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r12);
        return r10.call();
    L8:
        e = move-exception;
        throw new ExecutionError(e);
    L14:
        e = move-exception;
        throw new UncheckedExecutionException(e);
    L11:
        e = move-exception;
        throw new ExecutionException(e);
    L5:
        th = move-exception;
        throw new ExecutionException(th);
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T newProxy(T r10, Class<T> r11, long r12, TimeUnit r13) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        Preconditions.checkNotNull(r13);
        return r10;
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runUninterruptiblyWithTimeout(Runnable r10, long r11, TimeUnit r12) {
        runWithTimeout(r10, r11, r12);
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runWithTimeout(Runnable r10, long r11, TimeUnit r12) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r12);
        r10.run();     // Catch: Throwable -> L5 Error -> L8 RuntimeException -> L11
        return;
    L8:
        e = move-exception;
        throw new ExecutionError(e);
    L11:
        e = move-exception;
        throw new UncheckedExecutionException(e);
    L5:
        th = move-exception;
        throw new UncheckedExecutionException(th);
    }
}
