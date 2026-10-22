package h0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4972c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ s0.c f4973f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(s0.c cVar, int i, int i3) {
        super(2);
        this.f4972c = i3;
        switch (i3) {
            case 2:
                this.f4973f = cVar;
                super(2);
                break;
            default:
                float f5 = m.f5059a;
                float f10 = m.f5059a;
                this.f4973f = cVar;
                break;
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        int i = this.f4972c;
        jb.v vVar = jb.v.f6774a;
        s0.c cVar = this.f4973f;
        switch (i) {
            case 0:
                ((Number) obj2).intValue();
                float f5 = m.f5059a;
                float f10 = m.f5059a;
                m.b(cVar, (k0.s) obj, k0.z.D(439));
                break;
            case 1:
                k0.s sVar = (k0.s) obj;
                if ((((Number) obj2).intValue() & 3) != 2 || !sVar.B()) {
                    w.v vVarA = w.u.a(w.k.f14992c, w0.b.f15100q, sVar, 0);
                    int iR = k0.z.r(sVar);
                    s0.g gVarL = sVar.l();
                    w0.m mVarM = t.o.m(sVar, w0.j.f15113c);
                    u1.j.f13840e.getClass();
                    u1.z zVar = u1.i.f13833b;
                    sVar.b0();
                    if (sVar.S) {
                        sVar.k(zVar);
                    } else {
                        sVar.l0();
                    }
                    k0.z.B(vVarA, sVar, u1.i.f13836e);
                    k0.z.B(gVarL, sVar, u1.i.f13835d);
                    u1.h hVar = u1.i.f13837f;
                    if (sVar.S || !yb.k.a(sVar.M(), Integer.valueOf(iR))) {
                        k0.a.y(iR, sVar, iR, hVar);
                    }
                    k0.z.B(mVarM, sVar, u1.i.f13834c);
                    cVar.invoke(w.w.f15059a, sVar, 6);
                    sVar.q(true);
                    break;
                } else {
                    sVar.S();
                    break;
                }
                break;
            default:
                ((Number) obj2).intValue();
                t.i1.a(cVar, (k0.s) obj, k0.z.D(7));
                break;
        }
        return vVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(s0.c cVar) {
        super(2);
        this.f4972c = 1;
        this.f4973f = cVar;
    }
}
