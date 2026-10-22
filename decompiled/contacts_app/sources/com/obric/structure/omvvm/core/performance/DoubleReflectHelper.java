package com.obric.structure.omvvm.core.performance;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DoubleReflectHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u0004\u0018\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ \u0010\t\u001a\u0004\u0018\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\bJE\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\b2\u001e\u0010\u000e\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u000f\"\b\u0012\u0002\b\u0003\u0018\u00010\u0006¢\u0006\u0002\u0010\u0010J \u0010\u0011\u001a\u0004\u0018\u00010\u00012\f\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0013\u001a\u00020\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ*\u0010\u0011\u001a\u0004\u0018\u00010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u00012\f\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\u0015"}, d2 = {"Lcom/obric/structure/omvvm/core/performance/DoubleReflectHelper;", "", "()V", "getField", "Ljava/lang/reflect/Field;", "clazz", "Ljava/lang/Class;", "fieldName", "", "getFieldInner", "name", "getMethodInner", "Ljava/lang/reflect/Method;", "methodName", "params", "", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "readField", "clz", "target", "targetClazz", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DoubleReflectHelper {
    public static final DoubleReflectHelper INSTANCE = null;

    static {
        INSTANCE = new DoubleReflectHelper();
    }

    private DoubleReflectHelper() {
    }

    public final Field getFieldInner(Class<?> r6, String r7) {
        Object r5 = Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r6, new Object[]{r7});     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type java.lang.reflect.Field");     // Catch: Throwable -> L4
        Field r8 = (Field) r5;     // Catch: Throwable -> L4
        r8.setAccessible(true);     // Catch: Throwable -> L4
        return r8;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public final Method getMethodInner(Class<?> r7, String r8, Class<?>... r9) throws NoSuchMethodException {
        Intrinsics.checkNotNullParameter(r9, "params");
        Object r6 = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, new Class[0].getClass()}).invoke(r7, new Object[]{r8, r9});     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type java.lang.reflect.Method");     // Catch: Throwable -> L5
        Method r10 = (Method) r6;     // Catch: Throwable -> L5
        r10.setAccessible(true);     // Catch: Throwable -> L5
        return r10;
    L5:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public final Object readField(Object r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "target");
        Field r1 = getField(r2.getClass(), r3);
        Intrinsics.checkNotNull(r1);     // Catch: IllegalAccessException -> L5
        return r1.get(r2);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public final Object readField(Class<?> r1, String r2) {
        Field r0 = getField(r1, r2);
        Intrinsics.checkNotNull(r0);     // Catch: IllegalAccessException -> L5
        return r0.get(null);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public final Object readField(Object r1, Class<?> r2, String r3) {
        Field r0 = getField(r2, r3);
        Intrinsics.checkNotNull(r0);     // Catch: IllegalAccessException -> L5
        return r0.get(r1);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public final Field getField(Class<?> r1, String r2) {
        return getFieldInner(r1, r2);
    L4:
        return null;
    }
}
