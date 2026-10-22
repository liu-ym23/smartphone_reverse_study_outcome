package O6;

import android.content.Context;
import android.os.Build;
import android.os.SystemProperties;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class c {
    public static final String CURRENT_LAUNCHER_ICON_CORNER_SIZE_KEY = "current_launcher_icon_corner_size";
    private static final String HARDWARE_HAPTIC_FEEDBACK_INTENSITY = "hardware_haptic_feedback_intensity";
    private static final String METHOD_PRODUCT_INTERNATIONAL = "isProductInternational";
    private static final String ROUNDED_CORNER_LIMITER_0 = "corner_size_1";
    private static final String ROUNDED_CORNER_LIMITER_1 = "corner_size_2";
    private static final String ROUNDED_CORNER_LIMITER_2 = "corner_size_3";
    private static final String ROUNDED_CORNER_LIMITER_3 = "corner_size_4";
    private static final String ROUNDED_CORNER_LIMITER_4 = "corner_size_5";
    private static final float ROUNDED_CORNER_RADIUS_RATIO_DEFAULT = 0.2f;
    private static final float ROUNDED_CORNER_RADIUS_RATIO_LIMITER_1 = 0.26f;
    private static final float ROUNDED_CORNER_RADIUS_RATIO_LIMITER_2 = 0.33f;
    private static final float ROUNDED_CORNER_RADIUS_RATIO_LIMITER_3 = 0.4f;
    private static final float ROUNDED_CORNER_RADIUS_RATIO_LIMITER_4 = 0.5f;
    private static final String TAG = "CommonUtils";
    private static final int VIBRATION_INTENSITY_OFF = 0;
    private static Boolean isStepOS;
    private static Boolean isStepOS4;
    private static Method mMethodGetString;
    private static Class<?> scrollBarDrawableClass;
    private static Field scrollBarField;
    private static Field scrollCacheField;
    private static Class<?> scrollCacheFieldClass;
    private static Method setVerticalThumbDrawableMethod;
    private static Class<?> viewClass;

    public static float a(Context context) {
        String string = Settings.System.getString(context.getContentResolver(), CURRENT_LAUNCHER_ICON_CORNER_SIZE_KEY);
        if (TextUtils.isEmpty(string)) {
            return 0.2f;
        }
        string.getClass();
        switch (string) {
        }
        return 0.2f;
    }

    public static String b(String str) throws NoSuchMethodException, SecurityException {
        try {
            if (mMethodGetString == null) {
                Method declaredMethod = Build.class.getDeclaredMethod("getString", String.class);
                mMethodGetString = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            return (String) mMethodGetString.invoke(null, str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean c() {
        return true;
    }

    public static boolean d() {
        return SystemProperties.getBoolean("ro.stepos.shell_hapticfeedback_motor", true);
    }

    public static void e(View view, int i10) {
        if (view == null) {
            return;
        }
        view.setForceDarkAllowed(i10 != 2);
    }

    public static void f(View view) {
        g(view, 20120);
    }

    public static void g(View view, int i10) {
        if (d()) {
            view.performHapticFeedback(i10);
        }
    }

    public static void h(View view, int i10) {
        if (d()) {
            view.performHapticFeedback(i10);
        } else if (androidx.core.content.a.a(view.getContext(), "android.permission.VIBRATE") == 0) {
            ((Vibrator) view.getContext().getSystemService("vibrator")).vibrate(VibrationEffect.createOneShot(45L, -1));
        } else {
            Log.d("CommonUtils", "permission not declared");
        }
    }

    public static void i(View view, int i10, int i11) {
        if (d()) {
            view.performHapticFeedback(i10);
        } else {
            view.performHapticFeedback(i11);
        }
    }
}
