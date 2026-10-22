package tb;

import com.autonavi.aps.amapapi.config.Const;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import okhttp3.Protocol;
import tb.v;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0004H\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u0000H\u0000¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0002H\u0016¢\u0006\u0004\b&\u0010'R\u0017\u0010\u0007\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\t\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0007¢\u0006\f\n\u0004\b*\u00100\u001a\u0004\b1\u00102R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0007¢\u0006\f\n\u0004\b$\u00103\u001a\u0004\b4\u00105R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0007¢\u0006\f\n\u0004\b4\u00106\u001a\u0004\b(\u00107R\u0017\u0010\u0011\u001a\u00020\u00108\u0007¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0007¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b<\u0010>R\u0017\u0010\u001a\u001a\u00020\u00198\u0007¢\u0006\f\n\u0004\b:\u0010?\u001a\u0004\b@\u0010AR\u0017\u0010F\u001a\u00020B8\u0007¢\u0006\f\n\u0004\b@\u0010C\u001a\u0004\bD\u0010ER\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0007¢\u0006\f\n\u0004\b.\u0010G\u001a\u0004\b8\u0010HR\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00148\u0007¢\u0006\f\n\u0004\b1\u0010G\u001a\u0004\b,\u0010H¨\u0006I"}, d2 = {"Ltb/a;", "", "", "uriHost", "", "uriPort", "Ltb/p;", "dns", "Ljavax/net/SocketFactory;", "socketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "Ltb/h;", "certificatePinner", "Ltb/b;", "proxyAuthenticator", "Ljava/net/Proxy;", "proxy", "", "Lokhttp3/Protocol;", "protocols", "Lokhttp3/b;", "connectionSpecs", "Ljava/net/ProxySelector;", "proxySelector", "<init>", "(Ljava/lang/String;ILtb/p;Ljavax/net/SocketFactory;Ljavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/HostnameVerifier;Ltb/h;Ltb/b;Ljava/net/Proxy;Ljava/util/List;Ljava/util/List;Ljava/net/ProxySelector;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "that", Const.INTENT_KEY_UMID, "(Ltb/a;)Z", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ltb/p;", "c", "()Ltb/p;", Const.INTENT_KEY_PKGNAME, "Ljavax/net/SocketFactory;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Ljavax/net/SocketFactory;", "Ljavax/net/ssl/SSLSocketFactory;", "k", "()Ljavax/net/ssl/SSLSocketFactory;", "Ljavax/net/ssl/HostnameVerifier;", "e", "()Ljavax/net/ssl/HostnameVerifier;", "Ltb/h;", "()Ltb/h;", "f", "Ltb/b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Ltb/b;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ljava/net/Proxy;", "()Ljava/net/Proxy;", "Ljava/net/ProxySelector;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ljava/net/ProxySelector;", "Ltb/v;", "Ltb/v;", "l", "()Ltb/v;", "url", "Ljava/util/List;", "()Ljava/util/List;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: tb.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5534a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5549p dns;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final SocketFactory socketFactory;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final SSLSocketFactory sslSocketFactory;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final HostnameVerifier hostnameVerifier;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final C5541h certificatePinner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5535b proxyAuthenticator;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Proxy proxy;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final ProxySelector proxySelector;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final v url;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final List<Protocol> protocols;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final List<okhttp3.b> connectionSpecs;

    public C5534a(String uriHost, int i10, InterfaceC5549p dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, C5541h c5541h, InterfaceC5535b proxyAuthenticator, Proxy proxy, List<? extends Protocol> protocols, List<okhttp3.b> connectionSpecs, ProxySelector proxySelector) {
        kotlin.jvm.internal.p.i(uriHost, "uriHost");
        kotlin.jvm.internal.p.i(dns, "dns");
        kotlin.jvm.internal.p.i(socketFactory, "socketFactory");
        kotlin.jvm.internal.p.i(proxyAuthenticator, "proxyAuthenticator");
        kotlin.jvm.internal.p.i(protocols, "protocols");
        kotlin.jvm.internal.p.i(connectionSpecs, "connectionSpecs");
        kotlin.jvm.internal.p.i(proxySelector, "proxySelector");
        this.dns = dns;
        this.socketFactory = socketFactory;
        this.sslSocketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier;
        this.certificatePinner = c5541h;
        this.proxyAuthenticator = proxyAuthenticator;
        this.proxy = proxy;
        this.proxySelector = proxySelector;
        this.url = new v.a().t(sSLSocketFactory != null ? "https" : "http").g(uriHost).n(i10).c();
        this.protocols = ub.q.w(protocols);
        this.connectionSpecs = ub.q.w(connectionSpecs);
    }

    /* renamed from: a, reason: from getter */
    public final C5541h getCertificatePinner() {
        return this.certificatePinner;
    }

    public final List<okhttp3.b> b() {
        return this.connectionSpecs;
    }

    /* renamed from: c, reason: from getter */
    public final InterfaceC5549p getDns() {
        return this.dns;
    }

    public final boolean d(C5534a that) {
        kotlin.jvm.internal.p.i(that, "that");
        return kotlin.jvm.internal.p.d(this.dns, that.dns) && kotlin.jvm.internal.p.d(this.proxyAuthenticator, that.proxyAuthenticator) && kotlin.jvm.internal.p.d(this.protocols, that.protocols) && kotlin.jvm.internal.p.d(this.connectionSpecs, that.connectionSpecs) && kotlin.jvm.internal.p.d(this.proxySelector, that.proxySelector) && kotlin.jvm.internal.p.d(this.proxy, that.proxy) && kotlin.jvm.internal.p.d(this.sslSocketFactory, that.sslSocketFactory) && kotlin.jvm.internal.p.d(this.hostnameVerifier, that.hostnameVerifier) && kotlin.jvm.internal.p.d(this.certificatePinner, that.certificatePinner) && this.url.getPort() == that.url.getPort();
    }

    /* renamed from: e, reason: from getter */
    public final HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public boolean equals(Object other) {
        if (!(other instanceof C5534a)) {
            return false;
        }
        C5534a c5534a = (C5534a) other;
        return kotlin.jvm.internal.p.d(this.url, c5534a.url) && d(c5534a);
    }

    public final List<Protocol> f() {
        return this.protocols;
    }

    /* renamed from: g, reason: from getter */
    public final Proxy getProxy() {
        return this.proxy;
    }

    /* renamed from: h, reason: from getter */
    public final InterfaceC5535b getProxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.url.hashCode()) * 31) + this.dns.hashCode()) * 31) + this.proxyAuthenticator.hashCode()) * 31) + this.protocols.hashCode()) * 31) + this.connectionSpecs.hashCode()) * 31) + this.proxySelector.hashCode()) * 31) + Objects.hashCode(this.proxy)) * 31) + Objects.hashCode(this.sslSocketFactory)) * 31) + Objects.hashCode(this.hostnameVerifier)) * 31) + Objects.hashCode(this.certificatePinner);
    }

    /* renamed from: i, reason: from getter */
    public final ProxySelector getProxySelector() {
        return this.proxySelector;
    }

    /* renamed from: j, reason: from getter */
    public final SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    /* renamed from: k, reason: from getter */
    public final SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    /* renamed from: l, reason: from getter */
    public final v getUrl() {
        return this.url;
    }

    public String toString() {
        StringBuilder sb2;
        Object obj;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Address{");
        sb3.append(this.url.getHost());
        sb3.append(':');
        sb3.append(this.url.getPort());
        sb3.append(", ");
        if (this.proxy != null) {
            sb2 = new StringBuilder();
            sb2.append("proxy=");
            obj = this.proxy;
        } else {
            sb2 = new StringBuilder();
            sb2.append("proxySelector=");
            obj = this.proxySelector;
        }
        sb2.append(obj);
        sb3.append(sb2.toString());
        sb3.append('}');
        return sb3.toString();
    }
}
