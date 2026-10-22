package x4;

import x4.AbstractC1291C;

/* renamed from: x4.D, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1292D<S extends AbstractC1291C<S>> {
    public static <S extends AbstractC1291C<S>> Object a(Object obj) {
        return obj;
    }

    public static final S b(Object obj) {
        if (obj == C1303c.f23850a) {
            throw new IllegalStateException("Does not contain segment");
        }
        j4.k.e(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (S) obj;
    }

    public static final boolean c(Object obj) {
        return obj == C1303c.f23850a;
    }
}
