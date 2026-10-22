package com.bytedance.android.livesdk.link.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/BattleValueType;", "", "GiftValue", "Like", "Ticket", "Subscription", "ContributionUV", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum BattleValueType extends Enum<BattleValueType> {
    public static final BattleValueType ContributionUV = null;
    public static final BattleValueType GiftValue = null;
    public static final BattleValueType Like = null;
    public static final BattleValueType Subscription = null;
    public static final BattleValueType Ticket = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BattleValueType[] f147020a = null;

    static {
        BattleValueType r100 = new BattleValueType("GiftValue", 0);
        GiftValue = r100;
        BattleValueType r101 = new BattleValueType("Like", 1);
        Like = r101;
        BattleValueType r102 = new BattleValueType("Ticket", 2);
        Ticket = r102;
        BattleValueType r103 = new BattleValueType("Subscription", 3);
        Subscription = r103;
        BattleValueType r104 = new BattleValueType("ContributionUV", 4);
        ContributionUV = r104;
        f147020a = new BattleValueType[]{r100, r101, r102, r103, r104};
    }

    public static BattleValueType valueOf(String r100) {
        return (BattleValueType) r27.a.a(BattleValueType.class, r100);
    }

    public static BattleValueType[] values() {
        return (BattleValueType[]) f147020a.clone();
    }

    public BattleValueType(String r100, int r101) {
        super(r100, r101);
    }
}
