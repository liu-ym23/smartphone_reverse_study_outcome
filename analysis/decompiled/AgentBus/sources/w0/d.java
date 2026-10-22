package w0;

import i1.h0;
import nb.i;
import u0.z;
import u5.h;

/* loaded from: classes.dex */
public interface d extends d2.c {
    static void H(h0 h0Var, long j2, float f10, long j4, int i2) {
        if ((i2 & 4) != 0) {
            j4 = h0Var.f4489f.D();
        }
        b bVar = h0Var.f4489f;
        bVar.f10629f.f10627c.o(f10, j4, b.a(bVar, j2, f.f10635b, 3));
    }

    static /* synthetic */ void K(d dVar, long j2, long j4, int i2) {
        if ((i2 & 4) != 0) {
            j4 = Y(dVar.d(), 0L);
        }
        dVar.U(j2, 0L, j4, f.f10635b, (i2 & 64) != 0 ? 3 : 0);
    }

    static long Y(long j2, long j4) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32)) - Float.intBitsToFloat((int) (j4 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j2 & 4294967295L)) - Float.intBitsToFloat((int) (j4 & 4294967295L));
        return (Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L);
    }

    static /* synthetic */ void s(d dVar, u0.f fVar, z zVar, g gVar, int i2) {
        c cVar = gVar;
        if ((i2 & 8) != 0) {
            cVar = f.f10635b;
        }
        dVar.O(fVar, zVar, 1.0f, cVar, (i2 & 32) != 0 ? 3 : 0);
    }

    static void w(h0 h0Var, z zVar, long j2, long j4, long j10, c cVar, int i2) {
        long j11 = (i2 & 2) != 0 ? 0L : j2;
        long jY = (i2 & 4) != 0 ? Y(h0Var.f4489f.d(), j11) : j4;
        c cVar2 = (i2 & 32) != 0 ? f.f10635b : cVar;
        b bVar = h0Var.f4489f;
        int i10 = (int) (j11 >> 32);
        int i11 = (int) (j11 & 4294967295L);
        bVar.f10629f.f10627c.b(Float.intBitsToFloat(i10), Float.intBitsToFloat(i11), Float.intBitsToFloat((int) (jY >> 32)) + Float.intBitsToFloat(i10), Float.intBitsToFloat((int) (jY & 4294967295L)) + Float.intBitsToFloat(i11), Float.intBitsToFloat((int) (j10 >> 32)), Float.intBitsToFloat((int) (j10 & 4294967295L)), bVar.b(zVar, cVar2, 1.0f, null, 3));
    }

    default long D() {
        return i.r(r().b());
    }

    void L(long j2, long j4, long j10, float f10);

    void O(u0.f fVar, z zVar, float f10, c cVar, int i2);

    void U(long j2, long j4, long j10, c cVar, int i2);

    default long d() {
        return r().b();
    }

    h r();

    void z(long j2, float f10, float f11, long j4, long j10, c cVar);
}
