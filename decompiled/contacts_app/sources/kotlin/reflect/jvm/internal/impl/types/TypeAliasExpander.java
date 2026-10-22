package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: compiled from: TypeAliasExpander.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TypeAliasExpander {
    public static final Companion Companion = null;
    private static final TypeAliasExpander NON_REPORTING = null;
    private final TypeAliasExpansionReportStrategy reportStrategy;
    private final boolean shouldCheckBounds;

    /* JADX INFO: compiled from: TypeAliasExpander.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static final /* synthetic */ void access$assertRecursionDepth(Companion r0, int r1, TypeAliasDescriptor r2) {
            r0.assertRecursionDepth(r1, r2);
        }

        private final void assertRecursionDepth(int r2, TypeAliasDescriptor r3) {
            if (r2 > 100) goto L6;
            return;
        L6:
            throw new AssertionError("Too deep recursion while expanding type alias " + r3.getName());
        }
    }

    public TypeAliasExpander(TypeAliasExpansionReportStrategy r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "reportStrategy");
        this.reportStrategy = r2;
        this.shouldCheckBounds = r3;
    }

    public final SimpleType expand(TypeAliasExpansion r8, TypeAttributes r9) {
        Intrinsics.checkNotNullParameter(r8, "typeAliasExpansion");
        Intrinsics.checkNotNullParameter(r9, "attributes");
        return expandRecursively(r8, r9, false, 0, true);
    }

    private final SimpleType expandRecursively(TypeAliasExpansion r4, TypeAttributes r5, boolean r6, int r7, boolean r8) {
        TypeProjection r9 = expandTypeProjection(new TypeProjectionImpl(Variance.INVARIANT, r4.getDescriptor().getUnderlyingType()), r4, null, r7);
        KotlinType r0 = r9.getType();
        Intrinsics.checkNotNullExpressionValue(r0, "expandedProjection.type");
        SimpleType r1 = TypeSubstitutionKt.asSimpleType(r0);
        if (KotlinTypeKt.isError(r1) == false) goto L5;
        return r1;
    L5:
        r9.getProjectionKind();
        Variance r10 = Variance.INVARIANT;
        checkRepeatedAnnotations(r1.getAnnotations(), AnnotationsTypeAttributeKt.getAnnotations(r5));
        SimpleType r11 = TypeUtils.makeNullableIfNeeded(combineAttributes(r1, r5), r6);
        Intrinsics.checkNotNullExpressionValue(r11, "expandedType.combineAttr…fNeeded(it, isNullable) }");
        if (r8 == true) goto L8;
        return r11;
    L8:
        return SpecialTypesKt.withAbbreviation(r11, createAbbreviation(r4, r5, r6));
    }

    private final SimpleType createAbbreviation(TypeAliasExpansion r2, TypeAttributes r3, boolean r4) {
        TypeConstructor r1 = r2.getDescriptor().getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(r1, "descriptor.typeConstructor");
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(r3, r1, r2.getArguments(), r4, MemberScope.Empty.INSTANCE);
    }

    private final TypeProjection expandTypeProjection(TypeProjection r5, TypeAliasExpansion r6, TypeParameterDescriptor r7, int r8) {
        Companion.access$assertRecursionDepth(Companion, r8, r6.getDescriptor());
        if (r5.isStarProjection() == false) goto L6;
        Intrinsics.checkNotNull(r7);
        TypeProjection r4 = TypeUtils.makeStarProjection(r7);
        Intrinsics.checkNotNullExpressionValue(r4, "makeStarProjection(typeParameterDescriptor!!)");
        return r4;
    L6:
        KotlinType r0 = r5.getType();
        Intrinsics.checkNotNullExpressionValue(r0, "underlyingProjection.type");
        TypeProjection r2 = r6.getReplacement(r0.getConstructor());
        if (r2 != null) goto L11;
        return expandNonArgumentTypeProjection(r5, r6, r8);
    L11:
        if (r2.isStarProjection() == false) goto L14;
        Intrinsics.checkNotNull(r7);
        TypeProjection r9 = TypeUtils.makeStarProjection(r7);
        Intrinsics.checkNotNullExpressionValue(r9, "makeStarProjection(typeParameterDescriptor!!)");
        return r9;
    L14:
        UnwrappedType r10 = r2.getType().unwrap();
        Variance r1 = r2.getProjectionKind();
        Intrinsics.checkNotNullExpressionValue(r1, "argument.projectionKind");
        Variance r11 = r5.getProjectionKind();
        Intrinsics.checkNotNullExpressionValue(r11, "underlyingProjection.projectionKind");
        if (r11 != r1) goto L18;
    L24:
        if (r7 == null) goto L27;
        Variance r12 = r7.getVariance();
        if (r12 == null) goto L27;
    L28:
        Intrinsics.checkNotNullExpressionValue(r12, "typeParameterDescriptor?…nce ?: Variance.INVARIANT");
        if (r12 != r1) goto L32;
    L38:
        checkRepeatedAnnotations(r0.getAnnotations(), r10.getAnnotations());
        if ((r10 instanceof DynamicType) == false) goto L41;
        SimpleType r13 = combineAttributes((DynamicType) r10, r0.getAttributes());
    L43:
        return new TypeProjectionImpl(r1, r13);
    L41:
        r13 = combineNullabilityAndAnnotations(TypeSubstitutionKt.asSimpleType(r10), r0);
        goto L43
    L32:
        if (r12 == Variance.INVARIANT) goto L38;
        if (r1 != Variance.INVARIANT) goto L37;
        r1 = Variance.INVARIANT;
        goto L38
    L37:
        this.reportStrategy.conflictingProjection(r6.getDescriptor(), r7, r10);
    L27:
        r12 = Variance.INVARIANT;
        goto L28
    L18:
        if (r11 == Variance.INVARIANT) goto L24;
        if (r1 != Variance.INVARIANT) goto L23;
        r1 = r11;
        goto L24
    L23:
        this.reportStrategy.conflictingProjection(r6.getDescriptor(), r7, r10);
        goto L24
    }

    private final DynamicType combineAttributes(DynamicType r2, TypeAttributes r3) {
        return r2.replaceAttributes(createdCombinedAttributes(r2, r3));
    }

    private final SimpleType combineAttributes(SimpleType r3, TypeAttributes r4) {
        SimpleType r0 = r3;
        if (KotlinTypeKt.isError(r0) == false) goto L6;
        return r3;
    L6:
        return TypeSubstitutionKt.replace$default(r3, null, createdCombinedAttributes(r0, r4), 1, null);
    }

    private final TypeAttributes createdCombinedAttributes(KotlinType r1, TypeAttributes r2) {
        if (KotlinTypeKt.isError(r1) == false) goto L7;
        return r1.getAttributes();
    L7:
        return r2.add(r1.getAttributes());
    }

    private final void checkRepeatedAnnotations(Annotations r3, Annotations r4) {
        HashSet r0 = new HashSet();
        Iterator<AnnotationDescriptor> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r0.add(r5.next().getFqName());
        goto L4
    L6:
        HashSet r1 = r0;
        Iterator<AnnotationDescriptor> r6 = r4.iterator();
    L8:
        if (r6.hasNext() == false) goto L12;
        AnnotationDescriptor r7 = r6.next();
        if (r1.contains(r7.getFqName()) == false) goto L8;
        this.reportStrategy.repeatedAnnotation(r7);
        goto L8
    }

    private final SimpleType combineNullability(SimpleType r1, KotlinType r2) {
        SimpleType r0 = TypeUtils.makeNullableIfNeeded(r1, r2.isMarkedNullable());
        Intrinsics.checkNotNullExpressionValue(r0, "makeNullableIfNeeded(thi…romType.isMarkedNullable)");
        return r0;
    }

    private final SimpleType combineNullabilityAndAnnotations(SimpleType r1, KotlinType r2) {
        return combineAttributes(combineNullability(r1, r2), r2.getAttributes());
    }

    private final TypeProjection expandNonArgumentTypeProjection(TypeProjection r13, TypeAliasExpansion r14, int r15) {
        UnwrappedType r0 = r13.getType().unwrap();
        if (DynamicTypesKt.isDynamic(r0) == false) goto L5;
        return r13;
    L5:
        SimpleType r1 = TypeSubstitutionKt.asSimpleType(r0);
        SimpleType r2 = r1;
        if (KotlinTypeKt.isError(r2) == false) goto L8;
        return r13;
    L8:
        if (TypeUtilsKt.requiresTypeAliasExpansion(r2) == false) goto L38;
        TypeConstructor r3 = r1.getConstructor();
        ClassifierDescriptor r4 = r3.mo2083getDeclarationDescriptor();
        r3.getParameters().size();
        r1.getArguments().size();
        if ((r4 instanceof TypeParameterDescriptor) == false) goto L14;
        return r13;
    L14:
        if ((r4 instanceof TypeAliasDescriptor) == false) goto L31;
        TypeAliasDescriptor r5 = (TypeAliasDescriptor) r4;
        int r6 = 0;
        if (r14.isRecursion(r5) == false) goto L19;
        this.reportStrategy.recursiveTypeAlias(r5);
        Variance r16 = Variance.INVARIANT;
        ErrorTypeKind r17 = ErrorTypeKind.RECURSIVE_TYPE_ALIAS;
        String r7 = r5.getName().toString();
        Intrinsics.checkNotNullExpressionValue(r7, "typeDescriptor.name.toString()");
        return new TypeProjectionImpl(r16, ErrorUtils.createErrorType(r17, new String[]{r7}));
    L19:
        List<TypeProjection> r8 = r1.getArguments();
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r10 = r8.iterator();
    L21:
        if (r10.hasNext() == false) goto L26;
        Object r11 = r10.next();
        int r12 = r6 + 1;
        if (r6 >= 0) goto L25;
        CollectionsKt.throwIndexOverflow();
    L25:
        r9.add(expandTypeProjection((TypeProjection) r11, r14, r3.getParameters().get(r6), r15 + 1));
        r6 = r12;
        goto L21
    L26:
        SimpleType r18 = expandRecursively(TypeAliasExpansion.Companion.create(r14, r5, r9), r1.getAttributes(), r1.isMarkedNullable(), r15 + 1, false);
        SimpleType r19 = substituteArguments(r1, r14, r15);
        if (DynamicTypesKt.isDynamic(r18) == true) goto L37;
        r18 = SpecialTypesKt.withAbbreviation(r18, r19);
    L37:
        return new TypeProjectionImpl(r13.getProjectionKind(), r18);
    L31:
        SimpleType r110 = substituteArguments(r1, r14, r15);
        checkTypeArgumentsSubstitution(r2, r110);
        return new TypeProjectionImpl(r13.getProjectionKind(), r110);
    L38:
        return r13;
    }

    private final SimpleType substituteArguments(SimpleType r9, TypeAliasExpansion r10, int r11) {
        TypeConstructor r0 = r9.getConstructor();
        List<TypeProjection> r1 = r9.getArguments();
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
        int r4 = 0;
    L4:
        if (r3.hasNext() == false) goto L14;
        Object r5 = r3.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        TypeProjection r7 = (TypeProjection) r5;
        TypeProjectionImpl r8 = expandTypeProjection(r7, r10, r0.getParameters().get(r4), r11 + 1);
        if (r8.isStarProjection() == true) goto L12;
        r8 = new TypeProjectionImpl(r8.getProjectionKind(), TypeUtils.makeNullableIfNeeded(r8.getType(), r7.getType().isMarkedNullable()));
    L12:
        r2.add(r8);
        r4 = r6;
        goto L4
    L14:
        return TypeSubstitutionKt.replace$default(r9, r2, null, 2, null);
    }

    private final void checkTypeArgumentsSubstitution(KotlinType r9, KotlinType r10) {
        TypeSubstitutor r0 = TypeSubstitutor.create(r10);
        Intrinsics.checkNotNullExpressionValue(r0, "create(substitutedType)");
        Iterator<T> r11 = r10.getArguments().iterator();
        int r1 = 0;
    L4:
        if (r11.hasNext() == false) goto L16;
        Object r2 = r11.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        TypeProjection r4 = (TypeProjection) r2;
        if (r4.isStarProjection() == true) goto L15;
        KotlinType r5 = r4.getType();
        Intrinsics.checkNotNullExpressionValue(r5, "substitutedArgument.type");
        if (TypeUtilsKt.containsTypeAliasParameters(r5) == true) goto L15;
        TypeProjection r6 = r9.getArguments().get(r1);
        TypeParameterDescriptor r7 = r9.getConstructor().getParameters().get(r1);
        if (this.shouldCheckBounds == false) goto L15;
        TypeAliasExpansionReportStrategy r8 = this.reportStrategy;
        KotlinType r12 = r6.getType();
        Intrinsics.checkNotNullExpressionValue(r12, "unsubstitutedArgument.type");
        KotlinType r13 = r4.getType();
        Intrinsics.checkNotNullExpressionValue(r13, "substitutedArgument.type");
        Intrinsics.checkNotNullExpressionValue(r7, "typeParameter");
        r8.boundsViolationInSubstitution(r0, r12, r13, r7);
    L15:
        r1 = r3;
        goto L4
    }

    static {
        Companion = new Companion(null);
        NON_REPORTING = new TypeAliasExpander(TypeAliasExpansionReportStrategy.DO_NOTHING.INSTANCE, false);
    }
}
