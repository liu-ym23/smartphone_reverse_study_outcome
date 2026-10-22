package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedure;

/* JADX INFO: compiled from: specialBuiltinMembers.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class SpecialBuiltinMembers {
    public static final <T extends CallableMemberDescriptor> T getOverriddenBuiltinWithDifferentJvmName(T r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (SpecialGenericSignatures.Companion.getORIGINAL_SHORT_NAMES().contains(r4.getName()) == true) goto L8;
        if (BuiltinSpecialProperties.INSTANCE.getSPECIAL_SHORT_NAMES().contains(DescriptorUtilsKt.getPropertyIfAccessor(r4).getName()) == true) goto L8;
        return null;
    L8:
        if ((r4 instanceof PropertyDescriptor) == false) goto L10;
        boolean r0 = true;
    L12:
        if (r0 == false) goto L15;
        return (T) DescriptorUtilsKt.firstOverridden$default(r4, false, AnonymousClass1.INSTANCE, 1, null);
    L15:
        if ((r4 instanceof SimpleFunctionDescriptor) == true) goto L17;
        return null;
    L17:
        return (T) DescriptorUtilsKt.firstOverridden$default(r4, false, AnonymousClass2.INSTANCE, 1, null);
    L10:
        r0 = r4 instanceof PropertyAccessorDescriptor;
        goto L12
    }

    public static final boolean doesOverrideBuiltinWithDifferentJvmName(CallableMemberDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (getOverriddenBuiltinWithDifferentJvmName(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <T extends CallableMemberDescriptor> T getOverriddenSpecialBuiltin(T r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        T r0 = (T) getOverriddenBuiltinWithDifferentJvmName(r4);
        if (r0 == null) goto L5;
        return r0;
    L5:
        BuiltinMethodsWithSpecialGenericSignature r1 = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
        Name r2 = r4.getName();
        Intrinsics.checkNotNullExpressionValue(r2, "name");
        if (r1.getSameAsBuiltinMethodWithErasedValueParameters(r2) == true) goto L9;
        return null;
    L9:
        return (T) DescriptorUtilsKt.firstOverridden$default(r4, false, C04662.INSTANCE, 1, null);
    }

    public static final String getJvmMethodNameIfSpecial(CallableMemberDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "callableMemberDescriptor");
        CallableMemberDescriptor r3 = getOverriddenBuiltinThatAffectsJvmName(r2);
        if (r3 == null) goto L16;
        CallableMemberDescriptor r4 = DescriptorUtilsKt.getPropertyIfAccessor(r3);
        if (r4 != null) goto L8;
        return null;
    L8:
        if ((r4 instanceof PropertyDescriptor) == false) goto L11;
        return ClassicBuiltinSpecialProperties.INSTANCE.getBuiltinSpecialPropertyGetterName(r4);
    L11:
        if ((r4 instanceof SimpleFunctionDescriptor) == false) goto L18;
        Name r5 = BuiltinMethodsWithDifferentJvmName.INSTANCE.getJvmName((SimpleFunctionDescriptor) r4);
        if (r5 != null) goto L15;
        return null;
    L15:
        return r5.asString();
    L18:
        return null;
    L16:
        return null;
    }

    private static final CallableMemberDescriptor getOverriddenBuiltinThatAffectsJvmName(CallableMemberDescriptor r1) {
        if (KotlinBuiltIns.isBuiltIn(r1) == true) goto L7;
        return null;
    L7:
        return getOverriddenBuiltinWithDifferentJvmName(r1);
    }

    public static final boolean hasRealKotlinSuperClassWithOverrideOf(ClassDescriptor r3, CallableDescriptor r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "specialCallableDescriptor");
        DeclarationDescriptor r5 = r4.getContainingDeclaration();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        SimpleType r6 = ((ClassDescriptor) r5).getDefaultType();
        Intrinsics.checkNotNullExpressionValue(r6, "specialCallableDescripto…ssDescriptor).defaultType");
        ClassDescriptor r7 = DescriptorUtils.getSuperClassDescriptor(r3);
    L3:
        boolean r0 = false;
        if (r7 == null) goto L14;
        if ((r7 instanceof JavaClassDescriptor) == true) goto L13;
        if (TypeCheckingProcedure.findCorrespondingSupertype(r7.getDefaultType(), r6) == null) goto L10;
        r0 = true;
    L10:
        if (r0 == false) goto L13;
        return !KotlinBuiltIns.isBuiltIn(r7);
    L13:
        r7 = DescriptorUtils.getSuperClassDescriptor(r7);
        goto L3
    L14:
        return false;
    }

    public static final boolean isFromJava(CallableMemberDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return DescriptorUtilsKt.getPropertyIfAccessor(r1).getContainingDeclaration() instanceof JavaClassDescriptor;
    }

    public static final boolean isFromJavaOrBuiltins(CallableMemberDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (isFromJava(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (KotlinBuiltIns.isBuiltIn(r1) == true) goto L8;
        return false;
    }
}
