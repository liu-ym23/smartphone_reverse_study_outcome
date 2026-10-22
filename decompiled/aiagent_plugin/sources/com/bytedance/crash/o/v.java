package com.bytedance.crash.o;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* JADX INFO: compiled from: SerializeFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class v {
    public static Object a(File r4) {
    L25:
        th = move-exception;
        com.bytedance.crash.c.b.a(th);
        return null;
    L4:
        if (r4.exists() == true) goto L32;
        File r1 = new File(r4.getAbsolutePath() + ".bk");     // Catch: Throwable -> L25
        if (r1.exists() == true) goto L8;
        return null;
    L8:
        r1.renameTo(r4);     // Catch: Throwable -> L25
    L32:
        FileInputStream r2 = new FileInputStream(r4);     // Catch: Throwable -> L15 Exception -> L17
        Object r5 = new ObjectInputStream(r2).readObject();     // Catch: Exception -> L13 Throwable -> L22
        i.a(r2);     // Catch: Throwable -> L25
        return r5;
    L13:
        e = e;
    L19:
        j.a(r4);     // Catch: Throwable -> L22
        com.bytedance.crash.c.b.a(e);     // Catch: Throwable -> L22
        i.a(r2);     // Catch: Throwable -> L25
        return null;
    L22:
        th = th;
    L23:
        i.a(r2);     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L17:
        e = e;
        r2 = null;
    L15:
        th = th;
        r2 = null;
        goto L23
    }

    public static void a(File r4, Object r5) {
        File r0 = new File(r4.getAbsolutePath() + ".bk");     // Catch: Throwable -> L36
        if (r4.isDirectory() == false) goto L6;
        j.a(r4);     // Catch: Throwable -> L36
    L11:
        boolean r1 = false;
        Closeable r2 = null;
        FileOutputStream r3 = null;
        FileOutputStream r6 = new FileOutputStream(r4);     // Catch: Throwable -> L21 Exception -> L23
        ObjectOutputStream r7 = new ObjectOutputStream(r6);     // Catch: Throwable -> L17 Exception -> L19
        r7.writeObject(r5);     // Catch: Throwable -> L17 Exception -> L19
        r1 = true;
        i.a(r6);     // Catch: Throwable -> L36
        r2 = r7;
    L27:
        if (r0.exists() == false) goto L39;
        if (r1 == false) goto L31;
        j.a(r0);     // Catch: Throwable -> L36
        goto L39
    L31:
        if (r4.exists() == false) goto L33;
        j.a(r4);     // Catch: Throwable -> L36
    L33:
        r0.renameTo(r4);     // Catch: Throwable -> L36
    L39:
        return;
    L19:
        e = e;
        r3 = r6;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L21
        com.bytedance.crash.c.b.a(e);     // Catch: Throwable -> L21
        i.a(r3);     // Catch: Throwable -> L36
        r2 = r3;
    L17:
        th = th;
        r2 = r6;
    L34:
        i.a(r2);     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L21:
        th = th;
    L23:
        e = e;
        goto L24
    L6:
        if (r4.exists() == false) goto L11;
        if (r0.exists() == false) goto L10;
        r0.delete();     // Catch: Throwable -> L36
    L10:
        r4.renameTo(r0);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        com.bytedance.crash.c.b.a(th);
    }
}
