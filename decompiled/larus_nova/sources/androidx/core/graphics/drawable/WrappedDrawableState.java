package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes17.dex */
final class WrappedDrawableState extends Drawable.ConstantState {
    int mChangingConfigurations;
    Drawable.ConstantState mDrawableState;
    ColorStateList mTint;
    PorterDuff.Mode mTintMode;

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    public boolean canConstantState() {
        if (this.mDrawableState == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int r100 = this.mChangingConfigurations;
        Drawable.ConstantState r101 = this.mDrawableState;
        if (r101 == null) goto L5;
        int r102 = r101.getChangingConfigurations();
    L7:
        return r100 | r102;
    L5:
        r102 = 0;
        goto L7
    }

    public WrappedDrawableState(WrappedDrawableState r100) {
        this.mTint = null;
        this.mTintMode = WrappedDrawableApi14.DEFAULT_TINT_MODE;
        if (r100 == null) goto L6;
        this.mChangingConfigurations = r100.mChangingConfigurations;
        this.mDrawableState = r100.mDrawableState;
        this.mTint = r100.mTint;
        this.mTintMode = r100.mTintMode;
        return;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources r100) {
        return new WrappedDrawableApi21(this, r100);
    }
}
