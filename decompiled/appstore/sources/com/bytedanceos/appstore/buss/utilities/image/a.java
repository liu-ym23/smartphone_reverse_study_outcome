package com.bytedanceos.appstore.buss.utilities.image;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Util;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements Transformation {
    public a() {
    }

    public void a(Bitmap r10, Bitmap r11) {
        r11.setDensity(r10.getDensity());
    }

    public abstract Bitmap b(Context r10, BitmapPool r11, Bitmap r12, int r13, int r14);

    @Override // com.bumptech.glide.load.Transformation
    public final Resource transform(Context r10, Resource r11, int r12, int r13) {
        if (Util.isValidDimensions(r12, r13) == false) goto L16;
        BitmapPool r14 = Glide.get(r10).getBitmapPool();
        Bitmap r15 = (Bitmap) r11.get();
        if (r12 != Integer.MIN_VALUE) goto L7;
        r12 = r15.getWidth();
    L7:
        int r16 = r12;
        if (r13 != Integer.MIN_VALUE) goto L10;
        r13 = r15.getHeight();
    L10:
        Bitmap r17 = b(r10.getApplicationContext(), r14, r15, r16, r13);
        if (r15.equals(r17) == false) goto L14;
        return r11;
    L14:
        return BitmapResource.obtain(r17, r14);
    L16:
        throw new IllegalArgumentException("Cannot apply transformation on width: " + r12 + " or height: " + r13 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
