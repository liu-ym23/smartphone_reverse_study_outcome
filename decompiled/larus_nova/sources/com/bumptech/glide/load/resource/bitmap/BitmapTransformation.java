package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;

/* JADX INFO: loaded from: classes39.dex */
public abstract class BitmapTransformation implements Transformation<Bitmap> {
    public BitmapTransformation() {
    }

    public abstract Bitmap transform(BitmapPool r100, Bitmap r101, int r102, int r103);

    @Override // com.bumptech.glide.load.Transformation
    public final Resource<Bitmap> transform(Context r100, Resource<Bitmap> r101, int r102, int r103) {
        if (Util.isValidDimensions(r102, r103) == false) goto L15;
        BitmapPool r104 = Glide.get(r100).getBitmapPool();
        Bitmap r105 = r101.get();
        if (r102 != Integer.MIN_VALUE) goto L7;
        r102 = r105.getWidth();
    L7:
        if (r103 != Integer.MIN_VALUE) goto L9;
        r103 = r105.getHeight();
    L9:
        Bitmap r106 = transform(r104, r105, r102, r103);
        if (r105.equals(r106) == false) goto L13;
        return r101;
    L13:
        return BitmapResource.obtain(r106, r104);
    L15:
        throw new IllegalArgumentException("Cannot apply transformation on width: " + r102 + " or height: " + r103 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
