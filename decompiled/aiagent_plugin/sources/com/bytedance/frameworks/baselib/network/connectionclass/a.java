package com.bytedance.frameworks.baselib.network.connectionclass;

import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ConnectionClassManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f8046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f8047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AtomicReference<com.bytedance.frameworks.baselib.network.connectionclass.b> f8048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicReference<com.bytedance.frameworks.baselib.network.connectionclass.b> f8049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList<b> f8050e;
    private int f;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.connectionclass.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ConnectionClassManager.java */
    private static class C0179a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8051a = null;

        static {
            f8051a = new a();
        }
    }

    /* JADX INFO: compiled from: ConnectionClassManager.java */
    public interface b {
        void a(com.bytedance.frameworks.baselib.network.connectionclass.b r1);
    }

    public static a a() {
        return C0179a.f8051a;
    }

    public a() {
        this.f8046a = new c(0.05d);
        this.f8047b = false;
        this.f8048c = new AtomicReference(com.bytedance.frameworks.baselib.network.connectionclass.b.f8056e);
        this.f8050e = new ArrayList();
    }

    public synchronized void a(long r6, long r8) {
        monitor-enter(this);
        double r0 = ((r6 * 1.0d) / r8) * 8.0d;
        if (r8 != 0) goto L6;
    L28:
        monitor-exit(this);
        return;
    L6:
        if (r0 < 3.0d) goto L28;
        if (Logger.debug() == false) goto L11;
        Logger.d("ConnectionClassManager", "bytes = " + r6 + " timeInMs = " + r8 + " bandwidth = " + r0);     // Catch: Throwable -> L30
    L11:
        this.f8046a.a(r0);     // Catch: Throwable -> L30
        if (this.f8047b == false) goto L24;
        this.f++;     // Catch: Throwable -> L30
        if (b() == this.f8049d.get()) goto L17;
        this.f8047b = false;     // Catch: Throwable -> L30
        this.f = 1;     // Catch: Throwable -> L30
    L17:
        if (this.f >= 5.0d) goto L19;
    L21:
        monitor-exit(this);
        return;
    L19:
        if (c() == false) goto L21;
        this.f8047b = false;     // Catch: Throwable -> L30
        this.f = 1;     // Catch: Throwable -> L30
        this.f8048c.set((com.bytedance.frameworks.baselib.network.connectionclass.b) ZeusTransformUtils.preCheckCast(this.f8049d.get(), com.bytedance.frameworks.baselib.network.connectionclass.b.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L30
        d();     // Catch: Throwable -> L30
        goto L21
    L24:
        if (this.f8048c.get() == b()) goto L26;
        this.f8047b = true;     // Catch: Throwable -> L30
        this.f8049d = new AtomicReference(b());     // Catch: Throwable -> L30
    L26:
        monitor-exit(this);
    }

    private boolean c() {
        if (this.f8046a != null) goto L29;
        return false;
    L29:
        com.bytedance.frameworks.baselib.network.connectionclass.b r0 = (com.bytedance.frameworks.baselib.network.connectionclass.b) ZeusTransformUtils.preCheckCast(this.f8048c.get(), com.bytedance.frameworks.baselib.network.connectionclass.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        double r3 = 560.0d;
        double r5 = 112.0d;
        if (com.bytedance.frameworks.baselib.network.connectionclass.b.f8052a != r0) goto L9;
        r5 = 0.0d;
        r3 = 28.0d;
    L17:
        double r7 = this.f8046a.a();     // Catch: Throwable -> L26
        if (r7 <= r3) goto L24;
        if (r7 <= (r3 * 1.25d)) goto L28;
        return true;
    L28:
        return false;
    L24:
        if (r7 >= (r5 * 0.8d)) goto L28;
    L25:
        return true;
    L9:
        if (com.bytedance.frameworks.baselib.network.connectionclass.b.f8053b != r0) goto L12;
        r3 = 112.0d;
        r5 = 28.0d;
        goto L17
    L12:
        if (com.bytedance.frameworks.baselib.network.connectionclass.b.f8054c == r0) goto L17;
        if (com.bytedance.frameworks.baselib.network.connectionclass.b.f8055d != r0) goto L25;
        r3 = 3.4028234663852886E38d;
        r5 = 560.0d;
    L26:
        th = move-exception;
        th.printStackTrace();
        goto L28
    }

    public synchronized com.bytedance.frameworks.baselib.network.connectionclass.b b() {
        monitor-enter(this);
        c r0 = this.f8046a;     // Catch: Throwable -> L15
        if (r0 != null) goto L18;
        com.bytedance.frameworks.baselib.network.connectionclass.b r1 = com.bytedance.frameworks.baselib.network.connectionclass.b.f8056e;     // Catch: Throwable -> L15
        monitor-exit(this);
        return r1;
    L18:
        com.bytedance.frameworks.baselib.network.connectionclass.b r2 = a(r0.a());     // Catch: Throwable -> L11
        monitor-exit(this);
        return r2;
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L15
        return com.bytedance.frameworks.baselib.network.connectionclass.b.f8056e;
    L15:
        th = move-exception;
        throw th;
    }

    private com.bytedance.frameworks.baselib.network.connectionclass.b a(double r3) {
        if (r3 >= 0.0d) goto L7;
        return com.bytedance.frameworks.baselib.network.connectionclass.b.f8056e;
    L7:
        if (r3 >= 28.0d) goto L11;
        return com.bytedance.frameworks.baselib.network.connectionclass.b.f8052a;
    L11:
        if (r3 >= 112.0d) goto L15;
        return com.bytedance.frameworks.baselib.network.connectionclass.b.f8053b;
    L15:
        if (r3 >= 560.0d) goto L19;
        return com.bytedance.frameworks.baselib.network.connectionclass.b.f8054c;
    L19:
        return com.bytedance.frameworks.baselib.network.connectionclass.b.f8055d;
    }

    public com.bytedance.frameworks.baselib.network.connectionclass.b a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L6;
        this.f8050e.add(r4);
    L6:
        return (com.bytedance.frameworks.baselib.network.connectionclass.b) ZeusTransformUtils.preCheckCast(this.f8048c.get(), com.bytedance.frameworks.baselib.network.connectionclass.b.class, "com.obric.aiagent.plugin");
    }

    private void d() {
        int r1 = this.f8050e.size();     // Catch: Throwable -> L7
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L13;
        ((b) ZeusTransformUtils.preCheckCast(this.f8050e.get(r2), b.class, "com.obric.aiagent.plugin")).a((com.bytedance.frameworks.baselib.network.connectionclass.b) ZeusTransformUtils.preCheckCast(this.f8048c.get(), com.bytedance.frameworks.baselib.network.connectionclass.b.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L7
        r2 = r2 + 1;
        goto L4
    L13:
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }
}
