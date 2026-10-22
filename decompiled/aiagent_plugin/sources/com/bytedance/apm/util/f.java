package com.bytedance.apm.util;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: compiled from: FileUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f4978a = "f";

    static {
    }

    public f() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    public static void a(String r7, String... r8) {
        ?? r0 = new File(r7);
        FileOutputStream r1 = new FileOutputStream(r0);     // Catch: Throwable -> L25 Exception -> L28
    L42:
        CheckedOutputStream r2 = new CheckedOutputStream(r1, new CRC32());     // Catch: Throwable -> L21 Exception -> L23
        ZipOutputStream r3 = new ZipOutputStream(r2);     // Catch: Throwable -> L17 Exception -> L19
        int r9 = r8.length;     // Catch: Exception -> L15 Throwable -> L33
        int r4 = 0;
    L7:
        if (r4 >= r9) goto L13;
        String r5 = r8[r4];     // Catch: Exception -> L15 Throwable -> L33
        File r6 = new File(r5);     // Catch: Exception -> L15 Throwable -> L33
        if (r6.exists() == false) goto L12;
        a(r6, r3, "");     // Catch: Exception -> L15 Throwable -> L33
        r4 = r4 + 1;     // Catch: Exception -> L15 Throwable -> L33
        goto L7
    L12:
        throw new RuntimeException(r5 + "not exist！");     // Catch: Exception -> L15 Throwable -> L33
    L13:
        com.bytedance.monitor.a.d.a(r3);
        com.bytedance.monitor.a.d.a(r2);
        com.bytedance.monitor.a.d.a(r1);
        return;
    L15:
        Exception e2 = e;
    L32:
        throw new RuntimeException(e2);     // Catch: Throwable -> L33
    L19:
        e = e;
    L30:
        e2 = e;
    L17:
        th = th;
        Closeable r10 = null;
        r0 = r2;
    L27:
        th = th;
    L34:
        com.bytedance.monitor.a.d.a(r10);
        com.bytedance.monitor.a.d.a(r0);
        com.bytedance.monitor.a.d.a(r1);
        throw th;
    L23:
        e = e;
    L21:
        th = th;
        r0 = 0;
        r10 = null;
    L33:
        th = th;
    L28:
        e = e;
    L25:
        th = th;
        r0 = 0;
        r1 = null;
        r10 = null;
        goto L27
    }

    private static void a(File r3, ZipOutputStream r4, String r5) {
        if (r3.isDirectory() == false) goto L5;
        b(r3, r4, r5 + r3.getName() + File.separator);
        return;
    L5:
        System.out.println("compress：" + r5 + r3.getName());
        c(r3, r4, r5);
    }

    private static void b(File r2, ZipOutputStream r3, String r4) {
        if (r2.exists() == true) goto L5;
        return;
    L5:
        File[] r5 = r2.listFiles();
        int r0 = 0;
    L7:
        if (r0 >= r5.length) goto L9;
        a(r5[r0], r3, r4);
        r0 = r0 + 1;
        goto L7
    }

    private static void c(File r5, ZipOutputStream r6, String r7) {
        if (r5.exists() == true) goto L5;
        return;
    L5:
        InputStream r0 = null;
        InputStream r1 = new FileInputStream(r5);     // Catch: Throwable -> L24 Exception -> L26
    L39:
        BufferedInputStream r2 = new BufferedInputStream(r1);     // Catch: Throwable -> L19 Exception -> L21
    L41:
        r6.putNextEntry(new ZipEntry(r7 + r5.getName()));     // Catch: Throwable -> L15 Exception -> L17
        byte[] r8 = new byte[8192];     // Catch: Throwable -> L15 Exception -> L17
    L9:
        int r3 = r2.read(r8, 0, 8192);     // Catch: Throwable -> L15 Exception -> L17
        if (r3 == (-1)) goto L13;
        r6.write(r8, 0, r3);     // Catch: Throwable -> L15 Exception -> L17
    L13:
        com.bytedance.monitor.a.d.a(r2);
        com.bytedance.monitor.a.d.a(r1);
        return;
    L17:
        e = e;
    L23:
        r0 = r1;
    L35:
    L30:
        th = th;
        r1 = r0;
    L32:
        r0 = r2;
    L33:
        com.bytedance.monitor.a.d.a(r0);
        com.bytedance.monitor.a.d.a(r1);
        throw th;
    L29:
        throw new RuntimeException(e);     // Catch: Throwable -> L30
    L15:
        th = th;
    L21:
        e = e;
        r2 = null;
    L19:
        th = th;
    L26:
        e = e;
        r2 = null;
    L24:
        th = th;
        r1 = null;
        goto L33
    }

    public static long a(File r7) {
        if (r7.exists() == true) goto L6;
        return -1;
    L6:
        if (r7.isFile() == true) goto L8;
        long r3 = 0;
        if (r7.isDirectory() == false) goto L15;
        File[] r8 = r7.listFiles();
        int r0 = r8.length;
        int r1 = 0;
    L12:
        if (r1 >= r0) goto L14;
        r3 = r3 + a(r8[r1]);
        r1 = r1 + 1;
        goto L12
    L14:
        return r3;
    L15:
        return -1;
    L8:
        return r7.length();
    }

    public static File a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        File r0 = null;
        if (r3 != null) goto L10;
        return null;
    L10:
        r0 = r3.getExternalFilesDir(null);     // Catch: Throwable -> L9
    L6:
        r0 = r0.getParentFile();     // Catch: Throwable -> L9
        if (r0.getAbsolutePath().contains("/Android") == true) goto L6;
    L8:
        return r0;
    }
}
