package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: compiled from: DeserializedArrayValue.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DeserializedArrayValue extends ArrayValue {
    private final KotlinType type;

    public DeserializedArrayValue(List<? extends ConstantValue<?>> r2, final KotlinType r3) {
        Intrinsics.checkNotNullParameter(r2, "value");
        Intrinsics.checkNotNullParameter(r3, "type");
        super(r2, new AnonymousClass1(r3));
        this.type = r3;
    }

    public final KotlinType getType() {
        return this.type;
    }
}
