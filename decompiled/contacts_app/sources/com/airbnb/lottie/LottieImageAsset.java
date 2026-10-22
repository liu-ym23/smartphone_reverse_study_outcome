package com.airbnb.lottie;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public class LottieImageAsset {
    private Bitmap bitmap;
    private final String dirName;
    private final String fileName;
    private final int height;
    private final String id;
    private final int width;

    public LottieImageAsset(int r1, int r2, String r3, String r4, String r5) {
        this.width = r1;
        this.height = r2;
        this.id = r3;
        this.fileName = r4;
        this.dirName = r5;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String getId() {
        return this.id;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getDirName() {
        return this.dirName;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public void setBitmap(Bitmap r1) {
        this.bitmap = r1;
    }

    public boolean hasBitmap() {
        if (this.bitmap == null) goto L5;
    L10:
        return true;
    L5:
        if (this.fileName.startsWith("data:") == true) goto L7;
    L9:
        return false;
    L7:
        if (this.fileName.indexOf("base64,") <= 0) goto L9;
        goto L9
    }
}
