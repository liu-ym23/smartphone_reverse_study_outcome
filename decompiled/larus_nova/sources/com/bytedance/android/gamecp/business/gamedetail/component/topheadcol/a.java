package com.bytedance.android.gamecp.business.gamedetail.component.topheadcol;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f55280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0 f55281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Float f55282c;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f55280a, r101.f55280a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f55281b, r101.f55281b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f55282c, r101.f55282c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 42;
    }

    public final int hashCode() {
        String r100 = this.f55280a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        d0 r104 = this.f55281b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Float r107 = this.f55282c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TopHeadColProps(ID=" + this.f55280a + ", colProps=" + this.f55281b + ", dialogSlideOffset=" + this.f55282c + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f55280a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public a(String r100, d0 r101, Float r102) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        this.f55280a = r100;
        this.f55281b = r101;
        this.f55282c = r102;
    }
}
