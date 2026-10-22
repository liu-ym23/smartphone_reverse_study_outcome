package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.cache.CacheSink;
import com.bumptech.glide.util.GlideLogUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes39.dex */
public class StreamEncoder implements Encoder<InputStream> {
    private static final String TAG = "StreamEncoder";
    private final ArrayPool byteArrayPool;

    public StreamEncoder(ArrayPool r100) {
        this.byteArrayPool = r100;
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public boolean encode2(InputStream r100, CacheSink r101, Options r102) {
        byte[] r103 = (byte[]) this.byteArrayPool.get(65536, byte[].class);
        OutputStream r104 = null;
        r104 = r101.openOutputStream();     // Catch: Throwable -> L10 IOException -> L12
    L4:
        int r105 = r100.read(r103);     // Catch: Throwable -> L10 IOException -> L12
        if (r105 == (-1)) goto L7;
        r104.write(r103, 0, r105);     // Catch: Throwable -> L10 IOException -> L12
        goto L4
    L7:
        r104.close();     // Catch: Throwable -> L10 IOException -> L12
        r104.close();     // Catch: IOException -> L22
    L9:
        this.byteArrayPool.put(r103);
        return true;
    L10:
        th = move-exception;
        if (r104 != null) goto L29;
    L20:
        this.byteArrayPool.put(r103);
        throw th;
    L29:
        r104.close();     // Catch: IOException -> L23
    L12:
        e = move-exception;
        GlideLogUtil.e(TAG, "Failed to encode data onto the OutputStream", e);     // Catch: Throwable -> L10
        if (r104 != null) goto L25;
    L16:
        this.byteArrayPool.put(r103);
        return false;
    L25:
        r104.close();     // Catch: IOException -> L24
        goto L16
    }

    @Override // com.bumptech.glide.load.Encoder
    public /* bridge */ /* synthetic */ boolean encode(InputStream r100, CacheSink r101, Options r102) {
        return encode2(r100, r101, r102);
    }
}
