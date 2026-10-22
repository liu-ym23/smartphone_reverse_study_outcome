package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.ToggleButton;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import e.EnumC0546d;

/* renamed from: androidx.appcompat.widget.k0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0210k0 extends ToggleButton {

    /* renamed from: a, reason: collision with root package name */
    public final C0228u f3118a;

    /* renamed from: b, reason: collision with root package name */
    public final C0192b0 f3119b;

    /* renamed from: c, reason: collision with root package name */
    public D f3120c;

    public C0210k0(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet, R.attr.buttonStyleToggle);
        V0.a(getContext(), this);
        C0228u c0228u = new C0228u(this);
        this.f3118a = c0228u;
        c0228u.d(attributeSet, R.attr.buttonStyleToggle);
        C0192b0 c0192b0 = new C0192b0(this);
        this.f3119b = c0192b0;
        c0192b0.f(attributeSet, R.attr.buttonStyleToggle);
        getEmojiTextViewHelper().b(attributeSet, R.attr.buttonStyleToggle);
    }

    @NonNull
    private D getEmojiTextViewHelper() {
        if (this.f3120c == null) {
            this.f3120c = new D(this);
        }
        return this.f3120c;
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0228u c0228u = this.f3118a;
        if (c0228u != null) {
            c0228u.a();
        }
        C0192b0 c0192b0 = this.f3119b;
        if (c0192b0 != null) {
            c0192b0.b();
        }
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public ColorStateList getSupportBackgroundTintList() {
        C0228u c0228u = this.f3118a;
        if (c0228u != null) {
            return c0228u.b();
        }
        return null;
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0228u c0228u = this.f3118a;
        if (c0228u != null) {
            return c0228u.c();
        }
        return null;
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f3119b.d();
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f3119b.e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z4) {
        super.setAllCaps(z4);
        getEmojiTextViewHelper().c(z4);
    }

    @Override // android.widget.ToggleButton, android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0228u c0228u = this.f3118a;
        if (c0228u != null) {
            c0228u.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i4) {
        super.setBackgroundResource(i4);
        C0228u c0228u = this.f3118a;
        if (c0228u != null) {
            c0228u.f(i4);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0192b0 c0192b0 = this.f3119b;
        if (c0192b0 != null) {
            c0192b0.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0192b0 c0192b0 = this.f3119b;
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
        C0228u c0228u = this.f3118a;
        if (c0228u != null) {
            c0228u.h(colorStateList);
        }
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        C0228u c0228u = this.f3118a;
        if (c0228u != null) {
            c0228u.i(mode);
        }
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList colorStateList) {
        C0192b0 c0192b0 = this.f3119b;
        c0192b0.h(colorStateList);
        c0192b0.b();
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode mode) {
        C0192b0 c0192b0 = this.f3119b;
        c0192b0.i(mode);
        c0192b0.b();
    }
}
