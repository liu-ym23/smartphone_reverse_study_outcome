package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class RoundedCorners extends BitmapTransformation {
    private static final String ID = "com.bumptech.glide.load.resource.bitmap.RoundedCorners";
    private static final byte[] ID_BYTES = null;
    private final int roundingRadius;

    static {
        ID_BYTES = ID.getBytes(Key.CHARSET);
    }

    public RoundedCorners(int r10) {
        if (r10 <= 0) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkArgument(r11, "roundingRadius must be greater than 0.");
        this.roundingRadius = r10;
        return;
    L5:
        r11 = false;
        goto L6
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r10) {
        if ((r10 instanceof RoundedCorners) == true) goto L5;
        return false;
    L5:
        if (this.roundingRadius != ((RoundedCorners) r10).roundingRadius) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.hashCode(-569625254, Util.hashCode(this.roundingRadius));
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(@NonNull BitmapPool r10, @NonNull Bitmap r11, int r12, int r13) {
        return TransformationUtils.roundedCorners(r10, r11, this.roundingRadius);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest r10) {
        r10.update(ID_BYTES);
        r10.update(ByteBuffer.allocate(4).putInt(this.roundingRadius).array());
    }
}
