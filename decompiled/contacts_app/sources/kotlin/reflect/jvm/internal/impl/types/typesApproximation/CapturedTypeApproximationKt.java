package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: compiled from: CapturedTypeApproximation.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CapturedTypeApproximationKt {

    /* JADX INFO: compiled from: CapturedTypeApproximation.kt */
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

    private static final TypeProjection toTypeProjection(TypeArgument r2) {
        r2.isConsistent();
        if (Intrinsics.areEqual(r2.getInProjection(), r2.getOutProjection()) == true) goto L17;
        if (r2.getTypeParameter().getVariance() == Variance.IN_VARIANCE) goto L17;
        if (KotlinBuiltIns.isNothing(r2.getInProjection()) == false) goto L13;
        if (r2.getTypeParameter().getVariance() == Variance.IN_VARIANCE) goto L13;
        return new TypeProjectionImpl(toTypeProjection$removeProjectionIfRedundant(r2, Variance.OUT_VARIANCE), r2.getOutProjection());
    L13:
        if (KotlinBuiltIns.isNullableAny(r2.getOutProjection()) == false) goto L20;
        return new TypeProjectionImpl(toTypeProjection$removeProjectionIfRedundant(r2, Variance.IN_VARIANCE), r2.getInProjection());
    L20:
        return new TypeProjectionImpl(toTypeProjection$removeProjectionIfRedundant(r2, Variance.OUT_VARIANCE), r2.getOutProjection());
    L17:
        return new TypeProjectionImpl(r2.getInProjection());
    }

    private static final Variance toTypeProjection$removeProjectionIfRedundant(TypeArgument r0, Variance r1) {
        if (r1 == r0.getTypeParameter().getVariance()) goto L5;
        return r1;
    L5:
        return Variance.INVARIANT;
    }

    private static final TypeArgument toTypeArgument(TypeProjection r4, TypeParameterDescriptor r5) {
        Variance r0 = TypeSubstitutor.combine(r5.getVariance(), r4);
        int r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        if (r1 != 1) goto L5;
        KotlinType r2 = r4.getType();
        Intrinsics.checkNotNullExpressionValue(r2, "type");
        KotlinType r6 = r4.getType();
        Intrinsics.checkNotNullExpressionValue(r6, "type");
        return new TypeArgument(r5, r2, r6);
    L5:
        if (r1 != 2) goto L7;
        KotlinType r7 = r4.getType();
        Intrinsics.checkNotNullExpressionValue(r7, "type");
        SimpleType r3 = DescriptorUtilsKt.getBuiltIns(r5).getNullableAnyType();
        Intrinsics.checkNotNullExpressionValue(r3, "typeParameter.builtIns.nullableAnyType");
        return new TypeArgument(r5, r7, r3);
    L7:
        if (r1 != 3) goto L10;
        SimpleType r8 = DescriptorUtilsKt.getBuiltIns(r5).getNothingType();
        Intrinsics.checkNotNullExpressionValue(r8, "typeParameter.builtIns.nothingType");
        KotlinType r9 = r4.getType();
        Intrinsics.checkNotNullExpressionValue(r9, "type");
        return new TypeArgument(r5, r8, r9);
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public static final TypeProjection approximateCapturedTypesIfNecessary(TypeProjection r3, boolean r4) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.isStarProjection() == false) goto L8;
        return r3;
    L8:
        KotlinType r0 = r3.getType();
        Intrinsics.checkNotNullExpressionValue(r0, "typeProjection.type");
        if (TypeUtils.contains(r0, AnonymousClass1.INSTANCE) == true) goto L11;
        return r3;
    L11:
        Variance r1 = r3.getProjectionKind();
        Intrinsics.checkNotNullExpressionValue(r1, "typeProjection.projectionKind");
        if (r1 == Variance.OUT_VARIANCE) goto L14;
        if (r4 == false) goto L19;
        return new TypeProjectionImpl(r1, approximateCapturedTypes(r0).getLower());
    L19:
        return substituteCapturedTypesWithProjections(r3);
    L14:
        return new TypeProjectionImpl(r1, approximateCapturedTypes(r0).getUpper());
    }

    private static final TypeProjection substituteCapturedTypesWithProjections(TypeProjection r2) {
        TypeSubstitutor r0 = TypeSubstitutor.create(new CapturedTypeApproximationKt$substituteCapturedTypesWithProjections$typeSubstitutor$1());
        Intrinsics.checkNotNullExpressionValue(r0, "create(object : TypeCons…ojection\n        }\n    })");
        return r0.substituteWithoutApproximation(r2);
    }

    public static final ApproximationBounds<KotlinType> approximateCapturedTypes(KotlinType r7) {
        Intrinsics.checkNotNullParameter(r7, "type");
        if (FlexibleTypesKt.isFlexible(r7) == false) goto L6;
        ApproximationBounds<KotlinType> r0 = approximateCapturedTypes(FlexibleTypesKt.lowerIfFlexible(r7));
        ApproximationBounds<KotlinType> r1 = approximateCapturedTypes(FlexibleTypesKt.upperIfFlexible(r7));
        return new ApproximationBounds(TypeWithEnhancementKt.inheritEnhancement(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(r0.getLower()), FlexibleTypesKt.upperIfFlexible(r1.getLower())), r7), TypeWithEnhancementKt.inheritEnhancement(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(r0.getUpper()), FlexibleTypesKt.upperIfFlexible(r1.getUpper())), r7));
    L6:
        TypeConstructor r2 = r7.getConstructor();
        if (CapturedTypeConstructorKt.isCaptured(r7) == false) goto L18;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.calls.inference.CapturedTypeConstructor");
        TypeProjection r3 = ((CapturedTypeConstructor) r2).getProjection();
        KotlinType r4 = r3.getType();
        Intrinsics.checkNotNullExpressionValue(r4, "typeProjection.type");
        KotlinType r5 = approximateCapturedTypes$makeNullableIfNeeded(r4, r7);
        int r6 = WhenMappings.$EnumSwitchMapping$0[r3.getProjectionKind().ordinal()];
        if (r6 != 2) goto L11;
        SimpleType r8 = TypeUtilsKt.getBuiltIns(r7).getNullableAnyType();
        Intrinsics.checkNotNullExpressionValue(r8, "type.builtIns.nullableAnyType");
        return new ApproximationBounds(r5, r8);
    L11:
        if (r6 != 3) goto L14;
        SimpleType r9 = TypeUtilsKt.getBuiltIns(r7).getNothingType();
        Intrinsics.checkNotNullExpressionValue(r9, "type.builtIns.nothingType");
        return new ApproximationBounds(approximateCapturedTypes$makeNullableIfNeeded(r9, r7), r5);
    L14:
        throw new AssertionError("Only nontrivial projections should have been captured, not: " + r3);
    L18:
        if (r7.getArguments().isEmpty() == true) goto L47;
        if (r7.getArguments().size() != r2.getParameters().size()) goto L47;
        ArrayList r10 = new ArrayList();
        ArrayList r11 = new ArrayList();
        List<TypeProjection> r12 = r7.getArguments();
        List<TypeParameterDescriptor> r13 = r2.getParameters();
        Intrinsics.checkNotNullExpressionValue(r13, "typeConstructor.parameters");
        Iterator r14 = CollectionsKt.zip(r12, r13).iterator();
    L24:
        if (r14.hasNext() == false) goto L29;
        Pair r15 = (Pair) r14.next();
        TypeProjection r16 = (TypeProjection) r15.component1();
        TypeParameterDescriptor r17 = (TypeParameterDescriptor) r15.component2();
        Intrinsics.checkNotNullExpressionValue(r17, "typeParameter");
        TypeArgument r18 = toTypeArgument(r16, r17);
        if (r16.isStarProjection() == true) goto L27;
        ApproximationBounds<TypeArgument> r19 = approximateProjection(r18);
        TypeArgument r20 = r19.component1();
        TypeArgument r21 = r19.component2();
        r10.add(r20);
        r11.add(r21);
        goto L24
    L27:
        r10.add(r18);
        r11.add(r18);
        goto L24
    L29:
        ArrayList r22 = r10;
        boolean r23 = false;
        if ((r22 instanceof Collection) == true) goto L32;
    L34:
        Iterator r24 = r22.iterator();
    L36:
        if (r24.hasNext() == false) goto L41;
        if ((!((TypeArgument) r24.next()).isConsistent()) == false) goto L36;
        r23 = true;
    L41:
        if (r23 == false) goto L43;
        SimpleType r25 = TypeUtilsKt.getBuiltIns(r7).getNothingType();
        Intrinsics.checkNotNullExpressionValue(r25, "type.builtIns.nothingType");
        SimpleType r26 = r25;
    L45:
        return new ApproximationBounds(r26, replaceTypeArguments(r7, r11));
    L43:
        r26 = replaceTypeArguments(r7, r10);
        goto L45
    L32:
        if (r22.isEmpty() == false) goto L34;
    L47:
        return new ApproximationBounds(r7, r7);
    }

    private static final KotlinType approximateCapturedTypes$makeNullableIfNeeded(KotlinType r0, KotlinType r1) {
        KotlinType r2 = TypeUtils.makeNullableIfNeeded(r0, r1.isMarkedNullable());
        Intrinsics.checkNotNullExpressionValue(r2, "makeNullableIfNeeded(this, type.isMarkedNullable)");
        return r2;
    }

    private static final KotlinType replaceTypeArguments(KotlinType r8, List<TypeArgument> r9) {
        r8.getArguments().size();
        r9.size();
        List<TypeArgument> r10 = r9;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        r0.add(toTypeProjection((TypeArgument) r11.next()));
        goto L4
    L7:
        return TypeSubstitutionKt.replace$default(r8, r0, null, null, 6, null);
    }

    private static final ApproximationBounds<TypeArgument> approximateProjection(TypeArgument r7) {
        ApproximationBounds<KotlinType> r0 = approximateCapturedTypes(r7.getInProjection());
        KotlinType r1 = r0.component1();
        KotlinType r2 = r0.component2();
        ApproximationBounds<KotlinType> r3 = approximateCapturedTypes(r7.getOutProjection());
        KotlinType r4 = r3.component1();
        KotlinType r5 = r3.component2();
        return new ApproximationBounds(new TypeArgument(r7.getTypeParameter(), r2, r4), new TypeArgument(r7.getTypeParameter(), r1, r5));
    }
}
