package ad;

import ad.b;
import ad.i;
import java.net.ProxySelector;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.CertificatePinner;
import okhttp3.Protocol;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class n implements b.a {
    public static final List<Protocol> F = bd.l.f(Protocol.h, Protocol.f10881d);
    public static final List<okhttp3.e> G = bd.l.f(okhttp3.e.f10966g, okhttp3.e.h);
    public final int A;
    public final long B;
    public final stepos.support.v7.app.palette.b C;
    public final dd.e D;
    public final okhttp3.d E;

    /* renamed from: a, reason: collision with root package name */
    public final h f117a;

    /* renamed from: b, reason: collision with root package name */
    public final List<k> f118b;

    /* renamed from: c, reason: collision with root package name */
    public final List<k> f119c;

    /* renamed from: d, reason: collision with root package name */
    public final i.c f120d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f121e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f122f;

    /* renamed from: g, reason: collision with root package name */
    public final ad.a f123g;
    public final boolean h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f124i;

    /* renamed from: j, reason: collision with root package name */
    public final g f125j;

    /* renamed from: k, reason: collision with root package name */
    public final ad.a f126k;

    /* renamed from: l, reason: collision with root package name */
    public final ProxySelector f127l;

    /* renamed from: m, reason: collision with root package name */
    public final ad.a f128m;

    /* renamed from: n, reason: collision with root package name */
    public final SocketFactory f129n;

    /* renamed from: o, reason: collision with root package name */
    public final SSLSocketFactory f130o;

    /* renamed from: p, reason: collision with root package name */
    public final X509TrustManager f131p;

    /* renamed from: q, reason: collision with root package name */
    public final List<okhttp3.e> f132q;
    public final List<Protocol> r;

    /* renamed from: s, reason: collision with root package name */
    public final od.d f133s;

    /* renamed from: t, reason: collision with root package name */
    public final CertificatePinner f134t;

    /* renamed from: u, reason: collision with root package name */
    public final od.c f135u;

    /* renamed from: v, reason: collision with root package name */
    public final int f136v;

    /* renamed from: w, reason: collision with root package name */
    public final int f137w;

    /* renamed from: x, reason: collision with root package name */
    public final int f138x;

    /* renamed from: y, reason: collision with root package name */
    public final int f139y;
    public final int z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public int A;
        public int B;
        public long C;
        public stepos.support.v7.app.palette.b D;
        public dd.e E;

        /* renamed from: b, reason: collision with root package name */
        public okhttp3.d f141b;

        /* renamed from: e, reason: collision with root package name */
        public i.c f144e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f145f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f146g;
        public ad.a h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f147i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f148j;

        /* renamed from: k, reason: collision with root package name */
        public g f149k;

        /* renamed from: l, reason: collision with root package name */
        public ad.a f150l;

        /* renamed from: m, reason: collision with root package name */
        public ProxySelector f151m;

        /* renamed from: n, reason: collision with root package name */
        public ad.a f152n;

        /* renamed from: o, reason: collision with root package name */
        public SocketFactory f153o;

        /* renamed from: p, reason: collision with root package name */
        public SSLSocketFactory f154p;

        /* renamed from: q, reason: collision with root package name */
        public X509TrustManager f155q;
        public List<okhttp3.e> r;

        /* renamed from: s, reason: collision with root package name */
        public List<? extends Protocol> f156s;

        /* renamed from: t, reason: collision with root package name */
        public od.d f157t;

        /* renamed from: u, reason: collision with root package name */
        public CertificatePinner f158u;

        /* renamed from: v, reason: collision with root package name */
        public od.c f159v;

        /* renamed from: w, reason: collision with root package name */
        public int f160w;

        /* renamed from: x, reason: collision with root package name */
        public int f161x;

        /* renamed from: y, reason: collision with root package name */
        public int f162y;
        public int z;

        /* renamed from: a, reason: collision with root package name */
        public h f140a = new h();

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f142c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        public final ArrayList f143d = new ArrayList();

        public a() {
            i iVar = i.NONE;
            okhttp3.f fVar = bd.l.f3237a;
            kotlin.jvm.internal.g.f(iVar, "<this>");
            this.f144e = new bd.j(iVar);
            this.f145f = true;
            this.f146g = true;
            ad.a aVar = ad.a.f73a;
            this.h = aVar;
            this.f147i = true;
            this.f148j = true;
            this.f149k = g.f89a;
            this.f150l = ad.a.f74b;
            this.f152n = aVar;
            SocketFactory socketFactory = SocketFactory.getDefault();
            kotlin.jvm.internal.g.e(socketFactory, "getDefault(...)");
            this.f153o = socketFactory;
            this.r = n.G;
            this.f156s = n.F;
            this.f157t = od.d.f10858a;
            this.f158u = CertificatePinner.f10859c;
            this.f161x = 10000;
            this.f162y = 10000;
            this.z = 10000;
            this.B = 60000;
            this.C = 1024L;
        }

        public final void a(k interceptor) {
            kotlin.jvm.internal.g.f(interceptor, "interceptor");
            this.f142c.add(interceptor);
        }

        public final void b(long j10, TimeUnit unit) {
            kotlin.jvm.internal.g.f(unit, "unit");
            this.f161x = bd.l.b("timeout", j10, unit);
        }

        public final void c(long j10, TimeUnit unit) {
            kotlin.jvm.internal.g.f(unit, "unit");
            this.f162y = bd.l.b("timeout", j10, unit);
        }

        public final void d(long j10, TimeUnit unit) {
            kotlin.jvm.internal.g.f(unit, "unit");
            this.z = bd.l.b("timeout", j10, unit);
        }
    }

    public n(a aVar) throws NoSuchAlgorithmException, KeyStoreException {
        CertificatePinner certificatePinner = aVar.f158u;
        this.f117a = aVar.f140a;
        this.f118b = bd.l.l(aVar.f142c);
        this.f119c = bd.l.l(aVar.f143d);
        this.f120d = aVar.f144e;
        boolean z = aVar.f145f;
        this.f121e = z;
        boolean z3 = aVar.f146g;
        this.f122f = z3;
        this.f123g = aVar.h;
        this.h = aVar.f147i;
        this.f124i = aVar.f148j;
        this.f125j = aVar.f149k;
        this.f126k = aVar.f150l;
        ProxySelector proxySelector = aVar.f151m;
        proxySelector = proxySelector == null ? ProxySelector.getDefault() : proxySelector;
        this.f127l = proxySelector == null ? md.a.f10571a : proxySelector;
        this.f128m = aVar.f152n;
        this.f129n = aVar.f153o;
        List<okhttp3.e> list = aVar.r;
        this.f132q = list;
        this.r = aVar.f156s;
        this.f133s = aVar.f157t;
        this.f136v = aVar.f160w;
        int i10 = aVar.f161x;
        this.f137w = i10;
        int i11 = aVar.f162y;
        this.f138x = i11;
        int i12 = aVar.z;
        this.f139y = i12;
        int i13 = aVar.A;
        this.z = i13;
        this.A = aVar.B;
        this.B = aVar.C;
        stepos.support.v7.app.palette.b bVar = aVar.D;
        stepos.support.v7.app.palette.b bVar2 = bVar == null ? new stepos.support.v7.app.palette.b(6) : bVar;
        this.C = bVar2;
        dd.e eVar = aVar.E;
        this.D = eVar == null ? dd.e.f8479l : eVar;
        okhttp3.d dVar = aVar.f141b;
        if (dVar == null) {
            dVar = new okhttp3.d(null, null, i11, i12, i10, i11, i13, z, z3, bVar2, 31);
            aVar.f141b = dVar;
        }
        this.E = dVar;
        if (list == null || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((okhttp3.e) it.next()).f10967a) {
                    SSLSocketFactory sSLSocketFactory = aVar.f154p;
                    if (sSLSocketFactory != null) {
                        this.f130o = sSLSocketFactory;
                        od.c cVar = aVar.f159v;
                        kotlin.jvm.internal.g.c(cVar);
                        this.f135u = cVar;
                        X509TrustManager x509TrustManager = aVar.f155q;
                        kotlin.jvm.internal.g.c(x509TrustManager);
                        this.f131p = x509TrustManager;
                        certificatePinner.getClass();
                        this.f134t = kotlin.jvm.internal.g.b(certificatePinner.f10861b, cVar) ? certificatePinner : new CertificatePinner(certificatePinner.f10860a, cVar);
                    } else {
                        kd.h.Companion.getClass();
                        X509TrustManager x509TrustManagerPlatformTrustManager = kd.h.platform.platformTrustManager();
                        this.f131p = x509TrustManagerPlatformTrustManager;
                        kd.h hVar = kd.h.platform;
                        kotlin.jvm.internal.g.c(x509TrustManagerPlatformTrustManager);
                        this.f130o = hVar.newSslSocketFactory(x509TrustManagerPlatformTrustManager);
                        od.c cVarBuildCertificateChainCleaner = kd.h.platform.buildCertificateChainCleaner(x509TrustManagerPlatformTrustManager);
                        this.f135u = cVarBuildCertificateChainCleaner;
                        kotlin.jvm.internal.g.c(cVarBuildCertificateChainCleaner);
                        certificatePinner.getClass();
                        this.f134t = kotlin.jvm.internal.g.b(certificatePinner.f10861b, cVarBuildCertificateChainCleaner) ? certificatePinner : new CertificatePinner(certificatePinner.f10860a, cVarBuildCertificateChainCleaner);
                    }
                }
            }
            this.f130o = null;
            this.f135u = null;
            this.f131p = null;
            this.f134t = CertificatePinner.f10859c;
        } else {
            this.f130o = null;
            this.f135u = null;
            this.f131p = null;
            this.f134t = CertificatePinner.f10859c;
        }
        X509TrustManager x509TrustManager2 = this.f131p;
        od.c cVar2 = this.f135u;
        SSLSocketFactory sSLSocketFactory2 = this.f130o;
        List<k> list2 = this.f119c;
        List<k> list3 = this.f118b;
        kotlin.jvm.internal.g.d(list3, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (list3.contains(null)) {
            throw new IllegalStateException(("Null interceptor: " + list3).toString());
        }
        kotlin.jvm.internal.g.d(list2, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (list2.contains(null)) {
            throw new IllegalStateException(("Null network interceptor: " + list2).toString());
        }
        List<okhttp3.e> list4 = this.f132q;
        if (list4 == null || !list4.isEmpty()) {
            Iterator<T> it2 = list4.iterator();
            while (it2.hasNext()) {
                if (((okhttp3.e) it2.next()).f10967a) {
                    if (sSLSocketFactory2 == null) {
                        throw new IllegalStateException("sslSocketFactory == null");
                    }
                    if (cVar2 == null) {
                        throw new IllegalStateException("certificateChainCleaner == null");
                    }
                    if (x509TrustManager2 == null) {
                        throw new IllegalStateException("x509TrustManager == null");
                    }
                    return;
                }
            }
        }
        if (sSLSocketFactory2 != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (cVar2 != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (x509TrustManager2 != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (!kotlin.jvm.internal.g.b(this.f134t, CertificatePinner.f10859c)) {
            throw new IllegalStateException("Check failed.");
        }
    }

    @Override // ad.b.a
    public final okhttp3.internal.connection.d a(okhttp3.h request) {
        kotlin.jvm.internal.g.f(request, "request");
        return new okhttp3.internal.connection.d(this, request, false);
    }

    public final a b() {
        a aVar = new a();
        aVar.f140a = this.f117a;
        aVar.f141b = this.E;
        mb.q.g0(aVar.f142c, this.f118b);
        mb.q.g0(aVar.f143d, this.f119c);
        aVar.f144e = this.f120d;
        aVar.f145f = this.f121e;
        aVar.f146g = this.f122f;
        aVar.h = this.f123g;
        aVar.f147i = this.h;
        aVar.f148j = this.f124i;
        aVar.f149k = this.f125j;
        aVar.f150l = this.f126k;
        aVar.f151m = this.f127l;
        aVar.f152n = this.f128m;
        aVar.f153o = this.f129n;
        aVar.f154p = this.f130o;
        aVar.f155q = this.f131p;
        aVar.r = this.f132q;
        aVar.f156s = this.r;
        aVar.f157t = this.f133s;
        aVar.f158u = this.f134t;
        aVar.f159v = this.f135u;
        aVar.f160w = this.f136v;
        aVar.f161x = this.f137w;
        aVar.f162y = this.f138x;
        aVar.z = this.f139y;
        aVar.A = this.z;
        aVar.B = this.A;
        aVar.C = this.B;
        aVar.D = this.C;
        aVar.E = this.D;
        return aVar;
    }

    public n() {
        this(new a());
    }
}
