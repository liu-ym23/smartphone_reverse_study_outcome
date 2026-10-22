package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StreamGifDecoder implements ResourceDecoder<InputStream, GifDrawable> {
    private static final String TAG = "StreamGifDecoder";
    private final ArrayPool byteArrayPool;
    private final ResourceDecoder<ByteBuffer, GifDrawable> byteBufferDecoder;
    private final List<ImageHeaderParser> parsers;

    public StreamGifDecoder(List<ImageHeaderParser> r10, ResourceDecoder<ByteBuffer, GifDrawable> r11, ArrayPool r12) {
        this.parsers = r10;
        this.byteBufferDecoder = r11;
        this.byteArrayPool = r12;
    }

    private static byte[] inputStreamToBytes(InputStream r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream(16384);
        byte[] r12 = new byte[16384];     // Catch: IOException -> L7
    L4:
        int r13 = r10.read(r12);     // Catch: IOException -> L7
        if (r13 == (-1)) goto L9;
        r11.write(r12, 0, r13);     // Catch: IOException -> L7
        goto L4
    L9:
        r11.flush();     // Catch: IOException -> L7
        return r11.toByteArray();
    L7:
        e = move-exception;
        if (Log.isLoggable(TAG, 5) == false) goto L20;
        Log.w(TAG, "Error reading data from stream", e);
        return null;
    L20:
        return null;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ Resource<GifDrawable> decode(@NonNull InputStream r10, int r11, int r12, @NonNull Options r13) throws IOException {
        return decode2(r10, r11, r12, r13);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ boolean handles(@NonNull InputStream r10, @NonNull Options r11) throws IOException {
        return handles2(r10, r11);
    }

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public Resource<GifDrawable> decode2(@NonNull InputStream r10, int r11, int r12, @NonNull Options r13) throws IOException {
        byte[] r14 = inputStreamToBytes(r10);
        if (r14 != null) goto L6;
        return null;
    L6:
        ByteBuffer r15 = ByteBuffer.wrap(r14);
        return this.byteBufferDecoder.decode(r15, r11, r12, r13);
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(@NonNull InputStream r10, @NonNull Options r11) throws IOException {
        if (((Boolean) r11.get(GifOptions.DISABLE_ANIMATION)).booleanValue() == false) goto L5;
    L7:
        return false;
    L5:
        if (ImageHeaderParserUtils.getType(this.parsers, r10, this.byteArrayPool) != ImageHeaderParser.ImageType.GIF) goto L7;
        return true;
    }
}
