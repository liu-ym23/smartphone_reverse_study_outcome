package O4;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class l extends f {
    public l(i iVar, d dVar, int i5) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(dVar.f4451a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f4464a = iVar.w(byteBufferAllocate, dVar.f4454d + (i5 * dVar.f4457g) + 28);
    }
}
