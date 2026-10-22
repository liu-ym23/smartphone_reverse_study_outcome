package io.ktor.network.tls;

import fb.C4074a;
import fb.s;
import io.ktor.http.auth.AuthScheme;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.utils.io.core.ByteReadPacketKt;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u001c\u0010\b\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lio/ktor/network/tls/Digest;", AuthScheme.Digest, "()Lfb/s;", "Lio/ktor/network/tls/TLSHandshake;", "record", "LY8/t;", "plusAssign-Hh8V18w", "(Lfb/s;Lio/ktor/network/tls/TLSHandshake;)V", "plusAssign", "ktor-network-tls"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UtilsKt {
    public static final s Digest() {
        return Digest.m160constructorimpl(BytePacketBuilderKt.BytePacketBuilder());
    }

    /* renamed from: plusAssign-Hh8V18w, reason: not valid java name */
    public static final void m168plusAssignHh8V18w(s plusAssign, TLSHandshake record) throws TLSException {
        p.i(plusAssign, "$this$plusAssign");
        p.i(record, "record");
        if (record.getType() == TLSHandshakeType.HelloRequest) {
            throw new IllegalStateException("Check failed.");
        }
        C4074a c4074a = new C4074a();
        RenderKt.writeTLSHandshakeType(c4074a, record.getType(), (int) ByteReadPacketKt.getRemaining(record.getPacket()));
        if (ByteReadPacketKt.getRemaining(record.getPacket()) > 0) {
            BytePacketBuilderKt.writePacket(c4074a, ByteReadPacketKt.copy(record.getPacket()));
        }
        Digest.m166updateimpl(plusAssign, c4074a);
    }
}
