package o2;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.Objects;

/* loaded from: classes.dex */
public final class j0 {

    /* renamed from: b, reason: collision with root package name */
    public static final j0 f7235b;

    /* renamed from: a, reason: collision with root package name */
    public final g0 f7236a;

    static {
        if (Build.VERSION.SDK_INT >= 34) {
            f7235b = e0.f7229i;
        } else {
            f7235b = c0.f7224h;
        }
    }

    public j0(WindowInsets windowInsets) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 35) {
            this.f7236a = new f0(this, windowInsets);
            return;
        }
        if (i2 >= 34) {
            this.f7236a = new e0(this, windowInsets);
        } else if (i2 >= 31) {
            this.f7236a = new d0(this, windowInsets);
        } else {
            this.f7236a = new c0(this, windowInsets);
        }
    }

    public static j0 a(View view, WindowInsets windowInsets) {
        windowInsets.getClass();
        j0 j0Var = new j0(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            int i2 = m.f7237a;
            j0 j0VarA = j.a(view);
            g0 g0Var = j0Var.f7236a;
            g0Var.s(j0VarA);
            View rootView = view.getRootView();
            g0Var.d(rootView);
            g0Var.l(rootView);
            g0Var.m();
            g0Var.t(view.getWindowSystemUiVisibility());
        }
        return j0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof j0) {
            return Objects.equals(this.f7236a, ((j0) obj).f7236a);
        }
        return false;
    }

    public final int hashCode() {
        g0 g0Var = this.f7236a;
        if (g0Var == null) {
            return 0;
        }
        return g0Var.hashCode();
    }

    public j0() {
        this.f7236a = new g0(this);
    }
}
