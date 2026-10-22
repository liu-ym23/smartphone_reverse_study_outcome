package com.google.android.material.card;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.CutCornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: loaded from: classes2.dex */
class MaterialCardViewHelper {
    private static final float CARD_VIEW_SHADOW_MULTIPLIER = 1.5f;
    private static final int CHECKED_ICON_LAYER_INDEX = 2;
    private static final Drawable CHECKED_ICON_NONE = null;
    private static final double COS_45 = 0.0d;
    public static final int DEFAULT_FADE_ANIM_DURATION = 300;
    private static final int DEFAULT_STROKE_VALUE = -1;
    private final MaterialShapeDrawable bgDrawable;
    private boolean checkable;
    private float checkedAnimationProgress;
    private Drawable checkedIcon;
    private int checkedIconGravity;
    private int checkedIconMargin;
    private int checkedIconSize;
    private ColorStateList checkedIconTint;
    private LayerDrawable clickableForegroundDrawable;
    private MaterialShapeDrawable compatRippleDrawable;
    private Drawable fgDrawable;
    private final MaterialShapeDrawable foregroundContentDrawable;
    private MaterialShapeDrawable foregroundShapeDrawable;
    private ValueAnimator iconAnimator;
    private final TimeInterpolator iconFadeAnimInterpolator;
    private final int iconFadeInAnimDuration;
    private final int iconFadeOutAnimDuration;
    private boolean isBackgroundOverwritten;
    private final MaterialCardView materialCardView;
    private ColorStateList rippleColor;
    private Drawable rippleDrawable;
    private ShapeAppearanceModel shapeAppearanceModel;
    private ColorStateList strokeColor;
    private int strokeWidth;
    private final Rect userContentPadding;

    static {
        COS_45 = Math.cos(Math.toRadians(45.0d));
        CHECKED_ICON_NONE = null;
    }

    public MaterialCardViewHelper(MaterialCardView r5, AttributeSet r6, int r7, int r8) {
        this.userContentPadding = new Rect();
        this.isBackgroundOverwritten = false;
        this.checkedAnimationProgress = 0.0f;
        this.materialCardView = r5;
        MaterialShapeDrawable r1 = new MaterialShapeDrawable(r5.getContext(), r6, r7, r8);
        this.bgDrawable = r1;
        r1.initializeElevationOverlay(r5.getContext());
        r1.setShadowColor(-12303292);
        ShapeAppearanceModel.Builder r9 = r1.getShapeAppearanceModel().toBuilder();
        TypedArray r10 = r5.getContext().obtainStyledAttributes(r6, R.styleable.CardView, r7, R.style.CardView);
        if (r10.hasValue(R.styleable.CardView_cardCornerRadius) == false) goto L5;
        r9.setAllCornerSizes(r10.getDimension(R.styleable.CardView_cardCornerRadius, 0.0f));
    L5:
        this.foregroundContentDrawable = new MaterialShapeDrawable();
        setShapeAppearanceModel(r9.build());
        this.iconFadeAnimInterpolator = MotionUtils.resolveThemeInterpolator(r5.getContext(), R.attr.motionEasingLinearInterpolator, AnimationUtils.LINEAR_INTERPOLATOR);
        this.iconFadeInAnimDuration = MotionUtils.resolveThemeDuration(r5.getContext(), R.attr.motionDurationShort2, 300);
        this.iconFadeOutAnimDuration = MotionUtils.resolveThemeDuration(r5.getContext(), R.attr.motionDurationShort1, 300);
        r10.recycle();
    }

    void loadFromAttributes(TypedArray r4) {
        ColorStateList r0 = MaterialResources.getColorStateList(this.materialCardView.getContext(), r4, R.styleable.MaterialCardView_strokeColor);
        this.strokeColor = r0;
        if (r0 != null) goto L5;
        this.strokeColor = ColorStateList.valueOf(-1);
    L5:
        this.strokeWidth = r4.getDimensionPixelSize(R.styleable.MaterialCardView_strokeWidth, 0);
        boolean r1 = r4.getBoolean(R.styleable.MaterialCardView_android_checkable, false);
        this.checkable = r1;
        this.materialCardView.setLongClickable(r1);
        this.checkedIconTint = MaterialResources.getColorStateList(this.materialCardView.getContext(), r4, R.styleable.MaterialCardView_checkedIconTint);
        setCheckedIcon(MaterialResources.getDrawable(this.materialCardView.getContext(), r4, R.styleable.MaterialCardView_checkedIcon));
        setCheckedIconSize(r4.getDimensionPixelSize(R.styleable.MaterialCardView_checkedIconSize, 0));
        setCheckedIconMargin(r4.getDimensionPixelSize(R.styleable.MaterialCardView_checkedIconMargin, 0));
        this.checkedIconGravity = r4.getInteger(R.styleable.MaterialCardView_checkedIconGravity, 8388661);
        ColorStateList r2 = MaterialResources.getColorStateList(this.materialCardView.getContext(), r4, R.styleable.MaterialCardView_rippleColor);
        this.rippleColor = r2;
        if (r2 != null) goto L8;
        this.rippleColor = ColorStateList.valueOf(MaterialColors.getColor(this.materialCardView, R.attr.colorControlHighlight));
    L8:
        setCardForegroundColor(MaterialResources.getColorStateList(this.materialCardView.getContext(), r4, R.styleable.MaterialCardView_cardForegroundColor));
        updateRippleColor();
        updateElevation();
        updateStroke();
        this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
        if (this.materialCardView.isClickable() == false) goto L11;
        Drawable r5 = getClickableForeground();
    L12:
        this.fgDrawable = r5;
        this.materialCardView.setForeground(insetDrawable(r5));
        return;
    L11:
        r5 = this.foregroundContentDrawable;
        goto L12
    }

    boolean isBackgroundOverwritten() {
        return this.isBackgroundOverwritten;
    }

    void setBackgroundOverwritten(boolean r1) {
        this.isBackgroundOverwritten = r1;
    }

    void setStrokeColor(ColorStateList r2) {
        if (this.strokeColor != r2) goto L5;
        return;
    L5:
        this.strokeColor = r2;
        updateStroke();
    }

    int getStrokeColor() {
        ColorStateList r0 = this.strokeColor;
        if (r0 != null) goto L6;
        return -1;
    L6:
        return r0.getDefaultColor();
    }

    ColorStateList getStrokeColorStateList() {
        return this.strokeColor;
    }

    void setStrokeWidth(int r2) {
        if (r2 != this.strokeWidth) goto L5;
        return;
    L5:
        this.strokeWidth = r2;
        updateStroke();
    }

    int getStrokeWidth() {
        return this.strokeWidth;
    }

    MaterialShapeDrawable getBackground() {
        return this.bgDrawable;
    }

    void setCardBackgroundColor(ColorStateList r1) {
        this.bgDrawable.setFillColor(r1);
    }

    ColorStateList getCardBackgroundColor() {
        return this.bgDrawable.getFillColor();
    }

    void setCardForegroundColor(ColorStateList r1) {
        MaterialShapeDrawable r0 = this.foregroundContentDrawable;
        if (r1 != null) goto L5;
        r1 = ColorStateList.valueOf(0);
    L5:
        r0.setFillColor(r1);
    }

    ColorStateList getCardForegroundColor() {
        return this.foregroundContentDrawable.getFillColor();
    }

    void setUserContentPadding(int r2, int r3, int r4, int r5) {
        this.userContentPadding.set(r2, r3, r4, r5);
        updateContentPadding();
    }

    Rect getUserContentPadding() {
        return this.userContentPadding;
    }

    void updateClickable() {
        Drawable r0 = this.fgDrawable;
        if (this.materialCardView.isClickable() == false) goto L5;
        Drawable r1 = getClickableForeground();
    L6:
        this.fgDrawable = r1;
        if (r0 == r1) goto L10;
        updateInsetForeground(r1);
        return;
    L10:
        return;
    L5:
        r1 = this.foregroundContentDrawable;
        goto L6
    }

    public void animateCheckedIcon(boolean r6) {
        if (r6 == false) goto L5;
        float r1 = 1.0f;
    L6:
        if (r6 == false) goto L8;
        float r0 = 1.0f - this.checkedAnimationProgress;
    L9:
        ValueAnimator r2 = this.iconAnimator;
        if (r2 == null) goto L12;
        r2.cancel();
        this.iconAnimator = null;
    L12:
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{this.checkedAnimationProgress, r1});
        this.iconAnimator = r3;
        r3.addUpdateListener(new MaterialCardViewHelper$$ExternalSyntheticLambda0(this));
        this.iconAnimator.setInterpolator(this.iconFadeAnimInterpolator);
        ValueAnimator r4 = this.iconAnimator;
        if (r6 == false) goto L15;
        int r7 = this.iconFadeInAnimDuration;
    L16:
        r4.setDuration((long) (r7 * r0));
        this.iconAnimator.start();
        return;
    L15:
        r7 = this.iconFadeOutAnimDuration;
        goto L16
    L8:
        r0 = this.checkedAnimationProgress;
        goto L9
    L5:
        r1 = 0.0f;
        goto L6
    }

    /* JADX INFO: renamed from: lambda$animateCheckedIcon$0$com-google-android-material-card-MaterialCardViewHelper, reason: not valid java name */
    /* synthetic */ void m243xa4d79c2b(ValueAnimator r3) {
        float r4 = ((Float) r3.getAnimatedValue()).floatValue();
        Drawable r1 = this.checkedIcon;
        r1.setAlpha((int) (255.0f * r4));
        this.checkedAnimationProgress = r4;
    }

    void setCornerRadius(float r2) {
        setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(r2));
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

    float getCornerRadius() {
        return this.bgDrawable.getTopLeftCornerResolvedSize();
    }

    void setProgress(float r2) {
        this.bgDrawable.setInterpolation(r2);
        MaterialShapeDrawable r0 = this.foregroundContentDrawable;
        if (r0 == null) goto L5;
        r0.setInterpolation(r2);
    L5:
        MaterialShapeDrawable r1 = this.foregroundShapeDrawable;
        if (r1 == null) goto L9;
        r1.setInterpolation(r2);
        return;
    }

    float getProgress() {
        return this.bgDrawable.getInterpolation();
    }

    void updateElevation() {
        this.bgDrawable.setElevation(this.materialCardView.getCardElevation());
    }

    void updateInsets() {
        if (isBackgroundOverwritten() == true) goto L5;
        this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
    L5:
        this.materialCardView.setForeground(insetDrawable(this.fgDrawable));
    }

    void updateStroke() {
        this.foregroundContentDrawable.setStroke(this.strokeWidth, this.strokeColor);
    }

    void updateContentPadding() {
        if (shouldAddCornerPaddingInsideCardBackground() == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        float r1 = calculateActualCornerPadding();
    L12:
        int r2 = (int) (r1 - getParentCardViewCalculatedCornerPadding());
        this.materialCardView.setAncestorContentPadding(this.userContentPadding.left + r2, this.userContentPadding.top + r2, this.userContentPadding.right + r2, this.userContentPadding.bottom + r2);
        return;
    L11:
        r1 = 0.0f;
        goto L12
    L5:
        if (shouldAddCornerPaddingOutsideCardBackground() == true) goto L8;
        r0 = false;
        goto L9
    }

    void setCheckable(boolean r1) {
        this.checkable = r1;
    }

    boolean isCheckable() {
        return this.checkable;
    }

    void setRippleColor(ColorStateList r1) {
        this.rippleColor = r1;
        updateRippleColor();
    }

    void setCheckedIconTint(ColorStateList r1) {
        this.checkedIconTint = r1;
        Drawable r0 = this.checkedIcon;
        if (r0 == null) goto L6;
        DrawableCompat.setTintList(r0, r1);
        return;
    }

    ColorStateList getCheckedIconTint() {
        return this.checkedIconTint;
    }

    ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    Drawable getCheckedIcon() {
        return this.checkedIcon;
    }

    void setCheckedIcon(Drawable r2) {
        if (r2 == null) goto L4;
        Drawable r3 = DrawableCompat.wrap(r2).mutate();
        this.checkedIcon = r3;
        DrawableCompat.setTintList(r3, this.checkedIconTint);
        setChecked(this.materialCardView.isChecked());
    L5:
        LayerDrawable r4 = this.clickableForegroundDrawable;
        if (r4 == null) goto L9;
        r4.setDrawableByLayerId(R.id.mtrl_card_checked_layer_id, this.checkedIcon);
        return;
    L9:
        return;
    L4:
        this.checkedIcon = CHECKED_ICON_NONE;
        goto L5
    }

    int getCheckedIconSize() {
        return this.checkedIconSize;
    }

    void setCheckedIconSize(int r1) {
        this.checkedIconSize = r1;
    }

    int getCheckedIconMargin() {
        return this.checkedIconMargin;
    }

    void setCheckedIconMargin(int r1) {
        this.checkedIconMargin = r1;
    }

    void recalculateCheckedIconPosition(int r11, int r12) {
        if (this.clickableForegroundDrawable != null) goto L5;
        return;
    L5:
        if (this.materialCardView.getUseCompatPadding() == false) goto L7;
        int r0 = (int) Math.ceil(calculateVerticalBackgroundPadding() * 2.0f);
        int r1 = (int) Math.ceil(calculateHorizontalBackgroundPadding() * 2.0f);
    L9:
        if (isCheckedIconEnd() == false) goto L11;
        int r2 = ((r11 - this.checkedIconMargin) - this.checkedIconSize) - r1;
    L13:
        if (isCheckedIconBottom() == false) goto L15;
        int r3 = this.checkedIconMargin;
    L16:
        int r9 = r3;
        if (isCheckedIconEnd() == false) goto L19;
        int r13 = this.checkedIconMargin;
    L21:
        if (isCheckedIconBottom() == false) goto L23;
        int r14 = ((r12 - this.checkedIconMargin) - this.checkedIconSize) - r0;
    L24:
        int r7 = r14;
        if (ViewCompat.getLayoutDirection(this.materialCardView) != 1) goto L27;
        int r6 = r13;
        int r8 = r2;
    L28:
        this.clickableForegroundDrawable.setLayerInset(2, r6, r7, r8, r9);
        return;
    L27:
        r8 = r13;
        r6 = r2;
        goto L28
    L23:
        r14 = this.checkedIconMargin;
        goto L24
    L19:
        r13 = ((r11 - this.checkedIconMargin) - this.checkedIconSize) - r1;
        goto L21
    L15:
        r3 = ((r12 - this.checkedIconMargin) - this.checkedIconSize) - r0;
        goto L16
    L11:
        r2 = this.checkedIconMargin;
        goto L13
    L7:
        r0 = 0;
        r1 = 0;
        goto L9
    }

    void forceRippleRedraw() {
        Drawable r0 = this.rippleDrawable;
        if (r0 == null) goto L6;
        Rect r1 = r0.getBounds();
        int r2 = r1.bottom;
        this.rippleDrawable.setBounds(r1.left, r1.top, r1.right, r2 - 1);
        this.rippleDrawable.setBounds(r1.left, r1.top, r1.right, r2);
        return;
    }

    void setShapeAppearanceModel(ShapeAppearanceModel r3) {
        this.shapeAppearanceModel = r3;
        this.bgDrawable.setShapeAppearanceModel(r3);
        MaterialShapeDrawable r0 = this.bgDrawable;
        r0.setShadowBitmapDrawingEnable(!r0.isRoundRect());
        MaterialShapeDrawable r1 = this.foregroundContentDrawable;
        if (r1 == null) goto L5;
        r1.setShapeAppearanceModel(r3);
    L5:
        MaterialShapeDrawable r2 = this.foregroundShapeDrawable;
        if (r2 == null) goto L8;
        r2.setShapeAppearanceModel(r3);
    L8:
        MaterialShapeDrawable r4 = this.compatRippleDrawable;
        if (r4 == null) goto L12;
        r4.setShapeAppearanceModel(r3);
        return;
    }

    ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    private void updateInsetForeground(Drawable r2) {
        if ((this.materialCardView.getForeground() instanceof InsetDrawable) == false) goto L5;
        ((InsetDrawable) this.materialCardView.getForeground()).setDrawable(r2);
        return;
    L5:
        this.materialCardView.setForeground(insetDrawable(r2));
    }

    private Drawable insetDrawable(final Drawable r9) {
        if (this.materialCardView.getUseCompatPadding() == false) goto L5;
        final int r7 = (int) Math.ceil(calculateVerticalBackgroundPadding());
        final int r6 = (int) Math.ceil(calculateHorizontalBackgroundPadding());
    L6:
        final int r4 = r6;
        final int r5 = r7;
        return new AnonymousClass1(this, r9, r4, r5, r6, r7);
    L5:
        r6 = 0;
        r7 = 0;
        goto L6
    }

    private float calculateVerticalBackgroundPadding() {
        float r0 = this.materialCardView.getMaxCardElevation() * CARD_VIEW_SHADOW_MULTIPLIER;
        if (shouldAddCornerPaddingOutsideCardBackground() == false) goto L5;
        float r2 = calculateActualCornerPadding();
    L7:
        return r0 + r2;
    L5:
        r2 = 0.0f;
        goto L7
    }

    private float calculateHorizontalBackgroundPadding() {
        float r0 = this.materialCardView.getMaxCardElevation();
        if (shouldAddCornerPaddingOutsideCardBackground() == false) goto L5;
        float r2 = calculateActualCornerPadding();
    L7:
        return r0 + r2;
    L5:
        r2 = 0.0f;
        goto L7
    }

    private boolean canClipToOutline() {
        if (this.bgDrawable.isRoundRect() == false) goto L5;
        return true;
    L5:
        return false;
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

    private float calculateActualCornerPadding() {
        return Math.max(Math.max(calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getTopLeftCorner(), this.bgDrawable.getTopLeftCornerResolvedSize()), calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getTopRightCorner(), this.bgDrawable.getTopRightCornerResolvedSize())), Math.max(calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getBottomRightCorner(), this.bgDrawable.getBottomRightCornerResolvedSize()), calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getBottomLeftCorner(), this.bgDrawable.getBottomLeftCornerResolvedSize())));
    }

    private float calculateCornerPaddingForCornerTreatment(CornerTreatment r3, float r4) {
        if ((r3 instanceof RoundedCornerTreatment) == false) goto L7;
        return (float) ((1.0d - COS_45) * ((double) r4));
    L7:
        if ((r3 instanceof CutCornerTreatment) == true) goto L9;
        return 0.0f;
    L9:
        return r4 / 2.0f;
    }

    private Drawable getClickableForeground() {
        if (this.rippleDrawable != null) goto L6;
        this.rippleDrawable = createForegroundRippleDrawable();
    L6:
        if (this.clickableForegroundDrawable != null) goto L9;
        LayerDrawable r0 = new LayerDrawable(new Drawable[]{this.rippleDrawable, this.foregroundContentDrawable, this.checkedIcon});
        this.clickableForegroundDrawable = r0;
        r0.setId(2, R.id.mtrl_card_checked_layer_id);
    L9:
        return this.clickableForegroundDrawable;
    }

    private Drawable createForegroundRippleDrawable() {
        if (RippleUtils.USE_FRAMEWORK_RIPPLE == false) goto L7;
        this.foregroundShapeDrawable = createForegroundShapeDrawable();
        return new RippleDrawable(this.rippleColor, null, this.foregroundShapeDrawable);
    L7:
        return createCompatRippleDrawable();
    }

    private Drawable createCompatRippleDrawable() {
        StateListDrawable r0 = new StateListDrawable();
        MaterialShapeDrawable r1 = createForegroundShapeDrawable();
        this.compatRippleDrawable = r1;
        r1.setFillColor(this.rippleColor);
        r0.addState(new int[]{android.R.attr.state_pressed}, this.compatRippleDrawable);
        return r0;
    }

    private void updateRippleColor() {
        if (RippleUtils.USE_FRAMEWORK_RIPPLE == false) goto L7;
        Drawable r0 = this.rippleDrawable;
        if (r0 == null) goto L7;
        ((RippleDrawable) r0).setColor(this.rippleColor);
        return;
    L7:
        MaterialShapeDrawable r1 = this.compatRippleDrawable;
        if (r1 == null) goto L12;
        r1.setFillColor(this.rippleColor);
        return;
    }

    private MaterialShapeDrawable createForegroundShapeDrawable() {
        return new MaterialShapeDrawable(this.shapeAppearanceModel);
    }

    public void setChecked(boolean r2) {
        setChecked(r2, false);
    }

    public void setChecked(boolean r2, boolean r3) {
        Drawable r0 = this.checkedIcon;
        if (r0 == null) goto L15;
        if (r3 == false) goto L6;
        animateCheckedIcon(r2);
        return;
    L6:
        if (r2 == false) goto L8;
        int r4 = 255;
    L9:
        r0.setAlpha(r4);
        if (r2 == false) goto L12;
        float r5 = 1.0f;
    L13:
        this.checkedAnimationProgress = r5;
        return;
    L12:
        r5 = 0.0f;
        goto L13
    L8:
        r4 = 0;
        goto L9
    }

    int getCheckedIconGravity() {
        return this.checkedIconGravity;
    }

    void setCheckedIconGravity(int r2) {
        this.checkedIconGravity = r2;
        recalculateCheckedIconPosition(this.materialCardView.getMeasuredWidth(), this.materialCardView.getMeasuredHeight());
    }

    private boolean isCheckedIconEnd() {
        if ((this.checkedIconGravity & GravityCompat.END) != 8388613) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isCheckedIconBottom() {
        if ((this.checkedIconGravity & 80) != 80) goto L5;
        return true;
    L5:
        return false;
    }
}
