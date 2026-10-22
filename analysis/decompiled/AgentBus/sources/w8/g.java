package w8;

import v9.i0;
import v9.v;
import v9.x0;
import v9.z;
import v9.z0;

/* loaded from: classes.dex */
public final class g extends v9.m implements v9.j {

    /* renamed from: g, reason: collision with root package name */
    public final z f10897g;

    public g(z zVar) {
        q7.k.e(zVar, "delegate");
        this.f10897g = zVar;
    }

    @Override // v9.m, v9.v
    public final boolean F0() {
        return false;
    }

    @Override // v9.z, v9.z0
    public final z0 K0(i0 i0Var) {
        q7.k.e(i0Var, "newAttributes");
        return new g(this.f10897g.K0(i0Var));
    }

    @Override // v9.z
    /* renamed from: L0 */
    public final z I0(boolean z4) {
        return z4 ? this.f10897g.I0(true) : this;
    }

    @Override // v9.z
    /* renamed from: M0 */
    public final z K0(i0 i0Var) {
        q7.k.e(i0Var, "newAttributes");
        return new g(this.f10897g.K0(i0Var));
    }

    @Override // v9.m
    public final z N0() {
        return this.f10897g;
    }

    @Override // v9.m
    public final v9.m P0(z zVar) {
        return new g(zVar);
    }

    @Override // v9.j
    public final z0 R(v vVar) {
        q7.k.e(vVar, "replacement");
        z0 z0VarH0 = vVar.H0();
        if (!x0.f(z0VarH0) && !x0.e(z0VarH0)) {
            return z0VarH0;
        }
        if (z0VarH0 instanceof z) {
            z zVar = (z) z0VarH0;
            z zVarI0 = zVar.I0(false);
            return !x0.f(zVar) ? zVarI0 : new g(zVarI0);
        }
        if (!(z0VarH0 instanceof v9.p)) {
            throw new IllegalStateException(("Incorrect type: " + z0VarH0).toString());
        }
        v9.p pVar = (v9.p) z0VarH0;
        z zVar2 = pVar.f10580g;
        z zVarI02 = zVar2.I0(false);
        if (x0.f(zVar2)) {
            zVarI02 = new g(zVarI02);
        }
        z zVar3 = pVar.f10581h;
        z zVarI03 = zVar3.I0(false);
        if (x0.f(zVar3)) {
            zVarI03 = new g(zVarI03);
        }
        return v9.c.z(v9.d.j(zVarI02, zVarI03), v9.c.e(z0VarH0));
    }

    @Override // v9.j
    public final boolean j0() {
        return true;
    }
}
