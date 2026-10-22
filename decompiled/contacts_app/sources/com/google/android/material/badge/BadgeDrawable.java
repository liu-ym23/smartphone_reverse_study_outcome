package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class BadgeDrawable extends Drawable implements TextDrawableHelper.TextDrawableDelegate {
    static final int BADGE_RADIUS_NOT_SPECIFIED = -1;
    public static final int BOTTOM_END = 8388693;
    public static final int BOTTOM_START = 8388691;
    static final String DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX = "+";
    private static final int DEFAULT_STYLE = 0;
    private static final int DEFAULT_THEME_ATTR = 0;
    private static final int MAX_CIRCULAR_BADGE_NUMBER_COUNT = 9;
    static final int OFFSET_ALIGNMENT_MODE_EDGE = 0;
    static final int OFFSET_ALIGNMENT_MODE_LEGACY = 1;
    public static final int TOP_END = 8388661;
    public static final int TOP_START = 8388659;
    private WeakReference<View> anchorViewRef;
    private final Rect badgeBounds;
    private float badgeCenterX;
    private float badgeCenterY;
    private final WeakReference<Context> contextRef;
    private float cornerRadius;
    private WeakReference<FrameLayout> customBadgeParentRef;
    private float halfBadgeHeight;
    private float halfBadgeWidth;
    private int maxBadgeNumber;
    private final MaterialShapeDrawable shapeDrawable;
    private final BadgeState state;
    private final TextDrawableHelper textDrawableHelper;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BadgeGravity {
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
    }

    static {
        DEFAULT_STYLE = R.style.Widget_MaterialComponents_Badge;
        DEFAULT_THEME_ATTR = R.attr.badgeStyle;
    }

    BadgeState.State getSavedState() {
        return this.state.getOverridingState();
    }

    static BadgeDrawable createFromSavedState(Context r7, BadgeState.State r8) {
        return new BadgeDrawable(r7, 0, DEFAULT_THEME_ATTR, DEFAULT_STYLE, r8);
    }

    public static BadgeDrawable create(Context r7) {
        return new BadgeDrawable(r7, 0, DEFAULT_THEME_ATTR, DEFAULT_STYLE, null);
    }

    public static BadgeDrawable createFromResource(Context r7, int r8) {
        return new BadgeDrawable(r7, r8, DEFAULT_THEME_ATTR, DEFAULT_STYLE, null);
    }

    public void setVisible(boolean r2) {
        this.state.setVisible(r2);
        onVisibilityUpdated();
    }

    private void onVisibilityUpdated() {
        boolean r0 = this.state.isVisible();
        setVisible(r0, false);
        if (BadgeUtils.USE_COMPAT_PARENT == true) goto L5;
        return;
    L5:
        if (getCustomBadgeParent() == null) goto L10;
        if (r0 == true) goto L11;
        ((ViewGroup) getCustomBadgeParent().getParent()).invalidate();
        return;
    L11:
        return;
    }

    private void restoreState() {
        onBadgeShapeAppearanceUpdated();
        onBadgeTextAppearanceUpdated();
        onMaxCharacterCountUpdated();
        onNumberUpdated();
        onAlphaUpdated();
        onBackgroundColorUpdated();
        onBadgeTextColorUpdated();
        onBadgeGravityUpdated();
        updateCenterAndBounds();
        onVisibilityUpdated();
    }

    private BadgeDrawable(Context r9, int r10, int r11, int r12, BadgeState.State r13) {
        this.contextRef = new WeakReference(r9);
        ThemeEnforcement.checkMaterialTheme(r9);
        this.badgeBounds = new Rect();
        TextDrawableHelper r0 = new TextDrawableHelper(this);
        this.textDrawableHelper = r0;
        r0.getTextPaint().setTextAlign(Paint.Align.CENTER);
        BadgeState r1 = new BadgeState(r9, r10, r11, r12, r13);
        this.state = r1;
        if (r1.hasNumber() == false) goto L5;
        int r14 = r1.getBadgeWithTextShapeAppearanceResId();
    L7:
        if (r1.hasNumber() == false) goto L9;
        int r15 = r1.getBadgeWithTextShapeAppearanceOverlayResId();
    L10:
        this.shapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder(r9, r14, r15).build());
        restoreState();
        return;
    L9:
        r15 = r1.getBadgeShapeAppearanceOverlayResId();
        goto L10
    L5:
        r14 = r1.getBadgeShapeAppearanceResId();
        goto L7
    }

    @Deprecated
    public void updateBadgeCoordinates(View r2, ViewGroup r3) {
        if ((r3 instanceof FrameLayout) == false) goto L7;
        updateBadgeCoordinates(r2, (FrameLayout) r3);
        return;
    L7:
        throw new IllegalArgumentException("customBadgeParent must be a FrameLayout");
    }

    public void updateBadgeCoordinates(View r2) {
        updateBadgeCoordinates(r2, null);
    }

    public void updateBadgeCoordinates(View r2, FrameLayout r3) {
        this.anchorViewRef = new WeakReference(r2);
        if (BadgeUtils.USE_COMPAT_PARENT == false) goto L6;
        if (r3 != null) goto L6;
        tryWrapAnchorInCompatParent(r2);
    L8:
        if (BadgeUtils.USE_COMPAT_PARENT == true) goto L10;
        updateAnchorParentToNotClip(r2);
    L10:
        updateCenterAndBounds();
        invalidateSelf();
        return;
    L6:
        this.customBadgeParentRef = new WeakReference(r3);
        goto L8
    }

    public FrameLayout getCustomBadgeParent() {
        WeakReference<FrameLayout> r0 = this.customBadgeParentRef;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    private void tryWrapAnchorInCompatParent(final View r6) {
        ViewGroup r0 = (ViewGroup) r6.getParent();
        if (r0 != null) goto L5;
    L6:
        WeakReference<FrameLayout> r1 = this.customBadgeParentRef;
        if (r1 != null) goto L9;
    L11:
        updateAnchorParentToNotClip(r6);
        final FrameLayout r2 = new FrameLayout(r6.getContext());
        r2.setId(R.id.mtrl_anchor_parent);
        r2.setClipChildren(false);
        r2.setClipToPadding(false);
        r2.setLayoutParams(r6.getLayoutParams());
        r2.setMinimumWidth(r6.getWidth());
        r2.setMinimumHeight(r6.getHeight());
        int r3 = r0.indexOfChild(r6);
        r0.removeViewAt(r3);
        r6.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r2.addView(r6);
        r0.addView(r2, r3);
        this.customBadgeParentRef = new WeakReference(r2);
        r2.post(new AnonymousClass1(this, r6, r2));
        return;
    L9:
        if (r1.get() != r0) goto L11;
        return;
    L5:
        if (r0.getId() != R.id.mtrl_anchor_parent) goto L6;
    }

    private static void updateAnchorParentToNotClip(View r1) {
        ViewGroup r2 = (ViewGroup) r1.getParent();
        r2.setClipChildren(false);
        r2.setClipToPadding(false);
    }

    public int getBackgroundColor() {
        return this.shapeDrawable.getFillColor().getDefaultColor();
    }

    public void setBackgroundColor(int r2) {
        this.state.setBackgroundColor(r2);
        onBackgroundColorUpdated();
    }

    private void onBackgroundColorUpdated() {
        ColorStateList r0 = ColorStateList.valueOf(this.state.getBackgroundColor());
        if (this.shapeDrawable.getFillColor() == r0) goto L6;
        this.shapeDrawable.setFillColor(r0);
        invalidateSelf();
        return;
    }

    public int getBadgeTextColor() {
        return this.textDrawableHelper.getTextPaint().getColor();
    }

    public void setBadgeTextColor(int r2) {
        if (this.textDrawableHelper.getTextPaint().getColor() == r2) goto L6;
        this.state.setBadgeTextColor(r2);
        onBadgeTextColorUpdated();
        return;
    }

    private void onBadgeTextColorUpdated() {
        this.textDrawableHelper.getTextPaint().setColor(this.state.getBadgeTextColor());
        invalidateSelf();
    }

    public Locale getBadgeNumberLocale() {
        return this.state.getNumberLocale();
    }

    public void setBadgeNumberLocale(Locale r2) {
        if (r2.equals(this.state.getNumberLocale()) == true) goto L6;
        this.state.setNumberLocale(r2);
        invalidateSelf();
        return;
    }

    public boolean hasNumber() {
        return this.state.hasNumber();
    }

    public int getNumber() {
        if (hasNumber() == true) goto L7;
        return 0;
    L7:
        return this.state.getNumber();
    }

    public void setNumber(int r2) {
        int r3 = Math.max(0, r2);
        if (this.state.getNumber() == r3) goto L6;
        this.state.setNumber(r3);
        onNumberUpdated();
        return;
    }

    public void clearNumber() {
        if (hasNumber() == false) goto L6;
        this.state.clearNumber();
        onNumberUpdated();
        return;
    }

    private void onNumberUpdated() {
        this.textDrawableHelper.setTextWidthDirty(true);
        onBadgeShapeAppearanceUpdated();
        updateCenterAndBounds();
        invalidateSelf();
    }

    public int getMaxCharacterCount() {
        return this.state.getMaxCharacterCount();
    }

    public void setMaxCharacterCount(int r2) {
        if (this.state.getMaxCharacterCount() == r2) goto L6;
        this.state.setMaxCharacterCount(r2);
        onMaxCharacterCountUpdated();
        return;
    }

    private void onMaxCharacterCountUpdated() {
        updateMaxBadgeNumber();
        this.textDrawableHelper.setTextWidthDirty(true);
        updateCenterAndBounds();
        invalidateSelf();
    }

    public int getBadgeGravity() {
        return this.state.getBadgeGravity();
    }

    public void setBadgeGravity(int r2) {
        if (this.state.getBadgeGravity() == r2) goto L6;
        this.state.setBadgeGravity(r2);
        onBadgeGravityUpdated();
        return;
    }

    private void onBadgeGravityUpdated() {
        WeakReference<View> r0 = this.anchorViewRef;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.get() == null) goto L13;
        View r1 = this.anchorViewRef.get();
        WeakReference<FrameLayout> r2 = this.customBadgeParentRef;
        if (r2 == null) goto L9;
        FrameLayout r3 = r2.get();
    L10:
        updateBadgeCoordinates(r1, r3);
        return;
    L9:
        r3 = null;
        goto L10
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.state.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        this.state.setAlpha(r2);
        onAlphaUpdated();
    }

    private void onAlphaUpdated() {
        this.textDrawableHelper.getTextPaint().setAlpha(getAlpha());
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.badgeBounds.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.badgeBounds.width();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r2) {
        if (getBounds().isEmpty() == false) goto L5;
        return;
    L5:
        if (getAlpha() != 0) goto L7;
        return;
    L7:
        if (isVisible() == false) goto L16;
        this.shapeDrawable.draw(r2);
        if (hasNumber() == false) goto L15;
        drawText(r2);
        return;
    L15:
        return;
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void onTextSizeChange() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] r1) {
        return super.onStateChange(r1);
    }

    public void setContentDescriptionNumberless(CharSequence r1) {
        this.state.setContentDescriptionNumberless(r1);
    }

    public void setContentDescriptionQuantityStringsResource(int r1) {
        this.state.setContentDescriptionQuantityStringsResource(r1);
    }

    public void setContentDescriptionExceedsMaxBadgeNumberStringResource(int r1) {
        this.state.setContentDescriptionExceedsMaxBadgeNumberStringResource(r1);
    }

    public CharSequence getContentDescription() {
        if (isVisible() == true) goto L6;
        return null;
    L6:
        if (hasNumber() == false) goto L20;
        if (this.state.getContentDescriptionQuantityStrings() == 0) goto L18;
        Context r0 = this.contextRef.get();
        if (r0 != null) goto L13;
        return null;
    L13:
        if (getNumber() > this.maxBadgeNumber) goto L17;
        return r0.getResources().getQuantityString(this.state.getContentDescriptionQuantityStrings(), getNumber(), new Object[]{Integer.valueOf(getNumber())});
    L17:
        return r0.getString(this.state.getContentDescriptionExceedsMaxBadgeNumberStringResource(), new Object[]{Integer.valueOf(this.maxBadgeNumber)});
    L18:
        return null;
    L20:
        return this.state.getContentDescriptionNumberless();
    }

    public void setHorizontalOffset(int r1) {
        setHorizontalOffsetWithoutText(r1);
        setHorizontalOffsetWithText(r1);
    }

    public int getHorizontalOffset() {
        return this.state.getHorizontalOffsetWithoutText();
    }

    public void setHorizontalOffsetWithoutText(int r2) {
        this.state.setHorizontalOffsetWithoutText(r2);
        updateCenterAndBounds();
    }

    public int getHorizontalOffsetWithoutText() {
        return this.state.getHorizontalOffsetWithoutText();
    }

    public void setHorizontalOffsetWithText(int r2) {
        this.state.setHorizontalOffsetWithText(r2);
        updateCenterAndBounds();
    }

    public int getHorizontalOffsetWithText() {
        return this.state.getHorizontalOffsetWithText();
    }

    void setAdditionalHorizontalOffset(int r2) {
        this.state.setAdditionalHorizontalOffset(r2);
        updateCenterAndBounds();
    }

    int getAdditionalHorizontalOffset() {
        return this.state.getAdditionalHorizontalOffset();
    }

    public void setVerticalOffset(int r1) {
        setVerticalOffsetWithoutText(r1);
        setVerticalOffsetWithText(r1);
    }

    public int getVerticalOffset() {
        return this.state.getVerticalOffsetWithoutText();
    }

    public void setVerticalOffsetWithoutText(int r2) {
        this.state.setVerticalOffsetWithoutText(r2);
        updateCenterAndBounds();
    }

    public int getVerticalOffsetWithoutText() {
        return this.state.getVerticalOffsetWithoutText();
    }

    public void setVerticalOffsetWithText(int r2) {
        this.state.setVerticalOffsetWithText(r2);
        updateCenterAndBounds();
    }

    public int getVerticalOffsetWithText() {
        return this.state.getVerticalOffsetWithText();
    }

    void setAdditionalVerticalOffset(int r2) {
        this.state.setAdditionalVerticalOffset(r2);
        updateCenterAndBounds();
    }

    int getAdditionalVerticalOffset() {
        return this.state.getAdditionalVerticalOffset();
    }

    public void setTextAppearance(int r2) {
        this.state.setTextAppearanceResId(r2);
        onBadgeTextAppearanceUpdated();
    }

    private void onBadgeTextAppearanceUpdated() {
        Context r0 = this.contextRef.get();
        if (r0 != null) goto L5;
        return;
    L5:
        TextAppearance r1 = new TextAppearance(r0, this.state.getTextAppearanceResId());
        if (this.textDrawableHelper.getTextAppearance() != r1) goto L8;
        return;
    L8:
        this.textDrawableHelper.setTextAppearance(r1, r0);
        onBadgeTextColorUpdated();
        updateCenterAndBounds();
        invalidateSelf();
    }

    public void setBadgeWithoutTextShapeAppearance(int r2) {
        this.state.setBadgeShapeAppearanceResId(r2);
        onBadgeShapeAppearanceUpdated();
    }

    public void setBadgeWithoutTextShapeAppearanceOverlay(int r2) {
        this.state.setBadgeShapeAppearanceOverlayResId(r2);
        onBadgeShapeAppearanceUpdated();
    }

    public void setBadgeWithTextShapeAppearance(int r2) {
        this.state.setBadgeWithTextShapeAppearanceResId(r2);
        onBadgeShapeAppearanceUpdated();
    }

    public void setBadgeWithTextShapeAppearanceOverlay(int r2) {
        this.state.setBadgeWithTextShapeAppearanceOverlayResId(r2);
        onBadgeShapeAppearanceUpdated();
    }

    private void onBadgeShapeAppearanceUpdated() {
        Context r0 = this.contextRef.get();
        if (r0 != null) goto L5;
        return;
    L5:
        MaterialShapeDrawable r1 = this.shapeDrawable;
        if (this.state.hasNumber() == false) goto L8;
        int r2 = this.state.getBadgeWithTextShapeAppearanceResId();
    L10:
        if (this.state.hasNumber() == false) goto L12;
        int r3 = this.state.getBadgeWithTextShapeAppearanceOverlayResId();
    L13:
        r1.setShapeAppearanceModel(ShapeAppearanceModel.builder(r0, r2, r3).build());
        invalidateSelf();
        return;
    L12:
        r3 = this.state.getBadgeShapeAppearanceOverlayResId();
        goto L13
    L8:
        r2 = this.state.getBadgeShapeAppearanceResId();
        goto L10
    }

    private void updateCenterAndBounds() {
        Context r0 = this.contextRef.get();
        WeakReference<View> r1 = this.anchorViewRef;
        FrameLayout r2 = null;
        if (r1 == null) goto L5;
        View r3 = r1.get();
    L6:
        if (r0 == null) goto L25;
        if (r3 == null) goto L27;
        Rect r4 = new Rect();
        r4.set(this.badgeBounds);
        Rect r5 = new Rect();
        r3.getDrawingRect(r5);
        WeakReference<FrameLayout> r6 = this.customBadgeParentRef;
        if (r6 == null) goto L12;
        r2 = r6.get();
    L12:
        if (r2 == null) goto L14;
    L15:
        if (r2 != null) goto L17;
        r2 = (ViewGroup) r3.getParent();
    L17:
        r2.offsetDescendantRectToMyCoords(r3, r5);
    L18:
        calculateCenterAndBounds(r5, r3);
        BadgeUtils.updateBadgeBounds(this.badgeBounds, this.badgeCenterX, this.badgeCenterY, this.halfBadgeWidth, this.halfBadgeHeight);
        float r7 = this.cornerRadius;
        if (r7 == (-1.0f)) goto L22;
        this.shapeDrawable.setCornerSize(r7);
    L22:
        if (r4.equals(this.badgeBounds) == true) goto L26;
        this.shapeDrawable.setBounds(this.badgeBounds);
        return;
    L26:
        return;
    L14:
        if (BadgeUtils.USE_COMPAT_PARENT == false) goto L18;
    L27:
        return;
    L25:
        return;
    L5:
        r3 = null;
        goto L6
    }

    private int getTotalVerticalOffsetForState() {
        if (hasNumber() == false) goto L5;
        int r0 = this.state.getVerticalOffsetWithText();
    L7:
        if (this.state.offsetAlignmentMode != 0) goto L10;
        r0 = r0 - Math.round(this.halfBadgeHeight);
    L10:
        return r0 + this.state.getAdditionalVerticalOffset();
    L5:
        r0 = this.state.getVerticalOffsetWithoutText();
        goto L7
    }

    private int getTotalHorizontalOffsetForState() {
        if (hasNumber() == false) goto L5;
        int r0 = this.state.getHorizontalOffsetWithText();
    L7:
        if (this.state.offsetAlignmentMode != 1) goto L14;
        if (hasNumber() == false) goto L11;
        int r1 = this.state.horizontalInsetWithText;
    L12:
        r0 = r0 + r1;
        goto L14
    L11:
        r1 = this.state.horizontalInset;
    L14:
        return r0 + this.state.getAdditionalHorizontalOffset();
    L5:
        r0 = this.state.getHorizontalOffsetWithoutText();
        goto L7
    }

    private void calculateCenterAndBounds(Rect r5, View r6) {
        if (hasNumber() == true) goto L5;
        float r0 = this.state.badgeRadius;
    L6:
        this.cornerRadius = r0;
        if (r0 == (-1.0f)) goto L10;
        this.halfBadgeHeight = r0;
        this.halfBadgeWidth = r0;
    L19:
        if (getNumber() <= 9) goto L21;
        this.halfBadgeWidth = Math.max(this.halfBadgeWidth, (this.textDrawableHelper.getTextWidth(getBadgeText()) / 2.0f) + this.state.badgeWidePadding);
    L21:
        int r1 = getTotalVerticalOffsetForState();
        int r2 = this.state.getBadgeGravity();
        if (r2 != 8388691) goto L24;
    L26:
        this.badgeCenterY = r5.bottom - r1;
    L27:
        int r3 = getTotalHorizontalOffsetForState();
        int r4 = this.state.getBadgeGravity();
        if (r4 == 8388659) goto L36;
        if (r4 == 8388691) goto L36;
        if (ViewCompat.getLayoutDirection(r6) != 0) goto L33;
        float r7 = (r5.right + this.halfBadgeWidth) - r3;
    L34:
        this.badgeCenterX = r7;
        return;
    L33:
        r7 = (r5.left - this.halfBadgeWidth) + r3;
    L36:
        if (ViewCompat.getLayoutDirection(r6) != 0) goto L38;
        float r8 = (r5.left - this.halfBadgeWidth) + r3;
    L39:
        this.badgeCenterX = r8;
        return;
    L38:
        r8 = (r5.right + this.halfBadgeWidth) - r3;
        goto L39
    L24:
        if (r2 == 8388693) goto L26;
        this.badgeCenterY = r5.top + r1;
        goto L27
    L10:
        if (hasNumber() == true) goto L12;
        float r9 = this.state.badgeHeight;
    L13:
        this.halfBadgeHeight = Math.round(r9 / 2.0f);
        if (hasNumber() == true) goto L16;
        float r10 = this.state.badgeWidth;
    L17:
        this.halfBadgeWidth = Math.round(r10 / 2.0f);
        goto L19
    L16:
        r10 = this.state.badgeWithTextWidth;
        goto L17
    L12:
        r9 = this.state.badgeWithTextHeight;
        goto L13
    L5:
        r0 = this.state.badgeWithTextRadius;
        goto L6
    }

    private void drawText(Canvas r6) {
        Rect r0 = new Rect();
        String r1 = getBadgeText();
        this.textDrawableHelper.getTextPaint().getTextBounds(r1, 0, r1.length(), r0);
        r6.drawText(r1, this.badgeCenterX, this.badgeCenterY + (r0.height() / 2), this.textDrawableHelper.getTextPaint());
    }

    private String getBadgeText() {
        if (getNumber() <= this.maxBadgeNumber) goto L5;
        Context r0 = this.contextRef.get();
        if (r0 != null) goto L11;
        return "";
    L11:
        return String.format(this.state.getNumberLocale(), r0.getString(R.string.mtrl_exceed_max_badge_number_suffix), new Object[]{Integer.valueOf(this.maxBadgeNumber), DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX});
    L5:
        return NumberFormat.getInstance(this.state.getNumberLocale()).format(getNumber());
    }

    private void updateMaxBadgeNumber() {
        this.maxBadgeNumber = ((int) Math.pow(10.0d, ((double) getMaxCharacterCount()) - 1.0d)) - 1;
    }
}
