package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.types.TypeAttribute;

/* JADX INFO: compiled from: TypeAttributes.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class TypeAttribute<T extends TypeAttribute<T>> {
    public abstract T add(T r1);

    public abstract KClass<? extends T> getKey();

    public abstract T intersect(T r1);

    public TypeAttribute() {
    }
}
