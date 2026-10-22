package f1;

import d1.f0;
import d1.i;
import d1.l;
import p5.m;
import td.h;
import u1.i0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface d extends o2.c {
    static long P(long j10, long j11) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j10 >> 32)) - Float.intBitsToFloat((int) (j11 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j10 & 4294967295L)) - Float.intBitsToFloat((int) (j11 & 4294967295L));
        return (Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L);
    }

    static void Q(i0 i0Var, f0 f0Var, long j10, long j11, float f5, h hVar, int i) {
        if ((i & 2) != 0) {
            j10 = 0;
        }
        long j12 = j10;
        if ((i & 4) != 0) {
            j11 = P(i0Var.f13838c.e(), j12);
        }
        i0Var.d(f0Var, j12, j11, (i & 8) != 0 ? 1.0f : f5, (i & 16) != 0 ? f.f3864e : hVar);
    }

    static /* synthetic */ void k0(d dVar, long j10, long j11, int i) {
        if ((i & 4) != 0) {
            j11 = P(dVar.e(), 0L);
        }
        dVar.K(j10, 0L, j11, f.f3864e, (i & 64) != 0 ? 3 : 0);
    }

    static void p(i0 i0Var, f0 f0Var, long j10, long j11, long j12, h hVar, int i) {
        if ((i & 2) != 0) {
            j10 = 0;
        }
        long j13 = j10;
        i0Var.f(f0Var, j13, (i & 4) != 0 ? P(i0Var.f13838c.e(), j13) : j11, j12, 1.0f, (i & 32) != 0 ? f.f3864e : hVar);
    }

    static void r(d dVar, d1.e eVar, long j10, long j11, float f5, l lVar, int i, int i3) {
        dVar.G(eVar, 0L, j10, (i3 & 16) != 0 ? j10 : j11, (i3 & 32) != 0 ? 1.0f : f5, lVar, (i3 & 512) != 0 ? 1 : i);
    }

    static /* synthetic */ void s(d dVar, long j10, float f5, long j11, g gVar, int i) {
        if ((i & 4) != 0) {
            j11 = dVar.g0();
        }
        long j12 = j11;
        h hVar = gVar;
        if ((i & 16) != 0) {
            hVar = f.f3864e;
        }
        dVar.O(j10, f5, j12, hVar);
    }

    static /* synthetic */ void x(d dVar, d1.h hVar, f0 f0Var, float f5, g gVar, int i) {
        if ((i & 4) != 0) {
            f5 = 1.0f;
        }
        float f10 = f5;
        h hVar2 = gVar;
        if ((i & 8) != 0) {
            hVar2 = f.f3864e;
        }
        dVar.i0(hVar, f0Var, f10, hVar2, (i & 32) != 0 ? 3 : 0);
    }

    void C(d1.h hVar, long j10, h hVar2);

    void G(d1.e eVar, long j10, long j11, long j12, float f5, l lVar, int i);

    void K(long j10, long j11, long j12, h hVar, int i);

    void O(long j10, float f5, long j11, h hVar);

    m a0();

    default long e() {
        return a0().D();
    }

    default long g0() {
        return a.a.A(a0().D());
    }

    o2.l getLayoutDirection();

    void i0(d1.h hVar, f0 f0Var, float f5, h hVar2, int i);

    void j(long j10, long j11, long j12, float f5, i iVar);

    void n0(long j10, float f5, float f10, long j11, long j12, h hVar);
}
