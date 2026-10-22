package com.bytedance.reparo.core.a.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: IOUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
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

    public static int a(InputStream r2, OutputStream r3) {
        long r4 = b(r2, r3);
        if (r4 <= 2147483647L) goto L7;
        return -1;
    L7:
        return (int) r4;
    }

    public static long b(InputStream r1, OutputStream r2) {
        return a(r1, r2, 4096);
    }

    public static long a(InputStream r0, OutputStream r1, int r2) {
        return a(r0, r1, new byte[r2]);
    }

    public static long a(InputStream r4, OutputStream r5, byte[] r6) {
        long r0 = 0;
    L3:
        int r3 = r4.read(r6);
        if ((-1) == r3) goto L6;
        r5.write(r6, 0, r3);
        r0 = r0 + ((long) r3);
        goto L3
    L6:
        return r0;
    }
}
