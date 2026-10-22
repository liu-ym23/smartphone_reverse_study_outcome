package com.bytedance.android.shopping.orderlist.common.monitor.skeleton;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/monitor/skeleton/OrderSkeletonType;", "", "", "value", "I", "getValue", "()I", "FIRST_SCREEN", "CHANGE_TAB", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OrderSkeletonType extends Enum<OrderSkeletonType> {
    public static final OrderSkeletonType CHANGE_TAB = null;
    public static final OrderSkeletonType FIRST_SCREEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OrderSkeletonType[] f179933a = null;
    private final int value;

    static {
        OrderSkeletonType r100 = new OrderSkeletonType("FIRST_SCREEN", 0, 0);
        FIRST_SCREEN = r100;
        OrderSkeletonType r101 = new OrderSkeletonType("CHANGE_TAB", 1, 1);
        CHANGE_TAB = r101;
        f179933a = new OrderSkeletonType[]{r100, r101};
    }

    public static OrderSkeletonType valueOf(String r100) {
        return (OrderSkeletonType) r27.a.a(OrderSkeletonType.class, r100);
    }

    public static OrderSkeletonType[] values() {
        return (OrderSkeletonType[]) f179933a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public OrderSkeletonType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
