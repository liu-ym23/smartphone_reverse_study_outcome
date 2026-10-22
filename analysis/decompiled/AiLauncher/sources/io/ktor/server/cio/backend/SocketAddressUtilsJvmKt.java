package io.ktor.server.cio.backend;

import io.ktor.network.sockets.JavaSocketAddressUtilsKt;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002*\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/network/sockets/SocketAddress;", "Ljava/net/SocketAddress;", "Lio/ktor/util/network/NetworkAddress;", "toNetworkAddress", "(Lio/ktor/network/sockets/SocketAddress;)Ljava/net/SocketAddress;", "ktor-server-cio"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SocketAddressUtilsJvmKt {
    public static final SocketAddress toNetworkAddress(io.ktor.network.sockets.SocketAddress socketAddress) {
        p.i(socketAddress, "<this>");
        SocketAddress javaAddress = JavaSocketAddressUtilsKt.toJavaAddress(socketAddress);
        if (javaAddress instanceof InetSocketAddress) {
            return (InetSocketAddress) javaAddress;
        }
        return null;
    }
}
