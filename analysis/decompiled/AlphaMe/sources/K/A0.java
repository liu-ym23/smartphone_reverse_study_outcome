package K;

import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import d.C0527a;

/* loaded from: classes.dex */
public final class A0 extends y1.f {

    /* renamed from: c, reason: collision with root package name */
    public final WindowInsetsController f921c;

    /* renamed from: d, reason: collision with root package name */
    public final C0527a f922d;

    /* renamed from: e, reason: collision with root package name */
    public Window f923e;

    public A0(WindowInsetsController windowInsetsController, C0527a c0527a) {
        this.f921c = windowInsetsController;
        this.f922d = c0527a;
    }

    public final void r(boolean z4) {
        Window window = this.f923e;
        WindowInsetsController windowInsetsController = this.f921c;
        if (z4) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
            }
            windowInsetsController.setSystemBarsAppearance(16, 16);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-17));
        }
        windowInsetsController.setSystemBarsAppearance(0, 16);
    }

    public final void s(boolean z4) {
        Window window = this.f923e;
        WindowInsetsController windowInsetsController = this.f921c;
        if (z4) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
            }
            windowInsetsController.setSystemBarsAppearance(8, 8);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-8193));
        }
        windowInsetsController.setSystemBarsAppearance(0, 8);
    }

    public final void t() {
        ((y1.f) this.f922d.f12410b).p();
        this.f921c.show(0);
    }
}
