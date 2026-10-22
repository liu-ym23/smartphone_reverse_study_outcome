package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationAsAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLiteralAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.NullValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* JADX INFO: compiled from: LazyJavaAnnotationDescriptor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class LazyJavaAnnotationDescriptor implements AnnotationDescriptor, PossiblyExternalAnnotationDescriptor {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final NotNullLazyValue allValueArguments$delegate;
    private final LazyJavaResolverContext c;
    private final NullableLazyValue fqName$delegate;
    private final boolean isFreshlySupportedTypeUseAnnotation;
    private final boolean isIdeExternalAnnotation;
    private final JavaAnnotation javaAnnotation;
    private final JavaSourceElement source;
    private final NotNullLazyValue type$delegate;

    public LazyJavaAnnotationDescriptor(LazyJavaResolverContext r3, JavaAnnotation r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "c");
        Intrinsics.checkNotNullParameter(r4, "javaAnnotation");
        this.c = r3;
        this.javaAnnotation = r4;
        this.fqName$delegate = r3.getStorageManager().createNullableLazyValue(new LazyJavaAnnotationDescriptor$fqName$2(this));
        this.type$delegate = r3.getStorageManager().createLazyValue(new LazyJavaAnnotationDescriptor$type$2(this));
        this.source = r3.getComponents().getSourceElementFactory().source(r4);
        this.allValueArguments$delegate = r3.getStorageManager().createLazyValue(new LazyJavaAnnotationDescriptor$allValueArguments$2(this));
        this.isIdeExternalAnnotation = r4.isIdeExternalAnnotation();
        if (r4.isFreshlySupportedTypeUseAnnotation() == true) goto L7;
        if (r5 == true) goto L7;
        boolean r6 = false;
    L8:
        this.isFreshlySupportedTypeUseAnnotation = r6;
        return;
    L7:
        r6 = true;
        goto L8
    }

    public /* synthetic */ LazyJavaAnnotationDescriptor(LazyJavaResolverContext r1, JavaAnnotation r2, boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ ClassDescriptor access$createTypeForMissingDependencies(LazyJavaAnnotationDescriptor r0, FqName r1) {
        return r0.createTypeForMissingDependencies(r1);
    }

    public static final /* synthetic */ LazyJavaResolverContext access$getC$p(LazyJavaAnnotationDescriptor r0) {
        return r0.c;
    }

    public static final /* synthetic */ JavaAnnotation access$getJavaAnnotation$p(LazyJavaAnnotationDescriptor r0) {
        return r0.javaAnnotation;
    }

    public static final /* synthetic */ ConstantValue access$resolveAnnotationArgument(LazyJavaAnnotationDescriptor r0, JavaAnnotationArgument r1) {
        return r0.resolveAnnotationArgument(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public /* bridge */ /* synthetic */ SourceElement getSource() {
        return getSource();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public /* bridge */ /* synthetic */ KotlinType getType() {
        return getType();
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaAnnotationDescriptor.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaAnnotationDescriptor.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaAnnotationDescriptor.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public FqName getFqName() {
        return (FqName) StorageKt.getValue(this.fqName$delegate, this, $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public SimpleType getType() {
        return (SimpleType) StorageKt.getValue(this.type$delegate, this, $$delegatedProperties[1]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public JavaSourceElement getSource() {
        return this.source;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        return (Map) StorageKt.getValue(this.allValueArguments$delegate, this, $$delegatedProperties[2]);
    }

    private final ConstantValue<?> resolveAnnotationArgument(JavaAnnotationArgument r3) {
        if ((r3 instanceof JavaLiteralAnnotationArgument) == false) goto L6;
        return ConstantValueFactory.INSTANCE.createConstantValue(((JavaLiteralAnnotationArgument) r3).getValue());
    L6:
        if ((r3 instanceof JavaEnumValueAnnotationArgument) == false) goto L9;
        JavaEnumValueAnnotationArgument r4 = (JavaEnumValueAnnotationArgument) r3;
        return resolveFromEnumValue(r4.getEnumClassId(), r4.getEntryName());
    L9:
        if ((r3 instanceof JavaArrayAnnotationArgument) == false) goto L15;
        JavaArrayAnnotationArgument r5 = (JavaArrayAnnotationArgument) r3;
        Name r0 = r5.getName();
        if (r0 != null) goto L13;
        r0 = JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME;
    L13:
        Intrinsics.checkNotNullExpressionValue(r0, "argument.name ?: DEFAULT_ANNOTATION_MEMBER_NAME");
        return resolveFromArray(r0, r5.getElements());
    L15:
        if ((r3 instanceof JavaAnnotationAsAnnotationArgument) == false) goto L18;
        return resolveFromAnnotation(((JavaAnnotationAsAnnotationArgument) r3).getAnnotation());
    L18:
        if ((r3 instanceof JavaClassObjectAnnotationArgument) == true) goto L26;
        return null;
    L26:
        return resolveFromJavaClassObjectType(((JavaClassObjectAnnotationArgument) r3).getReferencedType());
    }

    private final ConstantValue<?> resolveFromAnnotation(JavaAnnotation r9) {
        return new AnnotationValue(new LazyJavaAnnotationDescriptor(this.c, r9, false, 4, null));
    }

    private final ConstantValue<?> resolveFromArray(Name r4, List<? extends JavaAnnotationArgument> r5) {
        SimpleType r0 = getType();
        Intrinsics.checkNotNullExpressionValue(r0, "type");
        if (KotlinTypeKt.isError(r0) == false) goto L6;
        return null;
    L6:
        ClassDescriptor r1 = DescriptorUtilsKt.getAnnotationClass(this);
        Intrinsics.checkNotNull(r1);
        ValueParameterDescriptor r6 = DescriptorResolverUtils.getAnnotationParameterByName(r4, r1);
        if (r6 == null) goto L10;
        SimpleType r7 = r6.getType();
        if (r7 == null) goto L10;
    L11:
        Intrinsics.checkNotNullExpressionValue(r7, "DescriptorResolverUtils.…GUMENT)\n                )");
        List<? extends JavaAnnotationArgument> r8 = r5;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r9 = r8.iterator();
    L13:
        if (r9.hasNext() == false) goto L18;
        NullValue r3 = resolveAnnotationArgument((JavaAnnotationArgument) r9.next());
        if (r3 != null) goto L17;
        r3 = new NullValue();
    L17:
        r2.add(r3);
        goto L13
    L18:
        ConstantValueFactory r10 = ConstantValueFactory.INSTANCE;
        return r10.createArrayValue(r2, r7);
    L10:
        r7 = this.c.getComponents().getModule().getBuiltIns().getArrayType(Variance.INVARIANT, ErrorUtils.createErrorType(ErrorTypeKind.UNKNOWN_ARRAY_ELEMENT_TYPE_OF_ANNOTATION_ARGUMENT, new String[0]));
        goto L11
    }

    private final ConstantValue<?> resolveFromEnumValue(ClassId r1, Name r2) {
        if (r1 == null) goto L7;
        if (r2 != null) goto L6;
        return null;
    L6:
        return new EnumValue(r1, r2);
    L7:
        return null;
    }

    private final ConstantValue<?> resolveFromJavaClassObjectType(JavaType r8) {
        return KClassValue.Companion.create(this.c.getTypeResolver().transformJavaType(r8, JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null)));
    }

    public String toString() {
        return DescriptorRenderer.renderAnnotation$default(DescriptorRenderer.FQ_NAMES_IN_TYPES, this, null, 2, null);
    }

    private final ClassDescriptor createTypeForMissingDependencies(FqName r3) {
        ModuleDescriptor r0 = this.c.getModule();
        ClassId r4 = ClassId.topLevel(r3);
        Intrinsics.checkNotNullExpressionValue(r4, "topLevel(fqName)");
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(r0, r4, this.c.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor
    public boolean isIdeExternalAnnotation() {
        return this.isIdeExternalAnnotation;
    }

    public final boolean isFreshlySupportedTypeUseAnnotation() {
        return this.isFreshlySupportedTypeUseAnnotation;
    }
}
