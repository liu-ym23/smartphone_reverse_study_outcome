package com.ttnet.org.chromium.net.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: JavaUploadDataSinkBase.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class r extends com.ttnet.org.chromium.net.ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f38163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f38164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f38165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.ttnet.org.chromium.net.ag f38166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ByteBuffer f38167e;
    private long f;
    private long g;

    public abstract int a(ByteBuffer r1);

    public abstract Runnable a(t.a r1);

    public abstract void a(long r1);

    public abstract void a(Throwable r1);

    public abstract Runnable b(t.a r1);

    public abstract void b();

    public abstract void c();

    static /* synthetic */ long a(r r2, long r3) {
        long r0 = r2.g + r3;
        r2.g = r0;
        return r0;
    }

    static /* synthetic */ ByteBuffer a(r r0) {
        return r0.f38167e;
    }

    static /* synthetic */ ByteBuffer a(r r0, ByteBuffer r1) {
        r0.f38167e = r1;
        return r1;
    }

    static /* synthetic */ void a(r r2, t.a r3) {
        r2.c((t.a) ZeusTransformUtils.wrapperContextForParams(r3, t.a.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ long b(r r2) {
        return r2.f;
    }

    static /* synthetic */ long b(r r0, long r1) {
        r0.f = r1;
        return r1;
    }

    static /* synthetic */ long c(r r2) {
        return r2.g;
    }

    static /* synthetic */ AtomicInteger d(r r0) {
        return r0.f38163a;
    }

    static /* synthetic */ com.ttnet.org.chromium.net.ag e(r r0) {
        return r0.f38166d;
    }

    static /* synthetic */ void f(r r0) {
        r0.d();
    }

    public r(Executor r3, Executor r4, com.ttnet.org.chromium.net.ag r5) {
        final Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.aiagent.plugin");
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.aiagent.plugin");
        this.f38163a = new AtomicInteger(3);
        this.f38164b = new AnonymousClass1(this, r6);
        this.f38165c = r7;
        this.f38166d = r5;
    }

    @Override // com.ttnet.org.chromium.net.ah
    public void a(final boolean r4) {
        if (this.f38163a.compareAndSet(0, 2) == false) goto L7;
        this.f38165c.execute(a(new AnonymousClass2(this, r4)));
        return;
    L7:
        throw new IllegalStateException("onReadSucceeded() called when not awaiting a read result; in state: " + this.f38163a.get());
    }

    @Override // com.ttnet.org.chromium.net.ah
    public void a() {
        if (this.f38163a.compareAndSet(1, 2) == false) goto L7;
        d();
        return;
    L7:
        throw new IllegalStateException("onRewindSucceeded() called when not awaiting a rewind; in state: " + this.f38163a.get());
    }

    @Override // com.ttnet.org.chromium.net.ah
    public void a(Exception r1) {
        a(r1);
    }

    private void d() {
        this.f38165c.execute(a(new AnonymousClass3(this)));
    }

    private void c(t.a r3) {
        t.a r4 = (t.a) ZeusTransformUtils.wrapperContextForParams(r3, t.a.class, "com.obric.aiagent.plugin");
        this.f38164b.execute(b(r4));     // Catch: RejectedExecutionException -> L5
        return;
    L5:
        e = move-exception;
        a(e);
    }

    public void b(final boolean r2) {
        c(new AnonymousClass4(this, r2));
    }
}
