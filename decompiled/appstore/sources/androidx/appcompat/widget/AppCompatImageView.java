package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableImageSourceView;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatImageView extends ImageView implements TintableBackgroundView, TintableImageSourceView {
    private final c mBackgroundTintHelper;
    private boolean mHasLevel;
    private final j mImageHelper;

    public AppCompatImageView(@NonNull Context r10) {
        this(r10, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        c r10 = this.mBackgroundTintHelper;
        if (r10 == null) goto L5;
        r10.b();
    L5:
        j r11 = this.mImageHelper;
        if (r11 == null) goto L9;
        r11.c();
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        c r10 = this.mBackgroundTintHelper;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.c();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        c r10 = this.mBackgroundTintHelper;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.d();
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportImageTintList() {
        j r10 = this.mImageHelper;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.d();
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportImageTintMode() {
        j r10 = this.mImageHelper;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.e();
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        if (this.mImageHelper.f() == true) goto L5;
    L7:
        return false;
    L5:
        if (super.hasOverlappingRendering() == false) goto L7;
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable r10) {
        super.setBackgroundDrawable(r10);
        c r11 = this.mBackgroundTintHelper;
        if (r11 == null) goto L6;
        r11.f(r10);
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int r10) {
        super.setBackgroundResource(r10);
        c r11 = this.mBackgroundTintHelper;
        if (r11 == null) goto L6;
        r11.g(r10);
        return;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap r10) {
        super.setImageBitmap(r10);
        j r11 = this.mImageHelper;
        if (r11 == null) goto L6;
        r11.c();
        return;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable r10) {
        j r11 = this.mImageHelper;
        if (r11 == null) goto L8;
        if (r10 == null) goto L8;
        if (this.mHasLevel == true) goto L8;
        r11.h(r10);
    L8:
        super.setImageDrawable(r10);
        j r12 = this.mImageHelper;
        if (r12 == null) goto L14;
        r12.c();
        if (this.mHasLevel == true) goto L15;
        this.mImageHelper.b();
        return;
    L15:
        return;
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int r10) {
        super.setImageLevel(r10);
        this.mHasLevel = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int r10) {
        j r11 = this.mImageHelper;
        if (r11 == null) goto L6;
        r11.i(r10);
        return;
    }

    @Override // android.widget.ImageView
    public void setImageURI(@Nullable Uri r10) {
        super.setImageURI(r10);
        j r11 = this.mImageHelper;
        if (r11 == null) goto L6;
        r11.c();
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList r10) {
        c r11 = this.mBackgroundTintHelper;
        if (r11 == null) goto L6;
        r11.i(r10);
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode r10) {
        c r11 = this.mBackgroundTintHelper;
        if (r11 == null) goto L6;
        r11.j(r10);
        return;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportImageTintList(@Nullable ColorStateList r10) {
        j r11 = this.mImageHelper;
        if (r11 == null) goto L6;
        r11.j(r10);
        return;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportImageTintMode(@Nullable PorterDuff.Mode r10) {
        j r11 = this.mImageHelper;
        if (r11 == null) goto L6;
        r11.k(r10);
        return;
    }

    public AppCompatImageView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public AppCompatImageView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(y.b(r10), r11, r12);
        this.mHasLevel = false;
        x.a(this, getContext());
        c r13 = new c(this);
        this.mBackgroundTintHelper = r13;
        r13.e(r11, r12);
        j r14 = new j(this);
        this.mImageHelper = r14;
        r14.g(r11, r12);
    }
}
