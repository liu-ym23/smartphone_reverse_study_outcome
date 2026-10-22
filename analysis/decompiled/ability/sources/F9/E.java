package F9;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes4.dex */
public final class E {

    /* renamed from: A, reason: collision with root package name */
    public long f600A;

    /* renamed from: B, reason: collision with root package name */
    public h2.d f601B;

    /* renamed from: a, reason: collision with root package name */
    public C0238p f602a = new C0238p();
    public C0233k b = new C0233k();
    public final ArrayList c = new ArrayList();
    public final ArrayList d = new ArrayList();
    public s e = new G4.a(2);
    public boolean f = true;
    public InterfaceC0224b g;
    public boolean h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public C0237o f603j;
    public InterfaceC0239q k;
    public Proxy l;
    public ProxySelector m;
    public InterfaceC0224b n;
    public SocketFactory o;
    public SSLSocketFactory p;

    /* renamed from: q, reason: collision with root package name */
    public X509TrustManager f604q;

    /* renamed from: r, reason: collision with root package name */
    public List f605r;

    /* renamed from: s, reason: collision with root package name */
    public List f606s;

    /* renamed from: t, reason: collision with root package name */
    public HostnameVerifier f607t;
    public okhttp3.a u;

    /* renamed from: v, reason: collision with root package name */
    public S9.c f608v;

    /* renamed from: w, reason: collision with root package name */
    public int f609w;

    /* renamed from: x, reason: collision with root package name */
    public int f610x;
    public int y;

    /* renamed from: z, reason: collision with root package name */
    public int f611z;

    public E() {
        C0237o c0237o = InterfaceC0224b.f638a;
        this.g = c0237o;
        this.h = true;
        this.i = true;
        this.f603j = C0237o.c;
        this.k = InterfaceC0239q.b;
        this.n = c0237o;
        SocketFactory socketFactory = SocketFactory.getDefault();
        kotlin.jvm.internal.k.e(socketFactory, "getDefault()");
        this.o = socketFactory;
        this.f605r = F.f613D;
        this.f606s = F.f612C;
        this.f607t = S9.d.f1183a;
        this.u = okhttp3.a.c;
        this.f610x = 10000;
        this.y = 10000;
        this.f611z = 10000;
        this.f600A = 1024L;
    }

    public final void a(A interceptor) {
        kotlin.jvm.internal.k.f(interceptor, "interceptor");
        this.c.add(interceptor);
    }

    public final void b(long j5, TimeUnit unit) {
        kotlin.jvm.internal.k.f(unit, "unit");
        this.f610x = G9.b.b(j5, unit);
    }

    public final void c(long j5, TimeUnit unit) {
        kotlin.jvm.internal.k.f(unit, "unit");
        this.y = G9.b.b(j5, unit);
    }

    public final void d(SSLSocketFactory sslSocketFactory, X509TrustManager trustManager) {
        kotlin.jvm.internal.k.f(sslSocketFactory, "sslSocketFactory");
        kotlin.jvm.internal.k.f(trustManager, "trustManager");
        if (!sslSocketFactory.equals(this.p) || !trustManager.equals(this.f604q)) {
            this.f601B = null;
        }
        this.p = sslSocketFactory;
        N9.m.Companion.getClass();
        this.f608v = N9.m.platform.buildCertificateChainCleaner(trustManager);
        this.f604q = trustManager;
    }

    public final void e(long j5, TimeUnit unit) {
        kotlin.jvm.internal.k.f(unit, "unit");
        this.f611z = G9.b.b(j5, unit);
    }
}
