package O4;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class a extends c {
    public a(i iVar, d dVar, long j5, int i5) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(dVar.f4451a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j6 = j5 + (i5 * 8);
        this.f4449a = iVar.w(byteBufferAllocate, j6);
        this.f4450b = iVar.w(byteBufferAllocate, j6 + 4);
    }
}
