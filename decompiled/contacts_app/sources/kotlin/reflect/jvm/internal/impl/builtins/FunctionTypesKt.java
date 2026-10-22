package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: compiled from: functionTypes.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class FunctionTypesKt {
    public static final boolean isFunctionType(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        ClassifierDescriptor r2 = r1.getConstructor().mo2083getDeclarationDescriptor();
        if (r2 == null) goto L5;
        FunctionClassKind r3 = getFunctionalClassKind(r2);
    L7:
        if (r3 != FunctionClassKind.Function) goto L9;
        return true;
    L9:
        return false;
    L5:
        r3 = null;
        goto L7
    }

    public static final boolean isSuspendFunctionType(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        ClassifierDescriptor r2 = r1.getConstructor().mo2083getDeclarationDescriptor();
        if (r2 == null) goto L5;
        FunctionClassKind r3 = getFunctionalClassKind(r2);
    L7:
        if (r3 != FunctionClassKind.SuspendFunction) goto L9;
        return true;
    L9:
        return false;
    L5:
        r3 = null;
        goto L7
    }

    public static final boolean isBuiltinFunctionalType(KotlinType r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ClassifierDescriptor r3 = r2.getConstructor().mo2083getDeclarationDescriptor();
        if (r3 != null) goto L5;
        return false;
    L5:
        if (isBuiltinFunctionalClassDescriptor(r3) == true) goto L7;
        return false;
    L7:
        return true;
    }

    public static final boolean isBuiltinFunctionalClassDescriptor(DeclarationDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        FunctionClassKind r2 = getFunctionalClassKind(r1);
        if (r2 != FunctionClassKind.Function) goto L5;
    L8:
        return true;
    L5:
        if (r2 == FunctionClassKind.SuspendFunction) goto L8;
        return false;
    }

    public static final boolean isBuiltinExtensionFunctionalType(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (isBuiltinFunctionalType(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (isTypeAnnotatedWithExtensionFunctionType(r1) == false) goto L7;
        return true;
    }

    private static final boolean isTypeAnnotatedWithExtensionFunctionType(KotlinType r1) {
        if (r1.getAnnotations().mo2078findAnnotation(StandardNames.FqNames.extensionFunctionType) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final FunctionClassKind getFunctionalClassKind(DeclarationDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if ((r2 instanceof ClassDescriptor) == true) goto L6;
        return null;
    L6:
        if (KotlinBuiltIns.isUnderKotlinPackage(r2) == true) goto L9;
        return null;
    L9:
        return getFunctionalClassKind(DescriptorUtilsKt.getFqNameUnsafe(r2));
    }

    private static final FunctionClassKind getFunctionalClassKind(FqNameUnsafe r3) {
        if (r3.isSafe() == true) goto L5;
        return null;
    L5:
        if (r3.isRoot() == true) goto L11;
        FunctionClassKind.Companion r0 = FunctionClassKind.Companion;
        String r1 = r3.shortName().asString();
        Intrinsics.checkNotNullExpressionValue(r1, "shortName().asString()");
        FqName r4 = r3.toSafe().parent();
        Intrinsics.checkNotNullExpressionValue(r4, "toSafe().parent()");
        return r0.getFunctionalClassKind(r1, r4);
    L11:
        return null;
    }

    public static final int contextFunctionTypeParamsCount(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        AnnotationDescriptor r2 = r1.getAnnotations().mo2078findAnnotation(StandardNames.FqNames.contextFunctionTypeParams);
        if (r2 != null) goto L6;
        return 0;
    L6:
        ConstantValue r3 = (ConstantValue) MapsKt.getValue(r2.getAllValueArguments(), StandardNames.CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.constants.IntValue");
        return ((IntValue) r3).getValue().intValue();
    }

    public static final KotlinType getReceiverTypeFromFunctionType(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        isBuiltinFunctionalType(r1);
        if (isTypeAnnotatedWithExtensionFunctionType(r1) == true) goto L6;
        return null;
    L6:
        int r0 = contextFunctionTypeParamsCount(r1);
        return r1.getArguments().get(r0).getType();
    }

    public static final List<KotlinType> getContextReceiverTypesFromFunctionType(KotlinType r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        isBuiltinFunctionalType(r3);
        int r0 = contextFunctionTypeParamsCount(r3);
        if (r0 == 0) goto L12;
        List<TypeProjection> r4 = r3.getArguments().subList(0, r0);
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L10;
        KotlinType r2 = ((TypeProjection) r5.next()).getType();
        Intrinsics.checkNotNullExpressionValue(r2, "it.type");
        r1.add(r2);
        goto L7
    L10:
        return r1;
    L12:
        return CollectionsKt.emptyList();
    }

    public static final KotlinType getReturnTypeFromFunctionType(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        isBuiltinFunctionalType(r1);
        KotlinType r2 = ((TypeProjection) CollectionsKt.last(r1.getArguments())).getType();
        Intrinsics.checkNotNullExpressionValue(r2, "arguments.last().type");
        return r2;
    }

    public static final List<TypeProjection> getValueParameterTypesFromFunctionType(KotlinType r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        isBuiltinFunctionalType(r2);
        List<TypeProjection> r0 = r2.getArguments();
        return r0.subList(contextFunctionTypeParamsCount(r2) + (isBuiltinExtensionFunctionalType(r2) ? 1 : 0), r0.size() - 1);
    }

    public static final Name extractParameterNameFromFunctionTypeArgument(KotlinType r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        AnnotationDescriptor r3 = r2.getAnnotations().mo2078findAnnotation(StandardNames.FqNames.parameterName);
        if (r3 != null) goto L5;
        return null;
    L5:
        Object r4 = CollectionsKt.singleOrNull(r3.getAllValueArguments().values());
        if ((r4 instanceof StringValue) == false) goto L8;
        StringValue r5 = (StringValue) r4;
    L9:
        if (r5 == null) goto L19;
        String r6 = r5.getValue();
        if (r6 == null) goto L19;
        if (Name.isValidIdentifier(r6) == true) goto L16;
        r6 = null;
    L16:
        if (r6 == null) goto L19;
        return Name.identifier(r6);
    L19:
        return null;
    L8:
        r5 = null;
        goto L9
    }

    public static final List<TypeProjection> getFunctionTypeArgumentProjections(KotlinType r9, List<? extends KotlinType> r10, List<? extends KotlinType> r11, List<Name> r12, KotlinType r13, KotlinBuiltIns r14) {
        Intrinsics.checkNotNullParameter(r10, "contextReceiverTypes");
        Intrinsics.checkNotNullParameter(r11, "parameterTypes");
        Intrinsics.checkNotNullParameter(r13, "returnType");
        Intrinsics.checkNotNullParameter(r14, "builtIns");
        int r1 = r11.size() + r10.size();
        int r2 = 0;
        if (r9 == null) goto L5;
        int r4 = 1;
    L6:
        ArrayList r0 = new ArrayList((r1 + r4) + 1);
        List<? extends KotlinType> r15 = r10;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<T> r16 = r15.iterator();
    L8:
        if (r16.hasNext() == false) goto L10;
        r3.add(TypeUtilsKt.asTypeProjection((KotlinType) r16.next()));
        goto L8
    L10:
        r0.addAll(r3);
        ArrayList r17 = r0;
        if (r9 == null) goto L13;
        TypeProjection r18 = TypeUtilsKt.asTypeProjection(r9);
    L14:
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r17, r18);
        Iterator<T> r19 = r11.iterator();
    L16:
        if (r19.hasNext() == false) goto L31;
        Object r110 = r19.next();
        int r5 = r2 + 1;
        if (r2 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        KotlinType r111 = (KotlinType) r110;
        if (r12 == null) goto L27;
        Name r6 = r12.get(r2);
        if (r6 == null) goto L27;
        if (r6.isSpecial() == true) goto L27;
    L28:
        if (r6 == null) goto L30;
        FqName r7 = StandardNames.FqNames.parameterName;
        Name r8 = Name.identifier("name");
        String r20 = r6.asString();
        Intrinsics.checkNotNullExpressionValue(r20, "name.asString()");
        r111 = TypeUtilsKt.replaceAnnotations(r111, Annotations.Companion.create(CollectionsKt.plus(r111.getAnnotations(), new BuiltInAnnotationDescriptor(r14, r7, MapsKt.mapOf(TuplesKt.to(r8, new StringValue(r20)))))));
    L30:
        r17.add(TypeUtilsKt.asTypeProjection(r111));
        r2 = r5;
    L27:
        r6 = null;
        goto L28
    L31:
        r0.add(TypeUtilsKt.asTypeProjection(r13));
        return r0;
    L13:
        r18 = null;
        goto L14
    L5:
        r4 = 0;
        goto L6
    }

    public static /* synthetic */ SimpleType createFunctionType$default(KotlinBuiltIns r9, Annotations r10, KotlinType r11, List r12, List r13, List r14, KotlinType r15, boolean r16, int r17, Object r18) {
        if ((r17 & 128) == 0) goto L5;
        boolean r8 = false;
    L7:
        return createFunctionType(r9, r10, r11, r12, r13, r14, r15, r8);
    L5:
        r8 = r16;
        goto L7
    }

    public static final SimpleType createFunctionType(KotlinBuiltIns r6, Annotations r7, KotlinType r8, List<? extends KotlinType> r9, List<? extends KotlinType> r10, List<Name> r11, KotlinType r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r6, "builtIns");
        Intrinsics.checkNotNullParameter(r7, "annotations");
        Intrinsics.checkNotNullParameter(r9, "contextReceiverTypes");
        Intrinsics.checkNotNullParameter(r10, "parameterTypes");
        Intrinsics.checkNotNullParameter(r12, "returnType");
        List<TypeProjection> r14 = getFunctionTypeArgumentProjections(r8, r9, r10, r11, r12, r6);
        int r15 = r10.size() + r9.size();
        if (r8 != null) goto L5;
        int r0 = 0;
    L6:
        ClassDescriptor r16 = getFunctionDescriptor(r6, r15 + r0, r13);
        if (r8 == null) goto L10;
        r7 = withExtensionFunctionAnnotation(r7, r6);
    L10:
        if ((!r9.isEmpty()) == false) goto L13;
        r7 = withContextReceiversFunctionAnnotation(r7, r6, r9.size());
    L13:
        return KotlinTypeFactory.simpleNotNullType(TypeAttributesKt.toDefaultAttributes(r7), r16, r14);
    L5:
        r0 = 1;
        goto L6
    }

    public static final Annotations withExtensionFunctionAnnotation(Annotations r4, KotlinBuiltIns r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "builtIns");
        if (r4.hasAnnotation(StandardNames.FqNames.extensionFunctionType) == false) goto L6;
        return r4;
    L6:
        return Annotations.Companion.create(CollectionsKt.plus(r4, new BuiltInAnnotationDescriptor(r5, StandardNames.FqNames.extensionFunctionType, MapsKt.emptyMap())));
    }

    public static final Annotations withContextReceiversFunctionAnnotation(Annotations r5, KotlinBuiltIns r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "builtIns");
        if (r5.hasAnnotation(StandardNames.FqNames.contextFunctionTypeParams) == false) goto L6;
        return r5;
    L6:
        return Annotations.Companion.create(CollectionsKt.plus(r5, new BuiltInAnnotationDescriptor(r6, StandardNames.FqNames.contextFunctionTypeParams, MapsKt.mapOf(TuplesKt.to(StandardNames.CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME, new IntValue(r7))))));
    }

    public static final ClassDescriptor getFunctionDescriptor(KotlinBuiltIns r1, int r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "builtIns");
        if (r3 == false) goto L5;
        ClassDescriptor r4 = r1.getSuspendFunction(r2);
    L6:
        Intrinsics.checkNotNullExpressionValue(r4, "if (isSuspendFunction) b…tFunction(parameterCount)");
        return r4;
    L5:
        r4 = r1.getFunction(r2);
        goto L6
    }
}
