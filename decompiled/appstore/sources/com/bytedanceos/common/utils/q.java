package com.bytedanceos.common.utils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q {
    public static /* synthetic */ void a(String r10) {
        c(r10);
    }

    public static void b() {
        final String r10 = "baidu.com";
        w3.c.b(new p(r10));
    }

    public static /* synthetic */ void c(String r10) {
    L6:
        e = move-exception;
        com.bytedanceos.common.toolbox.i.b("NetState", "judgeTheConnect: " + e.getMessage());
        return;
    L4:
        if (Runtime.getRuntime().exec("ping -c 3 -w 10 " + r10).waitFor() != 0) goto L8;
        com.bytedanceos.common.toolbox.i.a("NetState", "judgeTheConnect: ping success");     // Catch: Exception -> L6
    L12:
        return;
    L8:
        com.bytedanceos.common.toolbox.i.a("NetState", "judgeTheConnect: ping failed");     // Catch: Exception -> L6
        goto L12
    }
}
