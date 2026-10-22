package com.bytedance.android.live.core.cache;

import io.reactivex.Observable;

/* JADX INFO: loaded from: classes45.dex */
public interface Cache<K, V> {
    void clear();

    void delete(K r100);

    V get(K r100);

    Observable<V> observe(K r100);

    void put(K r100, V r101);
}
