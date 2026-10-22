package a5;

import android.content.Context;
import android.util.TypedValue;

/* loaded from: classes.dex */
public class b {
    public static float a(Context context, float f5) {
        return TypedValue.applyDimension(1, f5, context.getResources().getDisplayMetrics());
    }

    public static float b(Context context, float f5) {
        return f5 / context.getResources().getDisplayMetrics().density;
    }
}
