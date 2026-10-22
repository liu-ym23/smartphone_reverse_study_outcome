package com.monitor.cloudmessage.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.librarian.LibrarianImpl;
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

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f10480a = "b";

    static {
    }

    public static void a(File r10, ZipOutputStream r11, String r12) {
        if (r10.isDirectory() == false) goto L6;
        c(r10, r11, r12 + r10.getName() + File.separator);
        return;
    L6:
        if (w0.c.B() == false) goto L8;
        s1.c.b("cloudmessage", new String[]{"压缩：" + r12 + r10.getName()});
    L8:
        d(r10, r11, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v9 */
    public static void b(String r10, String... r11) {
        File r12 = new File(r10);
        FileOutputStream r13 = new FileOutputStream(r12);     // Catch: Throwable -> L29 Exception -> L31
        CheckedOutputStream r14 = new CheckedOutputStream(r13, new CRC32());     // Catch: Throwable -> L25 Exception -> L27
    L43:
        ZipOutputStream r15 = new ZipOutputStream(r14);     // Catch: Throwable -> L19 Exception -> L22
        int r16 = r11.length;     // Catch: Throwable -> L11 Exception -> L13
        int r17 = 0;
    L7:
        if (r17 >= r16) goto L17;
        String r18 = r11[r17];     // Catch: Throwable -> L11 Exception -> L13
        File r19 = new File(r18);     // Catch: Throwable -> L11 Exception -> L13
        if (r19.exists() == false) goto L16;
        a(r19, r15, "");     // Catch: Throwable -> L11 Exception -> L13
        r17 = r17 + 1;     // Catch: Throwable -> L11 Exception -> L13
        goto L7
    L16:
        throw new RuntimeException(r18 + "不存在！");     // Catch: Throwable -> L11 Exception -> L13
    L17:
        r3.d.a(r15);
        r3.d.a(r14);
        r3.d.a(r13);
        return;
    L13:
        Exception e10 = e;
    L34:
        throw new RuntimeException(e10);     // Catch: Throwable -> L11
    L22:
        e = e;
    L24:
        e10 = e;
    L19:
        th = th;
        Closeable r20 = null;
        CheckedOutputStream r21 = r14;
    L21:
        th = th;
        ?? r22 = r21;
    L35:
        r3.d.a(r20);
        r3.d.a(r22);
        r3.d.a(r13);
        throw th;
    L27:
        e = e;
    L25:
        th = th;
        r21 = null;
        r20 = null;
        goto L21
    L11:
        th = th;
        r22 = r12;
    L31:
        e = e;
    L29:
        th = th;
        r21 = null;
        r13 = null;
        r20 = null;
        goto L21
    }

    public static void c(File r10, ZipOutputStream r11, String r12) {
        if (r10.exists() == true) goto L5;
        return;
    L5:
        File[] r13 = r10.listFiles();
        int r14 = 0;
    L7:
        if (r14 >= r13.length) goto L9;
        a(r13[r14], r11, r12);
        r14 = r14 + 1;
        goto L7
    }

    public static void d(File r10, ZipOutputStream r11, String r12) {
        if (r10.exists() == true) goto L5;
        return;
    L5:
        InputStream r13 = null;
        InputStream r14 = new FileInputStream(r10);     // Catch: Throwable -> L23 Exception -> L25
        BufferedInputStream r15 = new BufferedInputStream(r14);     // Catch: Throwable -> L19 Exception -> L21
        r11.putNextEntry(new ZipEntry(r12 + r10.getName()));     // Catch: Throwable -> L13 Exception -> L15
        byte[] r16 = new byte[8192];     // Catch: Throwable -> L13 Exception -> L15
    L9:
        int r17 = r15.read(r16, 0, 8192);     // Catch: Throwable -> L13 Exception -> L15
        if (r17 == (-1)) goto L17;
        r11.write(r16, 0, r17);     // Catch: Throwable -> L13 Exception -> L15
    L17:
        r3.d.a(r15);
        r3.d.a(r14);
        return;
    L15:
        e = e;
    L16:
        r13 = r14;
    L33:
    L29:
        th = th;
        r14 = r13;
    L14:
        r13 = r15;
    L31:
        r3.d.a(r13);
        r3.d.a(r14);
        throw th;
    L28:
        throw new RuntimeException(e);     // Catch: Throwable -> L29
    L13:
        th = th;
        goto L14
    L21:
        e = e;
        r15 = null;
    L19:
        th = th;
        goto L31
    L25:
        e = e;
        r15 = null;
    L23:
        th = th;
        r14 = null;
        goto L31
    }

    public static boolean e(String r10, String r11, String r12) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L28:
        return false;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L28;
        if (TextUtils.isEmpty(r12) == true) goto L28;
        FileInputStream r13 = null;
        FileInputStream r14 = new FileInputStream(r10);     // Catch: Throwable -> L18 Exception -> L20
        boolean r15 = l(r14, r11, r12);     // Catch: Throwable -> L14 Exception -> L16
        r14.close();     // Catch: Exception -> L29
    L13:
        return r15;
    L16:
        e = e;
        r13 = r14;
    L21:
        e.printStackTrace();     // Catch: Throwable -> L18
        if (r13 != null) goto L37;
    L24:
        return false;
    L37:
        r13.close();     // Catch: Exception -> L31
    L14:
        th = th;
        r13 = r14;
    L25:
        if (r13 != null) goto L34;
    L27:
        throw th;
    L34:
        r13.close();     // Catch: Exception -> L30
    L20:
        e = e;
    L18:
        th = th;
        goto L25
    }

    public static void f(File r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.exists() == true) goto L7;
        return;
    L7:
        if (r10.isDirectory() == false) goto L17;
        File[] r11 = r10.listFiles();
        int r12 = r11.length;
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L17;
        File r14 = r11[r13];
        if (r14.isFile() == false) goto L14;
        r14.delete();
    L16:
        r13 = r13 + 1;
        goto L9
    L14:
        if (r10.isDirectory() == false) goto L16;
        f(r14);
    L17:
        r10.delete();
    }

    public static void g(File r10) {
        if (r10.exists() == false) goto L5;
        k(r10.getAbsolutePath());
    L5:
        r10.mkdirs();
    }

    public static File h(Context r10) {
        File r11 = r10.getExternalFilesDir("cloudMessage");
        if (r11 != null) goto L6;
        r11 = new File(r10.getFilesDir(), "cloudMessage");
    L6:
        if (r11.exists() == true) goto L8;
        r11.mkdir();
    L8:
        return r11;
    }

    public static String i(String r10, String r11) {
        Context r12 = v9.a.k().i();
        r10.hashCode();
        byte r13 = -1;
        switch(r10.hashCode()) {
            case -1481211727: goto L26;
            case -1427366653: goto L22;
            case -1301710629: goto L18;
            case -540898700: goto L14;
            case 70125656: goto L10;
            case 1506669642: goto L6;
            default: goto L29;
        };
    L29:
        switch(r13) {
            case 0: goto L42;
            case 1: goto L40;
            case 2: goto L38;
            case 3: goto L36;
            case 4: goto L34;
            case 5: goto L32;
            default: goto L30;
        };
    L30:
        return null;
    L32:
        return new File(r12.getFilesDir(), r11).getAbsolutePath();
    L34:
        return new File(r12.getExternalFilesDir(null).getParentFile(), r11).getAbsolutePath();
    L36:
        return new File(r12.getCacheDir(), r11).getAbsolutePath();
    L38:
        return new File(r12.getExternalCacheDir(), r11).getAbsolutePath();
    L40:
        return new File(r12.getExternalFilesDir(null), r11).getAbsolutePath();
    L42:
        return new File(r12.getFilesDir().getParentFile(), r11).getAbsolutePath();
    L6:
        if (r10.equals("data_package_file") == false) goto L29;
        r13 = 5;
        goto L29
    L10:
        if (r10.equals("sd_package") == false) goto L29;
        r13 = 4;
        goto L29
    L14:
        if (r10.equals("data_package_cache") == false) goto L29;
        r13 = 3;
        goto L29
    L18:
        if (r10.equals("sd_package_cache") == false) goto L29;
        r13 = 2;
        goto L29
    L22:
        if (r10.equals("sd_package_file") == false) goto L29;
        r13 = 1;
        goto L29
    L26:
        if (r10.equals("data_package") == false) goto L29;
        r13 = 0;
        goto L29
    }

    public static File j(String r10, String r11) {
        Context r12 = v9.a.k().i();
        r10.hashCode();
        byte r13 = -1;
        switch(r10.hashCode()) {
            case -1481211727: goto L26;
            case -1427366653: goto L22;
            case -1301710629: goto L18;
            case -540898700: goto L14;
            case 70125656: goto L10;
            case 1506669642: goto L6;
            default: goto L29;
        };
    L29:
        switch(r13) {
            case 0: goto L42;
            case 1: goto L40;
            case 2: goto L38;
            case 3: goto L36;
            case 4: goto L34;
            case 5: goto L32;
            default: goto L30;
        };
    L30:
        return null;
    L32:
        return new File(r12.getFilesDir(), r11);
    L34:
        return new File(r12.getExternalFilesDir(null).getParentFile(), r11);
    L36:
        return new File(r12.getCacheDir(), r11);
    L38:
        return new File(r12.getExternalCacheDir(), r11);
    L40:
        return new File(r12.getExternalFilesDir(null), r11);
    L42:
        return new File(r12.getFilesDir().getParentFile(), r11);
    L6:
        if (r10.equals("data_package_file") == false) goto L29;
        r13 = 5;
        goto L29
    L10:
        if (r10.equals("sd_package") == false) goto L29;
        r13 = 4;
        goto L29
    L14:
        if (r10.equals("data_package_cache") == false) goto L29;
        r13 = 3;
        goto L29
    L18:
        if (r10.equals("sd_package_cache") == false) goto L29;
        r13 = 2;
        goto L29
    L22:
        if (r10.equals("sd_package_file") == false) goto L29;
        r13 = 1;
        goto L29
    L26:
        if (r10.equals("data_package") == false) goto L29;
        r13 = 0;
        goto L29
    }

    public static boolean k(String r10) {
        File r11 = new File(r10);
        if (r11.exists() == true) goto L5;
        return true;
    L5:
        if (r11.isDirectory() == false) goto L30;
        File[] r12 = r11.listFiles();
        int r13 = r12.length;
        boolean r14 = true;
        int r15 = 0;
    L7:
        if (r15 >= r13) goto L20;
        if (r12[r15].isDirectory() == false) goto L15;
        if (r14 == true) goto L12;
    L14:
        r14 = false;
    L19:
        r15 = r15 + 1;
        goto L7
    L12:
        if (k(r12[r15].getAbsolutePath()) == false) goto L14;
    L13:
        r14 = true;
        goto L19
    L15:
        if (r14 == false) goto L14;
        if (r12[r15].delete() == false) goto L14;
    L20:
        if (r14 == false) goto L25;
        if (r11.delete() == false) goto L25;
        return true;
    L25:
        return false;
    L30:
        return true;
    }

    public static boolean l(InputStream r10, String r11, String r12) {
        if (r10 != null) goto L5;
        return false;
    L5:
        FileOutputStream r13 = null;
        File r14 = new File(r11);     // Catch: Throwable -> L12 Exception -> L14
        if (r14.exists() == false) goto L9;
    L16:
        FileOutputStream r15 = new FileOutputStream(new File(r14, r12));     // Catch: Throwable -> L12 Exception -> L14
        byte[] r16 = new byte[1024];     // Catch: Throwable -> L22 Exception -> L24
    L19:
        int r17 = r10.read(r16);     // Catch: Throwable -> L22 Exception -> L24
        if (r17 == (-1)) goto L26;
        r15.write(r16, 0, r17);     // Catch: Throwable -> L22 Exception -> L24
        goto L19
    L26:
        r15.flush();     // Catch: Throwable -> L22 Exception -> L24
        r15.close();     // Catch: Throwable -> L22 Exception -> L24
        r10.close();     // Catch: Throwable -> L12 Exception -> L14
        r10.close();     // Catch: Exception -> L41
        return true;
    L65:
        return true;
    L24:
        e = e;
        r13 = r15;
    L31:
        Log.d(f10480a, "save inputstream error: " + e);     // Catch: Throwable -> L12
        if (r13 != null) goto L56;
    L50:
        r10.close();     // Catch: Exception -> L45
    L35:
        return false;
    L56:
        r13.close();     // Catch: Exception -> L44
    L22:
        th = th;
        r13 = r15;
    L36:
        if (r13 == null) goto L59;
        r13.close();     // Catch: Exception -> L42
    L59:
        r10.close();     // Catch: Exception -> L43
        throw th;
    L64:
        throw th;
    L9:
        if (r14.mkdirs() == true) goto L16;
        r10.close();     // Catch: Exception -> L40
    L11:
        return false;
    L14:
        e = e;
    L12:
        th = th;
        goto L36
    }

    public static void m(String r10, File r11) {
        ZipOutputStream r12 = null;
        ZipOutputStream r13 = new ZipOutputStream(new FileOutputStream(r10));     // Catch: Throwable -> L9
        o(r13, r11, "");     // Catch: Throwable -> L7
        r3.d.a(r13);
        return;
    L7:
        th = th;
        r12 = r13;
    L10:
        r3.d.a(r12);
        throw th;
    L9:
        th = th;
        goto L10
    }

    public static void n(String r10, String r11) {
        m(r11, new File(r10));
    }

    public static void o(ZipOutputStream r10, File r11, String r12) {
        if (r11.isDirectory() == false) goto L12;
        File[] r13 = r11.listFiles();
        r10.putNextEntry(new ZipEntry(r12 + LibrarianImpl.Constants.SEPARATOR));
        if (r12.length() != 0) goto L7;
        String r14 = "";
    L8:
        int r15 = 0;
    L10:
        if (r15 >= r13.length) goto L32;
        o(r10, r13[r15], r14 + r13[r15].getName());
        r15 = r15 + 1;
        goto L10
    L32:
        return;
    L7:
        r14 = r12 + LibrarianImpl.Constants.SEPARATOR;
        goto L8
    L12:
        r10.putNextEntry(new ZipEntry(r12));
        FileInputStream r16 = null;
        FileInputStream r17 = new FileInputStream(r11);     // Catch: Throwable -> L22
    L25:
        int r18 = r17.read();     // Catch: Throwable -> L18
        if (r18 == (-1)) goto L20;
        r10.write(r18);     // Catch: Throwable -> L18
        goto L25
    L20:
        r3.d.a(r17);
        return;
    L18:
        th = th;
        r16 = r17;
    L23:
        r3.d.a(r16);
        throw th;
    L22:
        th = th;
        goto L23
    }
}
