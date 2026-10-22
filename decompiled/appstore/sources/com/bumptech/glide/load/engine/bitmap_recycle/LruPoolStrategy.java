package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
interface LruPoolStrategy {
    @Nullable
    Bitmap get(int r10, int r11, Bitmap.Config r12);

    int getSize(Bitmap r10);

    String logBitmap(int r10, int r11, Bitmap.Config r12);

    String logBitmap(Bitmap r10);

    void put(Bitmap r10);

    @Nullable
    Bitmap removeLast();
}
