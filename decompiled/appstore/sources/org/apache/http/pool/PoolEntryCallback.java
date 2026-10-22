package org.apache.http.pool;

/* JADX INFO: loaded from: classes4.dex */
public interface PoolEntryCallback<T, C> {
    void process(PoolEntry<T, C> r10);
}
