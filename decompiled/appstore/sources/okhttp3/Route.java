package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: loaded from: classes4.dex */
public final class Route {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Address f22826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Proxy f22827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f22828c;

    public Route(Address r10, Proxy r11, InetSocketAddress r12) {
        if (r10 == null) goto L13;
        if (r11 == null) goto L11;
        if (r12 == null) goto L9;
        this.f22826a = r10;
        this.f22827b = r11;
        this.f22828c = r12;
        return;
    L9:
        throw new NullPointerException("inetSocketAddress == null");
    L11:
        throw new NullPointerException("proxy == null");
    L13:
        throw new NullPointerException("address == null");
    }

    public Address a() {
        return this.f22826a;
    }

    public Proxy b() {
        return this.f22827b;
    }

    public boolean c() {
        if (this.f22826a.f22638i != null) goto L5;
    L7:
        return false;
    L5:
        if (this.f22827b.type() != Proxy.Type.HTTP) goto L7;
        return true;
    }

    public InetSocketAddress d() {
        return this.f22828c;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof Route) == false) goto L11;
        Route r11 = (Route) r10;
        if (r11.f22826a.equals(this.f22826a) == false) goto L11;
        if (r11.f22827b.equals(this.f22827b) == false) goto L11;
        if (r11.f22828c.equals(this.f22828c) == false) goto L11;
        return true;
    L11:
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f22826a.hashCode()) * 31) + this.f22827b.hashCode()) * 31) + this.f22828c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f22828c + "}";
    }
}
