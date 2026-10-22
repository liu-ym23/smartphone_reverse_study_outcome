package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.ttnet.org.chromium.net.NetError;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
public class TextInputLayout extends LinearLayout {
    public static final int BOX_BACKGROUND_FILLED = 1;
    public static final int BOX_BACKGROUND_NONE = 0;
    public static final int BOX_BACKGROUND_OUTLINE = 2;
    private static final int DEFAULT_PLACEHOLDER_FADE_DURATION = 87;
    private static final int DEF_STYLE_RES = 0;
    private static final int[][] EDIT_TEXT_BACKGROUND_RIPPLE_STATE = null;
    public static final int END_ICON_CLEAR_TEXT = 2;
    public static final int END_ICON_CUSTOM = -1;
    public static final int END_ICON_DROPDOWN_MENU = 3;
    public static final int END_ICON_NONE = 0;
    public static final int END_ICON_PASSWORD_TOGGLE = 1;
    private static final int INVALID_MAX_LENGTH = -1;
    private static final int LABEL_SCALE_ANIMATION_DURATION = 167;
    private static final String LOG_TAG = "TextInputLayout";
    private static final int NO_WIDTH = -1;
    private static final int PLACEHOLDER_START_DELAY = 67;
    private ValueAnimator animator;
    private boolean areCornerRadiiRtl;
    private MaterialShapeDrawable boxBackground;
    private boolean boxBackgroundApplied;
    private int boxBackgroundColor;
    private int boxBackgroundMode;
    private int boxCollapsedPaddingTopPx;
    private final int boxLabelCutoutPaddingPx;
    private int boxStrokeColor;
    private int boxStrokeWidthDefaultPx;
    private int boxStrokeWidthFocusedPx;
    private int boxStrokeWidthPx;
    private MaterialShapeDrawable boxUnderlineDefault;
    private MaterialShapeDrawable boxUnderlineFocused;
    final CollapsingTextHelper collapsingTextHelper;
    boolean counterEnabled;
    private int counterMaxLength;
    private int counterOverflowTextAppearance;
    private ColorStateList counterOverflowTextColor;
    private boolean counterOverflowed;
    private int counterTextAppearance;
    private ColorStateList counterTextColor;
    private TextView counterView;
    private int defaultFilledBackgroundColor;
    private ColorStateList defaultHintTextColor;
    private int defaultStrokeColor;
    private int disabledColor;
    private int disabledFilledBackgroundColor;
    EditText editText;
    private final LinkedHashSet<OnEditTextAttachedListener> editTextAttachedListeners;
    private Drawable endDummyDrawable;
    private int endDummyDrawableWidth;
    private final EndCompoundLayout endLayout;
    private boolean expandedHintEnabled;
    private StateListDrawable filledDropDownMenuBackground;
    private int focusedFilledBackgroundColor;
    private int focusedStrokeColor;
    private ColorStateList focusedTextColor;
    private CharSequence hint;
    private boolean hintAnimationEnabled;
    private boolean hintEnabled;
    private boolean hintExpanded;
    private int hoveredFilledBackgroundColor;
    private int hoveredStrokeColor;
    private boolean inDrawableStateChanged;
    private final IndicatorViewController indicatorViewController;
    private final FrameLayout inputFrame;
    private boolean isProvidingHint;
    private LengthCounter lengthCounter;
    private int maxEms;
    private int maxWidth;
    private int minEms;
    private int minWidth;
    private Drawable originalEditTextEndDrawable;
    private CharSequence originalHint;
    private MaterialShapeDrawable outlinedDropDownMenuBackground;
    private boolean placeholderEnabled;
    private Fade placeholderFadeIn;
    private Fade placeholderFadeOut;
    private CharSequence placeholderText;
    private int placeholderTextAppearance;
    private ColorStateList placeholderTextColor;
    private TextView placeholderTextView;
    private boolean restoringSavedState;
    private ShapeAppearanceModel shapeAppearanceModel;
    private Drawable startDummyDrawable;
    private int startDummyDrawableWidth;
    private final StartCompoundLayout startLayout;
    private ColorStateList strokeErrorColor;
    private final Rect tmpBoundsRect;
    private final Rect tmpRect;
    private final RectF tmpRectF;
    private Typeface typeface;

    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final TextInputLayout layout;

        public AccessibilityDelegate(TextInputLayout r1) {
            this.layout = r1;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r13, AccessibilityNodeInfoCompat r14) {
            super.onInitializeAccessibilityNodeInfo(r13, r14);
            EditText r0 = this.layout.getEditText();
            if (r0 == null) goto L5;
            CharSequence r1 = r0.getText();
        L6:
            CharSequence r2 = this.layout.getHint();
            CharSequence r3 = this.layout.getError();
            CharSequence r4 = this.layout.getPlaceholderText();
            int r5 = this.layout.getCounterMaxLength();
            CharSequence r6 = this.layout.getCounterOverflowDescription();
            boolean r7 = !TextUtils.isEmpty(r1);
            boolean r8 = !TextUtils.isEmpty(r2);
            boolean r9 = !this.layout.isHintExpanded();
            boolean r10 = !TextUtils.isEmpty(r3);
            if (r10 == false) goto L9;
        L12:
            boolean r11 = true;
        L13:
            if (r8 == false) goto L15;
            String r12 = r2.toString();
        L16:
            TextInputLayout.access$400(this.layout).setupAccessibilityNodeInfo(r14);
            if (r7 == false) goto L20;
            r14.setText(r1);
        L28:
            if (TextUtils.isEmpty(r12) == true) goto L30;
            r14.setHintText(r12);
            r14.setShowingHintText(!r7);
        L30:
            if (r1 != null) goto L32;
        L34:
            r5 = -1;
        L35:
            r14.setMaxTextLength(r5);
            if (r11 == false) goto L41;
            if (r10 == true) goto L40;
            r3 = r6;
        L40:
            r14.setError(r3);
        L41:
            View r15 = TextInputLayout.access$500(this.layout).getHelperTextView();
            if (r15 == null) goto L44;
            r14.setLabelFor(r15);
        L44:
            TextInputLayout.access$300(this.layout).getEndIconDelegate().onInitializeAccessibilityNodeInfo(r13, r14);
            return;
        L32:
            if (r1.length() != r5) goto L34;
        L20:
            if (TextUtils.isEmpty(r12) == true) goto L25;
            r14.setText(r12);
            if (r9 == false) goto L28;
            if (r4 == null) goto L28;
            r14.setText(r12 + ", " + r4);
            goto L28
        L25:
            if (r4 == null) goto L28;
            r14.setText(r4);
            goto L28
        L15:
            r12 = "";
            goto L16
        L9:
            if (TextUtils.isEmpty(r6) == false) goto L12;
            r11 = false;
            goto L13
        L5:
            r1 = null;
            goto L6
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View r1, AccessibilityEvent r2) {
            super.onPopulateAccessibilityEvent(r1, r2);
            TextInputLayout.access$300(this.layout).getEndIconDelegate().onPopulateAccessibilityEvent(r1, r2);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BoxBackgroundMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface EndIconMode {
    }

    public interface LengthCounter {
        int countLength(Editable r1);
    }

    public interface OnEditTextAttachedListener {
        void onEditTextAttached(TextInputLayout r1);
    }

    public interface OnEndIconChangedListener {
        void onEndIconChanged(TextInputLayout r1, int r2);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        CharSequence error;
        boolean isEndIconChecked;

        SavedState(Parcelable r1) {
            super(r1);
        }

        SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            this.error = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r1);
            boolean r3 = true;
            if (r1.readInt() == 1) goto L6;
            r3 = false;
        L6:
            this.isEndIconChecked = r3;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r2, int r3) {
            super.writeToParcel(r2, r3);
            TextUtils.writeToParcel(this.error, r2, r3);
            r2.writeInt(this.isEndIconChecked ? 1 : 0);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.error + "}";
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    static /* synthetic */ boolean access$000(TextInputLayout r0) {
        return r0.restoringSavedState;
    }

    static /* synthetic */ boolean access$100(TextInputLayout r0) {
        return r0.placeholderEnabled;
    }

    static /* synthetic */ void access$200(TextInputLayout r0, Editable r1) {
        r0.updatePlaceholderText(r1);
    }

    static /* synthetic */ EndCompoundLayout access$300(TextInputLayout r0) {
        return r0.endLayout;
    }

    static /* synthetic */ StartCompoundLayout access$400(TextInputLayout r0) {
        return r0.startLayout;
    }

    static /* synthetic */ IndicatorViewController access$500(TextInputLayout r0) {
        return r0.indicatorViewController;
    }

    static {
        DEF_STYLE_RES = R.style.Widget_Design_TextInputLayout;
        EDIT_TEXT_BACKGROUND_RIPPLE_STATE = new int[][]{new int[]{android.R.attr.state_pressed}, new int[0]};
    }

    static /* synthetic */ int lambda$new$0(Editable r0) {
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.length();
    }

    public TextInputLayout(Context r2) {
        this(r2, null);
    }

    public TextInputLayout(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.textInputStyle);
    }

    public TextInputLayout(Context r17, AttributeSet r18, int r19) {
        int r9 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r17, r18, r19, r9), r18, r19);
        this.minEms = -1;
        this.maxEms = -1;
        this.minWidth = -1;
        this.maxWidth = -1;
        this.indicatorViewController = new IndicatorViewController(this);
        this.lengthCounter = new TextInputLayout$$ExternalSyntheticLambda0();
        this.tmpRect = new Rect();
        this.tmpBoundsRect = new Rect();
        this.tmpRectF = new RectF();
        this.editTextAttachedListeners = new LinkedHashSet();
        CollapsingTextHelper r1 = new CollapsingTextHelper(this);
        this.collapsingTextHelper = r1;
        Context r11 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout r14 = new FrameLayout(r11);
        this.inputFrame = r14;
        r14.setAddStatesFromChildren(true);
        r1.setTextSizeInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        r1.setPositionInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        r1.setCollapsedTextGravity(8388659);
        TintTypedArray r2 = ThemeEnforcement.obtainTintedStyledAttributes(r11, r18, R.styleable.TextInputLayout, r19, r9, new int[]{R.styleable.TextInputLayout_counterTextAppearance, R.styleable.TextInputLayout_counterOverflowTextAppearance, R.styleable.TextInputLayout_errorTextAppearance, R.styleable.TextInputLayout_helperTextTextAppearance, R.styleable.TextInputLayout_hintTextAppearance});
        StartCompoundLayout r3 = new StartCompoundLayout(this, r2);
        this.startLayout = r3;
        this.hintEnabled = r2.getBoolean(R.styleable.TextInputLayout_hintEnabled, true);
        setHint(r2.getText(R.styleable.TextInputLayout_android_hint));
        this.hintAnimationEnabled = r2.getBoolean(R.styleable.TextInputLayout_hintAnimationEnabled, true);
        this.expandedHintEnabled = r2.getBoolean(R.styleable.TextInputLayout_expandedHintEnabled, true);
        if (r2.hasValue(R.styleable.TextInputLayout_android_minEms) == false) goto L6;
        setMinEms(r2.getInt(R.styleable.TextInputLayout_android_minEms, -1));
    L9:
        if (r2.hasValue(R.styleable.TextInputLayout_android_maxEms) == false) goto L12;
        setMaxEms(r2.getInt(R.styleable.TextInputLayout_android_maxEms, -1));
    L14:
        this.shapeAppearanceModel = ShapeAppearanceModel.builder(r11, r18, r19, r9).build();
        this.boxLabelCutoutPaddingPx = r11.getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.boxCollapsedPaddingTopPx = r2.getDimensionPixelOffset(R.styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.boxStrokeWidthDefaultPx = r2.getDimensionPixelSize(R.styleable.TextInputLayout_boxStrokeWidth, r11.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_default));
        this.boxStrokeWidthFocusedPx = r2.getDimensionPixelSize(R.styleable.TextInputLayout_boxStrokeWidthFocused, r11.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
        float r4 = r2.getDimension(R.styleable.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float r5 = r2.getDimension(R.styleable.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float r6 = r2.getDimension(R.styleable.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float r7 = r2.getDimension(R.styleable.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        ShapeAppearanceModel.Builder r8 = this.shapeAppearanceModel.toBuilder();
        if (r4 < 0.0f) goto L18;
        r8.setTopLeftCornerSize(r4);
    L18:
        if (r5 < 0.0f) goto L21;
        r8.setTopRightCornerSize(r5);
    L21:
        if (r6 < 0.0f) goto L24;
        r8.setBottomRightCornerSize(r6);
    L24:
        if (r7 < 0.0f) goto L26;
        r8.setBottomLeftCornerSize(r7);
    L26:
        this.shapeAppearanceModel = r8.build();
        ColorStateList r10 = MaterialResources.getColorStateList(r11, r2, R.styleable.TextInputLayout_boxBackgroundColor);
        if (r10 == null) goto L32;
        int r12 = r10.getDefaultColor();
        this.defaultFilledBackgroundColor = r12;
        this.boxBackgroundColor = r12;
        if (r10.isStateful() == false) goto L31;
        this.disabledFilledBackgroundColor = r10.getColorForState(new int[]{-16842910}, -1);
        this.focusedFilledBackgroundColor = r10.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        this.hoveredFilledBackgroundColor = r10.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
    L34:
        if (r2.hasValue(R.styleable.TextInputLayout_android_textColorHint) == false) goto L36;
        ColorStateList r13 = r2.getColorStateList(R.styleable.TextInputLayout_android_textColorHint);
        this.focusedTextColor = r13;
        this.defaultHintTextColor = r13;
    L36:
        ColorStateList r15 = MaterialResources.getColorStateList(r11, r2, R.styleable.TextInputLayout_boxStrokeColor);
        this.focusedStrokeColor = r2.getColor(R.styleable.TextInputLayout_boxStrokeColor, 0);
        this.defaultStrokeColor = ContextCompat.getColor(r11, R.color.mtrl_textinput_default_box_stroke_color);
        this.disabledColor = ContextCompat.getColor(r11, R.color.mtrl_textinput_disabled_color);
        this.hoveredStrokeColor = ContextCompat.getColor(r11, R.color.mtrl_textinput_hovered_box_stroke_color);
        if (r15 == null) goto L40;
        setBoxStrokeColorStateList(r15);
    L40:
        if (r2.hasValue(R.styleable.TextInputLayout_boxStrokeErrorColor) == false) goto L43;
        setBoxStrokeErrorColor(MaterialResources.getColorStateList(r11, r2, R.styleable.TextInputLayout_boxStrokeErrorColor));
    L43:
        if (r2.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, -1) == (-1)) goto L45;
        setHintTextAppearance(r2.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, 0));
    L45:
        int r16 = r2.getResourceId(R.styleable.TextInputLayout_errorTextAppearance, 0);
        CharSequence r20 = r2.getText(R.styleable.TextInputLayout_errorContentDescription);
        int r21 = r2.getInt(R.styleable.TextInputLayout_errorAccessibilityLiveRegion, 1);
        boolean r22 = r2.getBoolean(R.styleable.TextInputLayout_errorEnabled, false);
        int r23 = r2.getResourceId(R.styleable.TextInputLayout_helperTextTextAppearance, 0);
        boolean r24 = r2.getBoolean(R.styleable.TextInputLayout_helperTextEnabled, false);
        CharSequence r25 = r2.getText(R.styleable.TextInputLayout_helperText);
        int r110 = r2.getResourceId(R.styleable.TextInputLayout_placeholderTextAppearance, 0);
        CharSequence r111 = r2.getText(R.styleable.TextInputLayout_placeholderText);
        boolean r112 = r2.getBoolean(R.styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(r2.getInt(R.styleable.TextInputLayout_counterMaxLength, -1));
        this.counterTextAppearance = r2.getResourceId(R.styleable.TextInputLayout_counterTextAppearance, 0);
        this.counterOverflowTextAppearance = r2.getResourceId(R.styleable.TextInputLayout_counterOverflowTextAppearance, 0);
        setBoxBackgroundMode(r2.getInt(R.styleable.TextInputLayout_boxBackgroundMode, 0));
        setErrorContentDescription(r20);
        setErrorAccessibilityLiveRegion(r21);
        setCounterOverflowTextAppearance(this.counterOverflowTextAppearance);
        setHelperTextTextAppearance(r23);
        setErrorTextAppearance(r16);
        setCounterTextAppearance(this.counterTextAppearance);
        setPlaceholderText(r111);
        setPlaceholderTextAppearance(r110);
        if (r2.hasValue(R.styleable.TextInputLayout_errorTextColor) == false) goto L49;
        setErrorTextColor(r2.getColorStateList(R.styleable.TextInputLayout_errorTextColor));
    L49:
        if (r2.hasValue(R.styleable.TextInputLayout_helperTextTextColor) == false) goto L52;
        setHelperTextColor(r2.getColorStateList(R.styleable.TextInputLayout_helperTextTextColor));
    L52:
        if (r2.hasValue(R.styleable.TextInputLayout_hintTextColor) == false) goto L55;
        setHintTextColor(r2.getColorStateList(R.styleable.TextInputLayout_hintTextColor));
    L55:
        if (r2.hasValue(R.styleable.TextInputLayout_counterTextColor) == false) goto L58;
        setCounterTextColor(r2.getColorStateList(R.styleable.TextInputLayout_counterTextColor));
    L58:
        if (r2.hasValue(R.styleable.TextInputLayout_counterOverflowTextColor) == false) goto L61;
        setCounterOverflowTextColor(r2.getColorStateList(R.styleable.TextInputLayout_counterOverflowTextColor));
    L61:
        if (r2.hasValue(R.styleable.TextInputLayout_placeholderTextColor) == false) goto L63;
        setPlaceholderTextColor(r2.getColorStateList(R.styleable.TextInputLayout_placeholderTextColor));
    L63:
        EndCompoundLayout r26 = new EndCompoundLayout(this, r2);
        this.endLayout = r26;
        boolean r27 = r2.getBoolean(R.styleable.TextInputLayout_android_enabled, true);
        r2.recycle();
        ViewCompat.setImportantForAccessibility(this, 2);
        ViewCompat.setImportantForAutofill(this, 1);
        r14.addView(r3);
        r14.addView(r26);
        addView(r14);
        setEnabled(r27);
        setHelperTextEnabled(r24);
        setErrorEnabled(r22);
        setCounterEnabled(r112);
        setHelperText(r25);
        return;
    L31:
        this.focusedFilledBackgroundColor = this.defaultFilledBackgroundColor;
        ColorStateList r28 = AppCompatResources.getColorStateList(r11, R.color.mtrl_filled_background_color);
        this.disabledFilledBackgroundColor = r28.getColorForState(new int[]{-16842910}, -1);
        this.hoveredFilledBackgroundColor = r28.getColorForState(new int[]{android.R.attr.state_hovered}, -1);
        goto L34
    L32:
        this.boxBackgroundColor = 0;
        this.defaultFilledBackgroundColor = 0;
        this.disabledFilledBackgroundColor = 0;
        this.focusedFilledBackgroundColor = 0;
        this.hoveredFilledBackgroundColor = 0;
        goto L34
    L12:
        if (r2.hasValue(R.styleable.TextInputLayout_android_maxWidth) == false) goto L14;
        setMaxWidth(r2.getDimensionPixelSize(R.styleable.TextInputLayout_android_maxWidth, -1));
        goto L14
    L6:
        if (r2.hasValue(R.styleable.TextInputLayout_android_minWidth) == false) goto L9;
        setMinWidth(r2.getDimensionPixelSize(R.styleable.TextInputLayout_android_minWidth, -1));
        goto L9
    }

    @Override // android.view.ViewGroup
    public void addView(View r2, int r3, ViewGroup.LayoutParams r4) {
        if ((r2 instanceof EditText) == false) goto L5;
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(r4);
        r5.gravity = (r5.gravity & NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH) | 16;
        this.inputFrame.addView(r2, r5);
        this.inputFrame.setLayoutParams(r4);
        updateInputLayoutMargins();
        setEditText((EditText) r2);
        return;
    L5:
        super.addView(r2, r3, r4);
    }

    MaterialShapeDrawable getBoxBackground() {
        int r0 = this.boxBackgroundMode;
        if (r0 == 1) goto L10;
        if (r0 == 2) goto L10;
        throw new IllegalStateException();
    L10:
        return this.boxBackground;
    }

    public void setBoxBackgroundMode(int r2) {
        if (r2 != this.boxBackgroundMode) goto L5;
        return;
    L5:
        this.boxBackgroundMode = r2;
        if (this.editText == null) goto L9;
        onApplyBoxBackgroundMode();
        return;
    }

    public int getBoxBackgroundMode() {
        return this.boxBackgroundMode;
    }

    private void onApplyBoxBackgroundMode() {
        assignBoxBackgroundByMode();
        updateEditTextBoxBackgroundIfNeeded();
        updateTextInputBoxState();
        updateBoxCollapsedPaddingTop();
        adjustFilledEditTextPaddingForLargeFont();
        if (this.boxBackgroundMode == 0) goto L5;
        updateInputLayoutMargins();
    L5:
        setDropDownMenuBackgroundIfNeeded();
    }

    private void assignBoxBackgroundByMode() {
        int r0 = this.boxBackgroundMode;
        if (r0 != 0) goto L5;
        this.boxBackground = null;
        this.boxUnderlineDefault = null;
        this.boxUnderlineFocused = null;
        return;
    L5:
        if (r0 != 1) goto L7;
        this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
        this.boxUnderlineDefault = new MaterialShapeDrawable();
        this.boxUnderlineFocused = new MaterialShapeDrawable();
        return;
    L7:
        if (r0 != 2) goto L16;
        if (this.hintEnabled == true) goto L11;
    L13:
        this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
    L14:
        this.boxUnderlineDefault = null;
        this.boxUnderlineFocused = null;
        return;
    L11:
        if ((this.boxBackground instanceof CutoutDrawable) == true) goto L13;
        this.boxBackground = CutoutDrawable.create(this.shapeAppearanceModel);
        goto L14
    L16:
        throw new IllegalArgumentException(this.boxBackgroundMode + " is illegal; only @BoxBackgroundMode constants are supported.");
    }

    void updateEditTextBoxBackgroundIfNeeded() {
        EditText r0 = this.editText;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.boxBackground != null) goto L7;
        return;
    L7:
        if (this.boxBackgroundApplied == true) goto L11;
        if (r0.getBackground() == null) goto L11;
        return;
    L11:
        if (this.boxBackgroundMode == 0) goto L18;
        ViewCompat.setBackground(this.editText, getEditTextBoxBackground());
        this.boxBackgroundApplied = true;
        return;
    }

    private Drawable getEditTextBoxBackground() {
        EditText r0 = this.editText;
        if ((r0 instanceof AutoCompleteTextView) == false) goto L18;
        if (EditTextUtils.isEditable(r0) == true) goto L18;
        int r1 = MaterialColors.getColor(this.editText, R.attr.colorControlHighlight);
        int r2 = this.boxBackgroundMode;
        if (r2 != 2) goto L12;
        return getOutlinedBoxBackgroundWithRipple(getContext(), this.boxBackground, r1, EDIT_TEXT_BACKGROUND_RIPPLE_STATE);
    L12:
        if (r2 == 1) goto L14;
        return null;
    L14:
        return getFilledBoxBackgroundWithRipple(this.boxBackground, this.boxBackgroundColor, r1, EDIT_TEXT_BACKGROUND_RIPPLE_STATE);
    L18:
        return this.boxBackground;
    }

    private static Drawable getOutlinedBoxBackgroundWithRipple(Context r6, MaterialShapeDrawable r7, int r8, int[][] r9) {
        int r10 = MaterialColors.getColor(r6, R.attr.colorSurface, LOG_TAG);
        MaterialShapeDrawable r0 = new MaterialShapeDrawable(r7.getShapeAppearanceModel());
        int r11 = MaterialColors.layer(r8, r10, 0.1f);
        r0.setFillColor(new ColorStateList(r9, new int[]{r11, 0}));
        r0.setTint(r10);
        ColorStateList r12 = new ColorStateList(r9, new int[]{r11, r10});
        MaterialShapeDrawable r13 = new MaterialShapeDrawable(r7.getShapeAppearanceModel());
        r13.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(r12, r0, r13), r7});
    }

    private static Drawable getFilledBoxBackgroundWithRipple(MaterialShapeDrawable r2, int r3, int r4, int[][] r5) {
        return new RippleDrawable(new ColorStateList(r5, new int[]{MaterialColors.layer(r4, r3, 0.1f), r3}), r2, r2);
    }

    private void setDropDownMenuBackgroundIfNeeded() {
        EditText r0 = this.editText;
        if ((r0 instanceof AutoCompleteTextView) == true) goto L5;
        return;
    L5:
        AutoCompleteTextView r1 = (AutoCompleteTextView) r0;
        if (r1.getDropDownBackground() != null) goto L14;
        int r2 = this.boxBackgroundMode;
        if (r2 != 2) goto L11;
        r1.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
        return;
    L11:
        if (r2 != 1) goto L16;
        r1.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
        return;
    L16:
        return;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.outlinedDropDownMenuBackground != null) goto L6;
        this.outlinedDropDownMenuBackground = getDropDownMaterialShapeDrawable(true);
    L6:
        return this.outlinedDropDownMenuBackground;
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.filledDropDownMenuBackground != null) goto L6;
        StateListDrawable r0 = new StateListDrawable();
        this.filledDropDownMenuBackground = r0;
        r0.addState(new int[]{android.R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
        this.filledDropDownMenuBackground.addState(new int[0], getDropDownMaterialShapeDrawable(false));
    L6:
        return this.filledDropDownMenuBackground;
    }

    private MaterialShapeDrawable getDropDownMaterialShapeDrawable(boolean r5) {
        float r0 = getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        if (r5 == false) goto L5;
        float r6 = r0;
    L6:
        EditText r1 = this.editText;
        if ((r1 instanceof MaterialAutoCompleteTextView) == false) goto L9;
        float r2 = ((MaterialAutoCompleteTextView) r1).getPopupElevation();
    L10:
        int r3 = getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        ShapeAppearanceModel r7 = ShapeAppearanceModel.builder().setTopLeftCornerSize(r6).setTopRightCornerSize(r6).setBottomLeftCornerSize(r0).setBottomRightCornerSize(r0).build();
        MaterialShapeDrawable r4 = MaterialShapeDrawable.createWithElevationOverlay(getContext(), r2);
        r4.setShapeAppearanceModel(r7);
        r4.setPadding(0, r3, 0, r3);
        return r4;
    L9:
        r2 = getResources().getDimensionPixelOffset(R.dimen.m3_comp_outlined_autocomplete_menu_container_elevation);
        goto L10
    L5:
        r6 = 0.0f;
        goto L6
    }

    private void updateBoxCollapsedPaddingTop() {
        if (this.boxBackgroundMode == 1) goto L5;
        return;
    L5:
        if (MaterialResources.isFontScaleAtLeast2_0(getContext()) == false) goto L8;
        this.boxCollapsedPaddingTopPx = getResources().getDimensionPixelSize(R.dimen.material_font_2_0_box_collapsed_padding_top);
        return;
    L8:
        if (MaterialResources.isFontScaleAtLeast1_3(getContext()) == false) goto L13;
        this.boxCollapsedPaddingTopPx = getResources().getDimensionPixelSize(R.dimen.material_font_1_3_box_collapsed_padding_top);
        return;
    }

    private void adjustFilledEditTextPaddingForLargeFont() {
        if (this.editText != null) goto L5;
        return;
    L5:
        if (this.boxBackgroundMode == 1) goto L8;
        return;
    L8:
        if (MaterialResources.isFontScaleAtLeast2_0(getContext()) == false) goto L11;
        EditText r0 = this.editText;
        ViewCompat.setPaddingRelative(r0, ViewCompat.getPaddingStart(r0), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_top), ViewCompat.getPaddingEnd(this.editText), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_bottom));
        return;
    L11:
        if (MaterialResources.isFontScaleAtLeast1_3(getContext()) == false) goto L16;
        EditText r1 = this.editText;
        ViewCompat.setPaddingRelative(r1, ViewCompat.getPaddingStart(r1), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_top), ViewCompat.getPaddingEnd(this.editText), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_bottom));
        return;
    }

    public void setBoxCollapsedPaddingTop(int r1) {
        this.boxCollapsedPaddingTopPx = r1;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.boxCollapsedPaddingTopPx;
    }

    public void setBoxStrokeWidthResource(int r2) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(r2));
    }

    public void setBoxStrokeWidth(int r1) {
        this.boxStrokeWidthDefaultPx = r1;
        updateTextInputBoxState();
    }

    public int getBoxStrokeWidth() {
        return this.boxStrokeWidthDefaultPx;
    }

    public void setBoxStrokeWidthFocusedResource(int r2) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(r2));
    }

    public void setBoxStrokeWidthFocused(int r1) {
        this.boxStrokeWidthFocusedPx = r1;
        updateTextInputBoxState();
    }

    public int getBoxStrokeWidthFocused() {
        return this.boxStrokeWidthFocusedPx;
    }

    public void setBoxStrokeColor(int r2) {
        if (this.focusedStrokeColor == r2) goto L6;
        this.focusedStrokeColor = r2;
        updateTextInputBoxState();
        return;
    }

    public int getBoxStrokeColor() {
        return this.focusedStrokeColor;
    }

    public void setBoxStrokeColorStateList(ColorStateList r4) {
        if (r4.isStateful() == false) goto L6;
        this.defaultStrokeColor = r4.getDefaultColor();
        this.disabledColor = r4.getColorForState(new int[]{-16842910}, -1);
        this.hoveredStrokeColor = r4.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
        this.focusedStrokeColor = r4.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
    L8:
        updateTextInputBoxState();
        return;
    L6:
        if (this.focusedStrokeColor == r4.getDefaultColor()) goto L8;
        this.focusedStrokeColor = r4.getDefaultColor();
        goto L8
    }

    public void setBoxStrokeErrorColor(ColorStateList r2) {
        if (this.strokeErrorColor == r2) goto L6;
        this.strokeErrorColor = r2;
        updateTextInputBoxState();
        return;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.strokeErrorColor;
    }

    public void setBoxBackgroundColorResource(int r2) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), r2));
    }

    public void setBoxBackgroundColor(int r2) {
        if (this.boxBackgroundColor == r2) goto L6;
        this.boxBackgroundColor = r2;
        this.defaultFilledBackgroundColor = r2;
        this.focusedFilledBackgroundColor = r2;
        this.hoveredFilledBackgroundColor = r2;
        applyBoxAttributes();
        return;
    }

    public void setBoxBackgroundColorStateList(ColorStateList r4) {
        int r0 = r4.getDefaultColor();
        this.defaultFilledBackgroundColor = r0;
        this.boxBackgroundColor = r0;
        this.disabledFilledBackgroundColor = r4.getColorForState(new int[]{-16842910}, -1);
        this.focusedFilledBackgroundColor = r4.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        this.hoveredFilledBackgroundColor = r4.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
        applyBoxAttributes();
    }

    public int getBoxBackgroundColor() {
        return this.boxBackgroundColor;
    }

    public void setShapeAppearanceModel(ShapeAppearanceModel r2) {
        MaterialShapeDrawable r0 = this.boxBackground;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getShapeAppearanceModel() == r2) goto L9;
        this.shapeAppearanceModel = r2;
        applyBoxAttributes();
        return;
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    public void setBoxCornerFamily(int r3) {
        this.shapeAppearanceModel = this.shapeAppearanceModel.toBuilder().setTopLeftCorner(r3, this.shapeAppearanceModel.getTopLeftCornerSize()).setTopRightCorner(r3, this.shapeAppearanceModel.getTopRightCornerSize()).setBottomLeftCorner(r3, this.shapeAppearanceModel.getBottomLeftCornerSize()).setBottomRightCorner(r3, this.shapeAppearanceModel.getBottomRightCornerSize()).build();
        applyBoxAttributes();
    }

    public void setBoxCornerRadiiResources(int r2, int r3, int r4, int r5) {
        setBoxCornerRadii(getContext().getResources().getDimension(r2), getContext().getResources().getDimension(r3), getContext().getResources().getDimension(r5), getContext().getResources().getDimension(r4));
    }

    public void setBoxCornerRadii(float r3, float r4, float r5, float r6) {
        boolean r0 = ViewUtils.isLayoutRtl(this);
        this.areCornerRadiiRtl = r0;
        if (r0 == false) goto L5;
        float r1 = r4;
    L6:
        if (r0 == true) goto L9;
        r3 = r4;
    L9:
        if (r0 == false) goto L11;
        float r7 = r6;
    L12:
        if (r0 == true) goto L15;
        r5 = r6;
    L15:
        MaterialShapeDrawable r8 = this.boxBackground;
        if (r8 != null) goto L18;
    L25:
        this.shapeAppearanceModel = this.shapeAppearanceModel.toBuilder().setTopLeftCornerSize(r1).setTopRightCornerSize(r3).setBottomLeftCornerSize(r7).setBottomRightCornerSize(r5).build();
        applyBoxAttributes();
        return;
    L18:
        if (r8.getTopLeftCornerResolvedSize() != r1) goto L25;
        if (this.boxBackground.getTopRightCornerResolvedSize() != r3) goto L25;
        if (this.boxBackground.getBottomLeftCornerResolvedSize() != r7) goto L25;
        if (this.boxBackground.getBottomRightCornerResolvedSize() != r5) goto L25;
        return;
    L11:
        r7 = r5;
        goto L12
    L5:
        r1 = r3;
        goto L6
    }

    public float getBoxCornerRadiusTopStart() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L6;
        return this.shapeAppearanceModel.getTopRightCornerSize().getCornerSize(this.tmpRectF);
    L6:
        return this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.tmpRectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L6;
        return this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.tmpRectF);
    L6:
        return this.shapeAppearanceModel.getTopRightCornerSize().getCornerSize(this.tmpRectF);
    }

    public float getBoxCornerRadiusBottomEnd() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L6;
        return this.shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(this.tmpRectF);
    L6:
        return this.shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(this.tmpRectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L6;
        return this.shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(this.tmpRectF);
    L6:
        return this.shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(this.tmpRectF);
    }

    public void setTypeface(Typeface r2) {
        if (r2 == this.typeface) goto L8;
        this.typeface = r2;
        this.collapsingTextHelper.setTypefaces(r2);
        this.indicatorViewController.setTypefaces(r2);
        TextView r1 = this.counterView;
        if (r1 == null) goto L9;
        r1.setTypeface(r2);
        return;
    L9:
        return;
    }

    public Typeface getTypeface() {
        return this.typeface;
    }

    public void setLengthCounter(LengthCounter r1) {
        this.lengthCounter = r1;
    }

    public LengthCounter getLengthCounter() {
        return this.lengthCounter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure r5, int r6) {
        EditText r0 = this.editText;
        if (r0 != null) goto L6;
        super.dispatchProvideAutofillStructure(r5, r6);
        return;
    L6:
        int r2 = 0;
        if (this.originalHint == null) goto L14;
        boolean r1 = this.isProvidingHint;
        this.isProvidingHint = false;
        CharSequence r3 = r0.getHint();
        this.editText.setHint(this.originalHint);
        super.dispatchProvideAutofillStructure(r5, r6);     // Catch: Throwable -> L11
        this.editText.setHint(r3);
        this.isProvidingHint = r1;
        return;
    L11:
        th = move-exception;
        this.editText.setHint(r3);
        this.isProvidingHint = r1;
        throw th;
    L14:
        r5.setAutofillId(getAutofillId());
        onProvideAutofillStructure(r5, r6);
        onProvideAutofillVirtualStructure(r5, r6);
        r5.setChildCount(this.inputFrame.getChildCount());
    L16:
        if (r2 >= this.inputFrame.getChildCount()) goto L27;
        View r4 = this.inputFrame.getChildAt(r2);
        ViewStructure r7 = r5.newChild(r2);
        r4.dispatchProvideAutofillStructure(r7, r6);
        if (r4 != this.editText) goto L20;
        r7.setHint(getHint());
    L20:
        r2 = r2 + 1;
        goto L16
    }

    private void setEditText(EditText r5) {
        if (this.editText != null) goto L35;
        if (getEndIconMode() != 3) goto L7;
    L9:
        this.editText = r5;
        int r0 = this.minEms;
        if (r0 == (-1)) goto L12;
        setMinEms(r0);
    L13:
        int r1 = this.maxEms;
        if (r1 == (-1)) goto L16;
        setMaxEms(r1);
    L17:
        this.boxBackgroundApplied = false;
        onApplyBoxBackgroundMode();
        setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
        this.collapsingTextHelper.setTypefaces(this.editText.getTypeface());
        this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
        this.collapsingTextHelper.setExpandedLetterSpacing(this.editText.getLetterSpacing());
        int r2 = this.editText.getGravity();
        this.collapsingTextHelper.setCollapsedTextGravity((r2 & NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH) | 48);
        this.collapsingTextHelper.setExpandedTextGravity(r2);
        this.editText.addTextChangedListener(new AnonymousClass1(this));
        if (this.defaultHintTextColor != null) goto L21;
        this.defaultHintTextColor = this.editText.getHintTextColors();
    L21:
        if (this.hintEnabled == false) goto L27;
        if (TextUtils.isEmpty(this.hint) == false) goto L25;
        CharSequence r3 = this.editText.getHint();
        this.originalHint = r3;
        setHint(r3);
        this.editText.setHint(null);
    L25:
        this.isProvidingHint = true;
    L27:
        if (this.counterView == null) goto L29;
        updateCounter(this.editText.getText());
    L29:
        updateEditTextBackground();
        this.indicatorViewController.adjustIndicatorPadding();
        this.startLayout.bringToFront();
        this.endLayout.bringToFront();
        dispatchOnEditTextAttached();
        this.endLayout.updateSuffixTextViewPadding();
        if (isEnabled() == true) goto L32;
        r5.setEnabled(false);
    L32:
        updateLabelState(false, true);
        return;
    L16:
        setMaxWidth(this.maxWidth);
        goto L17
    L12:
        setMinWidth(this.minWidth);
        goto L13
    L7:
        if ((r5 instanceof TextInputEditText) == true) goto L9;
        Log.i(LOG_TAG, "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        goto L9
    L35:
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void updateInputLayoutMargins() {
        if (this.boxBackgroundMode == 1) goto L8;
        LinearLayout.LayoutParams r0 = (LinearLayout.LayoutParams) this.inputFrame.getLayoutParams();
        int r1 = calculateLabelMarginTop();
        if (r1 == r0.topMargin) goto L9;
        r0.topMargin = r1;
        this.inputFrame.requestLayout();
        return;
    L9:
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText r0 = this.editText;
        if (r0 == null) goto L7;
        return (r0.getBaseline() + getPaddingTop()) + calculateLabelMarginTop();
    L7:
        return super.getBaseline();
    }

    void updateLabelState(boolean r2) {
        updateLabelState(r2, false);
    }

    private void updateLabelState(boolean r8, boolean r9) {
        boolean r0 = isEnabled();
        EditText r1 = this.editText;
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        EditText r4 = this.editText;
        if (r4 != null) goto L11;
    L13:
        boolean r5 = false;
    L14:
        ColorStateList r6 = this.defaultHintTextColor;
        if (r6 == null) goto L17;
        this.collapsingTextHelper.setCollapsedAndExpandedTextColor(r6);
    L17:
        if (r0 == true) goto L24;
        ColorStateList r3 = this.defaultHintTextColor;
        if (r3 == null) goto L21;
        int r7 = r3.getColorForState(new int[]{-16842910}, this.disabledColor);
    L22:
        this.collapsingTextHelper.setCollapsedAndExpandedTextColor(ColorStateList.valueOf(r7));
    L35:
        if (r2 == false) goto L37;
    L46:
        if (r9 == false) goto L48;
    L49:
        collapseHint(r8);
        return;
    L48:
        if (this.hintExpanded == true) goto L49;
        return;
    L37:
        if (this.expandedHintEnabled == false) goto L46;
        if (isEnabled() == false) goto L42;
        if (r5 == true) goto L46;
    L42:
        if (r9 == false) goto L44;
    L45:
        expandHint(r8);
        return;
    L44:
        if (this.hintExpanded == false) goto L45;
        return;
    L21:
        r7 = this.disabledColor;
        goto L22
    L24:
        if (shouldShowError() == false) goto L27;
        this.collapsingTextHelper.setCollapsedAndExpandedTextColor(this.indicatorViewController.getErrorViewTextColors());
        goto L35
    L27:
        if (this.counterOverflowed == false) goto L31;
        TextView r10 = this.counterView;
        if (r10 == null) goto L31;
        this.collapsingTextHelper.setCollapsedAndExpandedTextColor(r10.getTextColors());
    L31:
        if (r5 == false) goto L35;
        ColorStateList r11 = this.focusedTextColor;
        if (r11 == null) goto L35;
        this.collapsingTextHelper.setCollapsedTextColor(r11);
        goto L35
    L11:
        if (r4.hasFocus() == false) goto L13;
        r5 = true;
        goto L14
    L5:
        if (TextUtils.isEmpty(r1.getText()) == true) goto L7;
        r2 = true;
        goto L8
    }

    public EditText getEditText() {
        return this.editText;
    }

    public void setMinEms(int r2) {
        this.minEms = r2;
        EditText r1 = this.editText;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r2 == (-1)) goto L9;
        r1.setMinEms(r2);
        return;
    }

    public int getMinEms() {
        return this.minEms;
    }

    public void setMaxEms(int r2) {
        this.maxEms = r2;
        EditText r1 = this.editText;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r2 == (-1)) goto L9;
        r1.setMaxEms(r2);
        return;
    }

    public int getMaxEms() {
        return this.maxEms;
    }

    public void setMinWidth(int r2) {
        this.minWidth = r2;
        EditText r1 = this.editText;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r2 == (-1)) goto L9;
        r1.setMinWidth(r2);
        return;
    }

    public void setMinWidthResource(int r2) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(r2));
    }

    public int getMinWidth() {
        return this.minWidth;
    }

    public void setMaxWidth(int r2) {
        this.maxWidth = r2;
        EditText r1 = this.editText;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r2 == (-1)) goto L9;
        r1.setMaxWidth(r2);
        return;
    }

    public void setMaxWidthResource(int r2) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(r2));
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public void setHint(CharSequence r2) {
        if (this.hintEnabled == false) goto L6;
        setHintInternal(r2);
        sendAccessibilityEvent(2048);
        return;
    }

    public void setHint(int r2) {
        if (r2 == 0) goto L4;
        CharSequence r3 = getResources().getText(r2);
    L5:
        setHint(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    private void setHintInternal(CharSequence r2) {
        if (TextUtils.equals(r2, this.hint) == true) goto L8;
        this.hint = r2;
        this.collapsingTextHelper.setText(r2);
        if (this.hintExpanded == true) goto L9;
        openCutout();
        return;
    L9:
        return;
    }

    public CharSequence getHint() {
        if (this.hintEnabled == true) goto L7;
        return null;
    L7:
        return this.hint;
    }

    public void setHintEnabled(boolean r3) {
        if (r3 == this.hintEnabled) goto L23;
        this.hintEnabled = r3;
        if (r3 == true) goto L12;
        this.isProvidingHint = false;
        if (TextUtils.isEmpty(this.hint) == false) goto L9;
    L11:
        setHintInternal(null);
    L20:
        if (this.editText == null) goto L24;
        updateInputLayoutMargins();
        return;
    L24:
        return;
    L9:
        if (TextUtils.isEmpty(this.editText.getHint()) == false) goto L11;
        this.editText.setHint(this.hint);
        goto L11
    L12:
        CharSequence r4 = this.editText.getHint();
        if (TextUtils.isEmpty(r4) == false) goto L15;
    L18:
        this.isProvidingHint = true;
        goto L20
    L15:
        if (TextUtils.isEmpty(this.hint) == false) goto L17;
        setHint(r4);
    L17:
        this.editText.setHint(null);
        goto L18
    }

    public boolean isHintEnabled() {
        return this.hintEnabled;
    }

    public boolean isProvidingHint() {
        return this.isProvidingHint;
    }

    public void setHintTextAppearance(int r2) {
        this.collapsingTextHelper.setCollapsedTextAppearance(r2);
        this.focusedTextColor = this.collapsingTextHelper.getCollapsedTextColor();
        if (this.editText == null) goto L6;
        updateLabelState(false);
        updateInputLayoutMargins();
        return;
    }

    public void setHintTextColor(ColorStateList r2) {
        if (this.focusedTextColor != r2) goto L5;
        return;
    L5:
        if (this.defaultHintTextColor != null) goto L7;
        this.collapsingTextHelper.setCollapsedTextColor(r2);
    L7:
        this.focusedTextColor = r2;
        if (this.editText == null) goto L12;
        updateLabelState(false);
        return;
    }

    public ColorStateList getHintTextColor() {
        return this.focusedTextColor;
    }

    public void setDefaultHintTextColor(ColorStateList r1) {
        this.defaultHintTextColor = r1;
        this.focusedTextColor = r1;
        if (this.editText == null) goto L6;
        updateLabelState(false);
        return;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.defaultHintTextColor;
    }

    public void setErrorEnabled(boolean r1) {
        this.indicatorViewController.setErrorEnabled(r1);
    }

    public void setErrorTextAppearance(int r1) {
        this.indicatorViewController.setErrorTextAppearance(r1);
    }

    public void setErrorTextColor(ColorStateList r1) {
        this.indicatorViewController.setErrorViewTextColor(r1);
    }

    public int getErrorCurrentTextColors() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    public void setHelperTextTextAppearance(int r1) {
        this.indicatorViewController.setHelperTextAppearance(r1);
    }

    public void setHelperTextColor(ColorStateList r1) {
        this.indicatorViewController.setHelperTextViewTextColor(r1);
    }

    public boolean isErrorEnabled() {
        return this.indicatorViewController.isErrorEnabled();
    }

    public void setHelperTextEnabled(boolean r1) {
        this.indicatorViewController.setHelperTextEnabled(r1);
    }

    public void setHelperText(CharSequence r2) {
        if (TextUtils.isEmpty(r2) == false) goto L8;
        if (isHelperTextEnabled() == false) goto L12;
        setHelperTextEnabled(false);
        return;
    L12:
        return;
    L8:
        if (isHelperTextEnabled() == true) goto L10;
        setHelperTextEnabled(true);
    L10:
        this.indicatorViewController.showHelper(r2);
    }

    public boolean isHelperTextEnabled() {
        return this.indicatorViewController.isHelperTextEnabled();
    }

    public int getHelperTextCurrentTextColor() {
        return this.indicatorViewController.getHelperTextViewCurrentTextColor();
    }

    public void setErrorContentDescription(CharSequence r1) {
        this.indicatorViewController.setErrorContentDescription(r1);
    }

    public CharSequence getErrorContentDescription() {
        return this.indicatorViewController.getErrorContentDescription();
    }

    public void setErrorAccessibilityLiveRegion(int r1) {
        this.indicatorViewController.setErrorAccessibilityLiveRegion(r1);
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.indicatorViewController.getErrorAccessibilityLiveRegion();
    }

    public void setError(CharSequence r2) {
        if (this.indicatorViewController.isErrorEnabled() == true) goto L9;
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return;
    L7:
        setErrorEnabled(true);
    L9:
        if (TextUtils.isEmpty(r2) == true) goto L11;
        this.indicatorViewController.showError(r2);
        return;
    L11:
        this.indicatorViewController.hideError();
    }

    public void setErrorIconDrawable(int r1) {
        this.endLayout.setErrorIconDrawable(r1);
    }

    public void setErrorIconDrawable(Drawable r1) {
        this.endLayout.setErrorIconDrawable(r1);
    }

    public Drawable getErrorIconDrawable() {
        return this.endLayout.getErrorIconDrawable();
    }

    public void setErrorIconTintList(ColorStateList r1) {
        this.endLayout.setErrorIconTintList(r1);
    }

    public void setErrorIconTintMode(PorterDuff.Mode r1) {
        this.endLayout.setErrorIconTintMode(r1);
    }

    public void setCounterEnabled(boolean r4) {
        if (this.counterEnabled != r4) goto L5;
        return;
    L5:
        if (r4 == false) goto L10;
        AppCompatTextView r1 = new AppCompatTextView(getContext());
        this.counterView = r1;
        r1.setId(R.id.textinput_counter);
        Typeface r2 = this.typeface;
        if (r2 == null) goto L9;
        this.counterView.setTypeface(r2);
    L9:
        this.counterView.setMaxLines(1);
        this.indicatorViewController.addIndicator(this.counterView, 2);
        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.counterView.getLayoutParams(), getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
        updateCounterTextAppearanceAndColor();
        updateCounter();
    L11:
        this.counterEnabled = r4;
        return;
    L10:
        this.indicatorViewController.removeIndicator(this.counterView, 2);
        this.counterView = null;
        goto L11
    }

    public void setCounterTextAppearance(int r2) {
        if (this.counterTextAppearance == r2) goto L6;
        this.counterTextAppearance = r2;
        updateCounterTextAppearanceAndColor();
        return;
    }

    public void setCounterTextColor(ColorStateList r2) {
        if (this.counterTextColor == r2) goto L6;
        this.counterTextColor = r2;
        updateCounterTextAppearanceAndColor();
        return;
    }

    public ColorStateList getCounterTextColor() {
        return this.counterTextColor;
    }

    public void setCounterOverflowTextAppearance(int r2) {
        if (this.counterOverflowTextAppearance == r2) goto L6;
        this.counterOverflowTextAppearance = r2;
        updateCounterTextAppearanceAndColor();
        return;
    }

    public void setCounterOverflowTextColor(ColorStateList r2) {
        if (this.counterOverflowTextColor == r2) goto L6;
        this.counterOverflowTextColor = r2;
        updateCounterTextAppearanceAndColor();
        return;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.counterOverflowTextColor;
    }

    public boolean isCounterEnabled() {
        return this.counterEnabled;
    }

    public void setCounterMaxLength(int r2) {
        if (this.counterMaxLength == r2) goto L11;
        if (r2 <= 0) goto L6;
        this.counterMaxLength = r2;
    L8:
        if (this.counterEnabled == false) goto L12;
        updateCounter();
        return;
    L12:
        return;
    L6:
        this.counterMaxLength = -1;
        goto L8
    }

    private void updateCounter() {
        if (this.counterView == null) goto L10;
        EditText r0 = this.editText;
        if (r0 != null) goto L7;
        Editable r1 = null;
    L8:
        updateCounter(r1);
        return;
    L7:
        r1 = r0.getText();
        goto L8
    }

    void updateCounter(Editable r9) {
        int r10 = this.lengthCounter.countLength(r9);
        boolean r0 = this.counterOverflowed;
        int r1 = this.counterMaxLength;
        if (r1 != (-1)) goto L6;
        this.counterView.setText(String.valueOf(r10));
        this.counterView.setContentDescription(null);
        this.counterOverflowed = false;
    L14:
        if (this.editText != null) goto L16;
        return;
    L16:
        if (r0 == this.counterOverflowed) goto L20;
        updateLabelState(false);
        updateTextInputBoxState();
        updateEditTextBackground();
        return;
    L20:
        return;
    L6:
        if (r10 <= r1) goto L8;
        boolean r2 = true;
    L9:
        this.counterOverflowed = r2;
        updateCounterContentDescription(getContext(), this.counterView, r10, this.counterMaxLength, this.counterOverflowed);
        if (r0 == this.counterOverflowed) goto L12;
        updateCounterTextAppearanceAndColor();
    L12:
        this.counterView.setText(BidiFormatter.getInstance().unicodeWrap(getContext().getString(R.string.character_counter_pattern, new Object[]{Integer.valueOf(r10), Integer.valueOf(this.counterMaxLength)})));
        goto L14
    L8:
        r2 = false;
        goto L9
    }

    private static void updateCounterContentDescription(Context r2, TextView r3, int r4, int r5, boolean r6) {
        if (r6 == false) goto L4;
        int r7 = R.string.character_counter_overflowed_content_description;
    L5:
        r3.setContentDescription(r2.getString(r7, new Object[]{Integer.valueOf(r4), Integer.valueOf(r5)}));
        return;
    L4:
        r7 = R.string.character_counter_content_description;
        goto L5
    }

    public void setPlaceholderText(CharSequence r4) {
        if (this.placeholderTextView != null) goto L6;
        AppCompatTextView r0 = new AppCompatTextView(getContext());
        this.placeholderTextView = r0;
        r0.setId(R.id.textinput_placeholder);
        ViewCompat.setImportantForAccessibility(this.placeholderTextView, 2);
        Fade r1 = createPlaceholderFadeTransition();
        this.placeholderFadeIn = r1;
        r1.setStartDelay(67);
        this.placeholderFadeOut = createPlaceholderFadeTransition();
        setPlaceholderTextAppearance(this.placeholderTextAppearance);
        setPlaceholderTextColor(this.placeholderTextColor);
    L6:
        if (TextUtils.isEmpty(r4) == false) goto L9;
        setPlaceholderTextEnabled(false);
    L12:
        updatePlaceholderText();
        return;
    L9:
        if (this.placeholderEnabled == true) goto L11;
        setPlaceholderTextEnabled(true);
    L11:
        this.placeholderText = r4;
        goto L12
    }

    public CharSequence getPlaceholderText() {
        if (this.placeholderEnabled == true) goto L7;
        return null;
    L7:
        return this.placeholderText;
    }

    private void setPlaceholderTextEnabled(boolean r2) {
        if (this.placeholderEnabled != r2) goto L5;
        return;
    L5:
        if (r2 == false) goto L7;
        addPlaceholderTextView();
    L8:
        this.placeholderEnabled = r2;
        return;
    L7:
        removePlaceholderTextView();
        this.placeholderTextView = null;
        goto L8
    }

    private Fade createPlaceholderFadeTransition() {
        Fade r0 = new Fade();
        r0.setDuration(MotionUtils.resolveThemeDuration(getContext(), R.attr.motionDurationShort2, 87));
        r0.setInterpolator(MotionUtils.resolveThemeInterpolator(getContext(), R.attr.motionEasingLinearInterpolator, AnimationUtils.LINEAR_INTERPOLATOR));
        return r0;
    }

    private void updatePlaceholderText() {
        EditText r0 = this.editText;
        if (r0 != null) goto L5;
        Editable r1 = null;
    L6:
        updatePlaceholderText(r1);
        return;
    L5:
        r1 = r0.getText();
        goto L6
    }

    private void updatePlaceholderText(Editable r2) {
        if (this.lengthCounter.countLength(r2) == 0) goto L5;
    L7:
        hidePlaceholderText();
        return;
    L5:
        if (this.hintExpanded == true) goto L7;
        showPlaceholderText();
    }

    private void showPlaceholderText() {
        if (this.placeholderTextView != null) goto L5;
        return;
    L5:
        if (this.placeholderEnabled == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.placeholderText) == true) goto L12;
        this.placeholderTextView.setText(this.placeholderText);
        TransitionManager.beginDelayedTransition(this.inputFrame, this.placeholderFadeIn);
        this.placeholderTextView.setVisibility(0);
        this.placeholderTextView.bringToFront();
        announceForAccessibility(this.placeholderText);
        return;
    }

    private void hidePlaceholderText() {
        TextView r0 = this.placeholderTextView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.placeholderEnabled == false) goto L9;
        r0.setText(null);
        TransitionManager.beginDelayedTransition(this.inputFrame, this.placeholderFadeOut);
        this.placeholderTextView.setVisibility(4);
        return;
    }

    private void addPlaceholderTextView() {
        TextView r0 = this.placeholderTextView;
        if (r0 == null) goto L6;
        this.inputFrame.addView(r0);
        this.placeholderTextView.setVisibility(0);
        return;
    }

    private void removePlaceholderTextView() {
        TextView r1 = this.placeholderTextView;
        if (r1 == null) goto L6;
        r1.setVisibility(8);
        return;
    }

    public void setPlaceholderTextColor(ColorStateList r2) {
        if (this.placeholderTextColor == r2) goto L9;
        this.placeholderTextColor = r2;
        TextView r1 = this.placeholderTextView;
        if (r1 == null) goto L10;
        if (r2 == null) goto L11;
        r1.setTextColor(r2);
        return;
    L11:
        return;
    L10:
        return;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.placeholderTextColor;
    }

    public void setPlaceholderTextAppearance(int r1) {
        this.placeholderTextAppearance = r1;
        TextView r0 = this.placeholderTextView;
        if (r0 == null) goto L6;
        TextViewCompat.setTextAppearance(r0, r1);
        return;
    }

    public int getPlaceholderTextAppearance() {
        return this.placeholderTextAppearance;
    }

    public void setPrefixText(CharSequence r1) {
        this.startLayout.setPrefixText(r1);
    }

    public CharSequence getPrefixText() {
        return this.startLayout.getPrefixText();
    }

    public TextView getPrefixTextView() {
        return this.startLayout.getPrefixTextView();
    }

    public void setPrefixTextColor(ColorStateList r1) {
        this.startLayout.setPrefixTextColor(r1);
    }

    public ColorStateList getPrefixTextColor() {
        return this.startLayout.getPrefixTextColor();
    }

    public void setPrefixTextAppearance(int r1) {
        this.startLayout.setPrefixTextAppearance(r1);
    }

    public void setSuffixText(CharSequence r1) {
        this.endLayout.setSuffixText(r1);
    }

    public CharSequence getSuffixText() {
        return this.endLayout.getSuffixText();
    }

    public TextView getSuffixTextView() {
        return this.endLayout.getSuffixTextView();
    }

    public void setSuffixTextColor(ColorStateList r1) {
        this.endLayout.setSuffixTextColor(r1);
    }

    public ColorStateList getSuffixTextColor() {
        return this.endLayout.getSuffixTextColor();
    }

    public void setSuffixTextAppearance(int r1) {
        this.endLayout.setSuffixTextAppearance(r1);
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        recursiveSetEnabled(this, r1);
        super.setEnabled(r1);
    }

    private static void recursiveSetEnabled(ViewGroup r4, boolean r5) {
        int r0 = r4.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        View r2 = r4.getChildAt(r1);
        r2.setEnabled(r5);
        if ((r2 instanceof ViewGroup) == false) goto L7;
        recursiveSetEnabled((ViewGroup) r2, r5);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    public int getCounterMaxLength() {
        return this.counterMaxLength;
    }

    CharSequence getCounterOverflowDescription() {
        if (this.counterEnabled == true) goto L5;
        return null;
    L5:
        if (this.counterOverflowed == false) goto L12;
        TextView r1 = this.counterView;
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.getContentDescription();
    L12:
        return null;
    }

    private void updateCounterTextAppearanceAndColor() {
        TextView r0 = this.counterView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.counterOverflowed == false) goto L7;
        int r1 = this.counterOverflowTextAppearance;
    L8:
        setTextAppearanceCompatWithErrorFallback(r0, r1);
        if (this.counterOverflowed == true) goto L14;
        ColorStateList r2 = this.counterTextColor;
        if (r2 == null) goto L14;
        this.counterView.setTextColor(r2);
    L14:
        if (this.counterOverflowed == false) goto L20;
        ColorStateList r3 = this.counterOverflowTextColor;
        if (r3 == null) goto L21;
        this.counterView.setTextColor(r3);
        return;
    L21:
        return;
    L20:
        return;
    L7:
        r1 = this.counterTextAppearance;
        goto L8
    }

    void setTextAppearanceCompatWithErrorFallback(TextView r3, int r4) {
        boolean r0 = true;
        TextViewCompat.setTextAppearance(r3, r4);     // Catch: Exception -> L11
        if (r3.getTextColors().getDefaultColor() == (-65281)) goto L8;
        r0 = false;
    L8:
        if (r0 == false) goto L14;
        TextViewCompat.setTextAppearance(r3, R.style.TextAppearance_AppCompat_Caption);
        r3.setTextColor(ContextCompat.getColor(getContext(), R.color.design_error));
        return;
    }

    private int calculateLabelMarginTop() {
        if (this.hintEnabled == true) goto L5;
        return 0;
    L5:
        int r0 = this.boxBackgroundMode;
        if (r0 != 0) goto L8;
        float r3 = this.collapsingTextHelper.getCollapsedTextHeight();
    L12:
        return (int) r3;
    L8:
        if (r0 == 2) goto L10;
        return 0;
    L10:
        r3 = this.collapsingTextHelper.getCollapsedTextHeight() / 2.0f;
        goto L12
    }

    private Rect calculateCollapsedTextBounds(Rect r5) {
        if (this.editText == null) goto L15;
        Rect r0 = this.tmpBoundsRect;
        boolean r1 = ViewUtils.isLayoutRtl(this);
        r0.bottom = r5.bottom;
        int r2 = this.boxBackgroundMode;
        if (r2 != 1) goto L7;
        r0.left = getLabelLeftBoundAlightWithPrefix(r5.left, r1);
        r0.top = r5.top + this.boxCollapsedPaddingTopPx;
        r0.right = getLabelRightBoundAlignedWithSuffix(r5.right, r1);
        return r0;
    L7:
        if (r2 == 2) goto L10;
        r0.left = getLabelLeftBoundAlightWithPrefix(r5.left, r1);
        r0.top = getPaddingTop();
        r0.right = getLabelRightBoundAlignedWithSuffix(r5.right, r1);
        return r0;
    L10:
        r0.left = r5.left + this.editText.getPaddingLeft();
        r0.top = r5.top - calculateLabelMarginTop();
        r0.right = r5.right - this.editText.getPaddingRight();
        return r0;
    L15:
        throw new IllegalStateException();
    }

    private int getLabelLeftBoundAlightWithPrefix(int r2, boolean r3) {
        int r4 = r2 + this.editText.getCompoundPaddingLeft();
        if (getPrefixText() == null) goto L7;
        if (r3 == false) goto L6;
        return r4;
    L6:
        return (r4 - getPrefixTextView().getMeasuredWidth()) + getPrefixTextView().getPaddingLeft();
    L7:
        return r4;
    }

    private int getLabelRightBoundAlignedWithSuffix(int r2, boolean r3) {
        int r4 = r2 - this.editText.getCompoundPaddingRight();
        if (getPrefixText() == null) goto L7;
        if (r3 == true) goto L6;
        return r4;
    L6:
        return r4 + (getPrefixTextView().getMeasuredWidth() - getPrefixTextView().getPaddingRight());
    L7:
        return r4;
    }

    private Rect calculateExpandedTextBounds(Rect r5) {
        if (this.editText == null) goto L7;
        Rect r0 = this.tmpBoundsRect;
        float r1 = this.collapsingTextHelper.getExpandedTextHeight();
        r0.left = r5.left + this.editText.getCompoundPaddingLeft();
        r0.top = calculateExpandedLabelTop(r5, r1);
        r0.right = r5.right - this.editText.getCompoundPaddingRight();
        r0.bottom = calculateExpandedLabelBottom(r5, r0, r1);
        return r0;
    L7:
        throw new IllegalStateException();
    }

    private int calculateExpandedLabelTop(Rect r2, float r3) {
        if (isSingleLineFilledTextField() == false) goto L7;
        return (int) (r2.centerY() - (r3 / 2.0f));
    L7:
        return r2.top + this.editText.getCompoundPaddingTop();
    }

    private int calculateExpandedLabelBottom(Rect r2, Rect r3, float r4) {
        if (isSingleLineFilledTextField() == false) goto L7;
        return (int) (r3.top + r4);
    L7:
        return r2.bottom - this.editText.getCompoundPaddingBottom();
    }

    private boolean isSingleLineFilledTextField() {
        if (this.boxBackgroundMode == 1) goto L5;
    L7:
        return false;
    L5:
        if (this.editText.getMinLines() > 1) goto L7;
        return true;
    }

    private int calculateBoxBackgroundColor() {
        int r0 = this.boxBackgroundColor;
        if (this.boxBackgroundMode == 1) goto L5;
        return r0;
    L5:
        return MaterialColors.layer(MaterialColors.getColor(this, R.attr.colorSurface, 0), this.boxBackgroundColor);
    }

    private void applyBoxAttributes() {
        MaterialShapeDrawable r0 = this.boxBackground;
        if (r0 != null) goto L5;
        return;
    L5:
        ShapeAppearanceModel r1 = r0.getShapeAppearanceModel();
        ShapeAppearanceModel r2 = this.shapeAppearanceModel;
        if (r1 == r2) goto L9;
        this.boxBackground.setShapeAppearanceModel(r2);
    L9:
        if (canDrawOutlineStroke() == false) goto L11;
        this.boxBackground.setStroke(this.boxStrokeWidthPx, this.boxStrokeColor);
    L11:
        int r3 = calculateBoxBackgroundColor();
        this.boxBackgroundColor = r3;
        this.boxBackground.setFillColor(ColorStateList.valueOf(r3));
        applyBoxUnderlineAttributes();
        updateEditTextBoxBackgroundIfNeeded();
    }

    private void applyBoxUnderlineAttributes() {
        if (this.boxUnderlineDefault != null) goto L5;
        return;
    L5:
        if (this.boxUnderlineFocused != null) goto L8;
        return;
    L8:
        if (canDrawStroke() == false) goto L14;
        MaterialShapeDrawable r0 = this.boxUnderlineDefault;
        if (this.editText.isFocused() == false) goto L12;
        ColorStateList r1 = ColorStateList.valueOf(this.defaultStrokeColor);
    L13:
        r0.setFillColor(r1);
        this.boxUnderlineFocused.setFillColor(ColorStateList.valueOf(this.boxStrokeColor));
        goto L14
    L12:
        r1 = ColorStateList.valueOf(this.boxStrokeColor);
    L14:
        invalidate();
    }

    private boolean canDrawOutlineStroke() {
        if (this.boxBackgroundMode == 2) goto L5;
    L7:
        return false;
    L5:
        if (canDrawStroke() == false) goto L7;
        return true;
    }

    private boolean canDrawStroke() {
        if (this.boxStrokeWidthPx > (-1)) goto L5;
    L7:
        return false;
    L5:
        if (this.boxStrokeColor == 0) goto L7;
        return true;
    }

    void updateEditTextBackground() {
        EditText r0 = this.editText;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.boxBackgroundMode != 0) goto L26;
        Drawable r1 = r0.getBackground();
        if (r1 != null) goto L11;
        return;
    L11:
        if (DrawableUtils.canSafelyMutateDrawable(r1) == false) goto L14;
        r1 = r1.mutate();
    L14:
        if (shouldShowError() == false) goto L17;
        r1.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        return;
    L17:
        if (this.counterOverflowed == false) goto L21;
        TextView r2 = this.counterView;
        if (r2 == null) goto L21;
        r1.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(r2.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        return;
    L21:
        DrawableCompat.clearColorFilter(r1);
        this.editText.refreshDrawableState();
        return;
    }

    boolean shouldShowError() {
        return this.indicatorViewController.errorShouldBeShown();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        if (shouldShowError() == false) goto L5;
        r1.error = getError();
    L5:
        r1.isEndIconChecked = this.endLayout.isEndIconChecked();
        return r1;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r2) {
        if ((r2 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r2);
        return;
    L6:
        SavedState r3 = (SavedState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        setError(r3.error);
        if (r3.isEndIconChecked == false) goto L9;
        post(new AnonymousClass2(this));
    L9:
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> r2) {
        this.restoringSavedState = true;
        super.dispatchRestoreInstanceState(r2);
        this.restoringSavedState = false;
    }

    public CharSequence getError() {
        if (this.indicatorViewController.isErrorEnabled() == true) goto L7;
        return null;
    L7:
        return this.indicatorViewController.getErrorText();
    }

    public CharSequence getHelperText() {
        if (this.indicatorViewController.isHelperTextEnabled() == true) goto L7;
        return null;
    L7:
        return this.indicatorViewController.getHelperText();
    }

    public boolean isHintAnimationEnabled() {
        return this.hintAnimationEnabled;
    }

    public void setHintAnimationEnabled(boolean r1) {
        this.hintAnimationEnabled = r1;
    }

    public boolean isExpandedHintEnabled() {
        return this.expandedHintEnabled;
    }

    public void setExpandedHintEnabled(boolean r2) {
        if (this.expandedHintEnabled == r2) goto L6;
        this.expandedHintEnabled = r2;
        updateLabelState(false);
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onRtlPropertiesChanged(int r10) {
        super.onRtlPropertiesChanged(r10);
        boolean r0 = true;
        if (r10 == 1) goto L7;
        r0 = false;
    L7:
        if (r0 == this.areCornerRadiiRtl) goto L10;
        float r11 = this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.tmpRectF);
        float r1 = this.shapeAppearanceModel.getTopRightCornerSize().getCornerSize(this.tmpRectF);
        float r2 = this.shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(this.tmpRectF);
        float r3 = this.shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(this.tmpRectF);
        CornerTreatment r4 = this.shapeAppearanceModel.getTopLeftCorner();
        CornerTreatment r5 = this.shapeAppearanceModel.getTopRightCorner();
        CornerTreatment r6 = this.shapeAppearanceModel.getBottomLeftCorner();
        CornerTreatment r7 = this.shapeAppearanceModel.getBottomRightCorner();
        ShapeAppearanceModel r12 = ShapeAppearanceModel.builder().setTopLeftCorner(r5).setTopRightCorner(r4).setBottomLeftCorner(r7).setBottomRightCorner(r6).setTopLeftCornerSize(r1).setTopRightCornerSize(r11).setBottomLeftCornerSize(r3).setBottomRightCornerSize(r2).build();
        this.areCornerRadiiRtl = r0;
        setShapeAppearanceModel(r12);
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        boolean r3 = updateEditTextHeightBasedOnIcon();
        boolean r4 = updateDummyDrawables();
        if (r3 == true) goto L5;
        if (r4 == true) goto L5;
    L6:
        updatePlaceholderMeasurementsBasedOnEditText();
        this.endLayout.updateSuffixTextViewPadding();
        return;
    L5:
        this.editText.post(new AnonymousClass3(this));
        goto L6
    }

    private boolean updateEditTextHeightBasedOnIcon() {
        if (this.editText != null) goto L5;
        return false;
    L5:
        int r0 = Math.max(this.endLayout.getMeasuredHeight(), this.startLayout.getMeasuredHeight());
        if (this.editText.getMeasuredHeight() >= r0) goto L9;
        this.editText.setMinimumHeight(r0);
        return true;
    L9:
        return false;
    }

    private void updatePlaceholderMeasurementsBasedOnEditText() {
        if (this.placeholderTextView == null) goto L8;
        EditText r0 = this.editText;
        if (r0 == null) goto L9;
        int r1 = r0.getGravity();
        this.placeholderTextView.setGravity(r1);
        this.placeholderTextView.setPadding(this.editText.getCompoundPaddingLeft(), this.editText.getCompoundPaddingTop(), this.editText.getCompoundPaddingRight(), this.editText.getCompoundPaddingBottom());
        return;
    L9:
        return;
    }

    public void setStartIconDrawable(int r2) {
        if (r2 == 0) goto L4;
        Drawable r3 = AppCompatResources.getDrawable(getContext(), r2);
    L5:
        setStartIconDrawable(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    public void setStartIconDrawable(Drawable r1) {
        this.startLayout.setStartIconDrawable(r1);
    }

    public Drawable getStartIconDrawable() {
        return this.startLayout.getStartIconDrawable();
    }

    public void setStartIconMinSize(int r1) {
        this.startLayout.setStartIconMinSize(r1);
    }

    public int getStartIconMinSize() {
        return this.startLayout.getStartIconMinSize();
    }

    public void setStartIconOnClickListener(View.OnClickListener r1) {
        this.startLayout.setStartIconOnClickListener(r1);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener r1) {
        this.startLayout.setStartIconOnLongClickListener(r1);
    }

    public void setStartIconVisible(boolean r1) {
        this.startLayout.setStartIconVisible(r1);
    }

    public boolean isStartIconVisible() {
        return this.startLayout.isStartIconVisible();
    }

    public void refreshStartIconDrawableState() {
        this.startLayout.refreshStartIconDrawableState();
    }

    public void setStartIconCheckable(boolean r1) {
        this.startLayout.setStartIconCheckable(r1);
    }

    public boolean isStartIconCheckable() {
        return this.startLayout.isStartIconCheckable();
    }

    public void setStartIconContentDescription(int r2) {
        if (r2 == 0) goto L4;
        CharSequence r3 = getResources().getText(r2);
    L5:
        setStartIconContentDescription(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    public void setStartIconContentDescription(CharSequence r1) {
        this.startLayout.setStartIconContentDescription(r1);
    }

    public CharSequence getStartIconContentDescription() {
        return this.startLayout.getStartIconContentDescription();
    }

    public void setStartIconTintList(ColorStateList r1) {
        this.startLayout.setStartIconTintList(r1);
    }

    public void setStartIconTintMode(PorterDuff.Mode r1) {
        this.startLayout.setStartIconTintMode(r1);
    }

    public void setEndIconMode(int r1) {
        this.endLayout.setEndIconMode(r1);
    }

    public int getEndIconMode() {
        return this.endLayout.getEndIconMode();
    }

    public void setEndIconOnClickListener(View.OnClickListener r1) {
        this.endLayout.setEndIconOnClickListener(r1);
    }

    public void setErrorIconOnClickListener(View.OnClickListener r1) {
        this.endLayout.setErrorIconOnClickListener(r1);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener r1) {
        this.endLayout.setEndIconOnLongClickListener(r1);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener r1) {
        this.endLayout.setErrorIconOnLongClickListener(r1);
    }

    public void refreshErrorIconDrawableState() {
        this.endLayout.refreshErrorIconDrawableState();
    }

    public void setEndIconVisible(boolean r1) {
        this.endLayout.setEndIconVisible(r1);
    }

    public boolean isEndIconVisible() {
        return this.endLayout.isEndIconVisible();
    }

    public void setEndIconActivated(boolean r1) {
        this.endLayout.setEndIconActivated(r1);
    }

    public void refreshEndIconDrawableState() {
        this.endLayout.refreshEndIconDrawableState();
    }

    public void setEndIconCheckable(boolean r1) {
        this.endLayout.setEndIconCheckable(r1);
    }

    public boolean isEndIconCheckable() {
        return this.endLayout.isEndIconCheckable();
    }

    public void setEndIconDrawable(int r1) {
        this.endLayout.setEndIconDrawable(r1);
    }

    public void setEndIconDrawable(Drawable r1) {
        this.endLayout.setEndIconDrawable(r1);
    }

    public Drawable getEndIconDrawable() {
        return this.endLayout.getEndIconDrawable();
    }

    public void setEndIconMinSize(int r1) {
        this.endLayout.setEndIconMinSize(r1);
    }

    public int getEndIconMinSize() {
        return this.endLayout.getEndIconMinSize();
    }

    public void setStartIconScaleType(ImageView.ScaleType r1) {
        this.startLayout.setStartIconScaleType(r1);
    }

    public ImageView.ScaleType getStartIconScaleType() {
        return this.startLayout.getStartIconScaleType();
    }

    public void setEndIconScaleType(ImageView.ScaleType r1) {
        this.endLayout.setEndIconScaleType(r1);
    }

    public ImageView.ScaleType getEndIconScaleType() {
        return this.endLayout.getEndIconScaleType();
    }

    public void setEndIconContentDescription(int r1) {
        this.endLayout.setEndIconContentDescription(r1);
    }

    public void setEndIconContentDescription(CharSequence r1) {
        this.endLayout.setEndIconContentDescription(r1);
    }

    public CharSequence getEndIconContentDescription() {
        return this.endLayout.getEndIconContentDescription();
    }

    public void setEndIconTintList(ColorStateList r1) {
        this.endLayout.setEndIconTintList(r1);
    }

    public void setEndIconTintMode(PorterDuff.Mode r1) {
        this.endLayout.setEndIconTintMode(r1);
    }

    public void addOnEndIconChangedListener(OnEndIconChangedListener r1) {
        this.endLayout.addOnEndIconChangedListener(r1);
    }

    public void removeOnEndIconChangedListener(OnEndIconChangedListener r1) {
        this.endLayout.removeOnEndIconChangedListener(r1);
    }

    public void clearOnEndIconChangedListeners() {
        this.endLayout.clearOnEndIconChangedListeners();
    }

    public void addOnEditTextAttachedListener(OnEditTextAttachedListener r2) {
        this.editTextAttachedListeners.add(r2);
        if (this.editText == null) goto L6;
        r2.onEditTextAttached(this);
        return;
    }

    public void removeOnEditTextAttachedListener(OnEditTextAttachedListener r1) {
        this.editTextAttachedListeners.remove(r1);
    }

    public void clearOnEditTextAttachedListeners() {
        this.editTextAttachedListeners.clear();
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int r1) {
        this.endLayout.setPasswordVisibilityToggleDrawable(r1);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable r1) {
        this.endLayout.setPasswordVisibilityToggleDrawable(r1);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int r1) {
        this.endLayout.setPasswordVisibilityToggleContentDescription(r1);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence r1) {
        this.endLayout.setPasswordVisibilityToggleContentDescription(r1);
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.endLayout.getPasswordVisibilityToggleDrawable();
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.endLayout.getPasswordVisibilityToggleContentDescription();
    }

    @Deprecated
    public boolean isPasswordVisibilityToggleEnabled() {
        return this.endLayout.isPasswordVisibilityToggleEnabled();
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean r1) {
        this.endLayout.setPasswordVisibilityToggleEnabled(r1);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList r1) {
        this.endLayout.setPasswordVisibilityToggleTintList(r1);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode r1) {
        this.endLayout.setPasswordVisibilityToggleTintMode(r1);
    }

    @Deprecated
    public void passwordVisibilityToggleRequested(boolean r1) {
        this.endLayout.togglePasswordVisibilityToggle(r1);
    }

    public void setTextInputAccessibilityDelegate(AccessibilityDelegate r1) {
        EditText r0 = this.editText;
        if (r0 == null) goto L6;
        ViewCompat.setAccessibilityDelegate(r0, r1);
        return;
    }

    CheckableImageButton getEndIconView() {
        return this.endLayout.getEndIconView();
    }

    private void dispatchOnEditTextAttached() {
        Iterator<OnEditTextAttachedListener> r0 = this.editTextAttachedListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onEditTextAttached(this);
        goto L4
    }

    boolean updateDummyDrawables() {
        if (this.editText != null) goto L5;
        return false;
    L5:
        boolean r5 = true;
        if (shouldUpdateStartDummyDrawable() == false) goto L16;
        int r0 = this.startLayout.getMeasuredWidth() - this.editText.getPaddingLeft();
        if (this.startDummyDrawable != null) goto L10;
    L11:
        ColorDrawable r6 = new ColorDrawable();
        this.startDummyDrawable = r6;
        this.startDummyDrawableWidth = r0;
        r6.setBounds(0, 0, r0, 1);
    L12:
        Drawable[] r1 = TextViewCompat.getCompoundDrawablesRelative(this.editText);
        Drawable r7 = r1[0];
        Drawable r8 = this.startDummyDrawable;
        if (r7 == r8) goto L19;
        TextViewCompat.setCompoundDrawablesRelative(this.editText, r8, r1[1], r1[2], r1[3]);
    L18:
        boolean r2 = true;
    L21:
        if (shouldUpdateEndDummyDrawable() == false) goto L37;
        int r3 = this.endLayout.getSuffixTextView().getMeasuredWidth() - this.editText.getPaddingRight();
        CheckableImageButton r9 = this.endLayout.getCurrentEndIconView();
        if (r9 == null) goto L25;
        r3 = (r3 + r9.getMeasuredWidth()) + MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) r9.getLayoutParams());
    L25:
        Drawable[] r10 = TextViewCompat.getCompoundDrawablesRelative(this.editText);
        Drawable r11 = this.endDummyDrawable;
        if (r11 != null) goto L28;
    L30:
        if (r11 != null) goto L32;
        ColorDrawable r12 = new ColorDrawable();
        this.endDummyDrawable = r12;
        this.endDummyDrawableWidth = r3;
        r12.setBounds(0, 0, r3, 1);
    L32:
        Drawable r4 = r10[2];
        Drawable r13 = this.endDummyDrawable;
        if (r4 == r13) goto L35;
        this.originalEditTextEndDrawable = r4;
        TextViewCompat.setCompoundDrawablesRelative(this.editText, r10[0], r10[1], r13, r10[3]);
    L44:
        return r5;
    L35:
        r5 = r2;
        goto L44
    L28:
        if (this.endDummyDrawableWidth == r3) goto L30;
        this.endDummyDrawableWidth = r3;
        r11.setBounds(0, 0, r3, 1);
        TextViewCompat.setCompoundDrawablesRelative(this.editText, r10[0], r10[1], this.endDummyDrawable, r10[3]);
        goto L44
    L37:
        if (this.endDummyDrawable == null) goto L45;
        Drawable[] r14 = TextViewCompat.getCompoundDrawablesRelative(this.editText);
        if (r14[2] != this.endDummyDrawable) goto L41;
        TextViewCompat.setCompoundDrawablesRelative(this.editText, r14[0], r14[1], this.originalEditTextEndDrawable, r14[3]);
    L42:
        this.endDummyDrawable = null;
        goto L44
    L41:
        r5 = r2;
        goto L42
    L45:
        return r2;
    L19:
        r2 = false;
        goto L21
    L10:
        if (this.startDummyDrawableWidth == r0) goto L12;
    L16:
        if (this.startDummyDrawable == null) goto L19;
        Drawable[] r15 = TextViewCompat.getCompoundDrawablesRelative(this.editText);
        TextViewCompat.setCompoundDrawablesRelative(this.editText, null, r15[1], r15[2], r15[3]);
        this.startDummyDrawable = null;
        goto L18
    }

    private boolean shouldUpdateStartDummyDrawable() {
        if (getStartIconDrawable() != null) goto L9;
        if (getPrefixText() != null) goto L7;
    L11:
        return false;
    L7:
        if (getPrefixTextView().getVisibility() != 0) goto L11;
    L9:
        if (this.startLayout.getMeasuredWidth() <= 0) goto L11;
        return true;
    }

    private boolean shouldUpdateEndDummyDrawable() {
        if (this.endLayout.isErrorIconVisible() == true) goto L11;
        if (this.endLayout.hasEndIcon() == false) goto L9;
        if (isEndIconVisible() == true) goto L11;
    L9:
        if (this.endLayout.getSuffixText() != null) goto L11;
    L13:
        return false;
    L11:
        if (this.endLayout.getMeasuredWidth() <= 0) goto L13;
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        EditText r6 = this.editText;
        if (r6 == null) goto L12;
        Rect r7 = this.tmpRect;
        DescendantOffsetUtils.getDescendantRect(this, r6, r7);
        updateBoxUnderlineBounds(r7);
        if (this.hintEnabled == false) goto L13;
        this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
        int r8 = this.editText.getGravity();
        this.collapsingTextHelper.setCollapsedTextGravity((r8 & NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH) | 48);
        this.collapsingTextHelper.setExpandedTextGravity(r8);
        this.collapsingTextHelper.setCollapsedBounds(calculateCollapsedTextBounds(r7));
        this.collapsingTextHelper.setExpandedBounds(calculateExpandedTextBounds(r7));
        this.collapsingTextHelper.recalculate();
        if (cutoutEnabled() == true) goto L9;
        return;
    L9:
        if (this.hintExpanded == true) goto L15;
        openCutout();
        return;
    L15:
        return;
    L13:
        return;
    }

    private void updateBoxUnderlineBounds(Rect r6) {
        if (this.boxUnderlineDefault == null) goto L6;
        int r0 = r6.bottom - this.boxStrokeWidthDefaultPx;
        this.boxUnderlineDefault.setBounds(r6.left, r0, r6.right, r6.bottom);
    L6:
        if (this.boxUnderlineFocused == null) goto L9;
        int r1 = r6.bottom - this.boxStrokeWidthFocusedPx;
        this.boxUnderlineFocused.setBounds(r6.left, r1, r6.right, r6.bottom);
        return;
    }

    @Override // android.view.View
    public void draw(Canvas r1) {
        super.draw(r1);
        drawHint(r1);
        drawBoxUnderline(r1);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        this.collapsingTextHelper.maybeUpdateFontWeightAdjustment(r1);
    }

    private void drawHint(Canvas r2) {
        if (this.hintEnabled == false) goto L6;
        this.collapsingTextHelper.draw(r2);
        return;
    }

    private void drawBoxUnderline(Canvas r6) {
        if (this.boxUnderlineFocused == null) goto L10;
        MaterialShapeDrawable r0 = this.boxUnderlineDefault;
        if (r0 == null) goto L11;
        r0.draw(r6);
        if (this.editText.isFocused() == false) goto L12;
        Rect r1 = this.boxUnderlineFocused.getBounds();
        Rect r2 = this.boxUnderlineDefault.getBounds();
        float r3 = this.collapsingTextHelper.getExpansionFraction();
        int r4 = r2.centerX();
        r1.left = AnimationUtils.lerp(r4, r2.left, r3);
        r1.right = AnimationUtils.lerp(r4, r2.right, r3);
        this.boxUnderlineFocused.draw(r6);
        return;
    L12:
        return;
    L11:
        return;
    }

    private void collapseHint(boolean r2) {
        ValueAnimator r0 = this.animator;
        if (r0 == null) goto L8;
        if (r0.isRunning() == false) goto L8;
        this.animator.cancel();
    L8:
        if (r2 == true) goto L10;
    L12:
        this.collapsingTextHelper.setExpansionFraction(1.0f);
    L13:
        this.hintExpanded = false;
        if (cutoutEnabled() == false) goto L16;
        openCutout();
    L16:
        updatePlaceholderText();
        this.startLayout.onHintStateChanged(false);
        this.endLayout.onHintStateChanged(false);
        return;
    L10:
        if (this.hintAnimationEnabled == false) goto L12;
        animateToExpansionFraction(1.0f);
        goto L13
    }

    private boolean cutoutEnabled() {
        if (this.hintEnabled == true) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.isEmpty(this.hint) == true) goto L9;
        if ((this.boxBackground instanceof CutoutDrawable) == false) goto L9;
        return true;
    }

    private void openCutout() {
        if (cutoutEnabled() == true) goto L5;
        return;
    L5:
        RectF r0 = this.tmpRectF;
        this.collapsingTextHelper.getCollapsedTextActualBounds(r0, this.editText.getWidth(), this.editText.getGravity());
        if (r0.width() > 0.0f) goto L8;
        return;
    L8:
        if (r0.height() <= 0.0f) goto L13;
        applyCutoutPadding(r0);
        r0.offset(-getPaddingLeft(), ((-getPaddingTop()) - (r0.height() / 2.0f)) + this.boxStrokeWidthPx);
        ((CutoutDrawable) this.boxBackground).setCutout(r0);
        return;
    }

    private void recalculateCutout() {
        if (cutoutEnabled() == true) goto L5;
        return;
    L5:
        if (this.hintExpanded == true) goto L9;
        closeCutout();
        openCutout();
        return;
    }

    private void closeCutout() {
        if (cutoutEnabled() == false) goto L6;
        ((CutoutDrawable) this.boxBackground).removeCutout();
        return;
    }

    private void applyCutoutPadding(RectF r3) {
        r3.left -= this.boxLabelCutoutPaddingPx;
        r3.right += this.boxLabelCutoutPaddingPx;
    }

    boolean cutoutIsOpen() {
        if (cutoutEnabled() == true) goto L5;
    L7:
        return false;
    L5:
        if (((CutoutDrawable) this.boxBackground).hasCutout() == false) goto L7;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.inDrawableStateChanged == false) goto L5;
        return;
    L5:
        boolean r0 = true;
        this.inDrawableStateChanged = true;
        super.drawableStateChanged();
        int[] r1 = getDrawableState();
        CollapsingTextHelper r2 = this.collapsingTextHelper;
        if (r2 == null) goto L8;
        boolean r3 = r2.setState(r1) | false;
    L10:
        if (this.editText != null) goto L12;
    L18:
        updateEditTextBackground();
        updateTextInputBoxState();
        if (r3 == false) goto L21;
        invalidate();
    L21:
        this.inDrawableStateChanged = false;
        return;
    L12:
        if (ViewCompat.isLaidOut(this) == true) goto L14;
    L16:
        r0 = false;
    L17:
        updateLabelState(r0);
        goto L18
    L14:
        if (isEnabled() == false) goto L16;
    L8:
        r3 = false;
        goto L10
    }

    void updateTextInputBoxState() {
        if (this.boxBackground != null) goto L5;
        return;
    L5:
        if (this.boxBackgroundMode == 0) goto L79;
        boolean r1 = false;
        if (isFocused() == true) goto L15;
        EditText r0 = this.editText;
        if (r0 != null) goto L12;
    L14:
        boolean r2 = false;
    L17:
        if (isHovered() == true) goto L24;
        EditText r3 = this.editText;
        if (r3 != null) goto L21;
    L23:
        boolean r4 = false;
    L26:
        if (shouldShowError() == false) goto L28;
    L31:
        r1 = true;
    L33:
        if (isEnabled() == true) goto L36;
        this.boxStrokeColor = this.disabledColor;
    L54:
        updateCursorColor(r1);
        this.endLayout.onTextInputBoxStateUpdated();
        refreshStartIconDrawableState();
        if (this.boxBackgroundMode != 2) goto L66;
        int r5 = this.boxStrokeWidthPx;
        if (r2 == true) goto L59;
    L61:
        this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
    L63:
        if (this.boxStrokeWidthPx == r5) goto L66;
        recalculateCutout();
        goto L66
    L59:
        if (isEnabled() == false) goto L61;
        this.boxStrokeWidthPx = this.boxStrokeWidthFocusedPx;
    L66:
        if (this.boxBackgroundMode == 1) goto L68;
    L76:
        applyBoxAttributes();
        return;
    L68:
        if (isEnabled() == true) goto L70;
        this.boxBackgroundColor = this.disabledFilledBackgroundColor;
        goto L76
    L70:
        if (r4 == false) goto L73;
        if (r2 == true) goto L73;
        this.boxBackgroundColor = this.hoveredFilledBackgroundColor;
    L73:
        if (r2 == false) goto L75;
        this.boxBackgroundColor = this.focusedFilledBackgroundColor;
        goto L76
    L75:
        this.boxBackgroundColor = this.defaultFilledBackgroundColor;
        goto L76
    L36:
        if (shouldShowError() == false) goto L42;
        if (this.strokeErrorColor == null) goto L40;
        updateStrokeErrorColor(r2, r4);
        goto L54
    L40:
        this.boxStrokeColor = getErrorCurrentTextColors();
        goto L54
    L42:
        if (this.counterOverflowed == false) goto L49;
        TextView r6 = this.counterView;
        if (r6 == null) goto L49;
        if (this.strokeErrorColor == null) goto L48;
        updateStrokeErrorColor(r2, r4);
        goto L54
    L48:
        this.boxStrokeColor = r6.getCurrentTextColor();
    L49:
        if (r2 == false) goto L51;
        this.boxStrokeColor = this.focusedStrokeColor;
        goto L54
    L51:
        if (r4 == false) goto L53;
        this.boxStrokeColor = this.hoveredStrokeColor;
        goto L54
    L53:
        this.boxStrokeColor = this.defaultStrokeColor;
        goto L54
    L28:
        if (this.counterView == null) goto L33;
        if (this.counterOverflowed == false) goto L33;
    L21:
        if (r3.isHovered() == false) goto L23;
    L24:
        r4 = true;
        goto L26
    L12:
        if (r0.hasFocus() == false) goto L14;
    L15:
        r2 = true;
        goto L17
    }

    private void updateStrokeErrorColor(boolean r5, boolean r6) {
        int r0 = this.strokeErrorColor.getDefaultColor();
        int r1 = this.strokeErrorColor.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, r0);
        int r2 = this.strokeErrorColor.getColorForState(new int[]{android.R.attr.state_activated, android.R.attr.state_enabled}, r0);
        if (r5 == false) goto L5;
        this.boxStrokeColor = r2;
        return;
    L5:
        if (r6 == false) goto L7;
        this.boxStrokeColor = r1;
        return;
    L7:
        this.boxStrokeColor = r0;
    }

    private void updateCursorColor(boolean r3) {
        ColorStateList r0 = MaterialColors.getColorStateListOrNull(getContext(), R.attr.colorControlActivated);
        EditText r1 = this.editText;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.getTextCursorDrawable() == null) goto L17;
        if (r0 == null) goto L18;
        Drawable r2 = this.editText.getTextCursorDrawable();
        if (r3 == false) goto L14;
        ColorStateList r4 = this.strokeErrorColor;
        if (r4 == null) goto L13;
        r0 = r4;
        goto L14
    L13:
        r0 = ColorStateList.valueOf(this.boxStrokeColor);
    L14:
        DrawableCompat.setTintList(r2, r0);
        return;
    L18:
        return;
    }

    private void expandHint(boolean r2) {
        ValueAnimator r0 = this.animator;
        if (r0 == null) goto L8;
        if (r0.isRunning() == false) goto L8;
        this.animator.cancel();
    L8:
        if (r2 == true) goto L10;
    L12:
        this.collapsingTextHelper.setExpansionFraction(0.0f);
    L14:
        if (cutoutEnabled() == true) goto L16;
    L18:
        this.hintExpanded = true;
        hidePlaceholderText();
        this.startLayout.onHintStateChanged(true);
        this.endLayout.onHintStateChanged(true);
        return;
    L16:
        if (((CutoutDrawable) this.boxBackground).hasCutout() == false) goto L18;
        closeCutout();
        goto L18
    L10:
        if (this.hintAnimationEnabled == false) goto L12;
        animateToExpansionFraction(0.0f);
        goto L14
    }

    void animateToExpansionFraction(float r5) {
        if (this.collapsingTextHelper.getExpansionFraction() != r5) goto L6;
        return;
    L6:
        if (this.animator != null) goto L8;
        ValueAnimator r0 = new ValueAnimator();
        this.animator = r0;
        r0.setInterpolator(MotionUtils.resolveThemeInterpolator(getContext(), R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        this.animator.setDuration(MotionUtils.resolveThemeDuration(getContext(), R.attr.motionDurationMedium4, LABEL_SCALE_ANIMATION_DURATION));
        this.animator.addUpdateListener(new AnonymousClass4(this));
    L8:
        this.animator.setFloatValues(new float[]{this.collapsingTextHelper.getExpansionFraction(), r5});
        this.animator.start();
    }

    final boolean isHintExpanded() {
        return this.hintExpanded;
    }

    final boolean isHelperTextDisplayed() {
        return this.indicatorViewController.helperTextIsDisplayed();
    }

    final int getHintCurrentCollapsedTextColor() {
        return this.collapsingTextHelper.getCurrentCollapsedTextColor();
    }

    final float getHintCollapsedTextHeight() {
        return this.collapsingTextHelper.getCollapsedTextHeight();
    }
}
