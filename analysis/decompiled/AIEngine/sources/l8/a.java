package l8;

import android.content.Context;
import android.os.SystemProperties;
import android.os.Vibrator;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static Method f10348a;

    public static float a(Context context) {
        String string = Settings.System.getString(context.getContentResolver(), "current_launcher_icon_corner_size");
        if (TextUtils.isEmpty(string)) {
            return 0.2f;
        }
        string.getClass();
        switch (string) {
            case "corner_size_2":
                return 0.26f;
            case "corner_size_3":
                return 0.33f;
            case "corner_size_4":
                return 0.4f;
            case "corner_size_5":
                return 0.5f;
            default:
                return 0.2f;
        }
    }

    public static boolean b() {
        return SystemProperties.getBoolean("ro.stepos.shell_hapticfeedback_motor", false) || SystemProperties.getBoolean("ro.stepos.use_qcom_vibrate", false);
    }

    public static boolean c(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (Settings.System.getInt(context.getContentResolver(), "vibrate_on", 1) == 0 || Settings.System.getInt(context.getContentResolver(), "haptic_feedback_enabled", 1) == 0) {
                return false;
            }
            return Settings.System.getInt(context.getContentResolver(), "haptic_feedback_intensity", 2) != 0;
        } catch (Exception e10) {
            Log.d("CommonUtils", "read haptic feedback settings failed", e10);
            return true;
        }
    }

    public static void d(View view) {
        if (view.getContext() == null) {
            return;
        }
        Context context = view.getContext();
        if (!c(context)) {
            Log.d("CommonUtils", "haptic feedback disabled by settings");
            return;
        }
        if (androidx.core.content.a.a(context, "android.permission.VIBRATE") != 0) {
            Log.d("CommonUtils", "permission not declared");
            return;
        }
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (vibrator == null || !vibrator.hasVibrator()) {
            Log.d("CommonUtils", "vibrator unavailable");
        } else {
            vibrator.vibrate(50L);
        }
    }

    public static void e(View view, int i10, int i11) {
        if (!c(view.getContext())) {
            Log.d("CommonUtils", "haptic feedback disabled by settings");
        } else if (b()) {
            view.performHapticFeedback(i10);
        } else {
            if (view.performHapticFeedback(i11)) {
                return;
            }
            d(view);
        }
    }
}
