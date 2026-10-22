package com.bytedance.memory.g;

import java.io.File;

/* JADX INFO: compiled from: MemoryShrinker.java */
/* JADX INFO: loaded from: classes.dex */
public class j {
    public static File a(File r12, File r13) {
        long r1 = System.currentTimeMillis();     // Catch: Exception -> L18
        com.bytedance.memory.d.a.a("shrink_begin");     // Catch: Exception -> L18
        com.bytedance.memory.f.a.c r3 = com.bytedance.memory.a.a.c().e().g();     // Catch: Exception -> L18
        File r5 = new File(com.bytedance.memory.c.b.i().a(), ".mini.hprof");     // Catch: Exception -> L18
        if (r3 != null) goto L6;
    L11:
        new b().a(r12, r13);     // Catch: Exception -> L18
        com.bytedance.memory.b.h.a(r13, r5, true);     // Catch: Exception -> L18
        com.bytedance.memory.heap.a.a().a(5);     // Catch: Exception -> L18
    L12:
        com.bytedance.memory.d.a.a("shrink_end");     // Catch: Exception -> L18
        com.bytedance.memory.d.a.a("shrink_time", System.currentTimeMillis() - r1);     // Catch: Exception -> L18
        com.bytedance.memory.d.a.a("origin_size", r12.length() / 1024);     // Catch: Exception -> L18
        com.bytedance.memory.d.a.a("shrink_size", r5.length() / 1024);     // Catch: Exception -> L18
        com.bytedance.memory.b.c.a("shrink hprof file %s, size: %dk to %s, size: %dk, use time:%d", new Object[]{r12.getPath(), Long.valueOf(r12.length() / 1024), r5.getPath(), Long.valueOf(r5.length() / 1024), Long.valueOf(System.currentTimeMillis() - r1)});     // Catch: Exception -> L18
        if (r5.exists() == false) goto L23;
        if (r5.length() > 0) goto L25;
        return null;
    L25:
        return r5;
    L23:
        return null;
    L6:
        if (com.bytedance.memory.d.a.e("close_native_shrink") == true) goto L11;
        if (r3.a(r12, r5) == false) goto L10;
        com.bytedance.memory.heap.a.a().a(3);     // Catch: Exception -> L18
        goto L12
    L10:
        new b().a(r12, r13);     // Catch: Exception -> L18
        com.bytedance.memory.b.h.a(r13, r5, true);     // Catch: Exception -> L18
        com.bytedance.memory.heap.a.a().a(5);     // Catch: Exception -> L18
    L18:
        e = move-exception;
        com.bytedance.services.apm.api.a.a(e, "shrink failed");
        e.printStackTrace();
        return null;
    }
}
