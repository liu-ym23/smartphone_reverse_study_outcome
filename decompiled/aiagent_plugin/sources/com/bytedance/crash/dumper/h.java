package com.bytedance.crash.dumper;

import com.bytedance.crash.CrashType;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: compiled from: EvilDumpFile.java */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.bytedance.crash.d f7414a;

    public static void a(com.bytedance.crash.d r0) {
        f7414a = r0;
    }

    public static void a(File r1, final JSONObject r2) {
        r1.listFiles(new AnonymousClass1(r2));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.bytedance.crash.c.b.c("pushEvilFile", th);
    }

    public static void a(File r6) {
        com.bytedance.crash.d r0 = f7414a;
        if (r0 == null) goto L14;
        File[] r1 = r0.a(CrashType.ANR);
        if (r1 != null) goto L7;
        return;
    L7:
        int r2 = r1.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L18;
        File r4 = r1[r3];
        File r5 = new File(r6, r4.getName());
        if (r5.exists() == true) goto L13;
        com.bytedance.crash.o.j.a(r4, r5);
    L13:
        r3 = r3 + 1;
        goto L8
    L18:
        return;
    }
}
