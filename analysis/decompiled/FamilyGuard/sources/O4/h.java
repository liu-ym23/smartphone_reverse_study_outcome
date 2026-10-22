package O4;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class h extends d {

    /* renamed from: j, reason: collision with root package name */
    private final i f4466j;

    public h(boolean z5, i iVar) {
        this.f4451a = z5;
        this.f4466j = iVar;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(z5 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f4452b = iVar.o(byteBufferAllocate, 16L);
        this.f4453c = iVar.u(byteBufferAllocate, 32L);
        this.f4454d = iVar.u(byteBufferAllocate, 40L);
        this.f4455e = iVar.o(byteBufferAllocate, 54L);
        this.f4456f = iVar.o(byteBufferAllocate, 56L);
        this.f4457g = iVar.o(byteBufferAllocate, 58L);
        this.f4458h = iVar.o(byteBufferAllocate, 60L);
        this.f4459i = iVar.o(byteBufferAllocate, 62L);
    }

    @Override // O4.d
    public c a(long j5, int i5) {
        return new b(this.f4466j, this, j5, i5);
    }

    @Override // O4.d
    public e b(long j5) {
        return new k(this.f4466j, this, j5);
    }

    @Override // O4.d
    public f c(int i5) {
        return new m(this.f4466j, this, i5);
    }
}
