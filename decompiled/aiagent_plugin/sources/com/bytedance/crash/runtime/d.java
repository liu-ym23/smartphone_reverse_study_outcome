package com.bytedance.crash.runtime;

import android.os.HandlerThread;

/* JADX INFO: compiled from: NpthHandlerThread.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ThreadWithHandler f7748a;

    public d() {
    }

    public static HandlerThread a() {
        if (f7748a != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7748a != null) goto L9;
        f7748a = new ThreadWithHandler("default_npth_thread");     // Catch: Throwable -> L11
        f7748a.a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f7748a.b();
    }

    public static ThreadWithHandler b() {
        if (f7748a != null) goto L6;
        a();
    L6:
        return f7748a;
    }
}
