package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface BitmapPool {
    void clearMemory();

    @NonNull
    Bitmap get(int r10, int r11, Bitmap.Config r12);

    @NonNull
    Bitmap getDirty(int r10, int r11, Bitmap.Config r12);

    long getMaxSize();

    void put(Bitmap r10);

    void setSizeMultiplier(float r10);

    void trimMemory(int r10);
}
