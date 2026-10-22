package s4;

import V3.n;
import x4.C1310j;

/* loaded from: classes.dex */
public final class M {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(Z3.e<?> eVar) {
        Object objA;
        if (eVar instanceof C1310j) {
            return eVar.toString();
        }
        try {
            n.a aVar = V3.n.f5531a;
            objA = V3.n.a(eVar + '@' + b(eVar));
        } catch (Throwable th) {
            n.a aVar2 = V3.n.f5531a;
            objA = V3.n.a(V3.o.a(th));
        }
        if (V3.n.b(objA) != null) {
            objA = eVar.getClass().getName() + '@' + b(eVar);
        }
        return (String) objA;
    }
}
