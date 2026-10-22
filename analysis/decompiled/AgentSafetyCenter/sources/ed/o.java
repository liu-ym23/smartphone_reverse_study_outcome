package ed;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import m.e1;
import m.s;
import n3.i0;
import n3.k0;
import p.g0;
import p.o0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public int f3837a;

    /* renamed from: b, reason: collision with root package name */
    public Object f3838b;

    /* renamed from: c, reason: collision with root package name */
    public Object f3839c;

    /* renamed from: d, reason: collision with root package name */
    public Object f3840d;

    /* renamed from: e, reason: collision with root package name */
    public Object f3841e;

    /* renamed from: f, reason: collision with root package name */
    public Object f3842f;

    public o() {
        this.f3838b = new s1.n[32];
        this.f3839c = new float[32];
        this.f3840d = new byte[32];
        int i = o0.f9601a;
        this.f3841e = new g0();
        this.f3842f = new g0();
    }

    public void a() {
        View view = (View) this.f3838b;
        Drawable background = view.getBackground();
        if (background != null) {
            if (((ad.h) this.f3840d) != null) {
                if (((ad.h) this.f3842f) == null) {
                    this.f3842f = new ad.h();
                }
                ad.h hVar = (ad.h) this.f3842f;
                hVar.f509c = null;
                hVar.f508b = false;
                hVar.f510d = null;
                hVar.f507a = false;
                WeakHashMap weakHashMap = k0.f8724a;
                ColorStateList backgroundTintList = view.getBackgroundTintList();
                if (backgroundTintList != null) {
                    hVar.f508b = true;
                    hVar.f509c = backgroundTintList;
                }
                PorterDuff.Mode backgroundTintMode = view.getBackgroundTintMode();
                if (backgroundTintMode != null) {
                    hVar.f507a = true;
                    hVar.f510d = backgroundTintMode;
                }
                if (hVar.f508b || hVar.f507a) {
                    s.d(background, hVar, view.getDrawableState());
                    return;
                }
            }
            ad.h hVar2 = (ad.h) this.f3841e;
            if (hVar2 != null) {
                s.d(background, hVar2, view.getDrawableState());
                return;
            }
            ad.h hVar3 = (ad.h) this.f3840d;
            if (hVar3 != null) {
                s.d(background, hVar3, view.getDrawableState());
            }
        }
    }

    public ColorStateList b() {
        ad.h hVar = (ad.h) this.f3841e;
        if (hVar != null) {
            return (ColorStateList) hVar.f509c;
        }
        return null;
    }

    public PorterDuff.Mode c() {
        ad.h hVar = (ad.h) this.f3841e;
        if (hVar != null) {
            return (PorterDuff.Mode) hVar.f510d;
        }
        return null;
    }

    public boolean d() {
        return this.f3837a < ((List) this.f3840d).size() || !((ArrayList) this.f3842f).isEmpty();
    }

    public void e(AttributeSet attributeSet, int i) {
        ColorStateList colorStateListG;
        View view = (View) this.f3838b;
        Context context = view.getContext();
        int[] iArr = g.a.f4122z;
        p5.m mVarJ = p5.m.J(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) mVarJ.f9742g;
        View view2 = (View) this.f3838b;
        Context context2 = view2.getContext();
        TypedArray typedArray2 = (TypedArray) mVarJ.f9742g;
        WeakHashMap weakHashMap = k0.f8724a;
        i0.b(view2, context2, iArr, attributeSet, typedArray2, i, 0);
        try {
            if (typedArray.hasValue(0)) {
                this.f3837a = typedArray.getResourceId(0, -1);
                s sVar = (s) this.f3839c;
                Context context3 = view.getContext();
                int i3 = this.f3837a;
                synchronized (sVar) {
                    colorStateListG = sVar.f8062a.g(i3, context3);
                }
                if (colorStateListG != null) {
                    h(colorStateListG);
                }
            }
            if (typedArray.hasValue(1)) {
                view.setBackgroundTintList(mVarJ.z(1));
            }
            if (typedArray.hasValue(2)) {
                view.setBackgroundTintMode(e1.b(typedArray.getInt(2, -1), null));
            }
            mVarJ.M();
        } catch (Throwable th) {
            mVarJ.M();
            throw th;
        }
    }

    public void f() {
        this.f3837a = -1;
        h(null);
        a();
    }

    public void g(int i) {
        ColorStateList colorStateListG;
        this.f3837a = i;
        s sVar = (s) this.f3839c;
        if (sVar != null) {
            Context context = ((View) this.f3838b).getContext();
            synchronized (sVar) {
                colorStateListG = sVar.f8062a.g(i, context);
            }
        } else {
            colorStateListG = null;
        }
        h(colorStateListG);
        a();
    }

    public void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (((ad.h) this.f3840d) == null) {
                this.f3840d = new ad.h();
            }
            ad.h hVar = (ad.h) this.f3840d;
            hVar.f509c = colorStateList;
            hVar.f508b = true;
        } else {
            this.f3840d = null;
        }
        a();
    }

    public void i(ColorStateList colorStateList) {
        if (((ad.h) this.f3841e) == null) {
            this.f3841e = new ad.h();
        }
        ad.h hVar = (ad.h) this.f3841e;
        hVar.f509c = colorStateList;
        hVar.f508b = true;
        a();
    }

    public void j(PorterDuff.Mode mode) {
        if (((ad.h) this.f3841e) == null) {
            this.f3841e = new ad.h();
        }
        ad.h hVar = (ad.h) this.f3841e;
        hVar.f510d = mode;
        hVar.f507a = true;
        a();
    }

    public o(View view) {
        this.f3837a = -1;
        this.f3838b = view;
        this.f3839c = s.a();
    }
}
