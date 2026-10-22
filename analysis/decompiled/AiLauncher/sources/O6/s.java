package O6;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.TypedValue;
import com.stepos.common.R$dimen;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class s {
    private static Field backgroundField = null;
    private static Class<?> cls = null;
    private static int mNightModeColor = -1;
    private static Integer sStatusBarHeight;
    private static Integer sStatusBarHeightResId;

    public static float a(float f10, Context context) {
        return TypedValue.applyDimension(1, f10, context.getResources().getDisplayMetrics());
    }

    public static int b(Resources resources, String str, String str2, String str3) {
        if (!UxipConstants.f30662a.equals(str3)) {
            return resources.getIdentifier(str, str2, str3);
        }
        return resources.getIdentifier("android:" + str2 + "/" + str, null, null);
    }

    public static int c(int i10, Context context) {
        TypedValue typedValueF = f(i10, context);
        if (typedValueF == null) {
            return 0;
        }
        return typedValueF.resourceId;
    }

    public static int d(Context context) {
        try {
            if (sStatusBarHeightResId == null) {
                sStatusBarHeightResId = Integer.valueOf(b(context.getResources(), "status_bar_height", "dimen", UxipConstants.f30662a));
            }
            return context.getResources().getDimensionPixelSize(sStatusBarHeightResId.intValue());
        } catch (Exception e10) {
            Log.e("ResurceUtils", "get status bar height fail", e10);
            return context.getResources().getDimensionPixelSize(R$dimen.status_bar_height);
        }
    }

    public static ArrayList<String> e(Context context, TypedArray typedArray, int i10) throws Resources.NotFoundException {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i10, typedValue)) {
            return null;
        }
        int i11 = typedValue.resourceId;
        if (i11 == 0) {
            throw new IllegalStateException("can't find the resourceId");
        }
        TypedArray typedArrayObtainTypedArray = context.getResources().obtainTypedArray(i11);
        int length = typedArrayObtainTypedArray.length();
        ArrayList<String> arrayList = new ArrayList<>(length);
        for (int i12 = 0; i12 < length; i12++) {
            arrayList.add(typedArrayObtainTypedArray.getString(i12));
        }
        typedArrayObtainTypedArray.recycle();
        return arrayList;
    }

    public static TypedValue f(int i10, Context context) {
        Resources.Theme theme = context.getTheme();
        if (theme == null) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        try {
            try {
                theme.resolveAttribute(i10, typedValue, true);
                return typedValue;
            } catch (Exception e10) {
                e10.printStackTrace();
                return typedValue;
            }
        } catch (Throwable unused) {
            return typedValue;
        }
    }

    public static float g(Context context, float f10) {
        return f10 / context.getResources().getDisplayMetrics().density;
    }

    public static int h(Context context, float f10) {
        return (int) ((f10 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static float i(float f10, Context context) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
