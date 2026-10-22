package com.ttnet.org.chromium.net.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
public final class CronetUploadDataStream extends com.ttnet.org.chromium.net.ah {
    private static final String TAG = "CronetUploadDataStream";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f37957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final VersionSafeCallbacks.f f37958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CronetUrlRequest f37959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f37960d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f37961e;
    private long f;
    private volatile boolean g;
    private final Runnable h;
    private ByteBuffer i;
    private final Object j;
    private long k;
    private int l;
    private boolean m;
    private Runnable n;

    interface a {
        long a(CronetUploadDataStream r1, long r2, long r4);

        void a(long r1);

        void a(long r1, CronetUploadDataStream r3);

        void a(long r1, CronetUploadDataStream r3, int r4, boolean r5);
    }

    static {
    }

    static /* synthetic */ Object a(CronetUploadDataStream r0) {
        return r0.j;
    }

    static /* synthetic */ void a(CronetUploadDataStream r0, int r1) {
        r0.a(r1);
    }

    static /* synthetic */ void a(CronetUploadDataStream r0, Throwable r1) {
        r0.a(r1);
    }

    static /* synthetic */ int b(CronetUploadDataStream r0, int r1) {
        r0.l = r1;
        return r1;
    }

    static /* synthetic */ long b(CronetUploadDataStream r2) {
        return r2.k;
    }

    static /* synthetic */ String c() {
        return TAG;
    }

    static /* synthetic */ ByteBuffer c(CronetUploadDataStream r0) {
        return r0.i;
    }

    static /* synthetic */ void d(CronetUploadDataStream r0) {
        r0.d();
    }

    static /* synthetic */ VersionSafeCallbacks.f e(CronetUploadDataStream r0) {
        return r0.f37958b;
    }

    static /* synthetic */ boolean f(CronetUploadDataStream r0) {
        return r0.g;
    }

    public CronetUploadDataStream(com.ttnet.org.chromium.net.ag r3, Executor r4, CronetUrlRequest r5) {
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.aiagent.plugin");
        this.h = new AnonymousClass1(this);
        this.j = new Object();
        this.l = 3;
        this.f37957a = r6;
        this.f37958b = new VersionSafeCallbacks.f(r3);
        this.f37959c = r5;
        this.g = false;
    }

    void readData(ByteBuffer r3) {
        this.i = r3;
        this.f = r3.limit();
        a(this.h);
    }

    void rewind() {
        a(new AnonymousClass2(this));
    }

    private void d() {
        this.f37959c.f();
    }

    private void a(int r4) {
        if (this.l != r4) goto L6;
        return;
    L6:
        throw new IllegalStateException("Expected " + r4 + ", but was " + this.l);
    }

    void onUploadDataStreamDestroyed() {
        e();
    }

    private void a(Throwable r7) {
        Object r0 = this.j;
        monitor-enter(r0);
        int r1 = this.l;     // Catch: Throwable -> L21
        if (r1 == 3) goto L20;
        if (r1 != 2) goto L9;
        boolean r2 = true;
    L10:
        this.l = 3;     // Catch: Throwable -> L21
        this.i = null;     // Catch: Throwable -> L21
        f();     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        if (r2 == true) goto L24;
    L17:
        this.f37959c.a(r7);
        return;
    L24:
        this.f37958b.close();     // Catch: Exception -> L15
        this.g = true;     // Catch: Exception -> L15
    L15:
        e = move-exception;
        com.ttnet.org.chromium.base.j.e(TAG, "Failure closing data provider", new Object[]{e});
        goto L17
    L9:
        r2 = false;
        goto L10
    L20:
        throw new IllegalStateException("There is no read or rewind or length check in progress.");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ah
    public void a(boolean r12) {
        Object r0 = this.j;
        monitor-enter(r0);
        a(0);     // Catch: Throwable -> L30
        if (this.f != this.i.limit()) goto L29;
        if (r12 == true) goto L10;
    L14:
        int r9 = this.i.position();     // Catch: Throwable -> L30
        long r4 = this.f37961e - ((long) r9);     // Catch: Throwable -> L30
        this.f37961e = r4;     // Catch: Throwable -> L30
        if (r4 < 0) goto L17;
    L21:
        this.i.position(0);     // Catch: Throwable -> L30
        this.i = null;     // Catch: Throwable -> L30
        this.l = 3;     // Catch: Throwable -> L30
        f();     // Catch: Throwable -> L30
        if (this.k != 0) goto L25;
        monitor-exit(r0);     // Catch: Throwable -> L30
        return;
    L25:
        l.a().a(this.k, this, r9, r12);     // Catch: Throwable -> L30
        monitor-exit(r0);     // Catch: Throwable -> L30
        return;
    L17:
        if (this.f37960d < 0) goto L21;
        throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", new Object[]{Long.valueOf(this.f37960d - this.f37961e), Long.valueOf(this.f37960d)}));     // Catch: Throwable -> L30
    L10:
        if (this.f37960d < 0) goto L14;
        throw new IllegalArgumentException("Non-chunked upload can't have last chunk");     // Catch: Throwable -> L30
    L29:
        throw new IllegalStateException("ByteBuffer limit changed");     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ah
    public void a() {
        Object r0 = this.j;
        monitor-enter(r0);
        a(1);     // Catch: Throwable -> L12
        this.l = 3;     // Catch: Throwable -> L12
        this.f37961e = this.f37960d;     // Catch: Throwable -> L12
        if (this.k != 0) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L9:
        l.a().a(this.k, this);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ah
    public void a(Exception r3) {
        Object r0 = this.j;
        monitor-enter(r0);
        a(1);     // Catch: Throwable -> L8
        a(r3);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void a(Runnable r3) {
        this.f37957a.execute((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        CronetUrlRequest r2 = this.f37959c;
        if (r2 == null) goto L11;
        r2.a(th);
        return;
    L11:
        throw new IllegalStateException("Unexpected request usage, caught in CronetUploadDataStream, caused by " + th);
    }

    private void e() {
        Object r0 = this.j;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.l != 0) goto L10;
        this.m = true;     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L10:
        if (this.k != 0) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L13:
        l.a().a(this.k);     // Catch: Throwable -> L19
        this.k = 0;     // Catch: Throwable -> L19
        Runnable r1 = this.n;     // Catch: Throwable -> L19
        if (r1 == null) goto L16;
        r1.run();     // Catch: Throwable -> L19
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L19
        a(new AnonymousClass3(this));
    }

    private void f() {
        Object r0 = this.j;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.l == 0) goto L12;
        if (this.m == false) goto L9;
        e();     // Catch: Throwable -> L13
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L12:
        throw new IllegalStateException("Method should not be called when read has not completed.");     // Catch: Throwable -> L13
    }

    void b() {
        Object r0 = this.j;
        monitor-enter(r0);
        this.l = 2;     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        this.f37959c.f();     // Catch: Throwable -> L9
        long r1 = this.f37958b.a();     // Catch: Throwable -> L9
        this.f37960d = r1;     // Catch: Throwable -> L9
        this.f37961e = r1;     // Catch: Throwable -> L9
    L11:
        Object r2 = this.j;
        monitor-enter(r2);
        this.l = 3;     // Catch: Throwable -> L17
        monitor-exit(r2);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    L9:
        th = move-exception;
        a(th);
    L20:
        th = move-exception;
        throw th;
    }

    void a(long r8) {
        Object r0 = this.j;
        monitor-enter(r0);
        this.k = l.a().a(this, r8, this.f37960d);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
