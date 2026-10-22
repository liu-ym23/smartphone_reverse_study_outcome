package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public interface TimeLimiter {
    <T> T callWithTimeout(Callable<T> r1, long r2, TimeUnit r4, boolean r5) throws Exception;

    <T> T newProxy(T r1, Class<T> r2, long r3, TimeUnit r5);
}
