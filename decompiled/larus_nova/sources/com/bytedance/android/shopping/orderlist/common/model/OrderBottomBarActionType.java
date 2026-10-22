package com.bytedance.android.shopping.orderlist.common.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/model/OrderBottomBarActionType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "CLICK", "VIEW", "CLOSE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OrderBottomBarActionType extends Enum<OrderBottomBarActionType> {
    public static final OrderBottomBarActionType CLICK = null;
    public static final OrderBottomBarActionType CLOSE = null;
    public static final OrderBottomBarActionType VIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OrderBottomBarActionType[] f179882a = null;
    private final String type;

    static {
        OrderBottomBarActionType r100 = new OrderBottomBarActionType("CLICK", 0, "click");
        CLICK = r100;
        OrderBottomBarActionType r101 = new OrderBottomBarActionType("VIEW", 1, "view");
        VIEW = r101;
        OrderBottomBarActionType r102 = new OrderBottomBarActionType("CLOSE", 2, "close");
        CLOSE = r102;
        f179882a = new OrderBottomBarActionType[]{r100, r101, r102};
    }

    public static OrderBottomBarActionType valueOf(String r100) {
        return (OrderBottomBarActionType) a.a(OrderBottomBarActionType.class, r100);
    }

    public static OrderBottomBarActionType[] values() {
        return (OrderBottomBarActionType[]) f179882a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public OrderBottomBarActionType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
