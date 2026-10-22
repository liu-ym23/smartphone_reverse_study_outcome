package h0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o1 extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w0.m f5093c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ d1.j0 f5094f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f5095g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ float f5096h;
    public final /* synthetic */ float i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ s0.c f5097j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o1(w0.m mVar, d1.j0 j0Var, long j10, float f5, td.h hVar, float f10, s0.c cVar) {
        super(2);
        this.f5093c = mVar;
        this.f5094f = j0Var;
        this.f5095g = j10;
        this.f5096h = f5;
        this.i = f10;
        this.f5097j = cVar;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        k0.s sVar = (k0.s) obj;
        int iIntValue = ((Number) obj2).intValue() & 3;
        jb.v vVar = jb.v.f6774a;
        if (iIntValue == 2 && sVar.B()) {
            sVar.S();
            return vVar;
        }
        w0.m mVarA = o1.d0.a(a2.l.a(q1.c(this.f5093c, this.f5094f, q1.d(this.f5095g, this.f5096h, sVar), null, ((o2.c) sVar.j(v1.a1.f14363h)).X(this.i)), false, r.f5121h), vVar, new n1(2, null, 0));
        s1.f0 f0VarE = w.p.e(w0.b.f15089c, true);
        int iHashCode = Long.hashCode(sVar.T);
        s0.g gVarL = sVar.l();
        w0.m mVarM = t.o.m(sVar, mVarA);
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
        this.f5097j.invoke(sVar, 0);
        sVar.q(true);
        return vVar;
    }
}
