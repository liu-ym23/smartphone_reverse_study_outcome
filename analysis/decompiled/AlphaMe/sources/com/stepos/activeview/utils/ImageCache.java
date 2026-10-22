package com.stepos.activeview.utils;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public interface ImageCache {
    void clearCache();

    Bitmap getBitmap(String str);

    void putBitmap(String str, Bitmap bitmap);

    void removeBitmap(String str);
}
