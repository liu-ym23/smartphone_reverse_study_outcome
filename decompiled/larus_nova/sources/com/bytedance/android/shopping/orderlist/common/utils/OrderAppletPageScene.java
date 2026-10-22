package com.bytedance.android.shopping.orderlist.common.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/utils/OrderAppletPageScene;", "", "PAGE_INTERNAL", "GO_TO_LANDING", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OrderAppletPageScene extends Enum<OrderAppletPageScene> {
    public static final OrderAppletPageScene GO_TO_LANDING = null;
    public static final OrderAppletPageScene PAGE_INTERNAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OrderAppletPageScene[] f179947a = null;

    static {
        OrderAppletPageScene r100 = new OrderAppletPageScene("PAGE_INTERNAL", 0);
        PAGE_INTERNAL = r100;
        OrderAppletPageScene r101 = new OrderAppletPageScene("GO_TO_LANDING", 1);
        GO_TO_LANDING = r101;
        f179947a = new OrderAppletPageScene[]{r100, r101};
    }

    public static OrderAppletPageScene valueOf(String r100) {
        return (OrderAppletPageScene) r27.a.a(OrderAppletPageScene.class, r100);
    }

    public static OrderAppletPageScene[] values() {
        return (OrderAppletPageScene[]) f179947a.clone();
    }

    public OrderAppletPageScene(String r100, int r101) {
        super(r100, r101);
    }
}
