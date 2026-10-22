package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes2.dex */
public interface AsyncFunction<I, O> {
    ListenableFuture<O> apply(I r1) throws Exception;
}
