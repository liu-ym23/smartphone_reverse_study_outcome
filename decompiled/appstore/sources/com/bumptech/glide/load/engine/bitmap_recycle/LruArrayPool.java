package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class LruArrayPool implements ArrayPool {
    private static final int DEFAULT_SIZE = 4194304;

    @VisibleForTesting
    static final int MAX_OVER_SIZE_MULTIPLE = 8;
    private static final int SINGLE_ARRAY_MAX_SIZE_DIVISOR = 2;
    private final Map<Class<?>, ArrayAdapterInterface<?>> adapters;
    private int currentSize;
    private final GroupedLinkedMap<Key, Object> groupedMap;
    private final KeyPool keyPool;
    private final int maxSize;
    private final Map<Class<?>, NavigableMap<Integer, Integer>> sortedSizes;

    public static final class Key implements Poolable {
        private Class<?> arrayClass;
        private final KeyPool pool;
        int size;

        public Key(KeyPool r10) {
            this.pool = r10;
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof Key) == false) goto L10;
            Key r11 = (Key) r10;
            if (this.size == r11.size) goto L7;
            return false;
        L7:
            if (this.arrayClass != r11.arrayClass) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            int r10 = this.size * 31;
            Class<?> r11 = this.arrayClass;
            if (r11 == null) goto L5;
            int r12 = r11.hashCode();
        L7:
            return r10 + r12;
        L5:
            r12 = 0;
            goto L7
        }

        public void init(int r10, Class<?> r11) {
            this.size = r10;
            this.arrayClass = r11;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            this.pool.offer(this);
        }

        public String toString() {
            return "Key{size=" + this.size + "array=" + this.arrayClass + '}';
        }
    }

    public static final class KeyPool extends BaseKeyPool<Key> {
        public KeyPool() {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public /* bridge */ /* synthetic */ Poolable create() {
            return create();
        }

        public Key get(int r10, Class<?> r11) {
            Key r12 = get();
            r12.init(r10, r11);
            return r12;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public Key create() {
            return new Key(this);
        }
    }

    @VisibleForTesting
    public LruArrayPool() {
        this.groupedMap = new GroupedLinkedMap();
        this.keyPool = new KeyPool();
        this.sortedSizes = new HashMap();
        this.adapters = new HashMap();
        this.maxSize = 4194304;
    }

    private void decrementArrayOfSize(int r10, Class<?> r11) {
        NavigableMap<Integer, Integer> r12 = getSizesForAdapter(r11);
        Integer r13 = (Integer) r12.get(Integer.valueOf(r10));
        if (r13 == null) goto L10;
        if (r13.intValue() != 1) goto L7;
        r12.remove(Integer.valueOf(r10));
        return;
    L7:
        r12.put(Integer.valueOf(r10), Integer.valueOf(r13.intValue() - 1));
        return;
    L10:
        throw new NullPointerException("Tried to decrement empty size, size: " + r10 + ", this: " + this);
    }

    private void evict() {
        evictToSize(this.maxSize);
    }

    private void evictToSize(int r10) {
    L3:
        if (this.currentSize <= r10) goto L7;
        Object r11 = this.groupedMap.removeLast();
        Preconditions.checkNotNull(r11);
        ArrayAdapterInterface r12 = getAdapterFromObject(r11);
        this.currentSize -= r12.getArrayLength(r11) * r12.getElementSizeInBytes();
        decrementArrayOfSize(r12.getArrayLength(r11), r11.getClass());
        if (Log.isLoggable(r12.getTag(), 2) == false) goto L3;
        Log.v(r12.getTag(), "evicted: " + r12.getArrayLength(r11));
        goto L3
    }

    private <T> ArrayAdapterInterface<T> getAdapterFromObject(T r10) {
        return getAdapterFromType(r10.getClass());
    }

    private <T> ArrayAdapterInterface<T> getAdapterFromType(Class<T> r10) {
        ArrayAdapterInterface<T> r11 = (ArrayAdapterInterface) this.adapters.get(r10);
        if (r11 == null) goto L5;
    L13:
        return r11;
    L5:
        if (r10.equals(int[].class) == false) goto L8;
        r11 = new IntegerArrayAdapter();
    L10:
        this.adapters.put(r10, r11);
        goto L13
    L8:
        if (r10.equals(byte[].class) == false) goto L12;
        r11 = new ByteArrayAdapter();
        goto L10
    L12:
        throw new IllegalArgumentException("No array pool found for: " + r10.getSimpleName());
    }

    @Nullable
    private <T> T getArrayForKey(Key r10) {
        return (T) this.groupedMap.get(r10);
    }

    private <T> T getForKey(Key r10, Class<T> r11) {
        ArrayAdapterInterface<T> r12 = getAdapterFromType(r11);
        T r13 = (T) getArrayForKey(r10);
        if (r13 == null) goto L5;
        this.currentSize -= r12.getArrayLength(r13) * r12.getElementSizeInBytes();
        decrementArrayOfSize(r12.getArrayLength(r13), r11);
    L5:
        if (r13 == null) goto L7;
        return r13;
    L7:
        if (Log.isLoggable(r12.getTag(), 2) == false) goto L10;
        Log.v(r12.getTag(), "Allocated " + r10.size + " bytes");
    L10:
        return r12.newArray(r10.size);
    }

    private NavigableMap<Integer, Integer> getSizesForAdapter(Class<?> r10) {
        NavigableMap<Integer, Integer> r11 = this.sortedSizes.get(r10);
        if (r11 != null) goto L6;
        TreeMap r12 = new TreeMap();
        this.sortedSizes.put(r10, r12);
        return r12;
    L6:
        return r11;
    }

    private boolean isNoMoreThanHalfFull() {
        int r10 = this.currentSize;
        if (r10 != 0) goto L5;
    L8:
        return true;
    L5:
        if ((this.maxSize / r10) >= 2) goto L8;
        return false;
    }

    private boolean isSmallEnoughForReuse(int r10) {
        if (r10 > (this.maxSize / 2)) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean mayFillRequest(int r10, Integer r11) {
        if (r11 != null) goto L4;
    L8:
        return false;
    L4:
        if (isNoMoreThanHalfFull() == false) goto L6;
    L7:
        return true;
    L6:
        if (r11.intValue() > (r10 * 8)) goto L8;
        goto L7
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized void clearMemory() {
        monitor-enter(this);
        evictToSize(0);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> T get(int r10, Class<T> r11) {
        monitor-enter(this);
        Integer r12 = getSizesForAdapter(r11).ceilingKey(Integer.valueOf(r10));     // Catch: Throwable -> L6
        if (mayFillRequest(r10, r12) == false) goto L8;
        Key r13 = this.keyPool.get(r12.intValue(), r11);     // Catch: Throwable -> L6
    L9:
        T r14 = (T) getForKey(r13, r11);
        monitor-exit(this);
        return r14;
    L8:
        r13 = this.keyPool.get(r10, r11);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public int getCurrentSize() {
        Iterator<Class<?>> r10 = this.sortedSizes.keySet().iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L9;
        Class<?> r12 = r10.next();
        Iterator<Integer> r13 = this.sortedSizes.get(r12).keySet().iterator();
    L7:
        if (r13.hasNext() == false) goto L4;
        Integer r14 = r13.next();
        ArrayAdapterInterface r15 = getAdapterFromType(r12);
        r11 = r11 + ((r14.intValue() * ((Integer) this.sortedSizes.get(r12).get(r14)).intValue()) * r15.getElementSizeInBytes());
        goto L7
    L9:
        return r11;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> T getExact(int r10, Class<T> r11) {
        monitor-enter(this);
        T r12 = (T) getForKey(this.keyPool.get(r10, r11), r11);
        monitor-exit(this);
        return r12;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    @Deprecated
    public <T> void put(T r10, Class<T> r11) {
        put(r10);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized void trimMemory(int r10) {
        monitor-enter(this);
        if (r10 < 40) goto L9;
        clearMemory();     // Catch: Throwable -> L6
    L17:
    L13:
        monitor-exit(this);
        return;
    L9:
        if (r10 < 20) goto L11;
    L12:
        evictToSize(this.maxSize / 2);     // Catch: Throwable -> L6
        goto L17
    L11:
        if (r10 != 15) goto L13;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> void put(T r10) {
        monitor-enter(this);
        Class<?> r11 = r10.getClass();     // Catch: Throwable -> L14
        ArrayAdapterInterface<T> r12 = getAdapterFromType(r11);     // Catch: Throwable -> L14
        int r13 = r12.getArrayLength(r10);     // Catch: Throwable -> L14
        int r14 = r12.getElementSizeInBytes() * r13;     // Catch: Throwable -> L14
        if (isSmallEnoughForReuse(r14) == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        Key r15 = this.keyPool.get(r13, r11);     // Catch: Throwable -> L14
        this.groupedMap.put(r15, r10);     // Catch: Throwable -> L14
        NavigableMap<Integer, Integer> r16 = getSizesForAdapter(r11);     // Catch: Throwable -> L14
        Integer r17 = (Integer) r16.get(Integer.valueOf(r15.size));     // Catch: Throwable -> L14
        Integer r18 = Integer.valueOf(r15.size);     // Catch: Throwable -> L14
        int r19 = 1;
        if (r17 == null) goto L11;
        r19 = 1 + r17.intValue();     // Catch: Throwable -> L14
    L11:
        r16.put(r18, Integer.valueOf(r19));     // Catch: Throwable -> L14
        this.currentSize += r14;     // Catch: Throwable -> L14
        evict();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public LruArrayPool(int r10) {
        this.groupedMap = new GroupedLinkedMap();
        this.keyPool = new KeyPool();
        this.sortedSizes = new HashMap();
        this.adapters = new HashMap();
        this.maxSize = r10;
    }
}
