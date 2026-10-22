package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes17.dex */
public class Fade extends Visibility {
    public static final int IN = 1;
    private static final String LOG_TAG = "Fade";
    public static final int OUT = 2;
    private static final String PROPNAME_TRANSITION_ALPHA = "android:fade:transitionAlpha";

    public static class FadeAnimatorListener extends AnimatorListenerAdapter {
        private boolean mLayerTypeChanged;
        private final View mView;

        public FadeAnimatorListener(View r100) {
            this.mLayerTypeChanged = false;
            this.mView = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r100) {
            ViewUtils.setTransitionAlpha(this.mView, 1.0f);
            if (this.mLayerTypeChanged == false) goto L6;
            this.mView.setLayerType(0, null);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r100) {
            if (ViewCompat.hasOverlappingRendering(this.mView) == true) goto L5;
            return;
        L5:
            if (this.mView.getLayerType() != 0) goto L9;
            this.mLayerTypeChanged = true;
            this.mView.setLayerType(2, null);
            return;
        }
    }

    public Fade() {
    }

    public Fade(int r100) {
        setMode(r100);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(TransitionValues r100) {
        super.captureStartValues(r100);
        r100.values.put(PROPNAME_TRANSITION_ALPHA, Float.valueOf(ViewUtils.getTransitionAlpha(r100.view)));
    }

    public Fade(Context r100, AttributeSet r101) {
        super(r100, r101);
        TypedArray r102 = r100.obtainStyledAttributes(r101, Styleable.FADE);
        setMode(TypedArrayUtils.getNamedInt(r102, (XmlResourceParser) r101, "fadingMode", 0, getMode()));
        r102.recycle();
    }

    private static float getStartAlpha(TransitionValues r100, float r101) {
        if (r100 == null) goto L7;
        Float r102 = (Float) r100.values.get(PROPNAME_TRANSITION_ALPHA);
        if (r102 != null) goto L6;
        return r101;
    L6:
        return r102.floatValue();
    L7:
        return r101;
    }

    private Animator createAnimation(final View r100, float r101, float r102) {
        if (r101 != r102) goto L6;
        return null;
    L6:
        ViewUtils.setTransitionAlpha(r100, r101);
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r100, ViewUtils.TRANSITION_ALPHA, new float[]{r102});
        r103.addListener(new FadeAnimatorListener(r100));
        addListener(new AnonymousClass1(this, r100));
        return r103;
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup r100, View r101, TransitionValues r102, TransitionValues r103) {
        float r104 = 0.0f;
        float r105 = getStartAlpha(r102, 0.0f);
        if (r105 == 1.0f) goto L7;
        r104 = r105;
    L7:
        return createAnimation(r101, r104, 1.0f);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup r100, View r101, TransitionValues r102, TransitionValues r103) {
        ViewUtils.saveNonTransitionAlpha(r101);
        return createAnimation(r101, getStartAlpha(r102, 1.0f), 0.0f);
    }
}
