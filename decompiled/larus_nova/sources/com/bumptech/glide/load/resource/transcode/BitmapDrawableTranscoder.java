package com.bumptech.glide.load.resource.transcode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: loaded from: classes39.dex */
public class BitmapDrawableTranscoder implements ResourceTranscoder<Bitmap, BitmapDrawable> {
    private final Resources resources;

    public BitmapDrawableTranscoder(Resources r100) {
        this.resources = (Resources) Preconditions.checkNotNull(r100);
    }

    public BitmapDrawableTranscoder(Context r100) {
        this(r100.getResources());
    }

    public BitmapDrawableTranscoder(Resources r100, BitmapPool r101) {
        this(r100);
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public Resource<BitmapDrawable> transcode(Resource<Bitmap> r100, Options r101) {
        return LazyBitmapDrawableResource.obtain(this.resources, r100);
    }
}
