package cf6;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes20.dex */
public final class g extends d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i f23525g;

    @Override // cf6.d
    public final f c() throws IOException {
        return new l(this.f23525g, this);
    }

    @Override // cf6.d
    public final e b(long r100) throws IOException {
        return new j(this.f23525g, this, r100);
    }

    public g(boolean r100, i r101) throws IOException {
        this.f23514a = r100;
        this.f23525g = r101;
        ByteBuffer r102 = ByteBuffer.allocate(4);
        if (r100 == false) goto L5;
        ByteOrder r103 = ByteOrder.BIG_ENDIAN;
    L6:
        r102.order(r103);
        r101.c(r102, 16);
        this.f23515b = r101.d(r102, 28);
        this.f23516c = r101.d(r102, 32);
        this.f23517d = r101.c(r102, 42);
        this.f23518e = r101.c(r102, 44);
        this.f23519f = r101.c(r102, 46);
        r101.c(r102, 48);
        r101.c(r102, 50);
        return;
    L5:
        r103 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }

    @Override // cf6.d
    public final c a(long r100, int r110) throws IOException {
        return new a(this.f23525g, this, r100, r110);
    }
}
