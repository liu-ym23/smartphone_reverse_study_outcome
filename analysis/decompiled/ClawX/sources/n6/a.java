package n6;

import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final b f3986a;

    /* renamed from: b, reason: collision with root package name */
    public final SocketFactory f3987b;

    /* renamed from: c, reason: collision with root package name */
    public final SSLSocketFactory f3988c;
    public final HostnameVerifier d;

    /* renamed from: e, reason: collision with root package name */
    public final e f3989e;

    /* renamed from: f, reason: collision with root package name */
    public final b f3990f;

    /* renamed from: g, reason: collision with root package name */
    public final ProxySelector f3991g;

    /* renamed from: h, reason: collision with root package name */
    public final m f3992h;

    /* renamed from: i, reason: collision with root package name */
    public final List f3993i;

    /* renamed from: j, reason: collision with root package name */
    public final List f3994j;

    public a(String uriHost, int i8, b dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, e eVar, b proxyAuthenticator, List protocols, List connectionSpecs, ProxySelector proxySelector) {
        kotlin.jvm.internal.p.e(uriHost, "uriHost");
        kotlin.jvm.internal.p.e(dns, "dns");
        kotlin.jvm.internal.p.e(socketFactory, "socketFactory");
        kotlin.jvm.internal.p.e(proxyAuthenticator, "proxyAuthenticator");
        kotlin.jvm.internal.p.e(protocols, "protocols");
        kotlin.jvm.internal.p.e(connectionSpecs, "connectionSpecs");
        kotlin.jvm.internal.p.e(proxySelector, "proxySelector");
        this.f3986a = dns;
        this.f3987b = socketFactory;
        this.f3988c = sSLSocketFactory;
        this.d = hostnameVerifier;
        this.f3989e = eVar;
        this.f3990f = proxyAuthenticator;
        this.f3991g = proxySelector;
        l lVar = new l(0);
        String str = sSLSocketFactory != null ? "https" : "http";
        if (str.equalsIgnoreCase("http")) {
            lVar.f4057c = "http";
        } else {
            if (!str.equalsIgnoreCase("https")) {
                throw new IllegalArgumentException("unexpected scheme: ".concat(str));
            }
            lVar.f4057c = "https";
        }
        String strB = o6.c.b(a7.a.c(uriHost, 0, 0, 7));
        if (strB == null) {
            throw new IllegalArgumentException("unexpected host: ".concat(uriHost));
        }
        lVar.f4059f = strB;
        if (1 > i8 || i8 >= 65536) {
            throw new IllegalArgumentException(a8.b.j(i8, "unexpected port: ").toString());
        }
        lVar.f4056b = i8;
        this.f3992h = lVar.b();
        this.f3993i = o6.f.j(protocols);
        this.f3994j = o6.f.j(connectionSpecs);
    }

    public final boolean a(a that) {
        kotlin.jvm.internal.p.e(that, "that");
        return kotlin.jvm.internal.p.a(this.f3986a, that.f3986a) && kotlin.jvm.internal.p.a(this.f3990f, that.f3990f) && kotlin.jvm.internal.p.a(this.f3993i, that.f3993i) && kotlin.jvm.internal.p.a(this.f3994j, that.f3994j) && kotlin.jvm.internal.p.a(this.f3991g, that.f3991g) && kotlin.jvm.internal.p.a(this.f3988c, that.f3988c) && kotlin.jvm.internal.p.a(this.d, that.d) && kotlin.jvm.internal.p.a(this.f3989e, that.f3989e) && this.f3992h.f4066e == that.f3992h.f4066e;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return kotlin.jvm.internal.p.a(this.f3992h, aVar.f3992h) && a(aVar);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f3989e) + ((Objects.hashCode(this.d) + ((Objects.hashCode(this.f3988c) + ((this.f3991g.hashCode() + ((this.f3994j.hashCode() + ((this.f3993i.hashCode() + ((this.f3990f.hashCode() + ((this.f3986a.hashCode() + a8.b.f(527, 31, this.f3992h.f4069h)) * 31)) * 31)) * 31)) * 31)) * 961)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Address{");
        m mVar = this.f3992h;
        sb.append(mVar.d);
        sb.append(AbstractJsonLexerKt.COLON);
        sb.append(mVar.f4066e);
        sb.append(", ");
        sb.append("proxySelector=" + this.f3991g);
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }
}
