package io.ktor.server.cio;

import La.H;
import io.ktor.http.HttpMethod;
import io.ktor.http.RequestConnectionPoint;
import io.ktor.http.URLProtocol;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.util.network.NetworkAddressJvmKt;
import java.net.SocketAddress;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u001b\b\u0000\u0018\u00002\u00020\u0001BI\u0012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u000e\u0010\u0005\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0010R\u001c\u0010\u0005\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u000fR\u001a\u0010\b\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0011R\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000fR\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u00068VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001c\u0010\u000fR\u001a\u0010#\u001a\u00020\u00198VX\u0097\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u001e\u001a\u0004\b \u0010!R\u0014\u0010%\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010!R\u0014\u0010'\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010!R\u0014\u0010)\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u000fR\u0014\u0010+\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u000fR\u0014\u0010-\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u000fR\u0014\u0010/\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u000fR\u0014\u00101\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u0010!R\u0014\u00103\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u000f¨\u00064"}, d2 = {"Lio/ktor/server/cio/CIOConnectionPoint;", "Lio/ktor/http/RequestConnectionPoint;", "Ljava/net/SocketAddress;", "Lio/ktor/util/network/NetworkAddress;", "remoteNetworkAddress", "localNetworkAddress", "", "version", "uri", "hostHeaderValue", "Lio/ktor/http/HttpMethod;", "method", "<init>", "(Ljava/net/SocketAddress;Ljava/net/SocketAddress;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/ktor/http/HttpMethod;)V", "toString", "()Ljava/lang/String;", "Ljava/net/SocketAddress;", "Ljava/lang/String;", "getVersion", "getUri", "Lio/ktor/http/HttpMethod;", "getMethod", "()Lio/ktor/http/HttpMethod;", "getScheme", "scheme", "", "defaultPort", "I", "getHost", "getHost$annotations", "()V", "host", "getPort", "()I", "getPort$annotations", "port", "getLocalPort", "localPort", "getServerPort", "serverPort", "getLocalHost", "localHost", "getServerHost", "serverHost", "getLocalAddress", "localAddress", "getRemoteHost", "remoteHost", "getRemotePort", "remotePort", "getRemoteAddress", "remoteAddress", "ktor-server-cio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CIOConnectionPoint implements RequestConnectionPoint {
    private final int defaultPort;
    private final String hostHeaderValue;
    private final SocketAddress localNetworkAddress;
    private final HttpMethod method;
    private final SocketAddress remoteNetworkAddress;
    private final String uri;
    private final String version;

    public CIOConnectionPoint(SocketAddress socketAddress, SocketAddress socketAddress2, String version, String uri, String str, HttpMethod method) {
        p.i(version, "version");
        p.i(uri, "uri");
        p.i(method, "method");
        this.remoteNetworkAddress = socketAddress;
        this.localNetworkAddress = socketAddress2;
        this.version = version;
        this.uri = uri;
        this.hostHeaderValue = str;
        this.method = method;
        this.defaultPort = URLProtocol.INSTANCE.createOrDefault(getScheme()).getDefaultPort();
    }

    public static /* synthetic */ void getHost$annotations() {
    }

    public static /* synthetic */ void getPort$annotations() {
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public String getHost() {
        String hostname;
        SocketAddress socketAddress = this.localNetworkAddress;
        if (socketAddress != null && (hostname = NetworkAddressJvmKt.getHostname(socketAddress)) != null) {
            return hostname;
        }
        String str = this.hostHeaderValue;
        return str != null ? H.x1(str, ServerSentEventKt.COLON, null, 2, null) : "localhost";
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public String getLocalAddress() {
        String address;
        SocketAddress socketAddress = this.localNetworkAddress;
        return (socketAddress == null || (address = NetworkAddressJvmKt.getAddress(socketAddress)) == null) ? "localhost" : address;
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public String getLocalHost() {
        String hostname;
        SocketAddress socketAddress = this.localNetworkAddress;
        return (socketAddress == null || (hostname = NetworkAddressJvmKt.getHostname(socketAddress)) == null) ? "localhost" : hostname;
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public int getLocalPort() {
        SocketAddress socketAddress = this.localNetworkAddress;
        return socketAddress != null ? NetworkAddressJvmKt.getPort(socketAddress) : this.defaultPort;
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public HttpMethod getMethod() {
        return this.method;
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public int getPort() {
        String strN1;
        SocketAddress socketAddress = this.localNetworkAddress;
        if (socketAddress != null) {
            return NetworkAddressJvmKt.getPort(socketAddress);
        }
        String str = this.hostHeaderValue;
        if (str == null || (strN1 = H.n1(str, ServerSentEventKt.COLON, "80")) == null) {
            return 80;
        }
        return Integer.parseInt(strN1);
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public String getRemoteAddress() {
        String address;
        SocketAddress socketAddress = this.remoteNetworkAddress;
        return (socketAddress == null || (address = NetworkAddressJvmKt.getAddress(socketAddress)) == null) ? "unknown" : address;
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public String getRemoteHost() {
        String hostname;
        SocketAddress socketAddress = this.remoteNetworkAddress;
        return (socketAddress == null || (hostname = NetworkAddressJvmKt.getHostname(socketAddress)) == null) ? "unknown" : hostname;
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public int getRemotePort() {
        SocketAddress socketAddress = this.remoteNetworkAddress;
        if (socketAddress != null) {
            return NetworkAddressJvmKt.getPort(socketAddress);
        }
        return 0;
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public String getScheme() {
        return "http";
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public String getServerHost() {
        String strB1;
        String str = this.hostHeaderValue;
        return (str == null || (strB1 = H.B1(str, ServerSentEventKt.COLON, null, 2, null)) == null) ? getLocalHost() : strB1;
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public int getServerPort() {
        String strR1;
        String str = this.hostHeaderValue;
        return (str == null || (strR1 = H.r1(str, ServerSentEventKt.COLON, String.valueOf(this.defaultPort))) == null) ? getLocalPort() : Integer.parseInt(strR1);
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public String getUri() {
        return this.uri;
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public String getVersion() {
        return this.version;
    }

    public String toString() {
        return "CIOConnectionPoint(uri=" + getUri() + ", method=" + getMethod() + ", version=" + getVersion() + ", localAddress=" + getLocalAddress() + ", localPort=" + getLocalPort() + ", remoteAddress=" + getRemoteAddress() + ", remotePort=" + getRemotePort() + ')';
    }
}
