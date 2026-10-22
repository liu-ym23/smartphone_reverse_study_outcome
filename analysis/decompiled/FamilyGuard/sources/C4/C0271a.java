package C4;

import C4.w;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: C4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0271a {

    /* renamed from: a, reason: collision with root package name */
    final w f741a;

    /* renamed from: b, reason: collision with root package name */
    final q f742b;

    /* renamed from: c, reason: collision with root package name */
    final SocketFactory f743c;

    /* renamed from: d, reason: collision with root package name */
    final InterfaceC0273c f744d;

    /* renamed from: e, reason: collision with root package name */
    final List<B> f745e;

    /* renamed from: f, reason: collision with root package name */
    final List<l> f746f;

    /* renamed from: g, reason: collision with root package name */
    final ProxySelector f747g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    final Proxy f748h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    final SSLSocketFactory f749i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    final HostnameVerifier f750j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    final C0277g f751k;

    public C0271a(String str, int i5, q qVar, SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable C0277g c0277g, InterfaceC0273c interfaceC0273c, @Nullable Proxy proxy, List<B> list, List<l> list2, ProxySelector proxySelector) {
        this.f741a = new w.a().s(sSLSocketFactory != null ? "https" : "http").g(str).n(i5).c();
        if (qVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.f742b = qVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.f743c = socketFactory;
        if (interfaceC0273c == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.f744d = interfaceC0273c;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.f745e = D4.e.t(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f746f = D4.e.t(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.f747g = proxySelector;
        this.f748h = proxy;
        this.f749i = sSLSocketFactory;
        this.f750j = hostnameVerifier;
        this.f751k = c0277g;
    }

    @Nullable
    public C0277g a() {
        return this.f751k;
    }

    public List<l> b() {
        return this.f746f;
    }

    public q c() {
        return this.f742b;
    }

    boolean d(C0271a c0271a) {
        return this.f742b.equals(c0271a.f742b) && this.f744d.equals(c0271a.f744d) && this.f745e.equals(c0271a.f745e) && this.f746f.equals(c0271a.f746f) && this.f747g.equals(c0271a.f747g) && Objects.equals(this.f748h, c0271a.f748h) && Objects.equals(this.f749i, c0271a.f749i) && Objects.equals(this.f750j, c0271a.f750j) && Objects.equals(this.f751k, c0271a.f751k) && l().y() == c0271a.l().y();
    }

    @Nullable
    public HostnameVerifier e() {
        return this.f750j;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof C0271a)) {
            return false;
        }
        C0271a c0271a = (C0271a) obj;
        return this.f741a.equals(c0271a.f741a) && d(c0271a);
    }

    public List<B> f() {
        return this.f745e;
    }

    @Nullable
    public Proxy g() {
        return this.f748h;
    }

    public InterfaceC0273c h() {
        return this.f744d;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.f741a.hashCode()) * 31) + this.f742b.hashCode()) * 31) + this.f744d.hashCode()) * 31) + this.f745e.hashCode()) * 31) + this.f746f.hashCode()) * 31) + this.f747g.hashCode()) * 31) + Objects.hashCode(this.f748h)) * 31) + Objects.hashCode(this.f749i)) * 31) + Objects.hashCode(this.f750j)) * 31) + Objects.hashCode(this.f751k);
    }

    public ProxySelector i() {
        return this.f747g;
    }

    public SocketFactory j() {
        return this.f743c;
    }

    @Nullable
    public SSLSocketFactory k() {
        return this.f749i;
    }

    public w l() {
        return this.f741a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f741a.m());
        sb.append(":");
        sb.append(this.f741a.y());
        if (this.f748h != null) {
            sb.append(", proxy=");
            sb.append(this.f748h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f747g);
        }
        sb.append("}");
        return sb.toString();
    }
}
