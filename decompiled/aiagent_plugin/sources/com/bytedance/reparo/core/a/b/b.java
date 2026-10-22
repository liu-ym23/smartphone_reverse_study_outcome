package com.bytedance.reparo.core.a.b;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: FileUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static void a(File r3) {
        File r0 = r3.getParentFile();
        if (r0 == null) goto L9;
        if (r0.exists() == true) goto L10;
        r0.mkdirs();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("it's parent file is null. " + r3.getAbsolutePath());
    }

    public static boolean b(File r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.exists() == false) goto L6;
        return true;
    }

    public static File a(InputStream r5, File r6) {
        if (r6.exists() == false) goto L5;
        r6.delete();
    L5:
        c(r6);
        BufferedInputStream r0 = null;
        BufferedInputStream r1 = new BufferedInputStream(r5);     // Catch: Throwable -> L24
        FileOutputStream r7 = new FileOutputStream(r6);     // Catch: Throwable -> L21
        BufferedOutputStream r2 = new BufferedOutputStream(r7, 4096);     // Catch: Throwable -> L19
        byte[] r3 = new byte[1024];     // Catch: Throwable -> L17
    L11:
        int r4 = r1.read(r3);     // Catch: Throwable -> L17
        if (r4 == (-1)) goto L14;
        r2.write(r3, 0, r4);     // Catch: Throwable -> L17
        goto L11
    L14:
        r2.flush();     // Catch: Throwable -> L17
        a(r1);
        a(r7);
        a(r2);
        return r6;
    L17:
        th = th;
    L23:
        r0 = r1;
    L26:
        a(r0);
        a(r7);
        a(r2);
        throw th;
    L19:
        th = th;
        r2 = null;
    L21:
        th = th;
        r7 = null;
        r2 = null;
    L24:
        th = th;
        r7 = null;
        r2 = null;
        goto L26
    }

    public static void a(File r2, File r3) {
        if (r2 == null) goto L18;
        if (r3 != null) goto L6;
        return;
    L6:
        if (TextUtils.equals(r2.getAbsolutePath(), r3.getAbsolutePath()) == false) goto L8;
        return;
    L8:
        FileInputStream r0 = null;
        FileInputStream r1 = new FileInputStream(r2);     // Catch: Throwable -> L15
        a(r1, r3);     // Catch: Throwable -> L13
        a(r1);
        return;
    L13:
        th = th;
        r0 = r1;
    L16:
        a(r0);
        throw th;
    L15:
        th = th;
        goto L16
    }

    public static void delete(File r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.exists() == true) goto L7;
        return;
    L7:
        if (r4.isFile() == false) goto L10;
        r4.delete();
        return;
    L10:
        if (r4.isDirectory() == false) goto L23;
        File[] r0 = r4.listFiles();
        if (r0 != null) goto L14;
    L18:
        r4.delete();
        return;
    L14:
        if (r0.length <= 0) goto L18;
        int r1 = r0.length;
        int r2 = 0;
    L16:
        if (r2 >= r1) goto L18;
        delete(r0[r2]);
        r2 = r2 + 1;
        goto L16
    }

    public static void c(File r1) {
        if (r1.exists() == false) goto L5;
        return;
    L5:
        a(r1);
        r1.createNewFile();
    }

    public static boolean d(File r2) {
        if (r2 != null) goto L6;
        return true;
    L6:
        if (r2.isFile() == true) goto L8;
        File[] r3 = r2.listFiles();
        if (r3 != null) goto L12;
        return true;
    L12:
        if (r3.length == 0) goto L17;
        return false;
    L17:
        return true;
    L8:
        return !b(r2);
    }

    public static long e(File r2) {
        if (b(r2) == true) goto L7;
        return 0;
    L7:
        return r2.length();
    }

    public static void a(Closeable r2) {
        Closeable r3 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L11;
        r3.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static boolean b(File r0, File r1) {
        if (r0 != r1) goto L5;
        return true;
    L5:
        if (r0 == null) goto L10;
        if (r1 != null) goto L9;
        return false;
    L9:
        return TextUtils.equals(r0.getAbsolutePath(), r1.getAbsolutePath());
    L10:
        return false;
    }

    public static void a(File r2, String r3, boolean r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        r2.getParentFile().mkdirs();
        FileOutputStream r0 = null;
        FileOutputStream r1 = new FileOutputStream(r2, r4);     // Catch: Throwable -> L12
        r1.write(r3.getBytes());     // Catch: Throwable -> L10
        r1.flush();     // Catch: Throwable -> L10
        c.a(r1);
        return;
    L10:
        th = th;
        r0 = r1;
    L13:
        c.a(r0);
        throw th;
    L12:
        th = th;
        goto L13
    }

    public static String f(File r1) {
        return new String(g(r1));
    }

    public static byte[] g(File r5) {
        FileInputStream r0 = new FileInputStream(r5);     // Catch: IOException -> L29
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();     // Catch: Throwable -> L21
        byte[] r2 = new byte[4096];     // Catch: Throwable -> L13
    L6:
        int r3 = r0.read(r2);     // Catch: Throwable -> L13
        if (r3 == (-1)) goto L9;
        r1.write(r2, 0, r3);     // Catch: Throwable -> L13
        goto L6
    L9:
        byte[] r4 = r1.toByteArray();     // Catch: Throwable -> L13
        r1.close();     // Catch: Throwable -> L21
        r0.close();     // Catch: IOException -> L29
        return r4;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L18
    L20:
        throw th;     // Catch: Throwable -> L21
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L26
    L28:
        throw th;     // Catch: IOException -> L29
    L26:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L29
    L29:
        e = move-exception;
        throw new IllegalStateException("Failed to read file " + r5, e);
    }

    public static List<String> h(File r3) {
        BufferedReader r0 = new BufferedReader(new FileReader(r3));     // Catch: Throwable -> L20
        ArrayList r4 = new ArrayList();     // Catch: Throwable -> L12
    L4:
        String r1 = r0.readLine();     // Catch: Throwable -> L12
        if (r1 == null) goto L10;
        if (TextUtils.isEmpty(r1) == true) goto L4;
        r4.add(r1);     // Catch: Throwable -> L12
    L10:
        r0.close();     // Catch: Throwable -> L20
        return r4;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L17
    L19:
        throw th;     // Catch: Throwable -> L20
    L17:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L20
    L20:
        return null;
    }
}
