package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;

/* JADX INFO: loaded from: classes3.dex */
abstract class VectorDrawableCommon extends Drawable implements TintAwareDrawable {
    Drawable mDelegateDrawable;

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 == null) goto L6;
        r100.clearColorFilter();
        return;
    L6:
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 == null) goto L7;
        return r100.getCurrent();
    L7:
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 == null) goto L7;
        return r100.getMinimumHeight();
    L7:
        return super.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 == null) goto L7;
        return r100.getMinimumWidth();
    L7:
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 == null) goto L7;
        return r100.getState();
    L7:
        return super.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 == null) goto L7;
        return r100.getTransparentRegion();
    L7:
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 == null) goto L6;
        DrawableCompat.jumpToCurrentState(r100);
        return;
    }

    public VectorDrawableCommon() {
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme r100) {
        Drawable r101 = this.mDelegateDrawable;
        if (r101 == null) goto L6;
        DrawableCompat.applyTheme(r101, r100);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect r100) {
        Drawable r101 = this.mDelegateDrawable;
        if (r101 == null) goto L7;
        return r101.getPadding(r100);
    L7:
        return super.getPadding(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r100) {
        Drawable r101 = this.mDelegateDrawable;
        if (r101 == null) goto L6;
        r101.setBounds(r100);
        return;
    L6:
        super.onBoundsChange(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int r100) {
        Drawable r101 = this.mDelegateDrawable;
        if (r101 == null) goto L7;
        return r101.setLevel(r100);
    L7:
        return super.onLevelChange(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int r100) {
        Drawable r101 = this.mDelegateDrawable;
        if (r101 == null) goto L6;
        r101.setChangingConfigurations(r100);
        return;
    L6:
        super.setChangingConfigurations(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean r100) {
        Drawable r101 = this.mDelegateDrawable;
        if (r101 == null) goto L6;
        r101.setFilterBitmap(r100);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] r100) {
        Drawable r101 = this.mDelegateDrawable;
        if (r101 == null) goto L7;
        return r101.setState(r100);
    L7:
        return super.setState(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int r100, PorterDuff.Mode r101) {
        Drawable r102 = this.mDelegateDrawable;
        if (r102 == null) goto L6;
        r102.setColorFilter(r100, r101);
        return;
    L6:
        super.setColorFilter(r100, r101);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float r100, float r101) {
        Drawable r102 = this.mDelegateDrawable;
        if (r102 == null) goto L6;
        DrawableCompat.setHotspot(r102, r100, r101);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int r100, int r101, int r102, int r103) {
        Drawable r104 = this.mDelegateDrawable;
        if (r104 == null) goto L6;
        DrawableCompat.setHotspotBounds(r104, r100, r101, r102, r103);
        return;
    }
}
