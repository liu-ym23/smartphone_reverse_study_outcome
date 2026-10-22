package com.bytedance.android.live.recharge.exchange.dialog;

import com.bytedance.android.live.recharge.model.ExchangeType;

/* JADX INFO: loaded from: classes47.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f89829a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f89830b = null;

    static {
        int[] r100 = new int[ExchangeType.values().length];
        f89829a = r100;
        ExchangeType r101 = ExchangeType.EXCHANGE_TYPE_FANS;
        r100[r101.ordinal()] = 1;
        ExchangeType r102 = ExchangeType.EXCHANGE_TYPE_LOTTERY_JOIN_FANS;
        r100[r102.ordinal()] = 2;
        ExchangeType r103 = ExchangeType.EXCHANGE_TYPE_RED_PACKET;
        r100[r103.ordinal()] = 3;
        r100[ExchangeType.EXCHANGE_TYPE_LOTTERY.ordinal()] = 4;
        ExchangeType r104 = ExchangeType.EXCHANGE_TYPE_GIFT;
        r100[r104.ordinal()] = 5;
        ExchangeType r105 = ExchangeType.EXCHANGE_TYPE_FAST_GIFT;
        r100[r105.ordinal()] = 6;
        ExchangeType r110 = ExchangeType.EXCHANGE_TYPE_GIFT_GUIDE;
        r100[r110.ordinal()] = 7;
        ExchangeType r111 = ExchangeType.EXCHANGE_TYPE_FANS_SEND_GIFT;
        r100[r111.ordinal()] = 8;
        ExchangeType r112 = ExchangeType.EXCHANGE_TYPE_BARRAGE;
        r100[r112.ordinal()] = 9;
        int[] r106 = new int[ExchangeType.values().length];
        f89830b = r106;
        r106[r105.ordinal()] = 1;
        r106[r101.ordinal()] = 2;
        r106[r111.ordinal()] = 3;
        r106[r112.ordinal()] = 4;
        r106[r110.ordinal()] = 5;
        r106[r102.ordinal()] = 6;
        r106[r103.ordinal()] = 7;
        r106[r104.ordinal()] = 8;
    }
}
