package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes17.dex */
class WrappedDrawableApi21 extends WrappedDrawableApi14 {
    private static final String TAG = "WrappedDrawableApi21";
    private static Method sIsProjectedDrawableMethod;

    private void findAndCacheIsProjectedDrawableMethod() {
        if (sIsProjectedDrawableMethod != null) goto L9;
        sIsProjectedDrawableMethod = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        return this.mDrawable.getDirtyBounds();
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14
    public boolean isCompatTintEnabled() {
        if (Build.VERSION.SDK_INT != 21) goto L14;
        Drawable r100 = this.mDrawable;
        if ((r100 instanceof GradientDrawable) == false) goto L7;
    L12:
        return true;
    L7:
        if ((r100 instanceof DrawableContainer) == true) goto L12;
        if ((r100 instanceof InsetDrawable) == true) goto L12;
        if ((r100 instanceof RippleDrawable) == true) goto L12;
        return false;
    L14:
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Drawable r100 = this.mDrawable;
        if (r100 == null) goto L8;
        Method r101 = sIsProjectedDrawableMethod;
        if (r101 == null) goto L8;
        return ((Boolean) r101.invoke(r100, new Object[0])).booleanValue();
    L8:
        return false;
    }

    public WrappedDrawableApi21(Drawable r100) {
        super(r100);
        findAndCacheIsProjectedDrawableMethod();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline r100) {
        this.mDrawable.getOutline(r100);
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14, android.graphics.drawable.Drawable
    public boolean setState(int[] r100) {
        if (super.setState(r100) == false) goto L6;
        invalidateSelf();
        return true;
    L6:
        return false;
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int r100) {
        if (isCompatTintEnabled() == false) goto L5;
        super.setTint(r100);
        return;
    L5:
        this.mDrawable.setTint(r100);
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList r100) {
        if (isCompatTintEnabled() == false) goto L5;
        super.setTintList(r100);
        return;
    L5:
        this.mDrawable.setTintList(r100);
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode r100) {
        if (isCompatTintEnabled() == false) goto L5;
        super.setTintMode(r100);
        return;
    L5:
        this.mDrawable.setTintMode(r100);
    }

    public WrappedDrawableApi21(WrappedDrawableState r100, Resources r101) {
        super(r100, r101);
        findAndCacheIsProjectedDrawableMethod();
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float r100, float r101) {
        this.mDrawable.setHotspot(r100, r101);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int r100, int r101, int r102, int r103) {
        this.mDrawable.setHotspotBounds(r100, r101, r102, r103);
    }
}
