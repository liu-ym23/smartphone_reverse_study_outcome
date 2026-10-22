package h3;

import androidx.room.AbstractC0351g;
import ch.qos.logback.core.CoreConstants;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;

/* renamed from: h3.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0592a {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0615y f12839a;

    /* renamed from: b, reason: collision with root package name */
    public final SocketFactory f12840b;

    /* renamed from: c, reason: collision with root package name */
    public final SSLSocketFactory f12841c;

    /* renamed from: d, reason: collision with root package name */
    public final HostnameVerifier f12842d;

    /* renamed from: e, reason: collision with root package name */
    public final C0605n f12843e;

    /* renamed from: f, reason: collision with root package name */
    public final InterfaceC0593b f12844f;

    /* renamed from: g, reason: collision with root package name */
    public final Proxy f12845g;

    /* renamed from: h, reason: collision with root package name */
    public final ProxySelector f12846h;

    /* renamed from: i, reason: collision with root package name */
    public final J f12847i;

    /* renamed from: j, reason: collision with root package name */
    public final List f12848j;

    /* renamed from: k, reason: collision with root package name */
    public final List f12849k;

    public C0592a(String host, int i4, InterfaceC0615y dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, C0605n c0605n, InterfaceC0593b proxyAuthenticator, Proxy proxy, List protocols, List connectionSpecs, ProxySelector proxySelector) {
        Intrinsics.checkNotNullParameter(host, "uriHost");
        Intrinsics.checkNotNullParameter(dns, "dns");
        Intrinsics.checkNotNullParameter(socketFactory, "socketFactory");
        Intrinsics.checkNotNullParameter(proxyAuthenticator, "proxyAuthenticator");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        Intrinsics.checkNotNullParameter(connectionSpecs, "connectionSpecs");
        Intrinsics.checkNotNullParameter(proxySelector, "proxySelector");
        this.f12839a = dns;
        this.f12840b = socketFactory;
        this.f12841c = sSLSocketFactory;
        this.f12842d = hostnameVerifier;
        this.f12843e = c0605n;
        this.f12844f = proxyAuthenticator;
        this.f12845g = proxy;
        this.f12846h = proxySelector;
        I i5 = new I();
        String scheme = sSLSocketFactory != null ? "https" : "http";
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        if (StringsKt__StringsJVMKt.equals(scheme, "http", true)) {
            i5.f12713a = "http";
        } else {
            if (!StringsKt__StringsJVMKt.equals(scheme, "https", true)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected scheme: ", scheme));
            }
            i5.f12713a = "https";
        }
        Intrinsics.checkNotNullParameter(host, "host");
        char[] cArr = J.f12721k;
        String canonicalHost = HostnamesKt.toCanonicalHost(C0611u.w(host, 0, 0, false, 7));
        if (canonicalHost == null) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected host: ", host));
        }
        i5.f12716d = canonicalHost;
        if (1 > i4 || i4 >= 65536) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected port: ", Integer.valueOf(i4)).toString());
        }
        i5.f12717e = i4;
        this.f12847i = i5.c();
        this.f12848j = Util.toImmutableList(protocols);
        this.f12849k = Util.toImmutableList(connectionSpecs);
    }

    public final boolean a(C0592a that) {
        Intrinsics.checkNotNullParameter(that, "that");
        return Intrinsics.areEqual(this.f12839a, that.f12839a) && Intrinsics.areEqual(this.f12844f, that.f12844f) && Intrinsics.areEqual(this.f12848j, that.f12848j) && Intrinsics.areEqual(this.f12849k, that.f12849k) && Intrinsics.areEqual(this.f12846h, that.f12846h) && Intrinsics.areEqual(this.f12845g, that.f12845g) && Intrinsics.areEqual(this.f12841c, that.f12841c) && Intrinsics.areEqual(this.f12842d, that.f12842d) && Intrinsics.areEqual(this.f12843e, that.f12843e) && this.f12847i.f12726e == that.f12847i.f12726e;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0592a) {
            C0592a c0592a = (C0592a) obj;
            if (Intrinsics.areEqual(this.f12847i, c0592a.f12847i) && a(c0592a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f12843e) + ((Objects.hashCode(this.f12842d) + ((Objects.hashCode(this.f12841c) + ((Objects.hashCode(this.f12845g) + ((this.f12846h.hashCode() + ((this.f12849k.hashCode() + ((this.f12848j.hashCode() + ((this.f12844f.hashCode() + ((this.f12839a.hashCode() + AbstractC0351g.d(this.f12847i.f12730i, 527, 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Address{");
        J j4 = this.f12847i;
        sb.append(j4.f12725d);
        sb.append(CoreConstants.COLON_CHAR);
        sb.append(j4.f12726e);
        sb.append(", ");
        Proxy proxy = this.f12845g;
        return B0.g.q(sb, proxy != null ? Intrinsics.stringPlus("proxy=", proxy) : Intrinsics.stringPlus("proxySelector=", this.f12846h), '}');
    }
}
