package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;

/* JADX INFO: compiled from: typeSignatureMapping.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface JvmTypeFactory<T> {
    T boxType(T r1);

    T createFromString(String r1);

    T createObjectType(String r1);

    T createPrimitiveType(PrimitiveType r1);

    T getJavaLangClassType();

    String toString(T r1);
}
