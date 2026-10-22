package t9;

import f8.l0;
import f8.n0;
import i8.i0;
import m.x;
import z8.f0;

/* loaded from: classes.dex */
public final class q extends i0 implements b {
    public final f0 F;
    public final b9.f G;
    public final b9.g H;
    public final b9.h I;
    public final j J;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(f8.j jVar, l0 l0Var, g8.j jVar2, int i2, f8.n nVar, boolean z4, e9.f fVar, int i10, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, f0 f0Var, b9.f fVar2, b9.g gVar, b9.h hVar, j jVar3) {
        super(jVar, l0Var, jVar2, i2, nVar, z4, fVar, i10, n0.f3487b, z10, z11, z14, z12, z13);
        q7.k.e(jVar, "containingDeclaration");
        q7.k.e(jVar2, "annotations");
        x.t(i2, "modality");
        q7.k.e(nVar, "visibility");
        q7.k.e(fVar, "name");
        x.t(i10, "kind");
        q7.k.e(f0Var, "proto");
        q7.k.e(fVar2, "nameResolver");
        q7.k.e(gVar, "typeTable");
        q7.k.e(hVar, "versionRequirementTable");
        this.F = f0Var;
        this.G = fVar2;
        this.H = gVar;
        this.I = hVar;
        this.J = jVar3;
    }

    @Override // i8.i0
    public final i0 I0(f8.j jVar, int i2, f8.n nVar, l0 l0Var, int i10, e9.f fVar) {
        q7.k.e(jVar, "newOwner");
        x.t(i2, "newModality");
        q7.k.e(nVar, "newVisibility");
        x.t(i10, "kind");
        q7.k.e(fVar, "newName");
        return new q(jVar, l0Var, getAnnotations(), i2, nVar, this.f4795k, fVar, i10, this.f4803s, this.f4804t, w(), this.f4807w, this.f4805u, this.F, this.G, this.H, this.I, this.J);
    }

    @Override // t9.k
    public final f9.a L() {
        return this.F;
    }

    @Override // t9.k
    public final b9.g m0() {
        return this.H;
    }

    @Override // t9.k
    public final j u() {
        return this.J;
    }

    @Override // i8.i0, f8.w
    public final boolean w() {
        return b9.e.D.e(this.F.f12135i).booleanValue();
    }

    @Override // t9.k
    public final b9.f z0() {
        return this.G;
    }
}
