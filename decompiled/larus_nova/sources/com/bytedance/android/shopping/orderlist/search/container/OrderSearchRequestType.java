package com.bytedance.android.shopping.orderlist.search.container;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/search/container/OrderSearchRequestType;", "", EffectConstants.NORMAL, "FIRST_REQUEST", "FIRST_SCREEN_ERROR_RETRY_REQUEST", "FOOT_REQUEST", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OrderSearchRequestType extends Enum<OrderSearchRequestType> {
    public static final OrderSearchRequestType FIRST_REQUEST = null;
    public static final OrderSearchRequestType FIRST_SCREEN_ERROR_RETRY_REQUEST = null;
    public static final OrderSearchRequestType FOOT_REQUEST = null;
    public static final OrderSearchRequestType NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OrderSearchRequestType[] f180538a = null;

    static {
        OrderSearchRequestType r100 = new OrderSearchRequestType(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        OrderSearchRequestType r101 = new OrderSearchRequestType("FIRST_REQUEST", 1);
        FIRST_REQUEST = r101;
        OrderSearchRequestType r102 = new OrderSearchRequestType("FIRST_SCREEN_ERROR_RETRY_REQUEST", 2);
        FIRST_SCREEN_ERROR_RETRY_REQUEST = r102;
        OrderSearchRequestType r103 = new OrderSearchRequestType("FOOT_REQUEST", 3);
        FOOT_REQUEST = r103;
        f180538a = new OrderSearchRequestType[]{r100, r101, r102, r103};
    }

    public static OrderSearchRequestType valueOf(String r100) {
        return (OrderSearchRequestType) r27.a.a(OrderSearchRequestType.class, r100);
    }

    public static OrderSearchRequestType[] values() {
        return (OrderSearchRequestType[]) f180538a.clone();
    }

    public OrderSearchRequestType(String r100, int r101) {
        super(r100, r101);
    }
}
