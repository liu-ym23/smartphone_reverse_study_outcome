package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* JADX INFO: compiled from: specialBuiltinMembers.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class BuiltinMethodsWithDifferentJvmName extends SpecialGenericSignatures {
    public static final BuiltinMethodsWithDifferentJvmName INSTANCE = null;

    static {
        INSTANCE = new BuiltinMethodsWithDifferentJvmName();
    }

    private BuiltinMethodsWithDifferentJvmName() {
    }

    public final Name getJvmName(SimpleFunctionDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "functionDescriptor");
        Map<String, Name> r0 = SpecialGenericSignatures.Companion.getSIGNATURE_TO_JVM_REPRESENTATION_NAME();
        String r2 = MethodSignatureMappingKt.computeJvmSignature(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r0.get(r2);
    }

    public final boolean isBuiltinFunctionWithDifferentNameInJvm(final SimpleFunctionDescriptor r4) {
        Intrinsics.checkNotNullParameter(r4, "functionDescriptor");
        if (KotlinBuiltIns.isBuiltIn(r4) == true) goto L5;
        return false;
    L5:
        if (DescriptorUtilsKt.firstOverridden$default(r4, false, new AnonymousClass1(r4), 1, null) != null) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean isRemoveAtByIndex(SimpleFunctionDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (Intrinsics.areEqual(r2.getName().asString(), "removeAt") == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmSignature(r2), SpecialGenericSignatures.Companion.getREMOVE_AT_NAME_AND_SIGNATURE().getSignature()) == false) goto L7;
        return true;
    }
}
