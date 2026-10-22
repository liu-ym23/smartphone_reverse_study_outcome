package g;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public int f2781a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2782b;

    /* renamed from: c, reason: collision with root package name */
    public Object f2783c;
    public Object d;

    /* renamed from: e, reason: collision with root package name */
    public Object f2784e;

    /* renamed from: f, reason: collision with root package name */
    public Object f2785f;

    public n(View view) {
        r rVar;
        this.f2781a = -1;
        this.f2782b = view;
        PorterDuff.Mode mode = r.f2814b;
        synchronized (r.class) {
            try {
                if (r.f2815c == null) {
                    r.c();
                }
                rVar = r.f2815c;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f2783c = rVar;
    }

    public void a() {
        View view = (View) this.f2782b;
        Drawable background = view.getBackground();
        if (background != null) {
            if (((s1) this.d) != null) {
                if (((s1) this.f2785f) == null) {
                    this.f2785f = new s1();
                }
                s1 s1Var = (s1) this.f2785f;
                s1Var.f2824c = null;
                s1Var.f2823b = false;
                s1Var.d = null;
                s1Var.f2822a = false;
                int[] iArr = e0.a0.f2285a;
                ColorStateList backgroundTintList = view.getBackgroundTintList();
                if (backgroundTintList != null) {
                    s1Var.f2823b = true;
                    s1Var.f2824c = backgroundTintList;
                }
                PorterDuff.Mode backgroundTintMode = view.getBackgroundTintMode();
                if (backgroundTintMode != null) {
                    s1Var.f2822a = true;
                    s1Var.d = backgroundTintMode;
                }
                if (s1Var.f2823b || s1Var.f2822a) {
                    r.d(background, s1Var, view.getDrawableState());
                    return;
                }
            }
            s1 s1Var2 = (s1) this.f2784e;
            if (s1Var2 != null) {
                r.d(background, s1Var2, view.getDrawableState());
                return;
            }
            s1 s1Var3 = (s1) this.d;
            if (s1Var3 != null) {
                r.d(background, s1Var3, view.getDrawableState());
            }
        }
    }

    public ColorStateList b() {
        s1 s1Var = (s1) this.f2784e;
        if (s1Var != null) {
            return (ColorStateList) s1Var.f2824c;
        }
        return null;
    }

    public PorterDuff.Mode c() {
        s1 s1Var = (s1) this.f2784e;
        if (s1Var != null) {
            return (PorterDuff.Mode) s1Var.d;
        }
        return null;
    }

    public void d(AttributeSet attributeSet, int i8) {
        ColorStateList colorStateListF;
        View view = (View) this.f2782b;
        Context context = view.getContext();
        int[] iArr = c.a.f1032t;
        a4.d dVarE = a4.d.E(context, attributeSet, iArr, i8);
        TypedArray typedArray = (TypedArray) dVarE.f97c;
        View view2 = (View) this.f2782b;
        Context context2 = view2.getContext();
        TypedArray typedArray2 = (TypedArray) dVarE.f97c;
        int[] iArr2 = e0.a0.f2285a;
        e0.y.b(view2, context2, iArr, attributeSet, typedArray2, i8, 0);
        try {
            if (typedArray.hasValue(0)) {
                this.f2781a = typedArray.getResourceId(0, -1);
                r rVar = (r) this.f2783c;
                Context context3 = view.getContext();
                int i9 = this.f2781a;
                synchronized (rVar) {
                    colorStateListF = rVar.f2816a.f(context3, i9);
                }
                if (colorStateListF != null) {
                    g(colorStateListF);
                }
            }
            if (typedArray.hasValue(1)) {
                view.setBackgroundTintList(dVarE.s(1));
            }
            if (typedArray.hasValue(2)) {
                view.setBackgroundTintMode(n0.a(typedArray.getInt(2, -1), null));
            }
            dVarE.H();
        } catch (Throwable th) {
            dVarE.H();
            throw th;
        }
    }

    public void e() {
        this.f2781a = -1;
        g(null);
        a();
    }

    public void f(int i8) {
        ColorStateList colorStateListF;
        this.f2781a = i8;
        r rVar = (r) this.f2783c;
        if (rVar != null) {
            Context context = ((View) this.f2782b).getContext();
            synchronized (rVar) {
                colorStateListF = rVar.f2816a.f(context, i8);
            }
        } else {
            colorStateListF = null;
        }
        g(colorStateListF);
        a();
    }

    public void g(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (((s1) this.d) == null) {
                this.d = new s1();
            }
            s1 s1Var = (s1) this.d;
            s1Var.f2824c = colorStateList;
            s1Var.f2823b = true;
        } else {
            this.d = null;
        }
        a();
    }

    public void h(ColorStateList colorStateList) {
        if (((s1) this.f2784e) == null) {
            this.f2784e = new s1();
        }
        s1 s1Var = (s1) this.f2784e;
        s1Var.f2824c = colorStateList;
        s1Var.f2823b = true;
        a();
    }

    public void i(PorterDuff.Mode mode) {
        if (((s1) this.f2784e) == null) {
            this.f2784e = new s1();
        }
        s1 s1Var = (s1) this.f2784e;
        s1Var.d = mode;
        s1Var.f2822a = true;
        a();
    }

    public n(q6.d taskRunner) {
        kotlin.jvm.internal.p.e(taskRunner, "taskRunner");
        this.f2782b = taskRunner;
        this.f2784e = u6.l.f5711a;
        this.f2785f = u6.c.f5678a;
    }
}
