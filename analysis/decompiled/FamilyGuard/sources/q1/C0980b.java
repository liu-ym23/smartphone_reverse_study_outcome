package q1;

import a1.C0409b;
import a1.C0411d;
import android.content.Context;
import android.util.TypedValue;
import android.view.View;

/* renamed from: q1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0980b {
    public static TypedValue a(Context context, int i5) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i5, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean b(Context context, int i5, boolean z5) {
        TypedValue typedValueA = a(context, i5);
        return (typedValueA == null || typedValueA.type != 18) ? z5 : typedValueA.data != 0;
    }

    public static int c(Context context, int i5, int i6) {
        TypedValue typedValueA = a(context, i5);
        return (int) ((typedValueA == null || typedValueA.type != 5) ? context.getResources().getDimension(i6) : typedValueA.getDimension(context.getResources().getDisplayMetrics()));
    }

    public static int d(Context context, int i5, int i6) {
        TypedValue typedValueA = a(context, i5);
        return (typedValueA == null || typedValueA.type != 16) ? i6 : typedValueA.data;
    }

    public static int e(Context context) {
        return c(context, C0409b.f6735v, C0411d.f6777c0);
    }

    public static int f(Context context, int i5, String str) {
        return g(context, i5, str).data;
    }

    public static TypedValue g(Context context, int i5, String str) {
        TypedValue typedValueA = a(context, i5);
        if (typedValueA != null) {
            return typedValueA;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i5)));
    }

    public static TypedValue h(View view, int i5) {
        return g(view.getContext(), i5, view.getClass().getCanonicalName());
    }
}
