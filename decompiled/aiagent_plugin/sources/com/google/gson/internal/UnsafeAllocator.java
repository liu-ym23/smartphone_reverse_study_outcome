package com.google.gson.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public abstract class UnsafeAllocator {
    public static final UnsafeAllocator INSTANCE = null;

    public abstract <T> T newInstance(Class<T> r1);

    public UnsafeAllocator() {
    }

    static /* synthetic */ void access$000(Class r0) {
        assertInstantiable(r0);
    }

    private static void assertInstantiable(Class<?> r3) {
        String r4 = ConstructorConstructor.checkInstantiable(r3);
        if (r4 != null) goto L6;
        return;
    L6:
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: " + r4);
    }

    static {
        INSTANCE = create();
    }

    private static UnsafeAllocator create() {
        Class r5 = ZeusTransformUtils.forName("sun.misc.Unsafe", "com.obric.aiagent.plugin");     // Catch: Exception -> L5
        Field r6 = r5.getDeclaredField("theUnsafe");     // Catch: Exception -> L5
        r6.setAccessible(true);     // Catch: Exception -> L5
        final Object r7 = r6.get(null);     // Catch: Exception -> L5
        final Method r8 = r5.getMethod("allocateInstance", new Class[]{Class.class});     // Catch: Exception -> L5
        return new AnonymousClass1(r8, r7);
    L12:
        Method r9 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});     // Catch: Exception -> L8
        r9.setAccessible(true);     // Catch: Exception -> L8
        final int r1 = ((Integer) ZeusTransformUtils.preCheckCast(r9.invoke(null, new Object[]{Object.class}), Integer.class, "com.obric.aiagent.plugin")).intValue();     // Catch: Exception -> L8
        final Method r2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Integer.TYPE});     // Catch: Exception -> L8
        r2.setAccessible(true);     // Catch: Exception -> L8
        return new AnonymousClass2(r2, r1);
    L8:
        final Method r0 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});     // Catch: Exception -> L10
        r0.setAccessible(true);     // Catch: Exception -> L10
        return new AnonymousClass3(r0);
    L11:
        return new AnonymousClass4();
    }
}
