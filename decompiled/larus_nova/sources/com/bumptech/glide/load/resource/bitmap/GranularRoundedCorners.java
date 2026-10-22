package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes39.dex */
public final class GranularRoundedCorners extends BitmapTransformation {
    private static final String ID = "com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners";
    private static final byte[] ID_BYTES = null;
    private final float bottomLeft;
    private final float bottomRight;
    private final float topLeft;
    private final float topRight;

    static {
        ID_BYTES = ID.getBytes(Key.CHARSET);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        int r100 = Util.hashCode(-2013597734, Util.hashCode(this.topLeft));
        int r101 = Util.hashCode(this.topRight, r100);
        int r102 = Util.hashCode(this.bottomRight, r101);
        return Util.hashCode(this.bottomLeft, r102);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        if ((r100 instanceof GranularRoundedCorners) == false) goto L14;
        GranularRoundedCorners r101 = (GranularRoundedCorners) r100;
        if (this.topLeft == r101.topLeft) goto L7;
        return false;
    L7:
        if (this.topRight == r101.topRight) goto L9;
        return false;
    L9:
        if (this.bottomRight == r101.bottomRight) goto L11;
        return false;
    L11:
        if (this.bottomLeft != r101.bottomLeft) goto L18;
        return true;
    L18:
        return false;
    L14:
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        r100.update(ID_BYTES);
        r100.update(ByteBuffer.allocate(16).putFloat(this.topLeft).putFloat(this.topRight).putFloat(this.bottomRight).putFloat(this.bottomLeft).array());
    }

    public GranularRoundedCorners(float r100, float r101, float r102, float r103) {
        this.topLeft = r100;
        this.topRight = r101;
        this.bottomRight = r102;
        this.bottomLeft = r103;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool r100, Bitmap r101, int r102, int r110) {
        return TransformationUtils.roundedCorners(r100, r101, this.topLeft, this.topRight, this.bottomRight, this.bottomLeft);
    }
}
