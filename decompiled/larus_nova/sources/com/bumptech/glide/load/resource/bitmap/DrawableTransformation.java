package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes39.dex */
public class DrawableTransformation implements Transformation<Drawable> {
    private final boolean isRequired;
    private final Transformation<Bitmap> wrapped;

    public Transformation<BitmapDrawable> asBitmapDrawable() {
        return this;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.wrapped.hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        if ((r100 instanceof DrawableTransformation) == true) goto L5;
        return false;
    L5:
        return this.wrapped.equals(((DrawableTransformation) r100).wrapped);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        this.wrapped.updateDiskCacheKey(r100);
    }

    public DrawableTransformation(Transformation<Bitmap> r100, boolean r101) {
        this.wrapped = r100;
        this.isRequired = r101;
    }

    private Resource<Drawable> newDrawableResource(Context r100, Resource<Bitmap> r101) {
        return LazyBitmapDrawableResource.obtain(r100.getResources(), r101);
    }

    @Override // com.bumptech.glide.load.Transformation
    public Resource<Drawable> transform(Context r100, Resource<Drawable> r101, int r102, int r103) {
        BitmapPool r104 = Glide.get(r100).getBitmapPool();
        Drawable r105 = r101.get();
        Resource<Bitmap> r106 = DrawableToBitmapConverter.convert(r104, r105, r102, r103);
        if (r106 == null) goto L5;
        Resource<Bitmap> r107 = this.wrapped.transform(r100, r106, r102, r103);
        if (r107.equals(r106) == false) goto L14;
        r107.recycle();
        return r101;
    L14:
        return newDrawableResource(r100, r107);
    L5:
        if (this.isRequired == true) goto L8;
        return r101;
    L8:
        throw new IllegalArgumentException("Unable to convert " + r105 + " to a Bitmap");
    }
}
