package com.bytedance.common.wschannel.channel.impl.ok.b;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import e.h;
import e.o;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Request;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.ad;
import okhttp3.z;

/* JADX INFO: compiled from: CustomHeartBeatRealWebSocket.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements com.bytedance.common.wschannel.channel.impl.ok.b.b, e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f6830a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<aa> f6831b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.common.wschannel.channel.impl.ok.b.c f6832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ab f6833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Random f6834e;
    private final String f;
    private final Runnable g;
    private final ArrayDeque<h> h;
    private final ArrayDeque<Object> i;
    private final long j;
    private okhttp3.e k;
    private e l;
    private f m;
    private ScheduledExecutorService n;
    private okhttp3.internal.l.a.b o;
    private long p;
    private boolean q;
    private ScheduledFuture<?> r;
    private int s;
    private String t;
    private boolean u;
    private int v;
    private int w;
    private int x;
    private boolean y;

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.channel.impl.ok.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CustomHeartBeatRealWebSocket.java */
    final class RunnableC0155a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f6838a;

        RunnableC0155a(a r1) {
            this.f6838a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6838a.b();
        }
    }

    /* JADX INFO: compiled from: CustomHeartBeatRealWebSocket.java */
    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f6839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h f6840b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f6841c;

        b(int r1, h r2, long r3) {
            this.f6839a = r1;
            this.f6840b = r2;
            this.f6841c = r3;
        }
    }

    /* JADX INFO: compiled from: CustomHeartBeatRealWebSocket.java */
    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f6842a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h f6843b;

        c(int r1, h r2) {
            this.f6842a = r1;
            this.f6843b = r2;
        }
    }

    /* JADX INFO: compiled from: CustomHeartBeatRealWebSocket.java */
    private final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f6844a;

        d(a r1) {
            this.f6844a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6844a.e(h.f38723b);
        }
    }

    static /* synthetic */ com.bytedance.common.wschannel.channel.impl.ok.b.c a(a r0) {
        return r0.f6832c;
    }

    static {
        f6831b = Collections.singletonList(aa.f39695c);
    }

    public a(ab r3, long r4, com.bytedance.common.wschannel.channel.impl.ok.b.c r6, Random r7) {
        this.h = new ArrayDeque();
        this.i = new ArrayDeque();
        this.s = -1;
        if ("GET".equals(r3.b()) == false) goto L7;
        this.f6833d = r3;
        this.f6832c = r6;
        this.f6834e = r7;
        this.j = r4;
        byte[] r5 = new byte[16];
        r7.nextBytes(r5);
        this.f = h.a(r5).e();
        this.g = new AnonymousClass1(this);
        return;
    L7:
        throw new IllegalArgumentException("Request must be GET: " + r3.b());
    }

    public static a a(ab r7, long r8, com.bytedance.common.wschannel.channel.impl.ok.b.c r10) {
        return new a(r7, r8, r10, new Random());
    }

    @Override // okhttp3.ah
    public ab a() {
        return this.f6833d;
    }

    public void b() {
        this.k.c();
    }

    private ab a(ab r6) {
        m.a r0 = m.b();
        if (r0 != null) goto L17;
        return r6;
    L17:
        Map<String, String> r1 = r0.a(r6.a().toString(), r6.c().e());     // Catch: Exception -> L14
        if (r1 != null) goto L8;
        return r6;
    L8:
        ab.a r2 = r6.h();     // Catch: Exception -> L14
        Iterator<Map.Entry<String, String>> r3 = r1.entrySet().iterator();     // Catch: Exception -> L14
    L10:
        if (r3.hasNext() == false) goto L12;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L14
        r2.b((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r4.getValue(), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L14
        goto L10
    L12:
        return r2.b();
    L14:
        e = move-exception;
        Logger.w("tryAddOkWsRequestOpaque failed with exception" + e);
        return r6;
    }

    public void a(z r4) {
        final Request r0 = a(this.f6833d.h().a("Upgrade", "websocket").a("Connection", "Upgrade").a("Sec-WebSocket-Key", this.f).a("Sec-WebSocket-Version", "13").b());
        Call r5 = okhttp3.internal.b.instance.newWebSocketCall(r4, r0);
        this.k = r5;
        r5.a(new AnonymousClass2(this, r0));
    }

    void a(ad r5) {
        if (r5.d() != 101) goto L18;
        String r0 = r5.b("Connection");
        if ("Upgrade".equalsIgnoreCase(r0) == false) goto L16;
        String r1 = r5.b("Upgrade");
        if ("websocket".equalsIgnoreCase(r1) == false) goto L14;
        String r6 = r5.b("Sec-WebSocket-Accept");
        String r4 = h.c(this.f + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").g().e();
        if (r4.equals(r6) == false) goto L12;
        return;
    L12:
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + r4 + "' but was '" + r6 + "'");
    L14:
        throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + r1 + "'");
    L16:
        throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + r0 + "'");
    L18:
        throw new ProtocolException("Expected HTTP 101 response but was '" + r5.d() + " " + r5.c() + "'");
    }

    public void a(String r7, okhttp3.internal.l.a.b r8) {
        monitor-enter(this);
        this.o = r8;     // Catch: Throwable -> L9
        this.m = new f(r8.client, r8.sink, this.f6834e);     // Catch: Throwable -> L9
        this.n = new ScheduledThreadPoolExecutor(1, okhttp3.internal.c.a(r7, false));     // Catch: Throwable -> L9
        if (this.i.isEmpty() == true) goto L6;
        f();     // Catch: Throwable -> L9
    L6:
        monitor-exit(this);     // Catch: Throwable -> L9
        this.l = new e(r8.client, r8.source, this, this.j);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void c() {
    L3:
        if (this.s != (-1)) goto L5;
        this.l.a();
        goto L3
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.b.e.a
    public void a(String r2) {
        com.bytedance.common.wschannel.channel.impl.ok.b.c r0 = this.f6832c;
        if (r0 == null) goto L6;
        r0.a(this, r2);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.b.e.a
    public void a(h r2) {
        com.bytedance.common.wschannel.channel.impl.ok.b.c r0 = this.f6832c;
        if (r0 == null) goto L6;
        r0.a(this, r2);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.b.e.a
    public synchronized void b(h r2) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.u == false) goto L6;
    L13:
        monitor-exit(this);
        return;
    L6:
        if (this.q == true) goto L8;
    L10:
        this.h.add(r2);     // Catch: Throwable -> L15
        f();     // Catch: Throwable -> L15
        this.w++;     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L8:
        if (this.i.isEmpty() == false) goto L10;
        goto L10
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.b.e.a
    public synchronized void c(h r2) {
        monitor-enter(this);
        this.x++;     // Catch: Throwable -> L8
        this.y = false;     // Catch: Throwable -> L8
        com.bytedance.common.wschannel.channel.impl.ok.b.c r0 = this.f6832c;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        r0.b(this, r2);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.b.e.a
    public void a(int r4, String r5) {
        if (r4 == (-1)) goto L32;
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L6:
        if (this.s != (-1)) goto L27;
        this.s = r4;     // Catch: Throwable -> L28
        this.t = r5;     // Catch: Throwable -> L28
        okhttp3.internal.l.a.b r1 = null;
        if (this.q == true) goto L10;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L28
        com.bytedance.common.wschannel.channel.impl.ok.b.c r0 = this.f6832c;     // Catch: Throwable -> L23
        if (r0 == null) goto L21;
        r0.a(this, r4, r5);     // Catch: Throwable -> L23
        if (r1 == null) goto L21;
        this.f6832c.b(this, r4, r5);     // Catch: Throwable -> L23
    L21:
        okhttp3.internal.c.a(r1);
        return;
    L23:
        th = move-exception;
        okhttp3.internal.c.a(r1);
        throw th;
    L10:
        if (this.i.isEmpty() == false) goto L15;
        okhttp3.internal.l.a.b r2 = this.o;     // Catch: Throwable -> L28
        this.o = null;     // Catch: Throwable -> L28
        ScheduledFuture<?> r3 = this.r;     // Catch: Throwable -> L28
        if (r3 == null) goto L14;
        r3.cancel(false);     // Catch: Throwable -> L28
    L14:
        this.n.shutdown();     // Catch: Throwable -> L28
        r1 = r2;
        goto L15
    L27:
        throw new IllegalStateException("already closed");     // Catch: Throwable -> L28
    L32:
        throw new IllegalArgumentException();
    }

    public boolean b(String r2) {
        Objects.requireNonNull(r2, "text == null");
        return a(h.c(r2), 1);
    }

    public boolean d(h r2) {
        Objects.requireNonNull(r2, "bytes == null");
        return a(r2, 2);
    }

    private synchronized boolean a(h r7, int r8) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (this.u == false) goto L6;
    L17:
        monitor-exit(this);
        return false;
    L6:
        if (this.q == true) goto L17;
        if ((this.p + ((long) r7.k())) <= 16777216) goto L13;
        b(1001, null);     // Catch: Throwable -> L19
        monitor-exit(this);
        return false;
    L13:
        this.p += (long) r7.k();     // Catch: Throwable -> L19
        this.i.add(new c(r8, r7));     // Catch: Throwable -> L19
        f();     // Catch: Throwable -> L19
        monitor-exit(this);
        return true;
    }

    public boolean b(int r3, String r4) {
        return a(r3, r4, 60000);
    }

    synchronized boolean a(int r6, String r7, long r8) {
        monitor-enter(this);
        com.bytedance.common.wschannel.channel.impl.ok.b.d.b(r6);     // Catch: Throwable -> L21
        h r0 = null;
        if (r7 == null) goto L11;
        r0 = h.c(r7);     // Catch: Throwable -> L21
        if (r0.k() <= 123) goto L11;
        throw new IllegalArgumentException("reason.size() > 123: " + r7);     // Catch: Throwable -> L21
    L11:
        if (this.u == true) goto L19;
        if (this.q == true) goto L19;
        this.q = true;     // Catch: Throwable -> L21
        this.i.add(new b(r6, r0, r8));     // Catch: Throwable -> L21
        f();     // Catch: Throwable -> L21
        monitor-exit(this);
        return true;
    L19:
        monitor-exit(this);
        return false;
    L21:
        th = move-exception;
        throw th;
    }

    private void f() {
        if (f6830a == false) goto L5;
    L9:
        ScheduledExecutorService r0 = this.n;
        if (r0 == null) goto L13;
        r0.execute(this.g);
        return;
    L13:
        return;
    L5:
        if (Thread.holdsLock(this) == true) goto L9;
        throw new AssertionError();
    }

    boolean d() {
        monitor-enter(this);
    L48:
        th = move-exception;
        throw th;
    L4:
        if (this.u == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L48
        return false;
    L7:
        f r0 = this.m;     // Catch: Throwable -> L48
        h r2 = (h) ZeusTransformUtils.preCheckCast(this.h.poll(), h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L48
        int r3 = -1;
        Object r4 = null;
        if (r2 != null) goto L20;
        Object r5 = this.i.poll();     // Catch: Throwable -> L48
        if (ZeusTransformUtils.instanceOf(r5, b.class) == false) goto L15;
        int r1 = this.s;     // Catch: Throwable -> L48
        String r6 = this.t;     // Catch: Throwable -> L48
        if (r1 == (-1)) goto L14;
        okhttp3.internal.l.a.b r7 = this.o;     // Catch: Throwable -> L48
        this.o = null;     // Catch: Throwable -> L48
        this.n.shutdown();     // Catch: Throwable -> L48
        r4 = r5;
        r3 = r1;
        okhttp3.internal.l.a.b r8 = r7;
    L21:
        monitor-exit(this);     // Catch: Throwable -> L48
        if (r2 == null) goto L25;
        r0.b(r2);     // Catch: Throwable -> L45
    L41:
        okhttp3.internal.c.a(r8);
        return true;
    L25:
        if (ZeusTransformUtils.instanceOf(r4, c.class) == false) goto L35;
        h r9 = ((c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.aiagent.plugin")).f6843b;     // Catch: Throwable -> L45
        e.f r10 = o.a(r0.a(((c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.aiagent.plugin")).f6842a, r9.k()));     // Catch: Throwable -> L45
        r10.c(r9);     // Catch: Throwable -> L45
        r10.close();     // Catch: Throwable -> L45
        monitor-enter(this);     // Catch: Throwable -> L45
        this.p -= (long) r9.k();     // Catch: Throwable -> L31
        monitor-exit(this);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L45
    L35:
        if (ZeusTransformUtils.instanceOf(r4, b.class) == false) goto L44;
        b r11 = (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L45
        r0.a(r11.f6839a, r11.f6840b);     // Catch: Throwable -> L45
        if (r8 == null) goto L41;
        com.bytedance.common.wschannel.channel.impl.ok.b.c r12 = this.f6832c;     // Catch: Throwable -> L45
        if (r12 == null) goto L41;
        r12.b(this, r3, r6);     // Catch: Throwable -> L45
        goto L41
    L44:
        throw new AssertionError();     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        okhttp3.internal.c.a(r8);
        throw th;
    L14:
        this.r = this.n.schedule(new RunnableC0155a(this), ((b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin")).f6841c, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L48
        r3 = r1;
        r8 = null;
    L19:
        r4 = r5;
        goto L21
    L15:
        if (r5 != null) goto L18;
        monitor-exit(this);     // Catch: Throwable -> L48
        return false;
    L18:
        r8 = null;
        r6 = null;
        goto L19
    L20:
        r8 = null;
        r6 = null;
        goto L21
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.b.b
    public void e() {
        ScheduledExecutorService r0 = this.n;
        if (r0 == null) goto L6;
        r0.execute(new d(this));
        return;
    }

    void e(h r6) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (this.u == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L23
        return;
    L7:
        f r0 = this.m;     // Catch: Throwable -> L23
        if (this.y == false) goto L10;
        int r1 = this.v;     // Catch: Throwable -> L23
    L11:
        this.v++;     // Catch: Throwable -> L23
        this.y = true;     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        if (r1 == (-1)) goto L17;
        a(new SocketTimeoutException(WsConstants.PING_NOT_RECEIVE_PONG_MSG), null);
        return;
    L17:
        if (r0 == null) goto L29;
        r0.a(r6);     // Catch: IOException -> L20
        return;
    L20:
        e = move-exception;
        a(e, null);
        return;
    L29:
        return;
    L10:
        r1 = -1;
        goto L11
    }

    public void a(Exception r4, ad r5) {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L4:
        if (this.u == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L7:
        this.u = true;     // Catch: Throwable -> L22
        okhttp3.internal.l.a.b r0 = this.o;     // Catch: Throwable -> L22
        this.o = null;     // Catch: Throwable -> L22
        ScheduledFuture<?> r1 = this.r;     // Catch: Throwable -> L22
        if (r1 == null) goto L10;
        r1.cancel(false);     // Catch: Throwable -> L22
    L10:
        ScheduledExecutorService r2 = this.n;     // Catch: Throwable -> L22
        if (r2 == null) goto L13;
        r2.shutdown();     // Catch: Throwable -> L22
    L13:
        monitor-exit(this);     // Catch: Throwable -> L22
        com.bytedance.common.wschannel.channel.impl.ok.b.c r3 = this.f6832c;     // Catch: Throwable -> L19
        if (r3 == null) goto L17;
        r3.a(this, r4, r5);     // Catch: Throwable -> L19
    L17:
        okhttp3.internal.c.a(r0);
        return;
    L19:
        th = move-exception;
        okhttp3.internal.c.a(r0);
        throw th;
    }

    public void c(int r2, String r3) {
        this.f6832c = null;
        b(r2, r3);     // Catch: Throwable -> L5
        return;
    }
}
