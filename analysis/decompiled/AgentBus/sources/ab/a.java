package ab;

import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final b f486a;

    /* renamed from: b, reason: collision with root package name */
    public final SocketFactory f487b;

    /* renamed from: c, reason: collision with root package name */
    public final SSLSocketFactory f488c;

    /* renamed from: d, reason: collision with root package name */
    public final HostnameVerifier f489d;

    /* renamed from: e, reason: collision with root package name */
    public final e f490e;

    /* renamed from: f, reason: collision with root package name */
    public final b f491f;

    /* renamed from: g, reason: collision with root package name */
    public final ProxySelector f492g;

    /* renamed from: h, reason: collision with root package name */
    public final p f493h;

    /* renamed from: i, reason: collision with root package name */
    public final List f494i;

    /* renamed from: j, reason: collision with root package name */
    public final List f495j;

    public a(String str, int i2, b bVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, e eVar, b bVar2, List list, List list2, ProxySelector proxySelector) {
        q7.k.e(str, "uriHost");
        q7.k.e(bVar, "dns");
        q7.k.e(socketFactory, "socketFactory");
        q7.k.e(bVar2, "proxyAuthenticator");
        q7.k.e(list, "protocols");
        q7.k.e(list2, "connectionSpecs");
        q7.k.e(proxySelector, "proxySelector");
        this.f486a = bVar;
        this.f487b = socketFactory;
        this.f488c = sSLSocketFactory;
        this.f489d = hostnameVerifier;
        this.f490e = eVar;
        this.f491f = bVar2;
        this.f492g = proxySelector;
        o oVar = new o();
        String str2 = sSLSocketFactory != null ? "https" : "http";
        if (str2.equalsIgnoreCase("http")) {
            oVar.f579a = "http";
        } else {
            if (!str2.equalsIgnoreCase("https")) {
                throw new IllegalArgumentException("unexpected scheme: ".concat(str2));
            }
            oVar.f579a = "https";
        }
        String strX = s7.a.X(b.e(str, 0, 0, 7));
        if (strX == null) {
            throw new IllegalArgumentException("unexpected host: ".concat(str));
        }
        oVar.f582d = strX;
        if (1 > i2 || i2 >= 65536) {
            throw new IllegalArgumentException(n.f.c(i2, "unexpected port: ").toString());
        }
        oVar.f583e = i2;
        this.f493h = oVar.a();
        this.f494i = bb.b.x(list);
        this.f495j = bb.b.x(list2);
    }

    public final boolean a(a aVar) {
        q7.k.e(aVar, "that");
        return q7.k.a(this.f486a, aVar.f486a) && q7.k.a(this.f491f, aVar.f491f) && q7.k.a(this.f494i, aVar.f494i) && q7.k.a(this.f495j, aVar.f495j) && q7.k.a(this.f492g, aVar.f492g) && q7.k.a(this.f488c, aVar.f488c) && q7.k.a(this.f489d, aVar.f489d) && q7.k.a(this.f490e, aVar.f490e) && this.f493h.f592e == aVar.f493h.f592e;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return q7.k.a(this.f493h, aVar.f493h) && a(aVar);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f490e) + ((Objects.hashCode(this.f489d) + ((Objects.hashCode(this.f488c) + ((this.f492g.hashCode() + m.x.h(this.f495j, m.x.h(this.f494i, (this.f491f.hashCode() + ((this.f486a.hashCode() + m.x.g(this.f493h.f595h, 527, 31)) * 31)) * 31, 31), 31)) * 961)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Address{");
        p pVar = this.f493h;
        sb2.append(pVar.f591d);
        sb2.append(':');
        sb2.append(pVar.f592e);
        sb2.append(", ");
        sb2.append("proxySelector=" + this.f492g);
        sb2.append('}');
        return sb2.toString();
    }
}
