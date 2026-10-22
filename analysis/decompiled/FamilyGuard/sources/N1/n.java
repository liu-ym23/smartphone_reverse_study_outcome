package N1;

import android.content.Context;
import android.os.SystemProperties;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;

/* loaded from: classes.dex */
public class n {
    public static boolean a() {
        return SystemProperties.getBoolean("ro.stepos.shell_hapticfeedback_motor", true);
    }

    private static boolean b(Context context) {
        return androidx.core.content.d.a(context, "android.permission.VIBRATE") == 0;
    }

    public static void c(View view, boolean z5) {
        if (z5) {
            view.performHapticFeedback(31020);
        } else {
            view.performHapticFeedback(0);
        }
    }

    public static void d(Context context, int i5) {
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (b(context)) {
            vibrator.vibrate(VibrationEffect.createOneShot(50L, i5));
        }
    }
}
