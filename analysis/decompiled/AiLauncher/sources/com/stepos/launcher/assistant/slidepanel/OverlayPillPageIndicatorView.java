package com.stepos.launcher.assistant.slidepanel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import java.util.Arrays;

/* loaded from: classes.dex */
public class OverlayPillPageIndicatorView extends View {
    private static final float BRIGHTNESS_ACTIVE = 0.81f;
    private static final float BRIGHTNESS_ENTERING = 0.38f;
    private static final float BRIGHTNESS_INACTIVE = 0.42f;
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_PAGE_COUNT = false;
    private static final float DOT_RADIUS_DP = 3.0f;
    private static final int PILL_BACKGROUND_COLOR = 1715486784;
    private static final float PILL_CORNER_RADIUS_DP = 13.0f;
    private static final float PILL_HEIGHT_DP = 26.0f;
    private static final float PILL_PADDING_H_DP = 12.0f;
    private static final float PILL_PADDING_V_DP = 10.0f;
    private static final float PILL_WIDTH_DP = 55.0f;
    private static final float PROGRESS_EPSILON = 1.0E-4f;
    private static final float SHIFT_TRANSLATION_DP = 6.58f;
    private static final String TAG = "OverlayPillIndicator";
    private static final float TWO_DOT_DIAMETER_DP = 5.0f;
    private static final float TWO_DOT_GAP_DP = 8.0f;
    private static final float TWO_DOT_ROW_WIDTH_DP = 18.0f;
    private static final long TWO_PAGE_COLOR_DURATION_MS = 200;
    private static final long WINDOW_SHIFT_LEFT_FADE_DELAY_MS = 17;
    private static final long WINDOW_SHIFT_LEFT_FADE_MS = 217;
    private static final long WINDOW_SHIFT_LEFT_MOVE_MS = 233;
    private static final long WINDOW_SHIFT_RIGHT_PHASE1_MS = 300;
    private static final long WINDOW_SHIFT_RIGHT_PHASE2_DELAY_MS = 300;
    private static final long WINDOW_SHIFT_RIGHT_PHASE2_MS = 250;
    private int mActivePage;
    private final Paint mBackgroundPaint;
    private float mDensity;
    private float[] mDotAlpha;
    private float[] mDotBrightness;
    private float mDotCenterY;
    private float[] mDotCentersX;
    private float[] mDotOffsetX;
    private final Paint mDotPaint;
    private float mDotRadius;
    private final OverlayPillGlassMaterial mGlassMaterial;
    private int mIndicatorColor;
    private float mOverlayProgress;
    private Animator mPageAnimator;
    private float mPillCornerRadius;
    private float mPillHeight;
    private float mPillPaddingH;
    private float mPillPaddingV;
    private final RectF mPillRect;
    private float mPillWidth;
    private int mScrollColor;
    private float mTwoDotGap;
    private float mTwoDotRadius;
    private float mTwoDotRowWidth;
    private int mVisibleDotCount;
    private int[] mVisibleWorkspacePages;
    private int mWorkspacePageCount;
    private static final LinearInterpolator LINEAR = new LinearInterpolator();
    private static final PathInterpolator EASE_IN_OUT = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    public OverlayPillPageIndicatorView(Context context) {
        this(context, null);
    }

    private int activeWorkspaceSlotIndex(int i10) {
        int i11 = this.mWorkspacePageCount;
        return (i11 < 2 || i10 < i11 - 1) ? 1 : 2;
    }

    private ValueAnimator alphaAnim(final int i10, float f10, float f11) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f10, f11);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.launcher.assistant.slidepanel.i
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f30144a.lambda$alphaAnim$1(i10, valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    private void animateColorSwap(int i10) {
        int iWorkspacePageToDotIndex = workspacePageToDotIndex(i10);
        AnimatorSet animatorSet = new AnimatorSet();
        int i11 = 0;
        while (true) {
            float[] fArr = this.mDotBrightness;
            if (i11 >= fArr.length) {
                animatorSet.setDuration(200L);
                animatorSet.setInterpolator(LINEAR);
                animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.stepos.launcher.assistant.slidepanel.OverlayPillPageIndicatorView.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        OverlayPillPageIndicatorView.this.mPageAnimator = null;
                    }
                });
                this.mPageAnimator = animatorSet;
                animatorSet.start();
                return;
            }
            if (i11 != 0) {
                float f10 = i11 == iWorkspacePageToDotIndex ? BRIGHTNESS_ACTIVE : BRIGHTNESS_INACTIVE;
                float f11 = fArr[i11];
                if (f11 != f10) {
                    animatorSet.play(brightnessAnim(i11, f11, f10));
                }
            }
            i11++;
        }
    }

    private void animateToActivePage(int i10, int i11) {
        cancelPageAnimator();
        if (this.mWorkspacePageCount <= 2) {
            animateColorSwap(i11);
            return;
        }
        int[] iArrComputeVisibleWorkspacePages = computeVisibleWorkspacePages(i10);
        int[] iArrComputeVisibleWorkspacePages2 = computeVisibleWorkspacePages(i11);
        if (Arrays.equals(iArrComputeVisibleWorkspacePages, iArrComputeVisibleWorkspacePages2)) {
            animateColorSwap(i11);
        } else if (i11 > i10) {
            animateWindowShiftLeft(iArrComputeVisibleWorkspacePages, iArrComputeVisibleWorkspacePages2);
        } else {
            animateWindowShiftRight(iArrComputeVisibleWorkspacePages, iArrComputeVisibleWorkspacePages2);
        }
    }

    private void animateWindowShiftLeft(int[] iArr, int[] iArr2) {
        int i10;
        float fShiftTranslationPx = shiftTranslationPx();
        AnimatorSet animatorSet = new AnimatorSet();
        int i11 = 0;
        int i12 = 0;
        while (i12 < this.mDotOffsetX.length) {
            OverlayPillPageIndicatorView overlayPillPageIndicatorView = this;
            animatorSet.play(overlayPillPageIndicatorView.offsetAnim(i12, 0.0f, -fShiftTranslationPx, WINDOW_SHIFT_LEFT_MOVE_MS));
            i12++;
            this = overlayPillPageIndicatorView;
        }
        OverlayPillPageIndicatorView overlayPillPageIndicatorView2 = this;
        int length = iArr.length;
        while (true) {
            if (i11 >= length) {
                i10 = -1;
                break;
            }
            i10 = iArr[i11];
            if (!containsPage(iArr2, i10)) {
                break;
            } else {
                i11++;
            }
        }
        int iWorkspacePageToDotIndexInWindow = overlayPillPageIndicatorView2.workspacePageToDotIndexInWindow(i10, iArr);
        int length2 = overlayPillPageIndicatorView2.mDotCentersX.length - 1;
        if (iWorkspacePageToDotIndexInWindow >= 0 && iWorkspacePageToDotIndexInWindow < overlayPillPageIndicatorView2.mDotAlpha.length) {
            ValueAnimator valueAnimatorAlphaAnim = overlayPillPageIndicatorView2.alphaAnim(iWorkspacePageToDotIndexInWindow, 1.0f, 0.0f);
            valueAnimatorAlphaAnim.setDuration(WINDOW_SHIFT_LEFT_FADE_MS);
            valueAnimatorAlphaAnim.setStartDelay(WINDOW_SHIFT_LEFT_FADE_DELAY_MS);
            valueAnimatorAlphaAnim.setInterpolator(LINEAR);
            animatorSet.play(valueAnimatorAlphaAnim);
        }
        if (length2 >= 0) {
            float[] fArr = overlayPillPageIndicatorView2.mDotAlpha;
            if (length2 < fArr.length) {
                fArr[length2] = 0.0f;
                ValueAnimator valueAnimatorAlphaAnim2 = overlayPillPageIndicatorView2.alphaAnim(length2, 0.0f, 1.0f);
                valueAnimatorAlphaAnim2.setDuration(WINDOW_SHIFT_LEFT_MOVE_MS);
                valueAnimatorAlphaAnim2.setStartDelay(WINDOW_SHIFT_LEFT_FADE_DELAY_MS);
                valueAnimatorAlphaAnim2.setInterpolator(LINEAR);
                animatorSet.play(valueAnimatorAlphaAnim2);
            }
        }
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.stepos.launcher.assistant.slidepanel.OverlayPillPageIndicatorView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                OverlayPillPageIndicatorView.this.mPageAnimator = null;
                OverlayPillPageIndicatorView.this.recomputeVisibleWorkspacePages();
                OverlayPillPageIndicatorView.this.recomputeDotCenters();
                OverlayPillPageIndicatorView.this.resetDotMotionState();
                OverlayPillPageIndicatorView overlayPillPageIndicatorView3 = OverlayPillPageIndicatorView.this;
                overlayPillPageIndicatorView3.applyBrightnessForActivePage(overlayPillPageIndicatorView3.mActivePage);
                OverlayPillPageIndicatorView.this.invalidate();
            }
        });
        overlayPillPageIndicatorView2.mPageAnimator = animatorSet;
        animatorSet.start();
    }

    private void animateWindowShiftRight(int[] iArr, int[] iArr2) {
        int length = iArr2.length;
        for (int i10 = 0; i10 < length && containsPage(iArr, iArr2[i10]); i10++) {
        }
        int length2 = iArr.length - 1;
        while (true) {
            if (length2 < 0) {
                break;
            }
            if (!containsPage(iArr2, iArr[length2])) {
                int i11 = iArr[length2];
                break;
            }
            length2--;
        }
        int length3 = this.mDotCentersX.length - 1;
        float[] fArr = this.mDotBrightness;
        if (1 < fArr.length) {
            fArr[1] = 0.38f;
        }
        float fShiftTranslationPx = shiftTranslationPx();
        ValueAnimator valueAnimatorBrightnessAnim = brightnessAnim(1, BRIGHTNESS_ENTERING, BRIGHTNESS_ACTIVE);
        valueAnimatorBrightnessAnim.setDuration(300L);
        valueAnimatorBrightnessAnim.setInterpolator(LINEAR);
        AnimatorSet animatorSet = new AnimatorSet();
        int i12 = 0;
        while (i12 < this.mDotOffsetX.length) {
            OverlayPillPageIndicatorView overlayPillPageIndicatorView = this;
            animatorSet.play(overlayPillPageIndicatorView.offsetAnim(i12, 0.0f, fShiftTranslationPx, 250L));
            i12++;
            this = overlayPillPageIndicatorView;
        }
        OverlayPillPageIndicatorView overlayPillPageIndicatorView2 = this;
        float[] fArr2 = overlayPillPageIndicatorView2.mDotAlpha;
        if (1 < fArr2.length) {
            fArr2[1] = 0.0f;
            ValueAnimator valueAnimatorAlphaAnim = overlayPillPageIndicatorView2.alphaAnim(1, 0.0f, 1.0f);
            valueAnimatorAlphaAnim.setDuration(250L);
            valueAnimatorAlphaAnim.setInterpolator(LINEAR);
            animatorSet.play(valueAnimatorAlphaAnim);
        }
        if (length3 >= 0 && length3 < overlayPillPageIndicatorView2.mDotAlpha.length) {
            ValueAnimator valueAnimatorAlphaAnim2 = overlayPillPageIndicatorView2.alphaAnim(length3, 1.0f, 0.0f);
            valueAnimatorAlphaAnim2.setDuration(250L);
            valueAnimatorAlphaAnim2.setInterpolator(LINEAR);
            animatorSet.play(valueAnimatorAlphaAnim2);
        }
        animatorSet.setStartDelay(300L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playSequentially(valueAnimatorBrightnessAnim, animatorSet);
        animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.stepos.launcher.assistant.slidepanel.OverlayPillPageIndicatorView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                OverlayPillPageIndicatorView.this.mPageAnimator = null;
                OverlayPillPageIndicatorView.this.recomputeVisibleWorkspacePages();
                OverlayPillPageIndicatorView.this.recomputeDotCenters();
                OverlayPillPageIndicatorView.this.resetDotMotionState();
                OverlayPillPageIndicatorView overlayPillPageIndicatorView3 = OverlayPillPageIndicatorView.this;
                overlayPillPageIndicatorView3.applyBrightnessForActivePage(overlayPillPageIndicatorView3.mActivePage);
                OverlayPillPageIndicatorView.this.invalidate();
            }
        });
        overlayPillPageIndicatorView2.mPageAnimator = animatorSet2;
        animatorSet2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyBrightnessForActivePage(int i10) {
        if (this.mDotBrightness.length == 0) {
            return;
        }
        int iWorkspacePageToDotIndex = workspacePageToDotIndex(i10);
        int i11 = 0;
        while (true) {
            float[] fArr = this.mDotBrightness;
            if (i11 >= fArr.length) {
                return;
            }
            if (i11 == 0) {
                fArr[i11] = 0.42f;
            } else if (i11 == iWorkspacePageToDotIndex) {
                fArr[i11] = 0.81f;
            } else {
                fArr[i11] = 0.42f;
            }
            this.mDotAlpha[i11] = 1.0f;
            this.mDotOffsetX[i11] = 0.0f;
            i11++;
        }
    }

    private void applyDotBrightnessForCurrentState() {
        float f10 = this.mOverlayProgress;
        if (f10 > 0.001f) {
            applyOverlayDotBrightness(f10);
        } else {
            applyBrightnessForActivePage(this.mActivePage);
        }
    }

    private void applyOverlayDotBrightness(float f10) {
        float[] fArr = this.mDotBrightness;
        if (fArr.length < 2) {
            return;
        }
        if (f10 <= 0.0f) {
            applyBrightnessForActivePage(this.mActivePage);
            return;
        }
        int i10 = 0;
        if (f10 >= 1.0f) {
            while (true) {
                float[] fArr2 = this.mDotBrightness;
                if (i10 >= fArr2.length) {
                    return;
                }
                fArr2[i10] = i10 == 0 ? 0.81f : 0.42f;
                i10++;
            }
        } else {
            fArr[1] = lerp(BRIGHTNESS_ACTIVE, BRIGHTNESS_INACTIVE, f10);
            this.mDotBrightness[0] = lerp(BRIGHTNESS_INACTIVE, BRIGHTNESS_ACTIVE, f10);
            while (true) {
                float[] fArr3 = this.mDotBrightness;
                if (i10 >= fArr3.length) {
                    return;
                }
                if (i10 != 0 && i10 != 1) {
                    fArr3[i10] = 0.42f;
                }
                i10++;
            }
        }
    }

    private boolean applyPillLayoutFromState(Bundle bundle) {
        if (!bundle.containsKey(OverlayIndicatorState.KEY_PILL_WIDTH_PX)) {
            return false;
        }
        float f10 = bundle.getInt(OverlayIndicatorState.KEY_PILL_WIDTH_PX);
        float f11 = bundle.getInt(OverlayIndicatorState.KEY_PILL_HEIGHT_PX);
        float f12 = bundle.getInt(OverlayIndicatorState.KEY_PILL_PADDING_HORIZONTAL_PX);
        float f13 = bundle.getInt(OverlayIndicatorState.KEY_PILL_PADDING_VERTICAL_PX);
        float f14 = bundle.getInt(OverlayIndicatorState.KEY_PILL_CORNER_RADIUS_PX);
        float f15 = bundle.getInt(OverlayIndicatorState.KEY_DOT_RADIUS_PX);
        float f16 = bundle.getInt(OverlayIndicatorState.KEY_TWO_DOT_RADIUS_PX);
        float f17 = bundle.getInt(OverlayIndicatorState.KEY_TWO_DOT_GAP_PX);
        float f18 = bundle.getInt(OverlayIndicatorState.KEY_TWO_DOT_ROW_WIDTH_PX);
        if (f10 == this.mPillWidth && f11 == this.mPillHeight && f12 == this.mPillPaddingH && f13 == this.mPillPaddingV && f14 == this.mPillCornerRadius && f15 == this.mDotRadius && f16 == this.mTwoDotRadius && f17 == this.mTwoDotGap && f18 == this.mTwoDotRowWidth) {
            return false;
        }
        this.mPillWidth = f10;
        this.mPillHeight = f11;
        this.mPillPaddingH = f12;
        this.mPillPaddingV = f13;
        this.mPillCornerRadius = f14;
        this.mDotRadius = f15;
        this.mTwoDotRadius = f16;
        this.mTwoDotGap = f17;
        this.mTwoDotRowWidth = f18;
        this.mGlassMaterial.setCornerRadiusPx(f14);
        return true;
    }

    private ValueAnimator brightnessAnim(final int i10, float f10, float f11) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f10, f11);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.launcher.assistant.slidepanel.k
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f30148a.lambda$brightnessAnim$0(i10, valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    private void cancelPageAnimator() {
        Animator animator = this.mPageAnimator;
        if (animator != null) {
            animator.cancel();
            this.mPageAnimator = null;
        }
    }

    private static float clamp(float f10) {
        return Math.max(0.0f, Math.min(1.0f, f10));
    }

    private float compactTwoDotRowWidth() {
        return (this.mDotRadius * 4.0f) + this.mTwoDotGap;
    }

    private int[] computeVisibleWorkspacePages(int i10) {
        int i11;
        int iMin;
        int iEffectiveVisibleDotCount = effectiveVisibleDotCount() - 1;
        int i12 = this.mWorkspacePageCount;
        if (iEffectiveVisibleDotCount <= 0 || i12 <= 0) {
            return new int[]{0};
        }
        if (iEffectiveVisibleDotCount == 1 || i12 == 1) {
            return new int[]{0};
        }
        if (i12 != 2 && (iMin = Math.min(Math.max(i10, 0), i12 - 1)) > 0) {
            return iMin >= i11 ? new int[]{i12 - 2, i11} : new int[]{iMin, iMin + 1};
        }
        return new int[]{0, 1};
    }

    private static boolean containsPage(int[] iArr, int i10) {
        for (int i11 : iArr) {
            if (i11 == i10) {
                return true;
            }
        }
        return false;
    }

    private int effectiveVisibleDotCount() {
        int i10 = this.mVisibleDotCount;
        return i10 > 0 ? i10 : visibleDotCountFromWorkspace();
    }

    private boolean isTwoScreenLayout() {
        return this.mWorkspacePageCount == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$alphaAnim$1(int i10, ValueAnimator valueAnimator) {
        this.mDotAlpha[i10] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$brightnessAnim$0(int i10, ValueAnimator valueAnimator) {
        this.mDotBrightness[i10] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$offsetAnim$2(int i10, ValueAnimator valueAnimator) {
        this.mDotOffsetX[i10] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    private static float lerp(float f10, float f11, float f12) {
        return f10 + ((f11 - f10) * f12);
    }

    private void logPageCountState(String str) {
    }

    private int mappedPageForActiveSlot(int i10) {
        int iMin = Math.min(Math.max(i10, 0), Math.max(this.mWorkspacePageCount - 1, 0));
        int[] iArrComputeVisibleWorkspacePages = computeVisibleWorkspacePages(iMin);
        return iArrComputeVisibleWorkspacePages.length == 0 ? iMin : activeWorkspaceSlotIndex(iMin) == 2 ? iArrComputeVisibleWorkspacePages[iArrComputeVisibleWorkspacePages.length - 1] : iArrComputeVisibleWorkspacePages[0];
    }

    private ValueAnimator offsetAnim(final int i10, float f10, float f11, long j10) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f10, f11);
        valueAnimatorOfFloat.setDuration(j10);
        valueAnimatorOfFloat.setInterpolator(EASE_IN_OUT);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.launcher.assistant.slidepanel.j
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f30146a.lambda$offsetAnim$2(i10, valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recomputeDotCenters() {
        int iEffectiveVisibleDotCount = effectiveVisibleDotCount();
        if (iEffectiveVisibleDotCount <= 0) {
            this.mDotCentersX = new float[0];
            return;
        }
        float[] fArr = new float[iEffectiveVisibleDotCount];
        this.mDotCentersX = fArr;
        float f10 = this.mPillPaddingH;
        float f11 = this.mPillPaddingV;
        float f12 = this.mPillWidth - (f10 * 2.0f);
        this.mDotCenterY = f11 + ((this.mPillHeight - (f11 * 2.0f)) / 2.0f);
        if (iEffectiveVisibleDotCount == 2) {
            float fCompactTwoDotRowWidth = f10 + ((f12 - compactTwoDotRowWidth()) / 2.0f);
            float[] fArr2 = this.mDotCentersX;
            float f13 = this.mDotRadius;
            float f14 = fCompactTwoDotRowWidth + f13;
            fArr2[0] = f14;
            fArr2[1] = f14 + (f13 * 2.0f) + this.mTwoDotGap;
            return;
        }
        if (iEffectiveVisibleDotCount == 1) {
            fArr[0] = f10 + (f12 / 2.0f);
            return;
        }
        float f15 = this.mDotRadius;
        float f16 = f10 + f15;
        float f17 = (((f10 + f12) - f15) - f16) / (iEffectiveVisibleDotCount - 1);
        for (int i10 = 0; i10 < iEffectiveVisibleDotCount; i10++) {
            this.mDotCentersX[i10] = (i10 * f17) + f16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recomputeVisibleWorkspacePages() {
        this.mVisibleWorkspacePages = computeVisibleWorkspacePages(this.mActivePage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetDotMotionState() {
        int length = this.mDotCentersX.length;
        this.mDotBrightness = new float[length];
        float[] fArr = new float[length];
        this.mDotAlpha = fArr;
        this.mDotOffsetX = new float[length];
        Arrays.fill(fArr, 1.0f);
    }

    private float shiftTranslationPx() {
        if (this.mDotCentersX.length <= 1) {
            return this.mDensity * SHIFT_TRANSLATION_DP;
        }
        float f10 = this.mPillPaddingH;
        float f11 = this.mDotRadius;
        return ((((this.mPillWidth - f10) - f11) - (f10 + f11)) / (r0 - 1)) / 2.0f;
    }

    private int visibleDotCountFromWorkspace() {
        return this.mWorkspacePageCount <= 1 ? 2 : 3;
    }

    private static int withAlpha(int i10, float f10) {
        return Color.argb(Math.round(f10 * Color.alpha(i10)), Color.red(i10), Color.green(i10), Color.blue(i10));
    }

    private int workspacePageToDotIndex(int i10) {
        if (i10 < 0) {
            return 0;
        }
        int iMappedPageForActiveSlot = mappedPageForActiveSlot(i10);
        int i11 = 0;
        while (true) {
            int[] iArr = this.mVisibleWorkspacePages;
            if (i11 >= iArr.length) {
                return activeWorkspaceSlotIndex(Math.min(Math.max(i10, 0), Math.max(this.mWorkspacePageCount - 1, 0)));
            }
            if (iArr[i11] == iMappedPageForActiveSlot) {
                return i11 + 1;
            }
            i11++;
        }
    }

    private int workspacePageToDotIndexInWindow(int i10, int[] iArr) {
        for (int i11 = 0; i11 < iArr.length; i11++) {
            if (iArr[i11] == i10) {
                return i11 + 1;
            }
        }
        return 1;
    }

    public boolean applyState(Bundle bundle) {
        return applyState(bundle, true);
    }

    public int getActivePage() {
        return this.mActivePage;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mGlassMaterial.attach();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        this.mGlassMaterial.detach();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mVisibleDotCount > 0 || this.mWorkspacePageCount > 0) {
            int iEffectiveVisibleDotCount = effectiveVisibleDotCount();
            if (iEffectiveVisibleDotCount <= 0 || this.mDotCentersX.length < iEffectiveVisibleDotCount) {
                recomputeDotCenters();
                resetDotMotionState();
                applyDotBrightnessForCurrentState();
            }
            if (this.mDotCentersX.length < iEffectiveVisibleDotCount) {
                return;
            }
            if (this.mGlassMaterial.shouldDrawFallbackBackground()) {
                this.mPillRect.set(0.0f, 0.0f, getWidth(), getHeight());
                RectF rectF = this.mPillRect;
                float f10 = this.mPillCornerRadius;
                canvas.drawRoundRect(rectF, f10, f10, this.mBackgroundPaint);
            }
            float height = this.mDotCenterY;
            if (height <= 0.0f) {
                height = getHeight() / 2.0f;
            }
            int i10 = 0;
            while (i10 < iEffectiveVisibleDotCount) {
                float[] fArr = this.mDotAlpha;
                float f11 = i10 < fArr.length ? fArr[i10] : 1.0f;
                if (f11 > 0.0f) {
                    float[] fArr2 = this.mDotBrightness;
                    float f12 = i10 < fArr2.length ? fArr2[i10] : BRIGHTNESS_INACTIVE;
                    float[] fArr3 = this.mDotOffsetX;
                    float f13 = i10 < fArr3.length ? fArr3[i10] : 0.0f;
                    boolean z10 = f12 >= 0.76f;
                    this.mDotPaint.setColor(withAlpha(z10 ? this.mScrollColor : this.mIndicatorColor, (z10 ? 1.0f : f12) * f11));
                    canvas.drawCircle(this.mDotCentersX[i10] + f13, height, this.mDotRadius, this.mDotPaint);
                }
                i10++;
            }
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            this.mGlassMaterial.onLayoutChanged();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        setMeasuredDimension((int) Math.ceil(this.mPillWidth), (int) Math.ceil(this.mPillHeight));
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        if (view == this) {
            this.mGlassMaterial.onVisibilityChanged();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.mGlassMaterial.onWindowVisibilityChanged(i10);
    }

    public void setOverlayProgress(float f10) {
        float fClamp = clamp(f10);
        if (Math.abs(fClamp - this.mOverlayProgress) < PROGRESS_EPSILON) {
            return;
        }
        this.mOverlayProgress = fClamp;
        this.mGlassMaterial.setOverlayProgress(fClamp);
        applyDotBrightnessForCurrentState();
        invalidate();
    }

    public OverlayPillPageIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint(1);
        this.mDotPaint = paint;
        Paint paint2 = new Paint(1);
        this.mBackgroundPaint = paint2;
        this.mPillRect = new RectF();
        this.mIndicatorColor = -1;
        this.mScrollColor = -1;
        this.mVisibleWorkspacePages = new int[0];
        this.mDotCentersX = new float[0];
        this.mDotBrightness = new float[0];
        this.mDotAlpha = new float[0];
        this.mDotOffsetX = new float[0];
        float f10 = getResources().getDisplayMetrics().density;
        this.mDensity = f10;
        this.mPillWidth = PILL_WIDTH_DP * f10;
        this.mPillHeight = PILL_HEIGHT_DP * f10;
        this.mPillPaddingH = 12.0f * f10;
        this.mPillPaddingV = 10.0f * f10;
        this.mPillCornerRadius = 13.0f * f10;
        this.mDotRadius = 3.0f * f10;
        this.mTwoDotRadius = (5.0f * f10) / 2.0f;
        this.mTwoDotGap = 8.0f * f10;
        this.mTwoDotRowWidth = f10 * TWO_DOT_ROW_WIDTH_DP;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint2.setStyle(style);
        paint2.setColor(PILL_BACKGROUND_COLOR);
        OverlayPillGlassMaterial overlayPillGlassMaterial = new OverlayPillGlassMaterial(this, TAG);
        this.mGlassMaterial = overlayPillGlassMaterial;
        overlayPillGlassMaterial.setCornerRadiusPx(this.mPillCornerRadius);
        setClickable(true);
        setFocusable(false);
        setImportantForAccessibility(2);
    }

    public boolean applyState(Bundle bundle, boolean z10) {
        boolean z11;
        boolean z12;
        int i10;
        int i11;
        int iMax;
        int iMax2;
        int iMax3;
        boolean z13 = false;
        if (bundle == null) {
            return false;
        }
        int i12 = this.mActivePage;
        boolean zApplyPillLayoutFromState = applyPillLayoutFromState(bundle);
        boolean z14 = true;
        if (!bundle.containsKey(OverlayIndicatorState.KEY_PAGE_COUNT) || (iMax3 = Math.max(0, bundle.getInt(OverlayIndicatorState.KEY_PAGE_COUNT))) == this.mVisibleDotCount) {
            z11 = false;
        } else {
            this.mVisibleDotCount = iMax3;
            zApplyPillLayoutFromState = true;
            z11 = true;
        }
        if (bundle.containsKey(OverlayIndicatorState.KEY_WORKSPACE_PAGE_COUNT) && (iMax2 = Math.max(0, bundle.getInt(OverlayIndicatorState.KEY_WORKSPACE_PAGE_COUNT))) != this.mWorkspacePageCount) {
            this.mWorkspacePageCount = iMax2;
            zApplyPillLayoutFromState = true;
            z11 = true;
        }
        if (!bundle.containsKey(OverlayIndicatorState.KEY_ACTIVE_PAGE) || (iMax = Math.max(0, bundle.getInt(OverlayIndicatorState.KEY_ACTIVE_PAGE))) == this.mActivePage) {
            z12 = false;
        } else {
            this.mActivePage = iMax;
            zApplyPillLayoutFromState = true;
            z11 = true;
            z12 = true;
        }
        if (z10 && bundle.containsKey(OverlayIndicatorState.KEY_OVERLAY_PROGRESS)) {
            float fClamp = clamp(bundle.getFloat(OverlayIndicatorState.KEY_OVERLAY_PROGRESS));
            if (Math.abs(fClamp - this.mOverlayProgress) >= PROGRESS_EPSILON) {
                this.mOverlayProgress = fClamp;
                this.mGlassMaterial.setOverlayProgress(fClamp);
                z13 = true;
                z11 = true;
            }
        }
        if (bundle.containsKey(OverlayIndicatorState.KEY_INDICATOR_COLOR) && (i11 = bundle.getInt(OverlayIndicatorState.KEY_INDICATOR_COLOR)) != this.mIndicatorColor) {
            this.mIndicatorColor = i11;
            z11 = true;
        }
        if (!bundle.containsKey(OverlayIndicatorState.KEY_SCROLL_COLOR) || (i10 = bundle.getInt(OverlayIndicatorState.KEY_SCROLL_COLOR)) == this.mScrollColor) {
            z14 = z11;
        } else {
            this.mScrollColor = i10;
        }
        if (zApplyPillLayoutFromState) {
            recomputeVisibleWorkspacePages();
            recomputeDotCenters();
            resetDotMotionState();
            if (OverlayIndicatorState.isLauncherGlassRestProgress(this.mOverlayProgress)) {
                applyBrightnessForActivePage(z12 ? i12 : this.mActivePage);
            } else {
                applyDotBrightnessForCurrentState();
            }
            requestLayout();
            logPageCountState("applyState");
        } else if (z13) {
            applyDotBrightnessForCurrentState();
        }
        if (z12 && z10 && OverlayIndicatorState.isLauncherGlassRestProgress(this.mOverlayProgress)) {
            animateToActivePage(i12, this.mActivePage);
            return zApplyPillLayoutFromState;
        }
        if (z14) {
            invalidate();
        }
        return zApplyPillLayoutFromState;
    }
}
