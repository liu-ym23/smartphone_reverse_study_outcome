package C4;

import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class H {

    /* renamed from: a, reason: collision with root package name */
    final C0271a f731a;

    /* renamed from: b, reason: collision with root package name */
    final Proxy f732b;

    /* renamed from: c, reason: collision with root package name */
    final InetSocketAddress f733c;

    public H(C0271a c0271a, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (c0271a == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.f731a = c0271a;
        this.f732b = proxy;
        this.f733c = inetSocketAddress;
    }

    public C0271a a() {
        return this.f731a;
    }

    public Proxy b() {
        return this.f732b;
    }

    public boolean c() {
        return this.f731a.f749i != null && this.f732b.type() == Proxy.Type.HTTP;
    }

    public InetSocketAddress d() {
        return this.f733c;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof H)) {
            return false;
        }
        H h5 = (H) obj;
        return h5.f731a.equals(this.f731a) && h5.f732b.equals(this.f732b) && h5.f733c.equals(this.f733c);
    }

    public int hashCode() {
        return ((((527 + this.f731a.hashCode()) * 31) + this.f732b.hashCode()) * 31) + this.f733c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f733c + "}";
    }
}
