package androidx.appcompat.widget;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;

/* JADX INFO: loaded from: classes3.dex */
public class AppCompatImageHelper {
    private TintInfo mImageTint;
    private TintInfo mInternalImageTint;
    private TintInfo mTmpInfo;
    private final ImageView mView;

    private boolean shouldApplyFrameworkTintUsingColorFilter() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 > 21) goto L5;
        if (r100 != 21) goto L11;
        return true;
    L11:
        return false;
    L5:
        if (this.mInternalImageTint != null) goto L12;
        return false;
    L12:
        return true;
    }

    public void applySupportImageTint() {
        Drawable r100 = this.mView.getDrawable();
        if (r100 == null) goto L5;
        DrawableUtils.fixDrawable(r100);
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        if (shouldApplyFrameworkTintUsingColorFilter() == true) goto L9;
    L11:
        TintInfo r101 = this.mImageTint;
        if (r101 == null) goto L14;
        AppCompatDrawableManager.tintDrawable(r100, r101, this.mView.getDrawableState());
        return;
    L14:
        TintInfo r102 = this.mInternalImageTint;
        if (r102 == null) goto L20;
        AppCompatDrawableManager.tintDrawable(r100, r102, this.mView.getDrawableState());
        return;
    L20:
        return;
    L9:
        if (applyFrameworkTintUsingColorFilter(r100) == false) goto L11;
    }

    public ColorStateList getSupportImageTintList() {
        TintInfo r100 = this.mImageTint;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.mTintList;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        TintInfo r100 = this.mImageTint;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.mTintMode;
    }

    public boolean hasOverlappingRendering() {
        if ((this.mView.getBackground() instanceof RippleDrawable) == false) goto L6;
        return false;
    L6:
        return true;
    }

    public AppCompatImageHelper(ImageView r100) {
        this.mView = r100;
    }

    private boolean applyFrameworkTintUsingColorFilter(Drawable r100) {
        if (this.mTmpInfo != null) goto L5;
        this.mTmpInfo = new TintInfo();
    L5:
        TintInfo r101 = this.mTmpInfo;
        r101.clear();
        ColorStateList r102 = ImageViewCompat.getImageTintList(this.mView);
        if (r102 == null) goto L8;
        r101.mHasTintList = true;
        r101.mTintList = r102;
    L8:
        PorterDuff.Mode r103 = ImageViewCompat.getImageTintMode(this.mView);
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

    public void setImageResource(int r100) {
        if (r100 == 0) goto L7;
        Drawable r101 = AppCompatResources.getDrawable(this.mView.getContext(), r100);
        if (r101 == null) goto L6;
        DrawableUtils.fixDrawable(r101);
    L6:
        this.mView.setImageDrawable(r101);
    L8:
        applySupportImageTint();
        return;
    L7:
        this.mView.setImageDrawable(null);
        goto L8
    }

    public void setInternalImageTint(ColorStateList r100) {
        if (r100 != null) goto L4;
        this.mInternalImageTint = null;
    L8:
        applySupportImageTint();
        return;
    L4:
        if (this.mInternalImageTint != null) goto L6;
        this.mInternalImageTint = new TintInfo();
    L6:
        TintInfo r101 = this.mInternalImageTint;
        r101.mTintList = r100;
        r101.mHasTintList = true;
        goto L8
    }

    public void setSupportImageTintList(ColorStateList r100) {
        if (this.mImageTint != null) goto L5;
        this.mImageTint = new TintInfo();
    L5:
        TintInfo r101 = this.mImageTint;
        r101.mTintList = r100;
        r101.mHasTintList = true;
        applySupportImageTint();
    }

    public void setSupportImageTintMode(PorterDuff.Mode r100) {
        if (this.mImageTint != null) goto L5;
        this.mImageTint = new TintInfo();
    L5:
        TintInfo r101 = this.mImageTint;
        r101.mTintMode = r100;
        r101.mHasTintMode = true;
        applySupportImageTint();
    }

    public void loadFromAttributes(AttributeSet r110, int r111) {
        TintTypedArray r100 = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), r110, new int[]{R.attr.src, com.larus.nova.R.attr.srcCompat, com.larus.nova.R.attr.tint, com.larus.nova.R.attr.tintMode}, r111, 0);
        ImageView r101 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r101, r101.getContext(), new int[]{R.attr.src, com.larus.nova.R.attr.srcCompat, com.larus.nova.R.attr.tint, com.larus.nova.R.attr.tintMode}, r110, r100.getWrappedTypeArray(), r111, 0);
        Drawable r112 = this.mView.getDrawable();     // Catch: Throwable -> L20
        if (r112 != null) goto L10;
        int r102 = r100.getResourceId(1, -1);     // Catch: Throwable -> L20
        if (r102 == (-1)) goto L10;
        r112 = AppCompatResources.getDrawable(this.mView.getContext(), r102);     // Catch: Throwable -> L20
        if (r112 == null) goto L10;
        this.mView.setImageDrawable(r112);     // Catch: Throwable -> L20
    L10:
        if (r112 == null) goto L13;
        DrawableUtils.fixDrawable(r112);     // Catch: Throwable -> L20
    L13:
        if (r100.hasValue(2) == false) goto L16;
        ImageViewCompat.setImageTintList(this.mView, r100.getColorStateList(2));     // Catch: Throwable -> L20
    L16:
        if (r100.hasValue(3) == false) goto L18;
        ImageViewCompat.setImageTintMode(this.mView, DrawableUtils.parseTintMode(r100.getInt(3, -1), null));     // Catch: Throwable -> L20
    L18:
        r100.recycle();
        return;
    L20:
        th = move-exception;
        r100.recycle();
        throw th;
    }
}
