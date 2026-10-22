package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: classes47.dex */
public final class g1 implements bu0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b1 f88607a;

    public g1(b1 r100) {
        this.f88607a = r100;
    }

    @Override // bu0.b
    public final void a() {
        ALogger.i("RedPacketIconMode", "RevenueShortTermStateStrategyListener true");
        this.f88607a.showNormalState();
        ALogger.i("RedPacketIconMode", "onClickedChange showNormalState");
    }
}
