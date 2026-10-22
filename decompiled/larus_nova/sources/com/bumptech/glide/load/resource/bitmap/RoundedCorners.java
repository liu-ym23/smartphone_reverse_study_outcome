package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes39.dex */
public final class RoundedCorners extends BitmapTransformation {
    private static final String ID = "com.bumptech.glide.load.resource.bitmap.RoundedCorners";
    private static final byte[] ID_BYTES = null;
    private final int roundingRadius;

    static {
        ID_BYTES = ID.getBytes(Key.CHARSET);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.hashCode(-569625254, Util.hashCode(this.roundingRadius));
    }

    public RoundedCorners(int r100) {
        if (r100 <= 0) goto L5;
        boolean r101 = true;
    L6:
        Preconditions.checkArgument(r101, "roundingRadius must be greater than 0.");
        this.roundingRadius = r100;
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        if ((r100 instanceof RoundedCorners) == true) goto L5;
        return false;
    L5:
        if (this.roundingRadius != ((RoundedCorners) r100).roundingRadius) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        r100.update(ID_BYTES);
        r100.update(ByteBuffer.allocate(4).putInt(this.roundingRadius).array());
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool r100, Bitmap r101, int r102, int r103) {
        return TransformationUtils.roundedCorners(r100, r101, this.roundingRadius);
    }
}
