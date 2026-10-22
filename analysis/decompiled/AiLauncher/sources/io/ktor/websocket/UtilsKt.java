package io.ktor.websocket;

import java.nio.ByteBuffer;
import kotlin.Metadata;

@Metadata(d1 = {"io/ktor/websocket/UtilsKt__UtilsJvmKt", "io/ktor/websocket/UtilsKt__UtilsKt"}, k = 4, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UtilsKt {
    public static final int flagAt(boolean z10, int i10) {
        return UtilsKt__UtilsKt.flagAt(z10, i10);
    }

    public static final int getOUTGOING_CHANNEL_CAPACITY() {
        return UtilsKt__UtilsJvmKt.getOUTGOING_CHANNEL_CAPACITY();
    }

    public static final byte xor(byte b10, byte b11) {
        return UtilsKt__UtilsKt.xor(b10, b11);
    }

    public static final void xor(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        UtilsKt__UtilsJvmKt.xor(byteBuffer, byteBuffer2);
    }
}
