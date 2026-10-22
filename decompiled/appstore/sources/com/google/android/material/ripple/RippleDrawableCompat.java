package com.google.android.material.ripple;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.TintAwareDrawable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RippleDrawableCompat extends Drawable implements Shapeable, TintAwareDrawable {
    private RippleDrawableCompatState drawableState;

    /* JADX INFO: renamed from: com.google.android.material.ripple.RippleDrawableCompat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class RippleDrawableCompatState extends Drawable.ConstantState {

        @NonNull
        MaterialShapeDrawable delegate;
        boolean shouldDrawDelegate;

        public RippleDrawableCompatState(MaterialShapeDrawable r10) {
            this.delegate = r10;
            this.shouldDrawDelegate = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public /* bridge */ /* synthetic */ Drawable newDrawable() {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public RippleDrawableCompat newDrawable() {
            return new RippleDrawableCompat(new RippleDrawableCompatState(this), null);
        }

        public RippleDrawableCompatState(@NonNull RippleDrawableCompatState r10) {
            this.delegate = (MaterialShapeDrawable) r10.delegate.getConstantState().newDrawable();
            this.shouldDrawDelegate = r10.shouldDrawDelegate;
        }
    }

    public /* synthetic */ RippleDrawableCompat(RippleDrawableCompatState r10, AnonymousClass1 r11) {
        this(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r10) {
        RippleDrawableCompatState r11 = this.drawableState;
        if (r11.shouldDrawDelegate == false) goto L6;
        r11.delegate.draw(r10);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.drawableState;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.drawableState.delegate.getOpacity();
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.drawableState.delegate.getShapeAppearanceModel();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public /* bridge */ /* synthetic */ Drawable mutate() {
        return mutate();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@NonNull Rect r10) {
        super.onBoundsChange(r10);
        this.drawableState.delegate.setBounds(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(@NonNull int[] r10) {
        boolean r11 = super.onStateChange(r10);
        if (this.drawableState.delegate.setState(r10) == false) goto L5;
        r11 = true;
    L5:
        boolean r12 = RippleUtils.shouldDrawRippleCompat(r10);
        RippleDrawableCompatState r13 = this.drawableState;
        if (r13.shouldDrawDelegate == r12) goto L9;
        r13.shouldDrawDelegate = r12;
        return true;
    L9:
        return r11;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r10) {
        this.drawableState.delegate.setAlpha(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter r10) {
        this.drawableState.delegate.setColorFilter(r10);
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel r10) {
        this.drawableState.delegate.setShapeAppearanceModel(r10);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(@ColorInt int r10) {
        this.drawableState.delegate.setTint(r10);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList r10) {
        this.drawableState.delegate.setTintList(r10);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@Nullable PorterDuff.Mode r10) {
        this.drawableState.delegate.setTintMode(r10);
    }

    public RippleDrawableCompat(ShapeAppearanceModel r10) {
        this(new RippleDrawableCompatState(new MaterialShapeDrawable(r10)));
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public RippleDrawableCompat mutate() {
        this.drawableState = new RippleDrawableCompatState(this.drawableState);
        return this;
    }

    private RippleDrawableCompat(RippleDrawableCompatState r10) {
        this.drawableState = r10;
    }
}
