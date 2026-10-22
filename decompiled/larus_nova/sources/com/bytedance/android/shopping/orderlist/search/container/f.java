package com.bytedance.android.shopping.orderlist.search.container;

/* JADX INFO: loaded from: classes13.dex */
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f180580a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f180581b = null;

    static {
        int[] r100 = new int[OrderSearchRequestType.values().length];
        f180580a = r100;
        OrderSearchRequestType r101 = OrderSearchRequestType.NORMAL;
        r100[r101.ordinal()] = 1;
        OrderSearchRequestType r102 = OrderSearchRequestType.FIRST_REQUEST;
        r100[r102.ordinal()] = 2;
        OrderSearchRequestType r103 = OrderSearchRequestType.FIRST_SCREEN_ERROR_RETRY_REQUEST;
        r100[r103.ordinal()] = 3;
        OrderSearchRequestType r104 = OrderSearchRequestType.FOOT_REQUEST;
        r100[r104.ordinal()] = 4;
        int[] r105 = new int[OrderSearchRequestType.values().length];
        f180581b = r105;
        r105[r102.ordinal()] = 1;
        r105[r103.ordinal()] = 2;
        r105[r104.ordinal()] = 3;
        r105[r101.ordinal()] = 4;
    }
}
