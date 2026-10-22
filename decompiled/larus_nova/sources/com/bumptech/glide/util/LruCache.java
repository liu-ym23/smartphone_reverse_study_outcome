package com.bumptech.glide.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public class LruCache<T, Y> {
    private final Map<T, Y> cache;
    private long currentSize;
    private final long initialMaxSize;
    private long maxSize;

    public synchronized int getCount() {
        monitor-enter(this);
        int r100 = this.cache.size();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized long getCurrentSize() {
        monitor-enter(this);
        long r100 = this.currentSize;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized long getMaxSize() {
        monitor-enter(this);
        long r100 = this.maxSize;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public int getSize(Y r100) {
        return 1;
    }

    public void onItemEvicted(T r100, Y r101) {
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    public void clearMemory() {
        trimToSize(0);
    }

    public LruCache(long r100) {
        this.cache = new LinkedHashMap(100, 0.75f, true);
        this.initialMaxSize = r100;
        this.maxSize = r100;
    }

    public synchronized boolean contains(T r100) {
        monitor-enter(this);
        boolean r101 = this.cache.containsKey(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized Y get(T r100) {
        monitor-enter(this);
        Y r101 = this.cache.get(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized Y remove(T r100) {
        monitor-enter(this);
        Y r101 = this.cache.remove(r100);     // Catch: Throwable -> L8
        if (r101 == null) goto L6;
        this.currentSize -= (long) getSize(r101);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r101;
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized void setSizeMultiplier(float r100) {
        monitor-enter(this);
        if (r100 < 0.0f) goto L11;
        this.maxSize = Math.round(this.initialMaxSize * r100);     // Catch: Throwable -> L8
        evict();     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        throw new IllegalArgumentException("Multiplier must be >= 0");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized void trimToSize(long r100) {
        monitor-enter(this);
    L12:
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.currentSize <= r100) goto L7;
        Iterator<Map.Entry<T, Y>> r101 = this.cache.entrySet().iterator();     // Catch: Throwable -> L9
        Map.Entry<T, Y> r102 = r101.next();     // Catch: Throwable -> L9
        Y r103 = r102.getValue();     // Catch: Throwable -> L9
        this.currentSize -= (long) getSize(r103);     // Catch: Throwable -> L9
        T r104 = r102.getKey();     // Catch: Throwable -> L9
        r101.remove();     // Catch: Throwable -> L9
        onItemEvicted(r104, r103);     // Catch: Throwable -> L9
        goto L12
    L7:
        monitor-exit(this);
    }

    public synchronized Y put(T r100, Y r101) {
        monitor-enter(this);
        long r102 = getSize(r101);     // Catch: Throwable -> L21 Exception -> L24
        if (r102 < this.maxSize) goto L11;
        onItemEvicted(r100, r101);     // Catch: Throwable -> L21
        monitor-exit(this);
        return null;
    L11:
        if (r101 == null) goto L13;
        this.currentSize += r102;     // Catch: Throwable -> L21
    L13:
        Y r103 = this.cache.put(r100, r101);     // Catch: Throwable -> L21
        if (r103 == null) goto L18;
        this.currentSize -= (long) getSize(r103);     // Catch: Throwable -> L21
        if (r103.equals(r101) == true) goto L18;
        onItemEvicted(r100, r103);     // Catch: Throwable -> L21
    L18:
        evict();     // Catch: Throwable -> L21
        monitor-exit(this);
        return r103;
    L21:
        th = move-exception;
        throw th;
    L25:
        return null;
    }
}
