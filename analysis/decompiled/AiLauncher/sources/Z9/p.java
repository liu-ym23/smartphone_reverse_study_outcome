package Z9;

import Z8.F;

/* loaded from: classes5.dex */
public final class p {
    public static final boolean a(r rVar) {
        ga.c cVarF;
        B b10 = (B) F.Z0(rVar.i());
        x type = b10 != null ? b10.getType() : null;
        j jVar = type instanceof j ? (j) type : null;
        if (jVar == null) {
            return false;
        }
        i iVarC = jVar.c();
        return (iVarC instanceof g) && (cVarF = ((g) iVarC).f()) != null && kotlin.jvm.internal.p.d(cVarF.a(), "java.lang.Object");
    }

    public static final boolean b(r rVar) {
        String strB = rVar.getName().b();
        int iHashCode = strB.hashCode();
        if (iHashCode != -1776922004) {
            if (iHashCode == -1295482945) {
                if (strB.equals("equals")) {
                    return a(rVar);
                }
                return false;
            }
            if (iHashCode != 147696667 || !strB.equals("hashCode")) {
                return false;
            }
        } else if (!strB.equals("toString")) {
            return false;
        }
        return rVar.i().isEmpty();
    }

    public static final boolean c(q qVar) {
        kotlin.jvm.internal.p.i(qVar, "<this>");
        return qVar.L().F() && (qVar instanceof r) && b((r) qVar);
    }
}
