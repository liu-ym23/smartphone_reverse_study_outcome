package com.bytedance.android.gamecp.business.gamedetail.component.titlebar.betaapply.signup;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f55158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f55159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f55160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f55161d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f55162e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f55163f;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L18;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f55158a, r101.f55158a) == true) goto L8;
        return false;
    L8:
        if (this.f55159b == r101.f55159b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f55160c, r101.f55160c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f55161d, r101.f55161d) == true) goto L14;
        return false;
    L14:
        if (this.f55162e == r101.f55162e) goto L16;
        return false;
    L16:
        if (this.f55163f == r101.f55163f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 38;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f55158a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f55159b;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        String r108 = this.f55160c;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f55161d;
        if (r111 == null) goto L16;
        r101 = r111.hashCode();
    L16:
        int r112 = (r110 + r101) * 31;
        boolean r113 = this.f55162e;
        ?? r114 = r113;
        if (r113 == false) goto L19;
        r114 = 1;
    L19:
        int r115 = (r112 + r114) * 31;
        boolean r116 = this.f55163f;
        if (r116 == true) goto L24;
        r105 = r116;
    L24:
        return r115 + r105;
    L12:
        r109 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TitleBetaApplySignUpButtonProps(ID=" + this.f55158a + ", isApplied=" + this.f55159b + ", applyUrl=" + this.f55160c + ", planId=" + this.f55161d + ", supportPlatform=" + this.f55162e + ", isLoading=" + this.f55163f + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f55158a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public a(String r100, boolean r101, String r102, String r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        Intrinsics.checkNotNullParameter(r102, "applyUrl");
        Intrinsics.checkNotNullParameter(r103, "planId");
        this.f55158a = r100;
        this.f55159b = r101;
        this.f55160c = r102;
        this.f55161d = r103;
        this.f55162e = r104;
        this.f55163f = false;
    }
}
