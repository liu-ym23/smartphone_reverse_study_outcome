package ad;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public final okhttp3.a f176a;

    /* renamed from: b, reason: collision with root package name */
    public final Proxy f177b;

    /* renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f178c;

    public u(okhttp3.a address, Proxy proxy, InetSocketAddress socketAddress) {
        kotlin.jvm.internal.g.f(address, "address");
        kotlin.jvm.internal.g.f(socketAddress, "socketAddress");
        this.f176a = address;
        this.f177b = proxy;
        this.f178c = socketAddress;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return kotlin.jvm.internal.g.b(uVar.f176a, this.f176a) && kotlin.jvm.internal.g.b(uVar.f177b, this.f177b) && kotlin.jvm.internal.g.b(uVar.f178c, this.f178c);
    }

    public final int hashCode() {
        return this.f178c.hashCode() + ((this.f177b.hashCode() + ((this.f176a.hashCode() + 527) * 31)) * 31);
    }

    public final String toString() {
        String hostAddress;
        StringBuilder sb2 = new StringBuilder();
        okhttp3.a aVar = this.f176a;
        okhttp3.g gVar = aVar.h;
        okhttp3.g gVar2 = aVar.h;
        String str = gVar.f10980d;
        InetSocketAddress inetSocketAddress = this.f178c;
        InetAddress address = inetSocketAddress.getAddress();
        String strB = (address == null || (hostAddress = address.getHostAddress()) == null) ? null : bd.c.b(hostAddress);
        if (gc.q.m0(str, ':')) {
            sb2.append("[");
            sb2.append(str);
            sb2.append("]");
        } else {
            sb2.append(str);
        }
        if (gVar2.f10981e != inetSocketAddress.getPort() || str.equals(strB)) {
            sb2.append(":");
            sb2.append(gVar2.f10981e);
        }
        if (!str.equals(strB)) {
            if (this.f177b.equals(Proxy.NO_PROXY)) {
                sb2.append(" at ");
            } else {
                sb2.append(" via proxy ");
            }
            if (strB == null) {
                sb2.append("<unresolved>");
            } else if (gc.q.m0(strB, ':')) {
                sb2.append("[");
                sb2.append(strB);
                sb2.append("]");
            } else {
                sb2.append(strB);
            }
            sb2.append(":");
            sb2.append(inetSocketAddress.getPort());
        }
        String string = sb2.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }
}
