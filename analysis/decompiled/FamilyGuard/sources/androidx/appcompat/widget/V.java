package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

/* loaded from: classes.dex */
public class V {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f8444a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    static final int[] f8445b = {-16842910};

    /* renamed from: c, reason: collision with root package name */
    static final int[] f8446c = {R.attr.state_focused};

    /* renamed from: d, reason: collision with root package name */
    static final int[] f8447d = {R.attr.state_activated};

    /* renamed from: e, reason: collision with root package name */
    static final int[] f8448e = {R.attr.state_pressed};

    /* renamed from: f, reason: collision with root package name */
    static final int[] f8449f = {R.attr.state_checked};

    /* renamed from: g, reason: collision with root package name */
    static final int[] f8450g = {R.attr.state_selected};

    /* renamed from: h, reason: collision with root package name */
    static final int[] f8451h = {-16842919, -16842908};

    /* renamed from: i, reason: collision with root package name */
    static final int[] f8452i = new int[0];

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f8453j = new int[1];

    public static void a(View view, Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(g.j.f17215y0);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(g.j.f16998D0)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i5) {
        ColorStateList colorStateListE = e(context, i5);
        if (colorStateListE != null && colorStateListE.isStateful()) {
            return colorStateListE.getColorForState(f8445b, colorStateListE.getDefaultColor());
        }
        TypedValue typedValueF = f();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValueF, true);
        return d(context, i5, typedValueF.getFloat());
    }

    public static int c(Context context, int i5) {
        int[] iArr = f8453j;
        iArr[0] = i5;
        a0 a0VarU = a0.u(context, null, iArr);
        try {
            return a0VarU.b(0, 0);
        } finally {
            a0VarU.x();
        }
    }

    static int d(Context context, int i5, float f5) {
        return androidx.core.graphics.a.k(c(context, i5), Math.round(Color.alpha(r0) * f5));
    }

    public static ColorStateList e(Context context, int i5) {
        int[] iArr = f8453j;
        iArr[0] = i5;
        a0 a0VarU = a0.u(context, null, iArr);
        try {
            return a0VarU.c(0);
        } finally {
            a0VarU.x();
        }
    }

    private static TypedValue f() {
        ThreadLocal<TypedValue> threadLocal = f8444a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }
}
