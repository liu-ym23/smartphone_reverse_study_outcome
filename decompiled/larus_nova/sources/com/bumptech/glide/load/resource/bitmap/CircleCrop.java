package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes39.dex */
public class CircleCrop extends BitmapTransformation {
    private static final String ID = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1";
    private static final byte[] ID_BYTES = null;
    private static final int VERSION = 1;

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return 1101716364;
    }

    static {
        ID_BYTES = ID.getBytes(Key.CHARSET);
    }

    public CircleCrop() {
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        return r100 instanceof CircleCrop;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        r100.update(ID_BYTES);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool r100, Bitmap r101, int r102, int r103) {
        return TransformationUtils.circleCrop(r100, r101, r102, r103);
    }
}
