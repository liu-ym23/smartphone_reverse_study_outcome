package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes39.dex */
public class Rotate extends BitmapTransformation {
    private static final String ID = "com.bumptech.glide.load.resource.bitmap.Rotate";
    private static final byte[] ID_BYTES = null;
    private final int degreesToRotate;

    static {
        ID_BYTES = ID.getBytes(Key.CHARSET);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.hashCode(-950519196, Util.hashCode(this.degreesToRotate));
    }

    public Rotate(int r100) {
        this.degreesToRotate = r100;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        if ((r100 instanceof Rotate) == true) goto L5;
        return false;
    L5:
        if (this.degreesToRotate != ((Rotate) r100).degreesToRotate) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        r100.update(ID_BYTES);
        r100.update(ByteBuffer.allocate(4).putInt(this.degreesToRotate).array());
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool r100, Bitmap r101, int r102, int r103) {
        return TransformationUtils.rotateImage(r101, this.degreesToRotate);
    }
}
