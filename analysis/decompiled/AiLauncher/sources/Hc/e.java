package Hc;

import androidx.fragment.app.FragmentManager;
import java.lang.reflect.Field;

/* loaded from: classes5.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static Field f3242a;

    /* renamed from: b, reason: collision with root package name */
    public static Field f3243b;

    public static void a(Object obj, boolean z10) throws NoSuchFieldException, SecurityException {
        if (!z10 || f3243b == null) {
            if (z10 || f3242a == null) {
                Field declaredField = null;
                try {
                    declaredField = obj.getClass().getDeclaredField("mStateSaved");
                    declaredField.setAccessible(true);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                if (z10) {
                    f3243b = declaredField;
                } else {
                    f3242a = declaredField;
                }
            }
        }
    }

    public static int b(Object obj) throws NoSuchFieldException, SecurityException {
        boolean z10 = obj instanceof FragmentManager;
        a(obj, z10);
        try {
            return (z10 ? f3243b : f3242a).getBoolean(obj) ? 1 : 0;
        } catch (Exception e10) {
            e10.printStackTrace();
            return -1;
        }
    }

    public static void c(Object obj, boolean z10) {
        boolean z11 = obj instanceof FragmentManager;
        a(obj, z11);
        try {
            (z11 ? f3243b : f3242a).setBoolean(obj, z10);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
