package com.bytedance.android.gamecp.business.gamedetail.component.titlebar.minigame;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f55226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.gamecp.business.gamedetail.component.minigamebar.c f55227b;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f55226a, r101.f55226a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f55227b, r101.f55227b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 28;
    }

    public final int hashCode() {
        String r100 = this.f55226a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        com.bytedance.android.gamecp.business.gamedetail.component.minigamebar.c r104 = this.f55227b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TitleMiniGameButtonProps(ID=" + this.f55226a + ", data=" + this.f55227b + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f55226a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public a(String r100, com.bytedance.android.gamecp.business.gamedetail.component.minigamebar.c r101) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f55226a = r100;
        this.f55227b = r101;
    }
}
