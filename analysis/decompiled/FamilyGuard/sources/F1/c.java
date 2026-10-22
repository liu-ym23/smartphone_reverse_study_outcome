package F1;

import A1.k;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
final class c extends b {

    /* renamed from: d, reason: collision with root package name */
    private static Class f1631d;

    /* renamed from: b, reason: collision with root package name */
    private final Object f1632b = d();

    /* renamed from: c, reason: collision with root package name */
    private final Field f1633c = c();

    c() {
    }

    private static Field c() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    private static Object d() throws NoSuchFieldException, ClassNotFoundException, SecurityException {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            f1631d = cls;
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // F1.b
    public void b(AccessibleObject accessibleObject) throws SecurityException {
        if (e(accessibleObject)) {
            return;
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (SecurityException e6) {
            throw new k("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e6);
        }
    }

    boolean e(AccessibleObject accessibleObject) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f1632b == null || this.f1633c == null) {
            return false;
        }
        try {
            Long l5 = (Long) f1631d.getMethod("objectFieldOffset", Field.class).invoke(this.f1632b, this.f1633c);
            l5.longValue();
            f1631d.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.f1632b, accessibleObject, l5, Boolean.TRUE);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
