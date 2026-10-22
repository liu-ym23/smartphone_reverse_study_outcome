package com.bumptech.glide.load.engine.bitmap_recycle;

/* JADX INFO: loaded from: classes39.dex */
interface ArrayAdapterInterface<T> {
    int getArrayLength(T r100);

    int getElementSizeInBytes();

    String getTag();

    T newArray(int r100);
}
