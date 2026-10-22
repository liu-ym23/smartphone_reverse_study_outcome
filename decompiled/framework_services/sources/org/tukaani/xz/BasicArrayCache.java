package org.tukaani.xz;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.compress.archivers.zip.UnixStat;

/* JADX INFO: loaded from: classes3.dex */
public class BasicArrayCache extends ArrayCache {
    private static final int CACHEABLE_SIZE_MIN = 32768;
    private static final int ELEMENTS_PER_STACK = 512;
    private static final int STACKS_MAX = 32;
    private final CacheMap<byte[]> byteArrayCache;
    private final CacheMap<int[]> intArrayCache;

    private static class CacheMap<T> extends LinkedHashMap<Integer, CyclicStack<Reference<T>>> {
        private static final long serialVersionUID = 1;

        public CacheMap() {
            super(64, 0.75f, true);
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<Integer, CyclicStack<Reference<T>>> eldest) {
            if (size() <= 32) goto L5;
            return true;
        L5:
            return false;
        }
    }

    private static class CyclicStack<T> {
        private final T[] elements;
        private int pos;

        /* synthetic */ CyclicStack(BasicArrayCacheIA r1) {
            this();
        }

        private CyclicStack() {
            this.elements = (T[]) new Object[512];
            this.pos = 0;
        }

        public synchronized T pop() {
            monitor-enter(this);
            T e = this.elements[this.pos];     // Catch: Throwable -> L6
            this.elements[this.pos] = null;     // Catch: Throwable -> L6
            this.pos = (this.pos - 1) & UnixStat.DEFAULT_LINK_PERM;     // Catch: Throwable -> L6
            monitor-exit(this);
            return e;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized void push(T e) {
            monitor-enter(this);
            this.pos = (this.pos + 1) & UnixStat.DEFAULT_LINK_PERM;     // Catch: Throwable -> L6
            this.elements[this.pos] = e;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    private static final class LazyHolder {
        static final BasicArrayCache INSTANCE = null;

        private LazyHolder() {
        }

        static {
            INSTANCE = new BasicArrayCache();
        }
    }

    public BasicArrayCache() {
        this.byteArrayCache = new CacheMap();
        this.intArrayCache = new CacheMap();
    }

    public static BasicArrayCache getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static <T> T getArray(CacheMap<T> cache, int size) {
        if (size >= 32768) goto L5;
        return null;
    L5:
        monitor-enter(cache);
        CyclicStack<Reference<T>> stack = cache.get(Integer.valueOf(size));     // Catch: Throwable -> L16
        monitor-exit(cache);     // Catch: Throwable -> L16
        if (stack != null) goto L10;
        return null;
    L10:
        Reference<T> r = stack.pop();
        if (r == null) goto L12;
        T array = r.get();
        if (array == null) goto L10;
        return array;
    L12:
        return null;
    L16:
        th = move-exception;
        throw th;
    }

    private static <T> void putArray(CacheMap<T> cache, T array, int size) {
        if (size >= 32768) goto L5;
        return;
    L5:
        monitor-enter(cache);
        CyclicStack<Reference<T>> stack = cache.get(Integer.valueOf(size));     // Catch: Throwable -> L9
        if (stack != null) goto L11;
        stack = new CyclicStack(null);     // Catch: Throwable -> L9
        cache.put(Integer.valueOf(size), stack);     // Catch: Throwable -> L9
    L11:
        monitor-exit(cache);     // Catch: Throwable -> L9
        stack.push(new SoftReference(array));
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // org.tukaani.xz.ArrayCache
    public byte[] getByteArray(int size, boolean fillWithZeros) {
        byte[] array = (byte[]) getArray(this.byteArrayCache, size);
        if (array == null) goto L8;
        if (fillWithZeros == false) goto L9;
        Arrays.fill(array, (byte) 0);
        return array;
    L9:
        return array;
    L8:
        return new byte[size];
    }

    @Override // org.tukaani.xz.ArrayCache
    public void putArray(byte[] array) {
        putArray(this.byteArrayCache, array, array.length);
    }

    @Override // org.tukaani.xz.ArrayCache
    public int[] getIntArray(int size, boolean fillWithZeros) {
        int[] array = (int[]) getArray(this.intArrayCache, size);
        if (array == null) goto L8;
        if (fillWithZeros == false) goto L9;
        Arrays.fill(array, 0);
        return array;
    L9:
        return array;
    L8:
        return new int[size];
    }

    @Override // org.tukaani.xz.ArrayCache
    public void putArray(int[] array) {
        putArray(this.intArrayCache, array, array.length);
    }
}
