package io.ktor.websocket.internals;

import fb.C4074a;
import fb.v;
import fb.x;
import io.ktor.utils.io.core.ByteReadPacketKt;
import java.io.EOFException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lfb/v;", "", "data", "", "endsWith", "(Lfb/v;[B)Z", "ktor-websockets"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BytePacketUtilsKt {
    public static final boolean endsWith(v vVar, byte[] data) throws EOFException {
        p.i(vVar, "<this>");
        p.i(data, "data");
        C4074a c4074aG = vVar.getBufferField().g();
        ByteReadPacketKt.discard(c4074aG, ByteReadPacketKt.getRemaining(c4074aG) - data.length);
        return Arrays.equals(x.c(c4074aG), data);
    }
}
