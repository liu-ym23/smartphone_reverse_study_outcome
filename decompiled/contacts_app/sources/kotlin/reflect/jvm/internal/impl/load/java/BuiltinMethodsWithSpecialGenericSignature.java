package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* JADX INFO: compiled from: specialBuiltinMembers.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class BuiltinMethodsWithSpecialGenericSignature extends SpecialGenericSignatures {
    public static final BuiltinMethodsWithSpecialGenericSignature INSTANCE = null;

    static {
        INSTANCE = new BuiltinMethodsWithSpecialGenericSignature();
    }

    private BuiltinMethodsWithSpecialGenericSignature() {
    }

    public static final /* synthetic */ boolean access$getHasErasedValueParametersInJava(BuiltinMethodsWithSpecialGenericSignature r0, CallableMemberDescriptor r1) {
        return r0.getHasErasedValueParametersInJava(r1);
    }

    private final boolean getHasErasedValueParametersInJava(CallableMemberDescriptor r1) {
        return CollectionsKt.contains(SpecialGenericSignatures.Companion.getERASED_VALUE_PARAMETERS_SIGNATURES(), MethodSignatureMappingKt.computeJvmSignature(r1));
    }

    @JvmStatic
    public static final FunctionDescriptor getOverriddenBuiltinFunctionWithErasedValueParametersInJava(FunctionDescriptor r4) {
        Intrinsics.checkNotNullParameter(r4, "functionDescriptor");
        BuiltinMethodsWithSpecialGenericSignature r0 = INSTANCE;
        Name r1 = r4.getName();
        Intrinsics.checkNotNullExpressionValue(r1, "functionDescriptor.name");
        if (r0.getSameAsBuiltinMethodWithErasedValueParameters(r1) == true) goto L6;
        return null;
    L6:
        return (FunctionDescriptor) DescriptorUtilsKt.firstOverridden$default(r4, false, AnonymousClass1.INSTANCE, 1, null);
    }

    public final boolean getSameAsBuiltinMethodWithErasedValueParameters(Name r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return SpecialGenericSignatures.Companion.getERASED_VALUE_PARAMETERS_SHORT_NAMES().contains(r1);
    }

    @JvmStatic
    public static final SpecialGenericSignatures.SpecialSignatureInfo getSpecialSignatureInfo(CallableMemberDescriptor r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (SpecialGenericSignatures.Companion.getERASED_VALUE_PARAMETERS_SHORT_NAMES().contains(r4.getName()) == true) goto L5;
        return null;
    L5:
        CallableMemberDescriptor r5 = DescriptorUtilsKt.firstOverridden$default(r4, false, BuiltinMethodsWithSpecialGenericSignature$getSpecialSignatureInfo$builtinSignature$1.INSTANCE, 1, null);
        if (r5 == null) goto L12;
        String r6 = MethodSignatureMappingKt.computeJvmSignature(r5);
        if (r6 == null) goto L12;
        return SpecialGenericSignatures.Companion.getSpecialSignatureInfo(r6);
    L12:
        return null;
    }
}
