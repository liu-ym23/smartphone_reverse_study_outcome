package com.bytedance.android.live.core.cache;

import io.reactivex.Observable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public class LruCache<K, V> implements Cache<K, V> {
    private static final int DEFAULT_CAPACITY = 8;
    private static final int REMOVE_ALL = -1;
    private Map<K, V> map;
    private int maxMemorySize;
    private int memorySize;

    @Override // com.bytedance.android.live.core.cache.Cache
    public final synchronized void clear() {
        monitor-enter(this);
        trimToSize(-1);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public int getValueSize(V r100) {
        return 1;
    }

    @Override // com.bytedance.android.live.core.cache.Cache
    public Observable<V> observe(K r100) {
        return null;
    }

    public final synchronized Map<K, V> snapshot() {
        monitor-enter(this);
        LinkedHashMap r100 = new LinkedHashMap(this.map);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized String toString() {
        monitor-enter(this);
        StringBuilder r100 = new StringBuilder();     // Catch: Throwable -> L10
        Iterator<Map.Entry<K, V>> r101 = this.map.entrySet().iterator();     // Catch: Throwable -> L10
    L5:
        if (r101.hasNext() == false) goto L7;
        Map.Entry<K, V> r102 = r101.next();     // Catch: Throwable -> L10
        r100.append(r102.getKey());     // Catch: Throwable -> L10
        r100.append(com.alipay.sdk.m.n.a.f25612h);     // Catch: Throwable -> L10
        r100.append(r102.getValue());     // Catch: Throwable -> L10
        r100.append(",");     // Catch: Throwable -> L10
        goto L5
    L7:
        r100.append("maxMemory=");     // Catch: Throwable -> L10
        r100.append(this.maxMemorySize);     // Catch: Throwable -> L10
        r100.append(",");     // Catch: Throwable -> L10
        r100.append("memorySize=");     // Catch: Throwable -> L10
        r100.append(this.memorySize);     // Catch: Throwable -> L10
        String r103 = r100.toString();     // Catch: Throwable -> L10
        monitor-exit(this);
        return r103;
    L10:
        th = move-exception;
        throw th;
    }

    public LruCache() {
        this(8);
    }

    public String getClassName() {
        return LruCache.class.getName();
    }

    public LruCache(int r100) {
        if (r100 <= 0) goto L9;
        this.map = new LruHashMap(r100);     // Catch: OutOfMemoryError -> L6
        this.maxMemorySize = r100;     // Catch: OutOfMemoryError -> L6
        return;
    L6:
        this.map = new LruHashMap(10);
        this.maxMemorySize = 10;
        return;
    L9:
        throw new IllegalArgumentException("capacity <= 0");
    }

    private void trimToSize(int r100) {
    L3:
        if (this.memorySize <= r100) goto L16;
        if (this.map.isEmpty() == true) goto L23;
        if (this.memorySize < 0) goto L15;
        if (this.map.isEmpty() == false) goto L13;
        if (this.memorySize != 0) goto L15;
    L13:
        Map.Entry<K, V> r101 = this.map.entrySet().iterator().next();
        this.map.remove(r101.getKey());
        this.memorySize -= getValueSize(r101.getValue());
    L15:
        throw new IllegalStateException(getClassName() + ".getValueSize() is reporting inconsistent results");
    L23:
        return;
    }

    @Override // com.bytedance.android.live.core.cache.Cache
    public final void delete(K r100) {
        monitor-enter(this);
        V r101 = this.map.remove(r100);     // Catch: Throwable -> L8
        if (r101 == null) goto L6;
        this.memorySize -= getValueSize(r101);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.live.core.cache.Cache
    public final V get(K r100) {
        monitor-enter(this);
        V r101 = this.map.get(r100);     // Catch: Throwable -> L10
        if (r101 == null) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L10
        return r101;
    L7:
        monitor-exit(this);     // Catch: Throwable -> L10
        return null;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.live.core.cache.Cache
    public final void put(K r100, V r101) {
        monitor-enter(this);
        V r102 = this.map.put(r100, r101);     // Catch: Throwable -> L9
        int r103 = this.memorySize + getValueSize(r101);     // Catch: Throwable -> L9
        this.memorySize = r103;     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        this.memorySize = r103 - getValueSize(r102);     // Catch: Throwable -> L9
    L6:
        trimToSize(this.maxMemorySize);     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
