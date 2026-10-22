package com.bumptech.glide.load.engine.bitmap_recycle;

/* JADX INFO: loaded from: classes.dex */
interface ArrayAdapterInterface<T> {
    int getArrayLength(T r10);

    int getElementSizeInBytes();

    String getTag();

    T newArray(int r10);
}
