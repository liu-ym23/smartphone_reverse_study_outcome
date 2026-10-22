package ab;

import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public final class s {
    public a7.d A;

    /* renamed from: a, reason: collision with root package name */
    public i5.f f601a = new i5.f(3);

    /* renamed from: b, reason: collision with root package name */
    public a7.d f602b = new a7.d(1);

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f603c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f604d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public b4.b f605e = new b4.b(4);

    /* renamed from: f, reason: collision with root package name */
    public boolean f606f = true;

    /* renamed from: g, reason: collision with root package name */
    public b f607g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f608h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f609i;

    /* renamed from: j, reason: collision with root package name */
    public b f610j;

    /* renamed from: k, reason: collision with root package name */
    public b f611k;

    /* renamed from: l, reason: collision with root package name */
    public ProxySelector f612l;

    /* renamed from: m, reason: collision with root package name */
    public b f613m;

    /* renamed from: n, reason: collision with root package name */
    public SocketFactory f614n;

    /* renamed from: o, reason: collision with root package name */
    public SSLSocketFactory f615o;

    /* renamed from: p, reason: collision with root package name */
    public X509TrustManager f616p;

    /* renamed from: q, reason: collision with root package name */
    public List f617q;

    /* renamed from: r, reason: collision with root package name */
    public List f618r;

    /* renamed from: s, reason: collision with root package name */
    public HostnameVerifier f619s;

    /* renamed from: t, reason: collision with root package name */
    public e f620t;

    /* renamed from: u, reason: collision with root package name */
    public w7.e0 f621u;

    /* renamed from: v, reason: collision with root package name */
    public int f622v;

    /* renamed from: w, reason: collision with root package name */
    public int f623w;

    /* renamed from: x, reason: collision with root package name */
    public int f624x;

    /* renamed from: y, reason: collision with root package name */
    public int f625y;

    /* renamed from: z, reason: collision with root package name */
    public long f626z;

    public s() {
        b bVar = b.f498a;
        this.f607g = bVar;
        this.f608h = true;
        this.f609i = true;
        this.f610j = b.f499b;
        this.f611k = b.f500c;
        this.f613m = bVar;
        SocketFactory socketFactory = SocketFactory.getDefault();
        q7.k.d(socketFactory, "getDefault()");
        this.f614n = socketFactory;
        this.f617q = t.H;
        this.f618r = t.G;
        this.f619s = mb.c.f6519a;
        this.f620t = e.f525c;
        this.f622v = 10000;
        this.f623w = 10000;
        this.f624x = 10000;
        this.f626z = 1024L;
    }

    public final void a(long j2, TimeUnit timeUnit) {
        q7.k.e(timeUnit, "unit");
        this.f622v = bb.b.b("timeout", j2, timeUnit);
    }

    public final void b(long j2, TimeUnit timeUnit) {
        q7.k.e(timeUnit, "unit");
        this.f623w = bb.b.b("timeout", j2, timeUnit);
    }

    public final void c(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
        if (!sSLSocketFactory.equals(this.f615o) || !x509TrustManager.equals(this.f616p)) {
            this.A = null;
        }
        this.f615o = sSLSocketFactory;
        ib.m mVar = ib.m.f5049a;
        this.f621u = ib.m.f5049a.b(x509TrustManager);
        this.f616p = x509TrustManager;
    }

    public final void d(long j2, TimeUnit timeUnit) {
        q7.k.e(timeUnit, "unit");
        this.f624x = bb.b.b("timeout", j2, timeUnit);
    }
}
