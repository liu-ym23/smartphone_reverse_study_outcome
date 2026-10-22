package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class BooleanValue extends ConstantValue<Boolean> {
    public BooleanValue(boolean r1) {
        super(Boolean.valueOf(r1));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public /* bridge */ /* synthetic */ KotlinType getType(ModuleDescriptor r1) {
        return getType(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public SimpleType getType(ModuleDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "module");
        SimpleType r0 = r1.getBuiltIns().getBooleanType();
        Intrinsics.checkNotNullExpressionValue(r0, "module.builtIns.booleanType");
        return r0;
    }
}
