package androidx.core.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes17.dex */
public final class ViewPropertyAnimatorCompat {
    private final WeakReference<View> mView;

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static ViewPropertyAnimator translationZ(ViewPropertyAnimator r100, float r101) {
            return r100.translationZ(r101);
        }

        public static ViewPropertyAnimator translationZBy(ViewPropertyAnimator r100, float r101) {
            return r100.translationZBy(r101);
        }

        public static ViewPropertyAnimator z(ViewPropertyAnimator r100, float r101) {
            return r100.z(r101);
        }

        public static ViewPropertyAnimator zBy(ViewPropertyAnimator r100, float r101) {
            return r100.zBy(r101);
        }
    }

    public static /* synthetic */ void a(ViewPropertyAnimatorUpdateListener r100, View r101, ValueAnimator r102) {
        lambda$setUpdateListener$0(r100, r101, r102);
    }

    public void cancel() {
        View r100 = this.mView.get();
        if (r100 == null) goto L6;
        r100.animate().cancel();
        return;
    }

    public long getDuration() {
        View r100 = this.mView.get();
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.animate().getDuration();
    }

    public Interpolator getInterpolator() {
        View r100 = this.mView.get();
        if (r100 != null) goto L5;
        return null;
    L5:
        return (Interpolator) r100.animate().getInterpolator();
    }

    public long getStartDelay() {
        View r100 = this.mView.get();
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.animate().getStartDelay();
    }

    public void start() {
        View r100 = this.mView.get();
        if (r100 == null) goto L6;
        r100.animate().start();
        return;
    }

    public ViewPropertyAnimatorCompat withLayer() {
        View r100 = this.mView.get();
        if (r100 == null) goto L5;
        r100.animate().withLayer();
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat(View r100) {
        this.mView = new WeakReference(r100);
    }

    public ViewPropertyAnimatorCompat alpha(float r100) {
        View r101 = this.mView.get();
        if (r101 == null) goto L5;
        r101.animate().alpha(r100);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat alphaBy(float r100) {
        View r101 = this.mView.get();
        if (r101 == null) goto L5;
        r101.animate().alphaBy(r100);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat rotation(float r100) {
        View r101 = this.mView.get();
        if (r101 == null) goto L5;
        r101.animate().rotation(r100);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat rotationBy(float r100) {
        View r101 = this.mView.get();
        if (r101 == null) goto L5;
        r101.animate().rotationBy(r100);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat rotationX(float r100) {
        View r101 = this.mView.get();
        if (r101 == null) goto L5;
        r101.animate().rotationX(r100);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat rotationXBy(float r100) {
        View r101 = this.mView.get();
        if (r101 == null) goto L5;
        r101.animate().rotationXBy(r100);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat rotationY(float r100) {
        View r101 = this.mView.get();
        if (r101 == null) goto L5;
        r101.animate().rotationY(r100);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat rotationYBy(float r100) {
        View r101 = this.mView.get();
        if (r101 == null) goto L5;
        r101.animate().rotationYBy(r100);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat scaleX(float r100) {
        View r101 = this.mView.get();
        if (r101 == null) goto L5;
        r101.animate().scaleX(r100);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat scaleXBy(float r100) {
        View r101 = this.mView.get();
        if (r101 == null) goto L5;
        r101.animate().scaleXBy(r100);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat scaleY(float r100) {
        View r101 = this.mView.get();
        if (r101 == null) goto L5;
        r101.animate().scaleY(r100);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat scaleYBy(float r100) {
        View r101 = this.mView.get();
        if (r101 == null) goto L5;
        r101.animate().scaleYBy(r100);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat setDuration(long r100) {
        View r101 = this.mView.get();
        if (r101 == null) goto L5;
        r101.animate().setDuration(r100);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat setInterpolator(Interpolator r100) {
        View r101 = this.mView.get();
        if (r101 == null) goto L5;
        r101.animate().setInterpolator(r100);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener r100) {
        View r101 = this.mView.get();
        if (r101 == null) goto L5;
        setListenerInternal(r101, r100);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat setStartDelay(long r100) {
        View r101 = this.mView.get();
        if (r101 == null) goto L5;
        r101.animate().setStartDelay(r100);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat setUpdateListener(final ViewPropertyAnimatorUpdateListener r100) {
        final View r101 = this.mView.get();
        if (r101 == null) goto L8;
        if (r100 == null) goto L6;
        ValueAnimator.AnimatorUpdateListener r102 = new o(r100, r101);
    L7:
        r101.animate().setUpdateListener(r102);
        goto L8
    L6:
        r102 = null;
    L8:
        return this;
    }

    public ViewPropertyAnimatorCompat translationX(float r100) {
        View r101 = this.mView.get();
        if (r101 == null) goto L5;
        r101.animate().translationX(r100);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat translationXBy(float r100) {
        View r101 = this.mView.get();
        if (r101 == null) goto L5;
        r101.animate().translationXBy(r100);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat translationY(float r100) {
        View r101 = this.mView.get();
        if (r101 == null) goto L5;
        r101.animate().translationY(r100);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat translationYBy(float r100) {
        View r101 = this.mView.get();
        if (r101 == null) goto L5;
        r101.animate().translationYBy(r100);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat translationZ(float r100) {
        View r101 = this.mView.get();
        if (r101 == null) goto L5;
        Api21Impl.translationZ(r101.animate(), r100);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat translationZBy(float r100) {
        View r101 = this.mView.get();
        if (r101 == null) goto L5;
        Api21Impl.translationZBy(r101.animate(), r100);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat withEndAction(Runnable r100) {
        View r101 = this.mView.get();
        if (r101 == null) goto L5;
        r101.animate().withEndAction(r100);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat withStartAction(Runnable r100) {
        View r101 = this.mView.get();
        if (r101 == null) goto L5;
        r101.animate().withStartAction(r100);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat x(float r100) {
        View r101 = this.mView.get();
        if (r101 == null) goto L5;
        r101.animate().x(r100);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat xBy(float r100) {
        View r101 = this.mView.get();
        if (r101 == null) goto L5;
        r101.animate().xBy(r100);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat y(float r100) {
        View r101 = this.mView.get();
        if (r101 == null) goto L5;
        r101.animate().y(r100);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat yBy(float r100) {
        View r101 = this.mView.get();
        if (r101 == null) goto L5;
        r101.animate().yBy(r100);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat z(float r100) {
        View r101 = this.mView.get();
        if (r101 == null) goto L5;
        Api21Impl.z(r101.animate(), r100);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat zBy(float r100) {
        View r101 = this.mView.get();
        if (r101 == null) goto L5;
        Api21Impl.zBy(r101.animate(), r100);
    L5:
        return this;
    }

    private void setListenerInternal(final View r100, final ViewPropertyAnimatorListener r101) {
        if (r101 == null) goto L4;
        r100.animate().setListener(new AnonymousClass1(this, r101, r100));
        return;
    L4:
        r100.animate().setListener(null);
    }

    private static /* synthetic */ void lambda$setUpdateListener$0(ViewPropertyAnimatorUpdateListener r100, View r101, ValueAnimator r102) {
        r100.onAnimationUpdate(r101);
    }
}
