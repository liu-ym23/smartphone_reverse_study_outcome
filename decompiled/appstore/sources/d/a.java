package d;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends Drawable implements Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f18985a;

    public a(Drawable r10) {
        a(r10);
    }

    public void a(Drawable r10) {
        Drawable r11 = this.f18985a;
        if (r11 == null) goto L5;
        r11.setCallback(null);
    L5:
        this.f18985a = r10;
        if (r10 == null) goto L9;
        r10.setCallback(this);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r10) {
        this.f18985a.draw(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.f18985a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f18985a.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f18985a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f18985a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f18985a.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f18985a.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f18985a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect r10) {
        return this.f18985a.getPadding(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f18985a.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f18985a.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r10) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return o.a.c(this.f18985a);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f18985a.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f18985a.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r10) {
        this.f18985a.setBounds(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int r10) {
        return this.f18985a.setLevel(r10);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable r10, Runnable r11, long r12) {
        scheduleSelf(r11, r12);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r10) {
        this.f18985a.setAlpha(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean r10) {
        o.a.d(this.f18985a, r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int r10) {
        this.f18985a.setChangingConfigurations(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r10) {
        this.f18985a.setColorFilter(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean r10) {
        this.f18985a.setDither(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean r10) {
        this.f18985a.setFilterBitmap(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float r10, float r11) {
        o.a.e(this.f18985a, r10, r11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int r10, int r11, int r12, int r13) {
        o.a.f(this.f18985a, r10, r11, r12, r13);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] r10) {
        return this.f18985a.setState(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int r10) {
        o.a.h(this.f18985a, r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList r10) {
        o.a.i(this.f18985a, r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode r10) {
        o.a.j(this.f18985a, r10);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r10, boolean r11) {
        if (super.setVisible(r10, r11) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f18985a.setVisible(r10, r11) == true) goto L8;
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable r10, Runnable r11) {
        unscheduleSelf(r11);
    }
}
