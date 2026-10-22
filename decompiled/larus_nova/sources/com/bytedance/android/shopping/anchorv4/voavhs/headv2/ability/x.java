package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.shopping.anchorv4.dto.business.SkuSpecInfo;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public interface x {
    void l(SkuProductDetailInfo r100);

    void q(SkuRestoreState r100, boolean r101);

    void u(Function1<? super SkuProductDetailInfo, Unit> r100);

    List<SkuSpecInfo> v();

    SkuRestoreState w();
}
