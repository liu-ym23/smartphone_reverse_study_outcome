package com.bytedance.android.gamecp.business.gamedetail.component.basicinfo;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.host_api.model.GameImageBundler;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements com.bytedance.android.gamecp.base.gamedetail.d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f53649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f53650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Float f53651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f53652d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f53653e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final GameImageBundler f53654f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f53655g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f53656h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Boolean f53657i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final f1.a f53658j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Boolean f53659k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f53660l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<com.bytedance.android.gamecp.business.gamedetail.component.orderbasicinfo.a.C0891a> f53661m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.f f53662n;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L34;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f53649a, r101.f53649a) == true) goto L8;
        return false;
    L8:
        if (this.f53650b == r101.f53650b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f53651c, r101.f53651c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f53652d, r101.f53652d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f53653e, r101.f53653e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f53654f, r101.f53654f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f53655g, r101.f53655g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f53656h, r101.f53656h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f53657i, r101.f53657i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f53658j, r101.f53658j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f53659k, r101.f53659k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f53660l, r101.f53660l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f53661m, r101.f53661m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f53662n, r101.f53662n) == true) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 34;
    }

    public final int hashCode() {
        String r100 = this.f53649a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f53650b) * 31;
        Float r104 = this.f53651c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f53652d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f53653e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        GameImageBundler r113 = this.f53654f;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        List<String> r116 = this.f53655g;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.f53656h;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.f53657i;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        f1.a r125 = this.f53658j;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.f53659k;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f53660l;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        List<com.bytedance.android.gamecp.business.gamedetail.component.orderbasicinfo.a.C0891a> r134 = this.f53661m;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.f r137 = this.f53662n;
        if (r137 == null) goto L54;
        r101 = r137.hashCode();
    L54:
        return r136 + r101;
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
        return "AudienceGameDetailInfoV3Props(ID=" + this.f53649a + ", style=" + this.f53650b + ", dialogSlideOffset=" + this.f53651c + ", name=" + this.f53652d + ", icon=" + this.f53653e + ", iconBundler=" + this.f53654f + ", tags=" + this.f53655g + ", showCommentSummary=" + this.f53656h + ", showSafeTag=" + this.f53657i + ", commentInfo=" + this.f53658j + ", hasMiniGame=" + this.f53659k + ", shortAdditionalDesc=" + this.f53660l + ", noticeList=" + this.f53661m + ", officialAccountInfo=" + this.f53662n + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f53649a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public b(String r100, int r101, Float r102, String r103, String r104, GameImageBundler r105, List<String> r106, Boolean r107, Boolean r110, f1.a r111, Boolean r112, String r113, List<com.bytedance.android.gamecp.business.gamedetail.component.orderbasicinfo.a.C0891a> r114, com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.f r115) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        this.f53649a = r100;
        this.f53650b = r101;
        this.f53651c = r102;
        this.f53652d = r103;
        this.f53653e = r104;
        this.f53654f = r105;
        this.f53655g = r106;
        this.f53656h = r107;
        this.f53657i = r110;
        this.f53658j = r111;
        this.f53659k = r112;
        this.f53660l = r113;
        this.f53661m = r114;
        this.f53662n = r115;
    }
}
