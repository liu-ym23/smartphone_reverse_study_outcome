package com.bytedance.safetyguard.lxc.internal.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: AppGatewayProxySession.kt */
/* JADX INFO: loaded from: classes.dex */
final class i implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f10234a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InputStream f10235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayBlockingQueue<h> f10236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f10237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f10238e;
    private final Thread f;

    /* JADX INFO: compiled from: AppGatewayProxySession.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f10234a = new a(null);
    }

    public static /* synthetic */ void lambda$6YDHuJJydSkc4fIDlIX5qx9sqEQ(i r0) {
        r0.b();
    }

    public i(InputStream r4) {
        d.h.b.o.e(r4, "input");
        this.f10235b = r4;
        this.f10236c = new ArrayBlockingQueue(1);
        this.f10237d = new AtomicBoolean(false);
        this.f10238e = new AtomicBoolean(false);
        Thread r5 = new Thread(new $$Lambda$i$6YDHuJJydSkc4fIDlIX5qx9sqEQ(this), "SafetyGuardLxcProxyFrameReader");
        r5.setDaemon(true);
        this.f = r5;
    }

    public final void a() {
        if (this.f10237d.compareAndSet(false, true) == false) goto L7;
        this.f.start();
        return;
    L7:
        throw new IllegalStateException("Gateway frame reader already started".toString());
    }

    public static /* synthetic */ com.bytedance.safetyguard.lxc.internal.c.f a(i r0, Long r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return r0.a(r1);
    }

    public final com.bytedance.safetyguard.lxc.internal.c.f a(Long r5) {
        if (r5 != null) goto L5;
        h r4 = (h) ZeusTransformUtils.preCheckCast(this.f10236c.take(), h.class, "com.obric.aiagent.plugin");     // Catch: InterruptedException -> L19
    L8:
        if (ZeusTransformUtils.instanceOf(r4, h.b.class) == false) goto L12;
        return ((h.b) ZeusTransformUtils.preCheckCast(r4, h.b.class, "com.obric.aiagent.plugin")).a();
    L12:
        if (ZeusTransformUtils.instanceOf(r4, h.a.class) == false) goto L16;
        throw ((h.a) ZeusTransformUtils.preCheckCast(r4, h.a.class, "com.obric.aiagent.plugin")).a();
    L16:
        throw new d.k();
    L5:
        r4 = (h) ZeusTransformUtils.preCheckCast(this.f10236c.poll(r5.longValue(), TimeUnit.MILLISECONDS), h.class, "com.obric.aiagent.plugin");     // Catch: InterruptedException -> L19
        if (r4 != null) goto L8;
        throw new j("Timed out waiting for HELLO after " + r5 + " ms");     // Catch: InterruptedException -> L19
    L19:
        e = move-exception;
        Thread.currentThread().interrupt();
        InterruptedIOException r6 = new InterruptedIOException("Interrupted while reading gateway frame");
        r6.initCause((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        throw ((Throwable) ZeusTransformUtils.preCheckCast(r6, Throwable.class, "com.obric.aiagent.plugin"));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f10238e.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.f10236c.offer(new h.a((Exception) ZeusTransformUtils.preCheckCast(new IOException("Gateway frame reader closed"), Exception.class, "com.obric.aiagent.plugin")));
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L8
        ((i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.aiagent.plugin")).f10235b.close();     // Catch: Throwable -> L8
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L8
    L10:
        this.f.interrupt();
        if (this.f == Thread.currentThread()) goto L26;
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L14
        ((i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.aiagent.plugin")).f.join(500);     // Catch: Throwable -> L14
        Object r6 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L14
    L16:
        Throwable r7 = d.n.c(r6);
        if (r7 != null) goto L19;
        return;
    L19:
        if (ZeusTransformUtils.instanceOf(r7, InterruptedException.class) == false) goto L28;
        Thread.currentThread().interrupt();
        return;
    L28:
        return;
    L14:
        th = move-exception;
        d.n.a r0 = d.n.f38560a;
        r6 = d.n.f(d.o.a(th));
        goto L16
    L26:
        return;
    L8:
        th = move-exception;
        d.n.a r3 = d.n.f38560a;
        d.n.f(d.o.a(th));
        goto L10
    }

    private final void b() {
    L4:
        if (this.f10238e.get() == true) goto L24;
        h r1 = (h) ZeusTransformUtils.preCheckCast(new h.b(com.bytedance.safetyguard.lxc.internal.c.g.f9831a.a(this.f10235b)), h.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7
    L18:
        this.f10236c.put(r1);     // Catch: InterruptedException -> L15
        if (ZeusTransformUtils.instanceOf(r1, h.b.class) == false) goto L25;
        if (((h.b) ZeusTransformUtils.preCheckCast(r1, h.b.class, "com.obric.aiagent.plugin")).a() != null) goto L4;
        return;
    L25:
        return;
    L14:
        return;
    L7:
        e = move-exception;
        r1 = (h) ZeusTransformUtils.preCheckCast(new h.a(e), h.class, "com.obric.aiagent.plugin");
        goto L18
    }
}
