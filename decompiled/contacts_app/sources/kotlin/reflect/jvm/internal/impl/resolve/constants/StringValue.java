package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.text.Typography;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class StringValue extends ConstantValue<String> {
    public StringValue(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        super(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public /* bridge */ /* synthetic */ KotlinType getType(ModuleDescriptor r1) {
        return getType(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public SimpleType getType(ModuleDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "module");
        SimpleType r0 = r1.getBuiltIns().getStringType();
        Intrinsics.checkNotNullExpressionValue(r0, "module.builtIns.stringType");
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public String toString() {
        return "\"" + getValue() + Typography.quote;
    }
}
