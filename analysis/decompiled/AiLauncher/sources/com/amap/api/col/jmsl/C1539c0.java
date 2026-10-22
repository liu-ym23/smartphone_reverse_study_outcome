package com.amap.api.col.jmsl;

import android.content.Context;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileLock;

/* renamed from: com.amap.api.col.jmsl.c0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1539c0 {

    /* renamed from: a, reason: collision with root package name */
    public static final String f16540a = C1604s2.m("SYmFja3Vwcw");

    /* renamed from: b, reason: collision with root package name */
    public static final String f16541b = C1604s2.m("SLmFkaXU");

    /* renamed from: c, reason: collision with root package name */
    public static final String f16542c = C1604s2.m("JIw");

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.nio.channels.FileChannel, java.nio.channels.spi.AbstractInterruptibleChannel] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.nio.channels.spi.AbstractInterruptibleChannel] */
    public static synchronized void a(Context context, String str, String str2) {
        ?? r42;
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        File externalCacheDir;
        FileLock fileLockTryLock = null;
        try {
            try {
                externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir == null) {
                    externalCacheDir = context.getCacheDir();
                }
            } catch (Exception unused) {
            }
            String absolutePath = externalCacheDir != null ? externalCacheDir.getAbsolutePath() : null;
            if (TextUtils.isEmpty(absolutePath)) {
                return;
            }
            String str3 = str + f16542c + str2;
            File file = new File(absolutePath + File.separator + f16540a);
            File file2 = new File(file, f16541b);
            try {
                if (!file.exists() || file.isDirectory()) {
                    file.mkdirs();
                }
                file2.createNewFile();
                randomAccessFile = new RandomAccessFile(file2, "rws");
                try {
                    ?? channel = randomAccessFile.getChannel();
                    try {
                        fileLockTryLock = channel.tryLock();
                        if (fileLockTryLock != null) {
                            channel.write(ByteBuffer.wrap(str3.getBytes("UTF-8")));
                        }
                        if (fileLockTryLock != null) {
                            try {
                                fileLockTryLock.release();
                            } catch (IOException unused2) {
                            }
                        }
                        try {
                            channel.close();
                        } catch (IOException unused3) {
                        }
                        b(randomAccessFile);
                    } catch (Throwable unused4) {
                        FileLock fileLock2 = fileLockTryLock;
                        fileLockTryLock = channel;
                        fileLock = fileLock2;
                        FileLock fileLock3 = fileLockTryLock;
                        fileLockTryLock = fileLock;
                        r42 = fileLock3;
                        if (fileLockTryLock != null) {
                            try {
                                fileLockTryLock.release();
                            } catch (IOException unused5) {
                            }
                        }
                        if (r42 != 0) {
                            try {
                                r42.close();
                            } catch (IOException unused6) {
                            }
                        }
                        b(randomAccessFile);
                    }
                } catch (Throwable unused7) {
                    fileLock = null;
                }
            } catch (Throwable unused8) {
                r42 = 0;
                randomAccessFile = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
