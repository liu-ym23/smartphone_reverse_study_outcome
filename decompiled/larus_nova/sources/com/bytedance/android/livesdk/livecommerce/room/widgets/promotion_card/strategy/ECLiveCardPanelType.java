package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/promotion_card/strategy/ECLiveCardPanelType;", "", "GOODS_DETAIL", "SKU", "ORDER", AccountType.OTHERS, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECLiveCardPanelType extends Enum<ECLiveCardPanelType> {
    public static final ECLiveCardPanelType GOODS_DETAIL = null;
    public static final ECLiveCardPanelType ORDER = null;
    public static final ECLiveCardPanelType OTHERS = null;
    public static final ECLiveCardPanelType SKU = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECLiveCardPanelType[] f152651a = null;

    static {
        ECLiveCardPanelType r100 = new ECLiveCardPanelType("GOODS_DETAIL", 0);
        GOODS_DETAIL = r100;
        ECLiveCardPanelType r101 = new ECLiveCardPanelType("SKU", 1);
        SKU = r101;
        ECLiveCardPanelType r102 = new ECLiveCardPanelType("ORDER", 2);
        ORDER = r102;
        ECLiveCardPanelType r103 = new ECLiveCardPanelType(AccountType.OTHERS, 3);
        OTHERS = r103;
        f152651a = new ECLiveCardPanelType[]{r100, r101, r102, r103};
    }

    public static ECLiveCardPanelType valueOf(String r100) {
        return (ECLiveCardPanelType) r27.a.a(ECLiveCardPanelType.class, r100);
    }

    public static ECLiveCardPanelType[] values() {
        return (ECLiveCardPanelType[]) f152651a.clone();
    }

    public ECLiveCardPanelType(String r100, int r101) {
        super(r100, r101);
    }
}
