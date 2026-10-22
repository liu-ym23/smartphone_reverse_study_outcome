package com.stepos.launcher.assistant.slidepanel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.util.Log;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import p9.InterfaceC5074l;

/* loaded from: classes.dex */
public final class MinusOneOverlayMeshMaskController {
    private static final float BUTTON_BOTTOM_OFFSET_DP = 216.0f;
    private static final float DESIGN_HEIGHT = 2400.0f;
    private static final float DESIGN_WIDTH = 1080.0f;
    private static final float END_HEIGHT = 2585.0f;
    private static final float END_WIDTH = 1354.0f;
    private static final long FADE_IN_1_DELAY_MS = 0;
    private static final long FADE_IN_1_DURATION_MS = 100;
    private static final long FADE_IN_2_DELAY_MS = 100;
    private static final long FADE_IN_2_DURATION_MS = 150;
    private static final long FADE_OUT_DELAY_MS = 250;
    private static final long FADE_OUT_DURATION_MS = 200;
    private static final float START_HEIGHT = 116.0f;
    private static final float START_WIDTH = 301.0f;
    private static final String TAG = "MinusOneOverlayMesh";
    private static final long TRANSFORM_DELAY_MS = 0;
    private static final long TRANSFORM_DURATION_MS = 450;
    private static AnimatorSet sAnimator;
    private static s7.o sHost;
    private static s7.k sInstance;
    private static FrameLayout sMaskView;
    private static final PathInterpolator OUTGOING = new PathInterpolator(0.3f, 0.0f, 1.0f, 1.0f);
    private static final PathInterpolator FADE_IN_1 = new PathInterpolator(0.18f, 0.18f, 0.56f, 0.68f);
    private static final PathInterpolator FADE_IN_2 = new PathInterpolator(0.38f, 0.58f, 0.84f, 1.0f);
    private static final PathInterpolator FADE_OUT = new PathInterpolator(0.17f, 0.0f, 0.83f, 1.0f);

    public static final class PointF {

        /* renamed from: x, reason: collision with root package name */
        final float f30129x;

        /* renamed from: y, reason: collision with root package name */
        final float f30130y;

        public PointF(float f10, float f11) {
            this.f30129x = f10;
            this.f30130y = f11;
        }
    }

    private MinusOneOverlayMeshMaskController() {
    }

    private static void applyFrame(View view, float f10, float f11, float f12, float f13) {
        int iMax = Math.max(1, (int) f12);
        int iMax2 = Math.max(1, (int) f13);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams.width != iMax || layoutParams.height != iMax2) {
            layoutParams.width = iMax;
            layoutParams.height = iMax2;
            view.setLayoutParams(layoutParams);
        }
        view.setTranslationX(f10 - (iMax / 2.0f));
        view.setTranslationY(f11 - (iMax2 / 2.0f));
    }

    public static /* synthetic */ void b(FrameLayout frameLayout, PointF pointF, PointF pointF2, float f10, float f11, float f12, float f13, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        applyFrame(frameLayout, lerp(pointF.f30129x, pointF2.f30129x, fFloatValue), lerp(pointF.f30130y, pointF2.f30130y, fFloatValue), lerp(f10, f11, fFloatValue), lerp(f12, f13, fFloatValue));
    }

    private static AnimatorSet buildCloseAnimator(ViewGroup viewGroup, final FrameLayout frameLayout) {
        float width = viewGroup.getWidth() / DESIGN_WIDTH;
        float height = viewGroup.getHeight() / DESIGN_HEIGHT;
        final float f10 = width * START_WIDTH;
        final float f11 = height * START_HEIGHT;
        final float f12 = width * END_WIDTH;
        final float f13 = height * END_HEIGHT;
        final PointF pointF = new PointF(viewGroup.getWidth() / 2.0f, viewGroup.getHeight() / 2.0f);
        final PointF pointF2 = new PointF(viewGroup.getWidth() / 2.0f, viewGroup.getHeight() - (viewGroup.getResources().getDisplayMetrics().density * BUTTON_BOTTOM_OFFSET_DP));
        applyFrame(frameLayout, pointF.f30129x, pointF.f30130y, f12, f13);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setStartDelay(0L);
        valueAnimatorOfFloat.setDuration(TRANSFORM_DURATION_MS);
        valueAnimatorOfFloat.setInterpolator(OUTGOING);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.launcher.assistant.slidepanel.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                MinusOneOverlayMeshMaskController.b(frameLayout, pointF, pointF2, f12, f10, f13, f11, valueAnimator);
            }
        });
        Property property = View.ALPHA;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(frameLayout, (Property<FrameLayout, Float>) property, 0.0f, 0.3f);
        objectAnimatorOfFloat.setStartDelay(0L);
        objectAnimatorOfFloat.setDuration(100L);
        objectAnimatorOfFloat.setInterpolator(FADE_IN_1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(frameLayout, (Property<FrameLayout, Float>) property, 0.3f, 0.6f);
        objectAnimatorOfFloat2.setStartDelay(100L);
        objectAnimatorOfFloat2.setDuration(150L);
        objectAnimatorOfFloat2.setInterpolator(FADE_IN_2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(frameLayout, (Property<FrameLayout, Float>) property, 0.6f, 0.0f);
        objectAnimatorOfFloat3.setStartDelay(250L);
        objectAnimatorOfFloat3.setDuration(200L);
        objectAnimatorOfFloat3.setInterpolator(FADE_OUT);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorOfFloat, objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.stepos.launcher.assistant.slidepanel.MinusOneOverlayMeshMaskController.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (MinusOneOverlayMeshMaskController.sAnimator == animator) {
                    MinusOneOverlayMeshMaskController.sAnimator = null;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (MinusOneOverlayMeshMaskController.sAnimator == animator) {
                    MinusOneOverlayMeshMaskController.sAnimator = null;
                }
                MinusOneOverlayMeshMaskController.cleanup();
            }
        });
        return animatorSet;
    }

    public static void cancel() {
        AnimatorSet animatorSet = sAnimator;
        if (animatorSet != null) {
            animatorSet.cancel();
            sAnimator = null;
        }
        cleanup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cleanup() {
        release(sInstance);
        sInstance = null;
        release(sHost);
        sHost = null;
        FrameLayout frameLayout = sMaskView;
        if (frameLayout != null) {
            ViewParent parent = frameLayout.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(sMaskView);
            }
        }
        sMaskView = null;
    }

    private static s7.o createMotionHost(View view) {
        return t7.j.c(s7.o.INSTANCE, view);
    }

    private static float lerp(float f10, float f11, float f12) {
        return f10 + ((f11 - f10) * f12);
    }

    private static s7.k playMesh(s7.o oVar) {
        return t7.j.f(t7.j.e(oVar), t7.c.f42010a.a(), new InterfaceC5074l() { // from class: com.stepos.launcher.assistant.slidepanel.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Y8.t.f7040a;
            }
        });
    }

    private static void release(s7.k kVar) {
        if (kVar == null) {
            return;
        }
        try {
            kVar.release();
        } catch (RuntimeException e10) {
            Log.w(TAG, "Unable to release mesh object", e10);
        }
    }

    private static void setUniform(s7.k kVar, String str, float f10) {
        kVar.g(str, f10);
    }

    public static void startClose(View view) {
        if (!(view instanceof ViewGroup)) {
            Log.w(TAG, "Skip overlay mesh: decorView is not a ViewGroup");
            return;
        }
        final ViewGroup viewGroup = (ViewGroup) view;
        if (!viewGroup.isLaidOut() || viewGroup.getWidth() <= 0 || viewGroup.getHeight() <= 0) {
            viewGroup.post(new Runnable() { // from class: com.stepos.launcher.assistant.slidepanel.a
                @Override // java.lang.Runnable
                public final void run() {
                    MinusOneOverlayMeshMaskController.startClose(viewGroup);
                }
            });
            return;
        }
        cancel();
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setBackgroundColor(0);
        frameLayout.setAlpha(0.0f);
        frameLayout.setVisibility(0);
        frameLayout.setImportantForAccessibility(2);
        frameLayout.setClickable(false);
        frameLayout.setClipChildren(false);
        frameLayout.setClipToPadding(false);
        viewGroup.addView(frameLayout, new ViewGroup.LayoutParams(1, 1));
        sMaskView = frameLayout;
        try {
            s7.o oVarCreateMotionHost = createMotionHost(frameLayout);
            sHost = oVarCreateMotionHost;
            s7.k kVarPlayMesh = playMesh(oVarCreateMotionHost);
            sInstance = kVarPlayMesh;
            if (kVarPlayMesh == null) {
                Log.w(TAG, "Skip overlay mesh: play returned null");
                cleanup();
                return;
            }
            setUniform(kVarPlayMesh, "u_originX", 0.5f);
            setUniform(sInstance, "u_originY", 0.5f);
            AnimatorSet animatorSetBuildCloseAnimator = buildCloseAnimator(viewGroup, frameLayout);
            sAnimator = animatorSetBuildCloseAnimator;
            animatorSetBuildCloseAnimator.start();
        } catch (RuntimeException e10) {
            Log.w(TAG, "Unable to start overlay mesh", e10);
            cleanup();
        }
    }

    private static void release(s7.o oVar) {
        if (oVar == null) {
            return;
        }
        try {
            oVar.k();
        } catch (RuntimeException e10) {
            Log.w(TAG, "Unable to release motion host", e10);
        }
    }
}
