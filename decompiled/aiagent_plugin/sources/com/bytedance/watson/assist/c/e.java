package com.bytedance.watson.assist.c;

import android.util.Log;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.BufferedReader;
import java.io.File;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: ProcTimeInStateFile.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends a {
    public e() {
        this("/proc/self/time_in_state");
    }

    public e(int r3) {
        super("/proc/self/task/" + r3 + "/time_in_state");
    }

    public e(String r1) {
        super(r1);
    }

    @Override // com.bytedance.watson.assist.c.a
    public b a(File r1) {
        return b(r1);
    }

    private b b(File r14) {
        BufferedReader r13 = com.bytedance.watson.assist.d.c.a(r14);
        if (r13 != null) goto L5;
        return null;
    L5:
        com.bytedance.watson.assist.b.c.e r0 = new com.bytedance.watson.assist.b.c.e();
        LinkedHashMap<Long, Long> r3 = null;
        long r4 = 0;
    L33:
        String r6 = r13.readLine();     // Catch: Exception -> L27 Throwable -> L31
        if (r6 == null) goto L24;
        if (r6.isEmpty() == true) goto L33;
        if (r6.contains(MonitorConstants.CPU) == true) goto L33;
        String[] r7 = r6.split(" ");     // Catch: Exception -> L27 Throwable -> L31
        if (r7.length <= 1) goto L24;
        long r9 = Long.parseLong(r7[0]);     // Catch: Exception -> L27 Throwable -> L31
        long r8 = Long.parseLong(r7[1]) * 10;     // Catch: Exception -> L27 Throwable -> L31
        if (r4 != 0) goto L19;
    L21:
        if (r3 != null) goto L23;
        r3 = new LinkedHashMap();     // Catch: Exception -> L27 Throwable -> L31
    L23:
        r3.put(Long.valueOf(r9), Long.valueOf(r8));     // Catch: Exception -> L27 Throwable -> L31
        r4 = r9;
        goto L33
    L19:
        if (r9 >= r4) goto L21;
        r0.a(r3);     // Catch: Exception -> L27 Throwable -> L31
        r3 = null;
    L24:
        r0.a(r3);     // Catch: Exception -> L27 Throwable -> L31
        com.bytedance.watson.assist.d.c.a(r13);
        return r0;
    L31:
        com.bytedance.watson.assist.d.c.a(r13);
        return r0;
    L27:
        e = move-exception;
        com.bytedance.watson.assist.d.b.d(Log.getStackTraceString(e));     // Catch: Throwable -> L31
        com.bytedance.watson.assist.d.c.a(r13);
        return r0;
    }
}
