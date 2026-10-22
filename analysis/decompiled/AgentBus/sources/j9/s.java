package j9;

import f8.z;
import v9.i0;
import v9.q0;
import v9.z0;

/* loaded from: classes.dex */
public final class s extends g {
    public s(e9.b bVar, int i2) {
        super(new q(new f(bVar, i2)));
    }

    @Override // j9.g
    public final v9.v a(z zVar) {
        v9.v vVarC;
        q7.k.e(zVar, "module");
        i0.f10557g.getClass();
        i0 i0Var = i0.f10558h;
        c8.h hVarN = zVar.n();
        hVarN.getClass();
        f8.e eVarI = hVarN.i(c8.m.P.g());
        Object obj = this.f5408a;
        r rVar = (r) obj;
        if (rVar instanceof p) {
            vVarC = ((p) obj).f5415a;
        } else {
            if (!(rVar instanceof q)) {
                throw new a4.u();
            }
            f fVar = ((q) obj).f5416a;
            e9.b bVar = fVar.f5406a;
            int i2 = fVar.f5407b;
            f8.e eVarD = f8.v.d(zVar, bVar);
            if (eVarD == null) {
                String string = bVar.toString();
                q7.k.d(string, "classId.toString()");
                vVarC = x9.i.c(x9.h.f11303i, string, String.valueOf(i2));
            } else {
                v9.z zVarK = eVarD.k();
                q7.k.d(zVarK, "descriptor.defaultType");
                z0 z0VarG = n7.m.G(zVarK);
                for (int i10 = 0; i10 < i2; i10++) {
                    z0VarG = zVar.n().h(z0VarG);
                }
                vVarC = z0VarG;
            }
        }
        return v9.d.q(i0Var, eVarI, a.a.S(new q0(vVarC)));
    }
}
