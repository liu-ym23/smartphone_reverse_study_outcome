package com.bytedance.android.shopping.store.slicecard.view;

import android.graphics.Typeface;
import androidx.core.graphics.ColorUtils;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.ECUrlModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f186382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f186383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ECUrlModel f186384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Float f186385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Float f186386e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Float f186387f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f186388g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f186389h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<Integer> f186390i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<Float> f186391j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Float f186392k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f186393l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ECUrlModel f186394m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<Integer> f186395n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<Float> f186396o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Float f186397p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<Float> f186398q;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L40;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f186382a, r101.f186382a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f186383b, r101.f186383b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f186384c, r101.f186384c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f186385d, r101.f186385d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f186386e, r101.f186386e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f186387f, r101.f186387f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f186388g, r101.f186388g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f186389h, r101.f186389h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f186390i, r101.f186390i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f186391j, r101.f186391j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f186392k, r101.f186392k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f186393l, r101.f186393l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f186394m, r101.f186394m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f186395n, r101.f186395n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f186396o, r101.f186396o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f186397p, r101.f186397p) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.f186398q, r101.f186398q) == true) goto L61;
        return false;
    L61:
        return true;
    L40:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f186382a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f186383b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ECUrlModel r107 = this.f186384c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Float r110 = this.f186385d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Float r113 = this.f186386e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Float r116 = this.f186387f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.f186388g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f186389h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        List<Integer> r125 = this.f186390i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        List<Float> r128 = this.f186391j;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        Float r131 = this.f186392k;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.f186393l;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        ECUrlModel r137 = this.f186394m;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        List<Integer> r140 = this.f186395n;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        List<Float> r143 = this.f186396o;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        Float r146 = this.f186397p;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        List<Float> r149 = this.f186398q;
        if (r149 == null) goto L70;
        r101 = r149.hashCode();
    L70:
        return r148 + r101;
    L65:
        r147 = 0;
        goto L66
    L61:
        r144 = 0;
        goto L62
    L57:
        r141 = 0;
        goto L58
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RichTextItem(text=" + this.f186382a + ", textColor=" + this.f186383b + ", image=" + this.f186384c + ", imageWidthPx=" + this.f186385d + ", imageHeightPx=" + this.f186386e + ", fontSizePx=" + this.f186387f + ", fontWeight=" + this.f186388g + ", fontFamily=" + this.f186389h + ", textColors=" + this.f186390i + ", textPositions=" + this.f186391j + ", textOrientation=" + this.f186392k + ", immersiveTextColor=" + this.f186393l + ", immersiveImage=" + this.f186394m + ", immersiveTextColors=" + this.f186395n + ", immersiveTextPositions=" + this.f186396o + ", immersiveTextOrientation=" + this.f186397p + ", imageMarginPx=" + this.f186398q + ")";
    }

    public final boolean b() {
        if ((!StringsKt.isBlank(this.f186382a)) == false) goto L5;
        return true;
    L5:
        if (this.f186384c == null) goto L7;
        return true;
    L7:
        if (this.f186394m != null) goto L13;
        return false;
    L13:
        return true;
    }

    public static d a(d r100, int r101, float r102) {
        int r103 = r100.f186369a.length;
        int[] r104 = new int[r103];
        int r105 = 0;
    L3:
        if (r105 >= r103) goto L5;
        r104[r105] = ColorUtils.blendARGB(r100.f186369a[r105], r101, r102);
        r105 = r105 + 1;
        goto L3
    L5:
        float[] r106 = r100.f186370b;
        float r107 = r100.f186371c;
        Intrinsics.checkNotNullParameter(r104, "colors");
        return new d(r104, r106, r107);
    }

    public static d c(List r100, List r101, Float r102) {
        boolean r103 = false;
        if (r100.size() < 2) goto L5;
        boolean r104 = true;
    L6:
        float[] r105 = null;
        if (r104 == false) goto L9;
        List r106 = r100;
    L10:
        if (r106 != null) goto L12;
        return null;
    L12:
        if (r101.size() != r100.size()) goto L14;
        boolean r107 = true;
    L15:
        if (r107 == true) goto L19;
        r101 = null;
    L19:
        if (r102 == null) goto L21;
        float r108 = r102.floatValue();
    L22:
        f r109 = b.f186361a;
        int[] r110 = CollectionsKt.toIntArray(r106);
        if (r101 == null) goto L37;
        if (r101.size() != r106.size()) goto L27;
        r103 = true;
    L27:
        if (r103 == true) goto L30;
        r101 = null;
    L30:
        if (r101 == null) goto L37;
        List r111 = r101;
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator r113 = r111.iterator();
    L33:
        if (r113.hasNext() == false) goto L35;
        r112.add(Float.valueOf(RangesKt.coerceIn(((Number) r113.next()).floatValue(), 0.0f, 1.0f)));
        goto L33
    L35:
        r105 = CollectionsKt.toFloatArray(r112);
    L37:
        return new d(r110, r105, r108);
    L21:
        r108 = 0.0f;
        goto L22
    L14:
        r107 = false;
        goto L15
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = false;
        goto L6
    }

    public /* synthetic */ g(String r210, String r211, ECUrlModel r212, int r213) {
        List r100 = null;
        if ((r213 & 2) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r213 & 4) == 0) goto L9;
        ECUrlModel r102 = null;
    L11:
        if ((r213 & 256) == 0) goto L13;
        List r110 = CollectionsKt.emptyList();
    L15:
        if ((r213 & 512) == 0) goto L17;
        List r111 = CollectionsKt.emptyList();
    L19:
        if ((r213 & 8192) == 0) goto L21;
        List r112 = CollectionsKt.emptyList();
    L23:
        if ((r213 & 16384) == 0) goto L25;
        List r113 = CollectionsKt.emptyList();
    L27:
        if ((r213 & 65536) == 0) goto L29;
        r100 = CollectionsKt.emptyList();
    L29:
        this(r210, r101, r102, null, null, null, null, null, r110, r111, null, null, null, r112, r113, null, r100);
        return;
    L25:
        r113 = null;
        goto L27
    L21:
        r112 = null;
        goto L23
    L17:
        r111 = null;
        goto L19
    L13:
        r110 = null;
        goto L15
    L9:
        r102 = r212;
        goto L11
    L5:
        r101 = r211;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final e d(float r210, int r211, float r212, PropertyReference0Impl r213) {
        float r100 = RangesKt.coerceIn(1.0f - r210, 0.0f, 1.0f);
        d r101 = c(this.f186390i, this.f186391j, this.f186392k);
        d r102 = c(this.f186395n, this.f186396o, this.f186397p);
        String r103 = this.f186383b;
        float[] r104 = null;
        if (r103 != null) goto L5;
    L10:
        int r105 = r211;
    L11:
        String r110 = this.f186393l;
        if (r110 != null) goto L14;
    L19:
        Integer r111 = null;
    L21:
        if (r101 == null) goto L52;
        if (r102 == null) goto L52;
        int r106 = Math.min(r101.f186369a.length, r102.f186369a.length);
        int[] r112 = new int[r106];
        int r113 = 0;
    L24:
        if (r113 >= r106) goto L26;
        r112[r113] = ColorUtils.blendARGB(r101.f186369a[r113], r102.f186369a[r113], r100);
        r113 = r113 + 1;
        goto L24
    L26:
        float[] r114 = r101.f186370b;
        if (r114 == null) goto L37;
        float[] r115 = r102.f186370b;
        if (r115 == null) goto L37;
        if (r114.length < r106) goto L37;
        if (r115.length < r106) goto L37;
        float[] r116 = new float[r106];
        int r117 = 0;
    L35:
        if (r117 >= r106) goto L48;
        float r118 = r101.f186370b[r117];
        r116[r117] = r118 + ((r102.f186370b[r117] - r118) * r100);
        r117 = r117 + 1;
    L48:
        if (r100 < 0.5f) goto L50;
        float r107 = r102.f186371c;
    L51:
        r101 = new d(r112, r116, r107);
    L60:
        if (r101 == null) goto L62;
        Integer r119 = null;
    L67:
        if (Intrinsics.areEqual(this.f186389h, "DouyinSans") == false) goto L71;
        Typeface r108 = (Typeface) r213.invoke();
        if (r108 != null) goto L81;
        r108 = Typeface.DEFAULT;
    L81:
        Integer r109 = this.f186388g;
        if (r109 != null) goto L84;
    L86:
        Typeface r120 = r108;
        if (r101 == null) goto L89;
        int[] r121 = r101.f186369a;
    L90:
        if (r101 == null) goto L92;
        r104 = r101.f186370b;
    L92:
        float[] r122 = r104;
        Float r123 = this.f186387f;
        if (r123 == null) goto L95;
        float r124 = r123.floatValue();
    L96:
        if (r101 == null) goto L98;
        Float r125 = Float.valueOf(r101.f186371c);
    L99:
        if (r125 == null) goto L101;
        float r126 = r125.floatValue();
    L103:
        return new e(r119, r121, r122, r124, r120, r126);
    L101:
        r126 = 0.0f;
        goto L103
    L98:
        r125 = this.f186392k;
        goto L99
    L95:
        r124 = r212;
        goto L96
    L89:
        r121 = null;
        goto L90
    L84:
        if (r109.intValue() < 600) goto L86;
        r108 = Typeface.create(r108, 1);
        goto L86
    L71:
        String r127 = this.f186389h;
        if (r127 != null) goto L74;
    L77:
        boolean r128 = true;
    L78:
        if (r128 == true) goto L80;
        r108 = Typeface.create(this.f186389h, 0);
        goto L81
    L80:
        r108 = null;
        goto L81
    L74:
        if (StringsKt.isBlank(r127) == true) goto L77;
        r128 = false;
        goto L78
    L62:
        if (r111 == null) goto L64;
        Integer r129 = Integer.valueOf(ColorUtils.blendARGB(r105, r111.intValue(), r100));
    L65:
        r119 = r129;
        goto L67
    L64:
        r129 = Integer.valueOf(r211);
        goto L65
    L50:
        r107 = r101.f186371c;
    L37:
        float[] r130 = r102.f186370b;
        if (r130 != null) goto L40;
    L42:
        if (r114 != null) goto L44;
    L46:
        r116 = null;
        goto L48
    L44:
        if (r114.length < r106) goto L46;
        r116 = Arrays.copyOf(r114, r106);
        goto L48
    L40:
        if (r130.length < r106) goto L42;
        r116 = Arrays.copyOf(r130, r106);
    L52:
        if (r101 == null) goto L55;
        if (r111 == null) goto L55;
        r101 = a(r101, r111.intValue(), r100);
    L55:
        if (r102 == null) goto L57;
        r101 = a(r102, r105, 1.0f - r100);
        goto L60
    L57:
        if (r101 != null) goto L60;
        r101 = null;
        goto L60
    L14:
        if ((!StringsKt.isBlank(r110)) == true) goto L17;
        r110 = null;
    L17:
        if (r110 == null) goto L19;
        r111 = Integer.valueOf(s.a(r110, r211));
        goto L21
    L5:
        if ((!StringsKt.isBlank(r103)) == true) goto L8;
        r103 = null;
    L8:
        if (r103 == null) goto L10;
        r105 = s.a(r103, r211);
        goto L11
    }

    public g(String r100, String r110, ECUrlModel r111, Float r112, Float r113, Float r114, Integer r115, String r116, List<Integer> r117, List<Float> r118, Float r119, String r210, ECUrlModel r211, List<Integer> r212, List<Float> r213, Float r214, List<Float> r215) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r117, "textColors");
        Intrinsics.checkNotNullParameter(r118, "textPositions");
        Intrinsics.checkNotNullParameter(r212, "immersiveTextColors");
        Intrinsics.checkNotNullParameter(r213, "immersiveTextPositions");
        Intrinsics.checkNotNullParameter(r215, "imageMarginPx");
        this.f186382a = r100;
        this.f186383b = r110;
        this.f186384c = r111;
        this.f186385d = r112;
        this.f186386e = r113;
        this.f186387f = r114;
        this.f186388g = r115;
        this.f186389h = r116;
        this.f186390i = r117;
        this.f186391j = r118;
        this.f186392k = r119;
        this.f186393l = r210;
        this.f186394m = r211;
        this.f186395n = r212;
        this.f186396o = r213;
        this.f186397p = r214;
        this.f186398q = r215;
    }
}
