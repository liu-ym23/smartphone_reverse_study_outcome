package C4;

import C4.F;
import C4.InterfaceC0275e;
import C4.s;
import C4.v;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public class A implements Cloneable, InterfaceC0275e.a {

    /* renamed from: A, reason: collision with root package name */
    static final List<B> f609A = D4.e.u(B.HTTP_2, B.HTTP_1_1);

    /* renamed from: B, reason: collision with root package name */
    static final List<l> f610B = D4.e.u(l.f910h, l.f912j);

    /* renamed from: a, reason: collision with root package name */
    final o f611a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    final Proxy f612b;

    /* renamed from: c, reason: collision with root package name */
    final List<B> f613c;

    /* renamed from: d, reason: collision with root package name */
    final List<l> f614d;

    /* renamed from: e, reason: collision with root package name */
    final List<x> f615e;

    /* renamed from: f, reason: collision with root package name */
    final List<x> f616f;

    /* renamed from: g, reason: collision with root package name */
    final s.b f617g;

    /* renamed from: h, reason: collision with root package name */
    final ProxySelector f618h;

    /* renamed from: i, reason: collision with root package name */
    final n f619i;

    /* renamed from: j, reason: collision with root package name */
    final SocketFactory f620j;

    /* renamed from: k, reason: collision with root package name */
    final SSLSocketFactory f621k;

    /* renamed from: l, reason: collision with root package name */
    final K4.c f622l;

    /* renamed from: m, reason: collision with root package name */
    final HostnameVerifier f623m;

    /* renamed from: n, reason: collision with root package name */
    final C0277g f624n;

    /* renamed from: o, reason: collision with root package name */
    final InterfaceC0273c f625o;

    /* renamed from: p, reason: collision with root package name */
    final InterfaceC0273c f626p;

    /* renamed from: q, reason: collision with root package name */
    final k f627q;

    /* renamed from: r, reason: collision with root package name */
    final q f628r;

    /* renamed from: s, reason: collision with root package name */
    final boolean f629s;

    /* renamed from: t, reason: collision with root package name */
    final boolean f630t;

    /* renamed from: u, reason: collision with root package name */
    final boolean f631u;

    /* renamed from: v, reason: collision with root package name */
    final int f632v;

    /* renamed from: w, reason: collision with root package name */
    final int f633w;

    /* renamed from: x, reason: collision with root package name */
    final int f634x;

    /* renamed from: y, reason: collision with root package name */
    final int f635y;

    /* renamed from: z, reason: collision with root package name */
    final int f636z;

    class a extends D4.a {
        a() {
        }

        @Override // D4.a
        public void a(v.a aVar, String str) {
            aVar.c(str);
        }

        @Override // D4.a
        public void b(v.a aVar, String str, String str2) {
            aVar.d(str, str2);
        }

        @Override // D4.a
        public void c(l lVar, SSLSocket sSLSocket, boolean z5) {
            lVar.a(sSLSocket, z5);
        }

        @Override // D4.a
        public int d(F.a aVar) {
            return aVar.f712c;
        }

        @Override // D4.a
        public boolean e(C0271a c0271a, C0271a c0271a2) {
            return c0271a.d(c0271a2);
        }

        @Override // D4.a
        @Nullable
        public F4.c f(F f5) {
            return f5.f708m;
        }

        @Override // D4.a
        public void g(F.a aVar, F4.c cVar) {
            aVar.k(cVar);
        }

        @Override // D4.a
        public F4.g h(k kVar) {
            return kVar.f906a;
        }
    }

    public static final class b {

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        Proxy f638b;

        /* renamed from: h, reason: collision with root package name */
        ProxySelector f644h;

        /* renamed from: i, reason: collision with root package name */
        n f645i;

        /* renamed from: j, reason: collision with root package name */
        SocketFactory f646j;

        /* renamed from: k, reason: collision with root package name */
        @Nullable
        SSLSocketFactory f647k;

        /* renamed from: l, reason: collision with root package name */
        @Nullable
        K4.c f648l;

        /* renamed from: m, reason: collision with root package name */
        HostnameVerifier f649m;

        /* renamed from: n, reason: collision with root package name */
        C0277g f650n;

        /* renamed from: o, reason: collision with root package name */
        InterfaceC0273c f651o;

        /* renamed from: p, reason: collision with root package name */
        InterfaceC0273c f652p;

        /* renamed from: q, reason: collision with root package name */
        k f653q;

        /* renamed from: r, reason: collision with root package name */
        q f654r;

        /* renamed from: s, reason: collision with root package name */
        boolean f655s;

        /* renamed from: t, reason: collision with root package name */
        boolean f656t;

        /* renamed from: u, reason: collision with root package name */
        boolean f657u;

        /* renamed from: v, reason: collision with root package name */
        int f658v;

        /* renamed from: w, reason: collision with root package name */
        int f659w;

        /* renamed from: x, reason: collision with root package name */
        int f660x;

        /* renamed from: y, reason: collision with root package name */
        int f661y;

        /* renamed from: z, reason: collision with root package name */
        int f662z;

        /* renamed from: e, reason: collision with root package name */
        final List<x> f641e = new ArrayList();

        /* renamed from: f, reason: collision with root package name */
        final List<x> f642f = new ArrayList();

        /* renamed from: a, reason: collision with root package name */
        o f637a = new o();

        /* renamed from: c, reason: collision with root package name */
        List<B> f639c = A.f609A;

        /* renamed from: d, reason: collision with root package name */
        List<l> f640d = A.f610B;

        /* renamed from: g, reason: collision with root package name */
        s.b f643g = s.l(s.f944a);

        public b() {
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.f644h = proxySelector;
            if (proxySelector == null) {
                this.f644h = new J4.a();
            }
            this.f645i = n.f934a;
            this.f646j = SocketFactory.getDefault();
            this.f649m = K4.d.f3670a;
            this.f650n = C0277g.f776c;
            InterfaceC0273c interfaceC0273c = InterfaceC0273c.f752a;
            this.f651o = interfaceC0273c;
            this.f652p = interfaceC0273c;
            this.f653q = new k();
            this.f654r = q.f942a;
            this.f655s = true;
            this.f656t = true;
            this.f657u = true;
            this.f658v = 0;
            this.f659w = 10000;
            this.f660x = 10000;
            this.f661y = 10000;
            this.f662z = 0;
        }

        public b a(x xVar) {
            if (xVar == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.f641e.add(xVar);
            return this;
        }

        public A b() {
            return new A(this);
        }

        public b c(long j5, TimeUnit timeUnit) {
            this.f659w = D4.e.e("timeout", j5, timeUnit);
            return this;
        }

        public b d(k kVar) {
            if (kVar == null) {
                throw new NullPointerException("connectionPool == null");
            }
            this.f653q = kVar;
            return this;
        }

        public b e(long j5, TimeUnit timeUnit) {
            this.f660x = D4.e.e("timeout", j5, timeUnit);
            return this;
        }

        public b f(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            }
            if (x509TrustManager == null) {
                throw new NullPointerException("trustManager == null");
            }
            this.f647k = sSLSocketFactory;
            this.f648l = K4.c.b(x509TrustManager);
            return this;
        }

        public b g(long j5, TimeUnit timeUnit) {
            this.f661y = D4.e.e("timeout", j5, timeUnit);
            return this;
        }
    }

    static {
        D4.a.f1202a = new a();
    }

    public A() {
        this(new b());
    }

    private static SSLSocketFactory x(X509TrustManager x509TrustManager) throws KeyManagementException {
        try {
            SSLContext sSLContext = okhttp3.internal.platform.f.get().getSSLContext();
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e6) {
            throw new AssertionError("No System TLS", e6);
        }
    }

    @Nullable
    public Proxy A() {
        return this.f612b;
    }

    public InterfaceC0273c B() {
        return this.f625o;
    }

    public ProxySelector C() {
        return this.f618h;
    }

    public int D() {
        return this.f634x;
    }

    public boolean E() {
        return this.f631u;
    }

    public SocketFactory F() {
        return this.f620j;
    }

    public SSLSocketFactory G() {
        return this.f621k;
    }

    public int H() {
        return this.f635y;
    }

    @Override // C4.InterfaceC0275e.a
    public InterfaceC0275e b(D d6) {
        return C.g(this, d6, false);
    }

    public InterfaceC0273c d() {
        return this.f626p;
    }

    public int e() {
        return this.f632v;
    }

    public C0277g g() {
        return this.f624n;
    }

    public int h() {
        return this.f633w;
    }

    public k i() {
        return this.f627q;
    }

    public List<l> j() {
        return this.f614d;
    }

    public n k() {
        return this.f619i;
    }

    public o l() {
        return this.f611a;
    }

    public q n() {
        return this.f628r;
    }

    public s.b p() {
        return this.f617g;
    }

    public boolean q() {
        return this.f630t;
    }

    public boolean s() {
        return this.f629s;
    }

    public HostnameVerifier t() {
        return this.f623m;
    }

    public List<x> u() {
        return this.f615e;
    }

    @Nullable
    E4.c v() {
        return null;
    }

    public List<x> w() {
        return this.f616f;
    }

    public int y() {
        return this.f636z;
    }

    public List<B> z() {
        return this.f613c;
    }

    A(b bVar) throws NoSuchAlgorithmException, KeyStoreException {
        boolean z5;
        this.f611a = bVar.f637a;
        this.f612b = bVar.f638b;
        this.f613c = bVar.f639c;
        List<l> list = bVar.f640d;
        this.f614d = list;
        this.f615e = D4.e.t(bVar.f641e);
        this.f616f = D4.e.t(bVar.f642f);
        this.f617g = bVar.f643g;
        this.f618h = bVar.f644h;
        this.f619i = bVar.f645i;
        this.f620j = bVar.f646j;
        Iterator<l> it = list.iterator();
        loop0: while (true) {
            z5 = false;
            while (it.hasNext()) {
                z5 = (z5 || it.next().d()) ? true : z5;
            }
        }
        SSLSocketFactory sSLSocketFactory = bVar.f647k;
        if (sSLSocketFactory == null && z5) {
            X509TrustManager x509TrustManagerC = D4.e.C();
            this.f621k = x(x509TrustManagerC);
            this.f622l = K4.c.b(x509TrustManagerC);
        } else {
            this.f621k = sSLSocketFactory;
            this.f622l = bVar.f648l;
        }
        if (this.f621k != null) {
            okhttp3.internal.platform.f.get().configureSslSocketFactory(this.f621k);
        }
        this.f623m = bVar.f649m;
        this.f624n = bVar.f650n.f(this.f622l);
        this.f625o = bVar.f651o;
        this.f626p = bVar.f652p;
        this.f627q = bVar.f653q;
        this.f628r = bVar.f654r;
        this.f629s = bVar.f655s;
        this.f630t = bVar.f656t;
        this.f631u = bVar.f657u;
        this.f632v = bVar.f658v;
        this.f633w = bVar.f659w;
        this.f634x = bVar.f660x;
        this.f635y = bVar.f661y;
        this.f636z = bVar.f662z;
        if (this.f615e.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.f615e);
        }
        if (this.f616f.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.f616f);
        }
    }
}
