package io.ktor.network.sockets;

import Ua.InterfaceC1089x;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.network.selector.SelectInterest;
import io.ktor.network.selector.SelectableBase;
import io.ktor.network.selector.SelectorManager;
import java.io.IOException;
import java.net.SocketOption;
import java.net.StandardSocketOptions;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.JobKt__JobKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u0082@¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\tH\u0096@¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\u00020\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lio/ktor/network/sockets/ServerSocketImpl;", "Lio/ktor/network/selector/SelectableBase;", "Lio/ktor/network/sockets/ServerSocket;", "Ljava/nio/channels/ServerSocketChannel;", "channel", "Lio/ktor/network/selector/SelectorManager;", "selector", "<init>", "(Ljava/nio/channels/ServerSocketChannel;Lio/ktor/network/selector/SelectorManager;)V", "Lio/ktor/network/sockets/Socket;", "acceptSuspend", "(Le9/c;)Ljava/lang/Object;", "Ljava/nio/channels/SocketChannel;", "nioChannel", "accepted", "(Ljava/nio/channels/SocketChannel;)Lio/ktor/network/sockets/Socket;", "accept", "LY8/t;", "close", "()V", "Ljava/nio/channels/ServerSocketChannel;", "getChannel", "()Ljava/nio/channels/ServerSocketChannel;", "Lio/ktor/network/selector/SelectorManager;", "getSelector", "()Lio/ktor/network/selector/SelectorManager;", "LUa/x;", "socketContext", "LUa/x;", "getSocketContext", "()LUa/x;", "Lio/ktor/network/sockets/SocketAddress;", "getLocalAddress", "()Lio/ktor/network/sockets/SocketAddress;", "localAddress", "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ServerSocketImpl extends SelectableBase implements ServerSocket {
    private final ServerSocketChannel channel;
    private final SelectorManager selector;
    private final InterfaceC1089x socketContext;

    @InterfaceC4112d(c = "io.ktor.network.sockets.ServerSocketImpl", f = "ServerSocketImpl.kt", l = {41}, m = "acceptSuspend")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.network.sockets.ServerSocketImpl$acceptSuspend$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ServerSocketImpl.this.acceptSuspend(this);
        }
    }

    public ServerSocketImpl(ServerSocketChannel channel, SelectorManager selector) {
        p.i(channel, "channel");
        p.i(selector, "selector");
        this.channel = channel;
        this.selector = selector;
        if (getChannel().isBlocking()) {
            throw new IllegalArgumentException("Channel need to be configured as non-blocking.");
        }
        this.socketContext = JobKt__JobKt.b(null, 1, null);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0041 -> B:18:0x0044). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object acceptSuspend(e9.InterfaceC4014c<? super io.ktor.network.sockets.Socket> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof io.ktor.network.sockets.ServerSocketImpl.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            io.ktor.network.sockets.ServerSocketImpl$acceptSuspend$1 r0 = (io.ktor.network.sockets.ServerSocketImpl.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.network.sockets.ServerSocketImpl$acceptSuspend$1 r0 = new io.ktor.network.sockets.ServerSocketImpl$acceptSuspend$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r5)
            goto L44
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r5)
        L34:
            io.ktor.network.selector.SelectInterest r5 = io.ktor.network.selector.SelectInterest.ACCEPT
            r4.interestOp(r5, r3)
            io.ktor.network.selector.SelectorManager r2 = r4.selector
            r0.label = r3
            java.lang.Object r5 = r2.select(r4, r5, r0)
            if (r5 != r1) goto L44
            return r1
        L44:
            java.nio.channels.ServerSocketChannel r5 = r4.getChannel()
            java.nio.channels.SocketChannel r5 = r5.accept()
            if (r5 == 0) goto L34
            io.ktor.network.sockets.Socket r4 = r4.accepted(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.sockets.ServerSocketImpl.acceptSuspend(e9.c):java.lang.Object");
    }

    private final Socket accepted(SocketChannel nioChannel) throws IOException {
        interestOp(SelectInterest.ACCEPT, false);
        nioChannel.configureBlocking(false);
        if (getLocalAddress() instanceof InetSocketAddress) {
            if (JavaSocketOptionsKt.getJava7NetworkApisAvailable()) {
                nioChannel.setOption((SocketOption<SocketOption>) StandardSocketOptions.TCP_NODELAY, (SocketOption) Boolean.TRUE);
            } else {
                nioChannel.socket().setTcpNoDelay(true);
            }
        }
        return new SocketImpl(nioChannel, this.selector, null, 4, null);
    }

    @Override // io.ktor.network.sockets.Acceptable
    public Object accept(InterfaceC4014c<? super Socket> interfaceC4014c) throws IOException {
        SocketChannel socketChannelAccept = getChannel().accept();
        return socketChannelAccept != null ? accepted(socketChannelAccept) : acceptSuspend(interfaceC4014c);
    }

    @Override // io.ktor.network.selector.SelectableBase, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            try {
                getChannel().close();
                this.selector.notifyClosed(this);
                getSocketContext().complete();
            } catch (Throwable th) {
                this.selector.notifyClosed(this);
                throw th;
            }
        } catch (Throwable th2) {
            getSocketContext().e(th2);
        }
    }

    @Override // io.ktor.network.selector.SelectableBase, io.ktor.network.selector.Selectable, Ua.InterfaceC1045a0
    public void dispose() {
        super.dispose();
    }

    @Override // io.ktor.network.sockets.ABoundSocket
    public SocketAddress getLocalAddress() {
        java.net.SocketAddress localAddress = JavaSocketOptionsKt.getJava7NetworkApisAvailable() ? getChannel().getLocalAddress() : getChannel().socket().getLocalSocketAddress();
        p.f(localAddress);
        return JavaSocketAddressUtilsKt.toSocketAddress(localAddress);
    }

    public final SelectorManager getSelector() {
        return this.selector;
    }

    @Override // io.ktor.network.selector.Selectable
    public ServerSocketChannel getChannel() {
        return this.channel;
    }

    @Override // io.ktor.network.sockets.ASocket
    public InterfaceC1089x getSocketContext() {
        return this.socketContext;
    }
}
