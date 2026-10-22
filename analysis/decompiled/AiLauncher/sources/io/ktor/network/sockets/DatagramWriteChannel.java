package io.ktor.network.sockets;

import Wa.s;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lio/ktor/network/sockets/DatagramWriteChannel;", "", "Lio/ktor/network/sockets/Datagram;", "datagram", "LY8/t;", "send", "(Lio/ktor/network/sockets/Datagram;Le9/c;)Ljava/lang/Object;", "LWa/s;", "getOutgoing", "()LWa/s;", "outgoing", "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface DatagramWriteChannel {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Object send(DatagramWriteChannel datagramWriteChannel, Datagram datagram, InterfaceC4014c<? super t> interfaceC4014c) {
            return DatagramWriteChannel.super.send(datagram, interfaceC4014c);
        }
    }

    static /* synthetic */ Object send$suspendImpl(DatagramWriteChannel datagramWriteChannel, Datagram datagram, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objSend = datagramWriteChannel.getOutgoing().send(datagram, interfaceC4014c);
        return objSend == C4063a.g() ? objSend : t.f7040a;
    }

    s<Datagram> getOutgoing();

    default Object send(Datagram datagram, InterfaceC4014c<? super t> interfaceC4014c) {
        return send$suspendImpl(this, datagram, interfaceC4014c);
    }
}
