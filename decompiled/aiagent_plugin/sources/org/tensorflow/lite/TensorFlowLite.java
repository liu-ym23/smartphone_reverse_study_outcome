package org.tensorflow.lite;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes5.dex */
public final class TensorFlowLite {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f40573a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[][] f40574b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Throwable f40575c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f40576d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicBoolean[] f40577e = null;

    private static native void nativeDoNothing();

    static {
        f40573a = Logger.getLogger(c.class.getName());
        int r2 = 0;
        String[][] r0 = {new String[]{"tensorflowlite_jni", "tensorflowlite_jni_stable"}, new String[]{"tensorflowlite_jni_gms_client"}};
        f40574b = r0;
        f40576d = false;
        int r1 = r0.length;
        UnsatisfiedLinkError r3 = null;
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L16;
        String[] r5 = r0[r4];
        int r6 = r5.length;
        int r7 = 0;
    L5:
        if (r7 >= r6) goto L15;
        String r8 = r5[r7];
        System.loadLibrary(r8);     // Catch: UnsatisfiedLinkError -> L9
        f40573a.info("Loaded native library: " + r8);     // Catch: UnsatisfiedLinkError -> L9
    L9:
        e = move-exception;
        f40573a.info("Didn't load native library: " + r8);
        if (r3 != null) goto L13;
        r3 = e;
    L14:
        r7 = r7 + 1;
        goto L5
    L13:
        r3.addSuppressed(e);
    L15:
        r4 = r4 + 1;
        goto L3
    L16:
        f40575c = r3;
        f40577e = new AtomicBoolean[c.a.EnumC1097a.values().length];
    L18:
        if (r2 >= c.a.EnumC1097a.values().length) goto L20;
        f40577e[r2] = new AtomicBoolean();
        r2 = r2 + 1;
        goto L18
    }

    private TensorFlowLite() {
    }
}
