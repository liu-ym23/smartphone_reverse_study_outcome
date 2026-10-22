package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f1050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z f1051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public z f1052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public z f1053d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public z f1054e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public z f1055f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public z f1056g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public z f1057h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final q f1058i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f1059j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1060k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Typeface f1061l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f1062m;

    public class a extends androidx.core.content.res.a.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f1063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f1064b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WeakReference f1065c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ o f1066d;

        public a(o r10, int r11, int r12, WeakReference r13) {
            this.f1066d = r10;
            this.f1063a = r11;
            this.f1064b = r12;
            this.f1065c = r13;
        }

        @Override // androidx.core.content.res.a.e
        public void onFontRetrievalFailed(int r10) {
        }

        @Override // androidx.core.content.res.a.e
        public void onFontRetrieved(Typeface r10) {
            int r11 = this.f1063a;
            if (r11 != (-1)) goto L5;
        L9:
            this.f1066d.n(this.f1065c, r10);
            return;
        L5:
            if ((this.f1064b & 2) == 0) goto L7;
            boolean r12 = true;
        L8:
            r10 = f.a(r10, r11, r12);
            goto L9
        L7:
            r12 = false;
            goto L8
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f1067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Typeface f1068b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f1069c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ o f1070d;

        public b(o r10, TextView r11, Typeface r12, int r13) {
            this.f1070d = r10;
            this.f1067a = r11;
            this.f1068b = r12;
            this.f1069c = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1067a.setTypeface(this.f1068b, this.f1069c);
        }
    }

    public static class c {
        @DoNotInline
        public static Drawable[] a(TextView r10) {
            return r10.getCompoundDrawablesRelative();
        }

        @DoNotInline
        public static void b(TextView r10, Drawable r11, Drawable r12, Drawable r13, Drawable r14) {
            r10.setCompoundDrawablesRelativeWithIntrinsicBounds(r11, r12, r13, r14);
        }

        @DoNotInline
        public static void c(TextView r10, Locale r11) {
            r10.setTextLocale(r11);
        }
    }

    public static class d {
        @DoNotInline
        public static LocaleList a(String r10) {
            return LocaleList.forLanguageTags(r10);
        }

        @DoNotInline
        public static void b(TextView r10, LocaleList r11) {
            r10.setTextLocales(r11);
        }
    }

    public static class e {
        @DoNotInline
        public static int a(TextView r10) {
            return r10.getAutoSizeStepGranularity();
        }

        @DoNotInline
        public static void b(TextView r10, int r11, int r12, int r13, int r14) {
            r10.setAutoSizeTextTypeUniformWithConfiguration(r11, r12, r13, r14);
        }

        @DoNotInline
        public static void c(TextView r10, int[] r11, int r12) {
            r10.setAutoSizeTextTypeUniformWithPresetSizes(r11, r12);
        }

        @DoNotInline
        public static boolean d(TextView r10, String r11) {
            return r10.setFontVariationSettings(r11);
        }
    }

    public static class f {
        @DoNotInline
        public static Typeface a(Typeface r10, int r11, boolean r12) {
            return Typeface.create(r10, r11, r12);
        }
    }

    public o(TextView r10) {
        this.f1059j = 0;
        this.f1060k = -1;
        this.f1050a = r10;
        this.f1058i = new q(r10);
    }

    public static z d(Context r10, androidx.appcompat.widget.f r11, int r12) {
        ColorStateList r13 = r11.f(r10, r12);
        if (r13 == null) goto L6;
        z r14 = new z();
        r14.f1164d = true;
        r14.f1161a = r13;
        return r14;
    L6:
        return null;
    }

    public void A(int r10, float r11) {
        if (i0.f1034b == false) goto L5;
        return;
    L5:
        if (l() == true) goto L9;
        B(r10, r11);
        return;
    }

    public final void B(int r10, float r11) {
        this.f1058i.t(r10, r11);
    }

    public final void C(Context r10, b0 r11) {
        this.f1059j = r11.k(R$styleable.TextAppearance_android_textStyle, this.f1059j);
        int r12 = r11.k(R$styleable.TextAppearance_android_textFontWeight, -1);
        this.f1060k = r12;
        if (r12 == (-1)) goto L5;
        this.f1059j &= 2;
    L5:
        int r13 = R$styleable.TextAppearance_android_fontFamily;
        boolean r14 = true;
        if (r11.s(r13) == false) goto L8;
    L22:
        this.f1061l = null;
        int r15 = R$styleable.TextAppearance_fontFamily;
        if (r11.s(r15) == false) goto L25;
        r13 = r15;
    L25:
        int r16 = this.f1060k;
        int r17 = this.f1059j;
        if (r10.isRestricted() == true) goto L44;
        Typeface r18 = r11.j(r13, this.f1059j, new a(this, r16, r17, new WeakReference(this.f1050a)));     // Catch: Throwable -> L56
        if (r18 == null) goto L39;
        if (this.f1060k == (-1)) goto L37;
        Typeface r19 = Typeface.create(r18, 0);     // Catch: Throwable -> L56
        int r20 = this.f1060k;     // Catch: Throwable -> L56
        if ((this.f1059j & 2) == 0) goto L35;
        boolean r21 = true;
    L36:
        this.f1061l = f.a(r19, r20, r21);     // Catch: Throwable -> L56
        goto L39
    L35:
        r21 = false;
        goto L36
    L37:
        this.f1061l = r18;     // Catch: Throwable -> L56
    L39:
        if (this.f1061l != null) goto L41;
        boolean r22 = true;
    L42:
        this.f1062m = r22;     // Catch: Throwable -> L56
        goto L44
    L41:
        r22 = false;
    L44:
        if (this.f1061l != null) goto L63;
        String r23 = r11.o(r13);
        if (r23 != null) goto L48;
        return;
    L48:
        if (this.f1060k == (-1)) goto L54;
        Typeface r24 = Typeface.create(r23, 0);
        int r110 = this.f1060k;
        if ((this.f1059j & 2) != 0) goto L53;
        r14 = false;
    L53:
        this.f1061l = f.a(r24, r110, r14);
        return;
    L54:
        this.f1061l = Typeface.create(r23, this.f1059j);
        return;
    L63:
        return;
    L8:
        if (r11.s(R$styleable.TextAppearance_fontFamily) == true) goto L22;
        int r25 = R$styleable.TextAppearance_android_typeface;
        if (r11.s(r25) == false) goto L59;
        this.f1062m = false;
        int r26 = r11.k(r25, 1);
        if (r26 == 1) goto L20;
        if (r26 != 2) goto L16;
        this.f1061l = Typeface.SERIF;
        return;
    L16:
        if (r26 != 3) goto L62;
        this.f1061l = Typeface.MONOSPACE;
        return;
    L62:
        return;
    L20:
        this.f1061l = Typeface.SANS_SERIF;
        return;
    }

    public final void a(Drawable r10, z r11) {
        if (r10 == null) goto L6;
        if (r11 == null) goto L7;
        androidx.appcompat.widget.f.i(r10, r11, this.f1050a.getDrawableState());
        return;
    L7:
        return;
    }

    public void b() {
        if (this.f1051b == null) goto L5;
    L10:
        Drawable[] r10 = this.f1050a.getCompoundDrawables();
        a(r10[0], this.f1051b);
        a(r10[1], this.f1052c);
        a(r10[2], this.f1053d);
        a(r10[3], this.f1054e);
    L12:
        if (this.f1055f == null) goto L14;
    L15:
        Drawable[] r11 = c.a(this.f1050a);
        a(r11[0], this.f1055f);
        a(r11[2], this.f1056g);
        return;
    L14:
        if (this.f1056g != null) goto L15;
        return;
    L5:
        if (this.f1052c != null) goto L10;
        if (this.f1053d != null) goto L10;
        if (this.f1054e == null) goto L12;
        goto L10
    }

    public void c() {
        this.f1058i.a();
    }

    public int e() {
        return this.f1058i.f();
    }

    public int f() {
        return this.f1058i.g();
    }

    public int g() {
        return this.f1058i.h();
    }

    public int[] h() {
        return this.f1058i.i();
    }

    public int i() {
        return this.f1058i.j();
    }

    public ColorStateList j() {
        z r10 = this.f1057h;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.f1161a;
    }

    public PorterDuff.Mode k() {
        z r10 = this.f1057h;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.f1162b;
    }

    public boolean l() {
        return this.f1058i.n();
    }

    public void m(AttributeSet r18, int r19) {
        Context r10 = this.f1050a.getContext();
        androidx.appcompat.widget.f r11 = androidx.appcompat.widget.f.b();
        int[] r12 = R$styleable.AppCompatTextHelper;
        b0 r13 = b0.v(r10, r18, r12, r19, 0);
        TextView r14 = this.f1050a;
        ViewCompat.n0(r14, r14.getContext(), r12, r18, r13.r(), r19, 0);
        int r15 = r13.n(R$styleable.AppCompatTextHelper_android_textAppearance, -1);
        int r16 = R$styleable.AppCompatTextHelper_android_drawableLeft;
        if (r13.s(r16) == false) goto L5;
        this.f1051b = d(r10, r11, r13.n(r16, 0));
    L5:
        int r17 = R$styleable.AppCompatTextHelper_android_drawableTop;
        if (r13.s(r17) == false) goto L8;
        this.f1052c = d(r10, r11, r13.n(r17, 0));
    L8:
        int r20 = R$styleable.AppCompatTextHelper_android_drawableRight;
        if (r13.s(r20) == false) goto L11;
        this.f1053d = d(r10, r11, r13.n(r20, 0));
    L11:
        int r21 = R$styleable.AppCompatTextHelper_android_drawableBottom;
        if (r13.s(r21) == false) goto L14;
        this.f1054e = d(r10, r11, r13.n(r21, 0));
    L14:
        int r22 = R$styleable.AppCompatTextHelper_android_drawableStart;
        if (r13.s(r22) == false) goto L17;
        this.f1055f = d(r10, r11, r13.n(r22, 0));
    L17:
        int r23 = R$styleable.AppCompatTextHelper_android_drawableEnd;
        if (r13.s(r23) == false) goto L20;
        this.f1056g = d(r10, r11, r13.n(r23, 0));
    L20:
        r13.w();
        boolean r24 = this.f1050a.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean r25 = true;
        if (r15 == (-1)) goto L37;
        b0 r26 = b0.t(r10, r15, R$styleable.TextAppearance);
        if (r24 == true) goto L27;
        int r27 = R$styleable.TextAppearance_textAllCaps;
        if (r26.s(r27) == false) goto L27;
        boolean r28 = r26.a(r27, false);
        boolean r29 = true;
    L28:
        C(r10, r26);
        int r30 = R$styleable.TextAppearance_textLocale;
        if (r26.s(r30) == false) goto L31;
        String r31 = r26.o(r30);
    L32:
        int r32 = R$styleable.TextAppearance_fontVariationSettings;
        if (r26.s(r32) == false) goto L35;
        String r33 = r26.o(r32);
    L36:
        r26.w();
    L38:
        b0 r34 = b0.v(r10, r18, R$styleable.TextAppearance, r19, 0);
        if (r24 == true) goto L43;
        int r110 = R$styleable.TextAppearance_textAllCaps;
        if (r34.s(r110) == false) goto L43;
        r28 = r34.a(r110, false);
    L44:
        int r35 = R$styleable.TextAppearance_textLocale;
        if (r34.s(r35) == false) goto L47;
        r31 = r34.o(r35);
    L47:
        int r36 = R$styleable.TextAppearance_fontVariationSettings;
        if (r34.s(r36) == false) goto L50;
        r33 = r34.o(r36);
    L50:
        int r37 = R$styleable.TextAppearance_android_textSize;
        if (r34.s(r37) == true) goto L53;
    L55:
        C(r10, r34);
        r34.w();
        if (r24 == true) goto L59;
        if (r25 == false) goto L59;
        s(r28);
    L59:
        Typeface r38 = this.f1061l;
        if (r38 != null) goto L62;
    L65:
        if (r33 == null) goto L67;
        e.d(this.f1050a, r33);
    L67:
        if (r31 == null) goto L69;
        d.b(this.f1050a, d.a(r31));
    L69:
        this.f1058i.o(r18, r19);
        if (i0.f1034b == true) goto L72;
    L79:
        b0 r39 = b0.u(r10, r18, R$styleable.AppCompatTextView);
        int r40 = r39.n(R$styleable.AppCompatTextView_drawableLeftCompat, -1);
        if (r40 == (-1)) goto L82;
        Drawable r41 = r11.c(r10, r40);
    L83:
        int r42 = r39.n(R$styleable.AppCompatTextView_drawableTopCompat, -1);
        if (r42 == (-1)) goto L86;
        Drawable r43 = r11.c(r10, r42);
    L87:
        int r44 = r39.n(R$styleable.AppCompatTextView_drawableRightCompat, -1);
        if (r44 == (-1)) goto L90;
        Drawable r45 = r11.c(r10, r44);
    L91:
        int r46 = r39.n(R$styleable.AppCompatTextView_drawableBottomCompat, -1);
        if (r46 == (-1)) goto L94;
        Drawable r47 = r11.c(r10, r46);
    L95:
        int r48 = r39.n(R$styleable.AppCompatTextView_drawableStartCompat, -1);
        if (r48 == (-1)) goto L98;
        Drawable r49 = r11.c(r10, r48);
    L99:
        int r50 = r39.n(R$styleable.AppCompatTextView_drawableEndCompat, -1);
        if (r50 == (-1)) goto L102;
        Drawable r51 = r11.c(r10, r50);
    L103:
        y(r41, r43, r45, r47, r49, r51);
        int r52 = R$styleable.AppCompatTextView_drawableTint;
        if (r39.s(r52) == false) goto L106;
        TextViewCompat.g(this.f1050a, r39.c(r52));
    L106:
        int r53 = R$styleable.AppCompatTextView_drawableTintMode;
        if (r39.s(r53) == false) goto L109;
        TextViewCompat.h(this.f1050a, r.e(r39.k(r53, -1), null));
    L109:
        int r54 = r39.f(R$styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
        int r55 = r39.f(R$styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
        int r56 = r39.f(R$styleable.AppCompatTextView_lineHeight, -1);
        r39.w();
        if (r54 == (-1)) goto L112;
        TextViewCompat.j(this.f1050a, r54);
    L112:
        if (r55 == (-1)) goto L114;
        TextViewCompat.k(this.f1050a, r55);
    L114:
        if (r56 == (-1)) goto L117;
        TextViewCompat.l(this.f1050a, r56);
        return;
    L117:
        return;
    L102:
        r51 = null;
        goto L103
    L98:
        r49 = null;
        goto L99
    L94:
        r47 = null;
        goto L95
    L90:
        r45 = null;
        goto L91
    L86:
        r43 = null;
        goto L87
    L82:
        r41 = null;
        goto L83
    L72:
        if (this.f1058i.j() == 0) goto L79;
        int[] r57 = this.f1058i.i();
        if (r57.length <= 0) goto L79;
        if (e.a(this.f1050a) == (-1.0f)) goto L78;
        e.b(this.f1050a, this.f1058i.g(), this.f1058i.f(), this.f1058i.h(), 0);
        goto L79
    L78:
        e.c(this.f1050a, r57, 0);
        goto L79
    L62:
        if (this.f1060k != (-1)) goto L64;
        this.f1050a.setTypeface(r38, this.f1059j);
        goto L65
    L64:
        this.f1050a.setTypeface(r38);
        goto L65
    L53:
        if (r34.f(r37, -1) != 0) goto L55;
        this.f1050a.setTextSize(0, 0.0f);
    L43:
        r25 = r29;
        goto L44
    L35:
        r33 = null;
        goto L36
    L31:
        r31 = null;
    L27:
        r28 = false;
        r29 = false;
        goto L28
    L37:
        r28 = false;
        r29 = false;
        r31 = null;
        r33 = null;
        goto L38
    }

    public void n(WeakReference r10, Typeface r11) {
        if (this.f1062m == false) goto L11;
        this.f1061l = r11;
        TextView r12 = (TextView) r10.get();
        if (r12 != null) goto L7;
        return;
    L7:
        if (ViewCompat.S(r12) == false) goto L9;
        r12.post(new b(this, r12, r11, this.f1059j));
        return;
    L9:
        r12.setTypeface(r11, this.f1059j);
        return;
    }

    public void o(boolean r10, int r11, int r12, int r13, int r14) {
        if (i0.f1034b == true) goto L6;
        c();
        return;
    }

    public void p() {
        b();
    }

    public void q(Context r10, int r11) {
        b0 r12 = b0.t(r10, r11, R$styleable.TextAppearance);
        int r13 = R$styleable.TextAppearance_textAllCaps;
        if (r12.s(r13) == false) goto L5;
        s(r12.a(r13, false));
    L5:
        int r14 = R$styleable.TextAppearance_android_textSize;
        if (r12.s(r14) == true) goto L8;
    L10:
        C(r10, r12);
        int r15 = R$styleable.TextAppearance_fontVariationSettings;
        if (r12.s(r15) == false) goto L15;
        String r16 = r12.o(r15);
        if (r16 == null) goto L15;
        e.d(this.f1050a, r16);
    L15:
        r12.w();
        Typeface r17 = this.f1061l;
        if (r17 == null) goto L19;
        this.f1050a.setTypeface(r17, this.f1059j);
        return;
    L19:
        return;
    L8:
        if (r12.f(r14, -1) != 0) goto L10;
        this.f1050a.setTextSize(0, 0.0f);
        goto L10
    }

    public void r(TextView r10, InputConnection r11, EditorInfo r12) {
    }

    public void s(boolean r10) {
        this.f1050a.setAllCaps(r10);
    }

    public void t(int r10, int r11, int r12, int r13) {
        this.f1058i.p(r10, r11, r12, r13);
    }

    public void u(int[] r10, int r11) {
        this.f1058i.q(r10, r11);
    }

    public void v(int r10) {
        this.f1058i.r(r10);
    }

    public void w(ColorStateList r10) {
        if (this.f1057h != null) goto L5;
        this.f1057h = new z();
    L5:
        z r11 = this.f1057h;
        r11.f1161a = r10;
        if (r10 == null) goto L8;
        boolean r12 = true;
    L9:
        r11.f1164d = r12;
        z();
        return;
    L8:
        r12 = false;
        goto L9
    }

    public void x(PorterDuff.Mode r10) {
        if (this.f1057h != null) goto L5;
        this.f1057h = new z();
    L5:
        z r11 = this.f1057h;
        r11.f1162b = r10;
        if (r10 == null) goto L8;
        boolean r12 = true;
    L9:
        r11.f1163c = r12;
        z();
        return;
    L8:
        r12 = false;
        goto L9
    }

    public final void y(Drawable r10, Drawable r11, Drawable r12, Drawable r13, Drawable r14, Drawable r15) {
        if (r14 != null) goto L39;
        if (r15 != null) goto L39;
        if (r10 != null) goto L10;
        if (r11 != null) goto L10;
        if (r12 != null) goto L10;
        if (r13 != null) goto L10;
        return;
    L10:
        Drawable[] r16 = c.a(this.f1050a);
        Drawable r17 = r16[0];
        if (r17 == null) goto L13;
    L29:
        TextView r18 = this.f1050a;
        if (r11 != null) goto L33;
        r11 = r16[1];
    L33:
        Drawable r19 = r16[2];
        if (r13 != null) goto L37;
        r13 = r16[3];
    L37:
        c.b(r18, r17, r11, r19, r13);
        return;
    L13:
        if (r16[2] != null) goto L29;
        Drawable[] r110 = this.f1050a.getCompoundDrawables();
        TextView r20 = this.f1050a;
        if (r10 != null) goto L19;
        r10 = r110[0];
    L19:
        if (r11 != null) goto L22;
        r11 = r110[1];
    L22:
        if (r12 != null) goto L25;
        r12 = r110[2];
    L25:
        if (r13 != null) goto L28;
        r13 = r110[3];
    L28:
        r20.setCompoundDrawablesWithIntrinsicBounds(r10, r11, r12, r13);
        return;
    L39:
        Drawable[] r21 = c.a(this.f1050a);
        TextView r22 = this.f1050a;
        if (r14 != null) goto L43;
        r14 = r21[0];
    L43:
        if (r11 != null) goto L46;
        r11 = r21[1];
    L46:
        if (r15 != null) goto L49;
        r15 = r21[2];
    L49:
        if (r13 != null) goto L52;
        r13 = r21[3];
    L52:
        c.b(r22, r14, r11, r15, r13);
    }

    public final void z() {
        z r10 = this.f1057h;
        this.f1051b = r10;
        this.f1052c = r10;
        this.f1053d = r10;
        this.f1054e = r10;
        this.f1055f = r10;
        this.f1056g = r10;
    }
}
