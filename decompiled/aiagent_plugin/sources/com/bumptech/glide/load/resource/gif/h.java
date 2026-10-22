package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.v;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.k;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: StreamGifDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class h implements k<InputStream, GifDrawable> {
    private static final String TAG = "StreamGifDecoder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ImageHeaderParser> f3888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k<ByteBuffer, GifDrawable> f3889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.b f3890c;

    @Override // com.bumptech.glide.load.k
    public /* synthetic */ v<GifDrawable> a(InputStream r3, int r4, int r5, i r6) {
        return a2((InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.bumptech.glide.load.k
    public /* synthetic */ boolean a(InputStream r3, i r4) {
        return a2((InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.aiagent.plugin"), r4);
    }

    public h(List<ImageHeaderParser> r3, k<ByteBuffer, GifDrawable> r4, com.bumptech.glide.load.engine.a.b r5) {
        List<ImageHeaderParser> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        k<ByteBuffer, GifDrawable> r7 = (k) ZeusTransformUtils.wrapperContextForParams(r4, k.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.engine.a.b r8 = (com.bumptech.glide.load.engine.a.b) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.engine.a.b.class, "com.obric.aiagent.plugin");
        this.f3888a = r6;
        this.f3889b = r7;
        this.f3890c = r8;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(InputStream r3, i r4) {
        if (((Boolean) ZeusTransformUtils.preCheckCast(r4.a(g.f3887b), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L5;
    L7:
        return false;
    L5:
        if (com.bumptech.glide.load.f.getType(this.f3888a, r3, this.f3890c) != ImageHeaderParser.ImageType.GIF) goto L7;
        return true;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public v<GifDrawable> a2(InputStream r1, int r2, int r3, i r4) {
        byte[] r5 = a(r1);
        if (r5 != null) goto L6;
        return null;
    L6:
        ByteBuffer r6 = ByteBuffer.wrap(r5);
        return this.f3889b.a(r6, r2, r3, r4);
    }

    private static byte[] a(InputStream r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(16384);
        byte[] r1 = new byte[16384];     // Catch: IOException -> L10
    L4:
        int r2 = r4.read(r1);     // Catch: IOException -> L10
        if (r2 == (-1)) goto L7;
        r0.write(r1, 0, r2);     // Catch: IOException -> L10
        goto L4
    L7:
        r0.flush();     // Catch: IOException -> L10
        return r0.toByteArray();
    L10:
        e = move-exception;
        if (a(TAG, 5) == false) goto L19;
        a(TAG, "Error reading data from stream", e);
        return null;
    L19:
        return null;
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
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}
