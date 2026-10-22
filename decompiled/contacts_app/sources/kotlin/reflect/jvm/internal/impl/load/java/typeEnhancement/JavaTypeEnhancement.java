package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: compiled from: typeEnhancement.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JavaTypeEnhancement {
    private final JavaResolverSettings javaResolverSettings;

    /* JADX INFO: compiled from: typeEnhancement.kt */
    private static final class Result {
        private final int subtreeSize;
        private final KotlinType type;

        public Result(KotlinType r1, int r2) {
            this.type = r1;
            this.subtreeSize = r2;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        public final KotlinType getType() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: typeEnhancement.kt */
    private static final class SimpleResult {
        private final boolean forWarnings;
        private final int subtreeSize;
        private final SimpleType type;

        public SimpleResult(SimpleType r1, int r2, boolean r3) {
            this.type = r1;
            this.subtreeSize = r2;
            this.forWarnings = r3;
        }

        public final boolean getForWarnings() {
            return this.forWarnings;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        public final SimpleType getType() {
            return this.type;
        }
    }

    public JavaTypeEnhancement(JavaResolverSettings r2) {
        Intrinsics.checkNotNullParameter(r2, "javaResolverSettings");
        this.javaResolverSettings = r2;
    }

    public final KotlinType enhance(KotlinType r2, Function1<? super Integer, JavaTypeQualifiers> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "qualifiers");
        return enhancePossiblyFlexible(r2.unwrap(), r3, 0, r4).getType();
    }

    private final Result enhancePossiblyFlexible(UnwrappedType r12, Function1<? super Integer, JavaTypeQualifiers> r13, int r14, boolean r15) {
        RawTypeImpl r1 = null;
        if (KotlinTypeKt.isError(r12) == false) goto L7;
        return new Result(null, 1);
    L7:
        if ((r12 instanceof FlexibleType) == false) goto L44;
        boolean r0 = r12 instanceof RawType;
        FlexibleType r9 = (FlexibleType) r12;
        SimpleResult r10 = enhanceInflexible(r9.getLowerBound(), r13, r14, TypeComponentPosition.FLEXIBLE_LOWER, r0, r15);
        SimpleResult r11 = enhanceInflexible(r9.getUpperBound(), r13, r14, TypeComponentPosition.FLEXIBLE_UPPER, r0, r15);
        r10.getSubtreeSize();
        r11.getSubtreeSize();
        if (r10.getType() != null) goto L14;
        if (r11.getType() != null) goto L14;
    L53:
        return new Result(r1, r10.getSubtreeSize());
    L14:
        if (r10.getForWarnings() == false) goto L16;
    L33:
        SimpleType r16 = r11.getType();
        if (r16 == null) goto L40;
        SimpleType r17 = r10.getType();
        if (r17 != null) goto L38;
        r17 = r16;
    L38:
        SimpleType r18 = KotlinTypeFactory.flexibleType(r17, r16);
        if (r18 == null) goto L40;
    L41:
        r1 = TypeWithEnhancementKt.wrapEnhancement(r12, r18);
    L40:
        SimpleType r19 = r10.getType();
        Intrinsics.checkNotNull(r19);
        r18 = r19;
        goto L41
    L16:
        if (r11.getForWarnings() == true) goto L33;
        if (r0 == false) goto L26;
        SimpleType r110 = r10.getType();
        if (r110 != null) goto L22;
        r110 = r9.getLowerBound();
    L22:
        SimpleType r111 = r11.getType();
        if (r111 != null) goto L25;
        r111 = r9.getUpperBound();
    L25:
        r1 = new RawTypeImpl(r110, r111);
        goto L53
    L26:
        SimpleType r112 = r10.getType();
        if (r112 != null) goto L29;
        r112 = r9.getLowerBound();
    L29:
        SimpleType r113 = r11.getType();
        if (r113 != null) goto L32;
        r113 = r9.getUpperBound();
    L32:
        r1 = KotlinTypeFactory.flexibleType(r112, r113);
        goto L53
    L44:
        if ((r12 instanceof SimpleType) == false) goto L52;
        SimpleResult r114 = enhanceInflexible$default(this, (SimpleType) r12, r13, r14, TypeComponentPosition.INFLEXIBLE, false, r15, 8, null);
        if (r114.getForWarnings() == false) goto L48;
        SimpleType r115 = TypeWithEnhancementKt.wrapEnhancement(r12, r114.getType());
    L50:
        return new Result(r115, r114.getSubtreeSize());
    L48:
        r115 = r114.getType();
        goto L50
    L52:
        throw new NoWhenBranchMatchedException();
    }

    static /* synthetic */ SimpleResult enhanceInflexible$default(JavaTypeEnhancement r9, SimpleType r10, Function1 r11, int r12, TypeComponentPosition r13, boolean r14, boolean r15, int r16, Object r17) {
        if ((r16 & 8) == 0) goto L5;
        boolean r7 = false;
    L7:
        if ((r16 & 16) == 0) goto L9;
        boolean r8 = false;
    L11:
        return r9.enhanceInflexible(r10, r11, r12, r13, r7, r8);
    L9:
        r8 = r15;
        goto L11
    L5:
        r7 = r14;
        goto L7
    }

    private final SimpleResult enhanceInflexible(SimpleType r19, Function1<? super Integer, JavaTypeQualifiers> r20, int r21, TypeComponentPosition r22, boolean r23, boolean r24) {
        Function1<? super Integer, JavaTypeQualifiers> r1 = r20;
        boolean r4 = TypeComponentPositionKt.shouldEnhance(r22);
        if (r24 == false) goto L7;
        if (r23 == false) goto L7;
        boolean r7 = false;
    L8:
        KotlinType r8 = null;
        if (r4 == false) goto L11;
    L14:
        ClassifierDescriptor r5 = r19.getConstructor().mo2083getDeclarationDescriptor();
        if (r5 == null) goto L17;
        JavaTypeQualifiers r9 = r1.invoke(Integer.valueOf(r21));
        ClassifierDescriptor r6 = TypeEnhancementKt.access$enhanceMutability(r5, r9, r22);
        Boolean r2 = TypeEnhancementKt.access$getEnhancedNullability(r9, r22);
        if (r6 == null) goto L22;
        TypeConstructor r10 = r6.getTypeConstructor();
        if (r10 == null) goto L22;
    L23:
        TypeConstructor r12 = r10;
        Intrinsics.checkNotNullExpressionValue(r12, "enhancedClassifier?.typeConstructor ?: constructor");
        int r11 = r21 + 1;
        List<TypeProjection> r13 = r19.getArguments();
        List<TypeParameterDescriptor> r14 = r12.getParameters();
        Intrinsics.checkNotNullExpressionValue(r14, "typeConstructor.parameters");
        List<TypeParameterDescriptor> r15 = r14;
        Iterator<T> r16 = r13.iterator();
        Iterator<T> r17 = r15.iterator();
        ArrayList r18 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(r13, 10), CollectionsKt.collectionSizeOrDefault(r15, 10)));
    L25:
        if (r16.hasNext() == false) goto L49;
        if (r17.hasNext() == false) goto L49;
        Object r110 = r16.next();
        TypeParameterDescriptor r111 = (TypeParameterDescriptor) r17.next();
        TypeProjection r112 = (TypeProjection) r110;
        if (r7 == true) goto L31;
        boolean r25 = r7;
        Result r26 = new Result(r8, 0);
    L38:
        r11 = r11 + r26.getSubtreeSize();
        if (r26.getType() == null) goto L41;
        KotlinType r3 = r26.getType();
        Variance r27 = r112.getProjectionKind();
        Intrinsics.checkNotNullExpressionValue(r27, "arg.projectionKind");
        TypeProjection r28 = TypeUtilsKt.createProjection(r3, r27, r111);
    L48:
        r18.add(r28);
        r1 = r20;
        r7 = r25;
        r8 = null;
        goto L25
    L41:
        if (r6 != null) goto L43;
    L45:
        if (r6 == null) goto L47;
        r28 = TypeUtils.makeStarProjection(r111);
        goto L48
    L47:
        r28 = null;
        goto L48
    L43:
        if (r112.isStarProjection() == true) goto L45;
        KotlinType r29 = r112.getType();
        Intrinsics.checkNotNullExpressionValue(r29, "arg.type");
        Variance r30 = r112.getProjectionKind();
        Intrinsics.checkNotNullExpressionValue(r30, "arg.projectionKind");
        r28 = TypeUtilsKt.createProjection(r29, r30, r111);
        goto L48
    L31:
        r25 = r7;
        if (r112.isStarProjection() == true) goto L35;
        r26 = enhancePossiblyFlexible(r112.getType().unwrap(), r1, r11, r24);
        goto L38
    L35:
        if (r1.invoke(Integer.valueOf(r11)).getNullability() != NullabilityQualifier.FORCE_FLEXIBILITY) goto L37;
        UnwrappedType r31 = r112.getType().unwrap();
        r26 = new Result(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(r31).makeNullableAsSpecified(false), FlexibleTypesKt.upperIfFlexible(r31).makeNullableAsSpecified(true)), 1);
        goto L38
    L37:
        r26 = new Result(null, 1);
    L49:
        ArrayList r32 = r18;
        int r113 = r11 - r21;
        if (r6 != null) goto L69;
        if (r2 != null) goto L69;
        ArrayList r33 = r32;
        if ((r33 instanceof Collection) == true) goto L55;
    L57:
        Iterator r34 = r33.iterator();
    L59:
        if (r34.hasNext() == false) goto L56;
        if (((TypeProjection) r34.next()) != null) goto L63;
        boolean r35 = true;
    L64:
        if (r35 == true) goto L59;
        boolean r36 = false;
    L66:
        if (r36 == false) goto L69;
        return new SimpleResult(null, r113, false);
    L63:
        r35 = false;
    L56:
        r36 = true;
        goto L66
    L55:
        if (r33.isEmpty() == false) goto L57;
    L69:
        Annotations[] r37 = new Annotations[3];
        r37[0] = r19.getAnnotations();
        EnhancedTypeAnnotations r38 = TypeEnhancementKt.access$getENHANCED_MUTABILITY_ANNOTATIONS$p();
        if (r6 == null) goto L72;
        boolean r39 = true;
    L73:
        if (r39 == true) goto L76;
        r38 = null;
    L76:
        r37[1] = r38;
        EnhancedTypeAnnotations r40 = TypeEnhancementKt.access$getENHANCED_NULLABILITY_ANNOTATIONS$p();
        if (r2 == null) goto L79;
        boolean r41 = true;
    L80:
        if (r41 == false) goto L82;
        EnhancedTypeAnnotations r42 = r40;
    L83:
        r37[2] = r42;
        TypeAttributes r114 = TypeAttributesKt.toDefaultAttributes(TypeEnhancementKt.access$compositeAnnotationsOrSingle(CollectionsKt.listOfNotNull(r37)));
        ArrayList r43 = r32;
        List<TypeProjection> r44 = r19.getArguments();
        Iterator r45 = r43.iterator();
        Iterator<T> r46 = r44.iterator();
        ArrayList r47 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(r43, 10), CollectionsKt.collectionSizeOrDefault(r44, 10)));
    L85:
        if (r45.hasNext() == false) goto L93;
        if (r46.hasNext() == false) goto L93;
        Object r48 = r45.next();
        TypeProjection r49 = (TypeProjection) r46.next();
        TypeProjection r50 = (TypeProjection) r48;
        if (r50 == null) goto L92;
        r49 = r50;
    L92:
        r47.add(r49);
    L93:
        ArrayList r115 = r47;
        if (r2 == null) goto L96;
        boolean r51 = r2.booleanValue();
    L97:
        SimpleType r52 = KotlinTypeFactory.simpleType$default(r114, r12, r115, r51, null, 16, null);
        if (r9.getDefinitelyNotNull() == false) goto L100;
        r52 = notNullTypeParameter(r52);
    L100:
        if (r2 != null) goto L102;
    L104:
        boolean r53 = false;
    L106:
        return new SimpleResult(r52, r113, r53);
    L102:
        if (r9.isNullabilityQualifierForWarning() == false) goto L104;
        r53 = true;
        goto L106
    L96:
        r51 = r19.isMarkedNullable();
        goto L97
    L82:
        r42 = null;
        goto L83
    L79:
        r41 = false;
        goto L80
    L72:
        r39 = false;
    L22:
        r10 = r19.getConstructor();
        goto L23
    L17:
        return new SimpleResult(null, 1, false);
    L11:
        if (r19.getArguments().isEmpty() == false) goto L14;
        return new SimpleResult(null, 1, false);
    L7:
        r7 = true;
        goto L8
    }

    private final SimpleType notNullTypeParameter(SimpleType r1) {
        if (this.javaResolverSettings.getCorrectNullabilityForNotNullTypeParameter() == false) goto L6;
        return SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull(r1, true);
    L6:
        return new NotNullTypeParameterImpl(r1);
    }
}
