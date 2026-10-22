package F9;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: F9.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0223a {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0239q f636a;
    public final SocketFactory b;
    public final SSLSocketFactory c;
    public final HostnameVerifier d;
    public final okhttp3.a e;
    public final InterfaceC0224b f;
    public final Proxy g;
    public final ProxySelector h;
    public final y i;

    /* renamed from: j, reason: collision with root package name */
    public final List f637j;
    public final List k;

    public C0223a(String uriHost, int i, InterfaceC0239q dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, okhttp3.a aVar, InterfaceC0224b proxyAuthenticator, Proxy proxy, List protocols, List connectionSpecs, ProxySelector proxySelector) {
        kotlin.jvm.internal.k.f(uriHost, "uriHost");
        kotlin.jvm.internal.k.f(dns, "dns");
        kotlin.jvm.internal.k.f(socketFactory, "socketFactory");
        kotlin.jvm.internal.k.f(proxyAuthenticator, "proxyAuthenticator");
        kotlin.jvm.internal.k.f(protocols, "protocols");
        kotlin.jvm.internal.k.f(connectionSpecs, "connectionSpecs");
        kotlin.jvm.internal.k.f(proxySelector, "proxySelector");
        this.f636a = dns;
        this.b = socketFactory;
        this.c = sSLSocketFactory;
        this.d = hostnameVerifier;
        this.e = aVar;
        this.f = proxyAuthenticator;
        this.g = proxy;
        this.h = proxySelector;
        x xVar = new x(0);
        xVar.m(sSLSocketFactory != null ? "https" : "http");
        xVar.h(uriHost);
        xVar.k(i);
        this.i = xVar.d();
        this.f637j = G9.b.w(protocols);
        this.k = G9.b.w(connectionSpecs);
    }

    public final boolean a(C0223a that) {
        kotlin.jvm.internal.k.f(that, "that");
        return kotlin.jvm.internal.k.b(this.f636a, that.f636a) && kotlin.jvm.internal.k.b(this.f, that.f) && kotlin.jvm.internal.k.b(this.f637j, that.f637j) && kotlin.jvm.internal.k.b(this.k, that.k) && kotlin.jvm.internal.k.b(this.h, that.h) && kotlin.jvm.internal.k.b(this.g, that.g) && kotlin.jvm.internal.k.b(this.c, that.c) && kotlin.jvm.internal.k.b(this.d, that.d) && kotlin.jvm.internal.k.b(this.e, that.e) && this.i.e == that.i.e;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0223a)) {
            return false;
        }
        C0223a c0223a = (C0223a) obj;
        return kotlin.jvm.internal.k.b(this.i, c0223a.i) && a(c0223a);
    }

    public final int hashCode() {
        return Objects.hashCode(this.e) + ((Objects.hashCode(this.d) + ((Objects.hashCode(this.c) + ((Objects.hashCode(this.g) + ((this.h.hashCode() + androidx.appfunctions.metadata.a.e(this.k, androidx.appfunctions.metadata.a.e(this.f637j, (this.f.hashCode() + ((this.f636a.hashCode() + B7.a.c(527, 31, this.i.i)) * 31)) * 31, 31), 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Address{");
        y yVar = this.i;
        sb.append(yVar.d);
        sb.append(':');
        sb.append(yVar.e);
        sb.append(", ");
        Proxy proxy = this.g;
        if (proxy != null) {
            str = "proxy=" + proxy;
        } else {
            str = "proxySelector=" + this.h;
        }
        return B7.a.g('}', str, sb);
    }
}
