package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.CheckBox;
import g.C0728a;
import h.C0744a;

/* renamed from: androidx.appcompat.widget.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0437g extends CheckBox implements androidx.core.widget.k {

    /* renamed from: a, reason: collision with root package name */
    private final C0440j f8549a;

    /* renamed from: b, reason: collision with root package name */
    private final C0435e f8550b;

    /* renamed from: c, reason: collision with root package name */
    private final C f8551c;

    /* renamed from: d, reason: collision with root package name */
    private C0444n f8552d;

    public C0437g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0728a.f16843t);
    }

    private C0444n getEmojiTextViewHelper() {
        if (this.f8552d == null) {
            this.f8552d = new C0444n(this);
        }
        return this.f8552d;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0435e c0435e = this.f8550b;
        if (c0435e != null) {
            c0435e.b();
        }
        C c6 = this.f8551c;
        if (c6 != null) {
            c6.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0435e c0435e = this.f8550b;
        if (c0435e != null) {
            return c0435e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0435e c0435e = this.f8550b;
        if (c0435e != null) {
            return c0435e.d();
        }
        return null;
    }

    @Override // androidx.core.widget.k
    public ColorStateList getSupportButtonTintList() {
        C0440j c0440j = this.f8549a;
        if (c0440j != null) {
            return c0440j.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        C0440j c0440j = this.f8549a;
        if (c0440j != null) {
            return c0440j.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f8551c.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f8551c.k();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z5) {
        super.setAllCaps(z5);
        getEmojiTextViewHelper().d(z5);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0435e c0435e = this.f8550b;
        if (c0435e != null) {
            c0435e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        C0435e c0435e = this.f8550b;
        if (c0435e != null) {
            c0435e.g(i5);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        C0440j c0440j = this.f8549a;
        if (c0440j != null) {
            c0440j.e();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C c6 = this.f8551c;
        if (c6 != null) {
            c6.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C c6 = this.f8551c;
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
        C0435e c0435e = this.f8550b;
        if (c0435e != null) {
            c0435e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0435e c0435e = this.f8550b;
        if (c0435e != null) {
            c0435e.j(mode);
        }
    }

    @Override // androidx.core.widget.k
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        C0440j c0440j = this.f8549a;
        if (c0440j != null) {
            c0440j.f(colorStateList);
        }
    }

    @Override // androidx.core.widget.k
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        C0440j c0440j = this.f8549a;
        if (c0440j != null) {
            c0440j.g(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f8551c.w(colorStateList);
        this.f8551c.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f8551c.x(mode);
        this.f8551c.b();
    }

    public C0437g(Context context, AttributeSet attributeSet, int i5) {
        super(X.b(context), attributeSet, i5);
        V.a(this, getContext());
        C0440j c0440j = new C0440j(this);
        this.f8549a = c0440j;
        c0440j.d(attributeSet, i5);
        C0435e c0435e = new C0435e(this);
        this.f8550b = c0435e;
        c0435e.e(attributeSet, i5);
        C c6 = new C(this);
        this.f8551c = c6;
        c6.m(attributeSet, i5);
        getEmojiTextViewHelper().c(attributeSet, i5);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i5) {
        setButtonDrawable(C0744a.b(getContext(), i5));
    }
}
