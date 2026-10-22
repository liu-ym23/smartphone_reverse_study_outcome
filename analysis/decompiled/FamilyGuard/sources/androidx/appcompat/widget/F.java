package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* loaded from: classes.dex */
public class F extends ToggleButton {

    /* renamed from: a, reason: collision with root package name */
    private final C0435e f8136a;

    /* renamed from: b, reason: collision with root package name */
    private final C f8137b;

    /* renamed from: c, reason: collision with root package name */
    private C0444n f8138c;

    public F(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyleToggle);
    }

    private C0444n getEmojiTextViewHelper() {
        if (this.f8138c == null) {
            this.f8138c = new C0444n(this);
        }
        return this.f8138c;
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0435e c0435e = this.f8136a;
        if (c0435e != null) {
            c0435e.b();
        }
        C c6 = this.f8137b;
        if (c6 != null) {
            c6.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0435e c0435e = this.f8136a;
        if (c0435e != null) {
            return c0435e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0435e c0435e = this.f8136a;
        if (c0435e != null) {
            return c0435e.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f8137b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f8137b.k();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z5) {
        super.setAllCaps(z5);
        getEmojiTextViewHelper().d(z5);
    }

    @Override // android.widget.ToggleButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0435e c0435e = this.f8136a;
        if (c0435e != null) {
            c0435e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        C0435e c0435e = this.f8136a;
        if (c0435e != null) {
            c0435e.g(i5);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C c6 = this.f8137b;
        if (c6 != null) {
            c6.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C c6 = this.f8137b;
        if (c6 != null) {
            c6.p();
        }
    }

    public void setEmojiCompatEnabled(boolean z5) {
        getEmojiTextViewHelper().e(z5);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0435e c0435e = this.f8136a;
        if (c0435e != null) {
            c0435e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0435e c0435e = this.f8136a;
        if (c0435e != null) {
            c0435e.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f8137b.w(colorStateList);
        this.f8137b.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f8137b.x(mode);
        this.f8137b.b();
    }

    public F(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        V.a(this, getContext());
        C0435e c0435e = new C0435e(this);
        this.f8136a = c0435e;
        c0435e.e(attributeSet, i5);
        C c6 = new C(this);
        this.f8137b = c6;
        c6.m(attributeSet, i5);
        getEmojiTextViewHelper().c(attributeSet, i5);
    }
}
