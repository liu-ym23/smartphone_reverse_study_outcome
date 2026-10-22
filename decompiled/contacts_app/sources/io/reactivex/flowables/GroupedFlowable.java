package io.reactivex.flowables;

import io.reactivex.Flowable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class GroupedFlowable<K, T> extends Flowable<T> {
    final K key;

    protected GroupedFlowable(K r1) {
        this.key = r1;
    }

    public K getKey() {
        return this.key;
    }
}
