package ad;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i0 {

    /* renamed from: a, reason: collision with root package name */
    public a f518a;

    /* renamed from: b, reason: collision with root package name */
    public Proxy f519b;

    /* renamed from: c, reason: collision with root package name */
    public InetSocketAddress f520c;

    public final boolean equals(Object obj) {
        if (!(obj instanceof i0)) {
            return false;
        }
        i0 i0Var = (i0) obj;
        return i0Var.f518a.equals(this.f518a) && i0Var.f519b.equals(this.f519b) && i0Var.f520c.equals(this.f520c);
    }

    public final int hashCode() {
        return this.f520c.hashCode() + ((this.f519b.hashCode() + ((this.f518a.hashCode() + 527) * 31)) * 31);
    }

    public final String toString() {
        return "Route{" + this.f520c + '}';
    }
}
