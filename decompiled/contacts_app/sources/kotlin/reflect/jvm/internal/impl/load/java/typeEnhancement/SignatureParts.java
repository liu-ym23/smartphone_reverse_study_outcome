package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext;

/* JADX INFO: compiled from: signatureEnhancement.kt */
/* JADX INFO: loaded from: classes4.dex */
final class SignatureParts extends AbstractSignatureParts<AnnotationDescriptor> {
    private final AnnotationQualifierApplicabilityType containerApplicabilityType;
    private final LazyJavaResolverContext containerContext;
    private final boolean isCovariant;
    private final boolean skipRawTypeArguments;
    private final Annotated typeContainer;

    public /* synthetic */ SignatureParts(Annotated r7, boolean r8, LazyJavaResolverContext r9, AnnotationQualifierApplicabilityType r10, boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 16) == 0) goto L5;
        r11 = false;
    L5:
        this(r7, r8, r9, r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public /* bridge */ /* synthetic */ AbstractAnnotationTypeQualifierResolver<AnnotationDescriptor> getAnnotationTypeQualifierResolver() {
        return getAnnotationTypeQualifierResolver2();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public /* bridge */ /* synthetic */ KotlinTypeMarker getEnhancedForWarnings(KotlinTypeMarker r1) {
        return getEnhancedForWarnings(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public /* bridge */ /* synthetic */ boolean getForceWarning(AnnotationDescriptor r1) {
        return getForceWarning2(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public /* bridge */ /* synthetic */ TypeSystemContext getTypeSystem() {
        return getTypeSystem();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean isCovariant() {
        return this.isCovariant;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public AnnotationQualifierApplicabilityType getContainerApplicabilityType() {
        return this.containerApplicabilityType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean getSkipRawTypeArguments() {
        return this.skipRawTypeArguments;
    }

    public SignatureParts(Annotated r2, boolean r3, LazyJavaResolverContext r4, AnnotationQualifierApplicabilityType r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "containerContext");
        Intrinsics.checkNotNullParameter(r5, "containerApplicabilityType");
        this.typeContainer = r2;
        this.isCovariant = r3;
        this.containerContext = r4;
        this.containerApplicabilityType = r5;
        this.skipRawTypeArguments = r6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    /* JADX INFO: renamed from: getAnnotationTypeQualifierResolver, reason: avoid collision after fix types in other method */
    public AbstractAnnotationTypeQualifierResolver<AnnotationDescriptor> getAnnotationTypeQualifierResolver2() {
        return this.containerContext.getComponents().getAnnotationTypeQualifierResolver();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean getEnableImprovementsInStrictMode() {
        return this.containerContext.getComponents().getSettings().getTypeEnhancementImprovementsInStrictMode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public Iterable<AnnotationDescriptor> getContainerAnnotations() {
        Annotated r0 = this.typeContainer;
        if (r0 == null) goto L7;
        Iterable<AnnotationDescriptor> r1 = r0.getAnnotations();
        if (r1 == null) goto L7;
    L9:
        return r1;
    L7:
        r1 = CollectionsKt.emptyList();
        goto L9
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public JavaTypeQualifiersByElementType getContainerDefaultTypeQualifiers() {
        return this.containerContext.getDefaultTypeQualifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean getContainerIsVarargParameter() {
        Annotated r1 = this.typeContainer;
        if ((r1 instanceof ValueParameterDescriptor) == true) goto L5;
    L7:
        return false;
    L5:
        if (((ValueParameterDescriptor) r1).getVarargElementType() == null) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public TypeSystemInferenceExtensionContext getTypeSystem() {
        return SimpleClassicTypeSystemContext.INSTANCE;
    }

    /* JADX INFO: renamed from: getForceWarning, reason: avoid collision after fix types in other method */
    public boolean getForceWarning2(AnnotationDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if ((r2 instanceof PossiblyExternalAnnotationDescriptor) == false) goto L7;
        if (((PossiblyExternalAnnotationDescriptor) r2).isIdeExternalAnnotation() == false) goto L7;
    L14:
        return true;
    L7:
        if ((r2 instanceof LazyJavaAnnotationDescriptor) == true) goto L9;
    L15:
        return false;
    L9:
        if (getEnableImprovementsInStrictMode() == true) goto L15;
        if (((LazyJavaAnnotationDescriptor) r2).isFreshlySupportedTypeUseAnnotation() == true) goto L14;
        if (getContainerApplicabilityType() != AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS) goto L15;
        goto L14
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public Iterable<AnnotationDescriptor> getAnnotations(KotlinTypeMarker r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return ((KotlinType) r1).getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public KotlinType getEnhancedForWarnings(KotlinTypeMarker r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return TypeWithEnhancementKt.getEnhancement((KotlinType) r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public FqNameUnsafe getFqNameUnsafe(KotlinTypeMarker r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        ClassDescriptor r0 = TypeUtils.getClassDescriptor((KotlinType) r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return DescriptorUtils.getFqName(r0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean isNotNullTypeParameterCompat(KotlinTypeMarker r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return ((KotlinType) r1).unwrap() instanceof NotNullTypeParameterImpl;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean isEqual(KotlinTypeMarker r2, KotlinTypeMarker r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "other");
        return this.containerContext.getComponents().getKotlinTypeChecker().equalTypes((KotlinType) r2, (KotlinType) r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean isArrayOrPrimitiveArray(KotlinTypeMarker r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return KotlinBuiltIns.isArrayOrPrimitiveArray((KotlinType) r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean isFromJava(TypeParameterMarker r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1 instanceof LazyJavaTypeParameterDescriptor;
    }
}
