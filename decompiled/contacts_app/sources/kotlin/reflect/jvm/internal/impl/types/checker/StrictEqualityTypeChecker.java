package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.AbstractStrictEqualityTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* JADX INFO: compiled from: NewKotlinTypeChecker.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class StrictEqualityTypeChecker {
    public static final StrictEqualityTypeChecker INSTANCE = null;

    static {
        INSTANCE = new StrictEqualityTypeChecker();
    }

    private StrictEqualityTypeChecker() {
    }

    public final boolean strictEqualTypes(UnwrappedType r2, UnwrappedType r3) {
        Intrinsics.checkNotNullParameter(r2, "a");
        Intrinsics.checkNotNullParameter(r3, "b");
        return AbstractStrictEqualityTypeChecker.INSTANCE.strictEqualTypes(SimpleClassicTypeSystemContext.INSTANCE, r2, r3);
    }
}
