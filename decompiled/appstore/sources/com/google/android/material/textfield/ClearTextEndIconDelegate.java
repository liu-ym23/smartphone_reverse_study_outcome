package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import androidx.annotation.NonNull;
import c.a;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;

/* JADX INFO: loaded from: classes3.dex */
class ClearTextEndIconDelegate extends EndIconDelegate {
    private static final int ANIMATION_FADE_DURATION = 100;
    private static final int ANIMATION_SCALE_DURATION = 150;
    private static final float ANIMATION_SCALE_FROM_VALUE = 0.8f;
    private final TextWatcher clearTextEndIconTextWatcher;
    private final TextInputLayout.OnEditTextAttachedListener clearTextOnEditTextAttachedListener;
    private final TextInputLayout.OnEndIconChangedListener endIconChangedListener;
    private AnimatorSet iconInAnim;
    private ValueAnimator iconOutAnim;
    private final View.OnFocusChangeListener onFocusChangeListener;

    public ClearTextEndIconDelegate(@NonNull TextInputLayout r10) {
        super(r10);
        this.clearTextEndIconTextWatcher = new AnonymousClass1(this);
        this.onFocusChangeListener = new AnonymousClass2(this);
        this.clearTextOnEditTextAttachedListener = new AnonymousClass3(this);
        this.endIconChangedListener = new AnonymousClass4(this);
    }

    public static /* synthetic */ boolean access$000(Editable r10) {
        return hasText(r10);
    }

    public static /* synthetic */ void access$100(ClearTextEndIconDelegate r10, boolean r11) {
        r10.animateIcon(r11);
    }

    public static /* synthetic */ View.OnFocusChangeListener access$200(ClearTextEndIconDelegate r10) {
        return r10.onFocusChangeListener;
    }

    public static /* synthetic */ TextWatcher access$300(ClearTextEndIconDelegate r10) {
        return r10.clearTextEndIconTextWatcher;
    }

    private void animateIcon(boolean r10) {
        if (this.textInputLayout.isEndIconVisible() != r10) goto L5;
        boolean r11 = true;
    L6:
        if (r10 == true) goto L8;
    L12:
        if (r10 == true) goto L19;
        this.iconInAnim.cancel();
        this.iconOutAnim.start();
        if (r11 == false) goto L20;
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
        if (r11 == false) goto L17;
        this.iconInAnim.end();
        return;
    L17:
        return;
    L5:
        r11 = false;
        goto L6
    }

    private ValueAnimator getAlphaAnimator(float... r10) {
        ValueAnimator r11 = ValueAnimator.ofFloat(r10);
        r11.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        r11.setDuration(100);
        r11.addUpdateListener(new AnonymousClass8(this));
        return r11;
    }

    private ValueAnimator getScaleAnimator() {
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{ANIMATION_SCALE_FROM_VALUE, 1.0f});
        r10.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        r10.setDuration(150);
        r10.addUpdateListener(new AnonymousClass9(this));
        return r10;
    }

    private static boolean hasText(@NonNull Editable r10) {
        if (r10.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void initAnimators() {
        ValueAnimator r10 = getScaleAnimator();
        ValueAnimator r11 = getAlphaAnimator(new float[]{0.0f, 1.0f});
        AnimatorSet r12 = new AnimatorSet();
        this.iconInAnim = r12;
        r12.playTogether(new Animator[]{r10, r11});
        this.iconInAnim.addListener(new AnonymousClass6(this));
        ValueAnimator r13 = getAlphaAnimator(new float[]{1.0f, 0.0f});
        this.iconOutAnim = r13;
        r13.addListener(new AnonymousClass7(this));
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void initialize() {
        this.textInputLayout.setEndIconDrawable(a.b(this.context, R.drawable.mtrl_ic_cancel));
        TextInputLayout r10 = this.textInputLayout;
        r10.setEndIconContentDescription(r10.getResources().getText(R.string.clear_text_end_icon_content_description));
        this.textInputLayout.setEndIconOnClickListener(new AnonymousClass5(this));
        this.textInputLayout.addOnEditTextAttachedListener(this.clearTextOnEditTextAttachedListener);
        this.textInputLayout.addOnEndIconChangedListener(this.endIconChangedListener);
        initAnimators();
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void onSuffixVisibilityChanged(boolean r10) {
        if (this.textInputLayout.getSuffixText() != null) goto L5;
        return;
    L5:
        animateIcon(r10);
    }
}
