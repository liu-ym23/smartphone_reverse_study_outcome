package com.stepos.activeview.listener;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public interface OnLoadImageListener {
    public static final int LOADIMAGE_FAIL = 0;
    public static final int LOADIMAGE_SUCESS = 1;

    void onLoadFinished(int i4, Bitmap bitmap);
}
