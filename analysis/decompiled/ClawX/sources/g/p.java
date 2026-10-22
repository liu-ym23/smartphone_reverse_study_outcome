package g;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.stepos.stepclaw.R;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class p extends CheckBox {

    /* renamed from: a, reason: collision with root package name */
    public final q f2797a;

    /* renamed from: b, reason: collision with root package name */
    public final n f2798b;

    /* renamed from: c, reason: collision with root package name */
    public final d0 f2799c;
    public u d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(Context context, AttributeSet attributeSet) {
        int resourceId;
        int resourceId2;
        super(context, attributeSet, R.attr.chipStyle);
        r1.a(context);
        q1.a(this, getContext());
        this.f2797a = new q(this);
        Context context2 = getContext();
        int[] iArr = c.a.f1022j;
        a4.d dVarE = a4.d.E(context2, attributeSet, iArr, R.attr.chipStyle);
        TypedArray typedArray = (TypedArray) dVarE.f97c;
        Context context3 = getContext();
        TypedArray typedArray2 = (TypedArray) dVarE.f97c;
        int[] iArr2 = e0.a0.f2285a;
        e0.y.b(this, context3, iArr, attributeSet, typedArray2, R.attr.chipStyle, 0);
        try {
            if (typedArray.hasValue(1) && (resourceId2 = typedArray.getResourceId(1, 0)) != 0) {
                try {
                    setButtonDrawable(b8.h.p(getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                }
            } else if (typedArray.hasValue(0) && (resourceId = typedArray.getResourceId(0, 0)) != 0) {
                setButtonDrawable(b8.h.p(getContext(), resourceId));
            }
            if (typedArray.hasValue(2)) {
                setButtonTintList(dVarE.s(2));
            }
            if (typedArray.hasValue(3)) {
                setButtonTintMode(n0.a(typedArray.getInt(3, -1), null));
            }
            dVarE.H();
            n nVar = new n(this);
            this.f2798b = nVar;
            nVar.d(attributeSet, R.attr.chipStyle);
            d0 d0Var = new d0(this);
            this.f2799c = d0Var;
            d0Var.d(attributeSet, R.attr.chipStyle);
            getEmojiTextViewHelper().a(attributeSet, R.attr.chipStyle);
        } catch (Throwable th) {
            dVarE.H();
            throw th;
        }
    }

    private u getEmojiTextViewHelper() {
        if (this.d == null) {
            this.d = new u(this);
        }
        return this.d;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        n nVar = this.f2798b;
        if (nVar != null) {
            nVar.a();
        }
        d0 d0Var = this.f2799c;
        if (d0Var != null) {
            d0Var.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        n nVar = this.f2798b;
        if (nVar != null) {
            return nVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        n nVar = this.f2798b;
        if (nVar != null) {
            return nVar.c();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        q qVar = this.f2797a;
        if (qVar != null) {
            return qVar.f2804b;
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        q qVar = this.f2797a;
        if (qVar != null) {
            return qVar.f2805c;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        s1 s1Var = this.f2799c.f2682h;
        if (s1Var != null) {
            return (ColorStateList) s1Var.f2824c;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        s1 s1Var = this.f2799c.f2682h;
        if (s1Var != null) {
            return (PorterDuff.Mode) s1Var.d;
        }
        return null;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        ((k4.z) getEmojiTextViewHelper().f2840b.f621a).G(z);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        n nVar = this.f2798b;
        if (nVar != null) {
            nVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i8) {
        super.setBackgroundResource(i8);
        n nVar = this.f2798b;
        if (nVar != null) {
            nVar.f(i8);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        q qVar = this.f2797a;
        if (qVar != null) {
            if (qVar.f2807f) {
                qVar.f2807f = false;
            } else {
                qVar.f2807f = true;
                qVar.a();
            }
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        d0 d0Var = this.f2799c;
        if (d0Var != null) {
            d0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        d0 d0Var = this.f2799c;
        if (d0Var != null) {
            d0Var.b();
        }
    }

    public void setEmojiCompatEnabled(boolean z) {
        ((k4.z) getEmojiTextViewHelper().f2840b.f621a).H(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(((k4.z) getEmojiTextViewHelper().f2840b.f621a).v(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        n nVar = this.f2798b;
        if (nVar != null) {
            nVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        n nVar = this.f2798b;
        if (nVar != null) {
            nVar.i(mode);
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        q qVar = this.f2797a;
        if (qVar != null) {
            qVar.f2804b = colorStateList;
            qVar.d = true;
            qVar.a();
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        q qVar = this.f2797a;
        if (qVar != null) {
            qVar.f2805c = mode;
            qVar.f2806e = true;
            qVar.a();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        d0 d0Var = this.f2799c;
        d0Var.f(colorStateList);
        d0Var.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        d0 d0Var = this.f2799c;
        d0Var.g(mode);
        d0Var.b();
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i8) {
        setButtonDrawable(b8.h.p(getContext(), i8));
    }
}
