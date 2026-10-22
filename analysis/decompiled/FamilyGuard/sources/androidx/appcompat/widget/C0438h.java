package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import g.C0728a;
import h.C0744a;

/* renamed from: androidx.appcompat.widget.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0438h extends CheckedTextView {

    /* renamed from: a, reason: collision with root package name */
    private final C0439i f8555a;

    /* renamed from: b, reason: collision with root package name */
    private final C0435e f8556b;

    /* renamed from: c, reason: collision with root package name */
    private final C f8557c;

    /* renamed from: d, reason: collision with root package name */
    private C0444n f8558d;

    public C0438h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0728a.f16844u);
    }

    private C0444n getEmojiTextViewHelper() {
        if (this.f8558d == null) {
            this.f8558d = new C0444n(this);
        }
        return this.f8558d;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C c6 = this.f8557c;
        if (c6 != null) {
            c6.b();
        }
        C0435e c0435e = this.f8556b;
        if (c0435e != null) {
            c0435e.b();
        }
        C0439i c0439i = this.f8555a;
        if (c0439i != null) {
            c0439i.a();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.i.o(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0435e c0435e = this.f8556b;
        if (c0435e != null) {
            return c0435e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0435e c0435e = this.f8556b;
        if (c0435e != null) {
            return c0435e.d();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        C0439i c0439i = this.f8555a;
        if (c0439i != null) {
            return c0439i.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        C0439i c0439i = this.f8555a;
        if (c0439i != null) {
            return c0439i.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f8557c.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f8557c.k();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return C0445o.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z5) {
        super.setAllCaps(z5);
        getEmojiTextViewHelper().d(z5);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0435e c0435e = this.f8556b;
        if (c0435e != null) {
            c0435e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        C0435e c0435e = this.f8556b;
        if (c0435e != null) {
            c0435e.g(i5);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        C0439i c0439i = this.f8555a;
        if (c0439i != null) {
            c0439i.e();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C c6 = this.f8557c;
        if (c6 != null) {
            c6.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C c6 = this.f8557c;
        if (c6 != null) {
            c6.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.p(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z5) {
        getEmojiTextViewHelper().e(z5);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0435e c0435e = this.f8556b;
        if (c0435e != null) {
            c0435e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0435e c0435e = this.f8556b;
        if (c0435e != null) {
            c0435e.j(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        C0439i c0439i = this.f8555a;
        if (c0439i != null) {
            c0439i.f(colorStateList);
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        C0439i c0439i = this.f8555a;
        if (c0439i != null) {
            c0439i.g(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f8557c.w(colorStateList);
        this.f8557c.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f8557c.x(mode);
        this.f8557c.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i5) {
        super.setTextAppearance(context, i5);
        C c6 = this.f8557c;
        if (c6 != null) {
            c6.q(context, i5);
        }
    }

    public C0438h(Context context, AttributeSet attributeSet, int i5) {
        super(X.b(context), attributeSet, i5);
        V.a(this, getContext());
        C c6 = new C(this);
        this.f8557c = c6;
        c6.m(attributeSet, i5);
        c6.b();
        C0435e c0435e = new C0435e(this);
        this.f8556b = c0435e;
        c0435e.e(attributeSet, i5);
        C0439i c0439i = new C0439i(this);
        this.f8555a = c0439i;
        c0439i.d(attributeSet, i5);
        getEmojiTextViewHelper().c(attributeSet, i5);
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i5) {
        setCheckMarkDrawable(C0744a.b(getContext(), i5));
    }
}
