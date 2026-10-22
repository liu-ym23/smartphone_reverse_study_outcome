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
public final class Z {

    /* renamed from: a, reason: collision with root package name */
    public d f13146a;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final t0.e f13147a;

        /* renamed from: b, reason: collision with root package name */
        public final t0.e f13148b;

        public a(WindowInsetsAnimation.Bounds bounds) {
            this.f13147a = c.h(bounds);
            this.f13148b = c.g(bounds);
        }

        public static a d(WindowInsetsAnimation.Bounds bounds) {
            return new a(bounds);
        }

        public t0.e a() {
            return this.f13147a;
        }

        public t0.e b() {
            return this.f13148b;
        }

        public WindowInsetsAnimation.Bounds c() {
            return c.f(this);
        }

        public String toString() {
            return "Bounds{lower=" + this.f13147a + " upper=" + this.f13148b + "}";
        }
    }

    public static abstract class b {
        public static final int DISPATCH_MODE_CONTINUE_ON_SUBTREE = 1;
        public static final int DISPATCH_MODE_STOP = 0;
        a0 mDispachedInsets;
        private final int mDispatchMode;

        public b(int i10) {
            this.mDispatchMode = i10;
        }

        public final int a() {
            return this.mDispatchMode;
        }

        public void b(Z z10) {
        }

        public void c(Z z10) {
        }

        public abstract a0 d(a0 a0Var, List<Z> list);

        public a e(Z z10, a aVar) {
            return aVar;
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f13154a;

        /* renamed from: b, reason: collision with root package name */
        public final Interpolator f13155b;

        /* renamed from: c, reason: collision with root package name */
        public final long f13156c;

        /* renamed from: d, reason: collision with root package name */
        public float f13157d = 1.0f;

        public d(int i10, Interpolator interpolator, long j10) {
            this.f13154a = i10;
            this.f13155b = interpolator;
            this.f13156c = j10;
        }

        public long a() {
            throw null;
        }

        public float b() {
            throw null;
        }

        public float c() {
            throw null;
        }

        public int d() {
            throw null;
        }

        public void e(float f10) {
            throw null;
        }
    }

    public Z(int i10, Interpolator interpolator, long j10) {
        this.f13146a = new c(i10, interpolator, j10);
    }

    public static void e(View view, b bVar) {
        c.i(view, bVar);
    }

    public static Z g(WindowInsetsAnimation windowInsetsAnimation) {
        return new Z(windowInsetsAnimation);
    }

    public long a() {
        return this.f13146a.a();
    }

    public float b() {
        return this.f13146a.b();
    }

    public float c() {
        return this.f13146a.c();
    }

    public int d() {
        return this.f13146a.d();
    }

    public void f(float f10) {
        this.f13146a.e(f10);
    }

    public static class c extends d {

        /* renamed from: e, reason: collision with root package name */
        public final WindowInsetsAnimation f13149e;

        public static class a extends WindowInsetsAnimation.Callback {

            /* renamed from: a, reason: collision with root package name */
            public final b f13150a;

            /* renamed from: b, reason: collision with root package name */
            public List<Z> f13151b;

            /* renamed from: c, reason: collision with root package name */
            public ArrayList<Z> f13152c;

            /* renamed from: d, reason: collision with root package name */
            public final HashMap<WindowInsetsAnimation, Z> f13153d;

            public a(b bVar) {
                super(bVar.a());
                this.f13153d = new HashMap<>();
                this.f13150a = bVar;
            }

            public final Z a(WindowInsetsAnimation windowInsetsAnimation) {
                Z z10 = this.f13153d.get(windowInsetsAnimation);
                if (z10 != null) {
                    return z10;
                }
                Z zG = Z.g(windowInsetsAnimation);
                this.f13153d.put(windowInsetsAnimation, zG);
                return zG;
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
                this.f13150a.b(a(windowInsetsAnimation));
                this.f13153d.remove(windowInsetsAnimation);
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
                this.f13150a.c(a(windowInsetsAnimation));
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public WindowInsets onProgress(WindowInsets windowInsets, List<WindowInsetsAnimation> list) {
                ArrayList<Z> arrayList = this.f13152c;
                if (arrayList == null) {
                    ArrayList<Z> arrayList2 = new ArrayList<>(list.size());
                    this.f13152c = arrayList2;
                    this.f13151b = Collections.unmodifiableList(arrayList2);
                } else {
                    arrayList.clear();
                }
                for (int size = list.size() - 1; size >= 0; size--) {
                    WindowInsetsAnimation windowInsetsAnimation = list.get(size);
                    Z zA = a(windowInsetsAnimation);
                    zA.f(windowInsetsAnimation.getFraction());
                    this.f13152c.add(zA);
                }
                return this.f13150a.d(a0.y(windowInsets), this.f13151b).x();
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
                return this.f13150a.e(a(windowInsetsAnimation), a.d(bounds)).c();
            }
        }

        public c(WindowInsetsAnimation windowInsetsAnimation) {
            super(0, null, 0L);
            this.f13149e = windowInsetsAnimation;
        }

        public static WindowInsetsAnimation.Bounds f(a aVar) {
            return new WindowInsetsAnimation.Bounds(aVar.a().d(), aVar.b().d());
        }

        public static t0.e g(WindowInsetsAnimation.Bounds bounds) {
            return t0.e.c(bounds.getUpperBound());
        }

        public static t0.e h(WindowInsetsAnimation.Bounds bounds) {
            return t0.e.c(bounds.getLowerBound());
        }

        public static void i(View view, b bVar) {
            view.setWindowInsetsAnimationCallback(bVar != null ? new a(bVar) : null);
        }

        @Override // androidx.core.view.Z.d
        public long a() {
            return this.f13149e.getDurationMillis();
        }

        @Override // androidx.core.view.Z.d
        public float b() {
            return this.f13149e.getFraction();
        }

        @Override // androidx.core.view.Z.d
        public float c() {
            return this.f13149e.getInterpolatedFraction();
        }

        @Override // androidx.core.view.Z.d
        public int d() {
            return this.f13149e.getTypeMask();
        }

        @Override // androidx.core.view.Z.d
        public void e(float f10) {
            this.f13149e.setFraction(f10);
        }

        public c(int i10, Interpolator interpolator, long j10) {
            this(new WindowInsetsAnimation(i10, interpolator, j10));
        }
    }

    public Z(WindowInsetsAnimation windowInsetsAnimation) {
        this(0, null, 0L);
        this.f13146a = new c(windowInsetsAnimation);
    }
}
