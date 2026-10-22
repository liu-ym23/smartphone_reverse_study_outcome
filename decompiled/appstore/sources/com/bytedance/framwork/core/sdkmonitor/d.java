package com.bytedance.framwork.core.sdkmonitor;

import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static void a(Closeable r10) {
        if (r10 == null) goto L8;
        r10.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }
}
