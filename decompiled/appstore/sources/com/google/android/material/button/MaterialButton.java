package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
import o.a;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialButton extends AppCompatButton implements Checkable, Shapeable {
    private static final int[] CHECKABLE_STATE_SET = null;
    private static final int[] CHECKED_STATE_SET = null;
    private static final int DEF_STYLE_RES = 0;
    public static final int ICON_GRAVITY_END = 3;
    public static final int ICON_GRAVITY_START = 1;
    public static final int ICON_GRAVITY_TEXT_END = 4;
    public static final int ICON_GRAVITY_TEXT_START = 2;
    public static final int ICON_GRAVITY_TEXT_TOP = 32;
    public static final int ICON_GRAVITY_TOP = 16;
    private static final String LOG_TAG = "MaterialButton";
    private boolean broadcasting;
    private boolean checked;

    @Nullable
    private Drawable icon;
    private int iconGravity;

    @Px
    private int iconLeft;

    @Px
    private int iconPadding;

    @Px
    private int iconSize;

    @Nullable
    private ColorStateList iconTint;

    @Nullable
    private PorterDuff.Mode iconTintMode;

    @Px
    private int iconTop;

    @NonNull
    private final MaterialButtonHelper materialButtonHelper;

    @NonNull
    private final LinkedHashSet<OnCheckedChangeListener> onCheckedChangeListeners;

    @Nullable
    private OnPressedChangeListener onPressedChangeListenerInternal;

    @Retention(RetentionPolicy.SOURCE)
    public @interface IconGravity {
    }

    public interface OnCheckedChangeListener {
        void onCheckedChanged(MaterialButton r10, boolean r11);
    }

    public interface OnPressedChangeListener {
        void onPressedChanged(MaterialButton r10, boolean r11);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean checked;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcelable r10) {
            super(r10);
        }

        private void readFromParcel(@NonNull Parcel r10) {
            boolean r11 = true;
            if (r10.readInt() == 1) goto L6;
            r11 = false;
        L6:
            this.checked = r11;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeInt(this.checked ? 1 : 0);
        }

        public SavedState(@NonNull Parcel r10, ClassLoader r11) {
            super(r10, r11);
            if (r11 != null) goto L5;
            getClass().getClassLoader();
        L5:
            readFromParcel(r10);
        }
    }

    static {
        CHECKABLE_STATE_SET = new int[]{R.attr.state_checkable};
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        DEF_STYLE_RES = com.google.android.material.R.style.Widget_MaterialComponents_Button;
    }

    public MaterialButton(@NonNull Context r10) {
        this(r10, null);
    }

    @NonNull
    private String getA11yClassName() {
        if (isCheckable() == false) goto L5;
        Class r10 = CompoundButton.class;
    L7:
        return r10.getName();
    L5:
        r10 = Button.class;
        goto L7
    }

    private int getTextHeight() {
        TextPaint r10 = getPaint();
        String r11 = getText().toString();
        if (getTransformationMethod() == null) goto L5;
        r11 = getTransformationMethod().getTransformation(r11, this).toString();
    L5:
        Rect r12 = new Rect();
        r10.getTextBounds(r11, 0, r11.length(), r12);
        return Math.min(r12.height(), getLayout().getHeight());
    }

    private int getTextWidth() {
        TextPaint r10 = getPaint();
        String r11 = getText().toString();
        if (getTransformationMethod() == null) goto L6;
        r11 = getTransformationMethod().getTransformation(r11, this).toString();
    L6:
        return Math.min((int) r10.measureText(r11), getLayout().getEllipsizedWidth());
    }

    private boolean isIconEnd() {
        int r10 = this.iconGravity;
        if (r10 != 3) goto L5;
    L8:
        return true;
    L5:
        if (r10 == 4) goto L8;
        return false;
    }

    private boolean isIconStart() {
        int r10 = this.iconGravity;
        if (r10 != 1) goto L5;
        return true;
    L5:
        if (r10 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    private boolean isIconTop() {
        int r10 = this.iconGravity;
        if (r10 != 16) goto L5;
    L8:
        return true;
    L5:
        if (r10 == 32) goto L8;
        return false;
    }

    private boolean isLayoutRTL() {
        if (ViewCompat.A(this) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean isUsingOriginalBackground() {
        MaterialButtonHelper r10 = this.materialButtonHelper;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isBackgroundOverwritten() == true) goto L7;
        return true;
    }

    private void resetIconDrawable() {
        if (isIconStart() == false) goto L6;
        TextViewCompat.i(this, this.icon, null, null, null);
        return;
    L6:
        if (isIconEnd() == false) goto L9;
        TextViewCompat.i(this, null, null, this.icon, null);
        return;
    L9:
        if (isIconTop() == false) goto L14;
        TextViewCompat.i(this, null, this.icon, null, null);
        return;
    }

    private void updateIcon(boolean r10) {
        Drawable r11 = this.icon;
        if (r11 == null) goto L16;
        Drawable r12 = a.l(r11).mutate();
        this.icon = r12;
        a.i(r12, this.iconTint);
        PorterDuff.Mode r13 = this.iconTintMode;
        if (r13 == null) goto L7;
        a.j(this.icon, r13);
    L7:
        int r14 = this.iconSize;
        if (r14 != 0) goto L11;
        r14 = this.icon.getIntrinsicWidth();
    L11:
        int r15 = this.iconSize;
        if (r15 != 0) goto L15;
        r15 = this.icon.getIntrinsicHeight();
    L15:
        Drawable r16 = this.icon;
        int r17 = this.iconLeft;
        int r18 = this.iconTop;
        r16.setBounds(r17, r18, r14 + r17, r15 + r18);
    L16:
        if (r10 == false) goto L19;
        resetIconDrawable();
        return;
    L19:
        Drawable[] r19 = TextViewCompat.a(this);
        Drawable r20 = r19[0];
        Drawable r21 = r19[1];
        Drawable r22 = r19[2];
        if (isIconStart() == false) goto L24;
        if (r20 == this.icon) goto L24;
    L31:
        resetIconDrawable();
        return;
    L24:
        if (isIconEnd() == false) goto L28;
        if (r22 != this.icon) goto L31;
    L28:
        if (isIconTop() == true) goto L30;
        return;
    L30:
        if (r21 != this.icon) goto L31;
    }

    private void updateIconPosition(int r10, int r11) {
        if (this.icon != null) goto L5;
        return;
    L5:
        if (getLayout() != null) goto L8;
        return;
    L8:
        if (isIconStart() == false) goto L10;
    L24:
        this.iconTop = 0;
        int r12 = this.iconGravity;
        boolean r13 = true;
        if (r12 != 1) goto L27;
    L42:
        this.iconLeft = 0;
        updateIcon(false);
        return;
    L27:
        if (r12 == 3) goto L42;
        int r14 = this.iconSize;
        if (r14 != 0) goto L32;
        r14 = this.icon.getIntrinsicWidth();
    L32:
        int r15 = (((((r10 - getTextWidth()) - ViewCompat.E(this)) - r14) - this.iconPadding) - ViewCompat.F(this)) / 2;
        boolean r16 = isLayoutRTL();
        if (this.iconGravity == 4) goto L36;
        r13 = false;
    L36:
        if (r16 == r13) goto L39;
        r15 = -r15;
    L39:
        if (this.iconLeft == r15) goto L47;
        this.iconLeft = r15;
        updateIcon(false);
        return;
    L47:
        return;
    L10:
        if (isIconEnd() == true) goto L24;
        if (isIconTop() == false) goto L44;
        this.iconLeft = 0;
        if (this.iconGravity != 16) goto L18;
        this.iconTop = 0;
        updateIcon(false);
        return;
    L18:
        int r17 = this.iconSize;
        if (r17 != 0) goto L21;
        r17 = this.icon.getIntrinsicHeight();
    L21:
        int r18 = (((((r11 - getTextHeight()) - getPaddingTop()) - r17) - this.iconPadding) - getPaddingBottom()) / 2;
        if (this.iconTop == r18) goto L45;
        this.iconTop = r18;
        updateIcon(false);
        return;
    L45:
        return;
    }

    public void addOnCheckedChangeListener(@NonNull OnCheckedChangeListener r10) {
        this.onCheckedChangeListeners.add(r10);
    }

    public void clearOnCheckedChangeListeners() {
        this.onCheckedChangeListeners.clear();
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @Px
    public int getCornerRadius() {
        if (isUsingOriginalBackground() == true) goto L7;
        return 0;
    L7:
        return this.materialButtonHelper.getCornerRadius();
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public int getIconGravity() {
        return this.iconGravity;
    }

    @Px
    public int getIconPadding() {
        return this.iconPadding;
    }

    @Px
    public int getIconSize() {
        return this.iconSize;
    }

    public ColorStateList getIconTint() {
        return this.iconTint;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.iconTintMode;
    }

    @Dimension
    public int getInsetBottom() {
        return this.materialButtonHelper.getInsetBottom();
    }

    @Dimension
    public int getInsetTop() {
        return this.materialButtonHelper.getInsetTop();
    }

    @Nullable
    public ColorStateList getRippleColor() {
        if (isUsingOriginalBackground() == true) goto L7;
        return null;
    L7:
        return this.materialButtonHelper.getRippleColor();
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        if (isUsingOriginalBackground() == false) goto L7;
        return this.materialButtonHelper.getShapeAppearanceModel();
    L7:
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (isUsingOriginalBackground() == true) goto L7;
        return null;
    L7:
        return this.materialButtonHelper.getStrokeColor();
    }

    @Px
    public int getStrokeWidth() {
        if (isUsingOriginalBackground() == true) goto L7;
        return 0;
    L7:
        return this.materialButtonHelper.getStrokeWidth();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        if (isUsingOriginalBackground() == false) goto L7;
        return this.materialButtonHelper.getSupportBackgroundTintList();
    L7:
        return super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (isUsingOriginalBackground() == false) goto L7;
        return this.materialButtonHelper.getSupportBackgroundTintMode();
    L7:
        return super.getSupportBackgroundTintMode();
    }

    public boolean isCheckable() {
        MaterialButtonHelper r10 = this.materialButtonHelper;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isCheckable() == false) goto L7;
        return true;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checked;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isUsingOriginalBackground() == false) goto L6;
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.materialButtonHelper.getMaterialShapeDrawable());
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int r10) {
        int[] r11 = super.onCreateDrawableState(r10 + 2);
        if (isCheckable() == false) goto L6;
        Button.mergeDrawableStates(r11, CHECKABLE_STATE_SET);
    L6:
        if (isChecked() == false) goto L8;
        Button.mergeDrawableStates(r11, CHECKED_STATE_SET);
    L8:
        return r11;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent r10) {
        super.onInitializeAccessibilityEvent(r10);
        r10.setClassName(getA11yClassName());
        r10.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        r10.setClassName(getA11yClassName());
        r10.setCheckable(isCheckable());
        r10.setChecked(isChecked());
        r10.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        setChecked(r11.checked);
    }

    @Override // android.widget.TextView, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        r10.checked = this.checked;
        return r10;
    }

    @Override // android.view.View
    public void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        updateIconPosition(r10, r11);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
        super.onTextChanged(r10, r11, r12, r13);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    public void removeOnCheckedChangeListener(@NonNull OnCheckedChangeListener r10) {
        this.onCheckedChangeListeners.remove(r10);
    }

    @Override // android.view.View
    public void setBackground(@NonNull Drawable r10) {
        setBackgroundDrawable(r10);
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int r10) {
        if (isUsingOriginalBackground() == false) goto L5;
        this.materialButtonHelper.setBackgroundColor(r10);
        return;
    L5:
        super.setBackgroundColor(r10);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(@NonNull Drawable r10) {
        if (isUsingOriginalBackground() == true) goto L5;
        super.setBackgroundDrawable(r10);
        return;
    L5:
        if (r10 == getBackground()) goto L7;
        Log.w(LOG_TAG, "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
        this.materialButtonHelper.setBackgroundOverwritten();
        super.setBackgroundDrawable(r10);
        return;
    L7:
        getBackground().setState(r10.getState());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(@DrawableRes int r10) {
        if (r10 == 0) goto L4;
        Drawable r11 = c.a.b(getContext(), r10);
    L5:
        setBackgroundDrawable(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList r10) {
        setSupportBackgroundTintList(r10);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode r10) {
        setSupportBackgroundTintMode(r10);
    }

    public void setCheckable(boolean r10) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.setCheckable(r10);
        return;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r10) {
        if (isCheckable() == true) goto L5;
        return;
    L5:
        if (isEnabled() == true) goto L7;
        return;
    L7:
        if (this.checked == r10) goto L20;
        this.checked = r10;
        refreshDrawableState();
        if (this.broadcasting == false) goto L11;
        return;
    L11:
        this.broadcasting = true;
        Iterator<OnCheckedChangeListener> r11 = this.onCheckedChangeListeners.iterator();
    L13:
        if (r11.hasNext() == false) goto L15;
        r11.next().onCheckedChanged(this, this.checked);
        goto L13
    L15:
        this.broadcasting = false;
        return;
    }

    public void setCornerRadius(@Px int r10) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.setCornerRadius(r10);
        return;
    }

    public void setCornerRadiusResource(@DimenRes int r10) {
        if (isUsingOriginalBackground() == false) goto L6;
        setCornerRadius(getResources().getDimensionPixelSize(r10));
        return;
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float r10) {
        super.setElevation(r10);
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.getMaterialShapeDrawable().setElevation(r10);
        return;
    }

    public void setIcon(@Nullable Drawable r10) {
        if (this.icon == r10) goto L6;
        this.icon = r10;
        updateIcon(true);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
        return;
    }

    public void setIconGravity(int r10) {
        if (this.iconGravity == r10) goto L6;
        this.iconGravity = r10;
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
        return;
    }

    public void setIconPadding(@Px int r10) {
        if (this.iconPadding == r10) goto L6;
        this.iconPadding = r10;
        setCompoundDrawablePadding(r10);
        return;
    }

    public void setIconResource(@DrawableRes int r10) {
        if (r10 == 0) goto L4;
        Drawable r11 = c.a.b(getContext(), r10);
    L5:
        setIcon(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    public void setIconSize(@Px int r10) {
        if (r10 < 0) goto L8;
        if (this.iconSize == r10) goto L9;
        this.iconSize = r10;
        updateIcon(true);
        return;
    L9:
        return;
    L8:
        throw new IllegalArgumentException("iconSize cannot be less than 0");
    }

    public void setIconTint(@Nullable ColorStateList r10) {
        if (this.iconTint == r10) goto L6;
        this.iconTint = r10;
        updateIcon(false);
        return;
    }

    public void setIconTintMode(PorterDuff.Mode r10) {
        if (this.iconTintMode == r10) goto L6;
        this.iconTintMode = r10;
        updateIcon(false);
        return;
    }

    public void setIconTintResource(@ColorRes int r10) {
        setIconTint(c.a.a(getContext(), r10));
    }

    public void setInsetBottom(@Dimension int r10) {
        this.materialButtonHelper.setInsetBottom(r10);
    }

    public void setInsetTop(@Dimension int r10) {
        this.materialButtonHelper.setInsetTop(r10);
    }

    public void setInternalBackground(Drawable r10) {
        super.setBackgroundDrawable(r10);
    }

    public void setOnPressedChangeListenerInternal(@Nullable OnPressedChangeListener r10) {
        this.onPressedChangeListenerInternal = r10;
    }

    @Override // android.view.View
    public void setPressed(boolean r10) {
        OnPressedChangeListener r11 = this.onPressedChangeListenerInternal;
        if (r11 == null) goto L5;
        r11.onPressedChanged(this, r10);
    L5:
        super.setPressed(r10);
    }

    public void setRippleColor(@Nullable ColorStateList r10) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.setRippleColor(r10);
        return;
    }

    public void setRippleColorResource(@ColorRes int r10) {
        if (isUsingOriginalBackground() == false) goto L6;
        setRippleColor(c.a.a(getContext(), r10));
        return;
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel r10) {
        if (isUsingOriginalBackground() == false) goto L7;
        this.materialButtonHelper.setShapeAppearanceModel(r10);
        return;
    L7:
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    public void setShouldDrawSurfaceColorStroke(boolean r10) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.setShouldDrawSurfaceColorStroke(r10);
        return;
    }

    public void setStrokeColor(@Nullable ColorStateList r10) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.setStrokeColor(r10);
        return;
    }

    public void setStrokeColorResource(@ColorRes int r10) {
        if (isUsingOriginalBackground() == false) goto L6;
        setStrokeColor(c.a.a(getContext(), r10));
        return;
    }

    public void setStrokeWidth(@Px int r10) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.setStrokeWidth(r10);
        return;
    }

    public void setStrokeWidthResource(@DimenRes int r10) {
        if (isUsingOriginalBackground() == false) goto L6;
        setStrokeWidth(getResources().getDimensionPixelSize(r10));
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@Nullable ColorStateList r10) {
        if (isUsingOriginalBackground() == false) goto L5;
        this.materialButtonHelper.setSupportBackgroundTintList(r10);
        return;
    L5:
        super.setSupportBackgroundTintList(r10);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode r10) {
        if (isUsingOriginalBackground() == false) goto L5;
        this.materialButtonHelper.setSupportBackgroundTintMode(r10);
        return;
    L5:
        super.setSupportBackgroundTintMode(r10);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.checked);
    }

    public MaterialButton(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, com.google.android.material.R.attr.materialButtonStyle);
    }

    public MaterialButton(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        int r13 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r10, r11, r12, r13), r11, r12);
        this.onCheckedChangeListeners = new LinkedHashSet();
        boolean r14 = false;
        this.checked = false;
        this.broadcasting = false;
        Context r15 = getContext();
        TypedArray r16 = ThemeEnforcement.obtainStyledAttributes(r15, r11, com.google.android.material.R.styleable.MaterialButton, r12, r13, new int[0]);
        this.iconPadding = r16.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialButton_iconPadding, 0);
        this.iconTintMode = ViewUtils.parseTintMode(r16.getInt(com.google.android.material.R.styleable.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.iconTint = MaterialResources.getColorStateList(getContext(), r16, com.google.android.material.R.styleable.MaterialButton_iconTint);
        this.icon = MaterialResources.getDrawable(getContext(), r16, com.google.android.material.R.styleable.MaterialButton_icon);
        this.iconGravity = r16.getInteger(com.google.android.material.R.styleable.MaterialButton_iconGravity, 1);
        this.iconSize = r16.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialButton_iconSize, 0);
        MaterialButtonHelper r17 = new MaterialButtonHelper(this, ShapeAppearanceModel.builder(r15, r11, r12, r13).build());
        this.materialButtonHelper = r17;
        r17.loadFromAttributes(r16);
        r16.recycle();
        setCompoundDrawablePadding(this.iconPadding);
        if (this.icon == null) goto L5;
        r14 = true;
    L5:
        updateIcon(r14);
    }
}
