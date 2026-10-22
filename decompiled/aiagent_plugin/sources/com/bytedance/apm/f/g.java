package com.bytedance.apm.f;

import android.os.SystemClock;
import java.io.BufferedReader;
import java.io.FileReader;

/* JADX INFO: compiled from: ProcessStartupTime.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    public static long a(int r8) {
        BufferedReader r0 = null;
        BufferedReader r1 = new BufferedReader(new FileReader("/proc/" + r8 + "/stat"));     // Catch: Throwable -> L13 Throwable -> L19
        goto L16
    L22:
        String r9 = r1.readLine();     // Catch: Throwable -> L10 Throwable -> L12
        if (r9 == null) goto L9;
        long r4 = ((SystemClock.elapsedRealtime() * com.bytedance.apm.util.b.a(100)) / 1000) - Long.parseLong(r9.split(" ")[21]);
        com.bytedance.monitor.a.d.a(r1);
        return r4;
    L9:
        com.bytedance.monitor.a.d.a(r1);
        return -1;
    L12:
        r0 = r1;
    L10:
        th = th;
        r0 = r1;
    L14:
        com.bytedance.monitor.a.d.a(r0);
        throw th;
    L13:
        th = th;
    L16:
        com.bytedance.monitor.a.d.a(r0);
        return -1;
    }
}
