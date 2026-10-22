package okhttp3;

import bd.l;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final ad.a f10923a;

    /* renamed from: b, reason: collision with root package name */
    public final SocketFactory f10924b;

    /* renamed from: c, reason: collision with root package name */
    public final SSLSocketFactory f10925c;

    /* renamed from: d, reason: collision with root package name */
    public final HostnameVerifier f10926d;

    /* renamed from: e, reason: collision with root package name */
    public final CertificatePinner f10927e;

    /* renamed from: f, reason: collision with root package name */
    public final ad.a f10928f;

    /* renamed from: g, reason: collision with root package name */
    public final ProxySelector f10929g;
    public final g h;

    /* renamed from: i, reason: collision with root package name */
    public final List<Protocol> f10930i;

    /* renamed from: j, reason: collision with root package name */
    public final List<e> f10931j;

    public a(String uriHost, int i10, ad.a dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, ad.a proxyAuthenticator, List protocols, List connectionSpecs, ProxySelector proxySelector) {
        kotlin.jvm.internal.g.f(uriHost, "uriHost");
        kotlin.jvm.internal.g.f(dns, "dns");
        kotlin.jvm.internal.g.f(socketFactory, "socketFactory");
        kotlin.jvm.internal.g.f(proxyAuthenticator, "proxyAuthenticator");
        kotlin.jvm.internal.g.f(protocols, "protocols");
        kotlin.jvm.internal.g.f(connectionSpecs, "connectionSpecs");
        kotlin.jvm.internal.g.f(proxySelector, "proxySelector");
        this.f10923a = dns;
        this.f10924b = socketFactory;
        this.f10925c = sSLSocketFactory;
        this.f10926d = hostnameVerifier;
        this.f10927e = certificatePinner;
        this.f10928f = proxyAuthenticator;
        this.f10929g = proxySelector;
        g.a aVar = new g.a();
        String str = sSLSocketFactory != null ? "https" : "http";
        if (str.equalsIgnoreCase("http")) {
            aVar.f10985a = "http";
        } else {
            if (!str.equalsIgnoreCase("https")) {
                throw new IllegalArgumentException("unexpected scheme: ".concat(str));
            }
            aVar.f10985a = "https";
        }
        String strB = bd.c.b(pd.a.d(0, uriHost, 0, 7));
        if (strB == null) {
            throw new IllegalArgumentException("unexpected host: ".concat(uriHost));
        }
        aVar.f10988d = strB;
        if (1 > i10 || i10 >= 65536) {
            throw new IllegalArgumentException(ai.onnxruntime.providers.a.a(i10, "unexpected port: ").toString());
        }
        aVar.f10989e = i10;
        this.h = aVar.b();
        this.f10930i = l.l(protocols);
        this.f10931j = l.l(connectionSpecs);
    }

    public final boolean a(a that) {
        kotlin.jvm.internal.g.f(that, "that");
        return kotlin.jvm.internal.g.b(this.f10923a, that.f10923a) && kotlin.jvm.internal.g.b(this.f10928f, that.f10928f) && kotlin.jvm.internal.g.b(this.f10930i, that.f10930i) && kotlin.jvm.internal.g.b(this.f10931j, that.f10931j) && kotlin.jvm.internal.g.b(this.f10929g, that.f10929g) && kotlin.jvm.internal.g.b(this.f10925c, that.f10925c) && kotlin.jvm.internal.g.b(this.f10926d, that.f10926d) && kotlin.jvm.internal.g.b(this.f10927e, that.f10927e) && this.h.f10981e == that.h.f10981e;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return kotlin.jvm.internal.g.b(this.h, aVar.h) && a(aVar);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f10927e) + ((Objects.hashCode(this.f10926d) + ((Objects.hashCode(this.f10925c) + ((this.f10929g.hashCode() + h0.e.b(this.f10931j, h0.e.b(this.f10930i, (this.f10928f.hashCode() + ((this.f10923a.hashCode() + v1.d.a(527, 31, this.h.f10984i)) * 31)) * 31, 31), 31)) * 961)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Address{");
        g gVar = this.h;
        sb2.append(gVar.f10980d);
        sb2.append(':');
        sb2.append(gVar.f10981e);
        sb2.append(", ");
        sb2.append("proxySelector=" + this.f10929g);
        sb2.append('}');
        return sb2.toString();
    }
}
