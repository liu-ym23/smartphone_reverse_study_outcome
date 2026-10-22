package com.zyql.ai.crop.callback;

import android.net.Uri;

/* loaded from: classes4.dex */
public interface BitmapCropCallback {
    void onBitmapCropped(Uri uri, int i10, int i11, int i12, int i13);

    void onCropFailure(Throwable th);
}
