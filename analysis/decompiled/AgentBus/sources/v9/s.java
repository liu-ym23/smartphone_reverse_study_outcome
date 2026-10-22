package v9;

/* loaded from: classes.dex */
public final class s extends s0 {

    /* renamed from: b, reason: collision with root package name */
    public final f8.q0[] f10586b;

    /* renamed from: c, reason: collision with root package name */
    public final p0[] f10587c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f10588d;

    public s(f8.q0[] q0VarArr, p0[] p0VarArr, boolean z4) {
        q7.k.e(q0VarArr, "parameters");
        q7.k.e(p0VarArr, "arguments");
        this.f10586b = q0VarArr;
        this.f10587c = p0VarArr;
        this.f10588d = z4;
    }

    @Override // v9.s0
    public final boolean b() {
        return this.f10588d;
    }

    @Override // v9.s0
    public final p0 d(v vVar) {
        f8.g gVarC = vVar.E0().c();
        f8.q0 q0Var = gVarC instanceof f8.q0 ? (f8.q0) gVarC : null;
        if (q0Var != null) {
            int index = q0Var.getIndex();
            f8.q0[] q0VarArr = this.f10586b;
            if (index < q0VarArr.length && q7.k.a(q0VarArr[index].h(), q0Var.h())) {
                return this.f10587c[index];
            }
        }
        return null;
    }

    @Override // v9.s0
    public final boolean e() {
        return this.f10587c.length == 0;
    }
}
