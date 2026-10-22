package ab;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public final a f515a;

    /* renamed from: b, reason: collision with root package name */
    public final Proxy f516b;

    /* renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f517c;

    public c0(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        q7.k.e(inetSocketAddress, "socketAddress");
        this.f515a = aVar;
        this.f516b = proxy;
        this.f517c = inetSocketAddress;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return q7.k.a(c0Var.f515a, this.f515a) && q7.k.a(c0Var.f516b, this.f516b) && q7.k.a(c0Var.f517c, this.f517c);
    }

    public final int hashCode() {
        return this.f517c.hashCode() + ((this.f516b.hashCode() + ((this.f515a.hashCode() + 527) * 31)) * 31);
    }

    public final String toString() {
        return "Route{" + this.f517c + '}';
    }
}
