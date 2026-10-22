package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.CacheSink;
import com.bumptech.glide.util.ByteBufferUtil;
import com.bumptech.glide.util.GlideLogUtil;
import com.larksuite.framework.utils.o;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes39.dex */
public class GifDrawableEncoder implements ResourceEncoder<GifDrawable> {
    private static final String TAG = "GifEncoder";

    public GifDrawableEncoder() {
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    public EncodeStrategy getEncodeStrategy(Options r100) {
        return EncodeStrategy.SOURCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    public boolean encode(Resource<GifDrawable> r100, CacheSink r101, Options r102) {
        GifDrawable r103 = r100.get();
        int r104 = 1;
        r104 = 1;
        r104 = 1;
        OutputStream r105 = null;
        r105 = r101.openOutputStream();     // Catch: Throwable -> L5 IOException -> L7
        ByteBufferUtil.toStream(r103.getBuffer(), r105);     // Catch: Throwable -> L5 IOException -> L7
        o.a(new Closeable[]{r105});
    L13:
        return r104;
    L5:
        th = move-exception;
        Closeable[] r106 = new Closeable[r104];
        r106[0] = r105;
        o.a(r106);
        throw th;
    L7:
        e = move-exception;
        GlideLogUtil.e(TAG, "Failed to encode GIF drawable data", e);     // Catch: Throwable -> L5
        o.a(new Closeable[]{r105});
        r104 = 0;
        goto L13
    }

    @Override // com.bumptech.glide.load.Encoder
    public /* bridge */ /* synthetic */ boolean encode(Object r100, CacheSink r101, Options r102) {
        return encode((Resource) r100, r101, r102);
    }
}
