package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.FilteredAnnotations;

/* JADX INFO: compiled from: TypeSubstitution.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TypeSubstitutionKt {
    public static final KotlinType replace(KotlinType r7, List<? extends TypeProjection> r8, Annotations r9) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "newArguments");
        Intrinsics.checkNotNullParameter(r9, "newAnnotations");
        return replace$default(r7, r8, r9, null, 4, null);
    }

    public static /* synthetic */ KotlinType replace$default(KotlinType r0, List r1, Annotations r2, List r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.getArguments();
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.getAnnotations();
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r1;
    L12:
        return replace(r0, r1, r2, r3);
    }

    public static final KotlinType replace(KotlinType r2, List<? extends TypeProjection> r3, Annotations r4, List<? extends TypeProjection> r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "newArguments");
        Intrinsics.checkNotNullParameter(r4, "newAnnotations");
        Intrinsics.checkNotNullParameter(r5, "newArgumentsForUpperBound");
        if (r3.isEmpty() == true) goto L7;
        if (r3 == r2.getArguments()) goto L7;
    L9:
        TypeAttributes r0 = r2.getAttributes();
        if ((r4 instanceof FilteredAnnotations) == true) goto L12;
    L14:
        TypeAttributes r6 = TypeAttributesKt.replaceAnnotations(r0, r4);
        UnwrappedType r7 = r2.unwrap();
        if ((r7 instanceof FlexibleType) == false) goto L18;
        FlexibleType r8 = (FlexibleType) r7;
        return KotlinTypeFactory.flexibleType(replace(r8.getLowerBound(), r3, r6), replace(r8.getUpperBound(), r5, r6));
    L18:
        if ((r7 instanceof SimpleType) == false) goto L22;
        return replace((SimpleType) r7, r3, r6);
    L22:
        throw new NoWhenBranchMatchedException();
    L12:
        if (r4.isEmpty() == false) goto L14;
        r4 = Annotations.Companion.getEMPTY();
    L7:
        if (r4 != r2.getAnnotations()) goto L9;
        return r2;
    }

    public static /* synthetic */ SimpleType replace$default(SimpleType r0, List r1, TypeAttributes r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.getArguments();
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.getAttributes();
    L9:
        return replace(r0, r1, r2);
    }

    public static final SimpleType replace(SimpleType r7, List<? extends TypeProjection> r8, TypeAttributes r9) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "newArguments");
        Intrinsics.checkNotNullParameter(r9, "newAttributes");
        if (r8.isEmpty() == false) goto L8;
        if (r9 != r7.getAttributes()) goto L8;
        return r7;
    L8:
        if (r8.isEmpty() == false) goto L12;
        return r7.replaceAttributes(r9);
    L12:
        return KotlinTypeFactory.simpleType$default(r9, r7.getConstructor(), r8, r7.isMarkedNullable(), null, 16, null);
    }

    public static final SimpleType asSimpleType(KotlinType r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        UnwrappedType r0 = r3.unwrap();
        if ((r0 instanceof SimpleType) == false) goto L5;
        SimpleType r1 = (SimpleType) r0;
    L6:
        if (r1 == null) goto L9;
        return r1;
    L9:
        throw new IllegalStateException(("This is should be simple type: " + r3).toString());
    L5:
        r1 = null;
        goto L6
    }
}
