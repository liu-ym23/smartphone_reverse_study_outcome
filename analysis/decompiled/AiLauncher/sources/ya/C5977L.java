package ya;

import kotlin.NoWhenBranchMatchedException;

/* renamed from: ya.L, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5977L {
    public static final AbstractC5974I a(S s10) {
        kotlin.jvm.internal.p.i(s10, "<this>");
        K0 K02 = s10.K0();
        kotlin.jvm.internal.p.g(K02, "null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
        return (AbstractC5974I) K02;
    }

    public static final boolean b(S s10) {
        kotlin.jvm.internal.p.i(s10, "<this>");
        return s10.K0() instanceof AbstractC5974I;
    }

    public static final AbstractC5990d0 c(S s10) {
        kotlin.jvm.internal.p.i(s10, "<this>");
        K0 K02 = s10.K0();
        if (K02 instanceof AbstractC5974I) {
            return ((AbstractC5974I) K02).P0();
        }
        if (K02 instanceof AbstractC5990d0) {
            return (AbstractC5990d0) K02;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final AbstractC5990d0 d(S s10) {
        kotlin.jvm.internal.p.i(s10, "<this>");
        K0 K02 = s10.K0();
        if (K02 instanceof AbstractC5974I) {
            return ((AbstractC5974I) K02).Q0();
        }
        if (K02 instanceof AbstractC5990d0) {
            return (AbstractC5990d0) K02;
        }
        throw new NoWhenBranchMatchedException();
    }
}
