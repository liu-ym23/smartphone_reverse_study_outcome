package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextWatcher;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import c.a;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: loaded from: classes3.dex */
class DropdownMenuEndIconDelegate extends EndIconDelegate {
    private static final int ANIMATION_FADE_IN_DURATION = 67;
    private static final int ANIMATION_FADE_OUT_DURATION = 50;
    private static final boolean IS_LOLLIPOP = false;
    private final TextInputLayout.AccessibilityDelegate accessibilityDelegate;

    @Nullable
    private AccessibilityManager accessibilityManager;
    private final TextInputLayout.OnEditTextAttachedListener dropdownMenuOnEditTextAttachedListener;
    private long dropdownPopupActivatedAt;
    private boolean dropdownPopupDirty;

    @SuppressLint({"ClickableViewAccessibility"})
    private final TextInputLayout.OnEndIconChangedListener endIconChangedListener;
    private final TextWatcher exposedDropdownEndIconTextWatcher;
    private ValueAnimator fadeInAnim;
    private ValueAnimator fadeOutAnim;
    private StateListDrawable filledPopupBackground;
    private boolean isEndIconChecked;
    private final View.OnFocusChangeListener onFocusChangeListener;
    private MaterialShapeDrawable outlinedPopupBackground;

    static {
        IS_LOLLIPOP = true;
    }

    public DropdownMenuEndIconDelegate(@NonNull TextInputLayout r10) {
        super(r10);
        this.exposedDropdownEndIconTextWatcher = new AnonymousClass1(this);
        this.onFocusChangeListener = new AnonymousClass2(this);
        final TextInputLayout r11 = this.textInputLayout;
        this.accessibilityDelegate = new AnonymousClass3(this, r11);
        this.dropdownMenuOnEditTextAttachedListener = new AnonymousClass4(this);
        this.endIconChangedListener = new AnonymousClass5(this);
        this.dropdownPopupDirty = false;
        this.isEndIconChecked = false;
        this.dropdownPopupActivatedAt = Long.MAX_VALUE;
    }

    public static /* synthetic */ AutoCompleteTextView access$000(EditText r10) {
        return castAutoCompleteTextViewOrThrow(r10);
    }

    public static /* synthetic */ AccessibilityManager access$100(DropdownMenuEndIconDelegate r10) {
        return r10.accessibilityManager;
    }

    public static /* synthetic */ TextInputLayout.AccessibilityDelegate access$1000(DropdownMenuEndIconDelegate r10) {
        return r10.accessibilityDelegate;
    }

    public static /* synthetic */ View.OnFocusChangeListener access$1100(DropdownMenuEndIconDelegate r10) {
        return r10.onFocusChangeListener;
    }

    public static /* synthetic */ boolean access$1200() {
        return IS_LOLLIPOP;
    }

    public static /* synthetic */ boolean access$1300(DropdownMenuEndIconDelegate r10) {
        return r10.isDropdownPopupActive();
    }

    public static /* synthetic */ long access$1402(DropdownMenuEndIconDelegate r10, long r11) {
        r10.dropdownPopupActivatedAt = r11;
        return r11;
    }

    public static /* synthetic */ boolean access$1500(DropdownMenuEndIconDelegate r10) {
        return r10.isEndIconChecked;
    }

    public static /* synthetic */ ValueAnimator access$1600(DropdownMenuEndIconDelegate r10) {
        return r10.fadeInAnim;
    }

    public static /* synthetic */ boolean access$200(EditText r10) {
        return isEditable(r10);
    }

    public static /* synthetic */ void access$300(DropdownMenuEndIconDelegate r10, boolean r11) {
        r10.setEndIconChecked(r11);
    }

    public static /* synthetic */ boolean access$402(DropdownMenuEndIconDelegate r10, boolean r11) {
        r10.dropdownPopupDirty = r11;
        return r11;
    }

    public static /* synthetic */ void access$500(DropdownMenuEndIconDelegate r10, AutoCompleteTextView r11) {
        r10.showHideDropdown(r11);
    }

    public static /* synthetic */ void access$600(DropdownMenuEndIconDelegate r10, AutoCompleteTextView r11) {
        r10.setPopupBackground(r11);
    }

    public static /* synthetic */ void access$700(DropdownMenuEndIconDelegate r10, AutoCompleteTextView r11) {
        r10.addRippleEffect(r11);
    }

    public static /* synthetic */ void access$800(DropdownMenuEndIconDelegate r10, AutoCompleteTextView r11) {
        r10.setUpDropdownShowHideBehavior(r11);
    }

    public static /* synthetic */ TextWatcher access$900(DropdownMenuEndIconDelegate r10) {
        return r10.exposedDropdownEndIconTextWatcher;
    }

    private void addRippleEffect(@NonNull AutoCompleteTextView r10) {
        if (isEditable(r10) == false) goto L5;
        return;
    L5:
        int r11 = this.textInputLayout.getBoxBackgroundMode();
        MaterialShapeDrawable r12 = this.textInputLayout.getBoxBackground();
        int r13 = MaterialColors.getColor(r10, R.attr.colorControlHighlight);
        int[][] r14 = {new int[]{android.R.attr.state_pressed}, new int[0]};
        if (r11 != 2) goto L9;
        addRippleEffectOnOutlinedLayout(r10, r13, r14, r12);
        return;
    L9:
        if (r11 != 1) goto L13;
        addRippleEffectOnFilledLayout(r10, r13, r14, r12);
        return;
    }

    private void addRippleEffectOnFilledLayout(@NonNull AutoCompleteTextView r10, int r11, int[][] r12, @NonNull MaterialShapeDrawable r13) {
        int r14 = this.textInputLayout.getBoxBackgroundColor();
        int[] r15 = {MaterialColors.layer(r11, r14, 0.1f), r14};
        if (IS_LOLLIPOP == false) goto L5;
        ViewCompat.t0(r10, new RippleDrawable(new ColorStateList(r12, r15), r13, r13));
        return;
    L5:
        MaterialShapeDrawable r16 = new MaterialShapeDrawable(r13.getShapeAppearanceModel());
        r16.setFillColor(new ColorStateList(r12, r15));
        LayerDrawable r17 = new LayerDrawable(new Drawable[]{r13, r16});
        int r18 = ViewCompat.F(r10);
        int r19 = r10.getPaddingTop();
        int r20 = ViewCompat.E(r10);
        int r21 = r10.getPaddingBottom();
        ViewCompat.t0(r10, r17);
        ViewCompat.D0(r10, r18, r19, r20, r21);
    }

    private void addRippleEffectOnOutlinedLayout(@NonNull AutoCompleteTextView r10, int r11, int[][] r12, @NonNull MaterialShapeDrawable r13) {
        int r14 = MaterialColors.getColor(r10, R.attr.colorSurface);
        MaterialShapeDrawable r15 = new MaterialShapeDrawable(r13.getShapeAppearanceModel());
        int r16 = MaterialColors.layer(r11, r14, 0.1f);
        r15.setFillColor(new ColorStateList(r12, new int[]{r16, 0}));
        if (IS_LOLLIPOP == false) goto L5;
        r15.setTint(r14);
        ColorStateList r17 = new ColorStateList(r12, new int[]{r16, r14});
        MaterialShapeDrawable r18 = new MaterialShapeDrawable(r13.getShapeAppearanceModel());
        r18.setTint(-1);
        LayerDrawable r19 = new LayerDrawable(new Drawable[]{new RippleDrawable(r17, r15, r18), r13});
    L6:
        ViewCompat.t0(r10, r19);
        return;
    L5:
        r19 = new LayerDrawable(new Drawable[]{r15, r13});
        goto L6
    }

    @NonNull
    private static AutoCompleteTextView castAutoCompleteTextViewOrThrow(EditText r10) {
        if ((r10 instanceof AutoCompleteTextView) == false) goto L7;
        return (AutoCompleteTextView) r10;
    L7:
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private ValueAnimator getAlphaAnimator(int r10, float... r11) {
        ValueAnimator r12 = ValueAnimator.ofFloat(r11);
        r12.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        r12.setDuration(r10);
        r12.addUpdateListener(new AnonymousClass10(this));
        return r12;
    }

    private MaterialShapeDrawable getPopUpMaterialShapeDrawable(float r10, float r11, float r12, int r13) {
        ShapeAppearanceModel r14 = ShapeAppearanceModel.builder().setTopLeftCornerSize(r10).setTopRightCornerSize(r10).setBottomLeftCornerSize(r11).setBottomRightCornerSize(r11).build();
        MaterialShapeDrawable r15 = MaterialShapeDrawable.createWithElevationOverlay(this.context, r12);
        r15.setShapeAppearanceModel(r14);
        r15.setPadding(0, r13, 0, r13);
        return r15;
    }

    private void initAnimators() {
        this.fadeInAnim = getAlphaAnimator(67, new float[]{0.0f, 1.0f});
        ValueAnimator r10 = getAlphaAnimator(50, new float[]{1.0f, 0.0f});
        this.fadeOutAnim = r10;
        r10.addListener(new AnonymousClass9(this));
    }

    private boolean isDropdownPopupActive() {
        long r10 = System.currentTimeMillis() - this.dropdownPopupActivatedAt;
        if (r10 >= 0) goto L5;
    L8:
        return true;
    L5:
        if (r10 > 300) goto L8;
        return false;
    }

    private static boolean isEditable(@NonNull EditText r10) {
        if (r10.getKeyListener() == null) goto L5;
        return true;
    L5:
        return false;
    }

    private void setEndIconChecked(boolean r10) {
        if (this.isEndIconChecked == r10) goto L6;
        this.isEndIconChecked = r10;
        this.fadeInAnim.cancel();
        this.fadeOutAnim.start();
        return;
    }

    private void setPopupBackground(@NonNull AutoCompleteTextView r10) {
        if (IS_LOLLIPOP == false) goto L11;
        int r11 = this.textInputLayout.getBoxBackgroundMode();
        if (r11 != 2) goto L8;
        r10.setDropDownBackgroundDrawable(this.outlinedPopupBackground);
        return;
    L8:
        if (r11 != 1) goto L13;
        r10.setDropDownBackgroundDrawable(this.filledPopupBackground);
        return;
    L13:
        return;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void setUpDropdownShowHideBehavior(@NonNull final AutoCompleteTextView r10) {
        r10.setOnTouchListener(new AnonymousClass7(this, r10));
        r10.setOnFocusChangeListener(this.onFocusChangeListener);
        if (IS_LOLLIPOP == false) goto L6;
        r10.setOnDismissListener(new AnonymousClass8(this));
        return;
    }

    private void showHideDropdown(@Nullable AutoCompleteTextView r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (isDropdownPopupActive() == false) goto L8;
        this.dropdownPopupDirty = false;
    L8:
        if (this.dropdownPopupDirty == false) goto L10;
        this.dropdownPopupDirty = false;
        return;
    L10:
        if (IS_LOLLIPOP == false) goto L12;
        setEndIconChecked(!this.isEndIconChecked);
    L14:
        if (this.isEndIconChecked == false) goto L16;
        r10.requestFocus();
        r10.showDropDown();
        return;
    L16:
        r10.dismissDropDown();
        return;
    L12:
        this.isEndIconChecked = !this.isEndIconChecked;
        this.endIconView.toggle();
        goto L14
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void initialize() {
        float r10 = this.context.getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        float r11 = this.context.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int r12 = this.context.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        MaterialShapeDrawable r13 = getPopUpMaterialShapeDrawable(r10, r10, r11, r12);
        MaterialShapeDrawable r14 = getPopUpMaterialShapeDrawable(0.0f, r10, r11, r12);
        this.outlinedPopupBackground = r13;
        StateListDrawable r15 = new StateListDrawable();
        this.filledPopupBackground = r15;
        r15.addState(new int[]{android.R.attr.state_above_anchor}, r13);
        this.filledPopupBackground.addState(new int[0], r14);
        if (IS_LOLLIPOP == false) goto L5;
        int r16 = R.drawable.mtrl_dropdown_arrow;
    L6:
        this.textInputLayout.setEndIconDrawable(a.b(this.context, r16));
        TextInputLayout r17 = this.textInputLayout;
        r17.setEndIconContentDescription(r17.getResources().getText(R.string.exposed_dropdown_menu_content_description));
        this.textInputLayout.setEndIconOnClickListener(new AnonymousClass6(this));
        this.textInputLayout.addOnEditTextAttachedListener(this.dropdownMenuOnEditTextAttachedListener);
        this.textInputLayout.addOnEndIconChangedListener(this.endIconChangedListener);
        initAnimators();
        this.accessibilityManager = (AccessibilityManager) this.context.getSystemService("accessibility");
        return;
    L5:
        r16 = R.drawable.mtrl_ic_arrow_drop_down;
        goto L6
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public boolean isBoxBackgroundModeSupported(int r10) {
        if (r10 == 0) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public boolean shouldTintIconOnError() {
        return true;
    }
}
