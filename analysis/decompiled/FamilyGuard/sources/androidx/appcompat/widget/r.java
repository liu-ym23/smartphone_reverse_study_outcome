package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class r extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private final C0435e f8600a;

    /* renamed from: b, reason: collision with root package name */
    private final C0447q f8601b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f8602c;

    public r(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0435e c0435e = this.f8600a;
        if (c0435e != null) {
            c0435e.b();
        }
        C0447q c0447q = this.f8601b;
        if (c0447q != null) {
            c0447q.c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0435e c0435e = this.f8600a;
        if (c0435e != null) {
            return c0435e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0435e c0435e = this.f8600a;
        if (c0435e != null) {
            return c0435e.d();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        C0447q c0447q = this.f8601b;
        if (c0447q != null) {
            return c0447q.d();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        C0447q c0447q = this.f8601b;
        if (c0447q != null) {
            return c0447q.e();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f8601b.f() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0435e c0435e = this.f8600a;
        if (c0435e != null) {
            c0435e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        C0435e c0435e = this.f8600a;
        if (c0435e != null) {
            c0435e.g(i5);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C0447q c0447q = this.f8601b;
        if (c0447q != null) {
            c0447q.c();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        C0447q c0447q = this.f8601b;
        if (c0447q != null && drawable != null && !this.f8602c) {
            c0447q.h(drawable);
        }
        super.setImageDrawable(drawable);
        C0447q c0447q2 = this.f8601b;
        if (c0447q2 != null) {
            c0447q2.c();
            if (this.f8602c) {
                return;
            }
            this.f8601b.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i5) {
        super.setImageLevel(i5);
        this.f8602c = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i5) {
        C0447q c0447q = this.f8601b;
        if (c0447q != null) {
            c0447q.i(i5);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C0447q c0447q = this.f8601b;
        if (c0447q != null) {
            c0447q.c();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0435e c0435e = this.f8600a;
        if (c0435e != null) {
            c0435e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0435e c0435e = this.f8600a;
        if (c0435e != null) {
            c0435e.j(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        C0447q c0447q = this.f8601b;
        if (c0447q != null) {
            c0447q.j(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        C0447q c0447q = this.f8601b;
        if (c0447q != null) {
            c0447q.k(mode);
        }
    }

    public r(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public r(Context context, AttributeSet attributeSet, int i5) {
        super(X.b(context), attributeSet, i5);
        this.f8602c = false;
        V.a(this, getContext());
        C0435e c0435e = new C0435e(this);
        this.f8600a = c0435e;
        c0435e.e(attributeSet, i5);
        C0447q c0447q = new C0447q(this);
        this.f8601b = c0447q;
        c0447q.g(attributeSet, i5);
    }
}
