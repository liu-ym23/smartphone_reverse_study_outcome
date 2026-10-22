package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.gif.GifDrawable;

/* JADX INFO: loaded from: classes39.dex */
public final class DrawableBytesTranscoder implements ResourceTranscoder<Drawable, byte[]> {
    private final ResourceTranscoder<Bitmap, byte[]> bitmapBytesTranscoder;
    private final BitmapPool bitmapPool;
    private final ResourceTranscoder<GifDrawable, byte[]> gifDrawableBytesTranscoder;

    /* JADX WARN: Multi-variable type inference failed */
    private static Resource<GifDrawable> toGifDrawableResource(Resource<Drawable> r100) {
        return r100;
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public Resource<byte[]> transcode(Resource<Drawable> r100, Options r101) {
        Drawable r102 = r100.get();
        if ((r102 instanceof BitmapDrawable) == false) goto L7;
        return this.bitmapBytesTranscoder.transcode(BitmapResource.obtain(((BitmapDrawable) r102).getBitmap(), this.bitmapPool), r101);
    L7:
        if ((r102 instanceof GifDrawable) == true) goto L9;
        return null;
    L9:
        return this.gifDrawableBytesTranscoder.transcode(toGifDrawableResource(r100), r101);
    }

    public DrawableBytesTranscoder(BitmapPool r100, ResourceTranscoder<Bitmap, byte[]> r101, ResourceTranscoder<GifDrawable, byte[]> r102) {
        this.bitmapPool = r100;
        this.bitmapBytesTranscoder = r101;
        this.gifDrawableBytesTranscoder = r102;
    }
}
