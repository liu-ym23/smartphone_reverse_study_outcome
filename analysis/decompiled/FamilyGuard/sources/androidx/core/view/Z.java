package androidx.core.view;

import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* loaded from: classes.dex */
public final class Z {

    /* renamed from: a, reason: collision with root package name */
    private final b f9793a;

    private static class b {
        b() {
        }

        public void a(boolean z5) {
            throw null;
        }

        public void b(boolean z5) {
            throw null;
        }

        void c(int i5) {
            throw null;
        }
    }

    @Deprecated
    private Z(WindowInsetsController windowInsetsController) {
        this.f9793a = new a(windowInsetsController, this, new C(windowInsetsController));
    }

    @Deprecated
    public static Z d(WindowInsetsController windowInsetsController) {
        return new Z(windowInsetsController);
    }

    public void a(boolean z5) {
        this.f9793a.a(z5);
    }

    public void b(boolean z5) {
        this.f9793a.b(z5);
    }

    public void c(int i5) {
        this.f9793a.c(i5);
    }

    private static class a extends b {

        /* renamed from: a, reason: collision with root package name */
        final Z f9794a;

        /* renamed from: b, reason: collision with root package name */
        final WindowInsetsController f9795b;

        /* renamed from: c, reason: collision with root package name */
        final C f9796c;

        /* renamed from: d, reason: collision with root package name */
        private final q.i<Object, WindowInsetsController.OnControllableInsetsChangedListener> f9797d;

        /* renamed from: e, reason: collision with root package name */
        protected Window f9798e;

        a(Window window, Z z5, C c6) {
            this(window.getInsetsController(), z5, c6);
            this.f9798e = window;
        }

        @Override // androidx.core.view.Z.b
        public void a(boolean z5) {
            if (z5) {
                if (this.f9798e != null) {
                    d(16);
                }
                this.f9795b.setSystemBarsAppearance(16, 16);
            } else {
                if (this.f9798e != null) {
                    e(16);
                }
                this.f9795b.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // androidx.core.view.Z.b
        public void b(boolean z5) {
            if (z5) {
                if (this.f9798e != null) {
                    d(8192);
                }
                this.f9795b.setSystemBarsAppearance(8, 8);
            } else {
                if (this.f9798e != null) {
                    e(8192);
                }
                this.f9795b.setSystemBarsAppearance(0, 8);
            }
        }

        @Override // androidx.core.view.Z.b
        void c(int i5) {
            if ((i5 & 8) != 0) {
                this.f9796c.a();
            }
            this.f9795b.show(i5 & (-9));
        }

        protected void d(int i5) {
            View decorView = this.f9798e.getDecorView();
            decorView.setSystemUiVisibility(i5 | decorView.getSystemUiVisibility());
        }

        protected void e(int i5) {
            View decorView = this.f9798e.getDecorView();
            decorView.setSystemUiVisibility((~i5) & decorView.getSystemUiVisibility());
        }

        a(WindowInsetsController windowInsetsController, Z z5, C c6) {
            this.f9797d = new q.i<>();
            this.f9795b = windowInsetsController;
            this.f9794a = z5;
            this.f9796c = c6;
        }
    }

    public Z(Window window, View view) {
        this.f9793a = new a(window, this, new C(view));
    }
}
