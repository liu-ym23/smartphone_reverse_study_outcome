package com.bytedance.android.shopping.orderlist.list.viewmodel;

import androidx.compose.ui.spatial.RectListKt;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.j0;
import com.bytedance.android.shopping.orderlist.list.slice.elements.tab.g;
import com.bytedance.android.shopping.orderlist.list.starter.OrderListParams;
import com.bytedance.kmp.ec.yata.common.init.PackYataSdkConfig;
import com.bytedance.kmp.ec.yata.common.init.b;
import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ti.j;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f180386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f180387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f180388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f180389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f180390e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f180391f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public OrderListParams f180392g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g f180393h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f180394i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f180395j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f180396k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f180397l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Integer f180398m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<Integer> f180399n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public j0 f180400o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f180401p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f180402q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f180403r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f180404s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f180405t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public e f180406u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f180407v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Map<String, j> f180408w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f180409x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f180410y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f180411z;

    public a() {
        this(null, null, null, null, null, null, RectListKt.Lower26Bits);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L58;
        a r101 = (a) r100;
        if (this.f180386a == r101.f180386a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f180387b, r101.f180387b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f180388c, r101.f180388c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f180389d, r101.f180389d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f180390e, r101.f180390e) == true) goto L16;
        return false;
    L16:
        if (this.f180391f == r101.f180391f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f180392g, r101.f180392g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f180393h, r101.f180393h) == true) goto L22;
        return false;
    L22:
        if (this.f180394i == r101.f180394i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f180395j, r101.f180395j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f180396k, r101.f180396k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f180397l, r101.f180397l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f180398m, r101.f180398m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f180399n, r101.f180399n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f180400o, r101.f180400o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f180401p, r101.f180401p) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.f180402q, r101.f180402q) == true) goto L40;
        return false;
    L40:
        if (this.f180403r == r101.f180403r) goto L42;
        return false;
    L42:
        if (this.f180404s == r101.f180404s) goto L44;
        return false;
    L44:
        if (this.f180405t == r101.f180405t) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.f180406u, r101.f180406u) == true) goto L48;
        return false;
    L48:
        if (this.f180407v == r101.f180407v) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.f180408w, r101.f180408w) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.f180409x, r101.f180409x) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f180410y, r101.f180410y) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.f180411z, r101.f180411z) == true) goto L88;
        return false;
    L88:
        return true;
    L58:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v52 */
    /* JADX WARN: Type inference failed for: r0v53 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v21, types: [int] */
    /* JADX WARN: Type inference failed for: r2v47, types: [int] */
    /* JADX WARN: Type inference failed for: r2v49, types: [int] */
    /* JADX WARN: Type inference failed for: r2v51, types: [int] */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r2v58 */
    /* JADX WARN: Type inference failed for: r2v59 */
    /* JADX WARN: Type inference failed for: r2v68 */
    /* JADX WARN: Type inference failed for: r2v71 */
    /* JADX WARN: Type inference failed for: r2v76 */
    /* JADX WARN: Type inference failed for: r2v77 */
    /* JADX WARN: Type inference failed for: r2v78 */
    /* JADX WARN: Type inference failed for: r2v79 */
    /* JADX WARN: Type inference failed for: r2v80 */
    public final int hashCode() {
        boolean r100 = this.f180386a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        String r104 = this.f180387b;
        int r105 = 0;
        if (r104 == null) goto L8;
        int r106 = r104.hashCode();
    L9:
        int r107 = (r103 + r106) * 31;
        Boolean r108 = this.f180388c;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        Boolean r111 = this.f180389d;
        if (r111 == null) goto L16;
        int r112 = r111.hashCode();
    L17:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f180390e;
        if (r114 == null) goto L20;
        int r115 = r114.hashCode();
    L21:
        int r116 = (r113 + r115) * 31;
        boolean r117 = this.f180391f;
        ?? r118 = r117;
        if (r117 == false) goto L24;
        r118 = 1;
    L24:
        int r119 = (r116 + r118) * 31;
        OrderListParams r120 = this.f180392g;
        if (r120 == null) goto L27;
        int r121 = r120.hashCode();
    L28:
        int r122 = (r119 + r121) * 31;
        g r123 = this.f180393h;
        if (r123 == null) goto L31;
        int r124 = r123.hashCode();
    L32:
        int r125 = (r122 + r124) * 31;
        boolean r126 = this.f180394i;
        ?? r127 = r126;
        if (r126 == false) goto L35;
        r127 = 1;
    L35:
        int r128 = (r125 + r127) * 31;
        String r129 = this.f180395j;
        if (r129 == null) goto L38;
        int r130 = r129.hashCode();
    L39:
        int r131 = (r128 + r130) * 31;
        Integer r132 = this.f180396k;
        if (r132 == null) goto L42;
        int r133 = r132.hashCode();
    L43:
        int r134 = (r131 + r133) * 31;
        Integer r135 = this.f180397l;
        if (r135 == null) goto L46;
        int r136 = r135.hashCode();
    L47:
        int r137 = (r134 + r136) * 31;
        Integer r138 = this.f180398m;
        if (r138 == null) goto L50;
        int r139 = r138.hashCode();
    L51:
        int r140 = (r137 + r139) * 31;
        List<Integer> r141 = this.f180399n;
        if (r141 == null) goto L54;
        int r142 = r141.hashCode();
    L55:
        int r143 = (r140 + r142) * 31;
        j0 r144 = this.f180400o;
        if (r144 == null) goto L58;
        int r145 = r144.hashCode();
    L59:
        int r146 = (r143 + r145) * 31;
        String r147 = this.f180401p;
        if (r147 == null) goto L62;
        int r148 = r147.hashCode();
    L63:
        int r149 = (r146 + r148) * 31;
        String r150 = this.f180402q;
        if (r150 == null) goto L66;
        int r151 = r150.hashCode();
    L67:
        int r152 = (r149 + r151) * 31;
        boolean r153 = this.f180403r;
        ?? r154 = r153;
        if (r153 == false) goto L70;
        r154 = 1;
    L70:
        int r155 = (r152 + r154) * 31;
        boolean r156 = this.f180404s;
        ?? r157 = r156;
        if (r156 == false) goto L73;
        r157 = 1;
    L73:
        int r158 = (r155 + r157) * 31;
        boolean r159 = this.f180405t;
        ?? r160 = r159;
        if (r159 == false) goto L76;
        r160 = 1;
    L76:
        int r161 = (r158 + r160) * 31;
        e r162 = this.f180406u;
        if (r162 == null) goto L79;
        int r163 = r162.hashCode();
    L80:
        int r164 = (r161 + r163) * 31;
        boolean r165 = this.f180407v;
        if (r165 == true) goto L84;
        r101 = r165;
    L84:
        int r166 = (r164 + r101) * 31;
        Map<String, j> r167 = this.f180408w;
        if (r167 == null) goto L87;
        int r168 = r167.hashCode();
    L88:
        int r169 = (r166 + r168) * 31;
        String r170 = this.f180409x;
        if (r170 == null) goto L91;
        int r171 = r170.hashCode();
    L92:
        int r172 = (r169 + r171) * 31;
        String r173 = this.f180410y;
        if (r173 == null) goto L95;
        int r174 = r173.hashCode();
    L96:
        int r175 = (r172 + r174) * 31;
        String r176 = this.f180411z;
        if (r176 == null) goto L100;
        r105 = r176.hashCode();
    L100:
        return r175 + r105;
    L95:
        r174 = 0;
        goto L96
    L91:
        r171 = 0;
        goto L92
    L87:
        r168 = 0;
        goto L88
    L79:
        r163 = 0;
        goto L80
    L66:
        r151 = 0;
        goto L67
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
    L31:
        r124 = 0;
        goto L32
    L27:
        r121 = 0;
        goto L28
    L20:
        r115 = 0;
        goto L21
    L16:
        r112 = 0;
        goto L17
    L12:
        r109 = 0;
        goto L13
    L8:
        r106 = 0;
        goto L9
    }

    public final String toString() {
        return "OrderListStaticState(isActivityReload=" + this.f180386a + ", sessionId=" + this.f180387b + ", isInApplet=" + this.f180388c + ", isInFirstAppletPage=" + this.f180389d + ", logId=" + this.f180390e + ", isHasNewerCoupon=" + this.f180391f + ", orderListParams=" + this.f180392g + ", selectedTabInfo=" + this.f180393h + ", hasCurrentTabParams=" + this.f180394i + ", tabMode=" + this.f180395j + ", currentBizTabId=" + this.f180396k + ", currentTabId=" + this.f180397l + ", currentSubTabId=" + this.f180398m + ", tabIdList=" + this.f180399n + ", queryCacheInfo=" + this.f180400o + ", btm=" + this.f180401p + ", appTheme=" + this.f180402q + ", hasSkinInfo=" + this.f180403r + ", isChunkRequest=" + this.f180404s + ", isChunkOngoing=" + this.f180405t + ", secondChunkResponse=" + this.f180406u + ", hasSecondChunkLoaded=" + this.f180407v + ", selfRegisterJsSubscriber=" + this.f180408w + ", sliceVersion=" + this.f180409x + ", geckoVersion=" + this.f180410y + ", yataVersion=" + this.f180411z + ")";
    }

    public final Map<String, Object> a() {
        LinkedHashMap r100 = new LinkedHashMap();
        Comparable r101 = this.f180396k;
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.put("biz_tab_id", r101);
        Integer r103 = this.f180397l;
        if (r103 == null) goto L8;
        int r104 = r103.intValue();
    L9:
        r100.put("tab_id", Integer.valueOf(r104));
        Comparable r105 = this.f180398m;
        if (r105 != null) goto L12;
        r105 = "";
    L12:
        r100.put("sub_tab_id", r105);
        String r106 = this.f180395j;
        if (r106 == null) goto L16;
        r102 = r106;
    L16:
        r100.put("tab_mode", r102);
        return r100;
    L8:
        r104 = 0;
        goto L9
    }

    public a(String r100, OrderListParams r101, String r102, Integer r103, Integer r104, String r110, int r111) {
        if ((r111 & 2) == 0) goto L6;
        r100 = null;
    L6:
        if ((r111 & 64) == 0) goto L9;
        r101 = null;
    L9:
        if ((r111 & 512) == 0) goto L12;
        r102 = null;
    L12:
        if ((r111 & 1024) == 0) goto L15;
        r103 = null;
    L15:
        if ((r111 & 2048) == 0) goto L18;
        r104 = null;
    L18:
        if ((r111 & 8192) == 0) goto L20;
        List<Integer> r105 = CollectionsKt.emptyList();
    L22:
        if ((32768 & r111) == 0) goto L25;
        r110 = null;
    L25:
        if ((4194304 & r111) == 0) goto L27;
        LinkedHashMap r106 = new LinkedHashMap();
    L29:
        if ((r111 & 33554432) == 0) goto L31;
        PackYataSdkConfig r112 = b.f251424a;
        String r113 = "1.23.7";
    L32:
        Intrinsics.checkNotNullParameter(r105, "tabIdList");
        Intrinsics.checkNotNullParameter(r106, "selfRegisterJsSubscriber");
        this.f180386a = false;
        this.f180387b = r100;
        this.f180388c = null;
        this.f180389d = null;
        this.f180390e = null;
        this.f180391f = false;
        this.f180392g = r101;
        this.f180393h = null;
        this.f180394i = false;
        this.f180395j = r102;
        this.f180396k = r103;
        this.f180397l = r104;
        this.f180398m = null;
        this.f180399n = r105;
        this.f180400o = null;
        this.f180401p = r110;
        this.f180402q = null;
        this.f180403r = false;
        this.f180404s = false;
        this.f180405t = false;
        this.f180406u = null;
        this.f180407v = false;
        this.f180408w = r106;
        this.f180409x = null;
        this.f180410y = null;
        this.f180411z = r113;
        return;
    L31:
        r113 = null;
        goto L32
    L27:
        r106 = null;
        goto L29
    L20:
        r105 = null;
        goto L22
    }
}
