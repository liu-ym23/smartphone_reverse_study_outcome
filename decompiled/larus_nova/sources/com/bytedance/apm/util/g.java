package com.bytedance.apm.util;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.miui.easygo.constant.EasyGoConstant;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes6.dex */
public final class g {
    public g() {
    }

    static {
    }

    public static File c(Context r100) {
        File r101 = null;
        if (r100 != null) goto L10;
        return null;
    L10:
        r101 = r100.getExternalFilesDir(null);     // Catch: Throwable -> L9
    L6:
        r101 = r101.getParentFile();     // Catch: Throwable -> L9
        if (r101.getAbsolutePath().contains("/Android") == true) goto L6;
    L8:
        return r101;
    }

    public static String d(PolarisFileWrapper r100) {
        String[] r101 = r100.getName().split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        if (r101.length > 1) goto L7;
        return "";
    L7:
        return r101[r101.length - 2];
    }

    public static long e(File r100) {
        long r101 = -1;
        if (r100.exists() == true) goto L6;
        return -1;
    L6:
        if (r100.isFile() == false) goto L10;
        return r100.length();
    L10:
        if (r100.isDirectory() == false) goto L14;
        File[] r102 = r100.listFiles();
        int r103 = r102.length;
        r101 = 0;
        int r104 = 0;
    L12:
        if (r104 >= r103) goto L14;
        r101 = r101 + e(r102[r104]);
        r104 = r104 + 1;
    L14:
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.security.android.aopcheck.PolarisFileWrapper, java.io.File] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    public static void b(String r100, String... r101) {
        ?? r102 = new PolarisFileWrapper(r100);
        PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(r102);     // Catch: Throwable -> L25 Exception -> L28
        CheckedOutputStream r104 = new CheckedOutputStream(r103, new CRC32());     // Catch: Throwable -> L21 Exception -> L23
    L42:
        ZipOutputStream r105 = new ZipOutputStream(r104);     // Catch: Throwable -> L17 Exception -> L19
        int r106 = r101.length;     // Catch: Exception -> L15 Throwable -> L33
        int r107 = 0;
    L7:
        if (r107 >= r106) goto L13;
        String r108 = r101[r107];     // Catch: Exception -> L15 Throwable -> L33
        PolarisFileWrapper r109 = new PolarisFileWrapper(r108);     // Catch: Exception -> L15 Throwable -> L33
        if (r109.exists() == false) goto L12;
        a(r109, r105, "");     // Catch: Exception -> L15 Throwable -> L33
        r107 = r107 + 1;     // Catch: Exception -> L15 Throwable -> L33
        goto L7
    L12:
        throw new RuntimeException(r108 + "not exist！");     // Catch: Exception -> L15 Throwable -> L33
    L13:
        d27.d.a(r105);
        d27.d.a(r104);
        d27.d.a(r103);
        return;
    L15:
        Exception e100 = e;
    L32:
        throw new RuntimeException(e100);     // Catch: Throwable -> L33
    L19:
        e = e;
    L30:
        e100 = e;
    L17:
        th = th;
        Closeable r110 = null;
        r102 = r104;
    L27:
        th = th;
    L34:
        d27.d.a(r110);
        d27.d.a(r102);
        d27.d.a(r103);
        throw th;
    L23:
        e = e;
    L21:
        th = th;
        r102 = 0;
        r110 = null;
        goto L27
    L33:
        th = th;
    L28:
        e = e;
    L25:
        th = th;
        r102 = 0;
        r103 = null;
        r110 = null;
        goto L27
    }

    public static void a(File r100, ZipOutputStream r101, String r102) {
        int r103 = 0;
        if (r100.isDirectory() == false) goto L11;
        String r104 = r102 + r100.getName() + File.separator;
        if (r100.exists() == false) goto L53;
        File[] r105 = r100.listFiles();
    L9:
        if (r103 >= r105.length) goto L55;
        a(r105[r103], r101, r104);
        r103 = r103 + 1;
        goto L9
    L55:
        return;
    L53:
        return;
    L11:
        System.out.println("compress：" + r102 + r100.getName());
        if (r100.exists() == false) goto L54;
        InputStream r106 = null;
        InputStream r107 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L32 Exception -> L34
        BufferedInputStream r108 = new BufferedInputStream(r107);     // Catch: Throwable -> L28 Exception -> L30
        r101.putNextEntry(new ZipEntry(r102 + r100.getName()));     // Catch: Throwable -> L24 Exception -> L26
        byte[] r109 = new byte[8192];     // Catch: Throwable -> L24 Exception -> L26
    L18:
        int r110 = r108.read(r109, 0, 8192);     // Catch: Throwable -> L24 Exception -> L26
        if (r110 == (-1)) goto L22;
        r101.write(r109, 0, r110);     // Catch: Throwable -> L24 Exception -> L26
    L22:
        d27.d.a(r108);
        d27.d.a(r107);
        return;
    L26:
        e = e;
        r106 = r108;
    L31:
        InputStream r111 = r106;
        r106 = r107;
    L42:
    L38:
        th = th;
        r107 = r106;
        r106 = r111;
    L40:
        d27.d.a(r106);
        d27.d.a(r107);
        throw th;
    L37:
        throw new RuntimeException(e);     // Catch: Throwable -> L38
    L24:
        th = th;
        r106 = r108;
        goto L40
    L30:
        e = e;
    L28:
        th = th;
        goto L40
    L34:
        e = e;
        r111 = null;
    L32:
        th = th;
        r107 = null;
        goto L40
    }
}
