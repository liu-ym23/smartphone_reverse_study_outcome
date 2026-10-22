package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes28.dex */
public final class i6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f27441a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f27442b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f27443c = null;

    static {
        f27441a = x5.b("SYmFja3Vwcw");
        f27442b = x5.b("SLmFkaXU");
        f27443c = x5.b("JIw");
    }

    private static void a(Closeable r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized void a(Context r100, String r101, String r102) {
        monitor-enter(i6.class);
        FileLock r103 = null;
        File r104 = r100.getExternalCacheDir();     // Catch: Throwable -> L11 Exception -> L53
        if (r104 != null) goto L8;
        r104 = r100.getCacheDir();     // Catch: Throwable -> L11 Exception -> L53
    L8:
        if (r104 == null) goto L13;
        String r105 = r104.getAbsolutePath();     // Catch: Throwable -> L11 Exception -> L53
    L15:
        if (TextUtils.isEmpty(r105) == false) goto L18;
        monitor-exit(i6.class);
        return;
    L18:
        String r106 = r101 + f27443c + r102;     // Catch: Throwable -> L11
        PolarisFileWrapper r107 = new PolarisFileWrapper(r105 + File.separator + f27441a);     // Catch: Throwable -> L11
        PolarisFileWrapper r108 = new PolarisFileWrapper(r107, f27442b);     // Catch: Throwable -> L11
    L38:
        FileChannel r109 = 0;
        RandomAccessFile r110 = null;
    L39:
        if (r103 != null) goto L54;
    L43:
        if (r109 != 0) goto L64;
    L45:
        a(r110);     // Catch: Throwable -> L11
        monitor-exit(i6.class);
        return;
    L64:
        r109.close();     // Catch: Throwable -> L11 IOException -> L52
        goto L45
    L54:
        r103.release();     // Catch: Throwable -> L11 IOException -> L42
        goto L43
    L20:
        if (r107.exists() == true) goto L22;
    L23:
        r107.mkdirs();     // Catch: Throwable -> L38
    L24:
        r108.createNewFile();     // Catch: Throwable -> L38
        r110 = new RandomAccessFile(r108, "rws");     // Catch: Throwable -> L38
        FileChannel r111 = r110.getChannel();     // Catch: Throwable -> L36
        r103 = r111.tryLock();     // Catch: Throwable -> L35
        if (r103 == null) goto L29;
        r111.write(ByteBuffer.wrap(r106.getBytes("UTF-8")));     // Catch: Throwable -> L35
    L29:
        if (r103 != null) goto L66;
    L62:
        r111.close();     // Catch: Throwable -> L11 IOException -> L51
    L32:
        a(r110);     // Catch: Throwable -> L11
        monitor-exit(i6.class);
        return;
    L66:
        r103.release();     // Catch: Throwable -> L11 IOException -> L50
    L35:
        FileLock r112 = r103;
        r103 = r111;
        FileLock r113 = r112;
    L37:
        FileLock r114 = r103;
        r103 = r113;
        r109 = r114;
    L36:
        r113 = null;
        goto L37
    L22:
        if (r107.isDirectory() == false) goto L24;
    L11:
        th = move-exception;
        throw th;
    L13:
        r105 = null;
        goto L15
    }
}
