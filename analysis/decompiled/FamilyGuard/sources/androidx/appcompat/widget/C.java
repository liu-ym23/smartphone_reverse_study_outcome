package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.LocaleList;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.core.content.res.h;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class C {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f8092a;

    /* renamed from: b, reason: collision with root package name */
    private Y f8093b;

    /* renamed from: c, reason: collision with root package name */
    private Y f8094c;

    /* renamed from: d, reason: collision with root package name */
    private Y f8095d;

    /* renamed from: e, reason: collision with root package name */
    private Y f8096e;

    /* renamed from: f, reason: collision with root package name */
    private Y f8097f;

    /* renamed from: g, reason: collision with root package name */
    private Y f8098g;

    /* renamed from: h, reason: collision with root package name */
    private Y f8099h;

    /* renamed from: i, reason: collision with root package name */
    private final E f8100i;

    /* renamed from: j, reason: collision with root package name */
    private int f8101j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f8102k = -1;

    /* renamed from: l, reason: collision with root package name */
    private Typeface f8103l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f8104m;

    class a extends h.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8105a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f8106b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ WeakReference f8107c;

        a(int i5, int i6, WeakReference weakReference) {
            this.f8105a = i5;
            this.f8106b = i6;
            this.f8107c = weakReference;
        }

        @Override // androidx.core.content.res.h.e
        public void f(int i5) {
        }

        @Override // androidx.core.content.res.h.e
        public void g(Typeface typeface) {
            int i5 = this.f8105a;
            if (i5 != -1) {
                typeface = e.a(typeface, i5, (this.f8106b & 2) != 0);
            }
            C.this.n(this.f8107c, typeface);
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f8109a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Typeface f8110b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f8111c;

        b(TextView textView, Typeface typeface, int i5) {
            this.f8109a = textView;
            this.f8110b = typeface;
            this.f8111c = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8109a.setTypeface(this.f8110b, this.f8111c);
        }
    }

    static class c {
        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    static class d {
        static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        static void b(TextView textView, int i5, int i6, int i7, int i8) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i5, i6, i7, i8);
        }

        static void c(TextView textView, int[] iArr, int i5) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i5);
        }

        static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    static class e {
        static Typeface a(Typeface typeface, int i5, boolean z5) {
            return Typeface.create(typeface, i5, z5);
        }
    }

    C(TextView textView) {
        this.f8092a = textView;
        this.f8100i = new E(textView);
    }

    private void B(int i5, float f5) {
        this.f8100i.t(i5, f5);
    }

    private void C(Context context, a0 a0Var) {
        String strO;
        this.f8101j = a0Var.k(g.j.f17010F2, this.f8101j);
        int iK = a0Var.k(g.j.f17049O2, -1);
        this.f8102k = iK;
        if (iK != -1) {
            this.f8101j &= 2;
        }
        int i5 = g.j.f17045N2;
        if (!a0Var.s(i5) && !a0Var.s(g.j.f17053P2)) {
            int i6 = g.j.f17005E2;
            if (a0Var.s(i6)) {
                this.f8104m = false;
                int iK2 = a0Var.k(i6, 1);
                if (iK2 == 1) {
                    this.f8103l = Typeface.SANS_SERIF;
                    return;
                } else if (iK2 == 2) {
                    this.f8103l = Typeface.SERIF;
                    return;
                } else {
                    if (iK2 != 3) {
                        return;
                    }
                    this.f8103l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f8103l = null;
        int i7 = g.j.f17053P2;
        if (a0Var.s(i7)) {
            i5 = i7;
        }
        int i8 = this.f8102k;
        int i9 = this.f8101j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceJ = a0Var.j(i5, this.f8101j, new a(i8, i9, new WeakReference(this.f8092a)));
                if (typefaceJ != null) {
                    if (this.f8102k != -1) {
                        this.f8103l = e.a(Typeface.create(typefaceJ, 0), this.f8102k, (this.f8101j & 2) != 0);
                    } else {
                        this.f8103l = typefaceJ;
                    }
                }
                this.f8104m = this.f8103l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f8103l != null || (strO = a0Var.o(i5)) == null) {
            return;
        }
        if (this.f8102k != -1) {
            this.f8103l = e.a(Typeface.create(strO, 0), this.f8102k, (this.f8101j & 2) != 0);
        } else {
            this.f8103l = Typeface.create(strO, this.f8101j);
        }
    }

    private void a(Drawable drawable, Y y5) {
        if (drawable == null || y5 == null) {
            return;
        }
        C0441k.i(drawable, y5, this.f8092a.getDrawableState());
    }

    private static Y d(Context context, C0441k c0441k, int i5) {
        ColorStateList colorStateListF = c0441k.f(context, i5);
        if (colorStateListF == null) {
            return null;
        }
        Y y5 = new Y();
        y5.f8465d = true;
        y5.f8462a = colorStateListF;
        return y5;
    }

    private void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] compoundDrawablesRelative = this.f8092a.getCompoundDrawablesRelative();
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            TextView textView = this.f8092a;
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative2 = this.f8092a.getCompoundDrawablesRelative();
        Drawable drawable7 = compoundDrawablesRelative2[0];
        if (drawable7 != null || compoundDrawablesRelative2[2] != null) {
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative2[1];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative2[3];
            }
            this.f8092a.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, compoundDrawablesRelative2[2], drawable4);
            return;
        }
        Drawable[] compoundDrawables = this.f8092a.getCompoundDrawables();
        TextView textView2 = this.f8092a;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    private void z() {
        Y y5 = this.f8099h;
        this.f8093b = y5;
        this.f8094c = y5;
        this.f8095d = y5;
        this.f8096e = y5;
        this.f8097f = y5;
        this.f8098g = y5;
    }

    void A(int i5, float f5) {
        if (h0.f8559a || l()) {
            return;
        }
        B(i5, f5);
    }

    void b() {
        if (this.f8093b != null || this.f8094c != null || this.f8095d != null || this.f8096e != null) {
            Drawable[] compoundDrawables = this.f8092a.getCompoundDrawables();
            a(compoundDrawables[0], this.f8093b);
            a(compoundDrawables[1], this.f8094c);
            a(compoundDrawables[2], this.f8095d);
            a(compoundDrawables[3], this.f8096e);
        }
        if (this.f8097f == null && this.f8098g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = this.f8092a.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f8097f);
        a(compoundDrawablesRelative[2], this.f8098g);
    }

    void c() {
        this.f8100i.a();
    }

    int e() {
        return this.f8100i.f();
    }

    int f() {
        return this.f8100i.g();
    }

    int g() {
        return this.f8100i.h();
    }

    int[] h() {
        return this.f8100i.i();
    }

    int i() {
        return this.f8100i.j();
    }

    ColorStateList j() {
        Y y5 = this.f8099h;
        if (y5 != null) {
            return y5.f8462a;
        }
        return null;
    }

    PorterDuff.Mode k() {
        Y y5 = this.f8099h;
        if (y5 != null) {
            return y5.f8463b;
        }
        return null;
    }

    boolean l() {
        return this.f8100i.n();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void m(android.util.AttributeSet r18, int r19) {
        /*
            Method dump skipped, instructions count: 636
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C.m(android.util.AttributeSet, int):void");
    }

    void n(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.f8104m) {
            this.f8103l = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                if (textView.isAttachedToWindow()) {
                    textView.post(new b(textView, typeface, this.f8101j));
                } else {
                    textView.setTypeface(typeface, this.f8101j);
                }
            }
        }
    }

    void o(boolean z5, int i5, int i6, int i7, int i8) {
        if (h0.f8559a) {
            return;
        }
        c();
    }

    void p() {
        b();
    }

    void q(Context context, int i5) {
        String strO;
        a0 a0VarT = a0.t(context, i5, g.j.f16995C2);
        int i6 = g.j.f17061R2;
        if (a0VarT.s(i6)) {
            s(a0VarT.a(i6, false));
        }
        int i7 = g.j.f17000D2;
        if (a0VarT.s(i7) && a0VarT.f(i7, -1) == 0) {
            this.f8092a.setTextSize(0, 0.0f);
        }
        C(context, a0VarT);
        int i8 = g.j.f17057Q2;
        if (a0VarT.s(i8) && (strO = a0VarT.o(i8)) != null) {
            d.d(this.f8092a, strO);
        }
        a0VarT.x();
        Typeface typeface = this.f8103l;
        if (typeface != null) {
            this.f8092a.setTypeface(typeface, this.f8101j);
        }
    }

    void r(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
    }

    void s(boolean z5) {
        this.f8092a.setAllCaps(z5);
    }

    void t(int i5, int i6, int i7, int i8) {
        this.f8100i.p(i5, i6, i7, i8);
    }

    void u(int[] iArr, int i5) {
        this.f8100i.q(iArr, i5);
    }

    void v(int i5) {
        this.f8100i.r(i5);
    }

    void w(ColorStateList colorStateList) {
        if (this.f8099h == null) {
            this.f8099h = new Y();
        }
        Y y5 = this.f8099h;
        y5.f8462a = colorStateList;
        y5.f8465d = colorStateList != null;
        z();
    }

    void x(PorterDuff.Mode mode) {
        if (this.f8099h == null) {
            this.f8099h = new Y();
        }
        Y y5 = this.f8099h;
        y5.f8463b = mode;
        y5.f8464c = mode != null;
        z();
    }
}
