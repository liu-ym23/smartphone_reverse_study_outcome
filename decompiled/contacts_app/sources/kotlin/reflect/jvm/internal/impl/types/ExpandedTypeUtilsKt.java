package kotlin.reflect.jvm.internal.impl.types;

import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;

/* JADX INFO: compiled from: expandedTypeUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ExpandedTypeUtilsKt {
    public static final KotlinTypeMarker computeExpandedTypeForInlineClass(TypeSystemCommonBackendContext r1, KotlinTypeMarker r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "inlineClassType");
        return computeExpandedTypeInner(r1, r2, new HashSet());
    }

    private static final KotlinTypeMarker computeExpandedTypeInner(TypeSystemCommonBackendContext r3, KotlinTypeMarker r4, HashSet<TypeConstructorMarker> r5) {
        TypeConstructorMarker r0 = r3.typeConstructor(r4);
        if (r5.add(r0) == true) goto L5;
        return null;
    L5:
        TypeParameterMarker r1 = r3.getTypeParameterClassifier(r0);
        if (r1 == null) goto L35;
        KotlinTypeMarker r2 = r3.getRepresentativeUpperBound(r1);
        KotlinTypeMarker r6 = computeExpandedTypeInner(r3, r2, r5);
        if (r6 == null) goto L56;
        if (r3.isInlineClass(r3.typeConstructor(r2)) == false) goto L12;
    L17:
        boolean r7 = true;
    L19:
        if ((r6 instanceof SimpleTypeMarker) == false) goto L27;
        if (r3.isPrimitiveType((SimpleTypeMarker) r6) == false) goto L27;
        if (r3.isNullableType(r4) == false) goto L27;
        if (r7 == false) goto L27;
        KotlinTypeMarker r8 = r3.makeNullable(r2);
    L55:
        return r8;
    L27:
        if (r3.isNullableType(r6) == true) goto L58;
        if (r3.isMarkedNullable(r4) == false) goto L58;
        r8 = r3.makeNullable(r6);
    L58:
        return r6;
    L12:
        if ((r2 instanceof SimpleTypeMarker) == true) goto L14;
    L16:
        r7 = false;
        goto L19
    L14:
        if (r3.isPrimitiveType((SimpleTypeMarker) r2) == false) goto L16;
    L56:
        return null;
    L35:
        if (r3.isInlineClass(r0) == false) goto L57;
        KotlinTypeMarker r9 = r3.getUnsubstitutedUnderlyingType(r4);
        if (r9 != null) goto L39;
        return null;
    L39:
        r6 = computeExpandedTypeInner(r3, r9, r5);
        if (r6 != null) goto L43;
        return null;
    L43:
        if (r3.isNullableType(r4) == false) goto L58;
        if (r3.isNullableType(r6) == false) goto L49;
        return r4;
    L49:
        if ((r6 instanceof SimpleTypeMarker) == false) goto L54;
        if (r3.isPrimitiveType((SimpleTypeMarker) r6) == false) goto L54;
        return r4;
    L54:
        return r3.makeNullable(r6);
    L57:
        return r4;
    }
}
