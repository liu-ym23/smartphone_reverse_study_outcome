package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.appcompat.R$attr;
import f.C4027a;

/* renamed from: androidx.appcompat.widget.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1304q extends RadioButton implements androidx.core.widget.k {

    /* renamed from: a, reason: collision with root package name */
    public final C1294g f9229a;

    /* renamed from: b, reason: collision with root package name */
    public final C1291d f9230b;

    /* renamed from: c, reason: collision with root package name */
    public final C1309w f9231c;

    /* renamed from: d, reason: collision with root package name */
    public C1297j f9232d;

    public C1304q(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.radioButtonStyle);
    }

    private C1297j getEmojiTextViewHelper() {
        if (this.f9232d == null) {
            this.f9232d = new C1297j(this);
        }
        return this.f9232d;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C1291d c1291d = this.f9230b;
        if (c1291d != null) {
            c1291d.b();
        }
        C1309w c1309w = this.f9231c;
        if (c1309w != null) {
            c1309w.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1291d c1291d = this.f9230b;
        if (c1291d != null) {
            return c1291d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1291d c1291d = this.f9230b;
        if (c1291d != null) {
            return c1291d.d();
        }
        return null;
    }

    @Override // androidx.core.widget.k
    public ColorStateList getSupportButtonTintList() {
        C1294g c1294g = this.f9229a;
        if (c1294g != null) {
            return c1294g.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        C1294g c1294g = this.f9229a;
        if (c1294g != null) {
            return c1294g.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f9231c.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f9231c.k();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().d(z10);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1291d c1291d = this.f9230b;
        if (c1291d != null) {
            c1291d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        C1291d c1291d = this.f9230b;
        if (c1291d != null) {
            c1291d.g(i10);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        C1294g c1294g = this.f9229a;
        if (c1294g != null) {
            c1294g.e();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C1309w c1309w = this.f9231c;
        if (c1309w != null) {
            c1309w.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C1309w c1309w = this.f9231c;
        if (c1309w != null) {
            c1309w.p();
        }
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().e(z10);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C1291d c1291d = this.f9230b;
        if (c1291d != null) {
            c1291d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C1291d c1291d = this.f9230b;
        if (c1291d != null) {
            c1291d.j(mode);
        }
    }

    @Override // androidx.core.widget.k
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        C1294g c1294g = this.f9229a;
        if (c1294g != null) {
            c1294g.f(colorStateList);
        }
    }

    @Override // androidx.core.widget.k
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        C1294g c1294g = this.f9229a;
        if (c1294g != null) {
            c1294g.g(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f9231c.w(colorStateList);
        this.f9231c.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f9231c.x(mode);
        this.f9231c.b();
    }

    public C1304q(Context context, AttributeSet attributeSet, int i10) {
        super(Q.b(context), attributeSet, i10);
        O.a(this, getContext());
        C1294g c1294g = new C1294g(this);
        this.f9229a = c1294g;
        c1294g.d(attributeSet, i10);
        C1291d c1291d = new C1291d(this);
        this.f9230b = c1291d;
        c1291d.e(attributeSet, i10);
        C1309w c1309w = new C1309w(this);
        this.f9231c = c1309w;
        c1309w.m(attributeSet, i10);
        getEmojiTextViewHelper().c(attributeSet, i10);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i10) {
        setButtonDrawable(C4027a.b(getContext(), i10));
    }
}
