package com.bytedance.crash.npth_repair.nativeCrash;

import com.bytedance.crash.npth_repair.NpthRepair;
import com.bytedance.crash.npth_repair.a.a;

/* JADX INFO: loaded from: classes.dex */
public class ArtDumpNativeStackFixer {
    private static final String TAG = "ArtDumpNativeStackFixer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f7648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f7649b;

    private static native int nStartFixDumpNativeStack();

    private static native void nStopFixDumpNativeStack();

    public ArtDumpNativeStackFixer() {
    }

    public static synchronized int a() {
        monitor-enter(ArtDumpNativeStackFixer.class);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (NpthRepair.a() == true) goto L11;
        a.a(TAG, "not init yet, please make sure invoke NpthRepair.init first");     // Catch: Throwable -> L25
        monitor-exit(ArtDumpNativeStackFixer.class);
        return -1;
    L11:
        if (f7648a == false) goto L17;
        a.a(TAG, "has fixed");     // Catch: Throwable -> L25
        monitor-exit(ArtDumpNativeStackFixer.class);
        return -2;
    L17:
        f7648a = true;     // Catch: Throwable -> L25
        f7649b = nStartFixDumpNativeStack();     // Catch: Throwable -> L20
    L22:
        int r1 = f7649b;     // Catch: Throwable -> L25
        monitor-exit(ArtDumpNativeStackFixer.class);
        return r1;
    L21:
        f7649b = -4;     // Catch: Throwable -> L25
        goto L22
    }
}
