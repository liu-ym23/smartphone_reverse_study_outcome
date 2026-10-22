package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class LruCache<T, Y> {
    private final Map<T, Y> cache;
    private long currentSize;
    private final long initialMaxSize;
    private long maxSize;

    public LruCache(long r10) {
        this.cache = new LinkedHashMap(100, 0.75f, true);
        this.initialMaxSize = r10;
        this.maxSize = r10;
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    public void clearMemory() {
        trimToSize(0);
    }

    public synchronized boolean contains(@NonNull T r10) {
        monitor-enter(this);
        boolean r11 = this.cache.containsKey(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }

    @Nullable
    public synchronized Y get(@NonNull T r10) {
        monitor-enter(this);
        Y r11 = this.cache.get(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int getCount() {
        monitor-enter(this);
        int r10 = this.cache.size();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized long getCurrentSize() {
        monitor-enter(this);
        long r10 = this.currentSize;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized long getMaxSize() {
        monitor-enter(this);
        long r10 = this.maxSize;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public int getSize(@Nullable Y r10) {
        return 1;
    }

    public void onItemEvicted(@NonNull T r10, @Nullable Y r11) {
    }

    @Nullable
    public synchronized Y put(@NonNull T r10, @Nullable Y r11) {
        monitor-enter(this);
        long r12 = getSize(r11);     // Catch: Throwable -> L9
        if (r12 < this.maxSize) goto L11;
        onItemEvicted(r10, r11);     // Catch: Throwable -> L9
        monitor-exit(this);
        return null;
    L11:
        if (r11 == null) goto L13;
        this.currentSize += r12;     // Catch: Throwable -> L9
    L13:
        Y r13 = this.cache.put(r10, r11);     // Catch: Throwable -> L9
        if (r13 == null) goto L18;
        this.currentSize -= (long) getSize(r13);     // Catch: Throwable -> L9
        if (r13.equals(r11) == true) goto L18;
        onItemEvicted(r10, r13);     // Catch: Throwable -> L9
    L18:
        evict();     // Catch: Throwable -> L9
        monitor-exit(this);
        return r13;
    L9:
        th = move-exception;
        throw th;
    }

    @Nullable
    public synchronized Y remove(@NonNull T r10) {
        monitor-enter(this);
        Y r11 = this.cache.remove(r10);     // Catch: Throwable -> L7
        if (r11 == null) goto L9;
        this.currentSize -= (long) getSize(r11);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void setSizeMultiplier(float r10) {
        monitor-enter(this);
        if (r10 < 0.0f) goto L11;
        this.maxSize = Math.round(this.initialMaxSize * r10);     // Catch: Throwable -> L8
        evict();     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        throw new IllegalArgumentException("Multiplier must be >= 0");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized void trimToSize(long r10) {
        monitor-enter(this);
    L13:
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.currentSize <= r10) goto L9;
        Iterator<Map.Entry<T, Y>> r11 = this.cache.entrySet().iterator();     // Catch: Throwable -> L7
        Map.Entry<T, Y> r12 = r11.next();     // Catch: Throwable -> L7
        Y r13 = r12.getValue();     // Catch: Throwable -> L7
        this.currentSize -= (long) getSize(r13);     // Catch: Throwable -> L7
        T r14 = r12.getKey();     // Catch: Throwable -> L7
        r11.remove();     // Catch: Throwable -> L7
        onItemEvicted(r14, r13);     // Catch: Throwable -> L7
        goto L13
    L9:
        monitor-exit(this);
    }
}
