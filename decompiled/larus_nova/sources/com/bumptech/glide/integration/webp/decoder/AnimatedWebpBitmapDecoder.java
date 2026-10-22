package com.bumptech.glide.integration.webp.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.integration.webp.WebpHeaderParser;
import com.bumptech.glide.integration.webp.WebpImage;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.gif.GifBitmapProvider;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes39.dex */
public class AnimatedWebpBitmapDecoder {
    public static final Option<Boolean> DISABLE_BITMAP = null;
    private final ArrayPool mArrayPool;
    private final BitmapPool mBitmapPool;
    private final Context mContext;
    private final GifBitmapProvider mProvider;

    static {
        DISABLE_BITMAP = Option.memory("com.bumptech.glide.integration.webp.decoder.AnimatedWebpBitmapDecoder.DisableBitmap", Boolean.FALSE);
    }

    public boolean handles(InputStream r100, Options r101) throws IOException {
        if (((Boolean) r101.get(DISABLE_BITMAP)).booleanValue() == false) goto L7;
        return false;
    L7:
        return WebpHeaderParser.isAnimatedWebpType(WebpHeaderParser.getType(r100, this.mArrayPool));
    }

    public boolean handles(ByteBuffer r100, Options r101) throws IOException {
        if (((Boolean) r101.get(DISABLE_BITMAP)).booleanValue() == false) goto L7;
        return false;
    L7:
        return WebpHeaderParser.isAnimatedWebpType(WebpHeaderParser.getType(r100));
    }

    public AnimatedWebpBitmapDecoder(Context r100, ArrayPool r101, BitmapPool r102) {
        this.mContext = r100;
        this.mArrayPool = r101;
        this.mBitmapPool = r102;
        this.mProvider = new GifBitmapProvider(r102, r101);
    }

    public Resource<Bitmap> decode(ByteBuffer r100, int r110, int r111, Options r112) throws IOException {
        int r113 = r100.remaining();
        byte[] r101 = new byte[r113];
        r100.get(r101, 0, r113);
        WebpImage r102 = WebpImage.create(r101);
        int r103 = Utils.getSampleSize(r102.getWidth(), r102.getHeight(), r110, r111);
        WebpDecoder r114 = new WebpDecoder(this.mContext, this.mProvider, r102, r100, r103);
        r114.advance();     // Catch: Throwable -> L6
        BitmapResource r104 = BitmapResource.obtain(r114.getNextFrame(), this.mBitmapPool);     // Catch: Throwable -> L6
        r114.clear();
        return r104;
    L6:
        th = move-exception;
        r114.clear();
        throw th;
    }

    public Resource<Bitmap> decode(InputStream r100, int r101, int r102, Options r103) throws IOException {
        byte[] r104 = Utils.inputStreamToBytes(r100);
        if (r104 != null) goto L7;
        return null;
    L7:
        return decode(ByteBuffer.wrap(r104), r101, r102, r103);
    }
}
