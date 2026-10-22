package com.baidu.platform.comapi.resource;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes39.dex */
public class a {
    public static void a(Closeable r100) {
        if (r100 != null) goto L7;
        return;
    L7:
        r100.close();     // Catch: Exception -> L6
        return;
    }

    public static void a(InputStream r100, OutputStream r101, byte[] r102) throws IOException {
        if (r100 == null) goto L21;
        if (r101 == null) goto L21;
        if (r102 == null) goto L21;
    L17:
        th = move-exception;
        a(r100);
        a(r101);
        throw th;
    L6:
        if ((r100 instanceof BufferedInputStream) == true) goto L9;
        r100 = new BufferedInputStream(r100);     // Catch: Throwable -> L17
    L9:
        if ((r101 instanceof BufferedOutputStream) == true) goto L11;
        r101 = new BufferedOutputStream(r101);     // Catch: Throwable -> L17
    L11:
        int r103 = r100.read(r102);     // Catch: Throwable -> L17
        if (r103 == (-1)) goto L14;
        r101.write(r102, 0, r103);     // Catch: Throwable -> L17
        goto L11
    L14:
        r101.flush();     // Catch: Throwable -> L17
        a(r100);
        a(r101);
        return;
    L21:
        throw new IOException("copyStream : outputStream or inputStream is null");
    }
}
