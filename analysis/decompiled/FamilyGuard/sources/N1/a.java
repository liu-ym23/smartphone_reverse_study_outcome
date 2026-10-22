package N1;

import android.content.Context;
import android.os.Build;
import android.os.SystemProperties;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Method f4183a;

    public static float a(Context context) {
        String string = Settings.System.getString(context.getContentResolver(), "current_launcher_icon_corner_size");
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
            if (f4183a == null) {
                Method declaredMethod = Build.class.getDeclaredMethod("getString", String.class);
                f4183a = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            return (String) f4183a.invoke(null, str);
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

    public static void e(View view, int i5) {
        if (view == null) {
            return;
        }
        view.setForceDarkAllowed(i5 != 2);
    }

    public static void f(View view) {
        g(view, 20120);
    }

    public static void g(View view, int i5) {
        if (d()) {
            view.performHapticFeedback(i5);
        }
    }

    public static void h(View view, int i5) {
        if (d()) {
            view.performHapticFeedback(i5);
        } else if (androidx.core.content.a.a(view.getContext(), "android.permission.VIBRATE") == 0) {
            ((Vibrator) view.getContext().getSystemService("vibrator")).vibrate(VibrationEffect.createOneShot(45L, -1));
        } else {
            Log.d("CommonUtils", "permission not declared");
        }
    }

    public static void i(View view, int i5, int i6) {
        if (d()) {
            view.performHapticFeedback(i5);
        } else {
            view.performHapticFeedback(i6);
        }
    }
}
