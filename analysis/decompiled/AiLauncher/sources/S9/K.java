package S9;

import Z8.C1173v;
import java.util.List;

/* loaded from: classes5.dex */
public final class K {
    public static final List<ga.e> a(ga.e name) {
        kotlin.jvm.internal.p.i(name, "name");
        String strB = name.b();
        kotlin.jvm.internal.p.h(strB, "asString(...)");
        return E.c(strB) ? C1173v.q(b(name)) : E.d(strB) ? f(name) : C1008g.f5749a.b(name);
    }

    public static final ga.e b(ga.e methodName) {
        kotlin.jvm.internal.p.i(methodName, "methodName");
        ga.e eVarE = e(methodName, "get", false, null, 12, null);
        return eVarE == null ? e(methodName, "is", false, null, 8, null) : eVarE;
    }

    public static final ga.e c(ga.e methodName, boolean z10) {
        kotlin.jvm.internal.p.i(methodName, "methodName");
        return e(methodName, "set", false, z10 ? "is" : null, 4, null);
    }

    public static final ga.e d(ga.e eVar, String str, boolean z10, String str2) {
        if (eVar.k()) {
            return null;
        }
        String strE = eVar.e();
        kotlin.jvm.internal.p.h(strE, "getIdentifier(...)");
        if (!La.D.X(strE, str, false, 2, null) || strE.length() == str.length()) {
            return null;
        }
        char cCharAt = strE.charAt(str.length());
        if ('a' <= cCharAt && cCharAt < '{') {
            return null;
        }
        if (str2 != null) {
            return ga.e.j(str2 + La.H.R0(strE, str));
        }
        if (!z10) {
            return eVar;
        }
        String strC = Ga.a.c(La.H.R0(strE, str), true);
        if (ga.e.l(strC)) {
            return ga.e.j(strC);
        }
        return null;
    }

    public static /* synthetic */ ga.e e(ga.e eVar, String str, boolean z10, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        if ((i10 & 8) != 0) {
            str2 = null;
        }
        return d(eVar, str, z10, str2);
    }

    public static final List<ga.e> f(ga.e methodName) {
        kotlin.jvm.internal.p.i(methodName, "methodName");
        return C1173v.r(c(methodName, false), c(methodName, true));
    }
}
