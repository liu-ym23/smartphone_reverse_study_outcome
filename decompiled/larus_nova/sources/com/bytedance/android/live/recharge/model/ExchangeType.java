package com.bytedance.android.live.recharge.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/recharge/model/ExchangeType;", "", "EXCHANGE_TYPE_GIFT", "EXCHANGE_TYPE_FAST_GIFT", "EXCHANGE_TYPE_GIFT_GUIDE", "EXCHANGE_TYPE_FANS", "EXCHANGE_TYPE_RED_PACKET", "EXCHANGE_TYPE_LOTTERY", "EXCHANGE_TYPE_BARRAGE", "EXCHANGE_TYPE_LOTTERY_JOIN_FANS", "EXCHANGE_TYPE_FANS_SEND_GIFT", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ExchangeType extends Enum<ExchangeType> {
    public static final ExchangeType EXCHANGE_TYPE_BARRAGE = null;
    public static final ExchangeType EXCHANGE_TYPE_FANS = null;
    public static final ExchangeType EXCHANGE_TYPE_FANS_SEND_GIFT = null;
    public static final ExchangeType EXCHANGE_TYPE_FAST_GIFT = null;
    public static final ExchangeType EXCHANGE_TYPE_GIFT = null;
    public static final ExchangeType EXCHANGE_TYPE_GIFT_GUIDE = null;
    public static final ExchangeType EXCHANGE_TYPE_LOTTERY = null;
    public static final ExchangeType EXCHANGE_TYPE_LOTTERY_JOIN_FANS = null;
    public static final ExchangeType EXCHANGE_TYPE_RED_PACKET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExchangeType[] f89991a = null;

    static {
        ExchangeType r100 = new ExchangeType("EXCHANGE_TYPE_GIFT", 0);
        EXCHANGE_TYPE_GIFT = r100;
        ExchangeType r101 = new ExchangeType("EXCHANGE_TYPE_FAST_GIFT", 1);
        EXCHANGE_TYPE_FAST_GIFT = r101;
        ExchangeType r102 = new ExchangeType("EXCHANGE_TYPE_GIFT_GUIDE", 2);
        EXCHANGE_TYPE_GIFT_GUIDE = r102;
        ExchangeType r103 = new ExchangeType("EXCHANGE_TYPE_FANS", 3);
        EXCHANGE_TYPE_FANS = r103;
        ExchangeType r104 = new ExchangeType("EXCHANGE_TYPE_RED_PACKET", 4);
        EXCHANGE_TYPE_RED_PACKET = r104;
        ExchangeType r105 = new ExchangeType("EXCHANGE_TYPE_LOTTERY", 5);
        EXCHANGE_TYPE_LOTTERY = r105;
        ExchangeType r106 = new ExchangeType("EXCHANGE_TYPE_BARRAGE", 6);
        EXCHANGE_TYPE_BARRAGE = r106;
        ExchangeType r107 = new ExchangeType("EXCHANGE_TYPE_LOTTERY_JOIN_FANS", 7);
        EXCHANGE_TYPE_LOTTERY_JOIN_FANS = r107;
        ExchangeType r108 = new ExchangeType("EXCHANGE_TYPE_FANS_SEND_GIFT", 8);
        EXCHANGE_TYPE_FANS_SEND_GIFT = r108;
        f89991a = new ExchangeType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    public static ExchangeType valueOf(String r100) {
        return (ExchangeType) r27.a.a(ExchangeType.class, r100);
    }

    public static ExchangeType[] values() {
        return (ExchangeType[]) f89991a.clone();
    }

    public ExchangeType(String r100, int r101) {
        super(r100, r101);
    }
}
