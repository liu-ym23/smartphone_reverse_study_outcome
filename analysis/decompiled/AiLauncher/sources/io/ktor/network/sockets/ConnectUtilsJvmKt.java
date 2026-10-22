package io.ktor.network.sockets;

import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.network.selector.SelectorManager;
import io.ktor.network.sockets.SocketOptions;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.ProtocolFamily;
import java.net.StandardProtocolFamily;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0080@¢\u0006\u0004\b\u0007\u0010\b\u001a*\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\nH\u0080@¢\u0006\u0004\b\f\u0010\r\u001a#\u0010\u0012\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a%\u0010\u0015\u001a\n \u0011*\u0004\u0018\u00010\u00140\u0014*\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lio/ktor/network/selector/SelectorManager;", "selector", "Lio/ktor/network/sockets/SocketAddress;", "remoteAddress", "Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;", "socketOptions", "Lio/ktor/network/sockets/Socket;", "tcpConnect", "(Lio/ktor/network/selector/SelectorManager;Lio/ktor/network/sockets/SocketAddress;Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;Le9/c;)Ljava/lang/Object;", "localAddress", "Lio/ktor/network/sockets/SocketOptions$AcceptorOptions;", "Lio/ktor/network/sockets/ServerSocket;", "tcpBind", "(Lio/ktor/network/selector/SelectorManager;Lio/ktor/network/sockets/SocketAddress;Lio/ktor/network/sockets/SocketOptions$AcceptorOptions;Le9/c;)Ljava/lang/Object;", "Ljava/nio/channels/spi/SelectorProvider;", Const.JSON_KEY_ADDRESS, "Ljava/nio/channels/SocketChannel;", "kotlin.jvm.PlatformType", "openSocketChannelFor", "(Ljava/nio/channels/spi/SelectorProvider;Lio/ktor/network/sockets/SocketAddress;)Ljava/nio/channels/SocketChannel;", "Ljava/nio/channels/ServerSocketChannel;", "openServerSocketChannelFor", "(Ljava/nio/channels/spi/SelectorProvider;Lio/ktor/network/sockets/SocketAddress;)Ljava/nio/channels/ServerSocketChannel;", "ktor-network"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConnectUtilsJvmKt {

    @InterfaceC4112d(c = "io.ktor.network.sockets.ConnectUtilsJvmKt", f = "ConnectUtilsJvm.kt", l = {21}, m = "tcpConnect")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.network.sockets.ConnectUtilsJvmKt$tcpConnect$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConnectUtilsJvmKt.tcpConnect(null, null, null, this);
        }
    }

    public static final ServerSocketChannel openServerSocketChannelFor(SelectorProvider selectorProvider, SocketAddress socketAddress) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        p.i(selectorProvider, "<this>");
        if (socketAddress != null && !(socketAddress instanceof InetSocketAddress)) {
            if (!(socketAddress instanceof UnixSocketAddress)) {
                throw new NoWhenBranchMatchedException();
            }
            Object objInvoke = SelectorProvider.class.getMethod("openServerSocketChannel", ProtocolFamily.class).invoke(selectorProvider, StandardProtocolFamily.valueOf("UNIX"));
            p.g(objInvoke, "null cannot be cast to non-null type java.nio.channels.ServerSocketChannel");
            return (ServerSocketChannel) objInvoke;
        }
        return selectorProvider.openServerSocketChannel();
    }

    public static final SocketChannel openSocketChannelFor(SelectorProvider selectorProvider, SocketAddress address) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        p.i(selectorProvider, "<this>");
        p.i(address, "address");
        if (address instanceof InetSocketAddress) {
            return selectorProvider.openSocketChannel();
        }
        if (!(address instanceof UnixSocketAddress)) {
            throw new NoWhenBranchMatchedException();
        }
        Object objInvoke = SelectorProvider.class.getMethod("openSocketChannel", ProtocolFamily.class).invoke(selectorProvider, StandardProtocolFamily.valueOf("UNIX"));
        p.g(objInvoke, "null cannot be cast to non-null type java.nio.channels.SocketChannel");
        return (SocketChannel) objInvoke;
    }

    public static final Object tcpBind(SelectorManager selectorManager, SocketAddress socketAddress, SocketOptions.AcceptorOptions acceptorOptions, InterfaceC4014c<? super ServerSocket> interfaceC4014c) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        ServerSocketChannel serverSocketChannelOpenServerSocketChannelFor = openServerSocketChannelFor(selectorManager.getProvider(), socketAddress);
        try {
            if (socketAddress instanceof InetSocketAddress) {
                p.f(serverSocketChannelOpenServerSocketChannelFor);
                JavaSocketOptionsKt.assignOptions(serverSocketChannelOpenServerSocketChannelFor, acceptorOptions);
            }
            p.f(serverSocketChannelOpenServerSocketChannelFor);
            JavaSocketOptionsKt.nonBlocking(serverSocketChannelOpenServerSocketChannelFor);
            ServerSocketImpl serverSocketImpl = new ServerSocketImpl(serverSocketChannelOpenServerSocketChannelFor, selectorManager);
            if (JavaSocketOptionsKt.getJava7NetworkApisAvailable()) {
                serverSocketImpl.getChannel().bind(socketAddress != null ? JavaSocketAddressUtilsKt.toJavaAddress(socketAddress) : null, acceptorOptions.getBacklogSize());
                return serverSocketImpl;
            }
            serverSocketImpl.getChannel().socket().bind(socketAddress != null ? JavaSocketAddressUtilsKt.toJavaAddress(socketAddress) : null, acceptorOptions.getBacklogSize());
            return serverSocketImpl;
        } catch (Throwable th) {
            serverSocketChannelOpenServerSocketChannelFor.close();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object tcpConnect(io.ktor.network.selector.SelectorManager r6, io.ktor.network.sockets.SocketAddress r7, io.ktor.network.sockets.SocketOptions.TCPClientSocketOptions r8, e9.InterfaceC4014c<? super io.ktor.network.sockets.Socket> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof io.ktor.network.sockets.ConnectUtilsJvmKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.network.sockets.ConnectUtilsJvmKt$tcpConnect$1 r0 = (io.ktor.network.sockets.ConnectUtilsJvmKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.network.sockets.ConnectUtilsJvmKt$tcpConnect$1 r0 = new io.ktor.network.sockets.ConnectUtilsJvmKt$tcpConnect$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L53
            if (r2 != r3) goto L4b
            java.lang.Object r6 = r0.L$7
            io.ktor.network.sockets.SocketImpl r6 = (io.ktor.network.sockets.SocketImpl) r6
            java.lang.Object r6 = r0.L$6
            io.ktor.network.sockets.SocketImpl r6 = (io.ktor.network.sockets.SocketImpl) r6
            java.lang.Object r7 = r0.L$5
            java.io.Closeable r7 = (java.io.Closeable) r7
            java.lang.Object r8 = r0.L$4
            java.nio.channels.SocketChannel r8 = (java.nio.channels.SocketChannel) r8
            java.lang.Object r8 = r0.L$3
            io.ktor.network.selector.SelectorManager r8 = (io.ktor.network.selector.SelectorManager) r8
            java.lang.Object r8 = r0.L$2
            io.ktor.network.sockets.SocketOptions$TCPClientSocketOptions r8 = (io.ktor.network.sockets.SocketOptions.TCPClientSocketOptions) r8
            java.lang.Object r8 = r0.L$1
            io.ktor.network.sockets.SocketAddress r8 = (io.ktor.network.sockets.SocketAddress) r8
            java.lang.Object r8 = r0.L$0
            io.ktor.network.selector.SelectorManager r8 = (io.ktor.network.selector.SelectorManager) r8
            kotlin.C4849c.b(r9)     // Catch: java.lang.Throwable -> L49
            return r6
        L49:
            r6 = move-exception
            goto Lb4
        L4b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L53:
            kotlin.C4849c.b(r9)
            java.nio.channels.spi.SelectorProvider r9 = r6.getProvider()
            java.nio.channels.SocketChannel r9 = openSocketChannelFor(r9, r7)
            boolean r2 = r7 instanceof io.ktor.network.sockets.InetSocketAddress     // Catch: java.lang.Throwable -> L69
            if (r2 == 0) goto L6c
            kotlin.jvm.internal.p.f(r9)     // Catch: java.lang.Throwable -> L69
            io.ktor.network.sockets.JavaSocketOptionsKt.assignOptions(r9, r8)     // Catch: java.lang.Throwable -> L69
            goto L6c
        L69:
            r6 = move-exception
            r7 = r9
            goto Lb4
        L6c:
            kotlin.jvm.internal.p.f(r9)     // Catch: java.lang.Throwable -> L69
            io.ktor.network.sockets.JavaSocketOptionsKt.nonBlocking(r9)     // Catch: java.lang.Throwable -> L69
            io.ktor.network.sockets.SocketImpl r2 = new io.ktor.network.sockets.SocketImpl     // Catch: java.lang.Throwable -> L69
            r2.<init>(r9, r6, r8)     // Catch: java.lang.Throwable -> L69
            java.net.SocketAddress r4 = io.ktor.network.sockets.JavaSocketAddressUtilsKt.toJavaAddress(r7)     // Catch: java.lang.Throwable -> L69
            java.lang.Object r5 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L69
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L69
            java.lang.Object r7 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L69
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L69
            java.lang.Object r7 = g9.h.a(r8)     // Catch: java.lang.Throwable -> L69
            r0.L$2 = r7     // Catch: java.lang.Throwable -> L69
            java.lang.Object r6 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L69
            r0.L$3 = r6     // Catch: java.lang.Throwable -> L69
            java.lang.Object r6 = g9.h.a(r9)     // Catch: java.lang.Throwable -> L69
            r0.L$4 = r6     // Catch: java.lang.Throwable -> L69
            r0.L$5 = r9     // Catch: java.lang.Throwable -> L69
            r0.L$6 = r2     // Catch: java.lang.Throwable -> L69
            java.lang.Object r6 = g9.h.a(r2)     // Catch: java.lang.Throwable -> L69
            r0.L$7 = r6     // Catch: java.lang.Throwable -> L69
            r6 = 0
            r0.I$0 = r6     // Catch: java.lang.Throwable -> L69
            r0.I$1 = r6     // Catch: java.lang.Throwable -> L69
            r0.I$2 = r6     // Catch: java.lang.Throwable -> L69
            r0.label = r3     // Catch: java.lang.Throwable -> L69
            java.lang.Object r6 = r2.connect$ktor_network(r4, r0)     // Catch: java.lang.Throwable -> L69
            if (r6 != r1) goto Lb3
            return r1
        Lb3:
            return r2
        Lb4:
            r7.close()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.sockets.ConnectUtilsJvmKt.tcpConnect(io.ktor.network.selector.SelectorManager, io.ktor.network.sockets.SocketAddress, io.ktor.network.sockets.SocketOptions$TCPClientSocketOptions, e9.c):java.lang.Object");
    }
}
