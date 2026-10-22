package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public abstract class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e0 f5103a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Property f5104b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Property f5105c = null;

    public class a extends Property {
        public a(Class r10, String r11) {
            super(r10, r11);
        }

        public Float a(View r10) {
            return Float.valueOf(y.c(r10));
        }

        public void b(View r10, Float r11) {
            y.h(r10, r11.floatValue());
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Object get(Object r10) {
            return a((View) r10);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(Object r10, Object r11) {
            b((View) r10, (Float) r11);
        }
    }

    public class b extends Property {
        public b(Class r10, String r11) {
            super(r10, r11);
        }

        public Rect a(View r10) {
            return ViewCompat.t(r10);
        }

        public void b(View r10, Rect r11) {
            ViewCompat.w0(r10, r11);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Object get(Object r10) {
            return a((View) r10);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(Object r10, Object r11) {
            b((View) r10, (Rect) r11);
        }
    }

    static {
        f5103a = new d0();
        f5104b = new a(Float.class, "translationAlpha");
        f5105c = new b(Rect.class, "clipBounds");
    }

    public static void a(View r10) {
        f5103a.a(r10);
    }

    public static ViewOverlayImpl b(View r10) {
        return new x(r10);
    }

    public static float c(View r10) {
        return f5103a.b(r10);
    }

    public static WindowIdImpl d(View r10) {
        return new g0(r10);
    }

    public static void e(View r10) {
        f5103a.c(r10);
    }

    public static void f(View r10, Matrix r11) {
        f5103a.d(r10, r11);
    }

    public static void g(View r10, int r11, int r12, int r13, int r14) {
        f5103a.e(r10, r11, r12, r13, r14);
    }

    public static void h(View r10, float r11) {
        f5103a.f(r10, r11);
    }

    public static void i(View r10, int r11) {
        f5103a.g(r10, r11);
    }

    public static void j(View r10, Matrix r11) {
        f5103a.h(r10, r11);
    }

    public static void k(View r10, Matrix r11) {
        f5103a.i(r10, r11);
    }
}
