package com.bytedance.android.ec.model;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/ec/model/ButtonType;", "", "", "type", "I", "getType", "()I", EffectConstants.NORMAL, "TimingSale", "TimingSaleAppointed", "TimingSaleNotAppointed", "MillionSubsid", "Auction", "Seckill", "GroupBuy", "GroupBuyAlone", "DepositPresale", "DepositPresaleAppointed", "DepositPresaleNotAppointed", "UserLimit", "Presale", "DepositFindGoods", "MultiChannelSale", "MatchPurchase", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final enum ButtonType extends Enum<ButtonType> {
    public static final ButtonType Auction = null;
    public static final ButtonType DepositFindGoods = null;
    public static final ButtonType DepositPresale = null;
    public static final ButtonType DepositPresaleAppointed = null;
    public static final ButtonType DepositPresaleNotAppointed = null;
    public static final ButtonType GroupBuy = null;
    public static final ButtonType GroupBuyAlone = null;
    public static final ButtonType MatchPurchase = null;
    public static final ButtonType MillionSubsid = null;
    public static final ButtonType MultiChannelSale = null;
    public static final ButtonType NORMAL = null;
    public static final ButtonType Presale = null;
    public static final ButtonType Seckill = null;
    public static final ButtonType TimingSale = null;
    public static final ButtonType TimingSaleAppointed = null;
    public static final ButtonType TimingSaleNotAppointed = null;
    public static final ButtonType UserLimit = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ButtonType[] f47848a = null;
    private final int type;

    public static ButtonType valueOf(String r100) {
        return (ButtonType) r27.a.a(ButtonType.class, r100);
    }

    public static ButtonType[] values() {
        return (ButtonType[]) f47848a.clone();
    }

    static {
        ButtonType r100 = new ButtonType(EffectConstants.NORMAL, 0, 0);
        NORMAL = r100;
        ButtonType r101 = new ButtonType("TimingSale", 1, 140);
        TimingSale = r101;
        ButtonType r102 = new ButtonType("TimingSaleAppointed", 2, 141);
        TimingSaleAppointed = r102;
        ButtonType r103 = new ButtonType("TimingSaleNotAppointed", 3, 142);
        TimingSaleNotAppointed = r103;
        ButtonType r104 = new ButtonType("MillionSubsid", 4, 72);
        MillionSubsid = r104;
        ButtonType r105 = new ButtonType("Auction", 5, 12);
        Auction = r105;
        ButtonType r106 = new ButtonType("Seckill", 6, 7);
        Seckill = r106;
        ButtonType r107 = new ButtonType("GroupBuy", 7, 120);
        GroupBuy = r107;
        ButtonType r108 = new ButtonType("GroupBuyAlone", 8, 121);
        GroupBuyAlone = r108;
        ButtonType r109 = new ButtonType("DepositPresale", 9, 10);
        DepositPresale = r109;
        ButtonType r110 = new ButtonType("DepositPresaleAppointed", 10, 101);
        DepositPresaleAppointed = r110;
        ButtonType r111 = new ButtonType("DepositPresaleNotAppointed", 11, 102);
        DepositPresaleNotAppointed = r111;
        ButtonType r112 = new ButtonType("UserLimit", 12, 14);
        UserLimit = r112;
        ButtonType r113 = new ButtonType("Presale", 13, 2);
        Presale = r113;
        ButtonType r114 = new ButtonType("DepositFindGoods", 14, 3);
        DepositFindGoods = r114;
        ButtonType r115 = new ButtonType("MultiChannelSale", 15, 13);
        MultiChannelSale = r115;
        ButtonType r116 = new ButtonType("MatchPurchase", 16, 15);
        MatchPurchase = r116;
        f47848a = new ButtonType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116};
    }

    public final int getType() {
        return this.type;
    }

    public ButtonType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
