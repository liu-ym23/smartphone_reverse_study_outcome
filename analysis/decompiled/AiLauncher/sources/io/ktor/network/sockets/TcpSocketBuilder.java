package io.ktor.network.sockets;

import Y8.t;
import com.stepos.deepbinder.core.constant.Constants;
import e9.InterfaceC4014c;
import io.ktor.network.selector.SelectorManager;
import io.ktor.network.sockets.SocketOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J6\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0086@¢\u0006\u0004\b\u0011\u0010\u0012J:\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e0\fH\u0086@¢\u0006\u0004\b\u0015\u0010\u0012J.\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00162\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0086@¢\u0006\u0004\b\u0011\u0010\u0018J2\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00162\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e0\fH\u0086@¢\u0006\u0004\b\u0015\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001aR\"\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lio/ktor/network/sockets/TcpSocketBuilder;", "Lio/ktor/network/sockets/Configurable;", "Lio/ktor/network/sockets/SocketOptions$PeerSocketOptions;", "Lio/ktor/network/selector/SelectorManager;", "selector", "options", "<init>", "(Lio/ktor/network/selector/SelectorManager;Lio/ktor/network/sockets/SocketOptions$PeerSocketOptions;)V", "", "hostname", "", "port", "Lkotlin/Function1;", "Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;", "LY8/t;", "configure", "Lio/ktor/network/sockets/Socket;", Constants.METHOD_CONNECT, "(Ljava/lang/String;ILp9/l;Le9/c;)Ljava/lang/Object;", "Lio/ktor/network/sockets/SocketOptions$AcceptorOptions;", "Lio/ktor/network/sockets/ServerSocket;", "bind", "Lio/ktor/network/sockets/SocketAddress;", "remoteAddress", "(Lio/ktor/network/sockets/SocketAddress;Lp9/l;Le9/c;)Ljava/lang/Object;", "localAddress", "Lio/ktor/network/selector/SelectorManager;", "Lio/ktor/network/sockets/SocketOptions$PeerSocketOptions;", "getOptions", "()Lio/ktor/network/sockets/SocketOptions$PeerSocketOptions;", "setOptions", "(Lio/ktor/network/sockets/SocketOptions$PeerSocketOptions;)V", "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TcpSocketBuilder implements Configurable<TcpSocketBuilder, SocketOptions.PeerSocketOptions> {
    private SocketOptions.PeerSocketOptions options;
    private final SelectorManager selector;

    public TcpSocketBuilder(SelectorManager selector, SocketOptions.PeerSocketOptions options) {
        p.i(selector, "selector");
        p.i(options, "options");
        this.selector = selector;
        this.options = options;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object bind$default(TcpSocketBuilder tcpSocketBuilder, String str, int i10, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "0.0.0.0";
        }
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.network.sockets.i
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return TcpSocketBuilder.bind$lambda$1((SocketOptions.AcceptorOptions) obj2);
                }
            };
        }
        return tcpSocketBuilder.bind(str, i10, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t bind$lambda$1(SocketOptions.AcceptorOptions acceptorOptions) {
        p.i(acceptorOptions, "<this>");
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t bind$lambda$3(SocketOptions.AcceptorOptions acceptorOptions) {
        p.i(acceptorOptions, "<this>");
        return t.f7040a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object connect$default(TcpSocketBuilder tcpSocketBuilder, String str, int i10, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.network.sockets.f
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return TcpSocketBuilder.connect$lambda$0((SocketOptions.TCPClientSocketOptions) obj2);
                }
            };
        }
        return tcpSocketBuilder.connect(str, i10, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t connect$lambda$0(SocketOptions.TCPClientSocketOptions tCPClientSocketOptions) {
        p.i(tCPClientSocketOptions, "<this>");
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t connect$lambda$2(SocketOptions.TCPClientSocketOptions tCPClientSocketOptions) {
        p.i(tCPClientSocketOptions, "<this>");
        return t.f7040a;
    }

    public final Object bind(String str, int i10, InterfaceC5074l<? super SocketOptions.AcceptorOptions, t> interfaceC5074l, InterfaceC4014c<? super ServerSocket> interfaceC4014c) {
        return bind(new InetSocketAddress(str, i10), interfaceC5074l, interfaceC4014c);
    }

    @Override // io.ktor.network.sockets.Configurable
    public /* bridge */ /* synthetic */ Configurable configure(InterfaceC5074l interfaceC5074l) {
        return configure((InterfaceC5074l<? super SocketOptions.PeerSocketOptions, t>) interfaceC5074l);
    }

    public final Object connect(String str, int i10, InterfaceC5074l<? super SocketOptions.TCPClientSocketOptions, t> interfaceC5074l, InterfaceC4014c<? super Socket> interfaceC4014c) {
        return connect(new InetSocketAddress(str, i10), interfaceC5074l, interfaceC4014c);
    }

    public final Object bind(SocketAddress socketAddress, InterfaceC5074l<? super SocketOptions.AcceptorOptions, t> interfaceC5074l, InterfaceC4014c<? super ServerSocket> interfaceC4014c) {
        SelectorManager selectorManager = this.selector;
        SocketOptions.AcceptorOptions acceptorOptionsTcpAccept$ktor_network = getOptions().tcpAccept$ktor_network();
        interfaceC5074l.invoke(acceptorOptionsTcpAccept$ktor_network);
        return ConnectUtilsJvmKt.tcpBind(selectorManager, socketAddress, acceptorOptionsTcpAccept$ktor_network, interfaceC4014c);
    }

    @Override // io.ktor.network.sockets.Configurable
    public TcpSocketBuilder configure(InterfaceC5074l<? super SocketOptions.PeerSocketOptions, t> interfaceC5074l) {
        return (TcpSocketBuilder) super.configure((InterfaceC5074l) interfaceC5074l);
    }

    public final Object connect(SocketAddress socketAddress, InterfaceC5074l<? super SocketOptions.TCPClientSocketOptions, t> interfaceC5074l, InterfaceC4014c<? super Socket> interfaceC4014c) {
        SelectorManager selectorManager = this.selector;
        SocketOptions.TCPClientSocketOptions tCPClientSocketOptionsTcpConnect$ktor_network = getOptions().tcpConnect$ktor_network();
        interfaceC5074l.invoke(tCPClientSocketOptionsTcpConnect$ktor_network);
        return ConnectUtilsJvmKt.tcpConnect(selectorManager, socketAddress, tCPClientSocketOptionsTcpConnect$ktor_network, interfaceC4014c);
    }

    @Override // io.ktor.network.sockets.Configurable
    public SocketOptions.PeerSocketOptions getOptions() {
        return this.options;
    }

    @Override // io.ktor.network.sockets.Configurable
    public void setOptions(SocketOptions.PeerSocketOptions peerSocketOptions) {
        p.i(peerSocketOptions, "<set-?>");
        this.options = peerSocketOptions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object connect$default(TcpSocketBuilder tcpSocketBuilder, SocketAddress socketAddress, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.network.sockets.h
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return TcpSocketBuilder.connect$lambda$2((SocketOptions.TCPClientSocketOptions) obj2);
                }
            };
        }
        return tcpSocketBuilder.connect(socketAddress, interfaceC5074l, interfaceC4014c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object bind$default(TcpSocketBuilder tcpSocketBuilder, SocketAddress socketAddress, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            socketAddress = null;
        }
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.network.sockets.g
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return TcpSocketBuilder.bind$lambda$3((SocketOptions.AcceptorOptions) obj2);
                }
            };
        }
        return tcpSocketBuilder.bind(socketAddress, interfaceC5074l, interfaceC4014c);
    }
}
