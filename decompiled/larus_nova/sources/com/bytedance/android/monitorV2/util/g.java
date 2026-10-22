package com.bytedance.android.monitorV2.util;

import android.content.Context;
import android.os.Environment;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes12.dex */
public final class g {
    public static void delete(File r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.exists() == false) goto L8;
        r100.delete();
        return;
    }

    public static File a(Context r100, String r101) {
        if (r100 == null) goto L22;
        String r102 = Environment.getExternalStorageState();
        boolean r103 = false;
        if ("mounted".equals(r102) == false) goto L6;
    L9:
        boolean r104 = true;
    L10:
        if (r104 == false) goto L26;
        r103 = "mounted".equals(Environment.getExternalStorageState());     // Catch: Exception -> L13
    L14:
        if (r103 == false) goto L27;
        File r105 = r100.getExternalFilesDir(r101);
        if (r105 != null) goto L19;
    L21:
        return r105;
    L19:
        if (r105.exists() == true) goto L21;
        r105.mkdirs();
        goto L21
    L27:
        return null;
    L26:
        return null;
    L6:
        if ("mounted_ro".equals(r102) == true) goto L9;
        r104 = false;
        goto L10
    L22:
        return null;
    }

    public static synchronized void b(String r100, String r101) {
        monitor-enter(g.class);
        if (r100 != null) goto L7;
        monitor-exit(g.class);
        return;
    L7:
        if (r101 != null) goto L65;
        monitor-exit(g.class);
        return;
    L65:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);     // Catch: Throwable -> L53
        PolarisFileWriterWrapper r103 = null;
    L27:
        th = th;
    L41:
        if (r103 != null) goto L63;
    L46:
        throw th;     // Catch: Throwable -> L53
    L63:
        r103.close();     // Catch: IOException -> L44 Throwable -> L53
    L44:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L53
        goto L46
    L13:
        if (r102.exists() == true) goto L32;
        File r104 = r102.getParentFile();     // Catch: Throwable -> L27 IOException -> L31
        if (r104 != null) goto L17;
    L21:
        boolean r105 = true;
    L22:
        if (r105 == false) goto L32;
    L29:
        e = move-exception;
        f.b(e);     // Catch: Throwable -> L27 IOException -> L31
        goto L32
    L24:
        if (r102.exists() == true) goto L32;
        r102.createNewFile();     // Catch: Throwable -> L27 IOException -> L29
        goto L32
    L17:
        if (r104.exists() == true) goto L21;
        r105 = r104.mkdirs();     // Catch: Throwable -> L27 IOException -> L31
    L32:
        PolarisFileWriterWrapper r106 = new PolarisFileWriterWrapper(r102, true);     // Catch: Throwable -> L27 IOException -> L31
        goto L47
    L66:
        r106.write(r101);     // Catch: Throwable -> L38 IOException -> L40
        r106.flush();     // Catch: Throwable -> L38 IOException -> L40
        r106.close();     // Catch: IOException -> L36 Throwable -> L53
    L60:
    L51:
        monitor-exit(g.class);
        return;
    L40:
        r103 = r106;
    L38:
        th = move-exception;
        th = th;
        r103 = r106;
    L47:
        if (r103 == null) goto L51;
        r103.close();     // Catch: IOException -> L36 Throwable -> L53
    L36:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        throw th;
    }
}
