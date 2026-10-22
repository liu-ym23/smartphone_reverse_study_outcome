package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ConstantValue<T> {
    private final T value;

    public abstract KotlinType getType(ModuleDescriptor r1);

    public ConstantValue(T r1) {
        this.value = r1;
    }

    public T getValue() {
        return this.value;
    }

    public boolean equals(Object r3) {
        if (this == r3) goto L13;
        T r2 = getValue();
        Object r1 = null;
        if ((r3 instanceof ConstantValue) == false) goto L6;
        ConstantValue r4 = (ConstantValue) r3;
    L7:
        if (r4 == null) goto L10;
        r1 = r4.getValue();
    L10:
        if (Intrinsics.areEqual(r2, r1) == true) goto L13;
        return false;
    L6:
        r4 = null;
    L13:
        return true;
    }

    public int hashCode() {
        T r0 = getValue();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
