package com.google.common.util.concurrent;

import java.lang.Exception;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractCheckedFuture<V, X extends Exception> extends ForwardingListenableFuture.SimpleForwardingListenableFuture<V> implements CheckedFuture<V, X> {
    protected abstract X mapException(Exception r1);

    protected AbstractCheckedFuture(ListenableFuture<V> r1) {
        super(r1);
    }

    @Override // com.google.common.util.concurrent.CheckedFuture
    public V checkedGet() throws Exception {
        return get();
    L10:
        e = move-exception;
        Thread.currentThread().interrupt();
        throw mapException(e);
    L7:
        e = move-exception;
        throw mapException(e);
    L4:
        e = move-exception;
        throw mapException(e);
    }

    @Override // com.google.common.util.concurrent.CheckedFuture
    public V checkedGet(long r1, TimeUnit r3) throws TimeoutException, Exception {
        return get(r1, r3);
    L10:
        e = move-exception;
        Thread.currentThread().interrupt();
        throw mapException(e);
    L7:
        e = move-exception;
        throw mapException(e);
    L4:
        e = move-exception;
        throw mapException(e);
    }
}
