package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes4.dex */
final class IsKPropertyCheck implements Check {
    public static final IsKPropertyCheck INSTANCE = null;
    private static final String description = null;

    private IsKPropertyCheck() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String invoke(FunctionDescriptor r1) {
        return Check.DefaultImpls.invoke(this, r1);
    }

    static {
        INSTANCE = new IsKPropertyCheck();
        description = "second parameter must be of type KProperty<*> or its supertype";
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String getDescription() {
        return description;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public boolean check(FunctionDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "functionDescriptor");
        ValueParameterDescriptor r1 = r2.getValueParameters().get(1);
        ReflectionTypes.Companion r3 = ReflectionTypes.Companion;
        Intrinsics.checkNotNullExpressionValue(r1, "secondParameter");
        KotlinType r4 = r3.createKPropertyStarType(DescriptorUtilsKt.getModule(r1));
        if (r4 == null) goto L5;
        KotlinType r5 = r1.getType();
        Intrinsics.checkNotNullExpressionValue(r5, "secondParameter.type");
        return TypeUtilsKt.isSubtypeOf(r4, TypeUtilsKt.makeNotNullable(r5));
    L5:
        return false;
    }
}
