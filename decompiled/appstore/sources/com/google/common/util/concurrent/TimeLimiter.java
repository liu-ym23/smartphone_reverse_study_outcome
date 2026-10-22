package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public interface TimeLimiter {
    @CanIgnoreReturnValue
    <T> T callUninterruptiblyWithTimeout(Callable<T> r10, long r11, TimeUnit r12) throws TimeoutException, ExecutionException;

    @CanIgnoreReturnValue
    <T> T callWithTimeout(Callable<T> r10, long r11, TimeUnit r12) throws TimeoutException, InterruptedException, ExecutionException;

    <T> T newProxy(T r10, Class<T> r11, long r12, TimeUnit r13);

    void runUninterruptiblyWithTimeout(Runnable r10, long r11, TimeUnit r12) throws TimeoutException;

    void runWithTimeout(Runnable r10, long r11, TimeUnit r12) throws TimeoutException, InterruptedException;
}
