package com.google.android.material.chip;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.AnimatorRes;
import androidx.annotation.BoolRes;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.a;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class Chip extends AppCompatCheckBox implements ChipDrawable.Delegate, Shapeable {
    private static final String BUTTON_ACCESSIBILITY_CLASS_NAME = "android.widget.Button";
    private static final int[] CHECKABLE_STATE_SET = null;
    private static final int CHIP_BODY_VIRTUAL_ID = 0;
    private static final int CLOSE_ICON_VIRTUAL_ID = 1;
    private static final String COMPOUND_BUTTON_ACCESSIBILITY_CLASS_NAME = "android.widget.CompoundButton";
    private static final int DEF_STYLE_RES = 0;
    private static final Rect EMPTY_BOUNDS = null;
    private static final String GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME = "android.view.View";
    private static final int MIN_TOUCH_TARGET_DP = 48;
    private static final String NAMESPACE_ANDROID = "http://schemas.android.com/apk/res/android";
    private static final int[] SELECTED_STATE = null;
    private static final String TAG = "Chip";

    @Nullable
    private ChipDrawable chipDrawable;
    private boolean closeIconFocused;
    private boolean closeIconHovered;
    private boolean closeIconPressed;
    private boolean deferredCheckedValue;
    private boolean ensureMinTouchTargetSize;
    private final TextAppearanceFontCallback fontCallback;

    @Nullable
    private InsetDrawable insetBackgroundDrawable;
    private int lastLayoutDirection;

    @Dimension(unit = 1)
    private int minTouchTargetSize;

    @Nullable
    private CompoundButton.OnCheckedChangeListener onCheckedChangeListenerInternal;

    @Nullable
    private View.OnClickListener onCloseIconClickListener;
    private final Rect rect;
    private final RectF rectF;

    @Nullable
    private RippleDrawable ripple;

    @NonNull
    private final ChipTouchHelper touchHelper;

    public class ChipTouchHelper extends a {
        final /* synthetic */ Chip this$0;

        public ChipTouchHelper(Chip r10, Chip r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // androidx.customview.widget.a
        public int getVirtualViewAt(float r10, float r11) {
            if (Chip.access$100(this.this$0) == true) goto L5;
        L7:
            return 0;
        L5:
            if (Chip.access$200(this.this$0).contains(r10, r11) == false) goto L7;
            return 1;
        }

        @Override // androidx.customview.widget.a
        public void getVisibleVirtualViews(@NonNull List<Integer> r10) {
            r10.add(0);
            if (Chip.access$100(this.this$0) == true) goto L5;
            return;
        L5:
            if (this.this$0.isCloseIconVisible() == true) goto L7;
            return;
        L7:
            if (Chip.access$300(this.this$0) == null) goto L12;
            r10.add(1);
            return;
        }

        @Override // androidx.customview.widget.a
        public boolean onPerformActionForVirtualView(int r10, int r11, Bundle r12) {
            if (r11 != 16) goto L11;
            if (r10 != 0) goto L8;
            return this.this$0.performClick();
        L8:
            if (r10 == 1) goto L10;
            return false;
        L10:
            return this.this$0.performCloseIconClick();
        L11:
            return false;
        }

        @Override // androidx.customview.widget.a
        public void onPopulateNodeForHost(@NonNull AccessibilityNodeInfoCompat r10) {
            r10.T(this.this$0.isCheckable());
            r10.W(this.this$0.isClickable());
            if (this.this$0.isCheckable() == true) goto L9;
            if (this.this$0.isClickable() == true) goto L9;
            r10.V(Chip.GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME);
        L13:
            r10.x0(this.this$0.getText());
            return;
        L9:
            if (this.this$0.isCheckable() == false) goto L11;
            String r11 = Chip.COMPOUND_BUTTON_ACCESSIBILITY_CLASS_NAME;
        L12:
            r10.V(r11);
            goto L13
        L11:
            r11 = Chip.BUTTON_ACCESSIBILITY_CLASS_NAME;
            goto L12
        }

        @Override // androidx.customview.widget.a
        public void onPopulateNodeForVirtualView(int r10, @NonNull AccessibilityNodeInfoCompat r11) {
            CharSequence r12 = "";
            if (r10 != 1) goto L12;
            CharSequence r13 = this.this$0.getCloseIconContentDescription();
            if (r13 == null) goto L7;
            r11.Z(r13);
        L11:
            r11.Q(Chip.access$500(this.this$0));
            r11.b(AccessibilityNodeInfoCompat.a.f2742i);
            r11.b0(this.this$0.isEnabled());
            return;
        L7:
            CharSequence r14 = this.this$0.getText();
            Context r15 = this.this$0.getContext();
            int r16 = R.string.mtrl_chip_close_icon_content_description;
            if (TextUtils.isEmpty(r14) == true) goto L10;
            r12 = r14;
        L10:
            r11.Z(r15.getString(r16, new Object[]{r12}).trim());
            goto L11
        L12:
            r11.Z("");
            r11.Q(Chip.access$600());
        }

        @Override // androidx.customview.widget.a
        public void onVirtualViewKeyboardFocusChanged(int r10, boolean r11) {
            if (r10 != 1) goto L6;
            Chip.access$402(this.this$0, r11);
            this.this$0.refreshDrawableState();
            return;
        }
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_Chip_Action;
        EMPTY_BOUNDS = new Rect();
        SELECTED_STATE = new int[]{android.R.attr.state_selected};
        CHECKABLE_STATE_SET = new int[]{android.R.attr.state_checkable};
    }

    public Chip(Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ ChipDrawable access$000(Chip r10) {
        return r10.chipDrawable;
    }

    public static /* synthetic */ boolean access$100(Chip r10) {
        return r10.hasCloseIcon();
    }

    public static /* synthetic */ RectF access$200(Chip r10) {
        return r10.getCloseIconTouchBounds();
    }

    public static /* synthetic */ View.OnClickListener access$300(Chip r10) {
        return r10.onCloseIconClickListener;
    }

    public static /* synthetic */ boolean access$402(Chip r10, boolean r11) {
        r10.closeIconFocused = r11;
        return r11;
    }

    public static /* synthetic */ Rect access$500(Chip r10) {
        return r10.getCloseIconTouchBoundsInt();
    }

    public static /* synthetic */ Rect access$600() {
        return EMPTY_BOUNDS;
    }

    private void applyChipDrawable(@NonNull ChipDrawable r10) {
        r10.setDelegate(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    @NonNull
    private int[] createCloseIconDrawableState() {
        ?? r10 = isEnabled();
        int r11 = r10;
        if (this.closeIconFocused == false) goto L5;
        r11 = r10 + 1;
    L5:
        int r12 = r11;
        if (this.closeIconHovered == false) goto L8;
        r12 = r11 + 1;
    L8:
        int r13 = r12;
        if (this.closeIconPressed == false) goto L11;
        r13 = r12 + 1;
    L11:
        int r14 = r13;
        if (isChecked() == false) goto L14;
        r14 = r13 + 1;
    L14:
        int[] r15 = new int[r14];
        int r16 = 0;
        if (isEnabled() == false) goto L18;
        r15[0] = 16842910;
        r16 = 1;
    L18:
        if (this.closeIconFocused == false) goto L21;
        r15[r16] = 16842908;
        r16 = r16 + 1;
    L21:
        if (this.closeIconHovered == false) goto L24;
        r15[r16] = 16843623;
        r16 = r16 + 1;
    L24:
        if (this.closeIconPressed == false) goto L27;
        r15[r16] = 16842919;
        r16 = r16 + 1;
    L27:
        if (isChecked() == false) goto L29;
        r15[r16] = 16842913;
    L29:
        return r15;
    }

    private void ensureChipDrawableHasCallback() {
        if (getBackgroundDrawable() == this.insetBackgroundDrawable) goto L5;
        return;
    L5:
        if (this.chipDrawable.getCallback() != null) goto L9;
        this.chipDrawable.setCallback(this.insetBackgroundDrawable);
        return;
    }

    @NonNull
    private RectF getCloseIconTouchBounds() {
        this.rectF.setEmpty();
        if (hasCloseIcon() == false) goto L8;
        if (this.onCloseIconClickListener == null) goto L8;
        this.chipDrawable.getCloseIconTouchBounds(this.rectF);
    L8:
        return this.rectF;
    }

    @NonNull
    private Rect getCloseIconTouchBoundsInt() {
        RectF r10 = getCloseIconTouchBounds();
        this.rect.set((int) r10.left, (int) r10.top, (int) r10.right, (int) r10.bottom);
        return this.rect;
    }

    @Nullable
    private TextAppearance getTextAppearance() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getTextAppearance();
    }

    @SuppressLint({"PrivateApi"})
    private boolean handleAccessibilityExit(@NonNull MotionEvent r10) {
        if (r10.getAction() != 10) goto L24;
        Field r11 = a.class.getDeclaredField("mHoveredVirtualViewId");     // Catch: NoSuchFieldException -> L8 InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        r11.setAccessible(true);     // Catch: NoSuchFieldException -> L8 InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        if (((Integer) r11.get(this.touchHelper)).intValue() == Integer.MIN_VALUE) goto L25;
        Method r12 = a.class.getDeclaredMethod("s", new Class[]{Integer.TYPE});     // Catch: NoSuchFieldException -> L8 InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        r12.setAccessible(true);     // Catch: NoSuchFieldException -> L8 InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        r12.invoke(this.touchHelper, new Object[]{Integer.MIN_VALUE});     // Catch: NoSuchFieldException -> L8 InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        return true;
    L25:
        return false;
    L12:
        e = move-exception;
        Log.e(TAG, "Unable to send Accessibility Exit event", e);
        return false;
    L8:
        e = move-exception;
        Log.e(TAG, "Unable to send Accessibility Exit event", e);
        return false;
    L14:
        e = move-exception;
        Log.e(TAG, "Unable to send Accessibility Exit event", e);
        return false;
    L10:
        e = move-exception;
        Log.e(TAG, "Unable to send Accessibility Exit event", e);
        return false;
    L24:
        return false;
    }

    private boolean hasCloseIcon() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.getCloseIcon() == null) goto L7;
        return true;
    }

    private void initMinTouchTarget(Context r10, @Nullable AttributeSet r11, int r12) {
        TypedArray r13 = ThemeEnforcement.obtainStyledAttributes(r10, r11, R.styleable.Chip, r12, DEF_STYLE_RES, new int[0]);
        this.ensureMinTouchTargetSize = r13.getBoolean(R.styleable.Chip_ensureMinTouchTargetSize, false);
        this.minTouchTargetSize = (int) Math.ceil(r13.getDimension(R.styleable.Chip_chipMinTouchTargetSize, (float) Math.ceil(ViewUtils.dpToPx(getContext(), 48))));
        r13.recycle();
    }

    private void initOutlineProvider() {
        setOutlineProvider(new AnonymousClass2(this));
    }

    private void insetChipBackgroundDrawable(int r10, int r11, int r12, int r13) {
        this.insetBackgroundDrawable = new InsetDrawable(this.chipDrawable, r10, r11, r12, r13);
    }

    private void removeBackgroundInset() {
        if (this.insetBackgroundDrawable == null) goto L6;
        this.insetBackgroundDrawable = null;
        setMinWidth(0);
        setMinHeight((int) getChipMinHeight());
        updateBackgroundDrawable();
        return;
    }

    private void setCloseIconHovered(boolean r10) {
        if (this.closeIconHovered == r10) goto L6;
        this.closeIconHovered = r10;
        refreshDrawableState();
        return;
    }

    private void setCloseIconPressed(boolean r10) {
        if (this.closeIconPressed == r10) goto L6;
        this.closeIconPressed = r10;
        refreshDrawableState();
        return;
    }

    private void unapplyChipDrawable(@Nullable ChipDrawable r10) {
        if (r10 == null) goto L5;
        r10.setDelegate(null);
        return;
    }

    private void updateAccessibilityDelegate() {
        if (hasCloseIcon() == true) goto L5;
    L9:
        ViewCompat.p0(this, null);
        return;
    L5:
        if (isCloseIconVisible() == false) goto L9;
        if (this.onCloseIconClickListener == null) goto L9;
        ViewCompat.p0(this, this.touchHelper);
    }

    private void updateBackgroundDrawable() {
        if (RippleUtils.USE_FRAMEWORK_RIPPLE == false) goto L5;
        updateFrameworkRippleBackground();
        return;
    L5:
        this.chipDrawable.setUseCompatRipple(true);
        ViewCompat.t0(this, getBackgroundDrawable());
        updatePaddingInternal();
        ensureChipDrawableHasCallback();
    }

    private void updateFrameworkRippleBackground() {
        this.ripple = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.chipDrawable.getRippleColor()), getBackgroundDrawable(), null);
        this.chipDrawable.setUseCompatRipple(false);
        ViewCompat.t0(this, this.ripple);
        updatePaddingInternal();
    }

    private void updatePaddingInternal() {
        if (TextUtils.isEmpty(getText()) == true) goto L12;
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L13;
        int r11 = (int) ((r10.getChipEndPadding() + this.chipDrawable.getTextEndPadding()) + this.chipDrawable.calculateCloseIconWidth());
        int r12 = (int) ((this.chipDrawable.getChipStartPadding() + this.chipDrawable.getTextStartPadding()) + this.chipDrawable.calculateChipIconWidth());
        if (this.insetBackgroundDrawable == null) goto L10;
        Rect r13 = new Rect();
        this.insetBackgroundDrawable.getPadding(r13);
        r12 = r12 + r13.left;
        r11 = r11 + r13.right;
    L10:
        ViewCompat.D0(this, r12, getPaddingTop(), r11, getPaddingBottom());
        return;
    L13:
        return;
    }

    private void updateTextPaintDrawState() {
        TextPaint r10 = getPaint();
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L5;
        r10.drawableState = r11.getState();
    L5:
        TextAppearance r12 = getTextAppearance();
        if (r12 == null) goto L9;
        r12.updateDrawState(getContext(), r10, this.fontCallback);
        return;
    }

    private void validateAttributes(@Nullable AttributeSet r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.getAttributeValue(NAMESPACE_ANDROID, "background") == null) goto L8;
        Log.w(TAG, "Do not set the background; Chip manages its own background drawable.");
    L8:
        if (r10.getAttributeValue(NAMESPACE_ANDROID, "drawableLeft") != null) goto L36;
        if (r10.getAttributeValue(NAMESPACE_ANDROID, "drawableStart") != null) goto L34;
        if (r10.getAttributeValue(NAMESPACE_ANDROID, "drawableEnd") != null) goto L32;
        if (r10.getAttributeValue(NAMESPACE_ANDROID, "drawableRight") != null) goto L30;
        if (r10.getAttributeBooleanValue(NAMESPACE_ANDROID, "singleLine", true) == false) goto L28;
        if (r10.getAttributeIntValue(NAMESPACE_ANDROID, "lines", 1) != 1) goto L28;
        if (r10.getAttributeIntValue(NAMESPACE_ANDROID, "minLines", 1) != 1) goto L28;
        if (r10.getAttributeIntValue(NAMESPACE_ANDROID, "maxLines", 1) != 1) goto L28;
        if (r10.getAttributeIntValue(NAMESPACE_ANDROID, "gravity", 8388627) == 8388627) goto L37;
        Log.w(TAG, "Chip text must be vertically center and start aligned");
        return;
    L37:
        return;
    L28:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    L30:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L32:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L34:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    L36:
        throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(@NonNull MotionEvent r10) {
        if (handleAccessibilityExit(r10) == false) goto L5;
    L10:
        return true;
    L5:
        if (this.touchHelper.dispatchHoverEvent(r10) == true) goto L10;
        if (super.dispatchHoverEvent(r10) == true) goto L10;
        return false;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent r10) {
        if (this.touchHelper.dispatchKeyEvent(r10) == false) goto L9;
        if (this.touchHelper.getKeyboardFocusedVirtualViewId() == Integer.MIN_VALUE) goto L9;
        return true;
    L9:
        return super.dispatchKeyEvent(r10);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L5;
    L7:
        boolean r11 = false;
    L8:
        if (r11 == false) goto L11;
        invalidate();
        return;
    L11:
        return;
    L5:
        if (r10.isCloseIconStateful() == false) goto L7;
        r11 = this.chipDrawable.setCloseIconState(createCloseIconDrawableState());
        goto L8
    }

    public boolean ensureAccessibleTouchTarget(@Dimension int r10) {
        this.minTouchTargetSize = r10;
        int r11 = 0;
        if (shouldEnsureMinTouchTargetSize() == false) goto L5;
        int r12 = Math.max(0, r10 - this.chipDrawable.getIntrinsicHeight());
        int r13 = Math.max(0, r10 - this.chipDrawable.getIntrinsicWidth());
        if (r13 > 0) goto L17;
        if (r12 > 0) goto L17;
        if (this.insetBackgroundDrawable == null) goto L15;
        removeBackgroundInset();
    L16:
        return false;
    L15:
        updateBackgroundDrawable();
    L17:
        if (r13 <= 0) goto L19;
        int r14 = r13 / 2;
    L20:
        if (r12 <= 0) goto L23;
        r11 = r12 / 2;
    L23:
        if (this.insetBackgroundDrawable == null) goto L35;
        Rect r15 = new Rect();
        this.insetBackgroundDrawable.getPadding(r15);
        if (r15.top != r11) goto L35;
        if (r15.bottom != r11) goto L35;
        if (r15.left != r14) goto L35;
        if (r15.right != r14) goto L35;
        updateBackgroundDrawable();
        return true;
    L35:
        if (getMinHeight() == r10) goto L38;
        setMinHeight(r10);
    L38:
        if (getMinWidth() == r10) goto L40;
        setMinWidth(r10);
    L40:
        insetChipBackgroundDrawable(r14, r11, r14, r11);
        updateBackgroundDrawable();
        return true;
    L19:
        r14 = 0;
        goto L20
    L5:
        if (this.insetBackgroundDrawable == null) goto L7;
        removeBackgroundInset();
    L8:
        return false;
    L7:
        updateBackgroundDrawable();
        goto L8
    }

    @Nullable
    public Drawable getBackgroundDrawable() {
        InsetDrawable r10 = this.insetBackgroundDrawable;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return this.chipDrawable;
    }

    @Nullable
    public Drawable getCheckedIcon() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getCheckedIcon();
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getCheckedIconTint();
    }

    @Nullable
    public ColorStateList getChipBackgroundColor() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getChipBackgroundColor();
    }

    public float getChipCornerRadius() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L5;
        return 0.0f;
    L5:
        return Math.max(0.0f, r10.getChipCornerRadius());
    }

    public Drawable getChipDrawable() {
        return this.chipDrawable;
    }

    public float getChipEndPadding() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L7;
        return 0.0f;
    L7:
        return r10.getChipEndPadding();
    }

    @Nullable
    public Drawable getChipIcon() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getChipIcon();
    }

    public float getChipIconSize() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L7;
        return 0.0f;
    L7:
        return r10.getChipIconSize();
    }

    @Nullable
    public ColorStateList getChipIconTint() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getChipIconTint();
    }

    public float getChipMinHeight() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L7;
        return 0.0f;
    L7:
        return r10.getChipMinHeight();
    }

    public float getChipStartPadding() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L7;
        return 0.0f;
    L7:
        return r10.getChipStartPadding();
    }

    @Nullable
    public ColorStateList getChipStrokeColor() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getChipStrokeColor();
    }

    public float getChipStrokeWidth() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L7;
        return 0.0f;
    L7:
        return r10.getChipStrokeWidth();
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    @Nullable
    public Drawable getCloseIcon() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getCloseIcon();
    }

    @Nullable
    public CharSequence getCloseIconContentDescription() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getCloseIconContentDescription();
    }

    public float getCloseIconEndPadding() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L7;
        return 0.0f;
    L7:
        return r10.getCloseIconEndPadding();
    }

    public float getCloseIconSize() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L7;
        return 0.0f;
    L7:
        return r10.getCloseIconSize();
    }

    public float getCloseIconStartPadding() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L7;
        return 0.0f;
    L7:
        return r10.getCloseIconStartPadding();
    }

    @Nullable
    public ColorStateList getCloseIconTint() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getCloseIconTint();
    }

    @Override // android.widget.TextView
    @Nullable
    public TextUtils.TruncateAt getEllipsize() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getEllipsize();
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(@NonNull Rect r10) {
        if (this.touchHelper.getKeyboardFocusedVirtualViewId() != 1) goto L5;
    L8:
        r10.set(getCloseIconTouchBoundsInt());
        return;
    L5:
        if (this.touchHelper.getAccessibilityFocusedVirtualViewId() == 1) goto L8;
        super.getFocusedRect(r10);
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getHideMotionSpec();
    }

    public float getIconEndPadding() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L7;
        return 0.0f;
    L7:
        return r10.getIconEndPadding();
    }

    public float getIconStartPadding() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L7;
        return 0.0f;
    L7:
        return r10.getIconStartPadding();
    }

    @Nullable
    public ColorStateList getRippleColor() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getRippleColor();
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.chipDrawable.getShapeAppearanceModel();
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getShowMotionSpec();
    }

    public float getTextEndPadding() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L7;
        return 0.0f;
    L7:
        return r10.getTextEndPadding();
    }

    public float getTextStartPadding() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L7;
        return 0.0f;
    L7:
        return r10.getTextStartPadding();
    }

    public boolean isCheckable() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isCheckable() == false) goto L7;
        return true;
    }

    @Deprecated
    public boolean isCheckedIconEnabled() {
        return isCheckedIconVisible();
    }

    public boolean isCheckedIconVisible() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isCheckedIconVisible() == false) goto L7;
        return true;
    }

    @Deprecated
    public boolean isChipIconEnabled() {
        return isChipIconVisible();
    }

    public boolean isChipIconVisible() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isChipIconVisible() == false) goto L7;
        return true;
    }

    @Deprecated
    public boolean isCloseIconEnabled() {
        return isCloseIconVisible();
    }

    public boolean isCloseIconVisible() {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isCloseIconVisible() == false) goto L7;
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.chipDrawable);
    }

    @Override // com.google.android.material.chip.ChipDrawable.Delegate
    public void onChipDrawableSizeChange() {
        ensureAccessibleTouchTarget(this.minTouchTargetSize);
        requestLayout();
        invalidateOutline();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int r10) {
        int[] r11 = super.onCreateDrawableState(r10 + 2);
        if (isChecked() == false) goto L6;
        CheckBox.mergeDrawableStates(r11, SELECTED_STATE);
    L6:
        if (isCheckable() == false) goto L8;
        CheckBox.mergeDrawableStates(r11, CHECKABLE_STATE_SET);
    L8:
        return r11;
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean r10, int r11, Rect r12) {
        super.onFocusChanged(r10, r11, r12);
        this.touchHelper.onFocusChanged(r10, r11, r12);
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NonNull MotionEvent r10) {
        int r11 = r10.getActionMasked();
        if (r11 != 7) goto L5;
        setCloseIconHovered(getCloseIconTouchBounds().contains(r10.getX(), r10.getY()));
    L10:
        return super.onHoverEvent(r10);
    L5:
        if (r11 != 10) goto L10;
        setCloseIconHovered(false);
        goto L10
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        if (isCheckable() == true) goto L9;
        if (isClickable() == true) goto L9;
        r10.setClassName(GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME);
    L13:
        r10.setCheckable(isCheckable());
        r10.setClickable(isClickable());
        if ((getParent() instanceof ChipGroup) == false) goto L22;
        ChipGroup r11 = (ChipGroup) getParent();
        AccessibilityNodeInfoCompat r12 = AccessibilityNodeInfoCompat.B0(r10);
        if (r11.isSingleLine() == false) goto L19;
        int r13 = r11.getIndexOfChip(this);
    L18:
        int r14 = r13;
        r12.Y(AccessibilityNodeInfoCompat.c.a(r11.getRowIndex(this), 1, r14, 1, false, isChecked()));
        return;
    L19:
        r13 = -1;
        goto L18
    L22:
        return;
    L9:
        if (isCheckable() == false) goto L11;
        String r15 = COMPOUND_BUTTON_ACCESSIBILITY_CLASS_NAME;
    L12:
        r10.setClassName(r15);
        goto L13
    L11:
        r15 = BUTTON_ACCESSIBILITY_CLASS_NAME;
        goto L12
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @Nullable
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(@NonNull MotionEvent r10, int r11) {
        if (getCloseIconTouchBounds().contains(r10.getX(), r10.getY()) == true) goto L5;
        return null;
    L5:
        if (isEnabled() == true) goto L7;
        return null;
    L7:
        return PointerIcon.getSystemIcon(getContext(), 1002);
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public void onRtlPropertiesChanged(int r10) {
        super.onRtlPropertiesChanged(r10);
        if (this.lastLayoutDirection == r10) goto L6;
        this.lastLayoutDirection = r10;
        updatePaddingInternal();
        return;
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NonNull MotionEvent r10) {
        int r11 = r10.getActionMasked();
        boolean r12 = getCloseIconTouchBounds().contains(r10.getX(), r10.getY());
        if (r11 == 0) goto L20;
        if (r11 == 1) goto L16;
        if (r11 == 2) goto L11;
        if (r11 != 3) goto L22;
    L18:
        boolean r13 = false;
    L19:
        setCloseIconPressed(false);
    L23:
        if (r13 == false) goto L25;
        return true;
    L25:
        if (super.onTouchEvent(r10) == false) goto L28;
        return true;
    L28:
        return false;
    L22:
        r13 = false;
        goto L23
    L11:
        if (this.closeIconPressed == false) goto L22;
        if (r12 == true) goto L14;
        setCloseIconPressed(false);
    L14:
        r13 = true;
        goto L23
    L16:
        if (this.closeIconPressed == false) goto L18;
        performCloseIconClick();
        r13 = true;
        goto L19
    L20:
        if (r12 == false) goto L22;
        setCloseIconPressed(true);
        goto L14
    }

    @CallSuper
    public boolean performCloseIconClick() {
        boolean r10 = false;
        playSoundEffect(0);
        View.OnClickListener r11 = this.onCloseIconClickListener;
        if (r11 == null) goto L5;
        r11.onClick(this);
        r10 = true;
    L5:
        this.touchHelper.sendEventForVirtualView(1, 1);
        return r10;
    }

    @Override // android.view.View
    public void setBackground(Drawable r10) {
        if (r10 != getBackgroundDrawable()) goto L5;
    L7:
        super.setBackground(r10);
        return;
    L5:
        if (r10 == this.ripple) goto L7;
        Log.w(TAG, "Do not set the background; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundColor(int r10) {
        Log.w(TAG, "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable r10) {
        if (r10 != getBackgroundDrawable()) goto L5;
    L7:
        super.setBackgroundDrawable(r10);
        return;
    L5:
        if (r10 == this.ripple) goto L7;
        Log.w(TAG, "Do not set the background drawable; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int r10) {
        Log.w(TAG, "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList r10) {
        Log.w(TAG, "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode r10) {
        Log.w(TAG, "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setCheckable(r10);
        return;
    }

    public void setCheckableResource(@BoolRes int r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setCheckableResource(r10);
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 != null) goto L6;
        this.deferredCheckedValue = r10;
        return;
    L6:
        if (r11.isCheckable() == false) goto L14;
        boolean r12 = isChecked();
        super.setChecked(r10);
        if (r12 == r10) goto L15;
        CompoundButton.OnCheckedChangeListener r13 = this.onCheckedChangeListenerInternal;
        if (r13 == null) goto L16;
        r13.onCheckedChanged(this, r10);
        return;
    L16:
        return;
    L15:
        return;
    }

    public void setCheckedIcon(@Nullable Drawable r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setCheckedIcon(r10);
        return;
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean r10) {
        setCheckedIconVisible(r10);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@BoolRes int r10) {
        setCheckedIconVisible(r10);
    }

    public void setCheckedIconResource(@DrawableRes int r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setCheckedIconResource(r10);
        return;
    }

    public void setCheckedIconTint(@Nullable ColorStateList r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setCheckedIconTint(r10);
        return;
    }

    public void setCheckedIconTintResource(@ColorRes int r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setCheckedIconTintResource(r10);
        return;
    }

    public void setCheckedIconVisible(@BoolRes int r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setCheckedIconVisible(r10);
        return;
    }

    public void setChipBackgroundColor(@Nullable ColorStateList r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setChipBackgroundColor(r10);
        return;
    }

    public void setChipBackgroundColorResource(@ColorRes int r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setChipBackgroundColorResource(r10);
        return;
    }

    @Deprecated
    public void setChipCornerRadius(float r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setChipCornerRadius(r10);
        return;
    }

    @Deprecated
    public void setChipCornerRadiusResource(@DimenRes int r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setChipCornerRadiusResource(r10);
        return;
    }

    public void setChipDrawable(@NonNull ChipDrawable r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == r10) goto L6;
        unapplyChipDrawable(r11);
        this.chipDrawable = r10;
        r10.setShouldDrawText(false);
        applyChipDrawable(this.chipDrawable);
        ensureAccessibleTouchTarget(this.minTouchTargetSize);
        return;
    }

    public void setChipEndPadding(float r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setChipEndPadding(r10);
        return;
    }

    public void setChipEndPaddingResource(@DimenRes int r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setChipEndPaddingResource(r10);
        return;
    }

    public void setChipIcon(@Nullable Drawable r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setChipIcon(r10);
        return;
    }

    @Deprecated
    public void setChipIconEnabled(boolean r10) {
        setChipIconVisible(r10);
    }

    @Deprecated
    public void setChipIconEnabledResource(@BoolRes int r10) {
        setChipIconVisible(r10);
    }

    public void setChipIconResource(@DrawableRes int r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setChipIconResource(r10);
        return;
    }

    public void setChipIconSize(float r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setChipIconSize(r10);
        return;
    }

    public void setChipIconSizeResource(@DimenRes int r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setChipIconSizeResource(r10);
        return;
    }

    public void setChipIconTint(@Nullable ColorStateList r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setChipIconTint(r10);
        return;
    }

    public void setChipIconTintResource(@ColorRes int r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setChipIconTintResource(r10);
        return;
    }

    public void setChipIconVisible(@BoolRes int r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setChipIconVisible(r10);
        return;
    }

    public void setChipMinHeight(float r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setChipMinHeight(r10);
        return;
    }

    public void setChipMinHeightResource(@DimenRes int r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setChipMinHeightResource(r10);
        return;
    }

    public void setChipStartPadding(float r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setChipStartPadding(r10);
        return;
    }

    public void setChipStartPaddingResource(@DimenRes int r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setChipStartPaddingResource(r10);
        return;
    }

    public void setChipStrokeColor(@Nullable ColorStateList r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setChipStrokeColor(r10);
        return;
    }

    public void setChipStrokeColorResource(@ColorRes int r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setChipStrokeColorResource(r10);
        return;
    }

    public void setChipStrokeWidth(float r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setChipStrokeWidth(r10);
        return;
    }

    public void setChipStrokeWidthResource(@DimenRes int r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setChipStrokeWidthResource(r10);
        return;
    }

    @Deprecated
    public void setChipText(@Nullable CharSequence r10) {
        setText(r10);
    }

    @Deprecated
    public void setChipTextResource(@StringRes int r10) {
        setText(getResources().getString(r10));
    }

    public void setCloseIcon(@Nullable Drawable r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L5;
        r11.setCloseIcon(r10);
    L5:
        updateAccessibilityDelegate();
    }

    public void setCloseIconContentDescription(@Nullable CharSequence r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setCloseIconContentDescription(r10);
        return;
    }

    @Deprecated
    public void setCloseIconEnabled(boolean r10) {
        setCloseIconVisible(r10);
    }

    @Deprecated
    public void setCloseIconEnabledResource(@BoolRes int r10) {
        setCloseIconVisible(r10);
    }

    public void setCloseIconEndPadding(float r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setCloseIconEndPadding(r10);
        return;
    }

    public void setCloseIconEndPaddingResource(@DimenRes int r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setCloseIconEndPaddingResource(r10);
        return;
    }

    public void setCloseIconResource(@DrawableRes int r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L5;
        r11.setCloseIconResource(r10);
    L5:
        updateAccessibilityDelegate();
    }

    public void setCloseIconSize(float r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setCloseIconSize(r10);
        return;
    }

    public void setCloseIconSizeResource(@DimenRes int r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setCloseIconSizeResource(r10);
        return;
    }

    public void setCloseIconStartPadding(float r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setCloseIconStartPadding(r10);
        return;
    }

    public void setCloseIconStartPaddingResource(@DimenRes int r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setCloseIconStartPaddingResource(r10);
        return;
    }

    public void setCloseIconTint(@Nullable ColorStateList r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setCloseIconTint(r10);
        return;
    }

    public void setCloseIconTintResource(@ColorRes int r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setCloseIconTintResource(r10);
        return;
    }

    public void setCloseIconVisible(@BoolRes int r10) {
        setCloseIconVisible(getResources().getBoolean(r10));
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable r10, @Nullable Drawable r11, @Nullable Drawable r12, @Nullable Drawable r13) {
        if (r10 != null) goto L9;
        if (r12 != null) goto L7;
        super.setCompoundDrawables(r10, r11, r12, r13);
        return;
    L7:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public void setCompoundDrawablesRelative(@Nullable Drawable r10, @Nullable Drawable r11, @Nullable Drawable r12, @Nullable Drawable r13) {
        if (r10 != null) goto L9;
        if (r12 != null) goto L7;
        super.setCompoundDrawablesRelative(r10, r11, r12, r13);
        return;
    L7:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int r10, int r11, int r12, int r13) {
        if (r10 != 0) goto L9;
        if (r12 != 0) goto L7;
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(r10, r11, r12, r13);
        return;
    L7:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int r10, int r11, int r12, int r13) {
        if (r10 != 0) goto L9;
        if (r12 != 0) goto L7;
        super.setCompoundDrawablesWithIntrinsicBounds(r10, r11, r12, r13);
        return;
    L7:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float r10) {
        super.setElevation(r10);
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setElevation(r10);
        return;
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt r10) {
        if (this.chipDrawable != null) goto L6;
        return;
    L6:
        if (r10 == TextUtils.TruncateAt.MARQUEE) goto L12;
        super.setEllipsize(r10);
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L13;
        r11.setEllipsize(r10);
        return;
    L13:
        return;
    L12:
        throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
    }

    public void setEnsureMinTouchTargetSize(boolean r10) {
        this.ensureMinTouchTargetSize = r10;
        ensureAccessibleTouchTarget(this.minTouchTargetSize);
    }

    @Override // android.widget.TextView
    public void setGravity(int r10) {
        if (r10 == 8388627) goto L5;
        Log.w(TAG, "Chip text must be vertically center and start aligned");
        return;
    L5:
        super.setGravity(r10);
    }

    public void setHideMotionSpec(@Nullable MotionSpec r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setHideMotionSpec(r10);
        return;
    }

    public void setHideMotionSpecResource(@AnimatorRes int r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setHideMotionSpecResource(r10);
        return;
    }

    public void setIconEndPadding(float r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setIconEndPadding(r10);
        return;
    }

    public void setIconEndPaddingResource(@DimenRes int r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setIconEndPaddingResource(r10);
        return;
    }

    public void setIconStartPadding(float r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setIconStartPadding(r10);
        return;
    }

    public void setIconStartPaddingResource(@DimenRes int r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setIconStartPaddingResource(r10);
        return;
    }

    @Override // android.view.View
    public void setLayoutDirection(int r10) {
        if (this.chipDrawable != null) goto L5;
        return;
    L5:
        super.setLayoutDirection(r10);
    }

    @Override // android.widget.TextView
    public void setLines(int r10) {
        if (r10 > 1) goto L7;
        super.setLines(r10);
        return;
    L7:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxLines(int r10) {
        if (r10 > 1) goto L7;
        super.setMaxLines(r10);
        return;
    L7:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxWidth(@Px int r10) {
        super.setMaxWidth(r10);
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setMaxWidth(r10);
        return;
    }

    @Override // android.widget.TextView
    public void setMinLines(int r10) {
        if (r10 > 1) goto L7;
        super.setMinLines(r10);
        return;
    L7:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener r10) {
        this.onCheckedChangeListenerInternal = r10;
    }

    public void setOnCloseIconClickListener(View.OnClickListener r10) {
        this.onCloseIconClickListener = r10;
        updateAccessibilityDelegate();
    }

    public void setRippleColor(@Nullable ColorStateList r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setRippleColor(r10);
    L6:
        if (this.chipDrawable.getUseCompatRipple() == true) goto L9;
        updateFrameworkRippleBackground();
        return;
    }

    public void setRippleColorResource(@ColorRes int r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L8;
        r11.setRippleColorResource(r10);
        if (this.chipDrawable.getUseCompatRipple() == true) goto L9;
        updateFrameworkRippleBackground();
        return;
    L9:
        return;
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel r10) {
        this.chipDrawable.setShapeAppearanceModel(r10);
    }

    public void setShowMotionSpec(@Nullable MotionSpec r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setShowMotionSpec(r10);
        return;
    }

    public void setShowMotionSpecResource(@AnimatorRes int r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setShowMotionSpecResource(r10);
        return;
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean r10) {
        if (r10 == false) goto L6;
        super.setSingleLine(r10);
        return;
    L6:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setText(CharSequence r10, TextView.BufferType r11) {
        ChipDrawable r12 = this.chipDrawable;
        if (r12 != null) goto L5;
        return;
    L5:
        if (r10 != null) goto L8;
        r10 = "";
    L8:
        if (r12.shouldDrawText() == false) goto L10;
        CharSequence r13 = null;
    L11:
        super.setText(r13, r11);
        ChipDrawable r14 = this.chipDrawable;
        if (r14 == null) goto L15;
        r14.setText(r10);
        return;
    L15:
        return;
    L10:
        r13 = r10;
        goto L11
    }

    public void setTextAppearance(@Nullable TextAppearance r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L5;
        r11.setTextAppearance(r10);
    L5:
        updateTextPaintDrawState();
    }

    public void setTextAppearanceResource(@StyleRes int r10) {
        setTextAppearance(getContext(), r10);
    }

    public void setTextEndPadding(float r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setTextEndPadding(r10);
        return;
    }

    public void setTextEndPaddingResource(@DimenRes int r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setTextEndPaddingResource(r10);
        return;
    }

    public void setTextStartPadding(float r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setTextStartPadding(r10);
        return;
    }

    public void setTextStartPaddingResource(@DimenRes int r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setTextStartPaddingResource(r10);
        return;
    }

    public boolean shouldEnsureMinTouchTargetSize() {
        return this.ensureMinTouchTargetSize;
    }

    public Chip(Context r10, AttributeSet r11) {
        this(r10, r11, R.attr.chipStyle);
    }

    public void setCloseIconVisible(boolean r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L5;
        r11.setCloseIconVisible(r10);
    L5:
        updateAccessibilityDelegate();
    }

    public Chip(Context r10, AttributeSet r11, int r12) {
        int r13 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r10, r11, r12, r13), r11, r12);
        this.rect = new Rect();
        this.rectF = new RectF();
        this.fontCallback = new AnonymousClass1(this);
        Context r14 = getContext();
        validateAttributes(r11);
        ChipDrawable r15 = ChipDrawable.createFromAttributes(r14, r11, r12, r13);
        initMinTouchTarget(r14, r11, r12);
        setChipDrawable(r15);
        r15.setElevation(ViewCompat.v(this));
        TypedArray r16 = ThemeEnforcement.obtainStyledAttributes(r14, r11, R.styleable.Chip, r12, r13, new int[0]);
        boolean r17 = r16.hasValue(R.styleable.Chip_shapeAppearance);
        r16.recycle();
        this.touchHelper = new ChipTouchHelper(this, this);
        updateAccessibilityDelegate();
        if (r17 == true) goto L5;
        initOutlineProvider();
    L5:
        setChecked(this.deferredCheckedValue);
        setText(r15.getText());
        setEllipsize(r15.getEllipsize());
        updateTextPaintDrawState();
        if (this.chipDrawable.shouldDrawText() == true) goto L8;
        setLines(1);
        setHorizontallyScrolling(true);
    L8:
        setGravity(8388627);
        updatePaddingInternal();
        if (shouldEnsureMinTouchTargetSize() == false) goto L11;
        setMinHeight(this.minTouchTargetSize);
    L11:
        this.lastLayoutDirection = ViewCompat.A(this);
    }

    public void setCheckedIconVisible(boolean r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setCheckedIconVisible(r10);
        return;
    }

    public void setChipIconVisible(boolean r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L6;
        r11.setChipIconVisible(r10);
        return;
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable r10, @Nullable Drawable r11, @Nullable Drawable r12, @Nullable Drawable r13) {
        if (r10 != null) goto L9;
        if (r12 != null) goto L7;
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(r10, r11, r12, r13);
        return;
    L7:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable r10, @Nullable Drawable r11, @Nullable Drawable r12, @Nullable Drawable r13) {
        if (r10 != null) goto L9;
        if (r12 != null) goto L7;
        super.setCompoundDrawablesWithIntrinsicBounds(r10, r11, r12, r13);
        return;
    L7:
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context r10, int r11) {
        super.setTextAppearance(r10, r11);
        ChipDrawable r12 = this.chipDrawable;
        if (r12 == null) goto L5;
        r12.setTextAppearanceResource(r11);
    L5:
        updateTextPaintDrawState();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int r10) {
        super.setTextAppearance(r10);
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L5;
        r11.setTextAppearanceResource(r10);
    L5:
        updateTextPaintDrawState();
    }
}
