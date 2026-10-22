package com.bytedance.android.gamecp.business.gamedetail.component.lynx;

import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class g implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f54499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f54500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f54501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f54502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f54503e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f54504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f54505g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f54506h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f54507i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f54508j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f54509k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f54510l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f54511m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e f54512n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f54513o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final d f54514p;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L38;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f54499a, r101.f54499a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f54500b, r101.f54500b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f54501c, r101.f54501c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f54502d, r101.f54502d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f54503e, r101.f54503e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f54504f, r101.f54504f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f54505g, r101.f54505g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f54506h, r101.f54506h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f54507i, r101.f54507i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f54508j, r101.f54508j) == true) goto L26;
        return false;
    L26:
        if (this.f54509k == r101.f54509k) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f54510l, r101.f54510l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f54511m, r101.f54511m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f54512n, r101.f54512n) == true) goto L34;
        return false;
    L34:
        if (this.f54513o == r101.f54513o) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f54514p, r101.f54514p) == true) goto L58;
        return false;
    L58:
        return true;
    L38:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v30, types: [int] */
    /* JADX WARN: Type inference failed for: r2v38, types: [int] */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v53 */
    public final int hashCode() {
        String r100 = this.f54499a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f54500b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f54501c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f54502d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f54503e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f54504f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f54505g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f54506h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f54507i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f54508j;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (((r127 + r129) * 31) + this.f54509k) * 31;
        String r131 = this.f54510l;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.f54511m;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        e r137 = this.f54512n;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        boolean r140 = this.f54513o;
        ?? r141 = r140;
        if (r140 == false) goto L57;
        r141 = 1;
    L57:
        int r142 = (r139 + r141) * 31;
        d r143 = this.f54514p;
        if (r143 == null) goto L61;
        r101 = r143.hashCode();
    L61:
        return r142 + r101;
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
        return "GameDetailLynxProps(ID=" + this.f54499a + ", componentId=" + this.f54500b + ", schema=" + this.f54501c + ", lynxData=" + this.f54502d + ", commonData=" + this.f54503e + ", promoterId=" + this.f54504f + ", gameId=" + this.f54505g + ", gameName=" + this.f54506h + ", enterFrom=" + this.f54507i + ", reportParams=" + this.f54508j + ", scene=" + this.f54509k + ", roomId=" + this.f54510l + ", videoId=" + this.f54511m + ", layoutStyle=" + this.f54512n + ", isCacheData=" + this.f54513o + ", bottomPaddingStyle=" + this.f54514p + ")";
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        if (TextUtils.isEmpty(this.f54500b) == false) goto L6;
        return 1;
    L6:
        return d0.a.getType(this);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return this.f54500b;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f54500b;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public g(String r100, String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r118, int r119, String r210, String r211, e r212, boolean r213, d r214) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        Intrinsics.checkNotNullParameter(r110, "componentId");
        Intrinsics.checkNotNullParameter(r111, "schema");
        Intrinsics.checkNotNullParameter(r112, "lynxData");
        Intrinsics.checkNotNullParameter(r113, "commonData");
        Intrinsics.checkNotNullParameter(r212, "layoutStyle");
        this.f54499a = r100;
        this.f54500b = r110;
        this.f54501c = r111;
        this.f54502d = r112;
        this.f54503e = r113;
        this.f54504f = r114;
        this.f54505g = r115;
        this.f54506h = r116;
        this.f54507i = r117;
        this.f54508j = r118;
        this.f54509k = r119;
        this.f54510l = r210;
        this.f54511m = r211;
        this.f54512n = r212;
        this.f54513o = r213;
        this.f54514p = r214;
    }
}
