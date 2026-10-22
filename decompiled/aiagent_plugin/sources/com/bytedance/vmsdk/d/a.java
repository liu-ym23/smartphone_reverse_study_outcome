package com.bytedance.vmsdk.d;

import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: compiled from: ThreadUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f11738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f11739b;

    public static synchronized String a() {
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f11739b == true) goto L8;
        f11739b = true;     // Catch: Throwable -> L11
        f11738a = b();     // Catch: IOException -> L14 Throwable -> L11
    L8:
        String r1 = f11738a;     // Catch: Throwable -> L11
        monitor-exit(a.class);
        return r1;
    }

    private static String b() {
        byte[] r0 = new byte[64];
        FileInputStream r1 = new FileInputStream("/proc/self/cmdline");
        int r2 = r1.read(r0);     // Catch: Throwable -> L9
        int r4 = a(r0, 0, r2, (byte) 0);     // Catch: Throwable -> L9
        if (r4 <= 0) goto L6;
        r2 = r4;
    L6:
        String r5 = new String(r0, 0, r2);     // Catch: Throwable -> L9
        r1.close();
        return r5;
    L9:
        th = move-exception;
        r1.close();
        throw th;
    }

    private static int a(byte[] r0, int r1, int r2, byte r3) {
        int r4 = 0;
    L4:
        if (r4 >= r0.length) goto L9;
        if (r0[r4] == r3) goto L7;
        r4 = r4 + 1;
        goto L4
    L7:
        return r4;
    L9:
        return -1;
    }
}
