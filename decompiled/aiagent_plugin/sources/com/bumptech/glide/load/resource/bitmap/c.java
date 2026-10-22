package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: BitmapEncoder.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements com.bumptech.glide.load.l<Bitmap> {
    private static final String TAG = "BitmapEncoder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bumptech.glide.load.h<Integer> f3792a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bumptech.glide.load.h<Bitmap.CompressFormat> f3793b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.b f3794c;

    @Override // com.bumptech.glide.load.d
    public /* synthetic */ boolean a(Object r3, File r4, com.bumptech.glide.load.i r5) {
        return a((com.bumptech.glide.load.engine.v) ZeusTransformUtils.preCheckCast(r3, com.bumptech.glide.load.engine.v.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    static {
        f3792a = com.bumptech.glide.load.h.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
        f3793b = com.bumptech.glide.load.h.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    }

    public c(com.bumptech.glide.load.engine.a.b r3) {
        this.f3794c = (com.bumptech.glide.load.engine.a.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.a.b.class, "com.obric.aiagent.plugin");
    }

    @Deprecated
    public c() {
        this.f3794c = null;
    }

    public boolean a(com.bumptech.glide.load.engine.v<Bitmap> r9, File r10, com.bumptech.glide.load.i r11) {
        Bitmap r12 = (Bitmap) ZeusTransformUtils.preCheckCast(((com.bumptech.glide.load.engine.v) ZeusTransformUtils.wrapperContextForParams(r9, com.bumptech.glide.load.engine.v.class, "com.obric.aiagent.plugin")).d(), Bitmap.class, "com.obric.aiagent.plugin");
        Bitmap.CompressFormat r1 = a(r12, r11);
        com.bumptech.glide.f.a.b.a("encode: [%dx%d] %s", Integer.valueOf(r12.getWidth()), Integer.valueOf(r12.getHeight()), r1);
        long r3 = com.bumptech.glide.f.f.a();     // Catch: Throwable -> L37
        int r2 = ((Integer) ZeusTransformUtils.preCheckCast(r11.a(f3792a), Integer.class, "com.obric.aiagent.plugin")).intValue();     // Catch: Throwable -> L37
        boolean r5 = false;
        OutputStream r6 = null;
        FileOutputStream r7 = new FileOutputStream(r10);     // Catch: Throwable -> L19 IOException -> L21
    L17:
        e = e;
        r6 = r7;
    L24:
        if (a(TAG, 3) == false) goto L26;
        a(TAG, "Failed to encode Bitmap", e);     // Catch: Throwable -> L19
    L26:
        if (r6 == null) goto L30;
    L45:
        r6.close();     // Catch: IOException -> L40 Throwable -> L37
    L30:
        if (a(TAG, 2) == false) goto L32;
        a(TAG, "Compressed with type: " + r1 + " of size " + com.bumptech.glide.f.k.a(r12) + " in " + com.bumptech.glide.f.f.a(r3) + ", options format: " + r11.a(f3793b) + ", hasAlpha: " + r12.hasAlpha());     // Catch: Throwable -> L37
    L32:
        com.bumptech.glide.f.a.b.a();
        return r5;
    L15:
        th = th;
        r6 = r7;
    L34:
        if (r6 != null) goto L43;
    L36:
        throw th;     // Catch: Throwable -> L37
    L43:
        r6.close();     // Catch: IOException -> L41 Throwable -> L37
        goto L36
    L7:
        if (this.f3794c == null) goto L10;
        r6 = new com.bumptech.glide.load.a.c(r7, this.f3794c);     // Catch: Throwable -> L15 IOException -> L17
    L11:
        r12.compress(r1, r2, r6);     // Catch: Throwable -> L19 IOException -> L21
        r6.close();     // Catch: Throwable -> L19 IOException -> L21
        r5 = true;
        goto L45
    L10:
        r6 = r7;
    L21:
        e = e;
    L19:
        th = th;
    L37:
        th = move-exception;
        com.bumptech.glide.f.a.b.a();
        throw th;
    }

    private Bitmap.CompressFormat a(Bitmap r2, com.bumptech.glide.load.i r3) {
        Bitmap.CompressFormat r1 = (Bitmap.CompressFormat) ZeusTransformUtils.preCheckCast(r3.a(f3793b), Bitmap.CompressFormat.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L6;
        return r1;
    L6:
        if (r2.hasAlpha() == false) goto L10;
        return Bitmap.CompressFormat.PNG;
    L10:
        return Bitmap.CompressFormat.JPEG;
    }

    @Override // com.bumptech.glide.load.l
    public com.bumptech.glide.load.c a(com.bumptech.glide.load.i r1) {
        return com.bumptech.glide.load.c.f3507b;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean a(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2, r3);
    }
}
