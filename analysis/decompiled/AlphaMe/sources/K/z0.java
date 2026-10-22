package K;

import android.view.View;
import android.view.WindowInsets;
import java.util.Objects;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class z0 {

    /* renamed from: b, reason: collision with root package name */
    public static final z0 f1022b = w0.f1013f;

    /* renamed from: a, reason: collision with root package name */
    public final x0 f1023a;

    public z0(WindowInsets windowInsets) {
        this.f1023a = new w0(this, windowInsets);
    }

    public static z0 f(View view, WindowInsets windowInsets) {
        windowInsets.getClass();
        z0 z0Var = new z0(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            WeakHashMap weakHashMap = S.f939a;
            z0 z0VarA = K.a(view);
            x0 x0Var = z0Var.f1023a;
            x0Var.m(z0VarA);
            x0Var.d(view.getRootView());
        }
        return z0Var;
    }

    public final int a() {
        return this.f1023a.h().f360d;
    }

    public final int b() {
        return this.f1023a.h().f357a;
    }

    public final int c() {
        return this.f1023a.h().f359c;
    }

    public final int d() {
        return this.f1023a.h().f358b;
    }

    public final WindowInsets e() {
        x0 x0Var = this.f1023a;
        if (x0Var instanceof s0) {
            return ((s0) x0Var).f1005c;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z0)) {
            return false;
        }
        return Objects.equals(this.f1023a, ((z0) obj).f1023a);
    }

    public final int hashCode() {
        x0 x0Var = this.f1023a;
        if (x0Var == null) {
            return 0;
        }
        return x0Var.hashCode();
    }

    public z0() {
        this.f1023a = new x0(this);
    }
}
