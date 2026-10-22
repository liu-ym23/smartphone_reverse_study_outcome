package com.bytedance.safetyguard.lxc.internal.d;

import com.bytedance.safetyguard.lxc.api.ProxySessionErrorCode;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.oui.texteffects.OProtocolTextEffectTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ca;

/* JADX INFO: compiled from: TcpProxyStream.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ah implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ag f10156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Socket f10157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final x f10158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final s f10159d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final t f10160e;
    private final d.h.a.b<Integer, d.x> f;
    private final AtomicBoolean g;
    private final AtomicBoolean h;
    private final ac i;
    private final ca j;

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.d.ah$1, reason: invalid class name */
    /* JADX INFO: compiled from: TcpProxyStream.kt */
    @d.c.b.a.f(b = "TcpProxyStream.kt", c = {36}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.proxy.TcpProxyStream$1")
    static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ah f10162b;

        AnonymousClass1(ah r3, d.c.d<? super AnonymousClass1> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10162b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f10162b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f10161a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            ah r6 = this.f10162b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10161a = 1;
            if (ah.a(r6, r2) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: TcpProxyStream.kt */
    @d.c.b.a.f(b = "TcpProxyStream.kt", c = {ITaskManager.Stub.TRANSACTION_tryActiveAgent}, d = "remoteWriteLoop", e = "com.bytedance.safetyguard.lxc.internal.proxy.TcpProxyStream")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10163a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f10164b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ah f10165c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f10166d;

        a(ah r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10165c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f10164b = r3;
            this.f10166d |= Integer.MIN_VALUE;
            return ah.a(this.f10165c, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: TcpProxyStream.kt */
    static final class b extends d.h.b.p implements d.h.a.b<ab, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OutputStream f10167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ah f10168b;

        b(OutputStream r1, ah r2) {
            this.f10167a = r1;
            this.f10168b = r2;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(ab r3) {
            a((ab) ZeusTransformUtils.preCheckCast(r3, ab.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }

        public final void a(ab r4) {
            ab r5 = (ab) ZeusTransformUtils.wrapperContextForParams(r4, ab.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "command");
            if (ZeusTransformUtils.instanceOf(r5, ab.a.class) == false) goto L6;
            this.f10167a.write(((ab.a) ZeusTransformUtils.preCheckCast(r5, ab.a.class, "com.obric.aiagent.plugin")).a());
            this.f10168b.getContext().b(((ab.a) ZeusTransformUtils.preCheckCast(r5, ab.a.class, "com.obric.aiagent.plugin")).a().length);
            ah.a(this.f10168b).a(this.f10168b.getContext().a(), ((ab.a) ZeusTransformUtils.preCheckCast(r5, ab.a.class, "com.obric.aiagent.plugin")).a().length);
            return;
        L6:
            if (d.h.b.o.a(r5, ab.b.f10111a) == false) goto L23;
            ah r6 = this.f10168b;
            d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L10
            ah.c(r6).shutdownOutput();     // Catch: Throwable -> L10
            Object r7 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L10
        L12:
            ah r1 = this.f10168b;
            Throwable r8 = d.n.c(r7);
            if (r8 != null) goto L15;
        L18:
            this.f10168b.getContext().b(true);
            ah.b(this.f10168b);
            return;
        L15:
            if (ah.a(r1, r8) == true) goto L18;
            throw r8;
        L10:
            th = move-exception;
            d.n.a r2 = d.n.f38560a;
            r7 = d.n.f(d.o.a(th));
            goto L12
        }
    }

    public ah(ag r9, Socket r10, x r11, am r12, s r13, t r14, d.h.a.b<? super Integer, d.x> r15) {
        am r2 = (am) ZeusTransformUtils.wrapperContextForParams(r12, am.class, "com.obric.aiagent.plugin");
        s r16 = (s) ZeusTransformUtils.wrapperContextForParams(r13, s.class, "com.obric.aiagent.plugin");
        d.h.a.b<Integer, d.x> r17 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r15, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "context");
        d.h.b.o.e(r10, "socket");
        d.h.b.o.e(r11, "writer");
        d.h.b.o.e(r2, "streamScope");
        d.h.b.o.e(r16, "logger");
        d.h.b.o.e(r14, "stats");
        d.h.b.o.e(r17, "onClosed");
        this.f10156a = r9;
        this.f10157b = r10;
        this.f10158c = r11;
        this.f10159d = r16;
        this.f10160e = r14;
        this.f = r17;
        boolean r18 = false;
        this.g = new AtomicBoolean(false);
        this.h = new AtomicBoolean(false);
        this.i = new ac(getContext().c());
        if (getContext().b() == com.bytedance.safetyguard.lxc.internal.c.c.f9817e) goto L5;
        r18 = true;
    L5:
        if (r18 == false) goto L9;
        this.j = kotlinx.coroutines.i.a(r2, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L9:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static final /* synthetic */ x a(ah r0) {
        return r0.f10158c;
    }

    public static final /* synthetic */ Object a(ah r2, d.c.d r3) {
        return r2.a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ boolean a(ah r0, Throwable r1) {
        return r0.b(r1);
    }

    public static final /* synthetic */ void b(ah r0) {
        r0.c();
    }

    public static final /* synthetic */ Socket c(ah r0) {
        return r0.f10157b;
    }

    @Override // com.bytedance.safetyguard.lxc.internal.d.w
    public ag getContext() {
        return this.f10156a;
    }

    @Override // com.bytedance.safetyguard.lxc.internal.d.w
    public void a(byte[] r7) {
        d.h.b.o.e(r7, "payload");
        d();
        if (this.h.get() == false) goto L13;
        this.f10160e.a(ProxySessionErrorCode.MALFORMED_FRAME, "DATA after peer HALF_CLOSE: streamId=" + getContext().a());
        a((Throwable) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.c.k("DATA after peer HALF_CLOSE: " + getContext().a(), null, 2, null), Throwable.class, "com.obric.aiagent.plugin"));
        return;
    L13:
        getContext().a(r7.length);     // Catch: Exception -> L10
        this.f10160e.a(r7.length);     // Catch: Exception -> L10
        if (this.i.a(r7) == true) goto L15;
        a((Throwable) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.c.k("Remote write queue is closed: " + getContext().a(), null, 2, null), Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L10
        return;
    L15:
        return;
    L10:
        e = move-exception;
        a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.safetyguard.lxc.internal.d.w
    public void a() {
        if (this.g.get() == false) goto L6;
        return;
    L6:
        if (this.h.compareAndSet(false, true) == true) goto L9;
        return;
    L9:
        if (this.i.a() == false) goto L11;
        return;
    L11:
        if (this.g.get() == true) goto L15;
        a((Throwable) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.c.k("Unable to enqueue HALF_CLOSE: " + getContext().a(), null, 2, null), Throwable.class, "com.obric.aiagent.plugin"));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object a(d.c.d<? super d.x> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r8, a.class, "com.obric.aiagent.plugin");
        if ((r0.f10166d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f10166d -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f10164b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f10166d;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        ah r6 = (ah) ZeusTransformUtils.preCheckCast(r0.f10163a, ah.class, "com.obric.aiagent.plugin");
        d.o.a(r9);     // Catch: Exception -> L20
        ah this = r6;
    L26:
    L25:
        return d.x.f38692a;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        d.o.a(r9);
        OutputStream r10 = this.f10157b.getOutputStream();     // Catch: Exception -> L20
        ac r4 = this.i;     // Catch: Exception -> L20
        d.h.a.b<? super ab, d.x> r11 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new b(r10, this), d.h.a.b.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L20
        r0.f10163a = this;     // Catch: Exception -> L20
        r0.f10166d = 1;     // Catch: Exception -> L20
        Object r12 = r4.a(r11, r0);     // Catch: Exception -> L20
        this = r12;
        if (r12 != r2) goto L26;
        return r2;
    L20:
        e = move-exception;
        if (this.g.get() == true) goto L25;
        this.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L7:
        r0 = new a(this, r8);
        goto L8
    }

    public final void b() {
        byte[] r1 = new byte[32768];
        InputStream r2 = this.f10157b.getInputStream();     // Catch: Exception -> L13 SocketException -> L17
    L5:
        if (this.g.get() == true) goto L33;
        int r3 = r2.read(r1);     // Catch: Exception -> L13 SocketException -> L17
        if (r3 < 0) goto L8;
        if (r3 == 0) goto L5;
        byte[] r7 = Arrays.copyOf(r1, r3);     // Catch: Exception -> L13 SocketException -> L17
        d.h.b.o.c(r7, "copyOf(...)");     // Catch: Exception -> L13 SocketException -> L17
        getContext().c(r7.length);     // Catch: Exception -> L13 SocketException -> L17
        this.f10160e.b(r7.length);     // Catch: Exception -> L13 SocketException -> L17
        this.f10158c.a(new com.bytedance.safetyguard.lxc.internal.c.f(com.bytedance.safetyguard.lxc.internal.c.h.g, getContext().a(), 0, r7, 4, null));     // Catch: Exception -> L13 SocketException -> L17
        goto L5
    L8:
        getContext().a(true);     // Catch: Exception -> L13 SocketException -> L17
        this.f10158c.a(new com.bytedance.safetyguard.lxc.internal.c.f(com.bytedance.safetyguard.lxc.internal.c.h.h, getContext().a(), 0, null, 12, null));     // Catch: Exception -> L13 SocketException -> L17
        c();     // Catch: Exception -> L13 SocketException -> L17
        return;
    L33:
        return;
    L17:
        e = move-exception;
        if (this.g.get() == true) goto L32;
        a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return;
    L32:
        return;
    L13:
        e = move-exception;
        if (this.g.get() == true) goto L30;
        a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return;
    }

    @Override // com.bytedance.safetyguard.lxc.internal.d.w
    public void a(int r1) {
        getContext().d(r1);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.g.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        getContext().f();
        this.i.b();
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L8
        ((ah) ZeusTransformUtils.preCheckCast(this, ah.class, "com.obric.aiagent.plugin")).f10157b.close();     // Catch: Throwable -> L8
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L8
    L10:
        ca.a.a(this.j, null, 1, null);
        this.f10159d.a("TcpProxyStream", "component=proxy_stream event=stream_closed outcome=success streamId=" + getContext().a() + " ingress=" + getContext().b());
        this.f.invoke(Integer.valueOf(getContext().a()));
        return;
    L8:
        th = move-exception;
        d.n.a r1 = d.n.f38560a;
        d.n.f(d.o.a(th));
        goto L10
    }

    private final void a(Throwable r12) {
        if (this.g.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        getContext().f();
        this.i.b();
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L8
        ((ah) ZeusTransformUtils.preCheckCast(this, ah.class, "com.obric.aiagent.plugin")).f10157b.close();     // Catch: Throwable -> L8
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L8
    L10:
        s r1 = this.f10159d;
        StringBuilder r2 = new StringBuilder().append("component=proxy_stream event=stream_reset outcome=failed streamId=").append(getContext().a()).append(" exceptionClass=");
        if (r12 == null) goto L15;
        Class<?> r13 = r12.getClass();
        if (r13 == null) goto L15;
        String r14 = r13.getSimpleName();
    L16:
        if (r14 != null) goto L18;
        r14 = OProtocolTextEffectTextView.EffectNameNone;
    L18:
        r1.a("TcpProxyStream", r2.append(r14).toString());
        this.f10158c.a(getContext().a());
        this.f.invoke(Integer.valueOf(getContext().a()));
        this.f10158c.f(new com.bytedance.safetyguard.lxc.internal.c.f(com.bytedance.safetyguard.lxc.internal.c.h.j, getContext().a(), 0, null, 12, null));
        ca.a.a(this.j, null, 1, null);
        return;
    L15:
        r14 = null;
    L8:
        th = move-exception;
        d.n.a r3 = d.n.f38560a;
        d.n.f(d.o.a(th));
        goto L10
    }

    private final boolean b(Throwable r6) {
        if (ZeusTransformUtils.instanceOf(r6, SocketException.class) == false) goto L15;
        String r5 = r6.getMessage();
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("ENOTCONN", CharSequence.class, "com.obric.aiagent.plugin"), true) == true) goto L14;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("not connected", CharSequence.class, "com.obric.aiagent.plugin"), true) == true) goto L14;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("Socket closed", CharSequence.class, "com.obric.aiagent.plugin"), true) == true) goto L14;
        return false;
    L14:
        return true;
    L15:
        Throwable r7 = r6.getCause();
        if (r7 != null) goto L18;
        return false;
    L18:
        if (b(r7) == true) goto L20;
        return false;
    L20:
        return true;
    }

    private final void c() {
        if (getContext().g() == true) goto L6;
        return;
    L6:
        if (this.g.compareAndSet(false, true) == true) goto L8;
        return;
    L8:
        getContext().f();
        this.i.b();
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L11
        ((ah) ZeusTransformUtils.preCheckCast(this, ah.class, "com.obric.aiagent.plugin")).f10157b.close();     // Catch: Throwable -> L11
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L11
    L13:
        this.f10159d.a("TcpProxyStream", "component=proxy_stream event=stream_closed outcome=success streamId=" + getContext().a() + " ingress=" + getContext().b());
        this.f.invoke(Integer.valueOf(getContext().a()));
        return;
    L11:
        th = move-exception;
        d.n.a r1 = d.n.f38560a;
        d.n.f(d.o.a(th));
        goto L13
    }

    private final void d() {
        if (this.g.get() == true) goto L8;
        if (getContext().e() == true) goto L8;
        return;
    L8:
        throw new com.bytedance.safetyguard.lxc.internal.c.k("Stream is closed: " + getContext().a(), null, 2, null);
    }
}
