package com.bytedance.memory.g;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* JADX INFO: compiled from: HprofBufferShrinker.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public b() {
    }

    public void a(File r4, File r5) {
        FileInputStream r0 = new FileInputStream(r4);     // Catch: Throwable -> L13
        BufferedOutputStream r6 = new BufferedOutputStream(new FileOutputStream(r5));     // Catch: Throwable -> L11
        new f(new BufferedInputStream(r0)).a(new g(new h(r6)));     // Catch: Throwable -> L9
        r6.close();     // Catch: Throwable -> L20
    L32:
        r0.close();     // Catch: Throwable -> L21
        return;
    L38:
        return;
    L9:
        Throwable th = th;
    L15:
        if (r6 != null) goto L34;
    L17:
        if (r0 == null) goto L39;
        r0.close();     // Catch: Throwable -> L23
        throw th;
    L40:
        throw th;
    L39:
        throw th;
    L34:
        r6.close();     // Catch: Throwable -> L22
    L11:
        th = move-exception;
        r6 = null;
        th = th;
    L13:
        th = move-exception;
        r0 = null;
        th = th;
        r6 = null;
        goto L15
    }
}
