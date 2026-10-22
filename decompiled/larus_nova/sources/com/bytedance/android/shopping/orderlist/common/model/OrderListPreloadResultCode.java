package com.bytedance.android.shopping.orderlist.common.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/model/OrderListPreloadResultCode;", "", "", "code", "I", "getCode", "()I", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "ALREADY_REQUESTING", "ALREADY_IN_ORDER_LIST", "INVALID_ENTER_FROM", "GET_SCHEMA_FAILURE", "SCHEMA_PROCESSOR_INVALID", "EXIST_VALID_PRELOAD_RESPONSE", "GET_QUERY_RESPONSE_FAILURE", "SUCCESS", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OrderListPreloadResultCode extends Enum<OrderListPreloadResultCode> {
    public static final OrderListPreloadResultCode ALREADY_IN_ORDER_LIST = null;
    public static final OrderListPreloadResultCode ALREADY_REQUESTING = null;
    public static final OrderListPreloadResultCode EXIST_VALID_PRELOAD_RESPONSE = null;
    public static final OrderListPreloadResultCode GET_QUERY_RESPONSE_FAILURE = null;
    public static final OrderListPreloadResultCode GET_SCHEMA_FAILURE = null;
    public static final OrderListPreloadResultCode INVALID_ENTER_FROM = null;
    public static final OrderListPreloadResultCode SCHEMA_PROCESSOR_INVALID = null;
    public static final OrderListPreloadResultCode SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OrderListPreloadResultCode[] f179883a = null;
    private final int code;
    private final String msg;

    public static OrderListPreloadResultCode valueOf(String r100) {
        return (OrderListPreloadResultCode) a.a(OrderListPreloadResultCode.class, r100);
    }

    public static OrderListPreloadResultCode[] values() {
        return (OrderListPreloadResultCode[]) f179883a.clone();
    }

    static {
        OrderListPreloadResultCode r100 = new OrderListPreloadResultCode("ALREADY_REQUESTING", 0, -1, "当前正在请求中");
        ALREADY_REQUESTING = r100;
        OrderListPreloadResultCode r101 = new OrderListPreloadResultCode("ALREADY_IN_ORDER_LIST", 1, -2, "当前在订单列表页面");
        ALREADY_IN_ORDER_LIST = r101;
        OrderListPreloadResultCode r102 = new OrderListPreloadResultCode("INVALID_ENTER_FROM", 2, -3, "输入enterFrom为空");
        INVALID_ENTER_FROM = r102;
        OrderListPreloadResultCode r103 = new OrderListPreloadResultCode("GET_SCHEMA_FAILURE", 3, -4, "获取最新scheme失败");
        GET_SCHEMA_FAILURE = r103;
        OrderListPreloadResultCode r104 = new OrderListPreloadResultCode("SCHEMA_PROCESSOR_INVALID", 4, -5, "业务返回scheme为空");
        SCHEMA_PROCESSOR_INVALID = r104;
        OrderListPreloadResultCode r105 = new OrderListPreloadResultCode("EXIST_VALID_PRELOAD_RESPONSE", 5, -6, "已存在有效的预加载结果");
        EXIST_VALID_PRELOAD_RESPONSE = r105;
        OrderListPreloadResultCode r106 = new OrderListPreloadResultCode("GET_QUERY_RESPONSE_FAILURE", 6, -7, "获取订单列表协议失败");
        GET_QUERY_RESPONSE_FAILURE = r106;
        OrderListPreloadResultCode r107 = new OrderListPreloadResultCode("SUCCESS", 7, 0, "预加载成功");
        SUCCESS = r107;
        f179883a = new OrderListPreloadResultCode[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public OrderListPreloadResultCode(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.msg = r103;
    }
}
