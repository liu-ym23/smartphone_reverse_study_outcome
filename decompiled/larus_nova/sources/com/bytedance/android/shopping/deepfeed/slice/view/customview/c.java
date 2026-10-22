package com.bytedance.android.shopping.deepfeed.slice.view.customview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.view.View;
import com.bytedance.android.ec.core.utils.font.ECFontHelper;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class c extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f173478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f173479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f173480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f173481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f173482e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f173483f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f173484g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f173485h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f173486i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f173487j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f173488k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f173489l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f173490m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f173491n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f173492o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f173493p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f173494q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f173495r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f173496s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f173497t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f173498u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Paint.Align f173499v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ValueAnimator f173500w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f173501x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public g f173502y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final SlcTemplateContext f173503z;

    public static final class a {
    }

    static {
    }

    public final float g() {
        return RangesKt.coerceIn(this.f173497t / 200, 0.0f, 1.0f);
    }

    public final boolean i() {
        String r100 = this.f173487j;
        int r101 = 0;
    L4:
        if (r101 >= r100.length()) goto L15;
        if (r100.charAt(r101) == 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == true) goto L10;
        r101 = r101 + 1;
        goto L4
    L10:
        return true;
    L8:
        r102 = false;
        goto L9
    L15:
        return false;
    }

    public final boolean j() {
        String r100 = this.f173486i;
        int r101 = 0;
    L4:
        if (r101 >= r100.length()) goto L15;
        if (r100.charAt(r101) == 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == true) goto L10;
        r101 = r101 + 1;
        goto L4
    L10:
        return true;
    L8:
        r102 = false;
        goto L9
    L15:
        return false;
    }

    public final String l() {
        if (this.f173488k == true) goto L8;
        if (this.f173489l == false) goto L8;
        return StringsKt.repeat("0", RangesKt.coerceAtMost(this.f173481d.length(), 2));
    L8:
        return this.f173483f;
    }

    public final void o() {
        Paint.FontMetrics r100 = this.f173478a.getFontMetrics();
        Paint.FontMetrics r101 = this.f173479b.getFontMetrics();
        float r102 = r100.bottom;
        float r103 = r100.top;
        this.f173492o = r102 - r103;
        float r104 = r101.bottom;
        float r105 = r101.top;
        this.f173493p = r104 - r105;
        float r106 = Math.max(-r103, -r105);
        this.f173494q = r106;
        this.f173495r = r106 + Math.max(r100.bottom, r101.bottom);
        Iterator<Character> r107 = new CharRange('0', '9').iterator();
        if (r107.hasNext() == false) goto L19;
        CharIterator r108 = (CharIterator) r107;
        char r109 = r108.nextChar();
        float r110 = this.f173478a.measureText(String.valueOf(r109));
    L6:
        if (r107.hasNext() == false) goto L8;
        char r111 = r108.nextChar();
        r110 = Math.max(r110, this.f173478a.measureText(String.valueOf(r111)));
        goto L6
    L8:
        this.f173490m = RangesKt.coerceAtLeast(r110, this.f173478a.measureText("."));
        Iterator<Character> r112 = new CharRange('0', '9').iterator();
        if (r112.hasNext() == false) goto L17;
        CharIterator r113 = (CharIterator) r112;
        char r114 = r113.nextChar();
        float r115 = this.f173479b.measureText(String.valueOf(r114));
    L12:
        if (r112.hasNext() == false) goto L14;
        char r116 = r113.nextChar();
        r115 = Math.max(r115, this.f173479b.measureText(String.valueOf(r116)));
        goto L12
    L14:
        this.f173491n = RangesKt.coerceAtLeast(r115, this.f173479b.measureText("."));
        return;
    L17:
        throw new NoSuchElementException();
    L19:
        throw new NoSuchElementException();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        ValueAnimator r100 = this.f173500w;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f173501x = true;
        this.f173496s = 1.0f;
        this.f173497t = Long.MAX_VALUE;
        requestLayout();
        invalidate();
        this.f173500w = null;
        super.onDetachedFromWindow();
    }

    public static String m(String r100) {
        if (r100 == null) goto L4;
        String r101 = StringsKt.trim(r100).toString();
    L5:
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        if (r101.length() != 0) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L14;
        return "0";
    L14:
        return r101;
    L10:
        r102 = false;
        goto L11
    L4:
        r101 = null;
        goto L5
    }

    public final float k(float r100) {
        int r101 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r102 = d.f173504a[this.f173499v.ordinal()];
        if (r102 == 1) goto L9;
        if (r102 == 2) goto L11;
        return getPaddingLeft() + ((r101 - r100) / 2.0f);
    L11:
        return (getPaddingLeft() + r101) - r100;
    L9:
        return getPaddingLeft();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        boolean r100 = true;
        if (this.f173480c.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == true) goto L15;
        return;
    L15:
        if (this.f173501x == true) goto L27;
        String r103 = l();
        boolean r104 = this.f173488k;
        if (r104 == true) goto L23;
        if (r104 == false) goto L20;
    L22:
        boolean r105 = false;
    L24:
        String r106 = this.f173482e;
        f(r110, r106, r103, r105, k(n(r106, r103, r105, false)));
        return;
    L20:
        if (this.f173489l == false) goto L22;
    L23:
        r105 = true;
        goto L24
    L27:
        if (this.f173496s < 1.0f) goto L29;
    L54:
        String r107 = this.f173480c;
        String r108 = this.f173481d;
        boolean r109 = this.f173489l;
        f(r110, r107, r108, r109, k(n(r107, r108, r109, false)));
        return;
    L29:
        if (this.f173484g.length() != 0) goto L31;
        boolean r111 = true;
    L32:
        if (r111 == true) goto L34;
    L41:
        boolean r112 = j();
        boolean r113 = i();
        float r114 = k(n(this.f173484g, this.f173486i, r112, false));
        float r115 = r114 + ((k(n(this.f173485h, this.f173487j, r113, false)) - r114) * RangesKt.coerceIn((this.f173497t - 70) / 200, 0.0f, 1.0f));
        float r116 = getPaddingTop() + this.f173494q;
        float r117 = c(r110, this.f173484g, this.f173485h, r115, r116, false);
        if (r112 == true) goto L44;
        if (r113 == true) goto L44;
        return;
    L44:
        boolean r118 = j();
        boolean r119 = i();
        if (r118 == false) goto L48;
        if (r119 == false) goto L48;
        r110.drawText(".", r117, r116, this.f173479b);
    L52:
        c(r110, this.f173486i, this.f173487j, r117 + this.f173479b.measureText("."), r116, true);
        return;
    L48:
        if (r118 == false) goto L50;
        d(r110, '.', r117, r116, 1.0f - g(), this.f173479b);
        goto L52
    L50:
        if (r119 == false) goto L52;
        d(r110, '.', r117, r116, g(), this.f173479b);
        goto L52
    L34:
        if (this.f173486i.length() == 0) goto L37;
        r100 = false;
    L37:
        if (r100 == false) goto L41;
        if (this.f173488k == true) goto L41;
    L31:
        r111 = false;
        goto L32
    L8:
        if (this.f173489l == true) goto L11;
        r102 = false;
        goto L12
    L5:
        r101 = false;
        goto L6
    }

    public c(Context r100, SlcTemplateContext r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "slcTemplateContext");
        super(r100, null, 0);
        this.f173503z = r101;
        Paint r102 = new Paint(1);
        r102.setColor(ColorProtector.parseColor("#FF161823"));
        r102.setTextAlign(Paint.Align.LEFT);
        Unit r103 = Unit.INSTANCE;
        this.f173478a = r102;
        Paint r104 = new Paint(1);
        r104.setColor(ColorProtector.parseColor("#FF161823"));
        r104.setTextAlign(Paint.Align.LEFT);
        this.f173479b = r104;
        this.f173480c = "";
        this.f173481d = "";
        this.f173482e = "";
        this.f173483f = "";
        this.f173484g = "";
        this.f173485h = "";
        this.f173486i = "";
        this.f173487j = "";
        this.f173496s = 1.0f;
        this.f173498u = true;
        this.f173499v = Paint.Align.CENTER;
        this.f173501x = true;
    }

    public static BigDecimal b(String r100, String r101) {
        if (r100 == null) goto L49;
        String r102 = StringsKt.trim(r100).toString();
        if (r101 == null) goto L47;
        String r103 = StringsKt.take(StringsKt.trim(r101).toString(), 2);
        boolean r104 = false;
        if (r102.length() != 0) goto L9;
        boolean r105 = true;
    L10:
        Object r106 = null;
        if (r105 == false) goto L19;
        if (r103.length() != 0) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == false) goto L19;
        return null;
    L15:
        r107 = false;
    L19:
        if (r102.length() != 0) goto L21;
        boolean r108 = true;
    L22:
        if (r108 == false) goto L25;
        r102 = "0";
    L28:
        if (r103.length() != 0) goto L30;
        r104 = true;
    L30:
        if (r104 == true) goto L50;
        r102 = r102 + '.' + r103;
    L50:
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L38
        if (r102 == null) goto L37;
        Object r110 = Result.m9449constructorimpl(new BigDecimal(StringsKt.trim(r102).toString()));     // Catch: Throwable -> L38
    L41:
        if (Result.m9455isFailureimpl(r110) == true) goto L45;
        r106 = r110;
    L45:
        return (BigDecimal) r106;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L41
    L25:
        if (Intrinsics.areEqual(r102, "-") == false) goto L28;
        r102 = "-0";
        goto L28
    L21:
        r108 = false;
        goto L22
    L9:
        r105 = false;
        goto L10
    L47:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L49:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static void p(Paint r100, Integer r101) {
        if (r101 == null) goto L4;
        int r102 = r101.intValue();
    L5:
        Typeface r103 = ECFontHelper.f45592e.b("DouyinNumberABC", r102, false);
        if (r103 == null) goto L8;
    L14:
        r100.setTypeface(r103);
        return;
    L8:
        if (Build.VERSION.SDK_INT < 28) goto L11;
        r103 = Typeface.create(Typeface.DEFAULT, r102, false);
        goto L14
    L11:
        if (r102 < 600) goto L13;
        r103 = Typeface.DEFAULT_BOLD;
        goto L14
    L13:
        r103 = Typeface.DEFAULT;
        goto L14
    L4:
        r102 = 400;
        goto L5
    }

    public final List<Character> h(char r100, char r101) {
        int r102 = r100 - '0';
        int r103 = r101 - '0';
        if (this.f173498u == false) goto L5;
        int r104 = ((r103 - r102) + 10) % 10;
    L6:
        if (r104 != 0) goto L8;
        r104 = 10;
    L8:
        IntRange r105 = new IntRange(0, r104);
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<Integer> r107 = r105.iterator();
    L10:
        if (r107.hasNext() == false) goto L17;
        int r108 = ((IntIterator) r107).nextInt();
        if (this.f173498u == false) goto L14;
        int r109 = r108 + r102;
    L15:
        r106.add(Character.valueOf((char) ((r109 % 10) + 48)));
        goto L10
    L14:
        r109 = (r102 - r108) + 10;
        goto L15
    L17:
        if (r106.size() > 5) goto L20;
        return r106;
    L20:
        return CollectionsKt.listOfNotNull(new Character[]{(Character) CollectionsKt.getOrNull(r106, 0), (Character) CollectionsKt.getOrNull(r106, 1), (Character) CollectionsKt.getOrNull(r106, r106.size() - 3), (Character) CollectionsKt.getOrNull(r106, r106.size() - 2), (Character) CollectionsKt.getOrNull(r106, r106.size() - 1)});
    L5:
        r104 = ((r102 - r103) + 10) % 10;
        goto L6
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r110) {
        o();
        boolean r101 = false;
        float r102 = n(this.f173480c, this.f173481d, this.f173489l, false);
        String r103 = this.f173482e;
        String r104 = l();
        boolean r105 = this.f173488k;
        if (r105 == true) goto L9;
        if (r105 == false) goto L6;
    L8:
        boolean r106 = false;
    L10:
        float r107 = Math.max(n(r103, r104, r106, false), Math.max(n(this.f173484g, this.f173486i, j(), true), n(this.f173485h, this.f173487j, i(), true)));
        if (this.f173501x == true) goto L13;
    L14:
        r101 = true;
    L15:
        if (r101 == false) goto L17;
        r102 = Math.max(r102, r107);
    L17:
        int r108 = (((int) r102) + getPaddingLeft()) + getPaddingRight();
        int r109 = (((int) this.f173495r) + getPaddingTop()) + getPaddingBottom();
        setMeasuredDimension(View.resolveSize(r108, r100), View.resolveSize(r109, r110));
        return;
    L13:
        if (this.f173496s >= 1.0f) goto L15;
    L6:
        if (this.f173489l == false) goto L8;
    L9:
        r106 = true;
        goto L10
    }

    public final float a(char r100, boolean r101, boolean r102) {
        if (r101 == false) goto L4;
        Paint r103 = this.f173479b;
    L5:
        if (r100 != 0) goto L10;
        if (r101 == false) goto L18;
        return this.f173491n;
    L18:
        return this.f173490m;
    L10:
        if (Character.isDigit(r100) == false) goto L16;
        if (r102 == false) goto L16;
        if (r101 == false) goto L20;
        return this.f173491n;
    L20:
        return this.f173490m;
    L16:
        return r103.measureText(String.valueOf(r100));
    L4:
        r103 = this.f173478a;
        goto L5
    }

    public final float n(String r100, String r110, boolean r111, boolean r112) {
        int r101 = 0;
        double r102 = 0;
        double r103 = r102;
        int r104 = 0;
    L4:
        if (r104 >= r100.length()) goto L6;
        r103 = r103 + ((double) a(r100.charAt(r104), false, r112));
        r104 = r104 + 1;
        goto L4
    L6:
        float r105 = (float) r103;
        if (r111 == false) goto L13;
        float r113 = this.f173479b.measureText(".");
    L10:
        if (r101 >= r110.length()) goto L12;
        r102 = r102 + ((double) a(r110.charAt(r101), true, r112));
        r101 = r101 + 1;
        goto L10
    L12:
        float r114 = r113 + ((float) r102);
    L15:
        return r105 + r114;
    L13:
        r114 = 0.0f;
        goto L15
    }

    public final float e(Canvas r100, String r101, float r110, float r111, boolean r112) {
        int r102 = 0;
    L4:
        if (r102 >= r101.length()) goto L10;
        char r103 = r101.charAt(r102);
        if (r112 == false) goto L8;
        Paint r104 = this.f173479b;
    L9:
        int r105 = r104.getAlpha();
        r104.setAlpha(RangesKt.coerceIn((int) (r105 * 1.0f), 0, 255));
        r100.drawText(String.valueOf(r103), r110, r111, r104);
        r104.setAlpha(r105);
        r110 = r110 + a(r103, r112, false);
        r102 = r102 + 1;
        goto L4
    L8:
        r104 = this.f173478a;
        goto L9
    L10:
        return r110;
    }

    public final void f(Canvas r110, String r111, String r112, boolean r113, float r114) {
        float r100 = getPaddingTop() + this.f173494q;
        float r101 = e(r110, r111, r114, r100, false);
        if (r113 == false) goto L6;
        d(r110, '.', r101, r100, 1.0f, this.f173479b);
        e(r110, r112, r101 + this.f173479b.measureText("."), r100, true);
        return;
    }

    public static void d(Canvas r100, char r101, float r102, float r103, float r104, Paint r105) {
        if (r101 != 0) goto L4;
        return;
    L4:
        int r106 = r105.getAlpha();
        r105.setAlpha(RangesKt.coerceIn((int) (r106 * r104), 0, 255));
        r100.drawText(String.valueOf(r101), r102, r103, r105);
        r105.setAlpha(r106);
    }

    public final float c(Canvas r110, String r210, String r211, float r212, float r213, boolean r214) {
        int r111 = Math.max(r210.length(), r211.length());
        float r112 = r212;
        int r113 = 0;
    L3:
        if (r113 >= r111) goto L51;
        if (r113 >= 0) goto L6;
    L8:
        char r114 = 0;
    L9:
        if (r113 >= 0) goto L11;
    L13:
        char r100 = 0;
    L14:
        if (r214 == false) goto L16;
        Paint r101 = this.f173479b;
    L17:
        Paint r102 = r101;
        if (r114 != 0) goto L20;
        char r115 = r100;
        d(r110, r100, r112, r213, g(), r102);
    L50:
        r112 = r112 + Math.max(a(r114, r214, true), a(r115, r214, true));
        r113 = r113 + 1;
        goto L3
    L20:
        r115 = r100;
        float r103 = 1.0f;
        if (r115 != 0) goto L23;
        d(r110, r114, r112, r213, 1.0f - g(), r102);
        goto L50
    L23:
        if (r114 != r115) goto L26;
        r110.drawText(String.valueOf(r115), r112, r213, r102);
        goto L50
    L26:
        if (Character.isDigit(r114) == true) goto L28;
    L49:
        float r104 = r112;
        d(r110, r114, r104, r213, 1.0f - g(), r102);
        d(r110, r115, r104, r213, g(), r102);
        goto L50
    L28:
        if (Character.isDigit(r115) == false) goto L49;
        List<Character> r105 = h(r114, r115);
        float r106 = this.f173496s * (r105.size() - 1);
        if (this.f173498u == true) goto L34;
        r103 = -1.0f;
    L34:
        if (r102 != this.f173479b) goto L36;
        float r107 = this.f173493p;
    L37:
        Iterator<T> r108 = r105.iterator();
        int r109 = 0;
    L39:
        if (r108.hasNext() == false) goto L50;
        Object r116 = r108.next();
        int r117 = r109 + 1;
        if (r109 >= 0) goto L43;
        CollectionsKt.throwIndexOverflow();
    L43:
        char r118 = ((Character) r116).charValue();
        float r119 = (((r109 - r106) * r107) * r103) + r213;
        float r215 = r103;
        if (r119 <= (-r107)) goto L48;
        if (r119 >= (getHeight() + r107)) goto L48;
        r110.drawText(String.valueOf(r118), r112, r119, r102);
    L48:
        r103 = r215;
        r109 = r117;
        goto L39
    L36:
        r107 = this.f173492o;
        goto L37
    L16:
        r101 = this.f173478a;
        goto L17
    L11:
        if (r113 > StringsKt.getLastIndex(r211)) goto L13;
        r100 = r211.charAt(r113);
        goto L14
    L6:
        if (r113 > StringsKt.getLastIndex(r210)) goto L8;
        r114 = r210.charAt(r113);
        goto L9
    L51:
        return r112;
    }
}
