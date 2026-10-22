package io.ktor.websocket;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u001c\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0080\f¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001c\u0010\u0007\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0080\b¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", "other", "xor", "(BB)B", "", "", "at", "flagAt", "(ZI)I", "ktor-websockets"}, k = 5, mv = {2, 2, 0}, xi = 48, xs = "io/ktor/websocket/UtilsKt")
/* loaded from: classes4.dex */
final /* synthetic */ class UtilsKt__UtilsKt {
    public static final int flagAt(boolean z10, int i10) {
        if (z10) {
            return 1 << i10;
        }
        return 0;
    }

    public static final byte xor(byte b10, byte b11) {
        return (byte) (b10 ^ b11);
    }
}
