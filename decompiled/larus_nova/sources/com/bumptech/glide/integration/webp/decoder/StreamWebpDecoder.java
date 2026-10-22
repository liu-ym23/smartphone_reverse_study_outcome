package com.bumptech.glide.integration.webp.decoder;

import com.bumptech.glide.integration.webp.WebpHeaderParser;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.request.BaseRequestOptions;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes39.dex */
public class StreamWebpDecoder implements ResourceDecoder<InputStream, WebpDrawable> {
    private final ArrayPool byteArrayPool;
    private final ResourceDecoder<ByteBuffer, WebpDrawable> byteBufferDecoder;

    public StreamWebpDecoder(ResourceDecoder<ByteBuffer, WebpDrawable> r100, ArrayPool r101) {
        this.byteBufferDecoder = r100;
        this.byteArrayPool = r101;
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(InputStream r100, Options r101) throws IOException {
        if (((Boolean) r101.get(BaseRequestOptions.DISABLE_ANIMATION)).booleanValue() == false) goto L7;
        return false;
    L7:
        return WebpHeaderParser.isAnimatedWebpType(WebpHeaderParser.getType(r100, this.byteArrayPool));
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ boolean handles(InputStream r100, Options r101) throws IOException {
        return handles2(r100, r101);
    }

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public Resource<WebpDrawable> decode2(InputStream r100, int r101, int r102, Options r103) throws IOException {
        byte[] r104 = Utils.inputStreamToBytes(r100);
        if (r104 != null) goto L6;
        return null;
    L6:
        ByteBuffer r105 = ByteBuffer.wrap(r104);
        return this.byteBufferDecoder.decode(r105, r101, r102, r103);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ Resource<WebpDrawable> decode(InputStream r100, int r101, int r102, Options r103) throws IOException {
        return decode2(r100, r101, r102, r103);
    }
}
