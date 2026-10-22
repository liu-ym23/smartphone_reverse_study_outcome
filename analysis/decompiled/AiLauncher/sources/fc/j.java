package fc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes5.dex */
public class j extends e {
    public j(i iVar, d dVar, long j10) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(dVar.f32638a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j11 = dVar.f32640c + (j10 * dVar.f32642e);
        this.f32647a = iVar.G(byteBufferAllocate, j11);
        this.f32648b = iVar.G(byteBufferAllocate, 4 + j11);
        this.f32649c = iVar.G(byteBufferAllocate, 8 + j11);
        this.f32650d = iVar.G(byteBufferAllocate, j11 + 20);
    }
}
