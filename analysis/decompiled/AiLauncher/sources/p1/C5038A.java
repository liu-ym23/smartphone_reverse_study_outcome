package p1;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;

/* renamed from: p1.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C5038A {

    /* renamed from: a, reason: collision with root package name */
    public static final C5039B f38059a = new F();

    /* renamed from: b, reason: collision with root package name */
    public static final Property<View, Float> f38060b = new a(Float.class, "translationAlpha");

    /* renamed from: c, reason: collision with root package name */
    public static final Property<View, Rect> f38061c = new b(Rect.class, "clipBounds");

    /* renamed from: p1.A$a */
    public class a extends Property<View, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(C5038A.b(view));
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f10) {
            C5038A.e(view, f10.floatValue());
        }
    }

    /* renamed from: p1.A$b */
    public class b extends Property<View, Rect> {
        public b(Class cls, String str) {
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

    public static void a(View view) {
        f38059a.a(view);
    }

    public static float b(View view) {
        return f38059a.b(view);
    }

    public static void c(View view) {
        f38059a.c(view);
    }

    public static void d(View view, int i10, int i11, int i12, int i13) {
        f38059a.d(view, i10, i11, i12, i13);
    }

    public static void e(View view, float f10) {
        f38059a.e(view, f10);
    }

    public static void f(View view, int i10) {
        f38059a.f(view, i10);
    }

    public static void g(View view, Matrix matrix) {
        f38059a.g(view, matrix);
    }

    public static void h(View view, Matrix matrix) {
        f38059a.h(view, matrix);
    }
}
