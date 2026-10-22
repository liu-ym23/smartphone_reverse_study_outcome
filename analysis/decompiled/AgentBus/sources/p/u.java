package p;

/* loaded from: classes.dex */
public final class u extends q7.m implements p7.n {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f8184g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ s0 f8185h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u(s0 s0Var, int i2) {
        super(2);
        this.f8184g = i2;
        this.f8185h = s0Var;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f8184g) {
            case 0:
                c1.l lVar = (c1.l) obj;
                long j2 = ((t0.b) obj2).f9654a;
                s0 s0Var = this.f8185h;
                if (((Boolean) s0Var.f8178w.invoke(lVar)).booleanValue()) {
                    if (!s0Var.B) {
                        if (s0Var.f8181z == null) {
                            s0Var.f8181z = a.a.b(Integer.MAX_VALUE, 6, null);
                        }
                        s0Var.B = true;
                        ia.d0.s(s0Var.Z(), null, null, new z(s0Var, null), 3);
                    }
                    long j4 = lVar.f1806c;
                    long jF = t0.b.f(j4, n7.b.b(t0.b.d(j2) * Math.signum(t0.b.d(j4)), t0.b.e(j2) * Math.signum(t0.b.e(j4))));
                    ka.g gVar = s0Var.f8181z;
                    if (gVar != null) {
                        gVar.u(new o(jF));
                    }
                }
                return c7.r.f1986a;
            default:
                float fFloatValue = ((Number) obj).floatValue();
                float fFloatValue2 = ((Number) obj2).floatValue();
                s0 s0Var2 = this.f8185h;
                ia.d0.s(s0Var2.Z(), null, null, new r0(s0Var2, fFloatValue, fFloatValue2, null), 3);
                return Boolean.TRUE;
        }
    }
}
