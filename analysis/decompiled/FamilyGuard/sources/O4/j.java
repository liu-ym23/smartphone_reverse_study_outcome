package O4;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class j extends e {
    public j(i iVar, d dVar, long j5) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(dVar.f4451a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j6 = dVar.f4453c + (j5 * dVar.f4455e);
        this.f4460a = iVar.w(byteBufferAllocate, j6);
        this.f4461b = iVar.w(byteBufferAllocate, 4 + j6);
        this.f4462c = iVar.w(byteBufferAllocate, 8 + j6);
        this.f4463d = iVar.w(byteBufferAllocate, j6 + 20);
    }
}
