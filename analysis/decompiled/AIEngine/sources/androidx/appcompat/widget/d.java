package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import java.util.WeakHashMap;
import v0.e0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final View f785a;

    /* renamed from: d, reason: collision with root package name */
    public v0 f788d;

    /* renamed from: e, reason: collision with root package name */
    public v0 f789e;

    /* renamed from: f, reason: collision with root package name */
    public v0 f790f;

    /* renamed from: c, reason: collision with root package name */
    public int f787c = -1;

    /* renamed from: b, reason: collision with root package name */
    public final j f786b = j.a();

    public d(View view) {
        this.f785a = view;
    }

    public final void a() {
        View view = this.f785a;
        Drawable background = view.getBackground();
        if (background != null) {
            if (this.f788d != null) {
                if (this.f790f == null) {
                    this.f790f = new v0();
                }
                v0 v0Var = this.f790f;
                v0Var.f937a = null;
                v0Var.f940d = false;
                v0Var.f938b = null;
                v0Var.f939c = false;
                WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
                ColorStateList colorStateListB = e0.d.b(view);
                if (colorStateListB != null) {
                    v0Var.f940d = true;
                    v0Var.f937a = colorStateListB;
                }
                PorterDuff.Mode modeC = e0.d.c(view);
                if (modeC != null) {
                    v0Var.f939c = true;
                    v0Var.f938b = modeC;
                }
                if (v0Var.f940d || v0Var.f939c) {
                    j.e(background, v0Var, view.getDrawableState());
                    return;
                }
            }
            v0 v0Var2 = this.f789e;
            if (v0Var2 != null) {
                j.e(background, v0Var2, view.getDrawableState());
                return;
            }
            v0 v0Var3 = this.f788d;
            if (v0Var3 != null) {
                j.e(background, v0Var3, view.getDrawableState());
            }
        }
    }

    public final ColorStateList b() {
        v0 v0Var = this.f789e;
        if (v0Var != null) {
            return v0Var.f937a;
        }
        return null;
    }

    public final PorterDuff.Mode c() {
        v0 v0Var = this.f789e;
        if (v0Var != null) {
            return v0Var.f938b;
        }
        return null;
    }

    public final void d(AttributeSet attributeSet, int i10) {
        ColorStateList colorStateListF;
        View view = this.f785a;
        Context context = view.getContext();
        int[] iArr = g.a.z;
        x0 x0VarE = x0.e(context, attributeSet, iArr, i10);
        TypedArray typedArray = x0VarE.f948b;
        View view2 = this.f785a;
        Context context2 = view2.getContext();
        TypedArray typedArray2 = x0VarE.f948b;
        WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
        e0.h.b(view2, context2, iArr, attributeSet, typedArray2, i10, 0);
        try {
            if (typedArray.hasValue(0)) {
                this.f787c = typedArray.getResourceId(0, -1);
                j jVar = this.f786b;
                Context context3 = view.getContext();
                int i11 = this.f787c;
                synchronized (jVar) {
                    colorStateListF = jVar.f848a.f(i11, context3);
                }
                if (colorStateListF != null) {
                    g(colorStateListF);
                }
            }
            if (typedArray.hasValue(1)) {
                e0.d.h(view, x0VarE.a(1));
            }
            if (typedArray.hasValue(2)) {
                e0.d.i(view, f0.c(typedArray.getInt(2, -1), null));
            }
            x0VarE.f();
        } catch (Throwable th) {
            x0VarE.f();
            throw th;
        }
    }

    public final void e() {
        this.f787c = -1;
        g(null);
        a();
    }

    public final void f(int i10) {
        ColorStateList colorStateListF;
        this.f787c = i10;
        j jVar = this.f786b;
        if (jVar != null) {
            Context context = this.f785a.getContext();
            synchronized (jVar) {
                colorStateListF = jVar.f848a.f(i10, context);
            }
        } else {
            colorStateListF = null;
        }
        g(colorStateListF);
        a();
    }

    public final void g(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f788d == null) {
                this.f788d = new v0();
            }
            v0 v0Var = this.f788d;
            v0Var.f937a = colorStateList;
            v0Var.f940d = true;
        } else {
            this.f788d = null;
        }
        a();
    }

    public final void h(ColorStateList colorStateList) {
        if (this.f789e == null) {
            this.f789e = new v0();
        }
        v0 v0Var = this.f789e;
        v0Var.f937a = colorStateList;
        v0Var.f940d = true;
        a();
    }

    public final void i(PorterDuff.Mode mode) {
        if (this.f789e == null) {
            this.f789e = new v0();
        }
        v0 v0Var = this.f789e;
        v0Var.f938b = mode;
        v0Var.f939c = true;
        a();
    }
}
