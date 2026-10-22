package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class U {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference<View> f13139a;

    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ V f13140a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f13141b;

        public a(V v10, View view) {
            this.f13140a = v10;
            this.f13141b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f13140a.c(this.f13141b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f13140a.d(this.f13141b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f13140a.e(this.f13141b);
        }
    }

    public U(View view) {
        this.f13139a = new WeakReference<>(view);
    }

    public U b(float f10) {
        View view = this.f13139a.get();
        if (view != null) {
            view.animate().alpha(f10);
        }
        return this;
    }

    public void c() {
        View view = this.f13139a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long d() {
        View view = this.f13139a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public U e(float f10) {
        View view = this.f13139a.get();
        if (view != null) {
            view.animate().rotation(f10);
        }
        return this;
    }

    public U f(long j10) {
        View view = this.f13139a.get();
        if (view != null) {
            view.animate().setDuration(j10);
        }
        return this;
    }

    public U g(Interpolator interpolator) {
        View view = this.f13139a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public U h(V v10) {
        View view = this.f13139a.get();
        if (view != null) {
            i(view, v10);
        }
        return this;
    }

    public final void i(View view, V v10) {
        if (v10 != null) {
            view.animate().setListener(new a(v10, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public U j(long j10) {
        View view = this.f13139a.get();
        if (view != null) {
            view.animate().setStartDelay(j10);
        }
        return this;
    }

    public U k(final X x10) {
        final View view = this.f13139a.get();
        if (view != null) {
            view.animate().setUpdateListener(x10 != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.T
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    x10.a(view);
                }
            } : null);
        }
        return this;
    }

    public void l() {
        View view = this.f13139a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public U m(float f10) {
        View view = this.f13139a.get();
        if (view != null) {
            view.animate().translationY(f10);
        }
        return this;
    }
}
