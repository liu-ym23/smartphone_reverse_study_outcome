package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MotionUtils;

/* JADX INFO: loaded from: classes2.dex */
class ClearTextEndIconDelegate extends EndIconDelegate {
    private static final float ANIMATION_SCALE_FROM_VALUE = 0.8f;
    private static final int DEFAULT_ANIMATION_FADE_DURATION = 100;
    private static final int DEFAULT_ANIMATION_SCALE_DURATION = 150;
    private final int animationFadeDuration;
    private final TimeInterpolator animationFadeInterpolator;
    private final int animationScaleDuration;
    private final TimeInterpolator animationScaleInterpolator;
    private EditText editText;
    private AnimatorSet iconInAnim;
    private ValueAnimator iconOutAnim;
    private final View.OnFocusChangeListener onFocusChangeListener;
    private final View.OnClickListener onIconClickListener;

    /* JADX INFO: renamed from: lambda$new$0$com-google-android-material-textfield-ClearTextEndIconDelegate, reason: not valid java name */
    /* synthetic */ void m273xfc81bd94(View r1) {
        EditText r2 = this.editText;
        if (r2 != null) goto L5;
        return;
    L5:
        Editable r3 = r2.getText();
        if (r3 == null) goto L8;
        r3.clear();
    L8:
        refreshIconState();
    }

    /* JADX INFO: renamed from: lambda$new$1$com-google-android-material-textfield-ClearTextEndIconDelegate, reason: not valid java name */
    /* synthetic */ void m274x7ae2c173(View r1, boolean r2) {
        animateIcon(shouldBeVisible());
    }

    ClearTextEndIconDelegate(EndCompoundLayout r4) {
        super(r4);
        this.onIconClickListener = new ClearTextEndIconDelegate$$ExternalSyntheticLambda3(this);
        this.onFocusChangeListener = new ClearTextEndIconDelegate$$ExternalSyntheticLambda4(this);
        this.animationFadeDuration = MotionUtils.resolveThemeDuration(r4.getContext(), R.attr.motionDurationShort3, 100);
        this.animationScaleDuration = MotionUtils.resolveThemeDuration(r4.getContext(), R.attr.motionDurationShort3, 150);
        this.animationFadeInterpolator = MotionUtils.resolveThemeInterpolator(r4.getContext(), R.attr.motionEasingLinearInterpolator, AnimationUtils.LINEAR_INTERPOLATOR);
        this.animationScaleInterpolator = MotionUtils.resolveThemeInterpolator(r4.getContext(), R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void setUp() {
        initAnimators();
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void tearDown() {
        EditText r0 = this.editText;
        if (r0 == null) goto L6;
        r0.post(new ClearTextEndIconDelegate$$ExternalSyntheticLambda0(this));
        return;
    }

    /* JADX INFO: renamed from: lambda$tearDown$2$com-google-android-material-textfield-ClearTextEndIconDelegate, reason: not valid java name */
    /* synthetic */ void m275x26d8c5f4() {
        animateIcon(true);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    int getIconDrawableResId() {
        return R.drawable.mtrl_ic_cancel;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    int getIconContentDescriptionResId() {
        return R.string.clear_text_end_icon_content_description;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void onSuffixVisibilityChanged(boolean r2) {
        if (this.endLayout.getSuffixText() != null) goto L5;
        return;
    L5:
        animateIcon(r2);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    View.OnClickListener getOnIconClickListener() {
        return this.onIconClickListener;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void onEditTextAttached(EditText r1) {
        this.editText = r1;
        this.textInputLayout.setEndIconVisible(shouldBeVisible());
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void afterEditTextChanged(Editable r1) {
        if (this.endLayout.getSuffixText() == null) goto L5;
        return;
    L5:
        animateIcon(shouldBeVisible());
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    View.OnFocusChangeListener getOnEditTextFocusChangeListener() {
        return this.onFocusChangeListener;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    View.OnFocusChangeListener getOnIconViewFocusChangeListener() {
        return this.onFocusChangeListener;
    }

    private void animateIcon(boolean r3) {
        if (this.endLayout.isEndIconVisible() != r3) goto L5;
        boolean r0 = true;
    L6:
        if (r3 == true) goto L8;
    L12:
        if (r3 == true) goto L19;
        this.iconInAnim.cancel();
        this.iconOutAnim.start();
        if (r0 == false) goto L20;
        this.iconOutAnim.end();
        return;
    L20:
        return;
    L19:
        return;
    L8:
        if (this.iconInAnim.isRunning() == true) goto L12;
        this.iconOutAnim.cancel();
        this.iconInAnim.start();
        if (r0 == false) goto L17;
        this.iconInAnim.end();
        return;
    L17:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private void initAnimators() {
        ValueAnimator r0 = getScaleAnimator();
        ValueAnimator r2 = getAlphaAnimator(new float[]{0.0f, 1.0f});
        AnimatorSet r3 = new AnimatorSet();
        this.iconInAnim = r3;
        r3.playTogether(new Animator[]{r0, r2});
        this.iconInAnim.addListener(new AnonymousClass1(this));
        ValueAnimator r1 = getAlphaAnimator(new float[]{1.0f, 0.0f});
        this.iconOutAnim = r1;
        r1.addListener(new AnonymousClass2(this));
    }

    private ValueAnimator getAlphaAnimator(float... r3) {
        ValueAnimator r4 = ValueAnimator.ofFloat(r3);
        r4.setInterpolator(this.animationFadeInterpolator);
        r4.setDuration(this.animationFadeDuration);
        r4.addUpdateListener(new ClearTextEndIconDelegate$$ExternalSyntheticLambda2(this));
        return r4;
    }

    /* JADX INFO: renamed from: lambda$getAlphaAnimator$3$com-google-android-material-textfield-ClearTextEndIconDelegate, reason: not valid java name */
    /* synthetic */ void m271xa5c23ba8(ValueAnimator r1) {
        float r2 = ((Float) r1.getAnimatedValue()).floatValue();
        this.endIconView.setAlpha(r2);
    }

    private ValueAnimator getScaleAnimator() {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.8f, 1.0f});
        r0.setInterpolator(this.animationScaleInterpolator);
        r0.setDuration(this.animationScaleDuration);
        r0.addUpdateListener(new ClearTextEndIconDelegate$$ExternalSyntheticLambda1(this));
        return r0;
    }

    /* JADX INFO: renamed from: lambda$getScaleAnimator$4$com-google-android-material-textfield-ClearTextEndIconDelegate, reason: not valid java name */
    /* synthetic */ void m272x3819711b(ValueAnimator r2) {
        float r3 = ((Float) r2.getAnimatedValue()).floatValue();
        this.endIconView.setScaleX(r3);
        this.endIconView.setScaleY(r3);
    }

    private boolean shouldBeVisible() {
        EditText r0 = this.editText;
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.hasFocus() == true) goto L9;
        if (this.endIconView.hasFocus() == false) goto L11;
    L9:
        if (this.editText.getText().length() <= 0) goto L11;
        return true;
    }
}
