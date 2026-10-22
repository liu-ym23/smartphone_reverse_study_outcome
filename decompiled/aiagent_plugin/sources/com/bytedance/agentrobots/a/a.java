package com.bytedance.agentrobots.a;

import com.bytedance.agentrobots.a.a.e;
import com.bytedance.agentrobots.a.a.f;

/* JADX INFO: compiled from: RobotFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.bytedance.agentrobots.a.a.a f3982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static com.bytedance.agentrobots.a.a.b f3983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static f f3984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static e f3985d;

    public static synchronized com.bytedance.agentrobots.a.a.a a() {
        monitor-enter(a.class);
        com.bytedance.agentrobots.a.a.a r1 = f3982a;     // Catch: Throwable -> L18
        if (r1 == null) goto L8;
        monitor-exit(a.class);
        return r1;
    L8:
        int r2 = b.a();     // Catch: Throwable -> L18
        if (r2 != 1) goto L12;
        f3982a = new com.bytedance.agentrobots.a.c.a();     // Catch: Throwable -> L18
    L15:
        com.bytedance.agentrobots.a.a.a r3 = f3982a;     // Catch: Throwable -> L18
        monitor-exit(a.class);
        return r3;
    L12:
        if (r2 != 2) goto L14;
        f3982a = new com.bytedance.agentrobots.a.b.a();     // Catch: Throwable -> L18
        goto L15
    L14:
        f3982a = null;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public static synchronized f b() {
        monitor-enter(a.class);
        f r1 = f3984c;     // Catch: Throwable -> L18
        if (r1 == null) goto L8;
        monitor-exit(a.class);
        return r1;
    L8:
        int r2 = b.a();     // Catch: Throwable -> L18
        if (r2 != 1) goto L12;
        f3984c = new com.bytedance.agentrobots.a.c.f();     // Catch: Throwable -> L18
    L15:
        f r3 = f3984c;     // Catch: Throwable -> L18
        monitor-exit(a.class);
        return r3;
    L12:
        if (r2 != 2) goto L14;
        f3984c = new com.bytedance.agentrobots.a.b.f();     // Catch: Throwable -> L18
        goto L15
    L14:
        f3984c = null;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public static synchronized com.bytedance.agentrobots.a.a.b c() {
        monitor-enter(a.class);
        com.bytedance.agentrobots.a.a.b r1 = f3983b;     // Catch: Throwable -> L18
        if (r1 == null) goto L8;
        monitor-exit(a.class);
        return r1;
    L8:
        int r2 = b.a();     // Catch: Throwable -> L18
        if (r2 != 1) goto L12;
        f3983b = new com.bytedance.agentrobots.a.c.b();     // Catch: Throwable -> L18
    L15:
        com.bytedance.agentrobots.a.a.b r3 = f3983b;     // Catch: Throwable -> L18
        monitor-exit(a.class);
        return r3;
    L12:
        if (r2 != 2) goto L14;
        f3983b = new com.bytedance.agentrobots.a.b.b();     // Catch: Throwable -> L18
        goto L15
    L14:
        f3983b = null;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public static synchronized e d() {
        monitor-enter(a.class);
        e r1 = f3985d;     // Catch: Throwable -> L18
        if (r1 == null) goto L8;
        monitor-exit(a.class);
        return r1;
    L8:
        int r2 = b.a();     // Catch: Throwable -> L18
        if (r2 != 1) goto L12;
        f3985d = new com.bytedance.agentrobots.a.c.e();     // Catch: Throwable -> L18
    L15:
        e r3 = f3985d;     // Catch: Throwable -> L18
        monitor-exit(a.class);
        return r3;
    L12:
        if (r2 != 2) goto L14;
        f3985d = new com.bytedance.agentrobots.a.b.e();     // Catch: Throwable -> L18
        goto L15
    L14:
        f3985d = null;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }
}
