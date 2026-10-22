package c3;

import android.content.Context;
import android.util.TypedValue;
import com.stepos.ability.R;

/* renamed from: c3.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0872b {
    public static TypedValue a(int i, Context context) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean b(Context context, int i, boolean z10) {
        TypedValue typedValueA = a(i, context);
        return (typedValueA == null || typedValueA.type != 18) ? z10 : typedValueA.data != 0;
    }

    public static int c(Context context) {
        TypedValue typedValueA = a(R.attr.minTouchTargetSize, context);
        return (int) ((typedValueA == null || typedValueA.type != 5) ? context.getResources().getDimension(R.dimen.mtrl_min_touch_target_size) : typedValueA.getDimension(context.getResources().getDisplayMetrics()));
    }

    public static TypedValue d(Context context, String str, int i) {
        TypedValue typedValueA = a(i, context);
        if (typedValueA != null) {
            return typedValueA;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i)));
    }
}
