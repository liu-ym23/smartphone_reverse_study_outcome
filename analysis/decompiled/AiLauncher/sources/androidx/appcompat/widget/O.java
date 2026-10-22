package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.R$styleable;
import t0.C5502d;

/* loaded from: classes.dex */
public class O {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f9009a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f9010b = {-16842910};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f9011c = {R.attr.state_focused};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f9012d = {R.attr.state_activated};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f9013e = {R.attr.state_pressed};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f9014f = {R.attr.state_checked};

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f9015g = {R.attr.state_selected};

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f9016h = {-16842919, -16842908};

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f9017i = new int[0];

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f9018j = new int[1];

    public static void a(View view, Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R$styleable.AppCompatTheme);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowActionBar)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i10) {
        ColorStateList colorStateListE = e(context, i10);
        if (colorStateListE != null && colorStateListE.isStateful()) {
            return colorStateListE.getColorForState(f9010b, colorStateListE.getDefaultColor());
        }
        TypedValue typedValueF = f();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValueF, true);
        return d(context, i10, typedValueF.getFloat());
    }

    public static int c(Context context, int i10) {
        int[] iArr = f9018j;
        iArr[0] = i10;
        U u10 = U.u(context, null, iArr);
        try {
            return u10.b(0, 0);
        } finally {
            u10.x();
        }
    }

    public static int d(Context context, int i10, float f10) {
        return C5502d.k(c(context, i10), Math.round(Color.alpha(r0) * f10));
    }

    public static ColorStateList e(Context context, int i10) {
        int[] iArr = f9018j;
        iArr[0] = i10;
        U u10 = U.u(context, null, iArr);
        try {
            return u10.c(0);
        } finally {
            u10.x();
        }
    }

    public static TypedValue f() {
        ThreadLocal<TypedValue> threadLocal = f9009a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }
}
