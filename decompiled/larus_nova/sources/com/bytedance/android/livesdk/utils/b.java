package com.bytedance.android.livesdk.utils;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile b f158885c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f158886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f158887b;

    public static b a() {
        if (f158885c != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f158885c != null) goto L9;
        f158885c = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f158885c;
    }

    public b() {
        this.f158886a = "";
        this.f158887b = false;
    }
}
