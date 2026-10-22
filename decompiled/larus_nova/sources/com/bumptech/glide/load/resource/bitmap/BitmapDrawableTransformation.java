package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes39.dex */
public class BitmapDrawableTransformation implements Transformation<BitmapDrawable> {
    private final Transformation<Drawable> wrapped;

    private static Resource<Drawable> convertToDrawableResource(Resource<BitmapDrawable> r100) {
        return r100;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.wrapped.hashCode();
    }

    public BitmapDrawableTransformation(Transformation<Bitmap> r100) {
        this.wrapped = (Transformation) Preconditions.checkNotNull(new DrawableTransformation(r100, false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Resource<BitmapDrawable> convertToBitmapDrawableResource(Resource<Drawable> r100) {
        if ((r100.get() instanceof BitmapDrawable) == false) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: " + r100.get());
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        if ((r100 instanceof BitmapDrawableTransformation) == true) goto L5;
        return false;
    L5:
        return this.wrapped.equals(((BitmapDrawableTransformation) r100).wrapped);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        this.wrapped.updateDiskCacheKey(r100);
    }

    @Override // com.bumptech.glide.load.Transformation
    public Resource<BitmapDrawable> transform(Context r100, Resource<BitmapDrawable> r101, int r102, int r103) {
        Resource<Drawable> r104 = convertToDrawableResource(r101);
        return convertToBitmapDrawableResource(this.wrapped.transform(r100, r104, r102, r103));
    }
}
