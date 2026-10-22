package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import e.EnumC0546d;

/* loaded from: classes.dex */
public class E extends ImageButton {

    /* renamed from: a, reason: collision with root package name */
    public final C0228u f2811a;

    /* renamed from: b, reason: collision with root package name */
    public final F f2812b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2813c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        W0.a(context);
        this.f2813c = false;
        V0.a(getContext(), this);
        C0228u c0228u = new C0228u(this);
        this.f2811a = c0228u;
        c0228u.d(attributeSet, i4);
        F f4 = new F(this);
        this.f2812b = f4;
        f4.b(attributeSet, i4);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0228u c0228u = this.f2811a;
        if (c0228u != null) {
            c0228u.a();
        }
        F f4 = this.f2812b;
        if (f4 != null) {
            f4.a();
        }
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public ColorStateList getSupportBackgroundTintList() {
        C0228u c0228u = this.f2811a;
        if (c0228u != null) {
            return c0228u.b();
        }
        return null;
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0228u c0228u = this.f2811a;
        if (c0228u != null) {
            return c0228u.c();
        }
        return null;
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public ColorStateList getSupportImageTintList() {
        X0 x02;
        F f4 = this.f2812b;
        if (f4 == null || (x02 = f4.f2816b) == null) {
            return null;
        }
        return x02.f3042a;
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public PorterDuff.Mode getSupportImageTintMode() {
        X0 x02;
        F f4 = this.f2812b;
        if (f4 == null || (x02 = f4.f2816b) == null) {
            return null;
        }
        return x02.f3043b;
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        return ((this.f2812b.f2815a.getBackground() instanceof RippleDrawable) ^ true) && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0228u c0228u = this.f2811a;
        if (c0228u != null) {
            c0228u.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i4) {
        super.setBackgroundResource(i4);
        C0228u c0228u = this.f2811a;
        if (c0228u != null) {
            c0228u.f(i4);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        F f4 = this.f2812b;
        if (f4 != null) {
            f4.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        F f4 = this.f2812b;
        if (f4 != null && drawable != null && !this.f2813c) {
            f4.f2817c = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (f4 != null) {
            f4.a();
            if (this.f2813c) {
                return;
            }
            ImageView imageView = f4.f2815a;
            if (imageView.getDrawable() != null) {
                imageView.getDrawable().setLevel(f4.f2817c);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i4) {
        super.setImageLevel(i4);
        this.f2813c = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int i4) {
        F f4 = this.f2812b;
        ImageView imageView = f4.f2815a;
        if (i4 != 0) {
            Drawable drawableO = Z2.I.o(imageView.getContext(), i4);
            if (drawableO != null) {
                Rect rect = AbstractC0220p0.f3149a;
            }
            imageView.setImageDrawable(drawableO);
        } else {
            imageView.setImageDrawable(null);
        }
        f4.a();
    }

    @Override // android.widget.ImageView
    public void setImageURI(@Nullable Uri uri) {
        super.setImageURI(uri);
        F f4 = this.f2812b;
        if (f4 != null) {
            f4.a();
        }
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        C0228u c0228u = this.f2811a;
        if (c0228u != null) {
            c0228u.h(colorStateList);
        }
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        C0228u c0228u = this.f2811a;
        if (c0228u != null) {
            c0228u.i(mode);
        }
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportImageTintList(@Nullable ColorStateList colorStateList) {
        F f4 = this.f2812b;
        if (f4 != null) {
            if (f4.f2816b == null) {
                f4.f2816b = new X0();
            }
            X0 x02 = f4.f2816b;
            x02.f3042a = colorStateList;
            x02.f3045d = true;
            f4.a();
        }
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportImageTintMode(@Nullable PorterDuff.Mode mode) {
        F f4 = this.f2812b;
        if (f4 != null) {
            if (f4.f2816b == null) {
                f4.f2816b = new X0();
            }
            X0 x02 = f4.f2816b;
            x02.f3043b = mode;
            x02.f3044c = true;
            f4.a();
        }
    }
}
