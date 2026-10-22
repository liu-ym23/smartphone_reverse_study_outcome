package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import g.C0728a;

/* renamed from: androidx.appcompat.widget.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0446p extends ImageButton {

    /* renamed from: a, reason: collision with root package name */
    private final C0435e f8592a;

    /* renamed from: b, reason: collision with root package name */
    private final C0447q f8593b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f8594c;

    public C0446p(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0728a.f16810G);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0435e c0435e = this.f8592a;
        if (c0435e != null) {
            c0435e.b();
        }
        C0447q c0447q = this.f8593b;
        if (c0447q != null) {
            c0447q.c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0435e c0435e = this.f8592a;
        if (c0435e != null) {
            return c0435e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0435e c0435e = this.f8592a;
        if (c0435e != null) {
            return c0435e.d();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        C0447q c0447q = this.f8593b;
        if (c0447q != null) {
            return c0447q.d();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        C0447q c0447q = this.f8593b;
        if (c0447q != null) {
            return c0447q.e();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f8593b.f() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0435e c0435e = this.f8592a;
        if (c0435e != null) {
            c0435e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        C0435e c0435e = this.f8592a;
        if (c0435e != null) {
            c0435e.g(i5);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C0447q c0447q = this.f8593b;
        if (c0447q != null) {
            c0447q.c();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        C0447q c0447q = this.f8593b;
        if (c0447q != null && drawable != null && !this.f8594c) {
            c0447q.h(drawable);
        }
        super.setImageDrawable(drawable);
        C0447q c0447q2 = this.f8593b;
        if (c0447q2 != null) {
            c0447q2.c();
            if (this.f8594c) {
                return;
            }
            this.f8593b.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i5) {
        super.setImageLevel(i5);
        this.f8594c = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i5) {
        this.f8593b.i(i5);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C0447q c0447q = this.f8593b;
        if (c0447q != null) {
            c0447q.c();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0435e c0435e = this.f8592a;
        if (c0435e != null) {
            c0435e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0435e c0435e = this.f8592a;
        if (c0435e != null) {
            c0435e.j(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        C0447q c0447q = this.f8593b;
        if (c0447q != null) {
            c0447q.j(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        C0447q c0447q = this.f8593b;
        if (c0447q != null) {
            c0447q.k(mode);
        }
    }

    public C0446p(Context context, AttributeSet attributeSet, int i5) {
        super(X.b(context), attributeSet, i5);
        this.f8594c = false;
        V.a(this, getContext());
        C0435e c0435e = new C0435e(this);
        this.f8592a = c0435e;
        c0435e.e(attributeSet, i5);
        C0447q c0447q = new C0447q(this);
        this.f8593b = c0447q;
        c0447q.g(attributeSet, i5);
    }
}
