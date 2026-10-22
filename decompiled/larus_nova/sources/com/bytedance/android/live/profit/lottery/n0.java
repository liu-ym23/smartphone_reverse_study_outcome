package com.bytedance.android.live.profit.lottery;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class n0 implements com.bytedance.android.scope.o, i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l2 f88147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LotteryContext f88148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LotteryPluginStore f88149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.core.a f88150d;

    @Override // com.bytedance.android.live.profit.lottery.i
    public final com.bytedance.live.datacontext.m<? extends ParticipateStatus> getCurCandidateState() {
        return this.f88148b.getCurCandidateState();
    }

    @Override // com.bytedance.android.live.profit.lottery.i
    public final com.bytedance.live.datacontext.n<? extends g> getCurrentLottery() {
        return this.f88148b.getCurrentLottery();
    }

    @Override // com.bytedance.android.live.profit.lottery.i
    public final com.bytedance.live.datacontext.k<LotteryState.b> getOnFinish() {
        return this.f88148b.getOnFinish();
    }

    @Override // com.bytedance.android.live.profit.lottery.i
    public final com.bytedance.live.datacontext.k<Unit> getOnHidePanel() {
        return this.f88148b.getOnHidePanel();
    }

    @Override // com.bytedance.android.live.profit.lottery.i
    public final com.bytedance.live.datacontext.k<Integer> getOnIconClick() {
        return this.f88148b.getOnIconClick();
    }

    @Override // com.bytedance.android.live.profit.lottery.i
    public final com.bytedance.live.datacontext.k<JSONObject> getOnPopupSchemaFailed() {
        return this.f88148b.getOnPopupSchemaFailed();
    }

    @Override // com.bytedance.android.live.profit.lottery.i
    public final com.bytedance.live.datacontext.k<Unit> getOnToolbarButtonClick() {
        return this.f88148b.getOnToolbarButtonClick();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        this.f88150d.b(i.class, this.f88147a);
    }

    @Override // com.bytedance.android.live.profit.lottery.i
    public final o getLotteryPluginStore() {
        return this.f88149c;
    }

    public n0(l2 r100, LotteryContext r101, LotteryPluginStore r102, com.bytedance.android.live.revenue.core.a r103) {
        Intrinsics.checkNotNullParameter(r100, "myScope");
        Intrinsics.checkNotNullParameter(r101, "ctx");
        Intrinsics.checkNotNullParameter(r102, "pluginStore");
        Intrinsics.checkNotNullParameter(r103, "inst");
        this.f88147a = r100;
        this.f88148b = r101;
        this.f88149c = r102;
        this.f88150d = r103;
    }
}
