package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class Rotate extends BitmapTransformation {
    private static final String ID = "com.bumptech.glide.load.resource.bitmap.Rotate";
    private static final byte[] ID_BYTES = null;
    private final int degreesToRotate;

    static {
        ID_BYTES = ID.getBytes(Key.CHARSET);
    }

    public Rotate(int r10) {
        this.degreesToRotate = r10;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r10) {
        if ((r10 instanceof Rotate) == true) goto L5;
        return false;
    L5:
        if (this.degreesToRotate != ((Rotate) r10).degreesToRotate) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.hashCode(-950519196, Util.hashCode(this.degreesToRotate));
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(@NonNull BitmapPool r10, @NonNull Bitmap r11, int r12, int r13) {
        return TransformationUtils.rotateImage(r11, this.degreesToRotate);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest r10) {
        r10.update(ID_BYTES);
        r10.update(ByteBuffer.allocate(4).putInt(this.degreesToRotate).array());
    }
}
