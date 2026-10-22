package io.ktor.network.tls.cipher;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0006\u0010\t\"\u001a\u0010\u000b\u001a\u00020\n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"", "", "offset", "", "data", "LY8/t;", "set", "([BIJ)V", "", "([BIS)V", "Ljava/nio/ByteBuffer;", "EmptyByteBuffer", "Ljava/nio/ByteBuffer;", "getEmptyByteBuffer", "()Ljava/nio/ByteBuffer;", "ktor-network-tls"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CipherKt {
    private static final ByteBuffer EmptyByteBuffer;

    static {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(0);
        p.h(byteBufferAllocate, "allocate(...)");
        EmptyByteBuffer = byteBufferAllocate;
    }

    public static final ByteBuffer getEmptyByteBuffer() {
        return EmptyByteBuffer;
    }

    public static final void set(byte[] bArr, int i10, long j10) {
        p.i(bArr, "<this>");
        for (int i11 = 0; i11 < 8; i11++) {
            bArr[i11 + i10] = (byte) (j10 >>> ((7 - i11) * 8));
        }
    }

    public static final void set(byte[] bArr, int i10, short s10) {
        p.i(bArr, "<this>");
        for (int i11 = 0; i11 < 2; i11++) {
            bArr[i11 + i10] = (byte) (s10 >>> ((1 - i11) * 8));
        }
    }
}
