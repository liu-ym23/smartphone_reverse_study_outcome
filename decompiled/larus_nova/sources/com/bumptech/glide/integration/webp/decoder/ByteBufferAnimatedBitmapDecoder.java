package com.bumptech.glide.integration.webp.decoder;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes39.dex */
public class ByteBufferAnimatedBitmapDecoder implements ResourceDecoder<ByteBuffer, Bitmap> {
    private final AnimatedWebpBitmapDecoder bitmapDecoder;

    public ByteBufferAnimatedBitmapDecoder(AnimatedWebpBitmapDecoder r100) {
        this.bitmapDecoder = r100;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ boolean handles(ByteBuffer r100, Options r101) throws IOException {
        return handles2(r100, r101);
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(ByteBuffer r100, Options r101) throws IOException {
        return this.bitmapDecoder.handles(r100, r101);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ Resource<Bitmap> decode(ByteBuffer r100, int r101, int r102, Options r103) throws IOException {
        return decode2(r100, r101, r102, r103);
    }

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public Resource<Bitmap> decode2(ByteBuffer r100, int r101, int r102, Options r103) throws IOException {
        return this.bitmapDecoder.decode(r100, r101, r102, r103);
    }
}
