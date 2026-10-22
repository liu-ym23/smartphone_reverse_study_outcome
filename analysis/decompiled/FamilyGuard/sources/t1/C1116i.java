package t1;

import android.graphics.drawable.Drawable;
import android.view.View;

/* renamed from: t1.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1116i {
    static C1112e a(int i5) {
        return i5 != 0 ? i5 != 1 ? b() : new C1113f() : new k();
    }

    static C1112e b() {
        return new k();
    }

    static C1114g c() {
        return new C1114g();
    }

    public static void d(View view, float f5) {
        Drawable background = view.getBackground();
        if (background instanceof C1115h) {
            ((C1115h) background).f0(f5);
        }
    }

    public static void e(View view) {
        Drawable background = view.getBackground();
        if (background instanceof C1115h) {
            f(view, (C1115h) background);
        }
    }

    public static void f(View view, C1115h c1115h) {
        if (c1115h.W()) {
            c1115h.k0(com.google.android.material.internal.r.f(view));
        }
    }
}
