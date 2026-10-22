package com.google.android.material.card;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import c.a;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialCardView extends CardView implements Checkable, Shapeable {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.cardview.widget.CardView";
    private static final int[] CHECKABLE_STATE_SET = null;
    private static final int[] CHECKED_STATE_SET = null;
    private static final int DEF_STYLE_RES = 0;
    private static final int[] DRAGGED_STATE_SET = null;
    private static final String LOG_TAG = "MaterialCardView";

    @NonNull
    private final MaterialCardViewHelper cardViewHelper;
    private boolean checked;
    private boolean dragged;
    private boolean isParentCardViewDoneInitializing;
    private OnCheckedChangeListener onCheckedChangeListener;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(MaterialCardView r10, boolean r11);
    }

    static {
        CHECKABLE_STATE_SET = new int[]{R.attr.state_checkable};
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        DRAGGED_STATE_SET = new int[]{com.google.android.material.R.attr.state_dragged};
        DEF_STYLE_RES = com.google.android.material.R.style.Widget_MaterialComponents_CardView;
    }

    public MaterialCardView(Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ float access$001(MaterialCardView r10) {
        return super.getRadius();
    }

    private void forceRippleRedrawIfNeeded() {
        this.cardViewHelper.forceRippleRedraw();
    }

    @NonNull
    private RectF getBoundsAsRectF() {
        RectF r10 = new RectF();
        r10.set(this.cardViewHelper.getBackground().getBounds());
        return r10;
    }

    @Override // androidx.cardview.widget.CardView
    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return this.cardViewHelper.getCardBackgroundColor();
    }

    @NonNull
    public ColorStateList getCardForegroundColor() {
        return this.cardViewHelper.getCardForegroundColor();
    }

    public float getCardViewRadius() {
        return access$001(this);
    }

    @Nullable
    public Drawable getCheckedIcon() {
        return this.cardViewHelper.getCheckedIcon();
    }

    @Dimension
    public int getCheckedIconMargin() {
        return this.cardViewHelper.getCheckedIconMargin();
    }

    @Dimension
    public int getCheckedIconSize() {
        return this.cardViewHelper.getCheckedIconSize();
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.cardViewHelper.getCheckedIconTint();
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.cardViewHelper.getUserContentPadding().bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.cardViewHelper.getUserContentPadding().left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.cardViewHelper.getUserContentPadding().right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.cardViewHelper.getUserContentPadding().top;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.cardViewHelper.getProgress();
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.cardViewHelper.getCornerRadius();
    }

    public ColorStateList getRippleColor() {
        return this.cardViewHelper.getRippleColor();
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.cardViewHelper.getShapeAppearanceModel();
    }

    @ColorInt
    @Deprecated
    public int getStrokeColor() {
        return this.cardViewHelper.getStrokeColor();
    }

    @Nullable
    public ColorStateList getStrokeColorStateList() {
        return this.cardViewHelper.getStrokeColorStateList();
    }

    @Dimension
    public int getStrokeWidth() {
        return this.cardViewHelper.getStrokeWidth();
    }

    public boolean isCheckable() {
        MaterialCardViewHelper r10 = this.cardViewHelper;
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

    public boolean isDragged() {
        return this.dragged;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.cardViewHelper.getBackground());
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int r10) {
        int[] r11 = super.onCreateDrawableState(r10 + 3);
        if (isCheckable() == false) goto L6;
        FrameLayout.mergeDrawableStates(r11, CHECKABLE_STATE_SET);
    L6:
        if (isChecked() == false) goto L9;
        FrameLayout.mergeDrawableStates(r11, CHECKED_STATE_SET);
    L9:
        if (isDragged() == false) goto L11;
        FrameLayout.mergeDrawableStates(r11, DRAGGED_STATE_SET);
    L11:
        return r11;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent r10) {
        super.onInitializeAccessibilityEvent(r10);
        r10.setClassName(ACCESSIBILITY_CLASS_NAME);
        r10.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        r10.setClassName(ACCESSIBILITY_CLASS_NAME);
        r10.setCheckable(isCheckable());
        r10.setClickable(isClickable());
        r10.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        this.cardViewHelper.onMeasure(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setAncestorContentPadding(int r10, int r11, int r12, int r13) {
        super.setContentPadding(r10, r11, r12, r13);
    }

    @Override // android.view.View
    public void setBackground(Drawable r10) {
        setBackgroundDrawable(r10);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r10) {
        if (this.isParentCardViewDoneInitializing == true) goto L5;
        return;
    L5:
        if (this.cardViewHelper.isBackgroundOverwritten() == true) goto L7;
        Log.i(LOG_TAG, "Setting a custom background is not supported.");
        this.cardViewHelper.setBackgroundOverwritten(true);
    L7:
        super.setBackgroundDrawable(r10);
    }

    public void setBackgroundInternal(Drawable r10) {
        super.setBackgroundDrawable(r10);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@ColorInt int r10) {
        this.cardViewHelper.setCardBackgroundColor(ColorStateList.valueOf(r10));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float r10) {
        super.setCardElevation(r10);
        this.cardViewHelper.updateElevation();
    }

    public void setCardForegroundColor(@Nullable ColorStateList r10) {
        this.cardViewHelper.setCardForegroundColor(r10);
    }

    public void setCheckable(boolean r10) {
        this.cardViewHelper.setCheckable(r10);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r10) {
        if (this.checked == r10) goto L6;
        toggle();
        return;
    }

    public void setCheckedIcon(@Nullable Drawable r10) {
        this.cardViewHelper.setCheckedIcon(r10);
    }

    public void setCheckedIconMargin(@Dimension int r10) {
        this.cardViewHelper.setCheckedIconMargin(r10);
    }

    public void setCheckedIconMarginResource(@DimenRes int r10) {
        if (r10 == (-1)) goto L6;
        this.cardViewHelper.setCheckedIconMargin(getResources().getDimensionPixelSize(r10));
        return;
    }

    public void setCheckedIconResource(@DrawableRes int r10) {
        this.cardViewHelper.setCheckedIcon(a.b(getContext(), r10));
    }

    public void setCheckedIconSize(@Dimension int r10) {
        this.cardViewHelper.setCheckedIconSize(r10);
    }

    public void setCheckedIconSizeResource(@DimenRes int r10) {
        if (r10 == 0) goto L5;
        this.cardViewHelper.setCheckedIconSize(getResources().getDimensionPixelSize(r10));
        return;
    }

    public void setCheckedIconTint(@Nullable ColorStateList r10) {
        this.cardViewHelper.setCheckedIconTint(r10);
    }

    @Override // android.view.View
    public void setClickable(boolean r10) {
        super.setClickable(r10);
        MaterialCardViewHelper r11 = this.cardViewHelper;
        if (r11 == null) goto L6;
        r11.updateClickable();
        return;
    }

    @Override // androidx.cardview.widget.CardView
    public void setContentPadding(int r10, int r11, int r12, int r13) {
        this.cardViewHelper.setUserContentPadding(r10, r11, r12, r13);
    }

    public void setDragged(boolean r10) {
        if (this.dragged == r10) goto L6;
        this.dragged = r10;
        refreshDrawableState();
        forceRippleRedrawIfNeeded();
        invalidate();
        return;
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float r10) {
        super.setMaxCardElevation(r10);
        this.cardViewHelper.updateInsets();
    }

    public void setOnCheckedChangeListener(@Nullable OnCheckedChangeListener r10) {
        this.onCheckedChangeListener = r10;
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean r10) {
        super.setPreventCornerOverlap(r10);
        this.cardViewHelper.updateInsets();
        this.cardViewHelper.updateContentPadding();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float r10) {
        this.cardViewHelper.setProgress(r10);
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float r10) {
        super.setRadius(r10);
        this.cardViewHelper.setCornerRadius(r10);
    }

    public void setRippleColor(@Nullable ColorStateList r10) {
        this.cardViewHelper.setRippleColor(r10);
    }

    public void setRippleColorResource(@ColorRes int r10) {
        this.cardViewHelper.setRippleColor(a.a(getContext(), r10));
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel r10) {
        setClipToOutline(r10.isRoundRect(getBoundsAsRectF()));
        this.cardViewHelper.setShapeAppearanceModel(r10);
    }

    public void setStrokeColor(@ColorInt int r10) {
        this.cardViewHelper.setStrokeColor(ColorStateList.valueOf(r10));
    }

    public void setStrokeWidth(@Dimension int r10) {
        this.cardViewHelper.setStrokeWidth(r10);
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean r10) {
        super.setUseCompatPadding(r10);
        this.cardViewHelper.updateInsets();
        this.cardViewHelper.updateContentPadding();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (isCheckable() == true) goto L5;
        return;
    L5:
        if (isEnabled() == false) goto L11;
        this.checked = !this.checked;
        refreshDrawableState();
        forceRippleRedrawIfNeeded();
        OnCheckedChangeListener r10 = this.onCheckedChangeListener;
        if (r10 == null) goto L12;
        r10.onCheckedChanged(this, this.checked);
        return;
    L12:
        return;
    }

    public MaterialCardView(Context r10, AttributeSet r11) {
        this(r10, r11, com.google.android.material.R.attr.materialCardViewStyle);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@Nullable ColorStateList r10) {
        this.cardViewHelper.setCardBackgroundColor(r10);
    }

    public void setStrokeColor(ColorStateList r10) {
        this.cardViewHelper.setStrokeColor(r10);
    }

    public MaterialCardView(Context r10, AttributeSet r11, int r12) {
        int r13 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r10, r11, r12, r13), r11, r12);
        this.checked = false;
        this.dragged = false;
        this.isParentCardViewDoneInitializing = true;
        TypedArray r14 = ThemeEnforcement.obtainStyledAttributes(getContext(), r11, com.google.android.material.R.styleable.MaterialCardView, r12, r13, new int[0]);
        MaterialCardViewHelper r15 = new MaterialCardViewHelper(this, r11, r12, r13);
        this.cardViewHelper = r15;
        r15.setCardBackgroundColor(super.getCardBackgroundColor());
        r15.setUserContentPadding(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        r15.loadFromAttributes(r14);
        r14.recycle();
    }
}
