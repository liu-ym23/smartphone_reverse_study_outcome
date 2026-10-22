package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.ExpandedTypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: compiled from: descriptorBasedTypeSignatureMapping.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DescriptorBasedTypeSignatureMappingKt {
    public static /* synthetic */ Object mapType$default(KotlinType r6, JvmTypeFactory r7, TypeMappingMode r8, TypeMappingConfiguration r9, JvmDescriptorTypeWriter r10, Function3 r11, int r12, Object r13) {
        if ((r12 & 32) == 0) goto L6;
        r11 = FunctionsKt.getDO_NOTHING_3();
    L6:
        return mapType(r6, r7, r8, r9, r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v10, types: [T, java.lang.Object] */
    public static final <T> T mapType(KotlinType r8, JvmTypeFactory<T> r9, TypeMappingMode r10, TypeMappingConfiguration<? extends T> r11, JvmDescriptorTypeWriter<T> r12, Function3<? super KotlinType, ? super T, ? super TypeMappingMode, Unit> r13) {
        Intrinsics.checkNotNullParameter(r8, "kotlinType");
        Intrinsics.checkNotNullParameter(r9, "factory");
        Intrinsics.checkNotNullParameter(r10, "mode");
        Intrinsics.checkNotNullParameter(r11, "typeMappingConfiguration");
        Intrinsics.checkNotNullParameter(r13, "writeGenericType");
        KotlinType r1 = r11.preprocessType(r8);
        if (r1 == null) goto L7;
        return (T) mapType(r1, r9, r10, r11, r12, r13);
    L7:
        if (FunctionTypesKt.isSuspendFunctionType(r8) == true) goto L9;
        KotlinType r2 = r8;
        Object r0 = TypeSignatureMappingKt.mapBuiltInType(SimpleClassicTypeSystemContext.INSTANCE, r2, r9, r10);
        if (r0 == null) goto L14;
        ?? r14 = (Object) TypeSignatureMappingKt.boxTypeIfNeeded(r9, r0, r10.getNeedPrimitiveBoxing());
        r13.invoke(r8, r14, r10);
        return r14;
    L14:
        TypeConstructor r3 = r8.getConstructor();
        if ((r3 instanceof IntersectionTypeConstructor) == false) goto L21;
        IntersectionTypeConstructor r4 = (IntersectionTypeConstructor) r3;
        KotlinType r15 = r4.getAlternativeType();
        if (r15 != null) goto L20;
        r15 = r11.commonSupertype(r4.mo2084getSupertypes());
    L20:
        return (T) mapType(TypeUtilsKt.replaceArgumentsWithStarProjections(r15), r9, r10, r11, r12, r13);
    L21:
        ClassifierDescriptor r5 = r3.mo2083getDeclarationDescriptor();
        if (r5 == null) goto L90;
        ClassifierDescriptor r6 = r5;
        if (ErrorUtils.isError(r6) == false) goto L29;
        T r16 = (T) r9.createObjectType("error/NonExistentClass");
        r11.processErrorType(r8, (ClassDescriptor) r5);
        if (r12 == 0) goto L28;
        r12.writeClass(r16);
    L28:
        return r16;
    L29:
        boolean r7 = r5 instanceof ClassDescriptor;
        if (r7 == true) goto L32;
    L49:
        if (r7 == false) goto L73;
        if (InlineClassesUtilsKt.isInlineClass(r6) == false) goto L59;
        if (r10.getNeedInlineClassWrapping() == true) goto L59;
        KotlinType r17 = (KotlinType) ExpandedTypeUtilsKt.computeExpandedTypeForInlineClass(SimpleClassicTypeSystemContext.INSTANCE, r2);
        if (r17 == null) goto L59;
        return (T) mapType(r17, r9, r10.wrapInlineClassesMode(), r11, r12, r13);
    L59:
        if (r10.isForAnnotationParameter() == true) goto L61;
    L63:
        ClassDescriptor r18 = (ClassDescriptor) r5;
        ClassDescriptor r19 = r18.getOriginal();
        Intrinsics.checkNotNullExpressionValue(r19, "descriptor.original");
        T r110 = r11.getPredefinedTypeForClass(r19);
        if (r110 == null) goto L66;
        T r20 = (Object) r110;
    L70:
        r13.invoke(r8, r20, r10);
        return r20;
    L66:
        if (r18.getKind() != ClassKind.ENUM_ENTRY) goto L68;
        DeclarationDescriptor r111 = r18.getContainingDeclaration();
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        r18 = (ClassDescriptor) r111;
    L68:
        ClassDescriptor r112 = r18.getOriginal();
        Intrinsics.checkNotNullExpressionValue(r112, "enumClassIfEnumEntry.original");
        r20 = (Object) r9.createObjectType(computeInternalName(r112, r11));
        goto L70
    L61:
        if (KotlinBuiltIns.isKClass((ClassDescriptor) r5) == false) goto L63;
        r20 = (Object) r9.getJavaLangClassType();
        goto L70
    L73:
        if ((r5 instanceof TypeParameterDescriptor) == false) goto L82;
        KotlinType r113 = TypeUtilsKt.getRepresentativeUpperBound((TypeParameterDescriptor) r5);
        if (r8.isMarkedNullable() == false) goto L77;
        r113 = TypeUtilsKt.makeNullable(r113);
    L77:
        T r21 = (T) mapType(r113, r9, r10, r11, null, FunctionsKt.getDO_NOTHING_3());
        if (r12 == 0) goto L80;
        Name r22 = r5.getName();
        Intrinsics.checkNotNullExpressionValue(r22, "descriptor.getName()");
        r12.writeTypeVariable(r22, r21);
    L80:
        return r21;
    L82:
        if ((r5 instanceof TypeAliasDescriptor) == false) goto L88;
        if (r10.getMapTypeAliases() == false) goto L88;
        return (T) mapType(((TypeAliasDescriptor) r5).getExpandedType(), r9, r10, r11, r12, r13);
    L88:
        throw new UnsupportedOperationException("Unknown type " + r8);
    L32:
        if (KotlinBuiltIns.isArray(r8) == false) goto L49;
        if (r8.getArguments().size() != 1) goto L48;
        TypeProjection r23 = r8.getArguments().get(0);
        KotlinType r24 = r23.getType();
        Intrinsics.checkNotNullExpressionValue(r24, "memberProjection.type");
        if (r23.getProjectionKind() != Variance.IN_VARIANCE) goto L40;
        Object r25 = r9.createObjectType("java/lang/Object");
        if (r12 == 0) goto L46;
        r12.writeArrayType();
        r12.writeClass(r25);
        r12.writeArrayEnd();
    L46:
        return (T) r9.createFromString("[" + r9.toString(r25));
    L40:
        if (r12 == 0) goto L42;
        r12.writeArrayType();
    L42:
        Variance r26 = r23.getProjectionKind();
        Intrinsics.checkNotNullExpressionValue(r26, "memberProjection.projectionKind");
        r25 = mapType(r24, r9, r10.toGenericArgumentMode(r26, true), r11, r12, r13);
        if (r12 == 0) goto L46;
        r12.writeArrayEnd();
        goto L46
    L48:
        throw new UnsupportedOperationException("arrays must have one type argument");
    L90:
        throw new UnsupportedOperationException("no descriptor for type constructor of " + r8);
    L9:
        return (T) mapType(SuspendFunctionTypesKt.transformSuspendFunctionToRuntimeFunctionType(r8), r9, r10, r11, r12, r13);
    }

    public static final boolean hasVoidReturnType(CallableDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        if ((r2 instanceof ConstructorDescriptor) == false) goto L5;
        return true;
    L5:
        KotlinType r0 = r2.getReturnType();
        Intrinsics.checkNotNull(r0);
        if (KotlinBuiltIns.isUnit(r0) == false) goto L12;
        KotlinType r1 = r2.getReturnType();
        Intrinsics.checkNotNull(r1);
        if (TypeUtils.isNullableType(r1) == true) goto L12;
        if ((r2 instanceof PropertyGetterDescriptor) == true) goto L12;
        return true;
    L12:
        return false;
    }

    public static /* synthetic */ String computeInternalName$default(ClassDescriptor r0, TypeMappingConfigurationImpl r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L6;
        r1 = TypeMappingConfigurationImpl.INSTANCE;
    L6:
        return computeInternalName(r0, r1);
    }

    public static final String computeInternalName(ClassDescriptor r8, TypeMappingConfiguration<?> r9) {
        Intrinsics.checkNotNullParameter(r8, "klass");
        Intrinsics.checkNotNullParameter(r9, "typeMappingConfiguration");
        String r0 = r9.getPredefinedFullInternalNameForClass(r8);
        if (r0 == null) goto L5;
        return r0;
    L5:
        DeclarationDescriptor r1 = r8.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(r1, "klass.containingDeclaration");
        String r2 = SpecialNames.safeIdentifier(r8.getName()).getIdentifier();
        Intrinsics.checkNotNullExpressionValue(r2, "safeIdentifier(klass.name).identifier");
        if ((r1 instanceof PackageFragmentDescriptor) == false) goto L13;
        FqName r10 = ((PackageFragmentDescriptor) r1).getFqName();
        if (r10.isRoot() == true) goto L24;
        StringBuilder r11 = new StringBuilder();
        String r3 = r10.asString();
        Intrinsics.checkNotNullExpressionValue(r3, "fqName.asString()");
        return r11.append(StringsKt.replace$default(r3, '.', '/', false, 4, null)).append('/').append(r2).toString();
    L24:
        return r2;
    L13:
        if ((r1 instanceof ClassDescriptor) == false) goto L15;
        ClassDescriptor r4 = (ClassDescriptor) r1;
    L16:
        if (r4 == null) goto L23;
        String r12 = r9.getPredefinedInternalNameForClass(r4);
        if (r12 != null) goto L21;
        r12 = computeInternalName(r4, r9);
    L21:
        return r12 + Typography.dollar + r2;
    L23:
        throw new IllegalArgumentException("Unexpected container: " + r1 + " for " + r8);
    L15:
        r4 = null;
        goto L16
    }
}
