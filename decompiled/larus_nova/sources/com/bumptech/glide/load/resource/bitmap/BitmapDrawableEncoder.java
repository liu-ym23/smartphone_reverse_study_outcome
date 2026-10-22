package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.CacheSink;

/* JADX INFO: loaded from: classes39.dex */
public class BitmapDrawableEncoder implements ResourceEncoder<BitmapDrawable> {
    private final BitmapPool bitmapPool;
    private final ResourceEncoder<Bitmap> encoder;

    @Override // com.bumptech.glide.load.ResourceEncoder
    public EncodeStrategy getEncodeStrategy(Options r100) {
        return this.encoder.getEncodeStrategy(r100);
    }

    public BitmapDrawableEncoder(BitmapPool r100, ResourceEncoder<Bitmap> r101) {
        this.bitmapPool = r100;
        this.encoder = r101;
    }

    public boolean encode(Resource<BitmapDrawable> r100, CacheSink r101, Options r102) {
        return this.encoder.encode((Bitmap) new BitmapResource(r100.get().getBitmap(), this.bitmapPool), r101, r102);
    }

    @Override // com.bumptech.glide.load.Encoder
    public /* bridge */ /* synthetic */ boolean encode(Object r100, CacheSink r101, Options r102) {
        return encode((Resource) r100, r101, r102);
    }
}
