package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.core.view.InterfaceC0480z;
import g.C0728a;

/* renamed from: androidx.appcompat.widget.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0442l extends EditText implements InterfaceC0480z {

    /* renamed from: a, reason: collision with root package name */
    private final C0435e f8581a;

    /* renamed from: b, reason: collision with root package name */
    private final C f8582b;

    /* renamed from: c, reason: collision with root package name */
    private final B f8583c;

    /* renamed from: d, reason: collision with root package name */
    private final androidx.core.widget.j f8584d;

    /* renamed from: e, reason: collision with root package name */
    private final C0443m f8585e;

    /* renamed from: f, reason: collision with root package name */
    private a f8586f;

    /* renamed from: androidx.appcompat.widget.l$a */
    class a {
        a() {
        }

        public TextClassifier a() {
            return C0442l.super.getTextClassifier();
        }

        public void b(TextClassifier textClassifier) {
            C0442l.super.setTextClassifier(textClassifier);
        }
    }

    public C0442l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0728a.f16809F);
    }

    private a getSuperCaller() {
        if (this.f8586f == null) {
            this.f8586f = new a();
        }
        return this.f8586f;
    }

    void c(C0443m c0443m) {
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
        C0435e c0435e = this.f8581a;
        if (c0435e != null) {
            c0435e.b();
        }
        C c6 = this.f8582b;
        if (c6 != null) {
            c6.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.i.o(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0435e c0435e = this.f8581a;
        if (c0435e != null) {
            return c0435e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0435e c0435e = this.f8581a;
        if (c0435e != null) {
            return c0435e.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f8582b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f8582b.k();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        return getSuperCaller().a();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f8582b.r(this, inputConnectionOnCreateInputConnection, editorInfo);
        return this.f8585e.d(C0445o.a(inputConnectionOnCreateInputConnection, editorInfo, this), editorInfo);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onDragEvent(DragEvent dragEvent) {
        if (C0453x.a(this, dragEvent)) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i5) {
        if (C0453x.b(this, i5)) {
            return true;
        }
        return super.onTextContextMenuItem(i5);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0435e c0435e = this.f8581a;
        if (c0435e != null) {
            c0435e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        C0435e c0435e = this.f8581a;
        if (c0435e != null) {
            c0435e.g(i5);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C c6 = this.f8582b;
        if (c6 != null) {
            c6.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C c6 = this.f8582b;
        if (c6 != null) {
            c6.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.p(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z5) {
        this.f8585e.e(z5);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f8585e.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0435e c0435e = this.f8581a;
        if (c0435e != null) {
            c0435e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0435e c0435e = this.f8581a;
        if (c0435e != null) {
            c0435e.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f8582b.w(colorStateList);
        this.f8582b.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f8582b.x(mode);
        this.f8582b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i5) {
        super.setTextAppearance(context, i5);
        C c6 = this.f8582b;
        if (c6 != null) {
            c6.q(context, i5);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        getSuperCaller().b(textClassifier);
    }

    public C0442l(Context context, AttributeSet attributeSet, int i5) {
        super(X.b(context), attributeSet, i5);
        V.a(this, getContext());
        C0435e c0435e = new C0435e(this);
        this.f8581a = c0435e;
        c0435e.e(attributeSet, i5);
        C c6 = new C(this);
        this.f8582b = c6;
        c6.m(attributeSet, i5);
        c6.b();
        this.f8583c = new B(this);
        this.f8584d = new androidx.core.widget.j();
        C0443m c0443m = new C0443m(this);
        this.f8585e = c0443m;
        c0443m.c(attributeSet, i5);
        c(c0443m);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return super.getText();
    }
}
