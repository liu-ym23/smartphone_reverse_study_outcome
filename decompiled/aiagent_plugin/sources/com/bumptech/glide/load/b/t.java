package com.bumptech.glide.load.b;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: StreamEncoder.java */
/* JADX INFO: loaded from: classes.dex */
public class t implements com.bumptech.glide.load.d<InputStream> {
    private static final String TAG = "StreamEncoder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.b f3494a;

    @Override // com.bumptech.glide.load.d
    public /* synthetic */ boolean a(InputStream r3, File r4, com.bumptech.glide.load.i r5) {
        return a2((InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    public t(com.bumptech.glide.load.engine.a.b r3) {
        this.f3494a = (com.bumptech.glide.load.engine.a.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.a.b.class, "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(InputStream r5, File r6, com.bumptech.glide.load.i r7) {
        byte[] r0 = (byte[]) ZeusTransformUtils.preCheckCast(this.f3494a.a(65536, byte[].class), byte[].class, "com.obric.aiagent.plugin");
        boolean r1 = false;
        FileOutputStream r2 = null;
        FileOutputStream r3 = new FileOutputStream(r6);     // Catch: Throwable -> L15 IOException -> L17
    L39:
        int r8 = r5.read(r0);     // Catch: Throwable -> L11 IOException -> L13
        if (r8 == (-1)) goto L7;
        r3.write(r0, 0, r8);     // Catch: Throwable -> L11 IOException -> L13
        goto L39
    L7:
        r3.close();     // Catch: Throwable -> L11 IOException -> L13
        r1 = true;
        r3.close();     // Catch: IOException -> L30
    L32:
        goto L24
    L13:
        e = e;
        r2 = r3;
    L20:
        if (a(TAG, 3) == false) goto L22;
        a(TAG, "Failed to encode data onto the OutputStream", e);     // Catch: Throwable -> L15
    L22:
        if (r2 == null) goto L24;
        r2.close();     // Catch: IOException -> L30
    L11:
        th = th;
        r2 = r3;
    L26:
        if (r2 != null) goto L37;
    L28:
        this.f3494a.a(r0);
        throw th;
    L37:
        r2.close();     // Catch: IOException -> L31
    L17:
        e = e;
    L24:
        this.f3494a.a(r0);
        return r1;
    L15:
        th = th;
        goto L26
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
        return Log.d(r1, r2, r3);
    }
}
