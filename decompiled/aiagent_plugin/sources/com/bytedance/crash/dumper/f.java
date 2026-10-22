package com.bytedance.crash.dumper;

import com.bytedance.crash.CrashType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;

/* JADX INFO: compiled from: CustomFile.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f7412a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f7413b = 1048576;

    static {
    }

    public static void a(boolean r0, int r1) {
        f7412a = r0;
        if (r1 <= 0) goto L6;
        f7413b = r1;
        return;
    }

    public static void a(File r12, CrashType r13) {
        com.bytedance.crash.monitor.a r0 = com.bytedance.crash.monitor.h.a();
        if (r0 != null) goto L5;
        return;
    L5:
        if (f7412a == false) goto L37;
        Iterator<com.bytedance.crash.d> r1 = r0.n().d(r13).iterator();     // Catch: Throwable -> L24
        int r2 = 0;
    L9:
        if (r1.hasNext() == false) goto L39;
        File[] r3 = ((com.bytedance.crash.d) ZeusTransformUtils.preCheckCast(r1.next(), com.bytedance.crash.d.class, "com.obric.aiagent.plugin")).a(r13);     // Catch: Throwable -> L24
        if (r3 == null) goto L9;
        int r4 = r3.length;     // Catch: Throwable -> L24
        int r5 = 0;
    L14:
        if (r5 >= r4) goto L9;
        File r6 = r3[r5];     // Catch: Throwable -> L24
        File r7 = new File(r12, r6.getName());     // Catch: Throwable -> L24
        if (r7.exists() == true) goto L22;
        r2 = (int) (((long) r2) + r6.length());     // Catch: Throwable -> L24
        if (r2 > f7413b) goto L9;
        com.bytedance.crash.o.j.a(r6, r7);     // Catch: Throwable -> L24
    L22:
        r5 = r5 + 1;
        goto L14
    L39:
        return;
    L38:
        return;
    }
}
