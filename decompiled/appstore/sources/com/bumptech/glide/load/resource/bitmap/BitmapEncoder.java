package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.BufferedOutputStream;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.GlideTrace;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class BitmapEncoder implements ResourceEncoder<Bitmap> {
    public static final Option<Bitmap.CompressFormat> COMPRESSION_FORMAT = null;
    public static final Option<Integer> COMPRESSION_QUALITY = null;
    private static final String TAG = "BitmapEncoder";

    @Nullable
    private final ArrayPool arrayPool;

    static {
        COMPRESSION_QUALITY = Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
        COMPRESSION_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    }

    public BitmapEncoder(@NonNull ArrayPool r10) {
        this.arrayPool = r10;
    }

    private Bitmap.CompressFormat getFormat(Bitmap r10, Options r11) {
        Bitmap.CompressFormat r12 = (Bitmap.CompressFormat) r11.get(COMPRESSION_FORMAT);
        if (r12 == null) goto L6;
        return r12;
    L6:
        if (r10.hasAlpha() == false) goto L10;
        return Bitmap.CompressFormat.PNG;
    L10:
        return Bitmap.CompressFormat.JPEG;
    }

    @Override // com.bumptech.glide.load.Encoder
    public /* bridge */ /* synthetic */ boolean encode(@NonNull Object r10, @NonNull File r11, @NonNull Options r12) {
        return encode((Resource) r10, r11, r12);
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    @NonNull
    public EncodeStrategy getEncodeStrategy(@NonNull Options r10) {
        return EncodeStrategy.TRANSFORMED;
    }

    public boolean encode(@NonNull Resource<Bitmap> r10, @NonNull File r11, @NonNull Options r12) {
        Bitmap r13 = r10.get();
        Bitmap.CompressFormat r14 = getFormat(r13, r12);
        GlideTrace.beginSectionFormat("encode: [%dx%d] %s", Integer.valueOf(r13.getWidth()), Integer.valueOf(r13.getHeight()), r14);
        long r15 = LogTime.getLogTime();     // Catch: Throwable -> L18
        int r16 = ((Integer) r12.get(COMPRESSION_QUALITY)).intValue();     // Catch: Throwable -> L18
        OutputStream r17 = null;
        FileOutputStream r18 = new FileOutputStream(r11);     // Catch: Throwable -> L21 IOException -> L23
    L12:
        e = e;
        r17 = r18;
    L26:
        if (Log.isLoggable(TAG, 3) == false) goto L28;
        Log.d(TAG, "Failed to encode Bitmap", e);     // Catch: Throwable -> L21
    L28:
        if (r17 != null) goto L51;
    L30:
        boolean r19 = false;
    L33:
        if (Log.isLoggable(TAG, 2) == false) goto L35;
        Log.v(TAG, "Compressed with type: " + r14 + " of size " + Util.getBitmapByteSize(r13) + " in " + LogTime.getElapsedMillis(r15) + ", options format: " + r12.get(COMPRESSION_FORMAT) + ", hasAlpha: " + r13.hasAlpha());     // Catch: Throwable -> L18
    L35:
        GlideTrace.endSection();
        return r19;
    L51:
        r17.close();     // Catch: Throwable -> L18 IOException -> L44
    L10:
        th = th;
        r17 = r18;
    L37:
        if (r17 != null) goto L47;
    L39:
        throw th;     // Catch: Throwable -> L18
    L47:
        r17.close();     // Catch: Throwable -> L18 IOException -> L43
        goto L39
    L7:
        if (this.arrayPool == null) goto L14;
        r17 = new BufferedOutputStream(r18, this.arrayPool);     // Catch: Throwable -> L10 IOException -> L12
    L15:
        r13.compress(r14, r16, r17);     // Catch: Throwable -> L21 IOException -> L23
        r17.close();     // Catch: Throwable -> L21 IOException -> L23
        r17.close();     // Catch: Throwable -> L18 IOException -> L42
    L20:
        r19 = true;
        goto L33
    L14:
        r17 = r18;
    L21:
        th = th;
    L23:
        e = e;
    L18:
        th = move-exception;
        GlideTrace.endSection();
        throw th;
    }

    @Deprecated
    public BitmapEncoder() {
        this.arrayPool = null;
    }
}
