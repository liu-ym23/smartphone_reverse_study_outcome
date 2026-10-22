package com.google.android.material.textfield;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.motion.MotionUtils;

/* JADX INFO: loaded from: classes2.dex */
class DropdownMenuEndIconDelegate extends EndIconDelegate {
    private static final int DEFAULT_ANIMATION_FADE_IN_DURATION = 67;
    private static final int DEFAULT_ANIMATION_FADE_OUT_DURATION = 50;
    private static final boolean IS_LOLLIPOP = false;
    private AccessibilityManager accessibilityManager;
    private final int animationFadeInDuration;
    private final TimeInterpolator animationFadeInterpolator;
    private final int animationFadeOutDuration;
    private AutoCompleteTextView autoCompleteTextView;
    private long dropdownPopupActivatedAt;
    private boolean dropdownPopupDirty;
    private boolean editTextHasFocus;
    private ValueAnimator fadeInAnim;
    private ValueAnimator fadeOutAnim;
    private boolean isEndIconChecked;
    private final View.OnFocusChangeListener onEditTextFocusChangeListener;
    private final View.OnClickListener onIconClickListener;
    private final AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener;

    @Override // com.google.android.material.textfield.EndIconDelegate
    boolean isBoxBackgroundModeSupported(int r1) {
        if (r1 == 0) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    boolean isIconActivable() {
        return true;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    boolean isIconCheckable() {
        return true;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    boolean shouldTintIconOnError() {
        return true;
    }

    static /* synthetic */ ValueAnimator access$000(DropdownMenuEndIconDelegate r0) {
        return r0.fadeInAnim;
    }

    static {
        IS_LOLLIPOP = true;
    }

    /* JADX INFO: renamed from: lambda$new$0$com-google-android-material-textfield-DropdownMenuEndIconDelegate, reason: not valid java name */
    /* synthetic */ void m278xd03fedd4(View r1) {
        showHideDropdown();
    }

    /* JADX INFO: renamed from: lambda$new$1$com-google-android-material-textfield-DropdownMenuEndIconDelegate, reason: not valid java name */
    /* synthetic */ void m279xac016995(View r1, boolean r2) {
        this.editTextHasFocus = r2;
        refreshIconState();
        if (r2 == true) goto L6;
        setEndIconChecked(false);
        this.dropdownPopupDirty = false;
        return;
    }

    /* JADX INFO: renamed from: lambda$new$2$com-google-android-material-textfield-DropdownMenuEndIconDelegate, reason: not valid java name */
    /* synthetic */ void m280x87c2e556(boolean r2) {
        AutoCompleteTextView r0 = this.autoCompleteTextView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (EditTextUtils.isEditable(r0) == true) goto L13;
        CheckableImageButton r1 = this.endIconView;
        if (r2 == false) goto L9;
        int r3 = 2;
    L10:
        ViewCompat.setImportantForAccessibility(r1, r3);
        return;
    L9:
        r3 = 1;
        goto L10
    }

    DropdownMenuEndIconDelegate(EndCompoundLayout r4) {
        super(r4);
        this.onIconClickListener = new DropdownMenuEndIconDelegate$$ExternalSyntheticLambda0(this);
        this.onEditTextFocusChangeListener = new DropdownMenuEndIconDelegate$$ExternalSyntheticLambda1(this);
        this.touchExplorationStateChangeListener = new DropdownMenuEndIconDelegate$$ExternalSyntheticLambda2(this);
        this.dropdownPopupActivatedAt = Long.MAX_VALUE;
        this.animationFadeInDuration = MotionUtils.resolveThemeDuration(r4.getContext(), R.attr.motionDurationShort3, 67);
        this.animationFadeOutDuration = MotionUtils.resolveThemeDuration(r4.getContext(), R.attr.motionDurationShort3, 50);
        this.animationFadeInterpolator = MotionUtils.resolveThemeInterpolator(r4.getContext(), R.attr.motionEasingLinearInterpolator, AnimationUtils.LINEAR_INTERPOLATOR);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void setUp() {
        initAnimators();
        this.accessibilityManager = (AccessibilityManager) this.context.getSystemService("accessibility");
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void tearDown() {
        AutoCompleteTextView r0 = this.autoCompleteTextView;
        if (r0 == null) goto L8;
        r0.setOnTouchListener(null);
        if (IS_LOLLIPOP == false) goto L9;
        this.autoCompleteTextView.setOnDismissListener(null);
        return;
    L9:
        return;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public AccessibilityManagerCompat.TouchExplorationStateChangeListener getTouchExplorationStateChangeListener() {
        return this.touchExplorationStateChangeListener;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    int getIconDrawableResId() {
        if (IS_LOLLIPOP == false) goto L6;
        return R.drawable.mtrl_dropdown_arrow;
    L6:
        return R.drawable.mtrl_ic_arrow_drop_down;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    int getIconContentDescriptionResId() {
        return R.string.exposed_dropdown_menu_content_description;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    boolean isIconChecked() {
        return this.isEndIconChecked;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    boolean isIconActivated() {
        return this.editTextHasFocus;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    View.OnClickListener getOnIconClickListener() {
        return this.onIconClickListener;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void onEditTextAttached(EditText r3) {
        this.autoCompleteTextView = castAutoCompleteTextViewOrThrow(r3);
        setUpDropdownShowHideBehavior();
        this.textInputLayout.setErrorIconDrawable(null);
        if (EditTextUtils.isEditable(r3) == false) goto L5;
    L7:
        this.textInputLayout.setEndIconVisible(true);
        return;
    L5:
        if (this.accessibilityManager.isTouchExplorationEnabled() == false) goto L7;
        ViewCompat.setImportantForAccessibility(this.endIconView, 2);
        goto L7
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void afterEditTextChanged(Editable r2) {
        if (this.accessibilityManager.isTouchExplorationEnabled() == true) goto L5;
    L9:
        this.autoCompleteTextView.post(new DropdownMenuEndIconDelegate$$ExternalSyntheticLambda4(this));
        return;
    L5:
        if (EditTextUtils.isEditable(this.autoCompleteTextView) == false) goto L9;
        if (this.endIconView.hasFocus() == true) goto L9;
        this.autoCompleteTextView.dismissDropDown();
        goto L9
    }

    /* JADX INFO: renamed from: lambda$afterEditTextChanged$3$com-google-android-material-textfield-DropdownMenuEndIconDelegate, reason: not valid java name */
    /* synthetic */ void m276xae660ff2() {
        boolean r0 = this.autoCompleteTextView.isPopupShowing();
        setEndIconChecked(r0);
        this.dropdownPopupDirty = r0;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    View.OnFocusChangeListener getOnEditTextFocusChangeListener() {
        return this.onEditTextFocusChangeListener;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void onInitializeAccessibilityNodeInfo(View r1, AccessibilityNodeInfoCompat r2) {
        if (EditTextUtils.isEditable(this.autoCompleteTextView) == true) goto L6;
        r2.setClassName(Spinner.class.getName());
    L6:
        if (r2.isShowingHintText() == false) goto L9;
        r2.setHintText(null);
        return;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void onPopulateAccessibilityEvent(View r3, AccessibilityEvent r4) {
        if (this.accessibilityManager.isEnabled() == true) goto L5;
        return;
    L5:
        if (EditTextUtils.isEditable(this.autoCompleteTextView) == false) goto L8;
        return;
    L8:
        if (r4.getEventType() == 32768) goto L10;
    L14:
        boolean r5 = false;
    L16:
        if (r4.getEventType() == 1) goto L18;
        if (r5 == true) goto L18;
        return;
    L18:
        showHideDropdown();
        updateDropdownPopupDirty();
        return;
    L10:
        if (this.isEndIconChecked == false) goto L14;
        if (this.autoCompleteTextView.isPopupShowing() == true) goto L14;
        r5 = true;
        goto L16
    }

    private void showHideDropdown() {
        if (this.autoCompleteTextView != null) goto L6;
        return;
    L6:
        if (isDropdownPopupActive() == false) goto L9;
        this.dropdownPopupDirty = false;
    L9:
        if (this.dropdownPopupDirty == false) goto L11;
        this.dropdownPopupDirty = false;
        return;
    L11:
        if (IS_LOLLIPOP == false) goto L13;
        setEndIconChecked(!this.isEndIconChecked);
    L15:
        if (this.isEndIconChecked == false) goto L17;
        this.autoCompleteTextView.requestFocus();
        this.autoCompleteTextView.showDropDown();
        return;
    L17:
        this.autoCompleteTextView.dismissDropDown();
        return;
    L13:
        this.isEndIconChecked = !this.isEndIconChecked;
        refreshIconState();
        goto L15
    }

    private void setUpDropdownShowHideBehavior() {
        this.autoCompleteTextView.setOnTouchListener(new DropdownMenuEndIconDelegate$$ExternalSyntheticLambda5(this));
        if (IS_LOLLIPOP == false) goto L5;
        this.autoCompleteTextView.setOnDismissListener(new DropdownMenuEndIconDelegate$$ExternalSyntheticLambda6(this));
    L5:
        this.autoCompleteTextView.setThreshold(0);
    }

    /* JADX INFO: renamed from: lambda$setUpDropdownShowHideBehavior$4$com-google-android-material-textfield-DropdownMenuEndIconDelegate, reason: not valid java name */
    /* synthetic */ boolean m281x5f2e2537(View r2, MotionEvent r3) {
        if (r3.getAction() == 1) goto L5;
    L8:
        return false;
    L5:
        if (isDropdownPopupActive() == false) goto L7;
        this.dropdownPopupDirty = false;
    L7:
        showHideDropdown();
        updateDropdownPopupDirty();
        goto L8
    }

    /* JADX INFO: renamed from: lambda$setUpDropdownShowHideBehavior$5$com-google-android-material-textfield-DropdownMenuEndIconDelegate, reason: not valid java name */
    /* synthetic */ void m282x3aefa0f8() {
        updateDropdownPopupDirty();
        setEndIconChecked(false);
    }

    private boolean isDropdownPopupActive() {
        long r0 = System.currentTimeMillis() - this.dropdownPopupActivatedAt;
        if (r0 >= 0) goto L5;
    L8:
        return true;
    L5:
        if (r0 > 300) goto L8;
        return false;
    }

    private static AutoCompleteTextView castAutoCompleteTextViewOrThrow(EditText r1) {
        if ((r1 instanceof AutoCompleteTextView) == false) goto L7;
        return (AutoCompleteTextView) r1;
    L7:
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private void updateDropdownPopupDirty() {
        this.dropdownPopupDirty = true;
        this.dropdownPopupActivatedAt = System.currentTimeMillis();
    }

    private void setEndIconChecked(boolean r2) {
        if (this.isEndIconChecked == r2) goto L6;
        this.isEndIconChecked = r2;
        this.fadeInAnim.cancel();
        this.fadeOutAnim.start();
        return;
    }

    private void initAnimators() {
        this.fadeInAnim = getAlphaAnimator(this.animationFadeInDuration, new float[]{0.0f, 1.0f});
        ValueAnimator r0 = getAlphaAnimator(this.animationFadeOutDuration, new float[]{1.0f, 0.0f});
        this.fadeOutAnim = r0;
        r0.addListener(new AnonymousClass1(this));
    }

    private ValueAnimator getAlphaAnimator(int r3, float... r4) {
        ValueAnimator r5 = ValueAnimator.ofFloat(r4);
        r5.setInterpolator(this.animationFadeInterpolator);
        r5.setDuration(r3);
        r5.addUpdateListener(new DropdownMenuEndIconDelegate$$ExternalSyntheticLambda3(this));
        return r5;
    }

    /* JADX INFO: renamed from: lambda$getAlphaAnimator$6$com-google-android-material-textfield-DropdownMenuEndIconDelegate, reason: not valid java name */
    /* synthetic */ void m277x6b943a83(ValueAnimator r1) {
        float r2 = ((Float) r1.getAnimatedValue()).floatValue();
        this.endIconView.setAlpha(r2);
    }
}
