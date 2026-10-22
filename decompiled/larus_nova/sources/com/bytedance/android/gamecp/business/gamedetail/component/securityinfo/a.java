package com.bytedance.android.gamecp.business.gamedetail.component.securityinfo;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.business.gamedetail.base.model.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f55028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f55029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f55030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f55031d;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f55028a, r101.f55028a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f55029b, r101.f55029b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f55030c, r101.f55030c) == true) goto L12;
        return false;
    L12:
        if (this.f55031d == r101.f55031d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 12;
    }

    public final int hashCode() {
        String r100 = this.f55028a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        h r104 = this.f55029b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        d r107 = this.f55030c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return ((r106 + r101) * 31) + this.f55031d;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GameDetailSecurityInfoProps(ID=" + this.f55028a + ", commonParams=" + this.f55029b + ", securityData=" + this.f55030c + ", promoteScene=" + this.f55031d + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f55028a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public a(String r100, h r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        Intrinsics.checkNotNullParameter(r102, "securityData");
        this.f55028a = r100;
        this.f55029b = r101;
        this.f55030c = r102;
        this.f55031d = 0;
    }
}
