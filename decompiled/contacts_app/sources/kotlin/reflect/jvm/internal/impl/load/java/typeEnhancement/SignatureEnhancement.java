package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.DeprecationCausedByFunctionNInfo;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JavaDescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureBuildingUtilsKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.deprecation.DescriptorBasedDeprecationInfoKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: compiled from: signatureEnhancement.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class SignatureEnhancement {
    private final JavaTypeEnhancement typeEnhancement;

    public SignatureEnhancement(JavaTypeEnhancement r2) {
        Intrinsics.checkNotNullParameter(r2, "typeEnhancement");
        this.typeEnhancement = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <D extends CallableMemberDescriptor> Collection<D> enhanceSignatures(LazyJavaResolverContext r3, Collection<? extends D> r4) {
        Intrinsics.checkNotNullParameter(r3, "c");
        Intrinsics.checkNotNullParameter(r4, "platformSignatures");
        Collection<? extends D> r5 = r4;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        r0.add(enhanceSignature((CallableMemberDescriptor) r6.next(), r3));
        goto L4
    L7:
        return r0;
    }

    private final <D extends CallableMemberDescriptor> Annotations getDefaultAnnotations(D r5, LazyJavaResolverContext r6) {
        ClassifierDescriptor r4 = DescriptorUtilKt.getTopLevelContainingClassifier(r5);
        if (r4 == null) goto L5;
        List<JavaAnnotation> r1 = null;
        if ((r4 instanceof LazyJavaClassDescriptor) == false) goto L9;
        LazyJavaClassDescriptor r7 = (LazyJavaClassDescriptor) r4;
    L10:
        if (r7 == null) goto L12;
        r1 = r7.getModuleAnnotations();
    L12:
        List<JavaAnnotation> r8 = r1;
        if (r8 != null) goto L15;
    L18:
        boolean r9 = true;
    L19:
        if (r9 == true) goto L21;
        List<JavaAnnotation> r2 = r1;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r3 = r2.iterator();
    L24:
        if (r3.hasNext() == false) goto L27;
        r10.add(new LazyJavaAnnotationDescriptor(r6, (JavaAnnotation) r3.next(), true));
        goto L24
    L27:
        return Annotations.Companion.create(CollectionsKt.plus(r5.getAnnotations(), r10));
    L21:
        return r5.getAnnotations();
    L15:
        if (r8.isEmpty() == true) goto L18;
        r9 = false;
        goto L19
    L9:
        r7 = null;
        goto L10
    L5:
        return r5.getAnnotations();
    }

    private final <D extends CallableMemberDescriptor> D enhanceSignature(D r21, LazyJavaResolverContext r22) {
        if ((r21 instanceof JavaCallableMemberDescriptor) == true) goto L5;
        return r21;
    L5:
        JavaCallableMemberDescriptor r13 = (JavaCallableMemberDescriptor) r21;
        boolean r14 = true;
        if (r13.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) goto L8;
    L10:
        LazyJavaResolverContext r8 = ContextKt.copyWithNewDefaultTypeQualifiers(r22, getDefaultAnnotations(r21, r22));
        if ((r21 instanceof JavaPropertyDescriptor) == false) goto L20;
        JavaPropertyDescriptor r0 = (JavaPropertyDescriptor) r21;
        PropertyGetterDescriptorImpl r1 = r0.getGetter();
        if (r1 != null) goto L15;
    L17:
        boolean r2 = false;
    L18:
        if (r2 == false) goto L20;
        PropertyGetterDescriptorImpl r3 = r0.getGetter();
        Intrinsics.checkNotNull(r3);
        CallableDescriptor r9 = r3;
    L21:
        TypeEnhancementInfo r10 = null;
        if (r13.getExtensionReceiverParameter() != null) goto L24;
        KotlinType r16 = null;
    L34:
        if ((r21 instanceof JavaMethodDescriptor) == false) goto L36;
        JavaMethodDescriptor r4 = (JavaMethodDescriptor) r21;
    L37:
        if (r4 == null) goto L41;
        SignatureBuildingComponents r5 = SignatureBuildingComponents.INSTANCE;
        DeclarationDescriptor r6 = r4.getContainingDeclaration();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        String r7 = MethodSignatureBuildingUtilsKt.signature(r5, (ClassDescriptor) r6, MethodSignatureMappingKt.computeJvmDescriptor$default(r4, false, false, 3, null));
        if (r7 == null) goto L41;
        PredefinedFunctionEnhancementInfo r17 = PredefinedEnhancementInfoKt.getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE().get(r7);
    L42:
        if (r17 == null) goto L45;
        r17.getParametersInfo().size();
        r13.getValueParameters().size();
    L45:
        if (UtilsKt.isJspecifyEnabledInStrictMode(r22.getComponents().getJavaTypeEnhancementState()) == true) goto L49;
        if (r8.getComponents().getSettings().getIgnoreNullabilityForErasedValueParameters() == true) goto L49;
    L51:
        boolean r11 = false;
    L52:
        List<ValueParameterDescriptor> r12 = r9.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r12, "annotationOwnerForMember.valueParameters");
        List<ValueParameterDescriptor> r15 = r12;
        int r18 = 10;
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<T> r110 = r15.iterator();
    L54:
        if (r110.hasNext() == false) goto L62;
        final ValueParameterDescriptor r20 = (ValueParameterDescriptor) r110.next();
        if (r17 == null) goto L60;
        List<TypeEnhancementInfo> r23 = r17.getParametersInfo();
        if (r23 == null) goto L60;
        TypeEnhancementInfo r24 = (TypeEnhancementInfo) CollectionsKt.getOrNull(r23, r20.getIndex());
    L61:
        ArrayList r111 = r19;
        r111.add(enhanceValueParameter(r21, r20, r8, r24, r11, new SignatureEnhancement$enhanceSignature$valueParameterEnhancements$1$1(r20)));
        r19 = r111;
        r18 = r18;
        r10 = null;
    L60:
        r24 = r10;
        goto L61
    L62:
        int r112 = r18;
        ArrayList r113 = r19;
        CallableDescriptor r25 = r9;
        if ((r21 instanceof PropertyDescriptor) == true) goto L65;
        D r26 = null;
    L66:
        PropertyDescriptor r27 = (PropertyDescriptor) r26;
        if (r27 != null) goto L69;
    L71:
        boolean r28 = false;
    L72:
        if (r28 == false) goto L74;
        AnnotationQualifierApplicabilityType r29 = AnnotationQualifierApplicabilityType.FIELD;
    L75:
        AnnotationQualifierApplicabilityType r30 = r29;
        if (r17 == null) goto L78;
        TypeEnhancementInfo r31 = r17.getReturnTypeInfo();
    L79:
        KotlinType r32 = enhance$default(this, r21, r25, true, r8, r30, r31, false, SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1.INSTANCE, 32, null);
        KotlinType r33 = r13.getReturnType();
        Intrinsics.checkNotNull(r33);
        if (containsFunctionN(r33) == true) goto L102;
        ReceiverParameterDescriptor r34 = r13.getExtensionReceiverParameter();
        if (r34 == null) goto L86;
        KotlinType r35 = r34.getType();
        if (r35 == null) goto L86;
        boolean r36 = containsFunctionN(r35);
    L87:
        if (r36 == true) goto L102;
        List<ValueParameterDescriptor> r37 = r13.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r37, "valueParameters");
        List<ValueParameterDescriptor> r38 = r37;
        if ((r38 instanceof Collection) == true) goto L91;
    L93:
        Iterator<T> r39 = r38.iterator();
    L95:
        if (r39.hasNext() == false) goto L92;
        KotlinType r40 = ((ValueParameterDescriptor) r39.next()).getType();
        Intrinsics.checkNotNullExpressionValue(r40, "it.type");
        if (containsFunctionN(r40) == false) goto L95;
        boolean r41 = true;
    L99:
        if (r41 == true) goto L102;
        boolean r42 = false;
    L103:
        if (r42 == false) goto L105;
        Pair<CallableDescriptor.UserDataKey<?>, ?> r114 = TuplesKt.to(DescriptorBasedDeprecationInfoKt.getDEPRECATED_FUNCTION_KEY(), new DeprecationCausedByFunctionNInfo(r21));
    L106:
        if (r16 != null) goto L125;
        if (r32 != null) goto L125;
        ArrayList r43 = r113;
        if ((r43 instanceof Collection) == true) goto L111;
    L113:
        Iterator r44 = r43.iterator();
    L115:
        if (r44.hasNext() == false) goto L112;
        if (((KotlinType) r44.next()) == null) goto L119;
        boolean r45 = true;
    L120:
        if (r45 == false) goto L115;
    L121:
        if (r14 == true) goto L125;
        if (r114 != null) goto L125;
        return r21;
    L119:
        r45 = false;
    L112:
        r14 = false;
        goto L121
    L111:
        if (r43.isEmpty() == false) goto L113;
    L125:
        if (r16 != null) goto L130;
        ReceiverParameterDescriptor r46 = r13.getExtensionReceiverParameter();
        if (r46 == null) goto L129;
        KotlinType r47 = r46.getType();
    L131:
        ArrayList r48 = r113;
        ArrayList r49 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r48, r112));
        Iterator r50 = r48.iterator();
        int r115 = 0;
    L133:
        if (r50.hasNext() == false) goto L141;
        Object r51 = r50.next();
        int r52 = r115 + 1;
        if (r115 >= 0) goto L137;
        CollectionsKt.throwIndexOverflow();
    L137:
        KotlinType r53 = (KotlinType) r51;
        if (r53 != null) goto L140;
        r53 = r13.getValueParameters().get(r115).getType();
        Intrinsics.checkNotNullExpressionValue(r53, "valueParameters[index].type");
    L140:
        r49.add(r53);
        r115 = r52;
        goto L133
    L141:
        ArrayList r54 = r49;
        if (r32 != null) goto L144;
        r32 = r13.getReturnType();
        Intrinsics.checkNotNull(r32);
    L144:
        JavaCallableMemberDescriptor r55 = r13.enhance(r47, r54, r32, r114);
        Intrinsics.checkNotNull(r55, "null cannot be cast to non-null type D of org.jetbrains.kotlin.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature");
        return r55;
    L129:
        r47 = null;
        goto L131
    L130:
        r47 = r16;
        goto L131
    L105:
        r114 = null;
    L92:
        r41 = false;
        goto L99
    L91:
        if (r38.isEmpty() == false) goto L93;
    L86:
        r36 = false;
    L102:
        r42 = true;
        goto L103
    L78:
        r31 = null;
        goto L79
    L74:
        r29 = AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE;
        goto L75
    L69:
        if (JavaDescriptorUtilKt.isJavaField(r27) != true) goto L71;
        r28 = true;
        goto L72
    L65:
        r26 = r21;
    L49:
        if (UtilsKt.hasErasedValueParameters(r21) == false) goto L51;
        r11 = true;
    L41:
        r17 = null;
        goto L42
    L36:
        r4 = null;
        goto L37
    L24:
        if ((r9 instanceof FunctionDescriptor) == true) goto L26;
        CallableDescriptor r56 = null;
    L27:
        FunctionDescriptor r57 = (FunctionDescriptor) r56;
        if (r57 == null) goto L30;
        ValueParameterDescriptor r58 = (ValueParameterDescriptor) r57.getUserData(JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER);
    L31:
        r16 = enhanceValueParameter(r21, r58, r8, null, false, SignatureEnhancement$enhanceSignature$receiverTypeEnhancement$1.INSTANCE);
        goto L34
    L30:
        r58 = null;
        goto L31
    L26:
        r56 = r9;
        goto L27
    L15:
        if (r1.isDefault() == true) goto L17;
        r2 = true;
    L20:
        r9 = r21;
        goto L21
    L8:
        if (r13.getOriginal().getOverriddenDescriptors().size() != 1) goto L10;
        return r21;
    }

    public final List<KotlinType> enhanceTypeParameterBounds(TypeParameterDescriptor r13, List<? extends KotlinType> r14, LazyJavaResolverContext r15) {
        Intrinsics.checkNotNullParameter(r13, "typeParameter");
        Intrinsics.checkNotNullParameter(r14, "bounds");
        Intrinsics.checkNotNullParameter(r15, "context");
        List<? extends KotlinType> r16 = r14;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<T> r17 = r16.iterator();
    L4:
        if (r17.hasNext() == false) goto L14;
        KotlinType r1 = (KotlinType) r17.next();
        if (TypeUtilsKt.contains(r1, SignatureEnhancement$enhanceTypeParameterBounds$1$1.INSTANCE) == true) goto L12;
        KotlinType r2 = enhance$default(this, new SignatureParts(r13, false, r15, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, false, 16, null), r1, CollectionsKt.emptyList(), null, false, 12, null);
        if (r2 == null) goto L12;
        r1 = r2;
    L12:
        r0.add(r1);
        goto L4
    L14:
        return r0;
    }

    public final KotlinType enhanceSuperType(KotlinType r10, LazyJavaResolverContext r11) {
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r11, "context");
        KotlinType r9 = enhance$default(this, new SignatureParts(null, false, r11, AnnotationQualifierApplicabilityType.TYPE_USE, true), r10, CollectionsKt.emptyList(), null, false, 12, null);
        if (r9 != null) goto L6;
        return r10;
    L6:
        return r9;
    }

    private final boolean containsFunctionN(KotlinType r1) {
        return TypeUtils.contains(r1, AnonymousClass1.INSTANCE);
    }

    private final KotlinType enhanceValueParameter(CallableMemberDescriptor r10, ValueParameterDescriptor r11, LazyJavaResolverContext r12, TypeEnhancementInfo r13, boolean r14, Function1<? super CallableMemberDescriptor, ? extends KotlinType> r15) {
        ValueParameterDescriptor r2 = r11;
        if (r11 == null) goto L8;
        LazyJavaResolverContext r16 = ContextKt.copyWithNewDefaultTypeQualifiers(r12, r11.getAnnotations());
        if (r16 == null) goto L8;
        LazyJavaResolverContext r4 = r16;
    L10:
        return enhance(r10, r2, false, r4, AnnotationQualifierApplicabilityType.VALUE_PARAMETER, r13, r14, r15);
    L8:
        r4 = r12;
        goto L10
    }

    static /* synthetic */ KotlinType enhance$default(SignatureEnhancement r10, CallableMemberDescriptor r11, Annotated r12, boolean r13, LazyJavaResolverContext r14, AnnotationQualifierApplicabilityType r15, TypeEnhancementInfo r16, boolean r17, Function1 r18, int r19, Object r20) {
        if ((r19 & 32) == 0) goto L5;
        boolean r8 = false;
    L7:
        return r10.enhance(r11, r12, r13, r14, r15, r16, r8, r18);
    L5:
        r8 = r17;
        goto L7
    }

    private final KotlinType enhance(CallableMemberDescriptor r11, Annotated r12, boolean r13, LazyJavaResolverContext r14, AnnotationQualifierApplicabilityType r15, TypeEnhancementInfo r16, boolean r17, Function1<? super CallableMemberDescriptor, ? extends KotlinType> r18) {
        SignatureParts r9 = new SignatureParts(r12, r13, r14, r15, false, 16, null);
        KotlinType r2 = r18.invoke(r11);
        Collection<? extends CallableMemberDescriptor> r1 = r11.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(r1, "overriddenDescriptors");
        Collection<? extends CallableMemberDescriptor> r3 = r1;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L7;
        CallableMemberDescriptor r6 = (CallableMemberDescriptor) r5.next();
        Intrinsics.checkNotNullExpressionValue(r6, "it");
        r4.add(r18.invoke(r6));
        goto L4
    L7:
        return enhance(r9, r2, r4, r16, r17);
    }

    static /* synthetic */ KotlinType enhance$default(SignatureEnhancement r6, SignatureParts r7, KotlinType r8, List r9, TypeEnhancementInfo r10, boolean r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L5;
        r10 = null;
    L5:
        TypeEnhancementInfo r4 = r10;
        if ((r12 & 8) == 0) goto L9;
        r11 = false;
    L9:
        return r6.enhance(r7, r8, r9, r4, r11);
    }

    private final KotlinType enhance(SignatureParts r2, KotlinType r3, List<? extends KotlinType> r4, TypeEnhancementInfo r5, boolean r6) {
        return this.typeEnhancement.enhance(r3, r2.computeIndexedQualifiers(r3, r4, r5, r6), r2.getSkipRawTypeArguments());
    }
}
