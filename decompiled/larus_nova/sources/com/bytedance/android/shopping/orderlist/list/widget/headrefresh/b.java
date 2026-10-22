package com.bytedance.android.shopping.orderlist.list.widget.headrefresh;

/* JADX INFO: loaded from: classes13.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f180470a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f180471b = null;

    static {
        int[] r100 = new int[OrderListHeadRefreshLayout.MoveState.values().length];
        f180470a = r100;
        OrderListHeadRefreshLayout.MoveState r101 = OrderListHeadRefreshLayout.MoveState.V_MOVING_HEAD;
        r100[r101.ordinal()] = 1;
        OrderListHeadRefreshLayout.MoveState r102 = OrderListHeadRefreshLayout.MoveState.V_MOVING_HEAD_UP_OR_CANCEL;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[OrderListHeadRefreshLayout.MoveState.values().length];
        f180471b = r103;
        r103[r101.ordinal()] = 1;
        r103[r102.ordinal()] = 2;
    }
}
