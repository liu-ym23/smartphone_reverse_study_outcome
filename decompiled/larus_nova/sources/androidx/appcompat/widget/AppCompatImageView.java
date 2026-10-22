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

/* JADX INFO: loaded from: classes3.dex */
public class AppCompatImageView extends ImageView implements TintableBackgroundView, TintableImageSourceView {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final AppCompatImageHelper mImageHelper;

    @Override // androidx.core.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper r100 = this.mBackgroundTintHelper;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSupportBackgroundTintList();
    }

    @Override // androidx.core.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper r100 = this.mBackgroundTintHelper;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSupportBackgroundTintMode();
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public ColorStateList getSupportImageTintList() {
        AppCompatImageHelper r100 = this.mImageHelper;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSupportImageTintList();
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public PorterDuff.Mode getSupportImageTintMode() {
        AppCompatImageHelper r100 = this.mImageHelper;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSupportImageTintMode();
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

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper r100 = this.mBackgroundTintHelper;
        if (r100 == null) goto L5;
        r100.applySupportBackgroundTint();
    L5:
        AppCompatImageHelper r101 = this.mImageHelper;
        if (r101 == null) goto L9;
        r101.applySupportImageTint();
        return;
    }

    public AppCompatImageView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r100) {
        super.setBackgroundDrawable(r100);
        AppCompatBackgroundHelper r101 = this.mBackgroundTintHelper;
        if (r101 == null) goto L6;
        r101.onSetBackgroundDrawable(r100);
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(int r100) {
        super.setBackgroundResource(r100);
        AppCompatBackgroundHelper r101 = this.mBackgroundTintHelper;
        if (r101 == null) goto L6;
        r101.onSetBackgroundResource(r100);
        return;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap r100) {
        super.setImageBitmap(r100);
        AppCompatImageHelper r101 = this.mImageHelper;
        if (r101 == null) goto L6;
        r101.applySupportImageTint();
        return;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable r100) {
        super.setImageDrawable(r100);
        AppCompatImageHelper r101 = this.mImageHelper;
        if (r101 == null) goto L6;
        r101.applySupportImageTint();
        return;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int r100) {
        AppCompatImageHelper r101 = this.mImageHelper;
        if (r101 == null) goto L6;
        r101.setImageResource(r100);
        return;
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri r100) {
        super.setImageURI(r100);
        AppCompatImageHelper r101 = this.mImageHelper;
        if (r101 == null) goto L6;
        r101.applySupportImageTint();
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList r100) {
        AppCompatBackgroundHelper r101 = this.mBackgroundTintHelper;
        if (r101 == null) goto L6;
        r101.setSupportBackgroundTintList(r100);
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode r100) {
        AppCompatBackgroundHelper r101 = this.mBackgroundTintHelper;
        if (r101 == null) goto L6;
        r101.setSupportBackgroundTintMode(r100);
        return;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintList(ColorStateList r100) {
        AppCompatImageHelper r101 = this.mImageHelper;
        if (r101 == null) goto L6;
        r101.setSupportImageTintList(r100);
        return;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintMode(PorterDuff.Mode r100) {
        AppCompatImageHelper r101 = this.mImageHelper;
        if (r101 == null) goto L6;
        r101.setSupportImageTintMode(r100);
        return;
    }

    public AppCompatImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public AppCompatImageView(Context r100, AttributeSet r101, int r102) {
        super(TintContextWrapper.wrap(r100), r101, r102);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatBackgroundHelper r103 = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = r103;
        r103.loadFromAttributes(r101, r102);
        AppCompatImageHelper r104 = new AppCompatImageHelper(this);
        this.mImageHelper = r104;
        r104.loadFromAttributes(r101, r102);
    }
}
