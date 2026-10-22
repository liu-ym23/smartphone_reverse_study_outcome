package com.bytedance.android.livesdk.link.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/BattleNotifyMessageType;", "", "Unknown", "LargeMatchStart", "LargeMatchEnd", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum BattleNotifyMessageType extends Enum<BattleNotifyMessageType> {
    public static final BattleNotifyMessageType LargeMatchEnd = null;
    public static final BattleNotifyMessageType LargeMatchStart = null;
    public static final BattleNotifyMessageType Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BattleNotifyMessageType[] f147018a = null;

    static {
        BattleNotifyMessageType r100 = new BattleNotifyMessageType("Unknown", 0);
        Unknown = r100;
        BattleNotifyMessageType r101 = new BattleNotifyMessageType("LargeMatchStart", 1);
        LargeMatchStart = r101;
        BattleNotifyMessageType r102 = new BattleNotifyMessageType("LargeMatchEnd", 2);
        LargeMatchEnd = r102;
        f147018a = new BattleNotifyMessageType[]{r100, r101, r102};
    }

    public static BattleNotifyMessageType valueOf(String r100) {
        return (BattleNotifyMessageType) r27.a.a(BattleNotifyMessageType.class, r100);
    }

    public static BattleNotifyMessageType[] values() {
        return (BattleNotifyMessageType[]) f147018a.clone();
    }

    public BattleNotifyMessageType(String r100, int r101) {
        super(r100, r101);
    }
}
