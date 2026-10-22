package e0;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.Objects;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class x0 {

    /* renamed from: b, reason: collision with root package name */
    public static final x0 f2337b;

    /* renamed from: a, reason: collision with root package name */
    public final t0 f2338a;

    static {
        if (Build.VERSION.SDK_INT >= 34) {
            f2337b = q0.f2328j;
        } else {
            f2337b = o0.f2326i;
        }
    }

    public x0(WindowInsets windowInsets) {
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 35) {
            this.f2338a = new s0(this, windowInsets);
        } else if (i8 >= 34) {
            this.f2338a = new q0(this, windowInsets);
        } else {
            this.f2338a = new p0(this, windowInsets);
        }
    }

    public static x0 c(View view, WindowInsets windowInsets) {
        windowInsets.getClass();
        x0 x0Var = new x0(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            int[] iArr = a0.f2285a;
            x0 x0VarA = v.a(view);
            t0 t0Var = x0Var.f2338a;
            t0Var.r(x0VarA);
            View rootView = view.getRootView();
            t0Var.d(rootView);
            t0Var.k(rootView);
            t0Var.l();
            t0Var.s(view.getWindowSystemUiVisibility());
        }
        return x0Var;
    }

    public final int a() {
        return this.f2338a.j().f6233b;
    }

    public final WindowInsets b() {
        t0 t0Var = this.f2338a;
        if (t0Var instanceof k0) {
            return ((k0) t0Var).f2316c;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x0) {
            return Objects.equals(this.f2338a, ((x0) obj).f2338a);
        }
        return false;
    }

    public final int hashCode() {
        t0 t0Var = this.f2338a;
        if (t0Var == null) {
            return 0;
        }
        return t0Var.hashCode();
    }

    public x0() {
        this.f2338a = new t0(this);
    }
}
