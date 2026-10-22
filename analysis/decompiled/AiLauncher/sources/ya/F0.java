package ya;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class F0 {
    public static final AbstractC5990d0 a(S s10) {
        kotlin.jvm.internal.p.i(s10, "<this>");
        K0 K02 = s10.K0();
        AbstractC5990d0 abstractC5990d0 = K02 instanceof AbstractC5990d0 ? (AbstractC5990d0) K02 : null;
        if (abstractC5990d0 != null) {
            return abstractC5990d0;
        }
        throw new IllegalStateException(("This is should be simple type: " + s10).toString());
    }

    public static final S b(S s10, List<? extends B0> newArguments, F9.g newAnnotations) {
        kotlin.jvm.internal.p.i(s10, "<this>");
        kotlin.jvm.internal.p.i(newArguments, "newArguments");
        kotlin.jvm.internal.p.i(newAnnotations, "newAnnotations");
        return e(s10, newArguments, newAnnotations, null, 4, null);
    }

    public static final S c(S s10, List<? extends B0> newArguments, F9.g newAnnotations, List<? extends B0> newArgumentsForUpperBound) {
        kotlin.jvm.internal.p.i(s10, "<this>");
        kotlin.jvm.internal.p.i(newArguments, "newArguments");
        kotlin.jvm.internal.p.i(newAnnotations, "newAnnotations");
        kotlin.jvm.internal.p.i(newArgumentsForUpperBound, "newArgumentsForUpperBound");
        if ((newArguments.isEmpty() || newArguments == s10.F0()) && newAnnotations == s10.getAnnotations()) {
            return s10;
        }
        s0 s0VarG0 = s10.G0();
        if ((newAnnotations instanceof F9.o) && ((F9.o) newAnnotations).isEmpty()) {
            newAnnotations = F9.g.f2609m0.b();
        }
        s0 s0VarA = t0.a(s0VarG0, newAnnotations);
        K0 K02 = s10.K0();
        if (K02 instanceof AbstractC5974I) {
            AbstractC5974I abstractC5974I = (AbstractC5974I) K02;
            return V.e(d(abstractC5974I.P0(), newArguments, s0VarA), d(abstractC5974I.Q0(), newArgumentsForUpperBound, s0VarA));
        }
        if (K02 instanceof AbstractC5990d0) {
            return d((AbstractC5990d0) K02, newArguments, s0VarA);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final AbstractC5990d0 d(AbstractC5990d0 abstractC5990d0, List<? extends B0> newArguments, s0 newAttributes) {
        kotlin.jvm.internal.p.i(abstractC5990d0, "<this>");
        kotlin.jvm.internal.p.i(newArguments, "newArguments");
        kotlin.jvm.internal.p.i(newAttributes, "newAttributes");
        return (newArguments.isEmpty() && newAttributes == abstractC5990d0.G0()) ? abstractC5990d0 : newArguments.isEmpty() ? abstractC5990d0.N0(newAttributes) : abstractC5990d0 instanceof Aa.g ? ((Aa.g) abstractC5990d0).T0(newArguments) : V.m(newAttributes, abstractC5990d0.H0(), newArguments, abstractC5990d0.I0(), null, 16, null);
    }

    public static /* synthetic */ S e(S s10, List list, F9.g gVar, List list2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = s10.F0();
        }
        if ((i10 & 2) != 0) {
            gVar = s10.getAnnotations();
        }
        if ((i10 & 4) != 0) {
            list2 = list;
        }
        return c(s10, list, gVar, list2);
    }

    public static /* synthetic */ AbstractC5990d0 f(AbstractC5990d0 abstractC5990d0, List list, s0 s0Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = abstractC5990d0.F0();
        }
        if ((i10 & 2) != 0) {
            s0Var = abstractC5990d0.G0();
        }
        return d(abstractC5990d0, list, s0Var);
    }
}
