package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.BufferedOutputStream;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.cache.CacheSink;
import com.bumptech.glide.util.GlideLogUtil;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.GlideTrace;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes39.dex */
public class BitmapEncoder implements ResourceEncoder<Bitmap> {
    public static final Option<Bitmap.CompressFormat> COMPRESSION_FORMAT = null;
    public static final Option<Integer> COMPRESSION_QUALITY = null;
    private static final String TAG = "BitmapEncoder";
    private final ArrayPool arrayPool;

    static {
        COMPRESSION_QUALITY = Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
        COMPRESSION_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    }

    public BitmapEncoder() {
        this.arrayPool = null;
    }

    public BitmapEncoder(ArrayPool r100) {
        this.arrayPool = r100;
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    public EncodeStrategy getEncodeStrategy(Options r100) {
        return EncodeStrategy.TRANSFORMED;
    }

    private Bitmap.CompressFormat getFormat(Bitmap r100, Options r101) {
        Bitmap.CompressFormat r102 = (Bitmap.CompressFormat) r101.get(COMPRESSION_FORMAT);
        if (r102 == null) goto L6;
        return r102;
    L6:
        if (r100.hasAlpha() == false) goto L10;
        return Bitmap.CompressFormat.PNG;
    L10:
        return Bitmap.CompressFormat.JPEG;
    }

    public boolean encode(Resource<Bitmap> r100, CacheSink r101, Options r110) {
        Bitmap r102 = r100.get();
        Bitmap.CompressFormat r103 = getFormat(r102, r110);
        GlideTrace.beginSectionFormat("encode: [%dx%d] %s", Integer.valueOf(r102.getWidth()), Integer.valueOf(r102.getHeight()), r103);
        long r104 = LogTime.getLogTime();     // Catch: Throwable -> L27
        int r105 = ((Integer) r110.get(COMPRESSION_QUALITY)).intValue();     // Catch: Throwable -> L27
        OutputStream r106 = null;
        r106 = r101.openOutputStream();     // Catch: Throwable -> L11 IOException -> L13
        if (this.arrayPool == null) goto L8;
        r106 = new BufferedOutputStream(r106, this.arrayPool);     // Catch: Throwable -> L11 IOException -> L13
    L8:
        r102.compress(r103, r105, r106);     // Catch: Throwable -> L11 IOException -> L13
        r106.close();     // Catch: Throwable -> L11 IOException -> L13
    L41:
        r106.close();     // Catch: IOException -> L30 Throwable -> L27
    L10:
        boolean r107 = true;
    L20:
        if (Log.isLoggable(TAG, 2) == false) goto L22;
        Objects.toString(r103);     // Catch: Throwable -> L27
        Util.getBitmapByteSize(r102);     // Catch: Throwable -> L27
        LogTime.getElapsedMillis(r104);     // Catch: Throwable -> L27
        Objects.toString(r110.get(COMPRESSION_FORMAT));     // Catch: Throwable -> L27
        r102.hasAlpha();     // Catch: Throwable -> L27
    L22:
        GlideTrace.endSection();
        return r107;
    L13:
        e = move-exception;
        GlideLogUtil.e(TAG, "Failed to encode Bitmap", e);     // Catch: Throwable -> L11
        if (r106 != null) goto L33;
    L17:
        r107 = false;
        goto L20
    L33:
        r106.close();     // Catch: IOException -> L32 Throwable -> L27
        goto L17
    L11:
        th = move-exception;
        if (r106 != null) goto L36;
    L26:
        throw th;     // Catch: Throwable -> L27
    L36:
        r106.close();     // Catch: IOException -> L31 Throwable -> L27
    L27:
        th = move-exception;
        GlideTrace.endSection();
        throw th;
    }

    @Override // com.bumptech.glide.load.Encoder
    public /* bridge */ /* synthetic */ boolean encode(Object r100, CacheSink r101, Options r102) {
        return encode((Resource) r100, r101, r102);
    }
}
