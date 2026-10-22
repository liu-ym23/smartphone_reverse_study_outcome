package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.types.checker.IntersectionTypeKt;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: compiled from: TypeParameterUpperBoundEraser.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TypeParameterUpperBoundEraser {
    public static final Companion Companion = null;
    private final Lazy erroneousErasedBound$delegate;
    private final MemoizedFunctionToNotNull<DataToEraseUpperBound, KotlinType> getErasedUpperBound;
    private final TypeParameterErasureOptions options;
    private final ErasureProjectionComputer projectionComputer;
    private final LockBasedStorageManager storage;

    /* JADX INFO: compiled from: TypeParameterUpperBoundEraser.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final KotlinType replaceArgumentsOfUpperBound(KotlinType r17, TypeSubstitutor r18, Set<? extends TypeParameterDescriptor> r19, boolean r20) {
            Intrinsics.checkNotNullParameter(r17, "<this>");
            Intrinsics.checkNotNullParameter(r18, "substitutor");
            UnwrappedType r2 = r17.unwrap();
            if ((r2 instanceof FlexibleType) == false) goto L68;
            FlexibleType r4 = (FlexibleType) r2;
            SimpleType r13 = r4.getLowerBound();
            if (r13.getConstructor().getParameters().isEmpty() == false) goto L7;
        L35:
            SimpleType r5 = r4.getUpperBound();
            if (r5.getConstructor().getParameters().isEmpty() == false) goto L38;
        L66:
            SimpleType r1 = KotlinTypeFactory.flexibleType(r13, r5);
        L101:
            KotlinType r0 = r18.safeSubstitute(TypeWithEnhancementKt.inheritEnhancement(r1, r2), Variance.OUT_VARIANCE);
            Intrinsics.checkNotNullExpressionValue(r0, "substitutor.safeSubstitu…s, Variance.OUT_VARIANCE)");
            return r0;
        L38:
            if (r5.getConstructor().mo2083getDeclarationDescriptor() == null) goto L66;
            List<TypeParameterDescriptor> r7 = r5.getConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(r7, "constructor.parameters");
            List<TypeParameterDescriptor> r8 = r7;
            ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
            Iterator<T> r10 = r8.iterator();
        L42:
            if (r10.hasNext() == false) goto L65;
            TypeParameterDescriptor r11 = (TypeParameterDescriptor) r10.next();
            StarProjectionImpl r12 = (TypeProjection) CollectionsKt.getOrNull(r17.getArguments(), r11.getIndex());
            if (r20 == false) goto L54;
            if (r12 == null) goto L51;
            KotlinType r14 = r12.getType();
            if (r14 == null) goto L51;
            Intrinsics.checkNotNullExpressionValue(r14, "type");
            if (TypeUtilsKt.containsTypeParameter(r14) == true) goto L51;
            boolean r15 = true;
        L52:
            if (r15 == false) goto L54;
        L64:
            r9.add(r12);
        L51:
            r15 = false;
        L54:
            if (r19 != null) goto L56;
        L58:
            boolean r16 = false;
        L59:
            if (r12 == null) goto L63;
            if (r16 == true) goto L63;
            TypeSubstitution r110 = r18.getSubstitution();
            KotlinType r111 = r12.getType();
            Intrinsics.checkNotNullExpressionValue(r111, "argument.type");
            if (r110.mo2088get(r111) != null) goto L64;
        L63:
            r12 = new StarProjectionImpl(r11);
            goto L64
        L56:
            if (r19.contains(r11) == false) goto L58;
            r16 = true;
            goto L59
        L65:
            r5 = TypeSubstitutionKt.replace$default(r5, r9, null, 2, null);
            goto L66
        L7:
            if (r13.getConstructor().mo2083getDeclarationDescriptor() == null) goto L35;
            List<TypeParameterDescriptor> r112 = r13.getConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(r112, "constructor.parameters");
            List<TypeParameterDescriptor> r113 = r112;
            ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
            Iterator<T> r115 = r113.iterator();
        L11:
            if (r115.hasNext() == false) goto L34;
            TypeParameterDescriptor r116 = (TypeParameterDescriptor) r115.next();
            TypeProjection r21 = (TypeProjection) CollectionsKt.getOrNull(r17.getArguments(), r116.getIndex());
            if (r20 == false) goto L23;
            if (r21 == null) goto L20;
            KotlinType r117 = r21.getType();
            if (r117 == null) goto L20;
            Intrinsics.checkNotNullExpressionValue(r117, "type");
            if (TypeUtilsKt.containsTypeParameter(r117) == true) goto L20;
            boolean r118 = true;
        L21:
            if (r118 == false) goto L23;
        L33:
            r114.add(r21);
        L20:
            r118 = false;
        L23:
            if (r19 != null) goto L25;
        L27:
            boolean r119 = false;
        L28:
            if (r21 == null) goto L32;
            if (r119 == true) goto L32;
            TypeSubstitution r120 = r18.getSubstitution();
            KotlinType r22 = r21.getType();
            Intrinsics.checkNotNullExpressionValue(r22, "argument.type");
            if (r120.mo2088get(r22) != null) goto L33;
        L32:
            r21 = new StarProjectionImpl(r116);
            goto L33
        L25:
            if (r19.contains(r116) == false) goto L27;
            r119 = true;
            goto L28
        L34:
            r13 = TypeSubstitutionKt.replace$default(r13, r114, null, 2, null);
            goto L35
        L68:
            if ((r2 instanceof SimpleType) == false) goto L104;
            SimpleType r6 = (SimpleType) r2;
            if (r6.getConstructor().getParameters().isEmpty() == false) goto L72;
        L100:
            r1 = r6;
            goto L101
        L72:
            if (r6.getConstructor().mo2083getDeclarationDescriptor() == null) goto L100;
            List<TypeParameterDescriptor> r23 = r6.getConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(r23, "constructor.parameters");
            List<TypeParameterDescriptor> r24 = r23;
            ArrayList r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r24, 10));
            Iterator<T> r26 = r24.iterator();
        L76:
            if (r26.hasNext() == false) goto L99;
            TypeParameterDescriptor r27 = (TypeParameterDescriptor) r26.next();
            StarProjectionImpl r121 = (TypeProjection) CollectionsKt.getOrNull(r17.getArguments(), r27.getIndex());
            if (r20 == false) goto L88;
            if (r121 == null) goto L85;
            KotlinType r122 = r121.getType();
            if (r122 == null) goto L85;
            Intrinsics.checkNotNullExpressionValue(r122, "type");
            if (TypeUtilsKt.containsTypeParameter(r122) == true) goto L85;
            boolean r123 = true;
        L86:
            if (r123 == false) goto L88;
        L98:
            r25.add(r121);
        L85:
            r123 = false;
        L88:
            if (r19 != null) goto L90;
        L92:
            boolean r124 = false;
        L93:
            if (r121 == null) goto L97;
            if (r124 == true) goto L97;
            TypeSubstitution r125 = r18.getSubstitution();
            KotlinType r126 = r121.getType();
            Intrinsics.checkNotNullExpressionValue(r126, "argument.type");
            if (r125.mo2088get(r126) != null) goto L98;
        L97:
            r121 = new StarProjectionImpl(r27);
            goto L98
        L90:
            if (r19.contains(r27) == false) goto L92;
            r124 = true;
            goto L93
        L99:
            r6 = TypeSubstitutionKt.replace$default(r6, r25, null, 2, null);
            goto L100
        L104:
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: TypeParameterUpperBoundEraser.kt */
    private static final class DataToEraseUpperBound {
        private final ErasureTypeAttributes typeAttr;
        private final TypeParameterDescriptor typeParameter;

        public String toString() {
            return "DataToEraseUpperBound(typeParameter=" + this.typeParameter + ", typeAttr=" + this.typeAttr + ')';
        }

        public DataToEraseUpperBound(TypeParameterDescriptor r2, ErasureTypeAttributes r3) {
            Intrinsics.checkNotNullParameter(r2, "typeParameter");
            Intrinsics.checkNotNullParameter(r3, "typeAttr");
            this.typeParameter = r2;
            this.typeAttr = r3;
        }

        public final TypeParameterDescriptor getTypeParameter() {
            return this.typeParameter;
        }

        public final ErasureTypeAttributes getTypeAttr() {
            return this.typeAttr;
        }

        public boolean equals(Object r4) {
            if ((r4 instanceof DataToEraseUpperBound) == true) goto L5;
            return false;
        L5:
            DataToEraseUpperBound r5 = (DataToEraseUpperBound) r4;
            if (Intrinsics.areEqual(r5.typeParameter, this.typeParameter) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(r5.typeAttr, this.typeAttr) == false) goto L12;
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            int r0 = this.typeParameter.hashCode();
            return r0 + ((r0 * 31) + this.typeAttr.hashCode());
        }
    }

    static {
        Companion = new Companion(null);
    }

    public TypeParameterUpperBoundEraser(ErasureProjectionComputer r2, TypeParameterErasureOptions r3) {
        Intrinsics.checkNotNullParameter(r2, "projectionComputer");
        Intrinsics.checkNotNullParameter(r3, "options");
        this.projectionComputer = r2;
        this.options = r3;
        LockBasedStorageManager r4 = new LockBasedStorageManager("Type parameter upper bound erasure results");
        this.storage = r4;
        this.erroneousErasedBound$delegate = LazyKt.lazy(new TypeParameterUpperBoundEraser$erroneousErasedBound$2(this));
        MemoizedFunctionToNotNull<DataToEraseUpperBound, KotlinType> r5 = r4.createMemoizedFunction(new AnonymousClass1(this));
        Intrinsics.checkNotNullExpressionValue(r5, "storage.createMemoizedFu…ameter, typeAttr) }\n    }");
        this.getErasedUpperBound = r5;
    }

    public static final /* synthetic */ KotlinType access$getErasedUpperBoundInternal(TypeParameterUpperBoundEraser r0, TypeParameterDescriptor r1, ErasureTypeAttributes r2) {
        return r0.getErasedUpperBoundInternal(r1, r2);
    }

    public /* synthetic */ TypeParameterUpperBoundEraser(ErasureProjectionComputer r1, TypeParameterErasureOptions r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = new TypeParameterErasureOptions(false, false);
    L5:
        this(r1, r2);
    }

    private final ErrorType getErroneousErasedBound() {
        return (ErrorType) this.erroneousErasedBound$delegate.getValue();
    }

    public final KotlinType getErasedUpperBound(TypeParameterDescriptor r2, ErasureTypeAttributes r3) {
        Intrinsics.checkNotNullParameter(r2, "typeParameter");
        Intrinsics.checkNotNullParameter(r3, "typeAttr");
        KotlinType r1 = this.getErasedUpperBound.invoke(new DataToEraseUpperBound(r2, r3));
        Intrinsics.checkNotNullExpressionValue(r1, "getErasedUpperBound(Data…typeParameter, typeAttr))");
        return r1;
    }

    private final KotlinType getDefaultType(ErasureTypeAttributes r1) {
        SimpleType r2 = r1.getDefaultType();
        if (r2 == null) goto L7;
        KotlinType r3 = TypeUtilsKt.replaceArgumentsWithStarProjections(r2);
        if (r3 == null) goto L7;
        return r3;
    L7:
        return getErroneousErasedBound();
    }

    private final KotlinType getErasedUpperBoundInternal(TypeParameterDescriptor r8, ErasureTypeAttributes r9) {
        Set<TypeParameterDescriptor> r0 = r9.getVisitedTypeParameters();
        if (r0 != null) goto L5;
    L8:
        SimpleType r1 = r8.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(r1, "typeParameter.defaultType");
        Set<TypeParameterDescriptor> r2 = TypeUtilsKt.extractTypeParametersFromUpperBounds(r1, r0);
        LinkedHashMap r4 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r2, 10)), 16));
        Iterator<T> r3 = r2.iterator();
    L10:
        if (r3.hasNext() == false) goto L19;
        TypeParameterDescriptor r5 = (TypeParameterDescriptor) r3.next();
        if (r0 != null) goto L14;
    L17:
        TypeProjection r6 = this.projectionComputer.computeProjection(r5, r9, this, getErasedUpperBound(r5, r9.withNewVisitedTypeParameter(r8)));
    L18:
        Pair r7 = TuplesKt.to(r5.getTypeConstructor(), r6);
        r4.put(r7.getFirst(), r7.getSecond());
        goto L10
    L14:
        if (r0.contains(r5) == false) goto L17;
        r6 = TypeUtils.makeStarProjection(r5, r9);
        Intrinsics.checkNotNullExpressionValue(r6, "makeStarProjection(it, typeAttr)");
        goto L18
    L19:
        boolean r10 = false;
        TypeSubstitutor r11 = TypeSubstitutor.create(TypeConstructorSubstitution.Companion.createByConstructorsMap$default(TypeConstructorSubstitution.Companion, r4, false, 2, null));
        Intrinsics.checkNotNullExpressionValue(r11, "create(TypeConstructorSu…ap(erasedTypeParameters))");
        List<KotlinType> r12 = r8.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(r12, "typeParameter.upperBounds");
        Set<KotlinType> r13 = substituteErasedUpperBounds(r11, r12, r9);
        if ((!r13.isEmpty()) == false) goto L38;
        if (this.options.getIntersectUpperBounds() == false) goto L24;
        List r14 = CollectionsKt.toList(r13);
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r16 = r14.iterator();
    L33:
        if (r16.hasNext() == false) goto L36;
        r15.add(((KotlinType) r16.next()).unwrap());
        goto L33
    L36:
        return IntersectionTypeKt.intersectTypes(r15);
    L24:
        if (r13.size() != 1) goto L26;
        r10 = true;
    L26:
        if (r10 == false) goto L30;
        return (KotlinType) CollectionsKt.single(r13);
    L30:
        throw new IllegalArgumentException("Should only be one computed upper bound if no need to intersect all bounds".toString());
    L38:
        return getDefaultType(r9);
    L5:
        if (r0.contains(r8.getOriginal()) == false) goto L8;
        return getDefaultType(r9);
    }

    private final Set<KotlinType> substituteErasedUpperBounds(TypeSubstitutor r6, List<? extends KotlinType> r7, ErasureTypeAttributes r8) {
        Set r0 = SetsKt.createSetBuilder();
        Iterator<? extends KotlinType> r9 = r7.iterator();
    L4:
        if (r9.hasNext() == false) goto L21;
        KotlinType r1 = r9.next();
        ClassifierDescriptor r2 = r1.getConstructor().mo2083getDeclarationDescriptor();
        if ((r2 instanceof ClassDescriptor) == false) goto L9;
        r0.add(Companion.replaceArgumentsOfUpperBound(r1, r6, r8.getVisitedTypeParameters(), this.options.getLeaveNonTypeParameterTypes()));
    L19:
        if (this.options.getIntersectUpperBounds() == true) goto L4;
    L9:
        if ((r2 instanceof TypeParameterDescriptor) == false) goto L19;
        Set<TypeParameterDescriptor> r3 = r8.getVisitedTypeParameters();
        boolean r4 = false;
        if (r3 != null) goto L13;
    L15:
        if (r4 == false) goto L17;
        r0.add(getDefaultType(r8));
        goto L19
    L17:
        List<KotlinType> r5 = ((TypeParameterDescriptor) r2).getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(r5, "declaration.upperBounds");
        r0.addAll(substituteErasedUpperBounds(r6, r5, r8));
        goto L19
    L13:
        if (r3.contains(r2) != true) goto L15;
        r4 = true;
    L21:
        return SetsKt.build(r0);
    }
}
