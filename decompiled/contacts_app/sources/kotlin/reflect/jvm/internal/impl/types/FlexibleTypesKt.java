package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: flexibleTypes.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class FlexibleTypesKt {
    public static final boolean isFlexible(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.unwrap() instanceof FlexibleType;
    }

    public static final FlexibleType asFlexibleType(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        UnwrappedType r2 = r1.unwrap();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
        return (FlexibleType) r2;
    }

    public static final SimpleType lowerIfFlexible(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        UnwrappedType r2 = r1.unwrap();
        if ((r2 instanceof FlexibleType) == false) goto L6;
        return ((FlexibleType) r2).getLowerBound();
    L6:
        if ((r2 instanceof SimpleType) == false) goto L10;
        return (SimpleType) r2;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public static final SimpleType upperIfFlexible(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        UnwrappedType r2 = r1.unwrap();
        if ((r2 instanceof FlexibleType) == false) goto L6;
        return ((FlexibleType) r2).getUpperBound();
    L6:
        if ((r2 instanceof SimpleType) == false) goto L10;
        return (SimpleType) r2;
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
