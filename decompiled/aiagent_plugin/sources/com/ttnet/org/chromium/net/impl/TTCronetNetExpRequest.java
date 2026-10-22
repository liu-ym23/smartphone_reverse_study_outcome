package com.ttnet.org.chromium.net.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes4.dex */
public final class TTCronetNetExpRequest extends com.ttnet.org.chromium.net.ac {
    private static final String TAG = "TTCronetNetExpRequest";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CronetUrlRequestContext f38055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f38056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<String> f38057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f38058d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f38059e;
    private int f;
    private final com.ttnet.org.chromium.net.ac.b g;
    private Executor h;
    private long i;
    private boolean j;
    private final Object k;

    interface a {
        long a(TTCronetNetExpRequest r1, long r2, int r4, String[] r5, int r6, int r7, int r8);

        void a(long r1, TTCronetNetExpRequest r3);

        void a(long r1, TTCronetNetExpRequest r3, String r4, String r5);

        void b(long r1, TTCronetNetExpRequest r3);
    }

    static {
    }

    static /* synthetic */ Object a(TTCronetNetExpRequest r0) {
        return r0.k;
    }

    static /* synthetic */ boolean b(TTCronetNetExpRequest r0) {
        return r0.e();
    }

    static /* synthetic */ String c() {
        return TAG;
    }

    static /* synthetic */ void c(TTCronetNetExpRequest r0) {
        r0.d();
    }

    static /* synthetic */ com.ttnet.org.chromium.net.ac.b d(TTCronetNetExpRequest r0) {
        return r0.g;
    }

    public TTCronetNetExpRequest(CronetUrlRequestContext r3, com.ttnet.org.chromium.net.ac.b r4, Executor r5, int r6, List<String> r7, int r8, int r9, int r10) {
        com.ttnet.org.chromium.net.ac.b r11 = (com.ttnet.org.chromium.net.ac.b) ZeusTransformUtils.wrapperContextForParams(r4, com.ttnet.org.chromium.net.ac.b.class, "com.obric.aiagent.plugin");
        Executor r12 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.aiagent.plugin");
        List<String> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        this.k = new Object();
        this.f38055a = r3;
        this.g = r11;
        this.h = r12;
        this.f38056b = r6;
        this.f38057c = r13;
        this.f38058d = r8;
        this.f38059e = r9;
        this.f = r10;
    }

    @Override // com.ttnet.org.chromium.net.ac
    public void a() {
        Object r0 = this.k;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.j == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L8:
        a r1 = ab.a();     // Catch: Throwable -> L15
        long r3 = this.f38055a.t();     // Catch: Throwable -> L15
        int r5 = this.f38056b;     // Catch: Throwable -> L15
        List<String> r2 = this.f38057c;     // Catch: Throwable -> L15
        long r4 = r1.a(this, r3, r5, (String[]) ZeusTransformUtils.preCheckCast(r2.toArray(new String[r2.size()]), String[].class, "com.obric.aiagent.plugin"), this.f38058d, this.f38059e, this.f);     // Catch: Throwable -> L15
        this.i = r4;     // Catch: Throwable -> L15
        if (r4 == 0) goto L14;
        this.j = true;     // Catch: Throwable -> L15
        ab.a().a(this.i, this);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L14:
        throw new NullPointerException("Create native net exp request adapter failed.");     // Catch: Throwable -> L15
    }

    @Override // com.ttnet.org.chromium.net.ac
    public void b() {
        Object r0 = this.k;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (e() == false) goto L7;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L7:
        if (this.j == false) goto L12;
        d();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
    }

    @Override // com.ttnet.org.chromium.net.ac
    public void a(String r9, String r10) {
        Object r0 = this.k;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (e() == false) goto L7;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L7:
        if (this.j == false) goto L12;
        ab.a().a(this.i, this, r9, r10);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
    }

    private void a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        Executor r2 = this.h;     // Catch: RejectedExecutionException -> L8
        if (r2 == null) goto L6;
        r2.execute(r4);     // Catch: RejectedExecutionException -> L8
    L11:
        return;
    L6:
        new Thread(r4, "NetExpCallback").start();     // Catch: RejectedExecutionException -> L8
    L8:
        e = move-exception;
        com.ttnet.org.chromium.base.j.e(TAG, "Exception posting task to executor", new Object[]{e});
    }

    private void d() {
        if (this.i != 0) goto L5;
        return;
    L5:
        ab.a().b(this.i, this);
        this.i = 0;
    }

    private void onNetExpRequestComplete(final String r2, final boolean r3) {
        a(new AnonymousClass1(this, r3, r2));
    }

    private boolean e() {
        if (this.j == true) goto L5;
    L7:
        return false;
    L5:
        if (this.i != 0) goto L7;
        return true;
    }
}
