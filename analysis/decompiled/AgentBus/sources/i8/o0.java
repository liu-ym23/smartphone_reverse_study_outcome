package i8;

import v9.v0;

/* loaded from: classes.dex */
public final class o0 extends u implements n0 {
    public static final d0 L;
    public final u9.n I;
    public final t9.s J;
    public i K;

    static {
        q7.x xVar = q7.w.f8821a;
        xVar.f(new q7.p(xVar.b(o0.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;"));
        L = new d0();
    }

    public o0(u9.n nVar, t9.s sVar, i iVar, n0 n0Var, g8.j jVar, int i2, f8.n0 n0Var2) {
        super(i2, e9.h.f3204e, sVar, n0Var, n0Var2, jVar);
        this.I = nVar;
        this.J = sVar;
        a8.e eVar = new a8.e(8, this, iVar);
        u9.k kVar = (u9.k) nVar;
        kVar.getClass();
        new u9.h(kVar, eVar);
        this.K = iVar;
    }

    @Override // f8.i
    public final boolean G() {
        return this.K.I;
    }

    @Override // f8.i
    public final f8.e H() {
        f8.e eVarH = this.K.H();
        q7.k.d(eVarH, "underlyingConstructorDescriptor.constructedClass");
        return eVarH;
    }

    @Override // i8.u
    public final u I0(int i2, e9.f fVar, f8.j jVar, f8.t tVar, f8.n0 n0Var, g8.j jVar2) {
        q7.k.e(jVar, "newOwner");
        m.x.t(i2, "kind");
        q7.k.e(jVar2, "annotations");
        if (i2 != 1) {
        }
        return new o0(this.I, this.J, this.K, this, jVar2, 1, n0Var);
    }

    @Override // i8.u, i8.n, i8.m, f8.j
    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    public final n0 a() {
        f8.t tVarA = super.a();
        q7.k.c(tVarA, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (n0) tVarA;
    }

    @Override // i8.u, f8.t, f8.p0
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public final o0 d(v0 v0Var) {
        q7.k.e(v0Var, "substitutor");
        f8.t tVarD = super.d(v0Var);
        q7.k.c(tVarD, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
        o0 o0Var = (o0) tVarD;
        v9.v vVar = o0Var.f4875l;
        q7.k.b(vVar);
        i iVarD = this.K.F0().d(v0.d(vVar));
        if (iVarD == null) {
            return null;
        }
        o0Var.K = iVarD;
        return o0Var;
    }

    @Override // i8.u, f8.c
    public final f8.c Y(f8.e eVar, int i2, f8.n nVar) {
        q7.k.e(eVar, "newOwner");
        m.x.t(i2, "modality");
        q7.k.e(nVar, "visibility");
        m.x.t(2, "kind");
        t tVarM0 = M0(v0.f10595b);
        tVarM0.f4853g = eVar;
        tVarM0.f4854h = i2;
        tVarM0.f4855i = nVar;
        tVarM0.f4857k = 2;
        tVarM0.f4864r = false;
        f8.k kVarJ0 = tVarM0.C.J0(tVarM0);
        q7.k.c(kVarJ0, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (n0) kVarJ0;
    }

    @Override // i8.u, f8.b
    public final v9.v f() {
        v9.v vVar = this.f4875l;
        q7.k.b(vVar);
        return vVar;
    }

    @Override // i8.n, f8.j
    public final f8.h p() {
        return this.J;
    }

    @Override // i8.n, f8.j
    public final f8.j p() {
        return this.J;
    }
}
