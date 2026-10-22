package kotlin.reflect.jvm.internal.impl.types.model;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: compiled from: TypeSystemContext.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TypeSystemContextKt {

    /* JADX INFO: compiled from: TypeSystemContext.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Variance.values().length];
            r0[Variance.INVARIANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Variance.IN_VARIANCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Variance.OUT_VARIANCE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static final TypeVariance convertVariance(Variance r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r2 = WhenMappings.$EnumSwitchMapping$0[r1.ordinal()];
        if (r2 == 1) goto L13;
        if (r2 == 2) goto L15;
        if (r2 != 3) goto L10;
        return TypeVariance.OUT;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return TypeVariance.IN;
    L13:
        return TypeVariance.INV;
    }
}
