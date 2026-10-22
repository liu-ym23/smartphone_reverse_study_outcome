package com.ttnet.org.chromium.net.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public final class CronetWebsocketConnection extends com.ttnet.org.chromium.net.ae {
    private static final String TAG = "CronetWebsocketConnection";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f38013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.ttnet.org.chromium.net.ae.b f38014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f38015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<String> f38016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f38017e;
    private String f;
    private long g;
    private int h;
    private long i;
    private String j;
    private int k;
    private String l;
    private Map<String, String> m;
    private Map<String, String> n;
    private boolean o;
    private boolean p;
    private final CronetUrlRequestContext q;
    private final Object r;
    private AtomicInteger s;

    interface a {
        long a(CronetWebsocketConnection r1, long r2);

        void a(long r1, CronetWebsocketConnection r3);

        void a(long r1, CronetWebsocketConnection r3, int r4, String r5, long r6, int r8, long r9, String r11, int r12, String r13, boolean r14);

        void a(long r1, CronetWebsocketConnection r3, String r4);

        void a(long r1, CronetWebsocketConnection r3, String r4, String r5);

        void a(long r1, CronetWebsocketConnection r3, ByteBuffer r4);

        void a(long r1, CronetWebsocketConnection r3, boolean r4);

        void b(long r1, CronetWebsocketConnection r3);

        void b(long r1, CronetWebsocketConnection r3, String r4);

        void b(long r1, CronetWebsocketConnection r3, String r4, String r5);
    }

    static {
    }

    static /* synthetic */ com.ttnet.org.chromium.net.ae.b a(CronetWebsocketConnection r0) {
        return r0.f38014b;
    }

    static /* synthetic */ String e() {
        return TAG;
    }

    CronetWebsocketConnection(CronetUrlRequestContext r8, com.ttnet.org.chromium.net.ae.b r9, Executor r10, List<String> r11, int r12, String r13, long r14, int r16, long r17, String r19, int r20, String r21, Map<String, String> r22, Map<String, String> r23, boolean r24) {
        Executor r1 = (Executor) ZeusTransformUtils.wrapperContextForParams(r10, Executor.class, "com.obric.aiagent.plugin");
        List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.aiagent.plugin");
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        this.p = true;
        this.r = new Object();
        this.s = new AtomicInteger(-1);
        this.q = r8;
        this.f38014b = r9;
        this.f38015c = r1;
        this.f38016d = r3;
        this.f38017e = r12;
        this.f = r13;
        this.g = r14;
        this.h = r16;
        this.i = r17;
        this.j = r19;
        this.k = r20;
        this.l = r21;
        this.m = r4;
        this.n = r2;
        this.o = r24;
    }

    CronetWebsocketConnection(CronetUrlRequestContext r3, com.ttnet.org.chromium.net.ae.b r4, Executor r5, List<String> r6, Map<String, String> r7, Map<String, String> r8, boolean r9) {
        Executor r10 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.aiagent.plugin");
        List<String> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        Map<String, String> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        Map<String, String> r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        this.p = true;
        this.r = new Object();
        this.s = new AtomicInteger(-1);
        this.q = r3;
        this.f38014b = r4;
        this.f38015c = r10;
        this.f38016d = r11;
        this.m = r12;
        this.n = r13;
        this.o = r9;
        this.p = false;
    }

    @Override // com.ttnet.org.chromium.net.ae
    public void a() {
        Object r15 = this.r;
        monitor-enter(r15);
    L35:
        th = th;
    L33:
        monitor-exit(r15);     // Catch: Throwable -> L35
        throw th;
    L31:
        th = th;
        goto L33
    L5:
        if (this.f38013a != 0) goto L7;
        this.f38013a = p.a().a(this, this.q.t());     // Catch: Throwable -> L31
    L7:
        Iterator<String> r1 = this.f38016d.iterator();     // Catch: Throwable -> L31
    L9:
        if (r1.hasNext() == false) goto L11;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        p.a().b(this.f38013a, this, r2);     // Catch: Throwable -> L31
        goto L9
    L11:
        Map<String, String> r3 = this.m;     // Catch: Throwable -> L31
        if (r3 == null) goto L17;
        Iterator<Map.Entry<String, String>> r7 = r3.entrySet().iterator();     // Catch: Throwable -> L31
    L15:
        if (r7.hasNext() == false) goto L17;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        p.a().b(this.f38013a, this, (String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r4.getValue(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L31
    L17:
        Map<String, String> r5 = this.n;     // Catch: Throwable -> L31
        if (r5 == null) goto L24;
        Iterator<Map.Entry<String, String>> r8 = r5.entrySet().iterator();     // Catch: Throwable -> L31
    L21:
        if (r8.hasNext() == false) goto L24;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        p.a().a(this.f38013a, this, (String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r6.getValue(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L31
    L24:
        if (this.p == false) goto L28;
        p.a().a(this.f38013a, this, this.f38017e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.o);     // Catch: Throwable -> L35
    L29:
        monitor-exit(r15);     // Catch: Throwable -> L35
        return;
    L28:
        p.a().a(this.f38013a, this, this.o);     // Catch: Throwable -> L35
        goto L29
    }

    @Override // com.ttnet.org.chromium.net.ae
    public void b() {
        Object r0 = this.r;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f38013a != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        p.a().a(this.f38013a, this);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    @Override // com.ttnet.org.chromium.net.ae
    public void a(String r6) {
        Object r0 = this.r;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f38013a != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        p.a().a(this.f38013a, this, r6);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    @Override // com.ttnet.org.chromium.net.ae
    public void a(ByteBuffer r6) {
        Object r0 = this.r;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f38013a != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        p.a().a(this.f38013a, this, r6);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    @Override // com.ttnet.org.chromium.net.ae
    public void d() {
        Object r0 = this.r;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f38013a != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        p.a().b(this.f38013a, this);     // Catch: Throwable -> L11
        this.f38013a = 0;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    @Override // com.ttnet.org.chromium.net.ae
    public boolean c() {
        if (this.s.get() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    private void onConnectionStateChanged(final int r4, final String r5) {
        com.ttnet.org.chromium.base.j.b(TAG, "onConnectionStateChanged: state = " + r4 + ", url = " + r5, new Object[0]);
        this.s.set(r4);
        a(new AnonymousClass1(this, r4, r5));
    }

    private void onConnectionError(final int r4, final String r5, final String r6) {
        com.ttnet.org.chromium.base.j.b(TAG, "onConnectionError: " + r6, new Object[0]);
        this.s.set(r4);
        a(new AnonymousClass2(this, r4, r5, r6));
    }

    private void onMessageReceived(ByteBuffer r4, final int r5) {
        com.ttnet.org.chromium.base.j.a(TAG, "onMessageReceived", new Object[0]);
        final ByteBuffer r6 = b(r4);
        a(new AnonymousClass3(this, r6, r5));
    }

    private void onFeedbackLog(final String r4) {
        com.ttnet.org.chromium.base.j.a(TAG, "OnFeedbackLog", new Object[0]);
        a(new AnonymousClass4(this, r4));
    }

    private void onTrafficChanged(final String r12, final long r13, final long r15, final boolean r17) {
        com.ttnet.org.chromium.base.j.a(TAG, "OnTrafficChanged", new Object[0]);
        a(new AnonymousClass5(this, r12, r13, r15, r17));
    }

    private void a(Runnable r3) {
        this.f38015c.execute((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin"));     // Catch: RejectedExecutionException -> L5
        return;
    L5:
        e = move-exception;
        com.ttnet.org.chromium.base.j.e(TAG, "Exception posting task to executor", new Object[]{e});
    }

    private ByteBuffer b(ByteBuffer r1) {
        ByteBuffer r0 = ByteBuffer.allocate(r1.capacity());
        r1.rewind();
        r0.put(r1);
        r0.flip();
        return r0;
    }
}
