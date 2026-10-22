package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class GifDrawableTransformation implements Transformation<GifDrawable> {
    private final Transformation<Bitmap> wrapped;

    public GifDrawableTransformation(Transformation<Bitmap> r10) {
        this.wrapped = (Transformation) Preconditions.checkNotNull(r10);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r10) {
        if ((r10 instanceof GifDrawableTransformation) == true) goto L5;
        return false;
    L5:
        return this.wrapped.equals(((GifDrawableTransformation) r10).wrapped);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.wrapped.hashCode();
    }

    @Override // com.bumptech.glide.load.Transformation
    @NonNull
    public Resource<GifDrawable> transform(@NonNull Context r10, @NonNull Resource<GifDrawable> r11, int r12, int r13) {
        GifDrawable r14 = r11.get();
        BitmapPool r15 = Glide.get(r10).getBitmapPool();
        Resource<Bitmap> r16 = new BitmapResource(r14.getFirstFrame(), r15);
        Resource<Bitmap> r17 = this.wrapped.transform(r10, r16, r12, r13);
        if (r16.equals(r17) == true) goto L5;
        r16.recycle();
    L5:
        Bitmap r18 = r17.get();
        r14.setFrameTransformation(this.wrapped, r18);
        return r11;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest r10) {
        this.wrapped.updateDiskCacheKey(r10);
    }
}
