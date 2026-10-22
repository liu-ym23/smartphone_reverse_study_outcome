package O6;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class n {
    private static String DecorViewClsName = "com.android.internal.policy.DecorView";
    private static Field mFiledStepOSFlags;
    private static Field mLastBottomInset;
    private static Field mLastLeftInset;
    private static Field mLastRightInset;
    private static Method setForcedNavigationBarColor;
    private static Method setNavigationBarIconColor;
    private static Method setNavigationBarIconColorExt;

    static {
        try {
            Class cls = Boolean.TYPE;
            setNavigationBarIconColor = Window.class.getDeclaredMethod("setNavigationBarIconColor", cls);
            mFiledStepOSFlags = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            setForcedNavigationBarColor = Window.class.getDeclaredMethod("setForcedNavigationBarColor", cls);
            setNavigationBarIconColorExt = Window.class.getDeclaredMethod("setNavigationBarIconColor", cls, cls);
        } catch (NoSuchFieldException | NoSuchMethodException unused) {
        }
        try {
            Class<?> cls2 = Class.forName(DecorViewClsName);
            Field declaredField = cls2.getDeclaredField("mLastBottomInset");
            mLastBottomInset = declaredField;
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            Field declaredField2 = cls2.getDeclaredField("mLastRightInset");
            mLastRightInset = declaredField2;
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Field declaredField3 = cls2.getDeclaredField("mLastLeftInset");
            mLastLeftInset = declaredField3;
            if (declaredField3 != null) {
                declaredField3.setAccessible(true);
            }
        } catch (ClassNotFoundException | NoSuchFieldException unused2) {
        }
    }

    public static int a(Activity activity) {
        View decorView;
        if (activity != null && activity.getWindow() != null && (decorView = activity.getWindow().getDecorView()) != null) {
            try {
                Field field = mLastBottomInset;
                if (field != null) {
                    return field.getInt(decorView);
                }
                return 0;
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            }
        }
        return 0;
    }

    public static int b(Context context) {
        if (context instanceof Activity) {
            return a((Activity) context);
        }
        return 0;
    }
}
