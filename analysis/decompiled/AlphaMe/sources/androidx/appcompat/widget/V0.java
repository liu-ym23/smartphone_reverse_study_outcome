package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import g.AbstractC0560a;

/* loaded from: classes.dex */
public abstract class V0 {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f3023a = new ThreadLocal();

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f3024b = {-16842910};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f3025c = {R.attr.state_focused};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f3026d = {R.attr.state_pressed};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f3027e = {R.attr.state_checked};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f3028f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f3029g = new int[1];

    public static void a(Context context, View view) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(AbstractC0560a.f12597j);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(121)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int b(int i4, Context context) {
        ColorStateList colorStateListD = d(i4, context);
        if (colorStateListD != null && colorStateListD.isStateful()) {
            return colorStateListD.getColorForState(f3024b, colorStateListD.getDefaultColor());
        }
        ThreadLocal threadLocal = f3023a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValue, true);
        float f4 = typedValue.getFloat();
        return D.a.d(c(i4, context), Math.round(Color.alpha(r4) * f4));
    }

    public static int c(int i4, Context context) {
        int[] iArr = f3029g;
        iArr[0] = i4;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            return typedArrayObtainStyledAttributes.getColor(0, 0);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList d(int i4, Context context) {
        ColorStateList colorStateList;
        int resourceId;
        int[] iArr = f3029g;
        iArr[0] = i4;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) == 0 || (colorStateList = B0.f.x(resourceId, context)) == null) {
                colorStateList = typedArrayObtainStyledAttributes.getColorStateList(0);
            }
            return colorStateList;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
