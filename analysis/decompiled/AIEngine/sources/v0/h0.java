package v0;

import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h0 {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference<View> f13288a;

    public h0(View view) {
        this.f13288a = new WeakReference<>(view);
    }

    public final void a(float f8) {
        View view = this.f13288a.get();
        if (view != null) {
            view.animate().alpha(f8);
        }
    }

    public final void b() {
        View view = this.f13288a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void c(long j10) {
        View view = this.f13288a.get();
        if (view != null) {
            view.animate().setDuration(j10);
        }
    }

    public final void d(Interpolator interpolator) {
        View view = this.f13288a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
    }

    public final void e(i0 i0Var) {
        View view = this.f13288a.get();
        if (view != null) {
            if (i0Var != null) {
                view.animate().setListener(new g0(i0Var, view));
            } else {
                view.animate().setListener(null);
            }
        }
    }

    public final void f(j0 j0Var) {
        View view = this.f13288a.get();
        if (view != null) {
            view.animate().setUpdateListener(j0Var != null ? new com.google.android.material.textfield.b(j0Var, view) : null);
        }
    }

    public final void g() {
        View view = this.f13288a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public final void h(float f8) {
        View view = this.f13288a.get();
        if (view != null) {
            view.animate().translationY(f8);
        }
    }
}
