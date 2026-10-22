package com.bytedance.apm6.consumer.slardar.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: WeedOutManager.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f5174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Set<d> f5175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f5176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f5177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5178e;
    private int f;

    public c() {
        this.f5175b = new HashSet();
        this.f5177d = 80;
        this.f5178e = 5;
        this.f = -1;
    }

    static /* synthetic */ int a(c r0) {
        return r0.f5178e;
    }

    static /* synthetic */ int b(c r0) {
        return r0.f5177d;
    }

    static /* synthetic */ Set c(c r0) {
        return r0.f5175b;
    }

    static /* synthetic */ int d(c r0) {
        return r0.f;
    }

    static /* synthetic */ b e(c r0) {
        return r0.f5176c;
    }

    static {
        f5174a = new c();
    }

    public static c a() {
        return f5174a;
    }

    public void a(int r2, int r3, int r4) {
        if (r2 <= 0) goto L12;
        if (r3 <= 0) goto L14;
        this.f5177d = r2;
        this.f5178e = r3;
        int r0 = -1;
        if (r4 == (-1)) goto L8;
        r0 = Math.max(r4, 80);
    L8:
        this.f = r0;
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L13;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "weed out config:maxSizeMB:" + r2 + " keepDays:" + r3);
        return;
    L13:
        return;
    L14:
        return;
    }

    public synchronized void a(d r3) {
        monitor-enter(this);
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        if (r4 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.f5175b.add(r4);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized void a(b r3) {
        monitor-enter(this);
        this.f5176c = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void b() {
        if (com.bytedance.apm6.foundation.context.a.e() == true) goto L5;
        return;
    L5:
        final long r3 = 0;
        final long r5 = 14400000;
        com.bytedance.apm6.util.e.b.a(com.bytedance.apm6.util.e.c.f5473a).a(new AnonymousClass1(this, r3, r5));
    }
}
