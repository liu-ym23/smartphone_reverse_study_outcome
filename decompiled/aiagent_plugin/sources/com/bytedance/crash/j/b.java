package com.bytedance.crash.j;

import com.bytedance.crash.i;
import com.bytedance.crash.o.r;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.json.JSONObject;

/* JADX INFO: compiled from: CrashProtector.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static void a() {
        JSONObject r1 = new d("com.bytedance.inner_fix.npth_profiler").a("SIGSEGV").a(35).a(d.a.f7546b).b("libnpth.so").a("libnpth.so", null, true).b("libnpth.so").a("libc.so", "_ZL15__pthread_startPv").a("w0", -1).a();     // Catch: Exception -> L5
        r.b("NPTH_PROT", "addConfig: " + a(r1) + ", config: " + r1.toString());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        r.c("NPTH_PROT", e.getMessage());
    }

    public static synchronized boolean a(JSONObject r4) {
        monitor-enter(b.class);
        c r1 = new c();     // Catch: Throwable -> L16
        if (c.b(r4) == true) goto L9;
        monitor-exit(b.class);
        return false;
    L9:
        r1.c();     // Catch: Throwable -> L16
        if (r1.a(r4) == true) goto L13;
        monitor-exit(b.class);
        return false;
    L13:
        boolean r5 = a(r1.a(), r1.b());     // Catch: Throwable -> L16
        monitor-exit(b.class);
        return r5;
    L16:
        th = move-exception;
        throw th;
    }

    public static synchronized void b(JSONObject r2) {
        monitor-enter(b.class);
        c r1 = new c();     // Catch: Throwable -> L7
        c.c(r2);     // Catch: Throwable -> L7
        r1.c();     // Catch: Throwable -> L7
        a(r1.a(), r1.b());     // Catch: Throwable -> L7
        monitor-exit(b.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static boolean a(byte[] r7, int r8) {
        File r2 = new File(i.e(), "crash_protector.config");     // Catch: Throwable -> L33
        if (a(r2, r7, r8) == false) goto L8;
        r.b("NPTH_PROT", "config not changed");     // Catch: Throwable -> L33
        return true;
    L8:
        if (r2.exists() == false) goto L10;
        r2.delete();     // Catch: Throwable -> L33
    L10:
        if (r7 == null) goto L30;
        if (r8 <= 0) goto L30;
        File r3 = new File(i.e(), "crash_protector.config.tmp");     // Catch: Throwable -> L33
        if (r3.exists() == false) goto L16;
    L18:
        FileOutputStream r5 = null;
        FileOutputStream r6 = new FileOutputStream(r3, false);     // Catch: Throwable -> L27
        r6.write(r7, 0, r8);     // Catch: Throwable -> L25
        r6.flush();     // Catch: Throwable -> L25
        com.bytedance.crash.o.i.a(r6);     // Catch: Throwable -> L33
        if (r3.renameTo(r2) == false) goto L31;
        r.b("NPTH_PROT", "update config file done");     // Catch: Throwable -> L33
        return true;
    L25:
        th = th;
        r5 = r6;
    L28:
        com.bytedance.crash.o.i.a(r5);     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L27:
        th = th;
        goto L28
    L16:
        if (r3.createNewFile() == true) goto L18;
        return false;
    L30:
        return false;
    L31:
        r.c("NPTH_PROT", "failed to update config file");
        return false;
    }

    private static boolean a(File r8, byte[] r9, int r10) {
        if (r9 == null) goto L47;
        if (r10 > 0) goto L6;
        return false;
    L6:
        if (r8.exists() == true) goto L8;
        return false;
    L8:
        if (r8.length() != r10) goto L51;
        FileInputStream r1 = null;
        FileInputStream r2 = new FileInputStream(r8);     // Catch: Exception -> L31
        byte[] r11 = new byte[4096];     // Catch: Exception -> L29
        int r3 = 0;
    L37:
        int r4 = r2.read(r11);     // Catch: Exception -> L28
        if (r4 <= 0) goto L33;
        int r5 = r3 + r4;     // Catch: Exception -> L28
        if (r5 > r10) goto L33;
        int r6 = 0;
    L21:
        if (r6 >= r4) goto L27;
        if (r11[r6] != r9[r3 + r6]) goto L24;
        r6 = r6 + 1;
        goto L21
    L24:
        r2.close();     // Catch: Exception -> L28
        return false;
    L27:
        r3 = r5;
    L33:
        com.bytedance.crash.o.i.a(r2);
        if (r3 != r10) goto L50;
        return true;
    L50:
        return false;
    L28:
        int r12 = r3;
    L30:
        r1 = r2;
    L32:
        r2 = r1;
        r3 = r12;
    L29:
        r12 = 0;
    L31:
        r12 = 0;
        goto L32
    L51:
        return false;
    L47:
        return false;
    }
}
