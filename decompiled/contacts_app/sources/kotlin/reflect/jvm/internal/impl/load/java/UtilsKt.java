package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;

/* JADX INFO: compiled from: utils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UtilsKt {
    public static final DescriptorVisibility toDescriptorVisibility(Visibility r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        DescriptorVisibility r2 = JavaDescriptorVisibilities.toDescriptorVisibility(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "toDescriptorVisibility(this)");
        return r2;
    }

    public static final boolean isJspecifyEnabledInStrictMode(JavaTypeEnhancementState r1) {
        Intrinsics.checkNotNullParameter(r1, "javaTypeEnhancementState");
        if (r1.getGetReportLevelForAnnotation().invoke(JavaNullabilityAnnotationSettingsKt.getJSPECIFY_ANNOTATIONS_PACKAGE()) != ReportLevel.STRICT) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean hasErasedValueParameters(CallableMemberDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "memberDescriptor");
        if ((r2 instanceof FunctionDescriptor) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r2.getUserData(JavaMethodDescriptor.HAS_ERASED_VALUE_PARAMETERS), true) == false) goto L7;
        return true;
    }
}
