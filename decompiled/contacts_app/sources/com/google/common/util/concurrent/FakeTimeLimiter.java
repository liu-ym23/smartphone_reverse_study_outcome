package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class FakeTimeLimiter implements TimeLimiter {
    public FakeTimeLimiter() {
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T newProxy(T r1, Class<T> r2, long r3, TimeUnit r5) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r5);
        return r1;
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T callWithTimeout(Callable<T> r1, long r2, TimeUnit r4, boolean r5) throws Exception {
        Preconditions.checkNotNull(r4);
        return r1.call();
    }
}
