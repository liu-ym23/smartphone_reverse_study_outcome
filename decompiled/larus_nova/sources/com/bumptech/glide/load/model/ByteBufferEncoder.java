package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.cache.CacheSink;
import com.bumptech.glide.util.ByteBufferUtil;
import com.bumptech.glide.util.GlideLogUtil;
import com.larksuite.framework.utils.o;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes39.dex */
public class ByteBufferEncoder implements Encoder<ByteBuffer> {
    private static final String TAG = "ByteBufferEncoder";

    public ByteBufferEncoder() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public boolean encode2(ByteBuffer r100, CacheSink r101, Options r102) {
        int r103 = 1;
        r103 = 1;
        r103 = 1;
        OutputStream r104 = null;
        r104 = r101.openOutputStream();     // Catch: Throwable -> L5 IOException -> L7
        ByteBufferUtil.toStream(r100, r104);     // Catch: Throwable -> L5 IOException -> L7
        o.a(new Closeable[]{r104});
    L13:
        return r103;
    L5:
        th = move-exception;
        Closeable[] r105 = new Closeable[r103];
        r105[0] = r104;
        o.a(r105);
        throw th;
    L7:
        e = move-exception;
        GlideLogUtil.e(TAG, "Failed to write data", e);     // Catch: Throwable -> L5
        o.a(new Closeable[]{r104});
        r103 = 0;
        goto L13
    }

    @Override // com.bumptech.glide.load.Encoder
    public /* bridge */ /* synthetic */ boolean encode(ByteBuffer r100, CacheSink r101, Options r102) {
        return encode2(r100, r101, r102);
    }
}
