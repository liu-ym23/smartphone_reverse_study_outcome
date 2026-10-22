package ad;

import java.lang.invoke.VarHandle;
import java.net.ProxySelector;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w implements Cloneable {
    public static final List E = bd.b.k(x.HTTP_2, x.HTTP_1_1);
    public static final List F = bd.b.k(i.f512e, i.f513f);
    public final int A;
    public final int B;
    public final int C;
    public final a2.i D;

    /* renamed from: c, reason: collision with root package name */
    public final p5.i f603c;

    /* renamed from: f, reason: collision with root package name */
    public final a2.i f604f;

    /* renamed from: g, reason: collision with root package name */
    public final List f605g;

    /* renamed from: h, reason: collision with root package name */
    public final List f606h;
    public final b8.z i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f607j;

    /* renamed from: k, reason: collision with root package name */
    public final b f608k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f609l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f610m;

    /* renamed from: n, reason: collision with root package name */
    public final b f611n;

    /* renamed from: o, reason: collision with root package name */
    public final b f612o;

    /* renamed from: p, reason: collision with root package name */
    public final ProxySelector f613p;

    /* renamed from: q, reason: collision with root package name */
    public final b f614q;

    /* renamed from: r, reason: collision with root package name */
    public final SocketFactory f615r;

    /* renamed from: s, reason: collision with root package name */
    public final SSLSocketFactory f616s;

    /* renamed from: t, reason: collision with root package name */
    public final X509TrustManager f617t;

    /* renamed from: u, reason: collision with root package name */
    public final List f618u;

    /* renamed from: v, reason: collision with root package name */
    public final List f619v;

    /* renamed from: w, reason: collision with root package name */
    public final md.d f620w;

    /* renamed from: x, reason: collision with root package name */
    public final e f621x;

    /* renamed from: y, reason: collision with root package name */
    public final md.c f622y;

    /* renamed from: z, reason: collision with root package name */
    public final int f623z;

    public w(v vVar) throws NoSuchAlgorithmException, KeyStoreException {
        this.f603c = vVar.f583a;
        this.f604f = vVar.f584b;
        this.f605g = bd.b.x(vVar.f585c);
        this.f606h = bd.b.x(vVar.f586d);
        this.i = vVar.f587e;
        this.f607j = vVar.f588f;
        this.f608k = vVar.f589g;
        this.f609l = vVar.f590h;
        this.f610m = vVar.i;
        this.f611n = vVar.f591j;
        this.f612o = vVar.f592k;
        ProxySelector proxySelector = ProxySelector.getDefault();
        this.f613p = proxySelector == null ? kd.a.f7505a : proxySelector;
        this.f614q = vVar.f593l;
        this.f615r = vVar.f594m;
        List list = vVar.f595n;
        this.f618u = list;
        this.f619v = vVar.f596o;
        this.f620w = vVar.f597p;
        this.f623z = vVar.f599r;
        this.A = vVar.f600s;
        this.B = vVar.f601t;
        this.C = vVar.f602u;
        a2.i iVar = new a2.i(6);
        iVar.f49f = new LinkedHashSet();
        VarHandle.storeStoreFence();
        this.D = iVar;
        if (list == null || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((i) it.next()).f514a) {
                    id.n.Companion.getClass();
                    X509TrustManager x509TrustManagerPlatformTrustManager = id.n.platform.platformTrustManager();
                    this.f617t = x509TrustManagerPlatformTrustManager;
                    id.n nVar = id.n.platform;
                    x509TrustManagerPlatformTrustManager.getClass();
                    this.f616s = nVar.newSslSocketFactory(x509TrustManagerPlatformTrustManager);
                    md.c cVarBuildCertificateChainCleaner = id.n.platform.buildCertificateChainCleaner(x509TrustManagerPlatformTrustManager);
                    this.f622y = cVarBuildCertificateChainCleaner;
                    e eVar = vVar.f598q;
                    cVarBuildCertificateChainCleaner.getClass();
                    if (!yb.k.a(eVar.f467b, cVarBuildCertificateChainCleaner)) {
                        Set set = eVar.f466a;
                        e eVar2 = new e();
                        eVar2.f466a = set;
                        eVar2.f467b = cVarBuildCertificateChainCleaner;
                        eVar = eVar2;
                    }
                    this.f621x = eVar;
                }
            }
            this.f616s = null;
            this.f622y = null;
            this.f617t = null;
            this.f621x = e.f465c;
        } else {
            this.f616s = null;
            this.f622y = null;
            this.f617t = null;
            this.f621x = e.f465c;
        }
        X509TrustManager x509TrustManager = this.f617t;
        md.c cVar = this.f622y;
        SSLSocketFactory sSLSocketFactory = this.f616s;
        List list2 = this.f606h;
        List list3 = this.f605g;
        list3.getClass();
        if (list3.contains(null)) {
            o.e(list3, "Null interceptor: ");
            throw null;
        }
        list2.getClass();
        if (list2.contains(null)) {
            o.e(list2, "Null network interceptor: ");
            throw null;
        }
        List list4 = this.f618u;
        if (list4 == null || !list4.isEmpty()) {
            Iterator it2 = list4.iterator();
            while (it2.hasNext()) {
                if (((i) it2.next()).f514a) {
                    if (sSLSocketFactory == null) {
                        od.f.e("sslSocketFactory == null");
                        throw null;
                    }
                    if (cVar == null) {
                        od.f.e("certificateChainCleaner == null");
                        throw null;
                    }
                    if (x509TrustManager != null) {
                        return;
                    }
                    od.f.e("x509TrustManager == null");
                    throw null;
                }
            }
        }
        if (sSLSocketFactory != null) {
            od.f.e("Check failed.");
            throw null;
        }
        if (cVar != null) {
            od.f.e("Check failed.");
            throw null;
        }
        if (x509TrustManager != null) {
            od.f.e("Check failed.");
            throw null;
        }
        if (yb.k.a(this.f621x, e.f465c)) {
            return;
        }
        od.f.e("Check failed.");
        throw null;
    }

    public final Object clone() {
        return super.clone();
    }
}
