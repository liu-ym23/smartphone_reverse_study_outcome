package com.stepos.alphame.ocr.decoder;

import android.graphics.Bitmap;
import com.stepos.alphame.utils.pool.PoolManager;

/* loaded from: classes.dex */
public interface OcrDecoder {
    Bitmap decode();

    default String preflightError() {
        return null;
    }

    default void release(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        PoolManager.releaseBitmap(bitmap);
    }
}
