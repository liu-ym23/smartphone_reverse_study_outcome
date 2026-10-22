package com.bytedance.android.shopping.orderlist.list.container;

import com.bytedance.android.shopping.orderlist.list.tracker.OrderListTracker;

/* JADX INFO: loaded from: classes13.dex */
public final /* synthetic */ class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f180192a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f180193b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f180194c = null;

    static {
        int[] r100 = new int[OrderListRequestType.values().length];
        f180192a = r100;
        OrderListRequestType r101 = OrderListRequestType.FIRST_REQUEST;
        r100[r101.ordinal()] = 1;
        OrderListRequestType r102 = OrderListRequestType.PRELOAD_REQUEST;
        r100[r102.ordinal()] = 2;
        OrderListRequestType r103 = OrderListRequestType.NORMAL;
        r100[r103.ordinal()] = 3;
        OrderListRequestType r104 = OrderListRequestType.FIRST_SCREEN_ERROR_RETRY_REQUEST;
        r100[r104.ordinal()] = 4;
        OrderListRequestType r105 = OrderListRequestType.CHANGE_TAB_ERROR_RETRY_REQUEST;
        r100[r105.ordinal()] = 5;
        OrderListRequestType r110 = OrderListRequestType.HEAD_REQUEST;
        r100[r110.ordinal()] = 6;
        OrderListRequestType r111 = OrderListRequestType.CLICK_TAB_REQUEST;
        r100[r111.ordinal()] = 7;
        OrderListRequestType r112 = OrderListRequestType.SIDE_SLIP_TAB_REQUEST;
        r100[r112.ordinal()] = 8;
        OrderListRequestType r113 = OrderListRequestType.FOOT_REQUEST;
        r100[r113.ordinal()] = 9;
        int[] r106 = new int[OrderListRequestType.values().length];
        f180193b = r106;
        r106[r101.ordinal()] = 1;
        r106[r102.ordinal()] = 2;
        r106[r103.ordinal()] = 3;
        r106[r104.ordinal()] = 4;
        r106[r105.ordinal()] = 5;
        r106[r111.ordinal()] = 6;
        r106[r112.ordinal()] = 7;
        r106[r110.ordinal()] = 8;
        r106[r113.ordinal()] = 9;
        int[] r107 = new int[OrderListTracker.ChangeTabType.values().length];
        f180194c = r107;
        r107[OrderListTracker.ChangeTabType.SLIDE.ordinal()] = 1;
        r107[OrderListTracker.ChangeTabType.CLICK.ordinal()] = 2;
    }
}
