package io.ktor.server.cio.backend;

import io.ktor.network.sockets.InetSocketAddress;
import io.ktor.network.sockets.SocketAddress;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\"\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lio/ktor/network/sockets/SocketAddress;", "", "getPort", "(Lio/ktor/network/sockets/SocketAddress;)Ljava/lang/Integer;", "port", "ktor-server-cio"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SocketAddressUtilsKt {
    public static final Integer getPort(SocketAddress socketAddress) {
        p.i(socketAddress, "<this>");
        InetSocketAddress inetSocketAddress = socketAddress instanceof InetSocketAddress ? (InetSocketAddress) socketAddress : null;
        if (inetSocketAddress != null) {
            return Integer.valueOf(inetSocketAddress.getPort());
        }
        return null;
    }
}
