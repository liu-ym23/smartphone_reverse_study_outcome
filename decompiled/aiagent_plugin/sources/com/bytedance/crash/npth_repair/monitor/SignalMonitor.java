package com.bytedance.crash.npth_repair.monitor;

import android.os.Build;
import com.bytedance.crash.npth_repair.NpthRepair;
import com.bytedance.crash.npth_repair.a.b;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class SignalMonitor {
    private static final String TAG = "SignalMonitor: ";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SignalMonitor f7645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f7646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7647c;

    private native int nDumpSignalMonitor(String r1);

    private native int nStartSignalMonitorWithSigType(int[] r1);

    private native void nStopSignalMonitor();

    private SignalMonitor() {
        this.f7647c = 1110;
    }

    public static SignalMonitor a() {
        if (f7645a != null) goto L15;
        monitor-enter(SignalMonitor.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7645a != null) goto L9;
        f7645a = new SignalMonitor();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SignalMonitor.class);     // Catch: Throwable -> L11
    L15:
        return f7645a;
    }

    private boolean b(b r1) {
        if (r1 != null) goto L4;
    L9:
        return true;
    L4:
        if (r1.a(Build.VERSION.SDK_INT) == true) goto L6;
    L8:
        return false;
    L6:
        if (r1.a(Build.BRAND) == false) goto L8;
        goto L8
    }

    private static int[] c(b r3) {
        int[] r0 = null;
        if (r3 != null) goto L5;
        return null;
    L5:
        JSONArray r4 = r3.b("sigTypes");
        if (r4 != null) goto L8;
    L13:
        return r0;
    L8:
        if (r4.length() <= 0) goto L13;
        r0 = new int[r4.length()];
        int r1 = 0;
    L11:
        if (r1 >= r4.length()) goto L13;
        r0[r1] = r4.optInt(r1);
        r1 = r1 + 1;
        goto L11
    }

    public synchronized int a(b r3) {
        monitor-enter(this);
        int r0 = this.f7647c;     // Catch: Throwable -> L27
        if (r0 == 1110) goto L12;
        if (r0 == 1113) goto L12;
        monitor-exit(this);
        return -2;
    L12:
        if (NpthRepair.a() == false) goto L14;
        this.f7646b = r3;     // Catch: Throwable -> L27
        int r1 = -6;
        if (b(r3) == true) goto L31;
    L21:
        if (r1 == 0) goto L23;
        this.f7647c = 1112;     // Catch: Throwable -> L27
    L25:
        monitor-exit(this);
        return r1;
    L23:
        this.f7647c = 1111;     // Catch: Throwable -> L27
        goto L25
    L31:
        r1 = nStartSignalMonitorWithSigType(c(r3));     // Catch: Throwable -> L20
    L20:
        r1 = -4;
        goto L21
    L14:
        monitor-exit(this);
        return -1;
    L27:
        th = move-exception;
        throw th;
    }

    public synchronized int a(String r3) {
        monitor-enter(this);
        int r0 = this.f7647c;     // Catch: Throwable -> L16
        if (r0 == 1111) goto L13;
        if (r0 == 1113) goto L13;
        monitor-exit(this);
        return -1;
    L13:
        this.f7647c = 1114;     // Catch: Throwable -> L16
        int r4 = nDumpSignalMonitor(r3);     // Catch: Throwable -> L16
        monitor-exit(this);
        return r4;
    L16:
        th = move-exception;
        throw th;
    }
}
