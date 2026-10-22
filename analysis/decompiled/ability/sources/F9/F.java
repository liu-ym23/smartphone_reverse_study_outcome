package F9;

import java.net.Proxy;
import java.net.ProxySelector;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;

/* loaded from: classes4.dex */
public final class F implements Cloneable, InterfaceC0228f {

    /* renamed from: C, reason: collision with root package name */
    public static final List f612C = G9.b.j(Protocol.HTTP_2, Protocol.HTTP_1_1);

    /* renamed from: D, reason: collision with root package name */
    public static final List f613D = G9.b.j(C0235m.e, C0235m.f);

    /* renamed from: A, reason: collision with root package name */
    public final long f614A;

    /* renamed from: B, reason: collision with root package name */
    public final h2.d f615B;

    /* renamed from: a, reason: collision with root package name */
    public final C0238p f616a;
    public final C0233k b;
    public final List c;
    public final List d;
    public final s e;
    public final boolean f;
    public final InterfaceC0224b g;
    public final boolean h;
    public final boolean i;

    /* renamed from: j, reason: collision with root package name */
    public final C0237o f617j;
    public final InterfaceC0239q k;
    public final Proxy l;
    public final ProxySelector m;
    public final InterfaceC0224b n;
    public final SocketFactory o;
    public final SSLSocketFactory p;

    /* renamed from: q, reason: collision with root package name */
    public final X509TrustManager f618q;

    /* renamed from: r, reason: collision with root package name */
    public final List f619r;

    /* renamed from: s, reason: collision with root package name */
    public final List f620s;

    /* renamed from: t, reason: collision with root package name */
    public final HostnameVerifier f621t;
    public final okhttp3.a u;

    /* renamed from: v, reason: collision with root package name */
    public final S9.c f622v;

    /* renamed from: w, reason: collision with root package name */
    public final int f623w;

    /* renamed from: x, reason: collision with root package name */
    public final int f624x;
    public final int y;

    /* renamed from: z, reason: collision with root package name */
    public final int f625z;

    public F(E e) throws NoSuchAlgorithmException, KeyStoreException {
        ProxySelector proxySelector;
        this.f616a = e.f602a;
        this.b = e.b;
        this.c = G9.b.w(e.c);
        this.d = G9.b.w(e.d);
        this.e = e.e;
        this.f = e.f;
        this.g = e.g;
        this.h = e.h;
        this.i = e.i;
        this.f617j = e.f603j;
        this.k = e.k;
        Proxy proxy = e.l;
        this.l = proxy;
        if (proxy != null) {
            proxySelector = P9.a.f1092a;
        } else {
            proxySelector = e.m;
            proxySelector = proxySelector == null ? ProxySelector.getDefault() : proxySelector;
            if (proxySelector == null) {
                proxySelector = P9.a.f1092a;
            }
        }
        this.m = proxySelector;
        this.n = e.n;
        this.o = e.o;
        List list = e.f605r;
        this.f619r = list;
        this.f620s = e.f606s;
        this.f621t = e.f607t;
        this.f623w = e.f609w;
        this.f624x = e.f610x;
        this.y = e.y;
        this.f625z = e.f611z;
        this.f614A = e.f600A;
        h2.d dVar = e.f601B;
        if (dVar == null) {
            dVar = new h2.d();
            dVar.f4555a = new LinkedHashSet();
        }
        this.f615B = dVar;
        List list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            this.p = null;
            this.f622v = null;
            this.f618q = null;
            this.u = okhttp3.a.c;
        } else {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                if (((C0235m) it.next()).f650a) {
                    SSLSocketFactory sSLSocketFactory = e.p;
                    if (sSLSocketFactory != null) {
                        this.p = sSLSocketFactory;
                        S9.c cVar = e.f608v;
                        kotlin.jvm.internal.k.c(cVar);
                        this.f622v = cVar;
                        X509TrustManager x509TrustManager = e.f604q;
                        kotlin.jvm.internal.k.c(x509TrustManager);
                        this.f618q = x509TrustManager;
                        okhttp3.a aVar = e.u;
                        aVar.getClass();
                        this.u = kotlin.jvm.internal.k.b(aVar.b, cVar) ? aVar : new okhttp3.a(aVar.f5466a, cVar);
                    } else {
                        N9.l lVar = N9.m.Companion;
                        lVar.getClass();
                        X509TrustManager x509TrustManagerPlatformTrustManager = N9.m.platform.platformTrustManager();
                        this.f618q = x509TrustManagerPlatformTrustManager;
                        N9.m mVar = N9.m.platform;
                        kotlin.jvm.internal.k.c(x509TrustManagerPlatformTrustManager);
                        this.p = mVar.newSslSocketFactory(x509TrustManagerPlatformTrustManager);
                        lVar.getClass();
                        S9.c cVarBuildCertificateChainCleaner = N9.m.platform.buildCertificateChainCleaner(x509TrustManagerPlatformTrustManager);
                        this.f622v = cVarBuildCertificateChainCleaner;
                        okhttp3.a aVar2 = e.u;
                        kotlin.jvm.internal.k.c(cVarBuildCertificateChainCleaner);
                        aVar2.getClass();
                        this.u = kotlin.jvm.internal.k.b(aVar2.b, cVarBuildCertificateChainCleaner) ? aVar2 : new okhttp3.a(aVar2.f5466a, cVarBuildCertificateChainCleaner);
                    }
                }
            }
            this.p = null;
            this.f622v = null;
            this.f618q = null;
            this.u = okhttp3.a.c;
        }
        X509TrustManager x509TrustManager2 = this.f618q;
        S9.c cVar2 = this.f622v;
        SSLSocketFactory sSLSocketFactory2 = this.p;
        List list3 = this.d;
        List list4 = this.c;
        kotlin.jvm.internal.k.d(list4, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (list4.contains(null)) {
            throw new IllegalStateException(("Null interceptor: " + list4).toString());
        }
        kotlin.jvm.internal.k.d(list3, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (list3.contains(null)) {
            throw new IllegalStateException(("Null network interceptor: " + list3).toString());
        }
        List list5 = this.f619r;
        if (!(list5 instanceof Collection) || !list5.isEmpty()) {
            Iterator it2 = list5.iterator();
            while (it2.hasNext()) {
                if (((C0235m) it2.next()).f650a) {
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
        if (!kotlin.jvm.internal.k.b(this.u, okhttp3.a.c)) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final E a() {
        E e = new E();
        e.f602a = this.f616a;
        e.b = this.b;
        D7.A.e0(this.c, e.c);
        D7.A.e0(this.d, e.d);
        e.e = this.e;
        e.f = this.f;
        e.g = this.g;
        e.h = this.h;
        e.i = this.i;
        e.f603j = this.f617j;
        e.k = this.k;
        e.l = this.l;
        e.m = this.m;
        e.n = this.n;
        e.o = this.o;
        e.p = this.p;
        e.f604q = this.f618q;
        e.f605r = this.f619r;
        e.f606s = this.f620s;
        e.f607t = this.f621t;
        e.u = this.u;
        e.f608v = this.f622v;
        e.f609w = this.f623w;
        e.f610x = this.f624x;
        e.y = this.y;
        e.f611z = this.f625z;
        e.f600A = this.f614A;
        e.f601B = this.f615B;
        return e;
    }

    public final Object clone() {
        return super.clone();
    }
}
