package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.util.e;
import com.google.android.material.R;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
class FloatingActionButtonImplLollipop extends FloatingActionButtonImpl {

    public static class AlwaysStatefulMaterialShapeDrawable extends MaterialShapeDrawable {
        public AlwaysStatefulMaterialShapeDrawable(ShapeAppearanceModel r10) {
            super(r10);
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    public FloatingActionButtonImplLollipop(FloatingActionButton r10, ShadowViewDelegate r11) {
        super(r10, r11);
    }

    @NonNull
    private Animator createElevationAnimator(float r10, float r11) {
        AnimatorSet r12 = new AnimatorSet();
        r12.play(ObjectAnimator.ofFloat(this.view, "elevation", new float[]{r10}).setDuration(0)).with(ObjectAnimator.ofFloat(this.view, View.TRANSLATION_Z, new float[]{r11}).setDuration(100));
        r12.setInterpolator(FloatingActionButtonImpl.ELEVATION_ANIM_INTERPOLATOR);
        return r12;
    }

    @NonNull
    public BorderDrawable createBorderDrawable(int r10, ColorStateList r11) {
        Context r12 = this.view.getContext();
        BorderDrawable r13 = new BorderDrawable((ShapeAppearanceModel) e.g(this.shapeAppearance));
        r13.setGradientColors(ContextCompat.b(r12, R.color.design_fab_stroke_top_outer_color), ContextCompat.b(r12, R.color.design_fab_stroke_top_inner_color), ContextCompat.b(r12, R.color.design_fab_stroke_end_inner_color), ContextCompat.b(r12, R.color.design_fab_stroke_end_outer_color));
        r13.setBorderWidth(r10);
        r13.setBorderTint(r11);
        return r13;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    @NonNull
    public MaterialShapeDrawable createShapeDrawable() {
        return new AlwaysStatefulMaterialShapeDrawable((ShapeAppearanceModel) e.g(this.shapeAppearance));
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public float getElevation() {
        return this.view.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void getPadding(@NonNull Rect r10) {
        if (this.shadowViewDelegate.isCompatPaddingEnabled() == false) goto L6;
        super.getPadding(r10);
        return;
    L6:
        if (shouldExpandBoundsForA11y() == true) goto L8;
        int r11 = (this.minTouchTargetSize - this.view.getSizeDimension()) / 2;
        r10.set(r11, r11, r11, r11);
        return;
    L8:
        r10.set(0, 0, 0, 0);
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void initializeBackgroundDrawable(ColorStateList r10, @Nullable PorterDuff.Mode r11, ColorStateList r12, int r13) {
        MaterialShapeDrawable r14 = createShapeDrawable();
        this.shapeDrawable = r14;
        r14.setTintList(r10);
        if (r11 == null) goto L5;
        this.shapeDrawable.setTintMode(r11);
    L5:
        this.shapeDrawable.initializeElevationOverlay(this.view.getContext());
        if (r13 <= 0) goto L8;
        this.borderDrawable = createBorderDrawable(r13, r10);
        Drawable r15 = new LayerDrawable(new Drawable[]{(Drawable) e.g(this.borderDrawable), (Drawable) e.g(this.shapeDrawable)});
    L9:
        RippleDrawable r16 = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(r12), r15, null);
        this.rippleDrawable = r16;
        this.contentBackground = r16;
        return;
    L8:
        this.borderDrawable = null;
        r15 = this.shapeDrawable;
        goto L9
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void jumpDrawableToCurrentState() {
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void onCompatShadowChanged() {
        updatePadding();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void onDrawableStateChanged(int[] r10) {
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void onElevationsChanged(float r10, float r11, float r12) {
        StateListAnimator r13 = new StateListAnimator();
        r13.addState(FloatingActionButtonImpl.PRESSED_ENABLED_STATE_SET, createElevationAnimator(r10, r12));
        r13.addState(FloatingActionButtonImpl.HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(r10, r11));
        r13.addState(FloatingActionButtonImpl.FOCUSED_ENABLED_STATE_SET, createElevationAnimator(r10, r11));
        r13.addState(FloatingActionButtonImpl.HOVERED_ENABLED_STATE_SET, createElevationAnimator(r10, r11));
        AnimatorSet r14 = new AnimatorSet();
        ArrayList r15 = new ArrayList();
        r15.add(ObjectAnimator.ofFloat(this.view, "elevation", new float[]{r10}).setDuration(0));
        r15.add(ObjectAnimator.ofFloat(this.view, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
        r14.playSequentially((Animator[]) r15.toArray(new Animator[0]));
        r14.setInterpolator(FloatingActionButtonImpl.ELEVATION_ANIM_INTERPOLATOR);
        r13.addState(FloatingActionButtonImpl.ENABLED_STATE_SET, r14);
        r13.addState(FloatingActionButtonImpl.EMPTY_STATE_SET, createElevationAnimator(0.0f, 0.0f));
        this.view.setStateListAnimator(r13);
        if (shouldAddPadding() == false) goto L6;
        updatePadding();
        return;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public boolean requirePreDrawListener() {
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void setRippleColor(@Nullable ColorStateList r10) {
        Drawable r11 = this.rippleDrawable;
        if ((r11 instanceof RippleDrawable) == false) goto L5;
        ((RippleDrawable) r11).setColor(RippleUtils.sanitizeRippleDrawableColor(r10));
        return;
    L5:
        super.setRippleColor(r10);
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public boolean shouldAddPadding() {
        if (this.shadowViewDelegate.isCompatPaddingEnabled() == false) goto L5;
    L8:
        return true;
    L5:
        if (shouldExpandBoundsForA11y() == false) goto L8;
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void updateFromViewRotation() {
    }
}
