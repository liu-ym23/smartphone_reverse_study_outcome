package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;

/* loaded from: classes.dex */
class y {

    /* renamed from: a, reason: collision with root package name */
    private static final z f11499a = new D();

    /* renamed from: b, reason: collision with root package name */
    static final Property<View, Float> f11500b = new a(Float.class, "translationAlpha");

    /* renamed from: c, reason: collision with root package name */
    static final Property<View, Rect> f11501c = new b(Rect.class, "clipBounds");

    class a extends Property<View, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(y.b(view));
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f5) {
            y.e(view, f5.floatValue());
        }
    }

    class b extends Property<View, Rect> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect get(View view) {
            return view.getClipBounds();
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Rect rect) {
            view.setClipBounds(rect);
        }
    }

    static void a(View view) {
        f11499a.a(view);
    }

    static float b(View view) {
        return f11499a.b(view);
    }

    static void c(View view) {
        f11499a.c(view);
    }

    static void d(View view, int i5, int i6, int i7, int i8) {
        f11499a.d(view, i5, i6, i7, i8);
    }

    static void e(View view, float f5) {
        f11499a.e(view, f5);
    }

    static void f(View view, int i5) {
        f11499a.f(view, i5);
    }

    static void g(View view, Matrix matrix) {
        f11499a.g(view, matrix);
    }

    static void h(View view, Matrix matrix) {
        f11499a.h(view, matrix);
    }
}
