package O6;

import android.content.Context;
import android.os.SystemProperties;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;

/* loaded from: classes3.dex */
public class y {
    private static final int FEEDBACK_CONSTANT = 31020;
    private static final int VIBRATE_DURATION = 50;

    public static boolean a() {
        return SystemProperties.getBoolean("ro.stepos.shell_hapticfeedback_motor", true);
    }

    public static boolean b(Context context) {
        return androidx.core.content.e.a(context, "android.permission.VIBRATE") == 0;
    }

    public static void c(View view, boolean z10) {
        if (z10) {
            view.performHapticFeedback(FEEDBACK_CONSTANT);
        } else {
            view.performHapticFeedback(0);
        }
    }

    public static void d(Context context, int i10) {
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (b(context)) {
            vibrator.vibrate(VibrationEffect.createOneShot(50L, i10));
        }
    }
}
