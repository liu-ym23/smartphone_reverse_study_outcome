package a5;

import android.content.Context;
import android.util.TypedValue;

/* loaded from: classes.dex */
public class a {
    public static int a(Context context, double d6) {
        return (int) TypedValue.applyDimension(1, (float) d6, context.getResources().getDisplayMetrics());
    }
}
