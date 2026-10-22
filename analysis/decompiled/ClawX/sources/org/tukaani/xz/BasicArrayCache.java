package org.tukaani.xz;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class BasicArrayCache extends ArrayCache {
    private static final int CACHEABLE_SIZE_MIN = 32768;
    private static final int ELEMENTS_PER_STACK = 512;
    private static final int STACKS_MAX = 32;
    private final CacheMap<byte[]> byteArrayCache = new CacheMap<>();
    private final CacheMap<int[]> intArrayCache = new CacheMap<>();

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    public static class CacheMap<T> extends LinkedHashMap<Integer, CyclicStack<Reference<T>>> {
        private static final long serialVersionUID = 1;

        public CacheMap() {
            super(64, 0.75f, true);
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<Integer, CyclicStack<Reference<T>>> entry) {
            return size() > 32;
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    public static class CyclicStack<T> {
        private final T[] elements;
        private int pos;

        private CyclicStack() {
            this.elements = (T[]) new Object[512];
            this.pos = 0;
        }

        public synchronized T pop() {
            T t8;
            T[] tArr = this.elements;
            int i8 = this.pos;
            t8 = tArr[i8];
            tArr[i8] = null;
            this.pos = (i8 - 1) & 511;
            return t8;
        }

        public synchronized void push(T t8) {
            int i8 = (this.pos + 1) & 511;
            this.pos = i8;
            this.elements[i8] = t8;
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    public static final class LazyHolder {
        static final BasicArrayCache INSTANCE = new BasicArrayCache();

        private LazyHolder() {
        }
    }

    private static <T> T getArray(CacheMap<T> cacheMap, int i8) {
        CyclicStack<Reference<T>> cyclicStack;
        T t8;
        if (i8 < 32768) {
            return null;
        }
        synchronized (cacheMap) {
            cyclicStack = cacheMap.get(Integer.valueOf(i8));
        }
        if (cyclicStack == null) {
            return null;
        }
        do {
            Reference<T> referencePop = cyclicStack.pop();
            if (referencePop == null) {
                return null;
            }
            t8 = referencePop.get();
        } while (t8 == null);
        return t8;
    }

    public static BasicArrayCache getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static <T> void putArray(CacheMap<T> cacheMap, T t8, int i8) {
        CyclicStack<Reference<T>> cyclicStack;
        if (i8 < 32768) {
            return;
        }
        synchronized (cacheMap) {
            try {
                cyclicStack = cacheMap.get(Integer.valueOf(i8));
                if (cyclicStack == null) {
                    cyclicStack = new CyclicStack<>();
                    cacheMap.put(Integer.valueOf(i8), cyclicStack);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        cyclicStack.push(new SoftReference(t8));
    }

    @Override // org.tukaani.xz.ArrayCache
    public byte[] getByteArray(int i8, boolean z) {
        byte[] bArr = (byte[]) getArray(this.byteArrayCache, i8);
        if (bArr == null) {
            return new byte[i8];
        }
        if (z) {
            Arrays.fill(bArr, (byte) 0);
        }
        return bArr;
    }

    @Override // org.tukaani.xz.ArrayCache
    public int[] getIntArray(int i8, boolean z) {
        int[] iArr = (int[]) getArray(this.intArrayCache, i8);
        if (iArr == null) {
            return new int[i8];
        }
        if (z) {
            Arrays.fill(iArr, 0);
        }
        return iArr;
    }

    @Override // org.tukaani.xz.ArrayCache
    public void putArray(byte[] bArr) {
        putArray(this.byteArrayCache, bArr, bArr.length);
    }

    @Override // org.tukaani.xz.ArrayCache
    public void putArray(int[] iArr) {
        putArray(this.intArrayCache, iArr, iArr.length);
    }
}
