package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import e.EnumC0546d;

/* renamed from: androidx.appcompat.widget.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0226t extends AutoCompleteTextView {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f3160d = {R.attr.popupBackground};

    /* renamed from: a, reason: collision with root package name */
    public final C0228u f3161a;

    /* renamed from: b, reason: collision with root package name */
    public final C0192b0 f3162b;

    /* renamed from: c, reason: collision with root package name */
    public final B0.c f3163c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0226t(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet, com.stepos.alphame.R.attr.autoCompleteTextViewStyle);
        W0.a(context);
        V0.a(getContext(), this);
        android.support.v4.media.session.c cVarY = android.support.v4.media.session.c.y(com.stepos.alphame.R.attr.autoCompleteTextViewStyle, 0, getContext(), attributeSet, f3160d);
        if (cVarY.v(0)) {
            setDropDownBackgroundDrawable(cVarY.l(0));
        }
        cVarY.A();
        C0228u c0228u = new C0228u(this);
        this.f3161a = c0228u;
        c0228u.d(attributeSet, com.stepos.alphame.R.attr.autoCompleteTextViewStyle);
        C0192b0 c0192b0 = new C0192b0(this);
        this.f3162b = c0192b0;
        c0192b0.f(attributeSet, com.stepos.alphame.R.attr.autoCompleteTextViewStyle);
        c0192b0.b();
        B0.c cVar = new B0.c(this);
        this.f3163c = cVar;
        cVar.j(attributeSet, com.stepos.alphame.R.attr.autoCompleteTextViewStyle);
        KeyListener keyListener = getKeyListener();
        if (!(keyListener instanceof NumberKeyListener)) {
            boolean zIsFocusable = super.isFocusable();
            boolean zIsClickable = super.isClickable();
            boolean zIsLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener keyListenerG = cVar.g(keyListener);
            if (keyListenerG == keyListener) {
                return;
            }
            super.setKeyListener(keyListenerG);
            super.setRawInputType(inputType);
            super.setFocusable(zIsFocusable);
            super.setClickable(zIsClickable);
            super.setLongClickable(zIsLongClickable);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0228u c0228u = this.f3161a;
        if (c0228u != null) {
            c0228u.a();
        }
        C0192b0 c0192b0 = this.f3162b;
        if (c0192b0 != null) {
            c0192b0.b();
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
        C0228u c0228u = this.f3161a;
        if (c0228u != null) {
            return c0228u.b();
        }
        return null;
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0228u c0228u = this.f3161a;
        if (c0228u != null) {
            return c0228u.c();
        }
        return null;
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f3162b.d();
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f3162b.e();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        t0.J.B(this, editorInfo, inputConnectionOnCreateInputConnection);
        return this.f3163c.k(inputConnectionOnCreateInputConnection, editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0228u c0228u = this.f3161a;
        if (c0228u != null) {
            c0228u.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i4) {
        super.setBackgroundResource(i4);
        C0228u c0228u = this.f3161a;
        if (c0228u != null) {
            c0228u.f(i4);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0192b0 c0192b0 = this.f3162b;
        if (c0192b0 != null) {
            c0192b0.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0192b0 c0192b0 = this.f3162b;
        if (c0192b0 != null) {
            c0192b0.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(@Nullable ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(callback);
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(@DrawableRes int i4) {
        setDropDownBackgroundDrawable(Z2.I.o(getContext(), i4));
    }

    public void setEmojiCompatEnabled(boolean z4) {
        ((Z.b) this.f3163c.f137b).f2126a.n(z4);
    }

    @Override // android.widget.TextView
    public void setKeyListener(@Nullable KeyListener keyListener) {
        super.setKeyListener(this.f3163c.g(keyListener));
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        C0228u c0228u = this.f3161a;
        if (c0228u != null) {
            c0228u.h(colorStateList);
        }
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        C0228u c0228u = this.f3161a;
        if (c0228u != null) {
            c0228u.i(mode);
        }
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList colorStateList) {
        C0192b0 c0192b0 = this.f3162b;
        c0192b0.h(colorStateList);
        c0192b0.b();
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode mode) {
        C0192b0 c0192b0 = this.f3162b;
        c0192b0.i(mode);
        c0192b0.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i4) {
        super.setTextAppearance(context, i4);
        C0192b0 c0192b0 = this.f3162b;
        if (c0192b0 != null) {
            c0192b0.g(i4, context);
        }
    }
}
