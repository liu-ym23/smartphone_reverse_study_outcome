package com.bumptech.glide.load.resource.transcode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class BitmapDrawableTranscoder implements ResourceTranscoder<Bitmap, BitmapDrawable> {
    private final Resources resources;

    public BitmapDrawableTranscoder(@NonNull Context r10) {
        this(r10.getResources());
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    @Nullable
    public Resource<BitmapDrawable> transcode(@NonNull Resource<Bitmap> r10, @NonNull Options r11) {
        return LazyBitmapDrawableResource.obtain(this.resources, r10);
    }

    @Deprecated
    public BitmapDrawableTranscoder(@NonNull Resources r10, BitmapPool r11) {
        this(r10);
    }

    public BitmapDrawableTranscoder(@NonNull Resources r10) {
        this.resources = (Resources) Preconditions.checkNotNull(r10);
    }
}
