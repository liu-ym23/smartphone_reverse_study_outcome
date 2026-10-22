package a6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e2 extends f6.p {

    /* renamed from: e, reason: collision with root package name */
    public final ThreadLocal f155e;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    public e2(f5.c cVar, f5.h hVar) {
        f2 f2Var = f2.f160a;
        super(cVar, hVar.o(f2Var) == null ? hVar.t(f2Var) : hVar);
        this.f155e = new ThreadLocal();
        if (cVar.getContext().o(f5.d.f2625a) instanceof b0) {
            return;
        }
        Object objN = f6.a.n(hVar, null);
        f6.a.g(hVar, objN);
        l0(hVar, objN);
    }

    @Override // f6.p
    public final void i0() {
        k0();
    }

    public final boolean j0() {
        boolean z = this.threadLocalIsSet && this.f155e.get() == null;
        this.f155e.remove();
        return !z;
    }

    public final void k0() {
        if (this.threadLocalIsSet) {
            b5.g gVar = (b5.g) this.f155e.get();
            if (gVar != null) {
                f6.a.g((f5.h) gVar.f892a, gVar.f893b);
            }
            this.f155e.remove();
        }
    }

    public final void l0(f5.h hVar, Object obj) {
        this.threadLocalIsSet = true;
        this.f155e.set(new b5.g(hVar, obj));
    }

    @Override // f6.p, a6.p1
    public final void r(Object obj) {
        k0();
        Object objS = i0.s(obj);
        f5.c cVar = this.d;
        f5.h context = cVar.getContext();
        Object objN = f6.a.n(context, null);
        e2 e2VarZ = objN != f6.a.d ? i0.z(cVar, context, objN) : null;
        try {
            cVar.resumeWith(objS);
            if (e2VarZ == null || e2VarZ.j0()) {
                f6.a.g(context, objN);
            }
        } catch (Throwable th) {
            if (e2VarZ == null || e2VarZ.j0()) {
                f6.a.g(context, objN);
            }
            throw th;
        }
    }
}
