package com.google.gson.internal.reflect;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes3.dex */
final class UnsafeReflectionAccessor extends ReflectionAccessor {
    private static Class unsafeClass;
    private final Field overrideField;
    private final Object theUnsafe;

    public UnsafeReflectionAccessor() {
        this.theUnsafe = getUnsafeInstance();
        this.overrideField = getOverrideField();
    }

    private static Field getOverrideField() {
        return AccessibleObject.class.getDeclaredField("override");
    L4:
        return null;
    }

    private static Object getUnsafeInstance() {
        Class<?> r10 = Class.forName("sun.misc.Unsafe");     // Catch: Exception -> L5
        unsafeClass = r10;     // Catch: Exception -> L5
        Field r11 = r10.getDeclaredField("theUnsafe");     // Catch: Exception -> L5
        r11.setAccessible(true);     // Catch: Exception -> L5
        return r11.get(null);
    L8:
        return null;
    }

    @Override // com.google.gson.internal.reflect.ReflectionAccessor
    public void makeAccessible(AccessibleObject r10) {
        if (makeAccessibleWithUnsafe(r10) == false) goto L11;
        return;
    L11:
        r10.setAccessible(true);     // Catch: SecurityException -> L7
        return;
    L7:
        e = move-exception;
        throw new JsonIOException("Gson couldn't modify fields for " + r10 + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e);
    }

    public boolean makeAccessibleWithUnsafe(AccessibleObject r10) {
        if (this.theUnsafe != null) goto L5;
        return false;
    L5:
        if (this.overrideField == null) goto L14;
        Long r11 = (Long) unsafeClass.getMethod("objectFieldOffset", new Class[]{Field.class}).invoke(this.theUnsafe, new Object[]{this.overrideField});     // Catch: Exception -> L11
        r11.longValue();     // Catch: Exception -> L11
        unsafeClass.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE}).invoke(this.theUnsafe, new Object[]{r10, r11, Boolean.TRUE});     // Catch: Exception -> L11
        return true;
    L15:
        return false;
    L14:
        return false;
    }
}
