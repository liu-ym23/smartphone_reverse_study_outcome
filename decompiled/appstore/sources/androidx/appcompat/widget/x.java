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

/* JADX INFO: loaded from: classes.dex */
public abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f1147a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1148b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f1149c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f1150d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f1151e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f1152f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f1153g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f1154h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f1155i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[] f1156j = null;

    static {
        f1147a = new ThreadLocal();
        f1148b = new int[]{-16842910};
        f1149c = new int[]{R.attr.state_focused};
        f1150d = new int[]{R.attr.state_activated};
        f1151e = new int[]{R.attr.state_pressed};
        f1152f = new int[]{R.attr.state_checked};
        f1153g = new int[]{R.attr.state_selected};
        f1154h = new int[]{-16842919, -16842908};
        f1155i = new int[0];
        f1156j = new int[1];
    }

    public static void a(View r10, Context r11) {
        TypedArray r12 = r11.obtainStyledAttributes(R$styleable.AppCompatTheme);
    L7:
        th = move-exception;
        r12.recycle();
        throw th;
    L4:
        if (r12.hasValue(R$styleable.AppCompatTheme_windowActionBar) == true) goto L9;
        Log.e("ThemeUtils", "View " + r10.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");     // Catch: Throwable -> L7
    L9:
        r12.recycle();
    }

    public static int b(Context r10, int r11) {
        ColorStateList r12 = e(r10, r11);
        if (r12 != null) goto L5;
    L8:
        TypedValue r13 = f();
        r10.getTheme().resolveAttribute(R.attr.disabledAlpha, r13, true);
        return d(r10, r11, r13.getFloat());
    L5:
        if (r12.isStateful() == false) goto L8;
        return r12.getColorForState(f1148b, r12.getDefaultColor());
    }

    public static int c(Context r10, int r11) {
        int[] r12 = f1156j;
        r12[0] = r11;
        b0 r13 = b0.u(r10, null, r12);
        int r14 = r13.b(0, 0);     // Catch: Throwable -> L6
        r13.w();
        return r14;
    L6:
        th = move-exception;
        r13.w();
        throw th;
    }

    public static int d(Context r10, int r11, float r12) {
        int r13 = c(r10, r11);
        return androidx.core.graphics.d.k(r13, Math.round(Color.alpha(r13) * r12));
    }

    public static ColorStateList e(Context r10, int r11) {
        int[] r12 = f1156j;
        r12[0] = r11;
        b0 r13 = b0.u(r10, null, r12);
        ColorStateList r14 = r13.c(0);     // Catch: Throwable -> L6
        r13.w();
        return r14;
    L6:
        th = move-exception;
        r13.w();
        throw th;
    }

    public static TypedValue f() {
        ThreadLocal r10 = f1147a;
        TypedValue r11 = (TypedValue) r10.get();
        if (r11 != null) goto L6;
        TypedValue r12 = new TypedValue();
        r10.set(r12);
        return r12;
    L6:
        return r11;
    }
}
