package O4;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class b extends c {
    public b(i iVar, d dVar, long j5, int i5) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(dVar.f4451a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j6 = j5 + (i5 * 16);
        this.f4449a = iVar.u(byteBufferAllocate, j6);
        this.f4450b = iVar.u(byteBufferAllocate, j6 + 8);
    }
}
