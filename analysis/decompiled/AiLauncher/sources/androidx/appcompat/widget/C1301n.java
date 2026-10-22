package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import androidx.appcompat.R$attr;
import f.C4027a;

/* renamed from: androidx.appcompat.widget.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1301n extends MultiAutoCompleteTextView {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f9220d = {R.attr.popupBackground};

    /* renamed from: a, reason: collision with root package name */
    public final C1291d f9221a;

    /* renamed from: b, reason: collision with root package name */
    public final C1309w f9222b;

    /* renamed from: c, reason: collision with root package name */
    public final C1296i f9223c;

    public C1301n(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.autoCompleteTextViewStyle);
    }

    public void a(C1296i c1296i) {
        KeyListener keyListener = getKeyListener();
        if (c1296i.b(keyListener)) {
            boolean zIsFocusable = super.isFocusable();
            boolean zIsClickable = super.isClickable();
            boolean zIsLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener keyListenerA = c1296i.a(keyListener);
            if (keyListenerA == keyListener) {
                return;
            }
            super.setKeyListener(keyListenerA);
            super.setRawInputType(inputType);
            super.setFocusable(zIsFocusable);
            super.setClickable(zIsClickable);
            super.setLongClickable(zIsLongClickable);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C1291d c1291d = this.f9221a;
        if (c1291d != null) {
            c1291d.b();
        }
        C1309w c1309w = this.f9222b;
        if (c1309w != null) {
            c1309w.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1291d c1291d = this.f9221a;
        if (c1291d != null) {
            return c1291d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1291d c1291d = this.f9221a;
        if (c1291d != null) {
            return c1291d.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f9222b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f9222b.k();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.f9223c.e(C1298k.a(super.onCreateInputConnection(editorInfo), editorInfo, this), editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1291d c1291d = this.f9221a;
        if (c1291d != null) {
            c1291d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        C1291d c1291d = this.f9221a;
        if (c1291d != null) {
            c1291d.g(i10);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C1309w c1309w = this.f9222b;
        if (c1309w != null) {
            c1309w.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C1309w c1309w = this.f9222b;
        if (c1309w != null) {
            c1309w.p();
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i10) {
        setDropDownBackgroundDrawable(C4027a.b(getContext(), i10));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        this.f9223c.f(z10);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f9223c.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C1291d c1291d = this.f9221a;
        if (c1291d != null) {
            c1291d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C1291d c1291d = this.f9221a;
        if (c1291d != null) {
            c1291d.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f9222b.w(colorStateList);
        this.f9222b.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f9222b.x(mode);
        this.f9222b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        C1309w c1309w = this.f9222b;
        if (c1309w != null) {
            c1309w.q(context, i10);
        }
    }

    public C1301n(Context context, AttributeSet attributeSet, int i10) {
        super(Q.b(context), attributeSet, i10);
        O.a(this, getContext());
        U uV = U.v(getContext(), attributeSet, f9220d, i10, 0);
        if (uV.s(0)) {
            setDropDownBackgroundDrawable(uV.g(0));
        }
        uV.x();
        C1291d c1291d = new C1291d(this);
        this.f9221a = c1291d;
        c1291d.e(attributeSet, i10);
        C1309w c1309w = new C1309w(this);
        this.f9222b = c1309w;
        c1309w.m(attributeSet, i10);
        c1309w.b();
        C1296i c1296i = new C1296i(this);
        this.f9223c = c1296i;
        c1296i.d(attributeSet, i10);
        a(c1296i);
    }
}
