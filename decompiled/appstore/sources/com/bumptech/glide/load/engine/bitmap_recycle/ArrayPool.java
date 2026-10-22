package com.bumptech.glide.load.engine.bitmap_recycle;

/* JADX INFO: loaded from: classes.dex */
public interface ArrayPool {
    public static final int STANDARD_BUFFER_SIZE_BYTES = 65536;

    void clearMemory();

    <T> T get(int r10, Class<T> r11);

    <T> T getExact(int r10, Class<T> r11);

    <T> void put(T r10);

    @Deprecated
    <T> void put(T r10, Class<T> r11);

    void trimMemory(int r10);
}
