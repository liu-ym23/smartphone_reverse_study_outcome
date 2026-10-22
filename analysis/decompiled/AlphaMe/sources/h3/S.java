package h3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.CertificateChainCleaner;

/* loaded from: classes2.dex */
public final class S implements Cloneable, InterfaceC0601j {

    /* renamed from: E, reason: collision with root package name */
    public static final List f12781E = Util.immutableListOf(T.HTTP_2, T.HTTP_1_1);

    /* renamed from: F, reason: collision with root package name */
    public static final List f12782F = Util.immutableListOf(C0610t.f12967e, C0610t.f12968f);

    /* renamed from: A, reason: collision with root package name */
    public final int f12783A;

    /* renamed from: B, reason: collision with root package name */
    public final int f12784B;

    /* renamed from: C, reason: collision with root package name */
    public final long f12785C;

    /* renamed from: D, reason: collision with root package name */
    public final RouteDatabase f12786D;

    /* renamed from: a, reason: collision with root package name */
    public final C0614x f12787a;

    /* renamed from: b, reason: collision with root package name */
    public final r f12788b;

    /* renamed from: c, reason: collision with root package name */
    public final List f12789c;

    /* renamed from: d, reason: collision with root package name */
    public final List f12790d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC0591A f12791e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f12792f;

    /* renamed from: g, reason: collision with root package name */
    public final InterfaceC0593b f12793g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f12794h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f12795i;

    /* renamed from: j, reason: collision with root package name */
    public final InterfaceC0613w f12796j;

    /* renamed from: k, reason: collision with root package name */
    public final C0599h f12797k;

    /* renamed from: l, reason: collision with root package name */
    public final InterfaceC0615y f12798l;

    /* renamed from: m, reason: collision with root package name */
    public final Proxy f12799m;

    /* renamed from: n, reason: collision with root package name */
    public final ProxySelector f12800n;

    /* renamed from: o, reason: collision with root package name */
    public final InterfaceC0593b f12801o;

    /* renamed from: p, reason: collision with root package name */
    public final SocketFactory f12802p;

    /* renamed from: q, reason: collision with root package name */
    public final SSLSocketFactory f12803q;

    /* renamed from: r, reason: collision with root package name */
    public final X509TrustManager f12804r;

    /* renamed from: s, reason: collision with root package name */
    public final List f12805s;

    /* renamed from: t, reason: collision with root package name */
    public final List f12806t;

    /* renamed from: u, reason: collision with root package name */
    public final HostnameVerifier f12807u;

    /* renamed from: v, reason: collision with root package name */
    public final C0605n f12808v;

    /* renamed from: w, reason: collision with root package name */
    public final CertificateChainCleaner f12809w;

    /* renamed from: x, reason: collision with root package name */
    public final int f12810x;

    /* renamed from: y, reason: collision with root package name */
    public final int f12811y;

    /* renamed from: z, reason: collision with root package name */
    public final int f12812z;

    public S(Q builder) throws NoSuchAlgorithmException, KeyStoreException {
        ProxySelector proxySelector;
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f12787a = builder.f12755a;
        this.f12788b = builder.f12756b;
        this.f12789c = Util.toImmutableList(builder.f12757c);
        this.f12790d = Util.toImmutableList(builder.f12758d);
        this.f12791e = builder.f12759e;
        this.f12792f = builder.f12760f;
        this.f12793g = builder.f12761g;
        this.f12794h = builder.f12762h;
        this.f12795i = builder.f12763i;
        this.f12796j = builder.f12764j;
        this.f12797k = builder.f12765k;
        this.f12798l = builder.f12766l;
        Proxy proxy = builder.f12767m;
        this.f12799m = proxy;
        if (proxy != null) {
            proxySelector = NullProxySelector.INSTANCE;
        } else {
            proxySelector = builder.f12768n;
            proxySelector = proxySelector == null ? ProxySelector.getDefault() : proxySelector;
            if (proxySelector == null) {
                proxySelector = NullProxySelector.INSTANCE;
            }
        }
        this.f12800n = proxySelector;
        this.f12801o = builder.f12769o;
        this.f12802p = builder.f12770p;
        List list = builder.f12773s;
        this.f12805s = list;
        this.f12806t = builder.f12774t;
        this.f12807u = builder.f12775u;
        this.f12810x = builder.f12778x;
        this.f12811y = builder.f12779y;
        this.f12812z = builder.f12780z;
        this.f12783A = builder.f12751A;
        this.f12784B = builder.f12752B;
        this.f12785C = builder.f12753C;
        RouteDatabase routeDatabase = builder.f12754D;
        this.f12786D = routeDatabase == null ? new RouteDatabase() : routeDatabase;
        List list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            this.f12803q = null;
            this.f12809w = null;
            this.f12804r = null;
            this.f12808v = C0605n.f12937c;
        } else {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                if (((C0610t) it.next()).f12969a) {
                    C0605n c0605n = builder.f12776v;
                    SSLSocketFactory sSLSocketFactory = builder.f12771q;
                    if (sSLSocketFactory != null) {
                        this.f12803q = sSLSocketFactory;
                        CertificateChainCleaner certificateChainCleaner = builder.f12777w;
                        Intrinsics.checkNotNull(certificateChainCleaner);
                        this.f12809w = certificateChainCleaner;
                        X509TrustManager x509TrustManager = builder.f12772r;
                        Intrinsics.checkNotNull(x509TrustManager);
                        this.f12804r = x509TrustManager;
                        Intrinsics.checkNotNull(certificateChainCleaner);
                        c0605n.getClass();
                        Intrinsics.checkNotNullParameter(certificateChainCleaner, "certificateChainCleaner");
                        this.f12808v = Intrinsics.areEqual(c0605n.f12939b, certificateChainCleaner) ? c0605n : new C0605n(c0605n.f12938a, certificateChainCleaner);
                    } else {
                        Platform.Companion companion = Platform.INSTANCE;
                        X509TrustManager x509TrustManagerPlatformTrustManager = companion.get().platformTrustManager();
                        this.f12804r = x509TrustManagerPlatformTrustManager;
                        Platform platform = companion.get();
                        Intrinsics.checkNotNull(x509TrustManagerPlatformTrustManager);
                        this.f12803q = platform.newSslSocketFactory(x509TrustManagerPlatformTrustManager);
                        CertificateChainCleaner.Companion companion2 = CertificateChainCleaner.INSTANCE;
                        Intrinsics.checkNotNull(x509TrustManagerPlatformTrustManager);
                        CertificateChainCleaner certificateChainCleaner2 = companion2.get(x509TrustManagerPlatformTrustManager);
                        this.f12809w = certificateChainCleaner2;
                        Intrinsics.checkNotNull(certificateChainCleaner2);
                        c0605n.getClass();
                        Intrinsics.checkNotNullParameter(certificateChainCleaner2, "certificateChainCleaner");
                        this.f12808v = Intrinsics.areEqual(c0605n.f12939b, certificateChainCleaner2) ? c0605n : new C0605n(c0605n.f12938a, certificateChainCleaner2);
                    }
                }
            }
            this.f12803q = null;
            this.f12809w = null;
            this.f12804r = null;
            this.f12808v = C0605n.f12937c;
        }
        List list3 = this.f12789c;
        if (!(!list3.contains(null))) {
            throw new IllegalStateException(Intrinsics.stringPlus("Null interceptor: ", list3).toString());
        }
        List list4 = this.f12790d;
        if (!(!list4.contains(null))) {
            throw new IllegalStateException(Intrinsics.stringPlus("Null network interceptor: ", list4).toString());
        }
        List list5 = this.f12805s;
        boolean z4 = list5 instanceof Collection;
        X509TrustManager x509TrustManager2 = this.f12804r;
        CertificateChainCleaner certificateChainCleaner3 = this.f12809w;
        SSLSocketFactory sSLSocketFactory2 = this.f12803q;
        if (!z4 || !list5.isEmpty()) {
            Iterator it2 = list5.iterator();
            while (it2.hasNext()) {
                if (((C0610t) it2.next()).f12969a) {
                    if (sSLSocketFactory2 == null) {
                        throw new IllegalStateException("sslSocketFactory == null".toString());
                    }
                    if (certificateChainCleaner3 == null) {
                        throw new IllegalStateException("certificateChainCleaner == null".toString());
                    }
                    if (x509TrustManager2 == null) {
                        throw new IllegalStateException("x509TrustManager == null".toString());
                    }
                    return;
                }
            }
        }
        if (sSLSocketFactory2 != null) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (certificateChainCleaner3 != null) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (x509TrustManager2 != null) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!Intrinsics.areEqual(this.f12808v, C0605n.f12937c)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public final Object clone() {
        return super.clone();
    }

    public S() {
        this(new Q());
    }
}
