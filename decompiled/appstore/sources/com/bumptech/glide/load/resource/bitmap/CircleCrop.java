package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class CircleCrop extends BitmapTransformation {
    private static final String ID = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1";
    private static final byte[] ID_BYTES = null;
    private static final int VERSION = 1;

    static {
        ID_BYTES = ID.getBytes(Key.CHARSET);
    }

    public CircleCrop() {
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r10) {
        return r10 instanceof CircleCrop;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return 1101716364;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(@NonNull BitmapPool r10, @NonNull Bitmap r11, int r12, int r13) {
        return TransformationUtils.circleCrop(r10, r11, r12, r13);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest r10) {
        r10.update(ID_BYTES);
    }
}
