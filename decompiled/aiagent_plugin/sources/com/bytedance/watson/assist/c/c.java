package com.bytedance.watson.assist.c;

import android.util.Log;
import java.io.BufferedReader;
import java.io.File;

/* JADX INFO: compiled from: ProcPidStatFile.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final Character f11854b = null;

    static {
        f11854b = ')';
    }

    public c(String r1) {
        super(r1);
    }

    public c() {
        this("proc/self/stat");
    }

    @Override // com.bytedance.watson.assist.c.a
    public b a(File r2) {
        return a(r2, null);
    }

    public b a(File r6, com.bytedance.watson.assist.b.c.d r7) {
        BufferedReader r5 = com.bytedance.watson.assist.d.c.a(r6);
        if (r5 != null) goto L32;
        return null;
    L32:
        String r8 = r5.readLine();     // Catch: Exception -> L25 Throwable -> L29
        if (r8 != null) goto L9;
    L23:
        com.bytedance.watson.assist.d.c.a(r5);
        return r7;
    L9:
        if (r8.isEmpty() == true) goto L23;
        String r9 = r8.trim();     // Catch: Exception -> L25 Throwable -> L29
        Character r0 = f11854b;     // Catch: Exception -> L25 Throwable -> L29
        String r1 = r9.substring(0, r9.indexOf(r0.charValue())).trim();     // Catch: Exception -> L25 Throwable -> L29
        String r10 = r9.substring(r9.indexOf(r0.charValue()) + 1, r9.length()).trim();     // Catch: Exception -> L25 Throwable -> L29
        String[] r2 = r1.split("\\(");     // Catch: Exception -> L25 Throwable -> L29
        String[] r11 = r10.split(" ");     // Catch: Exception -> L25 Throwable -> L29
        if (r2.length > 1) goto L14;
    L21:
        com.bytedance.watson.assist.d.c.a(r5);
        return r7;
    L14:
        if (r11.length <= 14) goto L21;
        if (r7 != null) goto L18;
        r7 = new com.bytedance.watson.assist.b.c.d();     // Catch: Exception -> L25 Throwable -> L29
    L18:
        r7.a(Integer.parseInt(r2[0].trim()));     // Catch: Exception -> L25 Throwable -> L29
        r7.a(r2[1].trim());     // Catch: Exception -> L25 Throwable -> L29
        r7.c((((Integer.parseInt(r11[11]) + Integer.parseInt(r11[12])) + Integer.parseInt(r11[13])) + Integer.parseInt(r11[14])) * 10);     // Catch: Exception -> L25 Throwable -> L29
        com.bytedance.watson.assist.d.c.a(r5);
        return r7;
    L25:
        e = move-exception;
        com.bytedance.watson.assist.d.b.d(Log.getStackTraceString(e));     // Catch: Throwable -> L29
        com.bytedance.watson.assist.d.c.a(r5);
        return r7;
    L29:
        com.bytedance.watson.assist.d.c.a(r5);
        return r7;
    }
}
