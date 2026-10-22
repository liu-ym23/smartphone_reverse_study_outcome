package com.bytedance.android.live.recharge;

import com.bytedance.android.live.recharge.order.Order;

/* JADX INFO: loaded from: classes47.dex */
public final /* synthetic */ class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f90522a = null;

    static {
        int[] r100 = new int[Order.State.values().length];
        f90522a = r100;
        r100[Order.State.Successful.ordinal()] = 1;
        r100[Order.State.Failed.ordinal()] = 2;
    }
}
