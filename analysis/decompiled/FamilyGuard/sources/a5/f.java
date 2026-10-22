package a5;

import androidx.fragment.app.x;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static Field f7331a;

    /* renamed from: b, reason: collision with root package name */
    public static Field f7332b;

    private static void a(Object obj, boolean z5) throws NoSuchFieldException, SecurityException {
        if (!z5 || f7332b == null) {
            if (z5 || f7331a == null) {
                Field declaredField = null;
                try {
                    declaredField = obj.getClass().getDeclaredField("mStateSaved");
                    declaredField.setAccessible(true);
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
                if (z5) {
                    f7332b = declaredField;
                } else {
                    f7331a = declaredField;
                }
            }
        }
    }

    public static int b(Object obj) throws NoSuchFieldException, SecurityException {
        boolean z5 = obj instanceof x;
        a(obj, z5);
        try {
            return (z5 ? f7332b : f7331a).getBoolean(obj) ? 1 : 0;
        } catch (Exception e6) {
            e6.printStackTrace();
            return -1;
        }
    }

    public static void c(Object obj, boolean z5) {
        boolean z6 = obj instanceof x;
        a(obj, z6);
        try {
            (z6 ? f7332b : f7331a).setBoolean(obj, z5);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }
}
