package a6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class a extends p1 implements f5.c, f0 {

    /* renamed from: c, reason: collision with root package name */
    public final f5.h f128c;

    public a(f5.h hVar, boolean z) {
        super(z);
        O((h1) hVar.o(c0.f143b));
        this.f128c = hVar.t(this);
    }

    @Override // a6.p1
    public final String D() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    @Override // a6.p1
    public final void N(w wVar) {
        i0.n(this.f128c, wVar);
    }

    @Override // a6.p1
    public final void X(Object obj) {
        if (!(obj instanceof v)) {
            g0(obj);
        } else {
            v vVar = (v) obj;
            f0(vVar.f222a, v.f221b.get(vVar) == 1);
        }
    }

    @Override // a6.f0
    public final f5.h b() {
        return this.f128c;
    }

    @Override // f5.c
    public final f5.h getContext() {
        return this.f128c;
    }

    public final void h0(g0 g0Var, a aVar, p5.p pVar) {
        Object objInvoke;
        int iOrdinal = g0Var.ordinal();
        b5.a0 a0Var = b5.a0.f883a;
        if (iOrdinal == 0) {
            try {
                f6.a.h(b8.h.u(b8.h.k(aVar, this, pVar)), a0Var);
                return;
            } catch (Throwable th) {
                a.a.D(this, th);
                throw null;
            }
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                kotlin.jvm.internal.p.e(pVar, "<this>");
                b8.h.u(b8.h.k(aVar, this, pVar)).resumeWith(a0Var);
                return;
            }
            if (iOrdinal != 3) {
                throw new w();
            }
            try {
                f5.h hVar = this.f128c;
                Object objN = f6.a.n(hVar, null);
                try {
                    if (pVar instanceof h5.a) {
                        kotlin.jvm.internal.d0.a(2, pVar);
                        objInvoke = pVar.invoke(aVar, this);
                    } else {
                        objInvoke = b8.h.R(pVar, aVar, this);
                    }
                    f6.a.g(hVar, objN);
                    if (objInvoke != g5.a.f2984a) {
                        resumeWith(objInvoke);
                    }
                } catch (Throwable th2) {
                    f6.a.g(hVar, objN);
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                if (th instanceof o0) {
                    th = ((o0) th).f201a;
                }
                resumeWith(a.a.o(th));
            }
        }
    }

    @Override // f5.c
    public final void resumeWith(Object obj) {
        Throwable thA = b5.i.a(obj);
        if (thA != null) {
            obj = new v(thA, false);
        }
        Object objT = T(obj);
        if (objT == i0.f175e) {
            return;
        }
        r(objT);
    }

    public void g0(Object obj) {
    }

    public void f0(Throwable th, boolean z) {
    }
}
