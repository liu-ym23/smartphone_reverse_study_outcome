package g;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class m extends AutoCompleteTextView {
    public static final int[] d = {R.attr.popupBackground};

    /* renamed from: a, reason: collision with root package name */
    public final n f2778a;

    /* renamed from: b, reason: collision with root package name */
    public final d0 f2779b;

    /* renamed from: c, reason: collision with root package name */
    public final androidx.emoji2.text.p f2780c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.stepos.stepclaw.R.attr.autoCompleteTextViewStyle);
        r1.a(context);
        q1.a(this, getContext());
        a4.d dVarE = a4.d.E(getContext(), attributeSet, d, com.stepos.stepclaw.R.attr.autoCompleteTextViewStyle);
        if (((TypedArray) dVarE.f97c).hasValue(0)) {
            setDropDownBackgroundDrawable(dVarE.t(0));
        }
        dVarE.H();
        n nVar = new n(this);
        this.f2778a = nVar;
        nVar.d(attributeSet, com.stepos.stepclaw.R.attr.autoCompleteTextViewStyle);
        d0 d0Var = new d0(this);
        this.f2779b = d0Var;
        d0Var.d(attributeSet, com.stepos.stepclaw.R.attr.autoCompleteTextViewStyle);
        d0Var.b();
        androidx.emoji2.text.p pVar = new androidx.emoji2.text.p(this, 6);
        this.f2780c = pVar;
        pVar.n(attributeSet, com.stepos.stepclaw.R.attr.autoCompleteTextViewStyle);
        KeyListener keyListener = getKeyListener();
        if (keyListener instanceof NumberKeyListener) {
            return;
        }
        boolean zIsFocusable = super.isFocusable();
        boolean zIsClickable = super.isClickable();
        boolean zIsLongClickable = super.isLongClickable();
        int inputType = super.getInputType();
        KeyListener keyListenerL = pVar.l(keyListener);
        if (keyListenerL == keyListener) {
            return;
        }
        super.setKeyListener(keyListenerL);
        super.setRawInputType(inputType);
        super.setFocusable(zIsFocusable);
        super.setClickable(zIsClickable);
        super.setLongClickable(zIsLongClickable);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        n nVar = this.f2778a;
        if (nVar != null) {
            nVar.a();
        }
        d0 d0Var = this.f2779b;
        if (d0Var != null) {
            d0Var.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return super.getCustomSelectionActionModeCallback();
    }

    public ColorStateList getSupportBackgroundTintList() {
        n nVar = this.f2778a;
        if (nVar != null) {
            return nVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        n nVar = this.f2778a;
        if (nVar != null) {
            return nVar.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        s1 s1Var = this.f2779b.f2682h;
        if (s1Var != null) {
            return (ColorStateList) s1Var.f2824c;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        s1 s1Var = this.f2779b.f2682h;
        if (s1Var != null) {
            return (PorterDuff.Mode) s1Var.d;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        a.a.X(inputConnectionOnCreateInputConnection, editorInfo, this);
        return this.f2780c.o(inputConnectionOnCreateInputConnection, editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        n nVar = this.f2778a;
        if (nVar != null) {
            nVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i8) {
        super.setBackgroundResource(i8);
        n nVar = this.f2778a;
        if (nVar != null) {
            nVar.f(i8);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        d0 d0Var = this.f2779b;
        if (d0Var != null) {
            d0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        d0 d0Var = this.f2779b;
        if (d0Var != null) {
            d0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(callback);
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i8) {
        setDropDownBackgroundDrawable(b8.h.p(getContext(), i8));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.f2780c.w(z);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f2780c.l(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        n nVar = this.f2778a;
        if (nVar != null) {
            nVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        n nVar = this.f2778a;
        if (nVar != null) {
            nVar.i(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        d0 d0Var = this.f2779b;
        d0Var.f(colorStateList);
        d0Var.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        d0 d0Var = this.f2779b;
        d0Var.g(mode);
        d0Var.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i8) {
        super.setTextAppearance(context, i8);
        d0 d0Var = this.f2779b;
        if (d0Var != null) {
            d0Var.e(context, i8);
        }
    }
}
