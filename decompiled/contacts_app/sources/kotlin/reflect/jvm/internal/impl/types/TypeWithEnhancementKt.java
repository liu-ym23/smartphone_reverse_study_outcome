package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TypeWithEnhancement.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TypeWithEnhancementKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final KotlinType getEnhancement(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof TypeWithEnhancement) == true) goto L7;
        return null;
    L7:
        return ((TypeWithEnhancement) r1).getEnhancement();
    }

    public static final UnwrappedType inheritEnhancement(UnwrappedType r1, KotlinType r2, Function1<? super KotlinType, ? extends KotlinType> r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "origin");
        Intrinsics.checkNotNullParameter(r3, "transform");
        KotlinType r4 = getEnhancement(r2);
        if (r4 == null) goto L5;
        KotlinType r5 = r3.invoke(r4);
    L7:
        return wrapEnhancement(r1, r5);
    L5:
        r5 = null;
        goto L7
    }

    public static final UnwrappedType inheritEnhancement(UnwrappedType r1, KotlinType r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "origin");
        return wrapEnhancement(r1, getEnhancement(r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final UnwrappedType wrapEnhancement(UnwrappedType r1, KotlinType r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof TypeWithEnhancement) == true) goto L5;
        if (r2 != null) goto L8;
    L19:
        return r1;
    L8:
        if (Intrinsics.areEqual(r2, r1) == true) goto L19;
        if ((r1 instanceof SimpleType) == false) goto L14;
        return new SimpleTypeWithEnhancement((SimpleType) r1, r2);
    L14:
        if ((r1 instanceof FlexibleType) == false) goto L18;
        return new FlexibleTypeWithEnhancement((FlexibleType) r1, r2);
    L18:
        throw new NoWhenBranchMatchedException();
    L5:
        return wrapEnhancement(((TypeWithEnhancement) r1).getOrigin(), r2);
    }
}
