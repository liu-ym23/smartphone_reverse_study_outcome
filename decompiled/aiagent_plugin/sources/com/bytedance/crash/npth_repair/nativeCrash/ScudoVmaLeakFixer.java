package com.bytedance.crash.npth_repair.nativeCrash;

import com.bytedance.crash.npth_repair.NpthRepair;
import com.bytedance.crash.npth_repair.a.a;

/* JADX INFO: loaded from: classes.dex */
public class ScudoVmaLeakFixer {
    private static final String TAG = "ScudoVmaLeakFixer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f7654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f7655b;

    private static native int nFixScudoVmaLeak();

    public ScudoVmaLeakFixer() {
    }

    public static synchronized int a() {
        monitor-enter(ScudoVmaLeakFixer.class);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (NpthRepair.a() == true) goto L11;
        a.a(TAG, "not init yet, please make sure invoke NpthRepair.init first");     // Catch: Throwable -> L25
        monitor-exit(ScudoVmaLeakFixer.class);
        return -1;
    L11:
        if (f7654a == false) goto L17;
        a.a(TAG, "has fixed");     // Catch: Throwable -> L25
        monitor-exit(ScudoVmaLeakFixer.class);
        return -2;
    L17:
        f7654a = true;     // Catch: Throwable -> L25
        f7655b = nFixScudoVmaLeak();     // Catch: Throwable -> L20
    L22:
        int r1 = f7655b;     // Catch: Throwable -> L25
        monitor-exit(ScudoVmaLeakFixer.class);
        return r1;
    L21:
        f7655b = -4;     // Catch: Throwable -> L25
        goto L22
    }
}
