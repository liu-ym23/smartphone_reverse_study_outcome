package s8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class o2 implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ boolean f11840c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ long f11841f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ String f11842g;

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        boolean z10 = this.f11840c;
        long jC = this.f11841f;
        String str = this.f11842g;
        k0.s sVar = (k0.s) obj;
        int iIntValue = ((Integer) obj2).intValue();
        if (sVar.P(iIntValue & 1, (iIntValue & 3) != 2)) {
            w0.m mVarB = androidx.compose.foundation.layout.c.b(w0.j.f15113c, 1.0f);
            s1.f0 f0VarE = w.p.e(w0.b.i, false);
            int iHashCode = Long.hashCode(sVar.T);
            s0.g gVarL = sVar.l();
            w0.m mVarM = t.o.m(sVar, mVarB);
            u1.j.f13840e.getClass();
            u1.z zVar = u1.i.f13833b;
            sVar.b0();
            if (sVar.S) {
                sVar.k(zVar);
            } else {
                sVar.l0();
            }
            k0.z.B(f0VarE, sVar, u1.i.f13836e);
            k0.z.B(gVarL, sVar, u1.i.f13835d);
            u1.h hVar = u1.i.f13837f;
            if (sVar.S || !yb.k.a(sVar.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar, iHashCode, hVar);
            }
            k0.z.B(mVarM, sVar, u1.i.f13834c);
            d2.l0 l0Var = ((h0.v1) sVar.j(h0.w1.f5235a)).f5220j;
            g2.k kVar = g2.k.f4253h;
            if (!z10) {
                jC = d1.p.c(0.4f, jC);
            }
            h0.t1.b(str, null, jC, 0L, kVar, 0L, null, 0L, 0, false, 0, 0, l0Var, sVar, 196608, 0, 65498);
            sVar.q(true);
        } else {
            sVar.S();
        }
        return jb.v.f6774a;
    }
}
