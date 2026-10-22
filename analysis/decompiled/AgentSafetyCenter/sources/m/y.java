package m;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y extends MultiAutoCompleteTextView {

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f8139h = {R.attr.popupBackground};

    /* renamed from: c, reason: collision with root package name */
    public final ed.o f8140c;

    /* renamed from: f, reason: collision with root package name */
    public final s0 f8141f;

    /* renamed from: g, reason: collision with root package name */
    public final a0 f8142g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.stepos.agentsafetycenter.R.attr.autoCompleteTextViewStyle);
        m2.a(context);
        l2.a(this, getContext());
        p5.m mVarJ = p5.m.J(getContext(), attributeSet, f8139h, com.stepos.agentsafetycenter.R.attr.autoCompleteTextViewStyle);
        if (((TypedArray) mVarJ.f9742g).hasValue(0)) {
            setDropDownBackgroundDrawable(mVarJ.A(0));
        }
        mVarJ.M();
        ed.o oVar = new ed.o(this);
        this.f8140c = oVar;
        oVar.e(attributeSet, com.stepos.agentsafetycenter.R.attr.autoCompleteTextViewStyle);
        s0 s0Var = new s0(this);
        this.f8141f = s0Var;
        s0Var.f(attributeSet, com.stepos.agentsafetycenter.R.attr.autoCompleteTextViewStyle);
        s0Var.b();
        a0 a0Var = new a0(this);
        this.f8142g = a0Var;
        a0Var.c(attributeSet, com.stepos.agentsafetycenter.R.attr.autoCompleteTextViewStyle);
        KeyListener keyListener = getKeyListener();
        if (keyListener instanceof NumberKeyListener) {
            return;
        }
        boolean zIsFocusable = isFocusable();
        boolean zIsClickable = isClickable();
        boolean zIsLongClickable = isLongClickable();
        int inputType = getInputType();
        KeyListener keyListenerB = a0Var.b(keyListener);
        if (keyListenerB == keyListener) {
            return;
        }
        super.setKeyListener(keyListenerB);
        setRawInputType(inputType);
        setFocusable(zIsFocusable);
        setClickable(zIsClickable);
        setLongClickable(zIsLongClickable);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        ed.o oVar = this.f8140c;
        if (oVar != null) {
            oVar.a();
        }
        s0 s0Var = this.f8141f;
        if (s0Var != null) {
            s0Var.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        ed.o oVar = this.f8140c;
        if (oVar != null) {
            return oVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        ed.o oVar = this.f8140c;
        if (oVar != null) {
            return oVar.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f8141f.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f8141f.e();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        ac.a.K(inputConnectionOnCreateInputConnection, editorInfo, this);
        return this.f8142g.d(inputConnectionOnCreateInputConnection, editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        ed.o oVar = this.f8140c;
        if (oVar != null) {
            oVar.f();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        ed.o oVar = this.f8140c;
        if (oVar != null) {
            oVar.g(i);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        s0 s0Var = this.f8141f;
        if (s0Var != null) {
            s0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        s0 s0Var = this.f8141f;
        if (s0Var != null) {
            s0Var.b();
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(id.k.v(i, getContext()));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        this.f8142g.e(z10);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f8142g.b(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        ed.o oVar = this.f8140c;
        if (oVar != null) {
            oVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        ed.o oVar = this.f8140c;
        if (oVar != null) {
            oVar.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        s0 s0Var = this.f8141f;
        s0Var.h(colorStateList);
        s0Var.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        s0 s0Var = this.f8141f;
        s0Var.i(mode);
        s0Var.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        s0 s0Var = this.f8141f;
        if (s0Var != null) {
            s0Var.g(i, context);
        }
    }
}
