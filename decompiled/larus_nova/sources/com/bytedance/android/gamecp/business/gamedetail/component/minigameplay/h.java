package com.bytedance.android.gamecp.business.gamedetail.component.minigameplay;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class h implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f54601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f54602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f54603c;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 21;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f54601a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public h(String r100, a r101, b r102) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        this.f54601a = r100;
        this.f54602b = r101;
        this.f54603c = r102;
    }
}
