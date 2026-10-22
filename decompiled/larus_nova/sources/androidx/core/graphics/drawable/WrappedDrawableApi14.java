package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes17.dex */
class WrappedDrawableApi14 extends Drawable implements Drawable.Callback, WrappedDrawable, TintAwareDrawable {
    static final PorterDuff.Mode DEFAULT_TINT_MODE = null;
    private boolean mColorFilterSet;
    private int mCurrentColor;
    private PorterDuff.Mode mCurrentMode;
    Drawable mDrawable;
    private boolean mMutated;
    WrappedDrawableState mState;

    public boolean isCompatTintEnabled() {
        return true;
    }

    static {
        DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    }

    private WrappedDrawableState mutateConstantState() {
        return new WrappedDrawableState(this.mState);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        WrappedDrawableState r100 = this.mState;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.canConstantState() == false) goto L10;
        WrappedDrawableState r101 = this.mState;
        r101.mChangingConfigurations = getChangingConfigurations();
        return this.mState;
    L10:
        return null;
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
    public int getLayoutDirection() {
        return DrawableCompat.getLayoutDirection(this.mDrawable);
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
    public void jumpToCurrentState() {
        this.mDrawable.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.mMutated == false) goto L5;
    L17:
        return this;
    L5:
        if (super.mutate() != this) goto L17;
        this.mState = mutateConstantState();
        Drawable r100 = this.mDrawable;
        if (r100 == null) goto L9;
        r100.mutate();
    L9:
        WrappedDrawableState r101 = this.mState;
        if (r101 == null) goto L16;
        Drawable r102 = this.mDrawable;
        if (r102 == null) goto L14;
        Drawable.ConstantState r103 = r102.getConstantState();
    L15:
        r101.mDrawableState = r103;
        goto L16
    L14:
        r103 = null;
    L16:
        this.mMutated = true;
        goto L17
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int r100 = super.getChangingConfigurations();
        WrappedDrawableState r101 = this.mState;
        if (r101 == null) goto L5;
        int r102 = r101.getChangingConfigurations();
    L7:
        return (r100 | r102) | this.mDrawable.getChangingConfigurations();
    L5:
        r102 = 0;
        goto L7
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (isCompatTintEnabled() == false) goto L7;
        WrappedDrawableState r100 = this.mState;
        if (r100 == null) goto L7;
        ColorStateList r101 = r100.mTint;
    L8:
        if (r101 == null) goto L12;
        if (r101.isStateful() == false) goto L12;
    L13:
        return true;
    L12:
        if (this.mDrawable.isStateful() == true) goto L13;
        return false;
    L7:
        r101 = null;
        goto L8
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawable
    public final Drawable getWrappedDrawable() {
        return this.mDrawable;
    }

    public WrappedDrawableApi14(Drawable r100) {
        this.mState = mutateConstantState();
        setWrappedDrawable(r100);
    }

    private void updateLocalState(Resources r100) {
        WrappedDrawableState r101 = this.mState;
        if (r101 == null) goto L8;
        Drawable.ConstantState r102 = r101.mDrawableState;
        if (r102 == null) goto L9;
        setWrappedDrawable(r102.newDrawable(r100));
        return;
    L9:
        return;
    }

    private boolean updateTint(int[] r100) {
        if (isCompatTintEnabled() == true) goto L5;
        return false;
    L5:
        WrappedDrawableState r101 = this.mState;
        ColorStateList r102 = r101.mTint;
        PorterDuff.Mode r103 = r101.mTintMode;
        if (r102 == null) goto L16;
        if (r103 == null) goto L16;
        int r104 = r102.getColorForState(r100, r102.getDefaultColor());
        if (this.mColorFilterSet == true) goto L11;
    L14:
        setColorFilter(r104, r103);
        this.mCurrentColor = r104;
        this.mCurrentMode = r103;
        this.mColorFilterSet = true;
        return true;
    L11:
        if (r104 != this.mCurrentColor) goto L14;
        if (r103 != this.mCurrentMode) goto L14;
    L17:
        return false;
    L16:
        this.mColorFilterSet = false;
        clearColorFilter();
        goto L17
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
        Drawable r101 = this.mDrawable;
        if (r101 == null) goto L6;
        r101.setBounds(r100);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int r100) {
        return DrawableCompat.setLayoutDirection(this.mDrawable, r100);
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
        boolean r101 = this.mDrawable.setState(r100);
        if (updateTint(r100) == true) goto L7;
        if (r101 == true) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int r100) {
        setTintList(ColorStateList.valueOf(r100));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList r100) {
        this.mState.mTint = r100;
        updateTint(getState());
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode r100) {
        this.mState.mTintMode = r100;
        updateTint(getState());
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawable
    public final void setWrappedDrawable(Drawable r100) {
        Drawable r101 = this.mDrawable;
        if (r101 == null) goto L5;
        r101.setCallback(null);
    L5:
        this.mDrawable = r100;
        if (r100 == null) goto L10;
        r100.setCallback(this);
        setVisible(r100.isVisible(), true);
        setState(r100.getState());
        setLevel(r100.getLevel());
        setBounds(r100.getBounds());
        WrappedDrawableState r102 = this.mState;
        if (r102 == null) goto L10;
        r102.mDrawableState = r100.getConstantState();
    L10:
        invalidateSelf();
    }

    public WrappedDrawableApi14(WrappedDrawableState r100, Resources r101) {
        this.mState = r100;
        updateLocalState(r101);
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
}
