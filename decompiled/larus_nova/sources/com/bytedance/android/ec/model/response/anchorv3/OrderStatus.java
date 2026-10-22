package com.bytedance.android.ec.model.response.anchorv3;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/OrderStatus;", "", "", CommonConstant.RETKEY.STATUS, "I", "getSTATUS", "()I", "UN_BUY", "UN_PAY", "CAN_EXPERIENCE", "CAN_NOT_EXPERIENCE", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final enum OrderStatus extends Enum<OrderStatus> {
    public static final OrderStatus CAN_EXPERIENCE = null;
    public static final OrderStatus CAN_NOT_EXPERIENCE = null;
    public static final OrderStatus UN_BUY = null;
    public static final OrderStatus UN_PAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OrderStatus[] f47934a = null;
    private final int STATUS;

    static {
        OrderStatus r100 = new OrderStatus("UN_BUY", 0, 1);
        UN_BUY = r100;
        OrderStatus r101 = new OrderStatus("UN_PAY", 1, 2);
        UN_PAY = r101;
        OrderStatus r102 = new OrderStatus("CAN_EXPERIENCE", 2, 3);
        CAN_EXPERIENCE = r102;
        OrderStatus r103 = new OrderStatus("CAN_NOT_EXPERIENCE", 3, 4);
        CAN_NOT_EXPERIENCE = r103;
        f47934a = new OrderStatus[]{r100, r101, r102, r103};
    }

    public static OrderStatus valueOf(String r100) {
        return (OrderStatus) r27.a.a(OrderStatus.class, r100);
    }

    public static OrderStatus[] values() {
        return (OrderStatus[]) f47934a.clone();
    }

    public final int getSTATUS() {
        return this.STATUS;
    }

    public OrderStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.STATUS = r102;
    }
}
