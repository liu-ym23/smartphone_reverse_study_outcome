package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

/* JADX INFO: loaded from: classes39.dex */
public final class GifBitmapProvider implements GifDecoder.BitmapProvider {
    private final ArrayPool arrayPool;
    private final BitmapPool bitmapPool;

    public GifBitmapProvider(BitmapPool r100) {
        this(r100, null);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public byte[] obtainByteArray(int r100) {
        ArrayPool r101 = this.arrayPool;
        if (r101 != null) goto L7;
        return new byte[r100];
    L7:
        return (byte[]) r101.get(r100, byte[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public int[] obtainIntArray(int r100) {
        ArrayPool r101 = this.arrayPool;
        if (r101 != null) goto L7;
        return new int[r100];
    L7:
        return (int[]) r101.get(r100, int[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public void release(byte[] r100) {
        ArrayPool r101 = this.arrayPool;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.put(r100);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public void release(int[] r100) {
        ArrayPool r101 = this.arrayPool;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.put(r100);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public void release(Bitmap r100) {
        this.bitmapPool.put(r100);
    }

    public GifBitmapProvider(BitmapPool r100, ArrayPool r101) {
        this.bitmapPool = r100;
        this.arrayPool = r101;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public Bitmap obtain(int r100, int r101, Bitmap.Config r102) {
        return this.bitmapPool.getDirty(r100, r101, r102);
    }
}
