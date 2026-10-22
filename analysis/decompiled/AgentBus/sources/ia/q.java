package ia;

/* loaded from: classes.dex */
public final class q extends k1 implements p {

    /* renamed from: j, reason: collision with root package name */
    public final o1 f4994j;

    public q(o1 o1Var) {
        this.f4994j = o1Var;
    }

    @Override // ia.p
    public final boolean c(Throwable th) {
        return j().G(th);
    }

    @Override // ia.k1
    public final boolean k() {
        return true;
    }

    @Override // ia.k1
    public final void l(Throwable th) {
        this.f4994j.B(j());
    }
}
