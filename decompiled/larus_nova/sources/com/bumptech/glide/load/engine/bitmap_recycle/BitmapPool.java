package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes39.dex */
public interface BitmapPool {
    void clearMemory();

    Bitmap get(int r100, int r101, Bitmap.Config r102);

    Bitmap getDirty(int r100, int r101, Bitmap.Config r102);

    long getMaxSize();

    void put(Bitmap r100);

    void setSizeMultiplier(float r100);

    void trimMemory(int r100);

    void trimToRetainRatio(float r100);
}
