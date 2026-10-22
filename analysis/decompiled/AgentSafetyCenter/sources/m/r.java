package m;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r extends CheckedTextView {

    /* renamed from: c, reason: collision with root package name */
    public final k0.t1 f8054c;

    /* renamed from: f, reason: collision with root package name */
    public final ed.o f8055f;

    /* renamed from: g, reason: collision with root package name */
    public final s0 f8056g;

    /* renamed from: h, reason: collision with root package name */
    public v f8057h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(Context context, AttributeSet attributeSet) {
        int resourceId;
        int resourceId2;
        super(context, attributeSet, R.attr.checkedTextViewStyle);
        m2.a(context);
        l2.a(this, getContext());
        s0 s0Var = new s0(this);
        this.f8056g = s0Var;
        s0Var.f(attributeSet, R.attr.checkedTextViewStyle);
        s0Var.b();
        ed.o oVar = new ed.o(this);
        this.f8055f = oVar;
        oVar.e(attributeSet, R.attr.checkedTextViewStyle);
        k0.t1 t1Var = new k0.t1();
        t1Var.f7076e = null;
        t1Var.f7077f = null;
        t1Var.f7072a = false;
        t1Var.f7073b = false;
        t1Var.f7075d = this;
        VarHandle.storeStoreFence();
        this.f8054c = t1Var;
        Context context2 = getContext();
        int[] iArr = g.a.f4108l;
        p5.m mVarJ = p5.m.J(context2, attributeSet, iArr, R.attr.checkedTextViewStyle);
        TypedArray typedArray = (TypedArray) mVarJ.f9742g;
        Context context3 = getContext();
        TypedArray typedArray2 = (TypedArray) mVarJ.f9742g;
        WeakHashMap weakHashMap = n3.k0.f8724a;
        n3.i0.b(this, context3, iArr, attributeSet, typedArray2, R.attr.checkedTextViewStyle, 0);
        try {
            if (typedArray.hasValue(1) && (resourceId2 = typedArray.getResourceId(1, 0)) != 0) {
                try {
                    setCheckMarkDrawable(id.k.v(resourceId2, getContext()));
                } catch (Resources.NotFoundException unused) {
                }
            } else if (typedArray.hasValue(0) && (resourceId = typedArray.getResourceId(0, 0)) != 0) {
                setCheckMarkDrawable(id.k.v(resourceId, getContext()));
            }
            if (typedArray.hasValue(2)) {
                setCheckMarkTintList(mVarJ.z(2));
            }
            if (typedArray.hasValue(3)) {
                setCheckMarkTintMode(e1.b(typedArray.getInt(3, -1), null));
            }
            mVarJ.M();
            getEmojiTextViewHelper().b(attributeSet, R.attr.checkedTextViewStyle);
        } catch (Throwable th) {
            mVarJ.M();
            throw th;
        }
    }

    private v getEmojiTextViewHelper() {
        if (this.f8057h == null) {
            this.f8057h = new v(this);
        }
        return this.f8057h;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        s0 s0Var = this.f8056g;
        if (s0Var != null) {
            s0Var.b();
        }
        ed.o oVar = this.f8055f;
        if (oVar != null) {
            oVar.a();
        }
        k0.t1 t1Var = this.f8054c;
        if (t1Var != null) {
            t1Var.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return super.getCustomSelectionActionModeCallback();
    }

    public ColorStateList getSupportBackgroundTintList() {
        ed.o oVar = this.f8055f;
        if (oVar != null) {
            return oVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        ed.o oVar = this.f8055f;
        if (oVar != null) {
            return oVar.c();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        k0.t1 t1Var = this.f8054c;
        if (t1Var != null) {
            return (ColorStateList) t1Var.f7076e;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        k0.t1 t1Var = this.f8054c;
        if (t1Var != null) {
            return (PorterDuff.Mode) t1Var.f7077f;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f8056g.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f8056g.e();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        ac.a.K(inputConnectionOnCreateInputConnection, editorInfo, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().c(z10);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        ed.o oVar = this.f8055f;
        if (oVar != null) {
            oVar.f();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        ed.o oVar = this.f8055f;
        if (oVar != null) {
            oVar.g(i);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        k0.t1 t1Var = this.f8054c;
        if (t1Var != null) {
            if (t1Var.f7074c) {
                t1Var.f7074c = false;
            } else {
                t1Var.f7074c = true;
                t1Var.b();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        s0 s0Var = this.f8056g;
        if (s0Var != null) {
            s0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        s0 s0Var = this.f8056g;
        if (s0Var != null) {
            s0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(callback);
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().d(z10);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        ed.o oVar = this.f8055f;
        if (oVar != null) {
            oVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        ed.o oVar = this.f8055f;
        if (oVar != null) {
            oVar.j(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        k0.t1 t1Var = this.f8054c;
        if (t1Var != null) {
            t1Var.f7076e = colorStateList;
            t1Var.f7072a = true;
            t1Var.b();
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        k0.t1 t1Var = this.f8054c;
        if (t1Var != null) {
            t1Var.f7077f = mode;
            t1Var.f7073b = true;
            t1Var.b();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        s0 s0Var = this.f8056g;
        s0Var.h(colorStateList);
        s0Var.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        s0 s0Var = this.f8056g;
        s0Var.i(mode);
        s0Var.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        s0 s0Var = this.f8056g;
        if (s0Var != null) {
            s0Var.g(i, context);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(id.k.v(i, getContext()));
    }
}
