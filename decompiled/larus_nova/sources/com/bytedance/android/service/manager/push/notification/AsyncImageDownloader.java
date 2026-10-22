package com.bytedance.android.service.manager.push.notification;

import android.graphics.Bitmap;
import t67.a;
import t67.c;

/* JADX INFO: loaded from: classes3.dex */
public interface AsyncImageDownloader extends a {
    void asyncDownloadImage(c r100, ImageDownloadCallback r101);

    @Override // t67.a
    /* synthetic */ Bitmap downloadImage(c r100);
}
