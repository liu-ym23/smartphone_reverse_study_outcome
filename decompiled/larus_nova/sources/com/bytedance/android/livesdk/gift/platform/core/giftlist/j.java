package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import com.bytedance.android.livesdk.gift.model.b3;
import com.bytedance.android.livesdk.gift.model.c1;
import com.bytedance.android.livesdk.gift.model.d2;
import com.bytedance.android.livesdk.gift.model.o2;
import com.bytedance.android.livesdk.gift.model.x2;
import com.bytedance.android.livesdk.gift.model.z2;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f130599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f130600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f130601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f130602d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final py.k f130603e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final py.k f130604f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final py.k f130605g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<s> f130606h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final x2 f130607i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b3 f130608j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final z2 f130609k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<Long> f130610l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<c1> f130611m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<d2> f130612n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f130613o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<o2> f130614p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Map<Integer, Long> f130615q;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L40;
        j r101 = (j) r100;
        if (this.f130599a == r101.f130599a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f130600b, r101.f130600b) == true) goto L10;
        return false;
    L10:
        if (this.f130601c == r101.f130601c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f130602d, r101.f130602d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f130603e, r101.f130603e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f130604f, r101.f130604f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f130605g, r101.f130605g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f130606h, r101.f130606h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f130607i, r101.f130607i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f130608j, r101.f130608j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f130609k, r101.f130609k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f130610l, r101.f130610l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f130611m, r101.f130611m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f130612n, r101.f130612n) == true) goto L34;
        return false;
    L34:
        if (this.f130613o == r101.f130613o) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f130614p, r101.f130614p) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.f130615q, r101.f130615q) == true) goto L61;
        return false;
    L61:
        return true;
    L40:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v55 */
    /* JADX WARN: Type inference failed for: r1v57 */
    public final int hashCode() {
        int r100 = this.f130599a * 31;
        String r101 = this.f130600b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        boolean r105 = this.f130601c;
        ?? r106 = r105;
        if (r105 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f130602d;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        py.k r111 = this.f130603e;
        if (r111 == null) goto L16;
        int r112 = r111.hashCode();
    L17:
        int r113 = (r110 + r112) * 31;
        py.k r114 = this.f130604f;
        if (r114 == null) goto L20;
        int r115 = r114.hashCode();
    L21:
        int r116 = (r113 + r115) * 31;
        py.k r117 = this.f130605g;
        if (r117 == null) goto L24;
        int r118 = r117.hashCode();
    L25:
        int r119 = (r116 + r118) * 31;
        List<s> r120 = this.f130606h;
        if (r120 == null) goto L28;
        int r121 = r120.hashCode();
    L29:
        int r122 = (r119 + r121) * 31;
        x2 r123 = this.f130607i;
        if (r123 == null) goto L32;
        int r124 = r123.hashCode();
    L33:
        int r125 = (r122 + r124) * 31;
        b3 r126 = this.f130608j;
        if (r126 == null) goto L36;
        int r127 = r126.hashCode();
    L37:
        int r128 = (r125 + r127) * 31;
        z2 r129 = this.f130609k;
        if (r129 == null) goto L40;
        int r130 = r129.hashCode();
    L41:
        int r131 = (r128 + r130) * 31;
        List<Long> r132 = this.f130610l;
        if (r132 == null) goto L44;
        int r133 = r132.hashCode();
    L45:
        int r134 = (r131 + r133) * 31;
        List<c1> r135 = this.f130611m;
        if (r135 == null) goto L48;
        int r136 = r135.hashCode();
    L49:
        int r137 = (r134 + r136) * 31;
        List<d2> r138 = this.f130612n;
        if (r138 == null) goto L52;
        int r139 = r138.hashCode();
    L53:
        int r140 = (((r137 + r139) * 31) + this.f130613o) * 31;
        List<o2> r141 = this.f130614p;
        if (r141 == null) goto L56;
        int r142 = r141.hashCode();
    L57:
        int r143 = (r140 + r142) * 31;
        Map<Integer, Long> r144 = this.f130615q;
        if (r144 == null) goto L61;
        r102 = r144.hashCode();
    L61:
        return r143 + r102;
    L56:
        r142 = 0;
        goto L57
    L52:
        r139 = 0;
        goto L53
    L48:
        r136 = 0;
        goto L49
    L44:
        r133 = 0;
        goto L45
    L40:
        r130 = 0;
        goto L41
    L36:
        r127 = 0;
        goto L37
    L32:
        r124 = 0;
        goto L33
    L28:
        r121 = 0;
        goto L29
    L24:
        r118 = 0;
        goto L25
    L20:
        r115 = 0;
        goto L21
    L16:
        r112 = 0;
        goto L17
    L12:
        r109 = 0;
        goto L13
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "PageModel(pageType=" + this.f130599a + ", pageName=" + this.f130600b + ", display=" + this.f130601c + ", eventName=" + this.f130602d + ", backgroundImage=" + this.f130603e + ", receiversModBg=" + this.f130604f + ", receiversLongModBg=" + this.f130605g + ", sectionList=" + this.f130606h + ", pageInfo=" + this.f130607i + ", pageNameStyleInfo=" + this.f130608j + ", lynxConfig=" + this.f130609k + ", gifts=" + this.f130610l + ", baseGifts=" + this.f130611m + ", topicList=" + this.f130612n + ", sortStrategy=" + this.f130613o + ", scrollPageNames=" + this.f130614p + ", forceInsertMap=" + this.f130615q + ")";
    }

    public final boolean a() {
        return this.f130601c;
    }

    public final int b() {
        return this.f130599a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(int r100, String r101, boolean r102, String r103, py.k r110, py.k r111, py.k r112, List<s> r113, x2 r114, b3 r115, z2 r116, List<Long> r117, List<? extends c1> r118, List<? extends d2> r119, int r210, List<? extends o2> r211, Map<Integer, Long> r212) {
        Intrinsics.checkNotNullParameter(r101, "pageName");
        Intrinsics.checkNotNullParameter(r103, "eventName");
        Intrinsics.checkNotNullParameter(r117, "gifts");
        this.f130599a = r100;
        this.f130600b = r101;
        this.f130601c = r102;
        this.f130602d = r103;
        this.f130603e = r110;
        this.f130604f = r111;
        this.f130605g = r112;
        this.f130606h = r113;
        this.f130607i = r114;
        this.f130608j = r115;
        this.f130609k = r116;
        this.f130610l = r117;
        this.f130611m = r118;
        this.f130612n = r119;
        this.f130613o = r210;
        this.f130614p = r211;
        this.f130615q = r212;
    }
}
