package com.bytedance.android.live.recharge.order;

import com.bytedance.android.live.recharge.platform.service.IExchangeService;
import com.bytedance.android.live.recharge.platform.service.PayService;

/* JADX INFO: loaded from: classes47.dex */
public final /* synthetic */ class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f90131a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f90132b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f90133c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int[] f90134d = null;

    static {
        int[] r100 = new int[Order.State.values().length];
        f90131a = r100;
        Order.State r101 = Order.State.Successful;
        r100[r101.ordinal()] = 1;
        Order.State r102 = Order.State.Failed;
        r100[r102.ordinal()] = 2;
        r100[Order.State.Canceled.ordinal()] = 3;
        int[] r103 = new int[IExchangeService.ExchangeProgress.values().length];
        f90132b = r103;
        r103[IExchangeService.ExchangeProgress.START.ordinal()] = 1;
        int[] r104 = new int[PayService.PayProgress.values().length];
        f90133c = r104;
        r104[PayService.PayProgress.START.ordinal()] = 1;
        r104[PayService.PayProgress.QUERY_ORDER.ordinal()] = 2;
        r104[PayService.PayProgress.SHOW_CASHIER.ordinal()] = 3;
        int[] r105 = new int[Order.State.values().length];
        f90134d = r105;
        r105[r101.ordinal()] = 1;
        r105[r102.ordinal()] = 2;
    }
}
