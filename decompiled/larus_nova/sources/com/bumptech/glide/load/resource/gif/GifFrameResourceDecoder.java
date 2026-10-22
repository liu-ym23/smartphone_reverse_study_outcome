package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public final class GifFrameResourceDecoder implements ResourceDecoder<GifDecoder, Bitmap> {
    private final BitmapPool bitmapPool;

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(GifDecoder r100, Options r101) {
        return true;
    }

    public GifFrameResourceDecoder(BitmapPool r100) {
        this.bitmapPool = r100;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ boolean handles(GifDecoder r100, Options r101) throws IOException {
        return handles2(r100, r101);
    }

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public Resource<Bitmap> decode2(GifDecoder r100, int r101, int r102, Options r103) {
        return BitmapResource.obtain(r100.getNextFrame(), this.bitmapPool);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ Resource<Bitmap> decode(GifDecoder r100, int r101, int r102, Options r103) throws IOException {
        return decode2(r100, r101, r102, r103);
    }
}
