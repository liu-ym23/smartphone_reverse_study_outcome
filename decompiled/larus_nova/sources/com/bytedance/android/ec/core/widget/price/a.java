package com.bytedance.android.ec.core.widget.price;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.ui.widget.CJBadgeTextView;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class a {
    public static final /* synthetic */ int K = 0;
    public float A;
    public Drawable B;
    public Long C;
    public b D;
    public boolean E;
    public int F;
    public boolean G;
    public boolean H;
    public Typeface I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f46123J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f46124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f46125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f46126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f46127d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f46128e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f46129f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f46130g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f46131h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f46132i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f46133j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f46134k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f46135l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f46136m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f46137n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f46138o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f46139p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f46140q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f46141r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f46142s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f46143t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f46144u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f46145v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f46146w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f46147x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f46148y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f46149z;

    /* JADX INFO: renamed from: com.bytedance.android.ec.core.widget.price.a$a, reason: collision with other inner class name */
    public static final class C0812a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f46150a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f46151b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f46152c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f46153d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L14;
            b r101 = (b) r100;
            if (Float.compare(this.f46150a, r101.f46150a) == 0) goto L8;
            return false;
        L8:
            if (Float.compare(this.f46151b, r101.f46151b) == 0) goto L10;
            return false;
        L10:
            if (Float.compare(this.f46152c, r101.f46152c) == 0) goto L12;
            return false;
        L12:
            if (this.f46153d == r101.f46153d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            return (((((Float.floatToIntBits(this.f46150a) * 31) + Float.floatToIntBits(this.f46151b)) * 31) + Float.floatToIntBits(this.f46152c)) * 31) + this.f46153d;
        }

        public final String toString() {
            return "Shadow(radius=" + this.f46150a + ", dx=" + this.f46151b + ", dy=" + this.f46152c + ", shadowColor=" + this.f46153d + ")";
        }

        public b(int r100) {
            this.f46150a = 2.0f;
            this.f46151b = 0.0f;
            this.f46152c = 2.0f;
            this.f46153d = r100;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f46154a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f46155b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L10;
            c r101 = (c) r100;
            if (this.f46154a == r101.f46154a) goto L8;
            return false;
        L8:
            if (this.f46155b == r101.f46155b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            return (this.f46154a * 31) + this.f46155b;
        }

        public final String toString() {
            return "StrikeRange(start=" + this.f46154a + ", end=" + this.f46155b + ")";
        }

        public c(int r100, int r101) {
            this.f46154a = r100;
            this.f46155b = r101;
        }
    }

    static {
    }

    private final Context getContext() {
        return this.f46125b.getContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.text.SpannableString] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r1v7, types: [android.text.SpannableStringBuilder] */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.widget.TextView] */
    public final void a() {
        int r100 = com.bytedance.android.ec.core.widget.price.b.f46156a;
        Intrinsics.checkNotNullParameter(this, "priceBuilder");
        Long r101 = this.f46127d;
        String r102 = "";
        if (r101 == null) goto L117;
        long r103 = r101.longValue();
        ?? r104 = new SpannableStringBuilder();
        String r105 = this.f46139p;
        if (r105 != null) goto L7;
    L18:
        int r106 = r104.length();
        if (this.f46132i == true) goto L24;
        SpannableString r110 = new SpannableString("¥");
        r110.setSpan(new ForegroundColorSpan(this.f46129f), 0, r110.length(), 17);
        r110.setSpan(new RelativeSizeSpan(this.f46133j), 0, r110.length(), 17);
        if (this.f46134k == false) goto L23;
        r110.setSpan(new StyleSpan(1), 0, r110.length(), 17);
    L23:
        r104.append(r110);
        SpannableString r111 = new SpannableString(" ");
        r111.setSpan(new com.bytedance.android.ec.core.widget.price.b.c(this.f46135l), 0, r111.length(), 17);
        r104.append(r111);
    L24:
        String r112 = this.f46128e;
        if (r112 == null) goto L30;
        String r113 = a2.d(r112);
        if (r113 == null) goto L30;
    L57:
        if (StringsKt.contains$default(r113, ".", false, 2, null) == false) goto L63;
        int r107 = StringsKt.indexOf$default(r113, ".", 0, false, 6, null);
        if (r113 == null) goto L62;
        String r108 = r113.substring(0, r107);
    L65:
        if (this.G == false) goto L69;
        Long r109 = StringsKt.toLongOrNull(r108);
        if (r109 == null) goto L69;
        r108 = String.format("%,d", Arrays.copyOf(new Object[]{r109}, 1));
    L69:
        String r114 = null;
        if (StringsKt.contains$default(r113, ".", false, 2, null) == false) goto L76;
        int r115 = StringsKt.indexOf$default(r113, ".", 0, false, 6, null);
        if (r113 == null) goto L75;
        r102 = r113.substring(r115);
        goto L76
    L75:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L76:
        SpannableString r116 = new SpannableString(r108);
        r116.setSpan(new ForegroundColorSpan(this.f46129f), 0, r116.length(), 17);
        r116.setSpan(new RelativeSizeSpan(1.0f), 0, r116.length(), 17);
        b r117 = this.D;
        if (r117 == null) goto L80;
        r116.setSpan(new com.bytedance.android.ec.core.widget.price.b.C0813b(r117), 0, r116.length(), 17);
    L80:
        if (this.f46131h == false) goto L82;
        r116.setSpan(new StyleSpan(1), 0, r116.length(), 17);
    L82:
        Typeface r118 = this.I;
        if (r118 == null) goto L85;
        r116.setSpan(new PriceTypefaceSpan(r118, this.f46131h), 0, r116.length(), 17);
    L85:
        r104.append(r116);
        if (r102.length() <= 0) goto L88;
        boolean r119 = true;
    L89:
        if (r119 == false) goto L99;
        SpannableString r120 = new SpannableString(r102);
        r120.setSpan(new ForegroundColorSpan(this.f46129f), 0, r120.length(), 17);
        r120.setSpan(new RelativeSizeSpan(this.f46130g), 0, r120.length(), 17);
        if (this.f46131h == false) goto L93;
        r120.setSpan(new StyleSpan(1), 0, r120.length(), 17);
    L93:
        Typeface r121 = this.I;
        if (r121 == null) goto L96;
        r120.setSpan(new PriceTypefaceSpan(r121, this.f46131h), 0, r120.length(), 17);
    L96:
        r104.append(r120);
        b r122 = this.D;
        if (r122 == null) goto L99;
        r120.setSpan(new com.bytedance.android.ec.core.widget.price.b.C0813b(r122), 0, r120.length(), 17);
    L99:
        this.f46124a = new c(r106, r104.length());
        String r123 = this.f46145v;
        if (r123 != null) goto L102;
    L118:
        this.f46125b.setText(r104);
        TextView r124 = this.f46125b;
        Long r125 = this.f46127d;
        if (r125 != null) goto L121;
    L140:
        String r126 = r114;
    L141:
        r124.setContentDescription(r126);
        this.f46125b.requestLayout();
        return;
    L121:
        if (r125.longValue() <= 0) goto L140;
        StringBuilder r127 = new StringBuilder();
        if (TextUtils.isEmpty(this.f46139p) == false) goto L130;
        Context r128 = getContext();
        if (this.f46136m == false) goto L128;
        int r129 = R.string.shopping_original_price;
    L129:
        r127.append(r128.getString(r129));
    L131:
        long r130 = 100;
        r127.append(r125.longValue() / r130);
        r127.append(".");
        r127.append(r125.longValue() % r130);
        Long r131 = this.C;
        if (r131 == null) goto L136;
        Intrinsics.checkNotNull(r131);
        if (r131.longValue() <= 0) goto L136;
        r127.append("至");
        Long r132 = this.C;
        Intrinsics.checkNotNull(r132);
        r127.append(r132.longValue() / r130);
        r127.append(".");
        Long r133 = this.C;
        Intrinsics.checkNotNull(r133);
        r127.append(r133.longValue() % r130);
    L136:
        r127.append(getContext().getString(R.string.shopping_currency_yuan));
        if (TextUtils.isEmpty(this.f46145v) == true) goto L139;
        r127.append(this.f46145v);
    L139:
        r126 = r127.toString();
        goto L141
    L128:
        r129 = R.string.shopping_current_price;
        goto L129
    L130:
        r127.append(this.f46139p);
        goto L131
    L102:
        if (r123.length() <= 0) goto L104;
        boolean r134 = true;
    L105:
        if (r134 != true) goto L118;
        Drawable r135 = this.B;
        if (r135 == null) goto L109;
        SpannableString r136 = new SpannableString(" ");
        int r137 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        int r138 = 17;
        r136.setSpan(new com.bytedance.android.ec.core.widget.price.b.c(com.bytedance.android.ec.hybrid.list.util.c.d(2)), 0, r136.length(), 17);
        r104.append(r136);
        r135.setBounds(0, 0, r135.getIntrinsicWidth(), r135.getIntrinsicHeight());
        SpannableString r139 = new SpannableString(" ");
        r139.setSpan(new ImageSpan(r135, 1), 0, r139.length(), 17);
        r104.append(r139);
    L110:
        SpannableString r140 = new SpannableString(" ");
        r140.setSpan(new com.bytedance.android.ec.core.widget.price.b.c(this.f46148y), 0, r140.length(), r138);
        r104.append(r140);
        SpannableString r141 = new SpannableString(this.f46145v);
        r141.setSpan(new ForegroundColorSpan(this.f46149z), 0, r141.length(), r138);
        r141.setSpan(new RelativeSizeSpan(this.f46147x), 0, r141.length(), r138);
        if (this.f46146w == false) goto L114;
        r141.setSpan(new StyleSpan(1), 0, r141.length(), r138);
    L114:
        if (this.A <= 0) goto L116;
        r141.setSpan(new com.bytedance.android.ec.core.widget.price.b.a(0.15f), 0, r141.length(), r138);
    L116:
        r104.append(r141);
        goto L118
    L109:
        r138 = 17;
        goto L110
    L104:
        r134 = false;
        goto L105
    L88:
        r119 = false;
        goto L89
    L62:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L63:
        r108 = r113;
    L30:
        boolean r142 = this.H;
        Long r143 = this.C;
        int r144 = this.f46123J;
        Long[] r145 = {Long.valueOf(r103), r143};
        if (ArraysKt.filterNotNull(r145).size() < 2) goto L33;
        boolean r146 = true;
    L34:
        if (r146 == false) goto L46;
        Long r147 = r145[0];
        if (r147 == null) goto L45;
        long r148 = r147.longValue();
        Long r149 = r145[1];
        if (r149 == null) goto L43;
        if (r148 >= r149.longValue()) goto L46;
        boolean r150 = true;
    L47:
        if (r150 == true) goto L49;
        if (r144 != 0) goto L49;
    L50:
        boolean r151 = true;
    L52:
        if (r151 != true) goto L54;
        String r152 = com.bytedance.android.ec.core.widget.price.b.b(r103, r142);
    L55:
        r113 = r152;
        goto L57
    L54:
        r152 = com.bytedance.android.ec.core.widget.price.b.b(r103, r142) + '-' + com.bytedance.android.ec.core.widget.price.b.b(r143.longValue(), r142);
    L49:
        if (r143 == null) goto L50;
        r151 = false;
        goto L52
    L43:
        throw new IllegalStateException("Required value was null.".toString());
    L45:
        throw new IllegalStateException("Required value was null.".toString());
    L46:
        r150 = false;
        goto L47
    L33:
        r146 = false;
        goto L34
    L7:
        if (r105.length() <= 0) goto L9;
        boolean r153 = true;
    L10:
        if (r153 != true) goto L18;
        SpannableString r154 = new SpannableString(this.f46139p);
        r154.setSpan(new ForegroundColorSpan(this.f46142s), 0, r154.length(), 17);
        r154.setSpan(new RelativeSizeSpan(this.f46141r), 0, r154.length(), 17);
        if (this.f46140q == false) goto L15;
        r154.setSpan(new StyleSpan(1), 0, r154.length(), 17);
    L15:
        if (this.f46144u <= 0) goto L17;
        r154.setSpan(new com.bytedance.android.ec.core.widget.price.b.a(this.f46144u), 0, r154.length(), 17);
    L17:
        r104.append(r154);
        SpannableString r155 = new SpannableString(" ");
        r155.setSpan(new com.bytedance.android.ec.core.widget.price.b.c(this.f46143t), 0, r155.length(), 17);
        r104.append(r155);
        goto L18
    L9:
        r153 = false;
        goto L10
    L117:
        r114 = null;
        r104 = new SpannableString("");
        goto L118
    }

    public a(TextView r100) {
        float r101 = UIUtils.sp2px(r100.getContext(), 13.0f);
        int r102 = vf4.a.a(r100.getContext(), 2.0f);
        float r103 = vf4.a.a(r100.getContext(), 1.0f);
        int r104 = vf4.a.a(r100.getContext(), 4.0f);
        int r105 = vf4.a.a(r100.getContext(), 2.0f);
        Intrinsics.checkNotNullParameter(r100, "textView");
        this.f46125b = r100;
        this.f46126c = r101;
        this.f46127d = null;
        this.f46128e = null;
        this.f46129f = CJBadgeTextView.BADGE_COLOR;
        this.f46130g = 0.6666667f;
        this.f46131h = false;
        this.f46132i = false;
        this.f46133j = 0.6666667f;
        this.f46134k = false;
        this.f46135l = r102;
        this.f46136m = false;
        this.f46137n = 0;
        this.f46138o = r103;
        this.f46139p = "";
        this.f46140q = false;
        this.f46141r = 1.0f;
        this.f46142s = 0;
        this.f46143t = r104;
        this.f46144u = 0.0f;
        this.f46145v = "";
        this.f46146w = false;
        this.f46147x = 1.0f;
        this.f46148y = r105;
        this.f46149z = 0;
        this.A = 0.0f;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = false;
        this.F = Integer.MAX_VALUE;
        this.G = false;
        this.H = false;
        this.I = null;
        this.f46123J = 0;
    }
}
