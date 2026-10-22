package io.ktor.network.sockets;

import Wa.r;
import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096@¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lio/ktor/network/sockets/DatagramReadChannel;", "", "Lio/ktor/network/sockets/Datagram;", "receive", "(Le9/c;)Ljava/lang/Object;", "LWa/r;", "getIncoming", "()LWa/r;", "incoming", "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface DatagramReadChannel {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Object receive(DatagramReadChannel datagramReadChannel, InterfaceC4014c<? super Datagram> interfaceC4014c) {
            return DatagramReadChannel.super.receive(interfaceC4014c);
        }
    }

    static /* synthetic */ Object receive$suspendImpl(DatagramReadChannel datagramReadChannel, InterfaceC4014c<? super Datagram> interfaceC4014c) {
        return datagramReadChannel.getIncoming().receive(interfaceC4014c);
    }

    r<Datagram> getIncoming();

    default Object receive(InterfaceC4014c<? super Datagram> interfaceC4014c) {
        return receive$suspendImpl(this, interfaceC4014c);
    }
}
