package com.jeffmony.async.future;

/* JADX INFO: loaded from: classes3.dex */
public interface FailRecoverCallback<T> {
    Future<T> fail(Exception r10) throws Exception;
}
