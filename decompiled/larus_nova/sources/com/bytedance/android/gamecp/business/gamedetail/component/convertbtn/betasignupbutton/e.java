package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betasignupbutton;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.base.gamedetail.s0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f54109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f54110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f54111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f54112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f54113e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f54114f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f54115g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final s0 f54116h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final s0 f54117i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final s0 f54118j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f54119k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f54120l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f54121m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f54122n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f54123o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f54124p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final JSONArray f54125q;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L40;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f54109a, r101.f54109a) == true) goto L8;
        return false;
    L8:
        if (this.f54110b == r101.f54110b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f54111c, r101.f54111c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f54112d, r101.f54112d) == true) goto L14;
        return false;
    L14:
        if (this.f54113e == r101.f54113e) goto L16;
        return false;
    L16:
        if (this.f54114f == r101.f54114f) goto L18;
        return false;
    L18:
        if (this.f54115g == r101.f54115g) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f54116h, r101.f54116h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f54117i, r101.f54117i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f54118j, r101.f54118j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f54119k, r101.f54119k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f54120l, r101.f54120l) == true) goto L30;
        return false;
    L30:
        if (this.f54121m == r101.f54121m) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f54122n, r101.f54122n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f54123o, r101.f54123o) == true) goto L36;
        return false;
    L36:
        if (this.f54124p == r101.f54124p) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.f54125q, r101.f54125q) == true) goto L61;
        return false;
    L61:
        return true;
    L40:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 50;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f54109a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f54110b;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        String r108 = this.f54111c;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f54112d;
        if (r111 == null) goto L16;
        int r112 = r111.hashCode();
    L17:
        long r113 = this.f54113e;
        int r114 = (((r110 + r112) * 31) + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        boolean r115 = this.f54114f;
        ?? r116 = r115;
        if (r115 == false) goto L20;
        r116 = 1;
    L20:
        int r117 = (r114 + r116) * 31;
        boolean r118 = this.f54115g;
        if (r118 == true) goto L24;
        r105 = r118;
    L24:
        int r119 = (r117 + r105) * 31;
        s0 r120 = this.f54116h;
        if (r120 == null) goto L27;
        int r121 = r120.hashCode();
    L28:
        int r122 = (r119 + r121) * 31;
        s0 r123 = this.f54117i;
        if (r123 == null) goto L31;
        int r124 = r123.hashCode();
    L32:
        int r125 = (r122 + r124) * 31;
        s0 r126 = this.f54118j;
        if (r126 == null) goto L35;
        int r127 = r126.hashCode();
    L36:
        int r128 = (r125 + r127) * 31;
        String r129 = this.f54119k;
        if (r129 == null) goto L39;
        int r130 = r129.hashCode();
    L40:
        int r131 = (r128 + r130) * 31;
        String r132 = this.f54120l;
        if (r132 == null) goto L43;
        int r133 = r132.hashCode();
    L44:
        int r134 = (((r131 + r133) * 31) + this.f54121m) * 31;
        String r135 = this.f54122n;
        if (r135 == null) goto L47;
        int r136 = r135.hashCode();
    L48:
        int r137 = (r134 + r136) * 31;
        String r138 = this.f54123o;
        if (r138 == null) goto L51;
        int r139 = r138.hashCode();
    L52:
        int r140 = (((r137 + r139) * 31) + this.f54124p) * 31;
        JSONArray r141 = this.f54125q;
        if (r141 == null) goto L56;
        r101 = r141.hashCode();
    L56:
        return r140 + r101;
    L51:
        r139 = 0;
        goto L52
    L47:
        r136 = 0;
        goto L48
    L43:
        r133 = 0;
        goto L44
    L39:
        r130 = 0;
        goto L40
    L35:
        r127 = 0;
        goto L36
    L31:
        r124 = 0;
        goto L32
    L27:
        r121 = 0;
        goto L28
    L16:
        r112 = 0;
        goto L17
    L12:
        r109 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "NewBetaSignUpProps(ID=" + this.f54109a + ", isApplied=" + this.f54110b + ", applyUrl=" + this.f54111c + ", planId=" + this.f54112d + ", supportPlatform=" + this.f54113e + ", isSupportAndroid=" + this.f54114f + ", isLoading=" + this.f54115g + ", applyStyle=" + this.f54116h + ", notApplyStyle=" + this.f54117i + ", unSupportStyle=" + this.f54118j + ", successToastForNative=" + this.f54119k + ", signResultForLynx=" + this.f54120l + ", reservedStatus=" + this.f54121m + ", applySuccessSchema=" + this.f54122n + ", autoAction=" + this.f54123o + ", gameStage=" + this.f54124p + ", originSupportPlatform=" + this.f54125q + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f54109a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public e(String r100, boolean r110, String r111, String r112, long r113, boolean r114, boolean r115, s0 r116, s0 r117, s0 r118, String r210, String r211, int r212, String r213, String r214, int r215, JSONArray r216) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        Intrinsics.checkNotNullParameter(r111, "applyUrl");
        Intrinsics.checkNotNullParameter(r112, "planId");
        Intrinsics.checkNotNullParameter(r116, "applyStyle");
        Intrinsics.checkNotNullParameter(r117, "notApplyStyle");
        Intrinsics.checkNotNullParameter(r118, "unSupportStyle");
        this.f54109a = r100;
        this.f54110b = r110;
        this.f54111c = r111;
        this.f54112d = r112;
        this.f54113e = r113;
        this.f54114f = r114;
        this.f54115g = r115;
        this.f54116h = r116;
        this.f54117i = r117;
        this.f54118j = r118;
        this.f54119k = r210;
        this.f54120l = r211;
        this.f54121m = r212;
        this.f54122n = r213;
        this.f54123o = r214;
        this.f54124p = r215;
        this.f54125q = r216;
    }
}
