package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes2.dex */
public interface FutureFallback<V> {
    ListenableFuture<V> create(Throwable r1) throws Exception;
}
