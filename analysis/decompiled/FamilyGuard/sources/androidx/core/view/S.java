package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class S {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<View> f9755a;

    class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ T f9756a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f9757b;

        a(T t5, View view) {
            this.f9756a = t5;
            this.f9757b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f9756a.c(this.f9757b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f9756a.d(this.f9757b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f9756a.e(this.f9757b);
        }
    }

    S(View view) {
        this.f9755a = new WeakReference<>(view);
    }

    private void k(View view, T t5) {
        if (t5 != null) {
            view.animate().setListener(new a(t5, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public S b(float f5) {
        View view = this.f9755a.get();
        if (view != null) {
            view.animate().alpha(f5);
        }
        return this;
    }

    public void c() {
        View view = this.f9755a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long d() {
        View view = this.f9755a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public S e(float f5) {
        View view = this.f9755a.get();
        if (view != null) {
            view.animate().rotation(f5);
        }
        return this;
    }

    public S f(float f5) {
        View view = this.f9755a.get();
        if (view != null) {
            view.animate().scaleX(f5);
        }
        return this;
    }

    public S g(float f5) {
        View view = this.f9755a.get();
        if (view != null) {
            view.animate().scaleY(f5);
        }
        return this;
    }

    public S h(long j5) {
        View view = this.f9755a.get();
        if (view != null) {
            view.animate().setDuration(j5);
        }
        return this;
    }

    public S i(Interpolator interpolator) {
        View view = this.f9755a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public S j(T t5) {
        View view = this.f9755a.get();
        if (view != null) {
            k(view, t5);
        }
        return this;
    }

    public S l(long j5) {
        View view = this.f9755a.get();
        if (view != null) {
            view.animate().setStartDelay(j5);
        }
        return this;
    }

    public S m(final V v5) {
        final View view = this.f9755a.get();
        if (view != null) {
            view.animate().setUpdateListener(v5 != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.Q
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    v5.a(view);
                }
            } : null);
        }
        return this;
    }

    public void n() {
        View view = this.f9755a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public S o(float f5) {
        View view = this.f9755a.get();
        if (view != null) {
            view.animate().translationX(f5);
        }
        return this;
    }

    public S p(float f5) {
        View view = this.f9755a.get();
        if (view != null) {
            view.animate().translationY(f5);
        }
        return this;
    }
}
