package com.bytedance.safetyguard.lxc.internal.d;

import com.bytedance.safetyguard.lxc.api.OutboundTarget;
import com.bytedance.safetyguard.lxc.api.ProxySessionCloseReason;
import com.bytedance.safetyguard.lxc.api.ProxySessionErrorCode;
import com.bytedance.safetyguard.lxc.api.SidecarAuthHandler;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.NoRouteToHostException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ao;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.dg;

/* JADX INFO: compiled from: AppGatewayProxySession.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f10194a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InputStream f10195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final r f10196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.b.n f10197d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SidecarAuthHandler f10198e;
    private final com.bytedance.safetyguard.lxc.internal.d.a f;
    private final s g;
    private final n h;
    private final Object i;
    private final Map<Integer, w> j;
    private final Map<Integer, b> k;
    private final HashSet<Integer> l;
    private final HashSet<Integer> m;
    private final ArrayDeque<Integer> n;
    private final int o;
    private final x p;
    private final AtomicBoolean q;
    private final AtomicReference<aj> r;
    private final t s;
    private volatile com.bytedance.safetyguard.lxc.internal.d.i t;
    private volatile int u;
    private volatile String v;
    private final kotlinx.coroutines.z w;
    private final am x;

    /* JADX INFO: compiled from: AppGatewayProxySession.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AppGatewayProxySession.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ca f10199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicReference<Socket> f10200b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final AtomicBoolean f10201c;

        public b() {
            this.f10200b = new AtomicReference();
            this.f10201c = new AtomicBoolean(false);
        }

        public final ca a() {
            ca r0 = this.f10199a;
            if (r0 == null) goto L5;
            return r0;
        L5:
            d.h.b.o.c("job");
            return null;
        }

        public final void a(ca r3) {
            ca r4 = (ca) ZeusTransformUtils.wrapperContextForParams(r3, ca.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "<set-?>");
            this.f10199a = r4;
        }

        public final void a(Socket r5) {
            d.h.b.o.e(r5, "candidate");
            if (this.f10201c.get() == true) goto L31;
            Socket r1 = (Socket) ZeusTransformUtils.preCheckCast(this.f10200b.getAndSet(r5), Socket.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L12;
            if (r1 == r5) goto L12;
            d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L9
            b r4 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
            r1.close();     // Catch: Throwable -> L9
            d.n.f(d.x.f38692a);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            d.n.a r6 = d.n.f38560a;
            d.n.f(d.o.a(th));
        L12:
            if (this.f10201c.get() == true) goto L14;
            return;
        L14:
            if (this.f10200b.compareAndSet(r5, null) == false) goto L35;
            d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L18
            b r7 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
            r5.close();     // Catch: Throwable -> L18
            d.n.f(d.x.f38692a);     // Catch: Throwable -> L18
        L21:
            throw new o();
        L18:
            th = move-exception;
            d.n.a r8 = d.n.f38560a;
            d.n.f(d.o.a(th));
            goto L21
        L35:
            return;
        L31:
            d.n.a r9 = d.n.f38560a;     // Catch: Throwable -> L25
            b r10 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
            r5.close();     // Catch: Throwable -> L25
            d.n.f(d.x.f38692a);     // Catch: Throwable -> L25
        L28:
            throw new o();
        L25:
            th = move-exception;
            d.n.a r11 = d.n.f38560a;
            d.n.f(d.o.a(th));
            goto L28
        }

        public final void b(Socket r2) {
            d.h.b.o.e(r2, "connected");
            this.f10200b.compareAndSet(r2, null);
        }

        public final void b() {
            if (this.f10201c.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            Socket r0 = (Socket) ZeusTransformUtils.preCheckCast(this.f10200b.getAndSet(null), Socket.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L15;
            d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L9
            b r3 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
            r0.close();     // Catch: Throwable -> L9
            Object r4 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L9
        L11:
            d.n.g(r4);
            return;
        L9:
            th = move-exception;
            d.n.a r2 = d.n.f38560a;
            r4 = d.n.f(d.o.a(th));
            goto L11
        }

        public final void c() {
            b();
            if (this.f10199a == null) goto L6;
            ca.a.a(a(), null, 1, null);
            return;
        }
    }

    /* JADX INFO: compiled from: AppGatewayProxySession.kt */
    private static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f10202a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f10203b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f10204c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ c[] f10205d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f10206e = null;

        private static final /* synthetic */ c[] a() {
            return new c[]{f10202a, f10203b, f10204c};
        }

        public static c valueOf(String r2) {
            return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
        }

        public static c[] values() {
            return (c[]) ZeusTransformUtils.preCheckCast(f10205d.clone(), c[].class, "com.obric.aiagent.plugin");
        }

        private c(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f10202a = new c("RESERVED", 0);
            f10203b = new c("RESOURCE_EXHAUSTED", 1);
            f10204c = new c("CLOSED", 2);
            c[] r0 = a();
            f10205d = r0;
            f10206e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AppGatewayProxySession.kt */
    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10207a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f10208b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f10209c = null;

        static {
            int[] r0 = new int[com.bytedance.safetyguard.lxc.internal.c.a.values().length];
            r0[com.bytedance.safetyguard.lxc.internal.c.a.f9810d.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L4:
            f10207a = r0;
            int[] r1 = new int[com.bytedance.safetyguard.lxc.internal.c.h.values().length];
            r1[com.bytedance.safetyguard.lxc.internal.c.h.f9836e.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L41:
            r1[com.bytedance.safetyguard.lxc.internal.c.h.g.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L53:
            r1[com.bytedance.safetyguard.lxc.internal.c.h.h.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L55:
            r1[com.bytedance.safetyguard.lxc.internal.c.h.k.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L57:
            r1[com.bytedance.safetyguard.lxc.internal.c.h.i.ordinal()] = 5;     // Catch: NoSuchFieldError -> L28
        L39:
            r1[com.bytedance.safetyguard.lxc.internal.c.h.j.ordinal()] = 6;     // Catch: NoSuchFieldError -> L29
        L49:
            r1[com.bytedance.safetyguard.lxc.internal.c.h.f9835d.ordinal()] = 7;     // Catch: NoSuchFieldError -> L30
        L61:
            r1[com.bytedance.safetyguard.lxc.internal.c.h.f9833b.ordinal()] = 8;     // Catch: NoSuchFieldError -> L31
        L43:
            r1[com.bytedance.safetyguard.lxc.internal.c.h.f9834c.ordinal()] = 9;     // Catch: NoSuchFieldError -> L32
        L45:
            r1[com.bytedance.safetyguard.lxc.internal.c.h.f.ordinal()] = 10;     // Catch: NoSuchFieldError -> L33
        L17:
            f10208b = r1;
            int[] r2 = new int[c.values().length];
            r2[c.f10204c.ordinal()] = 1;     // Catch: NoSuchFieldError -> L34
        L37:
            r2[c.f10203b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L35
        L47:
            r2[c.f10202a.ordinal()] = 3;     // Catch: NoSuchFieldError -> L36
        L21:
            f10209c = r2;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.d.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppGatewayProxySession.kt */
    @d.c.b.a.f(b = "AppGatewayProxySession.kt", c = {895}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.proxy.AppGatewayProxySession$awaitTerminated$jobsTerminated$1")
    static final class C0232e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f10211b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f10212c;

        /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.d.e$e$1, reason: invalid class name */
        /* JADX INFO: compiled from: AppGatewayProxySession.kt */
        @d.c.b.a.f(b = "AppGatewayProxySession.kt", c = {895}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.proxy.AppGatewayProxySession$awaitTerminated$jobsTerminated$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f10213a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ e f10214b;

            AnonymousClass1(e r3, d.c.d<? super AnonymousClass1> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f10214b = r3;
                super(2, r5);
            }

            public final Object a(am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f10214b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r5) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f10213a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r5);
            L12:
                return d.x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r5);
                kotlinx.coroutines.z r6 = e.a(this.f10214b);
                d.c.d<? super d.x> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f10213a = 1;
                if (r6.b(r2) != r0) goto L12;
                return r0;
            }
        }

        C0232e(e r3, long r4, d.c.d<? super C0232e> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10211b = r3;
            this.f10212c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((C0232e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0232e.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0232e(this.f10211b, this.f10212c, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f10210a;
            boolean r2 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L11:
            if (r7 != null) goto L15;
            r2 = false;
        L15:
            return d.c.b.a.b.a(r2);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            long r3 = e.a(this.f10211b, this.f10212c);
            d.h.a.m r8 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f10211b, null), d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10210a = 1;
            r7 = dg.b(r3, r8, r4);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AppGatewayProxySession.kt */
    @d.c.b.a.f(b = "AppGatewayProxySession.kt", c = {}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.proxy.AppGatewayProxySession$connectTcp$1")
    static final class f extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ah f10216b;

        f(ah r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10216b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f10216b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f10215a != 0) goto L7;
            d.o.a(r2);
            this.f10216b.b();
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AppGatewayProxySession.kt */
    static final class g extends d.h.b.p implements d.h.a.b<Socket, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f10217a;

        g(b r1) {
            this.f10217a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(Socket r3) {
            a((Socket) ZeusTransformUtils.preCheckCast(r3, Socket.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }

        public final void a(Socket r2) {
            d.h.b.o.e(r2, "candidate");
            this.f10217a.a(r2);
        }
    }

    /* JADX INFO: compiled from: AppGatewayProxySession.kt */
    /* synthetic */ class h extends d.h.b.l implements d.h.a.b<Integer, d.x> {
        h(Object r8) {
            super(1, r8, e.class, "onStreamClosed", "onStreamClosed(I)V", 0);
        }

        public final void a(int r3) {
            e.a((e) ZeusTransformUtils.preCheckCast(this.receiver, e.class, "com.obric.aiagent.plugin"), r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(Integer r3) {
            a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue());
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: AppGatewayProxySession.kt */
    /* synthetic */ class i extends d.h.b.l implements d.h.a.b<Integer, d.x> {
        i(Object r8) {
            super(1, r8, e.class, "onStreamClosed", "onStreamClosed(I)V", 0);
        }

        public final void a(int r3) {
            e.a((e) ZeusTransformUtils.preCheckCast(this.receiver, e.class, "com.obric.aiagent.plugin"), r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(Integer r3) {
            a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue());
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: AppGatewayProxySession.kt */
    @d.c.b.a.f(b = "AppGatewayProxySession.kt", c = {}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.proxy.AppGatewayProxySession$openTcp$1")
    static final class j extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f10219b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f10220c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.c.d f10221d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.b.q f10222e;
        final /* synthetic */ b f;

        j(e r3, int r4, com.bytedance.safetyguard.lxc.internal.c.d r5, com.bytedance.safetyguard.lxc.internal.b.q r6, b r7, d.c.d<? super j> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10219b = r3;
            this.f10220c = r4;
            this.f10221d = r5;
            this.f10222e = r6;
            this.f = r7;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new j(this.f10219b, this.f10220c, this.f10221d, this.f10222e, this.f, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f10218a != 0) goto L14;
            d.o.a(r5);
            e.a(this.f10219b, this.f10220c, this.f10221d, this.f10222e, this.f);     // Catch: Exception -> L7 CancellationException -> L11
        L10:
            return d.x.f38692a;
        L11:
            e = move-exception;
            throw e;
        L7:
            e = move-exception;
            e.a(this.f10219b, e);
            goto L10
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AppGatewayProxySession.kt */
    static final class k extends d.h.b.p implements d.h.a.b<Throwable, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f10223a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f10224b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f10225c;

        k(e r1, int r2, b r3) {
            this.f10223a = r1;
            this.f10224b = r2;
            this.f10225c = r3;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(Throwable r3) {
            a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }

        public final void a(Throwable r2) {
            e.a(this.f10223a, this.f10224b, this.f10225c);
        }
    }

    /* JADX INFO: compiled from: AppGatewayProxySession.kt */
    static final class l extends d.h.b.p implements d.h.a.m<Long, Integer, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f10226a;

        l(e r1) {
            this.f10226a = r1;
            super(2);
        }

        @Override // d.h.a.m
        public /* synthetic */ d.x invoke(Long r5, Integer r6) {
            a(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).longValue(), ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).intValue());
            return d.x.f38692a;
        }

        public final void a(long r5, int r7) {
            e.b(this.f10226a).a(ProxySessionErrorCode.PENDING_BYTES_EXCEEDED, "Pending writer bytes exceeded: pending=" + r5 + ", requested=" + r7 + ", max=" + e.c(this.f10226a).d());
        }
    }

    static {
        f10194a = new a(null);
    }

    public e(InputStream r18, OutputStream r19, r r20, com.bytedance.safetyguard.lxc.internal.b.n r21, SidecarAuthHandler r22, com.bytedance.safetyguard.lxc.internal.d.a r23, s r24, am r25, n r26) {
        com.bytedance.safetyguard.lxc.internal.b.n r4 = (com.bytedance.safetyguard.lxc.internal.b.n) ZeusTransformUtils.wrapperContextForParams(r21, com.bytedance.safetyguard.lxc.internal.b.n.class, "com.obric.aiagent.plugin");
        SidecarAuthHandler r6 = (SidecarAuthHandler) ZeusTransformUtils.wrapperContextForParams(r22, SidecarAuthHandler.class, "com.obric.aiagent.plugin");
        s r14 = (s) ZeusTransformUtils.wrapperContextForParams(r24, s.class, "com.obric.aiagent.plugin");
        am r7 = (am) ZeusTransformUtils.wrapperContextForParams(r25, am.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r18, "input");
        d.h.b.o.e(r19, "output");
        d.h.b.o.e(r20, "config");
        d.h.b.o.e(r4, "targetResolver");
        d.h.b.o.e(r6, "sidecarAuthHandler");
        d.h.b.o.e(r14, "logger");
        d.h.b.o.e(r7, "parentScope");
        d.h.b.o.e(r26, "addressConnector");
        this.f10195b = r18;
        this.f10196c = r20;
        this.f10197d = r4;
        this.f10198e = r6;
        this.f = r23;
        this.g = r14;
        this.h = r26;
        this.i = new Object();
        this.j = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        this.k = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        this.l = new HashSet();
        this.m = new HashSet();
        this.n = new ArrayDeque();
        this.o = Math.max(r20.e() * 4, 256);
        this.p = new x(r19, r20.d(), 0, (d.h.a.m) ZeusTransformUtils.preCheckCast(new l(this), d.h.a.m.class, "com.obric.aiagent.plugin"), null, r14, 20, null);
        this.q = new AtomicBoolean(false);
        this.r = new AtomicReference(null);
        this.s = new t();
        this.u = r20.c();
        this.v = "pending";
        kotlinx.coroutines.z r1 = cx.a((ca) ZeusTransformUtils.preCheckCast(r7.a().get((d.c.g.c) ZeusTransformUtils.preCheckCast(ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin")), ca.class, "com.obric.aiagent.plugin"));
        this.w = r1;
        this.x = an.a(r7.a().plus((d.c.g) ZeusTransformUtils.preCheckCast(r1, d.c.g.class, "com.obric.aiagent.plugin")));
    }

    public static final /* synthetic */ long a(e r0, long r1) {
        return r0.c(r1);
    }

    public static final /* synthetic */ kotlinx.coroutines.z a(e r0) {
        return r0.w;
    }

    public static final /* synthetic */ void a(e r0, int r1) {
        r0.c(r1);
    }

    public static final /* synthetic */ void a(e r0, int r1, com.bytedance.safetyguard.lxc.internal.c.d r2, com.bytedance.safetyguard.lxc.internal.b.q r3, b r4) {
        r0.a(r1, r2, r3, r4);
    }

    public static final /* synthetic */ void a(e r0, int r1, b r2) {
        r0.b(r1, r2);
    }

    public static final /* synthetic */ void a(e r0, Exception r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ t b(e r0) {
        return r0.s;
    }

    public static final /* synthetic */ r c(e r0) {
        return r0.f10196c;
    }

    public /* synthetic */ e(InputStream r14, OutputStream r15, r r16, com.bytedance.safetyguard.lxc.internal.b.n r17, SidecarAuthHandler r18, com.bytedance.safetyguard.lxc.internal.d.a r19, s r20, am r21, n r22, int r23, d.h.b.h r24) {
        com.bytedance.safetyguard.lxc.internal.b.n r7 = (com.bytedance.safetyguard.lxc.internal.b.n) ZeusTransformUtils.wrapperContextForParams(r17, com.bytedance.safetyguard.lxc.internal.b.n.class, "com.obric.aiagent.plugin");
        SidecarAuthHandler r8 = (SidecarAuthHandler) ZeusTransformUtils.wrapperContextForParams(r18, SidecarAuthHandler.class, "com.obric.aiagent.plugin");
        s r1 = (s) ZeusTransformUtils.wrapperContextForParams(r20, s.class, "com.obric.aiagent.plugin");
        am r3 = (am) ZeusTransformUtils.wrapperContextForParams(r21, am.class, "com.obric.aiagent.plugin");
        if ((r23 & 32) == 0) goto L5;
        com.bytedance.safetyguard.lxc.internal.d.a r9 = null;
    L7:
        if ((r23 & 64) == 0) goto L9;
        r1 = (s) ZeusTransformUtils.preCheckCast(com.bytedance.safetyguard.lxc.internal.d.c.f10185a, s.class, "com.obric.aiagent.plugin");
    L9:
        s r10 = r1;
        if ((r23 & 128) == 0) goto L12;
        am r11 = an.a(cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")));
    L14:
        if ((r23 & 256) == 0) goto L16;
        n r12 = new n(null, null, 3, null);
    L17:
        this(r14, r15, r16, r7, r8, r9, r10, r11, r12);
        return;
    L16:
        r12 = r22;
        goto L17
    L12:
        r11 = r3;
        goto L14
    L5:
        r9 = r19;
        goto L7
    }

    public final com.bytedance.safetyguard.lxc.internal.d.f a(d.h.a.b<? super com.bytedance.safetyguard.lxc.internal.d.d, d.x> r21) {
        d.h.a.b r2 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r21, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "onHandshake");
        long r4 = System.nanoTime();
        d.h.b.z.a r6 = new d.h.b.z.a();
        com.bytedance.safetyguard.lxc.internal.d.i r7 = new com.bytedance.safetyguard.lxc.internal.d.i(this.f10195b);     // Catch: Throwable -> L34 Exception -> L36 IOException -> L46 com.bytedance.safetyguard.lxc.internal.c.k -> L59 y -> L82 com.bytedance.safetyguard.lxc.internal.d.j -> L95
        r7.a();     // Catch: Throwable -> L34 Exception -> L36 IOException -> L46 com.bytedance.safetyguard.lxc.internal.c.k -> L59 y -> L82 com.bytedance.safetyguard.lxc.internal.d.j -> L95
        this.t = r7;     // Catch: Throwable -> L34 Exception -> L36 IOException -> L46 com.bytedance.safetyguard.lxc.internal.c.k -> L59 y -> L82 com.bytedance.safetyguard.lxc.internal.d.j -> L95
        com.bytedance.safetyguard.lxc.internal.c.f r8 = r7.a(Long.valueOf(this.f10196c.b()));     // Catch: Throwable -> L34 Exception -> L36 IOException -> L46 com.bytedance.safetyguard.lxc.internal.c.k -> L59 y -> L82 com.bytedance.safetyguard.lxc.internal.d.j -> L95
        if (r8 != null) goto L15;
        String r9 = "Gateway closed before HELLO";
        s.a.a(this.g, "AppGatewayProxySession", "component=proxy event=handshake_aborted outcome=failed reason=peer_closed_before_hello", null, 4, null);     // Catch: Throwable -> L34 Exception -> L36 IOException -> L46 com.bytedance.safetyguard.lxc.internal.c.k -> L59 y -> L82 com.bytedance.safetyguard.lxc.internal.d.j -> L95
        aj r10 = a(ProxySessionCloseReason.HANDSHAKE_FAILED, ProxySessionErrorCode.NETWORK_ERROR, "Gateway closed before HELLO");     // Catch: Throwable -> L34 Exception -> L36 IOException -> L46 com.bytedance.safetyguard.lxc.internal.c.k -> L59 y -> L82 com.bytedance.safetyguard.lxc.internal.d.j -> L95
        if (r10.a() != ProxySessionCloseReason.HANDSHAKE_FAILED) goto L107;
        ProxySessionErrorCode r11 = r10.b();     // Catch: Throwable -> L34 Exception -> L36 IOException -> L46 com.bytedance.safetyguard.lxc.internal.c.k -> L59 y -> L82 com.bytedance.safetyguard.lxc.internal.d.j -> L95
        if (r11 != null) goto L10;
        r11 = ProxySessionErrorCode.NETWORK_ERROR;     // Catch: Throwable -> L34 Exception -> L36 IOException -> L46 com.bytedance.safetyguard.lxc.internal.c.k -> L59 y -> L82 com.bytedance.safetyguard.lxc.internal.d.j -> L95
    L10:
        String r12 = r10.c();     // Catch: Throwable -> L34 Exception -> L36 IOException -> L46 com.bytedance.safetyguard.lxc.internal.c.k -> L59 y -> L82 com.bytedance.safetyguard.lxc.internal.d.j -> L95
        if (r12 == null) goto L14;
        r9 = r12;
    L14:
        a(r6, this, r2, (com.bytedance.safetyguard.lxc.internal.d.d) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.d.d.a(r11, r9), com.bytedance.safetyguard.lxc.internal.d.d.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L34 Exception -> L36 IOException -> L46 com.bytedance.safetyguard.lxc.internal.c.k -> L59 y -> L82 com.bytedance.safetyguard.lxc.internal.d.j -> L95
    L107:
        b(r4);
        aj r3 = (aj) ZeusTransformUtils.preCheckCast(this.r.get(), aj.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L111;
        r3 = a(ProxySessionCloseReason.INTERNAL_ERROR, ProxySessionErrorCode.NETWORK_ERROR, "Proxy session ended without a terminal classification");
    L111:
        return new com.bytedance.safetyguard.lxc.internal.d.f(r3.a(), r3.b(), r3.c(), this.s.c());
    L15:
        com.bytedance.safetyguard.lxc.internal.c.j r13 = com.bytedance.safetyguard.lxc.internal.c.b.f9812a.a(com.bytedance.safetyguard.lxc.internal.c.b.f9812a.a(r8));     // Catch: Throwable -> L34 Exception -> L36 IOException -> L46 com.bytedance.safetyguard.lxc.internal.c.k -> L59 y -> L82 com.bytedance.safetyguard.lxc.internal.d.j -> L95
        this.v = this.g.a(r13.a());     // Catch: Throwable -> L34 Exception -> L36 IOException -> L46 com.bytedance.safetyguard.lxc.internal.c.k -> L59 y -> L82 com.bytedance.safetyguard.lxc.internal.d.j -> L95
        this.u = r13.e();     // Catch: Throwable -> L34 Exception -> L36 IOException -> L46 com.bytedance.safetyguard.lxc.internal.c.k -> L59 y -> L82 com.bytedance.safetyguard.lxc.internal.d.j -> L95
        this.p.c(new com.bytedance.safetyguard.lxc.internal.c.f(com.bytedance.safetyguard.lxc.internal.c.h.f9834c, 0, 0, com.bytedance.safetyguard.lxc.internal.c.b.f9812a.a(r13), 4, null));     // Catch: Throwable -> L34 Exception -> L36 IOException -> L46 com.bytedance.safetyguard.lxc.internal.c.k -> L59 y -> L82 com.bytedance.safetyguard.lxc.internal.d.j -> L95
        if (r13.i() == true) goto L25;
        String r14 = r13.h();     // Catch: Throwable -> L34 Exception -> L36 IOException -> L46 com.bytedance.safetyguard.lxc.internal.c.k -> L59 y -> L82 com.bytedance.safetyguard.lxc.internal.d.j -> L95
        if (r14 != null) goto L21;
        r14 = "HELLO negotiation failed";
    L21:
        if (d.f10207a[r13.g().ordinal()] != 1) goto L23;
        ProxySessionErrorCode r15 = ProxySessionErrorCode.REQUIRED_FEATURE_MISSING;     // Catch: Throwable -> L34 Exception -> L36 IOException -> L46 com.bytedance.safetyguard.lxc.internal.c.k -> L59 y -> L82 com.bytedance.safetyguard.lxc.internal.d.j -> L95
    L24:
        a(ProxySessionCloseReason.HANDSHAKE_FAILED, r15, r14);     // Catch: Throwable -> L34 Exception -> L36 IOException -> L46 com.bytedance.safetyguard.lxc.internal.c.k -> L59 y -> L82 com.bytedance.safetyguard.lxc.internal.d.j -> L95
        a(r6, this, r2, (com.bytedance.safetyguard.lxc.internal.d.d) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.d.d.a(r15, r14), com.bytedance.safetyguard.lxc.internal.d.d.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L34 Exception -> L36 IOException -> L46 com.bytedance.safetyguard.lxc.internal.c.k -> L59 y -> L82 com.bytedance.safetyguard.lxc.internal.d.j -> L95
        goto L107
    L23:
        r15 = ProxySessionErrorCode.MALFORMED_FRAME;     // Catch: Throwable -> L34 Exception -> L36 IOException -> L46 com.bytedance.safetyguard.lxc.internal.c.k -> L59 y -> L82 com.bytedance.safetyguard.lxc.internal.d.j -> L95
        goto L24
    L25:
        a(r6, this, r2, (com.bytedance.safetyguard.lxc.internal.d.d) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.d.d.b(r13.a(), r13.b(), r13.c(), r13.d(), r13.e()), com.bytedance.safetyguard.lxc.internal.d.d.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L34 Exception -> L36 IOException -> L46 com.bytedance.safetyguard.lxc.internal.c.k -> L59 y -> L82 com.bytedance.safetyguard.lxc.internal.d.j -> L95
    L27:
        if (this.q.get() == true) goto L107;
        com.bytedance.safetyguard.lxc.internal.c.f r16 = com.bytedance.safetyguard.lxc.internal.d.i.a(r7, null, 1, null);     // Catch: Throwable -> L34 Exception -> L36 IOException -> L46 com.bytedance.safetyguard.lxc.internal.c.k -> L59 y -> L82 com.bytedance.safetyguard.lxc.internal.d.j -> L95
        if (r16 == null) goto L32;
        if (a(r16) == true) goto L27;
    L32:
        a(ProxySessionCloseReason.GATEWAY_CLOSED, null, null);     // Catch: Throwable -> L34 Exception -> L36 IOException -> L46 com.bytedance.safetyguard.lxc.internal.c.k -> L59 y -> L82 com.bytedance.safetyguard.lxc.internal.d.j -> L95
    L34:
        th = move-exception;
        b(r4);
        throw th;
    L36:
        e = move-exception;
        aj r17 = a(ProxySessionCloseReason.INTERNAL_ERROR, ProxySessionErrorCode.NETWORK_ERROR, e.getMessage());     // Catch: Throwable -> L34
        if (r6.f38499a == true) goto L107;
        if (r17.a() != ProxySessionCloseReason.INTERNAL_ERROR) goto L107;
        ProxySessionErrorCode r18 = ProxySessionErrorCode.NETWORK_ERROR;     // Catch: Throwable -> L34
        String r19 = r17.c();     // Catch: Throwable -> L34
        if (r19 != null) goto L45;
        r19 = "Proxy session failed";
    L45:
        a(r6, this, r2, (com.bytedance.safetyguard.lxc.internal.d.d) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.d.d.a(r18, r19), com.bytedance.safetyguard.lxc.internal.d.d.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L34
    L82:
        e = move-exception;
        if (r6.f38499a == false) goto L86;
        ProxySessionCloseReason r20 = ProxySessionCloseReason.IO_ERROR;     // Catch: Throwable -> L34
    L87:
        aj r22 = a(r20, ProxySessionErrorCode.NETWORK_ERROR, e.getMessage());     // Catch: Throwable -> L34
        if (r6.f38499a == true) goto L107;
        if (r22.a() != ProxySessionCloseReason.HANDSHAKE_FAILED) goto L107;
        ProxySessionErrorCode r23 = ProxySessionErrorCode.NETWORK_ERROR;     // Catch: Throwable -> L34
        String r24 = r22.c();     // Catch: Throwable -> L34
        if (r24 != null) goto L94;
        r24 = "HELLO_ACK commit failed";
    L94:
        a(r6, this, r2, (com.bytedance.safetyguard.lxc.internal.d.d) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.d.d.a(r23, r24), com.bytedance.safetyguard.lxc.internal.d.d.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L34
        goto L107
    L86:
        r20 = ProxySessionCloseReason.HANDSHAKE_FAILED;     // Catch: Throwable -> L34
    L46:
        e = move-exception;
        if (r6.f38499a == false) goto L50;
        ProxySessionCloseReason r25 = ProxySessionCloseReason.IO_ERROR;     // Catch: Throwable -> L34
    L51:
        aj r26 = a(r25, ProxySessionErrorCode.NETWORK_ERROR, e.getMessage());     // Catch: Throwable -> L34
        if (r6.f38499a == true) goto L107;
        if (r26.a() != ProxySessionCloseReason.HANDSHAKE_FAILED) goto L107;
        ProxySessionErrorCode r27 = ProxySessionErrorCode.NETWORK_ERROR;     // Catch: Throwable -> L34
        String r28 = r26.c();     // Catch: Throwable -> L34
        if (r28 != null) goto L58;
        r28 = "Gateway I/O failed during HELLO";
    L58:
        a(r6, this, r2, (com.bytedance.safetyguard.lxc.internal.d.d) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.d.d.a(r27, r28), com.bytedance.safetyguard.lxc.internal.d.d.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L34
        goto L107
    L50:
        r25 = ProxySessionCloseReason.HANDSHAKE_FAILED;     // Catch: Throwable -> L34
    L59:
        e = move-exception;
        if (r6.f38499a == false) goto L63;
        ProxySessionCloseReason r29 = ProxySessionCloseReason.PROTOCOL_ERROR;     // Catch: Throwable -> L34
    L65:
        if (this.s.c().e() != ProxySessionErrorCode.PENDING_BYTES_EXCEEDED) goto L67;
        ProxySessionErrorCode r30 = ProxySessionErrorCode.PENDING_BYTES_EXCEEDED;     // Catch: Throwable -> L34
    L68:
        aj r31 = a(r29, r30, e.getMessage());     // Catch: Throwable -> L34
        if (r31.a() != r29) goto L72;
        this.g.a("AppGatewayProxySession", "component=proxy event=protocol_violation outcome=failed exceptionClass=" + e.getClass().getSimpleName(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L34
        this.p.f(new com.bytedance.safetyguard.lxc.internal.c.f(com.bytedance.safetyguard.lxc.internal.c.h.f9835d, 0, 0, new com.bytedance.safetyguard.lxc.internal.c.e(a(e)).a(), 4, null));     // Catch: Throwable -> L34
    L72:
        if (r6.f38499a == true) goto L107;
        if (r31.a() != ProxySessionCloseReason.HANDSHAKE_FAILED) goto L107;
        ProxySessionErrorCode r32 = r31.b();     // Catch: Throwable -> L34
        if (r32 != null) goto L78;
        r32 = ProxySessionErrorCode.MALFORMED_FRAME;     // Catch: Throwable -> L34
    L78:
        String r33 = r31.c();     // Catch: Throwable -> L34
        if (r33 != null) goto L81;
        r33 = "Invalid HELLO";
    L81:
        a(r6, this, r2, (com.bytedance.safetyguard.lxc.internal.d.d) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.d.d.a(r32, r33), com.bytedance.safetyguard.lxc.internal.d.d.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L34
        goto L107
    L67:
        r30 = ProxySessionErrorCode.MALFORMED_FRAME;     // Catch: Throwable -> L34
        goto L68
    L63:
        r29 = ProxySessionCloseReason.HANDSHAKE_FAILED;     // Catch: Throwable -> L34
    L95:
        e = move-exception;
        aj r34 = a(ProxySessionCloseReason.HANDSHAKE_FAILED, ProxySessionErrorCode.HELLO_TIMEOUT, e.getMessage());     // Catch: Throwable -> L34
        if (r6.f38499a == true) goto L107;
        if (r34.a() != ProxySessionCloseReason.HANDSHAKE_FAILED) goto L107;
        ProxySessionErrorCode r35 = r34.b();     // Catch: Throwable -> L34
        if (r35 != null) goto L103;
        r35 = ProxySessionErrorCode.HELLO_TIMEOUT;     // Catch: Throwable -> L34
    L103:
        String r36 = r34.c();     // Catch: Throwable -> L34
        if (r36 != null) goto L106;
        r36 = "Timed out waiting for HELLO";
    L106:
        a(r6, this, r2, (com.bytedance.safetyguard.lxc.internal.d.d) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.d.d.a(r35, r36), com.bytedance.safetyguard.lxc.internal.d.d.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L34
        goto L107
    }

    private static final void a(d.h.b.z.a r2, e r3, d.h.a.b<? super com.bytedance.safetyguard.lxc.internal.d.d, d.x> r4, com.bytedance.safetyguard.lxc.internal.d.d r5) {
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.d.d r7 = (com.bytedance.safetyguard.lxc.internal.d.d) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.safetyguard.lxc.internal.d.d.class, "com.obric.aiagent.plugin");
        if (r2.f38499a == false) goto L5;
        return;
    L5:
        r2.f38499a = true;
        d.n.a r8 = d.n.f38560a;     // Catch: Throwable -> L8
        r6.invoke(r7);     // Catch: Throwable -> L8
        Object r9 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L8
    L10:
        Throwable r10 = d.n.c(r9);
        if (r10 == null) goto L16;
        r3.g.b("AppGatewayProxySession", "component=proxy event=handshake_callback_failed outcome=ignored", r10);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        d.n.a r11 = d.n.f38560a;
        r9 = d.n.f(d.o.a(th));
        goto L10
    }

    private final boolean a(com.bytedance.safetyguard.lxc.internal.c.f r3) {
        switch(d.f10208b[r3.getType().ordinal()]) {
            case 1: goto L19;
            case 2: goto L16;
            case 3: goto L13;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L9;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L6;
            case 10: goto L6;
            default: goto L29;
        };
    L7:
        return false;
    L9:
        f(r3);
        return true;
    L10:
        w r2 = c(r3);
        if (r2 == null) goto L23;
        r2.a(z.a(r3.c()));
        return true;
    L23:
        return true;
    L13:
        w r4 = c(r3);
        if (r4 == null) goto L25;
        r4.a();
        return true;
    L25:
        return true;
    L16:
        w r5 = d(r3);
        if (r5 == null) goto L27;
        r5.a(r3.c());
        return true;
    L27:
        return true;
    L19:
        b(r3);
        return true;
    L29:
        return true;
    L6:
        throw new com.bytedance.safetyguard.lxc.internal.c.k("Unexpected frame from gateway: " + r3.getType(), null, 2, null);
    }

    private final void b(com.bytedance.safetyguard.lxc.internal.c.f r17) {
        ae r3 = null;
        if (r17.a() <= 0) goto L51;
        com.bytedance.safetyguard.lxc.internal.c.d r4 = com.bytedance.safetyguard.lxc.internal.c.d.f9818a.a(r17.c());
        int r0 = d.f10209c[a(r17.a()).ordinal()];
        boolean r5 = true;
        if (r0 == 1) goto L58;
        if (r0 == 2) goto L48;
        this.g.a("AppGatewayProxySession", "component=proxy event=stream_opened outcome=pending streamId=" + r17.a() + " ingress=" + r4.d() + " targetType=" + r4.c() + " targetRef=" + this.g.a(r4.a()) + " targetPort=" + r4.b());
        OutboundTarget r1 = com.bytedance.safetyguard.lxc.internal.b.p.f9784a.a(r4);
        com.bytedance.safetyguard.lxc.internal.d.a r2 = this.f;
        if (r2 == null) goto L10;
        r3 = r2.a(r1);
    L10:
        if (r3 == null) goto L14;
        r5 = ZeusTransformUtils.instanceOf(r3, ae.a.class);
    L14:
        if (r5 == false) goto L17;
    L52:
        d.n.a r6 = d.n.f38560a;     // Catch: Throwable -> L29
        Object r7 = d.n.f(((e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.aiagent.plugin")).f10197d.a(r4));     // Catch: Throwable -> L29
    L31:
        Throwable r8 = d.n.c(r7);
        if (r8 != null) goto L46;
        com.bytedance.safetyguard.lxc.internal.b.m r9 = (com.bytedance.safetyguard.lxc.internal.b.m) ZeusTransformUtils.preCheckCast(r7, com.bytedance.safetyguard.lxc.internal.b.m.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, com.bytedance.safetyguard.lxc.internal.b.m.a.class) == false) goto L37;
        a(r17.a(), r4, ((com.bytedance.safetyguard.lxc.internal.b.m.a) ZeusTransformUtils.preCheckCast(r9, com.bytedance.safetyguard.lxc.internal.b.m.a.class, "com.obric.aiagent.plugin")).a());
        return;
    L37:
        if (ZeusTransformUtils.instanceOf(r9, com.bytedance.safetyguard.lxc.internal.b.m.b.class) == false) goto L40;
        this.g.a("AppGatewayProxySession", "component=proxy event=stream_rejected outcome=" + ((com.bytedance.safetyguard.lxc.internal.b.m.b) ZeusTransformUtils.preCheckCast(r9, com.bytedance.safetyguard.lxc.internal.b.m.b.class, "com.obric.aiagent.plugin")).a().a() + " streamId=" + r17.a() + " errorCode=" + ((com.bytedance.safetyguard.lxc.internal.b.m.b) ZeusTransformUtils.preCheckCast(r9, com.bytedance.safetyguard.lxc.internal.b.m.b.class, "com.obric.aiagent.plugin")).a().c());
        this.s.b();
        this.s.a(((com.bytedance.safetyguard.lxc.internal.b.m.b) ZeusTransformUtils.preCheckCast(r9, com.bytedance.safetyguard.lxc.internal.b.m.b.class, "com.obric.aiagent.plugin")).a().c(), ((com.bytedance.safetyguard.lxc.internal.b.m.b) ZeusTransformUtils.preCheckCast(r9, com.bytedance.safetyguard.lxc.internal.b.m.b.class, "com.obric.aiagent.plugin")).a().d());
        b(r17.a());
        a(r17.a(), ((com.bytedance.safetyguard.lxc.internal.b.m.b) ZeusTransformUtils.preCheckCast(r9, com.bytedance.safetyguard.lxc.internal.b.m.b.class, "com.obric.aiagent.plugin")).a().b());
        return;
    L40:
        if (ZeusTransformUtils.instanceOf(r9, com.bytedance.safetyguard.lxc.internal.b.m.d.class) == false) goto L43;
        a(r17.a(), r4);
        return;
    L43:
        if (ZeusTransformUtils.instanceOf(r9, com.bytedance.safetyguard.lxc.internal.b.m.c.class) == false) goto L57;
        this.s.b();
        this.s.a(ProxySessionErrorCode.DNS_FAILED, "Target resolver returned an incomplete DNS result");
        b(r17.a());
        a(r17.a(), com.bytedance.safetyguard.lxc.internal.c.l.f9850d);
        return;
    L57:
        return;
    L46:
        this.g.b("AppGatewayProxySession", "component=proxy event=target_resolution_failed outcome=failed", r8);
        this.s.b();
        this.s.a(ProxySessionErrorCode.NETWORK_ERROR, r8.getMessage());
        b(r17.a());
        a(r17.a(), com.bytedance.safetyguard.lxc.internal.c.l.i);
        return;
    L29:
        th = move-exception;
        d.n.a r10 = d.n.f38560a;
        r7 = d.n.f(d.o.a(th));
        goto L31
    L17:
        if (d.h.b.o.a(r3, ae.b.f10130a) == false) goto L20;
        s.a.a(this.g, "AppGatewayProxySession", "component=proxy event=action_context_missing outcome=fail_open targetRef=" + this.g.a(r1.getHost()) + " targetPort=" + r1.getPort() + " targetType=" + r1.getType() + " ingress=" + r1.getIngressProxy(), null, 4, null);
        goto L52
    L20:
        if (ZeusTransformUtils.instanceOf(r3, ae.c.class) == false) goto L24;
        this.g.a("AppGatewayProxySession", "component=proxy event=stream_rejected outcome=sensitive_policy_denied streamId=" + r17.a() + " status=" + ((ae.c) ZeusTransformUtils.preCheckCast(r3, ae.c.class, "com.obric.aiagent.plugin")).a());
        this.s.b();
        b(r17.a());
        a(r17.a(), com.bytedance.safetyguard.lxc.internal.c.l.f9849c);
        return;
    L24:
        if (d.h.b.o.a(r3, ae.d.f10134a) == false) goto L52;
        s.a.a(this.g, "AppGatewayProxySession", "component=proxy event=orphaned_action_context outcome=policy_denied streamId=" + r17.a(), null, 4, null);
        this.s.b();
        b(r17.a());
        a(r17.a(), com.bytedance.safetyguard.lxc.internal.c.l.f9849c);
        return;
    L48:
        this.s.b();
        this.s.a(ProxySessionErrorCode.TOO_MANY_STREAMS, "Too many proxy streams: max=" + this.f10196c.e());
        d(r17.a());
        a(r17.a(), com.bytedance.safetyguard.lxc.internal.c.l.j);
        return;
    L58:
        return;
    L51:
        throw new com.bytedance.safetyguard.lxc.internal.c.k("OPEN_TCP requires non-zero StreamId", null, 2, null);
    }

    private final void a(int r12, com.bytedance.safetyguard.lxc.internal.c.d r13, com.bytedance.safetyguard.lxc.internal.b.q r14) {
        b r7 = new b();
        ca r15 = kotlinx.coroutines.i.a(this.x, null, ao.f38852b, (d.h.a.m) ZeusTransformUtils.preCheckCast(new j(this, r12, r13, r14, r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null);
        if (r15 != null) goto L5;
        d.h.b.o.c("connectJob");
        ca r16 = null;
    L6:
        r7.a(r16);
        r15.a_((d.h.a.b) ZeusTransformUtils.preCheckCast(new k(this, r12, r7), d.h.a.b.class, "com.obric.aiagent.plugin"));
        Object r17 = this.i;
        monitor-enter(r17);
    L22:
        th = move-exception;
        throw th;
    L9:
        if (this.q.get() == false) goto L11;
    L15:
        boolean r11 = false;
    L16:
        monitor-exit(r17);
        if (r11 == true) goto L20;
        r7.c();
        return;
    L20:
        r15.s_();
        return;
    L11:
        if (this.l.contains(Integer.valueOf(r12)) == false) goto L15;
        Integer r18 = Integer.valueOf(r12);     // Catch: Throwable -> L22
        this.k.put(r18, r7);     // Catch: Throwable -> L22
        r11 = true;
        goto L16
    L5:
        r16 = r15;
        goto L6
    }

    private final void a(int r21, com.bytedance.safetyguard.lxc.internal.c.d r22, com.bytedance.safetyguard.lxc.internal.b.q r23, b r24) {
        long r7 = System.currentTimeMillis();
        Socket r9 = this.h.a(r23, this.f10196c.a(), (d.h.a.b) ZeusTransformUtils.preCheckCast(new g(r24), d.h.a.b.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L16
        ah r10 = new ah(b(r21, r22), r9, this.p, this.x, this.g, this.s, (d.h.a.b) ZeusTransformUtils.preCheckCast(new h(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
        if (a(r21, r24, (w) ZeusTransformUtils.preCheckCast(r10, w.class, "com.obric.aiagent.plugin")) == true) goto L8;
        this.g.a("AppGatewayProxySession", "component=proxy event=tcp_connect_cancelled outcome=cancelled streamId=" + r21 + " durationMs=" + (System.currentTimeMillis() - r7));
        r10.close();
        return;
    L8:
        r24.b(r9);
        s r3 = this.g;
        StringBuilder r2 = new StringBuilder().append("component=proxy event=tcp_connected outcome=success streamId=").append(r21).append(" targetIp=");
        InetAddress r4 = r9.getInetAddress();
        if (r4 == null) goto L11;
        String r5 = r4.getHostAddress();
    L12:
        if (r5 != null) goto L14;
        r5 = SensitiveType.UNKNOWN;
    L14:
        r3.a("AppGatewayProxySession", r2.append(r5).append(" durationMs=").append(System.currentTimeMillis() - r7).toString());
        kotlinx.coroutines.i.a(this.x, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new f(r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L11:
        r5 = null;
    L16:
        e = move-exception;
        if (a(r21, r24) == true) goto L21;
        this.g.a("AppGatewayProxySession", "component=proxy event=tcp_connect_cancelled outcome=cancelled streamId=" + r21 + " durationMs=" + (System.currentTimeMillis() - r7));
        return;
    L21:
        com.bytedance.safetyguard.lxc.internal.c.l r6 = b(e);
        this.g.a("AppGatewayProxySession", "component=proxy event=tcp_connect_failed outcome=" + r6 + " streamId=" + r21 + " durationMs=" + (System.currentTimeMillis() - r7) + " exceptionClass=" + e.getClass().getSimpleName());
        a(r21, r24, r6);
    }

    private final void a(int r12, com.bytedance.safetyguard.lxc.internal.c.d r13) {
        this.g.a("AppGatewayProxySession", "component=proxy event=sidecar_stream_opened outcome=pending streamId=" + r12);
        af r0 = new af(b(r12, com.bytedance.safetyguard.lxc.internal.c.d.a(r13, null, 0, null, com.bytedance.safetyguard.lxc.internal.c.c.f9817e, null, 23, null)), this.p, this.f10198e, this.x, this.g, this.s, (d.h.a.b) ZeusTransformUtils.preCheckCast(new i(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
        if (a(r12, (w) ZeusTransformUtils.preCheckCast(r0, w.class, "com.obric.aiagent.plugin")) == true) goto L6;
        r0.close();
        return;
    }

    private final ag b(int r14, com.bytedance.safetyguard.lxc.internal.c.d r15) {
        return new ag(r14, r15.d(), r15.a(), r15.b(), this.u, this.u, false, false, false, 448, null);
    }

    private final w c(com.bytedance.safetyguard.lxc.internal.c.f r5) {
        Object r0 = this.i;
        monitor-enter(r0);
        w r1 = (w) ZeusTransformUtils.preCheckCast(this.j.get(Integer.valueOf(r5.a())), w.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        monitor-exit(r0);
        if (r1 != null) goto L8;
    L10:
        if (r1 == null) goto L12;
        c(r5.a());
    L12:
        e(r5);
        return null;
    L8:
        if (r1.getContext().e() == true) goto L10;
        return r1;
    L14:
        th = move-exception;
        throw th;
    }

    private final w d(com.bytedance.safetyguard.lxc.internal.c.f r10) {
        Object r0 = this.i;
        monitor-enter(r0);
        w r1 = (w) ZeusTransformUtils.preCheckCast(this.j.get(Integer.valueOf(r10.a())), w.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        monitor-exit(r0);
        if (r1 != null) goto L8;
    L10:
        if (r1 == null) goto L13;
        c(r10.a());
    L13:
        if (e(r10) == false) goto L15;
        return null;
    L15:
        String r2 = "DATA for unknown stream: " + r10.a();
        this.g.a("AppGatewayProxySession", "component=proxy event=unknown_stream_frame outcome=reset frameType=" + r10.getType() + " streamId=" + r10.a());
        this.s.a(ProxySessionErrorCode.MALFORMED_FRAME, r2);
        if (r10.a() <= 0) goto L18;
        this.p.f(new com.bytedance.safetyguard.lxc.internal.c.f(com.bytedance.safetyguard.lxc.internal.c.h.j, r10.a(), 0, null, 12, null));
    L18:
        return null;
    L8:
        if (r1.getContext().e() == true) goto L10;
        return r1;
    L19:
        th = move-exception;
        throw th;
    }

    private final boolean e(com.bytedance.safetyguard.lxc.internal.c.f r5) {
        if (f(r5.a()) == false) goto L6;
        this.g.a("AppGatewayProxySession", "component=proxy event=closed_stream_frame outcome=ignored frameType=" + r5.getType() + " streamId=" + r5.a());
        return true;
    L6:
        this.g.a("AppGatewayProxySession", "component=proxy event=unknown_stream_frame outcome=ignored frameType=" + r5.getType() + " streamId=" + r5.a());
        return false;
    }

    private final c a(int r4) {
        Object r0 = this.i;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.q.get() == false) goto L8;
        c r3 = c.f10204c;     // Catch: Throwable -> L19
    L15:
        monitor-exit(r0);
        return r3;
    L8:
        if (this.l.contains(Integer.valueOf(r4)) == true) goto L18;
        if (this.m.contains(Integer.valueOf(r4)) == true) goto L18;
        if (this.l.size() < this.f10196c.e()) goto L14;
        r3 = c.f10203b;     // Catch: Throwable -> L19
        goto L15
    L14:
        this.l.add(Integer.valueOf(r4));     // Catch: Throwable -> L19
        r3 = c.f10202a;     // Catch: Throwable -> L19
    L18:
        throw new com.bytedance.safetyguard.lxc.internal.c.k("Duplicate StreamId: " + r4, null, 2, null);     // Catch: Throwable -> L19
    }

    private final void b(int r4) {
        Object r0 = this.i;
        monitor-enter(r0);
        this.l.remove(Integer.valueOf(r4));     // Catch: Throwable -> L7
        e(r4);     // Catch: Throwable -> L7
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private final boolean a(int r3, b r4) {
        Object r0 = this.i;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.q.get() == true) goto L9;
        if (this.k.get(Integer.valueOf(r3)) != r4) goto L9;
        boolean r2 = true;
    L10:
        monitor-exit(r0);
        return r2;
    L9:
        r2 = false;
        goto L10
    }

    private final boolean a(int r6, b r7, com.bytedance.safetyguard.lxc.internal.c.l r8) {
        Object r0 = this.i;
        monitor-enter(r0);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (this.q.get() == false) goto L7;
    L15:
        boolean r5 = false;
        boolean r9 = false;
    L16:
        monitor-exit(r0);
        if (r5 == false) goto L19;
        r7.b();
    L19:
        if (r5 == false) goto L23;
        if (r9 == false) goto L23;
        return true;
    L23:
        return false;
    L7:
        if (this.k.get(Integer.valueOf(r6)) != r7) goto L15;
        this.k.remove(Integer.valueOf(r6));     // Catch: Throwable -> L24
        r9 = a(r6, r8);     // Catch: Throwable -> L12
        this.l.remove(Integer.valueOf(r6));     // Catch: Throwable -> L24
        e(r6);     // Catch: Throwable -> L24
        r5 = true;
        goto L16
    L12:
        th = move-exception;
        this.l.remove(Integer.valueOf(r6));     // Catch: Throwable -> L24
        e(r6);     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    }

    private final void b(int r4, b r5) {
        Object r0 = this.i;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.k.get(Integer.valueOf(r4)) == r5) goto L7;
        boolean r3 = false;
    L9:
        monitor-exit(r0);
        if (r3 == false) goto L18;
        r5.b();
        return;
    L18:
        return;
    L7:
        this.k.remove(Integer.valueOf(r4));     // Catch: Throwable -> L13
        this.l.remove(Integer.valueOf(r4));     // Catch: Throwable -> L13
        e(r4);     // Catch: Throwable -> L13
        r3 = true;
        goto L9
    }

    private final boolean a(int r5, b r6, w r7) {
        w r8 = (w) ZeusTransformUtils.wrapperContextForParams(r7, w.class, "com.obric.aiagent.plugin");
        Object r0 = this.i;
        monitor-enter(r0);
        boolean r2 = false;
        if (this.q.get() == false) goto L7;
    L22:
        monitor-exit(r0);
        if (r2 == false) goto L25;
        this.s.a();
    L25:
        return r2;
    L7:
        if (this.l.contains(Integer.valueOf(r5)) == false) goto L22;
        if (this.k.get(Integer.valueOf(r5)) != r6) goto L22;
        if (r8.getContext().e() == true) goto L22;
        this.k.remove(Integer.valueOf(r5));     // Catch: Throwable -> L26
        this.j.put(Integer.valueOf(r5), r8);     // Catch: Throwable -> L26
    L19:
        e = move-exception;
        b(r5, r8);     // Catch: Throwable -> L26
        throw e;     // Catch: Throwable -> L26
    L15:
        if (a(r5, com.bytedance.safetyguard.lxc.internal.c.l.f9848b) == false) goto L17;
        r2 = true;
        goto L22
    L17:
        b(r5, r8);     // Catch: Exception -> L19 Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    private final boolean a(int r5, w r6) {
        w r7 = (w) ZeusTransformUtils.wrapperContextForParams(r6, w.class, "com.obric.aiagent.plugin");
        Object r0 = this.i;
        monitor-enter(r0);
        boolean r2 = false;
        if (this.q.get() == false) goto L7;
    L20:
        monitor-exit(r0);
        if (r2 == false) goto L23;
        this.s.a();
    L23:
        return r2;
    L7:
        if (this.l.contains(Integer.valueOf(r5)) == false) goto L20;
        if (r7.getContext().e() == true) goto L20;
        this.j.put(Integer.valueOf(r5), r7);     // Catch: Throwable -> L24
    L17:
        e = move-exception;
        b(r5, r7);     // Catch: Throwable -> L24
        throw e;     // Catch: Throwable -> L24
    L13:
        if (a(r5, com.bytedance.safetyguard.lxc.internal.c.l.f9848b) == false) goto L15;
        r2 = true;
        goto L20
    L15:
        b(r5, r7);     // Catch: Exception -> L17 Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    private final void b(int r3, w r4) {
        w r5 = (w) ZeusTransformUtils.wrapperContextForParams(r4, w.class, "com.obric.aiagent.plugin");
        if (this.j.get(Integer.valueOf(r3)) != r5) goto L6;
        this.j.remove(Integer.valueOf(r3));
        this.l.remove(Integer.valueOf(r3));
        e(r3);
        return;
    }

    private final void f(com.bytedance.safetyguard.lxc.internal.c.f r6) {
        Object r0 = this.i;
        monitor-enter(r0);
        this.p.a(r6.a());     // Catch: Throwable -> L19
        b r1 = (b) ZeusTransformUtils.preCheckCast(this.k.remove(Integer.valueOf(r6.a())), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        w r2 = (w) ZeusTransformUtils.preCheckCast(this.j.remove(Integer.valueOf(r6.a())), w.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        if (r1 != null) goto L7;
        if (r2 != null) goto L7;
    L8:
        d.m r3 = d.s.a(r1, r2);     // Catch: Throwable -> L19
        monitor-exit(r0);
        b r4 = (b) ZeusTransformUtils.preCheckCast(r3.c(), b.class, "com.obric.aiagent.plugin");
        w r5 = (w) ZeusTransformUtils.preCheckCast(r3.d(), w.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L13;
        r4.c();
    L13:
        if (r5 == null) goto L15;
        r5.close();
    L15:
        if (r4 != null) goto L24;
        if (r5 != null) goto L25;
        e(r6);
        return;
    L25:
        return;
    L24:
        return;
    L7:
        this.l.remove(Integer.valueOf(r6.a()));     // Catch: Throwable -> L19
        e(r6.a());     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    private final void c(int r4) {
        Object r0 = this.i;
        monitor-enter(r0);
        this.j.remove(Integer.valueOf(r4));     // Catch: Throwable -> L7
        this.l.remove(Integer.valueOf(r4));     // Catch: Throwable -> L7
        e(r4);     // Catch: Throwable -> L7
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private final void d(int r2) {
        if (r2 > 0) goto L4;
        return;
    L4:
        Object r0 = this.i;
        monitor-enter(r0);
        e(r2);     // Catch: Throwable -> L9
        d.x r1 = d.x.f38692a;     // Catch: Throwable -> L9
        monitor-exit(r0);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private final void e(int r3) {
        if (r3 > 0) goto L4;
        return;
    L4:
        if (this.m.add(Integer.valueOf(r3)) == false) goto L12;
        this.n.addLast(Integer.valueOf(r3));
    L8:
        if (this.n.size() <= this.o) goto L13;
        this.m.remove(this.n.removeFirst());
        goto L8
    L13:
        return;
    }

    private final boolean f(int r2) {
        if (r2 > 0) goto L5;
        return false;
    L5:
        Object r0 = this.i;
        monitor-enter(r0);
        boolean r1 = this.m.contains(Integer.valueOf(r2));     // Catch: Throwable -> L10
        monitor-exit(r0);
        return r1;
    L10:
        th = move-exception;
        throw th;
    }

    private final com.bytedance.safetyguard.lxc.internal.c.l a(com.bytedance.safetyguard.lxc.internal.c.k r5) {
        if (this.s.c().e() == ProxySessionErrorCode.PENDING_BYTES_EXCEEDED) goto L14;
        String r4 = r5.getMessage();
        boolean r6 = true;
        if (r4 != null) goto L7;
    L9:
        r6 = false;
    L10:
        if (r6 == true) goto L14;
        return com.bytedance.safetyguard.lxc.internal.c.l.h;
    L7:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("Pending writer bytes exceeded", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) != true) goto L9;
    L14:
        return com.bytedance.safetyguard.lxc.internal.c.l.j;
    }

    private final void a(Exception r11) {
        if (this.q.get() == false) goto L7;
        this.g.a("AppGatewayProxySession", "component=proxy event=tcp_connect_worker_cancelled outcome=cancelled");
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r11, com.bytedance.safetyguard.lxc.internal.c.k.class) == false) goto L9;
        this.g.a("AppGatewayProxySession", "component=proxy event=protocol_violation outcome=failed exceptionClass=" + r11.getClass().getSimpleName(), (Throwable) ZeusTransformUtils.preCheckCast(r11, Throwable.class, "com.obric.aiagent.plugin"));
        this.p.f(new com.bytedance.safetyguard.lxc.internal.c.f(com.bytedance.safetyguard.lxc.internal.c.h.f9835d, 0, 0, new com.bytedance.safetyguard.lxc.internal.c.e(a((com.bytedance.safetyguard.lxc.internal.c.k) ZeusTransformUtils.preCheckCast(r11, com.bytedance.safetyguard.lxc.internal.c.k.class, "com.obric.aiagent.plugin"))).a(), 4, null));
        a(ProxySessionCloseReason.PROTOCOL_ERROR, ProxySessionErrorCode.MALFORMED_FRAME, r11.getMessage());
    L10:
        a(false);
        return;
    L9:
        this.g.a("AppGatewayProxySession", "component=proxy event=tcp_connect_worker_failed outcome=failed exceptionClass=" + r11.getClass().getSimpleName(), (Throwable) ZeusTransformUtils.preCheckCast(r11, Throwable.class, "com.obric.aiagent.plugin"));
        a(ProxySessionCloseReason.IO_ERROR, ProxySessionErrorCode.NETWORK_ERROR, r11.getMessage());
        goto L10
    }

    private final boolean a(int r9, com.bytedance.safetyguard.lxc.internal.c.l r10) {
        return this.p.d(new com.bytedance.safetyguard.lxc.internal.c.f(com.bytedance.safetyguard.lxc.internal.c.h.f, r9, 0, new com.bytedance.safetyguard.lxc.internal.c.e(r10).a(), 4, null));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a(ProxySessionCloseReason.HOST_CLOSED, null, null);
        if (a(true) == false) goto L6;
        this.g.a("AppGatewayProxySession", "component=proxy event=session_close_requested outcome=success");
        return;
    }

    private final void b(long r7) {
        a(false);
        aj r0 = (aj) ZeusTransformUtils.preCheckCast(this.r.get(), aj.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        ProxySessionCloseReason r1 = r0.a();
        if (r1 == null) goto L6;
    L7:
        u r2 = this.s.c();
        s r3 = this.g;
        StringBuilder r6 = new StringBuilder().append("component=proxy event=session_terminal outcome=").append(r1).append(" sharedRef=").append(this.v).append(" closeReason=").append(r1).append(" errorCode=");
        if (r0 == null) goto L10;
        ProxySessionErrorCode r4 = r0.b();
    L11:
        r3.b("AppGatewayProxySession", r6.append(r4).append(" openedStreams=").append(r2.a()).append(" rejectedStreams=").append(r2.b()).append(" bytesFromGateway=").append(r2.c()).append(" bytesToGateway=").append(r2.d()).append(" durationMs=").append((System.nanoTime() - r7) / ((long) 1000000)).toString());
        return;
    L10:
        r4 = null;
    L6:
        r1 = ProxySessionCloseReason.INTERNAL_ERROR;
        goto L7
    }

    private final boolean a(boolean r11) {
        boolean r1 = this.q.compareAndSet(false, true);
        Object r2 = this.i;
        monitor-enter(r2);
        List r4 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(this.k.values(), Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L37
        List r5 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(this.j.values(), Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L37
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(this.l, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L37
    L6:
        if (r6.hasNext() == false) goto L8;
        e(((Number) ZeusTransformUtils.preCheckCast(r6.next(), Number.class, "com.obric.aiagent.plugin")).intValue());     // Catch: Throwable -> L37
        goto L6
    L8:
        this.k.clear();     // Catch: Throwable -> L37
        this.j.clear();     // Catch: Throwable -> L37
        this.l.clear();     // Catch: Throwable -> L37
        d.x r7 = d.x.f38692a;     // Catch: Throwable -> L37
        monitor-exit(r2);
        com.bytedance.safetyguard.lxc.internal.d.i r3 = this.t;
        if (r3 == null) goto L40;
        r3.close();
    L18:
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L20:
        if (r8.hasNext() == false) goto L22;
        ((b) ZeusTransformUtils.preCheckCast(r8.next(), b.class, "com.obric.aiagent.plugin")).c();
        goto L20
    L22:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L24:
        if (r9.hasNext() == false) goto L26;
        ((w) ZeusTransformUtils.preCheckCast(r9.next(), w.class, "com.obric.aiagent.plugin")).close();
        goto L24
    L26:
        an.a(this.x, null, 1, null);
        if (r11 == false) goto L44;
        this.p.a();
    L36:
        return r1;
    L44:
        d.n.a r12 = d.n.f38560a;     // Catch: Throwable -> L31
        ((e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.aiagent.plugin")).p.close();     // Catch: Throwable -> L31
        Object r13 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L31
    L33:
        Throwable r14 = d.n.c(r13);
        if (r14 == null) goto L36;
        this.g.b("AppGatewayProxySession", "component=proxy event=writer_close_failed outcome=failed", r14);
    L31:
        th = move-exception;
        d.n.a r0 = d.n.f38560a;
        r13 = d.n.f(d.o.a(th));
        goto L33
    L40:
        d.n.a r10 = d.n.f38560a;     // Catch: Throwable -> L15
        ((e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.aiagent.plugin")).f10195b.close();     // Catch: Throwable -> L15
        Object r15 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L15
    L17:
        d.n.g(r15);
    L15:
        th = move-exception;
        d.n.a r16 = d.n.f38560a;
        r15 = d.n.f(d.o.a(th));
    L37:
        th = move-exception;
        throw th;
    }

    private final aj a(ProxySessionCloseReason r3, ProxySessionErrorCode r4, String r5) {
        aj r0 = new aj(r3, r4, r5);
        if (this.r.compareAndSet(null, r0) == false) goto L6;
        if (r4 == null) goto L6;
        this.s.a(r4, r5);
    L6:
        aj r2 = this.r.get();
        if (r2 == null) goto L11;
        return (aj) ZeusTransformUtils.preCheckCast(r2, aj.class, "com.obric.aiagent.plugin");
    L11:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final boolean a(long r11) {
        long r0 = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(r11);
        boolean r2 = true;
        boolean r12 = false;
        if (((Boolean) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0232e(this, r0, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L22;
        s.a.a(this.g, "AppGatewayProxySession", "component=proxy event=worker_termination_timeout outcome=failed", null, 4, null);
        r2 = false;
    L22:
        d.n.a r13 = d.n.f38560a;     // Catch: Throwable -> L10
        e r14 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        if (r14.p.b(r14.c(r0)) == true) goto L8;
        s.a.a(r14.g, "AppGatewayProxySession", "component=proxy event=writer_termination_timeout outcome=failed", null, 4, null);     // Catch: Throwable -> L10
        r2 = false;
    L8:
        Object r15 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L10
    L12:
        Throwable r16 = d.n.c(r15);
        if (r16 == null) goto L15;
        this.g.b("AppGatewayProxySession", "component=proxy event=writer_termination_wait_failed outcome=failed", r16);
    L16:
        s r10 = this.g;
        StringBuilder r17 = new StringBuilder().append("component=proxy event=session_terminated outcome=");
        if (r12 == false) goto L19;
        String r1 = "success";
    L20:
        r10.a("AppGatewayProxySession", r17.append(r1).toString());
        return r12;
    L19:
        r1 = "timeout";
        goto L20
    L15:
        r12 = r2;
    L10:
        th = move-exception;
        d.n.a r3 = d.n.f38560a;
        r15 = d.n.f(d.o.a(th));
        goto L12
    }

    private final long c(long r3) {
        return Math.max(1, TimeUnit.NANOSECONDS.toMillis(r3 - System.nanoTime()));
    }

    private final com.bytedance.safetyguard.lxc.internal.c.l b(Exception r1) {
        if (ZeusTransformUtils.instanceOf(r1, UnknownHostException.class) == false) goto L6;
        return com.bytedance.safetyguard.lxc.internal.c.l.f9850d;
    L6:
        if (ZeusTransformUtils.instanceOf(r1, SocketTimeoutException.class) == false) goto L9;
        return com.bytedance.safetyguard.lxc.internal.c.l.f;
    L9:
        if (ZeusTransformUtils.instanceOf(r1, NoRouteToHostException.class) == false) goto L12;
        return com.bytedance.safetyguard.lxc.internal.c.l.g;
    L12:
        if (ZeusTransformUtils.instanceOf(r1, ConnectException.class) == false) goto L15;
        return com.bytedance.safetyguard.lxc.internal.c.l.f9851e;
    L15:
        return com.bytedance.safetyguard.lxc.internal.c.l.i;
    }
}
