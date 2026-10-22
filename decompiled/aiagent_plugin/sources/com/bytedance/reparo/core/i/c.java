package com.bytedance.reparo.core.i;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: ExecutorServiceUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ExecutorService f9283a;

    static {
    }

    public c() {
    }

    public static ExecutorService a() {
        if (f9283a != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9283a != null) goto L9;
        f9283a = Executors.newSingleThreadExecutor();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f9283a;
    }
}
