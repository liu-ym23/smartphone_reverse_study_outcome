package com.bytedance.android.gamecp.business.gamedetail.component.basicinfo;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.host_api.model.GameImageBundler;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements com.bytedance.android.gamecp.base.gamedetail.d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f53689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f53690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f53691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final GameImageBundler f53692d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f53693e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f1.a f53694f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f53695g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f53696h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.gamecp.business.gamedetail.base.model.d f53697i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d f53698j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<f1.b> f53699k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.android.gamecp.business.gamedetail.base.model.o f53700l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<com.bytedance.android.gamecp.business.gamedetail.base.model.a> f53701m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.android.gamecp.business.gamedetail.base.model.v f53702n;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L34;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f53689a, r101.f53689a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f53690b, r101.f53690b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f53691c, r101.f53691c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f53692d, r101.f53692d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f53693e, r101.f53693e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f53694f, r101.f53694f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f53695g, r101.f53695g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f53696h, r101.f53696h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f53697i, r101.f53697i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f53698j, r101.f53698j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f53699k, r101.f53699k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f53700l, r101.f53700l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f53701m, r101.f53701m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f53702n, r101.f53702n) == true) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 56;
    }

    public final int hashCode() {
        String r100 = this.f53689a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f53690b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f53691c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        GameImageBundler r110 = this.f53692d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<String> r113 = this.f53693e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        f1.a r116 = this.f53694f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f53695g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        List<String> r122 = this.f53696h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        com.bytedance.android.gamecp.business.gamedetail.base.model.d r125 = this.f53697i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        d r128 = this.f53698j;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        List<f1.b> r131 = this.f53699k;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        com.bytedance.android.gamecp.business.gamedetail.base.model.o r134 = this.f53700l;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        List<com.bytedance.android.gamecp.business.gamedetail.base.model.a> r137 = this.f53701m;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        com.bytedance.android.gamecp.business.gamedetail.base.model.v r140 = this.f53702n;
        if (r140 == null) goto L58;
        r101 = r140.hashCode();
    L58:
        return r139 + r101;
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
        return "AudienceGameDetailInfoV5Props(ID=" + this.f53689a + ", gameId=" + this.f53690b + ", name=" + this.f53691c + ", iconBundler=" + this.f53692d + ", tags=" + this.f53693e + ", commentInfo=" + this.f53694f + ", shortAdditionalDesc=" + this.f53695g + ", additionalDescList=" + this.f53696h + ", gameStatus=" + this.f53697i + ", fiveElement=" + this.f53698j + ", pcConfigsInfo=" + this.f53699k + ", officialSamePackageTips=" + this.f53700l + ", additionalDescriptionList=" + this.f53701m + ", videoRankListEntrance=" + this.f53702n + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f53689a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public e(String r100, String r101, String r102, GameImageBundler r103, List<String> r104, f1.a r105, String r106, List<String> r107, com.bytedance.android.gamecp.business.gamedetail.base.model.d r110, d r111, List<f1.b> r112, com.bytedance.android.gamecp.business.gamedetail.base.model.o r113, List<com.bytedance.android.gamecp.business.gamedetail.base.model.a> r114, com.bytedance.android.gamecp.business.gamedetail.base.model.v r115) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        this.f53689a = r100;
        this.f53690b = r101;
        this.f53691c = r102;
        this.f53692d = r103;
        this.f53693e = r104;
        this.f53694f = r105;
        this.f53695g = r106;
        this.f53696h = r107;
        this.f53697i = r110;
        this.f53698j = r111;
        this.f53699k = r112;
        this.f53700l = r113;
        this.f53701m = r114;
        this.f53702n = r115;
    }
}
