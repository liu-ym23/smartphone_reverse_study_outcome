package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: compiled from: AppCompatTextHelper.java */
/* JADX INFO: loaded from: classes.dex */
class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView f450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private x f451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private x f452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private x f453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private x f454e;
    private x f;
    private x g;
    private x h;
    private final n i;
    private int j;
    private int k;
    private Typeface l;
    private boolean m;

    /* JADX INFO: compiled from: AppCompatTextHelper.java */
    static class a {
        static void a(TextView r0, Locale r1) {
            r0.setTextLocale(r1);
        }

        static void a(TextView r0, Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
            r0.setCompoundDrawablesRelativeWithIntrinsicBounds(r1, r2, r3, r4);
        }

        static Drawable[] a(TextView r0) {
            return r0.getCompoundDrawablesRelative();
        }
    }

    /* JADX INFO: compiled from: AppCompatTextHelper.java */
    static class b {
        static Locale a(String r0) {
            return Locale.forLanguageTag(r0);
        }
    }

    /* JADX INFO: compiled from: AppCompatTextHelper.java */
    static class c {
        static void a(TextView r0, LocaleList r1) {
            r0.setTextLocales(r1);
        }

        static LocaleList a(String r0) {
            return LocaleList.forLanguageTags(r0);
        }
    }

    /* JADX INFO: compiled from: AppCompatTextHelper.java */
    static class d {
        static boolean a(TextView r0, String r1) {
            return r0.setFontVariationSettings(r1);
        }

        static int a(TextView r0) {
            return r0.getAutoSizeStepGranularity();
        }

        static void a(TextView r0, int r1, int r2, int r3, int r4) {
            r0.setAutoSizeTextTypeUniformWithConfiguration(r1, r2, r3, r4);
        }

        static void a(TextView r0, int[] r1, int r2) {
            r0.setAutoSizeTextTypeUniformWithPresetSizes(r1, r2);
        }
    }

    /* JADX INFO: compiled from: AppCompatTextHelper.java */
    static class e {
        static Typeface a(Typeface r0, int r1, boolean r2) {
            return Typeface.create(r0, r1, r2);
        }
    }

    m(TextView r2) {
        this.j = 0;
        this.k = -1;
        this.f450a = r2;
        this.i = new n(r2);
    }

    void a(AttributeSet r24, int r25) {
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r24, AttributeSet.class, "com.obric.aiagent.plugin");
        Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f450a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        androidx.appcompat.widget.d r11 = androidx.appcompat.widget.d.b();
        y r13 = y.a(r10, r9, R.styleable.AppCompatTextHelper, r25, 0);
        TextView r0 = this.f450a;
        ViewCompat.a(r0, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), R.styleable.AppCompatTextHelper, r9, r13.a(), r25, 0);
        int r1 = r13.g(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextHelper_android_textAppearance, "styleable", "AppCompatTextHelper_android_textAppearance"), -1);
        if (r13.g(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextHelper_android_drawableLeft, "styleable", "AppCompatTextHelper_android_drawableLeft")) == false) goto L6;
        this.f451b = a(r10, r11, r13.g(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextHelper_android_drawableLeft, "styleable", "AppCompatTextHelper_android_drawableLeft"), 0));
    L6:
        if (r13.g(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextHelper_android_drawableTop, "styleable", "AppCompatTextHelper_android_drawableTop")) == false) goto L9;
        this.f452c = a(r10, r11, r13.g(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextHelper_android_drawableTop, "styleable", "AppCompatTextHelper_android_drawableTop"), 0));
    L9:
        if (r13.g(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextHelper_android_drawableRight, "styleable", "AppCompatTextHelper_android_drawableRight")) == false) goto L12;
        this.f453d = a(r10, r11, r13.g(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextHelper_android_drawableRight, "styleable", "AppCompatTextHelper_android_drawableRight"), 0));
    L12:
        if (r13.g(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextHelper_android_drawableBottom, "styleable", "AppCompatTextHelper_android_drawableBottom")) == false) goto L15;
        this.f454e = a(r10, r11, r13.g(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextHelper_android_drawableBottom, "styleable", "AppCompatTextHelper_android_drawableBottom"), 0));
    L15:
        if (Build.VERSION.SDK_INT >= 17) goto L17;
    L22:
        r13.b();
        boolean r2 = ZeusTransformUtils.instanceOf(this.f450a.getTransformationMethod(), PasswordTransformationMethod.class);
        if (r1 == (-1)) goto L56;
        y r3 = y.a(r10, r1, R.styleable.TextAppearance);
        if (r2 == false) goto L27;
    L29:
        boolean r12 = false;
        boolean r15 = false;
    L30:
        a(r10, r3);
        boolean r16 = r12;
        boolean r17 = r15;
        if (Build.VERSION.SDK_INT < 23) goto L33;
        ColorStateList r18 = null;
        ColorStateList r19 = null;
        ColorStateList r110 = null;
    L46:
        if (r3.g(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_textLocale, "styleable", "TextAppearance_textLocale")) == false) goto L48;
        String r20 = r3.d(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_textLocale, "styleable", "TextAppearance_textLocale"));
    L49:
        ColorStateList r21 = r18;
        if (Build.VERSION.SDK_INT >= 26) goto L52;
    L54:
        String r14 = null;
    L55:
        r3.b();
        ColorStateList r111 = r21;
        ColorStateList r22 = r110;
        String r112 = r14;
        ColorStateList r113 = r22;
    L57:
        ColorStateList r23 = r113;
        y r4 = y.a(r10, r9, R.styleable.TextAppearance, r25, 0);
        if (r2 == false) goto L60;
    L62:
        boolean r5 = r17;
    L63:
        ColorStateList r26 = r111;
        if (Build.VERSION.SDK_INT < 23) goto L66;
        ColorStateList r114 = r26;
        ColorStateList r6 = r19;
        ColorStateList r115 = r23;
    L79:
        if (r4.g(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_textLocale, "styleable", "TextAppearance_textLocale")) == false) goto L81;
        r20 = r4.d(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_textLocale, "styleable", "TextAppearance_textLocale"));
    L81:
        String r7 = r20;
        if (Build.VERSION.SDK_INT >= 26) goto L84;
    L86:
        String r8 = r112;
    L88:
        if (Build.VERSION.SDK_INT < 28) goto L95;
        if (r4.g(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textSize, "styleable", "TextAppearance_android_textSize")) == false) goto L95;
        if (r4.e(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textSize, "styleable", "TextAppearance_android_textSize"), -1) != 0) goto L95;
        this.f450a.setTextSize(0, 0.0f);
    L95:
        a(r10, r4);
        r4.b();
        if (r115 == null) goto L98;
        this.f450a.setTextColor(r115);
    L98:
        if (r6 == null) goto L100;
        this.f450a.setHintTextColor(r6);
    L100:
        if (r114 == null) goto L102;
        this.f450a.setLinkTextColor(r114);
    L102:
        if (r2 == true) goto L105;
        if (r16 == false) goto L105;
        a(r5);
    L105:
        Typeface r27 = this.l;
        if (r27 != null) goto L108;
    L111:
        if (r8 == null) goto L113;
        d.a(this.f450a, r8);
    L113:
        if (r7 != null) goto L115;
    L120:
        this.i.a(r9, r25);
        if (ac.f411a == true) goto L123;
    L130:
        y r28 = y.a(r10, r9, R.styleable.AppCompatTextView);
        int r29 = r28.g(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_drawableLeftCompat, "styleable", "AppCompatTextView_drawableLeftCompat"), -1);
        if (r29 == (-1)) goto L133;
        Drawable r30 = r11.a(r10, r29);
    L134:
        int r31 = r28.g(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_drawableTopCompat, "styleable", "AppCompatTextView_drawableTopCompat"), -1);
        if (r31 == (-1)) goto L137;
        Drawable r32 = r11.a(r10, r31);
    L138:
        int r33 = r28.g(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_drawableRightCompat, "styleable", "AppCompatTextView_drawableRightCompat"), -1);
        if (r33 == (-1)) goto L141;
        Drawable r34 = r11.a(r10, r33);
    L142:
        int r35 = r28.g(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_drawableBottomCompat, "styleable", "AppCompatTextView_drawableBottomCompat"), -1);
        if (r35 == (-1)) goto L145;
        Drawable r36 = r11.a(r10, r35);
    L146:
        int r37 = r28.g(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_drawableStartCompat, "styleable", "AppCompatTextView_drawableStartCompat"), -1);
        if (r37 == (-1)) goto L149;
        Drawable r38 = r11.a(r10, r37);
    L150:
        int r39 = r28.g(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_drawableEndCompat, "styleable", "AppCompatTextView_drawableEndCompat"), -1);
        if (r39 == (-1)) goto L153;
        Drawable r116 = r11.a(r10, r39);
    L154:
        a(r30, r32, r34, r36, r38, r116);
        if (r28.g(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_drawableTint, "styleable", "AppCompatTextView_drawableTint")) == false) goto L158;
        TextViewCompat.a(this.f450a, r28.e(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_drawableTint, "styleable", "AppCompatTextView_drawableTint")));
    L158:
        if (r28.g(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_drawableTintMode, "styleable", "AppCompatTextView_drawableTintMode")) == false) goto L160;
        int r40 = -1;
        TextViewCompat.a(this.f450a, q.a(r28.a(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_drawableTintMode, "styleable", "AppCompatTextView_drawableTintMode"), -1), null));
    L161:
        int r41 = r28.e(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_firstBaselineToTopHeight, "styleable", "AppCompatTextView_firstBaselineToTopHeight"), r40);
        int r42 = r28.e(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_lastBaselineToBottomHeight, "styleable", "AppCompatTextView_lastBaselineToBottomHeight"), r40);
        int r43 = r28.e(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_lineHeight, "styleable", "AppCompatTextView_lineHeight"), r40);
        r28.b();
        if (r41 == r40) goto L164;
        TextViewCompat.b(this.f450a, r41);
    L164:
        if (r42 == r40) goto L166;
        TextViewCompat.c(this.f450a, r42);
    L166:
        if (r43 == r40) goto L169;
        TextViewCompat.d(this.f450a, r43);
        return;
    L169:
        return;
    L160:
        r40 = -1;
        goto L161
    L153:
        r116 = null;
        goto L154
    L149:
        r38 = null;
        goto L150
    L145:
        r36 = null;
        goto L146
    L141:
        r34 = null;
        goto L142
    L137:
        r32 = null;
        goto L138
    L133:
        r30 = null;
        goto L134
    L123:
        if (this.i.a() == 0) goto L130;
        int[] r44 = this.i.e();
        if (r44.length <= 0) goto L130;
        if (d.a(this.f450a) == (-1.0f)) goto L129;
        d.a(this.f450a, this.i.c(), this.i.d(), this.i.b(), 0);
        goto L130
    L129:
        d.a(this.f450a, r44, 0);
        goto L130
    L115:
        if (Build.VERSION.SDK_INT < 24) goto L118;
        c.a(this.f450a, c.a(r7));
        goto L120
    L118:
        if (Build.VERSION.SDK_INT < 21) goto L120;
        a.a(this.f450a, b.a(r7.split(",")[0]));
        goto L120
    L108:
        if (this.k != (-1)) goto L110;
        this.f450a.setTypeface(r27, this.j);
        goto L111
    L110:
        this.f450a.setTypeface(r27);
        goto L111
    L84:
        if (r4.g(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_fontVariationSettings, "styleable", "TextAppearance_fontVariationSettings")) == false) goto L86;
        r8 = r4.d(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_fontVariationSettings, "styleable", "TextAppearance_fontVariationSettings"));
        goto L88
    L66:
        if (r4.g(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColor, "styleable", "TextAppearance_android_textColor")) == false) goto L68;
        r115 = r4.e(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColor, "styleable", "TextAppearance_android_textColor"));
    L70:
        if (r4.g(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColorHint, "styleable", "TextAppearance_android_textColorHint")) == false) goto L73;
        r19 = r4.e(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColorHint, "styleable", "TextAppearance_android_textColorHint"));
    L73:
        if (r4.g(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColorLink, "styleable", "TextAppearance_android_textColorLink")) == false) goto L75;
        r114 = r4.e(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColorLink, "styleable", "TextAppearance_android_textColorLink"));
    L76:
        r6 = r19;
        goto L79
    L75:
        r114 = r26;
        goto L76
    L68:
        r115 = r23;
        goto L70
    L60:
        if (r4.g(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_textAllCaps, "styleable", "TextAppearance_textAllCaps")) == false) goto L62;
        r5 = r4.a(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_textAllCaps, "styleable", "TextAppearance_textAllCaps"), false);
        r16 = true;
        goto L63
    L52:
        if (r3.g(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_fontVariationSettings, "styleable", "TextAppearance_fontVariationSettings")) == false) goto L54;
        r14 = r3.d(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_fontVariationSettings, "styleable", "TextAppearance_fontVariationSettings"));
        goto L55
    L48:
        r20 = null;
        goto L49
    L33:
        if (r3.g(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColor, "styleable", "TextAppearance_android_textColor")) == false) goto L35;
        ColorStateList r117 = r3.e(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColor, "styleable", "TextAppearance_android_textColor"));
    L37:
        if (r3.g(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColorHint, "styleable", "TextAppearance_android_textColorHint")) == false) goto L39;
        ColorStateList r118 = r3.e(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColorHint, "styleable", "TextAppearance_android_textColorHint"));
    L41:
        if (r3.g(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColorLink, "styleable", "TextAppearance_android_textColorLink")) == false) goto L43;
        r110 = r117;
        r19 = r118;
        r18 = r3.e(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColorLink, "styleable", "TextAppearance_android_textColorLink"));
        goto L46
    L43:
        r110 = r117;
        r19 = r118;
        r18 = null;
        goto L46
    L39:
        r118 = null;
        goto L41
    L35:
        r117 = null;
        goto L37
    L27:
        if (r3.g(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_textAllCaps, "styleable", "TextAppearance_textAllCaps")) == false) goto L29;
        r15 = r3.a(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_textAllCaps, "styleable", "TextAppearance_textAllCaps"), false);
        r12 = true;
        goto L30
    L56:
        r113 = null;
        r111 = null;
        r16 = false;
        r17 = false;
        r19 = null;
        r112 = null;
        r20 = null;
        goto L57
    L17:
        if (r13.g(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextHelper_android_drawableStart, "styleable", "AppCompatTextHelper_android_drawableStart")) == false) goto L20;
        this.f = a(r10, r11, r13.g(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextHelper_android_drawableStart, "styleable", "AppCompatTextHelper_android_drawableStart"), 0));
    L20:
        if (r13.g(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextHelper_android_drawableEnd, "styleable", "AppCompatTextHelper_android_drawableEnd")) == false) goto L22;
        this.g = a(r10, r11, r13.g(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextHelper_android_drawableEnd, "styleable", "AppCompatTextHelper_android_drawableEnd"), 0));
        goto L22
    }

    private void a(Context r10, y r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        this.j = r11.a(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textStyle, "styleable", "TextAppearance_android_textStyle"), this.j);
        boolean r5 = false;
        if (Build.VERSION.SDK_INT < 28) goto L8;
        int r0 = r11.a(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textFontWeight, "styleable", "TextAppearance_android_textFontWeight"), -1);
        this.k = r0;
        if (r0 == (-1)) goto L8;
        this.j = (this.j & 2) | 0;
    L8:
        if (r11.g(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_fontFamily, "styleable", "TextAppearance_android_fontFamily")) == false) goto L10;
    L24:
        this.l = null;
        if (r11.g(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_fontFamily, "styleable", "TextAppearance_fontFamily")) == false) goto L27;
        int r1 = ZeusTransformUtils.mapRes(R.styleable.TextAppearance_fontFamily, "styleable", "TextAppearance_fontFamily");
    L28:
        final int r2 = this.k;
        final int r6 = this.j;
        if (r12.isRestricted() == true) goto L49;
        final WeakReference r13 = new WeakReference(this.f450a);
        Typeface r14 = r11.a(r1, this.j, new AnonymousClass1(this, r2, r6, r13));     // Catch: Throwable -> L62
        if (r14 == null) goto L44;
        if (Build.VERSION.SDK_INT >= 28) goto L36;
    L42:
        this.l = r14;     // Catch: Throwable -> L62
        goto L44
    L36:
        if (this.k == (-1)) goto L42;
        Typeface r15 = Typeface.create(r14, 0);     // Catch: Throwable -> L62
        int r3 = this.k;     // Catch: Throwable -> L62
        if ((this.j & 2) == 0) goto L40;
        boolean r7 = true;
    L41:
        this.l = e.a(r15, r3, r7);     // Catch: Throwable -> L62
        goto L44
    L40:
        r7 = false;
    L44:
        if (this.l != null) goto L46;
        boolean r16 = true;
    L47:
        this.m = r16;     // Catch: Throwable -> L62
        goto L49
    L46:
        r16 = false;
    L49:
        if (this.l != null) goto L69;
        String r17 = r11.d(r1);
        if (r17 != null) goto L53;
        return;
    L53:
        if (Build.VERSION.SDK_INT >= 28) goto L55;
    L60:
        this.l = Typeface.create(r17, this.j);
        return;
    L55:
        if (this.k == (-1)) goto L60;
        Typeface r18 = Typeface.create(r17, 0);
        int r19 = this.k;
        if ((this.j & 2) == 0) goto L59;
        r5 = true;
    L59:
        this.l = e.a(r18, r19, r5);
        return;
    L69:
        return;
    L27:
        r1 = ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_fontFamily, "styleable", "TextAppearance_android_fontFamily");
        goto L28
    L10:
        if (r11.g(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_fontFamily, "styleable", "TextAppearance_fontFamily")) == true) goto L24;
        if (r11.g(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_typeface, "styleable", "TextAppearance_android_typeface")) == false) goto L65;
        this.m = false;
        int r110 = r11.a(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_typeface, "styleable", "TextAppearance_android_typeface"), 1);
        if (r110 == 1) goto L22;
        if (r110 != 2) goto L18;
        this.l = Typeface.SERIF;
        return;
    L18:
        if (r110 != 3) goto L68;
        this.l = Typeface.MONOSPACE;
        return;
    L68:
        return;
    L22:
        this.l = Typeface.SANS_SERIF;
        return;
    }

    void a(WeakReference<TextView> r3, final Typeface r4) {
        if (this.m == false) goto L11;
        this.l = r4;
        final TextView r5 = (TextView) ZeusTransformUtils.preCheckCast(r3.get(), TextView.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L7;
        return;
    L7:
        if (ViewCompat.I(r5) == false) goto L9;
        final int r0 = this.j;
        r5.post(new AnonymousClass2(this, r5, r4, r0));
        return;
    L9:
        r5.setTypeface(r4, this.j);
        return;
    }

    void a(Context r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        y r8 = y.a(r7, r6, R.styleable.TextAppearance);
        if (r8.g(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_textAllCaps, "styleable", "TextAppearance_textAllCaps")) == false) goto L6;
        a(r8.a(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_textAllCaps, "styleable", "TextAppearance_textAllCaps"), false));
    L6:
        if (Build.VERSION.SDK_INT >= 23) goto L23;
        if (r8.g(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColor, "styleable", "TextAppearance_android_textColor")) == false) goto L13;
        ColorStateList r0 = r8.e(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColor, "styleable", "TextAppearance_android_textColor"));
        if (r0 == null) goto L13;
        this.f450a.setTextColor(r0);
    L13:
        if (r8.g(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColorLink, "styleable", "TextAppearance_android_textColorLink")) == false) goto L18;
        ColorStateList r1 = r8.e(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColorLink, "styleable", "TextAppearance_android_textColorLink"));
        if (r1 == null) goto L18;
        this.f450a.setLinkTextColor(r1);
    L18:
        if (r8.g(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColorHint, "styleable", "TextAppearance_android_textColorHint")) == false) goto L23;
        ColorStateList r2 = r8.e(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColorHint, "styleable", "TextAppearance_android_textColorHint"));
        if (r2 == null) goto L23;
        this.f450a.setHintTextColor(r2);
    L23:
        if (r8.g(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textSize, "styleable", "TextAppearance_android_textSize")) == true) goto L25;
    L27:
        a(r7, r8);
        if (Build.VERSION.SDK_INT >= 26) goto L30;
    L34:
        r8.b();
        Typeface r9 = this.l;
        if (r9 == null) goto L38;
        this.f450a.setTypeface(r9, this.j);
        return;
    L38:
        return;
    L30:
        if (r8.g(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_fontVariationSettings, "styleable", "TextAppearance_fontVariationSettings")) == false) goto L34;
        String r10 = r8.d(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_fontVariationSettings, "styleable", "TextAppearance_fontVariationSettings"));
        if (r10 == null) goto L34;
        d.a(this.f450a, r10);
        goto L34
    L25:
        if (r8.e(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textSize, "styleable", "TextAppearance_android_textSize"), -1) != 0) goto L27;
        this.f450a.setTextSize(0, 0.0f);
        goto L27
    }

    void a(boolean r1) {
        this.f450a.setAllCaps(r1);
    }

    void a() {
        b();
    }

    void b() {
        if (this.f451b == null) goto L5;
    L10:
        Drawable[] r0 = this.f450a.getCompoundDrawables();
        a(r0[0], this.f451b);
        a(r0[1], this.f452c);
        a(r0[2], this.f453d);
        a(r0[3], this.f454e);
    L12:
        if (Build.VERSION.SDK_INT >= 17) goto L14;
        return;
    L14:
        if (this.f == null) goto L16;
    L17:
        Drawable[] r1 = a.a(this.f450a);
        a(r1[0], this.f);
        a(r1[2], this.g);
        return;
    L16:
        if (this.g != null) goto L17;
        return;
    L5:
        if (this.f452c != null) goto L10;
        if (this.f453d != null) goto L10;
        if (this.f454e == null) goto L12;
        goto L10
    }

    private void a(Drawable r1, x r2) {
        if (r1 == null) goto L6;
        if (r2 == null) goto L7;
        androidx.appcompat.widget.d.a(r1, r2, this.f450a.getDrawableState());
        return;
    L7:
        return;
    }

    private static x a(Context r2, androidx.appcompat.widget.d r3, int r4) {
        ColorStateList r5 = r3.b((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r4);
        if (r5 == null) goto L6;
        x r6 = new x();
        r6.f496d = true;
        r6.f493a = r5;
        return r6;
    L6:
        return null;
    }

    void a(boolean r1, int r2, int r3, int r4, int r5) {
        if (ac.f411a == true) goto L6;
        c();
        return;
    }

    void a(int r2, float r3) {
        if (ac.f411a == false) goto L5;
        return;
    L5:
        if (d() == true) goto L9;
        b(r2, r3);
        return;
    }

    void c() {
        this.i.f();
    }

    boolean d() {
        return this.i.g();
    }

    private void b(int r1, float r2) {
        this.i.a(r1, r2);
    }

    void a(int r1) {
        this.i.a(r1);
    }

    void a(int r1, int r2, int r3, int r4) {
        this.i.a(r1, r2, r3, r4);
    }

    void a(int[] r1, int r2) {
        this.i.a(r1, r2);
    }

    int e() {
        return this.i.a();
    }

    int f() {
        return this.i.b();
    }

    int g() {
        return this.i.c();
    }

    int h() {
        return this.i.d();
    }

    int[] i() {
        return this.i.e();
    }

    ColorStateList j() {
        x r0 = this.h;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f493a;
    }

    void a(ColorStateList r2) {
        if (this.h != null) goto L5;
        this.h = new x();
    L5:
        this.h.f493a = r2;
        x r0 = this.h;
        if (r2 == null) goto L8;
        boolean r3 = true;
    L9:
        r0.f496d = r3;
        l();
        return;
    L8:
        r3 = false;
        goto L9
    }

    PorterDuff.Mode k() {
        x r0 = this.h;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f494b;
    }

    void a(PorterDuff.Mode r2) {
        if (this.h != null) goto L5;
        this.h = new x();
    L5:
        this.h.f494b = r2;
        x r0 = this.h;
        if (r2 == null) goto L8;
        boolean r3 = true;
    L9:
        r0.f495c = r3;
        l();
        return;
    L8:
        r3 = false;
        goto L9
    }

    private void l() {
        x r0 = this.h;
        this.f451b = r0;
        this.f452c = r0;
        this.f453d = r0;
        this.f454e = r0;
        this.f = r0;
        this.g = r0;
    }

    private void a(Drawable r7, Drawable r8, Drawable r9, Drawable r10, Drawable r11, Drawable r12) {
        if (Build.VERSION.SDK_INT < 17) goto L20;
        if (r11 != null) goto L6;
        if (r12 == null) goto L20;
    L6:
        Drawable[] r13 = a.a(this.f450a);
        TextView r6 = this.f450a;
        if (r11 != null) goto L10;
        r11 = r13[0];
    L10:
        if (r8 != null) goto L13;
        r8 = r13[1];
    L13:
        if (r12 != null) goto L16;
        r12 = r13[2];
    L16:
        if (r10 != null) goto L19;
        r10 = r13[3];
    L19:
        a.a(r6, r11, r8, r12, r10);
        return;
    L20:
        if (r7 != null) goto L25;
        if (r8 != null) goto L25;
        if (r9 != null) goto L25;
        if (r10 != null) goto L25;
        return;
    L25:
        if (Build.VERSION.SDK_INT < 17) goto L40;
        Drawable[] r14 = a.a(this.f450a);
        if (r14[0] == null) goto L29;
    L30:
        TextView r15 = this.f450a;
        Drawable r16 = r14[0];
        if (r8 != null) goto L34;
        r8 = r14[1];
    L34:
        Drawable r17 = r14[2];
        if (r10 != null) goto L38;
        r10 = r14[3];
    L38:
        a.a(r15, r16, r8, r17, r10);
        return;
    L29:
        if (r14[2] != null) goto L30;
    L40:
        Drawable[] r18 = this.f450a.getCompoundDrawables();
        TextView r19 = this.f450a;
        if (r7 != null) goto L44;
        r7 = r18[0];
    L44:
        if (r8 != null) goto L47;
        r8 = r18[1];
    L47:
        if (r9 != null) goto L50;
        r9 = r18[2];
    L50:
        if (r10 != null) goto L53;
        r10 = r18[3];
    L53:
        r19.setCompoundDrawablesWithIntrinsicBounds(r7, r8, r9, r10);
    }

    void a(TextView r2, InputConnection r3, EditorInfo r4) {
        InputConnection r1 = (InputConnection) ZeusTransformUtils.wrapperContextForParams(r3, InputConnection.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 30) goto L7;
        if (r1 == null) goto L8;
        androidx.core.view.inputmethod.a.a(r4, r2.getText());
        return;
    L8:
        return;
    }
}
