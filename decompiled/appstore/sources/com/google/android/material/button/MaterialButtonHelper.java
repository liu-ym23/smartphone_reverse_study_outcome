package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import o.a;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class MaterialButtonHelper {
    private static final boolean IS_LOLLIPOP = false;
    private boolean backgroundOverwritten;

    @Nullable
    private ColorStateList backgroundTint;

    @Nullable
    private PorterDuff.Mode backgroundTintMode;
    private boolean checkable;
    private int cornerRadius;
    private boolean cornerRadiusSet;
    private int elevation;
    private int insetBottom;
    private int insetLeft;
    private int insetRight;
    private int insetTop;

    @Nullable
    private Drawable maskDrawable;
    private final MaterialButton materialButton;

    @Nullable
    private ColorStateList rippleColor;
    private LayerDrawable rippleDrawable;

    @NonNull
    private ShapeAppearanceModel shapeAppearanceModel;
    private boolean shouldDrawSurfaceColorStroke;

    @Nullable
    private ColorStateList strokeColor;
    private int strokeWidth;

    static {
        IS_LOLLIPOP = true;
    }

    public MaterialButtonHelper(MaterialButton r10, @NonNull ShapeAppearanceModel r11) {
        this.shouldDrawSurfaceColorStroke = false;
        this.backgroundOverwritten = false;
        this.cornerRadiusSet = false;
        this.materialButton = r10;
        this.shapeAppearanceModel = r11;
    }

    private Drawable createBackground() {
        MaterialShapeDrawable r10 = new MaterialShapeDrawable(this.shapeAppearanceModel);
        r10.initializeElevationOverlay(this.materialButton.getContext());
        a.i(r10, this.backgroundTint);
        PorterDuff.Mode r11 = this.backgroundTintMode;
        if (r11 == null) goto L5;
        a.j(r10, r11);
    L5:
        r10.setStroke(this.strokeWidth, this.strokeColor);
        MaterialShapeDrawable r12 = new MaterialShapeDrawable(this.shapeAppearanceModel);
        r12.setTint(0);
        float r13 = this.strokeWidth;
        if (this.shouldDrawSurfaceColorStroke == false) goto L8;
        int r14 = MaterialColors.getColor(this.materialButton, R.attr.colorSurface);
    L9:
        r12.setStroke(r13, r14);
        if (IS_LOLLIPOP == false) goto L13;
        MaterialShapeDrawable r15 = new MaterialShapeDrawable(this.shapeAppearanceModel);
        this.maskDrawable = r15;
        a.h(r15, -1);
        RippleDrawable r16 = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.rippleColor), wrapDrawableWithInset(new LayerDrawable(new Drawable[]{r12, r10})), this.maskDrawable);
        this.rippleDrawable = r16;
        return r16;
    L13:
        RippleDrawableCompat r17 = new RippleDrawableCompat(this.shapeAppearanceModel);
        this.maskDrawable = r17;
        a.i(r17, RippleUtils.sanitizeRippleDrawableColor(this.rippleColor));
        LayerDrawable r18 = new LayerDrawable(new Drawable[]{r12, r10, this.maskDrawable});
        this.rippleDrawable = r18;
        return wrapDrawableWithInset(r18);
    L8:
        r14 = 0;
        goto L9
    }

    @Nullable
    private MaterialShapeDrawable getMaterialShapeDrawable(boolean r10) {
        LayerDrawable r11 = this.rippleDrawable;
        if (r11 != null) goto L5;
        return null;
    L5:
        if (r11.getNumberOfLayers() > 0) goto L7;
        return null;
    L7:
        if (IS_LOLLIPOP == false) goto L11;
        return (MaterialShapeDrawable) ((LayerDrawable) ((InsetDrawable) this.rippleDrawable.getDrawable(0)).getDrawable()).getDrawable(!r10 ? 1 : 0);
    L11:
        return (MaterialShapeDrawable) this.rippleDrawable.getDrawable(!r10 ? 1 : 0);
    }

    @Nullable
    private MaterialShapeDrawable getSurfaceColorStrokeDrawable() {
        return getMaterialShapeDrawable(true);
    }

    private void setVerticalInsets(@Dimension int r10, @Dimension int r11) {
        int r12 = ViewCompat.F(this.materialButton);
        int r13 = this.materialButton.getPaddingTop();
        int r14 = ViewCompat.E(this.materialButton);
        int r15 = this.materialButton.getPaddingBottom();
        int r16 = this.insetTop;
        int r17 = this.insetBottom;
        this.insetBottom = r11;
        this.insetTop = r10;
        if (this.backgroundOverwritten == true) goto L5;
        updateBackground();
    L5:
        ViewCompat.D0(this.materialButton, r12, (r13 + r10) - r16, r14, (r15 + r11) - r17);
    }

    private void updateBackground() {
        this.materialButton.setInternalBackground(createBackground());
        MaterialShapeDrawable r10 = getMaterialShapeDrawable();
        if (r10 == null) goto L6;
        r10.setElevation(this.elevation);
        return;
    }

    private void updateButtonShape(@NonNull ShapeAppearanceModel r10) {
        if (getMaterialShapeDrawable() == null) goto L6;
        getMaterialShapeDrawable().setShapeAppearanceModel(r10);
    L6:
        if (getSurfaceColorStrokeDrawable() == null) goto L9;
        getSurfaceColorStrokeDrawable().setShapeAppearanceModel(r10);
    L9:
        if (getMaskDrawable() == null) goto L12;
        getMaskDrawable().setShapeAppearanceModel(r10);
        return;
    }

    private void updateStroke() {
        MaterialShapeDrawable r10 = getMaterialShapeDrawable();
        MaterialShapeDrawable r11 = getSurfaceColorStrokeDrawable();
        if (r10 == null) goto L12;
        r10.setStroke(this.strokeWidth, this.strokeColor);
        if (r11 == null) goto L13;
        float r12 = this.strokeWidth;
        if (this.shouldDrawSurfaceColorStroke == false) goto L9;
        int r13 = MaterialColors.getColor(this.materialButton, R.attr.colorSurface);
    L10:
        r11.setStroke(r12, r13);
        return;
    L9:
        r13 = 0;
        goto L10
    L13:
        return;
    }

    @NonNull
    private InsetDrawable wrapDrawableWithInset(Drawable r10) {
        return new InsetDrawable(r10, this.insetLeft, this.insetTop, this.insetRight, this.insetBottom);
    }

    public int getCornerRadius() {
        return this.cornerRadius;
    }

    public int getInsetBottom() {
        return this.insetBottom;
    }

    public int getInsetTop() {
        return this.insetTop;
    }

    @Nullable
    public Shapeable getMaskDrawable() {
        LayerDrawable r10 = this.rippleDrawable;
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.getNumberOfLayers() > 1) goto L7;
        return null;
    L7:
        if (this.rippleDrawable.getNumberOfLayers() <= 2) goto L11;
        return (Shapeable) this.rippleDrawable.getDrawable(2);
    L11:
        return (Shapeable) this.rippleDrawable.getDrawable(1);
    }

    @Nullable
    public ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        return this.strokeColor;
    }

    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.backgroundTint;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    public boolean isBackgroundOverwritten() {
        return this.backgroundOverwritten;
    }

    public boolean isCheckable() {
        return this.checkable;
    }

    public void loadFromAttributes(@NonNull TypedArray r10) {
        this.insetLeft = r10.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetLeft, 0);
        this.insetRight = r10.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetRight, 0);
        this.insetTop = r10.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetTop, 0);
        this.insetBottom = r10.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetBottom, 0);
        int r11 = R.styleable.MaterialButton_cornerRadius;
        if (r10.hasValue(r11) == false) goto L5;
        int r12 = r10.getDimensionPixelSize(r11, -1);
        this.cornerRadius = r12;
        setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(r12));
        this.cornerRadiusSet = true;
    L5:
        this.strokeWidth = r10.getDimensionPixelSize(R.styleable.MaterialButton_strokeWidth, 0);
        this.backgroundTintMode = ViewUtils.parseTintMode(r10.getInt(R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.backgroundTint = MaterialResources.getColorStateList(this.materialButton.getContext(), r10, R.styleable.MaterialButton_backgroundTint);
        this.strokeColor = MaterialResources.getColorStateList(this.materialButton.getContext(), r10, R.styleable.MaterialButton_strokeColor);
        this.rippleColor = MaterialResources.getColorStateList(this.materialButton.getContext(), r10, R.styleable.MaterialButton_rippleColor);
        this.checkable = r10.getBoolean(R.styleable.MaterialButton_android_checkable, false);
        this.elevation = r10.getDimensionPixelSize(R.styleable.MaterialButton_elevation, 0);
        int r13 = ViewCompat.F(this.materialButton);
        int r14 = this.materialButton.getPaddingTop();
        int r15 = ViewCompat.E(this.materialButton);
        int r16 = this.materialButton.getPaddingBottom();
        if (r10.hasValue(R.styleable.MaterialButton_android_background) == false) goto L8;
        setBackgroundOverwritten();
    L9:
        ViewCompat.D0(this.materialButton, r13 + this.insetLeft, r14 + this.insetTop, r15 + this.insetRight, r16 + this.insetBottom);
        return;
    L8:
        updateBackground();
        goto L9
    }

    public void setBackgroundColor(int r10) {
        if (getMaterialShapeDrawable() == null) goto L6;
        getMaterialShapeDrawable().setTint(r10);
        return;
    }

    public void setBackgroundOverwritten() {
        this.backgroundOverwritten = true;
        this.materialButton.setSupportBackgroundTintList(this.backgroundTint);
        this.materialButton.setSupportBackgroundTintMode(this.backgroundTintMode);
    }

    public void setCheckable(boolean r10) {
        this.checkable = r10;
    }

    public void setCornerRadius(int r10) {
        if (this.cornerRadiusSet == true) goto L5;
    L6:
        this.cornerRadius = r10;
        this.cornerRadiusSet = true;
        setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(r10));
        return;
    L5:
        if (this.cornerRadius != r10) goto L6;
    }

    public void setInsetBottom(@Dimension int r10) {
        setVerticalInsets(this.insetTop, r10);
    }

    public void setInsetTop(@Dimension int r10) {
        setVerticalInsets(r10, this.insetBottom);
    }

    public void setRippleColor(@Nullable ColorStateList r10) {
        if (this.rippleColor == r10) goto L14;
        this.rippleColor = r10;
        boolean r11 = IS_LOLLIPOP;
        if (r11 == true) goto L7;
    L9:
        if (r11 == false) goto L11;
        return;
    L11:
        if ((this.materialButton.getBackground() instanceof RippleDrawableCompat) == false) goto L17;
        ((RippleDrawableCompat) this.materialButton.getBackground()).setTintList(RippleUtils.sanitizeRippleDrawableColor(r10));
        return;
    L17:
        return;
    L7:
        if ((this.materialButton.getBackground() instanceof RippleDrawable) == false) goto L9;
        ((RippleDrawable) this.materialButton.getBackground()).setColor(RippleUtils.sanitizeRippleDrawableColor(r10));
        return;
    }

    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel r10) {
        this.shapeAppearanceModel = r10;
        updateButtonShape(r10);
    }

    public void setShouldDrawSurfaceColorStroke(boolean r10) {
        this.shouldDrawSurfaceColorStroke = r10;
        updateStroke();
    }

    public void setStrokeColor(@Nullable ColorStateList r10) {
        if (this.strokeColor == r10) goto L6;
        this.strokeColor = r10;
        updateStroke();
        return;
    }

    public void setStrokeWidth(int r10) {
        if (this.strokeWidth == r10) goto L6;
        this.strokeWidth = r10;
        updateStroke();
        return;
    }

    public void setSupportBackgroundTintList(@Nullable ColorStateList r10) {
        if (this.backgroundTint == r10) goto L8;
        this.backgroundTint = r10;
        if (getMaterialShapeDrawable() == null) goto L9;
        a.i(getMaterialShapeDrawable(), this.backgroundTint);
        return;
    L9:
        return;
    }

    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode r10) {
        if (this.backgroundTintMode == r10) goto L10;
        this.backgroundTintMode = r10;
        if (getMaterialShapeDrawable() != null) goto L7;
        return;
    L7:
        if (this.backgroundTintMode == null) goto L12;
        a.j(getMaterialShapeDrawable(), this.backgroundTintMode);
        return;
    L12:
        return;
    }

    public void updateMaskBounds(int r10, int r11) {
        Drawable r12 = this.maskDrawable;
        if (r12 == null) goto L6;
        r12.setBounds(this.insetLeft, this.insetTop, r11 - this.insetRight, r10 - this.insetBottom);
        return;
    }

    @Nullable
    public MaterialShapeDrawable getMaterialShapeDrawable() {
        return getMaterialShapeDrawable(false);
    }
}
