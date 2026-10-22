package com.bytedance.android.shopping.orderlist.list.container;

/* JADX INFO: loaded from: classes13.dex */
public final /* synthetic */ class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f180195a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f180196b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f180197c = null;

    static {
        int[] r100 = new int[OrderListRequestType.values().length];
        f180195a = r100;
        OrderListRequestType r101 = OrderListRequestType.NORMAL;
        r100[r101.ordinal()] = 1;
        OrderListRequestType r102 = OrderListRequestType.CHANGE_TAB_ERROR_RETRY_REQUEST;
        r100[r102.ordinal()] = 2;
        OrderListRequestType r103 = OrderListRequestType.PRELOAD_REQUEST;
        r100[r103.ordinal()] = 3;
        OrderListRequestType r104 = OrderListRequestType.FIRST_REQUEST;
        r100[r104.ordinal()] = 4;
        OrderListRequestType r105 = OrderListRequestType.CLICK_TAB_REQUEST;
        r100[r105.ordinal()] = 5;
        OrderListRequestType r110 = OrderListRequestType.SIDE_SLIP_TAB_REQUEST;
        r100[r110.ordinal()] = 6;
        OrderListRequestType r111 = OrderListRequestType.FIRST_SCREEN_ERROR_RETRY_REQUEST;
        r100[r111.ordinal()] = 7;
        OrderListRequestType r112 = OrderListRequestType.HEAD_REQUEST;
        r100[r112.ordinal()] = 8;
        OrderListRequestType r113 = OrderListRequestType.FOOT_REQUEST;
        r100[r113.ordinal()] = 9;
        int[] r106 = new int[OrderListRequestType.values().length];
        f180196b = r106;
        r106[r104.ordinal()] = 1;
        r106[r103.ordinal()] = 2;
        r106[r111.ordinal()] = 3;
        r106[r113.ordinal()] = 4;
        r106[r112.ordinal()] = 5;
        r106[r101.ordinal()] = 6;
        r106[r105.ordinal()] = 7;
        r106[r110.ordinal()] = 8;
        r106[r102.ordinal()] = 9;
        int[] r107 = new int[OrderListRequestType.values().length];
        f180197c = r107;
        r107[r104.ordinal()] = 1;
        r107[r103.ordinal()] = 2;
        r107[r111.ordinal()] = 3;
        r107[r110.ordinal()] = 4;
        r107[r105.ordinal()] = 5;
        r107[r102.ordinal()] = 6;
        r107[r113.ordinal()] = 7;
        r107[r112.ordinal()] = 8;
        r107[r101.ordinal()] = 9;
    }
}
