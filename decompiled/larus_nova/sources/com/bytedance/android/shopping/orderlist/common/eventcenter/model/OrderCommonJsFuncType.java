package com.bytedance.android.shopping.orderlist.common.eventcenter.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/eventcenter/model/OrderCommonJsFuncType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "TYPE_REFRESH", "TYPE_YATA_EVENT", "TYPE_SEARCH_FEEDS_REQUEST_FINISH", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OrderCommonJsFuncType extends Enum<OrderCommonJsFuncType> {
    public static final OrderCommonJsFuncType TYPE_REFRESH = null;
    public static final OrderCommonJsFuncType TYPE_SEARCH_FEEDS_REQUEST_FINISH = null;
    public static final OrderCommonJsFuncType TYPE_YATA_EVENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OrderCommonJsFuncType[] f179866a = null;
    private final String type;

    static {
        OrderCommonJsFuncType r100 = new OrderCommonJsFuncType("TYPE_REFRESH", 0, "refresh");
        TYPE_REFRESH = r100;
        OrderCommonJsFuncType r101 = new OrderCommonJsFuncType("TYPE_YATA_EVENT", 1, "yata_event");
        TYPE_YATA_EVENT = r101;
        OrderCommonJsFuncType r102 = new OrderCommonJsFuncType("TYPE_SEARCH_FEEDS_REQUEST_FINISH", 2, "search_feeds_request_finish");
        TYPE_SEARCH_FEEDS_REQUEST_FINISH = r102;
        f179866a = new OrderCommonJsFuncType[]{r100, r101, r102};
    }

    public static OrderCommonJsFuncType valueOf(String r100) {
        return (OrderCommonJsFuncType) a.a(OrderCommonJsFuncType.class, r100);
    }

    public static OrderCommonJsFuncType[] values() {
        return (OrderCommonJsFuncType[]) f179866a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public OrderCommonJsFuncType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
