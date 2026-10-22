package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes4.dex */
public class ArrayValue extends ConstantValue<List<? extends ConstantValue<?>>> {
    private final Function1<ModuleDescriptor, KotlinType> computeType;

    /* JADX WARN: Multi-variable type inference failed */
    public ArrayValue(List<? extends ConstantValue<?>> r2, Function1<? super ModuleDescriptor, ? extends KotlinType> r3) {
        Intrinsics.checkNotNullParameter(r2, "value");
        Intrinsics.checkNotNullParameter(r3, "computeType");
        super(r2);
        this.computeType = r3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public KotlinType getType(ModuleDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "module");
        KotlinType r1 = this.computeType.invoke(r2);
        if (KotlinBuiltIns.isArray(r1) == false) goto L5;
    L7:
        return r1;
    L5:
        if (KotlinBuiltIns.isPrimitiveArray(r1) == true) goto L7;
        KotlinBuiltIns.isUnsignedArrayType(r1);
        goto L7
    }
}
