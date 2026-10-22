package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableImageSourceView;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatImageView extends ImageView implements TintableBackgroundView, TintableImageSourceView {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private boolean mHasLevel;
    private final AppCompatImageHelper mImageHelper;

    public AppCompatImageView(Context r2) {
        this(r2, null);
    }

    public AppCompatImageView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public AppCompatImageView(Context r1, AttributeSet r2, int r3) {
        super(TintContextWrapper.wrap(r1), r2, r3);
        this.mHasLevel = false;
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatBackgroundHelper r4 = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = r4;
        r4.loadFromAttributes(r2, r3);
        AppCompatImageHelper r5 = new AppCompatImageHelper(this);
        this.mImageHelper = r5;
        r5.loadFromAttributes(r2, r3);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int r1) {
        AppCompatImageHelper r0 = this.mImageHelper;
        if (r0 == null) goto L6;
        r0.setImageResource(r1);
        return;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable r3) {
        AppCompatImageHelper r0 = this.mImageHelper;
        if (r0 == null) goto L8;
        if (r3 == null) goto L8;
        if (this.mHasLevel == true) goto L8;
        r0.obtainLevelFromDrawable(r3);
    L8:
        super.setImageDrawable(r3);
        AppCompatImageHelper r4 = this.mImageHelper;
        if (r4 == null) goto L14;
        r4.applySupportImageTint();
        if (this.mHasLevel == true) goto L15;
        this.mImageHelper.applyImageLevel();
        return;
    L15:
        return;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap r1) {
        super.setImageBitmap(r1);
        AppCompatImageHelper r0 = this.mImageHelper;
        if (r0 == null) goto L6;
        r0.applySupportImageTint();
        return;
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri r1) {
        super.setImageURI(r1);
        AppCompatImageHelper r0 = this.mImageHelper;
        if (r0 == null) goto L6;
        r0.applySupportImageTint();
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(int r1) {
        super.setBackgroundResource(r1);
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.onSetBackgroundResource(r1);
        return;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r1) {
        super.setBackgroundDrawable(r1);
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.onSetBackgroundDrawable(r1);
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList r1) {
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.setSupportBackgroundTintList(r1);
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSupportBackgroundTintList();
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode r1) {
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.setSupportBackgroundTintMode(r1);
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSupportBackgroundTintMode();
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintList(ColorStateList r1) {
        AppCompatImageHelper r0 = this.mImageHelper;
        if (r0 == null) goto L6;
        r0.setSupportImageTintList(r1);
        return;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public ColorStateList getSupportImageTintList() {
        AppCompatImageHelper r0 = this.mImageHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSupportImageTintList();
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintMode(PorterDuff.Mode r1) {
        AppCompatImageHelper r0 = this.mImageHelper;
        if (r0 == null) goto L6;
        r0.setSupportImageTintMode(r1);
        return;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public PorterDuff.Mode getSupportImageTintMode() {
        AppCompatImageHelper r0 = this.mImageHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSupportImageTintMode();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L5;
        r0.applySupportBackgroundTint();
    L5:
        AppCompatImageHelper r1 = this.mImageHelper;
        if (r1 == null) goto L9;
        r1.applySupportImageTint();
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        if (this.mImageHelper.hasOverlappingRendering() == true) goto L5;
    L7:
        return false;
    L5:
        if (super.hasOverlappingRendering() == false) goto L7;
        return true;
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int r1) {
        super.setImageLevel(r1);
        this.mHasLevel = true;
    }
}
