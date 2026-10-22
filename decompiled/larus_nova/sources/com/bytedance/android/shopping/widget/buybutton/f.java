package com.bytedance.android.shopping.widget.buybutton;

import com.bytedance.android.ec.model.ButtonType;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f187295a = null;

    static {
        int[] r100 = new int[ButtonType.values().length];
        f187295a = r100;
        r100[ButtonType.Presale.ordinal()] = 1;
        r100[ButtonType.TimingSale.ordinal()] = 2;
        r100[ButtonType.TimingSaleAppointed.ordinal()] = 3;
        r100[ButtonType.TimingSaleNotAppointed.ordinal()] = 4;
        r100[ButtonType.DepositPresale.ordinal()] = 5;
        r100[ButtonType.DepositPresaleAppointed.ordinal()] = 6;
        r100[ButtonType.DepositPresaleNotAppointed.ordinal()] = 7;
        r100[ButtonType.DepositFindGoods.ordinal()] = 8;
        r100[ButtonType.GroupBuy.ordinal()] = 9;
        r100[ButtonType.GroupBuyAlone.ordinal()] = 10;
        r100[ButtonType.Auction.ordinal()] = 11;
        r100[ButtonType.Seckill.ordinal()] = 12;
    }
}
