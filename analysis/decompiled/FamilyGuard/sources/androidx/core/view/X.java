package androidx.core.view;

import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class X {

    /* renamed from: a, reason: collision with root package name */
    private d f9759a;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final androidx.core.graphics.b f9760a;

        /* renamed from: b, reason: collision with root package name */
        private final androidx.core.graphics.b f9761b;

        private a(WindowInsetsAnimation.Bounds bounds) {
            this.f9760a = c.f(bounds);
            this.f9761b = c.e(bounds);
        }

        public static a d(WindowInsetsAnimation.Bounds bounds) {
            return new a(bounds);
        }

        public androidx.core.graphics.b a() {
            return this.f9760a;
        }

        public androidx.core.graphics.b b() {
            return this.f9761b;
        }

        public WindowInsetsAnimation.Bounds c() {
            return c.d(this);
        }

        public String toString() {
            return "Bounds{lower=" + this.f9760a + " upper=" + this.f9761b + "}";
        }
    }

    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f9762a;

        public b(int i5) {
            this.f9762a = i5;
        }

        public final int a() {
            return this.f9762a;
        }

        public abstract void b(X x5);

        public abstract void c(X x5);

        public abstract Y d(Y y5, List<X> list);

        public abstract a e(X x5, a aVar);
    }

    private static class d {

        /* renamed from: a, reason: collision with root package name */
        private final int f9768a;

        /* renamed from: b, reason: collision with root package name */
        private final Interpolator f9769b;

        /* renamed from: c, reason: collision with root package name */
        private final long f9770c;

        d(int i5, Interpolator interpolator, long j5) {
            this.f9768a = i5;
            this.f9769b = interpolator;
            this.f9770c = j5;
        }

        public float a() {
            throw null;
        }

        public int b() {
            throw null;
        }

        public void c(float f5) {
            throw null;
        }
    }

    public X(int i5, Interpolator interpolator, long j5) {
        this.f9759a = new c(i5, interpolator, j5);
    }

    static void c(View view, b bVar) {
        c.g(view, bVar);
    }

    static X e(WindowInsetsAnimation windowInsetsAnimation) {
        return new X(windowInsetsAnimation);
    }

    public float a() {
        return this.f9759a.a();
    }

    public int b() {
        return this.f9759a.b();
    }

    public void d(float f5) {
        this.f9759a.c(f5);
    }

    private static class c extends d {

        /* renamed from: d, reason: collision with root package name */
        private final WindowInsetsAnimation f9763d;

        private static class a extends WindowInsetsAnimation.Callback {

            /* renamed from: a, reason: collision with root package name */
            private final b f9764a;

            /* renamed from: b, reason: collision with root package name */
            private List<X> f9765b;

            /* renamed from: c, reason: collision with root package name */
            private ArrayList<X> f9766c;

            /* renamed from: d, reason: collision with root package name */
            private final HashMap<WindowInsetsAnimation, X> f9767d;

            a(b bVar) {
                super(bVar.a());
                this.f9767d = new HashMap<>();
                this.f9764a = bVar;
            }

            private X a(WindowInsetsAnimation windowInsetsAnimation) {
                X x5 = this.f9767d.get(windowInsetsAnimation);
                if (x5 != null) {
                    return x5;
                }
                X xE = X.e(windowInsetsAnimation);
                this.f9767d.put(windowInsetsAnimation, xE);
                return xE;
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
                this.f9764a.b(a(windowInsetsAnimation));
                this.f9767d.remove(windowInsetsAnimation);
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
                this.f9764a.c(a(windowInsetsAnimation));
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public WindowInsets onProgress(WindowInsets windowInsets, List<WindowInsetsAnimation> list) {
                ArrayList<X> arrayList = this.f9766c;
                if (arrayList == null) {
                    ArrayList<X> arrayList2 = new ArrayList<>(list.size());
                    this.f9766c = arrayList2;
                    this.f9765b = Collections.unmodifiableList(arrayList2);
                } else {
                    arrayList.clear();
                }
                for (int size = list.size() - 1; size >= 0; size--) {
                    WindowInsetsAnimation windowInsetsAnimation = list.get(size);
                    X xA = a(windowInsetsAnimation);
                    xA.d(windowInsetsAnimation.getFraction());
                    this.f9766c.add(xA);
                }
                return this.f9764a.d(Y.t(windowInsets), this.f9765b).s();
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
                return this.f9764a.e(a(windowInsetsAnimation), a.d(bounds)).c();
            }
        }

        c(WindowInsetsAnimation windowInsetsAnimation) {
            super(0, null, 0L);
            this.f9763d = windowInsetsAnimation;
        }

        public static WindowInsetsAnimation.Bounds d(a aVar) {
            return new WindowInsetsAnimation.Bounds(aVar.a().e(), aVar.b().e());
        }

        public static androidx.core.graphics.b e(WindowInsetsAnimation.Bounds bounds) {
            return androidx.core.graphics.b.d(bounds.getUpperBound());
        }

        public static androidx.core.graphics.b f(WindowInsetsAnimation.Bounds bounds) {
            return androidx.core.graphics.b.d(bounds.getLowerBound());
        }

        public static void g(View view, b bVar) {
            view.setWindowInsetsAnimationCallback(bVar != null ? new a(bVar) : null);
        }

        @Override // androidx.core.view.X.d
        public float a() {
            return this.f9763d.getInterpolatedFraction();
        }

        @Override // androidx.core.view.X.d
        public int b() {
            return this.f9763d.getTypeMask();
        }

        @Override // androidx.core.view.X.d
        public void c(float f5) {
            this.f9763d.setFraction(f5);
        }

        c(int i5, Interpolator interpolator, long j5) {
            this(new WindowInsetsAnimation(i5, interpolator, j5));
        }
    }

    private X(WindowInsetsAnimation windowInsetsAnimation) {
        this(0, null, 0L);
        this.f9759a = new c(windowInsetsAnimation);
    }
}
