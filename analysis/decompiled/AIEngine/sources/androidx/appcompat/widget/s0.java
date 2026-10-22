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

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class s0 {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f924a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f925b = {-16842910};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f926c = {R.attr.state_focused};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f927d = {R.attr.state_pressed};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f928e = {R.attr.state_checked};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f929f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f930g = new int[1];

    public static void a(View view, Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(g.a.f8929j);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(121)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int b(int i10, Context context) {
        ColorStateList colorStateListD = d(i10, context);
        if (colorStateListD != null && colorStateListD.isStateful()) {
            return colorStateListD.getColorForState(f925b, colorStateListD.getDefaultColor());
        }
        ThreadLocal<TypedValue> threadLocal = f924a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValue, true);
        float f8 = typedValue.getFloat();
        return n0.a.d(c(i10, context), Math.round(Color.alpha(r4) * f8));
    }

    public static int c(int i10, Context context) {
        int[] iArr = f930g;
        iArr[0] = i10;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            return typedArrayObtainStyledAttributes.getColor(0, 0);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList d(int i10, Context context) {
        ColorStateList colorStateList;
        int resourceId;
        int[] iArr = f930g;
        iArr[0] = i10;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) == 0 || (colorStateList = androidx.core.content.a.b(resourceId, context)) == null) {
                colorStateList = typedArrayObtainStyledAttributes.getColorStateList(0);
            }
            return colorStateList;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
