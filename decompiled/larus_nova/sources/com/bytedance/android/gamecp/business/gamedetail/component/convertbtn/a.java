package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.b1;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f53907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f53908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f53909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f53910d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f53911e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b1 f53912f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b1 f53913g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b1 f53914h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b1 f53915i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f53916j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f53917k;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L28;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f53907a, r101.f53907a) == true) goto L8;
        return false;
    L8:
        if (this.f53908b == r101.f53908b) goto L10;
        return false;
    L10:
        if (this.f53909c == r101.f53909c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f53910d, r101.f53910d) == true) goto L14;
        return false;
    L14:
        if (this.f53911e == r101.f53911e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f53912f, r101.f53912f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f53913g, r101.f53913g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f53914h, r101.f53914h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f53915i, r101.f53915i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f53916j, r101.f53916j) == true) goto L26;
        return false;
    L26:
        if (this.f53917k == r101.f53917k) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 48;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f53907a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f53908b;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        boolean r108 = this.f53909c;
        if (r108 == true) goto L13;
        r105 = r108;
    L13:
        int r109 = (r107 + r105) * 31;
        Long r110 = this.f53910d;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (((r109 + r111) * 31) + this.f53911e) * 31;
        b1 r113 = this.f53912f;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        b1 r116 = this.f53913g;
        if (r116 == null) goto L24;
        int r117 = r116.hashCode();
    L25:
        int r118 = (r115 + r117) * 31;
        b1 r119 = this.f53914h;
        if (r119 == null) goto L28;
        int r120 = r119.hashCode();
    L29:
        int r121 = (r118 + r120) * 31;
        b1 r122 = this.f53915i;
        if (r122 == null) goto L32;
        int r123 = r122.hashCode();
    L33:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f53916j;
        if (r125 == null) goto L37;
        r101 = r125.hashCode();
    L37:
        return ((r124 + r101) * 31) + this.f53917k;
    L32:
        r123 = 0;
        goto L33
    L28:
        r120 = 0;
        goto L29
    L24:
        r117 = 0;
        goto L25
    L20:
        r114 = 0;
        goto L21
    L16:
        r111 = 0;
        goto L17
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "NewReserveProps(ID=" + this.f53907a + ", hasDone=" + this.f53908b + ", showLoading=" + this.f53909c + ", supportPlatform=" + this.f53910d + ", reserveTheme=" + this.f53911e + ", reverseStyle=" + this.f53912f + ", unReverseStyle=" + this.f53913g + ", unSupportStyle=" + this.f53914h + ", gameOnlineStyle=" + this.f53915i + ", autoAction=" + this.f53916j + ", interactiveStyle=" + this.f53917k + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f53907a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public a(String r100, boolean r101, boolean r102, Long r103, int r104, b1 r105, b1 r106, b1 r107, b1 r110, String r111, int r112) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        this.f53907a = r100;
        this.f53908b = r101;
        this.f53909c = r102;
        this.f53910d = r103;
        this.f53911e = r104;
        this.f53912f = r105;
        this.f53913g = r106;
        this.f53914h = r107;
        this.f53915i = r110;
        this.f53916j = r111;
        this.f53917k = r112;
    }
}
