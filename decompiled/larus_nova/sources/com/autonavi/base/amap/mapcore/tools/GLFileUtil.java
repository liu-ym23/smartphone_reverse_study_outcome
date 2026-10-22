package com.autonavi.base.amap.mapcore.tools;

import android.content.Context;
import com.amap.api.mapcore.util.p3;
import com.bytedance.keva.KevaImpl;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes39.dex */
public class GLFileUtil {
    public GLFileUtil() {
    }

    public static void closeQuietly(Closeable r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: Exception -> L5
        return;
    L9:
        return;
    }

    public static void deleteFile(File r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        File[] r101 = r100.listFiles();
        if (r100.isDirectory() == false) goto L10;
        if (r101 == null) goto L10;
        int r102 = r101.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L10;
        deleteFile(r101[r103]);
        r103 = r103 + 1;
    L10:
        r100.delete();
    }

    public static File getCacheDir(Context r100) {
        File r101 = r100.getCacheDir();
        if (r101 != null) goto L5;
        r101 = r100.getDir("cache", 0);
    L5:
        if (r101 != null) goto L8;
        r101 = new PolarisFileWrapper("/data/data/" + r100.getPackageName() + "/app_cache");
    L8:
        if (r101.exists() == true) goto L10;
        r101.mkdirs();
    L10:
        return r101;
    }

    public static File getFilesDir(Context r100) {
        File r101 = r100.getFilesDir();
        if (r101 != null) goto L5;
        r101 = r100.getDir(KevaImpl.PrivateConstants.FILES_DIR_NAME, 0);
    L5:
        if (r101 != null) goto L8;
        r101 = new PolarisFileWrapper("/data/data/" + r100.getPackageName() + "/app_files");
    L8:
        if (r101.exists() == true) goto L10;
        r101.mkdirs();
    L10:
        return r101;
    }

    public static byte[] readFileContents(String r100) {
        PolarisFileInputStreamWrapper r101 = null;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);     // Catch: Throwable -> L18 Exception -> L21
        if (r102.exists() == true) goto L7;
        closeQuietly(null);
        return null;
    L7:
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r102);     // Catch: Throwable -> L18 Exception -> L21
    L25:
        byte[] r104 = new byte[1024];     // Catch: Throwable -> L16 Exception -> L24
        ByteArrayOutputStream r105 = new ByteArrayOutputStream();     // Catch: Throwable -> L16 Exception -> L24
    L10:
        int r106 = r103.read(r104);     // Catch: Throwable -> L16 Exception -> L24
        if (r106 == (-1)) goto L13;
        r105.write(r104, 0, r106);     // Catch: Throwable -> L16 Exception -> L24
        goto L10
    L13:
        r105.close();     // Catch: Throwable -> L16 Exception -> L24
        byte[] r107 = r105.toByteArray();     // Catch: Throwable -> L16 Exception -> L24
        closeQuietly(r103);
        return r107;
    L16:
        th = move-exception;
        r101 = r103;
        th = th;
    L19:
        closeQuietly(r101);
        throw th;
    L22:
        closeQuietly(r103);
        return null;
    L21:
        r103 = null;
    L18:
        th = th;
        goto L19
    }

    public static void writeDatasToFile(String r100, byte[] r101) {
        ReentrantReadWriteLock.WriteLock r102 = new ReentrantReadWriteLock().writeLock();
        r102.lock();
        PolarisFileOutputStreamWrapper r103 = null;
        if (r101 != null) goto L30;
    L25:
        r102.unlock();
        closeQuietly(null);
        return;
    L30:
    L19:
        th = move-exception;
        Throwable th10 = th;
    L21:
        r102.unlock();
        closeQuietly(r103);
        throw th10;
    L5:
        if (r101.length == 0) goto L25;
        PolarisFileWrapper r104 = new PolarisFileWrapper(r100);     // Catch: Throwable -> L19 Exception -> L27
        File r105 = r104.getParentFile();     // Catch: Throwable -> L19 Exception -> L27
        if (r105.exists() == true) goto L11;
        r105.mkdirs();     // Catch: Throwable -> L19 Exception -> L27
    L11:
        if (r104.exists() == false) goto L13;
        r104.delete();     // Catch: Throwable -> L19 Exception -> L27
    L13:
        r104.createNewFile();     // Catch: Throwable -> L19 Exception -> L27
        PolarisFileOutputStreamWrapper r106 = new PolarisFileOutputStreamWrapper(r104);     // Catch: Throwable -> L19 Exception -> L27
        r106.write(r101);     // Catch: Throwable -> L16 Exception -> L18
        r106.flush();     // Catch: Throwable -> L16 Exception -> L18
        r102.unlock();
        closeQuietly(r106);
        return;
    L18:
        r103 = r106;
    L16:
        th10 = th;
        r103 = r106;
        goto L21
    L23:
        r102.unlock();
        closeQuietly(r103);
    }

    public static void copy(Context r100, String r101, File r102) throws Exception {
        r102.delete();
        InputStream r103 = p3.d(r100, r101);
        byte[] r104 = new byte[r103.available()];
        r103.read(r104);     // Catch: Throwable -> L11
        closeQuietly(r103);
        PolarisFileOutputStreamWrapper r105 = new PolarisFileOutputStreamWrapper(r102);
        r105.write(r104);     // Catch: Throwable -> L8
        closeQuietly(r105);
        return;
    L8:
        th = move-exception;
        closeQuietly(r105);
        throw th;
    L11:
        th = move-exception;
        closeQuietly(r103);
        throw th;
    }
}
