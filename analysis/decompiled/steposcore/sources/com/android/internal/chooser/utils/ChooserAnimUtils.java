package com.android.internal.chooser.utils;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.IntentExt;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.transition.Slide;
import android.view.View;
import android.view.Window;
import android.view.animation.PathInterpolator;
import com.android.internal.dynamicanimation.animation.SpringAnimation;
import com.android.internal.dynamicanimation.animation.SpringForce;
import stepos.widget.CircleProgressBar;

/* loaded from: classes.dex */
public class ChooserAnimUtils {
    private static final TimeInterpolator ALPHA_INTERPOLATOR = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    private static final TimeInterpolator SLIDE_INTERPOLATOR = new PathInterpolator(0.26f, 1.0f, 0.48f, 1.0f);

    public static void startEnterAnimationSlideBottom(Window window) {
        Slide slide = new Slide();
        slide.setInterpolator(new PathInterpolator(0.26f, 1.0f, 0.48f, 1.0f));
        slide.setDuration(450L);
        slide.setSlideEdge(80);
        window.setEnterTransition(slide);
    }

    public static void startEnterAnimation(final Window window, View mNestedScrollingLayout, final ColorDrawable mDimBackground, float mDimAmount) {
        AnimatorSet animatorSet = new AnimatorSet();
        int height = 0;
        if (mNestedScrollingLayout != null) {
            height = mNestedScrollingLayout.getMeasuredHeight();
            mNestedScrollingLayout.setTranslationY(height);
        }
        ObjectAnimator translationY = ObjectAnimator.ofFloat(mNestedScrollingLayout, "translationY", height, 0.0f);
        translationY.setInterpolator(SLIDE_INTERPOLATOR);
        translationY.setDuration(300L);
        ValueAnimator alpha = ValueAnimator.ofFloat(mDimAmount, 0.1f);
        alpha.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.android.internal.chooser.utils.ChooserAnimUtils.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                ChooserAnimUtils.updateDimBackground(mDimBackground, ((Float) animation.getAnimatedValue()).floatValue());
            }
        });
        alpha.setInterpolator(ALPHA_INTERPOLATOR);
        alpha.setDuration(300L);
        animatorSet.playTogether(translationY, alpha);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.android.internal.chooser.utils.ChooserAnimUtils.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                window.setWindowAnimations(R.style.TextAppearance.Holo.Light.Widget.Switch);
            }
        });
        animatorSet.start();
    }

    public static void startExitAnimation(Window window, View mNestedScrollingLayout, final ColorDrawable mDimBackground, float mDimAmount, final Runnable mFinishTask) {
        window.setWindowAnimations(0);
        transparentOnlyNavigationBar(window);
        AnimatorSet animatorSet = new AnimatorSet();
        float measuredHeight = 0.0f;
        float translationYvalue = 0.0f;
        if (mNestedScrollingLayout != null) {
            measuredHeight = mNestedScrollingLayout.getMeasuredHeight();
            translationYvalue = mNestedScrollingLayout.getTranslationY();
        }
        ObjectAnimator translationY = ObjectAnimator.ofFloat(mNestedScrollingLayout, "translationY", translationYvalue, measuredHeight);
        translationY.setInterpolator(new PathInterpolator(0.23f, 0.03f, 0.55f, 0.21f));
        translationY.setDuration(300L);
        ValueAnimator alpha = ValueAnimator.ofFloat(mDimAmount, 0.0f);
        alpha.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.android.internal.chooser.utils.ChooserAnimUtils.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                ChooserAnimUtils.updateDimBackground(mDimBackground, ((Float) animation.getAnimatedValue()).floatValue());
            }
        });
        alpha.setInterpolator(ALPHA_INTERPOLATOR);
        alpha.setDuration(300L);
        animatorSet.playTogether(translationY, alpha);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.android.internal.chooser.utils.ChooserAnimUtils.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mFinishTask.run();
            }
        });
        animatorSet.start();
    }

    public static void startSpringExitAnimation(Window window, View mNestedScrollingLayout, final ColorDrawable mDimBackground, float mDimAmount, final Runnable mFinishTask) {
        window.setWindowAnimations(0);
        transparentOnlyNavigationBar(window);
        float measuredHeight = 0.0f;
        float translationYvalue = 0.0f;
        if (mNestedScrollingLayout != null) {
            measuredHeight = mNestedScrollingLayout.getMeasuredHeight();
            translationYvalue = mNestedScrollingLayout.getTranslationY();
        }
        SpringAnimation springAnimation = new SpringAnimation(mNestedScrollingLayout, SpringAnimation.TRANSLATION_Y);
        springAnimation.setSpring(new SpringForce().setDampingRatio(0.93f).setStiffness(400.0f));
        springAnimation.setStartValue(translationYvalue);
        springAnimation.getSpring().setFinalPosition(measuredHeight);
        springAnimation.start();
        ValueAnimator alpha = ValueAnimator.ofFloat(mDimAmount, 0.0f);
        alpha.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.android.internal.chooser.utils.ChooserAnimUtils.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                ChooserAnimUtils.updateDimBackground(mDimBackground, ((Float) animation.getAnimatedValue()).floatValue());
            }
        });
        alpha.setInterpolator(ALPHA_INTERPOLATOR);
        alpha.setDuration(300L);
        alpha.start();
        alpha.addListener(new AnimatorListenerAdapter() { // from class: com.android.internal.chooser.utils.ChooserAnimUtils.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mFinishTask.run();
            }
        });
    }

    public static ColorDrawable updateDimBackground(ColorDrawable mDimBackground, float mDimAmount) {
        mDimBackground.setColor(Color.argb(mDimAmount, 0.0f, 0.0f, 0.0f));
        return mDimBackground;
    }

    public static void transparentNavigationBar(Window window) {
        int vis;
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.clearFlags(2);
        window.getAttributes().windowAnimations = 0;
        int vis2 = window.getDecorView().getSystemUiVisibility() | 1024 | 512 | 256;
        boolean nightMode = (window.getContext().getResources().getConfiguration().uiMode & 48) == 32;
        if (nightMode) {
            vis = vis2 & (-17);
        } else {
            vis = vis2 | 16;
        }
        window.getDecorView().setSystemUiVisibility(vis);
        window.clearFlags(CircleProgressBar.RIM_COLOR_DEF);
        window.addFlags(IntentExt.STEPOS_FLAG_DISABLE_SNAPSHOT);
        window.setNavigationBarColor(0);
        window.setStatusBarColor(0);
        window.setStatusBarContrastEnforced(false);
        window.setNavigationBarContrastEnforced(false);
    }

    public static void transparentOnlyNavigationBar(Window window) {
        window.setNavigationBarContrastEnforced(false);
        window.setNavigationBarColor(0);
    }
}
