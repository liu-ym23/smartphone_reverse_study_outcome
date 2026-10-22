package com.bytedance.android.live.recharge.order.aio;

import com.bytedance.tools.kcp.aio.runtime.RpcEnum;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@RpcEnum(messageName = "webcast.revenue.biz.recharge.order.OrderResultCode")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/recharge/order/aio/OrderResultCode;", "", "", "value", "I", "getValue", "()I", "Unknown", "Success", "Failure", "Cancelled", "Submitted", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum OrderResultCode extends Enum<OrderResultCode> {
    public static final OrderResultCode Cancelled = null;
    public static final OrderResultCode Failure = null;
    public static final OrderResultCode Submitted = null;
    public static final OrderResultCode Success = null;
    public static final OrderResultCode Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OrderResultCode[] f90080a = null;
    private final int value;

    static {
        OrderResultCode r100 = new OrderResultCode("Unknown", 0, 0);
        Unknown = r100;
        OrderResultCode r101 = new OrderResultCode("Success", 1, 1);
        Success = r101;
        OrderResultCode r102 = new OrderResultCode("Failure", 2, 2);
        Failure = r102;
        OrderResultCode r103 = new OrderResultCode("Cancelled", 3, 3);
        Cancelled = r103;
        OrderResultCode r104 = new OrderResultCode("Submitted", 4, 4);
        Submitted = r104;
        f90080a = new OrderResultCode[]{r100, r101, r102, r103, r104};
    }

    public static OrderResultCode valueOf(String r100) {
        return (OrderResultCode) a.a(OrderResultCode.class, r100);
    }

    public static OrderResultCode[] values() {
        return (OrderResultCode[]) f90080a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public OrderResultCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
