package com.bytedance.android.gamecp.business.gamedetail.component.betaapply.signup;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f53807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f53808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f53809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f53810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f53811e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f53812f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f53813g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Float f53814h;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L22;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f53807a, r101.f53807a) == true) goto L8;
        return false;
    L8:
        if (this.f53808b == r101.f53808b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f53809c, r101.f53809c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f53810d, r101.f53810d) == true) goto L14;
        return false;
    L14:
        if (this.f53811e == r101.f53811e) goto L16;
        return false;
    L16:
        if (this.f53812f == r101.f53812f) goto L18;
        return false;
    L18:
        if (this.f53813g == r101.f53813g) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f53814h, r101.f53814h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 37;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f53807a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f53808b;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        String r108 = this.f53809c;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f53810d;
        if (r111 == null) goto L16;
        int r112 = r111.hashCode();
    L17:
        int r113 = (r110 + r112) * 31;
        boolean r114 = this.f53811e;
        ?? r115 = r114;
        if (r114 == false) goto L20;
        r115 = 1;
    L20:
        int r116 = (((r113 + r115) * 31) + this.f53812f) * 31;
        boolean r117 = this.f53813g;
        if (r117 == true) goto L24;
        r105 = r117;
    L24:
        int r118 = (r116 + r105) * 31;
        Float r119 = this.f53814h;
        if (r119 == null) goto L28;
        r101 = r119.hashCode();
    L28:
        return r118 + r101;
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
        return "BetaApplySignUpButtonItemProps(ID=" + this.f53807a + ", isApplied=" + this.f53808b + ", applyUrl=" + this.f53809c + ", planId=" + this.f53810d + ", supportPlatform=" + this.f53811e + ", convertButtonTheme=" + this.f53812f + ", isLoading=" + this.f53813g + ", dialogSlideOffset=" + this.f53814h + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f53807a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public static d c(d r110, boolean r111, Float r112, int r113) {
        String r100 = null;
        if ((r113 & 1) == 0) goto L5;
        String r101 = r110.f53807a;
    L7:
        if ((r113 & 2) == 0) goto L9;
        r111 = r110.f53808b;
    L9:
        boolean r102 = r111;
        if ((r113 & 4) == 0) goto L12;
        String r103 = r110.f53809c;
    L14:
        if ((r113 & 8) == 0) goto L16;
        r100 = r110.f53810d;
    L16:
        String r104 = r100;
        if ((r113 & 16) == 0) goto L19;
        boolean r105 = r110.f53811e;
    L21:
        if ((r113 & 32) == 0) goto L23;
        int r106 = r110.f53812f;
    L25:
        if ((r113 & 64) == 0) goto L27;
        boolean r107 = r110.f53813g;
    L29:
        if ((r113 & 128) == 0) goto L31;
        r112 = r110.f53814h;
    L31:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "ID");
        Intrinsics.checkNotNullParameter(r103, "applyUrl");
        Intrinsics.checkNotNullParameter(r104, "planId");
        return new d(r101, r102, r103, r104, r105, r106, r107, r112);
    L27:
        r107 = false;
        goto L29
    L23:
        r106 = 0;
        goto L25
    L19:
        r105 = false;
        goto L21
    L12:
        r103 = null;
        goto L14
    L5:
        r101 = null;
        goto L7
    }

    public d(String r100, boolean r101, String r102, String r103, boolean r104, int r105, boolean r106, Float r107) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        Intrinsics.checkNotNullParameter(r102, "applyUrl");
        Intrinsics.checkNotNullParameter(r103, "planId");
        this.f53807a = r100;
        this.f53808b = r101;
        this.f53809c = r102;
        this.f53810d = r103;
        this.f53811e = r104;
        this.f53812f = r105;
        this.f53813g = r106;
        this.f53814h = r107;
    }
}
