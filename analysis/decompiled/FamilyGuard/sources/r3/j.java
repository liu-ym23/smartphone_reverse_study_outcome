package r3;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private final View f20031a;

    /* renamed from: b, reason: collision with root package name */
    private Drawable f20032b;

    public j(View view) {
        j4.k.g(view, "owner");
        this.f20031a = view;
    }

    private final void b(Drawable drawable, Canvas canvas) {
        if (drawable == null) {
            return;
        }
        drawable.setBounds(0, 0, this.f20031a.getWidth(), this.f20031a.getHeight());
        drawable.draw(canvas);
    }

    private final Drawable e(Drawable drawable, Drawable drawable2) {
        if (drawable == drawable2) {
            return drawable;
        }
        if (drawable != null) {
            drawable.setCallback(null);
        }
        if (drawable2 != null) {
            drawable2.setCallback(this.f20031a);
            drawable2.setLayoutDirection(this.f20031a.getLayoutDirection());
            if (drawable2.isStateful()) {
                drawable2.setState(this.f20031a.getDrawableState());
            }
            drawable2.setVisible(this.f20031a.getVisibility() == 0, true);
        }
        this.f20031a.invalidate();
        return drawable2;
    }

    public final void a(Canvas canvas) {
        j4.k.g(canvas, "canvas");
        b(this.f20032b, canvas);
    }

    public final void c(float f5, float f6) {
        Drawable drawable = this.f20032b;
        if (drawable != null) {
            drawable.setHotspot(f5, f6);
        }
    }

    public final void d() {
        Drawable drawable = this.f20032b;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public final void f(Drawable drawable) {
        this.f20032b = e(this.f20032b, drawable);
    }

    public final boolean g() {
        Drawable drawable = this.f20032b;
        return drawable != null && drawable.isStateful() && drawable.setState(this.f20031a.getDrawableState());
    }

    public final void h(int i5) {
        Drawable drawable = this.f20032b;
        if (drawable != null) {
            drawable.setLayoutDirection(i5);
        }
    }

    public final boolean i(Drawable drawable) {
        j4.k.g(drawable, "drawable");
        return drawable == this.f20032b;
    }
}
