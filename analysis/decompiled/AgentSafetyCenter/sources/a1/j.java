package a1;

import com.google.crypto.tink.shaded.protobuf.Reader;
import kb.t;
import s1.e0;
import s1.g0;
import s1.v0;
import u1.i0;
import u1.n;
import u1.o0;
import u1.w;
import w0.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j extends l implements w, n {

    /* renamed from: s, reason: collision with root package name */
    public h1.b f23s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f24t;

    /* renamed from: u, reason: collision with root package name */
    public w0.e f25u;

    /* renamed from: v, reason: collision with root package name */
    public s1.j f26v;

    /* renamed from: w, reason: collision with root package name */
    public float f27w;

    /* renamed from: x, reason: collision with root package name */
    public d1.l f28x;

    public static boolean B0(long j10) {
        return !c1.e.b(j10, 9205357640488583168L) && (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j10 & 4294967295L))) & Reader.READ_DONE) < 2139095040;
    }

    public static boolean C0(long j10) {
        return !c1.e.b(j10, 9205357640488583168L) && (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j10 >> 32))) & Reader.READ_DONE) < 2139095040;
    }

    @Override // u1.n
    public final void b(i0 i0Var) {
        f1.b bVar = i0Var.f13838c;
        long jH = this.f23s.h();
        long jFloatToRawIntBits = (Float.floatToRawIntBits(C0(jH) ? Float.intBitsToFloat((int) (jH >> 32)) : Float.intBitsToFloat((int) (bVar.e() >> 32))) << 32) | (Float.floatToRawIntBits(B0(jH) ? Float.intBitsToFloat((int) (jH & 4294967295L)) : Float.intBitsToFloat((int) (bVar.e() & 4294967295L))) & 4294967295L);
        long jL = (Float.intBitsToFloat((int) (bVar.e() >> 32)) == 0.0f || Float.intBitsToFloat((int) (bVar.e() & 4294967295L)) == 0.0f) ? 0L : v0.l(jFloatToRawIntBits, this.f26v.a(jFloatToRawIntBits, bVar.e()));
        long jA = this.f25u.a((Math.round(Float.intBitsToFloat((int) (jL >> 32))) << 32) | (Math.round(Float.intBitsToFloat((int) (jL & 4294967295L))) & 4294967295L), (Math.round(Float.intBitsToFloat((int) (bVar.e() >> 32))) << 32) | (Math.round(Float.intBitsToFloat((int) (bVar.e() & 4294967295L))) & 4294967295L), i0Var.getLayoutDirection());
        float f5 = (int) (jA >> 32);
        float f10 = (int) (jA & 4294967295L);
        ((g) bVar.f3859f.f9741f).z(f5, f10);
        try {
            this.f23s.g(i0Var, jL, this.f27w, this.f28x);
            ((g) bVar.f3859f.f9741f).z(-f5, -f10);
            i0Var.b();
        } catch (Throwable th) {
            ((g) bVar.f3859f.f9741f).z(-f5, -f10);
            throw th;
        }
    }

    @Override // u1.w
    public final g0 f(o0 o0Var, e0 e0Var, long j10) {
        long jB;
        boolean z10 = false;
        boolean z11 = o2.a.e(j10) && o2.a.d(j10);
        if (o2.a.g(j10) && o2.a.f(j10)) {
            z10 = true;
        }
        if (((!this.f24t || this.f23s.h() == 9205357640488583168L) && z11) || z10) {
            jB = o2.a.b(j10, o2.a.i(j10), 0, o2.a.h(j10), 0, 10);
        } else {
            long jH = this.f23s.h();
            int iRound = C0(jH) ? Math.round(Float.intBitsToFloat((int) (jH >> 32))) : o2.a.k(j10);
            int iRound2 = B0(jH) ? Math.round(Float.intBitsToFloat((int) (jH & 4294967295L))) : o2.a.j(j10);
            long jFloatToRawIntBits = (Float.floatToRawIntBits(o2.b.f(iRound, j10)) << 32) | (Float.floatToRawIntBits(o2.b.e(iRound2, j10)) & 4294967295L);
            if (this.f24t && this.f23s.h() != 9205357640488583168L) {
                float fIntBitsToFloat = !C0(this.f23s.h()) ? Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32)) : Float.intBitsToFloat((int) (this.f23s.h() >> 32));
                float fIntBitsToFloat2 = !B0(this.f23s.h()) ? Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L)) : Float.intBitsToFloat((int) (this.f23s.h() & 4294967295L));
                long jFloatToRawIntBits2 = (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
                jFloatToRawIntBits = (Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32)) == 0.0f || Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L)) == 0.0f) ? 0L : v0.l(jFloatToRawIntBits2, this.f26v.a(jFloatToRawIntBits2, jFloatToRawIntBits));
            }
            jB = o2.a.b(j10, o2.b.f(Math.round(Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32))), j10), 0, o2.b.e(Math.round(Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L))), j10), 0, 10);
        }
        s1.o0 o0VarQ = e0Var.q(jB);
        return o0Var.Y(o0VarQ.f11277c, o0VarQ.f11278f, t.f7405c, new i(o0VarQ, 0));
    }

    @Override // w0.l
    public final boolean q0() {
        return false;
    }

    public final String toString() {
        return "PainterModifier(painter=" + this.f23s + ", sizeToIntrinsics=" + this.f24t + ", alignment=" + this.f25u + ", alpha=" + this.f27w + ", colorFilter=" + this.f28x + ')';
    }
}
