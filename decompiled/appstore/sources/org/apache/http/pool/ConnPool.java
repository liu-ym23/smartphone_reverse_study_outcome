package org.apache.http.pool;

import java.util.concurrent.Future;
import org.apache.http.concurrent.FutureCallback;

/* JADX INFO: loaded from: classes4.dex */
public interface ConnPool<T, E> {
    Future<E> lease(T r10, Object r11, FutureCallback<E> r12);

    void release(E r10, boolean r11);
}
