package com.bytedance.android.gamecp.business.gamedetail.component.titlebar.score;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f55267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f55268b;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f55267a, r101.f55267a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f55268b, r101.f55268b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 27;
    }

    public final int hashCode() {
        String r100 = this.f55267a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        a r104 = this.f55268b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TitleScoreInfoProps(ID=" + this.f55267a + ", data=" + this.f55268b + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f55267a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public b(String r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f55267a = r100;
        this.f55268b = r101;
    }
}
