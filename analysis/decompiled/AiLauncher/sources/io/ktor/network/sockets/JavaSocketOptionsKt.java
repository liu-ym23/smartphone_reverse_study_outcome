package io.ktor.network.sockets;

import io.ktor.network.sockets.SocketOptions;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.SocketOption;
import java.net.StandardSocketOptions;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001b\u0010\u0006\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\"\u001a\u0010\t\u001a\u00020\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Ljava/nio/channels/SelectableChannel;", "LY8/t;", "nonBlocking", "(Ljava/nio/channels/SelectableChannel;)V", "Lio/ktor/network/sockets/SocketOptions;", "options", "assignOptions", "(Ljava/nio/channels/SelectableChannel;Lio/ktor/network/sockets/SocketOptions;)V", "", "java7NetworkApisAvailable", "Z", "getJava7NetworkApisAvailable", "()Z", "ktor-network"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class JavaSocketOptionsKt {
    private static final boolean java7NetworkApisAvailable;

    static {
        boolean z10;
        try {
            Class.forName("java.net.StandardSocketOptions");
            z10 = true;
        } catch (ClassNotFoundException unused) {
            z10 = false;
        }
        java7NetworkApisAvailable = z10;
    }

    public static final void assignOptions(SelectableChannel selectableChannel, SocketOptions options) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        p.i(selectableChannel, "<this>");
        p.i(options, "options");
        if (selectableChannel instanceof SocketChannel) {
            if (!TypeOfService.m147equalsimpl0(options.getTypeOfService(), TypeOfService.INSTANCE.m157getUNDEFINEDzieKYfw())) {
                if (java7NetworkApisAvailable) {
                    ((SocketChannel) selectableChannel).setOption((SocketOption<SocketOption>) StandardSocketOptions.IP_TOS, (SocketOption) Integer.valueOf(options.getTypeOfService() & 255));
                } else {
                    ((SocketChannel) selectableChannel).socket().setTrafficClass(options.getTypeOfService() & 255);
                }
            }
            if (options.getReuseAddress()) {
                if (java7NetworkApisAvailable) {
                    ((SocketChannel) selectableChannel).setOption((SocketOption<SocketOption>) StandardSocketOptions.SO_REUSEADDR, (SocketOption) Boolean.TRUE);
                } else {
                    ((SocketChannel) selectableChannel).socket().setReuseAddress(true);
                }
            }
            if (options.getReusePort()) {
                SocketOptionsPlatformCapabilities.INSTANCE.setReusePort((SocketChannel) selectableChannel);
            }
            if (options instanceof SocketOptions.PeerSocketOptions) {
                SocketOptions.PeerSocketOptions peerSocketOptions = (SocketOptions.PeerSocketOptions) options;
                Integer numValueOf = Integer.valueOf(peerSocketOptions.getReceiveBufferSize());
                if (numValueOf.intValue() <= 0) {
                    numValueOf = null;
                }
                if (numValueOf != null) {
                    int iIntValue = numValueOf.intValue();
                    if (java7NetworkApisAvailable) {
                        ((SocketChannel) selectableChannel).setOption((SocketOption<SocketOption>) StandardSocketOptions.SO_RCVBUF, (SocketOption) Integer.valueOf(iIntValue));
                    } else {
                        ((SocketChannel) selectableChannel).socket().setReceiveBufferSize(iIntValue);
                    }
                }
                Integer numValueOf2 = Integer.valueOf(peerSocketOptions.getSendBufferSize());
                if (numValueOf2.intValue() <= 0) {
                    numValueOf2 = null;
                }
                if (numValueOf2 != null) {
                    int iIntValue2 = numValueOf2.intValue();
                    if (java7NetworkApisAvailable) {
                        ((SocketChannel) selectableChannel).setOption((SocketOption<SocketOption>) StandardSocketOptions.SO_SNDBUF, (SocketOption) Integer.valueOf(iIntValue2));
                    } else {
                        ((SocketChannel) selectableChannel).socket().setSendBufferSize(iIntValue2);
                    }
                }
            }
            if (options instanceof SocketOptions.TCPClientSocketOptions) {
                SocketOptions.TCPClientSocketOptions tCPClientSocketOptions = (SocketOptions.TCPClientSocketOptions) options;
                Integer numValueOf3 = Integer.valueOf(tCPClientSocketOptions.getLingerSeconds());
                if (numValueOf3.intValue() < 0) {
                    numValueOf3 = null;
                }
                if (numValueOf3 != null) {
                    int iIntValue3 = numValueOf3.intValue();
                    if (java7NetworkApisAvailable) {
                        ((SocketChannel) selectableChannel).setOption((SocketOption<SocketOption>) StandardSocketOptions.SO_LINGER, (SocketOption) Integer.valueOf(iIntValue3));
                    } else {
                        ((SocketChannel) selectableChannel).socket().setSoLinger(true, iIntValue3);
                    }
                }
                Boolean keepAlive = tCPClientSocketOptions.getKeepAlive();
                if (keepAlive != null) {
                    boolean zBooleanValue = keepAlive.booleanValue();
                    if (java7NetworkApisAvailable) {
                        ((SocketChannel) selectableChannel).setOption((SocketOption<SocketOption>) StandardSocketOptions.SO_KEEPALIVE, (SocketOption) keepAlive);
                    } else {
                        ((SocketChannel) selectableChannel).socket().setKeepAlive(zBooleanValue);
                    }
                }
                if (java7NetworkApisAvailable) {
                    ((SocketChannel) selectableChannel).setOption((SocketOption<SocketOption>) StandardSocketOptions.TCP_NODELAY, (SocketOption) Boolean.valueOf(tCPClientSocketOptions.getNoDelay()));
                } else {
                    ((SocketChannel) selectableChannel).socket().setTcpNoDelay(tCPClientSocketOptions.getNoDelay());
                }
            }
        }
        if (selectableChannel instanceof ServerSocketChannel) {
            if (options.getReuseAddress()) {
                if (java7NetworkApisAvailable) {
                    ((ServerSocketChannel) selectableChannel).setOption((SocketOption<SocketOption>) StandardSocketOptions.SO_REUSEADDR, (SocketOption) Boolean.TRUE);
                } else {
                    ((ServerSocketChannel) selectableChannel).socket().setReuseAddress(true);
                }
            }
            if (options.getReusePort()) {
                SocketOptionsPlatformCapabilities.INSTANCE.setReusePort((ServerSocketChannel) selectableChannel);
            }
        }
        if (selectableChannel instanceof DatagramChannel) {
            if (!TypeOfService.m147equalsimpl0(options.getTypeOfService(), TypeOfService.INSTANCE.m157getUNDEFINEDzieKYfw())) {
                if (java7NetworkApisAvailable) {
                    ((DatagramChannel) selectableChannel).setOption((SocketOption<SocketOption>) StandardSocketOptions.IP_TOS, (SocketOption) Integer.valueOf(options.getTypeOfService() & 255));
                } else {
                    ((DatagramChannel) selectableChannel).socket().setTrafficClass(options.getTypeOfService() & 255);
                }
            }
            if (options.getReuseAddress()) {
                if (java7NetworkApisAvailable) {
                    ((DatagramChannel) selectableChannel).setOption((SocketOption<SocketOption>) StandardSocketOptions.SO_REUSEADDR, (SocketOption) Boolean.TRUE);
                } else {
                    ((DatagramChannel) selectableChannel).socket().setReuseAddress(true);
                }
            }
            if (options.getReusePort()) {
                SocketOptionsPlatformCapabilities.INSTANCE.setReusePort((DatagramChannel) selectableChannel);
            }
            if (options instanceof SocketOptions.UDPSocketOptions) {
                if (java7NetworkApisAvailable) {
                    ((DatagramChannel) selectableChannel).setOption((SocketOption<SocketOption>) StandardSocketOptions.SO_BROADCAST, (SocketOption) Boolean.valueOf(((SocketOptions.UDPSocketOptions) options).getBroadcast()));
                } else {
                    ((DatagramChannel) selectableChannel).socket().setBroadcast(((SocketOptions.UDPSocketOptions) options).getBroadcast());
                }
            }
            if (options instanceof SocketOptions.PeerSocketOptions) {
                SocketOptions.PeerSocketOptions peerSocketOptions2 = (SocketOptions.PeerSocketOptions) options;
                Integer numValueOf4 = Integer.valueOf(peerSocketOptions2.getReceiveBufferSize());
                if (numValueOf4.intValue() <= 0) {
                    numValueOf4 = null;
                }
                if (numValueOf4 != null) {
                    int iIntValue4 = numValueOf4.intValue();
                    if (java7NetworkApisAvailable) {
                        ((DatagramChannel) selectableChannel).setOption((SocketOption<SocketOption>) StandardSocketOptions.SO_RCVBUF, (SocketOption) Integer.valueOf(iIntValue4));
                    } else {
                        ((DatagramChannel) selectableChannel).socket().setReceiveBufferSize(iIntValue4);
                    }
                }
                Integer numValueOf5 = Integer.valueOf(peerSocketOptions2.getSendBufferSize());
                Integer num = numValueOf5.intValue() > 0 ? numValueOf5 : null;
                if (num != null) {
                    int iIntValue5 = num.intValue();
                    if (java7NetworkApisAvailable) {
                        ((DatagramChannel) selectableChannel).setOption((SocketOption<SocketOption>) StandardSocketOptions.SO_SNDBUF, (SocketOption) Integer.valueOf(iIntValue5));
                    } else {
                        ((DatagramChannel) selectableChannel).socket().setSendBufferSize(iIntValue5);
                    }
                }
            }
        }
    }

    public static final boolean getJava7NetworkApisAvailable() {
        return java7NetworkApisAvailable;
    }

    public static final void nonBlocking(SelectableChannel selectableChannel) throws IOException {
        p.i(selectableChannel, "<this>");
        selectableChannel.configureBlocking(false);
    }
}
