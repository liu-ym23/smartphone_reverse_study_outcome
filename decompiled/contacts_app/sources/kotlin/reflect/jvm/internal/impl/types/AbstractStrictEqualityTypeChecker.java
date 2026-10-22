package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;

/* JADX INFO: compiled from: AbstractStrictEqualityTypeChecker.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AbstractStrictEqualityTypeChecker {
    public static final AbstractStrictEqualityTypeChecker INSTANCE = null;

    static {
        INSTANCE = new AbstractStrictEqualityTypeChecker();
    }

    private AbstractStrictEqualityTypeChecker() {
    }

    public final boolean strictEqualTypes(TypeSystemContext r2, KotlinTypeMarker r3, KotlinTypeMarker r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "a");
        Intrinsics.checkNotNullParameter(r4, "b");
        return strictEqualTypesInternal(r2, r3, r4);
    }

    private final boolean strictEqualTypesInternal(TypeSystemContext r5, KotlinTypeMarker r6, KotlinTypeMarker r7) {
        if (r6 != r7) goto L5;
        return true;
    L5:
        SimpleTypeMarker r1 = r5.asSimpleType(r6);
        SimpleTypeMarker r2 = r5.asSimpleType(r7);
        if (r1 == null) goto L10;
        if (r2 == null) goto L10;
        return strictEqualSimpleTypes(r5, r1, r2);
    L10:
        FlexibleTypeMarker r8 = r5.asFlexibleType(r6);
        FlexibleTypeMarker r9 = r5.asFlexibleType(r7);
        if (r8 == null) goto L20;
        if (r9 == null) goto L20;
        if (strictEqualSimpleTypes(r5, r5.lowerBound(r8), r5.lowerBound(r9)) == false) goto L19;
        if (strictEqualSimpleTypes(r5, r5.upperBound(r8), r5.upperBound(r9)) == false) goto L19;
        return true;
    L19:
        return false;
    L20:
        return false;
    }

    private final boolean strictEqualSimpleTypes(TypeSystemContext r9, SimpleTypeMarker r10, SimpleTypeMarker r11) {
        SimpleTypeMarker r0 = r10;
        SimpleTypeMarker r2 = r11;
        if (r9.argumentsCount(r0) == r9.argumentsCount(r2)) goto L5;
    L36:
        return false;
    L5:
        if (r9.isMarkedNullable(r10) != r9.isMarkedNullable(r11)) goto L36;
        if (r9.asDefinitelyNotNullType(r10) != null) goto L9;
        boolean r1 = true;
    L11:
        if (r9.asDefinitelyNotNullType(r11) != null) goto L13;
        boolean r5 = true;
    L14:
        if (r1 != r5) goto L36;
        if (r9.areEqualTypeConstructors(r9.typeConstructor(r10), r9.typeConstructor(r11)) == false) goto L36;
        if (r9.identicalArguments(r10, r11) == false) goto L21;
        return true;
    L21:
        int r12 = r9.argumentsCount(r0);
        int r13 = 0;
    L22:
        if (r13 >= r12) goto L35;
        TypeArgumentMarker r3 = r9.getArgument(r0, r13);
        TypeArgumentMarker r6 = r9.getArgument(r2, r13);
        if (r9.isStarProjection(r3) != r9.isStarProjection(r6)) goto L25;
        if (r9.isStarProjection(r3) == true) goto L34;
        if (r9.getVariance(r3) != r9.getVariance(r6)) goto L30;
        if (strictEqualTypesInternal(r9, r9.getType(r3), r9.getType(r6)) == true) goto L34;
        return false;
    L30:
        return false;
    L34:
        r13 = r13 + 1;
        goto L22
    L25:
        return false;
    L35:
        return true;
    L13:
        r5 = false;
        goto L14
    L9:
        r1 = false;
        goto L11
    }
}
