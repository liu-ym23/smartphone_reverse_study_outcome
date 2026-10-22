package Z2;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.internal.u;

/* loaded from: classes2.dex */
public class i {
    public static e a(int i10) {
        return i10 != 0 ? i10 != 1 ? b() : new f() : new k();
    }

    public static e b() {
        return new k();
    }

    public static g c() {
        return new g();
    }

    public static void d(View view, float f10) {
        Drawable background = view.getBackground();
        if (background instanceof h) {
            ((h) background).f0(f10);
        }
    }

    public static void e(View view) {
        Drawable background = view.getBackground();
        if (background instanceof h) {
            f(view, (h) background);
        }
    }

    public static void f(View view, h hVar) {
        if (hVar.W()) {
            hVar.k0(u.f(view));
        }
    }
}
