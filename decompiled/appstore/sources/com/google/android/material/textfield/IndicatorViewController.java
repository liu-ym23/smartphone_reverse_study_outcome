package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.resources.MaterialResources;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class IndicatorViewController {
    private static final int CAPTION_OPACITY_FADE_ANIMATION_DURATION = 167;
    private static final int CAPTION_STATE_ERROR = 1;
    private static final int CAPTION_STATE_HELPER_TEXT = 2;
    private static final int CAPTION_STATE_NONE = 0;
    private static final int CAPTION_TRANSLATE_Y_ANIMATION_DURATION = 217;
    static final int COUNTER_INDEX = 2;
    static final int ERROR_INDEX = 0;
    static final int HELPER_INDEX = 1;

    @Nullable
    private Animator captionAnimator;
    private FrameLayout captionArea;
    private int captionDisplayed;
    private int captionToShow;
    private final float captionTranslationYPx;
    private final Context context;
    private boolean errorEnabled;

    @Nullable
    private CharSequence errorText;
    private int errorTextAppearance;

    @Nullable
    private TextView errorView;

    @Nullable
    private CharSequence errorViewContentDescription;

    @Nullable
    private ColorStateList errorViewTextColor;
    private CharSequence helperText;
    private boolean helperTextEnabled;
    private int helperTextTextAppearance;

    @Nullable
    private TextView helperTextView;

    @Nullable
    private ColorStateList helperTextViewTextColor;
    private LinearLayout indicatorArea;
    private int indicatorsAdded;

    @NonNull
    private final TextInputLayout textInputView;
    private Typeface typeface;

    public IndicatorViewController(@NonNull TextInputLayout r10) {
        Context r11 = r10.getContext();
        this.context = r11;
        this.textInputView = r10;
        this.captionTranslationYPx = r11.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
    }

    public static /* synthetic */ int access$002(IndicatorViewController r10, int r11) {
        r10.captionDisplayed = r11;
        return r11;
    }

    public static /* synthetic */ Animator access$102(IndicatorViewController r10, Animator r11) {
        r10.captionAnimator = r11;
        return r11;
    }

    public static /* synthetic */ TextView access$200(IndicatorViewController r10) {
        return r10.errorView;
    }

    private boolean canAdjustIndicatorPadding() {
        if (this.indicatorArea != null) goto L5;
    L7:
        return false;
    L5:
        if (this.textInputView.getEditText() == null) goto L7;
        return true;
    }

    private void createCaptionAnimators(@NonNull List<Animator> r10, boolean r11, @Nullable TextView r12, int r13, int r14, int r15) {
        if (r12 == null) goto L14;
        if (r11 == false) goto L17;
        if (r13 == r15) goto L7;
        if (r13 == r14) goto L7;
        return;
    L7:
        if (r15 != r13) goto L9;
        boolean r16 = true;
    L10:
        r10.add(createCaptionOpacityAnimator(r12, r16));
        if (r15 != r13) goto L16;
        r10.add(createCaptionTranslationYAnimator(r12));
        return;
    L16:
        return;
    L9:
        r16 = false;
        goto L10
    L17:
        return;
    }

    private ObjectAnimator createCaptionOpacityAnimator(TextView r10, boolean r11) {
        if (r11 == false) goto L4;
        float r12 = 1.0f;
    L5:
        ObjectAnimator r13 = ObjectAnimator.ofFloat(r10, View.ALPHA, new float[]{r12});
        r13.setDuration(167);
        r13.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        return r13;
    L4:
        r12 = 0.0f;
        goto L5
    }

    private ObjectAnimator createCaptionTranslationYAnimator(TextView r10) {
        ObjectAnimator r11 = ObjectAnimator.ofFloat(r10, View.TRANSLATION_Y, new float[]{-this.captionTranslationYPx, 0.0f});
        r11.setDuration(217);
        r11.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        return r11;
    }

    @Nullable
    private TextView getCaptionViewFromDisplayState(int r10) {
        if (r10 == 1) goto L11;
        if (r10 == 2) goto L9;
        return null;
    L9:
        return this.helperTextView;
    L11:
        return this.errorView;
    }

    private int getIndicatorPadding(boolean r10, @DimenRes int r11, int r12) {
        if (r10 == true) goto L4;
        return r12;
    L4:
        return this.context.getResources().getDimensionPixelSize(r11);
    }

    private boolean isCaptionStateError(int r10) {
        if (r10 == 1) goto L5;
    L9:
        return false;
    L5:
        if (this.errorView == null) goto L9;
        if (TextUtils.isEmpty(this.errorText) == true) goto L9;
        return true;
    }

    private boolean isCaptionStateHelperText(int r10) {
        if (r10 == 2) goto L5;
    L9:
        return false;
    L5:
        if (this.helperTextView == null) goto L9;
        if (TextUtils.isEmpty(this.helperText) == true) goto L9;
        return true;
    }

    private void setCaptionViewVisibilities(int r10, int r11) {
        if (r10 != r11) goto L4;
        return;
    L4:
        if (r11 == 0) goto L8;
        TextView r12 = getCaptionViewFromDisplayState(r11);
        if (r12 == null) goto L8;
        r12.setVisibility(0);
        r12.setAlpha(1.0f);
    L8:
        if (r10 == 0) goto L14;
        TextView r13 = getCaptionViewFromDisplayState(r10);
        if (r13 == null) goto L14;
        r13.setVisibility(4);
        if (r10 != 1) goto L14;
        r13.setText(null);
    L14:
        this.captionDisplayed = r11;
    }

    private void setTextViewTypeface(@Nullable TextView r10, Typeface r11) {
        if (r10 == null) goto L5;
        r10.setTypeface(r11);
        return;
    }

    private void setViewGroupGoneIfEmpty(@NonNull ViewGroup r10, int r11) {
        if (r11 != 0) goto L5;
        r10.setVisibility(8);
        return;
    }

    private boolean shouldAnimateCaptionView(@Nullable TextView r10, @Nullable CharSequence r11) {
        if (ViewCompat.T(this.textInputView) == true) goto L5;
    L12:
        return false;
    L5:
        if (this.textInputView.isEnabled() == false) goto L12;
        if (this.captionToShow != this.captionDisplayed) goto L11;
        if (r10 == null) goto L11;
        if (TextUtils.equals(r10.getText(), r11) == true) goto L12;
    L11:
        return true;
    }

    private void updateCaptionViewsVisibility(final int r14, final int r15, boolean r16) {
        if (r14 != r15) goto L5;
        return;
    L5:
        if (r16 == false) goto L7;
        AnimatorSet r11 = new AnimatorSet();
        this.captionAnimator = r11;
        ArrayList r12 = new ArrayList();
        createCaptionAnimators(r12, this.helperTextEnabled, this.helperTextView, 2, r14, r15);
        createCaptionAnimators(r12, this.errorEnabled, this.errorView, 1, r14, r15);
        AnimatorSetCompat.playTogether(r11, r12);
        final TextView r10 = getCaptionViewFromDisplayState(r14);
        final TextView r13 = getCaptionViewFromDisplayState(r15);
        r11.addListener(new AnonymousClass1(this, r15, r10, r14, r13));
        r11.start();
    L8:
        this.textInputView.updateEditTextBackground();
        this.textInputView.updateLabelState(r16);
        this.textInputView.updateTextInputBoxState();
        return;
    L7:
        setCaptionViewVisibilities(r14, r15);
        goto L8
    }

    public void addIndicator(TextView r10, int r11) {
        if (this.indicatorArea != null) goto L10;
        if (this.captionArea != null) goto L10;
        LinearLayout r12 = new LinearLayout(this.context);
        this.indicatorArea = r12;
        r12.setOrientation(0);
        this.textInputView.addView(this.indicatorArea, -1, -2);
        this.captionArea = new FrameLayout(this.context);
        this.indicatorArea.addView(this.captionArea, new LinearLayout.LayoutParams(0, -2, 1.0f));
        if (this.textInputView.getEditText() == null) goto L10;
        adjustIndicatorPadding();
    L10:
        if (isCaptionView(r11) == false) goto L12;
        this.captionArea.setVisibility(0);
        this.captionArea.addView(r10);
    L13:
        this.indicatorArea.setVisibility(0);
        this.indicatorsAdded++;
        return;
    L12:
        this.indicatorArea.addView(r10, new LinearLayout.LayoutParams(-2, -2));
        goto L13
    }

    public void adjustIndicatorPadding() {
        if (canAdjustIndicatorPadding() == false) goto L6;
        EditText r10 = this.textInputView.getEditText();
        boolean r11 = MaterialResources.isFontScaleAtLeast1_3(this.context);
        LinearLayout r12 = this.indicatorArea;
        int r13 = R.dimen.material_helper_text_font_1_3_padding_horizontal;
        ViewCompat.D0(r12, getIndicatorPadding(r11, r13, ViewCompat.F(r10)), getIndicatorPadding(r11, R.dimen.material_helper_text_font_1_3_padding_top, this.context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top)), getIndicatorPadding(r11, r13, ViewCompat.E(r10)), 0);
        return;
    }

    public void cancelCaptionAnimator() {
        Animator r10 = this.captionAnimator;
        if (r10 == null) goto L6;
        r10.cancel();
        return;
    }

    public boolean errorIsDisplayed() {
        return isCaptionStateError(this.captionDisplayed);
    }

    public boolean errorShouldBeShown() {
        return isCaptionStateError(this.captionToShow);
    }

    @Nullable
    public CharSequence getErrorContentDescription() {
        return this.errorViewContentDescription;
    }

    @Nullable
    public CharSequence getErrorText() {
        return this.errorText;
    }

    @ColorInt
    public int getErrorViewCurrentTextColor() {
        TextView r10 = this.errorView;
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.getCurrentTextColor();
    }

    @Nullable
    public ColorStateList getErrorViewTextColors() {
        TextView r10 = this.errorView;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getTextColors();
    }

    public CharSequence getHelperText() {
        return this.helperText;
    }

    @Nullable
    public ColorStateList getHelperTextViewColors() {
        TextView r10 = this.helperTextView;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getTextColors();
    }

    @ColorInt
    public int getHelperTextViewCurrentTextColor() {
        TextView r10 = this.helperTextView;
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.getCurrentTextColor();
    }

    public boolean helperTextIsDisplayed() {
        return isCaptionStateHelperText(this.captionDisplayed);
    }

    public boolean helperTextShouldBeShown() {
        return isCaptionStateHelperText(this.captionToShow);
    }

    public void hideError() {
        this.errorText = null;
        cancelCaptionAnimator();
        if (this.captionDisplayed == 1) goto L5;
    L10:
        updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, shouldAnimateCaptionView(this.errorView, null));
        return;
    L5:
        if (this.helperTextEnabled == true) goto L7;
    L9:
        this.captionToShow = 0;
        goto L10
    L7:
        if (TextUtils.isEmpty(this.helperText) == true) goto L9;
        this.captionToShow = 2;
        goto L10
    }

    public void hideHelperText() {
        cancelCaptionAnimator();
        int r10 = this.captionDisplayed;
        if (r10 != 2) goto L5;
        this.captionToShow = 0;
    L5:
        updateCaptionViewsVisibility(r10, this.captionToShow, shouldAnimateCaptionView(this.helperTextView, null));
    }

    public boolean isCaptionView(int r10) {
        if (r10 == 0) goto L8;
        if (r10 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    public boolean isErrorEnabled() {
        return this.errorEnabled;
    }

    public boolean isHelperTextEnabled() {
        return this.helperTextEnabled;
    }

    public void removeIndicator(TextView r10, int r11) {
        if (this.indicatorArea != null) goto L6;
        return;
    L6:
        if (isCaptionView(r11) == false) goto L10;
        FrameLayout r12 = this.captionArea;
        if (r12 == null) goto L10;
        r12.removeView(r10);
    L11:
        int r13 = this.indicatorsAdded - 1;
        this.indicatorsAdded = r13;
        setViewGroupGoneIfEmpty(this.indicatorArea, r13);
        return;
    L10:
        this.indicatorArea.removeView(r10);
        goto L11
    }

    public void setErrorContentDescription(@Nullable CharSequence r10) {
        this.errorViewContentDescription = r10;
        TextView r11 = this.errorView;
        if (r11 == null) goto L6;
        r11.setContentDescription(r10);
        return;
    }

    public void setErrorEnabled(boolean r10) {
        if (this.errorEnabled != r10) goto L5;
        return;
    L5:
        cancelCaptionAnimator();
        if (r10 == false) goto L11;
        AppCompatTextView r11 = new AppCompatTextView(this.context);
        this.errorView = r11;
        r11.setId(R.id.textinput_error);
        this.errorView.setTextAlignment(5);
        Typeface r12 = this.typeface;
        if (r12 == null) goto L10;
        this.errorView.setTypeface(r12);
    L10:
        setErrorTextAppearance(this.errorTextAppearance);
        setErrorViewTextColor(this.errorViewTextColor);
        setErrorContentDescription(this.errorViewContentDescription);
        this.errorView.setVisibility(4);
        ViewCompat.r0(this.errorView, 1);
        addIndicator(this.errorView, 0);
    L12:
        this.errorEnabled = r10;
        return;
    L11:
        hideError();
        removeIndicator(this.errorView, 0);
        this.errorView = null;
        this.textInputView.updateEditTextBackground();
        this.textInputView.updateTextInputBoxState();
        goto L12
    }

    public void setErrorTextAppearance(@StyleRes int r10) {
        this.errorTextAppearance = r10;
        TextView r11 = this.errorView;
        if (r11 == null) goto L6;
        this.textInputView.setTextAppearanceCompatWithErrorFallback(r11, r10);
        return;
    }

    public void setErrorViewTextColor(@Nullable ColorStateList r10) {
        this.errorViewTextColor = r10;
        TextView r11 = this.errorView;
        if (r11 == null) goto L7;
        if (r10 == null) goto L8;
        r11.setTextColor(r10);
        return;
    L8:
        return;
    }

    public void setHelperTextAppearance(@StyleRes int r10) {
        this.helperTextTextAppearance = r10;
        TextView r11 = this.helperTextView;
        if (r11 == null) goto L6;
        TextViewCompat.n(r11, r10);
        return;
    }

    public void setHelperTextEnabled(boolean r10) {
        if (this.helperTextEnabled != r10) goto L5;
        return;
    L5:
        cancelCaptionAnimator();
        if (r10 == false) goto L11;
        AppCompatTextView r11 = new AppCompatTextView(this.context);
        this.helperTextView = r11;
        r11.setId(R.id.textinput_helper_text);
        this.helperTextView.setTextAlignment(5);
        Typeface r12 = this.typeface;
        if (r12 == null) goto L10;
        this.helperTextView.setTypeface(r12);
    L10:
        this.helperTextView.setVisibility(4);
        ViewCompat.r0(this.helperTextView, 1);
        setHelperTextAppearance(this.helperTextTextAppearance);
        setHelperTextViewTextColor(this.helperTextViewTextColor);
        addIndicator(this.helperTextView, 1);
    L12:
        this.helperTextEnabled = r10;
        return;
    L11:
        hideHelperText();
        removeIndicator(this.helperTextView, 1);
        this.helperTextView = null;
        this.textInputView.updateEditTextBackground();
        this.textInputView.updateTextInputBoxState();
        goto L12
    }

    public void setHelperTextViewTextColor(@Nullable ColorStateList r10) {
        this.helperTextViewTextColor = r10;
        TextView r11 = this.helperTextView;
        if (r11 == null) goto L7;
        if (r10 == null) goto L8;
        r11.setTextColor(r10);
        return;
    L8:
        return;
    }

    public void setTypefaces(Typeface r10) {
        if (r10 == this.typeface) goto L6;
        this.typeface = r10;
        setTextViewTypeface(this.errorView, r10);
        setTextViewTypeface(this.helperTextView, r10);
        return;
    }

    public void showError(CharSequence r10) {
        cancelCaptionAnimator();
        this.errorText = r10;
        this.errorView.setText(r10);
        int r11 = this.captionDisplayed;
        if (r11 == 1) goto L5;
        this.captionToShow = 1;
    L5:
        updateCaptionViewsVisibility(r11, this.captionToShow, shouldAnimateCaptionView(this.errorView, r10));
    }

    public void showHelper(CharSequence r10) {
        cancelCaptionAnimator();
        this.helperText = r10;
        this.helperTextView.setText(r10);
        int r11 = this.captionDisplayed;
        if (r11 == 2) goto L5;
        this.captionToShow = 2;
    L5:
        updateCaptionViewsVisibility(r11, this.captionToShow, shouldAnimateCaptionView(this.helperTextView, r10));
    }
}
