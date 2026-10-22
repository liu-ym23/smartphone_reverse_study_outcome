package m;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.RadioButton;
import com.stepos.agentsafetycenter.R;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class b0 extends RadioButton implements r3.h {

    /* renamed from: c, reason: collision with root package name */
    public final k0.t1 f7880c;

    /* renamed from: f, reason: collision with root package name */
    public final ed.o f7881f;

    /* renamed from: g, reason: collision with root package name */
    public final s0 f7882g;

    /* renamed from: h, reason: collision with root package name */
    public v f7883h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.radioButtonStyle);
        m2.a(context);
        l2.a(this, getContext());
        k0.t1 t1Var = new k0.t1(this);
        this.f7880c = t1Var;
        t1Var.d(attributeSet, R.attr.radioButtonStyle);
        ed.o oVar = new ed.o(this);
        this.f7881f = oVar;
        oVar.e(attributeSet, R.attr.radioButtonStyle);
        s0 s0Var = new s0(this);
        this.f7882g = s0Var;
        s0Var.f(attributeSet, R.attr.radioButtonStyle);
        getEmojiTextViewHelper().b(attributeSet, R.attr.radioButtonStyle);
    }

    private v getEmojiTextViewHelper() {
        if (this.f7883h == null) {
            this.f7883h = new v(this);
        }
        return this.f7883h;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        ed.o oVar = this.f7881f;
        if (oVar != null) {
            oVar.a();
        }
        s0 s0Var = this.f7882g;
        if (s0Var != null) {
            s0Var.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        ed.o oVar = this.f7881f;
        if (oVar != null) {
            return oVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        ed.o oVar = this.f7881f;
        if (oVar != null) {
            return oVar.c();
        }
        return null;
    }

    @Override // r3.h
    public ColorStateList getSupportButtonTintList() {
        k0.t1 t1Var = this.f7880c;
        if (t1Var != null) {
            return (ColorStateList) t1Var.f7076e;
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        k0.t1 t1Var = this.f7880c;
        if (t1Var != null) {
            return (PorterDuff.Mode) t1Var.f7077f;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f7882g.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f7882g.e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().c(z10);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        ed.o oVar = this.f7881f;
        if (oVar != null) {
            oVar.f();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        ed.o oVar = this.f7881f;
        if (oVar != null) {
            oVar.g(i);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        k0.t1 t1Var = this.f7880c;
        if (t1Var != null) {
            if (t1Var.f7074c) {
                t1Var.f7074c = false;
            } else {
                t1Var.f7074c = true;
                t1Var.a();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        s0 s0Var = this.f7882g;
        if (s0Var != null) {
            s0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        s0 s0Var = this.f7882g;
        if (s0Var != null) {
            s0Var.b();
        }
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().d(z10);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        ed.o oVar = this.f7881f;
        if (oVar != null) {
            oVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        ed.o oVar = this.f7881f;
        if (oVar != null) {
            oVar.j(mode);
        }
    }

    @Override // r3.h
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        k0.t1 t1Var = this.f7880c;
        if (t1Var != null) {
            t1Var.f7076e = colorStateList;
            t1Var.f7072a = true;
            t1Var.a();
        }
    }

    @Override // r3.h
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        k0.t1 t1Var = this.f7880c;
        if (t1Var != null) {
            t1Var.f7077f = mode;
            t1Var.f7073b = true;
            t1Var.a();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        s0 s0Var = this.f7882g;
        s0Var.h(colorStateList);
        s0Var.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        s0 s0Var = this.f7882g;
        s0Var.i(mode);
        s0Var.b();
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(id.k.v(i, getContext()));
    }
}
