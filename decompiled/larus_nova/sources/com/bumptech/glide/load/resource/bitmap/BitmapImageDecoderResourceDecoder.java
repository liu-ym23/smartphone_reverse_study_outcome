package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.resource.ImageDecoderResourceDecoder;
import com.bumptech.glide.util.GlideLogUtil;
import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public final class BitmapImageDecoderResourceDecoder extends ImageDecoderResourceDecoder<Bitmap> {
    private static final String TAG = "BitmapImageDecoder";
    private final BitmapPool bitmapPool;

    public BitmapImageDecoderResourceDecoder() {
        this.bitmapPool = new BitmapPoolAdapter();
    }

    @Override // com.bumptech.glide.load.resource.ImageDecoderResourceDecoder
    public Resource<Bitmap> decode(ImageDecoder.Source r100, int r101, int r102, ImageDecoder.OnHeaderDecodedListener r103) throws IOException {
        Bitmap r104 = ImageDecoder.decodeBitmap(r100, r103);
        GlideLogUtil.i(TAG, "Decoded [" + r104.getWidth() + "x" + r104.getHeight() + "] for [" + r101 + "x" + r102 + "]");
        return new BitmapResource(r104, this.bitmapPool);
    }
}
