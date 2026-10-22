package com.bytedance.android.live.recharge.exchange;

import com.bytedance.android.live.recharge.order.Order;

/* JADX INFO: loaded from: classes47.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f89791a = null;

    static {
        int[] r100 = new int[Order.State.values().length];
        f89791a = r100;
        r100[Order.State.Successful.ordinal()] = 1;
        r100[Order.State.Failed.ordinal()] = 2;
    }
}
