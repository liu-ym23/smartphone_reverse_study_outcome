package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.profit.lottery.model.LotteryInfoSyncData;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class s0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LotteryIMDataSource f88188a;

    public s0(LotteryIMDataSource r100) {
        this.f88188a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r310) {
        BehaviorSubject<y2> r100 = this.f88188a.f87947i;
        LotteryInfoSyncData r101 = (LotteryInfoSyncData) ((com.bytedance.android.livesdk.revenue.message.e.a) r310).f157181a;
        Intrinsics.checkNotNullParameter(r101, "$this$toLotteryTempStatusInfo");
        r100.onNext(new y2(r101.getLotteryId(), r101.getLotteryType(), r101.getLuckyCount(), r101.getPrizeCount(), r101.getCandidateTotalCount(), r101.getLastSurgeTimeStamp(), r101.getStartTime(), r101.getDrawTime(), r101.getEnabledDilatation(), r101.getDilatationConfigDetail(), r101.getDilatationNow(), r101.getPrizeCountBeforeDilatation(), r101.getLuckyCountBeforeDilatation()));
    }
}
