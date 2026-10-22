package j1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import q1.C0980b;

/* renamed from: j1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0777a {
    public static int a(int i5, int i6) {
        return androidx.core.graphics.a.k(i5, (Color.alpha(i5) * i6) / 255);
    }

    public static int b(Context context, int i5, int i6) {
        Integer numF = f(context, i5);
        return numF != null ? numF.intValue() : i6;
    }

    public static int c(Context context, int i5, String str) {
        return l(context, C0980b.g(context, i5, str));
    }

    public static int d(View view, int i5) {
        return l(view.getContext(), C0980b.h(view, i5));
    }

    public static int e(View view, int i5, int i6) {
        return b(view.getContext(), i5, i6);
    }

    public static Integer f(Context context, int i5) {
        TypedValue typedValueA = C0980b.a(context, i5);
        if (typedValueA != null) {
            return Integer.valueOf(l(context, typedValueA));
        }
        return null;
    }

    public static ColorStateList g(Context context, int i5) {
        TypedValue typedValueA = C0980b.a(context, i5);
        if (typedValueA == null) {
            return null;
        }
        int i6 = typedValueA.resourceId;
        if (i6 != 0) {
            return androidx.core.content.a.d(context, i6);
        }
        int i7 = typedValueA.data;
        if (i7 != 0) {
            return ColorStateList.valueOf(i7);
        }
        return null;
    }

    public static boolean h(int i5) {
        return i5 != 0 && androidx.core.graphics.a.d(i5) > 0.5d;
    }

    public static int i(int i5, int i6) {
        return androidx.core.graphics.a.g(i6, i5);
    }

    public static int j(int i5, int i6, float f5) {
        return i(i5, androidx.core.graphics.a.k(i6, Math.round(Color.alpha(i6) * f5)));
    }

    public static int k(View view, int i5, int i6, float f5) {
        return j(d(view, i5), d(view, i6), f5);
    }

    private static int l(Context context, TypedValue typedValue) {
        int i5 = typedValue.resourceId;
        return i5 != 0 ? androidx.core.content.a.c(context, i5) : typedValue.data;
    }
}
