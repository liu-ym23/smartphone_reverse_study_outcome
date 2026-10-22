package com.zyql.ai.crop.callback;

import android.graphics.Bitmap;
import com.zyql.ai.crop.model.ExifInfo;

/* loaded from: classes4.dex */
public interface BitmapLoadCallback {
    void onBitmapLoaded(Bitmap bitmap, ExifInfo exifInfo, String str, String str2);

    void onFailure(Exception exc);
}
