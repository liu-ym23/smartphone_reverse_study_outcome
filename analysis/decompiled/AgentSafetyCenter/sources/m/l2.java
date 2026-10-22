package m;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class l2 {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f7989a = new ThreadLocal();

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f7990b = {-16842910};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f7991c = {R.attr.state_focused};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f7992d = {R.attr.state_pressed};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f7993e = {R.attr.state_checked};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f7994f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f7995g = new int[1];

    public static void a(View view, Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(g.a.f4106j);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(121)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int b(int i, Context context) {
        ColorStateList colorStateListD = d(i, context);
        if (colorStateListD != null && colorStateListD.isStateful()) {
            return colorStateListD.getColorForState(f7990b, colorStateListD.getDefaultColor());
        }
        ThreadLocal threadLocal = f7989a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValue, true);
        float f5 = typedValue.getFloat();
        return f3.a.d(c(i, context), Math.round(Color.alpha(r4) * f5));
    }

    public static int c(int i, Context context) {
        int[] iArr = f7995g;
        iArr[0] = i;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            return typedArrayObtainStyledAttributes.getColor(0, 0);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList d(int i, Context context) {
        ColorStateList colorStateList;
        int resourceId;
        int[] iArr = f7995g;
        iArr[0] = i;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) == 0 || (colorStateList = id.k.u(resourceId, context)) == null) {
                colorStateList = typedArrayObtainStyledAttributes.getColorStateList(0);
            }
            return colorStateList;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
