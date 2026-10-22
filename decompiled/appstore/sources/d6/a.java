package d6;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f19095a = null;

    static {
        f19095a = new HashMap();
    }

    public static Field a(Class r10, String r11) {
        Class<?> r12 = (Class) f.b(r10, "The class must not be null");
        f.c(!TextUtils.isEmpty(r11), "The field name must not be blank");
        String r13 = b(r12, r11);
        Map r14 = f19095a;
        monitor-enter(r14);
        Field r15 = (Field) r14.get(r13);     // Catch: Throwable -> L36
        monitor-exit(r14);     // Catch: Throwable -> L36
        if (r15 != null) goto L8;
    L11:
        if (r12 == null) goto L34;
    L33:
        r12 = r12.getSuperclass();
        goto L11
    L13:
        if (e.a() == true) goto L15;
    L19:
        Field r16 = r12.getDeclaredField(r11);     // Catch: NoSuchFieldException -> L33
    L20:
        if (r16 == null) goto L32;
        if (r16.isAccessible() == true) goto L24;
        r16.setAccessible(true);     // Catch: NoSuchFieldException -> L33
    L24:
        Map r17 = f19095a;     // Catch: NoSuchFieldException -> L33
        monitor-enter(r17);     // Catch: NoSuchFieldException -> L33
        r17.put(r13, r16);     // Catch: Throwable -> L29
        monitor-exit(r17);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;     // Catch: NoSuchFieldException -> L33
    L32:
        return r16;
    L15:
        if (c.a() == null) goto L19;
        r16 = c.a().getField(r12, r11);     // Catch: NoSuchFieldException -> L33
        if (r16 != null) goto L20;
        r16 = r12.getDeclaredField(r11);     // Catch: NoSuchFieldException -> L33
        goto L20
    L34:
        return null;
    L8:
        if (r15.isAccessible() == true) goto L10;
        r15.setAccessible(true);
    L10:
        return r15;
    L36:
        th = move-exception;
        throw th;
    }

    public static String b(Class r10, String r11) {
        return r10.toString() + "#" + r11;
    }

    public static Object c(Field r10, Object r11) {
        if (r10 == null) goto L5;
        boolean r12 = true;
    L6:
        f.a(r12, "The field must not be null");
        if (r10.isAccessible() == true) goto L10;
        r10.setAccessible(true);
    L10:
        return r10.get(r11);
    L5:
        r12 = false;
        goto L6
    }

    public static Object d(Class r10, String r11) {
        Field r12 = a(r10, r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return e(r12);
    }

    public static Object e(Field r10) {
        return c((Field) f.b(r10, "The field must not be null"), null);
    }
}
