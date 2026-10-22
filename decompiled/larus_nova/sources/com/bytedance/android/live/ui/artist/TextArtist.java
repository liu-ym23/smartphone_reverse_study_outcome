package com.bytedance.android.live.ui.artist;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.common.utility.DeviceUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes7.dex */
public final class TextArtist {
    public static final HashSet<Character> P = null;
    public static final HashSet<Character> Q = null;
    public static final HashSet<Character> R = null;
    public static final String S = null;
    public static final int T = 0;
    public static final int U = 0;
    public int A;
    public final c B;
    public int C;
    public CharSequence D;
    public TextArtist E;
    public final RectF F;
    public final Paint.FontMetrics G;
    public final Paint.FontMetricsInt H;
    public final Paint.FontMetricsInt I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public float f102017J;
    public final Lazy K;
    public final CharSequence L;
    public final f M;
    public final TextPaint N;
    public final boolean O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f102018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f102019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<? extends Object> f102020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f102021d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f102022e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<CharacterStyle> f102023f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<IntRange> f102024g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f102025h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f102026i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f102027j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f102028k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f102029l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f102030m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f102031n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float[] f102032o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f102033p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f102034q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final float[] f102035r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final float[] f102036s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final float[] f102037t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ArrayList<IntRange> f102038u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f102039v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final float[] f102040w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final float[] f102041x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Rect f102042y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public HashMap<Character, Float> f102043z;

    static {
        HashSet<Character> r100 = new HashSet();
        P = r100;
        HashSet<Character> r101 = new HashSet();
        Q = r101;
        R = new HashSet();
        int r102 = 0;
        T = "一".charAt(0);
        U = "龥".charAt(0);
        r100.add((char) 65292);
        r100.add((char) 12290);
        r100.add((char) 65311);
        r100.add((char) 65281);
        r100.add((char) 12289);
        r100.add((char) 65306);
        r100.add((char) 65289);
        r100.add((char) 12303);
        r100.add((char) 12309);
        r100.add((char) 65373);
        r100.add((char) 12305);
        r100.add((char) 12311);
        r100.add((char) 12299);
        r100.add((char) 12301);
        r100.add(Character.valueOf(Typography.rightDoubleQuote));
        r100.add(Character.valueOf(Typography.rightSingleQuote));
        r101.add((char) 65288);
        r101.add((char) 12302);
        r101.add((char) 12308);
        r101.add((char) 65371);
        r101.add((char) 12304);
        r101.add((char) 12310);
        r101.add((char) 12298);
        r101.add((char) 12300);
        r101.add(Character.valueOf(Typography.leftDoubleQuote));
        r101.add(Character.valueOf(Typography.leftSingleQuote));
    L4:
        if (r102 >= "，。、；：,.;”’!?！？".length()) goto L6;
        char r103 = "，。、；：,.;”’!?！？".charAt(r102);
        R.add(Character.valueOf(r103));
        r102 = r102 + 1;
        goto L4
    L6:
        S = new String(CollectionsKt.toCharArray(P)).concat(new String(CollectionsKt.toCharArray(Q)));
    }

    public final int c() {
        return this.f102038u.size();
    }

    public final float e() {
        int r100 = Math.min(this.C, c());
        float r101 = -1.0f;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L8;
        float r103 = d(r102);
        if (r103 <= r101) goto L7;
        r101 = r103;
    L7:
        r102 = r102 + 1;
        goto L3
    L8:
        return r101;
    }

    public static boolean h(char r100) {
        if (r100 >= T) goto L5;
    L7:
        return false;
    L5:
        if (r100 > U) goto L7;
        return true;
    }

    public static boolean i(char r100) {
        if (Intrinsics.compare(r100, 48) >= 0) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.compare(r100, 57) > 0) goto L7;
        return true;
    }

    public static boolean j(char r100) {
        if (Intrinsics.compare(r100, 65) < 0) goto L7;
        if (Intrinsics.compare(r100, 90) > 0) goto L7;
    L10:
        return true;
    L7:
        if (Intrinsics.compare(r100, 97) >= 0) goto L9;
    L11:
        return false;
    L9:
        if (Intrinsics.compare(r100, 122) > 0) goto L11;
        goto L10
    }

    public static boolean k(Object r100) {
        if ((r100 instanceof Character) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Character) r100).charValue() != '\n') goto L7;
        return true;
    }

    public final float d(int r100) {
        if (r100 >= 0) goto L4;
        return -1.0f;
    L4:
        if (r100 >= c()) goto L11;
        int r101 = ((IntRange) ListProtector.get(this.f102038u, r100)).getLast();
        if (r101 >= 0) goto L8;
        return -1.0f;
    L8:
        return this.f102036s[r101] + f(this.f102035r[r101], ListProtector.get(this.f102020c, r101));
    L11:
        return -1.0f;
    }

    /* JADX WARN: Type inference failed for: r13v0, types: [com.bytedance.android.live.ui.artist.TextArtist$determinePerSlicePosition$1] */
    public final void g(int r210) {
        int r100 = Objects.hash(new Object[]{Float.valueOf(this.f102028k), Integer.valueOf(r210), Float.valueOf(this.f102026i), Integer.valueOf(this.C), this.D, Boolean.valueOf(this.f102029l), Boolean.valueOf(this.f102031n), Boolean.valueOf(this.f102030m), Boolean.valueOf(this.O)});
        if (r100 != this.A) goto L5;
        return;
    L5:
        this.M.setColor(this.f102027j);
        this.M.setTextSize(this.f102028k);
        this.M.getFontMetrics(this.G);
        this.M.getFontMetricsInt(this.H);
        if (this.f102031n == false) goto L8;
        Paint.FontMetrics r101 = this.G;
        float r102 = r101.bottom;
        float r103 = r101.top;
    L9:
        this.f102017J = r102 - r103;
        f r104 = this.M;
        r104.f102051a = this.H;
        float r105 = this.f102028k;
        if (this.f102033p == r105) goto L16;
        String r110 = this.L.toString();
        if (r110 == null) goto L15;
        r104.getTextWidths(r110.toCharArray(), 0, this.f102019b, this.f102032o);
        this.f102033p = r105;
        goto L16
    L15:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L16:
        int r106 = this.f102021d;
        int r107 = 0;
        int r111 = 0;
    L17:
        float r112 = 0.0f;
        if (r107 >= r106) goto L38;
        Object r113 = ListProtector.get(this.f102020c, r107);
        if ((r113 instanceof Character) == false) goto L26;
        if (k(r113) == false) goto L24;
        this.f102035r[r107] = 0.0f;
    L36:
        r111 = r111 + 1;
    L37:
        r107 = r107 + 1;
        goto L17
    L24:
        this.f102035r[r107] = this.f102032o[r111];
        goto L36
    L26:
        if ((r113 instanceof String) == false) goto L32;
        String r114 = (String) r113;
        int r115 = r114.length() + r111;
        int r116 = r111;
    L28:
        if (r116 >= r115) goto L30;
        r112 = r112 + this.f102032o[r116];
        r116 = r116 + 1;
        goto L28
    L30:
        this.f102035r[r107] = r112;
        int r117 = r114.length();
    L34:
        r111 = r111 + r117;
        goto L37
    L32:
        if ((r113 instanceof d) == false) goto L35;
        Paint.FontMetricsInt r118 = this.I;
        Paint.FontMetricsInt r119 = this.H;
        r118.ascent = r119.ascent;
        r118.descent = r119.descent;
        r118.top = r119.top;
        r118.bottom = r119.bottom;
        r118.leading = r119.leading;
        d r120 = (d) r113;
        this.f102035r[r107] = r120.f102049c.getSize(this.M, this.L, r120.f102048b.getFirst(), r120.f102048b.getFirst() + r120.f102047a.length(), this.I);
        r117 = r120.f102047a.length();
        goto L34
    L35:
        this.f102035r[r107] = 0.0f;
        goto L36
    L38:
        this.M.getTextWidths(this.f102039v, this.f102040w);
        c r108 = this.B;
        float r109 = this.f102028k;
        r108.getClass();
        HashMap<Character, Float> r121 = c.f102045a.get(Float.valueOf(r109));
        if (r121 != null) goto L41;
    L44:
        boolean r122 = true;
    L45:
        if (r122 == true) goto L47;
        this.f102043z = r121;
    L55:
        this.f102038u.clear();
        if (this.f102021d != 0) goto L59;
        int r211 = r100;
    L198:
        if (this.D.length() <= 0) goto L200;
        boolean r123 = true;
    L201:
        if (r123 == true) goto L203;
    L207:
        this.A = r211;
        return;
    L203:
        if (this.C >= Integer.MAX_VALUE) goto L207;
        TextArtist r124 = this.E;
        if (r124 == null) goto L207;
        r124.a(this.F, r210);
        goto L207
    L200:
        r123 = false;
        goto L201
    L59:
        final Ref.FloatRef r125 = new Ref.FloatRef();
        r125.element = 0.0f;
        final Ref.FloatRef r126 = new Ref.FloatRef();
        r126.element = -this.G.top;
        final Ref.IntRef r127 = new Ref.IntRef();
        r127.element = 0;
        if ((!this.f102024g.isEmpty()) == false) goto L62;
        IntRange r128 = (IntRange) ListProtector.get(this.f102024g, 0);
    L63:
        ?? r129 = new TextArtist$determinePerSlicePosition$1(this, r125, r126, r127);
        int r130 = this.f102021d;
        int r131 = -1;
        int r132 = 0;
        int r133 = 0;
        int r134 = 0;
    L64:
        if (r132 >= r130) goto L167;
        Object r135 = ListProtector.get(this.f102020c, r132);
        float r136 = this.f102035r[r132];
        if (r125.element == r112) goto L68;
    L74:
        r100 = r100;
        r130 = r130;
    L76:
        if (this.f102030m == false) goto L132;
        if (r132 <= 0) goto L128;
        if (r128 != null) goto L80;
    L84:
        boolean r137 = true;
    L86:
        if (r125.element > 0) goto L88;
        boolean r138 = false;
    L89:
        int r139 = r132 - 1;
        if (this.f102037t[r139] == r126.element) goto L92;
        r138 = false;
    L92:
        if (r138 == false) goto L128;
        Object r140 = ListProtector.get(this.f102020c, r139);
        if (r140 != null) goto L97;
    L126:
        boolean r141 = false;
    L127:
        boolean r142 = r141;
    L129:
        if (r142 == false) goto L132;
        r125.element += (this.f102040w[2] / 3) * 2;
        goto L132
    L97:
        if ((r140 instanceof d) == true) goto L126;
        if ((r135 instanceof d) == true) goto L126;
        if ((r140 instanceof String) == false) goto L104;
        char r143 = StringsKt.last((CharSequence) r140);
    L106:
        if ((r135 instanceof String) == false) goto L108;
        char r144 = StringsKt.first((CharSequence) r135);
    L111:
        if (h(r143) == false) goto L118;
        if (j(r144) == false) goto L115;
    L123:
        r141 = true;
        goto L127
    L115:
        if (i(r144) == true) goto L123;
    L118:
        if (j(r143) == true) goto L122;
        if (i(r143) == false) goto L126;
    L122:
        if (h(r144) == false) goto L126;
    L108:
        if (r135 == null) goto L125;
        r144 = ((Character) r135).charValue();
        goto L111
    L125:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Char");
    L104:
        r143 = ((Character) r140).charValue();
        goto L106
    L88:
        r138 = r137;
        goto L89
    L80:
        if (r128.contains(r131) != true) goto L84;
        if (r128.contains(r133) == false) goto L84;
        r137 = false;
    L128:
        r142 = false;
    L132:
        boolean r145 = k(r135);
        if (r145 == false) goto L135;
        r129.invoke(r132);
    L143:
        float[] r146 = this.f102036s;
        float r147 = r125.element;
        r146[r132] = r147;
        this.f102037t[r132] = r126.element;
        if (r145 == true) goto L147;
        r125.element = r147 + r136;
    L147:
        if ((r135 instanceof Character) == false) goto L150;
    L155:
        int r148 = 1;
    L156:
        int r149 = r148 + r133;
        if (r128 == null) goto L159;
        int r150 = r128.getEndInclusive().intValue();
    L160:
        if (r149 <= r150) goto L166;
        int r151 = r134 + 1;
        if (this.f102024g.size() <= r151) goto L164;
        IntRange r152 = (IntRange) ListProtector.get(this.f102024g, r151);
    L165:
        r134 = r151;
        r128 = r152;
        goto L166
    L164:
        r152 = null;
    L166:
        r132 = r132 + 1;
        r131 = r133;
        r130 = r130;
        r112 = 0.0f;
        r133 = r149;
        r100 = r100;
        goto L64
    L159:
        r150 = Integer.MAX_VALUE;
        goto L160
    L150:
        if ((r135 instanceof String) == false) goto L153;
        r148 = ((String) r135).length();
        goto L156
    L153:
        if ((r135 instanceof d) == false) goto L155;
        r148 = ((d) r135).f102047a.length();
        goto L156
    L135:
        float r153 = r210;
        if ((r125.element + r136) <= r153) goto L143;
        if (CollectionsKt.contains(P, r135) == true) goto L140;
        r129.invoke(r132);
        goto L143
    L140:
        if ((r125.element + f(r136, r135)) <= r153) goto L143;
        r129.invoke(r132);
        goto L143
    L68:
        if (CollectionsKt.contains(Q, r135) == false) goto L74;
        float r154 = r125.element;
        Float r155 = this.f102043z.get(r135);
        if (r155 == null) goto L72;
        float r156 = r155.floatValue();
    L73:
        r125.element = r154 - Math.max(0.0f, r156 - 0);
        goto L76
    L72:
        r156 = 0.0f;
        goto L73
    L167:
        r211 = r100;
        int r157 = r127.element;
        this.f102038u.add(new IntRange(r157, Math.max(r157, this.f102021d - 1)));
        if (c() <= 1) goto L198;
        float r158 = e();
        int r159 = this.f102038u.size() - 1;
        int r160 = 0;
    L171:
        if (r160 >= r159) goto L198;
        int r161 = r160 + 1;
        if (k(ListProtector.get(this.f102020c, ((IntRange) ListProtector.get(this.f102038u, r161)).getFirst())) == true) goto L196;
        IntRange r162 = (IntRange) ListProtector.get(this.f102038u, r160);
        int r163 = r162.getFirst();
        int r164 = r162.getLast();
        int r165 = ((r164 - r163) + 1) - 1;
        if (r165 == 0) goto L196;
        if (this.f102029l == false) goto L181;
        float r166 = r210;
    L184:
        float r167 = r166 - d(r160);
        if (c() > 5) goto L187;
        int r168 = 0;
        float r169 = this.f102040w[0];
    L188:
        float r170 = Math.min(r167, r169);
        if (r170 <= r168) goto L196;
        float r171 = r170 / r165;
        int r172 = r163 + 1;
        if (r172 > r164) goto L196;
    L193:
        float[] r173 = this.f102036s;
        r173[r172] = r173[r172] + ((r172 - r163) * r171);
        if (r172 == r164) goto L196;
        r172 = r172 + 1;
        goto L193
    L187:
        r168 = 0;
        r169 = this.f102040w[1];
        goto L188
    L181:
        r166 = r210;
        if ((r166 - r158) <= this.f102040w[1]) goto L184;
        r166 = r158;
    L196:
        r160 = r161;
        goto L171
    L62:
        r128 = null;
        goto L63
    L47:
        int r174 = S.length();
        int r175 = 0;
    L48:
        if (r175 >= r174) goto L54;
        char r176 = S.charAt(r175);
        this.M.getTextWidths(String.valueOf(r176), this.f102041x);
        this.M.getTextBounds(String.valueOf(r176), 0, 1, this.f102042y);
        HashMap<Character, Float> r177 = this.f102043z;
        Character r178 = Character.valueOf(r176);
        if (CollectionsKt.contains(P, Character.valueOf(r176)) == false) goto L52;
        float r179 = Math.max(0.0f, this.f102041x[0] - this.f102042y.right);
    L53:
        r177.put(r178, Float.valueOf(r179));
        r175 = r175 + 1;
        goto L48
    L52:
        r179 = Math.max(0.0f, this.f102042y.left);
        goto L53
    L54:
        c r180 = this.B;
        float r181 = this.f102028k;
        HashMap<Character, Float> r182 = new HashMap(this.f102043z);
        r180.getClass();
        Intrinsics.checkNotNullParameter(r182, "cache");
        c.f102045a.put(Float.valueOf(r181), r182);
        goto L55
    L41:
        if (r121.isEmpty() == true) goto L44;
        r122 = false;
        goto L45
    L8:
        Paint.FontMetrics r183 = this.G;
        r102 = r183.descent;
        r103 = r183.ascent;
        goto L9
    }

    public final void l(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.D = r100;
        TextArtist r101 = new TextArtist(r100, this.M, this.N, false);
        r101.f102027j = this.f102027j;
        r101.f102028k = this.f102028k;
        r101.f102026i = this.f102026i;
        Unit r102 = Unit.INSTANCE;
        this.E = r101;
    }

    public final void a(RectF r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "result");
        g(r101);
        int r102 = Math.min(this.C, c());
        if (r102 != 0) goto L7;
        r100.set(0.0f, 0.0f, 0.0f, 0.0f);
        return;
    L7:
        if (r102 > 1) goto L9;
        int r103 = ((IntRange) CollectionsKt.last(this.f102038u)).getLast();
        float r104 = this.f102036s[r103];
        float r105 = this.f102035r[r103];
        r100.left = 0.0f;
        r100.top = 0.0f;
        r100.right = r104 + r105;
        Paint.FontMetrics r106 = this.G;
        r100.bottom = (r106.bottom + 0.0f) - r106.top;
        return;
    L9:
        r100.left = 0.0f;
        r100.top = -this.G.top;
        float r107 = e();
        float r108 = r101;
        if ((r108 - r107) <= this.f102040w[1]) goto L12;
        r100.right = r107;
    L13:
        float r109 = r100.top + ((this.f102017J + this.f102026i) * (r102 - 1));
        Paint.FontMetrics r110 = this.G;
        float r111 = r110.bottom;
        float r112 = r110.top;
        r100.bottom = (r109 + (r111 - r112)) + (r110.ascent - r112);
        return;
    L12:
        r100.right = r108;
        goto L13
    }

    /* JADX WARN: Type inference failed for: r0v17, types: [T, kotlin.ranges.IntRange] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.bytedance.android.live.ui.artist.TextArtist$drawPerSlice$4] */
    public final void b(Canvas r110, final int r111) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        g(r111);
        this.M.setColor(this.f102027j);
        this.M.setTextSize(this.f102028k);
        Ref.IntRef r100 = new Ref.IntRef();
        r100.element = 0;
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        r101.element = null;
        if ((!this.f102024g.isEmpty()) == false) goto L5;
        r101.element = (IntRange) ListProtector.get(this.f102024g, 0);
    L5:
        Ref.IntRef r102 = new Ref.IntRef();
        r102.element = 0;
        Paint.FontMetrics r103 = this.G;
        float r104 = r103.descent;
        float r105 = 2;
        final TextArtist$drawPerSlice$1 r112 = new TextArtist$drawPerSlice$1(this, (this.f102026i / r105) + ((this.f102017J / r105) - (((r104 - r103.ascent) / r105) - r104)), r110, r102, r101, r100);
        final TextArtist$drawPerSlice$2 r106 = new TextArtist$drawPerSlice$2(this, r112);
        final TextArtist$drawPerSlice$3 r107 = new TextArtist$drawPerSlice$3(this, r110);
        ?? r108 = new TextArtist$drawPerSlice$4(this, r111, r106, r107, r112);
        int r109 = c();
        int r113 = 0;
    L6:
        if (r113 >= r109) goto L22;
        int r114 = this.C;
        if (r113 >= r114) goto L27;
        if (r113 == (r114 - 1)) goto L13;
    L20:
        r106.invoke(r113);
    L21:
        r113 = r113 + 1;
        goto L6
    L13:
        if (c() <= this.C) goto L20;
        if (this.D.length() <= 0) goto L17;
        boolean r115 = true;
    L18:
        if (r115 == false) goto L20;
        r108.invoke(r113);
        goto L21
    L17:
        r115 = false;
        goto L18
    L27:
        return;
    }

    public final float f(float r100, Object r101) {
        float r102 = 0.0f;
        if ((r101 instanceof String) == false) goto L6;
        r101 = Character.valueOf(StringsKt.last((CharSequence) r101));
    L8:
        Float r103 = this.f102043z.get(r101);
        if (r103 == null) goto L11;
        float r104 = r103.floatValue();
    L12:
        r102 = Math.max(0.0f, r104 - 0);
    L14:
        return r100 - r102;
    L11:
        r104 = 0.0f;
        goto L12
    L6:
        if ((r101 instanceof d) == false) goto L8;
        goto L8
    }

    public TextArtist(CharSequence r110, f r111, TextPaint r210, boolean r211) {
        CharSequence r100 = r110;
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r111, "textPaint");
        Intrinsics.checkNotNullParameter(r210, "textPaintForSpan");
        this.L = r100;
        this.M = r111;
        this.N = r210;
        this.O = r211;
        String r101 = r110.toString();
        this.f102018a = r101;
        int r102 = r101.length();
        this.f102019b = r102;
        this.f102022e = 15;
        this.f102024g = new ArrayList(15);
        this.f102025h = 15;
        this.f102027j = -1;
        this.f102028k = s1.e(16.0f);
        int r103 = 1;
        this.f102029l = true;
        this.f102032o = new float[r102];
        this.f102034q = DeviceUtils.isMiui();
        this.f102020c = new ArrayList(r102);
        if ((r100 instanceof Spanned) == true) goto L5;
        r100 = null;
    L5:
        Spanned r104 = (Spanned) r100;
        if (r104 == null) goto L24;
        Object[] r105 = r104.getSpans(0, r102, CharacterStyle.class);
        if (r105 == null) goto L10;
        Arrays.sort(r105, new e(r104));
    L10:
        CharacterStyle[] r106 = (CharacterStyle[]) r105;
        if (r106 == null) goto L24;
        ArrayList r107 = new ArrayList();
        int r108 = r106.length;
        int r109 = 0;
    L13:
        if (r109 >= r108) goto L25;
        CharacterStyle r112 = r106[r109];
        if ((r112 instanceof a) == false) goto L17;
    L20:
        boolean r113 = true;
    L21:
        if (r113 == false) goto L23;
        r107.add(r112);
    L23:
        r109 = r109 + 1;
        goto L13
    L17:
        if ((r112 instanceof ForegroundColorSpan) == true) goto L20;
        r113 = false;
    L25:
        if (r107 == null) goto L30;
        Iterator r114 = r107.iterator();
    L28:
        if (r114.hasNext() == false) goto L30;
        CharacterStyle r115 = (CharacterStyle) r114.next();
        this.f102024g.add(RangesKt.until(r104.getSpanStart(r115), r104.getSpanEnd(r115)));
    L30:
        this.f102023f = r107;
        String r116 = this.f102018a;
        if (r116 == null) goto L179;
        char[] r117 = r116.toCharArray();
        this.M.getTextWidths(r117, 0, r117.length, this.f102032o);
        this.f102033p = this.f102028k;
        if (r104 == null) goto L38;
        Object[] r118 = r104.getSpans(0, this.f102019b, ImageSpan.class);
        if (r118 == null) goto L37;
        Arrays.sort(r118, new e(r104));
    L37:
        ImageSpan[] r119 = (ImageSpan[]) r118;
    L39:
        ArrayList r120 = new ArrayList(this.f102022e);
        if (r119 == null) goto L45;
        int r121 = r119.length;
        int r122 = 0;
    L42:
        if (r122 >= r121) goto L45;
        ImageSpan r123 = r119[r122];
        r120.add(RangesKt.until(r104.getSpanStart(r123), r104.getSpanEnd(r123)));
        r122 = r122 + 1;
    L45:
        if ((!r120.isEmpty()) == false) goto L47;
        IntRange r124 = (IntRange) ListProtector.get(r120, 0);
    L49:
        if (this.O == true) goto L51;
        ArrayList r125 = new ArrayList();
    L133:
        if ((!r125.isEmpty()) == false) goto L135;
        IntRange r126 = (IntRange) ListProtector.get(r125, 0);
    L136:
        int r127 = 0;
        int r128 = 0;
        int r129 = 0;
    L138:
        if (r129 >= this.f102019b) goto L176;
        if (r124 == null) goto L155;
        if (r129 != r124.getStart().intValue()) goto L155;
        if (r119 == null) goto L144;
        int r130 = r119.length;
    L145:
        if (r130 <= r128) goto L148;
        if (r119 == null) goto L148;
        ImageSpan r131 = r119[r128];
    L149:
        if (r131 == null) goto L138;
        this.f102020c.add(new d(StringsKt.substring(this.L, r124), r124, r131));
        r129 = r129 + ((r124.getLast() - r124.getFirst()) + 1);
        r128 = r128 + 1;
        if (r120.size() > r128) goto L153;
        r124 = null;
        goto L138
    L153:
        r124 = (IntRange) ListProtector.get(r120, r128);
    L148:
        r131 = null;
        goto L149
    L144:
        r130 = 0;
    L155:
        if (r126 == null) goto L162;
        if (r129 != r126.getStart().intValue()) goto L162;
        this.f102020c.add(StringsKt.substring(this.L, r126));
        r129 = r129 + ((r126.getLast() - r126.getFirst()) + 1);
        r127 = r127 + 1;
        if (r125.size() > r127) goto L160;
        r126 = null;
        goto L138
    L160:
        r126 = (IntRange) ListProtector.get(r125, r127);
    L162:
        char r132 = this.f102018a.charAt(r129);
        if (this.f102032o[r129] <= 0) goto L166;
        this.f102020c.add(Character.valueOf(r132));
    L175:
        r129 = r129 + 1;
        goto L138
    L166:
        if ((!this.f102020c.isEmpty()) == false) goto L174;
        Object r133 = CollectionsKt.last(this.f102020c);
        if ((r133 instanceof Character) == false) goto L170;
    L173:
        ArrayList<? extends Object> r134 = this.f102020c;
        ListProtector.remove(r134, r134.size() - 1);
        StringBuilder r135 = new StringBuilder();
        r135.append(r133);
        r135.append(r132);
        this.f102020c.add(r135.toString());
        goto L175
    L170:
        if ((r133 instanceof String) == true) goto L173;
        this.f102020c.add(Character.valueOf(r132));
        goto L175
    L174:
        this.f102020c.add(Character.valueOf(r132));
        goto L175
    L176:
        int r136 = this.f102020c.size();
        this.f102021d = r136;
        this.f102035r = new float[r136];
        this.f102036s = new float[r136];
        this.f102037t = new float[r136];
        this.f102038u = new ArrayList(this.f102022e);
        this.f102039v = "AM ";
        this.f102040w = new float[3];
        this.f102041x = new float[1];
        this.f102042y = new Rect();
        this.f102043z = new HashMap();
        this.B = c.f102046b;
        this.C = Integer.MAX_VALUE;
        this.D = "";
        this.F = new RectF();
        this.G = new Paint.FontMetrics();
        this.H = new Paint.FontMetricsInt();
        this.I = new Paint.FontMetricsInt();
        this.K = LazyKt.lazy(LazyThreadSafetyMode.NONE, TextArtist$linePaint$2.INSTANCE);
        return;
    L135:
        r126 = null;
        goto L136
    L51:
        if ((!this.f102024g.isEmpty()) == false) goto L53;
        IntRange r137 = (IntRange) ListProtector.get(this.f102024g, 0);
        int r138 = r137.getFirst();
        int r139 = r137.getLast() + 1;
    L54:
        int r140 = this.f102024g.size();
        r125 = new ArrayList(this.f102022e);
        int r141 = 0;
        int r142 = 0;
    L56:
        if (r141 >= (this.f102019b - r103)) goto L133;
        if (r141 < r139) goto L62;
        r142 = r142 + 1;
        if (r142 >= r140) goto L61;
        IntRange r143 = (IntRange) ListProtector.get(this.f102024g, r142);
        r138 = r143.getFirst();
        r139 = r143.getLast() + r103;
        goto L62
    L61:
        r139 = 2147483646;
        r138 = 2147483646;
    L62:
        char r144 = this.f102018a.charAt(r141);
        int r145 = 2;
        if (j(r144) == true) goto L104;
        if (i(r144) == true) goto L104;
        if (this.f102032o[r141] == 0.0f) goto L69;
        int r146 = r141 + 1;
        if (r146 == r138) goto L103;
        if (r146 == r139) goto L103;
        char r147 = this.f102018a.charAt(r146);
        if (h(r147) == false) goto L77;
    L82:
        boolean r148 = true;
    L84:
        if (this.f102034q == true) goto L86;
    L90:
        if (r148 == false) goto L92;
    L99:
        int r149 = 1;
        r145 = 1;
    L100:
        if (r145 <= r149) goto L102;
        r125.add(RangesKt.until(r141, r141 + r145));
    L102:
        r141 = r141 + r145;
    L130:
        r103 = 1;
        goto L56
    L92:
        if (R.contains(Character.valueOf(r147)) == false) goto L99;
        int r150 = r141 + 2;
        if (r150 < this.f102019b) goto L96;
    L98:
        r149 = 1;
        goto L100
    L96:
        if (StringsKt.contains$default("”’'\"", this.f102018a.charAt(r150), false, 2, null) == false) goto L98;
        r145 = 3;
        goto L98
    L86:
        if (h(r144) == false) goto L90;
        if (r147 != '.') goto L90;
    L77:
        if (j(r147) == true) goto L82;
        if (i(r147) == true) goto L82;
        r148 = false;
    L103:
        r141 = r146;
        goto L130
    L69:
        r141 = r141 + 1;
    L104:
        int r151 = r141 + 1;
        int r152 = r151;
        int r153 = 1;
    L105:
        if (r152 < r151) goto L125;
        if (r152 >= this.f102019b) goto L125;
        if (r152 == r138) goto L125;
        if (r152 == r139) goto L125;
        char r154 = this.f102018a.charAt(r152);
        r152 = r152 + 1;
        if (j(r154) == false) goto L114;
    L117:
        boolean r155 = true;
    L118:
        if (r155 == false) goto L121;
        r153 = r153 + 1;
        goto L105
    L121:
        if (h(r154) == true) goto L125;
        if (R.contains(Character.valueOf(r154)) == false) goto L125;
        r153 = r153 + 1;
        goto L125
    L114:
        if (i(r154) == true) goto L117;
        r155 = false;
    L125:
        if (r153 >= 2) goto L127;
    L129:
        r141 = r141 + r153;
        goto L130
    L127:
        if (r153 > this.f102025h) goto L129;
        r125.add(RangesKt.until(r141, r141 + r153));
        goto L129
    L53:
        r139 = 2147483646;
        r138 = 2147483646;
        goto L54
    L47:
        r124 = null;
        goto L49
    L38:
        r119 = null;
        goto L39
    L179:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L24:
        r107 = null;
        goto L25
    }
}
