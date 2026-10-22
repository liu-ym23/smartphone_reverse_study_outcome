package com.bumptech.glide.integration.heif.bean;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes39.dex */
public class HeifData {
    public byte[] data;
    public final int height;
    public final int width;

    public Bitmap newBitmap(Bitmap.Config r100) {
        return newBitmap(r100, false);
    }

    public Bitmap newBitmap(Bitmap.Config r100, boolean r101) {
        byte[] r102 = this.data;
        if (r102 != null) goto L5;
    L21:
        return null;
    L5:
        if (r102.length <= 0) goto L21;
        int r103 = this.width;
        if (r103 <= 0) goto L21;
        int r104 = this.height;
        if (r104 <= 0) goto L21;
        if (r100 != null) goto L22;
        r100 = Bitmap.Config.ARGB_8888;
    L22:
        Bitmap r105 = Bitmap.createBitmap(r103, r104, r100);     // Catch: Throwable -> L17
        r105.copyPixelsFromBuffer(ByteBuffer.wrap(r102));     // Catch: Throwable -> L17
        if (r101 == false) goto L16;
        this.data = null;
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r101 == false) goto L20;
        this.data = null;
    L20:
        throw th;
    }

    public HeifData(byte[] r100, int r101, int r102) {
        this.data = r100;
        this.width = r101;
        this.height = r102;
    }
}
