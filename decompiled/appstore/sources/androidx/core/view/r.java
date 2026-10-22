package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import androidx.annotation.DoNotInline;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f2787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Runnable f2788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Runnable f2789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2790d;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimatorListener f2791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f2792b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ r f2793c;

        public a(r r10, ViewPropertyAnimatorListener r11, View r12) {
            this.f2793c = r10;
            this.f2791a = r11;
            this.f2792b = r12;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            this.f2791a.onAnimationCancel(this.f2792b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            this.f2791a.onAnimationEnd(this.f2792b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            this.f2791a.onAnimationStart(this.f2792b);
        }
    }

    public static class b {
        @DoNotInline
        public static ViewPropertyAnimator a(ViewPropertyAnimator r10, ValueAnimator.AnimatorUpdateListener r11) {
            return r10.setUpdateListener(r11);
        }
    }

    public r(View r10) {
        this.f2788b = null;
        this.f2789c = null;
        this.f2790d = -1;
        this.f2787a = new WeakReference(r10);
    }

    public static /* synthetic */ void a(ViewPropertyAnimatorUpdateListener r10, View r11, ValueAnimator r12) {
        e(r10, r11, r12);
    }

    public static /* synthetic */ void e(ViewPropertyAnimatorUpdateListener r10, View r11, ValueAnimator r12) {
        r10.onAnimationUpdate(r11);
    }

    public r b(float r10) {
        View r11 = (View) this.f2787a.get();
        if (r11 == null) goto L5;
        r11.animate().alpha(r10);
    L5:
        return this;
    }

    public void c() {
        View r10 = (View) this.f2787a.get();
        if (r10 == null) goto L6;
        r10.animate().cancel();
        return;
    }

    public long d() {
        View r10 = (View) this.f2787a.get();
        if (r10 != null) goto L5;
        return 0;
    L5:
        return r10.animate().getDuration();
    }

    public r f(long r10) {
        View r11 = (View) this.f2787a.get();
        if (r11 == null) goto L5;
        r11.animate().setDuration(r10);
    L5:
        return this;
    }

    public r g(Interpolator r10) {
        View r11 = (View) this.f2787a.get();
        if (r11 == null) goto L5;
        r11.animate().setInterpolator(r10);
    L5:
        return this;
    }

    public r h(ViewPropertyAnimatorListener r10) {
        View r11 = (View) this.f2787a.get();
        if (r11 == null) goto L5;
        i(r11, r10);
    L5:
        return this;
    }

    public final void i(View r10, ViewPropertyAnimatorListener r11) {
        if (r11 == null) goto L4;
        r10.animate().setListener(new a(this, r11, r10));
        return;
    L4:
        r10.animate().setListener(null);
    }

    public r j(long r10) {
        View r11 = (View) this.f2787a.get();
        if (r11 == null) goto L5;
        r11.animate().setStartDelay(r10);
    L5:
        return this;
    }

    public r k(final ViewPropertyAnimatorUpdateListener r10) {
        final View r11 = (View) this.f2787a.get();
        if (r11 == null) goto L8;
        if (r10 == null) goto L6;
        ValueAnimator.AnimatorUpdateListener r12 = new q(r10, r11);
    L7:
        b.a(r11.animate(), r12);
        goto L8
    L6:
        r12 = null;
    L8:
        return this;
    }

    public void l() {
        View r10 = (View) this.f2787a.get();
        if (r10 == null) goto L6;
        r10.animate().start();
        return;
    }

    public r m(float r10) {
        View r11 = (View) this.f2787a.get();
        if (r11 == null) goto L5;
        r11.animate().translationY(r10);
    L5:
        return this;
    }
}
