package fc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: fc.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C4085a extends c {
    public C4085a(i iVar, d dVar, long j10, int i10) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(dVar.f32638a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j11 = j10 + (i10 * 8);
        this.f32636a = iVar.G(byteBufferAllocate, j11);
        this.f32637b = iVar.G(byteBufferAllocate, j11 + 4);
    }
}
