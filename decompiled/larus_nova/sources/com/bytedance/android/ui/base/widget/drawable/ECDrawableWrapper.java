package com.bytedance.android.ui.base.widget.drawable;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;

/* JADX INFO: loaded from: classes14.dex */
public class ECDrawableWrapper extends Drawable implements Drawable.Callback {
    private Drawable mDrawable;

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.mDrawable.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.mDrawable.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mDrawable.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mDrawable.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.mDrawable.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.mDrawable.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.mDrawable.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.mDrawable.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.mDrawable.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return DrawableCompat.isAutoMirrored(this.mDrawable);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.mDrawable.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        DrawableCompat.jumpToCurrentState(this.mDrawable);
    }

    public Drawable getWrappedDrawable() {
        return this.mDrawable;
    }

    public ECDrawableWrapper(Drawable r100) {
        setWrappedDrawable(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        this.mDrawable.draw(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect r100) {
        return this.mDrawable.getPadding(r100);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r100) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r100) {
        this.mDrawable.setBounds(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int r100) {
        return this.mDrawable.setLevel(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r100) {
        this.mDrawable.setAlpha(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean r100) {
        DrawableCompat.setAutoMirrored(this.mDrawable, r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int r100) {
        this.mDrawable.setChangingConfigurations(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r100) {
        this.mDrawable.setColorFilter(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean r100) {
        this.mDrawable.setDither(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean r100) {
        this.mDrawable.setFilterBitmap(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] r100) {
        return this.mDrawable.setState(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int r100) {
        DrawableCompat.setTint(this.mDrawable, r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList r100) {
        DrawableCompat.setTintList(this.mDrawable, r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode r100) {
        DrawableCompat.setTintMode(this.mDrawable, r100);
    }

    public void setWrappedDrawable(Drawable r100) {
        Drawable r101 = this.mDrawable;
        if (r101 == null) goto L5;
        r101.setCallback(null);
    L5:
        this.mDrawable = r100;
        if (r100 == null) goto L9;
        r100.setCallback(this);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float r100, float r101) {
        DrawableCompat.setHotspot(this.mDrawable, r100, r101);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r100, boolean r101) {
        if (super.setVisible(r100, r101) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mDrawable.setVisible(r100, r101) == true) goto L8;
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable r100, Runnable r101) {
        unscheduleSelf(r101);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
        scheduleSelf(r101, r102);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int r100, int r101, int r102, int r103) {
        DrawableCompat.setHotspotBounds(this.mDrawable, r100, r101, r102, r103);
    }
}
