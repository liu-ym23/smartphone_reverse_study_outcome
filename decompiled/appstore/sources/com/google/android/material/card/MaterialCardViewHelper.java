package com.google.android.material.card;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.view.ViewCompat;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.CutCornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;
import o.a;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class MaterialCardViewHelper {
    private static final float CARD_VIEW_SHADOW_MULTIPLIER = 1.5f;
    private static final int CHECKED_ICON_LAYER_INDEX = 2;
    private static final int[] CHECKED_STATE_SET = null;
    private static final double COS_45 = 0.0d;
    private static final int DEFAULT_STROKE_VALUE = -1;

    @NonNull
    private final MaterialShapeDrawable bgDrawable;
    private boolean checkable;

    @Nullable
    private Drawable checkedIcon;

    @Dimension
    private int checkedIconMargin;

    @Dimension
    private int checkedIconSize;

    @Nullable
    private ColorStateList checkedIconTint;

    @Nullable
    private LayerDrawable clickableForegroundDrawable;

    @Nullable
    private MaterialShapeDrawable compatRippleDrawable;

    @Nullable
    private Drawable fgDrawable;

    @NonNull
    private final MaterialShapeDrawable foregroundContentDrawable;

    @Nullable
    private MaterialShapeDrawable foregroundShapeDrawable;
    private boolean isBackgroundOverwritten;

    @NonNull
    private final MaterialCardView materialCardView;

    @Nullable
    private ColorStateList rippleColor;

    @Nullable
    private Drawable rippleDrawable;

    @Nullable
    private ShapeAppearanceModel shapeAppearanceModel;

    @Nullable
    private ColorStateList strokeColor;

    @Dimension
    private int strokeWidth;

    @NonNull
    private final Rect userContentPadding;

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        COS_45 = Math.cos(Math.toRadians(45.0d));
    }

    public MaterialCardViewHelper(@NonNull MaterialCardView r10, AttributeSet r11, int r12, @StyleRes int r13) {
        this.userContentPadding = new Rect();
        this.isBackgroundOverwritten = false;
        this.materialCardView = r10;
        MaterialShapeDrawable r14 = new MaterialShapeDrawable(r10.getContext(), r11, r12, r13);
        this.bgDrawable = r14;
        r14.initializeElevationOverlay(r10.getContext());
        r14.setShadowColor(-12303292);
        ShapeAppearanceModel.Builder r15 = r14.getShapeAppearanceModel().toBuilder();
        TypedArray r16 = r10.getContext().obtainStyledAttributes(r11, com.google.android.material.R.styleable.CardView, r12, com.google.android.material.R.style.CardView);
        int r17 = com.google.android.material.R.styleable.CardView_cardCornerRadius;
        if (r16.hasValue(r17) == false) goto L5;
        r15.setAllCornerSizes(r16.getDimension(r17, 0.0f));
    L5:
        this.foregroundContentDrawable = new MaterialShapeDrawable();
        setShapeAppearanceModel(r15.build());
        r16.recycle();
    }

    private float calculateActualCornerPadding() {
        return Math.max(Math.max(calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getTopLeftCorner(), this.bgDrawable.getTopLeftCornerResolvedSize()), calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getTopRightCorner(), this.bgDrawable.getTopRightCornerResolvedSize())), Math.max(calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getBottomRightCorner(), this.bgDrawable.getBottomRightCornerResolvedSize()), calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getBottomLeftCorner(), this.bgDrawable.getBottomLeftCornerResolvedSize())));
    }

    private float calculateCornerPaddingForCornerTreatment(CornerTreatment r10, float r11) {
        if ((r10 instanceof RoundedCornerTreatment) == false) goto L7;
        return (float) ((1.0d - COS_45) * ((double) r11));
    L7:
        if ((r10 instanceof CutCornerTreatment) == true) goto L9;
        return 0.0f;
    L9:
        return r11 / 2.0f;
    }

    private float calculateHorizontalBackgroundPadding() {
        float r10 = this.materialCardView.getMaxCardElevation();
        if (shouldAddCornerPaddingOutsideCardBackground() == false) goto L5;
        float r11 = calculateActualCornerPadding();
    L7:
        return r10 + r11;
    L5:
        r11 = 0.0f;
        goto L7
    }

    private float calculateVerticalBackgroundPadding() {
        float r10 = this.materialCardView.getMaxCardElevation() * 1.5f;
        if (shouldAddCornerPaddingOutsideCardBackground() == false) goto L5;
        float r11 = calculateActualCornerPadding();
    L7:
        return r10 + r11;
    L5:
        r11 = 0.0f;
        goto L7
    }

    private boolean canClipToOutline() {
        return this.bgDrawable.isRoundRect();
    }

    @NonNull
    private Drawable createCheckedIconLayer() {
        StateListDrawable r10 = new StateListDrawable();
        Drawable r11 = this.checkedIcon;
        if (r11 == null) goto L5;
        r10.addState(CHECKED_STATE_SET, r11);
    L5:
        return r10;
    }

    @NonNull
    private Drawable createCompatRippleDrawable() {
        StateListDrawable r10 = new StateListDrawable();
        MaterialShapeDrawable r11 = createForegroundShapeDrawable();
        this.compatRippleDrawable = r11;
        r11.setFillColor(this.rippleColor);
        r10.addState(new int[]{R.attr.state_pressed}, this.compatRippleDrawable);
        return r10;
    }

    @NonNull
    private Drawable createForegroundRippleDrawable() {
        if (RippleUtils.USE_FRAMEWORK_RIPPLE == false) goto L7;
        this.foregroundShapeDrawable = createForegroundShapeDrawable();
        return new RippleDrawable(this.rippleColor, null, this.foregroundShapeDrawable);
    L7:
        return createCompatRippleDrawable();
    }

    @NonNull
    private MaterialShapeDrawable createForegroundShapeDrawable() {
        return new MaterialShapeDrawable(this.shapeAppearanceModel);
    }

    @NonNull
    private Drawable getClickableForeground() {
        if (this.rippleDrawable != null) goto L6;
        this.rippleDrawable = createForegroundRippleDrawable();
    L6:
        if (this.clickableForegroundDrawable != null) goto L9;
        Drawable r10 = createCheckedIconLayer();
        LayerDrawable r11 = new LayerDrawable(new Drawable[]{this.rippleDrawable, this.foregroundContentDrawable, r10});
        this.clickableForegroundDrawable = r11;
        r11.setId(2, com.google.android.material.R.id.mtrl_card_checked_layer_id);
    L9:
        return this.clickableForegroundDrawable;
    }

    private float getParentCardViewCalculatedCornerPadding() {
        if (this.materialCardView.getPreventCornerOverlap() == true) goto L5;
        return 0.0f;
    L5:
        if (this.materialCardView.getUseCompatPadding() == true) goto L7;
        return 0.0f;
    L7:
        return (float) ((1.0d - COS_45) * ((double) this.materialCardView.getCardViewRadius()));
    }

    @NonNull
    private Drawable insetDrawable(final Drawable r10) {
        if (this.materialCardView.getUseCompatPadding() == false) goto L5;
        final int r11 = (int) Math.ceil(calculateVerticalBackgroundPadding());
        final int r12 = (int) Math.ceil(calculateHorizontalBackgroundPadding());
    L6:
        final int r13 = r12;
        final int r14 = r11;
        return new AnonymousClass1(this, r10, r13, r14, r12, r11);
    L5:
        r12 = 0;
        r11 = 0;
        goto L6
    }

    private boolean shouldAddCornerPaddingInsideCardBackground() {
        if (this.materialCardView.getPreventCornerOverlap() == true) goto L5;
    L7:
        return false;
    L5:
        if (canClipToOutline() == true) goto L7;
        return true;
    }

    private boolean shouldAddCornerPaddingOutsideCardBackground() {
        if (this.materialCardView.getPreventCornerOverlap() == true) goto L5;
    L9:
        return false;
    L5:
        if (canClipToOutline() == false) goto L9;
        if (this.materialCardView.getUseCompatPadding() == false) goto L9;
        return true;
    }

    private void updateInsetForeground(Drawable r10) {
        if ((this.materialCardView.getForeground() instanceof InsetDrawable) == false) goto L5;
        ((InsetDrawable) this.materialCardView.getForeground()).setDrawable(r10);
        return;
    L5:
        this.materialCardView.setForeground(insetDrawable(r10));
    }

    private void updateRippleColor() {
        if (RippleUtils.USE_FRAMEWORK_RIPPLE == false) goto L7;
        Drawable r10 = this.rippleDrawable;
        if (r10 == null) goto L7;
        ((RippleDrawable) r10).setColor(this.rippleColor);
        return;
    L7:
        MaterialShapeDrawable r11 = this.compatRippleDrawable;
        if (r11 == null) goto L12;
        r11.setFillColor(this.rippleColor);
        return;
    }

    @RequiresApi(api = 23)
    public void forceRippleRedraw() {
        Drawable r10 = this.rippleDrawable;
        if (r10 == null) goto L6;
        Rect r11 = r10.getBounds();
        int r12 = r11.bottom;
        this.rippleDrawable.setBounds(r11.left, r11.top, r11.right, r12 - 1);
        this.rippleDrawable.setBounds(r11.left, r11.top, r11.right, r12);
        return;
    }

    @NonNull
    public MaterialShapeDrawable getBackground() {
        return this.bgDrawable;
    }

    public ColorStateList getCardBackgroundColor() {
        return this.bgDrawable.getFillColor();
    }

    public ColorStateList getCardForegroundColor() {
        return this.foregroundContentDrawable.getFillColor();
    }

    @Nullable
    public Drawable getCheckedIcon() {
        return this.checkedIcon;
    }

    @Dimension
    public int getCheckedIconMargin() {
        return this.checkedIconMargin;
    }

    @Dimension
    public int getCheckedIconSize() {
        return this.checkedIconSize;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.checkedIconTint;
    }

    public float getCornerRadius() {
        return this.bgDrawable.getTopLeftCornerResolvedSize();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.bgDrawable.getInterpolation();
    }

    @Nullable
    public ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    @ColorInt
    public int getStrokeColor() {
        ColorStateList r10 = this.strokeColor;
        if (r10 != null) goto L6;
        return -1;
    L6:
        return r10.getDefaultColor();
    }

    @Nullable
    public ColorStateList getStrokeColorStateList() {
        return this.strokeColor;
    }

    @Dimension
    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    @NonNull
    public Rect getUserContentPadding() {
        return this.userContentPadding;
    }

    public boolean isBackgroundOverwritten() {
        return this.isBackgroundOverwritten;
    }

    public boolean isCheckable() {
        return this.checkable;
    }

    public void loadFromAttributes(@NonNull TypedArray r10) {
        ColorStateList r11 = MaterialResources.getColorStateList(this.materialCardView.getContext(), r10, com.google.android.material.R.styleable.MaterialCardView_strokeColor);
        this.strokeColor = r11;
        if (r11 != null) goto L5;
        this.strokeColor = ColorStateList.valueOf(-1);
    L5:
        this.strokeWidth = r10.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialCardView_strokeWidth, 0);
        boolean r12 = r10.getBoolean(com.google.android.material.R.styleable.MaterialCardView_android_checkable, false);
        this.checkable = r12;
        this.materialCardView.setLongClickable(r12);
        this.checkedIconTint = MaterialResources.getColorStateList(this.materialCardView.getContext(), r10, com.google.android.material.R.styleable.MaterialCardView_checkedIconTint);
        setCheckedIcon(MaterialResources.getDrawable(this.materialCardView.getContext(), r10, com.google.android.material.R.styleable.MaterialCardView_checkedIcon));
        setCheckedIconSize(r10.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialCardView_checkedIconSize, 0));
        setCheckedIconMargin(r10.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialCardView_checkedIconMargin, 0));
        ColorStateList r13 = MaterialResources.getColorStateList(this.materialCardView.getContext(), r10, com.google.android.material.R.styleable.MaterialCardView_rippleColor);
        this.rippleColor = r13;
        if (r13 != null) goto L8;
        this.rippleColor = ColorStateList.valueOf(MaterialColors.getColor(this.materialCardView, com.google.android.material.R.attr.colorControlHighlight));
    L8:
        setCardForegroundColor(MaterialResources.getColorStateList(this.materialCardView.getContext(), r10, com.google.android.material.R.styleable.MaterialCardView_cardForegroundColor));
        updateRippleColor();
        updateElevation();
        updateStroke();
        this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
        if (this.materialCardView.isClickable() == false) goto L11;
        Drawable r14 = getClickableForeground();
    L12:
        this.fgDrawable = r14;
        this.materialCardView.setForeground(insetDrawable(r14));
        return;
    L11:
        r14 = this.foregroundContentDrawable;
        goto L12
    }

    public void onMeasure(int r10, int r11) {
        if (this.clickableForegroundDrawable == null) goto L13;
        int r12 = this.checkedIconMargin;
        int r13 = this.checkedIconSize;
        int r14 = (r10 - r12) - r13;
        int r15 = (r11 - r12) - r13;
        if (this.materialCardView.getUseCompatPadding() == false) goto L7;
        r15 = r15 - ((int) Math.ceil(calculateVerticalBackgroundPadding() * 2.0f));
        r14 = r14 - ((int) Math.ceil(calculateHorizontalBackgroundPadding() * 2.0f));
    L7:
        int r16 = r15;
        int r17 = this.checkedIconMargin;
        if (ViewCompat.A(this.materialCardView) != 1) goto L10;
        int r18 = r14;
        int r19 = r17;
    L11:
        this.clickableForegroundDrawable.setLayerInset(2, r19, this.checkedIconMargin, r18, r16);
        return;
    L10:
        r19 = r14;
        r18 = r17;
        goto L11
    }

    public void setBackgroundOverwritten(boolean r10) {
        this.isBackgroundOverwritten = r10;
    }

    public void setCardBackgroundColor(ColorStateList r10) {
        this.bgDrawable.setFillColor(r10);
    }

    public void setCardForegroundColor(@Nullable ColorStateList r10) {
        MaterialShapeDrawable r11 = this.foregroundContentDrawable;
        if (r10 != null) goto L5;
        r10 = ColorStateList.valueOf(0);
    L5:
        r11.setFillColor(r10);
    }

    public void setCheckable(boolean r10) {
        this.checkable = r10;
    }

    public void setCheckedIcon(@Nullable Drawable r10) {
        this.checkedIcon = r10;
        if (r10 == null) goto L6;
        Drawable r11 = a.l(r10.mutate());
        this.checkedIcon = r11;
        a.i(r11, this.checkedIconTint);
    L6:
        if (this.clickableForegroundDrawable == null) goto L9;
        Drawable r12 = createCheckedIconLayer();
        this.clickableForegroundDrawable.setDrawableByLayerId(com.google.android.material.R.id.mtrl_card_checked_layer_id, r12);
        return;
    }

    public void setCheckedIconMargin(@Dimension int r10) {
        this.checkedIconMargin = r10;
    }

    public void setCheckedIconSize(@Dimension int r10) {
        this.checkedIconSize = r10;
    }

    public void setCheckedIconTint(@Nullable ColorStateList r10) {
        this.checkedIconTint = r10;
        Drawable r11 = this.checkedIcon;
        if (r11 == null) goto L6;
        a.i(r11, r10);
        return;
    }

    public void setCornerRadius(float r10) {
        setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(r10));
        this.fgDrawable.invalidateSelf();
        if (shouldAddCornerPaddingOutsideCardBackground() == false) goto L5;
    L6:
        updateContentPadding();
    L8:
        if (shouldAddCornerPaddingOutsideCardBackground() == false) goto L11;
        updateInsets();
        return;
    L11:
        return;
    L5:
        if (shouldAddCornerPaddingInsideCardBackground() == false) goto L8;
        goto L6
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float r10) {
        this.bgDrawable.setInterpolation(r10);
        MaterialShapeDrawable r11 = this.foregroundContentDrawable;
        if (r11 == null) goto L5;
        r11.setInterpolation(r10);
    L5:
        MaterialShapeDrawable r12 = this.foregroundShapeDrawable;
        if (r12 == null) goto L9;
        r12.setInterpolation(r10);
        return;
    }

    public void setRippleColor(@Nullable ColorStateList r10) {
        this.rippleColor = r10;
        updateRippleColor();
    }

    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel r10) {
        this.shapeAppearanceModel = r10;
        this.bgDrawable.setShapeAppearanceModel(r10);
        MaterialShapeDrawable r11 = this.bgDrawable;
        r11.setShadowBitmapDrawingEnable(!r11.isRoundRect());
        MaterialShapeDrawable r12 = this.foregroundContentDrawable;
        if (r12 == null) goto L5;
        r12.setShapeAppearanceModel(r10);
    L5:
        MaterialShapeDrawable r13 = this.foregroundShapeDrawable;
        if (r13 == null) goto L8;
        r13.setShapeAppearanceModel(r10);
    L8:
        MaterialShapeDrawable r14 = this.compatRippleDrawable;
        if (r14 == null) goto L12;
        r14.setShapeAppearanceModel(r10);
        return;
    }

    public void setStrokeColor(ColorStateList r10) {
        if (this.strokeColor != r10) goto L5;
        return;
    L5:
        this.strokeColor = r10;
        updateStroke();
    }

    public void setStrokeWidth(@Dimension int r10) {
        if (r10 != this.strokeWidth) goto L5;
        return;
    L5:
        this.strokeWidth = r10;
        updateStroke();
    }

    public void setUserContentPadding(int r10, int r11, int r12, int r13) {
        this.userContentPadding.set(r10, r11, r12, r13);
        updateContentPadding();
    }

    public void updateClickable() {
        Drawable r10 = this.fgDrawable;
        if (this.materialCardView.isClickable() == false) goto L5;
        Drawable r11 = getClickableForeground();
    L6:
        this.fgDrawable = r11;
        if (r10 == r11) goto L10;
        updateInsetForeground(r11);
        return;
    L10:
        return;
    L5:
        r11 = this.foregroundContentDrawable;
        goto L6
    }

    public void updateContentPadding() {
        if (shouldAddCornerPaddingInsideCardBackground() == false) goto L5;
    L8:
        float r10 = calculateActualCornerPadding();
    L9:
        int r11 = (int) (r10 - getParentCardViewCalculatedCornerPadding());
        MaterialCardView r12 = this.materialCardView;
        Rect r13 = this.userContentPadding;
        r12.setAncestorContentPadding(r13.left + r11, r13.top + r11, r13.right + r11, r13.bottom + r11);
        return;
    L5:
        if (shouldAddCornerPaddingOutsideCardBackground() == true) goto L8;
        r10 = 0.0f;
        goto L9
    }

    public void updateElevation() {
        this.bgDrawable.setElevation(this.materialCardView.getCardElevation());
    }

    public void updateInsets() {
        if (isBackgroundOverwritten() == true) goto L5;
        this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
    L5:
        this.materialCardView.setForeground(insetDrawable(this.fgDrawable));
    }

    public void updateStroke() {
        this.foregroundContentDrawable.setStroke(this.strokeWidth, this.strokeColor);
    }
}
