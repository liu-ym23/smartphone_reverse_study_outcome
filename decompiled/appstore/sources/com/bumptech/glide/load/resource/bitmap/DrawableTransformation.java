package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class DrawableTransformation implements Transformation<Drawable> {
    private final boolean isRequired;
    private final Transformation<Bitmap> wrapped;

    public DrawableTransformation(Transformation<Bitmap> r10, boolean r11) {
        this.wrapped = r10;
        this.isRequired = r11;
    }

    private Resource<Drawable> newDrawableResource(Context r10, Resource<Bitmap> r11) {
        return LazyBitmapDrawableResource.obtain(r10.getResources(), r11);
    }

    public Transformation<BitmapDrawable> asBitmapDrawable() {
        return this;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r10) {
        if ((r10 instanceof DrawableTransformation) == true) goto L5;
        return false;
    L5:
        return this.wrapped.equals(((DrawableTransformation) r10).wrapped);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.wrapped.hashCode();
    }

    @Override // com.bumptech.glide.load.Transformation
    @NonNull
    public Resource<Drawable> transform(@NonNull Context r10, @NonNull Resource<Drawable> r11, int r12, int r13) {
        BitmapPool r14 = Glide.get(r10).getBitmapPool();
        Drawable r15 = r11.get();
        Resource<Bitmap> r16 = DrawableToBitmapConverter.convert(r14, r15, r12, r13);
        if (r16 == null) goto L5;
        Resource<Bitmap> r17 = this.wrapped.transform(r10, r16, r12, r13);
        if (r17.equals(r16) == false) goto L14;
        r17.recycle();
        return r11;
    L14:
        return newDrawableResource(r10, r17);
    L5:
        if (this.isRequired == true) goto L8;
        return r11;
    L8:
        throw new IllegalArgumentException("Unable to convert " + r15 + " to a Bitmap");
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest r10) {
        this.wrapped.updateDiskCacheKey(r10);
    }
}
