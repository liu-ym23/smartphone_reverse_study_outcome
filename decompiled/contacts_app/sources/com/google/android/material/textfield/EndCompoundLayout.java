package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
class EndCompoundLayout extends LinearLayout {
    private final AccessibilityManager accessibilityManager;
    private EditText editText;
    private final TextWatcher editTextWatcher;
    private final LinkedHashSet<TextInputLayout.OnEndIconChangedListener> endIconChangedListeners;
    private final EndIconDelegates endIconDelegates;
    private final FrameLayout endIconFrame;
    private int endIconMinSize;
    private int endIconMode;
    private View.OnLongClickListener endIconOnLongClickListener;
    private ImageView.ScaleType endIconScaleType;
    private ColorStateList endIconTintList;
    private PorterDuff.Mode endIconTintMode;
    private final CheckableImageButton endIconView;
    private View.OnLongClickListener errorIconOnLongClickListener;
    private ColorStateList errorIconTintList;
    private PorterDuff.Mode errorIconTintMode;
    private final CheckableImageButton errorIconView;
    private boolean hintExpanded;
    private final TextInputLayout.OnEditTextAttachedListener onEditTextAttachedListener;
    private CharSequence suffixText;
    private final TextView suffixTextView;
    final TextInputLayout textInputLayout;
    private AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener;

    private static class EndIconDelegates {
        private final int customEndIconDrawableId;
        private final SparseArray<EndIconDelegate> delegates;
        private final EndCompoundLayout endLayout;
        private final int passwordIconDrawableId;

        static /* synthetic */ int access$500(EndIconDelegates r0) {
            return r0.customEndIconDrawableId;
        }

        EndIconDelegates(EndCompoundLayout r2, TintTypedArray r3) {
            this.delegates = new SparseArray();
            this.endLayout = r2;
            this.customEndIconDrawableId = r3.getResourceId(R.styleable.TextInputLayout_endIconDrawable, 0);
            this.passwordIconDrawableId = r3.getResourceId(R.styleable.TextInputLayout_passwordToggleDrawable, 0);
        }

        EndIconDelegate get(int r2) {
            EndIconDelegate r0 = this.delegates.get(r2);
            if (r0 != null) goto L6;
            EndIconDelegate r1 = create(r2);
            this.delegates.append(r2, r1);
            return r1;
        L6:
            return r0;
        }

        private EndIconDelegate create(int r3) {
            if (r3 == (-1)) goto L22;
            if (r3 == 0) goto L20;
            if (r3 == 1) goto L18;
            if (r3 == 2) goto L16;
            if (r3 != 3) goto L14;
            return new DropdownMenuEndIconDelegate(this.endLayout);
        L14:
            throw new IllegalArgumentException("Invalid end icon mode: " + r3);
        L16:
            return new ClearTextEndIconDelegate(this.endLayout);
        L18:
            return new PasswordToggleEndIconDelegate(this.endLayout, this.passwordIconDrawableId);
        L20:
            return new NoEndIconDelegate(this.endLayout);
        L22:
            return new CustomEndIconDelegate(this.endLayout);
        }
    }

    static /* synthetic */ EditText access$000(EndCompoundLayout r0) {
        return r0.editText;
    }

    static /* synthetic */ EditText access$002(EndCompoundLayout r0, EditText r1) {
        r0.editText = r1;
        return r1;
    }

    static /* synthetic */ TextWatcher access$100(EndCompoundLayout r0) {
        return r0.editTextWatcher;
    }

    static /* synthetic */ void access$200(EndCompoundLayout r0, EndIconDelegate r1) {
        r0.setOnFocusChangeListenersIfNeeded(r1);
    }

    static /* synthetic */ void access$300(EndCompoundLayout r0) {
        r0.addTouchExplorationStateChangeListenerIfNeeded();
    }

    static /* synthetic */ void access$400(EndCompoundLayout r0) {
        r0.removeTouchExplorationStateChangeListenerIfNeeded();
    }

    EndCompoundLayout(TextInputLayout r7, TintTypedArray r8) {
        super(r7.getContext());
        this.endIconMode = 0;
        this.endIconChangedListeners = new LinkedHashSet();
        this.editTextWatcher = new AnonymousClass1(this);
        TextInputLayout.OnEditTextAttachedListener r1 = new AnonymousClass2(this);
        this.onEditTextAttachedListener = r1;
        this.accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.textInputLayout = r7;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.END));
        FrameLayout r0 = new FrameLayout(getContext());
        this.endIconFrame = r0;
        r0.setVisibility(8);
        r0.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater r2 = LayoutInflater.from(getContext());
        CheckableImageButton r3 = createIconView(this, r2, R.id.text_input_error_icon);
        this.errorIconView = r3;
        CheckableImageButton r4 = createIconView(r0, r2, R.id.text_input_end_icon);
        this.endIconView = r4;
        this.endIconDelegates = new EndIconDelegates(this, r8);
        AppCompatTextView r5 = new AppCompatTextView(getContext());
        this.suffixTextView = r5;
        initErrorIconView(r8);
        initEndIconView(r8);
        initSuffixTextView(r8);
        r0.addView(r4);
        addView(r5);
        addView(r0);
        addView(r3);
        r7.addOnEditTextAttachedListener(r1);
        addOnAttachStateChangeListener(new AnonymousClass3(this));
    }

    private CheckableImageButton createIconView(ViewGroup r3, LayoutInflater r4, int r5) {
        CheckableImageButton r6 = (CheckableImageButton) r4.inflate(R.layout.design_text_input_end_icon, r3, false);
        r6.setId(r5);
        IconHelper.setCompatRippleBackgroundIfNeeded(r6);
        if (MaterialResources.isFontScaleAtLeast1_3(getContext()) == false) goto L5;
        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) r6.getLayoutParams(), 0);
    L5:
        return r6;
    }

    private void initErrorIconView(TintTypedArray r3) {
        if (r3.hasValue(R.styleable.TextInputLayout_errorIconTint) == false) goto L6;
        this.errorIconTintList = MaterialResources.getColorStateList(getContext(), r3, R.styleable.TextInputLayout_errorIconTint);
    L6:
        if (r3.hasValue(R.styleable.TextInputLayout_errorIconTintMode) == false) goto L9;
        this.errorIconTintMode = ViewUtils.parseTintMode(r3.getInt(R.styleable.TextInputLayout_errorIconTintMode, -1), null);
    L9:
        if (r3.hasValue(R.styleable.TextInputLayout_errorIconDrawable) == false) goto L11;
        setErrorIconDrawable(r3.getDrawable(R.styleable.TextInputLayout_errorIconDrawable));
    L11:
        this.errorIconView.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        ViewCompat.setImportantForAccessibility(this.errorIconView, 2);
        this.errorIconView.setClickable(false);
        this.errorIconView.setPressable(false);
        this.errorIconView.setFocusable(false);
    }

    private void initEndIconView(TintTypedArray r6) {
        if (r6.hasValue(R.styleable.TextInputLayout_passwordToggleEnabled) == true) goto L11;
        if (r6.hasValue(R.styleable.TextInputLayout_endIconTint) == false) goto L8;
        this.endIconTintList = MaterialResources.getColorStateList(getContext(), r6, R.styleable.TextInputLayout_endIconTint);
    L8:
        if (r6.hasValue(R.styleable.TextInputLayout_endIconTintMode) == false) goto L11;
        this.endIconTintMode = ViewUtils.parseTintMode(r6.getInt(R.styleable.TextInputLayout_endIconTintMode, -1), null);
    L11:
        if (r6.hasValue(R.styleable.TextInputLayout_endIconMode) == false) goto L17;
        setEndIconMode(r6.getInt(R.styleable.TextInputLayout_endIconMode, 0));
        if (r6.hasValue(R.styleable.TextInputLayout_endIconContentDescription) == false) goto L15;
        setEndIconContentDescription(r6.getText(R.styleable.TextInputLayout_endIconContentDescription));
    L15:
        setEndIconCheckable(r6.getBoolean(R.styleable.TextInputLayout_endIconCheckable, true));
    L25:
        setEndIconMinSize(r6.getDimensionPixelSize(R.styleable.TextInputLayout_endIconMinSize, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size)));
        if (r6.hasValue(R.styleable.TextInputLayout_endIconScaleType) == false) goto L29;
        setEndIconScaleType(IconHelper.convertScaleType(r6.getInt(R.styleable.TextInputLayout_endIconScaleType, -1)));
        return;
    L29:
        return;
    L17:
        if (r6.hasValue(R.styleable.TextInputLayout_passwordToggleEnabled) == false) goto L25;
        if (r6.hasValue(R.styleable.TextInputLayout_passwordToggleTint) == false) goto L22;
        this.endIconTintList = MaterialResources.getColorStateList(getContext(), r6, R.styleable.TextInputLayout_passwordToggleTint);
    L22:
        if (r6.hasValue(R.styleable.TextInputLayout_passwordToggleTintMode) == false) goto L24;
        this.endIconTintMode = ViewUtils.parseTintMode(r6.getInt(R.styleable.TextInputLayout_passwordToggleTintMode, -1), null);
    L24:
        setEndIconMode(r6.getBoolean(R.styleable.TextInputLayout_passwordToggleEnabled, false) ? 1 : 0);
        setEndIconContentDescription(r6.getText(R.styleable.TextInputLayout_passwordToggleContentDescription));
        goto L25
    }

    private void initSuffixTextView(TintTypedArray r5) {
        this.suffixTextView.setVisibility(8);
        this.suffixTextView.setId(R.id.textinput_suffix_text);
        this.suffixTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        ViewCompat.setAccessibilityLiveRegion(this.suffixTextView, 1);
        setSuffixTextAppearance(r5.getResourceId(R.styleable.TextInputLayout_suffixTextAppearance, 0));
        if (r5.hasValue(R.styleable.TextInputLayout_suffixTextColor) == false) goto L5;
        setSuffixTextColor(r5.getColorStateList(R.styleable.TextInputLayout_suffixTextColor));
    L5:
        setSuffixText(r5.getText(R.styleable.TextInputLayout_suffixText));
    }

    void setErrorIconDrawable(int r2) {
        if (r2 == 0) goto L4;
        Drawable r3 = AppCompatResources.getDrawable(getContext(), r2);
    L5:
        setErrorIconDrawable(r3);
        refreshErrorIconDrawableState();
        return;
    L4:
        r3 = null;
        goto L5
    }

    void setErrorIconDrawable(Drawable r3) {
        this.errorIconView.setImageDrawable(r3);
        updateErrorIconVisibility();
        IconHelper.applyIconTint(this.textInputLayout, this.errorIconView, this.errorIconTintList, this.errorIconTintMode);
    }

    Drawable getErrorIconDrawable() {
        return this.errorIconView.getDrawable();
    }

    void setErrorIconTintList(ColorStateList r3) {
        if (this.errorIconTintList == r3) goto L6;
        this.errorIconTintList = r3;
        IconHelper.applyIconTint(this.textInputLayout, this.errorIconView, r3, this.errorIconTintMode);
        return;
    }

    void setErrorIconTintMode(PorterDuff.Mode r3) {
        if (this.errorIconTintMode == r3) goto L6;
        this.errorIconTintMode = r3;
        IconHelper.applyIconTint(this.textInputLayout, this.errorIconView, this.errorIconTintList, r3);
        return;
    }

    void setErrorIconOnClickListener(View.OnClickListener r2) {
        IconHelper.setIconOnClickListener(this.errorIconView, r2, this.errorIconOnLongClickListener);
    }

    CheckableImageButton getEndIconView() {
        return this.endIconView;
    }

    EndIconDelegate getEndIconDelegate() {
        return this.endIconDelegates.get(this.endIconMode);
    }

    int getEndIconMode() {
        return this.endIconMode;
    }

    void setEndIconMode(int r5) {
        if (this.endIconMode != r5) goto L5;
        return;
    L5:
        tearDownDelegate(getEndIconDelegate());
        int r0 = this.endIconMode;
        this.endIconMode = r5;
        dispatchOnEndIconChanged(r0);
        if (r5 == 0) goto L8;
        boolean r1 = true;
    L9:
        setEndIconVisible(r1);
        EndIconDelegate r2 = getEndIconDelegate();
        setEndIconDrawable(getIconResId(r2));
        setEndIconContentDescription(r2.getIconContentDescriptionResId());
        setEndIconCheckable(r2.isIconCheckable());
        if (r2.isBoxBackgroundModeSupported(this.textInputLayout.getBoxBackgroundMode()) == false) goto L17;
        setUpDelegate(r2);
        setEndIconOnClickListener(r2.getOnIconClickListener());
        EditText r6 = this.editText;
        if (r6 == null) goto L14;
        r2.onEditTextAttached(r6);
        setOnFocusChangeListenersIfNeeded(r2);
    L14:
        IconHelper.applyIconTint(this.textInputLayout, this.endIconView, this.endIconTintList, this.endIconTintMode);
        refreshIconState(true);
        return;
    L17:
        throw new IllegalStateException("The current box background mode " + this.textInputLayout.getBoxBackgroundMode() + " is not supported by the end icon mode " + r5);
    L8:
        r1 = false;
        goto L9
    }

    void refreshIconState(boolean r5) {
        EndIconDelegate r0 = getEndIconDelegate();
        boolean r2 = true;
        if (r0.isIconCheckable() == false) goto L7;
        boolean r1 = this.endIconView.isChecked();
        if (r1 == r0.isIconChecked()) goto L7;
        this.endIconView.setChecked(!r1);
        boolean r3 = true;
    L9:
        if (r0.isIconActivable() == false) goto L13;
        boolean r4 = this.endIconView.isActivated();
        if (r4 == r0.isIconActivated()) goto L13;
        setEndIconActivated(!r4);
    L14:
        if (r5 == true) goto L16;
        if (r2 == true) goto L16;
        return;
    L16:
        refreshEndIconDrawableState();
        return;
    L13:
        r2 = r3;
    L7:
        r3 = false;
        goto L9
    }

    private void setUpDelegate(EndIconDelegate r1) {
        r1.setUp();
        this.touchExplorationStateChangeListener = r1.getTouchExplorationStateChangeListener();
        addTouchExplorationStateChangeListenerIfNeeded();
    }

    private void tearDownDelegate(EndIconDelegate r2) {
        removeTouchExplorationStateChangeListenerIfNeeded();
        this.touchExplorationStateChangeListener = null;
        r2.tearDown();
    }

    private void addTouchExplorationStateChangeListenerIfNeeded() {
        if (this.touchExplorationStateChangeListener != null) goto L5;
        return;
    L5:
        if (this.accessibilityManager != null) goto L7;
        return;
    L7:
        if (ViewCompat.isAttachedToWindow(this) == false) goto L12;
        AccessibilityManagerCompat.addTouchExplorationStateChangeListener(this.accessibilityManager, this.touchExplorationStateChangeListener);
        return;
    }

    private void removeTouchExplorationStateChangeListenerIfNeeded() {
        AccessibilityManagerCompat.TouchExplorationStateChangeListener r0 = this.touchExplorationStateChangeListener;
        if (r0 == null) goto L8;
        AccessibilityManager r1 = this.accessibilityManager;
        if (r1 == null) goto L9;
        AccessibilityManagerCompat.removeTouchExplorationStateChangeListener(r1, r0);
        return;
    L9:
        return;
    }

    private int getIconResId(EndIconDelegate r1) {
        int r0 = EndIconDelegates.access$500(this.endIconDelegates);
        if (r0 == 0) goto L5;
        return r0;
    L5:
        return r1.getIconDrawableResId();
    }

    void setEndIconOnClickListener(View.OnClickListener r2) {
        IconHelper.setIconOnClickListener(this.endIconView, r2, this.endIconOnLongClickListener);
    }

    void setEndIconOnLongClickListener(View.OnLongClickListener r1) {
        this.endIconOnLongClickListener = r1;
        IconHelper.setIconOnLongClickListener(this.endIconView, r1);
    }

    void setErrorIconOnLongClickListener(View.OnLongClickListener r1) {
        this.errorIconOnLongClickListener = r1;
        IconHelper.setIconOnLongClickListener(this.errorIconView, r1);
    }

    private void setOnFocusChangeListenersIfNeeded(EndIconDelegate r3) {
        if (this.editText != null) goto L6;
        return;
    L6:
        if (r3.getOnEditTextFocusChangeListener() == null) goto L9;
        this.editText.setOnFocusChangeListener(r3.getOnEditTextFocusChangeListener());
    L9:
        if (r3.getOnIconViewFocusChangeListener() == null) goto L12;
        this.endIconView.setOnFocusChangeListener(r3.getOnIconViewFocusChangeListener());
        return;
    }

    void refreshErrorIconDrawableState() {
        IconHelper.refreshIconDrawableState(this.textInputLayout, this.errorIconView, this.errorIconTintList);
    }

    void setEndIconVisible(boolean r2) {
        if (isEndIconVisible() == r2) goto L10;
        CheckableImageButton r0 = this.endIconView;
        if (r2 == false) goto L7;
        int r3 = 0;
    L8:
        r0.setVisibility(r3);
        updateEndLayoutVisibility();
        updateSuffixTextViewPadding();
        this.textInputLayout.updateDummyDrawables();
        return;
    L7:
        r3 = 8;
        goto L8
    }

    boolean isEndIconVisible() {
        if (this.endIconFrame.getVisibility() == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.endIconView.getVisibility() != 0) goto L7;
        return true;
    }

    void setEndIconActivated(boolean r1) {
        this.endIconView.setActivated(r1);
    }

    void refreshEndIconDrawableState() {
        IconHelper.refreshIconDrawableState(this.textInputLayout, this.endIconView, this.endIconTintList);
    }

    void setEndIconCheckable(boolean r1) {
        this.endIconView.setCheckable(r1);
    }

    boolean isEndIconCheckable() {
        return this.endIconView.isCheckable();
    }

    boolean isEndIconChecked() {
        if (hasEndIcon() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.endIconView.isChecked() == false) goto L7;
        return true;
    }

    void checkEndIcon() {
        this.endIconView.performClick();
        this.endIconView.jumpDrawablesToCurrentState();
    }

    void setEndIconDrawable(int r2) {
        if (r2 == 0) goto L4;
        Drawable r3 = AppCompatResources.getDrawable(getContext(), r2);
    L5:
        setEndIconDrawable(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    void setEndIconDrawable(Drawable r4) {
        this.endIconView.setImageDrawable(r4);
        if (r4 == null) goto L6;
        IconHelper.applyIconTint(this.textInputLayout, this.endIconView, this.endIconTintList, this.endIconTintMode);
        refreshEndIconDrawableState();
        return;
    }

    Drawable getEndIconDrawable() {
        return this.endIconView.getDrawable();
    }

    void setEndIconContentDescription(int r2) {
        if (r2 == 0) goto L4;
        CharSequence r3 = getResources().getText(r2);
    L5:
        setEndIconContentDescription(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    void setEndIconContentDescription(CharSequence r2) {
        if (getEndIconContentDescription() == r2) goto L6;
        this.endIconView.setContentDescription(r2);
        return;
    }

    CharSequence getEndIconContentDescription() {
        return this.endIconView.getContentDescription();
    }

    void setEndIconTintList(ColorStateList r3) {
        if (this.endIconTintList == r3) goto L6;
        this.endIconTintList = r3;
        IconHelper.applyIconTint(this.textInputLayout, this.endIconView, r3, this.endIconTintMode);
        return;
    }

    void setEndIconTintMode(PorterDuff.Mode r3) {
        if (this.endIconTintMode == r3) goto L6;
        this.endIconTintMode = r3;
        IconHelper.applyIconTint(this.textInputLayout, this.endIconView, this.endIconTintList, r3);
        return;
    }

    void setEndIconMinSize(int r2) {
        if (r2 < 0) goto L8;
        if (r2 == this.endIconMinSize) goto L9;
        this.endIconMinSize = r2;
        IconHelper.setIconMinSize(this.endIconView, r2);
        IconHelper.setIconMinSize(this.errorIconView, r2);
        return;
    L9:
        return;
    L8:
        throw new IllegalArgumentException("endIconSize cannot be less than 0");
    }

    int getEndIconMinSize() {
        return this.endIconMinSize;
    }

    void setEndIconScaleType(ImageView.ScaleType r2) {
        this.endIconScaleType = r2;
        IconHelper.setIconScaleType(this.endIconView, r2);
        IconHelper.setIconScaleType(this.errorIconView, r2);
    }

    ImageView.ScaleType getEndIconScaleType() {
        return this.endIconScaleType;
    }

    void addOnEndIconChangedListener(TextInputLayout.OnEndIconChangedListener r1) {
        this.endIconChangedListeners.add(r1);
    }

    void removeOnEndIconChangedListener(TextInputLayout.OnEndIconChangedListener r1) {
        this.endIconChangedListeners.remove(r1);
    }

    void clearOnEndIconChangedListeners() {
        this.endIconChangedListeners.clear();
    }

    boolean hasEndIcon() {
        if (this.endIconMode == 0) goto L5;
        return true;
    L5:
        return false;
    }

    TextView getSuffixTextView() {
        return this.suffixTextView;
    }

    void setSuffixText(CharSequence r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        CharSequence r0 = null;
    L6:
        this.suffixText = r0;
        this.suffixTextView.setText(r2);
        updateSuffixTextVisibility();
        return;
    L5:
        r0 = r2;
        goto L6
    }

    CharSequence getSuffixText() {
        return this.suffixText;
    }

    void setSuffixTextAppearance(int r1) {
        TextViewCompat.setTextAppearance(this.suffixTextView, r1);
    }

    void setSuffixTextColor(ColorStateList r1) {
        this.suffixTextView.setTextColor(r1);
    }

    ColorStateList getSuffixTextColor() {
        return this.suffixTextView.getTextColors();
    }

    void setPasswordVisibilityToggleDrawable(int r2) {
        if (r2 == 0) goto L4;
        Drawable r3 = AppCompatResources.getDrawable(getContext(), r2);
    L5:
        setPasswordVisibilityToggleDrawable(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    void setPasswordVisibilityToggleDrawable(Drawable r1) {
        this.endIconView.setImageDrawable(r1);
    }

    void setPasswordVisibilityToggleContentDescription(int r2) {
        if (r2 == 0) goto L4;
        CharSequence r3 = getResources().getText(r2);
    L5:
        setPasswordVisibilityToggleContentDescription(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    void setPasswordVisibilityToggleContentDescription(CharSequence r1) {
        this.endIconView.setContentDescription(r1);
    }

    Drawable getPasswordVisibilityToggleDrawable() {
        return this.endIconView.getDrawable();
    }

    CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.endIconView.getContentDescription();
    }

    boolean isPasswordVisibilityToggleEnabled() {
        if (this.endIconMode == 1) goto L7;
        return false;
    L7:
        return true;
    }

    void setPasswordVisibilityToggleEnabled(boolean r3) {
        if (r3 == true) goto L4;
    L6:
        if (r3 == true) goto L10;
        setEndIconMode(0);
        return;
    L10:
        return;
    L4:
        if (this.endIconMode == 1) goto L6;
        setEndIconMode(1);
    }

    void setPasswordVisibilityToggleTintList(ColorStateList r3) {
        this.endIconTintList = r3;
        IconHelper.applyIconTint(this.textInputLayout, this.endIconView, r3, this.endIconTintMode);
    }

    void setPasswordVisibilityToggleTintMode(PorterDuff.Mode r3) {
        this.endIconTintMode = r3;
        IconHelper.applyIconTint(this.textInputLayout, this.endIconView, this.endIconTintList, r3);
    }

    void togglePasswordVisibilityToggle(boolean r3) {
        if (this.endIconMode != 1) goto L8;
        this.endIconView.performClick();
        if (r3 == false) goto L9;
        this.endIconView.jumpDrawablesToCurrentState();
        return;
    L9:
        return;
    }

    void onHintStateChanged(boolean r1) {
        this.hintExpanded = r1;
        updateSuffixTextVisibility();
    }

    void onTextInputBoxStateUpdated() {
        updateErrorIconVisibility();
        refreshErrorIconDrawableState();
        refreshEndIconDrawableState();
        if (getEndIconDelegate().shouldTintIconOnError() == false) goto L6;
        tintEndIconOnError(this.textInputLayout.shouldShowError());
        return;
    }

    private void updateSuffixTextVisibility() {
        int r0 = this.suffixTextView.getVisibility();
        boolean r2 = false;
        if (this.suffixText != null) goto L5;
    L7:
        int r1 = 8;
    L8:
        if (r0 == r1) goto L13;
        EndIconDelegate r3 = getEndIconDelegate();
        if (r1 != 0) goto L12;
        r2 = true;
    L12:
        r3.onSuffixVisibilityChanged(r2);
    L13:
        updateEndLayoutVisibility();
        this.suffixTextView.setVisibility(r1);
        this.textInputLayout.updateDummyDrawables();
        return;
    L5:
        if (this.hintExpanded == true) goto L7;
        r1 = 0;
        goto L8
    }

    void updateSuffixTextViewPadding() {
        if (this.textInputLayout.editText != null) goto L6;
        return;
    L6:
        if (isEndIconVisible() == false) goto L8;
    L11:
        int r0 = 0;
    L12:
        ViewCompat.setPaddingRelative(this.suffixTextView, getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.textInputLayout.editText.getPaddingTop(), r0, this.textInputLayout.editText.getPaddingBottom());
        return;
    L8:
        if (isErrorIconVisible() == true) goto L11;
        r0 = ViewCompat.getPaddingEnd(this.textInputLayout.editText);
        goto L12
    }

    CheckableImageButton getCurrentEndIconView() {
        if (isErrorIconVisible() == false) goto L7;
        return this.errorIconView;
    L7:
        if (hasEndIcon() == true) goto L9;
        return null;
    L9:
        if (isEndIconVisible() == true) goto L11;
        return null;
    L11:
        return this.endIconView;
    }

    boolean isErrorIconVisible() {
        if (this.errorIconView.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void updateErrorIconVisibility() {
        int r1 = 0;
        if (getErrorIconDrawable() != null) goto L5;
    L9:
        boolean r0 = false;
    L10:
        CheckableImageButton r2 = this.errorIconView;
        if (r0 == true) goto L14;
        r1 = 8;
    L14:
        r2.setVisibility(r1);
        updateEndLayoutVisibility();
        updateSuffixTextViewPadding();
        if (hasEndIcon() == true) goto L18;
        this.textInputLayout.updateDummyDrawables();
        return;
    L18:
        return;
    L5:
        if (this.textInputLayout.isErrorEnabled() == false) goto L9;
        if (this.textInputLayout.shouldShowError() == false) goto L9;
        r0 = true;
        goto L10
    }

    private void updateEndLayoutVisibility() {
        FrameLayout r0 = this.endIconFrame;
        int r2 = 8;
        if (this.endIconView.getVisibility() == 0) goto L5;
    L7:
        int r1 = 8;
    L8:
        r0.setVisibility(r1);
        if (this.suffixText != null) goto L11;
    L13:
        char r3 = '\b';
    L15:
        if (isEndIconVisible() == false) goto L17;
    L21:
        boolean r4 = true;
    L22:
        if (r4 == false) goto L24;
        r2 = 0;
    L24:
        setVisibility(r2);
        return;
    L17:
        if (isErrorIconVisible() == true) goto L21;
        if (r3 == 0) goto L21;
        r4 = false;
        goto L22
    L11:
        if (this.hintExpanded == true) goto L13;
        r3 = 0;
        goto L15
    L5:
        if (isErrorIconVisible() == true) goto L7;
        r1 = 0;
        goto L8
    }

    private void dispatchOnEndIconChanged(int r4) {
        Iterator<TextInputLayout.OnEndIconChangedListener> r0 = this.endIconChangedListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onEndIconChanged(this.textInputLayout, r4);
        goto L4
    }

    private void tintEndIconOnError(boolean r3) {
        if (r3 == true) goto L4;
    L6:
        IconHelper.applyIconTint(this.textInputLayout, this.endIconView, this.endIconTintList, this.endIconTintMode);
        return;
    L4:
        if (getEndIconDrawable() == null) goto L6;
        Drawable r4 = DrawableCompat.wrap(getEndIconDrawable()).mutate();
        DrawableCompat.setTint(r4, this.textInputLayout.getErrorCurrentTextColors());
        this.endIconView.setImageDrawable(r4);
    }
}
