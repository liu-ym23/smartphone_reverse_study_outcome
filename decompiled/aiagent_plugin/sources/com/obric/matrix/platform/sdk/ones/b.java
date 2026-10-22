package com.obric.matrix.platform.sdk.ones;

import android.content.Context;

/* JADX INFO: compiled from: MatrixOnesSdk.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private static final String TAG = "MatrixOnesSdk";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f33630a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f33631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f33632c;

    static {
        f33630a = new b();
    }

    private b() {
    }

    public final Context a() {
        return f33631b;
    }

    public final a b() {
        return f33632c;
    }

    public final synchronized void c() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (f33631b == null) goto L10;
        if (f33632c == null) goto L10;
        monitor-exit(this);
        return;
    L10:
        throw new RuntimeException("please call init first ");     // Catch: Throwable -> L11
    }
}
