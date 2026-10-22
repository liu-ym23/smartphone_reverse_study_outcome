package io.ktor.server.cio.backend;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.InternalAPI;
import java.net.SocketAddress;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@InternalAPI
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u000e\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007\u0012\u000e\u0010\t\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001f\u0010\t\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014¨\u0006\u0016"}, d2 = {"Lio/ktor/server/cio/backend/ServerIncomingConnection;", "", "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/utils/io/ByteWriteChannel;", "output", "Ljava/net/SocketAddress;", "Lio/ktor/util/network/NetworkAddress;", "remoteAddress", "localAddress", "<init>", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Ljava/net/SocketAddress;Ljava/net/SocketAddress;)V", "Lio/ktor/utils/io/ByteReadChannel;", "getInput", "()Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/ByteWriteChannel;", "getOutput", "()Lio/ktor/utils/io/ByteWriteChannel;", "Ljava/net/SocketAddress;", "getRemoteAddress", "()Ljava/net/SocketAddress;", "getLocalAddress", "ktor-server-cio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ServerIncomingConnection {
    private final ByteReadChannel input;
    private final SocketAddress localAddress;
    private final ByteWriteChannel output;
    private final SocketAddress remoteAddress;

    public ServerIncomingConnection(ByteReadChannel input, ByteWriteChannel output, SocketAddress socketAddress, SocketAddress socketAddress2) {
        p.i(input, "input");
        p.i(output, "output");
        this.input = input;
        this.output = output;
        this.remoteAddress = socketAddress;
        this.localAddress = socketAddress2;
    }

    public final ByteReadChannel getInput() {
        return this.input;
    }

    public final SocketAddress getLocalAddress() {
        return this.localAddress;
    }

    public final ByteWriteChannel getOutput() {
        return this.output;
    }

    public final SocketAddress getRemoteAddress() {
        return this.remoteAddress;
    }
}
