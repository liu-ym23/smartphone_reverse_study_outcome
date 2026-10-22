package io.ktor.network.sockets;

import com.autonavi.aps.amapapi.config.Const;
import fb.v;
import io.ktor.utils.io.core.ByteReadPacketKt;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/network/sockets/Datagram;", "", "Lfb/v;", "packet", "Lio/ktor/network/sockets/SocketAddress;", Const.JSON_KEY_ADDRESS, "<init>", "(Lfb/v;Lio/ktor/network/sockets/SocketAddress;)V", "Lfb/v;", "getPacket", "()Lfb/v;", "Lio/ktor/network/sockets/SocketAddress;", "getAddress", "()Lio/ktor/network/sockets/SocketAddress;", "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Datagram {
    private final SocketAddress address;
    private final v packet;

    public Datagram(v packet, SocketAddress address) {
        p.i(packet, "packet");
        p.i(address, "address");
        this.packet = packet;
        this.address = address;
        if (ByteReadPacketKt.getRemaining(packet) <= 65535) {
            return;
        }
        throw new IllegalArgumentException(("Datagram size limit exceeded: " + ByteReadPacketKt.getRemaining(packet) + " of possible 65535").toString());
    }

    public final SocketAddress getAddress() {
        return this.address;
    }

    public final v getPacket() {
        return this.packet;
    }
}
