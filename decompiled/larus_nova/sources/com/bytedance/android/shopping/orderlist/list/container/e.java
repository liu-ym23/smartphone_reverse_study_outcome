package com.bytedance.android.shopping.orderlist.list.container;

/* JADX INFO: loaded from: classes13.dex */
public final /* synthetic */ class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f180187a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f180188b = null;

    static {
        int[] r100 = new int[OrderListRequestType.values().length];
        f180187a = r100;
        r100[OrderListRequestType.NORMAL.ordinal()] = 1;
        r100[OrderListRequestType.FIRST_REQUEST.ordinal()] = 2;
        r100[OrderListRequestType.PRELOAD_REQUEST.ordinal()] = 3;
        r100[OrderListRequestType.CHANGE_TAB_ERROR_RETRY_REQUEST.ordinal()] = 4;
        r100[OrderListRequestType.FIRST_SCREEN_ERROR_RETRY_REQUEST.ordinal()] = 5;
        OrderListRequestType r101 = OrderListRequestType.HEAD_REQUEST;
        r100[r101.ordinal()] = 6;
        OrderListRequestType r102 = OrderListRequestType.FOOT_REQUEST;
        r100[r102.ordinal()] = 7;
        int[] r103 = new int[OrderListRequestType.values().length];
        f180188b = r103;
        r103[r101.ordinal()] = 1;
        r103[r102.ordinal()] = 2;
    }
}
