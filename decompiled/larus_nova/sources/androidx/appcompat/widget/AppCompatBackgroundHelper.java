package androidx.appcompat.widget;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes3.dex */
class AppCompatBackgroundHelper {
    private int mBackgroundResId;
    private TintInfo mBackgroundTint;
    private final AppCompatDrawableManager mDrawableManager;
    private TintInfo mInternalBackgroundTint;
    private TintInfo mTmpInfo;
    private final View mView;

    private boolean shouldApplyFrameworkTintUsingColorFilter() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 > 21) goto L5;
        if (r100 != 21) goto L11;
        return true;
    L11:
        return false;
    L5:
        if (this.mInternalBackgroundTint != null) goto L12;
        return false;
    L12:
        return true;
    }

    public void applySupportBackgroundTint() {
        Drawable r100 = this.mView.getBackground();
        if (r100 != null) goto L5;
        return;
    L5:
        if (shouldApplyFrameworkTintUsingColorFilter() == true) goto L7;
    L9:
        TintInfo r101 = this.mBackgroundTint;
        if (r101 == null) goto L12;
        AppCompatDrawableManager.tintDrawable(r100, r101, this.mView.getDrawableState());
        return;
    L12:
        TintInfo r102 = this.mInternalBackgroundTint;
        if (r102 == null) goto L18;
        AppCompatDrawableManager.tintDrawable(r100, r102, this.mView.getDrawableState());
        return;
    L18:
        return;
    L7:
        if (applyFrameworkTintUsingColorFilter(r100) == false) goto L9;
    }

    public ColorStateList getSupportBackgroundTintList() {
        TintInfo r100 = this.mBackgroundTint;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.mTintList;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        TintInfo r100 = this.mBackgroundTint;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.mTintMode;
    }

    public AppCompatBackgroundHelper(View r100) {
        this.mBackgroundResId = -1;
        this.mView = r100;
        this.mDrawableManager = AppCompatDrawableManager.get();
    }

    private boolean applyFrameworkTintUsingColorFilter(Drawable r100) {
        if (this.mTmpInfo != null) goto L5;
        this.mTmpInfo = new TintInfo();
    L5:
        TintInfo r101 = this.mTmpInfo;
        r101.clear();
        ColorStateList r102 = ViewCompat.getBackgroundTintList(this.mView);
        if (r102 == null) goto L8;
        r101.mHasTintList = true;
        r101.mTintList = r102;
    L8:
        PorterDuff.Mode r103 = ViewCompat.getBackgroundTintMode(this.mView);
        if (r103 == null) goto L12;
        r101.mHasTintMode = true;
        r101.mTintMode = r103;
    L12:
        if (r101.mHasTintList == false) goto L14;
    L18:
        AppCompatDrawableManager.tintDrawable(r100, r101, this.mView.getDrawableState());
        return true;
    L14:
        if (r101.mHasTintMode == true) goto L18;
        return false;
    }

    public void onSetBackgroundDrawable(Drawable r100) {
        this.mBackgroundResId = -1;
        setInternalBackgroundTint(null);
        applySupportBackgroundTint();
    }

    public void onSetBackgroundResource(int r100) {
        this.mBackgroundResId = r100;
        AppCompatDrawableManager r101 = this.mDrawableManager;
        if (r101 == null) goto L5;
        ColorStateList r102 = r101.getTintList(this.mView.getContext(), r100);
    L6:
        setInternalBackgroundTint(r102);
        applySupportBackgroundTint();
        return;
    L5:
        r102 = null;
        goto L6
    }

    public void setInternalBackgroundTint(ColorStateList r100) {
        if (r100 != null) goto L4;
        this.mInternalBackgroundTint = null;
    L8:
        applySupportBackgroundTint();
        return;
    L4:
        if (this.mInternalBackgroundTint != null) goto L6;
        this.mInternalBackgroundTint = new TintInfo();
    L6:
        TintInfo r101 = this.mInternalBackgroundTint;
        r101.mTintList = r100;
        r101.mHasTintList = true;
        goto L8
    }

    public void setSupportBackgroundTintList(ColorStateList r100) {
        if (this.mBackgroundTint != null) goto L5;
        this.mBackgroundTint = new TintInfo();
    L5:
        TintInfo r101 = this.mBackgroundTint;
        r101.mTintList = r100;
        r101.mHasTintList = true;
        applySupportBackgroundTint();
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode r100) {
        if (this.mBackgroundTint != null) goto L5;
        this.mBackgroundTint = new TintInfo();
    L5:
        TintInfo r101 = this.mBackgroundTint;
        r101.mTintMode = r100;
        r101.mHasTintMode = true;
        applySupportBackgroundTint();
    }

    public void loadFromAttributes(AttributeSet r110, int r111) {
        TintTypedArray r100 = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), r110, new int[]{R.attr.background, com.larus.nova.R.attr.backgroundTint, com.larus.nova.R.attr.backgroundTintMode}, r111, 0);
        View r101 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r101, r101.getContext(), new int[]{R.attr.background, com.larus.nova.R.attr.backgroundTint, com.larus.nova.R.attr.backgroundTintMode}, r110, r100.getWrappedTypeArray(), r111, 0);
    L16:
        th = move-exception;
        r100.recycle();
        throw th;
    L4:
        if (r100.hasValue(0) == false) goto L9;
        this.mBackgroundResId = r100.getResourceId(0, -1);     // Catch: Throwable -> L16
        ColorStateList r112 = this.mDrawableManager.getTintList(this.mView.getContext(), this.mBackgroundResId);     // Catch: Throwable -> L16
        if (r112 == null) goto L9;
        setInternalBackgroundTint(r112);     // Catch: Throwable -> L16
    L9:
        if (r100.hasValue(1) == false) goto L12;
        ViewCompat.setBackgroundTintList(this.mView, r100.getColorStateList(1));     // Catch: Throwable -> L16
    L12:
        if (r100.hasValue(2) == false) goto L14;
        ViewCompat.setBackgroundTintMode(this.mView, DrawableUtils.parseTintMode(r100.getInt(2, -1), null));     // Catch: Throwable -> L16
    L14:
        r100.recycle();
    }
}
