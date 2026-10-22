package fc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes5.dex */
public class g extends d {

    /* renamed from: j, reason: collision with root package name */
    public final i f32652j;

    public g(boolean z10, i iVar) {
        this.f32638a = z10;
        this.f32652j = iVar;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(z10 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f32639b = iVar.l(byteBufferAllocate, 16L);
        this.f32640c = iVar.G(byteBufferAllocate, 28L);
        this.f32641d = iVar.G(byteBufferAllocate, 32L);
        this.f32642e = iVar.l(byteBufferAllocate, 42L);
        this.f32643f = iVar.l(byteBufferAllocate, 44L);
        this.f32644g = iVar.l(byteBufferAllocate, 46L);
        this.f32645h = iVar.l(byteBufferAllocate, 48L);
        this.f32646i = iVar.l(byteBufferAllocate, 50L);
    }

    @Override // fc.d
    public c a(long j10, int i10) {
        return new C4085a(this.f32652j, this, j10, i10);
    }

    @Override // fc.d
    public e b(long j10) {
        return new j(this.f32652j, this, j10);
    }

    @Override // fc.d
    public f c(int i10) {
        return new l(this.f32652j, this, i10);
    }
}
