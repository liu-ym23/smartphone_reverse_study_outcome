package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BitmapDrawableTransformation implements Transformation<BitmapDrawable> {
    private final Transformation<Drawable> wrapped;

    public BitmapDrawableTransformation(Transformation<Bitmap> r10) {
        this.wrapped = (Transformation) Preconditions.checkNotNull(new DrawableTransformation(r10, false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Resource<BitmapDrawable> convertToBitmapDrawableResource(Resource<Drawable> r10) {
        if ((r10.get() instanceof BitmapDrawable) == false) goto L6;
        return r10;
    L6:
        throw new IllegalArgumentException("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: " + r10.get());
    }

    private static Resource<Drawable> convertToDrawableResource(Resource<BitmapDrawable> r10) {
        return r10;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r10) {
        if ((r10 instanceof BitmapDrawableTransformation) == true) goto L5;
        return false;
    L5:
        return this.wrapped.equals(((BitmapDrawableTransformation) r10).wrapped);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.wrapped.hashCode();
    }

    @Override // com.bumptech.glide.load.Transformation
    @NonNull
    public Resource<BitmapDrawable> transform(@NonNull Context r10, @NonNull Resource<BitmapDrawable> r11, int r12, int r13) {
        Resource<Drawable> r14 = convertToDrawableResource(r11);
        return convertToBitmapDrawableResource(this.wrapped.transform(r10, r14, r12, r13));
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest r10) {
        this.wrapped.updateDiskCacheKey(r10);
    }
}
