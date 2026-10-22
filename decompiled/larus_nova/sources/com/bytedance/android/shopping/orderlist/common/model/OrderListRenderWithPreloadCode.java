package com.bytedance.android.shopping.orderlist.common.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/model/OrderListRenderWithPreloadCode;", "", "", "code", "I", "getCode", "()I", "RESULT_SUCCESS", "RESULT_EMPTY", "RESULT_OUT_OF_DATE", "RESULT_SCHEMA_CHANGED", "RESULT_UID_CHANGED", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OrderListRenderWithPreloadCode extends Enum<OrderListRenderWithPreloadCode> {
    public static final OrderListRenderWithPreloadCode RESULT_EMPTY = null;
    public static final OrderListRenderWithPreloadCode RESULT_OUT_OF_DATE = null;
    public static final OrderListRenderWithPreloadCode RESULT_SCHEMA_CHANGED = null;
    public static final OrderListRenderWithPreloadCode RESULT_SUCCESS = null;
    public static final OrderListRenderWithPreloadCode RESULT_UID_CHANGED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OrderListRenderWithPreloadCode[] f179884a = null;
    private final int code;

    static {
        OrderListRenderWithPreloadCode r100 = new OrderListRenderWithPreloadCode("RESULT_SUCCESS", 0, 0);
        RESULT_SUCCESS = r100;
        OrderListRenderWithPreloadCode r101 = new OrderListRenderWithPreloadCode("RESULT_EMPTY", 1, -1);
        RESULT_EMPTY = r101;
        OrderListRenderWithPreloadCode r102 = new OrderListRenderWithPreloadCode("RESULT_OUT_OF_DATE", 2, -2);
        RESULT_OUT_OF_DATE = r102;
        OrderListRenderWithPreloadCode r103 = new OrderListRenderWithPreloadCode("RESULT_SCHEMA_CHANGED", 3, -3);
        RESULT_SCHEMA_CHANGED = r103;
        OrderListRenderWithPreloadCode r104 = new OrderListRenderWithPreloadCode("RESULT_UID_CHANGED", 4, -4);
        RESULT_UID_CHANGED = r104;
        f179884a = new OrderListRenderWithPreloadCode[]{r100, r101, r102, r103, r104};
    }

    public static OrderListRenderWithPreloadCode valueOf(String r100) {
        return (OrderListRenderWithPreloadCode) a.a(OrderListRenderWithPreloadCode.class, r100);
    }

    public static OrderListRenderWithPreloadCode[] values() {
        return (OrderListRenderWithPreloadCode[]) f179884a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public OrderListRenderWithPreloadCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
