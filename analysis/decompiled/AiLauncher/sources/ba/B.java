package ba;

import D9.a;
import aa.r0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import pa.C5080d;
import ya.G0;

/* loaded from: classes5.dex */
public final class B {
    public static final <T> T a(n<T> nVar, T possiblyPrimitiveType, boolean z10) {
        kotlin.jvm.internal.p.i(nVar, "<this>");
        kotlin.jvm.internal.p.i(possiblyPrimitiveType, "possiblyPrimitiveType");
        return z10 ? nVar.b(possiblyPrimitiveType) : possiblyPrimitiveType;
    }

    public static final <T> T b(G0 g02, Ca.g type, n<T> typeFactory, C1463A mode) {
        kotlin.jvm.internal.p.i(g02, "<this>");
        kotlin.jvm.internal.p.i(type, "type");
        kotlin.jvm.internal.p.i(typeFactory, "typeFactory");
        kotlin.jvm.internal.p.i(mode, "mode");
        Ca.n nVarV = g02.V(type);
        if (!g02.D(nVarV)) {
            return null;
        }
        PrimitiveType primitiveTypeR = g02.R(nVarV);
        if (primitiveTypeR != null) {
            return (T) a(typeFactory, typeFactory.c(primitiveTypeR), g02.p(type) || r0.c(g02, type));
        }
        PrimitiveType primitiveTypeP0 = g02.P0(nVarV);
        if (primitiveTypeP0 != null) {
            return typeFactory.a('[' + JvmPrimitiveType.get(primitiveTypeP0).getDesc());
        }
        if (g02.L(nVarV)) {
            ga.d dVarA0 = g02.a0(nVarV);
            ga.b bVarN = dVarA0 != null ? D9.a.f2270a.n(dVarA0) : null;
            if (bVarN != null) {
                if (!mode.a()) {
                    List<a.C0022a> listI = D9.a.f2270a.i();
                    if (!(listI instanceof Collection) || !listI.isEmpty()) {
                        Iterator<T> it = listI.iterator();
                        while (it.hasNext()) {
                            if (kotlin.jvm.internal.p.d(((a.C0022a) it.next()).d(), bVarN)) {
                                return null;
                            }
                        }
                    }
                }
                String strH = C5080d.h(bVarN);
                kotlin.jvm.internal.p.h(strH, "internalNameByClassId(...)");
                return typeFactory.e(strH);
            }
        }
        return null;
    }
}
