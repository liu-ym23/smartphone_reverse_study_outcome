package n3;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.lang.invoke.VarHandle;
import java.util.Objects;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m1 {

    /* renamed from: b, reason: collision with root package name */
    public static final m1 f8736b;

    /* renamed from: a, reason: collision with root package name */
    public j1 f8737a;

    static {
        if (Build.VERSION.SDK_INT >= 34) {
            f8736b = h1.f8718s;
        } else {
            f8736b = f1.f8713r;
        }
    }

    public m1(m1 m1Var) {
        if (m1Var == null) {
            this.f8737a = new j1(this);
            return;
        }
        j1 j1Var = m1Var.f8737a;
        int i = Build.VERSION.SDK_INT;
        if (i >= 35 && (j1Var instanceof i1)) {
            this.f8737a = new i1(this, (i1) j1Var);
        } else if (i >= 34 && (j1Var instanceof h1)) {
            this.f8737a = new h1(this, (h1) j1Var);
        } else if (j1Var instanceof g1) {
            this.f8737a = new g1(this, (g1) j1Var);
        } else if (j1Var instanceof f1) {
            this.f8737a = new f1(this, (f1) j1Var);
        } else if (j1Var instanceof e1) {
            this.f8737a = new e1(this, (e1) j1Var);
        } else if (j1Var instanceof d1) {
            this.f8737a = new d1(this, (d1) j1Var);
        } else if (j1Var instanceof c1) {
            this.f8737a = new c1(this, (c1) j1Var);
        } else if (j1Var instanceof b1) {
            this.f8737a = new b1(this, (b1) j1Var);
        } else {
            this.f8737a = new j1(this);
        }
        j1Var.e(this);
    }

    public static f3.b e(f3.b bVar, int i, int i3, int i10, int i11) {
        int iMax = Math.max(0, bVar.f3900a - i);
        int iMax2 = Math.max(0, bVar.f3901b - i3);
        int iMax3 = Math.max(0, bVar.f3902c - i10);
        int iMax4 = Math.max(0, bVar.f3903d - i11);
        return (iMax == i && iMax2 == i3 && iMax3 == i10 && iMax4 == i11) ? bVar : f3.b.a(iMax, iMax2, iMax3, iMax4);
    }

    public static m1 h(View view, WindowInsets windowInsets) {
        windowInsets.getClass();
        m1 m1Var = new m1();
        int i = Build.VERSION.SDK_INT;
        if (i >= 35) {
            m1Var.f8737a = new i1(m1Var, windowInsets);
        } else if (i >= 34) {
            m1Var.f8737a = new h1(m1Var, windowInsets);
        } else {
            m1Var.f8737a = new g1(m1Var, windowInsets);
        }
        VarHandle.storeStoreFence();
        if (view != null && view.isAttachedToWindow()) {
            WeakHashMap weakHashMap = k0.f8724a;
            m1Var.f8737a.y(f0.a(view));
            View rootView = view.getRootView();
            j1 j1Var = m1Var.f8737a;
            j1Var.d(rootView);
            j1Var.p(rootView);
            j1Var.q();
            m1Var.f8737a.z(view.getWindowSystemUiVisibility());
        }
        return m1Var;
    }

    public final int a() {
        return this.f8737a.n().f3903d;
    }

    public final int b() {
        return this.f8737a.n().f3900a;
    }

    public final int c() {
        return this.f8737a.n().f3902c;
    }

    public final int d() {
        return this.f8737a.n().f3901b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof m1) {
            return Objects.equals(this.f8737a, ((m1) obj).f8737a);
        }
        return false;
    }

    public final m1 f(int i, int i3, int i10, int i11) {
        int i12 = Build.VERSION.SDK_INT;
        a1 z0Var = i12 >= 36 ? new z0(this) : i12 >= 35 ? new y0(this) : i12 >= 34 ? new x0(this) : new w0(this);
        z0Var.e(f3.b.a(i, i3, i10, i11));
        return z0Var.b();
    }

    public final WindowInsets g() {
        j1 j1Var = this.f8737a;
        if (j1Var instanceof b1) {
            return ((b1) j1Var).f8687c;
        }
        return null;
    }

    public final int hashCode() {
        j1 j1Var = this.f8737a;
        if (j1Var == null) {
            return 0;
        }
        return j1Var.hashCode();
    }
}
