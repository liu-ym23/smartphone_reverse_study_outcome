package x9;

import d7.z;
import f8.n0;
import f8.o;
import i8.k;
import java.util.List;
import o9.n;
import v9.s0;
import v9.v0;

/* loaded from: classes.dex */
public final class a extends k {
    /* JADX WARN: Illegal instructions before constructor call */
    public a(e9.f fVar) {
        i iVar = i.f11323a;
        c cVar = i.f11324b;
        u9.b bVar = u9.k.f10207e;
        List list = z.f2978f;
        super(cVar, fVar, 3, 1, list, bVar);
        i8.i iVar2 = new i8.i(this, null, g8.h.f3888a, true, 1, n0.f3487b);
        iVar2.U0(list, o.f3491d);
        String str = iVar2.getName().f3197f;
        q7.k.d(str, "errorConstructor.name.toString()");
        e eVarB = i.b(9, str, "");
        h hVar = h.A;
        iVar2.f4875l = new f(i.d(hVar, new String[0]), eVarB, hVar, list, false, new String[0]);
        C0(eVarB, ib.k.S(iVar2), iVar2);
    }

    @Override // i8.b, i8.z
    public final n R(s0 s0Var, w9.g gVar) {
        String str = getName().f3197f;
        q7.k.d(str, "name.toString()");
        return i.b(9, str, s0Var.toString());
    }

    @Override // i8.b, f8.p0
    public final f8.k d(v0 v0Var) {
        q7.k.e(v0Var, "substitutor");
        return this;
    }

    @Override // i8.k
    public final String toString() {
        String strB = getName().b();
        q7.k.d(strB, "name.asString()");
        return strB;
    }

    @Override // i8.b
    /* renamed from: u0 */
    public final f8.e d(v0 v0Var) {
        q7.k.e(v0Var, "substitutor");
        return this;
    }
}
