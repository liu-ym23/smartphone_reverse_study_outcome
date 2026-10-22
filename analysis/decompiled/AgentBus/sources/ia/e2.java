package ia;

/* loaded from: classes.dex */
public final class e2 extends na.r {

    /* renamed from: j, reason: collision with root package name */
    public final ThreadLocal f4953j;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    public e2(g7.d dVar, g7.l lVar) {
        f2 f2Var = f2.f4957f;
        super(dVar, lVar.o(f2Var) == null ? lVar.Q(f2Var) : lVar);
        this.f4953j = new ThreadLocal();
        if (dVar.getContext().o(g7.f.f3865f) instanceof x) {
            return;
        }
        Object objN = na.b.n(lVar, null);
        na.b.g(lVar, objN);
        r0(lVar, objN);
    }

    @Override // na.r
    public final void o0() {
        q0();
    }

    public final boolean p0() {
        boolean z4 = this.threadLocalIsSet && this.f4953j.get() == null;
        this.f4953j.remove();
        return !z4;
    }

    public final void q0() {
        if (this.threadLocalIsSet) {
            c7.j jVar = (c7.j) this.f4953j.get();
            if (jVar != null) {
                na.b.g((g7.l) jVar.f1973f, jVar.f1974g);
            }
            this.f4953j.remove();
        }
    }

    public final void r0(g7.l lVar, Object obj) {
        this.threadLocalIsSet = true;
        this.f4953j.set(new c7.j(lVar, obj));
    }

    @Override // na.r, ia.o1
    public final void y(Object obj) {
        q0();
        Object objU = d0.u(obj);
        g7.d dVar = this.f6925i;
        g7.l context = dVar.getContext();
        Object objN = na.b.n(context, null);
        e2 e2VarA = objN != na.b.f6890d ? d0.A(dVar, context, objN) : null;
        try {
            dVar.resumeWith(objU);
            if (e2VarA == null || e2VarA.p0()) {
                na.b.g(context, objN);
            }
        } catch (Throwable th) {
            if (e2VarA == null || e2VarA.p0()) {
                na.b.g(context, objN);
            }
            throw th;
        }
    }
}
