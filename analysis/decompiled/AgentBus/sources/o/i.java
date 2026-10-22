package o;

import i1.f1;

/* loaded from: classes.dex */
public final class i extends n0.l implements i1.m, f1 {

    /* renamed from: t, reason: collision with root package name */
    public long f7057t;

    /* renamed from: u, reason: collision with root package name */
    public u0.c0 f7058u;

    /* renamed from: v, reason: collision with root package name */
    public long f7059v;

    /* renamed from: w, reason: collision with root package name */
    public d2.l f7060w;

    /* renamed from: x, reason: collision with root package name */
    public u0.w f7061x;

    /* renamed from: y, reason: collision with root package name */
    public u0.c0 f7062y;

    @Override // i1.m
    public final void e(i1.h0 h0Var) {
        i1.h0 h0Var2;
        u0.f fVar;
        i1.h0 h0Var3 = h0Var;
        w0.b bVar = h0Var3.f4489f;
        if (this.f7058u != u0.z.f9929a) {
            q7.v vVar = new q7.v();
            if (t0.e.a(bVar.d(), this.f7059v) && h0Var3.f() == this.f7060w && q7.k.a(this.f7062y, this.f7058u)) {
                u0.w wVar = this.f7061x;
                q7.k.b(wVar);
                vVar.f8820f = wVar;
            } else {
                i1.l.r(this, new eb.k(vVar, this, h0Var3, 2));
            }
            this.f7061x = (u0.w) vVar.f8820f;
            this.f7059v = bVar.d();
            this.f7060w = h0Var3.f();
            this.f7062y = this.f7058u;
            Object obj = vVar.f8820f;
            q7.k.b(obj);
            u0.w wVar2 = (u0.w) obj;
            if (!u0.m.c(this.f7057t, u0.m.f9916f)) {
                long j2 = this.f7057t;
                boolean z4 = wVar2 instanceof u0.u;
                w0.f fVar2 = w0.f.f10635b;
                if (z4) {
                    t0.c cVar = ((u0.u) wVar2).f9925a;
                    float f10 = cVar.f9656a;
                    float f11 = cVar.f9657b;
                    long jFloatToRawIntBits = Float.floatToRawIntBits(f10);
                    float f12 = cVar.f9658c - cVar.f9656a;
                    float f13 = cVar.f9659d - cVar.f9657b;
                    h0Var2 = h0Var;
                    h0Var2.U(j2, (Float.floatToRawIntBits(f11) & 4294967295L) | (jFloatToRawIntBits << 32), (Float.floatToRawIntBits(f12) << 32) | (Float.floatToRawIntBits(f13) & 4294967295L), fVar2, 3);
                } else {
                    h0Var2 = h0Var3;
                    if (wVar2 instanceof u0.v) {
                        u0.v vVar2 = (u0.v) wVar2;
                        fVar = vVar2.f9927b;
                        if (fVar == null) {
                            t0.d dVar = vVar2.f9926a;
                            float fIntBitsToFloat = Float.intBitsToFloat((int) (dVar.f9667h >> 32));
                            float f14 = dVar.f9660a;
                            float f15 = dVar.f9661b;
                            long jFloatToRawIntBits2 = (Float.floatToRawIntBits(f15) & 4294967295L) | (Float.floatToRawIntBits(f14) << 32);
                            float fB = dVar.b();
                            float fA = dVar.a();
                            long jFloatToRawIntBits3 = (Float.floatToRawIntBits(fB) << 32) | (Float.floatToRawIntBits(fA) & 4294967295L);
                            long jFloatToRawIntBits4 = (Float.floatToRawIntBits(fIntBitsToFloat) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
                            int i2 = (int) (jFloatToRawIntBits2 >> 32);
                            int i10 = (int) (jFloatToRawIntBits2 & 4294967295L);
                            bVar.f10629f.f10627c.b(Float.intBitsToFloat(i2), Float.intBitsToFloat(i10), Float.intBitsToFloat((int) (jFloatToRawIntBits3 >> 32)) + Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (jFloatToRawIntBits3 & 4294967295L)) + Float.intBitsToFloat(i10), Float.intBitsToFloat((int) (jFloatToRawIntBits4 >> 32)), Float.intBitsToFloat((int) (jFloatToRawIntBits4 & 4294967295L)), w0.b.a(bVar, j2, fVar2, 3));
                        }
                    } else {
                        if (!(wVar2 instanceof u0.t)) {
                            throw new a4.u();
                        }
                        fVar = ((u0.t) wVar2).f9924a;
                    }
                    h0Var2.e(fVar, j2, fVar2);
                }
            }
            h0Var2.a();
        }
        if (!u0.m.c(this.f7057t, u0.m.f9916f)) {
            w0.d.K(h0Var, this.f7057t, 0L, 126);
            h0Var3 = h0Var;
        }
        h0Var2 = h0Var3;
        h0Var2.a();
    }

    @Override // i1.f1
    public final void v() {
        this.f7059v = 9205357640488583168L;
        this.f7060w = null;
        this.f7061x = null;
        this.f7062y = null;
        i1.l.l(this);
    }
}
