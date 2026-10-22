package O4;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class g extends d {

    /* renamed from: j, reason: collision with root package name */
    private final i f4465j;

    public g(boolean z5, i iVar) {
        this.f4451a = z5;
        this.f4465j = iVar;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(z5 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f4452b = iVar.o(byteBufferAllocate, 16L);
        this.f4453c = iVar.w(byteBufferAllocate, 28L);
        this.f4454d = iVar.w(byteBufferAllocate, 32L);
        this.f4455e = iVar.o(byteBufferAllocate, 42L);
        this.f4456f = iVar.o(byteBufferAllocate, 44L);
        this.f4457g = iVar.o(byteBufferAllocate, 46L);
        this.f4458h = iVar.o(byteBufferAllocate, 48L);
        this.f4459i = iVar.o(byteBufferAllocate, 50L);
    }

    @Override // O4.d
    public c a(long j5, int i5) {
        return new a(this.f4465j, this, j5, i5);
    }

    @Override // O4.d
    public e b(long j5) {
        return new j(this.f4465j, this, j5);
    }

    @Override // O4.d
    public f c(int i5) {
        return new l(this.f4465j, this, i5);
    }
}
