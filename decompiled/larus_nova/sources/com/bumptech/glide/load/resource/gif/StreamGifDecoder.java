package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.util.GlideLogUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class StreamGifDecoder implements ResourceDecoder<InputStream, GifDrawable> {
    private static final String TAG = "StreamGifDecoder";
    private final ArrayPool byteArrayPool;
    private final ResourceDecoder<ByteBuffer, GifDrawable> byteBufferDecoder;
    private final List<ImageHeaderParser> parsers;

    private static byte[] inputStreamToBytes(InputStream r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream(16384);
        byte[] r102 = new byte[16384];     // Catch: IOException -> L10
    L4:
        int r103 = r100.read(r102);     // Catch: IOException -> L10
        if (r103 == (-1)) goto L7;
        r101.write(r102, 0, r103);     // Catch: IOException -> L10
        goto L4
    L7:
        r101.flush();     // Catch: IOException -> L10
        return r101.toByteArray();
    L10:
        e = move-exception;
        GlideLogUtil.e(TAG, "Error reading data from stream", e);
        return null;
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(InputStream r100, Options r101) throws IOException {
        if (((Boolean) r101.get(BaseRequestOptions.DISABLE_ANIMATION)).booleanValue() == false) goto L5;
    L7:
        return false;
    L5:
        if (ImageHeaderParserUtils.getType(this.parsers, r100, this.byteArrayPool) != ImageHeaderParser.ImageType.GIF) goto L7;
        return true;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ boolean handles(InputStream r100, Options r101) throws IOException {
        return handles2(r100, r101);
    }

    public StreamGifDecoder(List<ImageHeaderParser> r100, ResourceDecoder<ByteBuffer, GifDrawable> r101, ArrayPool r102) {
        this.parsers = r100;
        this.byteBufferDecoder = r101;
        this.byteArrayPool = r102;
    }

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public Resource<GifDrawable> decode2(InputStream r100, int r101, int r102, Options r103) throws IOException {
        byte[] r104 = inputStreamToBytes(r100);
        if (r104 != null) goto L6;
        return null;
    L6:
        ByteBuffer r105 = ByteBuffer.wrap(r104);
        return this.byteBufferDecoder.decode(r105, r101, r102, r103);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ Resource<GifDrawable> decode(InputStream r100, int r101, int r102, Options r103) throws IOException {
        return decode2(r100, r101, r102, r103);
    }
}
