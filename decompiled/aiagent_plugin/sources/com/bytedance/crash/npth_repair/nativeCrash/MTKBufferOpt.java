package com.bytedance.crash.npth_repair.nativeCrash;

import com.bytedance.crash.npth_repair.NpthRepair;

/* JADX INFO: loaded from: classes.dex */
public class MTKBufferOpt {
    private static final String TAG = "RenderD128Opt";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static boolean f7652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static int f7653b;

    private static native int nOptMTKBuffer(int r0);

    public MTKBufferOpt() {
    }

    public static synchronized int a(int r2) {
        monitor-enter(MTKBufferOpt.class);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (NpthRepair.a() == true) goto L10;
        monitor-exit(MTKBufferOpt.class);
        return -1;
    L10:
        if (f7652a == false) goto L15;
        monitor-exit(MTKBufferOpt.class);
        return -2;
    L15:
        f7652a = true;     // Catch: Throwable -> L23
        f7653b = nOptMTKBuffer(r2);     // Catch: Throwable -> L18
    L20:
        int r3 = f7653b;     // Catch: Throwable -> L23
        monitor-exit(MTKBufferOpt.class);
        return r3;
    L19:
        f7653b = -4;     // Catch: Throwable -> L23
        goto L20
    }
}
