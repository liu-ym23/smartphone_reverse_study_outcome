package com.bytedance.reparo.core.g;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

/* JADX INFO: compiled from: FileLockHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements Closeable {
    private static final String TAG = "FileLockHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FileOutputStream f9214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FileLock f9215b;

    private c(File r8) {
        com.bytedance.reparo.core.a.b.b.c(r8);
        this.f9214a = new FileOutputStream(r8);
        FileLock r1 = null;
        Exception e2 = null;
        int r4 = 0;
    L4:
        if (r4 >= 3) goto L19;
        r4 = r4 + 1;
        r1 = this.f9214a.getChannel().lock();     // Catch: Exception -> L12
        if (r1 == null) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == true) goto L19;
    L26:
        Thread.sleep(10);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        com.bytedance.reparo.core.j.b(TAG, "getInfoLock Thread sleep exception", e);
        goto L4
    L9:
        r5 = false;
    L12:
        e2 = e;
        com.bytedance.reparo.core.j.d(TAG, "getInfoLock Thread failed time:10");
    L19:
        if (r1 == null) goto L23;
        this.f9215b = r1;
        return;
    L23:
        throw new IOException("FileLockHelper lock file failed: " + r8.getAbsolutePath(), e2);
    }

    public static c a(File r1) {
        return new c(r1);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        FileLock r0 = this.f9215b;     // Catch: Throwable -> L9
        if (r0 == null) goto L5;
        r0.release();     // Catch: Throwable -> L9
    L5:
        FileOutputStream r1 = this.f9214a;
        if (r1 == null) goto L16;
        r1.close();
        return;
    L16:
        return;
    L9:
        th = move-exception;
        FileOutputStream r2 = this.f9214a;
        if (r2 == null) goto L13;
        r2.close();
    L13:
        throw th;
    }
}
