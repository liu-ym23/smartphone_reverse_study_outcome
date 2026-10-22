package F9;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* loaded from: classes4.dex */
public final class Q {

    /* renamed from: a, reason: collision with root package name */
    public final C0223a f635a;
    public final Proxy b;
    public final InetSocketAddress c;

    public Q(C0223a c0223a, Proxy proxy, InetSocketAddress socketAddress) {
        kotlin.jvm.internal.k.f(socketAddress, "socketAddress");
        this.f635a = c0223a;
        this.b = proxy;
        this.c = socketAddress;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Q)) {
            return false;
        }
        Q q5 = (Q) obj;
        return kotlin.jvm.internal.k.b(q5.f635a, this.f635a) && kotlin.jvm.internal.k.b(q5.b, this.b) && kotlin.jvm.internal.k.b(q5.c, this.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + ((this.f635a.hashCode() + 527) * 31)) * 31);
    }

    public final String toString() {
        return "Route{" + this.c + '}';
    }
}
