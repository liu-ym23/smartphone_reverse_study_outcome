package ia;

/* loaded from: classes.dex */
public final class m1 extends k1 {

    /* renamed from: j, reason: collision with root package name */
    public final o1 f4977j;

    /* renamed from: k, reason: collision with root package name */
    public final n1 f4978k;

    /* renamed from: l, reason: collision with root package name */
    public final q f4979l;

    /* renamed from: m, reason: collision with root package name */
    public final Object f4980m;

    public m1(o1 o1Var, n1 n1Var, q qVar, Object obj) {
        this.f4977j = o1Var;
        this.f4978k = n1Var;
        this.f4979l = qVar;
        this.f4980m = obj;
    }

    @Override // ia.k1
    public final boolean k() {
        return false;
    }

    @Override // ia.k1
    public final void l(Throwable th) {
        q qVar = this.f4979l;
        q qVarA0 = o1.a0(qVar);
        o1 o1Var = this.f4977j;
        n1 n1Var = this.f4978k;
        Object obj = this.f4980m;
        if (qVarA0 == null || !o1Var.k0(n1Var, qVarA0, obj)) {
            n1Var.f4987f.e(new na.i(2), 2);
            q qVarA02 = o1.a0(qVar);
            if (qVarA02 == null || !o1Var.k0(n1Var, qVarA02, obj)) {
                o1Var.w(o1Var.L(n1Var, obj));
            }
        }
    }
}
