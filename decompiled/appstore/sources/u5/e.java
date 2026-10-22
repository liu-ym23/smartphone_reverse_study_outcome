package u5;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    public static Field a(Class r10, String r11) {
        Field r12 = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r10, new Object[]{r11});     // Catch: Throwable -> L4
        r12.setAccessible(true);     // Catch: Throwable -> L4
        return r12;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }
}
