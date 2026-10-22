package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.appcompat.R$attr;

/* renamed from: androidx.appcompat.widget.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1299l extends ImageButton {
    private final C1291d mBackgroundTintHelper;
    private boolean mHasLevel;
    private final C1300m mImageHelper;

    public C1299l(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C1291d c1291d = this.mBackgroundTintHelper;
        if (c1291d != null) {
            c1291d.b();
        }
        C1300m c1300m = this.mImageHelper;
        if (c1300m != null) {
            c1300m.c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1291d c1291d = this.mBackgroundTintHelper;
        if (c1291d != null) {
            return c1291d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1291d c1291d = this.mBackgroundTintHelper;
        if (c1291d != null) {
            return c1291d.d();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        C1300m c1300m = this.mImageHelper;
        if (c1300m != null) {
            return c1300m.d();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        C1300m c1300m = this.mImageHelper;
        if (c1300m != null) {
            return c1300m.e();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.mImageHelper.f() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1291d c1291d = this.mBackgroundTintHelper;
        if (c1291d != null) {
            c1291d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        C1291d c1291d = this.mBackgroundTintHelper;
        if (c1291d != null) {
            c1291d.g(i10);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C1300m c1300m = this.mImageHelper;
        if (c1300m != null) {
            c1300m.c();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        C1300m c1300m = this.mImageHelper;
        if (c1300m != null && drawable != null && !this.mHasLevel) {
            c1300m.h(drawable);
        }
        super.setImageDrawable(drawable);
        C1300m c1300m2 = this.mImageHelper;
        if (c1300m2 != null) {
            c1300m2.c();
            if (this.mHasLevel) {
                return;
            }
            this.mImageHelper.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i10) {
        super.setImageLevel(i10);
        this.mHasLevel = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i10) {
        this.mImageHelper.i(i10);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C1300m c1300m = this.mImageHelper;
        if (c1300m != null) {
            c1300m.c();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C1291d c1291d = this.mBackgroundTintHelper;
        if (c1291d != null) {
            c1291d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C1291d c1291d = this.mBackgroundTintHelper;
        if (c1291d != null) {
            c1291d.j(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        C1300m c1300m = this.mImageHelper;
        if (c1300m != null) {
            c1300m.j(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        C1300m c1300m = this.mImageHelper;
        if (c1300m != null) {
            c1300m.k(mode);
        }
    }

    public C1299l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.imageButtonStyle);
    }

    public C1299l(Context context, AttributeSet attributeSet, int i10) {
        super(Q.b(context), attributeSet, i10);
        this.mHasLevel = false;
        O.a(this, getContext());
        C1291d c1291d = new C1291d(this);
        this.mBackgroundTintHelper = c1291d;
        c1291d.e(attributeSet, i10);
        C1300m c1300m = new C1300m(this);
        this.mImageHelper = c1300m;
        c1300m.g(attributeSet, i10);
    }
}
