package com.jeffmony.async.future;

/* JADX INFO: loaded from: classes3.dex */
public interface ThenFutureCallback<T, F> {
    Future<T> then(F r10) throws Exception;
}
