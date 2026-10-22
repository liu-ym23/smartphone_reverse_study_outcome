package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;

/* loaded from: classes.dex */
public final class A {

    /* renamed from: b, reason: collision with root package name */
    public static final PorterDuff.Mode f2721b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c, reason: collision with root package name */
    public static A f2722c;

    /* renamed from: a, reason: collision with root package name */
    public N0 f2723a;

    public static synchronized A a() {
        try {
            if (f2722c == null) {
                c();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f2722c;
    }

    public static synchronized void c() {
        if (f2722c == null) {
            A a4 = new A();
            f2722c = a4;
            a4.f2723a = N0.c();
            N0 n02 = f2722c.f2723a;
            C0238z c0238z = new C0238z(0);
            synchronized (n02) {
                n02.f2893e = c0238z;
            }
        }
    }

    public static void d(Drawable drawable, X0 x02, int[] iArr) {
        PorterDuff.Mode mode = N0.f2886f;
        int[] state = drawable.getState();
        if (drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z4 = x02.f3045d;
        if (!z4 && !x02.f3044c) {
            drawable.clearColorFilter();
            return;
        }
        PorterDuffColorFilter porterDuffColorFilterG = null;
        ColorStateList colorStateList = z4 ? x02.f3042a : null;
        PorterDuff.Mode mode2 = x02.f3044c ? x02.f3043b : N0.f2886f;
        if (colorStateList != null && mode2 != null) {
            porterDuffColorFilterG = N0.g(colorStateList.getColorForState(iArr, 0), mode2);
        }
        drawable.setColorFilter(porterDuffColorFilterG);
    }

    public final synchronized Drawable b(Context context, int i4) {
        return this.f2723a.e(context, i4);
    }
}
