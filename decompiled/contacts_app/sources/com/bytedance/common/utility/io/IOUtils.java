package com.bytedance.common.utility.io;

import android.os.StatFs;
import android.text.TextUtils;
import com.bytedance.common.utility.reflect.JavaCalls;
import com.bytedance.librarian.LibrarianImpl;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes2.dex */
public final class IOUtils {
    private IOUtils() {
    }

    public static void deleteFile(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return;
    L5:
        File r0 = new File(r1);
        if (r0.exists() == true) goto L8;
        return;
    L8:
        if (r0.isFile() == false) goto L13;
        r0.delete();
        return;
    }

    public static boolean exists(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return false;
    L7:
        return new File(r1).exists();
    }

    public static boolean mkdir(String r1) {
        return new File(r1).mkdirs();
    }

    public static boolean copyFile(File r4, File r5) {
        if (r4.exists() == true) goto L5;
    L22:
        return false;
    L5:
        if (r4.isFile() == false) goto L22;
        if (r5.isDirectory() == false) goto L10;
        return false;
    L10:
        if (r5.exists() == false) goto L23;
        r5.delete();
    L23:
        byte[] r0 = new byte[2048];     // Catch: IOException -> L20
        BufferedInputStream r2 = new BufferedInputStream(new FileInputStream(r4));     // Catch: IOException -> L20
        BufferedOutputStream r6 = new BufferedOutputStream(new FileOutputStream(r5));     // Catch: IOException -> L20
    L14:
        int r7 = r2.read(r0);     // Catch: IOException -> L20
        if (r7 == (-1)) goto L16;
        r6.write(r0, 0, r7);     // Catch: IOException -> L20
        goto L14
    L16:
        r2.close();     // Catch: IOException -> L20
        r6.flush();     // Catch: IOException -> L20
        r6.close();     // Catch: IOException -> L20
        return true;
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    }

    public static boolean copyFile(String r1, String r2) {
        return copyFile(new File(r1), new File(r2));
    }

    public static String readFileFirstLine(String r3) {
        BufferedReader r0 = null;
        BufferedReader r1 = new BufferedReader(new FileReader(r3));     // Catch: Throwable -> L13 Exception -> L28
        goto L16
    L37:
        String r4 = r1.readLine();     // Catch: Throwable -> L10 Exception -> L12
        r1.close();     // Catch: Throwable -> L10 Exception -> L12
        r1.close();     // Catch: IOException -> L7
    L9:
        return r4;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L12:
        r0 = r1;
    L10:
        th = th;
        r0 = r1;
    L22:
        if (r0 != null) goto L31;
    L27:
        throw th;
    L31:
        r0.close();     // Catch: IOException -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
    L13:
        th = th;
    L16:
        if (r0 != null) goto L29;
    L21:
        return "";
    L29:
        r0.close();     // Catch: IOException -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L21
    }

    public static void deletePath(String r7) {
        File r0 = new File(r7);
        if (r0.exists() == true) goto L6;
        return;
    L6:
        if (r0.isFile() == false) goto L9;
        r0.delete();
        return;
    L9:
        String[] r1 = r0.list();
        if (r1 != null) goto L12;
        return;
    L12:
        int r2 = r1.length;
        int r3 = 0;
    L13:
        if (r3 >= r2) goto L28;
        String r4 = r1[r3];
        if (r4 == null) goto L27;
        if (r7.endsWith(File.separator) == false) goto L20;
        String r5 = r7 + r4;
    L21:
        File r6 = new File(r5);
        if (r6.isFile() == false) goto L25;
        r6.delete();
    L25:
        if (r6.isDirectory() == false) goto L27;
        deletePath(r5);
        goto L27
    L20:
        r5 = r7 + File.separator + r4;
    L27:
        r3 = r3 + 1;
        goto L13
    L28:
        r0.delete();
    }

    public static void clearPath(String r6) {
        File r0 = new File(r6);
        if (r0.exists() == true) goto L5;
        return;
    L5:
        if (r0.isDirectory() == false) goto L24;
        String[] r1 = r0.list();
        int r2 = r1.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L25;
        String r4 = r1[r3];
        if (r6.endsWith(File.separator) == false) goto L12;
        String r5 = r6 + r4;
    L13:
        File r7 = new File(r5);
        if (r7.isFile() == false) goto L17;
        r7.delete();
    L17:
        if (r7.isDirectory() == false) goto L19;
        deletePath(r5);
    L19:
        r3 = r3 + 1;
        goto L8
    L12:
        r5 = r6 + File.separator + r4;
        goto L13
    L25:
        return;
    }

    public static long getFileSize(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return 0;
    L5:
        File r0 = new File(r8);
        if (r0.exists() == true) goto L8;
        return 0;
    L8:
        long r3 = r0.length();
        if (r0.isDirectory() == false) goto L23;
        File[] r9 = r0.listFiles();
        if (r9 == null) goto L23;
        int r1 = r9.length;
        int r5 = 0;
    L13:
        if (r5 >= r1) goto L23;
        r3 = r3 + getFileSize(r9[r5].getAbsolutePath());
        r5 = r5 + 1;
        goto L13
    L17:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L20:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L23:
        return r3;
    }

    public static String getFileName(String r3) {
        if (r3.endsWith(LibrarianImpl.Constants.SEPARATOR) == false) goto L5;
        r3 = r3.substring(0, r3.length() - 1);
    L5:
        int r0 = r3.lastIndexOf(LibrarianImpl.Constants.SEPARATOR);
        if (r0 > 0) goto L8;
        return r3;
    L8:
        if (r0 < (r3.length() - 1)) goto L10;
        return r3;
    L10:
        return r3.substring(r0 + 1);
    }

    public static String getParentFilePath(String r3) {
        if (r3.endsWith(LibrarianImpl.Constants.SEPARATOR) == false) goto L5;
        r3 = r3.substring(0, r3.length() - 1);
    L5:
        int r0 = r3.lastIndexOf(LibrarianImpl.Constants.SEPARATOR);
        if (r0 >= 0) goto L8;
        return null;
    L8:
        return r3.substring(0, r0);
    }

    public static String getFileNameWithoutExtension(String r2) {
        String r3 = getFileName(r2);
        if (r3 != null) goto L5;
        return r3;
    L5:
        if (r3.length() <= 0) goto L11;
        int r0 = r3.lastIndexOf(46);
        if (r0 > 0) goto L9;
        return r3;
    L9:
        return r3.substring(0, r0);
    L11:
        return r3;
    }

    public static String getFileExtension(String r2) {
        int r0 = r2.lastIndexOf(LibrarianImpl.Constants.DOT);
        if (r0 >= 0) goto L5;
        return "";
    L5:
        if (r0 < (r2.length() - 1)) goto L7;
        return "";
    L7:
        return r2.substring(r0 + 1).toUpperCase(Locale.getDefault());
    }

    public static boolean renameFile(String r1, String r2) {
        File r0 = new File(r1);
        File r3 = new File(r2);
        if (r0.exists() == true) goto L7;
        return false;
    L7:
        return r0.renameTo(r3);
    }

    public static long getAvailableBytes(String r5) {
    L9:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L3:
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return 0;
    L5:
        if (new File(r5).exists() == false) goto L16;
        StatFs r0 = new StatFs(r5);     // Catch: Exception -> L9
        return ((long) r0.getBlockSize()) * r0.getAvailableBlocks();
    L16:
        return 0;
    }

    public static long getAllBytes(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L15;
        return 0;
    L15:
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        return 0;
    L6:
        if (TextUtils.isEmpty(r5) == true) goto L14;
        if (new File(r5).exists() == false) goto L14;
        StatFs r0 = new StatFs(r5);     // Catch: Exception -> L12
        return ((long) r0.getBlockSize()) * r0.getBlockCount();
    }

    public static boolean canWrite(File r3) {
        if (r3 != null) goto L4;
        return false;
    L4:
        if (r3.exists() == false) goto L13;
        File r1 = new File(r3, LibrarianImpl.Constants.DOT + System.currentTimeMillis());
        boolean r4 = r1.mkdir();
        if (r4 == true) goto L9;
        return r4;
    L9:
        return r1.delete();
    L13:
        return false;
    }

    public static void setPermissions(String r2, int r3) {
        JavaCalls.callStaticMethod("android.os.FileUtils", r2, new Object[]{Integer.valueOf(r3), -1, -1});
    }

    public static void write(String r3, String r4, boolean r5) {
        FileWriter r0 = null;
        File r1 = new File(r3);     // Catch: Throwable -> L14 IOException -> L19
        if (r1.exists() == true) goto L6;
        r1.getParentFile().mkdirs();     // Catch: Throwable -> L14 IOException -> L19
        r1.createNewFile();     // Catch: Throwable -> L14 IOException -> L19
    L6:
        FileWriter r2 = new FileWriter(r3, r5);     // Catch: Throwable -> L14 IOException -> L19
        r2.write(r4);     // Catch: Throwable -> L10 IOException -> L12
        r2.close();     // Catch: Exception -> L28
    L32:
    L35:
        return;
    L12:
        e = e;
        r0 = r2;
    L20:
        e.printStackTrace();     // Catch: Throwable -> L24
        if (r0 == null) goto L35;
    L17:
        r0.close();     // Catch: Exception -> L28
    L10:
        th = th;
        r0 = r2;
    L15:
        th.printStackTrace();     // Catch: Throwable -> L24
        if (r0 == null) goto L35;
    L19:
        e = e;
    L14:
        th = th;
    L41:
        return;
    L24:
        th = move-exception;
        if (r0 != null) goto L30;
    L27:
        throw th;
    L30:
        r0.close();     // Catch: Exception -> L29
        goto L27
    }

    public static void close(Closeable r0) {
        if (r0 != null) goto L7;
        return;
    L7:
        r0.close();     // Catch: IOException -> L6
        return;
    }

    public static void close(ZipFile r0) {
        if (r0 != null) goto L7;
        return;
    L7:
        r0.close();     // Catch: IOException -> L6
        return;
    }
}
