package io.ktor.network.tls.extensions;

import fb.v;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/network/tls/extensions/TLSExtension;", "", "Lio/ktor/network/tls/extensions/TLSExtensionType;", "type", "", "length", "Lfb/v;", "packet", "<init>", "(Lio/ktor/network/tls/extensions/TLSExtensionType;ILfb/v;)V", "Lio/ktor/network/tls/extensions/TLSExtensionType;", "getType", "()Lio/ktor/network/tls/extensions/TLSExtensionType;", "I", "getLength", "()I", "Lfb/v;", "getPacket", "()Lfb/v;", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TLSExtension {
    private final int length;
    private final v packet;
    private final TLSExtensionType type;

    public TLSExtension(TLSExtensionType type, int i10, v packet) {
        p.i(type, "type");
        p.i(packet, "packet");
        this.type = type;
        this.length = i10;
        this.packet = packet;
    }

    public final int getLength() {
        return this.length;
    }

    public final v getPacket() {
        return this.packet;
    }

    public final TLSExtensionType getType() {
        return this.type;
    }
}
