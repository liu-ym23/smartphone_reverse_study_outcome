package tc;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Insets;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class f {
    public static final int a(Context r10, float r11) {
        q.g(r10, "<this>");
        if (r11 != 0.0f) goto L6;
        return 0;
    L6:
        return yf.b.b(r11 * r10.getResources().getDisplayMetrics().density);
    }

    public static final int b(Context r10, int r11) {
        q.g(r10, "<this>");
        if (r11 != 0) goto L6;
        return 0;
    L6:
        return a(r10, r11);
    }

    public static final float c(Context r10, double r11) {
        q.g(r10, "<this>");
        if (r11 != 0.0d) goto L6;
        return 0.0f;
    L6:
        return d(r10, (float) r11);
    }

    public static final float d(Context r10, float r11) {
        q.g(r10, "<this>");
        if (r11 != 0.0f) goto L6;
        return 0.0f;
    L6:
        return TypedValue.applyDimension(1, r11, r10.getResources().getDisplayMetrics());
    }

    public static final float e(Context r10, int r11) {
        q.g(r10, "<this>");
        if (r11 != 0) goto L6;
        return 0.0f;
    L6:
        return d(r10, r11);
    }

    public static final float f(Context r10, float r11) {
        q.g(r10, "<this>");
        if (r11 != 0.0f) goto L6;
        return 0.0f;
    L6:
        return TypedValue.applyDimension(2, r11, r10.getResources().getDisplayMetrics());
    }

    public static final float g(float r10) {
        return r10 * Resources.getSystem().getDisplayMetrics().density;
    }

    public static final float h(float r10, Context r11) {
        q.g(r11, "context");
        return r10 * r11.getResources().getDisplayMetrics().density;
    }

    public static final int i(int r10) {
        return (int) ((r10 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static final float j(float r10, float r11) {
        if (r10 != 0.0f) goto L6;
        return 0.0f;
    L6:
        return r10 * r11;
    }

    public static final int k(Context r10) {
        q.g(r10, "<this>");
        WindowManager r11 = (WindowManager) r10.getSystemService(WindowManager.class);
        Integer r12 = null;
        if (r11 != null) goto L5;
        WindowMetrics r13 = null;
    L6:
        if (r13 != null) goto L8;
    L7:
        Insets r14 = null;
    L12:
        if (r13 == null) goto L18;
        Rect r15 = r13.getBounds();
        if (r15 == null) goto L18;
        r12 = Integer.valueOf(r15.height());
    L18:
        if (r12 != null) goto L20;
        int r16 = m(r10);
    L21:
        int r17 = 0;
        if (r14 != null) goto L24;
        int r18 = 0;
    L25:
        if (r14 == null) goto L29;
        r17 = r14.bottom;
    L29:
        return (r16 - r18) - r17;
    L24:
        r18 = r14.top;
        goto L25
    L20:
        r16 = r12.intValue();
        goto L21
    L8:
        WindowInsets r19 = r13.getWindowInsets();
        if (r19 == null) goto L7;
        r14 = r19.getInsets(WindowInsets.Type.systemBars());
        goto L12
    L5:
        r13 = r11.getCurrentWindowMetrics();
        goto L6
    }

    public static final int l(String r10) {
        q.g(r10, "<this>");
        return Color.parseColor(r10);
    }

    public static final int m(Context r10) {
        q.g(r10, "<this>");
        DisplayMetrics r11 = r10.getResources().getDisplayMetrics();
        if (r11 != null) goto L6;
        return 0;
    L6:
        return r11.heightPixels;
    }

    public static final int n(Context r10) {
        q.g(r10, "<this>");
        DisplayMetrics r11 = r10.getResources().getDisplayMetrics();
        if (r11 != null) goto L6;
        return 0;
    L6:
        return r11.widthPixels;
    }

    public static final int o(Context r10, float r11) {
        q.g(r10, "<this>");
        return yf.b.b(r11 / r10.getResources().getDisplayMetrics().density);
    }

    public static final int p(View r10, double r11) {
        q.g(r10, "<this>");
        if (r11 != 0.0d) goto L6;
        return 0;
    L6:
        return q(r10, (float) r11);
    }

    public static final int q(View r10, float r11) {
        q.g(r10, "<this>");
        if (r11 != 0.0f) goto L6;
        return 0;
    L6:
        return yf.b.b(r11 * r10.getResources().getDisplayMetrics().density);
    }

    public static final int r(View r10, int r11) {
        q.g(r10, "<this>");
        if (r11 != 0) goto L6;
        return 0;
    L6:
        return q(r10, r11);
    }

    public static final float s(View r10, double r11) {
        q.g(r10, "<this>");
        if (r11 != 0.0d) goto L6;
        return 0.0f;
    L6:
        return t(r10, (float) r11);
    }

    public static final float t(View r10, float r11) {
        q.g(r10, "<this>");
        if (r11 != 0.0f) goto L6;
        return 0.0f;
    L6:
        return TypedValue.applyDimension(1, r11, r10.getResources().getDisplayMetrics());
    }

    public static final float u(View r10, int r11) {
        q.g(r10, "<this>");
        if (r11 != 0) goto L6;
        return 0.0f;
    L6:
        return t(r10, r11);
    }

    public static final float v(View r10, float r11) {
        q.g(r10, "<this>");
        if (r11 != 0.0f) goto L6;
        return 0.0f;
    L6:
        return TypedValue.applyDimension(2, r11, r10.getResources().getDisplayMetrics());
    }
}
