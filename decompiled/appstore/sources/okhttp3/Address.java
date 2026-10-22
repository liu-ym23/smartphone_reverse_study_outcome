package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.internal.Util;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: classes4.dex */
public final class Address {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HttpUrl f22630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Dns f22631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SocketFactory f22632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Authenticator f22633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f22634e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f22635f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ProxySelector f22636g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Proxy f22637h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SSLSocketFactory f22638i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final HostnameVerifier f22639j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f22640k;

    public Address(String r10, int r11, Dns r12, SocketFactory r13, SSLSocketFactory r14, HostnameVerifier r15, b r16, Authenticator r17, Proxy r18, List r19, List r110, ProxySelector r111) {
        HttpUrl.Builder r20 = new HttpUrl.Builder();
        if (r14 == null) goto L5;
        String r21 = "https";
    L6:
        this.f22630a = r20.u(r21).g(r10).n(r11).c();
        if (r12 == null) goto L31;
        this.f22631b = r12;
        if (r13 == null) goto L29;
        this.f22632c = r13;
        if (r17 == null) goto L27;
        this.f22633d = r17;
        if (r19 == null) goto L25;
        this.f22634e = Util.immutableList(r19);
        if (r110 == null) goto L23;
        this.f22635f = Util.immutableList(r110);
        if (r111 == null) goto L21;
        this.f22636g = r111;
        this.f22637h = r18;
        this.f22638i = r14;
        this.f22639j = r15;
        this.f22640k = r16;
        return;
    L21:
        throw new NullPointerException("proxySelector == null");
    L23:
        throw new NullPointerException("connectionSpecs == null");
    L25:
        throw new NullPointerException("protocols == null");
    L27:
        throw new NullPointerException("proxyAuthenticator == null");
    L29:
        throw new NullPointerException("socketFactory == null");
    L31:
        throw new NullPointerException("dns == null");
    L5:
        r21 = HttpHost.DEFAULT_SCHEME_NAME;
        goto L6
    }

    public b a() {
        return this.f22640k;
    }

    public List b() {
        return this.f22635f;
    }

    public Dns c() {
        return this.f22631b;
    }

    public boolean d(Address r10) {
        if (this.f22631b.equals(r10.f22631b) == true) goto L5;
    L23:
        return false;
    L5:
        if (this.f22633d.equals(r10.f22633d) == false) goto L23;
        if (this.f22634e.equals(r10.f22634e) == false) goto L23;
        if (this.f22635f.equals(r10.f22635f) == false) goto L23;
        if (this.f22636g.equals(r10.f22636g) == false) goto L23;
        if (Util.equal(this.f22637h, r10.f22637h) == false) goto L23;
        if (Util.equal(this.f22638i, r10.f22638i) == false) goto L23;
        if (Util.equal(this.f22639j, r10.f22639j) == false) goto L23;
        if (Util.equal(this.f22640k, r10.f22640k) == false) goto L23;
        if (l().z() != r10.l().z()) goto L23;
        return true;
    }

    public HostnameVerifier e() {
        return this.f22639j;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof Address) == false) goto L9;
        Address r11 = (Address) r10;
        if (this.f22630a.equals(r11.f22630a) == false) goto L9;
        if (d(r11) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public List f() {
        return this.f22634e;
    }

    public Proxy g() {
        return this.f22637h;
    }

    public Authenticator h() {
        return this.f22633d;
    }

    public int hashCode() {
        int r10 = (((((((((((527 + this.f22630a.hashCode()) * 31) + this.f22631b.hashCode()) * 31) + this.f22633d.hashCode()) * 31) + this.f22634e.hashCode()) * 31) + this.f22635f.hashCode()) * 31) + this.f22636g.hashCode()) * 31;
        Proxy r11 = this.f22637h;
        int r12 = 0;
        if (r11 == null) goto L5;
        int r13 = r11.hashCode();
    L6:
        int r14 = (r10 + r13) * 31;
        SSLSocketFactory r15 = this.f22638i;
        if (r15 == null) goto L9;
        int r16 = r15.hashCode();
    L10:
        int r17 = (r14 + r16) * 31;
        HostnameVerifier r18 = this.f22639j;
        if (r18 == null) goto L13;
        int r19 = r18.hashCode();
    L14:
        int r20 = (r17 + r19) * 31;
        b r21 = this.f22640k;
        if (r21 == null) goto L18;
        r12 = r21.hashCode();
    L18:
        return r20 + r12;
    L13:
        r19 = 0;
        goto L14
    L9:
        r16 = 0;
        goto L10
    L5:
        r13 = 0;
        goto L6
    }

    public ProxySelector i() {
        return this.f22636g;
    }

    public SocketFactory j() {
        return this.f22632c;
    }

    public SSLSocketFactory k() {
        return this.f22638i;
    }

    public HttpUrl l() {
        return this.f22630a;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("Address{");
        r10.append(this.f22630a.m());
        r10.append(":");
        r10.append(this.f22630a.z());
        if (this.f22637h == null) goto L5;
        r10.append(", proxy=");
        r10.append(this.f22637h);
    L6:
        r10.append("}");
        return r10.toString();
    L5:
        r10.append(", proxySelector=");
        r10.append(this.f22636g);
        goto L6
    }
}
