package com.bytedance.android.live.profit.privilege.model.touch;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u001b\u0010\u0005\u001a\u00060\u0003j\u0002`\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"com/bytedance/android/live/profit/privilege/model/touch/GrowthTouchData$FreqCtrlStrategy", "", "Lcom/bytedance/android/live/profit/privilege/model/touch/GrowthTouchData$FreqCtrlStrategy;", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "value", "J", "getValue", "()J", "StrategyUnknown", "StrategyDailyLimitByUID", "StrategyRoomLimitByUID", "StrategyTotalLimitByUID", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum GrowthTouchData$FreqCtrlStrategy extends Enum<GrowthTouchData$FreqCtrlStrategy> {
    public static final GrowthTouchData$FreqCtrlStrategy StrategyDailyLimitByUID = null;
    public static final GrowthTouchData$FreqCtrlStrategy StrategyRoomLimitByUID = null;
    public static final GrowthTouchData$FreqCtrlStrategy StrategyTotalLimitByUID = null;
    public static final GrowthTouchData$FreqCtrlStrategy StrategyUnknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GrowthTouchData$FreqCtrlStrategy[] f88421a = null;
    private final long value;

    static {
        GrowthTouchData$FreqCtrlStrategy r100 = new GrowthTouchData$FreqCtrlStrategy("StrategyUnknown", 0, 0);
        StrategyUnknown = r100;
        GrowthTouchData$FreqCtrlStrategy r101 = new GrowthTouchData$FreqCtrlStrategy("StrategyDailyLimitByUID", 1, 1);
        StrategyDailyLimitByUID = r101;
        GrowthTouchData$FreqCtrlStrategy r102 = new GrowthTouchData$FreqCtrlStrategy("StrategyRoomLimitByUID", 2, 2);
        StrategyRoomLimitByUID = r102;
        GrowthTouchData$FreqCtrlStrategy r103 = new GrowthTouchData$FreqCtrlStrategy("StrategyTotalLimitByUID", 3, 3);
        StrategyTotalLimitByUID = r103;
        f88421a = new GrowthTouchData$FreqCtrlStrategy[]{r100, r101, r102, r103};
    }

    public static GrowthTouchData$FreqCtrlStrategy valueOf(String r100) {
        return (GrowthTouchData$FreqCtrlStrategy) r27.a.a(GrowthTouchData$FreqCtrlStrategy.class, r100);
    }

    public static GrowthTouchData$FreqCtrlStrategy[] values() {
        return (GrowthTouchData$FreqCtrlStrategy[]) f88421a.clone();
    }

    public final long getValue() {
        return this.value;
    }

    public GrowthTouchData$FreqCtrlStrategy(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}
