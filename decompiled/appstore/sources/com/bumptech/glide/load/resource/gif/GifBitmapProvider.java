package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

/* JADX INFO: loaded from: classes.dex */
public final class GifBitmapProvider implements GifDecoder.BitmapProvider {

    @Nullable
    private final ArrayPool arrayPool;
    private final BitmapPool bitmapPool;

    public GifBitmapProvider(BitmapPool r10) {
        this(r10, null);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    @NonNull
    public Bitmap obtain(int r10, int r11, @NonNull Bitmap.Config r12) {
        return this.bitmapPool.getDirty(r10, r11, r12);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    @NonNull
    public byte[] obtainByteArray(int r10) {
        ArrayPool r11 = this.arrayPool;
        if (r11 != null) goto L7;
        return new byte[r10];
    L7:
        return (byte[]) r11.get(r10, byte[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    @NonNull
    public int[] obtainIntArray(int r10) {
        ArrayPool r11 = this.arrayPool;
        if (r11 != null) goto L7;
        return new int[r10];
    L7:
        return (int[]) r11.get(r10, int[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public void release(@NonNull Bitmap r10) {
        this.bitmapPool.put(r10);
    }

    public GifBitmapProvider(BitmapPool r10, @Nullable ArrayPool r11) {
        this.bitmapPool = r10;
        this.arrayPool = r11;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public void release(@NonNull byte[] r10) {
        ArrayPool r11 = this.arrayPool;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.put(r10);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public void release(@NonNull int[] r10) {
        ArrayPool r11 = this.arrayPool;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.put(r10);
    }
}
