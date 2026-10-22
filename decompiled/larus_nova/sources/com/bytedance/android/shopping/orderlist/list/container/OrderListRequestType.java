package com.bytedance.android.shopping.orderlist.list.container;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/container/OrderListRequestType;", "", EffectConstants.NORMAL, "FIRST_REQUEST", "FIRST_SCREEN_ERROR_RETRY_REQUEST", "CHANGE_TAB_ERROR_RETRY_REQUEST", "HEAD_REQUEST", "FOOT_REQUEST", "PRELOAD_REQUEST", "CLICK_TAB_REQUEST", "SIDE_SLIP_TAB_REQUEST", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OrderListRequestType extends Enum<OrderListRequestType> {
    public static final OrderListRequestType CHANGE_TAB_ERROR_RETRY_REQUEST = null;
    public static final OrderListRequestType CLICK_TAB_REQUEST = null;
    public static final OrderListRequestType FIRST_REQUEST = null;
    public static final OrderListRequestType FIRST_SCREEN_ERROR_RETRY_REQUEST = null;
    public static final OrderListRequestType FOOT_REQUEST = null;
    public static final OrderListRequestType HEAD_REQUEST = null;
    public static final OrderListRequestType NORMAL = null;
    public static final OrderListRequestType PRELOAD_REQUEST = null;
    public static final OrderListRequestType SIDE_SLIP_TAB_REQUEST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OrderListRequestType[] f180164a = null;

    static {
        OrderListRequestType r100 = new OrderListRequestType(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        OrderListRequestType r101 = new OrderListRequestType("FIRST_REQUEST", 1);
        FIRST_REQUEST = r101;
        OrderListRequestType r102 = new OrderListRequestType("FIRST_SCREEN_ERROR_RETRY_REQUEST", 2);
        FIRST_SCREEN_ERROR_RETRY_REQUEST = r102;
        OrderListRequestType r103 = new OrderListRequestType("CHANGE_TAB_ERROR_RETRY_REQUEST", 3);
        CHANGE_TAB_ERROR_RETRY_REQUEST = r103;
        OrderListRequestType r104 = new OrderListRequestType("HEAD_REQUEST", 4);
        HEAD_REQUEST = r104;
        OrderListRequestType r105 = new OrderListRequestType("FOOT_REQUEST", 5);
        FOOT_REQUEST = r105;
        OrderListRequestType r106 = new OrderListRequestType("PRELOAD_REQUEST", 6);
        PRELOAD_REQUEST = r106;
        OrderListRequestType r107 = new OrderListRequestType("CLICK_TAB_REQUEST", 7);
        CLICK_TAB_REQUEST = r107;
        OrderListRequestType r108 = new OrderListRequestType("SIDE_SLIP_TAB_REQUEST", 8);
        SIDE_SLIP_TAB_REQUEST = r108;
        f180164a = new OrderListRequestType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    public static OrderListRequestType valueOf(String r100) {
        return (OrderListRequestType) r27.a.a(OrderListRequestType.class, r100);
    }

    public static OrderListRequestType[] values() {
        return (OrderListRequestType[]) f180164a.clone();
    }

    public OrderListRequestType(String r100, int r101) {
        super(r100, r101);
    }
}
