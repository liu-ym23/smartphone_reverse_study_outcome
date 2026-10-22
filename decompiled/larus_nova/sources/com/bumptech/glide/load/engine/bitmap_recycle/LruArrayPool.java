package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.util.GlideLogUtil;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes39.dex */
public final class LruArrayPool implements ArrayPool {
    private static final int DEFAULT_SIZE = 4194304;
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

        public int hashCode() {
            int r100 = this.size * 31;
            Class<?> r101 = this.arrayClass;
            if (r101 == null) goto L5;
            int r102 = r101.hashCode();
        L7:
            return r100 + r102;
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            this.pool.offer(this);
        }

        public String toString() {
            return "Key{size=" + this.size + "array=" + this.arrayClass + '}';
        }

        public Key(KeyPool r100) {
            this.pool = r100;
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof Key) == false) goto L10;
            Key r101 = (Key) r100;
            if (this.size == r101.size) goto L7;
            return false;
        L7:
            if (this.arrayClass != r101.arrayClass) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public void init(int r100, Class<?> r101) {
            this.size = r100;
            this.arrayClass = r101;
        }
    }

    public static final class KeyPool extends BaseKeyPool<Key> {
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public Key create() {
            return new Key(this);
        }

        public KeyPool() {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public /* bridge */ /* synthetic */ Poolable create() {
            return create();
        }

        public Key get(int r100, Class<?> r101) {
            Key r102 = get();
            r102.init(r100, r101);
            return r102;
        }
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

    private void evict() {
        evictToSize(this.maxSize);
    }

    private boolean isNoMoreThanHalfFull() {
        int r100 = this.currentSize;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if ((this.maxSize / r100) >= 2) goto L8;
        return false;
    }

    public int getCurrentSize() {
        Iterator<Class<?>> r100 = this.sortedSizes.keySet().iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L9;
        Class<?> r102 = r100.next();
        Iterator<Integer> r103 = this.sortedSizes.get(r102).keySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L4;
        Integer r104 = r103.next();
        ArrayAdapterInterface r105 = getAdapterFromType(r102);
        r101 = r101 + ((r104.intValue() * ((Integer) this.sortedSizes.get(r102).get(r104)).intValue()) * r105.getElementSizeInBytes());
        goto L7
    L9:
        return r101;
    }

    public LruArrayPool() {
        this.groupedMap = new GroupedLinkedMap();
        this.keyPool = new KeyPool();
        this.sortedSizes = new HashMap();
        this.adapters = new HashMap();
        this.maxSize = 4194304;
    }

    public LruArrayPool(int r100) {
        this.groupedMap = new GroupedLinkedMap();
        this.keyPool = new KeyPool();
        this.sortedSizes = new HashMap();
        this.adapters = new HashMap();
        this.maxSize = r100;
    }

    private void evictToSize(int r100) {
    L3:
        if (this.currentSize <= r100) goto L5;
        Object r101 = this.groupedMap.removeLast();
        Preconditions.checkNotNull(r101);
        ArrayAdapterInterface r102 = getAdapterFromObject(r101);
        this.currentSize -= r102.getArrayLength(r101) * r102.getElementSizeInBytes();
        decrementArrayOfSize(r102.getArrayLength(r101), r101.getClass());
        GlideLogUtil.v(r102.getTag(), "evicted: " + r102.getArrayLength(r101));
        goto L3
    }

    private <T> ArrayAdapterInterface<T> getAdapterFromObject(T r100) {
        return getAdapterFromType(r100.getClass());
    }

    private <T> ArrayAdapterInterface<T> getAdapterFromType(Class<T> r100) {
        ArrayAdapterInterface<T> r101 = (ArrayAdapterInterface) this.adapters.get(r100);
        if (r101 == null) goto L5;
    L13:
        return r101;
    L5:
        if (r100.equals(int[].class) == false) goto L8;
        r101 = new IntegerArrayAdapter();
    L10:
        this.adapters.put(r100, r101);
        goto L13
    L8:
        if (r100.equals(byte[].class) == false) goto L12;
        r101 = new ByteArrayAdapter();
        goto L10
    L12:
        throw new IllegalArgumentException("No array pool found for: ".concat(r100.getSimpleName()));
    }

    private <T> T getArrayForKey(Key r100) {
        return (T) this.groupedMap.get(r100);
    }

    private NavigableMap<Integer, Integer> getSizesForAdapter(Class<?> r100) {
        NavigableMap<Integer, Integer> r101 = this.sortedSizes.get(r100);
        if (r101 != null) goto L6;
        TreeMap r102 = new TreeMap();
        this.sortedSizes.put(r100, r102);
        return r102;
    L6:
        return r101;
    }

    private boolean isSmallEnoughForReuse(int r100) {
        if (r100 > (this.maxSize / 2)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> void put(T r100) {
        monitor-enter(this);
        Class<?> r101 = r100.getClass();     // Catch: Throwable -> L14
        ArrayAdapterInterface<T> r102 = getAdapterFromType(r101);     // Catch: Throwable -> L14
        int r103 = r102.getArrayLength(r100);     // Catch: Throwable -> L14
        int r104 = r102.getElementSizeInBytes() * r103;     // Catch: Throwable -> L14
        if (isSmallEnoughForReuse(r104) == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        Key r105 = this.keyPool.get(r103, r101);     // Catch: Throwable -> L14
        this.groupedMap.put(r105, r100);     // Catch: Throwable -> L14
        NavigableMap<Integer, Integer> r106 = getSizesForAdapter(r101);     // Catch: Throwable -> L14
        Integer r107 = (Integer) r106.get(Integer.valueOf(r105.size));     // Catch: Throwable -> L14
        Integer r108 = Integer.valueOf(r105.size);     // Catch: Throwable -> L14
        int r109 = 1;
        if (r107 == null) goto L11;
        r109 = 1 + r107.intValue();     // Catch: Throwable -> L14
    L11:
        r106.put(r108, Integer.valueOf(r109));     // Catch: Throwable -> L14
        this.currentSize += r104;     // Catch: Throwable -> L14
        evict();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized void trimMemory(int r100) {
        monitor-enter(this);
        if (r100 < 40) goto L9;
        clearMemory();     // Catch: Throwable -> L6
    L17:
    L13:
        monitor-exit(this);
        return;
    L9:
        if (r100 < 20) goto L11;
    L12:
        evictToSize(this.maxSize / 2);     // Catch: Throwable -> L6
        goto L17
    L11:
        if (r100 != 15) goto L13;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public void trimToRetainRatio(float r100) {
        evictToSize((int) Math.floor(this.maxSize * r100));
    }

    private void decrementArrayOfSize(int r100, Class<?> r101) {
        NavigableMap<Integer, Integer> r102 = getSizesForAdapter(r101);
        Integer r103 = (Integer) r102.get(Integer.valueOf(r100));
        if (r103 == null) goto L10;
        if (r103.intValue() != 1) goto L7;
        r102.remove(Integer.valueOf(r100));
        return;
    L7:
        r102.put(Integer.valueOf(r100), Integer.valueOf(r103.intValue() - 1));
        return;
    L10:
        throw new NullPointerException("Tried to decrement empty size, size: " + r100 + ", this: " + this);
    }

    private <T> T getForKey(Key r100, Class<T> r101) {
        ArrayAdapterInterface<T> r102 = getAdapterFromType(r101);
        T r103 = (T) getArrayForKey(r100);
        if (r103 == null) goto L5;
        this.currentSize -= r102.getArrayLength(r103) * r102.getElementSizeInBytes();
        decrementArrayOfSize(r102.getArrayLength(r103), r101);
    L5:
        if (r103 != null) goto L8;
        GlideLogUtil.v(r102.getTag(), "Allocated " + r100.size + " bytes");
        return r102.newArray(r100.size);
    L8:
        return r103;
    }

    private boolean mayFillRequest(int r100, Integer r101) {
        if (r101 != null) goto L4;
    L8:
        return false;
    L4:
        if (isNoMoreThanHalfFull() == false) goto L6;
    L7:
        return true;
    L6:
        if (r101.intValue() > (r100 * 8)) goto L8;
        goto L7
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> T get(int r100, Class<T> r101) {
        monitor-enter(this);
        Integer r102 = getSizesForAdapter(r101).ceilingKey(Integer.valueOf(r100));     // Catch: Throwable -> L10
        if (mayFillRequest(r100, r102) == false) goto L6;
        Key r103 = this.keyPool.get(r102.intValue(), r101);     // Catch: Throwable -> L10
    L7:
        T r104 = (T) getForKey(r103, r101);
        monitor-exit(this);
        return r104;
    L6:
        r103 = this.keyPool.get(r100, r101);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> T getExact(int r100, Class<T> r101) {
        monitor-enter(this);
        T r102 = (T) getForKey(this.keyPool.get(r100, r101), r101);
        monitor-exit(this);
        return r102;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public <T> void put(T r100, Class<T> r101) {
        put(r100);
    }
}
