package com.bytedance.android.livesdk.livecommerce.promotionlist.repository;

import com.bytedance.android.livesdk.livecommerce.event.ECEventUtilsV2;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f151109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f151110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f151111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f151112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f151113e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f151114f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f151115g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f151116h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f151117i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f151118j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f151119k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f151120l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f151121m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f151122n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f151123o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f151124p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f151125q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f151126r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f151127s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f151128t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f151129u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f151130v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f151131w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f151132x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f151133y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f151134z;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L48;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f151114f, r101.f151114f) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f151115g, r101.f151115g) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f151116h, r101.f151116h) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f151117i, r101.f151117i) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f151118j, r101.f151118j) == true) goto L16;
        return false;
    L16:
        if (this.f151119k == r101.f151119k) goto L18;
        return false;
    L18:
        if (this.f151120l == r101.f151120l) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f151121m, r101.f151121m) == true) goto L22;
        return false;
    L22:
        if (this.f151122n == r101.f151122n) goto L24;
        return false;
    L24:
        if (this.f151123o == r101.f151123o) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f151124p, r101.f151124p) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f151125q, r101.f151125q) == true) goto L30;
        return false;
    L30:
        if (this.f151126r == r101.f151126r) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f151127s, r101.f151127s) == true) goto L34;
        return false;
    L34:
        if (this.f151128t == r101.f151128t) goto L36;
        return false;
    L36:
        if (this.f151129u == r101.f151129u) goto L38;
        return false;
    L38:
        if (this.f151130v == r101.f151130v) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.f151131w, r101.f151131w) == true) goto L42;
        return false;
    L42:
        if (this.f151132x == r101.f151132x) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.f151133y, r101.f151133y) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.f151134z, r101.f151134z) == true) goto L73;
        return false;
    L73:
        return true;
    L48:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20, types: [int] */
    /* JADX WARN: Type inference failed for: r2v29, types: [int] */
    /* JADX WARN: Type inference failed for: r2v34, types: [int] */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v60 */
    /* JADX WARN: Type inference failed for: r2v61 */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Type inference failed for: r2v64 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f151114f;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f151115g;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f151116h;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f151117i;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f151118j;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        boolean r116 = this.f151119k;
        ?? r117 = 1;
        ?? r118 = r116;
        if (r116 == false) goto L25;
        r118 = 1;
    L25:
        int r119 = (r115 + r118) * 31;
        boolean r120 = this.f151120l;
        ?? r121 = r120;
        if (r120 == false) goto L28;
        r121 = 1;
    L28:
        int r122 = (r119 + r121) * 31;
        String r123 = this.f151121m;
        if (r123 == null) goto L31;
        int r124 = r123.hashCode();
    L32:
        int r125 = (r122 + r124) * 31;
        boolean r126 = this.f151122n;
        ?? r127 = r126;
        if (r126 == false) goto L35;
        r127 = 1;
    L35:
        int r128 = (((r125 + r127) * 31) + this.f151123o) * 31;
        String r129 = this.f151124p;
        if (r129 == null) goto L38;
        int r130 = r129.hashCode();
    L39:
        int r131 = (r128 + r130) * 31;
        String r132 = this.f151125q;
        if (r132 == null) goto L42;
        int r133 = r132.hashCode();
    L43:
        int r134 = (r131 + r133) * 31;
        boolean r135 = this.f151126r;
        ?? r136 = r135;
        if (r135 == false) goto L46;
        r136 = 1;
    L46:
        int r137 = (r134 + r136) * 31;
        String r138 = this.f151127s;
        if (r138 == null) goto L49;
        int r139 = r138.hashCode();
    L50:
        int r140 = (r137 + r139) * 31;
        boolean r141 = this.f151128t;
        ?? r142 = r141;
        if (r141 == false) goto L53;
        r142 = 1;
    L53:
        int r143 = (((((r140 + r142) * 31) + this.f151129u) * 31) + this.f151130v) * 31;
        String r144 = this.f151131w;
        if (r144 == null) goto L56;
        int r145 = r144.hashCode();
    L57:
        int r146 = (r143 + r145) * 31;
        boolean r147 = this.f151132x;
        if (r147 == true) goto L61;
        r117 = r147;
    L61:
        int r148 = (r146 + r117) * 31;
        String r149 = this.f151133y;
        if (r149 == null) goto L64;
        int r150 = r149.hashCode();
    L65:
        int r151 = (r148 + r150) * 31;
        String r152 = this.f151134z;
        if (r152 == null) goto L69;
        r101 = r152.hashCode();
    L69:
        return r151 + r101;
    L64:
        r150 = 0;
        goto L65
    L56:
        r145 = 0;
        goto L57
    L49:
        r139 = 0;
        goto L50
    L42:
        r133 = 0;
        goto L43
    L38:
        r130 = 0;
        goto L39
    L31:
        r124 = 0;
        goto L32
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
        return "LivePromotionListPageRequestParam(authorId=" + this.f151114f + ", secAuthorId=" + this.f151115g + ", roomId=" + this.f151116h + ", containerRoomId=" + this.f151117i + ", roomUniqueKey=" + this.f151118j + ", isLinkmic=" + this.f151119k + ", isDefaultTab=" + this.f151120l + ", liveListChannel=" + this.f151121m + ", autoApplyCoupon=" + this.f151122n + ", listApplyCoupon=" + this.f151123o + ", extraEntranceInfo=" + this.f151124p + ", monitorName=" + this.f151125q + ", closeOrderBanner=" + this.f151126r + ", relatedInfo=" + this.f151127s + ", recommendedProductDisplayed=" + this.f151128t + ", pageSize=" + this.f151129u + ", prefetchDistance=" + this.f151130v + ", anchorTabUniqueIndex=" + this.f151131w + ", isInSplit=" + this.f151132x + ", cartAnimRelatedInfo=" + this.f151133y + ", preferredCoupon=" + this.f151134z + ")";
    }

    public final String b() {
        return ECEventUtilsV2.c(ECEventUtilsV2.f147718b, "live_list_card", this.f151121m, this.f151124p);
    }

    public static c a(c r210) {
        String r100 = r210.f151114f;
        String r101 = r210.f151115g;
        String r102 = r210.f151116h;
        String r103 = r210.f151117i;
        String r104 = r210.f151118j;
        boolean r105 = r210.f151119k;
        boolean r106 = r210.f151120l;
        String r107 = r210.f151121m;
        boolean r108 = r210.f151122n;
        int r110 = r210.f151123o;
        String r111 = r210.f151124p;
        String r112 = r210.f151125q;
        boolean r113 = r210.f151126r;
        String r114 = r210.f151127s;
        boolean r115 = r210.f151128t;
        int r116 = r210.f151129u;
        int r117 = r210.f151130v;
        String r118 = r210.f151131w;
        boolean r119 = r210.f151132x;
        String r120 = r210.f151133y;
        String r121 = r210.f151134z;
        r210.getClass();
        Intrinsics.checkNotNullParameter(r100, "authorId");
        Intrinsics.checkNotNullParameter(r101, "secAuthorId");
        Intrinsics.checkNotNullParameter(r102, "roomId");
        Intrinsics.checkNotNullParameter(r103, "containerRoomId");
        Intrinsics.checkNotNullParameter(r104, "roomUniqueKey");
        return new c(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121);
    }

    public /* synthetic */ c(String r210, String r211, String r212, String r213, String r310, boolean r311, boolean r312, String r313, boolean r314, int r315, String r316, String r317, boolean r318, String r319, boolean r410, String r411, boolean r412, String r413, String r414, int r415) {
        if ((r415 & 1024) == 0) goto L5;
        String r110 = null;
    L7:
        if ((r415 & 2048) == 0) goto L9;
        String r111 = null;
    L11:
        if ((r415 & 8192) == 0) goto L13;
        String r112 = null;
    L15:
        if ((r415 & 16384) == 0) goto L17;
        boolean r113 = false;
    L19:
        if ((32768 & r415) == 0) goto L21;
        int r114 = EComABUtils.liveListLoadPageSize();
    L23:
        if ((65536 & r415) == 0) goto L25;
        int r214 = EComABUtils.liveListLoadPagePrefetchDistance();
    L27:
        if ((131072 & r415) == 0) goto L29;
        String r215 = null;
    L31:
        if ((262144 & r415) == 0) goto L33;
        boolean r216 = false;
    L35:
        if ((524288 & r415) == 0) goto L37;
        String r217 = null;
    L39:
        if ((r415 & 1048576) == 0) goto L41;
        String r218 = null;
    L42:
        this(r210, r211, r212, r213, r310, r311, r312, r313, r314, r315, r110, r111, r318, r112, r113, r114, r214, r215, r216, r217, r218);
        return;
    L41:
        r218 = r414;
        goto L42
    L37:
        r217 = r413;
        goto L39
    L33:
        r216 = r412;
        goto L35
    L29:
        r215 = r411;
        goto L31
    L25:
        r214 = 0;
        goto L27
    L21:
        r114 = 0;
        goto L23
    L17:
        r113 = r410;
        goto L19
    L13:
        r112 = r319;
        goto L15
    L9:
        r111 = r317;
        goto L11
    L5:
        r110 = r316;
        goto L7
    }

    public c(String r100, String r101, String r110, String r111, String r112, boolean r113, boolean r114, String r115, boolean r116, int r117, String r118, String r119, boolean r210, String r211, boolean r212, int r213, int r214, String r215, boolean r216, String r217, String r218) {
        Intrinsics.checkNotNullParameter(r100, "authorId");
        Intrinsics.checkNotNullParameter(r101, "secAuthorId");
        Intrinsics.checkNotNullParameter(r110, "roomId");
        Intrinsics.checkNotNullParameter(r111, "containerRoomId");
        Intrinsics.checkNotNullParameter(r112, "roomUniqueKey");
        this.f151114f = r100;
        this.f151115g = r101;
        this.f151116h = r110;
        this.f151117i = r111;
        this.f151118j = r112;
        this.f151119k = r113;
        this.f151120l = r114;
        this.f151121m = r115;
        this.f151122n = r116;
        this.f151123o = r117;
        this.f151124p = r118;
        this.f151125q = r119;
        this.f151126r = r210;
        this.f151127s = r211;
        this.f151128t = r212;
        this.f151129u = r213;
        this.f151130v = r214;
        this.f151131w = r215;
        this.f151132x = r216;
        this.f151133y = r217;
        this.f151134z = r218;
    }
}
