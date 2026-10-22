package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JavaDescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;

/* JADX INFO: compiled from: FieldOverridabilityCondition.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class FieldOverridabilityCondition implements ExternalOverridabilityCondition {
    public FieldOverridabilityCondition() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Result isOverridable(CallableDescriptor r1, CallableDescriptor r2, ClassDescriptor r3) {
        Intrinsics.checkNotNullParameter(r1, "superDescriptor");
        Intrinsics.checkNotNullParameter(r2, "subDescriptor");
        if ((r2 instanceof PropertyDescriptor) == false) goto L27;
        if ((r1 instanceof PropertyDescriptor) == false) goto L27;
        PropertyDescriptor r4 = (PropertyDescriptor) r2;
        PropertyDescriptor r5 = (PropertyDescriptor) r1;
        if (Intrinsics.areEqual(r4.getName(), r5.getName()) == true) goto L12;
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    L12:
        if (JavaDescriptorUtilKt.isJavaField(r4) == false) goto L18;
        if (JavaDescriptorUtilKt.isJavaField(r5) == false) goto L18;
        return ExternalOverridabilityCondition.Result.OVERRIDABLE;
    L18:
        if (JavaDescriptorUtilKt.isJavaField(r4) == true) goto L25;
        if (JavaDescriptorUtilKt.isJavaField(r5) == true) goto L25;
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    L25:
        return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
    L27:
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Contract getContract() {
        return ExternalOverridabilityCondition.Contract.BOTH;
    }
}
