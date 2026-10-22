package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;

/* loaded from: classes.dex */
public class BitmapEncoder implements ResourceEncoder<Bitmap> {
    private static final String TAG = "BitmapEncoder";
    private final ArrayPool arrayPool;
    public static final Option<Integer> COMPRESSION_QUALITY = Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    public static final Option<Bitmap.CompressFormat> COMPRESSION_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    public BitmapEncoder(ArrayPool arrayPool) {
        this.arrayPool = arrayPool;
    }

    private Bitmap.CompressFormat getFormat(Bitmap bitmap, Options options) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) options.get(COMPRESSION_FORMAT);
        return compressFormat != null ? compressFormat : bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    public EncodeStrategy getEncodeStrategy(Options options) {
        return EncodeStrategy.TRANSFORMED;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0073 A[Catch: all -> 0x00c3, TRY_LEAVE, TryCatch #2 {all -> 0x00c3, blocks: (B:3:0x0021, B:16:0x0052, B:29:0x006d, B:31:0x0073, B:35:0x00bf, B:36:0x00c2, B:26:0x0068), top: B:45:0x0021 }] */
    @Override // com.bumptech.glide.load.Encoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean encode(com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> r8, java.io.File r9, com.bumptech.glide.load.Options r10) {
        /*
            r7 = this;
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r8 = r8.get()
            android.graphics.Bitmap r8 = (android.graphics.Bitmap) r8
            android.graphics.Bitmap$CompressFormat r1 = r7.getFormat(r8, r10)
            int r2 = r8.getWidth()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r3 = r8.getHeight()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "encode: [%dx%d] %s"
            com.bumptech.glide.util.pool.GlideTrace.beginSectionFormat(r4, r2, r3, r1)
            long r2 = com.bumptech.glide.util.LogTime.getLogTime()     // Catch: java.lang.Throwable -> Lc3
            com.bumptech.glide.load.Option<java.lang.Integer> r4 = com.bumptech.glide.load.resource.bitmap.BitmapEncoder.COMPRESSION_QUALITY     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object r4 = r10.get(r4)     // Catch: java.lang.Throwable -> Lc3
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Throwable -> Lc3
            int r4 = r4.intValue()     // Catch: java.lang.Throwable -> Lc3
            r5 = 0
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            r6.<init>(r9)     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r9 = r7.arrayPool     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L48
            if (r9 == 0) goto L4b
            com.bumptech.glide.load.data.BufferedOutputStream r9 = new com.bumptech.glide.load.data.BufferedOutputStream     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L48
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r7 = r7.arrayPool     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L48
            r9.<init>(r6, r7)     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L48
            r5 = r9
            goto L4c
        L44:
            r7 = move-exception
            r5 = r6
            goto Lbd
        L48:
            r7 = move-exception
            r5 = r6
            goto L5a
        L4b:
            r5 = r6
        L4c:
            r8.compress(r1, r4, r5)     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            r5.close()     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            r5.close()     // Catch: java.io.IOException -> L55 java.lang.Throwable -> Lc3
        L55:
            r7 = 1
            goto L6c
        L57:
            r7 = move-exception
            goto Lbd
        L59:
            r7 = move-exception
        L5a:
            r9 = 3
            boolean r9 = android.util.Log.isLoggable(r0, r9)     // Catch: java.lang.Throwable -> L57
            if (r9 == 0) goto L66
            java.lang.String r9 = "Failed to encode Bitmap"
            android.util.Log.d(r0, r9, r7)     // Catch: java.lang.Throwable -> L57
        L66:
            if (r5 == 0) goto L6b
            r5.close()     // Catch: java.io.IOException -> L6b java.lang.Throwable -> Lc3
        L6b:
            r7 = 0
        L6c:
            r9 = 2
            boolean r9 = android.util.Log.isLoggable(r0, r9)     // Catch: java.lang.Throwable -> Lc3
            if (r9 == 0) goto Lb9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc3
            r9.<init>()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r4 = "Compressed with type: "
            r9.append(r4)     // Catch: java.lang.Throwable -> Lc3
            r9.append(r1)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r1 = " of size "
            r9.append(r1)     // Catch: java.lang.Throwable -> Lc3
            int r1 = com.bumptech.glide.util.Util.getBitmapByteSize(r8)     // Catch: java.lang.Throwable -> Lc3
            r9.append(r1)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r1 = " in "
            r9.append(r1)     // Catch: java.lang.Throwable -> Lc3
            double r1 = com.bumptech.glide.util.LogTime.getElapsedMillis(r2)     // Catch: java.lang.Throwable -> Lc3
            r9.append(r1)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r1 = ", options format: "
            r9.append(r1)     // Catch: java.lang.Throwable -> Lc3
            com.bumptech.glide.load.Option<android.graphics.Bitmap$CompressFormat> r1 = com.bumptech.glide.load.resource.bitmap.BitmapEncoder.COMPRESSION_FORMAT     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object r10 = r10.get(r1)     // Catch: java.lang.Throwable -> Lc3
            r9.append(r10)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r10 = ", hasAlpha: "
            r9.append(r10)     // Catch: java.lang.Throwable -> Lc3
            boolean r8 = r8.hasAlpha()     // Catch: java.lang.Throwable -> Lc3
            r9.append(r8)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r8 = r9.toString()     // Catch: java.lang.Throwable -> Lc3
            android.util.Log.v(r0, r8)     // Catch: java.lang.Throwable -> Lc3
        Lb9:
            com.bumptech.glide.util.pool.GlideTrace.endSection()
            return r7
        Lbd:
            if (r5 == 0) goto Lc2
            r5.close()     // Catch: java.io.IOException -> Lc2 java.lang.Throwable -> Lc3
        Lc2:
            throw r7     // Catch: java.lang.Throwable -> Lc3
        Lc3:
            r7 = move-exception
            com.bumptech.glide.util.pool.GlideTrace.endSection()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.BitmapEncoder.encode(com.bumptech.glide.load.engine.Resource, java.io.File, com.bumptech.glide.load.Options):boolean");
    }

    @Deprecated
    public BitmapEncoder() {
        this.arrayPool = null;
    }
}
