package com.bytedance.android.shopping.anchorv4.bottom;

import androidx.fragment.app.FragmentManager;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentManager f165827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f165828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f165829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f165830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f165831e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f165832f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f165833g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f165834h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f165835i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f165836j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f165837k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f165838l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Boolean f165839m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Integer f165840n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<String> f165841o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f165842p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Integer f165843q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f165844r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Map<String, Object> f165845s;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j0) == false) goto L44;
        j0 r101 = (j0) r100;
        if (Intrinsics.areEqual(this.f165827a, r101.f165827a) == true) goto L8;
        return false;
    L8:
        if (this.f165828b == r101.f165828b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f165829c, r101.f165829c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f165830d, r101.f165830d) == true) goto L14;
        return false;
    L14:
        if (this.f165831e == r101.f165831e) goto L16;
        return false;
    L16:
        if (this.f165832f == r101.f165832f) goto L18;
        return false;
    L18:
        if (this.f165833g == r101.f165833g) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f165834h, r101.f165834h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f165835i, r101.f165835i) == true) goto L24;
        return false;
    L24:
        if (this.f165836j == r101.f165836j) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f165837k, r101.f165837k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f165838l, r101.f165838l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f165839m, r101.f165839m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f165840n, r101.f165840n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f165841o, r101.f165841o) == true) goto L36;
        return false;
    L36:
        if (this.f165842p == r101.f165842p) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.f165843q, r101.f165843q) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.f165844r, r101.f165844r) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f165845s, r101.f165845s) == true) goto L67;
        return false;
    L67:
        return true;
    L44:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v58 */
    /* JADX WARN: Type inference failed for: r2v59 */
    /* JADX WARN: Type inference failed for: r2v60 */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public final int hashCode() {
        FragmentManager r100 = this.f165827a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f165828b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        String r105 = this.f165829c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f165830d;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        boolean r111 = this.f165831e;
        ?? r112 = 1;
        ?? r113 = r111;
        if (r111 == false) goto L17;
        r113 = 1;
    L17:
        int r114 = (r110 + r113) * 31;
        boolean r115 = this.f165832f;
        ?? r116 = r115;
        if (r115 == false) goto L20;
        r116 = 1;
    L20:
        int r117 = (r114 + r116) * 31;
        boolean r118 = this.f165833g;
        ?? r119 = r118;
        if (r118 == false) goto L23;
        r119 = 1;
    L23:
        int r120 = (r117 + r119) * 31;
        Integer r121 = this.f165834h;
        if (r121 == null) goto L26;
        int r122 = r121.hashCode();
    L27:
        int r123 = (r120 + r122) * 31;
        Integer r124 = this.f165835i;
        if (r124 == null) goto L30;
        int r125 = r124.hashCode();
    L31:
        int r126 = (r123 + r125) * 31;
        boolean r127 = this.f165836j;
        if (r127 == true) goto L35;
        r112 = r127;
    L35:
        int r128 = (r126 + r112) * 31;
        Integer r129 = this.f165837k;
        if (r129 == null) goto L38;
        int r130 = r129.hashCode();
    L39:
        int r131 = (r128 + r130) * 31;
        String r132 = this.f165838l;
        if (r132 == null) goto L42;
        int r133 = r132.hashCode();
    L43:
        int r134 = (r131 + r133) * 31;
        Boolean r135 = this.f165839m;
        if (r135 == null) goto L46;
        int r136 = r135.hashCode();
    L47:
        int r137 = (r134 + r136) * 31;
        Integer r138 = this.f165840n;
        if (r138 == null) goto L50;
        int r139 = r138.hashCode();
    L51:
        int r140 = (r137 + r139) * 31;
        List<String> r141 = this.f165841o;
        if (r141 == null) goto L54;
        int r142 = r141.hashCode();
    L55:
        int r143 = (((r140 + r142) * 31) + this.f165842p) * 31;
        Integer r144 = this.f165843q;
        if (r144 == null) goto L58;
        int r145 = r144.hashCode();
    L59:
        int r146 = (r143 + r145) * 31;
        String r147 = this.f165844r;
        if (r147 == null) goto L62;
        int r148 = r147.hashCode();
    L63:
        int r149 = (r146 + r148) * 31;
        Map<String, Object> r150 = this.f165845s;
        if (r150 == null) goto L67;
        r101 = r150.hashCode();
    L67:
        return r149 + r101;
    L62:
        r148 = 0;
        goto L63
    L58:
        r145 = 0;
        goto L59
    L54:
        r142 = 0;
        goto L55
    L50:
        r139 = 0;
        goto L51
    L46:
        r136 = 0;
        goto L47
    L42:
        r133 = 0;
        goto L43
    L38:
        r130 = 0;
        goto L39
    L30:
        r125 = 0;
        goto L31
    L26:
        r122 = 0;
        goto L27
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SkuNativeParam(fragmentManager=" + this.f165827a + ", pageResumeTime=" + this.f165828b + ", promotionLogId=" + this.f165829c + ", pageType=" + this.f165830d + ", isFromFeedProductGuessULike=" + this.f165831e + ", isGroupBuying=" + this.f165832f + ", addToCart=" + this.f165833g + ", actionType=" + this.f165834h + ", sceneType=" + this.f165835i + ", isCustomBuying=" + this.f165836j + ", heightPercent=" + this.f165837k + ", skuFrom=" + this.f165838l + ", scrollToInstallment=" + this.f165839m + ", termCount=" + this.f165840n + ", defaultSpecIDs=" + this.f165841o + ", ultimateBuyType=" + this.f165842p + ", forceYataSku=" + this.f165843q + ", bizIdentifier=" + this.f165844r + ", trackExtra=" + this.f165845s + ")";
    }

    public j0(FragmentManager r100, long r101, String r102, String r103, boolean r104, boolean r110, boolean r111, Integer r112, Integer r113, boolean r114, Integer r115, String r116, Boolean r117, Integer r118, List<String> r119, int r210, Integer r211, String r212, Map<String, ? extends Object> r213) {
        Intrinsics.checkNotNullParameter(r100, "fragmentManager");
        this.f165827a = r100;
        this.f165828b = r101;
        this.f165829c = r102;
        this.f165830d = r103;
        this.f165831e = r104;
        this.f165832f = r110;
        this.f165833g = r111;
        this.f165834h = r112;
        this.f165835i = r113;
        this.f165836j = r114;
        this.f165837k = r115;
        this.f165838l = r116;
        this.f165839m = r117;
        this.f165840n = r118;
        this.f165841o = r119;
        this.f165842p = r210;
        this.f165843q = r211;
        this.f165844r = r212;
        this.f165845s = r213;
    }

    public /* synthetic */ j0(FragmentManager r210, long r211, String r212, String r213, boolean r310, boolean r311, boolean r312, Integer r313, Integer r314, boolean r315, Integer r316, String r317, Boolean r318, Integer r319, List r410, int r411, Integer r412, String r413, Map r414, int r415) {
        if ((r415 & 4) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r415 & 8) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r415 & 16) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r415 & 32) == 0) goto L17;
        boolean r110 = false;
    L19:
        if ((r415 & 64) == 0) goto L21;
        boolean r111 = false;
    L23:
        if ((r415 & 128) == 0) goto L25;
        Integer r112 = null;
    L27:
        if ((r415 & 256) == 0) goto L29;
        Integer r113 = null;
    L31:
        if ((r415 & 512) == 0) goto L33;
        boolean r114 = false;
    L35:
        if ((r415 & 1024) == 0) goto L37;
        Integer r115 = 0;
    L39:
        if ((r415 & 2048) == 0) goto L41;
        String r116 = null;
    L43:
        if ((r415 & 4096) == 0) goto L45;
        Boolean r117 = Boolean.FALSE;
    L47:
        if ((r415 & 8192) == 0) goto L49;
        Integer r118 = 0;
    L51:
        if ((r415 & 16384) == 0) goto L53;
        List r119 = null;
    L55:
        if ((32768 & r415) == 0) goto L57;
        int r214 = 0;
    L59:
        if ((65536 & r415) == 0) goto L61;
        Integer r215 = 0;
    L63:
        if ((131072 & r415) == 0) goto L65;
        String r216 = null;
    L67:
        if ((r415 & 262144) == 0) goto L69;
        Map r217 = null;
    L70:
        this(r210, r211, r100, r101, r102, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r214, r215, r216, r217);
        return;
    L69:
        r217 = r414;
        goto L70
    L65:
        r216 = r413;
        goto L67
    L61:
        r215 = r412;
        goto L63
    L57:
        r214 = r411;
        goto L59
    L53:
        r119 = r410;
        goto L55
    L49:
        r118 = r319;
        goto L51
    L45:
        r117 = r318;
        goto L47
    L41:
        r116 = r317;
        goto L43
    L37:
        r115 = r316;
        goto L39
    L33:
        r114 = r315;
        goto L35
    L29:
        r113 = r314;
        goto L31
    L25:
        r112 = r313;
        goto L27
    L21:
        r111 = r312;
        goto L23
    L17:
        r110 = r311;
        goto L19
    L13:
        r102 = r310;
        goto L15
    L9:
        r101 = r213;
        goto L11
    L5:
        r100 = r212;
        goto L7
    }
}
