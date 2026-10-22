package com.google.android.material.textfield;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.b0;
import androidx.appcompat.widget.f;
import androidx.appcompat.widget.r;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.a;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.e;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.ttnet.org.chromium.net.NetError;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes3.dex */
public class TextInputLayout extends LinearLayout {
    public static final int BOX_BACKGROUND_FILLED = 1;
    public static final int BOX_BACKGROUND_NONE = 0;
    public static final int BOX_BACKGROUND_OUTLINE = 2;
    private static final int DEF_STYLE_RES = 0;
    public static final int END_ICON_CLEAR_TEXT = 2;
    public static final int END_ICON_CUSTOM = -1;
    public static final int END_ICON_DROPDOWN_MENU = 3;
    public static final int END_ICON_NONE = 0;
    public static final int END_ICON_PASSWORD_TOGGLE = 1;
    private static final int INVALID_MAX_LENGTH = -1;
    private static final int LABEL_SCALE_ANIMATION_DURATION = 167;
    private static final String LOG_TAG = "TextInputLayout";
    private static final int NO_WIDTH = -1;
    private ValueAnimator animator;

    @Nullable
    private MaterialShapeDrawable boxBackground;

    @ColorInt
    private int boxBackgroundColor;
    private int boxBackgroundMode;
    private int boxCollapsedPaddingTopPx;
    private int boxLabelCutoutHeight;
    private final int boxLabelCutoutPaddingPx;

    @ColorInt
    private int boxStrokeColor;
    private int boxStrokeWidthDefaultPx;
    private int boxStrokeWidthFocusedPx;
    private int boxStrokeWidthPx;

    @Nullable
    private MaterialShapeDrawable boxUnderline;
    final CollapsingTextHelper collapsingTextHelper;
    boolean counterEnabled;
    private int counterMaxLength;
    private int counterOverflowTextAppearance;

    @Nullable
    private ColorStateList counterOverflowTextColor;
    private boolean counterOverflowed;
    private int counterTextAppearance;

    @Nullable
    private ColorStateList counterTextColor;

    @Nullable
    private TextView counterView;

    @ColorInt
    private int defaultFilledBackgroundColor;
    private ColorStateList defaultHintTextColor;

    @ColorInt
    private int defaultStrokeColor;

    @ColorInt
    private int disabledColor;

    @ColorInt
    private int disabledFilledBackgroundColor;
    EditText editText;
    private final LinkedHashSet<OnEditTextAttachedListener> editTextAttachedListeners;

    @Nullable
    private Drawable endDummyDrawable;
    private int endDummyDrawableWidth;
    private final LinkedHashSet<OnEndIconChangedListener> endIconChangedListeners;
    private final SparseArray<EndIconDelegate> endIconDelegates;

    @NonNull
    private final FrameLayout endIconFrame;
    private int endIconMode;
    private View.OnLongClickListener endIconOnLongClickListener;
    private ColorStateList endIconTintList;
    private PorterDuff.Mode endIconTintMode;

    @NonNull
    private final CheckableImageButton endIconView;

    @NonNull
    private final LinearLayout endLayout;
    private View.OnLongClickListener errorIconOnLongClickListener;
    private ColorStateList errorIconTintList;

    @NonNull
    private final CheckableImageButton errorIconView;
    private boolean expandedHintEnabled;

    @ColorInt
    private int focusedFilledBackgroundColor;

    @ColorInt
    private int focusedStrokeColor;
    private ColorStateList focusedTextColor;
    private boolean hasEndIconTintList;
    private boolean hasEndIconTintMode;
    private boolean hasStartIconTintList;
    private boolean hasStartIconTintMode;
    private CharSequence hint;
    private boolean hintAnimationEnabled;
    private boolean hintEnabled;
    private boolean hintExpanded;

    @ColorInt
    private int hoveredFilledBackgroundColor;

    @ColorInt
    private int hoveredStrokeColor;
    private boolean inDrawableStateChanged;
    private final IndicatorViewController indicatorViewController;

    @NonNull
    private final FrameLayout inputFrame;
    private boolean isProvidingHint;
    private int maxWidth;
    private int minWidth;
    private Drawable originalEditTextEndDrawable;
    private CharSequence originalHint;
    private boolean placeholderEnabled;
    private CharSequence placeholderText;
    private int placeholderTextAppearance;

    @Nullable
    private ColorStateList placeholderTextColor;
    private TextView placeholderTextView;

    @Nullable
    private CharSequence prefixText;

    @NonNull
    private final TextView prefixTextView;
    private boolean restoringSavedState;

    @NonNull
    private ShapeAppearanceModel shapeAppearanceModel;

    @Nullable
    private Drawable startDummyDrawable;
    private int startDummyDrawableWidth;
    private View.OnLongClickListener startIconOnLongClickListener;
    private ColorStateList startIconTintList;
    private PorterDuff.Mode startIconTintMode;

    @NonNull
    private final CheckableImageButton startIconView;

    @NonNull
    private final LinearLayout startLayout;
    private ColorStateList strokeErrorColor;

    @Nullable
    private CharSequence suffixText;

    @NonNull
    private final TextView suffixTextView;
    private final Rect tmpBoundsRect;
    private final Rect tmpRect;
    private final RectF tmpRectF;
    private Typeface typeface;

    public static class AccessibilityDelegate extends a {
        private final TextInputLayout layout;

        public AccessibilityDelegate(@NonNull TextInputLayout r10) {
            this.layout = r10;
        }

        @Override // androidx.core.view.a
        public void onInitializeAccessibilityNodeInfo(@NonNull View r11, @NonNull AccessibilityNodeInfoCompat r12) {
            super.onInitializeAccessibilityNodeInfo(r11, r12);
            EditText r13 = this.layout.getEditText();
            if (r13 == null) goto L5;
            CharSequence r10 = r13.getText();
        L6:
            CharSequence r14 = this.layout.getHint();
            CharSequence r15 = this.layout.getError();
            CharSequence r16 = this.layout.getPlaceholderText();
            int r17 = this.layout.getCounterMaxLength();
            CharSequence r18 = this.layout.getCounterOverflowDescription();
            boolean r19 = TextUtils.isEmpty(r10);
            boolean r20 = TextUtils.isEmpty(r14);
            boolean r110 = this.layout.isHintExpanded();
            boolean r21 = TextUtils.isEmpty(r15);
            if (r21 == true) goto L9;
        L12:
            boolean r22 = true;
        L13:
            if (r20 == true) goto L15;
            String r23 = r14.toString();
        L16:
            if (r19 == true) goto L19;
            r12.x0(r10);
        L27:
            if (TextUtils.isEmpty(r23) == true) goto L29;
            r12.g0(r23);
            r12.t0(r19);
        L29:
            if (r10 != null) goto L31;
        L33:
            r17 = -1;
        L34:
            r12.i0(r17);
            if (r22 == false) goto L40;
            if (r21 == false) goto L39;
            r15 = r18;
        L39:
            r12.c0(r15);
        L40:
            if (r13 == null) goto L43;
            r13.setLabelFor(R.id.textinput_helper_text);
            return;
        L43:
            return;
        L31:
            if (r10.length() != r17) goto L33;
        L19:
            if (TextUtils.isEmpty(r23) == true) goto L24;
            r12.x0(r23);
            if (r110 == true) goto L27;
            if (r16 == null) goto L27;
            r12.x0(r23 + ", " + r16);
            goto L27
        L24:
            if (r16 == null) goto L27;
            r12.x0(r16);
            goto L27
        L15:
            r23 = "";
            goto L16
        L9:
            if (TextUtils.isEmpty(r18) == false) goto L12;
            r22 = false;
            goto L13
        L5:
            r10 = null;
            goto L6
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BoxBackgroundMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface EndIconMode {
    }

    public interface OnEditTextAttachedListener {
        void onEditTextAttached(@NonNull TextInputLayout r10);
    }

    public interface OnEndIconChangedListener {
        void onEndIconChanged(@NonNull TextInputLayout r10, int r11);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        @Nullable
        CharSequence error;

        @Nullable
        CharSequence helperText;

        @Nullable
        CharSequence hintText;
        boolean isEndIconChecked;

        @Nullable
        CharSequence placeholderText;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcelable r10) {
            super(r10);
        }

        @NonNull
        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.error + " hint=" + this.hintText + " helperText=" + this.helperText + " placeholderText=" + this.placeholderText + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            TextUtils.writeToParcel(this.error, r10, r11);
            r10.writeInt(this.isEndIconChecked ? 1 : 0);
            TextUtils.writeToParcel(this.hintText, r10, r11);
            TextUtils.writeToParcel(this.helperText, r10, r11);
            TextUtils.writeToParcel(this.placeholderText, r10, r11);
        }

        public SavedState(@NonNull Parcel r10, ClassLoader r11) {
            super(r10, r11);
            Parcelable.Creator r12 = TextUtils.CHAR_SEQUENCE_CREATOR;
            this.error = (CharSequence) r12.createFromParcel(r10);
            boolean r13 = true;
            if (r10.readInt() == 1) goto L6;
            r13 = false;
        L6:
            this.isEndIconChecked = r13;
            this.hintText = (CharSequence) r12.createFromParcel(r10);
            this.helperText = (CharSequence) r12.createFromParcel(r10);
            this.placeholderText = (CharSequence) r12.createFromParcel(r10);
        }
    }

    static {
        DEF_STYLE_RES = R.style.Widget_Design_TextInputLayout;
    }

    public TextInputLayout(@NonNull Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ boolean access$000(TextInputLayout r10) {
        return r10.restoringSavedState;
    }

    public static /* synthetic */ boolean access$100(TextInputLayout r10) {
        return r10.placeholderEnabled;
    }

    public static /* synthetic */ void access$200(TextInputLayout r10, int r11) {
        r10.updatePlaceholderText(r11);
    }

    public static /* synthetic */ CheckableImageButton access$300(TextInputLayout r10) {
        return r10.endIconView;
    }

    private void addPlaceholderTextView() {
        TextView r10 = this.placeholderTextView;
        if (r10 == null) goto L6;
        this.inputFrame.addView(r10);
        this.placeholderTextView.setVisibility(0);
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
        EditText r10 = this.editText;
        ViewCompat.D0(r10, ViewCompat.F(r10), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_top), ViewCompat.E(this.editText), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_bottom));
        return;
    L11:
        if (MaterialResources.isFontScaleAtLeast1_3(getContext()) == false) goto L16;
        EditText r11 = this.editText;
        ViewCompat.D0(r11, ViewCompat.F(r11), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_top), ViewCompat.E(this.editText), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_bottom));
        return;
    }

    private void applyBoxAttributes() {
        MaterialShapeDrawable r10 = this.boxBackground;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.setShapeAppearanceModel(this.shapeAppearanceModel);
        if (canDrawOutlineStroke() == false) goto L8;
        this.boxBackground.setStroke(this.boxStrokeWidthPx, this.boxStrokeColor);
    L8:
        int r11 = calculateBoxBackgroundColor();
        this.boxBackgroundColor = r11;
        this.boxBackground.setFillColor(ColorStateList.valueOf(r11));
        if (this.endIconMode != 3) goto L11;
        this.editText.getBackground().invalidateSelf();
    L11:
        applyBoxUnderlineAttributes();
        invalidate();
    }

    private void applyBoxUnderlineAttributes() {
        if (this.boxUnderline != null) goto L6;
        return;
    L6:
        if (canDrawStroke() == false) goto L8;
        this.boxUnderline.setFillColor(ColorStateList.valueOf(this.boxStrokeColor));
    L8:
        invalidate();
    }

    private void applyCutoutPadding(@NonNull RectF r10) {
        float r11 = r10.left;
        int r12 = this.boxLabelCutoutPaddingPx;
        r10.left = r11 - r12;
        r10.right += r12;
    }

    private void applyEndIconTint() {
        applyIconTint(this.endIconView, this.hasEndIconTintList, this.endIconTintList, this.hasEndIconTintMode, this.endIconTintMode);
    }

    private void applyIconTint(@NonNull CheckableImageButton r10, boolean r11, ColorStateList r12, boolean r13, PorterDuff.Mode r14) {
        Drawable r15 = r10.getDrawable();
        if (r15 == null) goto L12;
        if (r11 == true) goto L6;
        if (r13 == false) goto L12;
    L6:
        r15 = o.a.l(r15).mutate();
        if (r11 == false) goto L9;
        o.a.i(r15, r12);
    L9:
        if (r13 == false) goto L12;
        o.a.j(r15, r14);
    L12:
        if (r10.getDrawable() == r15) goto L15;
        r10.setImageDrawable(r15);
        return;
    }

    private void applyStartIconTint() {
        applyIconTint(this.startIconView, this.hasStartIconTintList, this.startIconTintList, this.hasStartIconTintMode, this.startIconTintMode);
    }

    private void assignBoxBackgroundByMode() {
        int r10 = this.boxBackgroundMode;
        if (r10 != 0) goto L5;
        this.boxBackground = null;
        this.boxUnderline = null;
        return;
    L5:
        if (r10 != 1) goto L7;
        this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
        this.boxUnderline = new MaterialShapeDrawable();
        return;
    L7:
        if (r10 != 2) goto L16;
        if (this.hintEnabled == true) goto L11;
    L13:
        this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
    L14:
        this.boxUnderline = null;
        return;
    L11:
        if ((this.boxBackground instanceof CutoutDrawable) == true) goto L13;
        this.boxBackground = new CutoutDrawable(this.shapeAppearanceModel);
        goto L14
    L16:
        throw new IllegalArgumentException(this.boxBackgroundMode + " is illegal; only @BoxBackgroundMode constants are supported.");
    }

    private int calculateBoxBackgroundColor() {
        int r10 = this.boxBackgroundColor;
        if (this.boxBackgroundMode == 1) goto L5;
        return r10;
    L5:
        return MaterialColors.layer(MaterialColors.getColor(this, R.attr.colorSurface, 0), this.boxBackgroundColor);
    }

    @NonNull
    private Rect calculateCollapsedTextBounds(@NonNull Rect r10) {
        if (this.editText == null) goto L19;
        Rect r11 = this.tmpBoundsRect;
        if (ViewCompat.A(this) != 1) goto L7;
        boolean r12 = true;
    L8:
        r11.bottom = r10.bottom;
        int r13 = this.boxBackgroundMode;
        if (r13 != 1) goto L11;
        r11.left = getLabelLeftBoundAlightWithPrefix(r10.left, r12);
        r11.top = r10.top + this.boxCollapsedPaddingTopPx;
        r11.right = getLabelRightBoundAlignedWithSuffix(r10.right, r12);
        return r11;
    L11:
        if (r13 == 2) goto L14;
        r11.left = getLabelLeftBoundAlightWithPrefix(r10.left, r12);
        r11.top = getPaddingTop();
        r11.right = getLabelRightBoundAlignedWithSuffix(r10.right, r12);
        return r11;
    L14:
        r11.left = r10.left + this.editText.getPaddingLeft();
        r11.top = r10.top - calculateLabelMarginTop();
        r11.right = r10.right - this.editText.getPaddingRight();
        return r11;
    L7:
        r12 = false;
        goto L8
    L19:
        throw new IllegalStateException();
    }

    private int calculateExpandedLabelBottom(@NonNull Rect r10, @NonNull Rect r11, float r12) {
        if (isSingleLineFilledTextField() == false) goto L7;
        return (int) (r11.top + r12);
    L7:
        return r10.bottom - this.editText.getCompoundPaddingBottom();
    }

    private int calculateExpandedLabelTop(@NonNull Rect r10, float r11) {
        if (isSingleLineFilledTextField() == false) goto L7;
        return (int) (r10.centerY() - (r11 / 2.0f));
    L7:
        return r10.top + this.editText.getCompoundPaddingTop();
    }

    @NonNull
    private Rect calculateExpandedTextBounds(@NonNull Rect r10) {
        if (this.editText == null) goto L7;
        Rect r11 = this.tmpBoundsRect;
        float r12 = this.collapsingTextHelper.getExpandedTextHeight();
        r11.left = r10.left + this.editText.getCompoundPaddingLeft();
        r11.top = calculateExpandedLabelTop(r10, r12);
        r11.right = r10.right - this.editText.getCompoundPaddingRight();
        r11.bottom = calculateExpandedLabelBottom(r10, r11, r12);
        return r11;
    L7:
        throw new IllegalStateException();
    }

    private int calculateLabelMarginTop() {
        if (this.hintEnabled == true) goto L5;
        return 0;
    L5:
        int r10 = this.boxBackgroundMode;
        if (r10 != 0) goto L8;
    L15:
        float r11 = this.collapsingTextHelper.getCollapsedTextHeight();
    L14:
        return (int) r11;
    L8:
        if (r10 == 1) goto L15;
        if (r10 == 2) goto L12;
        return 0;
    L12:
        r11 = this.collapsingTextHelper.getCollapsedTextHeight() / 2.0f;
        goto L14
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

    private void closeCutout() {
        if (cutoutEnabled() == false) goto L6;
        ((CutoutDrawable) this.boxBackground).removeCutout();
        return;
    }

    private void collapseHint(boolean r10) {
        ValueAnimator r11 = this.animator;
        if (r11 == null) goto L8;
        if (r11.isRunning() == false) goto L8;
        this.animator.cancel();
    L8:
        if (r10 == true) goto L10;
    L12:
        this.collapsingTextHelper.setExpansionFraction(1.0f);
    L13:
        this.hintExpanded = false;
        if (cutoutEnabled() == false) goto L16;
        openCutout();
    L16:
        updatePlaceholderText();
        updatePrefixTextVisibility();
        updateSuffixTextVisibility();
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

    private void dispatchOnEditTextAttached() {
        Iterator<OnEditTextAttachedListener> r10 = this.editTextAttachedListeners.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().onEditTextAttached(this);
        goto L4
    }

    private void dispatchOnEndIconChanged(int r10) {
        Iterator<OnEndIconChangedListener> r11 = this.endIconChangedListeners.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onEndIconChanged(this, r10);
        goto L4
    }

    private void drawBoxUnderline(Canvas r10) {
        MaterialShapeDrawable r11 = this.boxUnderline;
        if (r11 == null) goto L6;
        Rect r12 = r11.getBounds();
        r12.top = r12.bottom - this.boxStrokeWidthPx;
        this.boxUnderline.draw(r10);
        return;
    }

    private void drawHint(@NonNull Canvas r10) {
        if (this.hintEnabled == false) goto L6;
        this.collapsingTextHelper.draw(r10);
        return;
    }

    private void expandHint(boolean r10) {
        ValueAnimator r11 = this.animator;
        if (r11 == null) goto L8;
        if (r11.isRunning() == false) goto L8;
        this.animator.cancel();
    L8:
        if (r10 == true) goto L10;
    L12:
        this.collapsingTextHelper.setExpansionFraction(0.0f);
    L14:
        if (cutoutEnabled() == true) goto L16;
    L18:
        this.hintExpanded = true;
        hidePlaceholderText();
        updatePrefixTextVisibility();
        updateSuffixTextVisibility();
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

    private EndIconDelegate getEndIconDelegate() {
        EndIconDelegate r10 = this.endIconDelegates.get(this.endIconMode);
        if (r10 == null) goto L6;
        return r10;
    L6:
        return this.endIconDelegates.get(0);
    }

    @Nullable
    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.errorIconView.getVisibility() != 0) goto L7;
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

    private int getLabelLeftBoundAlightWithPrefix(int r10, boolean r11) {
        int r12 = r10 + this.editText.getCompoundPaddingLeft();
        if (this.prefixText == null) goto L7;
        if (r11 == false) goto L6;
        return r12;
    L6:
        return (r12 - this.prefixTextView.getMeasuredWidth()) + this.prefixTextView.getPaddingLeft();
    L7:
        return r12;
    }

    private int getLabelRightBoundAlignedWithSuffix(int r10, boolean r11) {
        int r12 = r10 - this.editText.getCompoundPaddingRight();
        if (this.prefixText == null) goto L7;
        if (r11 == true) goto L6;
        return r12;
    L6:
        return r12 + (this.prefixTextView.getMeasuredWidth() - this.prefixTextView.getPaddingRight());
    L7:
        return r12;
    }

    private boolean hasEndIcon() {
        if (this.endIconMode == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void hidePlaceholderText() {
        TextView r10 = this.placeholderTextView;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.placeholderEnabled == false) goto L9;
        r10.setText(null);
        this.placeholderTextView.setVisibility(4);
        return;
    }

    private boolean isErrorIconVisible() {
        if (this.errorIconView.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isSingleLineFilledTextField() {
        if (this.boxBackgroundMode == 1) goto L5;
    L7:
        return false;
    L5:
        if (this.editText.getMinLines() > 1) goto L7;
        return true;
    }

    private int[] mergeIconState(CheckableImageButton r10) {
        int[] r11 = getDrawableState();
        int[] r12 = r10.getDrawableState();
        int r13 = r11.length;
        int[] r14 = Arrays.copyOf(r11, r11.length + r12.length);
        System.arraycopy(r12, 0, r14, r13, r12.length);
        return r14;
    }

    private void onApplyBoxBackgroundMode() {
        assignBoxBackgroundByMode();
        setEditTextBoxBackground();
        updateTextInputBoxState();
        updateBoxCollapsedPaddingTop();
        adjustFilledEditTextPaddingForLargeFont();
        if (this.boxBackgroundMode == 0) goto L6;
        updateInputLayoutMargins();
        return;
    }

    private void openCutout() {
        if (cutoutEnabled() == true) goto L5;
        return;
    L5:
        RectF r10 = this.tmpRectF;
        this.collapsingTextHelper.getCollapsedTextActualBounds(r10, this.editText.getWidth(), this.editText.getGravity());
        applyCutoutPadding(r10);
        int r11 = this.boxStrokeWidthPx;
        this.boxLabelCutoutHeight = r11;
        r10.top = 0.0f;
        r10.bottom = r11;
        r10.offset(-getPaddingLeft(), 0.0f);
        ((CutoutDrawable) this.boxBackground).setCutout(r10);
    }

    private static void recursiveSetEnabled(@NonNull ViewGroup r10, boolean r11) {
        int r12 = r10.getChildCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        View r14 = r10.getChildAt(r13);
        r14.setEnabled(r11);
        if ((r14 instanceof ViewGroup) == false) goto L7;
        recursiveSetEnabled((ViewGroup) r14, r11);
    L7:
        r13 = r13 + 1;
        goto L3
    }

    private void refreshIconDrawableState(CheckableImageButton r10, ColorStateList r11) {
        Drawable r12 = r10.getDrawable();
        if (r10.getDrawable() == null) goto L10;
        if (r11 != null) goto L6;
        return;
    L6:
        if (r11.isStateful() == false) goto L12;
        int r13 = r11.getColorForState(mergeIconState(r10), r11.getDefaultColor());
        Drawable r14 = o.a.l(r12).mutate();
        o.a.i(r14, ColorStateList.valueOf(r13));
        r10.setImageDrawable(r14);
        return;
    L12:
        return;
    }

    private void removePlaceholderTextView() {
        TextView r10 = this.placeholderTextView;
        if (r10 == null) goto L6;
        r10.setVisibility(8);
        return;
    }

    private void setEditText(EditText r10) {
        if (this.editText != null) goto L27;
        if (this.endIconMode != 3) goto L7;
    L9:
        this.editText = r10;
        setMinWidth(this.minWidth);
        setMaxWidth(this.maxWidth);
        onApplyBoxBackgroundMode();
        setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
        this.collapsingTextHelper.setTypefaces(this.editText.getTypeface());
        this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
        int r11 = this.editText.getGravity();
        this.collapsingTextHelper.setCollapsedTextGravity((r11 & NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH) | 48);
        this.collapsingTextHelper.setExpandedTextGravity(r11);
        this.editText.addTextChangedListener(new AnonymousClass1(this));
        if (this.defaultHintTextColor != null) goto L13;
        this.defaultHintTextColor = this.editText.getHintTextColors();
    L13:
        if (this.hintEnabled == false) goto L19;
        if (TextUtils.isEmpty(this.hint) == false) goto L17;
        CharSequence r12 = this.editText.getHint();
        this.originalHint = r12;
        setHint(r12);
        this.editText.setHint(null);
    L17:
        this.isProvidingHint = true;
    L19:
        if (this.counterView == null) goto L21;
        updateCounter(this.editText.getText().length());
    L21:
        updateEditTextBackground();
        this.indicatorViewController.adjustIndicatorPadding();
        this.startLayout.bringToFront();
        this.endLayout.bringToFront();
        this.endIconFrame.bringToFront();
        this.errorIconView.bringToFront();
        dispatchOnEditTextAttached();
        updatePrefixTextViewPadding();
        updateSuffixTextViewPadding();
        if (isEnabled() == true) goto L24;
        r10.setEnabled(false);
    L24:
        updateLabelState(false, true);
        return;
    L7:
        if ((r10 instanceof TextInputEditText) == true) goto L9;
        Log.i(LOG_TAG, "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        goto L9
    L27:
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setEditTextBoxBackground() {
        if (shouldUseEditTextBackgroundForBoxBackground() == false) goto L6;
        ViewCompat.t0(this.editText, this.boxBackground);
        return;
    }

    private void setErrorIconVisible(boolean r10) {
        CheckableImageButton r11 = this.errorIconView;
        int r12 = 8;
        if (r10 == false) goto L5;
        int r13 = 0;
    L6:
        r11.setVisibility(r13);
        FrameLayout r14 = this.endIconFrame;
        if (r10 == true) goto L10;
        r12 = 0;
    L10:
        r14.setVisibility(r12);
        updateSuffixTextViewPadding();
        if (hasEndIcon() == true) goto L14;
        updateDummyDrawables();
        return;
    L14:
        return;
    L5:
        r13 = 8;
        goto L6
    }

    private void setHintInternal(CharSequence r10) {
        if (TextUtils.equals(r10, this.hint) == true) goto L8;
        this.hint = r10;
        this.collapsingTextHelper.setText(r10);
        if (this.hintExpanded == true) goto L9;
        openCutout();
        return;
    L9:
        return;
    }

    private static void setIconClickable(@NonNull CheckableImageButton r10, @Nullable View.OnLongClickListener r11) {
        boolean r12 = ViewCompat.O(r10);
        boolean r13 = false;
        int r14 = 1;
        if (r11 == null) goto L5;
        boolean r15 = true;
    L6:
        if (r12 == true) goto L8;
        if (r15 == true) goto L8;
    L9:
        r10.setFocusable(r13);
        r10.setClickable(r12);
        r10.setPressable(r12);
        r10.setLongClickable(r15);
        if (r13 == true) goto L13;
        r14 = 2;
    L13:
        ViewCompat.A0(r10, r14);
        return;
    L8:
        r13 = true;
        goto L9
    L5:
        r15 = false;
        goto L6
    }

    private static void setIconOnClickListener(@NonNull CheckableImageButton r10, @Nullable View.OnClickListener r11, @Nullable View.OnLongClickListener r12) {
        r10.setOnClickListener(r11);
        setIconClickable(r10, r12);
    }

    private static void setIconOnLongClickListener(@NonNull CheckableImageButton r10, @Nullable View.OnLongClickListener r11) {
        r10.setOnLongClickListener(r11);
        setIconClickable(r10, r11);
    }

    private void setPlaceholderTextEnabled(boolean r10) {
        if (this.placeholderEnabled != r10) goto L5;
        return;
    L5:
        if (r10 == false) goto L7;
        AppCompatTextView r11 = new AppCompatTextView(getContext());
        this.placeholderTextView = r11;
        r11.setId(R.id.textinput_placeholder);
        ViewCompat.r0(this.placeholderTextView, 1);
        setPlaceholderTextAppearance(this.placeholderTextAppearance);
        setPlaceholderTextColor(this.placeholderTextColor);
        addPlaceholderTextView();
    L8:
        this.placeholderEnabled = r10;
        return;
    L7:
        removePlaceholderTextView();
        this.placeholderTextView = null;
        goto L8
    }

    private boolean shouldUpdateEndDummyDrawable() {
        if (this.errorIconView.getVisibility() == 0) goto L11;
        if (hasEndIcon() == false) goto L9;
        if (isEndIconVisible() == true) goto L11;
    L9:
        if (this.suffixText != null) goto L11;
    L13:
        return false;
    L11:
        if (this.endLayout.getMeasuredWidth() <= 0) goto L13;
        return true;
    }

    private boolean shouldUpdateStartDummyDrawable() {
        if (getStartIconDrawable() != null) goto L7;
        if (this.prefixText != null) goto L7;
    L9:
        return false;
    L7:
        if (this.startLayout.getMeasuredWidth() <= 0) goto L9;
        return true;
    }

    private boolean shouldUseEditTextBackgroundForBoxBackground() {
        EditText r10 = this.editText;
        if (r10 != null) goto L5;
    L11:
        return false;
    L5:
        if (this.boxBackground == null) goto L11;
        if (r10.getBackground() != null) goto L11;
        if (this.boxBackgroundMode == 0) goto L11;
        return true;
    }

    private void showPlaceholderText() {
        TextView r10 = this.placeholderTextView;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.placeholderEnabled == false) goto L9;
        r10.setText(this.placeholderText);
        this.placeholderTextView.setVisibility(0);
        this.placeholderTextView.bringToFront();
        return;
    }

    private void tintEndIconOnError(boolean r10) {
        if (r10 == true) goto L4;
    L6:
        applyEndIconTint();
        return;
    L4:
        if (getEndIconDrawable() == null) goto L6;
        Drawable r11 = o.a.l(getEndIconDrawable()).mutate();
        o.a.h(r11, this.indicatorViewController.getErrorViewCurrentTextColor());
        this.endIconView.setImageDrawable(r11);
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

    private void updateBoxUnderlineBounds(@NonNull Rect r10) {
        MaterialShapeDrawable r11 = this.boxUnderline;
        if (r11 == null) goto L6;
        int r12 = r10.bottom;
        int r13 = r12 - this.boxStrokeWidthFocusedPx;
        r11.setBounds(r10.left, r13, r10.right, r12);
        return;
    }

    private void updateCounter() {
        if (this.counterView == null) goto L10;
        EditText r10 = this.editText;
        if (r10 != null) goto L7;
        int r11 = 0;
    L8:
        updateCounter(r11);
        return;
    L7:
        r11 = r10.getText().length();
        goto L8
    }

    private static void updateCounterContentDescription(@NonNull Context r10, @NonNull TextView r11, int r12, int r13, boolean r14) {
        if (r14 == false) goto L4;
        int r15 = R.string.character_counter_overflowed_content_description;
    L5:
        r11.setContentDescription(r10.getString(r15, new Object[]{Integer.valueOf(r12), Integer.valueOf(r13)}));
        return;
    L4:
        r15 = R.string.character_counter_content_description;
        goto L5
    }

    private void updateCounterTextAppearanceAndColor() {
        TextView r10 = this.counterView;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.counterOverflowed == false) goto L7;
        int r11 = this.counterOverflowTextAppearance;
    L8:
        setTextAppearanceCompatWithErrorFallback(r10, r11);
        if (this.counterOverflowed == true) goto L14;
        ColorStateList r12 = this.counterTextColor;
        if (r12 == null) goto L14;
        this.counterView.setTextColor(r12);
    L14:
        if (this.counterOverflowed == false) goto L20;
        ColorStateList r13 = this.counterOverflowTextColor;
        if (r13 == null) goto L21;
        this.counterView.setTextColor(r13);
        return;
    L21:
        return;
    L20:
        return;
    L7:
        r11 = this.counterTextAppearance;
        goto L8
    }

    private void updateCutout() {
        if (cutoutEnabled() == true) goto L5;
        return;
    L5:
        if (this.hintExpanded == false) goto L7;
        return;
    L7:
        if (this.boxLabelCutoutHeight == this.boxStrokeWidthPx) goto L12;
        closeCutout();
        openCutout();
        return;
    }

    private boolean updateDummyDrawables() {
        if (this.editText != null) goto L5;
        return false;
    L5:
        boolean r10 = true;
        if (shouldUpdateStartDummyDrawable() == false) goto L16;
        int r11 = this.startLayout.getMeasuredWidth() - this.editText.getPaddingLeft();
        if (this.startDummyDrawable != null) goto L10;
    L11:
        ColorDrawable r12 = new ColorDrawable();
        this.startDummyDrawable = r12;
        this.startDummyDrawableWidth = r11;
        r12.setBounds(0, 0, r11, 1);
    L12:
        Drawable[] r13 = TextViewCompat.a(this.editText);
        Drawable r14 = r13[0];
        Drawable r15 = this.startDummyDrawable;
        if (r14 == r15) goto L19;
        TextViewCompat.i(this.editText, r15, r13[1], r13[2], r13[3]);
    L18:
        boolean r16 = true;
    L21:
        if (shouldUpdateEndDummyDrawable() == false) goto L38;
        int r17 = this.suffixTextView.getMeasuredWidth() - this.editText.getPaddingRight();
        CheckableImageButton r18 = getEndIconToUpdateDummyDrawable();
        if (r18 == null) goto L25;
        r17 = (r17 + r18.getMeasuredWidth()) + e.b((ViewGroup.MarginLayoutParams) r18.getLayoutParams());
    L25:
        Drawable[] r19 = TextViewCompat.a(this.editText);
        Drawable r20 = this.endDummyDrawable;
        if (r20 != null) goto L28;
    L30:
        if (r20 != null) goto L32;
        ColorDrawable r21 = new ColorDrawable();
        this.endDummyDrawable = r21;
        this.endDummyDrawableWidth = r17;
        r21.setBounds(0, 0, r17, 1);
    L32:
        Drawable r22 = r19[2];
        Drawable r23 = this.endDummyDrawable;
        if (r22 == r23) goto L35;
        this.originalEditTextEndDrawable = r22;
        TextViewCompat.i(this.editText, r19[0], r19[1], r23, r19[3]);
    L44:
        return r10;
    L35:
        r10 = r16;
        goto L44
    L28:
        if (this.endDummyDrawableWidth == r17) goto L30;
        this.endDummyDrawableWidth = r17;
        r20.setBounds(0, 0, r17, 1);
        TextViewCompat.i(this.editText, r19[0], r19[1], this.endDummyDrawable, r19[3]);
        goto L44
    L38:
        if (this.endDummyDrawable == null) goto L45;
        Drawable[] r24 = TextViewCompat.a(this.editText);
        if (r24[2] != this.endDummyDrawable) goto L42;
        TextViewCompat.i(this.editText, r24[0], r24[1], this.originalEditTextEndDrawable, r24[3]);
    L43:
        this.endDummyDrawable = null;
        goto L44
    L42:
        r10 = r16;
        goto L43
    L45:
        return r16;
    L19:
        r16 = false;
        goto L21
    L10:
        if (this.startDummyDrawableWidth == r11) goto L12;
    L16:
        if (this.startDummyDrawable == null) goto L19;
        Drawable[] r25 = TextViewCompat.a(this.editText);
        TextViewCompat.i(this.editText, null, r25[1], r25[2], r25[3]);
        this.startDummyDrawable = null;
        goto L18
    }

    private boolean updateEditTextHeightBasedOnIcon() {
        if (this.editText != null) goto L5;
        return false;
    L5:
        int r10 = Math.max(this.endLayout.getMeasuredHeight(), this.startLayout.getMeasuredHeight());
        if (this.editText.getMeasuredHeight() >= r10) goto L9;
        this.editText.setMinimumHeight(r10);
        return true;
    L9:
        return false;
    }

    private void updateInputLayoutMargins() {
        if (this.boxBackgroundMode == 1) goto L8;
        LinearLayout.LayoutParams r10 = (LinearLayout.LayoutParams) this.inputFrame.getLayoutParams();
        int r11 = calculateLabelMarginTop();
        if (r11 == r10.topMargin) goto L9;
        r10.topMargin = r11;
        this.inputFrame.requestLayout();
        return;
    L9:
        return;
    }

    private void updatePlaceholderMeasurementsBasedOnEditText() {
        if (this.placeholderTextView == null) goto L8;
        EditText r10 = this.editText;
        if (r10 == null) goto L9;
        int r11 = r10.getGravity();
        this.placeholderTextView.setGravity(r11);
        this.placeholderTextView.setPadding(this.editText.getCompoundPaddingLeft(), this.editText.getCompoundPaddingTop(), this.editText.getCompoundPaddingRight(), this.editText.getCompoundPaddingBottom());
        return;
    L9:
        return;
    }

    private void updatePlaceholderText() {
        EditText r10 = this.editText;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        updatePlaceholderText(r11);
        return;
    L5:
        r11 = r10.getText().length();
        goto L6
    }

    private void updatePrefixTextViewPadding() {
        if (this.editText != null) goto L6;
        return;
    L6:
        if (isStartIconVisible() == false) goto L8;
        int r10 = 0;
    L9:
        ViewCompat.D0(this.prefixTextView, r10, this.editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.editText.getCompoundPaddingBottom());
        return;
    L8:
        r10 = ViewCompat.F(this.editText);
        goto L9
    }

    private void updatePrefixTextVisibility() {
        TextView r10 = this.prefixTextView;
        if (this.prefixText != null) goto L5;
    L7:
        int r11 = 8;
    L8:
        r10.setVisibility(r11);
        updateDummyDrawables();
        return;
    L5:
        if (isHintExpanded() == true) goto L7;
        r11 = 0;
        goto L8
    }

    private void updateStrokeErrorColor(boolean r10, boolean r11) {
        int r12 = this.strokeErrorColor.getDefaultColor();
        int r13 = this.strokeErrorColor.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, r12);
        int r14 = this.strokeErrorColor.getColorForState(new int[]{android.R.attr.state_activated, android.R.attr.state_enabled}, r12);
        if (r10 == false) goto L5;
        this.boxStrokeColor = r14;
        return;
    L5:
        if (r11 == false) goto L7;
        this.boxStrokeColor = r13;
        return;
    L7:
        this.boxStrokeColor = r12;
    }

    private void updateSuffixTextViewPadding() {
        if (this.editText != null) goto L6;
        return;
    L6:
        if (isEndIconVisible() == false) goto L8;
    L11:
        int r10 = 0;
    L12:
        ViewCompat.D0(this.suffixTextView, getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.editText.getPaddingTop(), r10, this.editText.getPaddingBottom());
        return;
    L8:
        if (isErrorIconVisible() == true) goto L11;
        r10 = ViewCompat.E(this.editText);
        goto L12
    }

    private void updateSuffixTextVisibility() {
        int r10 = this.suffixTextView.getVisibility();
        int r11 = 0;
        if (this.suffixText != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        TextView r13 = this.suffixTextView;
        if (r12 == true) goto L12;
        r11 = 8;
    L12:
        r13.setVisibility(r11);
        if (r10 == this.suffixTextView.getVisibility()) goto L15;
        getEndIconDelegate().onSuffixVisibilityChanged(r12);
    L15:
        updateDummyDrawables();
        return;
    L5:
        if (isHintExpanded() == true) goto L7;
        r12 = true;
        goto L8
    }

    public void addOnEditTextAttachedListener(@NonNull OnEditTextAttachedListener r10) {
        this.editTextAttachedListeners.add(r10);
        if (this.editText == null) goto L6;
        r10.onEditTextAttached(this);
        return;
    }

    public void addOnEndIconChangedListener(@NonNull OnEndIconChangedListener r10) {
        this.endIconChangedListeners.add(r10);
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View r10, int r11, @NonNull ViewGroup.LayoutParams r12) {
        if ((r10 instanceof EditText) == false) goto L5;
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(r12);
        r13.gravity = (r13.gravity & NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH) | 16;
        this.inputFrame.addView(r10, r13);
        this.inputFrame.setLayoutParams(r12);
        updateInputLayoutMargins();
        setEditText((EditText) r10);
        return;
    L5:
        super.addView(r10, r11, r12);
    }

    @VisibleForTesting
    public void animateToExpansionFraction(float r10) {
        if (this.collapsingTextHelper.getExpansionFraction() != r10) goto L6;
        return;
    L6:
        if (this.animator != null) goto L8;
        ValueAnimator r11 = new ValueAnimator();
        this.animator = r11;
        r11.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        this.animator.setDuration(167);
        this.animator.addUpdateListener(new AnonymousClass4(this));
    L8:
        this.animator.setFloatValues(new float[]{this.collapsingTextHelper.getExpansionFraction(), r10});
        this.animator.start();
    }

    public void clearOnEditTextAttachedListeners() {
        this.editTextAttachedListeners.clear();
    }

    public void clearOnEndIconChangedListeners() {
        this.endIconChangedListeners.clear();
    }

    @VisibleForTesting
    public boolean cutoutIsOpen() {
        if (cutoutEnabled() == true) goto L5;
    L7:
        return false;
    L5:
        if (((CutoutDrawable) this.boxBackground).hasCutout() == false) goto L7;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(26)
    public void dispatchProvideAutofillStructure(@NonNull ViewStructure r10, int r11) {
        EditText r12 = this.editText;
        if (r12 != null) goto L6;
        super.dispatchProvideAutofillStructure(r10, r11);
        return;
    L6:
        int r13 = 0;
        if (this.originalHint == null) goto L14;
        boolean r14 = this.isProvidingHint;
        this.isProvidingHint = false;
        CharSequence r15 = r12.getHint();
        this.editText.setHint(this.originalHint);
        super.dispatchProvideAutofillStructure(r10, r11);     // Catch: Throwable -> L11
        this.editText.setHint(r15);
        this.isProvidingHint = r14;
        return;
    L11:
        th = move-exception;
        this.editText.setHint(r15);
        this.isProvidingHint = r14;
        throw th;
    L14:
        r10.setAutofillId(getAutofillId());
        onProvideAutofillStructure(r10, r11);
        onProvideAutofillVirtualStructure(r10, r11);
        r10.setChildCount(this.inputFrame.getChildCount());
    L16:
        if (r13 >= this.inputFrame.getChildCount()) goto L27;
        View r16 = this.inputFrame.getChildAt(r13);
        ViewStructure r17 = r10.newChild(r13);
        r16.dispatchProvideAutofillStructure(r17, r11);
        if (r16 != this.editText) goto L20;
        r17.setHint(getHint());
    L20:
        r13 = r13 + 1;
        goto L16
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(@NonNull SparseArray<Parcelable> r10) {
        this.restoringSavedState = true;
        super.dispatchRestoreInstanceState(r10);
        this.restoringSavedState = false;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas r10) {
        super.draw(r10);
        drawHint(r10);
        drawBoxUnderline(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.inDrawableStateChanged == false) goto L5;
        return;
    L5:
        boolean r10 = true;
        this.inDrawableStateChanged = true;
        super.drawableStateChanged();
        int[] r11 = getDrawableState();
        CollapsingTextHelper r12 = this.collapsingTextHelper;
        if (r12 == null) goto L8;
        boolean r13 = r12.setState(r11);
    L10:
        if (this.editText != null) goto L12;
    L18:
        updateEditTextBackground();
        updateTextInputBoxState();
        if (r13 == false) goto L21;
        invalidate();
    L21:
        this.inDrawableStateChanged = false;
        return;
    L12:
        if (ViewCompat.T(this) == true) goto L14;
    L16:
        r10 = false;
    L17:
        updateLabelState(r10);
        goto L18
    L14:
        if (isEnabled() == false) goto L16;
    L8:
        r13 = false;
        goto L10
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText r10 = this.editText;
        if (r10 == null) goto L7;
        return (r10.getBaseline() + getPaddingTop()) + calculateLabelMarginTop();
    L7:
        return super.getBaseline();
    }

    @NonNull
    public MaterialShapeDrawable getBoxBackground() {
        int r10 = this.boxBackgroundMode;
        if (r10 == 1) goto L10;
        if (r10 == 2) goto L10;
        throw new IllegalStateException();
    L10:
        return this.boxBackground;
    }

    public int getBoxBackgroundColor() {
        return this.boxBackgroundColor;
    }

    public int getBoxBackgroundMode() {
        return this.boxBackgroundMode;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.boxBackground.getBottomLeftCornerResolvedSize();
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.boxBackground.getBottomRightCornerResolvedSize();
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.boxBackground.getTopRightCornerResolvedSize();
    }

    public float getBoxCornerRadiusTopStart() {
        return this.boxBackground.getTopLeftCornerResolvedSize();
    }

    public int getBoxStrokeColor() {
        return this.focusedStrokeColor;
    }

    @Nullable
    public ColorStateList getBoxStrokeErrorColor() {
        return this.strokeErrorColor;
    }

    public int getBoxStrokeWidth() {
        return this.boxStrokeWidthDefaultPx;
    }

    public int getBoxStrokeWidthFocused() {
        return this.boxStrokeWidthFocusedPx;
    }

    public int getCounterMaxLength() {
        return this.counterMaxLength;
    }

    @Nullable
    public CharSequence getCounterOverflowDescription() {
        if (this.counterEnabled == true) goto L5;
        return null;
    L5:
        if (this.counterOverflowed == false) goto L12;
        TextView r10 = this.counterView;
        if (r10 != null) goto L9;
        return null;
    L9:
        return r10.getContentDescription();
    L12:
        return null;
    }

    @Nullable
    public ColorStateList getCounterOverflowTextColor() {
        return this.counterTextColor;
    }

    @Nullable
    public ColorStateList getCounterTextColor() {
        return this.counterTextColor;
    }

    @Nullable
    public ColorStateList getDefaultHintTextColor() {
        return this.defaultHintTextColor;
    }

    @Nullable
    public EditText getEditText() {
        return this.editText;
    }

    @Nullable
    public CharSequence getEndIconContentDescription() {
        return this.endIconView.getContentDescription();
    }

    @Nullable
    public Drawable getEndIconDrawable() {
        return this.endIconView.getDrawable();
    }

    public int getEndIconMode() {
        return this.endIconMode;
    }

    @NonNull
    public CheckableImageButton getEndIconView() {
        return this.endIconView;
    }

    @Nullable
    public CharSequence getError() {
        if (this.indicatorViewController.isErrorEnabled() == true) goto L7;
        return null;
    L7:
        return this.indicatorViewController.getErrorText();
    }

    @Nullable
    public CharSequence getErrorContentDescription() {
        return this.indicatorViewController.getErrorContentDescription();
    }

    @ColorInt
    public int getErrorCurrentTextColors() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    @Nullable
    public Drawable getErrorIconDrawable() {
        return this.errorIconView.getDrawable();
    }

    @VisibleForTesting
    public final int getErrorTextCurrentColor() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    @Nullable
    public CharSequence getHelperText() {
        if (this.indicatorViewController.isHelperTextEnabled() == true) goto L7;
        return null;
    L7:
        return this.indicatorViewController.getHelperText();
    }

    @ColorInt
    public int getHelperTextCurrentTextColor() {
        return this.indicatorViewController.getHelperTextViewCurrentTextColor();
    }

    @Nullable
    public CharSequence getHint() {
        if (this.hintEnabled == true) goto L7;
        return null;
    L7:
        return this.hint;
    }

    @VisibleForTesting
    public final float getHintCollapsedTextHeight() {
        return this.collapsingTextHelper.getCollapsedTextHeight();
    }

    @VisibleForTesting
    public final int getHintCurrentCollapsedTextColor() {
        return this.collapsingTextHelper.getCurrentCollapsedTextColor();
    }

    @Nullable
    public ColorStateList getHintTextColor() {
        return this.focusedTextColor;
    }

    @Px
    public int getMaxWidth() {
        return this.maxWidth;
    }

    @Px
    public int getMinWidth() {
        return this.minWidth;
    }

    @Nullable
    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.endIconView.getContentDescription();
    }

    @Nullable
    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.endIconView.getDrawable();
    }

    @Nullable
    public CharSequence getPlaceholderText() {
        if (this.placeholderEnabled == true) goto L7;
        return null;
    L7:
        return this.placeholderText;
    }

    @StyleRes
    public int getPlaceholderTextAppearance() {
        return this.placeholderTextAppearance;
    }

    @Nullable
    public ColorStateList getPlaceholderTextColor() {
        return this.placeholderTextColor;
    }

    @Nullable
    public CharSequence getPrefixText() {
        return this.prefixText;
    }

    @Nullable
    public ColorStateList getPrefixTextColor() {
        return this.prefixTextView.getTextColors();
    }

    @NonNull
    public TextView getPrefixTextView() {
        return this.prefixTextView;
    }

    @Nullable
    public CharSequence getStartIconContentDescription() {
        return this.startIconView.getContentDescription();
    }

    @Nullable
    public Drawable getStartIconDrawable() {
        return this.startIconView.getDrawable();
    }

    @Nullable
    public CharSequence getSuffixText() {
        return this.suffixText;
    }

    @Nullable
    public ColorStateList getSuffixTextColor() {
        return this.suffixTextView.getTextColors();
    }

    @NonNull
    public TextView getSuffixTextView() {
        return this.suffixTextView;
    }

    @Nullable
    public Typeface getTypeface() {
        return this.typeface;
    }

    public boolean isCounterEnabled() {
        return this.counterEnabled;
    }

    public boolean isEndIconCheckable() {
        return this.endIconView.isCheckable();
    }

    public boolean isEndIconVisible() {
        if (this.endIconFrame.getVisibility() == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.endIconView.getVisibility() != 0) goto L7;
        return true;
    }

    public boolean isErrorEnabled() {
        return this.indicatorViewController.isErrorEnabled();
    }

    public boolean isExpandedHintEnabled() {
        return this.expandedHintEnabled;
    }

    @VisibleForTesting
    public final boolean isHelperTextDisplayed() {
        return this.indicatorViewController.helperTextIsDisplayed();
    }

    public boolean isHelperTextEnabled() {
        return this.indicatorViewController.isHelperTextEnabled();
    }

    public boolean isHintAnimationEnabled() {
        return this.hintAnimationEnabled;
    }

    public boolean isHintEnabled() {
        return this.hintEnabled;
    }

    @VisibleForTesting
    public final boolean isHintExpanded() {
        return this.hintExpanded;
    }

    @Deprecated
    public boolean isPasswordVisibilityToggleEnabled() {
        if (this.endIconMode == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isProvidingHint() {
        return this.isProvidingHint;
    }

    public boolean isStartIconCheckable() {
        return this.startIconView.isCheckable();
    }

    public boolean isStartIconVisible() {
        if (this.startIconView.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        EditText r15 = this.editText;
        if (r15 == null) goto L12;
        Rect r16 = this.tmpRect;
        DescendantOffsetUtils.getDescendantRect(this, r15, r16);
        updateBoxUnderlineBounds(r16);
        if (this.hintEnabled == false) goto L13;
        this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
        int r17 = this.editText.getGravity();
        this.collapsingTextHelper.setCollapsedTextGravity((r17 & NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH) | 48);
        this.collapsingTextHelper.setExpandedTextGravity(r17);
        this.collapsingTextHelper.setCollapsedBounds(calculateCollapsedTextBounds(r16));
        this.collapsingTextHelper.setExpandedBounds(calculateExpandedTextBounds(r16));
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

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        boolean r12 = updateEditTextHeightBasedOnIcon();
        boolean r13 = updateDummyDrawables();
        if (r12 == true) goto L5;
        if (r13 == true) goto L5;
    L6:
        updatePlaceholderMeasurementsBasedOnEditText();
        updatePrefixTextViewPadding();
        updateSuffixTextViewPadding();
        return;
    L5:
        this.editText.post(new AnonymousClass3(this));
        goto L6
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        setError(r11.error);
        if (r11.isEndIconChecked == false) goto L9;
        this.endIconView.post(new AnonymousClass2(this));
    L9:
        setHint(r11.hintText);
        setHelperText(r11.helperText);
        setPlaceholderText(r11.placeholderText);
        requestLayout();
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        if (this.indicatorViewController.errorShouldBeShown() == false) goto L6;
        r10.error = getError();
    L6:
        if (hasEndIcon() == true) goto L8;
    L10:
        boolean r11 = false;
    L11:
        r10.isEndIconChecked = r11;
        r10.hintText = getHint();
        r10.helperText = getHelperText();
        r10.placeholderText = getPlaceholderText();
        return r10;
    L8:
        if (this.endIconView.isChecked() == false) goto L10;
        r11 = true;
        goto L11
    }

    @Deprecated
    public void passwordVisibilityToggleRequested(boolean r10) {
        if (this.endIconMode != 1) goto L8;
        this.endIconView.performClick();
        if (r10 == false) goto L9;
        this.endIconView.jumpDrawablesToCurrentState();
        return;
    L9:
        return;
    }

    public void refreshEndIconDrawableState() {
        refreshIconDrawableState(this.endIconView, this.endIconTintList);
    }

    public void refreshErrorIconDrawableState() {
        refreshIconDrawableState(this.errorIconView, this.errorIconTintList);
    }

    public void refreshStartIconDrawableState() {
        refreshIconDrawableState(this.startIconView, this.startIconTintList);
    }

    public void removeOnEditTextAttachedListener(@NonNull OnEditTextAttachedListener r10) {
        this.editTextAttachedListeners.remove(r10);
    }

    public void removeOnEndIconChangedListener(@NonNull OnEndIconChangedListener r10) {
        this.endIconChangedListeners.remove(r10);
    }

    public void setBoxBackgroundColor(@ColorInt int r10) {
        if (this.boxBackgroundColor == r10) goto L6;
        this.boxBackgroundColor = r10;
        this.defaultFilledBackgroundColor = r10;
        this.focusedFilledBackgroundColor = r10;
        this.hoveredFilledBackgroundColor = r10;
        applyBoxAttributes();
        return;
    }

    public void setBoxBackgroundColorResource(@ColorRes int r10) {
        setBoxBackgroundColor(ContextCompat.b(getContext(), r10));
    }

    public void setBoxBackgroundColorStateList(@NonNull ColorStateList r10) {
        int r11 = r10.getDefaultColor();
        this.defaultFilledBackgroundColor = r11;
        this.boxBackgroundColor = r11;
        this.disabledFilledBackgroundColor = r10.getColorForState(new int[]{-16842910}, -1);
        this.focusedFilledBackgroundColor = r10.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        this.hoveredFilledBackgroundColor = r10.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
        applyBoxAttributes();
    }

    public void setBoxBackgroundMode(int r10) {
        if (r10 != this.boxBackgroundMode) goto L5;
        return;
    L5:
        this.boxBackgroundMode = r10;
        if (this.editText == null) goto L9;
        onApplyBoxBackgroundMode();
        return;
    }

    public void setBoxCornerRadii(float r10, float r11, float r12, float r13) {
        MaterialShapeDrawable r14 = this.boxBackground;
        if (r14 != null) goto L5;
    L12:
        this.shapeAppearanceModel = this.shapeAppearanceModel.toBuilder().setTopLeftCornerSize(r10).setTopRightCornerSize(r11).setBottomRightCornerSize(r13).setBottomLeftCornerSize(r12).build();
        applyBoxAttributes();
        return;
    L5:
        if (r14.getTopLeftCornerResolvedSize() != r10) goto L12;
        if (this.boxBackground.getTopRightCornerResolvedSize() != r11) goto L12;
        if (this.boxBackground.getBottomRightCornerResolvedSize() != r13) goto L12;
        if (this.boxBackground.getBottomLeftCornerResolvedSize() != r12) goto L12;
    }

    public void setBoxCornerRadiiResources(@DimenRes int r10, @DimenRes int r11, @DimenRes int r12, @DimenRes int r13) {
        setBoxCornerRadii(getContext().getResources().getDimension(r10), getContext().getResources().getDimension(r11), getContext().getResources().getDimension(r13), getContext().getResources().getDimension(r12));
    }

    public void setBoxStrokeColor(@ColorInt int r10) {
        if (this.focusedStrokeColor == r10) goto L6;
        this.focusedStrokeColor = r10;
        updateTextInputBoxState();
        return;
    }

    public void setBoxStrokeColorStateList(@NonNull ColorStateList r10) {
        if (r10.isStateful() == false) goto L6;
        this.defaultStrokeColor = r10.getDefaultColor();
        this.disabledColor = r10.getColorForState(new int[]{-16842910}, -1);
        this.hoveredStrokeColor = r10.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
        this.focusedStrokeColor = r10.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
    L8:
        updateTextInputBoxState();
        return;
    L6:
        if (this.focusedStrokeColor == r10.getDefaultColor()) goto L8;
        this.focusedStrokeColor = r10.getDefaultColor();
        goto L8
    }

    public void setBoxStrokeErrorColor(@Nullable ColorStateList r10) {
        if (this.strokeErrorColor == r10) goto L6;
        this.strokeErrorColor = r10;
        updateTextInputBoxState();
        return;
    }

    public void setBoxStrokeWidth(int r10) {
        this.boxStrokeWidthDefaultPx = r10;
        updateTextInputBoxState();
    }

    public void setBoxStrokeWidthFocused(int r10) {
        this.boxStrokeWidthFocusedPx = r10;
        updateTextInputBoxState();
    }

    public void setBoxStrokeWidthFocusedResource(@DimenRes int r10) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(r10));
    }

    public void setBoxStrokeWidthResource(@DimenRes int r10) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(r10));
    }

    public void setCounterEnabled(boolean r10) {
        if (this.counterEnabled != r10) goto L5;
        return;
    L5:
        if (r10 == false) goto L10;
        AppCompatTextView r11 = new AppCompatTextView(getContext());
        this.counterView = r11;
        r11.setId(R.id.textinput_counter);
        Typeface r12 = this.typeface;
        if (r12 == null) goto L9;
        this.counterView.setTypeface(r12);
    L9:
        this.counterView.setMaxLines(1);
        this.indicatorViewController.addIndicator(this.counterView, 2);
        e.d((ViewGroup.MarginLayoutParams) this.counterView.getLayoutParams(), getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
        updateCounterTextAppearanceAndColor();
        updateCounter();
    L11:
        this.counterEnabled = r10;
        return;
    L10:
        this.indicatorViewController.removeIndicator(this.counterView, 2);
        this.counterView = null;
        goto L11
    }

    public void setCounterMaxLength(int r10) {
        if (this.counterMaxLength == r10) goto L11;
        if (r10 <= 0) goto L6;
        this.counterMaxLength = r10;
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

    public void setCounterOverflowTextAppearance(int r10) {
        if (this.counterOverflowTextAppearance == r10) goto L6;
        this.counterOverflowTextAppearance = r10;
        updateCounterTextAppearanceAndColor();
        return;
    }

    public void setCounterOverflowTextColor(@Nullable ColorStateList r10) {
        if (this.counterOverflowTextColor == r10) goto L6;
        this.counterOverflowTextColor = r10;
        updateCounterTextAppearanceAndColor();
        return;
    }

    public void setCounterTextAppearance(int r10) {
        if (this.counterTextAppearance == r10) goto L6;
        this.counterTextAppearance = r10;
        updateCounterTextAppearanceAndColor();
        return;
    }

    public void setCounterTextColor(@Nullable ColorStateList r10) {
        if (this.counterTextColor == r10) goto L6;
        this.counterTextColor = r10;
        updateCounterTextAppearanceAndColor();
        return;
    }

    public void setDefaultHintTextColor(@Nullable ColorStateList r10) {
        this.defaultHintTextColor = r10;
        this.focusedTextColor = r10;
        if (this.editText == null) goto L6;
        updateLabelState(false);
        return;
    }

    @Override // android.view.View
    public void setEnabled(boolean r10) {
        recursiveSetEnabled(this, r10);
        super.setEnabled(r10);
    }

    public void setEndIconActivated(boolean r10) {
        this.endIconView.setActivated(r10);
    }

    public void setEndIconCheckable(boolean r10) {
        this.endIconView.setCheckable(r10);
    }

    public void setEndIconContentDescription(@StringRes int r10) {
        if (r10 == 0) goto L4;
        CharSequence r11 = getResources().getText(r10);
    L5:
        setEndIconContentDescription(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    public void setEndIconDrawable(@DrawableRes int r10) {
        if (r10 == 0) goto L4;
        Drawable r11 = c.a.b(getContext(), r10);
    L5:
        setEndIconDrawable(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    public void setEndIconMode(int r10) {
        int r11 = this.endIconMode;
        this.endIconMode = r10;
        dispatchOnEndIconChanged(r11);
        if (r10 == 0) goto L5;
        boolean r12 = true;
    L6:
        setEndIconVisible(r12);
        if (getEndIconDelegate().isBoxBackgroundModeSupported(this.boxBackgroundMode) == false) goto L11;
        getEndIconDelegate().initialize();
        applyEndIconTint();
        return;
    L11:
        throw new IllegalStateException("The current box background mode " + this.boxBackgroundMode + " is not supported by the end icon mode " + r10);
    L5:
        r12 = false;
        goto L6
    }

    public void setEndIconOnClickListener(@Nullable View.OnClickListener r10) {
        setIconOnClickListener(this.endIconView, r10, this.endIconOnLongClickListener);
    }

    public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener r10) {
        this.endIconOnLongClickListener = r10;
        setIconOnLongClickListener(this.endIconView, r10);
    }

    public void setEndIconTintList(@Nullable ColorStateList r10) {
        if (this.endIconTintList == r10) goto L6;
        this.endIconTintList = r10;
        this.hasEndIconTintList = true;
        applyEndIconTint();
        return;
    }

    public void setEndIconTintMode(@Nullable PorterDuff.Mode r10) {
        if (this.endIconTintMode == r10) goto L6;
        this.endIconTintMode = r10;
        this.hasEndIconTintMode = true;
        applyEndIconTint();
        return;
    }

    public void setEndIconVisible(boolean r10) {
        if (isEndIconVisible() == r10) goto L10;
        CheckableImageButton r11 = this.endIconView;
        if (r10 == false) goto L7;
        int r12 = 0;
    L8:
        r11.setVisibility(r12);
        updateSuffixTextViewPadding();
        updateDummyDrawables();
        return;
    L7:
        r12 = 8;
        goto L8
    }

    public void setError(@Nullable CharSequence r10) {
        if (this.indicatorViewController.isErrorEnabled() == true) goto L9;
        if (TextUtils.isEmpty(r10) == false) goto L7;
        return;
    L7:
        setErrorEnabled(true);
    L9:
        if (TextUtils.isEmpty(r10) == true) goto L11;
        this.indicatorViewController.showError(r10);
        return;
    L11:
        this.indicatorViewController.hideError();
    }

    public void setErrorContentDescription(@Nullable CharSequence r10) {
        this.indicatorViewController.setErrorContentDescription(r10);
    }

    public void setErrorEnabled(boolean r10) {
        this.indicatorViewController.setErrorEnabled(r10);
    }

    public void setErrorIconDrawable(@DrawableRes int r10) {
        if (r10 == 0) goto L4;
        Drawable r11 = c.a.b(getContext(), r10);
    L5:
        setErrorIconDrawable(r11);
        refreshErrorIconDrawableState();
        return;
    L4:
        r11 = null;
        goto L5
    }

    public void setErrorIconOnClickListener(@Nullable View.OnClickListener r10) {
        setIconOnClickListener(this.errorIconView, r10, this.errorIconOnLongClickListener);
    }

    public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener r10) {
        this.errorIconOnLongClickListener = r10;
        setIconOnLongClickListener(this.errorIconView, r10);
    }

    public void setErrorIconTintList(@Nullable ColorStateList r10) {
        this.errorIconTintList = r10;
        Drawable r11 = this.errorIconView.getDrawable();
        if (r11 == null) goto L6;
        r11 = o.a.l(r11).mutate();
        o.a.i(r11, r10);
    L6:
        if (this.errorIconView.getDrawable() == r11) goto L9;
        this.errorIconView.setImageDrawable(r11);
        return;
    }

    public void setErrorIconTintMode(@Nullable PorterDuff.Mode r10) {
        Drawable r11 = this.errorIconView.getDrawable();
        if (r11 == null) goto L6;
        r11 = o.a.l(r11).mutate();
        o.a.j(r11, r10);
    L6:
        if (this.errorIconView.getDrawable() == r11) goto L9;
        this.errorIconView.setImageDrawable(r11);
        return;
    }

    public void setErrorTextAppearance(@StyleRes int r10) {
        this.indicatorViewController.setErrorTextAppearance(r10);
    }

    public void setErrorTextColor(@Nullable ColorStateList r10) {
        this.indicatorViewController.setErrorViewTextColor(r10);
    }

    public void setExpandedHintEnabled(boolean r10) {
        if (this.expandedHintEnabled == r10) goto L6;
        this.expandedHintEnabled = r10;
        updateLabelState(false);
        return;
    }

    public void setHelperText(@Nullable CharSequence r10) {
        if (TextUtils.isEmpty(r10) == false) goto L8;
        if (isHelperTextEnabled() == false) goto L12;
        setHelperTextEnabled(false);
        return;
    L12:
        return;
    L8:
        if (isHelperTextEnabled() == true) goto L10;
        setHelperTextEnabled(true);
    L10:
        this.indicatorViewController.showHelper(r10);
    }

    public void setHelperTextColor(@Nullable ColorStateList r10) {
        this.indicatorViewController.setHelperTextViewTextColor(r10);
    }

    public void setHelperTextEnabled(boolean r10) {
        this.indicatorViewController.setHelperTextEnabled(r10);
    }

    public void setHelperTextTextAppearance(@StyleRes int r10) {
        this.indicatorViewController.setHelperTextAppearance(r10);
    }

    public void setHint(@Nullable CharSequence r10) {
        if (this.hintEnabled == false) goto L6;
        setHintInternal(r10);
        sendAccessibilityEvent(2048);
        return;
    }

    public void setHintAnimationEnabled(boolean r10) {
        this.hintAnimationEnabled = r10;
    }

    public void setHintEnabled(boolean r10) {
        if (r10 == this.hintEnabled) goto L23;
        this.hintEnabled = r10;
        if (r10 == true) goto L12;
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
        CharSequence r11 = this.editText.getHint();
        if (TextUtils.isEmpty(r11) == false) goto L15;
    L18:
        this.isProvidingHint = true;
        goto L20
    L15:
        if (TextUtils.isEmpty(this.hint) == false) goto L17;
        setHint(r11);
    L17:
        this.editText.setHint(null);
        goto L18
    }

    public void setHintTextAppearance(@StyleRes int r10) {
        this.collapsingTextHelper.setCollapsedTextAppearance(r10);
        this.focusedTextColor = this.collapsingTextHelper.getCollapsedTextColor();
        if (this.editText == null) goto L6;
        updateLabelState(false);
        updateInputLayoutMargins();
        return;
    }

    public void setHintTextColor(@Nullable ColorStateList r10) {
        if (this.focusedTextColor != r10) goto L5;
        return;
    L5:
        if (this.defaultHintTextColor != null) goto L7;
        this.collapsingTextHelper.setCollapsedTextColor(r10);
    L7:
        this.focusedTextColor = r10;
        if (this.editText == null) goto L12;
        updateLabelState(false);
        return;
    }

    public void setMaxWidth(@Px int r10) {
        this.maxWidth = r10;
        EditText r11 = this.editText;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r10 == (-1)) goto L9;
        r11.setMaxWidth(r10);
        return;
    }

    public void setMaxWidthResource(@DimenRes int r10) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(r10));
    }

    public void setMinWidth(@Px int r10) {
        this.minWidth = r10;
        EditText r11 = this.editText;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r10 == (-1)) goto L9;
        r11.setMinWidth(r10);
        return;
    }

    public void setMinWidthResource(@DimenRes int r10) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(r10));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@StringRes int r10) {
        if (r10 == 0) goto L4;
        CharSequence r11 = getResources().getText(r10);
    L5:
        setPasswordVisibilityToggleContentDescription(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@DrawableRes int r10) {
        if (r10 == 0) goto L4;
        Drawable r11 = c.a.b(getContext(), r10);
    L5:
        setPasswordVisibilityToggleDrawable(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean r10) {
        if (r10 == true) goto L4;
    L6:
        if (r10 == true) goto L10;
        setEndIconMode(0);
        return;
    L10:
        return;
    L4:
        if (this.endIconMode == 1) goto L6;
        setEndIconMode(1);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList r10) {
        this.endIconTintList = r10;
        this.hasEndIconTintList = true;
        applyEndIconTint();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode r10) {
        this.endIconTintMode = r10;
        this.hasEndIconTintMode = true;
        applyEndIconTint();
    }

    public void setPlaceholderText(@Nullable CharSequence r10) {
        if (this.placeholderEnabled == false) goto L8;
        if (TextUtils.isEmpty(r10) == false) goto L8;
        setPlaceholderTextEnabled(false);
    L11:
        updatePlaceholderText();
        return;
    L8:
        if (this.placeholderEnabled == true) goto L10;
        setPlaceholderTextEnabled(true);
    L10:
        this.placeholderText = r10;
        goto L11
    }

    public void setPlaceholderTextAppearance(@StyleRes int r10) {
        this.placeholderTextAppearance = r10;
        TextView r11 = this.placeholderTextView;
        if (r11 == null) goto L6;
        TextViewCompat.n(r11, r10);
        return;
    }

    public void setPlaceholderTextColor(@Nullable ColorStateList r10) {
        if (this.placeholderTextColor == r10) goto L9;
        this.placeholderTextColor = r10;
        TextView r11 = this.placeholderTextView;
        if (r11 == null) goto L10;
        if (r10 == null) goto L11;
        r11.setTextColor(r10);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setPrefixText(@Nullable CharSequence r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        CharSequence r11 = null;
    L6:
        this.prefixText = r11;
        this.prefixTextView.setText(r10);
        updatePrefixTextVisibility();
        return;
    L5:
        r11 = r10;
        goto L6
    }

    public void setPrefixTextAppearance(@StyleRes int r10) {
        TextViewCompat.n(this.prefixTextView, r10);
    }

    public void setPrefixTextColor(@NonNull ColorStateList r10) {
        this.prefixTextView.setTextColor(r10);
    }

    public void setStartIconCheckable(boolean r10) {
        this.startIconView.setCheckable(r10);
    }

    public void setStartIconContentDescription(@StringRes int r10) {
        if (r10 == 0) goto L4;
        CharSequence r11 = getResources().getText(r10);
    L5:
        setStartIconContentDescription(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    public void setStartIconDrawable(@DrawableRes int r10) {
        if (r10 == 0) goto L4;
        Drawable r11 = c.a.b(getContext(), r10);
    L5:
        setStartIconDrawable(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    public void setStartIconOnClickListener(@Nullable View.OnClickListener r10) {
        setIconOnClickListener(this.startIconView, r10, this.startIconOnLongClickListener);
    }

    public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener r10) {
        this.startIconOnLongClickListener = r10;
        setIconOnLongClickListener(this.startIconView, r10);
    }

    public void setStartIconTintList(@Nullable ColorStateList r10) {
        if (this.startIconTintList == r10) goto L6;
        this.startIconTintList = r10;
        this.hasStartIconTintList = true;
        applyStartIconTint();
        return;
    }

    public void setStartIconTintMode(@Nullable PorterDuff.Mode r10) {
        if (this.startIconTintMode == r10) goto L6;
        this.startIconTintMode = r10;
        this.hasStartIconTintMode = true;
        applyStartIconTint();
        return;
    }

    public void setStartIconVisible(boolean r10) {
        if (isStartIconVisible() == r10) goto L10;
        CheckableImageButton r11 = this.startIconView;
        if (r10 == false) goto L7;
        int r12 = 0;
    L8:
        r11.setVisibility(r12);
        updatePrefixTextViewPadding();
        updateDummyDrawables();
        return;
    L7:
        r12 = 8;
        goto L8
    }

    public void setSuffixText(@Nullable CharSequence r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        CharSequence r11 = null;
    L6:
        this.suffixText = r11;
        this.suffixTextView.setText(r10);
        updateSuffixTextVisibility();
        return;
    L5:
        r11 = r10;
        goto L6
    }

    public void setSuffixTextAppearance(@StyleRes int r10) {
        TextViewCompat.n(this.suffixTextView, r10);
    }

    public void setSuffixTextColor(@NonNull ColorStateList r10) {
        this.suffixTextView.setTextColor(r10);
    }

    public void setTextAppearanceCompatWithErrorFallback(@NonNull TextView r10, @StyleRes int r11) {
        TextViewCompat.n(r10, r11);     // Catch: Exception -> L7
        if (r10.getTextColors().getDefaultColor() == (-65281)) goto L5;
        return;
    L5:
        TextViewCompat.n(r10, R.style.TextAppearance_AppCompat_Caption);
        r10.setTextColor(ContextCompat.b(getContext(), R.color.design_error));
    }

    public void setTextInputAccessibilityDelegate(@Nullable AccessibilityDelegate r10) {
        EditText r11 = this.editText;
        if (r11 == null) goto L6;
        ViewCompat.p0(r11, r10);
        return;
    }

    public void setTypeface(@Nullable Typeface r10) {
        if (r10 == this.typeface) goto L8;
        this.typeface = r10;
        this.collapsingTextHelper.setTypefaces(r10);
        this.indicatorViewController.setTypefaces(r10);
        TextView r11 = this.counterView;
        if (r11 == null) goto L9;
        r11.setTypeface(r10);
        return;
    L9:
        return;
    }

    public void updateEditTextBackground() {
        EditText r10 = this.editText;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.boxBackgroundMode != 0) goto L26;
        Drawable r11 = r10.getBackground();
        if (r11 != null) goto L11;
        return;
    L11:
        if (r.a(r11) == false) goto L14;
        r11 = r11.mutate();
    L14:
        if (this.indicatorViewController.errorShouldBeShown() == false) goto L17;
        r11.setColorFilter(f.e(this.indicatorViewController.getErrorViewCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        return;
    L17:
        if (this.counterOverflowed == false) goto L21;
        TextView r12 = this.counterView;
        if (r12 == null) goto L21;
        r11.setColorFilter(f.e(r12.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        return;
    L21:
        o.a.a(r11);
        this.editText.refreshDrawableState();
        return;
    }

    public void updateLabelState(boolean r10) {
        updateLabelState(r10, false);
    }

    public void updateTextInputBoxState() {
        if (this.boxBackground != null) goto L5;
        return;
    L5:
        if (this.boxBackgroundMode == 0) goto L79;
        boolean r10 = false;
        if (isFocused() == true) goto L15;
        EditText r11 = this.editText;
        if (r11 != null) goto L12;
    L14:
        boolean r12 = false;
    L17:
        if (isHovered() == true) goto L24;
        EditText r13 = this.editText;
        if (r13 != null) goto L21;
    L23:
        boolean r14 = false;
    L26:
        if (isEnabled() == true) goto L29;
        this.boxStrokeColor = this.disabledColor;
    L48:
        if (getErrorIconDrawable() != null) goto L50;
    L54:
        setErrorIconVisible(r10);
        refreshErrorIconDrawableState();
        refreshStartIconDrawableState();
        refreshEndIconDrawableState();
        if (getEndIconDelegate().shouldTintIconOnError() == false) goto L57;
        tintEndIconOnError(this.indicatorViewController.errorShouldBeShown());
    L57:
        if (r12 == true) goto L59;
    L61:
        this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
    L63:
        if (this.boxBackgroundMode != 2) goto L66;
        updateCutout();
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
        if (r14 == false) goto L73;
        if (r12 == true) goto L73;
        this.boxBackgroundColor = this.hoveredFilledBackgroundColor;
    L73:
        if (r12 == false) goto L75;
        this.boxBackgroundColor = this.focusedFilledBackgroundColor;
        goto L76
    L75:
        this.boxBackgroundColor = this.defaultFilledBackgroundColor;
        goto L76
    L59:
        if (isEnabled() == false) goto L61;
        this.boxStrokeWidthPx = this.boxStrokeWidthFocusedPx;
        goto L63
    L50:
        if (this.indicatorViewController.isErrorEnabled() == false) goto L54;
        if (this.indicatorViewController.errorShouldBeShown() == false) goto L54;
        r10 = true;
        goto L54
    L29:
        if (this.indicatorViewController.errorShouldBeShown() == false) goto L35;
        if (this.strokeErrorColor == null) goto L33;
        updateStrokeErrorColor(r12, r14);
        goto L48
    L33:
        this.boxStrokeColor = this.indicatorViewController.getErrorViewCurrentTextColor();
        goto L48
    L35:
        if (this.counterOverflowed == false) goto L42;
        TextView r15 = this.counterView;
        if (r15 == null) goto L42;
        if (this.strokeErrorColor == null) goto L41;
        updateStrokeErrorColor(r12, r14);
        goto L48
    L41:
        this.boxStrokeColor = r15.getCurrentTextColor();
    L42:
        if (r12 == false) goto L44;
        this.boxStrokeColor = this.focusedStrokeColor;
        goto L48
    L44:
        if (r14 == false) goto L46;
        this.boxStrokeColor = this.hoveredStrokeColor;
        goto L48
    L46:
        this.boxStrokeColor = this.defaultStrokeColor;
        goto L48
    L21:
        if (r13.isHovered() == false) goto L23;
    L24:
        r14 = true;
        goto L26
    L12:
        if (r11.hasFocus() == false) goto L14;
    L15:
        r12 = true;
        goto L17
    }

    public TextInputLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.textInputStyle);
    }

    private void updateLabelState(boolean r10, boolean r11) {
        boolean r12 = isEnabled();
        EditText r13 = this.editText;
        boolean r14 = false;
        if (r13 != null) goto L5;
    L7:
        boolean r15 = false;
    L8:
        EditText r16 = this.editText;
        if (r16 != null) goto L11;
    L13:
        boolean r17 = this.indicatorViewController.errorShouldBeShown();
        ColorStateList r18 = this.defaultHintTextColor;
        if (r18 == null) goto L16;
        this.collapsingTextHelper.setCollapsedTextColor(r18);
        this.collapsingTextHelper.setExpandedTextColor(this.defaultHintTextColor);
    L16:
        if (r12 == true) goto L22;
        ColorStateList r19 = this.defaultHintTextColor;
        if (r19 == null) goto L20;
        int r20 = r19.getColorForState(new int[]{-16842910}, this.disabledColor);
    L21:
        this.collapsingTextHelper.setCollapsedTextColor(ColorStateList.valueOf(r20));
        this.collapsingTextHelper.setExpandedTextColor(ColorStateList.valueOf(r20));
    L33:
        if (r15 == false) goto L35;
    L44:
        if (r11 == false) goto L46;
    L47:
        collapseHint(r10);
        return;
    L46:
        if (this.hintExpanded == true) goto L47;
        return;
    L35:
        if (this.expandedHintEnabled == false) goto L44;
        if (isEnabled() == false) goto L40;
        if (r14 == true) goto L44;
    L40:
        if (r11 == false) goto L42;
    L43:
        expandHint(r10);
        return;
    L42:
        if (this.hintExpanded == false) goto L43;
        return;
    L20:
        r20 = this.disabledColor;
        goto L21
    L22:
        if (r17 == false) goto L25;
        this.collapsingTextHelper.setCollapsedTextColor(this.indicatorViewController.getErrorViewTextColors());
        goto L33
    L25:
        if (this.counterOverflowed == false) goto L29;
        TextView r21 = this.counterView;
        if (r21 == null) goto L29;
        this.collapsingTextHelper.setCollapsedTextColor(r21.getTextColors());
    L29:
        if (r14 == false) goto L33;
        ColorStateList r22 = this.focusedTextColor;
        if (r22 == null) goto L33;
        this.collapsingTextHelper.setCollapsedTextColor(r22);
        goto L33
    L11:
        if (r16.hasFocus() == false) goto L13;
        r14 = true;
        goto L13
    L5:
        if (TextUtils.isEmpty(r13.getText()) == true) goto L7;
        r15 = true;
        goto L8
    }

    private void updatePlaceholderText(int r10) {
        if (r10 == 0) goto L4;
    L6:
        hidePlaceholderText();
        return;
    L4:
        if (this.hintExpanded == true) goto L6;
        showPlaceholderText();
    }

    public void setEndIconContentDescription(@Nullable CharSequence r10) {
        if (getEndIconContentDescription() == r10) goto L6;
        this.endIconView.setContentDescription(r10);
        return;
    }

    public void setEndIconDrawable(@Nullable Drawable r10) {
        this.endIconView.setImageDrawable(r10);
        refreshEndIconDrawableState();
    }

    public void setStartIconContentDescription(@Nullable CharSequence r10) {
        if (getStartIconContentDescription() == r10) goto L6;
        this.startIconView.setContentDescription(r10);
        return;
    }

    public void setStartIconDrawable(@Nullable Drawable r10) {
        this.startIconView.setImageDrawable(r10);
        if (r10 == null) goto L5;
        setStartIconVisible(true);
        refreshStartIconDrawableState();
        return;
    L5:
        setStartIconVisible(false);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        setStartIconContentDescription(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v48, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v89 */
    public TextInputLayout(@NonNull Context r28, @Nullable AttributeSet r29, int r30) {
        int r10 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r28, r29, r30, r10), r29, r30);
        this.minWidth = -1;
        this.maxWidth = -1;
        this.indicatorViewController = new IndicatorViewController(this);
        this.tmpRect = new Rect();
        this.tmpBoundsRect = new Rect();
        this.tmpRectF = new RectF();
        this.editTextAttachedListeners = new LinkedHashSet();
        this.endIconMode = 0;
        SparseArray<EndIconDelegate> r12 = new SparseArray();
        this.endIconDelegates = r12;
        this.endIconChangedListeners = new LinkedHashSet();
        CollapsingTextHelper r11 = new CollapsingTextHelper(this);
        this.collapsingTextHelper = r11;
        Context r13 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout r14 = new FrameLayout(r13);
        this.inputFrame = r14;
        r14.setAddStatesFromChildren(true);
        addView(r14);
        LinearLayout r15 = new LinearLayout(r13);
        this.startLayout = r15;
        r15.setOrientation(0);
        r15.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        r14.addView(r15);
        LinearLayout r16 = new LinearLayout(r13);
        this.endLayout = r16;
        r16.setOrientation(0);
        r16.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        r14.addView(r16);
        FrameLayout r17 = new FrameLayout(r13);
        this.endIconFrame = r17;
        r17.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        TimeInterpolator r18 = AnimationUtils.LINEAR_INTERPOLATOR;
        r11.setTextSizeInterpolator(r18);
        r11.setPositionInterpolator(r18);
        r11.setCollapsedTextGravity(BadgeDrawable.TOP_START);
        int[] r19 = R.styleable.TextInputLayout;
        int r20 = R.styleable.TextInputLayout_counterTextAppearance;
        int r21 = R.styleable.TextInputLayout_counterOverflowTextAppearance;
        int r110 = R.styleable.TextInputLayout_errorTextAppearance;
        int r111 = R.styleable.TextInputLayout_helperTextTextAppearance;
        int r112 = R.styleable.TextInputLayout_hintTextAppearance;
        b0 r22 = ThemeEnforcement.obtainTintedStyledAttributes(r13, r29, r19, r30, r10, new int[]{r20, r21, r110, r111, r112});
        this.hintEnabled = r22.a(R.styleable.TextInputLayout_hintEnabled, true);
        setHint(r22.p(R.styleable.TextInputLayout_android_hint));
        this.hintAnimationEnabled = r22.a(R.styleable.TextInputLayout_hintAnimationEnabled, true);
        this.expandedHintEnabled = r22.a(R.styleable.TextInputLayout_expandedHintEnabled, true);
        int r23 = R.styleable.TextInputLayout_android_minWidth;
        if (r22.s(r23) == false) goto L5;
        int r24 = -1;
        setMinWidth(r22.f(r23, -1));
    L6:
        int r25 = R.styleable.TextInputLayout_android_maxWidth;
        if (r22.s(r25) == false) goto L9;
        setMaxWidth(r22.f(r25, r24));
    L9:
        this.shapeAppearanceModel = ShapeAppearanceModel.builder(r13, r29, r30, r10).build();
        this.boxLabelCutoutPaddingPx = r13.getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.boxCollapsedPaddingTopPx = r22.e(R.styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.boxStrokeWidthDefaultPx = r22.f(R.styleable.TextInputLayout_boxStrokeWidth, r13.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_default));
        this.boxStrokeWidthFocusedPx = r22.f(R.styleable.TextInputLayout_boxStrokeWidthFocused, r13.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
        float r26 = r22.d(R.styleable.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float r27 = r22.d(R.styleable.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float r31 = r22.d(R.styleable.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float r32 = r22.d(R.styleable.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        ShapeAppearanceModel.Builder r33 = this.shapeAppearanceModel.toBuilder();
        if (r26 < 0.0f) goto L13;
        r33.setTopLeftCornerSize(r26);
    L13:
        if (r27 < 0.0f) goto L16;
        r33.setTopRightCornerSize(r27);
    L16:
        if (r31 < 0.0f) goto L19;
        r33.setBottomRightCornerSize(r31);
    L19:
        if (r32 < 0.0f) goto L21;
        r33.setBottomLeftCornerSize(r32);
    L21:
        this.shapeAppearanceModel = r33.build();
        ColorStateList r34 = MaterialResources.getColorStateList(r13, r22, R.styleable.TextInputLayout_boxBackgroundColor);
        if (r34 == null) goto L27;
        int r35 = r34.getDefaultColor();
        this.defaultFilledBackgroundColor = r35;
        this.boxBackgroundColor = r35;
        if (r34.isStateful() == false) goto L26;
        this.disabledFilledBackgroundColor = r34.getColorForState(new int[]{-16842910}, -1);
        this.focusedFilledBackgroundColor = r34.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        this.hoveredFilledBackgroundColor = r34.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
    L28:
        int r36 = R.styleable.TextInputLayout_android_textColorHint;
        if (r22.s(r36) == false) goto L31;
        ColorStateList r37 = r22.c(r36);
        this.focusedTextColor = r37;
        this.defaultHintTextColor = r37;
    L31:
        int r38 = R.styleable.TextInputLayout_boxStrokeColor;
        ColorStateList r39 = MaterialResources.getColorStateList(r13, r22, r38);
        this.focusedStrokeColor = r22.b(r38, 0);
        this.defaultStrokeColor = ContextCompat.b(r13, R.color.mtrl_textinput_default_box_stroke_color);
        this.disabledColor = ContextCompat.b(r13, R.color.mtrl_textinput_disabled_color);
        this.hoveredStrokeColor = ContextCompat.b(r13, R.color.mtrl_textinput_hovered_box_stroke_color);
        if (r39 == null) goto L34;
        setBoxStrokeColorStateList(r39);
    L34:
        int r40 = R.styleable.TextInputLayout_boxStrokeErrorColor;
        if (r22.s(r40) == false) goto L38;
        setBoxStrokeErrorColor(MaterialResources.getColorStateList(r13, r22, r40));
    L38:
        if (r22.n(r112, -1) == (-1)) goto L40;
        ?? r41 = 0;
        setHintTextAppearance(r22.n(r112, 0));
    L41:
        int r42 = r22.n(r110, r41);
        CharSequence r43 = r22.p(R.styleable.TextInputLayout_errorContentDescription);
        boolean r44 = r22.a(R.styleable.TextInputLayout_errorEnabled, r41);
        LayoutInflater r45 = LayoutInflater.from(getContext());
        int r46 = R.layout.design_text_input_end_icon;
        CheckableImageButton r47 = (CheckableImageButton) r45.inflate(r46, r16, r41);
        this.errorIconView = r47;
        r47.setId(R.id.text_input_error_icon);
        r47.setVisibility(8);
        if (MaterialResources.isFontScaleAtLeast1_3(r13) == false) goto L44;
        e.d((ViewGroup.MarginLayoutParams) r47.getLayoutParams(), r41);
    L44:
        int r48 = R.styleable.TextInputLayout_errorIconDrawable;
        if (r22.s(r48) == false) goto L47;
        setErrorIconDrawable(r22.g(r48));
    L47:
        int r49 = R.styleable.TextInputLayout_errorIconTint;
        if (r22.s(r49) == false) goto L50;
        setErrorIconTintList(MaterialResources.getColorStateList(r13, r22, r49));
    L50:
        int r50 = R.styleable.TextInputLayout_errorIconTintMode;
        if (r22.s(r50) == false) goto L53;
        setErrorIconTintMode(ViewUtils.parseTintMode(r22.k(r50, -1), null));
    L53:
        r47.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        ViewCompat.A0(r47, 2);
        r47.setClickable(false);
        r47.setPressable(false);
        r47.setFocusable(false);
        int r113 = r22.n(r111, 0);
        boolean r114 = r22.a(R.styleable.TextInputLayout_helperTextEnabled, false);
        CharSequence r51 = r22.p(R.styleable.TextInputLayout_helperText);
        int r115 = r22.n(R.styleable.TextInputLayout_placeholderTextAppearance, 0);
        CharSequence r52 = r22.p(R.styleable.TextInputLayout_placeholderText);
        int r116 = r22.n(R.styleable.TextInputLayout_prefixTextAppearance, 0);
        CharSequence r53 = r22.p(R.styleable.TextInputLayout_prefixText);
        int r117 = r22.n(R.styleable.TextInputLayout_suffixTextAppearance, 0);
        CharSequence r54 = r22.p(R.styleable.TextInputLayout_suffixText);
        boolean r118 = r22.a(R.styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(r22.k(R.styleable.TextInputLayout_counterMaxLength, -1));
        this.counterTextAppearance = r22.n(r20, 0);
        this.counterOverflowTextAppearance = r22.n(r21, 0);
        CheckableImageButton r119 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, r15, false);
        this.startIconView = r119;
        r119.setVisibility(8);
        if (MaterialResources.isFontScaleAtLeast1_3(r13) == false) goto L56;
        e.c((ViewGroup.MarginLayoutParams) r119.getLayoutParams(), 0);
    L56:
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        int r55 = R.styleable.TextInputLayout_startIconDrawable;
        if (r22.s(r55) == false) goto L62;
        setStartIconDrawable(r22.g(r55));
        int r56 = R.styleable.TextInputLayout_startIconContentDescription;
        if (r22.s(r56) == false) goto L61;
        setStartIconContentDescription(r22.p(r56));
    L61:
        setStartIconCheckable(r22.a(R.styleable.TextInputLayout_startIconCheckable, true));
    L62:
        int r57 = R.styleable.TextInputLayout_startIconTint;
        if (r22.s(r57) == false) goto L65;
        setStartIconTintList(MaterialResources.getColorStateList(r13, r22, r57));
    L65:
        int r58 = R.styleable.TextInputLayout_startIconTintMode;
        if (r22.s(r58) == false) goto L68;
        setStartIconTintMode(ViewUtils.parseTintMode(r22.k(r58, -1), null));
    L68:
        setBoxBackgroundMode(r22.k(R.styleable.TextInputLayout_boxBackgroundMode, 0));
        CheckableImageButton r59 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(r46, r17, false);
        this.endIconView = r59;
        r17.addView(r59);
        r59.setVisibility(8);
        if (MaterialResources.isFontScaleAtLeast1_3(r13) == false) goto L71;
        e.d((ViewGroup.MarginLayoutParams) r59.getLayoutParams(), 0);
    L71:
        r12.append(-1, new CustomEndIconDelegate(this));
        r12.append(0, new NoEndIconDelegate(this));
        r12.append(1, new PasswordToggleEndIconDelegate(this));
        r12.append(2, new ClearTextEndIconDelegate(this));
        r12.append(3, new DropdownMenuEndIconDelegate(this));
        int r60 = R.styleable.TextInputLayout_endIconMode;
        if (r22.s(r60) == false) goto L80;
        setEndIconMode(r22.k(r60, 0));
        int r61 = R.styleable.TextInputLayout_endIconDrawable;
        if (r22.s(r61) == false) goto L76;
        setEndIconDrawable(r22.g(r61));
    L76:
        int r62 = R.styleable.TextInputLayout_endIconContentDescription;
        if (r22.s(r62) == false) goto L79;
        setEndIconContentDescription(r22.p(r62));
    L79:
        setEndIconCheckable(r22.a(R.styleable.TextInputLayout_endIconCheckable, true));
    L89:
        if (r22.s(R.styleable.TextInputLayout_passwordToggleEnabled) == true) goto L96;
        int r63 = R.styleable.TextInputLayout_endIconTint;
        if (r22.s(r63) == false) goto L93;
        setEndIconTintList(MaterialResources.getColorStateList(r13, r22, r63));
    L93:
        int r64 = R.styleable.TextInputLayout_endIconTintMode;
        if (r22.s(r64) == false) goto L96;
        setEndIconTintMode(ViewUtils.parseTintMode(r22.k(r64, -1), null));
    L96:
        AppCompatTextView r65 = new AppCompatTextView(r13);
        this.prefixTextView = r65;
        r65.setId(R.id.textinput_prefix_text);
        r65.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        ViewCompat.r0(r65, 1);
        r15.addView(r119);
        r15.addView(r65);
        AppCompatTextView r66 = new AppCompatTextView(r13);
        this.suffixTextView = r66;
        r66.setId(R.id.textinput_suffix_text);
        r66.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        ViewCompat.r0(r66, 1);
        r16.addView(r66);
        r16.addView(r47);
        r16.addView(r17);
        setHelperTextEnabled(r114);
        setHelperText(r51);
        setHelperTextTextAppearance(r113);
        setErrorEnabled(r44);
        setErrorTextAppearance(r42);
        setErrorContentDescription(r43);
        setCounterTextAppearance(this.counterTextAppearance);
        setCounterOverflowTextAppearance(this.counterOverflowTextAppearance);
        setPlaceholderText(r52);
        setPlaceholderTextAppearance(r115);
        setPrefixText(r53);
        setPrefixTextAppearance(r116);
        setSuffixText(r54);
        setSuffixTextAppearance(r117);
        int r67 = R.styleable.TextInputLayout_errorTextColor;
        if (r22.s(r67) == false) goto L99;
        setErrorTextColor(r22.c(r67));
    L99:
        int r68 = R.styleable.TextInputLayout_helperTextTextColor;
        if (r22.s(r68) == false) goto L102;
        setHelperTextColor(r22.c(r68));
    L102:
        int r69 = R.styleable.TextInputLayout_hintTextColor;
        if (r22.s(r69) == false) goto L105;
        setHintTextColor(r22.c(r69));
    L105:
        int r70 = R.styleable.TextInputLayout_counterTextColor;
        if (r22.s(r70) == false) goto L108;
        setCounterTextColor(r22.c(r70));
    L108:
        int r71 = R.styleable.TextInputLayout_counterOverflowTextColor;
        if (r22.s(r71) == false) goto L111;
        setCounterOverflowTextColor(r22.c(r71));
    L111:
        int r72 = R.styleable.TextInputLayout_placeholderTextColor;
        if (r22.s(r72) == false) goto L114;
        setPlaceholderTextColor(r22.c(r72));
    L114:
        int r73 = R.styleable.TextInputLayout_prefixTextColor;
        if (r22.s(r73) == false) goto L117;
        setPrefixTextColor(r22.c(r73));
    L117:
        int r74 = R.styleable.TextInputLayout_suffixTextColor;
        if (r22.s(r74) == false) goto L120;
        setSuffixTextColor(r22.c(r74));
    L120:
        setCounterEnabled(r118);
        setEnabled(r22.a(R.styleable.TextInputLayout_android_enabled, true));
        r22.w();
        ViewCompat.A0(this, 2);
        ViewCompat.B0(this, 1);
        return;
    L80:
        int r75 = R.styleable.TextInputLayout_passwordToggleEnabled;
        if (r22.s(r75) == false) goto L89;
        setEndIconMode(r22.a(r75, false) ? 1 : 0);
        setEndIconDrawable(r22.g(R.styleable.TextInputLayout_passwordToggleDrawable));
        setEndIconContentDescription(r22.p(R.styleable.TextInputLayout_passwordToggleContentDescription));
        int r76 = R.styleable.TextInputLayout_passwordToggleTint;
        if (r22.s(r76) == false) goto L85;
        setEndIconTintList(MaterialResources.getColorStateList(r13, r22, r76));
    L85:
        int r77 = R.styleable.TextInputLayout_passwordToggleTintMode;
        if (r22.s(r77) == false) goto L89;
        setEndIconTintMode(ViewUtils.parseTintMode(r22.k(r77, -1), null));
        goto L89
    L40:
        r41 = 0;
        goto L41
    L26:
        this.focusedFilledBackgroundColor = this.defaultFilledBackgroundColor;
        ColorStateList r78 = c.a.a(r13, R.color.mtrl_filled_background_color);
        this.disabledFilledBackgroundColor = r78.getColorForState(new int[]{-16842910}, -1);
        this.hoveredFilledBackgroundColor = r78.getColorForState(new int[]{android.R.attr.state_hovered}, -1);
        goto L28
    L27:
        this.boxBackgroundColor = 0;
        this.defaultFilledBackgroundColor = 0;
        this.disabledFilledBackgroundColor = 0;
        this.focusedFilledBackgroundColor = 0;
        this.hoveredFilledBackgroundColor = 0;
        goto L28
    L5:
        r24 = -1;
        goto L6
    }

    public void setErrorIconDrawable(@Nullable Drawable r10) {
        this.errorIconView.setImageDrawable(r10);
        if (r10 != null) goto L5;
    L7:
        boolean r11 = false;
    L8:
        setErrorIconVisible(r11);
        return;
    L5:
        if (this.indicatorViewController.isErrorEnabled() == false) goto L7;
        r11 = true;
        goto L8
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence r10) {
        this.endIconView.setContentDescription(r10);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable r10) {
        this.endIconView.setImageDrawable(r10);
    }

    public void updateCounter(int r10) {
        boolean r11 = this.counterOverflowed;
        int r12 = this.counterMaxLength;
        if (r12 != (-1)) goto L5;
        this.counterView.setText(String.valueOf(r10));
        this.counterView.setContentDescription(null);
        this.counterOverflowed = false;
    L13:
        if (this.editText != null) goto L15;
        return;
    L15:
        if (r11 == this.counterOverflowed) goto L19;
        updateLabelState(false);
        updateTextInputBoxState();
        updateEditTextBackground();
        return;
    L19:
        return;
    L5:
        if (r10 <= r12) goto L7;
        boolean r13 = true;
    L8:
        this.counterOverflowed = r13;
        updateCounterContentDescription(getContext(), this.counterView, r10, this.counterMaxLength, this.counterOverflowed);
        if (r11 == this.counterOverflowed) goto L11;
        updateCounterTextAppearanceAndColor();
    L11:
        this.counterView.setText(androidx.core.text.a.c().j(getContext().getString(R.string.character_counter_pattern, new Object[]{Integer.valueOf(r10), Integer.valueOf(this.counterMaxLength)})));
        goto L13
    L7:
        r13 = false;
        goto L8
    }

    public void setHint(@StringRes int r10) {
        if (r10 == 0) goto L4;
        CharSequence r11 = getResources().getText(r10);
    L5:
        setHint(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }
}
