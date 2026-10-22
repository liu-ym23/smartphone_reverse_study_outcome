package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.gif.GifDrawable;

/* JADX INFO: loaded from: classes.dex */
public final class DrawableBytesTranscoder implements ResourceTranscoder<Drawable, byte[]> {
    private final ResourceTranscoder<Bitmap, byte[]> bitmapBytesTranscoder;
    private final BitmapPool bitmapPool;
    private final ResourceTranscoder<GifDrawable, byte[]> gifDrawableBytesTranscoder;

    public DrawableBytesTranscoder(@NonNull BitmapPool r10, @NonNull ResourceTranscoder<Bitmap, byte[]> r11, @NonNull ResourceTranscoder<GifDrawable, byte[]> r12) {
        this.bitmapPool = r10;
        this.bitmapBytesTranscoder = r11;
        this.gifDrawableBytesTranscoder = r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    private static Resource<GifDrawable> toGifDrawableResource(@NonNull Resource<Drawable> r10) {
        return r10;
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    @Nullable
    public Resource<byte[]> transcode(@NonNull Resource<Drawable> r10, @NonNull Options r11) {
        Drawable r12 = r10.get();
        if ((r12 instanceof BitmapDrawable) == false) goto L7;
        return this.bitmapBytesTranscoder.transcode(BitmapResource.obtain(((BitmapDrawable) r12).getBitmap(), this.bitmapPool), r11);
    L7:
        if ((r12 instanceof GifDrawable) == true) goto L9;
        return null;
    L9:
        return this.gifDrawableBytesTranscoder.transcode(toGifDrawableResource(r10), r11);
    }
}
