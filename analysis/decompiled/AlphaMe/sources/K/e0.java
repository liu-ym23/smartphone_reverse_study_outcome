package K;

import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f959a;

    public e0(View view) {
        this.f959a = new WeakReference(view);
    }

    public final void a(float f4) {
        View view = (View) this.f959a.get();
        if (view != null) {
            view.animate().alpha(f4);
        }
    }

    public final void b() {
        View view = (View) this.f959a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void c(long j4) {
        View view = (View) this.f959a.get();
        if (view != null) {
            view.animate().setDuration(j4);
        }
    }

    public final void d(Interpolator interpolator) {
        View view = (View) this.f959a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
    }

    public final void e(f0 f0Var) {
        View view = (View) this.f959a.get();
        if (view != null) {
            if (f0Var != null) {
                view.animate().setListener(new d0(0, this, f0Var, view));
            } else {
                view.animate().setListener(null);
            }
        }
    }

    public final void f(g0 g0Var) {
        View view = (View) this.f959a.get();
        if (view != null) {
            view.animate().setUpdateListener(g0Var != null ? new c0(0, g0Var, view) : null);
        }
    }

    public final void g() {
        View view = (View) this.f959a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public final void h(float f4) {
        View view = (View) this.f959a.get();
        if (view != null) {
            view.animate().translationY(f4);
        }
    }
}
