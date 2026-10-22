package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes39.dex */
public final class ByteBufferBitmapImageDecoderResourceDecoder implements ResourceDecoder<ByteBuffer, Bitmap> {
    private final BitmapImageDecoderResourceDecoder wrapped;

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(ByteBuffer r100, Options r101) throws IOException {
        return true;
    }

    public ByteBufferBitmapImageDecoderResourceDecoder() {
        this.wrapped = new BitmapImageDecoderResourceDecoder();
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ boolean handles(ByteBuffer r100, Options r101) throws IOException {
        return handles2(r100, r101);
    }

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public Resource<Bitmap> decode2(ByteBuffer r100, int r101, int r102, Options r103) throws IOException {
        ImageDecoder.Source r104 = ImageDecoder.createSource(r100);
        return this.wrapped.decode2(r104, r101, r102, r103);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ Resource<Bitmap> decode(ByteBuffer r100, int r101, int r102, Options r103) throws IOException {
        return decode2(r100, r101, r102, r103);
    }
}
