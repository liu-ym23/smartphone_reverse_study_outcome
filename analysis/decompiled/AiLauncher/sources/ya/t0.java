package ya;

import ya.r0;

/* loaded from: classes5.dex */
public final class t0 {
    public static final s0 a(s0 s0Var, F9.g newAnnotations) {
        s0 s0VarO;
        kotlin.jvm.internal.p.i(s0Var, "<this>");
        kotlin.jvm.internal.p.i(newAnnotations, "newAnnotations");
        if (C6012s.a(s0Var) == newAnnotations) {
            return s0Var;
        }
        r rVarB = C6012s.b(s0Var);
        if (rVarB != null && (s0VarO = s0Var.o(rVarB)) != null) {
            s0Var = s0VarO;
        }
        return (newAnnotations.iterator().hasNext() || !newAnnotations.isEmpty()) ? s0Var.n(new r(newAnnotations)) : s0Var;
    }

    public static final s0 b(F9.g gVar) {
        kotlin.jvm.internal.p.i(gVar, "<this>");
        return r0.a.a(C6016w.f44130a, gVar, null, null, 6, null);
    }
}
