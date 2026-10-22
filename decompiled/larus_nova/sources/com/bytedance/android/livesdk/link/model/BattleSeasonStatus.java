package com.bytedance.android.livesdk.link.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/BattleSeasonStatus;", "", "UnknownSeason", "RunningSeason", "OffSeason", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum BattleSeasonStatus extends Enum<BattleSeasonStatus> {
    public static final BattleSeasonStatus OffSeason = null;
    public static final BattleSeasonStatus RunningSeason = null;
    public static final BattleSeasonStatus UnknownSeason = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BattleSeasonStatus[] f147019a = null;

    static {
        BattleSeasonStatus r100 = new BattleSeasonStatus("UnknownSeason", 0);
        UnknownSeason = r100;
        BattleSeasonStatus r101 = new BattleSeasonStatus("RunningSeason", 1);
        RunningSeason = r101;
        BattleSeasonStatus r102 = new BattleSeasonStatus("OffSeason", 2);
        OffSeason = r102;
        f147019a = new BattleSeasonStatus[]{r100, r101, r102};
    }

    public static BattleSeasonStatus valueOf(String r100) {
        return (BattleSeasonStatus) r27.a.a(BattleSeasonStatus.class, r100);
    }

    public static BattleSeasonStatus[] values() {
        return (BattleSeasonStatus[]) f147019a.clone();
    }

    public BattleSeasonStatus(String r100, int r101) {
        super(r100, r101);
    }
}
