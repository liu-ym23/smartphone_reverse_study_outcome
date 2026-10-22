package n6;

import java.net.ProxySelector;
import java.util.Iterator;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.platform.Platform;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class q {
    public static final List E = o6.f.k(new r[]{r.f4122f, r.d});
    public static final List F = o6.f.k(new h[]{h.f4032e, h.f4033f});
    public final long A;
    public final androidx.emoji2.text.m B;
    public final q6.d C;
    public final androidx.emoji2.text.m D;

    /* renamed from: a, reason: collision with root package name */
    public final a1.w f4096a;

    /* renamed from: b, reason: collision with root package name */
    public final List f4097b;

    /* renamed from: c, reason: collision with root package name */
    public final List f4098c;
    public final a1.n d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f4099e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f4100f;

    /* renamed from: g, reason: collision with root package name */
    public final b f4101g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f4102h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f4103i;

    /* renamed from: j, reason: collision with root package name */
    public final b f4104j;

    /* renamed from: k, reason: collision with root package name */
    public final b f4105k;

    /* renamed from: l, reason: collision with root package name */
    public final ProxySelector f4106l;

    /* renamed from: m, reason: collision with root package name */
    public final b f4107m;

    /* renamed from: n, reason: collision with root package name */
    public final SocketFactory f4108n;

    /* renamed from: o, reason: collision with root package name */
    public final SSLSocketFactory f4109o;

    /* renamed from: p, reason: collision with root package name */
    public final X509TrustManager f4110p;

    /* renamed from: q, reason: collision with root package name */
    public final List f4111q;

    /* renamed from: r, reason: collision with root package name */
    public final List f4112r;

    /* renamed from: s, reason: collision with root package name */
    public final HostnameVerifier f4113s;

    /* renamed from: t, reason: collision with root package name */
    public final e f4114t;

    /* renamed from: u, reason: collision with root package name */
    public final z6.d f4115u;

    /* renamed from: v, reason: collision with root package name */
    public final int f4116v;

    /* renamed from: w, reason: collision with root package name */
    public final int f4117w;

    /* renamed from: x, reason: collision with root package name */
    public final int f4118x;
    public final int y;
    public final int z;

    public q(p pVar) {
        e eVar = pVar.f4092u;
        this.f4096a = pVar.f4073a;
        this.f4097b = o6.f.j(pVar.f4075c);
        this.f4098c = o6.f.j(pVar.d);
        this.d = pVar.f4076e;
        this.f4099e = pVar.f4077f;
        this.f4100f = pVar.f4078g;
        this.f4101g = pVar.f4079h;
        this.f4102h = pVar.f4080i;
        this.f4103i = pVar.f4081j;
        this.f4104j = pVar.f4082k;
        this.f4105k = pVar.f4083l;
        ProxySelector proxySelector = pVar.f4084m;
        if (proxySelector == null && (proxySelector = ProxySelector.getDefault()) == null) {
            proxySelector = x6.a.f6306a;
        }
        this.f4106l = proxySelector;
        this.f4107m = pVar.f4085n;
        this.f4108n = pVar.f4086o;
        List list = pVar.f4089r;
        this.f4111q = list;
        this.f4112r = pVar.f4090s;
        this.f4113s = pVar.f4091t;
        this.f4116v = pVar.f4094w;
        this.f4117w = pVar.f4095x;
        this.f4118x = pVar.y;
        this.y = pVar.z;
        this.z = pVar.A;
        this.A = pVar.B;
        androidx.emoji2.text.m mVar = pVar.C;
        this.B = mVar == null ? new androidx.emoji2.text.m(29) : mVar;
        q6.d dVar = pVar.D;
        this.C = dVar == null ? q6.d.f4879l : dVar;
        androidx.emoji2.text.m mVar2 = pVar.f4074b;
        if (mVar2 == null) {
            mVar2 = new androidx.emoji2.text.m(22);
            pVar.f4074b = mVar2;
        }
        this.D = mVar2;
        if (list == null || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((h) it.next()).f4034a) {
                    SSLSocketFactory sSLSocketFactory = pVar.f4087p;
                    if (sSLSocketFactory != null) {
                        this.f4109o = sSLSocketFactory;
                        z6.d dVar2 = pVar.f4093v;
                        kotlin.jvm.internal.p.b(dVar2);
                        this.f4115u = dVar2;
                        X509TrustManager x509TrustManager = pVar.f4088q;
                        kotlin.jvm.internal.p.b(x509TrustManager);
                        this.f4110p = x509TrustManager;
                        eVar.getClass();
                        this.f4114t = kotlin.jvm.internal.p.a(eVar.f4012b, dVar2) ? eVar : new e(eVar.f4011a, dVar2);
                    } else {
                        Platform.Companion companion = Platform.INSTANCE;
                        X509TrustManager trustManager = companion.get().platformTrustManager();
                        this.f4110p = trustManager;
                        this.f4109o = companion.get().newSslSocketFactory(trustManager);
                        z6.d.Companion.getClass();
                        kotlin.jvm.internal.p.e(trustManager, "trustManager");
                        z6.d certificateChainCleaner = companion.get().buildCertificateChainCleaner(trustManager);
                        this.f4115u = certificateChainCleaner;
                        eVar.getClass();
                        kotlin.jvm.internal.p.e(certificateChainCleaner, "certificateChainCleaner");
                        this.f4114t = kotlin.jvm.internal.p.a(eVar.f4012b, certificateChainCleaner) ? eVar : new e(eVar.f4011a, certificateChainCleaner);
                    }
                }
            }
            this.f4109o = null;
            this.f4115u = null;
            this.f4110p = null;
            this.f4114t = e.f4010c;
        } else {
            this.f4109o = null;
            this.f4115u = null;
            this.f4110p = null;
            this.f4114t = e.f4010c;
        }
        X509TrustManager x509TrustManager2 = this.f4110p;
        z6.d dVar3 = this.f4115u;
        SSLSocketFactory sSLSocketFactory2 = this.f4109o;
        List list2 = this.f4098c;
        List list3 = this.f4097b;
        kotlin.jvm.internal.p.c(list3, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (list3.contains(null)) {
            throw new IllegalStateException(("Null interceptor: " + list3).toString());
        }
        kotlin.jvm.internal.p.c(list2, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (list2.contains(null)) {
            throw new IllegalStateException(("Null network interceptor: " + list2).toString());
        }
        List list4 = this.f4111q;
        if (list4 == null || !list4.isEmpty()) {
            Iterator it2 = list4.iterator();
            while (it2.hasNext()) {
                if (((h) it2.next()).f4034a) {
                    if (sSLSocketFactory2 == null) {
                        throw new IllegalStateException("sslSocketFactory == null");
                    }
                    if (dVar3 == null) {
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
        if (dVar3 != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (x509TrustManager2 != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (!kotlin.jvm.internal.p.a(this.f4114t, e.f4010c)) {
            throw new IllegalStateException("Check failed.");
        }
    }
}
