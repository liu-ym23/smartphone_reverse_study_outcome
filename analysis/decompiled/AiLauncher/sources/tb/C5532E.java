package tb;

import La.H;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.sse.ServerSentEventKt;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import kotlin.Metadata;
import okhttp3.Protocol;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Ltb/E;", "", "Ltb/a;", Const.JSON_KEY_ADDRESS, "Ljava/net/Proxy;", "proxy", "Ljava/net/InetSocketAddress;", "socketAddress", "<init>", "(Ltb/a;Ljava/net/Proxy;Ljava/net/InetSocketAddress;)V", "", "c", "()Z", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ltb/a;", "()Ltb/a;", Const.INTENT_KEY_PKGNAME, "Ljava/net/Proxy;", "()Ljava/net/Proxy;", "Ljava/net/InetSocketAddress;", Const.INTENT_KEY_UMID, "()Ljava/net/InetSocketAddress;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: tb.E, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5532E {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C5534a address;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Proxy proxy;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final InetSocketAddress socketAddress;

    public C5532E(C5534a address, Proxy proxy, InetSocketAddress socketAddress) {
        kotlin.jvm.internal.p.i(address, "address");
        kotlin.jvm.internal.p.i(proxy, "proxy");
        kotlin.jvm.internal.p.i(socketAddress, "socketAddress");
        this.address = address;
        this.proxy = proxy;
        this.socketAddress = socketAddress;
    }

    /* renamed from: a, reason: from getter */
    public final C5534a getAddress() {
        return this.address;
    }

    /* renamed from: b, reason: from getter */
    public final Proxy getProxy() {
        return this.proxy;
    }

    public final boolean c() {
        if (this.proxy.type() != Proxy.Type.HTTP) {
            return false;
        }
        return this.address.getSslSocketFactory() != null || this.address.f().contains(Protocol.H2_PRIOR_KNOWLEDGE);
    }

    /* renamed from: d, reason: from getter */
    public final InetSocketAddress getSocketAddress() {
        return this.socketAddress;
    }

    public boolean equals(Object other) {
        if (!(other instanceof C5532E)) {
            return false;
        }
        C5532E c5532e = (C5532E) other;
        return kotlin.jvm.internal.p.d(c5532e.address, this.address) && kotlin.jvm.internal.p.d(c5532e.proxy, this.proxy) && kotlin.jvm.internal.p.d(c5532e.socketAddress, this.socketAddress);
    }

    public int hashCode() {
        return ((((527 + this.address.hashCode()) * 31) + this.proxy.hashCode()) * 31) + this.socketAddress.hashCode();
    }

    public String toString() {
        String hostAddress;
        StringBuilder sb2 = new StringBuilder();
        String host = this.address.getUrl().getHost();
        InetAddress address = this.socketAddress.getAddress();
        String strK = (address == null || (hostAddress = address.getHostAddress()) == null) ? null : ub.l.k(hostAddress);
        if (H.f0(host, ':', false, 2, null)) {
            sb2.append("[");
            sb2.append(host);
            sb2.append("]");
        } else {
            sb2.append(host);
        }
        if (this.address.getUrl().getPort() != this.socketAddress.getPort() || kotlin.jvm.internal.p.d(host, strK)) {
            sb2.append(ServerSentEventKt.COLON);
            sb2.append(this.address.getUrl().getPort());
        }
        if (!kotlin.jvm.internal.p.d(host, strK)) {
            if (kotlin.jvm.internal.p.d(this.proxy, Proxy.NO_PROXY)) {
                sb2.append(" at ");
            } else {
                sb2.append(" via proxy ");
            }
            if (strK == null) {
                sb2.append("<unresolved>");
            } else if (H.f0(strK, ':', false, 2, null)) {
                sb2.append("[");
                sb2.append(strK);
                sb2.append("]");
            } else {
                sb2.append(strK);
            }
            sb2.append(ServerSentEventKt.COLON);
            sb2.append(this.socketAddress.getPort());
        }
        return sb2.toString();
    }
}
