package com.bytedance.android.livesdk.utils;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.message.model.gg;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes11.dex */
public final class a5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a5 f158820a;

    public static void a() {
        if (df6.g.getContext() == null) goto L52;
        InputStreamReader r100 = null;
        char[] r101 = null;
        InputStreamReader r102 = null;
        r102 = null;
        r102 = null;
        if (df6.g.getContext().getExternalFilesDir(null) == null) goto L69;
        String r103 = df6.g.getContext().getExternalFilesDir(null).getAbsolutePath() + File.separator + "mockFile.json";
        if (new PolarisFileWrapper(r103).exists() == true) goto L64;
        return;
    L64:
        PolarisFileInputStreamWrapper r104 = new PolarisFileInputStreamWrapper(r103);     // Catch: Throwable -> L25 IOException -> L27
        InputStreamReader r105 = new InputStreamReader(r104, "UTF-8");     // Catch: Throwable -> L21 IOException -> L23
        r101 = new char[r104.available()];     // Catch: Throwable -> L17 IOException -> L19
        r105.read(r101);     // Catch: Throwable -> L17 IOException -> L19
        r105.close();     // Catch: Throwable -> L17 IOException -> L19
        r104.close();     // Catch: Throwable -> L17 IOException -> L19
        r105.close();     // Catch: IOException -> L15
        r104.close();     // Catch: IOException -> L15
    L39:
        if (r101 == null) goto L66;
        gg r106 = (gg) GsonProtectorUtils.fromJson(GsonHelper.get(), new String(r101), gg.class);
        return;
    L66:
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L39
    L19:
        IOException e100 = e;
        char[] r107 = r101;
        r102 = r105;
        char[] r108 = r107;
    L29:
        e100.printStackTrace();     // Catch: Throwable -> L21
        if (r102 != null) goto L53;
    L34:
        if (r104 == null) goto L38;
        r104.close();     // Catch: IOException -> L32
    L32:
        e = move-exception;
        e.printStackTrace();
    L38:
        r101 = r108;
        goto L39
    L53:
        r102.close();     // Catch: IOException -> L32
    L17:
        Throwable th10 = th;
    L42:
        Throwable r109 = th10;
        r100 = r105;
        th = r109;
    L43:
        if (r100 != null) goto L59;
    L47:
        if (r104 == null) goto L67;
        r104.close();     // Catch: IOException -> L45
        throw th;
    L45:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L67:
        throw th;
    L59:
        r100.close();     // Catch: IOException -> L45
    L23:
        e = move-exception;
        e100 = e;
        r108 = null;
    L21:
        th = move-exception;
        InputStreamReader r110 = r102;
        th10 = th;
        r105 = r110;
        goto L42
    L27:
        e = move-exception;
        e100 = e;
        r108 = null;
        r104 = null;
    L25:
        th = th;
        r104 = null;
        goto L43
    L69:
        return;
    }

    public a5() {
    }
}
