package io.ktor.network.sockets;

import Y8.t;
import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lio/ktor/network/sockets/ConnectedDatagramSocket;", "Lio/ktor/network/sockets/ASocket;", "Lio/ktor/network/sockets/ABoundSocket;", "Lio/ktor/network/sockets/AConnectedSocket;", "Lio/ktor/network/sockets/DatagramReadWriteChannel;", "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ConnectedDatagramSocket extends ASocket, ABoundSocket, AConnectedSocket, DatagramReadWriteChannel {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void dispose(ConnectedDatagramSocket connectedDatagramSocket) {
            ConnectedDatagramSocket.super.dispose();
        }

        @Deprecated
        public static Object receive(ConnectedDatagramSocket connectedDatagramSocket, InterfaceC4014c<? super Datagram> interfaceC4014c) {
            return ConnectedDatagramSocket.super.receive(interfaceC4014c);
        }

        @Deprecated
        public static Object send(ConnectedDatagramSocket connectedDatagramSocket, Datagram datagram, InterfaceC4014c<? super t> interfaceC4014c) {
            return ConnectedDatagramSocket.super.send(datagram, interfaceC4014c);
        }
    }
}
