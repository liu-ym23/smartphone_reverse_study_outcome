package N1;

import android.content.Context;
import android.graphics.Color;
import android.provider.Settings;
import android.util.TypedValue;

/* loaded from: classes.dex */
public class j {
    public static int a(Context context, double d6) {
        return (int) TypedValue.applyDimension(1, (float) d6, context.getResources().getDisplayMetrics());
    }

    public static boolean b(int i5) {
        float[] fArr = new float[3];
        if (Color.alpha(i5) != 0) {
            Color.colorToHSV(i5, fArr);
            if (fArr[1] > 0.2f && fArr[2] > 0.2f) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "flyme_high_contrast_mode", 0) != 0;
    }
}
