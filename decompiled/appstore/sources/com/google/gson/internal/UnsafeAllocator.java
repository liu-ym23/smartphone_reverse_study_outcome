package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes3.dex */
public abstract class UnsafeAllocator {
    public UnsafeAllocator() {
    }

    public static void assertInstantiable(Class<?> r10) {
        int r11 = r10.getModifiers();
        if (Modifier.isInterface(r11) == true) goto L10;
        if (Modifier.isAbstract(r11) == true) goto L8;
        return;
    L8:
        throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + r10.getName());
    L10:
        throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + r10.getName());
    }

    public static UnsafeAllocator create() {
        Class<?> r10 = Class.forName("sun.misc.Unsafe");     // Catch: Exception -> L5
        Field r11 = r10.getDeclaredField("theUnsafe");     // Catch: Exception -> L5
        r11.setAccessible(true);     // Catch: Exception -> L5
        final Object r12 = r11.get(null);     // Catch: Exception -> L5
        final Method r13 = r10.getMethod("allocateInstance", new Class[]{Class.class});     // Catch: Exception -> L5
        return new AnonymousClass1(r13, r12);
    L5:
        Method r14 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});     // Catch: Exception -> L7
        r14.setAccessible(true);     // Catch: Exception -> L7
        final int r15 = ((Integer) r14.invoke(null, new Object[]{Object.class})).intValue();     // Catch: Exception -> L7
        final Method r16 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Integer.TYPE});     // Catch: Exception -> L7
        r16.setAccessible(true);     // Catch: Exception -> L7
        return new AnonymousClass2(r16, r15);
    L7:
        final Method r17 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});     // Catch: Exception -> L9
        r17.setAccessible(true);     // Catch: Exception -> L9
        return new AnonymousClass3(r17);
    L10:
        return new AnonymousClass4();
    }

    public abstract <T> T newInstance(Class<T> r10) throws Exception;
}
