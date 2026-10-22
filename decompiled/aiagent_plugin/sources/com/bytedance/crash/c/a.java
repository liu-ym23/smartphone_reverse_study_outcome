package com.bytedance.crash.c;

import android.os.SystemClock;
import com.bytedance.crash.runtime.DefaultWorkThread;
import org.json.JSONObject;

/* JADX INFO: compiled from: InitMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f7260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final JSONObject f7261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f7262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f7263d;

    private a() {
        this.f7261b = new JSONObject();
        long r0 = SystemClock.uptimeMillis();
        this.f7262c = r0;
        this.f7263d = r0;
    }

    public static void a() {
        if (f7260a != null) goto L6;
        f7260a = new a();
        return;
    }

    public static void a(String r6) {
        if (f7260a != null) goto L8;
        return;
    L8:
        long r0 = SystemClock.uptimeMillis();     // Catch: Throwable -> L7
        a r2 = f7260a;     // Catch: Throwable -> L7
        r2.f7261b.put(r6, r0 - r2.f7263d);     // Catch: Throwable -> L7
        f7260a.f7263d = r0;     // Catch: Throwable -> L7
        return;
    }

    public static void b() {
        if (f7260a != null) goto L9;
        return;
    L9:
        long r0 = SystemClock.uptimeMillis();     // Catch: Throwable -> L8
        a r2 = f7260a;     // Catch: Throwable -> L8
        long r1 = r0 - r2.f7262c;     // Catch: Throwable -> L8
        r2.f7261b.put("total", r1);     // Catch: Throwable -> L8
    L6:
        DefaultWorkThread.post(new AnonymousClass1());
    }

    public static void c() {
        if (f7260a == null) goto L6;
        new b.a("npthStart").a(f7260a.f7261b).a();
        f7260a = null;
        return;
    }
}
