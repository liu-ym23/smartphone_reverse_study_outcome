package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.header;

import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.shopping.anchorv4.dto.business.SkuSpecInfo;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.x;
import com.bytedance.android.shopping.prepurchase.arch.container.component.j;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vg3.e0;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0 f181778a;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.x
    public final List<SkuSpecInfo> v() {
        return this.f181778a.Z0();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.x
    public final SkuRestoreState w() {
        return this.f181778a.g0();
    }

    public b(j r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceRegistry");
        com.bytedance.android.shopping.prepurchase.arch.container.ability.a r101 = r100.getService(e0.class);
        Intrinsics.checkNotNull(r101);
        this.f181778a = (e0) r101;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.x
    public final void l(SkuProductDetailInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "skuProductDetailInfo");
        this.f181778a.l(r100);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.x
    public final void u(Function1<? super SkuProductDetailInfo, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f181778a.u(r100);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.x
    public final void q(SkuRestoreState r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f181778a.q(r100, r101);
    }
}
