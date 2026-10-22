package io.ktor.network.sockets;

import Y8.t;
import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lio/ktor/network/sockets/BoundDatagramSocket;", "Lio/ktor/network/sockets/ASocket;", "Lio/ktor/network/sockets/ABoundSocket;", "Lio/ktor/network/sockets/DatagramReadWriteChannel;", "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface BoundDatagramSocket extends ASocket, ABoundSocket, DatagramReadWriteChannel {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void dispose(BoundDatagramSocket boundDatagramSocket) {
            BoundDatagramSocket.super.dispose();
        }

        @Deprecated
        public static Object receive(BoundDatagramSocket boundDatagramSocket, InterfaceC4014c<? super Datagram> interfaceC4014c) {
            return BoundDatagramSocket.super.receive(interfaceC4014c);
        }

        @Deprecated
        public static Object send(BoundDatagramSocket boundDatagramSocket, Datagram datagram, InterfaceC4014c<? super t> interfaceC4014c) {
            return BoundDatagramSocket.super.send(datagram, interfaceC4014c);
        }
    }
}
