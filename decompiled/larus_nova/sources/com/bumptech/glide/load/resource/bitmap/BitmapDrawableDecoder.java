package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public class BitmapDrawableDecoder<DataType> implements ResourceDecoder<DataType, BitmapDrawable> {
    private final ResourceDecoder<DataType, Bitmap> decoder;
    private final Resources resources;

    public BitmapDrawableDecoder(Resources r100, ResourceDecoder<DataType, Bitmap> r101) {
        this.resources = (Resources) Preconditions.checkNotNull(r100);
        this.decoder = (ResourceDecoder) Preconditions.checkNotNull(r101);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(DataType r100, Options r101) throws IOException {
        return this.decoder.handles(r100, r101);
    }

    public BitmapDrawableDecoder(Context r100, ResourceDecoder<DataType, Bitmap> r101) {
        this(r100.getResources(), r101);
    }

    public BitmapDrawableDecoder(Resources r100, BitmapPool r101, ResourceDecoder<DataType, Bitmap> r102) {
        this(r100, r102);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<BitmapDrawable> decode(DataType r100, int r101, int r102, Options r103) throws IOException {
        Resource<Bitmap> r104 = this.decoder.decode(r100, r101, r102, r103);
        return LazyBitmapDrawableResource.obtain(this.resources, r104);
    }
}
