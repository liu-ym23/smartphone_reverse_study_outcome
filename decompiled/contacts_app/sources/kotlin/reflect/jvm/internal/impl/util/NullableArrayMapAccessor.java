package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: ArrayMapOwner.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class NullableArrayMapAccessor<K, V, T extends V> extends AbstractArrayMapOwner.AbstractArrayMapAccessor<K, V, T> implements ReadOnlyProperty<AbstractArrayMapOwner<K, V>, V> {
    @Override // kotlin.properties.ReadOnlyProperty
    public /* bridge */ /* synthetic */ Object getValue(Object r1, KProperty r2) {
        return getValue((AbstractArrayMapOwner) r1, r2);
    }

    public NullableArrayMapAccessor(KClass<? extends K> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        super(r2, r3);
    }

    public T getValue(AbstractArrayMapOwner<K, V> r2, KProperty<?> r3) {
        Intrinsics.checkNotNullParameter(r2, "thisRef");
        Intrinsics.checkNotNullParameter(r3, "property");
        return extractValue(r2);
    }
}
