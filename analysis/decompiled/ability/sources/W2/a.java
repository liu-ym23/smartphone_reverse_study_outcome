package W2;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import c3.AbstractC0872b;

/* loaded from: classes3.dex */
public abstract class a {
    public static int a(int i, View view) {
        Context context = view.getContext();
        TypedValue typedValueD = AbstractC0872b.d(view.getContext(), view.getClass().getCanonicalName(), i);
        int i6 = typedValueD.resourceId;
        return i6 != 0 ? ContextCompat.getColor(context, i6) : typedValueD.data;
    }

    public static Integer b(int i, Context context) {
        TypedValue typedValueA = AbstractC0872b.a(i, context);
        if (typedValueA == null) {
            return null;
        }
        int i6 = typedValueA.resourceId;
        return Integer.valueOf(i6 != 0 ? ContextCompat.getColor(context, i6) : typedValueA.data);
    }

    public static int c(float f, int i, int i6) {
        return ColorUtils.compositeColors(ColorUtils.setAlphaComponent(i6, Math.round(Color.alpha(i6) * f)), i);
    }
}
