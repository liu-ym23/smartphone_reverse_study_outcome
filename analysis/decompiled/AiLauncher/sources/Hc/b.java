package Hc;

import android.content.Context;
import android.util.TypedValue;

/* loaded from: classes5.dex */
public class b {
    public static float a(Context context, float f10) {
        return TypedValue.applyDimension(1, f10, context.getResources().getDisplayMetrics());
    }

    public static float b(Context context, float f10) {
        return f10 / context.getResources().getDisplayMetrics().density;
    }
}
