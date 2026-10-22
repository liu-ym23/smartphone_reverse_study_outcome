package com.bytedance.android.gamecp.business.gamedetail.component.betaapply.download;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f53776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f53777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f53778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f53779d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f53780e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f53781f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f53782g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f53783h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Float f53784i;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L24;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f53776a, r101.f53776a) == true) goto L8;
        return false;
    L8:
        if (this.f53777b == r101.f53777b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f53778c, r101.f53778c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f53779d, r101.f53779d) == true) goto L14;
        return false;
    L14:
        if (this.f53780e == r101.f53780e) goto L16;
        return false;
    L16:
        if (this.f53781f == r101.f53781f) goto L18;
        return false;
    L18:
        if (this.f53782g == r101.f53782g) goto L20;
        return false;
    L20:
        if (this.f53783h == r101.f53783h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f53784i, r101.f53784i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 39;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f53776a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f53777b;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        String r108 = this.f53778c;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f53779d;
        if (r111 == null) goto L16;
        int r112 = r111.hashCode();
    L17:
        int r113 = (r110 + r112) * 31;
        boolean r114 = this.f53780e;
        ?? r115 = r114;
        if (r114 == false) goto L20;
        r115 = 1;
    L20:
        int r116 = (((r113 + r115) * 31) + this.f53781f) * 31;
        boolean r117 = this.f53782g;
        ?? r118 = r117;
        if (r117 == false) goto L23;
        r118 = 1;
    L23:
        int r119 = (r116 + r118) * 31;
        boolean r120 = this.f53783h;
        if (r120 == true) goto L27;
        r105 = r120;
    L27:
        int r121 = (r119 + r105) * 31;
        Float r122 = this.f53784i;
        if (r122 == null) goto L31;
        r101 = r122.hashCode();
    L31:
        return r121 + r101;
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
        return "BetaApplyDownloadButtonItemProps(ID=" + this.f53776a + ", isQualified=" + this.f53777b + ", openScheme=" + this.f53778c + ", planId=" + this.f53779d + ", supportPlatform=" + this.f53780e + ", convertButtonTheme=" + this.f53781f + ", autoDownload=" + this.f53782g + ", autoOpen=" + this.f53783h + ", dialogSlideOffset=" + this.f53784i + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f53776a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public a(String r100, boolean r101, String r102, String r103, boolean r104, int r105, boolean r106, boolean r107, Float r110) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        Intrinsics.checkNotNullParameter(r102, "openScheme");
        Intrinsics.checkNotNullParameter(r103, "planId");
        this.f53776a = r100;
        this.f53777b = r101;
        this.f53778c = r102;
        this.f53779d = r103;
        this.f53780e = r104;
        this.f53781f = r105;
        this.f53782g = r106;
        this.f53783h = r107;
        this.f53784i = r110;
    }
}
