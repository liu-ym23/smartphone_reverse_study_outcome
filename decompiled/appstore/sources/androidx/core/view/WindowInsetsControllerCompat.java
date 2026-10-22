package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.collection.SimpleArrayMap;

/* JADX INFO: loaded from: classes.dex */
public final class WindowInsetsControllerCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f2728a;

    public interface OnControllableInsetsChangedListener {
        void onControllableInsetsChanged(@NonNull WindowInsetsControllerCompat r10, int r11);
    }

    public static class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WindowInsetsControllerCompat f2729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WindowInsetsController f2730b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SimpleArrayMap f2731c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Window f2732d;

        public a(Window r10, WindowInsetsControllerCompat r11) {
            this(r10.getInsetsController(), r11);
            this.f2732d = r10;
        }

        public static /* synthetic */ void f(a r10, OnControllableInsetsChangedListener r11, WindowInsetsController r12, int r13) {
            r10.g(r11, r12, r13);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.b
        public void a(int r10) {
            this.f2730b.hide(r10);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.b
        public void addOnControllableInsetsChangedListener(@NonNull final OnControllableInsetsChangedListener r10) {
            if (this.f2731c.containsKey(r10) == false) goto L5;
            return;
        L5:
            WindowInsetsController.OnControllableInsetsChangedListener r11 = new v(this, r10);
            this.f2731c.put(r10, r11);
            this.f2730b.addOnControllableInsetsChangedListener(r11);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.b
        public void b(boolean r10) {
            if (r10 == false) goto L9;
            if (this.f2732d == null) goto L7;
            h(16);
        L7:
            this.f2730b.setSystemBarsAppearance(16, 16);
            return;
        L9:
            if (this.f2732d == null) goto L11;
            i(16);
        L11:
            this.f2730b.setSystemBarsAppearance(0, 16);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.b
        public void c(boolean r10) {
            if (r10 == false) goto L9;
            if (this.f2732d == null) goto L7;
            h(8192);
        L7:
            this.f2730b.setSystemBarsAppearance(8, 8);
            return;
        L9:
            if (this.f2732d == null) goto L11;
            i(8192);
        L11:
            this.f2730b.setSystemBarsAppearance(0, 8);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.b
        public void d(int r10) {
            this.f2730b.setSystemBarsBehavior(r10);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.b
        public void e(int r10) {
            Window r11 = this.f2732d;
            if (r11 != null) goto L5;
        L9:
            this.f2730b.show(r10);
            return;
        L5:
            if ((r10 & 8) == 0) goto L9;
            if (Build.VERSION.SDK_INT >= 32) goto L9;
            ((InputMethodManager) r11.getContext().getSystemService("input_method")).isActive();
            goto L9
        }

        public final /* synthetic */ void g(OnControllableInsetsChangedListener r10, WindowInsetsController r11, int r12) {
            if (this.f2730b != r11) goto L6;
            r10.onControllableInsetsChanged(this.f2729a, r12);
            return;
        }

        public void h(int r10) {
            View r11 = this.f2732d.getDecorView();
            r11.setSystemUiVisibility(r10 | r11.getSystemUiVisibility());
        }

        public void i(int r10) {
            View r11 = this.f2732d.getDecorView();
            int r12 = r11.getSystemUiVisibility();
            r11.setSystemUiVisibility((~r10) & r12);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.b
        public void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener r10) {
            WindowInsetsController.OnControllableInsetsChangedListener r11 = (WindowInsetsController.OnControllableInsetsChangedListener) this.f2731c.remove(r10);
            if (r11 == null) goto L6;
            this.f2730b.removeOnControllableInsetsChangedListener(r11);
            return;
        }

        public a(WindowInsetsController r10, WindowInsetsControllerCompat r11) {
            this.f2731c = new SimpleArrayMap();
            this.f2730b = r10;
            this.f2729a = r11;
        }
    }

    public static class b {
        public b() {
        }

        public abstract void a(int r10);

        public void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener r10) {
        }

        public abstract void b(boolean r10);

        public abstract void c(boolean r10);

        public abstract void d(int r10);

        public abstract void e(int r10);

        public void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener r10) {
        }
    }

    public WindowInsetsControllerCompat(Window r10, View r11) {
        this.f2728a = new a(r10, this);
    }

    public void a(int r10) {
        this.f2728a.a(r10);
    }

    public void addOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener r10) {
        this.f2728a.addOnControllableInsetsChangedListener(r10);
    }

    public void b(boolean r10) {
        this.f2728a.b(r10);
    }

    public void c(boolean r10) {
        this.f2728a.c(r10);
    }

    public void d(int r10) {
        this.f2728a.d(r10);
    }

    public void e(int r10) {
        this.f2728a.e(r10);
    }

    public void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener r10) {
        this.f2728a.removeOnControllableInsetsChangedListener(r10);
    }
}
