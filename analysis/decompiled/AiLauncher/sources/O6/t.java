package O6;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class t {
    public static final String STEP_OS_HIGH_CONTRAST_MODE = "flyme_high_contrast_mode";
    private static final float STEP_OS_SYSTEM_CONTRACT_THRESHOLD = 0.2f;
    private static Method actualScreenHeightMethod;

    public static int a(Context context, double d10) {
        return (int) TypedValue.applyDimension(1, (float) d10, context.getResources().getDisplayMetrics());
    }

    public static int b(WindowManager windowManager) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Display defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            if (actualScreenHeightMethod == null) {
                Method method = Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class);
                actualScreenHeightMethod = method;
                method.invoke(defaultDisplay, displayMetrics);
            }
            actualScreenHeightMethod.invoke(defaultDisplay, displayMetrics);
            return displayMetrics.heightPixels;
        } catch (Exception e10) {
            e10.printStackTrace();
            return -1;
        }
    }

    public static int c(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(s.b(resources, "navigation_bar_height", "dimen", UxipConstants.f30662a));
    }

    public static boolean d(int i10) {
        float[] fArr = new float[3];
        if (Color.alpha(i10) != 0) {
            Color.colorToHSV(i10, fArr);
            if (fArr[1] > 0.2f && fArr[2] > 0.2f) {
                return true;
            }
        }
        return false;
    }

    public static boolean e(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), STEP_OS_HIGH_CONTRAST_MODE, 0) != 0;
    }
}
