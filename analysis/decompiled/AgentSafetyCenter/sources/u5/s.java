package u5;

import s1.t0;
import s1.v0;
import u1.i0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s extends w0.l implements u1.n, u1.w {

    /* renamed from: s, reason: collision with root package name */
    public l f14091s;

    /* renamed from: t, reason: collision with root package name */
    public w0.e f14092t;

    /* renamed from: u, reason: collision with root package name */
    public s1.j f14093u;

    /* renamed from: v, reason: collision with root package name */
    public float f14094v;

    public final long B0(long j10) {
        if (c1.e.f(j10)) {
            return 0L;
        }
        long jH = this.f14091s.h();
        if (jH != 9205357640488583168L) {
            float fE = c1.e.e(jH);
            if (Float.isInfinite(fE) || Float.isNaN(fE)) {
                fE = c1.e.e(j10);
            }
            float fC = c1.e.c(jH);
            if (Float.isInfinite(fC) || Float.isNaN(fC)) {
                fC = c1.e.c(j10);
            }
            long jE = a.a.e(fE, fC);
            long jA = this.f14093u.a(jE, j10);
            int i = t0.f11298a;
            float fIntBitsToFloat = Float.intBitsToFloat((int) (jA >> 32));
            if (!Float.isInfinite(fIntBitsToFloat) && !Float.isNaN(fIntBitsToFloat)) {
                float fIntBitsToFloat2 = Float.intBitsToFloat((int) (4294967295L & jA));
                if (!Float.isInfinite(fIntBitsToFloat2) && !Float.isNaN(fIntBitsToFloat2)) {
                    return v0.l(jE, jA);
                }
            }
        }
        return j10;
    }

    @Override // u1.n
    public final void b(i0 i0Var) {
        f1.b bVar = i0Var.f13838c;
        long jB0 = B0(bVar.e());
        w0.e eVar = this.f14092t;
        f6.e eVar2 = w.f14106b;
        long jB = ac.a.b(ac.a.Q(c1.e.e(jB0)), ac.a.Q(c1.e.c(jB0)));
        long jE = bVar.e();
        long jA = eVar.a(jB, ac.a.b(ac.a.Q(c1.e.e(jE)), ac.a.Q(c1.e.c(jE))), i0Var.getLayoutDirection());
        float f5 = (int) (jA >> 32);
        float f10 = (int) (jA & 4294967295L);
        ((a1.g) bVar.f3859f.f9741f).z(f5, f10);
        this.f14091s.g(i0Var, jB0, this.f14094v, null);
        ((a1.g) bVar.f3859f.f9741f).z(-f5, -f10);
        i0Var.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    @Override // u1.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final s1.g0 f(u1.o0 r11, s1.e0 r12, long r13) {
        /*
            r10 = this;
            boolean r1 = o2.a.g(r13)
            boolean r2 = o2.a.f(r13)
            r7 = 1
            if (r1 == 0) goto Le
            if (r2 == 0) goto Le
            goto L41
        Le:
            boolean r3 = o2.a.e(r13)
            if (r3 == 0) goto L1c
            boolean r3 = o2.a.d(r13)
            if (r3 == 0) goto L1c
            r3 = r7
            goto L1d
        L1c:
            r3 = 0
        L1d:
            u5.l r4 = r10.f14091s
            long r4 = r4.h()
            r8 = 9205357640488583168(0x7fc000007fc00000, double:2.247117487993712E307)
            int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r6 != 0) goto L44
            if (r3 == 0) goto L41
            int r2 = o2.a.i(r13)
            int r4 = o2.a.h(r13)
            r5 = 0
            r6 = 10
            r3 = 0
            r0 = r13
            long r0 = o2.a.b(r0, r2, r3, r4, r5, r6)
            goto Lca
        L41:
            r0 = r13
            goto Lca
        L44:
            if (r3 == 0) goto L55
            if (r1 != 0) goto L4a
            if (r2 == 0) goto L55
        L4a:
            int r1 = o2.a.i(r13)
            float r1 = (float) r1
            int r2 = o2.a.h(r13)
        L53:
            float r2 = (float) r2
            goto La1
        L55:
            float r1 = c1.e.e(r4)
            float r2 = c1.e.c(r4)
            boolean r3 = java.lang.Float.isInfinite(r1)
            if (r3 != 0) goto L7a
            boolean r3 = java.lang.Float.isNaN(r1)
            if (r3 != 0) goto L7a
            f6.e r3 = u5.w.f14106b
            int r3 = o2.a.k(r13)
            float r3 = (float) r3
            int r4 = o2.a.i(r13)
            float r4 = (float) r4
            float r1 = p5.f.p(r1, r3, r4)
            goto L7f
        L7a:
            int r1 = o2.a.k(r13)
            float r1 = (float) r1
        L7f:
            boolean r3 = java.lang.Float.isInfinite(r2)
            if (r3 != 0) goto L9c
            boolean r3 = java.lang.Float.isNaN(r2)
            if (r3 != 0) goto L9c
            f6.e r3 = u5.w.f14106b
            int r3 = o2.a.j(r13)
            float r3 = (float) r3
            int r4 = o2.a.h(r13)
            float r4 = (float) r4
            float r2 = p5.f.p(r2, r3, r4)
            goto La1
        L9c:
            int r2 = o2.a.j(r13)
            goto L53
        La1:
            long r1 = a.a.e(r1, r2)
            long r0 = r10.B0(r1)
            float r2 = c1.e.e(r0)
            float r0 = c1.e.c(r0)
            int r1 = ac.a.Q(r2)
            int r2 = o2.b.f(r1, r13)
            int r0 = ac.a.Q(r0)
            int r4 = o2.b.e(r0, r13)
            r5 = 0
            r6 = 10
            r3 = 0
            r0 = r13
            long r0 = o2.a.b(r0, r2, r3, r4, r5, r6)
        Lca:
            s1.o0 r0 = r12.q(r0)
            int r1 = r0.f11277c
            int r2 = r0.f11278f
            u5.p r3 = new u5.p
            r3.<init>(r7)
            r3.f14086f = r0
            java.lang.invoke.VarHandle.storeStoreFence()
            kb.t r0 = kb.t.f7405c
            s1.g0 r0 = r11.Y(r1, r2, r0, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: u5.s.f(u1.o0, s1.e0, long):s1.g0");
    }

    @Override // w0.l
    public final boolean q0() {
        return false;
    }
}
