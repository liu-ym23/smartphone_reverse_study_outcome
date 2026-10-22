package com.bytedance.android.shopping.store.product.presenter.aggregate;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.store.product.presenter.utils.ECProductCardFunctionUtils;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c {
    public static final void a(StoreV2ProductItemVO r100, QContext r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "qContext");
        Pair[] r104 = new Pair[3];
        if (r102 != null) goto L5;
        r102 = "store_page";
    L5:
        r104[0] = TuplesKt.to("enter_from_merge", r102);
        if (r103 != null) goto L8;
        r103 = "mini_window";
    L8:
        r104[1] = TuplesKt.to("enter_method", r103);
        r104[2] = TuplesKt.to("data_type", com.bytedance.android.ec.core.event.a.VALUE_DATA_TYPE);
        ECProductCardFunctionUtils.b(r100, r101, MapsKt.hashMapOf(r104));
    }
}
