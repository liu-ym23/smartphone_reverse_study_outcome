package k0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t1 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f7072a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7073b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7074c;

    /* renamed from: d, reason: collision with root package name */
    public Object f7075d;

    /* renamed from: e, reason: collision with root package name */
    public Object f7076e;

    /* renamed from: f, reason: collision with root package name */
    public Object f7077f;

    public t1(s1 s1Var, Object obj, boolean z10, y0 y0Var, boolean z11) {
        this.f7075d = s1Var;
        this.f7072a = z10;
        this.f7076e = y0Var;
        this.f7073b = z11;
        this.f7077f = obj;
        this.f7074c = true;
    }

    public void a() {
        CompoundButton compoundButton = (CompoundButton) this.f7075d;
        Drawable buttonDrawable = compoundButton.getButtonDrawable();
        if (buttonDrawable != null) {
            if (this.f7072a || this.f7073b) {
                Drawable drawableMutate = buttonDrawable.mutate();
                if (this.f7072a) {
                    drawableMutate.setTintList((ColorStateList) this.f7076e);
                }
                if (this.f7073b) {
                    drawableMutate.setTintMode((PorterDuff.Mode) this.f7077f);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(compoundButton.getDrawableState());
                }
                compoundButton.setButtonDrawable(drawableMutate);
            }
        }
    }

    public void b() {
        m.r rVar = (m.r) this.f7075d;
        Drawable checkMarkDrawable = rVar.getCheckMarkDrawable();
        if (checkMarkDrawable != null) {
            if (this.f7072a || this.f7073b) {
                Drawable drawableMutate = checkMarkDrawable.mutate();
                if (this.f7072a) {
                    drawableMutate.setTintList((ColorStateList) this.f7076e);
                }
                if (this.f7073b) {
                    drawableMutate.setTintMode((PorterDuff.Mode) this.f7077f);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(rVar.getDrawableState());
                }
                rVar.setCheckMarkDrawable(drawableMutate);
            }
        }
    }

    public Object c() {
        if (this.f7072a) {
            return null;
        }
        Object obj = this.f7077f;
        if (obj != null) {
            return obj;
        }
        t.d("Unexpected form of a provided value");
        throw new androidx.fragment.app.d();
    }

    public void d(AttributeSet attributeSet, int i) {
        int resourceId;
        int resourceId2;
        CompoundButton compoundButton = (CompoundButton) this.f7075d;
        Context context = compoundButton.getContext();
        int[] iArr = g.a.f4109m;
        p5.m mVarJ = p5.m.J(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) mVarJ.f9742g;
        Context context2 = compoundButton.getContext();
        TypedArray typedArray2 = (TypedArray) mVarJ.f9742g;
        WeakHashMap weakHashMap = n3.k0.f8724a;
        n3.i0.b(compoundButton, context2, iArr, attributeSet, typedArray2, i, 0);
        try {
            if (typedArray.hasValue(1) && (resourceId2 = typedArray.getResourceId(1, 0)) != 0) {
                try {
                    compoundButton.setButtonDrawable(id.k.v(resourceId2, compoundButton.getContext()));
                } catch (Resources.NotFoundException unused) {
                }
            } else if (typedArray.hasValue(0) && (resourceId = typedArray.getResourceId(0, 0)) != 0) {
                compoundButton.setButtonDrawable(id.k.v(resourceId, compoundButton.getContext()));
            }
            if (typedArray.hasValue(2)) {
                compoundButton.setButtonTintList(mVarJ.z(2));
            }
            if (typedArray.hasValue(3)) {
                compoundButton.setButtonTintMode(m.e1.b(typedArray.getInt(3, -1), null));
            }
            mVarJ.M();
        } catch (Throwable th) {
            mVarJ.M();
            throw th;
        }
    }

    public t1(CompoundButton compoundButton) {
        this.f7076e = null;
        this.f7077f = null;
        this.f7072a = false;
        this.f7073b = false;
        this.f7075d = compoundButton;
    }
}
