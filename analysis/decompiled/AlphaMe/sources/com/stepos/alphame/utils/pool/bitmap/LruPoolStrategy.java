package com.stepos.alphame.utils.pool.bitmap;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
interface LruPoolStrategy {
    Bitmap get(int i4, int i5, Bitmap.Config config);

    int getSize(Bitmap bitmap);

    String logBitmap(int i4, int i5, Bitmap.Config config);

    String logBitmap(Bitmap bitmap);

    void put(Bitmap bitmap);

    Bitmap removeLast();
}
