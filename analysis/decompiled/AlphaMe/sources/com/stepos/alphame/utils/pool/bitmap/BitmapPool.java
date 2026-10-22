package com.stepos.alphame.utils.pool.bitmap;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public interface BitmapPool {
    void clearMemory();

    Bitmap get(int i4, int i5, Bitmap.Config config);

    Bitmap getDirty(int i4, int i5, Bitmap.Config config);

    int getMaxSize();

    void put(Bitmap bitmap);

    void setSizeMultiplier(float f4);

    void trimMemory(int i4);
}
