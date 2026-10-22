package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/model/CardType;", "", "None", "DIY", "Buff", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CardType extends Enum<CardType> {
    public static final CardType Buff = null;
    public static final CardType DIY = null;
    public static final CardType None = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CardType[] f127489a = null;

    static {
        CardType r100 = new CardType("None", 0);
        None = r100;
        CardType r101 = new CardType("DIY", 1);
        DIY = r101;
        CardType r102 = new CardType("Buff", 2);
        Buff = r102;
        f127489a = new CardType[]{r100, r101, r102};
    }

    public static CardType valueOf(String r100) {
        return (CardType) a.a(CardType.class, r100);
    }

    public static CardType[] values() {
        return (CardType[]) f127489a.clone();
    }

    public CardType(String r100, int r101) {
        super(r100, r101);
    }
}
