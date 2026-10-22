package n3;

import android.view.View;
import android.view.animation.Interpolator;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o0 {

    /* renamed from: a, reason: collision with root package name */
    public WeakReference f8739a;

    public final void a(float f5) {
        View view = (View) this.f8739a.get();
        if (view != null) {
            view.animate().alpha(f5);
        }
    }

    public final void b() {
        View view = (View) this.f8739a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void c(long j10) {
        View view = (View) this.f8739a.get();
        if (view != null) {
            view.animate().setDuration(j10);
        }
    }

    public final void d(Interpolator interpolator) {
        View view = (View) this.f8739a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
    }

    public final void e(p0 p0Var) {
        View view = (View) this.f8739a.get();
        if (view != null) {
            if (p0Var != null) {
                view.animate().setListener(new bb.d(p0Var, view));
            } else {
                view.animate().setListener(null);
            }
        }
    }

    public final void f(q0 q0Var) {
        bb.b bVar;
        View view = (View) this.f8739a.get();
        if (view != null) {
            if (q0Var != null) {
                bVar = new bb.b(1);
                bVar.f2049b = q0Var;
                VarHandle.storeStoreFence();
            } else {
                bVar = null;
            }
            view.animate().setUpdateListener(bVar);
        }
    }

    public final void g() {
        View view = (View) this.f8739a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public final void h(float f5) {
        View view = (View) this.f8739a.get();
        if (view != null) {
            view.animate().translationY(f5);
        }
    }
}
