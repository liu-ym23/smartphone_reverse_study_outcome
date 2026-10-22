package c27;

import android.os.Build;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes21.dex */
public final class a {
    public static Field a(Class<?> r100, String r101) {
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 28) goto L5;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == false) goto L21;
        Field r104 = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r100, new Object[]{r101});     // Catch: Throwable -> L14
        r104.setAccessible(true);     // Catch: Throwable -> L14
        return r104;
    L14:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L19
        return null;
    L19:
        return null;
    L21:
        return d27.b.a(r100, r101);
    L5:
        if (r102 == 27) goto L7;
    L9:
        r103 = false;
        goto L11
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }

    public static Method b(Class<?> r100, String r101, Class<?>... r102) throws NoSuchMethodException {
        Method r103 = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r100, new Object[]{r101, r102});     // Catch: Throwable -> L4
        r103.setAccessible(true);     // Catch: Throwable -> L4
        return r103;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }
}
