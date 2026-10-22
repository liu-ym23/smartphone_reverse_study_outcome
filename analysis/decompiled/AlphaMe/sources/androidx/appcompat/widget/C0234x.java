package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.stepos.alphame.R;
import e.EnumC0546d;

/* renamed from: androidx.appcompat.widget.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0234x extends CheckedTextView {

    /* renamed from: a, reason: collision with root package name */
    public final C0236y f3192a;

    /* renamed from: b, reason: collision with root package name */
    public final C0228u f3193b;

    /* renamed from: c, reason: collision with root package name */
    public final C0192b0 f3194c;

    /* renamed from: d, reason: collision with root package name */
    public D f3195d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0234x(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet, R.attr.checkedTextViewStyle);
        W0.a(context);
        V0.a(getContext(), this);
        C0192b0 c0192b0 = new C0192b0(this);
        this.f3194c = c0192b0;
        c0192b0.f(attributeSet, R.attr.checkedTextViewStyle);
        c0192b0.b();
        C0228u c0228u = new C0228u(this);
        this.f3193b = c0228u;
        c0228u.d(attributeSet, R.attr.checkedTextViewStyle);
        C0236y c0236y = new C0236y(this, 0);
        this.f3192a = c0236y;
        c0236y.c(attributeSet, R.attr.checkedTextViewStyle);
        getEmojiTextViewHelper().b(attributeSet, R.attr.checkedTextViewStyle);
    }

    @NonNull
    private D getEmojiTextViewHelper() {
        if (this.f3195d == null) {
            this.f3195d = new D(this);
        }
        return this.f3195d;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0192b0 c0192b0 = this.f3194c;
        if (c0192b0 != null) {
            c0192b0.b();
        }
        C0228u c0228u = this.f3193b;
        if (c0228u != null) {
            c0228u.a();
        }
        C0236y c0236y = this.f3192a;
        if (c0236y != null) {
            c0236y.b();
        }
    }

    @Override // android.widget.TextView
    @Nullable
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return super.getCustomSelectionActionModeCallback();
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public ColorStateList getSupportBackgroundTintList() {
        C0228u c0228u = this.f3193b;
        if (c0228u != null) {
            return c0228u.b();
        }
        return null;
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0228u c0228u = this.f3193b;
        if (c0228u != null) {
            return c0228u.c();
        }
        return null;
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public ColorStateList getSupportCheckMarkTintList() {
        C0236y c0236y = this.f3192a;
        if (c0236y != null) {
            return c0236y.f3206b;
        }
        return null;
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        C0236y c0236y = this.f3192a;
        if (c0236y != null) {
            return c0236y.f3207c;
        }
        return null;
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f3194c.d();
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f3194c.e();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        t0.J.B(this, editorInfo, inputConnectionOnCreateInputConnection);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z4) {
        super.setAllCaps(z4);
        getEmojiTextViewHelper().c(z4);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0228u c0228u = this.f3193b;
        if (c0228u != null) {
            c0228u.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i4) {
        super.setBackgroundResource(i4);
        C0228u c0228u = this.f3193b;
        if (c0228u != null) {
            c0228u.f(i4);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(@Nullable Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        C0236y c0236y = this.f3192a;
        if (c0236y != null) {
            if (c0236y.f3210f) {
                c0236y.f3210f = false;
            } else {
                c0236y.f3210f = true;
                c0236y.b();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0192b0 c0192b0 = this.f3194c;
        if (c0192b0 != null) {
            c0192b0.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0192b0 c0192b0 = this.f3194c;
        if (c0192b0 != null) {
            c0192b0.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(@Nullable ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(callback);
    }

    public void setEmojiCompatEnabled(boolean z4) {
        getEmojiTextViewHelper().d(z4);
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        C0228u c0228u = this.f3193b;
        if (c0228u != null) {
            c0228u.h(colorStateList);
        }
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        C0228u c0228u = this.f3193b;
        if (c0228u != null) {
            c0228u.i(mode);
        }
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportCheckMarkTintList(@Nullable ColorStateList colorStateList) {
        C0236y c0236y = this.f3192a;
        if (c0236y != null) {
            c0236y.f3206b = colorStateList;
            c0236y.f3208d = true;
            c0236y.b();
        }
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportCheckMarkTintMode(@Nullable PorterDuff.Mode mode) {
        C0236y c0236y = this.f3192a;
        if (c0236y != null) {
            c0236y.f3207c = mode;
            c0236y.f3209e = true;
            c0236y.b();
        }
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList colorStateList) {
        C0192b0 c0192b0 = this.f3194c;
        c0192b0.h(colorStateList);
        c0192b0.b();
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode mode) {
        C0192b0 c0192b0 = this.f3194c;
        c0192b0.i(mode);
        c0192b0.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i4) {
        super.setTextAppearance(context, i4);
        C0192b0 c0192b0 = this.f3194c;
        if (c0192b0 != null) {
            c0192b0.g(i4, context);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(@DrawableRes int i4) {
        setCheckMarkDrawable(Z2.I.o(getContext(), i4));
    }
}
