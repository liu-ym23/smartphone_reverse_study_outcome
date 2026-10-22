package com.bytedance.android.service.manager.push.notification;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes12.dex */
public interface ImageDownloadCallback {
    void onFailed();

    void onSuccess(Bitmap r100);
}
