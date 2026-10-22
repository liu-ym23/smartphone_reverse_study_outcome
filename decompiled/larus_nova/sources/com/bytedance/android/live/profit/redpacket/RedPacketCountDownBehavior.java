package com.bytedance.android.live.profit.redpacket;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketCountDownBehavior;", "", "", "value", "I", "getValue", "()I", "AnimatorAsSpecialTimer", "NoSpecialTimer", "CountDownTimerAsSpecialTimer", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RedPacketCountDownBehavior extends Enum<RedPacketCountDownBehavior> {
    public static final RedPacketCountDownBehavior AnimatorAsSpecialTimer = null;
    public static final RedPacketCountDownBehavior CountDownTimerAsSpecialTimer = null;
    public static final RedPacketCountDownBehavior NoSpecialTimer = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RedPacketCountDownBehavior[] f88489a = null;
    private final int value;

    static {
        RedPacketCountDownBehavior r100 = new RedPacketCountDownBehavior("AnimatorAsSpecialTimer", 0, 0);
        AnimatorAsSpecialTimer = r100;
        RedPacketCountDownBehavior r101 = new RedPacketCountDownBehavior("NoSpecialTimer", 1, 1);
        NoSpecialTimer = r101;
        RedPacketCountDownBehavior r102 = new RedPacketCountDownBehavior("CountDownTimerAsSpecialTimer", 2, 2);
        CountDownTimerAsSpecialTimer = r102;
        f88489a = new RedPacketCountDownBehavior[]{r100, r101, r102};
    }

    public static RedPacketCountDownBehavior valueOf(String r100) {
        return (RedPacketCountDownBehavior) r27.a.a(RedPacketCountDownBehavior.class, r100);
    }

    public static RedPacketCountDownBehavior[] values() {
        return (RedPacketCountDownBehavior[]) f88489a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public RedPacketCountDownBehavior(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
