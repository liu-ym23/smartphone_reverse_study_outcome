package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes39.dex */
interface LruPoolStrategy {
    Bitmap get(int r100, int r101, Bitmap.Config r102);

    int getSize(Bitmap r100);

    String logBitmap(int r100, int r101, Bitmap.Config r102);

    String logBitmap(Bitmap r100);

    void put(Bitmap r100);

    Bitmap removeLast();
}
