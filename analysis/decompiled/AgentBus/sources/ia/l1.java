package ia;

/* loaded from: classes.dex */
public final class l1 extends m {

    /* renamed from: n, reason: collision with root package name */
    public final o1 f4970n;

    public l1(g7.d dVar, o1 o1Var) {
        super(1, dVar);
        this.f4970n = o1Var;
    }

    @Override // ia.m
    public final String A() {
        return "AwaitContinuation";
    }

    @Override // ia.m
    public final Throwable q(o1 o1Var) {
        Throwable thC;
        o1 o1Var2 = this.f4970n;
        o1Var2.getClass();
        Object obj = o1.f4991f.get(o1Var2);
        return (!(obj instanceof n1) || (thC = ((n1) obj).c()) == null) ? obj instanceof v ? ((v) obj).f5011a : o1Var.E() : thC;
    }
}
