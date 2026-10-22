package ia;

/* loaded from: classes.dex */
public abstract class a extends o1 implements g7.d, b0 {

    /* renamed from: h, reason: collision with root package name */
    public final g7.l f4915h;

    public a(g7.l lVar, boolean z4) {
        super(z4);
        T((g1) lVar.o(z.f5027g));
        this.f4915h = lVar.Q(this);
    }

    @Override // ia.o1
    public final String F() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    @Override // ia.o1
    public final void S(a4.u uVar) {
        d0.n(this.f4915h, uVar);
    }

    @Override // ia.o1
    public final void c0(Object obj) {
        if (!(obj instanceof v)) {
            m0(obj);
        } else {
            v vVar = (v) obj;
            l0(vVar.f5011a, v.f5010b.get(vVar) == 1);
        }
    }

    @Override // g7.d
    public final g7.l getContext() {
        return this.f4915h;
    }

    @Override // ia.b0
    public final g7.l k() {
        return this.f4915h;
    }

    public void l0(Throwable th, boolean z4) {
    }

    public void m0(Object obj) {
    }

    public final void n0(c0 c0Var, a aVar, p7.n nVar) {
        Object objInvoke;
        int iOrdinal = c0Var.ordinal();
        c7.r rVar = c7.r.f1986a;
        if (iOrdinal == 0) {
            try {
                na.b.h(ib.k.C(ib.k.r(aVar, this, nVar)), rVar);
                return;
            } finally {
                th = th;
                if (th instanceof k0) {
                    th = ((k0) th).f4965f;
                }
                resumeWith(w7.e0.n(th));
            }
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                q7.k.e(nVar, "<this>");
                ib.k.C(ib.k.r(aVar, this, nVar)).resumeWith(rVar);
                return;
            }
            if (iOrdinal != 3) {
                throw new a4.u();
            }
            try {
                g7.l lVar = this.f4915h;
                Object objN = na.b.n(lVar, null);
                try {
                    if (nVar instanceof i7.a) {
                        q7.z.c(2, nVar);
                        objInvoke = nVar.invoke(aVar, this);
                    } else {
                        objInvoke = ib.k.X(nVar, aVar, this);
                    }
                    na.b.g(lVar, objN);
                    if (objInvoke != h7.a.f4212f) {
                        resumeWith(objInvoke);
                    }
                } catch (Throwable th) {
                    na.b.g(lVar, objN);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    @Override // g7.d
    public final void resumeWith(Object obj) {
        Throwable thA = c7.m.a(obj);
        if (thA != null) {
            obj = new v(thA, false);
        }
        Object objY = Y(obj);
        if (objY == d0.f4939e) {
            return;
        }
        y(objY);
    }
}
