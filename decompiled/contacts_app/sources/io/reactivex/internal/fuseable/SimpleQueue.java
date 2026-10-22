package io.reactivex.internal.fuseable;

/* JADX INFO: loaded from: classes4.dex */
public interface SimpleQueue<T> {
    void clear();

    boolean isEmpty();

    boolean offer(T r1);

    boolean offer(T r1, T r2);

    T poll() throws Exception;
}
