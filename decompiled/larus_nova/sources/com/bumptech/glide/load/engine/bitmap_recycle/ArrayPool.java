package com.bumptech.glide.load.engine.bitmap_recycle;

/* JADX INFO: loaded from: classes39.dex */
public interface ArrayPool {
    public static final int STANDARD_BUFFER_SIZE_BYTES = 65536;

    void clearMemory();

    <T> T get(int r100, Class<T> r101);

    <T> T getExact(int r100, Class<T> r101);

    <T> void put(T r100);

    <T> void put(T r100, Class<T> r101);

    void trimMemory(int r100);

    void trimToRetainRatio(float r100);
}
