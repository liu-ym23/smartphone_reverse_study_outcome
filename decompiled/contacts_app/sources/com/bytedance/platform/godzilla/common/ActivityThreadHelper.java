package com.bytedance.platform.godzilla.common;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.platform.godzilla.utils.MethodUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class ActivityThreadHelper {
    private static final long WAIT_TIME = 5000;
    private static Object sActivityThread;
    private static Class sClassForActivityThread;

    static /* synthetic */ Object access$002(Object r0) {
        sActivityThread = r0;
        return r0;
    }

    static /* synthetic */ Class access$100() {
        return sClassForActivityThread;
    }

    private ActivityThreadHelper() {
    }

    public static Object currentActivityThread() {
        if (sActivityThread != null) goto L36;
        monitor-enter(ActivityThreadHelper.class);     // Catch: Exception -> L33
    L30:
        th = move-exception;
        throw th;     // Catch: Exception -> L33
    L7:
        if (sActivityThread != null) goto L13;
        if (sClassForActivityThread != null) goto L11;
        sClassForActivityThread = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L30
    L11:
        sActivityThread = MethodUtils.invokeStaticMethod(sClassForActivityThread, "currentActivityThread", new Object[0]);     // Catch: Throwable -> L30
    L13:
        if (sActivityThread == null) goto L15;
    L28:
        monitor-exit(ActivityThreadHelper.class);     // Catch: Throwable -> L30
        goto L36
    L15:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L28;
        final Object r1 = new Object();     // Catch: Throwable -> L30
        new Handler(Looper.getMainLooper()).post(new AnonymousClass1(r1));     // Catch: Throwable -> L30
        if (sActivityThread != null) goto L28;
        monitor-enter(r1);     // Catch: Throwable -> L30
        r1.wait(5000);     // Catch: Throwable -> L22 InterruptedException -> L37
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L24:
        monitor-exit(r1);     // Catch: Throwable -> L22
    L33:
        e = move-exception;
        e.printStackTrace();
    L36:
        return sActivityThread;
    }
}
