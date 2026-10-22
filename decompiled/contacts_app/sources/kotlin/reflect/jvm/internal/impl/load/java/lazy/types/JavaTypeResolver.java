package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: compiled from: JavaTypeResolver.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JavaTypeResolver {
    private final LazyJavaResolverContext c;
    private final RawProjectionComputer projectionComputer;
    private final TypeParameterResolver typeParameterResolver;
    private final TypeParameterUpperBoundEraser typeParameterUpperBoundEraser;

    /* JADX WARN: Multi-variable type inference failed */
    public JavaTypeResolver(LazyJavaResolverContext r3, TypeParameterResolver r4) {
        Intrinsics.checkNotNullParameter(r3, "c");
        Intrinsics.checkNotNullParameter(r4, "typeParameterResolver");
        this.c = r3;
        this.typeParameterResolver = r4;
        RawProjectionComputer r5 = new RawProjectionComputer();
        this.projectionComputer = r5;
        this.typeParameterUpperBoundEraser = new TypeParameterUpperBoundEraser(r5, null, 2, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ TypeParameterUpperBoundEraser access$getTypeParameterUpperBoundEraser$p(JavaTypeResolver r0) {
        return r0.typeParameterUpperBoundEraser;
    }

    public final KotlinType transformJavaType(JavaType r8, JavaTypeAttributes r9) {
        Intrinsics.checkNotNullParameter(r9, "attr");
        if ((r8 instanceof JavaPrimitiveType) == false) goto L10;
        PrimitiveType r10 = ((JavaPrimitiveType) r8).getType();
        if (r10 == null) goto L7;
        SimpleType r7 = this.c.getModule().getBuiltIns().getPrimitiveKotlinType(r10);
    L8:
        Intrinsics.checkNotNullExpressionValue(r7, "{\n                val pr…ns.unitType\n            }");
        return r7;
    L7:
        r7 = this.c.getModule().getBuiltIns().getUnitType();
        goto L8
    L10:
        if ((r8 instanceof JavaClassifierType) == false) goto L13;
        return transformJavaClassifierType((JavaClassifierType) r8, r9);
    L13:
        if ((r8 instanceof JavaArrayType) == false) goto L16;
        return transformArrayType$default(this, (JavaArrayType) r8, r9, false, 4, null);
    L16:
        if ((r8 instanceof JavaWildcardType) == false) goto L24;
        JavaType r11 = ((JavaWildcardType) r8).getBound();
        if (r11 == null) goto L23;
        KotlinType r12 = transformJavaType(r11, r9);
        if (r12 == null) goto L23;
        return r12;
    L23:
        SimpleType r13 = this.c.getModule().getBuiltIns().getDefaultBound();
        Intrinsics.checkNotNullExpressionValue(r13, "c.module.builtIns.defaultBound");
        return r13;
    L24:
        if (r8 != null) goto L28;
        SimpleType r14 = this.c.getModule().getBuiltIns().getDefaultBound();
        Intrinsics.checkNotNullExpressionValue(r14, "c.module.builtIns.defaultBound");
        return r14;
    L28:
        throw new UnsupportedOperationException("Unsupported type: " + r8);
    }

    public static /* synthetic */ KotlinType transformArrayType$default(JavaTypeResolver r0, JavaArrayType r1, JavaTypeAttributes r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        return r0.transformArrayType(r1, r2, r3);
    }

    public final KotlinType transformArrayType(JavaArrayType r12, JavaTypeAttributes r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r12, "arrayType");
        Intrinsics.checkNotNullParameter(r13, "attr");
        JavaType r0 = r12.getComponentType();
        PrimitiveType r2 = null;
        if ((r0 instanceof JavaPrimitiveType) == false) goto L5;
        JavaPrimitiveType r1 = (JavaPrimitiveType) r0;
    L6:
        if (r1 == null) goto L8;
        r2 = r1.getType();
    L8:
        LazyJavaAnnotations r3 = new LazyJavaAnnotations(this.c, r12, true);
        if (r2 == null) goto L15;
        SimpleType r11 = this.c.getModule().getBuiltIns().getPrimitiveArrayKotlinType(r2);
        Intrinsics.checkNotNullExpressionValue(r11, "c.module.builtIns.getPri…KotlinType(primitiveType)");
        SimpleType r15 = r11;
        TypeUtilsKt.replaceAnnotations(r15, Annotations.Companion.create(CollectionsKt.plus(r3, r11.getAnnotations())));
        if (r13.isForAnnotationParameter() == false) goto L14;
        return r15;
    L14:
        return KotlinTypeFactory.flexibleType(r11, r11.makeNullableAsSpecified(true));
    L15:
        KotlinType r16 = transformJavaType(r0, JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, r13.isForAnnotationParameter(), false, null, 6, null));
        if (r13.isForAnnotationParameter() == false) goto L22;
        if (r14 == false) goto L19;
        Variance r17 = Variance.OUT_VARIANCE;
    L20:
        SimpleType r18 = this.c.getModule().getBuiltIns().getArrayType(r17, r16, r3);
        Intrinsics.checkNotNullExpressionValue(r18, "c.module.builtIns.getArr…mponentType, annotations)");
        return r18;
    L19:
        r17 = Variance.INVARIANT;
        goto L20
    L22:
        LazyJavaAnnotations r4 = r3;
        SimpleType r19 = this.c.getModule().getBuiltIns().getArrayType(Variance.INVARIANT, r16, r4);
        Intrinsics.checkNotNullExpressionValue(r19, "c.module.builtIns.getArr…mponentType, annotations)");
        return KotlinTypeFactory.flexibleType(r19, this.c.getModule().getBuiltIns().getArrayType(Variance.OUT_VARIANCE, r16, r4).makeNullableAsSpecified(true));
    L5:
        r1 = null;
        goto L6
    }

    private static final ErrorType transformJavaClassifierType$errorType(JavaClassifierType r3) {
        return ErrorUtils.createErrorType(ErrorTypeKind.UNRESOLVED_JAVA_CLASS, new String[]{r3.getPresentableText()});
    }

    private final KotlinType transformJavaClassifierType(JavaClassifierType r4, JavaTypeAttributes r5) {
        if (r5.isForAnnotationParameter() == false) goto L5;
    L7:
        boolean r0 = false;
    L8:
        boolean r1 = r4.isRaw();
        if (r1 == true) goto L17;
        if (r0 == true) goto L17;
        SimpleType r3 = computeSimpleJavaClassifierType(r4, r5, null);
        if (r3 != null) goto L16;
        r3 = transformJavaClassifierType$errorType(r4);
    L16:
        return r3;
    L17:
        SimpleType r2 = computeSimpleJavaClassifierType(r4, r5.withFlexibility(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND), null);
        if (r2 == null) goto L20;
        SimpleType r6 = computeSimpleJavaClassifierType(r4, r5.withFlexibility(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND), r2);
        if (r6 == null) goto L24;
        if (r1 == false) goto L28;
        return new RawTypeImpl(r2, r6);
    L28:
        return KotlinTypeFactory.flexibleType(r2, r6);
    L24:
        return transformJavaClassifierType$errorType(r4);
    L20:
        return transformJavaClassifierType$errorType(r4);
    L5:
        if (r5.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) goto L7;
        r0 = true;
        goto L8
    }

    private final SimpleType computeSimpleJavaClassifierType(JavaClassifierType r9, JavaTypeAttributes r10, SimpleType r11) {
        if (r11 == null) goto L5;
        TypeAttributes r0 = r11.getAttributes();
        if (r0 == null) goto L5;
    L6:
        TypeAttributes r1 = r0;
        TypeConstructor r2 = computeTypeConstructor(r9, r10);
        TypeConstructor r3 = null;
        if (r2 != null) goto L9;
        return null;
    L9:
        boolean r4 = isNullable(r10);
        if (r11 == null) goto L13;
        r3 = r11.getConstructor();
    L13:
        if (Intrinsics.areEqual(r3, r2) == false) goto L20;
        if (r9.isRaw() == true) goto L20;
        if (r4 == false) goto L20;
        return r11.makeNullableAsSpecified(true);
    L20:
        return KotlinTypeFactory.simpleType$default(r1, r2, computeArguments(r9, r10, r2), r4, null, 16, null);
    L5:
        r0 = TypeAttributesKt.toDefaultAttributes(new LazyJavaAnnotations(this.c, r9, false, 4, null));
        goto L6
    }

    private final TypeConstructor computeTypeConstructor(JavaClassifierType r4, JavaTypeAttributes r5) {
        JavaClassifier r0 = r4.getClassifier();
        if (r0 != null) goto L7;
        return createNotFoundClass(r4);
    L7:
        if ((r0 instanceof JavaClass) == false) goto L20;
        JavaClass r1 = (JavaClass) r0;
        FqName r2 = r1.getFqName();
        if (r2 == null) goto L18;
        ClassDescriptor r6 = mapKotlinClass(r4, r5, r2);
        if (r6 != null) goto L13;
        r6 = this.c.getComponents().getModuleClassResolver().resolveClass(r1);
    L13:
        if (r6 == null) goto L29;
        TypeConstructor r7 = r6.getTypeConstructor();
        if (r7 == null) goto L29;
        return r7;
    L29:
        return createNotFoundClass(r4);
    L18:
        throw new AssertionError("Class type should have a FQ name: " + r0);
    L20:
        if ((r0 instanceof JavaTypeParameter) == false) goto L27;
        TypeParameterDescriptor r3 = this.typeParameterResolver.resolveTypeParameter((JavaTypeParameter) r0);
        if (r3 != null) goto L30;
        return null;
    L30:
        return r3.getTypeConstructor();
    L27:
        throw new IllegalStateException("Unknown classifier kind: " + r0);
    }

    private final TypeConstructor createNotFoundClass(JavaClassifierType r2) {
        ClassId r3 = ClassId.topLevel(new FqName(r2.getClassifierQualifiedName()));
        Intrinsics.checkNotNullExpressionValue(r3, "topLevel(FqName(javaType.classifierQualifiedName))");
        TypeConstructor r1 = this.c.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses().getClass(r3, CollectionsKt.listOf(0)).getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(r1, "c.components.deserialize…istOf(0)).typeConstructor");
        return r1;
    }

    private final ClassDescriptor mapKotlinClass(JavaClassifierType r8, JavaTypeAttributes r9, FqName r10) {
        if (r9.isForAnnotationParameter() == true) goto L5;
    L8:
        JavaToKotlinClassMapper r6 = JavaToKotlinClassMapper.INSTANCE;
        ClassDescriptor r11 = JavaToKotlinClassMapper.mapJavaToKotlin$default(r6, r10, this.c.getModule().getBuiltIns(), null, 4, null);
        if (r11 != null) goto L13;
        return null;
    L13:
        if (r6.isReadOnly(r11) == true) goto L15;
    L22:
        return r11;
    L15:
        if (r9.getFlexibility() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND) goto L21;
        if (r9.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) goto L21;
        if (argumentsMakeSenseOnlyForMutableContainer(r8, r11) == false) goto L22;
    L21:
        return r6.convertReadOnlyToMutable(r11);
    L5:
        if (Intrinsics.areEqual(r10, JavaTypeResolverKt.access$getJAVA_LANG_CLASS_FQ_NAME$p()) == false) goto L8;
        return this.c.getComponents().getReflectionTypes().getKClass();
    }

    private final boolean argumentsMakeSenseOnlyForMutableContainer(JavaClassifierType r1, ClassDescriptor r2) {
        if (JavaTypesKt.isSuperWildcard((JavaType) CollectionsKt.lastOrNull(r1.getTypeArguments())) == true) goto L5;
        return false;
    L5:
        List<TypeParameterDescriptor> r0 = JavaToKotlinClassMapper.INSTANCE.convertReadOnlyToMutable(r2).getTypeConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(r0, "JavaToKotlinClassMapper.…ypeConstructor.parameters");
        TypeParameterDescriptor r3 = (TypeParameterDescriptor) CollectionsKt.lastOrNull(r0);
        if (r3 == null) goto L14;
        Variance r4 = r3.getVariance();
        if (r4 != null) goto L11;
        return false;
    L11:
        if (r4 == Variance.OUT_VARIANCE) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    }

    private final List<TypeProjection> computeRawTypeArguments(final JavaClassifierType r12, List<? extends TypeParameterDescriptor> r13, final TypeConstructor r14, final JavaTypeAttributes r15) {
        List<? extends TypeParameterDescriptor> r16 = r13;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<T> r17 = r16.iterator();
    L4:
        if (r17.hasNext() == false) goto L11;
        final TypeParameterDescriptor r1 = (TypeParameterDescriptor) r17.next();
        if (TypeUtilsKt.hasTypeParameterRecursiveBounds(r1, null, r15.getVisitedTypeParameters()) == false) goto L8;
        TypeProjection r2 = TypeUtils.makeStarProjection(r1, r15);
    L9:
        r0.add(r2);
        goto L4
    L8:
        LazyWrappedType r8 = new LazyWrappedType(this.c.getStorageManager(), new JavaTypeResolver$computeRawTypeArguments$1$erasedUpperBound$1(this, r1, r15, r14, r12));
        r2 = this.projectionComputer.computeProjection(r1, r15.markIsRaw(r12.isRaw()), this.typeParameterUpperBoundEraser, r8);
        goto L9
    L11:
        return r0;
    }

    private final List<TypeProjection> computeArguments(JavaClassifierType r12, JavaTypeAttributes r13, TypeConstructor r14) {
        if (r12.isRaw() == false) goto L5;
    L10:
        boolean r0 = true;
    L11:
        List<TypeParameterDescriptor> r4 = r14.getParameters();
        Intrinsics.checkNotNullExpressionValue(r4, "constructor.parameters");
        if (r0 == false) goto L16;
        return computeRawTypeArguments(r12, r4, r14, r13);
    L16:
        if (r4.size() == r12.getTypeArguments().size()) goto L23;
        List<TypeParameterDescriptor> r5 = r4;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r15 = r5.iterator();
    L19:
        if (r15.hasNext() == false) goto L22;
        TypeParameterDescriptor r16 = (TypeParameterDescriptor) r15.next();
        ErrorTypeKind r1 = ErrorTypeKind.MISSED_TYPE_ARGUMENT_FOR_TYPE_PARAMETER;
        String r17 = r16.getName().asString();
        Intrinsics.checkNotNullExpressionValue(r17, "p.name.asString()");
        r11.add(new TypeProjectionImpl(ErrorUtils.createErrorType(r1, new String[]{r17})));
        goto L19
    L22:
        return CollectionsKt.toList(r11);
    L23:
        Iterable r18 = CollectionsKt.withIndex(r12.getTypeArguments());
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator r110 = r18.iterator();
    L25:
        if (r110.hasNext() == false) goto L28;
        IndexedValue r111 = (IndexedValue) r110.next();
        int r2 = r111.component1();
        JavaType r112 = (JavaType) r111.component2();
        r4.size();
        TypeParameterDescriptor r3 = r4.get(r2);
        JavaTypeAttributes r6 = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null);
        Intrinsics.checkNotNullExpressionValue(r3, "parameter");
        r19.add(transformToTypeProjection(r112, r6, r3));
        goto L25
    L28:
        return CollectionsKt.toList(r19);
    L5:
        if (r12.getTypeArguments().isEmpty() == false) goto L9;
        List<TypeParameterDescriptor> r7 = r14.getParameters();
        Intrinsics.checkNotNullExpressionValue(r7, "constructor.parameters");
        if ((!r7.isEmpty()) == true) goto L10;
    L9:
        r0 = false;
        goto L11
    }

    private final TypeProjection transformToTypeProjection(JavaType r9, JavaTypeAttributes r10, TypeParameterDescriptor r11) {
        if ((r9 instanceof JavaWildcardType) == false) goto L16;
        JavaWildcardType r12 = (JavaWildcardType) r9;
        JavaType r0 = r12.getBound();
        if (r12.isExtends() == false) goto L7;
        Variance r13 = Variance.OUT_VARIANCE;
    L8:
        if (r0 != null) goto L10;
    L13:
        TypeProjection r8 = TypeUtils.makeStarProjection(r11, r10);
    L14:
        Intrinsics.checkNotNullExpressionValue(r8, "{\n                val bo…          }\n            }");
        return r8;
    L10:
        if (isConflictingArgumentFor(r13, r11) == true) goto L13;
        r8 = TypeUtilsKt.createProjection(transformJavaType(r0, JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null)), r13, r11);
        goto L14
    L7:
        r13 = Variance.IN_VARIANCE;
        goto L8
    L16:
        return new TypeProjectionImpl(Variance.INVARIANT, transformJavaType(r9, r10));
    }

    private final boolean isConflictingArgumentFor(Variance r3, TypeParameterDescriptor r4) {
        if (r4.getVariance() != Variance.INVARIANT) goto L6;
        return false;
    L6:
        if (r3 == r4.getVariance()) goto L9;
        return true;
    L9:
        return false;
    }

    private final boolean isNullable(JavaTypeAttributes r3) {
        if (r3.getFlexibility() != JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND) goto L6;
        return false;
    L6:
        if (r3.isForAnnotationParameter() == false) goto L8;
        return false;
    L8:
        if (r3.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) goto L12;
        return true;
    L12:
        return false;
    }
}
