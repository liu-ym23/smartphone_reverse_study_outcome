package s3;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Vibrator;
import android.provider.Settings;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f20292a = new l();

    private l() {
    }

    private final boolean a() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("getBoolean", String.class, Boolean.TYPE);
            Boolean bool = Boolean.FALSE;
            Object objInvoke = method.invoke(null, "ro.stepos.shell_hapticfeedback_motor", bool);
            Boolean bool2 = Boolean.TRUE;
            if (!j4.k.b(objInvoke, bool2)) {
                if (!j4.k.b(method.invoke(null, "ro.stepos.use_qcom_vibrate", bool), bool2)) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private final boolean b(Context context) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            if (Settings.System.getInt(contentResolver, "vibrate_on", 1) != 0 && Settings.System.getInt(contentResolver, "haptic_feedback_enabled", 1) != 0) {
                if (Settings.System.getInt(contentResolver, "haptic_feedback_intensity", 2) != 0) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public final void c(View view) {
        Vibrator vibrator;
        j4.k.g(view, "view");
        Context context = view.getContext();
        j4.k.d(context);
        if (b(context)) {
            if (a()) {
                view.performHapticFeedback(31022);
            } else if (androidx.core.content.a.a(context, "android.permission.VIBRATE") == 0 && (vibrator = (Vibrator) context.getSystemService(Vibrator.class)) != null && vibrator.hasVibrator()) {
                vibrator.vibrate(50L);
            }
        }
    }
}
