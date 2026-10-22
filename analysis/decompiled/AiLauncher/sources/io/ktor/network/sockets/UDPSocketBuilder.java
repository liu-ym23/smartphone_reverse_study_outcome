package io.ktor.network.sockets;

import Y8.t;
import com.stepos.deepbinder.core.constant.Constants;
import e9.InterfaceC4014c;
import io.ktor.network.selector.SelectorManager;
import io.ktor.network.sockets.SocketOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J2\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\nH\u0086@¢\u0006\u0004\b\u000e\u0010\u000fJ:\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\nH\u0086@¢\u0006\u0004\b\u000e\u0010\u0014J:\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\nH\u0086@¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0019R\"\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lio/ktor/network/sockets/UDPSocketBuilder;", "Lio/ktor/network/sockets/Configurable;", "Lio/ktor/network/sockets/SocketOptions$UDPSocketOptions;", "Lio/ktor/network/selector/SelectorManager;", "selector", "options", "<init>", "(Lio/ktor/network/selector/SelectorManager;Lio/ktor/network/sockets/SocketOptions$UDPSocketOptions;)V", "Lio/ktor/network/sockets/SocketAddress;", "localAddress", "Lkotlin/Function1;", "LY8/t;", "configure", "Lio/ktor/network/sockets/BoundDatagramSocket;", "bind", "(Lio/ktor/network/sockets/SocketAddress;Lp9/l;Le9/c;)Ljava/lang/Object;", "", "hostname", "", "port", "(Ljava/lang/String;ILp9/l;Le9/c;)Ljava/lang/Object;", "remoteAddress", "Lio/ktor/network/sockets/ConnectedDatagramSocket;", Constants.METHOD_CONNECT, "(Lio/ktor/network/sockets/SocketAddress;Lio/ktor/network/sockets/SocketAddress;Lp9/l;Le9/c;)Ljava/lang/Object;", "Lio/ktor/network/selector/SelectorManager;", "Lio/ktor/network/sockets/SocketOptions$UDPSocketOptions;", "getOptions", "()Lio/ktor/network/sockets/SocketOptions$UDPSocketOptions;", "setOptions", "(Lio/ktor/network/sockets/SocketOptions$UDPSocketOptions;)V", "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UDPSocketBuilder implements Configurable<UDPSocketBuilder, SocketOptions.UDPSocketOptions> {
    private SocketOptions.UDPSocketOptions options;
    private final SelectorManager selector;

    public UDPSocketBuilder(SelectorManager selector, SocketOptions.UDPSocketOptions options) {
        p.i(selector, "selector");
        p.i(options, "options");
        this.selector = selector;
        this.options = options;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object bind$default(UDPSocketBuilder uDPSocketBuilder, SocketAddress socketAddress, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            socketAddress = null;
        }
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.network.sockets.k
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return UDPSocketBuilder.bind$lambda$0((SocketOptions.UDPSocketOptions) obj2);
                }
            };
        }
        return uDPSocketBuilder.bind(socketAddress, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t bind$lambda$0(SocketOptions.UDPSocketOptions uDPSocketOptions) {
        p.i(uDPSocketOptions, "<this>");
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t bind$lambda$1(SocketOptions.UDPSocketOptions uDPSocketOptions) {
        p.i(uDPSocketOptions, "<this>");
        return t.f7040a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object connect$default(UDPSocketBuilder uDPSocketBuilder, SocketAddress socketAddress, SocketAddress socketAddress2, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            socketAddress2 = null;
        }
        if ((i10 & 4) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.network.sockets.l
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return UDPSocketBuilder.connect$lambda$2((SocketOptions.UDPSocketOptions) obj2);
                }
            };
        }
        return uDPSocketBuilder.connect(socketAddress, socketAddress2, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t connect$lambda$2(SocketOptions.UDPSocketOptions uDPSocketOptions) {
        p.i(uDPSocketOptions, "<this>");
        return t.f7040a;
    }

    public final Object bind(SocketAddress socketAddress, InterfaceC5074l<? super SocketOptions.UDPSocketOptions, t> interfaceC5074l, InterfaceC4014c<? super BoundDatagramSocket> interfaceC4014c) {
        SelectorManager selectorManager = this.selector;
        SocketOptions.UDPSocketOptions uDPSocketOptionsUdp$ktor_network = getOptions().udp$ktor_network();
        interfaceC5074l.invoke(uDPSocketOptionsUdp$ktor_network);
        return UDPSocketBuilderJvmKt.udpBind(selectorManager, socketAddress, uDPSocketOptionsUdp$ktor_network, interfaceC4014c);
    }

    @Override // io.ktor.network.sockets.Configurable
    public /* bridge */ /* synthetic */ Configurable configure(InterfaceC5074l interfaceC5074l) {
        return configure((InterfaceC5074l<? super SocketOptions.UDPSocketOptions, t>) interfaceC5074l);
    }

    public final Object connect(SocketAddress socketAddress, SocketAddress socketAddress2, InterfaceC5074l<? super SocketOptions.UDPSocketOptions, t> interfaceC5074l, InterfaceC4014c<? super ConnectedDatagramSocket> interfaceC4014c) {
        SelectorManager selectorManager = this.selector;
        SocketOptions.UDPSocketOptions uDPSocketOptionsUdp$ktor_network = getOptions().udp$ktor_network();
        interfaceC5074l.invoke(uDPSocketOptionsUdp$ktor_network);
        return UDPSocketBuilderJvmKt.udpConnect(selectorManager, socketAddress, socketAddress2, uDPSocketOptionsUdp$ktor_network, interfaceC4014c);
    }

    public final Object bind(String str, int i10, InterfaceC5074l<? super SocketOptions.UDPSocketOptions, t> interfaceC5074l, InterfaceC4014c<? super BoundDatagramSocket> interfaceC4014c) {
        return bind(new InetSocketAddress(str, i10), interfaceC5074l, interfaceC4014c);
    }

    @Override // io.ktor.network.sockets.Configurable
    public UDPSocketBuilder configure(InterfaceC5074l<? super SocketOptions.UDPSocketOptions, t> interfaceC5074l) {
        return (UDPSocketBuilder) super.configure((InterfaceC5074l) interfaceC5074l);
    }

    @Override // io.ktor.network.sockets.Configurable
    public SocketOptions.UDPSocketOptions getOptions() {
        return this.options;
    }

    @Override // io.ktor.network.sockets.Configurable
    public void setOptions(SocketOptions.UDPSocketOptions uDPSocketOptions) {
        p.i(uDPSocketOptions, "<set-?>");
        this.options = uDPSocketOptions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object bind$default(UDPSocketBuilder uDPSocketBuilder, String str, int i10, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "0.0.0.0";
        }
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.network.sockets.j
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return UDPSocketBuilder.bind$lambda$1((SocketOptions.UDPSocketOptions) obj2);
                }
            };
        }
        return uDPSocketBuilder.bind(str, i10, interfaceC5074l, interfaceC4014c);
    }
}
