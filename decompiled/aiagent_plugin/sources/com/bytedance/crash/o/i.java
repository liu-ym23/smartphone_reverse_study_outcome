package com.bytedance.crash.o;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: FileSystemUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class i {
    public static File a(File r1, String r2) {
        File r0 = new File(r1, r2);
        b(r0);
        return r0;
    }

    public static void a(File r1) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.exists() == true) goto L11;
        r1.createNewFile();     // Catch: IOException -> L8
        return;
    L12:
        return;
    }

    public static File b(File r1) {
    L9:
        e = move-exception;
        e.printStackTrace();
    L11:
        return r1;
    L3:
        if (r1.exists() == true) goto L6;
        r1.mkdirs();     // Catch: Exception -> L9
    L12:
        goto L11
    L6:
        if (r1.isDirectory() == true) goto L12;
        r1.delete();     // Catch: Exception -> L9
        r1.mkdirs();     // Catch: Exception -> L9
        goto L12
    }

    public static File b(File r1, String r2) {
        File r0 = new File(r1, r2);
        if (r0.isDirectory() == false) goto L12;
        c(r0);
    L12:
    L9:
        e = move-exception;
        e.printStackTrace();
    L11:
        return r0;
    L6:
        if (r0.exists() == true) goto L11;
        r0.createNewFile();     // Catch: Exception -> L9
        goto L11
    }

    public static void c(File r1, String r2) {
        j.a(r1, r2, false);     // Catch: Exception -> L5
        return;
    }

    public static void a(File r0, String r1, String r2) {
        j.a(b(r0, r1), r2, false);     // Catch: Exception -> L5
        return;
    }

    public static void c(File r4) {
        if (r4.exists() == true) goto L5;
        return;
    L5:
        if (r4.isDirectory() == false) goto L14;
        File[] r0 = r4.listFiles();
        if (r0 == null) goto L14;
        int r1 = r0.length;
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L14;
        c(r0[r2]);
        r2 = r2 + 1;
    L14:
        j.a(r4);     // Catch: Throwable -> L13
        return;
    }

    public static String d(File r5) {
        if (r5.exists() == true) goto L5;
    L15:
        return null;
    L5:
        if (r5.isDirectory() == true) goto L15;
        int r0 = (int) r5.length();
        byte[] r2 = new byte[r0];
        FileInputStream r3 = new FileInputStream(r5);     // Catch: Throwable -> L12
        String r4 = new String(r2, 0, r3.read(r2, 0, r0));     // Catch: Throwable -> L17
        r3.close();     // Catch: IOException -> L16
    L11:
        return r4;
    L13:
        if (r3 == null) goto L15;
        r3.close();     // Catch: IOException -> L18
    L12:
        r3 = null;
        goto L13
    }

    public static void a(Closeable r2) {
        Closeable r3 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L9;
        r3.close();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static void a(ZipFile r0) {
        if (r0 != null) goto L8;
        r0.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public static void a(String r9, int r10) {
        t.a("android.os.FileUtils", "setPermissions", new Class[]{String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE}).invoke(null, new Object[]{r9, Integer.valueOf(r10), -1, -1});     // Catch: Throwable -> L4
        return;
    }
}
