package ab;

import java.net.ProtocolException;
import java.net.ProxySelector;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public final class t implements Cloneable {
    public static final List G = bb.b.l(u.HTTP_2, u.HTTP_1_1);
    public static final List H = bb.b.l(i.f552e, i.f553f);
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final long E;
    public final a7.d F;

    /* renamed from: f, reason: collision with root package name */
    public final i5.f f627f;

    /* renamed from: g, reason: collision with root package name */
    public final a7.d f628g;

    /* renamed from: h, reason: collision with root package name */
    public final List f629h;

    /* renamed from: i, reason: collision with root package name */
    public final List f630i;

    /* renamed from: j, reason: collision with root package name */
    public final b4.b f631j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f632k;

    /* renamed from: l, reason: collision with root package name */
    public final b f633l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f634m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f635n;

    /* renamed from: o, reason: collision with root package name */
    public final b f636o;

    /* renamed from: p, reason: collision with root package name */
    public final b f637p;

    /* renamed from: q, reason: collision with root package name */
    public final ProxySelector f638q;

    /* renamed from: r, reason: collision with root package name */
    public final b f639r;

    /* renamed from: s, reason: collision with root package name */
    public final SocketFactory f640s;

    /* renamed from: t, reason: collision with root package name */
    public final SSLSocketFactory f641t;

    /* renamed from: u, reason: collision with root package name */
    public final X509TrustManager f642u;

    /* renamed from: v, reason: collision with root package name */
    public final List f643v;

    /* renamed from: w, reason: collision with root package name */
    public final List f644w;

    /* renamed from: x, reason: collision with root package name */
    public final HostnameVerifier f645x;

    /* renamed from: y, reason: collision with root package name */
    public final e f646y;

    /* renamed from: z, reason: collision with root package name */
    public final w7.e0 f647z;

    public t(s sVar) throws NoSuchAlgorithmException, KeyStoreException {
        this.f627f = sVar.f601a;
        this.f628g = sVar.f602b;
        this.f629h = bb.b.x(sVar.f603c);
        this.f630i = bb.b.x(sVar.f604d);
        this.f631j = sVar.f605e;
        this.f632k = sVar.f606f;
        this.f633l = sVar.f607g;
        this.f634m = sVar.f608h;
        this.f635n = sVar.f609i;
        this.f636o = sVar.f610j;
        this.f637p = sVar.f611k;
        ProxySelector proxySelector = sVar.f612l;
        proxySelector = proxySelector == null ? ProxySelector.getDefault() : proxySelector;
        this.f638q = proxySelector == null ? kb.a.f5723a : proxySelector;
        this.f639r = sVar.f613m;
        this.f640s = sVar.f614n;
        List list = sVar.f617q;
        this.f643v = list;
        this.f644w = sVar.f618r;
        this.f645x = sVar.f619s;
        this.A = sVar.f622v;
        this.B = sVar.f623w;
        this.C = sVar.f624x;
        this.D = sVar.f625y;
        this.E = sVar.f626z;
        a7.d dVar = sVar.A;
        this.F = dVar == null ? new a7.d(7) : dVar;
        if (list == null || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((i) it.next()).f554a) {
                    SSLSocketFactory sSLSocketFactory = sVar.f615o;
                    if (sSLSocketFactory != null) {
                        this.f641t = sSLSocketFactory;
                        w7.e0 e0Var = sVar.f621u;
                        q7.k.b(e0Var);
                        this.f647z = e0Var;
                        X509TrustManager x509TrustManager = sVar.f616p;
                        q7.k.b(x509TrustManager);
                        this.f642u = x509TrustManager;
                        e eVar = sVar.f620t;
                        eVar.getClass();
                        this.f646y = q7.k.a(eVar.f527b, e0Var) ? eVar : new e(eVar.f526a, e0Var);
                    } else {
                        ib.m mVar = ib.m.f5049a;
                        X509TrustManager x509TrustManagerJ = ib.m.f5049a.j();
                        this.f642u = x509TrustManagerJ;
                        this.f641t = ib.m.f5049a.i(x509TrustManagerJ);
                        w7.e0 e0VarB = ib.m.f5049a.b(x509TrustManagerJ);
                        this.f647z = e0VarB;
                        e eVar2 = sVar.f620t;
                        eVar2.getClass();
                        this.f646y = q7.k.a(eVar2.f527b, e0VarB) ? eVar2 : new e(eVar2.f526a, e0VarB);
                    }
                }
            }
            this.f641t = null;
            this.f647z = null;
            this.f642u = null;
            this.f646y = e.f525c;
        } else {
            this.f641t = null;
            this.f647z = null;
            this.f642u = null;
            this.f646y = e.f525c;
        }
        X509TrustManager x509TrustManager2 = this.f642u;
        w7.e0 e0Var2 = this.f647z;
        SSLSocketFactory sSLSocketFactory2 = this.f641t;
        List list2 = this.f630i;
        List list3 = this.f629h;
        q7.k.c(list3, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (list3.contains(null)) {
            throw new IllegalStateException(("Null interceptor: " + list3).toString());
        }
        q7.k.c(list2, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (list2.contains(null)) {
            throw new IllegalStateException(("Null network interceptor: " + list2).toString());
        }
        List list4 = this.f643v;
        if (list4 == null || !list4.isEmpty()) {
            Iterator it2 = list4.iterator();
            while (it2.hasNext()) {
                if (((i) it2.next()).f554a) {
                    if (sSLSocketFactory2 == null) {
                        throw new IllegalStateException("sslSocketFactory == null");
                    }
                    if (e0Var2 == null) {
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
        if (e0Var2 != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (x509TrustManager2 != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (!q7.k.a(this.f646y, e.f525c)) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final s a() {
        s sVar = new s();
        sVar.f601a = this.f627f;
        sVar.f602b = this.f628g;
        d7.x.D0(sVar.f603c, this.f629h);
        d7.x.D0(sVar.f604d, this.f630i);
        sVar.f605e = this.f631j;
        sVar.f606f = this.f632k;
        sVar.f607g = this.f633l;
        sVar.f608h = this.f634m;
        sVar.f609i = this.f635n;
        sVar.f610j = this.f636o;
        sVar.f611k = this.f637p;
        sVar.f612l = this.f638q;
        sVar.f613m = this.f639r;
        sVar.f614n = this.f640s;
        sVar.f615o = this.f641t;
        sVar.f616p = this.f642u;
        sVar.f617q = this.f643v;
        sVar.f618r = this.f644w;
        sVar.f619s = this.f645x;
        sVar.f620t = this.f646y;
        sVar.f621u = this.f647z;
        sVar.f622v = this.A;
        sVar.f623w = this.B;
        sVar.f624x = this.C;
        sVar.f625y = this.D;
        sVar.f626z = this.E;
        sVar.A = this.F;
        return sVar;
    }

    public final eb.i b(w wVar) {
        q7.k.e(wVar, "request");
        return new eb.i(this, wVar, false);
    }

    public final nb.g c(w wVar, s7.a aVar) {
        nb.g gVar = new nb.g(db.e.f3030h, wVar, aVar, new Random(), this.D, this.E);
        if (wVar.f663c.a("Sec-WebSocket-Extensions") != null) {
            gVar.c(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null);
            return gVar;
        }
        s sVarA = a();
        sVarA.f605e = new b4.b(4);
        List list = nb.g.f6949w;
        q7.k.e(list, "protocols");
        ArrayList arrayListN1 = d7.r.n1(list);
        u uVar = u.H2_PRIOR_KNOWLEDGE;
        if (!arrayListN1.contains(uVar) && !arrayListN1.contains(u.HTTP_1_1)) {
            throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + arrayListN1).toString());
        }
        if (arrayListN1.contains(uVar) && arrayListN1.size() > 1) {
            throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + arrayListN1).toString());
        }
        if (arrayListN1.contains(u.HTTP_1_0)) {
            throw new IllegalArgumentException(("protocols must not contain http/1.0: " + arrayListN1).toString());
        }
        if (arrayListN1.contains(null)) {
            throw new IllegalArgumentException("protocols must not contain null");
        }
        arrayListN1.remove(u.SPDY_3);
        if (!arrayListN1.equals(sVarA.f618r)) {
            sVarA.A = null;
        }
        List listUnmodifiableList = Collections.unmodifiableList(arrayListN1);
        q7.k.d(listUnmodifiableList, "unmodifiableList(protocolsCopy)");
        sVarA.f618r = listUnmodifiableList;
        t tVar = new t(sVarA);
        v vVarA = wVar.a();
        vVarA.b("Upgrade", "websocket");
        vVarA.b("Connection", "Upgrade");
        vVarA.b("Sec-WebSocket-Key", gVar.f6955f);
        vVarA.b("Sec-WebSocket-Version", "13");
        vVarA.b("Sec-WebSocket-Extensions", "permessage-deflate");
        w wVarA = vVarA.a();
        eb.i iVar = new eb.i(tVar, wVarA, true);
        gVar.f6956g = iVar;
        iVar.f(new nb.f(0, gVar, wVarA));
        return gVar;
    }

    public final Object clone() {
        return super.clone();
    }
}
