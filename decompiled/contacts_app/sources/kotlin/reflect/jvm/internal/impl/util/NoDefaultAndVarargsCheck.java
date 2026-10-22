package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes4.dex */
final class NoDefaultAndVarargsCheck implements Check {
    public static final NoDefaultAndVarargsCheck INSTANCE = null;
    private static final String description = null;

    private NoDefaultAndVarargsCheck() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String invoke(FunctionDescriptor r1) {
        return Check.DefaultImpls.invoke(this, r1);
    }

    static {
        INSTANCE = new NoDefaultAndVarargsCheck();
        description = "should not have varargs or parameters with default values";
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String getDescription() {
        return description;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public boolean check(FunctionDescriptor r4) {
        Intrinsics.checkNotNullParameter(r4, "functionDescriptor");
        List<ValueParameterDescriptor> r3 = r4.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r3, "functionDescriptor.valueParameters");
        List<ValueParameterDescriptor> r5 = r3;
        if ((r5 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L25;
        ValueParameterDescriptor r7 = (ValueParameterDescriptor) r6.next();
        Intrinsics.checkNotNullExpressionValue(r7, "it");
        if (DescriptorUtilsKt.declaresOrInheritsDefaultValue(r7) == false) goto L13;
    L15:
        boolean r8 = false;
    L16:
        if (r8 == true) goto L9;
        return false;
    L13:
        if (r7.getVarargElementType() != null) goto L15;
        r8 = true;
        goto L16
    L25:
        return true;
    L5:
        if (r5.isEmpty() == false) goto L7;
        return true;
    }
}
