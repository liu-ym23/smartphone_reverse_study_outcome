package ya;

import kotlin.reflect.jvm.internal.impl.types.Variance;

/* renamed from: ya.F, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5971F {
    public static /* synthetic */ B0 b(C5971F c5971f, E9.b0 b0Var, C5972G c5972g, A0 a02, S s10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: computeProjection");
        }
        if ((i10 & 8) != 0) {
            s10 = a02.e(b0Var, c5972g);
        }
        return c5971f.a(b0Var, c5972g, a02, s10);
    }

    public B0 a(E9.b0 parameter, C5972G typeAttr, A0 typeParameterUpperBoundEraser, S erasedUpperBound) {
        kotlin.jvm.internal.p.i(parameter, "parameter");
        kotlin.jvm.internal.p.i(typeAttr, "typeAttr");
        kotlin.jvm.internal.p.i(typeParameterUpperBoundEraser, "typeParameterUpperBoundEraser");
        kotlin.jvm.internal.p.i(erasedUpperBound, "erasedUpperBound");
        return new D0(Variance.OUT_VARIANCE, erasedUpperBound);
    }
}
