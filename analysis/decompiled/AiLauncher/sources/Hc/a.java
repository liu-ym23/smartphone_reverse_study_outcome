package Hc;

import android.content.Context;
import android.util.TypedValue;

/* loaded from: classes5.dex */
public class a {
    public static int a(Context context, double d10) {
        return (int) TypedValue.applyDimension(1, (float) d10, context.getResources().getDisplayMetrics());
    }
}
