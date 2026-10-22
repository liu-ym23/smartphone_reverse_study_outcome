package N1;

import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static Method f4194a = null;

    /* renamed from: b, reason: collision with root package name */
    private static Method f4195b = null;

    /* renamed from: c, reason: collision with root package name */
    private static Field f4196c = null;

    /* renamed from: d, reason: collision with root package name */
    private static Method f4197d = null;

    /* renamed from: e, reason: collision with root package name */
    private static String f4198e = "com.android.internal.policy.DecorView";

    /* renamed from: f, reason: collision with root package name */
    private static Field f4199f;

    /* renamed from: g, reason: collision with root package name */
    private static Field f4200g;

    /* renamed from: h, reason: collision with root package name */
    private static Field f4201h;

    static {
        try {
            Class cls = Boolean.TYPE;
            f4194a = Window.class.getDeclaredMethod("setNavigationBarIconColor", cls);
            f4196c = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            f4197d = Window.class.getDeclaredMethod("setForcedNavigationBarColor", cls);
            f4195b = Window.class.getDeclaredMethod("setNavigationBarIconColor", cls, cls);
        } catch (NoSuchFieldException | NoSuchMethodException unused) {
        }
        try {
            Class<?> cls2 = Class.forName(f4198e);
            Field declaredField = cls2.getDeclaredField("mLastBottomInset");
            f4199f = declaredField;
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            Field declaredField2 = cls2.getDeclaredField("mLastRightInset");
            f4201h = declaredField2;
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Field declaredField3 = cls2.getDeclaredField("mLastLeftInset");
            f4200g = declaredField3;
            if (declaredField3 != null) {
                declaredField3.setAccessible(true);
            }
        } catch (ClassNotFoundException | NoSuchFieldException unused2) {
        }
    }

    public static void a(Window window, boolean z5) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = f4194a;
        if (method != null) {
            try {
                method.invoke(window, Boolean.valueOf(z5));
            } catch (IllegalAccessException e6) {
                e6.printStackTrace();
            } catch (InvocationTargetException e7) {
                e7.printStackTrace();
            }
        }
    }

    public static void b(Window window, boolean z5, boolean z6) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = f4195b;
        if (method == null) {
            a(window, z5);
            return;
        }
        try {
            method.invoke(window, Boolean.valueOf(z5), Boolean.valueOf(z6));
        } catch (IllegalAccessException e6) {
            e6.printStackTrace();
        } catch (InvocationTargetException e7) {
            e7.printStackTrace();
        }
    }

    public static void c(Window window, boolean z5) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = f4197d;
        if (method != null) {
            try {
                method.invoke(window, Boolean.valueOf(z5));
            } catch (IllegalAccessException e6) {
                e6.printStackTrace();
            } catch (InvocationTargetException e7) {
                e7.printStackTrace();
            }
        }
    }

    public static void d(Window window, int i5, boolean z5) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        c(window, z5);
        window.setNavigationBarColor(i5);
    }
}
