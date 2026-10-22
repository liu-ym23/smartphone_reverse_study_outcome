package com.bytedance.android.gamecp.business.gamedetail.component.layoutcomponent;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b<P extends d0> implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final P f54398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<d0> f54399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<c> f54400c;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f54398a.getId();
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return this.f54398a.getType();
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(P r100, List<? extends d0> r101, List<c> r102) {
        Intrinsics.checkNotNullParameter(r100, "attrProp");
        Intrinsics.checkNotNullParameter(r101, "childProps");
        Intrinsics.checkNotNullParameter(r102, "childLayoutProps");
        this.f54398a = r100;
        this.f54399b = r101;
        this.f54400c = r102;
    }
}
