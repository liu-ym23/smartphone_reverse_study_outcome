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
import g.C0728a;
import h.C0744a;

/* renamed from: androidx.appcompat.widget.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0448s extends MultiAutoCompleteTextView {

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f8603d = {R.attr.popupBackground};

    /* renamed from: a, reason: collision with root package name */
    private final C0435e f8604a;

    /* renamed from: b, reason: collision with root package name */
    private final C f8605b;

    /* renamed from: c, reason: collision with root package name */
    private final C0443m f8606c;

    public C0448s(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0728a.f16841r);
    }

    void a(C0443m c0443m) {
        KeyListener keyListener = getKeyListener();
        if (c0443m.b(keyListener)) {
            boolean zIsFocusable = super.isFocusable();
            boolean zIsClickable = super.isClickable();
            boolean zIsLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener keyListenerA = c0443m.a(keyListener);
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
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0435e c0435e = this.f8604a;
        if (c0435e != null) {
            c0435e.b();
        }
        C c6 = this.f8605b;
        if (c6 != null) {
            c6.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0435e c0435e = this.f8604a;
        if (c0435e != null) {
            return c0435e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0435e c0435e = this.f8604a;
        if (c0435e != null) {
            return c0435e.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f8605b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f8605b.k();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.f8606c.d(C0445o.a(super.onCreateInputConnection(editorInfo), editorInfo, this), editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0435e c0435e = this.f8604a;
        if (c0435e != null) {
            c0435e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        C0435e c0435e = this.f8604a;
        if (c0435e != null) {
            c0435e.g(i5);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C c6 = this.f8605b;
        if (c6 != null) {
            c6.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C c6 = this.f8605b;
        if (c6 != null) {
            c6.p();
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i5) {
        setDropDownBackgroundDrawable(C0744a.b(getContext(), i5));
    }

    public void setEmojiCompatEnabled(boolean z5) {
        this.f8606c.e(z5);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f8606c.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0435e c0435e = this.f8604a;
        if (c0435e != null) {
            c0435e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0435e c0435e = this.f8604a;
        if (c0435e != null) {
            c0435e.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f8605b.w(colorStateList);
        this.f8605b.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f8605b.x(mode);
        this.f8605b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i5) {
        super.setTextAppearance(context, i5);
        C c6 = this.f8605b;
        if (c6 != null) {
            c6.q(context, i5);
        }
    }

    public C0448s(Context context, AttributeSet attributeSet, int i5) {
        super(X.b(context), attributeSet, i5);
        V.a(this, getContext());
        a0 a0VarV = a0.v(getContext(), attributeSet, f8603d, i5, 0);
        if (a0VarV.s(0)) {
            setDropDownBackgroundDrawable(a0VarV.g(0));
        }
        a0VarV.x();
        C0435e c0435e = new C0435e(this);
        this.f8604a = c0435e;
        c0435e.e(attributeSet, i5);
        C c6 = new C(this);
        this.f8605b = c6;
        c6.m(attributeSet, i5);
        c6.b();
        C0443m c0443m = new C0443m(this);
        this.f8606c = c0443m;
        c0443m.c(attributeSet, i5);
        a(c0443m);
    }
}
