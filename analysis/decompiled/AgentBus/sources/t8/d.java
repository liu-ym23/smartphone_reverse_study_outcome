package t8;

import c7.j;
import c8.h;
import d7.t;
import f8.g;
import h4.n;
import java.util.ArrayList;
import java.util.List;
import q7.k;
import v9.i0;
import v9.m0;
import v9.p0;
import v9.q0;
import v9.s0;
import v9.v;
import v9.z;
import x9.i;

/* loaded from: classes.dex */
public final class d extends s0 {

    /* renamed from: c, reason: collision with root package name */
    public static final a f9784c = n7.b.x(2, false, null, 5).b(3);

    /* renamed from: d, reason: collision with root package name */
    public static final a f9785d = n7.b.x(2, false, null, 5).b(2);

    /* renamed from: b, reason: collision with root package name */
    public final nb.f f9786b = new nb.f(new n(24, false));

    @Override // v9.s0
    public final p0 d(v vVar) {
        return new q0(h(vVar, new a(2, false, false, null, 62)));
    }

    public final j g(z zVar, f8.e eVar, a aVar) {
        if (zVar.E0().getParameters().isEmpty()) {
            return new j(zVar, Boolean.FALSE);
        }
        if (h.y(zVar)) {
            p0 p0Var = (p0) zVar.C0().get(0);
            int iA = p0Var.a();
            v vVarB = p0Var.b();
            k.d(vVarB, "componentTypeProjection.type");
            return new j(v9.d.r(a.a.S(new q0(iA, h(vVarB, aVar))), zVar.D0(), zVar.E0(), zVar.F0()), Boolean.FALSE);
        }
        if (v9.c.i(zVar)) {
            return new j(i.c(x9.h.f11313s, zVar.E0().toString()), Boolean.FALSE);
        }
        o9.n nVarX = eVar.X(this);
        k.d(nVarX, "declaration.getMemberScope(this)");
        i0 i0VarD0 = zVar.D0();
        m0 m0VarH = eVar.h();
        k.d(m0VarH, "declaration.typeConstructor");
        List<f8.q0> parameters = eVar.h().getParameters();
        k.d(parameters, "declaration.typeConstructor.parameters");
        ArrayList arrayList = new ArrayList(t.A0(parameters, 10));
        for (f8.q0 q0Var : parameters) {
            k.d(q0Var, "parameter");
            nb.f fVar = this.f9786b;
            arrayList.add(n.g(q0Var, aVar, fVar, fVar.z(q0Var, aVar)));
        }
        return new j(v9.d.t(i0VarD0, m0VarH, arrayList, zVar.F0(), nVarX, new r8.c(eVar, this, zVar, aVar)), Boolean.TRUE);
    }

    public final v h(v vVar, a aVar) {
        g gVarC = vVar.E0().c();
        if (gVarC instanceof f8.q0) {
            aVar.getClass();
            return h(this.f9786b.z((f8.q0) gVarC, a.a(aVar, 0, true, null, null, 59)), aVar);
        }
        if (!(gVarC instanceof f8.e)) {
            throw new IllegalStateException(("Unexpected declaration kind: " + gVarC).toString());
        }
        g gVarC2 = v9.c.x(vVar).E0().c();
        if (gVarC2 instanceof f8.e) {
            j jVarG = g(v9.c.k(vVar), (f8.e) gVarC, f9784c);
            z zVar = (z) jVarG.f1973f;
            boolean zBooleanValue = ((Boolean) jVarG.f1974g).booleanValue();
            j jVarG2 = g(v9.c.x(vVar), (f8.e) gVarC2, f9785d);
            z zVar2 = (z) jVarG2.f1973f;
            return (zBooleanValue || ((Boolean) jVarG2.f1974g).booleanValue()) ? new f(zVar, zVar2) : v9.d.j(zVar, zVar2);
        }
        throw new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + gVarC2 + "\" while for lower it's \"" + gVarC + '\"').toString());
    }
}
