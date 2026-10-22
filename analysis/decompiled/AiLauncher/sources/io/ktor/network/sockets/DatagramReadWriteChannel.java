package io.ktor.network.sockets;

import Y8.t;
import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003À\u0006\u0003"}, d2 = {"Lio/ktor/network/sockets/DatagramReadWriteChannel;", "Lio/ktor/network/sockets/DatagramReadChannel;", "Lio/ktor/network/sockets/DatagramWriteChannel;", "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface DatagramReadWriteChannel extends DatagramReadChannel, DatagramWriteChannel {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Object receive(DatagramReadWriteChannel datagramReadWriteChannel, InterfaceC4014c<? super Datagram> interfaceC4014c) {
            return DatagramReadWriteChannel.super.receive(interfaceC4014c);
        }

        @Deprecated
        public static Object send(DatagramReadWriteChannel datagramReadWriteChannel, Datagram datagram, InterfaceC4014c<? super t> interfaceC4014c) {
            return DatagramReadWriteChannel.super.send(datagram, interfaceC4014c);
        }
    }
}
