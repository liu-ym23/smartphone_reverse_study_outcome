package com.bytedance.android.gamecp.business.gamedetail.component.basicinfo;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.host_api.model.GameImageBundler;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements com.bytedance.android.gamecp.base.gamedetail.d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f53664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f53665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Float f53666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f53667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f53668e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final GameImageBundler f53669f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f53670g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f53671h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Boolean f53672i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final f1.a f53673j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Boolean f53674k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f53675l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<String> f53676m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<com.bytedance.android.gamecp.business.gamedetail.component.orderbasicinfo.a.C0891a> f53677n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.f f53678o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.bytedance.android.gamecp.business.gamedetail.base.model.d f53679p;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L38;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f53664a, r101.f53664a) == true) goto L8;
        return false;
    L8:
        if (this.f53665b == r101.f53665b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f53666c, r101.f53666c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f53667d, r101.f53667d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f53668e, r101.f53668e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f53669f, r101.f53669f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f53670g, r101.f53670g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f53671h, r101.f53671h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f53672i, r101.f53672i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f53673j, r101.f53673j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f53674k, r101.f53674k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f53675l, r101.f53675l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f53676m, r101.f53676m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f53677n, r101.f53677n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f53678o, r101.f53678o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f53679p, r101.f53679p) == true) goto L58;
        return false;
    L58:
        return true;
    L38:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 41;
    }

    public final int hashCode() {
        String r100 = this.f53664a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f53665b) * 31;
        Float r104 = this.f53666c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f53667d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f53668e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        GameImageBundler r113 = this.f53669f;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        List<String> r116 = this.f53670g;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.f53671h;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.f53672i;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        f1.a r125 = this.f53673j;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.f53674k;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f53675l;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        List<String> r134 = this.f53676m;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        List<com.bytedance.android.gamecp.business.gamedetail.component.orderbasicinfo.a.C0891a> r137 = this.f53677n;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.f r140 = this.f53678o;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        com.bytedance.android.gamecp.business.gamedetail.base.model.d r143 = this.f53679p;
        if (r143 == null) goto L62;
        r101 = r143.hashCode();
    L62:
        return r142 + r101;
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
        return "AudienceGameDetailInfoV4Props(ID=" + this.f53664a + ", style=" + this.f53665b + ", dialogSlideOffset=" + this.f53666c + ", name=" + this.f53667d + ", icon=" + this.f53668e + ", iconBundler=" + this.f53669f + ", tags=" + this.f53670g + ", showCommentSummary=" + this.f53671h + ", showSafeTag=" + this.f53672i + ", commentInfo=" + this.f53673j + ", hasMiniGame=" + this.f53674k + ", shortAdditionalDesc=" + this.f53675l + ", additionalDescList=" + this.f53676m + ", noticeList=" + this.f53677n + ", officialAccountInfo=" + this.f53678o + ", gameStatus=" + this.f53679p + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f53664a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public c(String r100, int r101, Float r102, String r103, String r104, GameImageBundler r105, List<String> r110, Boolean r111, Boolean r112, f1.a r113, Boolean r114, String r115, List<String> r116, List<com.bytedance.android.gamecp.business.gamedetail.component.orderbasicinfo.a.C0891a> r117, com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.f r118, com.bytedance.android.gamecp.business.gamedetail.base.model.d r119) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        this.f53664a = r100;
        this.f53665b = r101;
        this.f53666c = r102;
        this.f53667d = r103;
        this.f53668e = r104;
        this.f53669f = r105;
        this.f53670g = r110;
        this.f53671h = r111;
        this.f53672i = r112;
        this.f53673j = r113;
        this.f53674k = r114;
        this.f53675l = r115;
        this.f53676m = r116;
        this.f53677n = r117;
        this.f53678o = r118;
        this.f53679p = r119;
    }
}
