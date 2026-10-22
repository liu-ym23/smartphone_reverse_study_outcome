package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.stepos.alphame.R;
import e.EnumC0546d;

/* loaded from: classes.dex */
public class K extends RadioButton implements androidx.core.widget.o {

    /* renamed from: a, reason: collision with root package name */
    public final C0236y f2854a;

    /* renamed from: b, reason: collision with root package name */
    public final C0228u f2855b;

    /* renamed from: c, reason: collision with root package name */
    public final C0192b0 f2856c;

    /* renamed from: d, reason: collision with root package name */
    public D f2857d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet, R.attr.radioButtonStyle);
        W0.a(context);
        V0.a(getContext(), this);
        C0236y c0236y = new C0236y(this, 1);
        this.f2854a = c0236y;
        c0236y.c(attributeSet, R.attr.radioButtonStyle);
        C0228u c0228u = new C0228u(this);
        this.f2855b = c0228u;
        c0228u.d(attributeSet, R.attr.radioButtonStyle);
        C0192b0 c0192b0 = new C0192b0(this);
        this.f2856c = c0192b0;
        c0192b0.f(attributeSet, R.attr.radioButtonStyle);
        getEmojiTextViewHelper().b(attributeSet, R.attr.radioButtonStyle);
    }

    @NonNull
    private D getEmojiTextViewHelper() {
        if (this.f2857d == null) {
            this.f2857d = new D(this);
        }
        return this.f2857d;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0228u c0228u = this.f2855b;
        if (c0228u != null) {
            c0228u.a();
        }
        C0192b0 c0192b0 = this.f2856c;
        if (c0192b0 != null) {
            c0192b0.b();
        }
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public ColorStateList getSupportBackgroundTintList() {
        C0228u c0228u = this.f2855b;
        if (c0228u != null) {
            return c0228u.b();
        }
        return null;
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0228u c0228u = this.f2855b;
        if (c0228u != null) {
            return c0228u.c();
        }
        return null;
    }

    @Override // androidx.core.widget.o
    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public ColorStateList getSupportButtonTintList() {
        C0236y c0236y = this.f2854a;
        if (c0236y != null) {
            return c0236y.f3206b;
        }
        return null;
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public PorterDuff.Mode getSupportButtonTintMode() {
        C0236y c0236y = this.f2854a;
        if (c0236y != null) {
            return c0236y.f3207c;
        }
        return null;
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f2856c.d();
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f2856c.e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z4) {
        super.setAllCaps(z4);
        getEmojiTextViewHelper().c(z4);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0228u c0228u = this.f2855b;
        if (c0228u != null) {
            c0228u.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i4) {
        super.setBackgroundResource(i4);
        C0228u c0228u = this.f2855b;
        if (c0228u != null) {
            c0228u.f(i4);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        C0236y c0236y = this.f2854a;
        if (c0236y != null) {
            if (c0236y.f3210f) {
                c0236y.f3210f = false;
            } else {
                c0236y.f3210f = true;
                c0236y.a();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0192b0 c0192b0 = this.f2856c;
        if (c0192b0 != null) {
            c0192b0.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0192b0 c0192b0 = this.f2856c;
        if (c0192b0 != null) {
            c0192b0.b();
        }
    }

    public void setEmojiCompatEnabled(boolean z4) {
        getEmojiTextViewHelper().d(z4);
    }

    @Override // android.widget.TextView
    public void setFilters(@NonNull InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        C0228u c0228u = this.f2855b;
        if (c0228u != null) {
            c0228u.h(colorStateList);
        }
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        C0228u c0228u = this.f2855b;
        if (c0228u != null) {
            c0228u.i(mode);
        }
    }

    @Override // androidx.core.widget.o
    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportButtonTintList(@Nullable ColorStateList colorStateList) {
        C0236y c0236y = this.f2854a;
        if (c0236y != null) {
            c0236y.f3206b = colorStateList;
            c0236y.f3208d = true;
            c0236y.a();
        }
    }

    @Override // androidx.core.widget.o
    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportButtonTintMode(@Nullable PorterDuff.Mode mode) {
        C0236y c0236y = this.f2854a;
        if (c0236y != null) {
            c0236y.f3207c = mode;
            c0236y.f3209e = true;
            c0236y.a();
        }
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList colorStateList) {
        C0192b0 c0192b0 = this.f2856c;
        c0192b0.h(colorStateList);
        c0192b0.b();
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode mode) {
        C0192b0 c0192b0 = this.f2856c;
        c0192b0.i(mode);
        c0192b0.b();
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(@DrawableRes int i4) {
        setButtonDrawable(Z2.I.o(getContext(), i4));
    }
}
