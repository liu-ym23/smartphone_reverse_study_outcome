package ya;

import kotlin.NoWhenBranchMatchedException;
import p9.InterfaceC5074l;

/* loaded from: classes5.dex */
public final class J0 {
    /* JADX WARN: Multi-variable type inference failed */
    public static final S a(S s10) {
        kotlin.jvm.internal.p.i(s10, "<this>");
        if (s10 instanceof I0) {
            return ((I0) s10).c0();
        }
        return null;
    }

    public static final K0 b(K0 k02, S origin) {
        kotlin.jvm.internal.p.i(k02, "<this>");
        kotlin.jvm.internal.p.i(origin, "origin");
        return d(k02, a(origin));
    }

    public static final K0 c(K0 k02, S origin, InterfaceC5074l<? super S, ? extends S> transform) {
        kotlin.jvm.internal.p.i(k02, "<this>");
        kotlin.jvm.internal.p.i(origin, "origin");
        kotlin.jvm.internal.p.i(transform, "transform");
        S sA = a(origin);
        return d(k02, sA != null ? transform.invoke(sA) : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final K0 d(K0 k02, S s10) {
        kotlin.jvm.internal.p.i(k02, "<this>");
        if (k02 instanceof I0) {
            return d(((I0) k02).A0(), s10);
        }
        if (s10 == null || kotlin.jvm.internal.p.d(s10, k02)) {
            return k02;
        }
        if (k02 instanceof AbstractC5990d0) {
            return new C5996g0((AbstractC5990d0) k02, s10);
        }
        if (k02 instanceof AbstractC5974I) {
            return new C5976K((AbstractC5974I) k02, s10);
        }
        throw new NoWhenBranchMatchedException();
    }
}
