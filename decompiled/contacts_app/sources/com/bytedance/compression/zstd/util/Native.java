package com.bytedance.compression.zstd.util;

/* JADX INFO: loaded from: classes2.dex */
public class Native {
    private static final String LIB_NAME = "bdzstd";
    private static boolean loaded = false;

    static {
    }

    public Native() {
    }

    public static synchronized void load() {
        monitor-enter(Native.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (loaded == false) goto L8;
        monitor-exit(Native.class);
        return;
    L8:
        System.loadLibrary(LIB_NAME);     // Catch: Throwable -> L11
        loaded = true;     // Catch: Throwable -> L11
        monitor-exit(Native.class);
    }
}
