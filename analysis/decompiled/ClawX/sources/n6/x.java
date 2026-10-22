package n6;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final a f4163a;

    /* renamed from: b, reason: collision with root package name */
    public final Proxy f4164b;

    /* renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f4165c;

    public x(a aVar, Proxy proxy, InetSocketAddress socketAddress) {
        kotlin.jvm.internal.p.e(socketAddress, "socketAddress");
        this.f4163a = aVar;
        this.f4164b = proxy;
        this.f4165c = socketAddress;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return kotlin.jvm.internal.p.a(xVar.f4163a, this.f4163a) && kotlin.jvm.internal.p.a(xVar.f4164b, this.f4164b) && kotlin.jvm.internal.p.a(xVar.f4165c, this.f4165c);
    }

    public final int hashCode() {
        return this.f4165c.hashCode() + ((this.f4164b.hashCode() + ((this.f4163a.hashCode() + 527) * 31)) * 31);
    }

    public final String toString() {
        String hostAddress;
        StringBuilder sb = new StringBuilder();
        m mVar = this.f4163a.f3992h;
        String str = mVar.d;
        InetSocketAddress inetSocketAddress = this.f4165c;
        InetAddress address = inetSocketAddress.getAddress();
        String strB = (address == null || (hostAddress = address.getHostAddress()) == null) ? null : o6.c.b(hostAddress);
        if (x5.n.h1(str, AbstractJsonLexerKt.COLON)) {
            sb.append("[");
            sb.append(str);
            sb.append("]");
        } else {
            sb.append(str);
        }
        if (mVar.f4066e != inetSocketAddress.getPort() || str.equals(strB)) {
            sb.append(":");
            sb.append(mVar.f4066e);
        }
        if (!str.equals(strB)) {
            if (this.f4164b.equals(Proxy.NO_PROXY)) {
                sb.append(" at ");
            } else {
                sb.append(" via proxy ");
            }
            if (strB == null) {
                sb.append("<unresolved>");
            } else if (x5.n.h1(strB, AbstractJsonLexerKt.COLON)) {
                sb.append("[");
                sb.append(strB);
                sb.append("]");
            } else {
                sb.append(strB);
            }
            sb.append(":");
            sb.append(inetSocketAddress.getPort());
        }
        return sb.toString();
    }
}
