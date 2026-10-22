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
import androidx.appcompat.R$attr;
import f.C4027a;

/* renamed from: androidx.appcompat.widget.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1292e extends CheckedTextView {

    /* renamed from: a, reason: collision with root package name */
    public final C1293f f9186a;

    /* renamed from: b, reason: collision with root package name */
    public final C1291d f9187b;

    /* renamed from: c, reason: collision with root package name */
    public final C1309w f9188c;

    /* renamed from: d, reason: collision with root package name */
    public C1297j f9189d;

    public C1292e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.checkedTextViewStyle);
    }

    private C1297j getEmojiTextViewHelper() {
        if (this.f9189d == null) {
            this.f9189d = new C1297j(this);
        }
        return this.f9189d;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C1309w c1309w = this.f9188c;
        if (c1309w != null) {
            c1309w.b();
        }
        C1291d c1291d = this.f9187b;
        if (c1291d != null) {
            c1291d.b();
        }
        C1293f c1293f = this.f9186a;
        if (c1293f != null) {
            c1293f.a();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.i.o(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1291d c1291d = this.f9187b;
        if (c1291d != null) {
            return c1291d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1291d c1291d = this.f9187b;
        if (c1291d != null) {
            return c1291d.d();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        C1293f c1293f = this.f9186a;
        if (c1293f != null) {
            return c1293f.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        C1293f c1293f = this.f9186a;
        if (c1293f != null) {
            return c1293f.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f9188c.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f9188c.k();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return C1298k.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().d(z10);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1291d c1291d = this.f9187b;
        if (c1291d != null) {
            c1291d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        C1291d c1291d = this.f9187b;
        if (c1291d != null) {
            c1291d.g(i10);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        C1293f c1293f = this.f9186a;
        if (c1293f != null) {
            c1293f.e();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C1309w c1309w = this.f9188c;
        if (c1309w != null) {
            c1309w.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C1309w c1309w = this.f9188c;
        if (c1309w != null) {
            c1309w.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.p(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().e(z10);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C1291d c1291d = this.f9187b;
        if (c1291d != null) {
            c1291d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C1291d c1291d = this.f9187b;
        if (c1291d != null) {
            c1291d.j(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        C1293f c1293f = this.f9186a;
        if (c1293f != null) {
            c1293f.f(colorStateList);
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        C1293f c1293f = this.f9186a;
        if (c1293f != null) {
            c1293f.g(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f9188c.w(colorStateList);
        this.f9188c.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f9188c.x(mode);
        this.f9188c.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        C1309w c1309w = this.f9188c;
        if (c1309w != null) {
            c1309w.q(context, i10);
        }
    }

    public C1292e(Context context, AttributeSet attributeSet, int i10) {
        super(Q.b(context), attributeSet, i10);
        O.a(this, getContext());
        C1309w c1309w = new C1309w(this);
        this.f9188c = c1309w;
        c1309w.m(attributeSet, i10);
        c1309w.b();
        C1291d c1291d = new C1291d(this);
        this.f9187b = c1291d;
        c1291d.e(attributeSet, i10);
        C1293f c1293f = new C1293f(this);
        this.f9186a = c1293f;
        c1293f.d(attributeSet, i10);
        getEmojiTextViewHelper().c(attributeSet, i10);
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i10) {
        setCheckMarkDrawable(C4027a.b(getContext(), i10));
    }
}
