package com.ttnet.org.chromium.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.ttnet.org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes4.dex */
public class ThreadUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f18308a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f18309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Handler f18310c;

    static {
        f18308a = new Object();
    }

    public static void a() {
    }

    public static Handler b() {
        Object r10 = f18308a;
        monitor-enter(r10);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f18310c == null) goto L7;
        boolean r11 = false;
    L14:
        monitor-exit(r10);     // Catch: Throwable -> L9
        if (r11 == false) goto L18;
        TraceEvent.c();
    L18:
        return f18310c;
    L7:
        if (f18309b == true) goto L12;
        f18310c = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L9
        r11 = true;
        goto L14
    L12:
        throw new RuntimeException("Did not yet override the UI thread");     // Catch: Throwable -> L9
    }

    public static Looper c() {
        return b().getLooper();
    }

    public static void d(Runnable r10) {
        if (e() == false) goto L5;
        r10.run();
        return;
    L5:
        b().post(r10);
    }

    public static boolean e() {
        if (b().getLooper() != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    @CalledByNative
    private static boolean isThreadPriorityAudio(int r10) {
        if (Process.getThreadPriority(r10) != (-16)) goto L5;
        return true;
    L5:
        return false;
    }

    @CalledByNative
    public static void setThreadPriorityAudio(int r10) {
        Process.setThreadPriority(r10, -16);
    }
}
