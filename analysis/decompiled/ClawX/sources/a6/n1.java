package a6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class n1 extends l1 {

    /* renamed from: e, reason: collision with root package name */
    public final p1 f195e;

    /* renamed from: f, reason: collision with root package name */
    public final o1 f196f;

    /* renamed from: g, reason: collision with root package name */
    public final q f197g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f198h;

    public n1(p1 p1Var, o1 o1Var, q qVar, Object obj) {
        this.f195e = p1Var;
        this.f196f = o1Var;
        this.f197g = qVar;
        this.f198h = obj;
    }

    @Override // a6.l1
    public final boolean k() {
        return false;
    }

    @Override // a6.l1
    public final void l(Throwable th) {
        q qVar = this.f197g;
        q qVarV = p1.V(qVar);
        p1 p1Var = this.f195e;
        o1 o1Var = this.f196f;
        Object obj = this.f198h;
        if (qVarV == null || !p1Var.e0(o1Var, qVarV, obj)) {
            o1Var.f204a.e(new f6.g(2), 2);
            q qVarV2 = p1.V(qVar);
            if (qVarV2 == null || !p1Var.e0(o1Var, qVarV2, obj)) {
                p1Var.q(p1Var.H(o1Var, obj));
            }
        }
    }
}
