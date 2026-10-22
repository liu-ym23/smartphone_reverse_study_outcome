package org.apache.http.concurrent;

/* JADX INFO: loaded from: classes4.dex */
public interface FutureCallback<T> {
    void cancelled();

    void completed(T r10);

    void failed(Exception r10);
}
