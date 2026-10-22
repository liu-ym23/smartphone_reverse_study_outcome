package com.bytedance.android.live.profit.redpacket;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketTempStatusStrategy;", "", "", "strategyNum", "I", "getStrategyNum", "()I", "STRATEGY_SINGLE_PLAY", "STRATEGY_PARTICIPATION_SURGE", "STRATEGY_COUNT_DOWN", "STRATEGY_HOST", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RedPacketTempStatusStrategy extends Enum<RedPacketTempStatusStrategy> {
    public static final RedPacketTempStatusStrategy STRATEGY_COUNT_DOWN = null;
    public static final RedPacketTempStatusStrategy STRATEGY_HOST = null;
    public static final RedPacketTempStatusStrategy STRATEGY_PARTICIPATION_SURGE = null;
    public static final RedPacketTempStatusStrategy STRATEGY_SINGLE_PLAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RedPacketTempStatusStrategy[] f88572a = null;
    private final int strategyNum;

    static {
        RedPacketTempStatusStrategy r100 = new RedPacketTempStatusStrategy("STRATEGY_SINGLE_PLAY", 0, 1);
        STRATEGY_SINGLE_PLAY = r100;
        RedPacketTempStatusStrategy r101 = new RedPacketTempStatusStrategy("STRATEGY_PARTICIPATION_SURGE", 1, 2);
        STRATEGY_PARTICIPATION_SURGE = r101;
        RedPacketTempStatusStrategy r102 = new RedPacketTempStatusStrategy("STRATEGY_COUNT_DOWN", 2, 3);
        STRATEGY_COUNT_DOWN = r102;
        RedPacketTempStatusStrategy r103 = new RedPacketTempStatusStrategy("STRATEGY_HOST", 3, 4);
        STRATEGY_HOST = r103;
        f88572a = new RedPacketTempStatusStrategy[]{r100, r101, r102, r103};
    }

    public static RedPacketTempStatusStrategy valueOf(String r100) {
        return (RedPacketTempStatusStrategy) r27.a.a(RedPacketTempStatusStrategy.class, r100);
    }

    public static RedPacketTempStatusStrategy[] values() {
        return (RedPacketTempStatusStrategy[]) f88572a.clone();
    }

    public final int getStrategyNum() {
        return this.strategyNum;
    }

    public RedPacketTempStatusStrategy(String r100, int r101, int r102) {
        super(r100, r101);
        this.strategyNum = r102;
    }
}
