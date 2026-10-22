package o8;

import i8.l0;
import java.util.List;
import v9.v0;

/* loaded from: classes.dex */
public final class j implements h9.g {
    @Override // h9.g
    public final int a(f8.b bVar, f8.b bVar2, f8.e eVar) {
        q7.k.e(bVar, "superDescriptor");
        q7.k.e(bVar2, "subDescriptor");
        if (!(bVar2 instanceof q8.e)) {
            return 4;
        }
        q8.e eVar2 = (q8.e) bVar2;
        if (!eVar2.getTypeParameters().isEmpty()) {
            return 4;
        }
        h9.k kVarI = h9.l.i(bVar, bVar2);
        if ((kVarI != null ? kVarI.c() : 0) != 0) {
            return 4;
        }
        List listX0 = eVar2.x0();
        q7.k.d(listX0, "subDescriptor.valueParameters");
        fa.p pVarT0 = fa.l.t0(d7.r.H0(listX0), e.f7802k);
        v9.v vVar = eVar2.f4875l;
        q7.k.b(vVar);
        fa.g gVarR0 = fa.l.r0(d7.n.T(new fa.j[]{pVarT0, d7.n.T(new Object[]{vVar})}));
        i8.v vVar2 = eVar2.f4877n;
        fa.e eVar3 = new fa.e(fa.l.r0(d7.n.T(new fa.j[]{gVarR0, d7.r.H0(d7.s.w0(vVar2 != null ? vVar2.getType() : null))})));
        while (eVar3.hasNext()) {
            v9.v vVar3 = (v9.v) eVar3.next();
            if (!vVar3.C0().isEmpty() && !(vVar3.H0() instanceof t8.f)) {
                return 4;
            }
        }
        f8.b bVarBuild = (f8.b) bVar.d(new v0(new t8.d()));
        if (bVarBuild == null) {
            return 4;
        }
        if (bVarBuild instanceof l0) {
            l0 l0Var = (l0) bVarBuild;
            if (!l0Var.getTypeParameters().isEmpty()) {
                bVarBuild = l0Var.o0().g().build();
                q7.k.b(bVarBuild);
            }
        }
        int iC = h9.l.f4243c.n(bVarBuild, bVar2, false).c();
        m.x.y(iC, "DEFAULT.isOverridableByW…Descriptor, false).result");
        return i.$EnumSwitchMapping$0[n.f.d(iC)] == 1 ? 1 : 4;
    }

    @Override // h9.g
    public final int b() {
        return 2;
    }
}
