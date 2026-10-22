package ad;

import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public b f421a;

    /* renamed from: b, reason: collision with root package name */
    public SocketFactory f422b;

    /* renamed from: c, reason: collision with root package name */
    public SSLSocketFactory f423c;

    /* renamed from: d, reason: collision with root package name */
    public HostnameVerifier f424d;

    /* renamed from: e, reason: collision with root package name */
    public e f425e;

    /* renamed from: f, reason: collision with root package name */
    public b f426f;

    /* renamed from: g, reason: collision with root package name */
    public ProxySelector f427g;

    /* renamed from: h, reason: collision with root package name */
    public q f428h;
    public List i;

    /* renamed from: j, reason: collision with root package name */
    public List f429j;

    public final boolean a(a aVar) {
        aVar.getClass();
        return yb.k.a(this.f421a, aVar.f421a) && yb.k.a(this.f426f, aVar.f426f) && yb.k.a(this.i, aVar.i) && yb.k.a(this.f429j, aVar.f429j) && yb.k.a(this.f427g, aVar.f427g) && yb.k.a(this.f423c, aVar.f423c) && yb.k.a(this.f424d, aVar.f424d) && yb.k.a(this.f425e, aVar.f425e) && this.f428h.f563e == aVar.f428h.f563e;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return yb.k.a(this.f428h, aVar.f428h) && a(aVar);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f425e) + ((Objects.hashCode(this.f424d) + ((Objects.hashCode(this.f423c) + ((this.f427g.hashCode() + androidx.activity.b.e(this.f429j, androidx.activity.b.e(this.i, (this.f426f.hashCode() + ((this.f421a.hashCode() + androidx.activity.b.d(527, 31, this.f428h.i)) * 31)) * 31, 31), 31)) * 961)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Address{");
        q qVar = this.f428h;
        sb2.append(qVar.f562d);
        sb2.append(':');
        sb2.append(qVar.f563e);
        sb2.append(", ");
        sb2.append("proxySelector=" + this.f427g);
        sb2.append('}');
        return sb2.toString();
    }
}
