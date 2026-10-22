package fc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes5.dex */
public class h extends d {

    /* renamed from: j, reason: collision with root package name */
    public final i f32653j;

    public h(boolean z10, i iVar) {
        this.f32638a = z10;
        this.f32653j = iVar;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(z10 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f32639b = iVar.l(byteBufferAllocate, 16L);
        this.f32640c = iVar.n(byteBufferAllocate, 32L);
        this.f32641d = iVar.n(byteBufferAllocate, 40L);
        this.f32642e = iVar.l(byteBufferAllocate, 54L);
        this.f32643f = iVar.l(byteBufferAllocate, 56L);
        this.f32644g = iVar.l(byteBufferAllocate, 58L);
        this.f32645h = iVar.l(byteBufferAllocate, 60L);
        this.f32646i = iVar.l(byteBufferAllocate, 62L);
    }

    @Override // fc.d
    public c a(long j10, int i10) {
        return new b(this.f32653j, this, j10, i10);
    }

    @Override // fc.d
    public e b(long j10) {
        return new k(this.f32653j, this, j10);
    }

    @Override // fc.d
    public f c(int i10) {
        return new m(this.f32653j, this, i10);
    }
}
