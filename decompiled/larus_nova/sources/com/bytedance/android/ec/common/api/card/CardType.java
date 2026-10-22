package com.bytedance.android.ec.common.api.card;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/common/api/card/CardType;", "", "EXPLAIN_CARD", "COUPON_CARD", "RELATED_CARD", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final enum CardType extends Enum<CardType> {
    public static final CardType COUPON_CARD = null;
    public static final CardType EXPLAIN_CARD = null;
    public static final CardType RELATED_CARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CardType[] f42825a = null;

    static {
        CardType r100 = new CardType("EXPLAIN_CARD", 0);
        EXPLAIN_CARD = r100;
        CardType r101 = new CardType("COUPON_CARD", 1);
        COUPON_CARD = r101;
        CardType r102 = new CardType("RELATED_CARD", 2);
        RELATED_CARD = r102;
        f42825a = new CardType[]{r100, r101, r102};
    }

    public static CardType valueOf(String r100) {
        return (CardType) a.a(CardType.class, r100);
    }

    public static CardType[] values() {
        return (CardType[]) f42825a.clone();
    }

    public CardType(String r100, int r101) {
        super(r100, r101);
    }
}
