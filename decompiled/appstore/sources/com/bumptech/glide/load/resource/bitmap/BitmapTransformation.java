package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;

/* JADX INFO: loaded from: classes.dex */
public abstract class BitmapTransformation implements Transformation<Bitmap> {
    public BitmapTransformation() {
    }

    public abstract Bitmap transform(@NonNull BitmapPool r10, @NonNull Bitmap r11, int r12, int r13);

    @Override // com.bumptech.glide.load.Transformation
    @NonNull
    public final Resource<Bitmap> transform(@NonNull Context r10, @NonNull Resource<Bitmap> r11, int r12, int r13) {
        if (Util.isValidDimensions(r12, r13) == false) goto L15;
        BitmapPool r14 = Glide.get(r10).getBitmapPool();
        Bitmap r15 = r11.get();
        if (r12 != Integer.MIN_VALUE) goto L7;
        r12 = r15.getWidth();
    L7:
        if (r13 != Integer.MIN_VALUE) goto L9;
        r13 = r15.getHeight();
    L9:
        Bitmap r16 = transform(r14, r15, r12, r13);
        if (r15.equals(r16) == false) goto L13;
        return r11;
    L13:
        return BitmapResource.obtain(r16, r14);
    L15:
        throw new IllegalArgumentException("Cannot apply transformation on width: " + r12 + " or height: " + r13 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
