package com.bytedance.crash.dumper.a;

import android.os.Build;
import java.io.File;

/* JADX INFO: compiled from: ThrowableDumper.java */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f7400a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f7401b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char[] f7402c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final char[] f7403d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final char[] f7404e = null;
    private static final char[] f = null;
    private static final boolean g = false;

    static {
        f7400a = new char[]{'C', 'a', 'u', 's', 'e', 'd', ' ', 'b', 'y', ':', ' '};
        f7401b = new char[]{'S', 'u', 'p', 'p', 'r', 'e', 's', 's', 'e', 'd', ':', ' '};
        f7402c = new char[]{'\t', 'a', 't', ' '};
        f7403d = new char[]{'\t', '.', '.', '.', ' '};
        f7404e = new char[]{' ', 'm', 'o', 'r', 'e', '\n'};
        f = new char[]{' ', 's', 'k', 'i', 'p', '\n'};
        if (Build.VERSION.SDK_INT < 19) goto L5;
        boolean r0 = true;
    L6:
        g = r0;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static String a(File r2) {
        return com.bytedance.crash.o.i.d(new File(r2, "throwable.txt"));
    }

    public static void a(File r2, Throwable r3) {
        i r0 = new i(r2.getAbsolutePath() + "/throwable.txt");     // Catch: Throwable -> L4
        a(new h(r0), r3);     // Catch: Throwable -> L4
        r0.f();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.bytedance.crash.c.b.c("NPTH_DUMP", th);
    }

    private static void a(h r4, StackTraceElement[] r5, int r6) {
        int r0 = 0;
        if (r6 > 256) goto L5;
    L10:
        if (r0 >= r6) goto L16;
        r4.a(f7402c).a(r5[r0]).a('\n');
        r0 = r0 + 1;
        goto L10
    L16:
        return;
    L5:
        if (r0 >= 128) goto L7;
        r4.a(f7402c).a(r5[r0]).a('\n');
        r0 = r0 + 1;
        goto L5
    L7:
        r4.a(f7403d).a(r6 - 256).a(f);
        int r1 = r6 - 128;
    L8:
        if (r1 >= r6) goto L12;
        r4.a(f7402c).a(r5[r1]).a('\n');
        r1 = r1 + 1;
        goto L8
    }

    private static void a(h r7, Throwable r8) {
        r7.a(r8).a('\n');
        StackTraceElement[] r0 = r8.getStackTrace();
        a(r7, r0, r0.length);
        if (g == false) goto L7;
        Throwable[] r1 = r8.getSuppressed();
        int r2 = r1.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L7;
        a(r7, f7401b, 1, r1[r3], r8);
        r3 = r3 + 1;
    L7:
        Throwable r4 = r8.getCause();
        if (r4 == null) goto L12;
        a(r7, f7400a, 0, r4, r8);
        return;
    }

    private static void a(h r5, char[] r6, int r7, Throwable r8, Throwable r9) {
        StackTraceElement[] r10 = r9.getStackTrace();
        StackTraceElement[] r0 = r8.getStackTrace();
        int r1 = r0.length - 1;
        int r2 = r10.length - 1;
    L3:
        if (r1 < 0) goto L8;
        if (r2 < 0) goto L8;
        if (r0[r1].equals(r10[r2]) == false) goto L8;
        r1 = r1 - 1;
        r2 = r2 - 1;
    L8:
        int r11 = (r0.length - 1) - r1;
        r5.b(r7).a(r6).a(r8).a('\n');
        a(r5, r0, r0.length - r11);
        if (r11 == 0) goto L12;
        r5.b(r7).a(f7403d).a(r11).a(f7404e);
    L12:
        if (g == false) goto L16;
        Throwable[] r12 = r8.getSuppressed();
        int r13 = r12.length;
        int r3 = 0;
    L14:
        if (r3 >= r13) goto L16;
        a(r5, f7401b, r7 + 1, r12[r3], r8);
        r3 = r3 + 1;
    L16:
        Throwable r14 = r8.getCause();
        if (r14 == null) goto L24;
        a(r5, f7400a, r7, r14, r8);
        return;
    }
}
