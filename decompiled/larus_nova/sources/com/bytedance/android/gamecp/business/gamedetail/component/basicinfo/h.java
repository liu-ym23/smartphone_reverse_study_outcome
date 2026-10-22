package com.bytedance.android.gamecp.business.gamedetail.component.basicinfo;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.host_api.model.GameImageBundler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class h implements com.bytedance.android.gamecp.base.gamedetail.d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f53719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f53720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f53721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final GameImageBundler f53722d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f53723e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f1.a f53724f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.gamecp.business.gamedetail.base.model.d f53725g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final g f53726h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f f53727i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.android.gamecp.business.gamedetail.base.model.v f53728j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.android.gamecp.business.gamedetail.base.model.q f53729k;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L28;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f53719a, r101.f53719a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f53720b, r101.f53720b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f53721c, r101.f53721c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f53722d, r101.f53722d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f53723e, r101.f53723e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f53724f, r101.f53724f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f53725g, r101.f53725g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f53726h, r101.f53726h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f53727i, r101.f53727i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f53728j, r101.f53728j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f53729k, r101.f53729k) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 57;
    }

    public final int hashCode() {
        String r100 = this.f53719a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f53720b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f53721c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        GameImageBundler r110 = this.f53722d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        i r113 = this.f53723e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        f1.a r116 = this.f53724f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        com.bytedance.android.gamecp.business.gamedetail.base.model.d r119 = this.f53725g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        g r122 = this.f53726h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        f r125 = this.f53727i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        com.bytedance.android.gamecp.business.gamedetail.base.model.v r128 = this.f53728j;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        com.bytedance.android.gamecp.business.gamedetail.base.model.q r131 = this.f53729k;
        if (r131 == null) goto L46;
        r101 = r131.hashCode();
    L46:
        return r130 + r101;
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
        return "AudienceGameDetailInfoV6Props(ID=" + this.f53719a + ", gameId=" + this.f53720b + ", name=" + this.f53721c + ", iconBundler=" + this.f53722d + ", tags=" + this.f53723e + ", commentInfo=" + this.f53724f + ", gameStatus=" + this.f53725g + ", fiveElement=" + this.f53726h + ", descriptions=" + this.f53727i + ", videoRankListEntrance=" + this.f53728j + ", gameRankEntranceInfo=" + this.f53729k + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f53719a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public h(String r100, String r101, String r102, GameImageBundler r103, i r104, f1.a r105, com.bytedance.android.gamecp.business.gamedetail.base.model.d r106, g r107, f r110, com.bytedance.android.gamecp.business.gamedetail.base.model.v r111, com.bytedance.android.gamecp.business.gamedetail.base.model.q r112) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        this.f53719a = r100;
        this.f53720b = r101;
        this.f53721c = r102;
        this.f53722d = r103;
        this.f53723e = r104;
        this.f53724f = r105;
        this.f53725g = r106;
        this.f53726h = r107;
        this.f53727i = r110;
        this.f53728j = r111;
        this.f53729k = r112;
    }
}
