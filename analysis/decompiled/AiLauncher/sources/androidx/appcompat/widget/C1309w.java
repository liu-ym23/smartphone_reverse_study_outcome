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
import androidx.appcompat.R$styleable;
import java.lang.ref.WeakReference;
import s0.h;

/* renamed from: androidx.appcompat.widget.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1309w {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f9241a;

    /* renamed from: b, reason: collision with root package name */
    public S f9242b;

    /* renamed from: c, reason: collision with root package name */
    public S f9243c;

    /* renamed from: d, reason: collision with root package name */
    public S f9244d;

    /* renamed from: e, reason: collision with root package name */
    public S f9245e;

    /* renamed from: f, reason: collision with root package name */
    public S f9246f;

    /* renamed from: g, reason: collision with root package name */
    public S f9247g;

    /* renamed from: h, reason: collision with root package name */
    public S f9248h;

    /* renamed from: i, reason: collision with root package name */
    public final C1310x f9249i;

    /* renamed from: j, reason: collision with root package name */
    public int f9250j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f9251k = -1;

    /* renamed from: l, reason: collision with root package name */
    public Typeface f9252l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f9253m;

    /* renamed from: androidx.appcompat.widget.w$a */
    public class a extends h.f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f9254a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f9255b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WeakReference f9256c;

        public a(int i10, int i11, WeakReference weakReference) {
            this.f9254a = i10;
            this.f9255b = i11;
            this.f9256c = weakReference;
        }

        @Override // s0.h.f
        public void f(int i10) {
        }

        @Override // s0.h.f
        public void g(Typeface typeface) {
            int i10 = this.f9254a;
            if (i10 != -1) {
                typeface = e.a(typeface, i10, (this.f9255b & 2) != 0);
            }
            C1309w.this.n(this.f9256c, typeface);
        }
    }

    /* renamed from: androidx.appcompat.widget.w$b */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f9258a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Typeface f9259b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f9260c;

        public b(TextView textView, Typeface typeface, int i10) {
            this.f9258a = textView;
            this.f9259b = typeface;
            this.f9260c = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f9258a.setTypeface(this.f9259b, this.f9260c);
        }
    }

    /* renamed from: androidx.appcompat.widget.w$c */
    public static class c {
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        public static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    /* renamed from: androidx.appcompat.widget.w$d */
    public static class d {
        public static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        public static void b(TextView textView, int i10, int i11, int i12, int i13) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i10, i11, i12, i13);
        }

        public static void c(TextView textView, int[] iArr, int i10) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i10);
        }

        public static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    /* renamed from: androidx.appcompat.widget.w$e */
    public static class e {
        public static Typeface a(Typeface typeface, int i10, boolean z10) {
            return Typeface.create(typeface, i10, z10);
        }
    }

    public C1309w(TextView textView) {
        this.f9241a = textView;
        this.f9249i = new C1310x(textView);
    }

    public static S d(Context context, C1295h c1295h, int i10) {
        ColorStateList colorStateListF = c1295h.f(context, i10);
        if (colorStateListF == null) {
            return null;
        }
        S s10 = new S();
        s10.f9026d = true;
        s10.f9023a = colorStateListF;
        return s10;
    }

    public void A(int i10, float f10) {
        if (b0.f9179a || l()) {
            return;
        }
        B(i10, f10);
    }

    public final void B(int i10, float f10) {
        this.f9249i.t(i10, f10);
    }

    public final void C(Context context, U u10) {
        String strO;
        this.f9250j = u10.k(R$styleable.TextAppearance_android_textStyle, this.f9250j);
        int iK = u10.k(R$styleable.TextAppearance_android_textFontWeight, -1);
        this.f9251k = iK;
        if (iK != -1) {
            this.f9250j &= 2;
        }
        int i10 = R$styleable.TextAppearance_android_fontFamily;
        if (!u10.s(i10) && !u10.s(R$styleable.TextAppearance_fontFamily)) {
            int i11 = R$styleable.TextAppearance_android_typeface;
            if (u10.s(i11)) {
                this.f9253m = false;
                int iK2 = u10.k(i11, 1);
                if (iK2 == 1) {
                    this.f9252l = Typeface.SANS_SERIF;
                    return;
                } else if (iK2 == 2) {
                    this.f9252l = Typeface.SERIF;
                    return;
                } else {
                    if (iK2 != 3) {
                        return;
                    }
                    this.f9252l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f9252l = null;
        int i12 = R$styleable.TextAppearance_fontFamily;
        if (u10.s(i12)) {
            i10 = i12;
        }
        int i13 = this.f9251k;
        int i14 = this.f9250j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceJ = u10.j(i10, this.f9250j, new a(i13, i14, new WeakReference(this.f9241a)));
                if (typefaceJ != null) {
                    if (this.f9251k != -1) {
                        this.f9252l = e.a(Typeface.create(typefaceJ, 0), this.f9251k, (this.f9250j & 2) != 0);
                    } else {
                        this.f9252l = typefaceJ;
                    }
                }
                this.f9253m = this.f9252l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f9252l != null || (strO = u10.o(i10)) == null) {
            return;
        }
        if (this.f9251k != -1) {
            this.f9252l = e.a(Typeface.create(strO, 0), this.f9251k, (this.f9250j & 2) != 0);
        } else {
            this.f9252l = Typeface.create(strO, this.f9250j);
        }
    }

    public final void a(Drawable drawable, S s10) {
        if (drawable == null || s10 == null) {
            return;
        }
        C1295h.i(drawable, s10, this.f9241a.getDrawableState());
    }

    public void b() {
        if (this.f9242b != null || this.f9243c != null || this.f9244d != null || this.f9245e != null) {
            Drawable[] compoundDrawables = this.f9241a.getCompoundDrawables();
            a(compoundDrawables[0], this.f9242b);
            a(compoundDrawables[1], this.f9243c);
            a(compoundDrawables[2], this.f9244d);
            a(compoundDrawables[3], this.f9245e);
        }
        if (this.f9246f == null && this.f9247g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = this.f9241a.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f9246f);
        a(compoundDrawablesRelative[2], this.f9247g);
    }

    public void c() {
        this.f9249i.a();
    }

    public int e() {
        return this.f9249i.f();
    }

    public int f() {
        return this.f9249i.g();
    }

    public int g() {
        return this.f9249i.h();
    }

    public int[] h() {
        return this.f9249i.i();
    }

    public int i() {
        return this.f9249i.j();
    }

    public ColorStateList j() {
        S s10 = this.f9248h;
        if (s10 != null) {
            return s10.f9023a;
        }
        return null;
    }

    public PorterDuff.Mode k() {
        S s10 = this.f9248h;
        if (s10 != null) {
            return s10.f9024b;
        }
        return null;
    }

    public boolean l() {
        return this.f9249i.n();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fb  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m(android.util.AttributeSet r18, int r19) {
        /*
            Method dump skipped, instructions count: 636
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C1309w.m(android.util.AttributeSet, int):void");
    }

    public void n(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.f9253m) {
            this.f9252l = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                if (textView.isAttachedToWindow()) {
                    textView.post(new b(textView, typeface, this.f9250j));
                } else {
                    textView.setTypeface(typeface, this.f9250j);
                }
            }
        }
    }

    public void o(boolean z10, int i10, int i11, int i12, int i13) {
        if (b0.f9179a) {
            return;
        }
        c();
    }

    public void p() {
        b();
    }

    public void q(Context context, int i10) {
        String strO;
        U uT = U.t(context, i10, R$styleable.TextAppearance);
        int i11 = R$styleable.TextAppearance_textAllCaps;
        if (uT.s(i11)) {
            s(uT.a(i11, false));
        }
        int i12 = R$styleable.TextAppearance_android_textSize;
        if (uT.s(i12) && uT.f(i12, -1) == 0) {
            this.f9241a.setTextSize(0, 0.0f);
        }
        C(context, uT);
        int i13 = R$styleable.TextAppearance_fontVariationSettings;
        if (uT.s(i13) && (strO = uT.o(i13)) != null) {
            d.d(this.f9241a, strO);
        }
        uT.x();
        Typeface typeface = this.f9252l;
        if (typeface != null) {
            this.f9241a.setTypeface(typeface, this.f9250j);
        }
    }

    public void r(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
    }

    public void s(boolean z10) {
        this.f9241a.setAllCaps(z10);
    }

    public void t(int i10, int i11, int i12, int i13) throws IllegalArgumentException {
        this.f9249i.p(i10, i11, i12, i13);
    }

    public void u(int[] iArr, int i10) throws IllegalArgumentException {
        this.f9249i.q(iArr, i10);
    }

    public void v(int i10) {
        this.f9249i.r(i10);
    }

    public void w(ColorStateList colorStateList) {
        if (this.f9248h == null) {
            this.f9248h = new S();
        }
        S s10 = this.f9248h;
        s10.f9023a = colorStateList;
        s10.f9026d = colorStateList != null;
        z();
    }

    public void x(PorterDuff.Mode mode) {
        if (this.f9248h == null) {
            this.f9248h = new S();
        }
        S s10 = this.f9248h;
        s10.f9024b = mode;
        s10.f9025c = mode != null;
        z();
    }

    public final void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] compoundDrawablesRelative = this.f9241a.getCompoundDrawablesRelative();
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            TextView textView = this.f9241a;
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative2 = this.f9241a.getCompoundDrawablesRelative();
        Drawable drawable7 = compoundDrawablesRelative2[0];
        if (drawable7 != null || compoundDrawablesRelative2[2] != null) {
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative2[1];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative2[3];
            }
            this.f9241a.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, compoundDrawablesRelative2[2], drawable4);
            return;
        }
        Drawable[] compoundDrawables = this.f9241a.getCompoundDrawables();
        TextView textView2 = this.f9241a;
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

    public final void z() {
        S s10 = this.f9248h;
        this.f9242b = s10;
        this.f9243c = s10;
        this.f9244d = s10;
        this.f9245e = s10;
        this.f9246f = s10;
        this.f9247g = s10;
    }
}
