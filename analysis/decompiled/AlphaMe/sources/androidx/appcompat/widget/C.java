package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import com.stepos.alphame.R;
import e.EnumC0546d;

/* loaded from: classes.dex */
public class C extends EditText {

    /* renamed from: a, reason: collision with root package name */
    public final C0228u f2804a;

    /* renamed from: b, reason: collision with root package name */
    public final C0192b0 f2805b;

    /* renamed from: c, reason: collision with root package name */
    public final B0.c f2806c;

    /* renamed from: d, reason: collision with root package name */
    public B f2807d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet, R.attr.editTextStyle);
        W0.a(context);
        V0.a(getContext(), this);
        C0228u c0228u = new C0228u(this);
        this.f2804a = c0228u;
        c0228u.d(attributeSet, R.attr.editTextStyle);
        C0192b0 c0192b0 = new C0192b0(this);
        this.f2805b = c0192b0;
        c0192b0.f(attributeSet, R.attr.editTextStyle);
        c0192b0.b();
        B0.c cVar = new B0.c(this);
        this.f2806c = cVar;
        cVar.j(attributeSet, R.attr.editTextStyle);
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

    @NonNull
    @RequiresApi(26)
    @UiThread
    private B getSuperCaller() {
        if (this.f2807d == null) {
            this.f2807d = new B(this);
        }
        return this.f2807d;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0228u c0228u = this.f2804a;
        if (c0228u != null) {
            c0228u.a();
        }
        C0192b0 c0192b0 = this.f2805b;
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
        C0228u c0228u = this.f2804a;
        if (c0228u != null) {
            return c0228u.b();
        }
        return null;
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0228u c0228u = this.f2804a;
        if (c0228u != null) {
            return c0228u.c();
        }
        return null;
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f2805b.d();
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f2805b.e();
    }

    @Override // android.widget.TextView
    @NonNull
    @RequiresApi(api = 26)
    public TextClassifier getTextClassifier() {
        return super.getTextClassifier();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f2805b.getClass();
        t0.J.B(this, editorInfo, inputConnectionOnCreateInputConnection);
        return this.f2806c.k(inputConnectionOnCreateInputConnection, editorInfo);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onDragEvent(DragEvent dragEvent) {
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int i4) {
        return super.onTextContextMenuItem(i4);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0228u c0228u = this.f2804a;
        if (c0228u != null) {
            c0228u.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i4) {
        super.setBackgroundResource(i4);
        C0228u c0228u = this.f2804a;
        if (c0228u != null) {
            c0228u.f(i4);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0192b0 c0192b0 = this.f2805b;
        if (c0192b0 != null) {
            c0192b0.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0192b0 c0192b0 = this.f2805b;
        if (c0192b0 != null) {
            c0192b0.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(@Nullable ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(callback);
    }

    public void setEmojiCompatEnabled(boolean z4) {
        ((Z.b) this.f2806c.f137b).f2126a.n(z4);
    }

    @Override // android.widget.TextView
    public void setKeyListener(@Nullable KeyListener keyListener) {
        super.setKeyListener(this.f2806c.g(keyListener));
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        C0228u c0228u = this.f2804a;
        if (c0228u != null) {
            c0228u.h(colorStateList);
        }
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        C0228u c0228u = this.f2804a;
        if (c0228u != null) {
            c0228u.i(mode);
        }
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList colorStateList) {
        C0192b0 c0192b0 = this.f2805b;
        c0192b0.h(colorStateList);
        c0192b0.b();
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode mode) {
        C0192b0 c0192b0 = this.f2805b;
        c0192b0.i(mode);
        c0192b0.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i4) {
        super.setTextAppearance(context, i4);
        C0192b0 c0192b0 = this.f2805b;
        if (c0192b0 != null) {
            c0192b0.g(i4, context);
        }
    }

    @Override // android.widget.TextView
    @RequiresApi(api = 26)
    public void setTextClassifier(@Nullable TextClassifier textClassifier) {
        super.setTextClassifier(textClassifier);
    }

    @Override // android.widget.EditText, android.widget.TextView
    @Nullable
    public Editable getText() {
        return super.getText();
    }
}
