package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public final d f13182a;

    public static class b extends a {
        public b(Window window, b0 b0Var, H h10) {
            super(window, b0Var, h10);
        }

        @Override // androidx.core.view.b0.a, androidx.core.view.b0.d
        public void f(int i10) {
            this.f13184b.setSystemBarsBehavior(i10);
        }

        public b(WindowInsetsController windowInsetsController, b0 b0Var, H h10) {
            super(windowInsetsController, b0Var, h10);
        }
    }

    public static class c extends b {
        public c(Window window, b0 b0Var, H h10) {
            super(window, b0Var, h10);
        }

        @Override // androidx.core.view.b0.a, androidx.core.view.b0.d
        public boolean b() {
            return (this.f13184b.getSystemBarsAppearance() & 16) != 0;
        }

        @Override // androidx.core.view.b0.a, androidx.core.view.b0.d
        public boolean c() {
            return (this.f13184b.getSystemBarsAppearance() & 8) != 0;
        }

        public c(WindowInsetsController windowInsetsController, b0 b0Var, H h10) {
            super(windowInsetsController, b0Var, h10);
        }
    }

    public static class d {
        public void a(int i10) {
            throw null;
        }

        public boolean b() {
            throw null;
        }

        public boolean c() {
            throw null;
        }

        public void d(boolean z10) {
            throw null;
        }

        public void e(boolean z10) {
            throw null;
        }

        public void f(int i10) {
            throw null;
        }

        public void g(int i10) {
            throw null;
        }
    }

    @Deprecated
    public b0(WindowInsetsController windowInsetsController) {
        if (Build.VERSION.SDK_INT >= 35) {
            this.f13182a = new c(windowInsetsController, this, new H(windowInsetsController));
        } else {
            this.f13182a = new a(windowInsetsController, this, new H(windowInsetsController));
        }
    }

    @Deprecated
    public static b0 h(WindowInsetsController windowInsetsController) {
        return new b0(windowInsetsController);
    }

    public void a(int i10) {
        this.f13182a.a(i10);
    }

    public boolean b() {
        return this.f13182a.b();
    }

    public boolean c() {
        return this.f13182a.c();
    }

    public void d(boolean z10) {
        this.f13182a.d(z10);
    }

    public void e(boolean z10) {
        this.f13182a.e(z10);
    }

    public void f(int i10) {
        this.f13182a.f(i10);
    }

    public void g(int i10) {
        this.f13182a.g(i10);
    }

    public static class a extends d {

        /* renamed from: a, reason: collision with root package name */
        public final b0 f13183a;

        /* renamed from: b, reason: collision with root package name */
        public final WindowInsetsController f13184b;

        /* renamed from: c, reason: collision with root package name */
        public final H f13185c;

        /* renamed from: d, reason: collision with root package name */
        public final androidx.collection.t<Object, WindowInsetsController.OnControllableInsetsChangedListener> f13186d;

        /* renamed from: e, reason: collision with root package name */
        public Window f13187e;

        public a(Window window, b0 b0Var, H h10) {
            this(window.getInsetsController(), b0Var, h10);
            this.f13187e = window;
        }

        @Override // androidx.core.view.b0.d
        public void a(int i10) {
            if ((i10 & 8) != 0) {
                this.f13185c.a();
            }
            this.f13184b.hide(i10 & (-9));
        }

        @Override // androidx.core.view.b0.d
        public boolean b() {
            this.f13184b.setSystemBarsAppearance(0, 0);
            return (this.f13184b.getSystemBarsAppearance() & 16) != 0;
        }

        @Override // androidx.core.view.b0.d
        public boolean c() {
            this.f13184b.setSystemBarsAppearance(0, 0);
            return (this.f13184b.getSystemBarsAppearance() & 8) != 0;
        }

        @Override // androidx.core.view.b0.d
        public void d(boolean z10) {
            if (z10) {
                if (this.f13187e != null) {
                    h(16);
                }
                this.f13184b.setSystemBarsAppearance(16, 16);
            } else {
                if (this.f13187e != null) {
                    i(16);
                }
                this.f13184b.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // androidx.core.view.b0.d
        public void e(boolean z10) {
            if (z10) {
                if (this.f13187e != null) {
                    h(com.stepos.agentframework.chatui.longtext.b.THRESHOLD);
                }
                this.f13184b.setSystemBarsAppearance(8, 8);
            } else {
                if (this.f13187e != null) {
                    i(com.stepos.agentframework.chatui.longtext.b.THRESHOLD);
                }
                this.f13184b.setSystemBarsAppearance(0, 8);
            }
        }

        @Override // androidx.core.view.b0.d
        public void f(int i10) {
            Window window = this.f13187e;
            if (window == null) {
                this.f13184b.setSystemBarsBehavior(i10);
                return;
            }
            window.getDecorView().setTag(356039078, Integer.valueOf(i10));
            if (i10 == 0) {
                i(6144);
                return;
            }
            if (i10 == 1) {
                i(4096);
                h(2048);
            } else {
                if (i10 != 2) {
                    return;
                }
                i(2048);
                h(4096);
            }
        }

        @Override // androidx.core.view.b0.d
        public void g(int i10) {
            if ((i10 & 8) != 0) {
                this.f13185c.b();
            }
            this.f13184b.show(i10 & (-9));
        }

        public void h(int i10) {
            View decorView = this.f13187e.getDecorView();
            decorView.setSystemUiVisibility(i10 | decorView.getSystemUiVisibility());
        }

        public void i(int i10) {
            View decorView = this.f13187e.getDecorView();
            decorView.setSystemUiVisibility((~i10) & decorView.getSystemUiVisibility());
        }

        public a(WindowInsetsController windowInsetsController, b0 b0Var, H h10) {
            this.f13186d = new androidx.collection.t<>();
            this.f13184b = windowInsetsController;
            this.f13183a = b0Var;
            this.f13185c = h10;
        }
    }

    public b0(Window window, View view) {
        H h10 = new H(view);
        if (Build.VERSION.SDK_INT >= 35) {
            this.f13182a = new c(window, this, h10);
        } else {
            this.f13182a = new a(window, this, h10);
        }
    }
}
