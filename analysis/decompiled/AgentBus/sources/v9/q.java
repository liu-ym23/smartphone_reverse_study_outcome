package v9;

/* loaded from: classes.dex */
public final class q extends p implements j {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(z zVar, z zVar2) {
        super(zVar, zVar2);
        q7.k.e(zVar, "lowerBound");
        q7.k.e(zVar2, "upperBound");
    }

    @Override // v9.v
    public final v G0(w9.g gVar) {
        q7.k.e(gVar, "kotlinTypeRefiner");
        z zVar = this.f10580g;
        q7.k.e(zVar, "type");
        z zVar2 = this.f10581h;
        q7.k.e(zVar2, "type");
        return new q(zVar, zVar2);
    }

    @Override // v9.z0
    public final z0 I0(boolean z4) {
        return d.j(this.f10580g.I0(z4), this.f10581h.I0(z4));
    }

    @Override // v9.z0
    /* renamed from: J0 */
    public final z0 G0(w9.g gVar) {
        q7.k.e(gVar, "kotlinTypeRefiner");
        z zVar = this.f10580g;
        q7.k.e(zVar, "type");
        z zVar2 = this.f10581h;
        q7.k.e(zVar2, "type");
        return new q(zVar, zVar2);
    }

    @Override // v9.z0
    public final z0 K0(i0 i0Var) {
        q7.k.e(i0Var, "newAttributes");
        return d.j(this.f10580g.K0(i0Var), this.f10581h.K0(i0Var));
    }

    @Override // v9.p
    public final z L0() {
        return this.f10580g;
    }

    @Override // v9.p
    public final String M0(g9.g gVar, g9.g gVar2) {
        boolean zO = gVar2.f3942a.o();
        z zVar = this.f10581h;
        z zVar2 = this.f10580g;
        if (!zO) {
            return gVar.G(gVar.Z(zVar2), gVar.Z(zVar), n7.m.r(this));
        }
        return "(" + gVar.Z(zVar2) + ".." + gVar.Z(zVar) + ')';
    }

    @Override // v9.j
    public final z0 R(v vVar) {
        z0 z0VarJ;
        q7.k.e(vVar, "replacement");
        z0 z0VarH0 = vVar.H0();
        if (z0VarH0 instanceof p) {
            z0VarJ = z0VarH0;
        } else {
            if (!(z0VarH0 instanceof z)) {
                throw new a4.u();
            }
            z zVar = (z) z0VarH0;
            z0VarJ = d.j(zVar, zVar.I0(true));
        }
        return c.g(z0VarJ, z0VarH0);
    }

    @Override // v9.j
    public final boolean j0() {
        z zVar = this.f10580g;
        return (zVar.E0().c() instanceof f8.q0) && q7.k.a(zVar.E0(), this.f10581h.E0());
    }

    @Override // v9.p
    public final String toString() {
        return "(" + this.f10580g + ".." + this.f10581h + ')';
    }
}
