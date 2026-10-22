package kotlin.reflect.jvm.internal.impl.load.kotlin;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: compiled from: methodSignatureMapping.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class MethodSignatureMappingKt {
    public static final String computeJvmDescriptor(FunctionDescriptor r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        StringBuilder r0 = new StringBuilder();
        if (r5 == true) goto L5;
    L9:
        r0.append("(");
        ReceiverParameterDescriptor r6 = r3.getExtensionReceiverParameter();
        if (r6 == null) goto L12;
        KotlinType r7 = r6.getType();
        Intrinsics.checkNotNullExpressionValue(r7, "it.type");
        appendErasedType(r0, r7);
    L12:
        Iterator<ValueParameterDescriptor> r8 = r3.getValueParameters().iterator();
    L14:
        if (r8.hasNext() == false) goto L16;
        KotlinType r1 = r8.next().getType();
        Intrinsics.checkNotNullExpressionValue(r1, "parameter.type");
        appendErasedType(r0, r1);
        goto L14
    L16:
        r0.append(")");
        if (r4 == true) goto L19;
    L22:
        String r9 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r9, "StringBuilder().apply(builderAction).toString()");
        return r9;
    L19:
        if (DescriptorBasedTypeSignatureMappingKt.hasVoidReturnType(r3) == false) goto L21;
        r0.append(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        goto L22
    L21:
        KotlinType r10 = r3.getReturnType();
        Intrinsics.checkNotNull(r10);
        appendErasedType(r0, r10);
        goto L22
    L5:
        if ((r3 instanceof ConstructorDescriptor) == false) goto L7;
        String r11 = "<init>";
    L8:
        r0.append(r11);
        goto L9
    L7:
        r11 = r3.getName().asString();
        Intrinsics.checkNotNullExpressionValue(r11, "name.asString()");
        goto L8
    }

    public static /* synthetic */ String computeJvmDescriptor$default(FunctionDescriptor r1, boolean r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = true;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = true;
    L9:
        return computeJvmDescriptor(r1, r2, r3);
    }

    public static final boolean forceSingleValueParameterBoxing(CallableDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "f");
        if ((r5 instanceof FunctionDescriptor) == true) goto L5;
        return false;
    L5:
        FunctionDescriptor r0 = (FunctionDescriptor) r5;
        if (Intrinsics.areEqual(r0.getName().asString(), "remove") == true) goto L8;
        return false;
    L8:
        if (r0.getValueParameters().size() == 1) goto L10;
        return false;
    L10:
        if (SpecialBuiltinMembers.isFromJavaOrBuiltins((CallableMemberDescriptor) r5) == true) goto L37;
        List<ValueParameterDescriptor> r6 = r0.getOriginal().getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r6, "f.original.valueParameters");
        KotlinType r7 = ((ValueParameterDescriptor) CollectionsKt.single(r6)).getType();
        Intrinsics.checkNotNullExpressionValue(r7, "f.original.valueParameters.single().type");
        JvmType r8 = mapToJvmType(r7);
        JvmPrimitiveType r4 = null;
        if ((r8 instanceof JvmType.Primitive) == false) goto L15;
        JvmType.Primitive r9 = (JvmType.Primitive) r8;
    L16:
        if (r9 == null) goto L19;
        r4 = r9.getJvmPrimitiveType();
    L19:
        if (r4 == JvmPrimitiveType.INT) goto L21;
        return false;
    L21:
        FunctionDescriptor r10 = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(r0);
        if (r10 != null) goto L24;
        return false;
    L24:
        List<ValueParameterDescriptor> r1 = r10.getOriginal().getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r1, "overridden.original.valueParameters");
        KotlinType r2 = ((ValueParameterDescriptor) CollectionsKt.single(r1)).getType();
        Intrinsics.checkNotNullExpressionValue(r2, "overridden.original.valueParameters.single().type");
        JvmType r3 = mapToJvmType(r2);
        DeclarationDescriptor r11 = r10.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(r11, "overridden.containingDeclaration");
        if (Intrinsics.areEqual(DescriptorUtilsKt.getFqNameUnsafe(r11), StandardNames.FqNames.mutableCollection.toUnsafe()) == true) goto L27;
        return false;
    L27:
        if ((r3 instanceof JvmType.Object) == true) goto L29;
        return false;
    L29:
        if (Intrinsics.areEqual(((JvmType.Object) r3).getInternalName(), "java/lang/Object") == true) goto L31;
        return false;
    L31:
        return true;
    L15:
        r9 = null;
        goto L16
    L37:
        return false;
    }

    public static final String getInternalName(ClassDescriptor r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        JavaToKotlinClassMap r0 = JavaToKotlinClassMap.INSTANCE;
        FqNameUnsafe r1 = DescriptorUtilsKt.getFqNameSafe(r3).toUnsafe();
        Intrinsics.checkNotNullExpressionValue(r1, "fqNameSafe.toUnsafe()");
        ClassId r2 = r0.mapKotlinToJava(r1);
        if (r2 == null) goto L7;
        String r4 = JvmClassName.byClassId(r2).getInternalName();
        Intrinsics.checkNotNullExpressionValue(r4, "byClassId(it).internalName");
        return r4;
    L7:
        return DescriptorBasedTypeSignatureMappingKt.computeInternalName$default(r3, null, 2, null);
    }

    private static final void appendErasedType(StringBuilder r0, KotlinType r1) {
        r0.append(mapToJvmType(r1));
    }

    public static final JvmType mapToJvmType(KotlinType r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        return (JvmType) DescriptorBasedTypeSignatureMappingKt.mapType$default(r9, JvmTypeFactoryImpl.INSTANCE, TypeMappingMode.DEFAULT, TypeMappingConfigurationImpl.INSTANCE, null, null, 32, null);
    }

    public static final String computeJvmSignature(CallableDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        SignatureBuildingComponents r0 = SignatureBuildingComponents.INSTANCE;
        if (DescriptorUtils.isLocal(r5) == false) goto L5;
        return null;
    L5:
        DeclarationDescriptor r1 = r5.getContainingDeclaration();
        if ((r1 instanceof ClassDescriptor) == false) goto L8;
        ClassDescriptor r2 = (ClassDescriptor) r1;
    L9:
        if (r2 != null) goto L12;
        return null;
    L12:
        if (r2.getName().isSpecial() == false) goto L14;
        return null;
    L14:
        CallableDescriptor r6 = r5.getOriginal();
        if ((r6 instanceof SimpleFunctionDescriptor) == false) goto L17;
        SimpleFunctionDescriptor r7 = (SimpleFunctionDescriptor) r6;
    L18:
        if (r7 != null) goto L21;
        return null;
    L21:
        return MethodSignatureBuildingUtilsKt.signature(r0, r2, computeJvmDescriptor$default(r7, false, false, 3, null));
    L17:
        r7 = null;
        goto L18
    L8:
        r2 = null;
        goto L9
    }
}
