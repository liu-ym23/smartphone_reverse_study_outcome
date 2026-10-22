package io.ktor.network.tls;

import fb.v;
import io.ktor.utils.io.core.ByteReadPacketKt;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/ktor/network/tls/TLSHandshake;", "", "<init>", "()V", "Lio/ktor/network/tls/TLSHandshakeType;", "type", "Lio/ktor/network/tls/TLSHandshakeType;", "getType", "()Lio/ktor/network/tls/TLSHandshakeType;", "setType", "(Lio/ktor/network/tls/TLSHandshakeType;)V", "Lfb/v;", "packet", "Lfb/v;", "getPacket", "()Lfb/v;", "setPacket", "(Lfb/v;)V", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TLSHandshake {
    private TLSHandshakeType type = TLSHandshakeType.HelloRequest;
    private v packet = ByteReadPacketKt.getByteReadPacketEmpty();

    public final v getPacket() {
        return this.packet;
    }

    public final TLSHandshakeType getType() {
        return this.type;
    }

    public final void setPacket(v vVar) {
        p.i(vVar, "<set-?>");
        this.packet = vVar;
    }

    public final void setType(TLSHandshakeType tLSHandshakeType) {
        p.i(tLSHandshakeType, "<set-?>");
        this.type = tLSHandshakeType;
    }
}
