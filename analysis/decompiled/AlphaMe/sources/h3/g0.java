package h3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    public final C0592a f12909a;

    /* renamed from: b, reason: collision with root package name */
    public final Proxy f12910b;

    /* renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f12911c;

    public g0(C0592a address, Proxy proxy, InetSocketAddress socketAddress) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Intrinsics.checkNotNullParameter(socketAddress, "socketAddress");
        this.f12909a = address;
        this.f12910b = proxy;
        this.f12911c = socketAddress;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof g0) {
            g0 g0Var = (g0) obj;
            if (Intrinsics.areEqual(g0Var.f12909a, this.f12909a) && Intrinsics.areEqual(g0Var.f12910b, this.f12910b) && Intrinsics.areEqual(g0Var.f12911c, this.f12911c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f12911c.hashCode() + ((this.f12910b.hashCode() + ((this.f12909a.hashCode() + 527) * 31)) * 31);
    }

    public final String toString() {
        return "Route{" + this.f12911c + '}';
    }
}
