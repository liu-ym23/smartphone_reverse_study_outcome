package com.bytedance.apm.profiler;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class Profiler {
    private static final String TAG = "unwind";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f4856a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f4857b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicReference<Boolean> f4858c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f4859d;

    private static native boolean nAttachThread(int r0);

    private static native boolean nCheck();

    private static native void nClear();

    private static native boolean nDetachThread(int r0);

    private static native String nDump(long r0, long r2);

    private static native String nGetStack(int r0);

    private static native boolean nInit();

    private static native void nSetAlog(long r0);

    private static native boolean nStart(int r0);

    private static native boolean nStop();

    private Profiler() {
    }

    static {
        f4858c = new AtomicReference(null);
        f4859d = false;
    }
}
