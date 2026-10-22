package okhttp3;

import com.bytedance.crash.dumper.Scraps;
import com.bytedance.keva.KevaImpl;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: OkHttpClient.kt */
/* JADX INFO: loaded from: classes4.dex */
public class z implements Cloneable {
    private static final List<aa> F = null;
    private static final List<l> G = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f40236a = null;
    private final int A;
    private final int B;
    private final int C;
    private final long D;
    private final okhttp3.internal.d.h E;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p f40237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k f40238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<w> f40239d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<w> f40240e;
    private final r.c f;
    private final boolean g;
    private final okhttp3.b h;
    private final boolean i;
    private final boolean j;
    private final n k;
    private final c l;
    private final q m;
    private final Proxy n;
    private final ProxySelector o;
    private final okhttp3.b p;
    private final SocketFactory q;
    private final SSLSocketFactory r;
    private final X509TrustManager s;
    private final List<l> t;
    private final List<aa> u;
    private final HostnameVerifier v;
    private final g w;
    private final okhttp3.internal.k.c x;
    private final int y;
    private final int z;

    /* JADX INFO: compiled from: OkHttpClient.kt */
    public static final class a {
        private int A;
        private int B;
        private long C;
        private okhttp3.internal.d.h D;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private p f40241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private k f40242b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<w> f40243c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<w> f40244d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private r.c f40245e;
        private boolean f;
        private okhttp3.b g;
        private boolean h;
        private boolean i;
        private n j;
        private c k;
        private q l;
        private Proxy m;
        private ProxySelector n;
        private okhttp3.b o;
        private SocketFactory p;
        private SSLSocketFactory q;
        private X509TrustManager r;
        private List<l> s;
        private List<? extends aa> t;
        private HostnameVerifier u;
        private g v;
        private okhttp3.internal.k.c w;
        private int x;
        private int y;
        private int z;

        public a() {
            this.f40241a = new p();
            this.f40242b = new k();
            this.f40243c = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            this.f40244d = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            this.f40245e = okhttp3.internal.c.a(r.NONE);
            this.f = true;
            this.g = okhttp3.b.f39735b;
            this.h = true;
            this.i = true;
            this.j = n.f40179b;
            this.l = q.f40188b;
            this.o = okhttp3.b.f39735b;
            SocketFactory r0 = SocketFactory.getDefault();
            d.h.b.o.c(r0, "getDefault()");
            this.p = r0;
            this.s = z.f40236a.b();
            this.t = z.f40236a.a();
            this.u = (HostnameVerifier) ZeusTransformUtils.preCheckCast(okhttp3.internal.k.d.f40154a, HostnameVerifier.class, "com.obric.aiagent.plugin");
            this.v = g.f39771b;
            this.y = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
            this.z = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
            this.A = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
            this.C = 1024;
        }

        public final p a() {
            return this.f40241a;
        }

        public final k b() {
            return this.f40242b;
        }

        public final List<w> c() {
            return this.f40243c;
        }

        public final List<w> d() {
            return this.f40244d;
        }

        public final r.c e() {
            return this.f40245e;
        }

        public final boolean f() {
            return this.f;
        }

        public final okhttp3.b g() {
            return this.g;
        }

        public final boolean h() {
            return this.h;
        }

        public final boolean i() {
            return this.i;
        }

        public final n j() {
            return this.j;
        }

        public final c k() {
            return this.k;
        }

        public final q l() {
            return this.l;
        }

        public final Proxy m() {
            return this.m;
        }

        public final ProxySelector n() {
            return this.n;
        }

        public final okhttp3.b o() {
            return this.o;
        }

        public final SocketFactory p() {
            return this.p;
        }

        public final SSLSocketFactory q() {
            return this.q;
        }

        public final X509TrustManager r() {
            return this.r;
        }

        public final List<l> s() {
            return this.s;
        }

        public final List<aa> t() {
            return this.t;
        }

        public final HostnameVerifier u() {
            return this.u;
        }

        public final g v() {
            return this.v;
        }

        public final okhttp3.internal.k.c w() {
            return this.w;
        }

        public final int x() {
            return this.x;
        }

        public final int y() {
            return this.y;
        }

        public final int z() {
            return this.z;
        }

        public final int A() {
            return this.A;
        }

        public final int B() {
            return this.B;
        }

        public final long C() {
            return this.C;
        }

        public final okhttp3.internal.d.h D() {
            return this.D;
        }

        public a(z r5) {
            d.h.b.o.e(r5, "okHttpClient");
            this();
            this.f40241a = r5.a();
            this.f40242b = r5.b();
            d.a.p.a((Collection) ZeusTransformUtils.preCheckCast(this.f40243c, Collection.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r5.c(), Iterable.class, "com.obric.aiagent.plugin"));
            d.a.p.a((Collection) ZeusTransformUtils.preCheckCast(this.f40244d, Collection.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r5.d(), Iterable.class, "com.obric.aiagent.plugin"));
            this.f40245e = r5.e();
            this.f = r5.f();
            this.g = r5.g();
            this.h = r5.h();
            this.i = r5.i();
            this.j = r5.j();
            this.k = r5.k();
            this.l = r5.l();
            this.m = r5.m();
            this.n = r5.n();
            this.o = r5.o();
            this.p = r5.p();
            this.q = z.a(r5);
            this.r = r5.r();
            this.s = r5.s();
            this.t = r5.t();
            this.u = r5.u();
            this.v = r5.v();
            this.w = r5.w();
            this.x = r5.x();
            this.y = r5.y();
            this.z = r5.z();
            this.A = r5.A();
            this.B = r5.B();
            this.C = r5.C();
            this.D = r5.D();
        }

        public final a a(p r4) {
            d.h.b.o.e(r4, "dispatcher");
            ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).f40241a = r4;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public final a a(k r4) {
            d.h.b.o.e(r4, "connectionPool");
            ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).f40242b = r4;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public final a a(w r5) {
            w r6 = (w) ZeusTransformUtils.wrapperContextForParams(r5, w.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r6, "interceptor");
            ((Collection) ZeusTransformUtils.preCheckCast(((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).f40243c, Collection.class, "com.obric.aiagent.plugin")).add(r6);
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public final a b(w r5) {
            w r6 = (w) ZeusTransformUtils.wrapperContextForParams(r5, w.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r6, "interceptor");
            ((Collection) ZeusTransformUtils.preCheckCast(((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).f40244d, Collection.class, "com.obric.aiagent.plugin")).add(r6);
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public final a a(r r4) {
            d.h.b.o.e(r4, "eventListener");
            a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            r2.f40245e = okhttp3.internal.c.a(r4);
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public final a a(boolean r4) {
            ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).f = r4;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public final a b(boolean r4) {
            ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).h = r4;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public final a c(boolean r4) {
            ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).i = r4;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public final a a(n r4) {
            n r5 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "cookieJar");
            ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).j = r5;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public final a a(q r5) {
            q r6 = (q) ZeusTransformUtils.wrapperContextForParams(r5, q.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r6, "dns");
            a r1 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(r6, r1.l) == true) goto L5;
            r1.D = null;
        L5:
            r1.l = r6;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public final a a(Proxy r5) {
            a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(r5, r2.m) == true) goto L5;
            r2.D = null;
        L5:
            r2.m = r5;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public final a a(okhttp3.b r5) {
            okhttp3.b r6 = (okhttp3.b) ZeusTransformUtils.wrapperContextForParams(r5, okhttp3.b.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r6, "proxyAuthenticator");
            a r1 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(r6, r1.o) == true) goto L5;
            r1.D = null;
        L5:
            r1.o = r6;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public final a a(SSLSocketFactory r5) {
            d.h.b.o.e(r5, "sslSocketFactory");
            a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(r5, r2.q) == true) goto L5;
            r2.D = null;
        L5:
            r2.q = r5;
            X509TrustManager r3 = okhttp3.internal.i.h.f40147b.a().a(r5);
            if (r3 == null) goto L10;
            r2.r = r3;
            okhttp3.internal.i.h r6 = okhttp3.internal.i.h.f40147b.a();
            X509TrustManager r4 = r2.r;
            d.h.b.o.a(r4);
            r2.w = r6.a(r4);
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        L10:
            throw new IllegalStateException("Unable to extract the trust manager on " + okhttp3.internal.i.h.f40147b.a() + ", sslSocketFactory is " + r5.getClass());
        }

        public final a a(SSLSocketFactory r5, X509TrustManager r6) {
            X509TrustManager r7 = (X509TrustManager) ZeusTransformUtils.wrapperContextForParams(r6, X509TrustManager.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "sslSocketFactory");
            d.h.b.o.e(r7, "trustManager");
            a r1 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(r5, r1.q) == true) goto L5;
        L6:
            r1.D = null;
        L7:
            r1.q = r5;
            r1.w = okhttp3.internal.k.c.f40153b.a(r7);
            r1.r = r7;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        L5:
            if (d.h.b.o.a(r7, r1.r) == true) goto L7;
            goto L6
        }

        public final a a(List<l> r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r6, "connectionSpecs");
            a r1 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(r6, r1.s) == true) goto L5;
            r1.D = null;
        L5:
            r1.s = okhttp3.internal.c.b(r6);
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public final a b(List<? extends aa> r7) {
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r8, "protocols");
            a r1 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            List r9 = d.a.p.g((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin"));
            boolean r4 = false;
            if (r9.contains(aa.f) == false) goto L5;
        L8:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L32;
            if (r9.contains(aa.f) == true) goto L13;
        L14:
            r4 = true;
        L15:
            if (r4 == false) goto L30;
            if ((!r9.contains(aa.f39694b)) == false) goto L28;
            d.h.b.o.a(r9, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Protocol?>");
            if ((!r9.contains(null)) == false) goto L26;
            r9.remove(aa.f39696d);
            if (d.h.b.o.a(r9, r1.t) == true) goto L23;
            r1.D = null;
        L23:
            List<? extends aa> r10 = Collections.unmodifiableList(r9);
            d.h.b.o.c(r10, "unmodifiableList(protocolsCopy)");
            r1.t = r10;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        L26:
            throw new IllegalArgumentException("protocols must not contain null".toString());
        L28:
            throw new IllegalArgumentException(("protocols must not contain http/1.0: " + r9).toString());
        L30:
            throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + r9).toString());
        L13:
            if (r9.size() > 1) goto L15;
        L32:
            throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + r9).toString());
        L5:
            if (r9.contains(aa.f39695c) == true) goto L8;
            r3 = false;
            goto L9
        }

        public final a a(long r5, TimeUnit r7) {
            d.h.b.o.e(r7, Scraps.INNER_UNIT);
            a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            r2.y = okhttp3.internal.c.a("timeout", r5, r7);
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public final a b(long r5, TimeUnit r7) {
            d.h.b.o.e(r7, Scraps.INNER_UNIT);
            a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            r2.z = okhttp3.internal.c.a("timeout", r5, r7);
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public final a c(long r5, TimeUnit r7) {
            d.h.b.o.e(r7, Scraps.INNER_UNIT);
            a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            r2.A = okhttp3.internal.c.a("timeout", r5, r7);
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public final z E() {
            return new z(this);
        }
    }

    /* JADX INFO: compiled from: OkHttpClient.kt */
    public static final class b {
        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }

        public final List<aa> a() {
            return z.F();
        }

        public final List<l> b() {
            return z.G();
        }
    }

    public z(a r6) {
        d.h.b.o.e(r6, "builder");
        this.f40237b = r6.a();
        this.f40238c = r6.b();
        this.f40239d = okhttp3.internal.c.b(r6.c());
        this.f40240e = okhttp3.internal.c.b(r6.d());
        this.f = r6.e();
        this.g = r6.f();
        this.h = r6.g();
        this.i = r6.h();
        this.j = r6.i();
        this.k = r6.j();
        this.l = r6.k();
        this.m = r6.l();
        this.n = r6.m();
        if (r6.m() == null) goto L5;
        ProxySelector r0 = (ProxySelector) ZeusTransformUtils.preCheckCast(okhttp3.internal.j.a.f40149a, ProxySelector.class, "com.obric.aiagent.plugin");
    L10:
        this.o = r0;
        this.p = r6.o();
        this.q = r6.p();
        List<l> r1 = r6.s();
        this.t = r1;
        this.u = r6.t();
        this.v = r6.u();
        this.y = r6.x();
        this.z = r6.y();
        this.A = r6.z();
        this.B = r6.A();
        this.C = r6.B();
        this.D = r6.C();
        okhttp3.internal.d.h r2 = r6.D();
        if (r2 != null) goto L13;
        r2 = new okhttp3.internal.d.h();
    L13:
        this.E = r2;
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
        boolean r4 = true;
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L16;
    L18:
        Iterator r5 = r3.iterator();
    L20:
        if (r5.hasNext() == false) goto L24;
        if (((l) ZeusTransformUtils.preCheckCast(r5.next(), l.class, "com.obric.aiagent.plugin")).a() == false) goto L20;
        r4 = false;
    L24:
        if (r4 == false) goto L27;
        this.r = null;
        this.x = null;
        this.s = null;
        this.w = g.f39771b;
    L30:
        H();
        return;
    L27:
        if (r6.q() == null) goto L29;
        this.r = r6.q();
        okhttp3.internal.k.c r7 = r6.w();
        d.h.b.o.a(r7);
        this.x = r7;
        X509TrustManager r8 = r6.r();
        d.h.b.o.a(r8);
        this.s = r8;
        g r9 = r6.v();
        d.h.b.o.a(r7);
        this.w = r9.a(r7);
        goto L30
    L29:
        X509TrustManager r10 = okhttp3.internal.i.h.f40147b.a().b();
        this.s = r10;
        okhttp3.internal.i.h r11 = okhttp3.internal.i.h.f40147b.a();
        d.h.b.o.a(r10);
        this.r = r11.c(r10);
        okhttp3.internal.k.c.a r12 = okhttp3.internal.k.c.f40153b;
        d.h.b.o.a(r10);
        okhttp3.internal.k.c r13 = r12.a(r10);
        this.x = r13;
        g r14 = r6.v();
        d.h.b.o.a(r13);
        this.w = r14.a(r13);
        goto L30
    L16:
        if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L18;
    L5:
        r0 = r6.n();
        if (r0 != null) goto L8;
        r0 = ProxySelector.getDefault();
    L8:
        if (r0 != null) goto L10;
        r0 = (ProxySelector) ZeusTransformUtils.preCheckCast(okhttp3.internal.j.a.f40149a, ProxySelector.class, "com.obric.aiagent.plugin");
        goto L10
    }

    public static final /* synthetic */ List F() {
        return F;
    }

    public static final /* synthetic */ List G() {
        return G;
    }

    public static final /* synthetic */ SSLSocketFactory a(z r0) {
        return r0.r;
    }

    public Object clone() {
        return super.clone();
    }

    public final p a() {
        return this.f40237b;
    }

    public final k b() {
        return this.f40238c;
    }

    public final List<w> c() {
        return this.f40239d;
    }

    public final List<w> d() {
        return this.f40240e;
    }

    public final r.c e() {
        return this.f;
    }

    public final boolean f() {
        return this.g;
    }

    public final okhttp3.b g() {
        return this.h;
    }

    public final boolean h() {
        return this.i;
    }

    public final boolean i() {
        return this.j;
    }

    public final n j() {
        return this.k;
    }

    public final c k() {
        return this.l;
    }

    public final q l() {
        return this.m;
    }

    public final Proxy m() {
        return this.n;
    }

    public final ProxySelector n() {
        return this.o;
    }

    public final okhttp3.b o() {
        return this.p;
    }

    public final SocketFactory p() {
        return this.q;
    }

    public final SSLSocketFactory q() {
        SSLSocketFactory r1 = this.r;
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    public final X509TrustManager r() {
        return this.s;
    }

    public final List<l> s() {
        return this.t;
    }

    public final List<aa> t() {
        return this.u;
    }

    public final HostnameVerifier u() {
        return this.v;
    }

    public final g v() {
        return this.w;
    }

    public final okhttp3.internal.k.c w() {
        return this.x;
    }

    public final int x() {
        return this.y;
    }

    public final int y() {
        return this.z;
    }

    public final int z() {
        return this.A;
    }

    public final int A() {
        return this.B;
    }

    public final int B() {
        return this.C;
    }

    public final long C() {
        return this.D;
    }

    public final okhttp3.internal.d.h D() {
        return this.E;
    }

    public z() {
        this(new a());
    }

    private final void H() {
        List<w> r0 = this.f40239d;
        d.h.b.o.a(r0, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        boolean r3 = true;
        if ((!r0.contains(null)) == false) goto L61;
        List<w> r1 = this.f40240e;
        d.h.b.o.a(r1, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if ((!r1.contains(null)) == false) goto L59;
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(this.t, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, Collection.class) == true) goto L9;
    L11:
        Iterator r4 = r2.iterator();
    L13:
        if (r4.hasNext() == false) goto L10;
        if (((l) ZeusTransformUtils.preCheckCast(r4.next(), l.class, "com.obric.aiagent.plugin")).a() == false) goto L13;
        boolean r5 = false;
    L17:
        if (r5 == false) goto L46;
        if (this.r != null) goto L21;
        boolean r6 = true;
    L23:
        if (r6 == false) goto L44;
        if (this.x != null) goto L27;
        boolean r7 = true;
    L28:
        if (r7 == false) goto L42;
        if (this.s == null) goto L33;
        r3 = false;
    L33:
        if (r3 == false) goto L40;
        if (d.h.b.o.a(this.w, g.f39771b) == false) goto L38;
        return;
    L38:
        throw new IllegalStateException("Check failed.".toString());
    L40:
        throw new IllegalStateException("Check failed.".toString());
    L42:
        throw new IllegalStateException("Check failed.".toString());
    L27:
        r7 = false;
        goto L28
    L44:
        throw new IllegalStateException("Check failed.".toString());
    L21:
        r6 = false;
        goto L23
    L46:
        if (this.r == null) goto L57;
        if (this.x == null) goto L55;
        if (this.s == null) goto L53;
        return;
    L53:
        throw new IllegalStateException("x509TrustManager == null".toString());
    L55:
        throw new IllegalStateException("certificateChainCleaner == null".toString());
    L57:
        throw new IllegalStateException("sslSocketFactory == null".toString());
    L10:
        r5 = true;
        goto L17
    L9:
        if (((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L11;
    L59:
        throw new IllegalStateException(("Null network interceptor: " + this.f40240e).toString());
    L61:
        throw new IllegalStateException(("Null interceptor: " + this.f40239d).toString());
    }

    public e a(ab r3) {
        d.h.b.o.e(r3, Ext.KEY_REQUEST);
        return (e) ZeusTransformUtils.preCheckCast(new okhttp3.internal.d.e(this, r3, false), e.class, "com.obric.aiagent.plugin");
    }

    public a E() {
        return new a(this);
    }

    static {
        f40236a = new b(null);
        F = okhttp3.internal.c.a(new aa[]{aa.f39697e, aa.f39695c});
        G = okhttp3.internal.c.a(new l[]{l.f40166c, l.f40168e});
    }
}
