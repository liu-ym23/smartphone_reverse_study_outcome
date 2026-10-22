package io.ktor.server.cio.backend;

import Ua.InterfaceC1083u;
import Ua.M;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import java.net.SocketAddress;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\u0018\u00002\u00020\u0001BQ\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u000e\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t\u0012\u000e\u0010\u000b\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001f\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001f\u0010\u000b\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR\u001f\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lio/ktor/server/cio/backend/ServerRequestScope;", "LUa/M;", "Lkotlin/coroutines/d;", "coroutineContext", "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/utils/io/ByteWriteChannel;", "output", "Ljava/net/SocketAddress;", "Lio/ktor/util/network/NetworkAddress;", "remoteAddress", "localAddress", "LUa/u;", "", "upgraded", "<init>", "(Lkotlin/coroutines/d;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Ljava/net/SocketAddress;Ljava/net/SocketAddress;LUa/u;)V", "withContext", "(Lkotlin/coroutines/d;)Lio/ktor/server/cio/backend/ServerRequestScope;", "Lkotlin/coroutines/d;", "getCoroutineContext", "()Lkotlin/coroutines/d;", "Lio/ktor/utils/io/ByteReadChannel;", "getInput", "()Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/ByteWriteChannel;", "getOutput", "()Lio/ktor/utils/io/ByteWriteChannel;", "Ljava/net/SocketAddress;", "getRemoteAddress", "()Ljava/net/SocketAddress;", "getLocalAddress", "LUa/u;", "getUpgraded", "()LUa/u;", "ktor-server-cio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ServerRequestScope implements M {
    private final kotlin.coroutines.d coroutineContext;
    private final ByteReadChannel input;
    private final SocketAddress localAddress;
    private final ByteWriteChannel output;
    private final SocketAddress remoteAddress;
    private final InterfaceC1083u<Boolean> upgraded;

    public ServerRequestScope(kotlin.coroutines.d coroutineContext, ByteReadChannel input, ByteWriteChannel output, SocketAddress socketAddress, SocketAddress socketAddress2, InterfaceC1083u<Boolean> interfaceC1083u) {
        p.i(coroutineContext, "coroutineContext");
        p.i(input, "input");
        p.i(output, "output");
        this.coroutineContext = coroutineContext;
        this.input = input;
        this.output = output;
        this.remoteAddress = socketAddress;
        this.localAddress = socketAddress2;
        this.upgraded = interfaceC1083u;
    }

    @Override // Ua.M
    public kotlin.coroutines.d getCoroutineContext() {
        return this.coroutineContext;
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

    public final InterfaceC1083u<Boolean> getUpgraded() {
        return this.upgraded;
    }

    public final ServerRequestScope withContext(kotlin.coroutines.d coroutineContext) {
        p.i(coroutineContext, "coroutineContext");
        return new ServerRequestScope(getCoroutineContext().plus(coroutineContext), this.input, this.output, this.remoteAddress, this.localAddress, this.upgraded);
    }
}
