package h5;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static Field a(Class r10, String r11) {
        if (c() == false) goto L9;
        return b(r10, r11);
    L6:
        return null;
    L9:
        return i5.b.a(r10, r11);
    }

    public static Field b(Class r10, String r11) {
        Field r12 = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r10, new Object[]{r11});     // Catch: Throwable -> L4
        r12.setAccessible(true);     // Catch: Throwable -> L4
        return r12;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static boolean c() {
        return true;
    }
}
