package com.bytedance.android.live.profit.lottery;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/LotteryTempStatusStrategy;", "", "", "strategyNum", "I", "getStrategyNum", "()I", "STRATEGY_SINGLE_PLAY", "STRATEGY_PARTICIPATION_SURGE", "STRATEGY_COUNT_DOWN", "STRATEGY_HOST", "STRATEGY_ENTER", "STRATEGY_INTEREST", "STRATEGY_BEHAVIOR", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LotteryTempStatusStrategy extends Enum<LotteryTempStatusStrategy> {
    public static final LotteryTempStatusStrategy STRATEGY_BEHAVIOR = null;
    public static final LotteryTempStatusStrategy STRATEGY_COUNT_DOWN = null;
    public static final LotteryTempStatusStrategy STRATEGY_ENTER = null;
    public static final LotteryTempStatusStrategy STRATEGY_HOST = null;
    public static final LotteryTempStatusStrategy STRATEGY_INTEREST = null;
    public static final LotteryTempStatusStrategy STRATEGY_PARTICIPATION_SURGE = null;
    public static final LotteryTempStatusStrategy STRATEGY_SINGLE_PLAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LotteryTempStatusStrategy[] f88033a = null;
    private final int strategyNum;

    static {
        LotteryTempStatusStrategy r100 = new LotteryTempStatusStrategy("STRATEGY_SINGLE_PLAY", 0, 1);
        STRATEGY_SINGLE_PLAY = r100;
        LotteryTempStatusStrategy r101 = new LotteryTempStatusStrategy("STRATEGY_PARTICIPATION_SURGE", 1, 2);
        STRATEGY_PARTICIPATION_SURGE = r101;
        LotteryTempStatusStrategy r102 = new LotteryTempStatusStrategy("STRATEGY_COUNT_DOWN", 2, 3);
        STRATEGY_COUNT_DOWN = r102;
        LotteryTempStatusStrategy r103 = new LotteryTempStatusStrategy("STRATEGY_HOST", 3, 4);
        STRATEGY_HOST = r103;
        LotteryTempStatusStrategy r104 = new LotteryTempStatusStrategy("STRATEGY_ENTER", 4, 5);
        STRATEGY_ENTER = r104;
        LotteryTempStatusStrategy r105 = new LotteryTempStatusStrategy("STRATEGY_INTEREST", 5, 6);
        STRATEGY_INTEREST = r105;
        LotteryTempStatusStrategy r106 = new LotteryTempStatusStrategy("STRATEGY_BEHAVIOR", 6, 7);
        STRATEGY_BEHAVIOR = r106;
        f88033a = new LotteryTempStatusStrategy[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static LotteryTempStatusStrategy valueOf(String r100) {
        return (LotteryTempStatusStrategy) r27.a.a(LotteryTempStatusStrategy.class, r100);
    }

    public static LotteryTempStatusStrategy[] values() {
        return (LotteryTempStatusStrategy[]) f88033a.clone();
    }

    public final int getStrategyNum() {
        return this.strategyNum;
    }

    public LotteryTempStatusStrategy(String r100, int r101, int r102) {
        super(r100, r101);
        this.strategyNum = r102;
    }
}
